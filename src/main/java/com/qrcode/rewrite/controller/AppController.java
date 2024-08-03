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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private SysEntryDomainService entryDomainService;

    @Autowired
    private SysMainDomainService mainDomainService;

    @PostMapping("/updateEntryUrl")
    public AjaxResult updateEntryUrl(@RequestBody UpdateEntryUrlReqVO vo) {

        if(StringUtils.isEmpty(vo.getQrUrl()) || StringUtils.isEmpty(vo.getWebType())){
            return AjaxResult.error("qrURL或web识别码没有输入！！");
        }

        SysEntryDomain entryDomain = entryDomainService.getEntryDomainInfoByWebType(vo.getWebType());
        if(entryDomain == null){
            entryDomain = new SysEntryDomain();
            entryDomain.setQrUrl(vo.getQrUrl());
            entryDomain.setWebType(vo.getWebType());
            entryDomain.setWebName(vo.getWebName());

            entryDomainService.insertEntryDomain(entryDomain);
        }else{
            entryDomain.setQrUrl(vo.getQrUrl());
            entryDomainService.updateEntryDomain(entryDomain);
        }

        return AjaxResult.success();
    }

    @PostMapping("/updateMainUrl")
    public AjaxResult updateMainUrl(@RequestBody UpdateMainUrlReqVO vo) {

        if(StringUtils.isEmpty(vo.getMainUrl()) || StringUtils.isEmpty(vo.getWebType())){
            return AjaxResult.error("mainURL或web识别码没有输入！！");
        }

        SysMainDomain mainDomain = mainDomainService.getMainDomainInfoByWebType(vo.getWebType());

        if(mainDomain == null){
            mainDomain = new SysMainDomain();
            mainDomain.setMainUrl(vo.getMainUrl());
            mainDomain.setWebType(vo.getWebType());
            mainDomainService.insertMainDomain(mainDomain);
        }else{
            mainDomain.setMainUrl(vo.getMainUrl());
            mainDomainService.updateMainDomain(mainDomain);
        }

        return AjaxResult.success();
    }
}
