package com.cstad.itebankingprojectdemo.util;

public class MediaUtil {
        public static String extractExtension(String mediaName){
            // get extension from file after the user upload
            int lastDotIndex = mediaName.lastIndexOf(".");
            return mediaName.substring(lastDotIndex + 1);

        }

    }
