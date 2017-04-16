package com.haima.crm.controller;

import com.haima.crm.constants.StatisticsTypeConfig;
import com.haima.crm.dto.CustomerCarDTO;
import com.haima.crm.entity.ComplaintStatistics;
import com.haima.crm.service.CrmQueryService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;
import com.haima.crm.vo.ComplaintStatisticsVo;
import com.haima.crm.vo.CrmCustomerCarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lushaozhong
 * @version 1.0
 * @date 2017-04-15 21:40
 */

@Controller
@RequestMapping("crm")
public class CrmQueryController {
    @Autowired
    private CrmQueryService crmQueryService;

    /**
     * 统计分析列表
     */
    @ResponseBody
    @RequestMapping("/customer/car/list")
    public Result customerCarList(@RequestBody CrmCustomerCarVo crmCustomerCarVo) {
        // 查询列表数据
        List<CustomerCarDTO> customerCarList = crmQueryService.queryCustomerCarList(crmCustomerCarVo);
        int total = crmQueryService.queryCustomerCarTotal(crmCustomerCarVo);
        PageUtils pageUtil = new PageUtils(customerCarList, total, crmCustomerCarVo.getLimit(), crmCustomerCarVo.getPage());

        return Result.ok().put("page", pageUtil);
    }
}
