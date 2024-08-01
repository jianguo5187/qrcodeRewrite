package com.qrcode.rewrite.mapper;

import com.qrcode.rewrite.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface SysEntryDomainMapper {

    User getUserInfo(String userId);
}
