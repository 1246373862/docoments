package com.document.service;

import com.document.entity.Tag;
import com.document.entity.TagDocRelationship;
import com.document.util.BaseApiResult;

import java.util.List;
import java.util.Map;

/**
 * @Author yinghangfeng
 * @Date 2022/6/7 11:39
 * @Version 1.0
 */
public interface TagService {

    /**
     * insert
     * @param tag tag
     * @return result
     */
    BaseApiResult insert(Tag tag);

    /**
     * update
     * @param tag tag
     * @return result
     */
    BaseApiResult update(Tag tag);

    /**
     * remove
     * @param tag tag
     * @return result
     */
    BaseApiResult remove(Tag tag);

    /**
     * query
     * @param tag tag
     * @return result
     */
    BaseApiResult queryById(Tag tag);

    /**
     * search
     * @param tag tag
     * @return result
     */
    BaseApiResult search(Tag tag);

    /**
     * list
     * @return result
     */
    BaseApiResult list();

    /**
     * add relationship
     * @param relationship TagDocRelationship
     * @return BaseApiResult
     */
    BaseApiResult addRelationShip(TagDocRelationship relationship);

    /**
     * cancel relationship
     * @param relationship TagDocRelationShip
     * @return result
     */
    BaseApiResult cancelTagRelationship(TagDocRelationship relationship);

    /**
     * get all relationships
     * @return result
     */
    Map<Tag, List<TagDocRelationship>> getRecentTagRelationship();

    /**
     * 判断标签和文档的关系是否存在
     * @Author yinghangfeng
     * @Description 某个标签是否文档存在关系
     * @Date 22:21 2022/11/16
     * @param tagId 标签id
     * @param fileId 文档id
     * @return boolean
     **/
    boolean relateExist(String tagId, String fileId);

}
