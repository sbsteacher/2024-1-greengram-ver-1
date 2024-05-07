package com.green.greengram.feed;

import com.green.greengram.common.CustomFileUtils;
import com.green.greengram.feed.model.FeedPicPostDto;
import com.green.greengram.feed.model.FeedPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional
    public long postFeed(List<MultipartFile> pics, FeedPostReq p) { //feed pk값 리턴
        int result = mapper.postFeed(p);

        try {
            String path = String.format("feed/%d", p.getFeedId());
            customFileUtils.makeFolders(path);

            FeedPicPostDto picDto = FeedPicPostDto.builder().feedId(p.getFeedId()).build();
            for(MultipartFile pic : pics) {
                String saveFileName = customFileUtils.makeRandomFileName(pic);
                picDto.getFileNames().add(saveFileName);
                String target = String.format("%s/%s", path, saveFileName);
                customFileUtils.transferTo(pic, target);
            }
            int affectedRowsPics = mapper.postFeedPics(picDto);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Feed 등록 오류");
        }
        return p.getFeedId();
    }
}
