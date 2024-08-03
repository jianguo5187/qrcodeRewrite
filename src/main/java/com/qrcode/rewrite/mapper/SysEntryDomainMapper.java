package com.qrcode.rewrite.mapper;

import com.qrcode.rewrite.pojo.SysEntryDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface SysEntryDomainMapper {

    public SysEntryDomain getEntryDomainInfoByWebType(String webType);

    public int insertEntryDomain(SysEntryDomain sysEntryDomain);

    public int updateEntryDomain(SysEntryDomain sysEntryDomain);
}
