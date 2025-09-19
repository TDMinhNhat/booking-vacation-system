package io.github.tdminhnhat.service.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService<P> {

    Object addImage(P id, MultipartFile image) throws Exception;

    Object addListImages(P id, MultipartFile[] images) throws Exception;

    Object updateImage(P id, MultipartFile image) throws Exception;

    Object updateImages(P id, MultipartFile[] images) throws Exception;

    Object deleteImage(P id) throws Exception;

    Object deleteImages(P id) throws Exception;
}
