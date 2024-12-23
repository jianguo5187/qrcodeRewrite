package com.qrcode.rewrite.mapper;

import com.qrcode.rewrite.pojo.SysEntryDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface SysEntryDomainMapper {

    public String getEntryUrlByWebType(String webType);

    public SysEntryDomain getEntryDomainInfoByWebType(String webType);

    public int insertEntryDomain(SysEntryDomain sysEntryDomain);

    public int updateEntryDomain(SysEntryDomain sysEntryDomain);
}
