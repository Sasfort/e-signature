package com.kredinesia.esignature.dto.upload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
@AllArgsConstructor
public class UploadRequest {
    String documentTitle;
    String docType;
    String owner;
    File document;
    List<Object> recipients;
    String templateId;
}
