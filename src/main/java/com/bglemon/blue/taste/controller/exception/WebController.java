package com.bglemon.blue.taste.controller.exception;

import com.bglemon.blue.taste.utils.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/4/22 16:52
 * @Modificd:
 */

public class WebController {

    private static final Logger logger = LogManager.getLogger(WebController.class);

    @Autowired
    RedisUtil redisUtil;

 @PostMapping("/clean-cache")
    public String clean() {
//        redisUtil.remove("role_permission");
//        logger.info("==========redis:{}",redisUtil.get("permission_root"));
//        redisUtil.remove("role_root");
        return "ok";
    }
  /*
    @GetMapping("/article")
    public ResponseBean article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new ResponseBean(200, "You are already logged in", null);
        } else {
            return new ResponseBean(200, "You are guest", null);
        }
    }
    @GetMapping("/require_auth")
    @RequiresAuthentication
    public ResponseBean requireAuth() {
        return new ResponseBean(200, "You are authenticated", null);
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public ResponseBean requireRole() {
        return new ResponseBean(200, "You are visiting require_role", null);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"user:view", "user:edit"})
    public ResponseBean requirePermission() {
        return new ResponseBean(200, "You are visiting permission require edit,view", null);
    }

    @GetMapping("/require_permission1")
    @RequiresPermissions(value = "edit")
    public ResponseBean requirePermission1() {
        return new ResponseBean(200, "You are visiting permission edit", null);
    }
    @GetMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseBean unauthorized() {
        return new ResponseBean(401, "Unauthorized", null);
    }*/
}
