package com.document.entity;

import com.document.enums.ThumbSizeEnum;
import com.document.enums.ThumbnailEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName Thumbnail
 * @Description 缩略图相关的类
 * @Author yinghangfeng
 * @Date 2022/7/23 5:57 下午
 * @Version 1.0
 **/
@Document
@Data
public class Thumbnail {

    /**
     * 缩略图id
     */
    @Id
    private String id;

    /**
     * 对象的id
     */
    private String objectId;

    /**
     * 不同种类型
     */
    private ThumbnailEnum thumbnailEnum;

    /**
     * 大文件管理GridFS的ID
     */
    private String gridfsId;

    /**
     * 缩略图的尺寸大小
     **/
    private ThumbSizeEnum thumbSizeEnum;


}
