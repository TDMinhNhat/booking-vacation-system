package io.github.tdminhnhat.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IImageManagementController<P> {

    ResponseEntity<?> addImage(P id, MultipartFile image) throws Exception;

    ResponseEntity<?> addListImages(P id, MultipartFile[] images) throws Exception;

    ResponseEntity<?> updateImage(P id, MultipartFile image) throws Exception;

    ResponseEntity<?> updateImages(P id, MultipartFile[] image) throws Exception;

    ResponseEntity<?> deleteImage(P id) throws Exception;

    ResponseEntity<?> deleteImages(P id) throws Exception;
}
