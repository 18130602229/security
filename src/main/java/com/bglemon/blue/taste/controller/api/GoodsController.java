package com.bglemon.blue.taste.controller.api;

import com.bglemon.blue.taste.service.GoodsService;
import com.bglemon.blue.taste.utils.ApiResult;
import com.bglemon.blue.taste.vo.GoodsVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: 商品管理
 * @author: immortal
 * @modified By：
 * @create: 2021-01-19 11:59
 **/
@RestController
@RequestMapping("goods")
@Api(value="GoodsController",tags={"商品相关 API 接口"})
public class GoodsController {
    @Resource
    GoodsService goodsService;

    @GetMapping
    @ApiOperation(value = "分页查询商品", notes = "分页查询商品 API")
    public ApiResult<PageInfo> lists(@RequestParam(value="pageNumber",required = false,defaultValue = "0") int pageNumber,
                                           @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                                           GoodsVO goodsVO) {
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo pageInfo = new PageInfo(goodsService.getSearch(goodsVO));
        return new ApiResult().withData(pageInfo);
    }
    @GetMapping("one")
    @ApiOperation(value = "根据ID获取商品", notes = "根据ID获取商品 API")
    public ApiResult getOne(Integer id) {
        return new ApiResult().withData(goodsService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "新增商品", notes = "新增商品 API")
    public ApiResult save(GoodsVO goodsVO){
        goodsService.save(goodsVO);
        return new ApiResult();

    }
    @PutMapping
    @ApiOperation(value = "编辑商品", notes = "编辑商品 API")
    @Transactional
    public ApiResult edit(GoodsVO goodsVO){
        goodsService.edit(goodsVO);
        return new ApiResult();
    }

    @DeleteMapping
    @ApiOperation(value = "删除", notes = "删除商品 API")
    @Transactional
    @RequiresRoles("admin")
    public ApiResult remove(@RequestParam Integer id){
        // 删除 role 表中的数据
        goodsService.remove(id);
        return new ApiResult();
    }
}