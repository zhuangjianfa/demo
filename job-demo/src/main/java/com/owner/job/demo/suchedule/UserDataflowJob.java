/**
 * Copyright © 2014 GZJF Corp. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of 深圳市大头兄弟文化传播有限公司 Corp. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from 深圳市大头兄弟文化传播有限公司 Corp or an authorized sublicensor.
 */
package com.owner.job.demo.suchedule;

import java.util.List;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.owner.job.annotation.ElasticDataflowJob;
import com.owner.job.base.DataflowJobAbstract;

/**
 * description:流式DEMO
 * Author	Date	Changes
 * zhuangjianfa  2018年4月9日 Created
 */
@SuppressWarnings("rawtypes")
@ElasticDataflowJob
public class UserDataflowJob extends DataflowJobAbstract{

    /* (non-Javadoc)
     * @see com.dangdang.ddframe.job.api.dataflow.DataflowJob#fetchData(com.dangdang.ddframe.job.api.ShardingContext)
     */
    
    @Override
    public List fetchData(ShardingContext shardingContext) {
        System.out.println("UserDataflowJob fetchData");
        return null;
    }

    /* (non-Javadoc)
     * @see com.dangdang.ddframe.job.api.dataflow.DataflowJob#processData(com.dangdang.ddframe.job.api.ShardingContext, java.util.List)
     */
    @Override
    public void processData(ShardingContext shardingContext, List data) {
        System.out.println("UserDataflowJob processData");
        
    }
    
}
