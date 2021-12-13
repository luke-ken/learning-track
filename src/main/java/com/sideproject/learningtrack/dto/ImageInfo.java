package com.sideproject.learningtrack.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

/**
 * Designed based on requirement from front-end, more specifically the third-party 'quill-image-uploader' library.
 */
@Value
public class ImageInfo {
    String imageUrl;
}
