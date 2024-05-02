package com.green.greengram.user;

import com.green.greengram.user.model.SignUpPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(SignUpPostReq p);
}
