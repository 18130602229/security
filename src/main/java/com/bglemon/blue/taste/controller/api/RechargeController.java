package com.bglemon.blue.taste.controller.api;

import com.bglemon.blue.taste.service.RechargeService;
import com.bglemon.blue.taste.utils.ApiResult;
import com.bglemon.blue.taste.vo.RechargeVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: 充值接口
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 13:30
 **/
@RestController
@RequestMapping("recharge")
@Api(value="RechargeController",tags={"充值相关 API 接口"})
public class RechargeController {
    @Resource
    RechargeService rechargeService;

    @GetMapping
    @ApiOperation(value = "分页查询充值", notes = "分页查询充值 API")
    public ApiResult<PageInfo> lists(@RequestParam(value="pageNumber",required = false,defaultValue = "0") int pageNumber,
                                     @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                                     RechargeVO rechargeVO) {
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo pageInfo = new PageInfo(rechargeService.getSearch(rechargeVO));
        return new ApiResult().withData(pageInfo);
    }
    @GetMapping("one")
    @ApiOperation(value = "根据ID获取充值", notes = "根据ID获取充值 API")
    public ApiResult getOne(Integer id) {
        return new ApiResult().withData(rechargeService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "新增充值", notes = "新增充值 API")
    public ApiResult save(RechargeVO rechargeVO){
        rechargeService.save(rechargeVO);
        return new ApiResult();

    }
    @PutMapping
    @ApiOperation(value = "编辑充值", notes = "编辑充值 API")
    @Transactional
    public ApiResult edit(RechargeVO rechargeVO){
        rechargeService.edit(rechargeVO);
        return new ApiResult();
    }

    @DeleteMapping
    @ApiOperation(value = "删除", notes = "删除充值 API")
    @Transactional
    public ApiResult remove(@RequestParam Integer id){
        // 删除 role 表中的数据
        rechargeService.remove(id);
        return new ApiResult();
    }
}