package com.document.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.document.entity.dto.CommentDTO;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName CommentWithUserVO
 * @Description TODO
 * @Author yinghangfeng
 * @Date 2023/1/9 22:19
 * @Version 1.0
 **/
@Data
public class CommentWithUserVO extends CommentDTO {

    private String id;

    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    private String userId;

    private String userAvatarId;

    private String docName;
}
