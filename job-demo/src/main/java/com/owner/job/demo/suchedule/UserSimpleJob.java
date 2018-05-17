/**
 * Copyright © 2014 GZJF Corp. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of 深圳市大头兄弟文化传播有限公司 Corp. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from 深圳市大头兄弟文化传播有限公司 Corp or an authorized sublicensor.
 */
package com.owner.job.demo.suchedule;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.owner.job.annotation.ElasticSimpleJob;
import com.owner.job.base.SimpleJobAbstract;

/**
 * description:简单任务配置类
 * Author	Date	Changes
 * zhuangjianfa  2018年4月9日 Created
 */
@ElasticSimpleJob(corn="0/10 * * * * ?",disabled=false,overwrite=true,shardingTotalCount=2,shardingItemParameters="0=begjing,1=guangzhou")
public class UserSimpleJob extends SimpleJobAbstract{

    /* (non-Javadoc)
     * @see com.dangdang.ddframe.job.api.simple.SimpleJob#execute(com.dangdang.ddframe.job.api.ShardingContext)
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("UserSimpleJob execute");
    }
    
}
