package com.haima.crm.dao;

import com.haima.crm.entity.ComplaintStatistics;
import com.haima.crm.entity.ComplaintStatisticsSatisfaction;
import com.haima.crm.entity.CrmEtlParameter;
import com.haima.crm.vo.ComplaintStatisticsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-05-21 19:52
 */
public interface CrmEtlDao extends BaseDao<ComplaintStatisticsVo> {
    CrmEtlParameter getEtlParameter(@Param("jobName") String jobName);
}
