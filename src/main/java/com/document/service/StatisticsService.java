package com.document.service;

import com.document.util.BaseApiResult;


/**
 * @author hangfeng.ying
 */
public interface StatisticsService {

    /**
     * trend
     * @return trend
     */
    BaseApiResult trend();

    /**
     * all
     * @return all
     */
    BaseApiResult all();

    /**
     * @Author yinghangfeng
     * @Description 统计各月的数据
     * @Date 17:10 2023/5/20
     * @Param []
     * @return com.document.util.BaseApiResult
     **/
    BaseApiResult getMonthStat();

}
