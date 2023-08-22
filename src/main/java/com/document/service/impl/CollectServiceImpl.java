package com.document.service.impl;

import com.document.common.MessageConstant;
import com.document.entity.CollectDocRelationship;
import com.document.service.CollectService;
import com.document.util.BaseApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @Author yinghangfeng
 * @Date 2022/6/7 11:40
 * @Version 1.0
 */
@Slf4j
@Service
public class CollectServiceImpl implements CollectService {

    public static final String COLLECTION_NAME = "collectCollection";

    private static final String DOC_ID = "docId";

    @Resource
    MongoTemplate mongoTemplate;

    @Resource
    UserServiceImpl userServiceImpl;

    @Resource
    FileServiceImpl fileServiceImpl;

    /**
     * @return com.document.utils.ApiResult
     * @Author yinghangfeng
     * @Description // 对某个文档进行关注
     * @Date 9:31 下午 2022/6/23
     * @Param [collect]
     **/
    @Override
    public BaseApiResult insert(CollectDocRelationship collect) {
        Boolean aBoolean = insertRelationShip(collect);
        if (Boolean.FALSE.equals(aBoolean)) {
            return BaseApiResult.error(MessageConstant.PROCESS_ERROR_CODE, MessageConstant.OPERATE_FAILED);
        }
        return BaseApiResult.success(MessageConstant.SUCCESS);
    }

    @Override
    public Boolean insertRelationShip(CollectDocRelationship collect) {
        // 必须经过userId和docId的校验，否则不予关注
        if (!userServiceImpl.isExist(collect.getUserId()) || !fileServiceImpl.isExist(collect.getDocId())) {
            return false;
        }

        CollectDocRelationship collectDb = getExistRelationship(collect);
        if (collectDb != null) {
            return false;
        }
        mongoTemplate.save(collect, COLLECTION_NAME);
        return true;
    }

    /**
     * @return com.document.utils.ApiResult
     * @Author yinghangfeng
     * @Description // 删除收藏关系
     * @Date 9:43 下午 2022/6/23
     * @Param [collect]
     **/
    @Override
    public BaseApiResult remove(CollectDocRelationship collect) {
        collect = getExistRelationship(collect);
        while (collect != null) {
            mongoTemplate.remove(collect, COLLECTION_NAME);
            collect = getExistRelationship(collect);
        }
        return BaseApiResult.success(MessageConstant.SUCCESS);
    }

    /**
     * @return com.document.entity.CollectDocRelationship
     * @Author yinghangfeng
     * @Description // 查询已经存在的关系
     * @Date 9:37 下午 2022/6/23
     * @Param []
     **/
    private CollectDocRelationship getExistRelationship(CollectDocRelationship collect) {
        collect = Optional.ofNullable(collect).orElse(new CollectDocRelationship());

        Query query = new Query()
                .addCriteria(Criteria.where(DOC_ID).is(collect.getDocId())
                        .and("userId").is(collect.getUserId()));

        return mongoTemplate.findOne(
                query, CollectDocRelationship.class, COLLECTION_NAME
        );
    }

    /**
     * @return java.lang.Long
     * @Author yinghangfeng
     * @Description 查询某个文档下面的点赞数量
     * @Date 22:35 2022/9/24
     * @Param [docId]
     **/
    public Long collectNum(String docId) {
        Query query = new Query().addCriteria(Criteria.where(DOC_ID).is(docId));
        return mongoTemplate.count(query, CollectDocRelationship.class, COLLECTION_NAME);
    }

    /**
     * @Author yinghangfeng
     * @Description // 根据文档的id删除掉点赞的关系
     * @Date 11:17 上午 2022/6/25
     * @Param [docId]
     **/
    public void removeRelateByDocId(String docId) {
        Query query = new Query(Criteria.where(DOC_ID).is(docId));
        List<CollectDocRelationship> relationships = mongoTemplate.find(query, CollectDocRelationship.class,
                COLLECTION_NAME);
        relationships.forEach(this::remove);
    }


}