package com.qrcode.rewrite.service.impl;

import com.qrcode.rewrite.mapper.SysMainDomainMapper;
import com.qrcode.rewrite.pojo.SysMainDomain;
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

    @Override
    public SysMainDomain getMainDomainInfoByWebType(String webType) {
        return mainDomainMapper.getMainDomainInfoByWebType(webType);
    }

    @Override
    public int insertMainDomain(SysMainDomain sysMainDomain) {
        return mainDomainMapper.insertMainDomain(sysMainDomain);
    }

    @Override
    public int updateMainDomain(SysMainDomain sysMainDomain) {
        return mainDomainMapper.updateMainDomain(sysMainDomain);
    }
}
