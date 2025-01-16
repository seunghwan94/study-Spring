package com.example.clone.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttachDto {
  private String uuid;
  private String origin;
  private boolean image;
  private String path;

  private long size;
  private String mime;
  private String fileName;
  private String ext;
  private String url;

  private Long num; // noteNum
}
