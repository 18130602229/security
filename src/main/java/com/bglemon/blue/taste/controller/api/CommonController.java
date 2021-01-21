package com.bglemon.blue.taste.controller.api;

import com.bglemon.blue.taste.service.CommonService;
import com.bglemon.blue.taste.utils.ApiResult;
import com.bglemon.blue.taste.vo.QueryCordVO;
import com.bglemon.blue.taste.vo.TipsVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 提供较少接口的类
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 12:12
 **/
@RestController
@Api(value="CommonController",tags={"其它接口 API 接口"})
public class CommonController {
    @Resource
    CommonService commonService;

    @GetMapping("query-cord")
    @ApiOperation(value = "查询记录", notes = "查询记录 API")
    public ApiResult lists(@RequestParam(value="pageNumber",required = false,defaultValue = "0") int pageNumber,
                           @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                           QueryCordVO queryCordVO) {
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo pageInfo = new PageInfo(commonService.getQueryCord(queryCordVO));
        return new ApiResult().withData(pageInfo);
    }

    @PostMapping("tips")
    @ApiOperation(value = "提示记录", notes = "提示记录 API")
    public ApiResult tipsLists(@RequestParam(value="pageNumber",required = false,defaultValue = "0") int pageNumber,
                           @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                               TipsVO tipsVO) {
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo pageInfo = new PageInfo(commonService.getTips(tipsVO));
        return new ApiResult().withData(pageInfo);
    }
}