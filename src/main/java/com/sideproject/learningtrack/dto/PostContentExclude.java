package com.sideproject.learningtrack.dto;

import lombok.Value;

/**
 * A class-based projection for 'Post'
 */
@Value
public class PostContentExclude {
    String id, title, timestamp;
    String[] tags;
}
