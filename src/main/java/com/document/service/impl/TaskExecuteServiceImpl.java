package com.document.service.impl;

import com.document.entity.FileDocument;
import com.document.service.TaskExecuteService;
import com.document.task.thread.MainTask;
import com.document.task.thread.TaskThreadPool;
import org.springframework.stereotype.Service;

/**
 * @Author yinghangfeng
 * @Date 2022/10/20 18:04
 * @Version 1.0
 */
@Service
public class TaskExecuteServiceImpl implements TaskExecuteService {

    @Override
    public void execute(FileDocument fileDocument) {
        MainTask mainTask = new MainTask(fileDocument);
        TaskThreadPool.getInstance().submit(mainTask);
    }
}
