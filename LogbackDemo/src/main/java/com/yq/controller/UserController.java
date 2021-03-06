

package com.yq.controller;

import com.yq.domain.User;
import com.yq.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService  userSvc;

    @ApiOperation(value = "按用户id查询", notes="private")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", defaultValue = "2", value = "userID", required = true, dataType = "string", paramType = "path"),
    })
    @GetMapping(value = "/users/{userId}", produces = "application/json;charset=UTF-8")
    public User getUser(@PathVariable String userId) {
        User user = (User)userSvc.getById(userId);
        log.error("error rest get user={} by id={}", user, userId);
        log.warn("warn rest get user={} by id={}", user, userId);
        log.info("info rest get user={} by id={}", user, userId);
        log.debug("debug rest get user={} by id={}", user, userId);
        log.trace("trace rest get user={} by id={}", user, userId);
        return user;
    }

    @ApiOperation(value = "按用户id查询", notes="private")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", defaultValue = "2", value = "userID", required = true, dataType = "string", paramType = "path"),
    })
    @DeleteMapping(value = "/users/{userId}", produces = "application/json;charset=UTF-8")
    public User delUser(@PathVariable String userId) {
        User user = (User)userSvc.deleteById(userId);
        log.info("rest del user={} by id={}", user, userId);
        log.debug("rest del user={} by id={}", user, userId);
        return user;
    }

    @ApiOperation(value = "查询所有用户")
    @GetMapping(value = "/users", produces = "application/json;charset=UTF-8")
    public Iterable<User> findAllUsers() {
        Collection<User> users = userSvc.getAllUsers();
        log.info("rest get all users");
        log.debug("rest get all users");
        return users;
    }
}