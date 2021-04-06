package com.sideproject.learningtrack.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Designed based on requirement from front-end, more specifically the third-party 'quill-image-uploader' library.
 */
public class ImageInfo {

    @Getter
    @Setter
    private String imageUrl;

    public ImageInfo(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
