package com.qrcode.rewrite.service;

import com.qrcode.rewrite.pojo.SysEntryDomain;

public interface SysEntryDomainService {

    public String getEntryUrlByWebType(String webType);

    public SysEntryDomain getEntryDomainInfoByWebType(String webType);

    public int insertEntryDomain(SysEntryDomain sysEntryDomain);

    public int updateEntryDomain(SysEntryDomain sysEntryDomain);
}
