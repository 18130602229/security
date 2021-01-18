package com.bglemon.blue.taste.controller.api;


import com.bglemon.blue.taste.config.JWTUtil;
import com.bglemon.blue.taste.domain.AccountLog;
import com.bglemon.blue.taste.service.AccountLogService;
import com.bglemon.blue.taste.utils.ApiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:zhuchuanshun
 * @Description: 登录日志相关
 * @Date: 2019/4/17 19:21
 * @Modificd:
 */
@RestController
@RequestMapping("/accountLog")
@Api(value="AccountLogController",tags={"登录日志相关 API 接口"})
public class AccountLogController {
    @Autowired
    private AccountLogService accountLogService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping
    @ApiOperation(value = "获取所有登录日志", notes = "获取所有登录日志 API")
    public ApiResult<PageInfo<AccountLog>> lists(
                                                @RequestParam("account") String account,
                                                @RequestParam("date") String date,
                                                @RequestParam(value="pageNumber",required = false,defaultValue = "0") int pageNo,
                                                @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        if ("-1".equals(account)){ // 当account 传 -1 时 代表不是 admin 角色。
            String token = request.getHeader("Authorization");
            int userId = JWTUtil.getUserId(token); // 这个id 是，用户 adminUser 的id。
            PageInfo<AccountLog> pageInfo = new PageInfo(accountLogService.findByUserIdAndDate(userId,date));
            return new ApiResult().withData(pageInfo);
        }else{
            PageInfo<AccountLog> pageInfo = new PageInfo(accountLogService.findByAccountAndDate(account, date));
            return new ApiResult().withData(pageInfo);
        }
    }
}
