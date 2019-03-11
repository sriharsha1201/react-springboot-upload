package com.egiants.fileupload;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(value = {"*"}, exposedHeaders = "Content-Disposition")
public class FileBoundry {
    private FileEntityRepository fileEntityRepository;

    public FileBoundry(FileEntityRepository fileEntityRepository) {
        this.fileEntityRepository = fileEntityRepository;
    }
    @PostMapping
    public ResponseEntity<Void> uploadNewFile(@NotNull @RequestParam("file") MultipartFile multipartFile) throws IOException {
        FileEntity fileEntity = new FileEntity(multipartFile.getOriginalFilename(), multipartFile.getContentType(), multipartFile.getBytes());
        fileEntityRepository.save(fileEntity);
        System.out.println("File Name: "+multipartFile.getOriginalFilename() + "File Type: " +multipartFile.getContentType() + "File Size "+ multipartFile.getSize());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }
}
