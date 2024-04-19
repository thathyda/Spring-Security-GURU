package com.cstad.itebankingprojectdemo.features.media.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record MediaResponse(

        String name,
        String contentType,
        //png , jpg
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Long size,
        String extension,
        String uri
) {
}
