package com.egiants.fileupload;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepository extends JpaRepository<FileEntity, Long> {
}
