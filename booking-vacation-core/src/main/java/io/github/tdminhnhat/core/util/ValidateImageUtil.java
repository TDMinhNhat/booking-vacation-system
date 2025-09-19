package io.github.tdminhnhat.core.util;

import org.springframework.web.multipart.MultipartFile;


public class ValidateImageUtil {

    public static boolean isImageFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        return fileName.matches(".*\\.(jpg|jpeg|png)$");
    }
}
