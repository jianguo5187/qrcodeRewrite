package com.qrcode.rewrite.controller;

import com.qrcode.rewrite.dto.AjaxResult;
import com.qrcode.rewrite.dto.UpdateEntryUrlReqVO;
import com.qrcode.rewrite.dto.UpdateMainUrlReqVO;
import com.qrcode.rewrite.pojo.SysEntryDomain;
import com.qrcode.rewrite.pojo.SysMainDomain;
import com.qrcode.rewrite.service.SysEntryDomainService;
import com.qrcode.rewrite.service.SysMainDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private SysEntryDomainService entryDomainService;

    @Autowired
    private SysMainDomainService mainDomainService;

    @GetMapping("/updateEntryUrl")
    public AjaxResult updateEntryUrl(@RequestParam(name = "webType", required = false) String webType,@RequestParam(name = "qrUrl", required = false) String qrUrl,@RequestParam(name = "webName", required = false) String webName) {

        if(StringUtils.isEmpty(qrUrl) || StringUtils.isEmpty(webType)){
            return AjaxResult.error("qrURL或web识别码没有输入！！");
        }

        SysEntryDomain entryDomain = entryDomainService.getEntryDomainInfoByWebType(webType);
        if(entryDomain == null){
            entryDomain = new SysEntryDomain();
            entryDomain.setQrUrl(qrUrl);
            entryDomain.setWebType(webType);
            entryDomain.setWebName(webName);

            entryDomainService.insertEntryDomain(entryDomain);
        }else{
            entryDomain.setQrUrl(qrUrl);
            entryDomainService.updateEntryDomain(entryDomain);
        }

        return AjaxResult.success();
    }

    @GetMapping("/updateMainUrl")
    public AjaxResult updateMainUrl(@RequestParam(name = "webType", required = false) String webType,@RequestParam(name = "mainUrl", required = false) String mainUrl) {

        if(StringUtils.isEmpty(mainUrl) || StringUtils.isEmpty(webType)){
            return AjaxResult.error("mainURL或web识别码没有输入！！");
        }

        SysMainDomain mainDomain = mainDomainService.getMainDomainInfoByWebType(webType);

        if(mainDomain == null){
            mainDomain = new SysMainDomain();
            mainDomain.setMainUrl(mainUrl);
            mainDomain.setWebType(webType);
            mainDomainService.insertMainDomain(mainDomain);
        }else{
            mainDomain.setMainUrl(mainUrl);
            mainDomainService.updateMainDomain(mainDomain);
        }

        return AjaxResult.success();
    }
}
