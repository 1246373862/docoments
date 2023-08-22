package com.document.task.data;

import com.document.entity.FileDocument;
import com.document.enums.DocType;
import lombok.Data;

/**
 * @Author yinghangfeng
 * @Date 2022/10/26 17:30
 * @Version 1.0
 */
@Data
public class TaskData {

    FileDocument fileDocument;

    String txtFilePath;

    String thumbFilePath;

    String previewFilePath;

    DocType docType;


}
