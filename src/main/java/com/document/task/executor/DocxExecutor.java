package com.document.task.executor;

import com.document.task.data.TaskData;
import com.document.util.MsExcelParse;

import java.io.InputStream;

/**
 * @Author yinghangfeng
 * @Date 2022/10/24 11:42
 * @Version 1.0
 */
public class DocxExecutor extends TaskExecutor{

    @Override
    protected void readText(InputStream is, String textFilePath) {
        MsExcelParse.readPdfText(is, textFilePath);
    }

    @Override
    protected void makeThumb(InputStream is, String picPath) {
        // no action
    }

    @Override
    protected void makePreviewFile(InputStream is, TaskData taskData) {
        // no action
    }
}
