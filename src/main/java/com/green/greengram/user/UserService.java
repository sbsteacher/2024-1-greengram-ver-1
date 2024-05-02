package com.green.greengram.user;

import com.green.greengram.user.model.SignUpPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int postUser(MultipartFile pic, SignUpPostReq p) {
        //프로필 이미지 파일 처리


        return mapper.postUser(p);
    }

}
