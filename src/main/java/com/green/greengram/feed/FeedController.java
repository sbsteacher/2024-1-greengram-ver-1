package com.green.greengram.feed;

import com.green.greengram.common.model.ResultDto;
import com.green.greengram.feed.model.FeedPostReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/feed")
@Tag(name = "Feed 피드", description = "Feed CRUD")
public class FeedController {
    private final FeedService service;

    @PostMapping
    @Operation(summary = "Feed 등록", description = "")
    public ResultDto<Long> postFeed(@RequestPart List<MultipartFile> pics, @RequestPart FeedPostReq p) {
        long result = 0L;

        return ResultDto.<Long>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result)
                .build();
    }
}
