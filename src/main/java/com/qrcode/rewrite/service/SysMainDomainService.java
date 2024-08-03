package com.qrcode.rewrite.service;

import com.qrcode.rewrite.pojo.SysMainDomain;

public interface SysMainDomainService {
    public String getMainUrlByWebType(String webType);

    public SysMainDomain getMainDomainInfoByWebType(String webType);

    public int insertMainDomain(SysMainDomain sysMainDomain);

    public int updateMainDomain(SysMainDomain sysMainDomain);
}
