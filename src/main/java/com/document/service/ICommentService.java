package com.document.service;

import com.document.entity.Comment;
import com.document.entity.dto.BasePageDTO;
import com.document.entity.dto.CommentListDTO;
import com.document.util.BaseApiResult;

import java.util.List;

/**
 * @author hangfeng.ying
 */
public interface ICommentService {

    /**
     * insert
     * @param comment Comment
     * @return result
     */
    BaseApiResult insert(Comment comment);

    /**
     * update
     * @param comment Comment
     * @return result
     */
    BaseApiResult update(Comment comment);

    /**
     * remove
     * @param comment Comment
     * @param userId userId
     * @return result
     */
    BaseApiResult remove(Comment comment, String userId);

    /**
     * @Author yinghangfeng
     * @Description 批量删除评论列表
     * @Date 20:49 2023/2/12
     * @Param [commentIdList]
     * @return com.document.util.BaseApiResult
     **/
    BaseApiResult removeBatch(List<String> commentIdList);

    /**
     * queryById
     * @param comment CommentListDTO
     * @return result
     */
    BaseApiResult queryById(CommentListDTO comment);

    /**
     * search
     * @param comment Comment
     * @return result
     */
    BaseApiResult search(Comment comment);

    /**
     * @Author yinghangfeng
     * @Description 查询评论列表
     * @Date 14:44 2022/12/10
     * @Param [pageDTO, userId]
     * @return com.document.util.BaseApiResult
     **/
    BaseApiResult queryAllComments(BasePageDTO pageDTO, String userId, Boolean isAdmin);

}
