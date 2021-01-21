package com.bglemon.blue.taste.controller.api;

import com.bglemon.blue.taste.service.BatchService;
import com.bglemon.blue.taste.utils.ApiResult;
import com.bglemon.blue.taste.vo.BatchVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: 批次管理
 * @author: immortal
 * @modified By：
 * @create: 2021-01-19 11:59
 **/
@RestController
@RequestMapping("batch")
@Api(value="BatchController",tags={"批次相关 API 接口"})
public class BatchController {
    @Resource
    BatchService batchService;

    @GetMapping
    @ApiOperation(value = "分页查询批次", notes = "分页查询批次 API")
    public ApiResult lists(@RequestParam(value="pageNumber",required = false,defaultValue = "0") int pageNumber,
                                           @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                                           BatchVO batchVO) {
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo pageInfo = new PageInfo(batchService.getSearch(batchVO));
        return new ApiResult().withData(pageInfo);
    }
    @GetMapping("one")
    @ApiOperation(value = "根据ID获取批次", notes = "根据ID获取批次 API")
    public ApiResult getOne(Integer id) {
        return new ApiResult().withData(batchService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "新增批次", notes = "新增批次 API")
    public ApiResult save(BatchVO batchVO){
        batchService.save(batchVO);
        return new ApiResult();
    }
    
    @PutMapping
    @ApiOperation(value = "编辑批次", notes = "编辑批次 API")
    public ApiResult edit(BatchVO batchVO){
        batchService.edit(batchVO);
        return new ApiResult();
    }

    @DeleteMapping
    @ApiOperation(value = "删除", notes = "删除批次 API")
    public ApiResult remove(@RequestParam Integer id){
        batchService.remove(id);
        return new ApiResult();
    }
}