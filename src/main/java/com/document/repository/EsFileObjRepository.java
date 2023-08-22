package com.document.repository;

import com.document.entity.FileObj;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * // 另外一种方式
 * //    @Query("{\"match\":{\"attachment.content\":\"?0\"}}")
 * //    SearchHits<FileObj> find(String keyword);
 * @author hangfeng.ying
 */
public interface EsFileObjRepository extends ElasticsearchRepository<FileObj, String> {


}
