package com.egiants.fileupload;

import javax.persistence.*;

@Entity
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String contentType;

    @Lob
    private byte[] data;

    public FileEntity(String originalFilename, String contentType, byte[] bytes) {
        this.fileName = originalFilename;
        this.contentType = contentType;
        this.data = bytes;
    }
}
