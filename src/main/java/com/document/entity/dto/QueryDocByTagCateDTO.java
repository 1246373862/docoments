package com.document.entity.dto;

import lombok.Data;

/**
 * @ClassName QueryDocByTagCateDTO
 * @Description 根据分类或标签查询文档列表
 * @Author yinghangfeng
 * @Date 2023/1/6 21:54
 * @Version 1.0
 **/
@Data
public class QueryDocByTagCateDTO extends BasePageDTO{

    String cateId;

    String tagId;

    String keyword;

}
