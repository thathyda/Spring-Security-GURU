package com.cstad.itebankingprojectdemo.features.media;

import com.cstad.itebankingprojectdemo.features.media.dto.MediaResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaService {
    MediaResponse  uploadSingle(MultipartFile file, String folderName);
    List<MediaResponse> uploadSingle(List<MultipartFile> files,String folderName);

    List<MediaResponse> uploadMultiple(List<MultipartFile> files, String folderName);

    MediaResponse loadMediaByName (String mediaName, String folderName);
    MediaResponse deleteMediaByName(String mediaName, String folderName);
}
