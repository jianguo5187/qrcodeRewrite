package com.qrcode.rewrite.service.impl;

import com.qrcode.rewrite.mapper.SysMainDomainMapper;
import com.qrcode.rewrite.service.SysMainDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMainDomainServiceImpl implements SysMainDomainService {

    @Autowired
    private SysMainDomainMapper mainDomainMapper;

    @Override
    public String getMainUrlByWebType(String webType) {
        return mainDomainMapper.getMainUrlByWebType(webType);
    }
}
