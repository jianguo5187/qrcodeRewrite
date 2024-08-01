package com.qrcode.rewrite.service.impl;

import com.qrcode.rewrite.mapper.SysEntryDomainMapper;
import com.qrcode.rewrite.service.SysEntryDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysEntryDomainServiceImpl implements SysEntryDomainService {

    @Autowired
    private SysEntryDomainMapper mainDomainMapper;

}
