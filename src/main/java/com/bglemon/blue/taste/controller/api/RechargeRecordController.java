package com.bglemon.blue.taste.controller.api;

import com.bglemon.blue.taste.service.RechargeRecordService;
import com.bglemon.blue.taste.utils.ApiResult;
import com.bglemon.blue.taste.vo.RechargeRecordVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: 充值记录
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 20:02
 **/
@RestController
@RequestMapping("recharge-record")
@Api(value="RechargeRecordController",tags={"充值相关 API 接口"})
public class RechargeRecordController {
    @Resource
    RechargeRecordService rechargeRecordService;

    @GetMapping
    @ApiOperation(value = "分页查询充值", notes = "分页查询充值 API")
    public ApiResult<PageInfo> lists(@RequestParam(value="pageNumber",required = false,defaultValue = "0") int pageNumber,
                                     @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                                     RechargeRecordVO rechargeRecordVO) {
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo pageInfo = new PageInfo(rechargeRecordService.getSearch(rechargeRecordVO));
        return new ApiResult().withData(pageInfo);
    }

    @PostMapping
    @ApiOperation(value = "新增充值", notes = "新增充值 API")
    public ApiResult save(int userId,int rechargeId){
        rechargeRecordService.save(userId,rechargeId);
        return new ApiResult();

    }
}