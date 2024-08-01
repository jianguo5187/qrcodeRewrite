package com.qrcode.rewrite.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface SysMainDomainMapper {
    public String getMainUrlByWebType(String webType);
}
