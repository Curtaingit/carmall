package com.qunchuang.carmall.controller;

import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.qunchuang.carmall.service.AdminService;
import com.qunchuang.carmall.service.VerificationService;
import com.qunchuang.carmall.utils.AliyunOSSUtil;
import com.qunchuang.carmall.utils.BosUtils;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Curtain
 * @date 2019/1/21 11:17
 */
@RestController
public class CarMallRestController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private VerificationService verificationService;

    @Autowired
    private WxMpService wxMpService;

    @RequestMapping("/initAccount")
    public String account(String curtain){
        return adminService.init(curtain);
    }

    @RequestMapping("/sts")
    public Object getStsToken() {
        AssumeRoleResponse resp= AliyunOSSUtil.getToken();
        Map<String,Object> result=new HashMap<>();
        result.put("bucketName","biya-image");
        result.put("endpoint","https://oss-cn-hangzhou.aliyuncs.com/");
        result.put("assumeRoleResponse",resp);
        result.put("resourceId", BosUtils.getZipUuid());
        return result;
    }

    @RequestMapping("/getCode")
    public String getCode(String phone){
        return verificationService.getCode(phone);
    }

    @GetMapping(value = "/jsapisignature")
    @ResponseBody
    public Object createJsapiSignature(@RequestParam("url") String url) throws WxErrorException {
        //是否加上url域名判断
        return this.wxMpService.createJsapiSignature(url);
    }

    //https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx18143d6812b9778c&secret=032714a68384f8d94460342badcea2a9
}
