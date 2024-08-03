package com.qrcode.rewrite.mapper;

import com.qrcode.rewrite.pojo.SysMainDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMainDomainMapper {
    public String getMainUrlByWebType(String webType);

    public SysMainDomain getMainDomainInfoByWebType(String webType);

    public int insertMainDomain(SysMainDomain sysMainDomain);

    public int updateMainDomain(SysMainDomain sysMainDomain);
}
