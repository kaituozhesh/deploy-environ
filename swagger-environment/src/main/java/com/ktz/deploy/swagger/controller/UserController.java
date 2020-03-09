package com.ktz.deploy.swagger.controller;

import com.ktz.deploy.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Api()：注解类
 *      tags：描述Controller的作用
 * @ApiOperation()：注解方法
 *      value：具体说明接口的作用
 *      notes：接口方法备注
 * @ApiImplicitParams()：注解接口方法，描述一组请求参数，可以包含多个@ApiImplicitParam()
 * @ApiImplicitParam()：注解接口方法，描述一个具体的请求参数
 *      name：请求参数名
 *      value：请求参数描述
 *      required：是否必传
 *      paramType：参数放在哪个地方
 *          header：请求参数的获取：@RequestHeader
 *          query：请求参数的获取：@RequestParam
 *          path（用于restful接口）：请求参数的获取：@PathVariable
 *      dataType：参数类型，默认String，其他值dataType="Integer"
 *      defaultValue：默认值
 * @ApiResponses()：注释接口方法，描述一组HTTP返回值，可以包含多个ApiResponse()
 * @ApiResponse()：注释接口方法，描述一个HTTP响应信息
 *      code：HTTP返回值
 *      message：返回信息
 *      response：抛出异常的类
 * @ApiModel()：注解Model，描述响应数据Model类
 * @ApiModelProperty()：注解属性，描述响应Model类的属性
 * @ApiIgnore()：注解类，表示忽略这个Api
 */
@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController {

    @PostMapping("/add_user")
    @ApiOperation(value = "添加用户的接口", notes = "添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四"),
            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "深圳", required = true)
    }
    )
    public String addUser(String username, String address) {
        return username + " " + address;
    }

    @GetMapping("/find_user")
    @ApiOperation("根据id查询用户的接口")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99", required = true)
    public User getUserById(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @PutMapping("/{id}")
    @ApiOperation("根据id更新用户的接口")
    public User updateUserById(@RequestBody User user) {
        return user;
    }
}
