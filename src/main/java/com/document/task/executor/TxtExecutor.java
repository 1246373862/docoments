package com.document.task.executor;

import com.document.entity.FileDocument;
import com.document.entity.FileObj;
import com.document.task.data.TaskData;
import com.document.task.exception.TaskRunException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName TxtExecutor
 * @Description 直接读取文本的执行器
 * @Author yinghangfeng
 * @Date 2023/2/26 11:22
 * @Version 1.0
 **/
public class TxtExecutor extends TaskExecutor{

    @Override
    protected void readText(InputStream is, String textFilePath) throws IOException {
        // no action
    }

    @Override
    protected void makeThumb(InputStream is, String picPath) throws IOException {
        // no action
    }

    @Override
    protected void makePreviewFile(InputStream is, TaskData taskData) {
        // no action
    }

    @Override
    public void uploadFileToEs(InputStream is, FileDocument fileDocument, TaskData taskData) {
        try {
            FileObj fileObj = new FileObj();
            fileObj.setId(fileDocument.getMd5());
            fileObj.setName(fileDocument.getName());
            fileObj.setType(fileDocument.getContentType());
            fileObj.readFile(is);
            this.upload(fileObj);
        } catch (IOException | TaskRunException e) {
            throw new TaskRunException("存入es的过程中报错了", e);
        }
    }
}
