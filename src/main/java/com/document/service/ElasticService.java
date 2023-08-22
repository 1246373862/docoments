package com.document.service;

import com.document.entity.FileDocument;
import com.document.util.BaseApiResult;

import java.io.IOException;
import java.util.List;

/**
 * @author hangfeng.ying
 */
public interface ElasticService {

    /**
     * search
     * @param keyword String
     * @return result
     * @throws IOException exception
     */
    List<FileDocument> search(String keyword) throws IOException;

    BaseApiResult getWordStat() throws IOException;

}
