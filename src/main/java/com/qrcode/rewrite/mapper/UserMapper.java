package com.qrcode.rewrite.mapper;

import com.qrcode.rewrite.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserInfo(String userId);
}
