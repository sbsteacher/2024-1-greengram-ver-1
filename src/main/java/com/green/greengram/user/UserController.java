package com.green.greengram.user;

import com.green.greengram.common.model.ResultDto;
import com.green.greengram.user.model.SignUpPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;


    @PostMapping
    public ResultDto<Integer> postUser(@RequestPart(required = false) MultipartFile pic
                                    , @RequestPart SignUpPostReq p) {
        log.info("pic: {}", pic);
        log.info("p: {}", p);
        int result = service.postUser(pic, p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("회원가입 성공")
                .resultData(result)
                .build();
    }
}
