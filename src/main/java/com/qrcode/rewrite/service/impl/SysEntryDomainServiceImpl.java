package com.qrcode.rewrite.service.impl;

import com.qrcode.rewrite.mapper.SysEntryDomainMapper;
import com.qrcode.rewrite.pojo.SysEntryDomain;
import com.qrcode.rewrite.service.SysEntryDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysEntryDomainServiceImpl implements SysEntryDomainService {

    @Autowired
    private SysEntryDomainMapper mainDomainMapper;

    @Override
    public String getEntryUrlByWebType(String webType) {
        return mainDomainMapper.getEntryUrlByWebType(webType);
    }

    @Override
    public SysEntryDomain getEntryDomainInfoByWebType(String webType) {
        return mainDomainMapper.getEntryDomainInfoByWebType(webType);
    }

    @Override
    public int insertEntryDomain(SysEntryDomain sysEntryDomain) {
        return mainDomainMapper.insertEntryDomain(sysEntryDomain);
    }

    @Override
    public int updateEntryDomain(SysEntryDomain sysEntryDomain) {
        return mainDomainMapper.updateEntryDomain(sysEntryDomain);
    }
}
