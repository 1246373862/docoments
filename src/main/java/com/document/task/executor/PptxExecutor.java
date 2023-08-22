package com.document.task.executor;

import com.document.entity.FileDocument;
import com.document.enums.FileFormatEnum;
import com.document.task.data.TaskData;
import com.document.task.exception.TaskRunException;
import com.document.util.poi.Converter;
import com.document.util.poi.PptxToPDFConverter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.UUID;

/**
 * @ClassName PptxExecutor
 * @Description TODO
 * @Author yinghangfeng
 * @Date 2023/2/25 17:24
 * @Version 1.0
 **/
@Slf4j
public class PptxExecutor extends DocxExecutor{

    @Override
    protected void makePreviewFile(InputStream inStream, TaskData taskData) {
        taskData.setPreviewFilePath(UUID.randomUUID() + ".pdf");
        try {
            OutputStream outStream = getOutFileStream(taskData.getPreviewFilePath());
            boolean shouldShowMessages = true;
            Converter converter = new PptxToPDFConverter(inStream, outStream, true,
                    true);
            converter.convert();
        } catch (Exception e) {
            log.error("解析报错");
            throw new TaskRunException("转换预览文件报错", e);
        }
        // 解析出来的预览文件存储到文件系统中
        String objId = saveFileToDFS(taskData.getPreviewFilePath(), FileFormatEnum.PDF, "preview-");
        FileDocument fileDocument = taskData.getFileDocument();
        fileDocument.setPreviewFileId(objId);

    }

    protected static OutputStream getOutFileStream(String outputFilePath) throws IOException {
        File outFile = new File(outputFilePath);

        try{
            //Make all directories up to specified
            outFile.getParentFile().mkdirs();
        } catch (NullPointerException e){
            //Ignore error since it means not parent directories
        }

        outFile.createNewFile();
        FileOutputStream oStream = new FileOutputStream(outFile);
        return oStream;
    }

}
