package com.cstad.itebankingprojectdemo.features.media;

import com.cstad.itebankingprojectdemo.features.media.dto.MediaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/medias" )
@RequiredArgsConstructor
public class MediaController {
    private final MediaService mediaService;
    @PostMapping("/upload-file")
    MediaResponse uploadSingle(@RequestPart MultipartFile file) {
        return mediaService.uploadSingle(file, "Image");

    }
    @PostMapping("/upload-multiple")
    List<MediaResponse> uploadMultiple(@RequestPart List<MultipartFile> files){
        return (mediaService.uploadSingle(files, "Image"));
    }

//    @GetMapping("/{mediaName}")
//    MediaResponse loadMediaByName()

    @GetMapping("/{mediaName}")
    MediaResponse loadMediaByName(@PathVariable String mediaName) {
        return mediaService.loadMediaByName(mediaName, "Image");
    }

    @DeleteMapping("/{mediaName}")
    MediaResponse deleteMediaByName(@PathVariable String mediaName) {
        return mediaService.deleteMediaByName(mediaName, "Image");
    }
}
