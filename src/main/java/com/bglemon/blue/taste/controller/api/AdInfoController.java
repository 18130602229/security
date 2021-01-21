package com.bglemon.blue.taste.controller.api;

import com.bglemon.blue.taste.service.AdInfoService;
import com.bglemon.blue.taste.utils.ApiResult;
import com.bglemon.blue.taste.vo.AdInfoVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: 广告接口
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 13:30
 **/
@RestController
@RequestMapping("ad")
@Api(value="AdInfoController",tags={"广告相关 API 接口"})
public class AdInfoController {
    @Resource
    AdInfoService adInfoService;

    @GetMapping
    @ApiOperation(value = "分页查询广告", notes = "分页查询广告 API")
    public ApiResult<PageInfo> lists(@RequestParam(value="pageNumber",required = false,defaultValue = "0") int pageNumber,
                                     @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                                     AdInfoVO adInfoVO) {
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo pageInfo = new PageInfo(adInfoService.getSearch(adInfoVO));
        return new ApiResult().withData(pageInfo);
    }
    @GetMapping("one")
    @ApiOperation(value = "根据ID获取广告", notes = "根据ID获取广告 API")
    public ApiResult getOne(Integer id) {
        return new ApiResult().withData(adInfoService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "新增广告", notes = "新增广告 API")
    public ApiResult save(AdInfoVO adInfoVO){
        adInfoService.save(adInfoVO);
        return new ApiResult();

    }
    @PutMapping
    @ApiOperation(value = "编辑广告", notes = "编辑广告 API")
    @Transactional
    public ApiResult edit(AdInfoVO adInfoVO){
        adInfoService.edit(adInfoVO);
        return new ApiResult();
    }

    @DeleteMapping
    @ApiOperation(value = "删除", notes = "删除广告 API")
    @Transactional
    public ApiResult remove(@RequestParam Integer id){
        // 删除 role 表中的数据
        adInfoService.remove(id);
        return new ApiResult();
    }
}