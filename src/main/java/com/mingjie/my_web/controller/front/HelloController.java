package com.mingjie.my_web.controller.front;

import com.alibaba.fastjson.JSONObject;
import com.mingjie.my_web.common.BaseResult;
import com.mingjie.my_web.common.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "入门接口")
public class HelloController {
    @ApiOperation("获取第一个json")
    @GetMapping("/hello")
    public BaseResult hello(){
        return ResultUtil.success("welcome to you");
    }
    @ApiOperation("根据id获取单个产品信息")
            @ApiImplicitParams({
                    @ApiImplicitParam(name = "id",value = "产品id,目前只有id=1的产品",required = true,dataType = "int",paramType = "query")
            })
    @GetMapping("/getProduct")
        public BaseResult getProduct(){
            JSONObject json = new JSONObject();
            json.put("id",1);
            json.put("name","iphoneX");
            json.put("price",2000);
            json.put("sum",5);
        return ResultUtil.success(json);
        }
}
