package ru.hits.lecturehosting.video.util;

import lombok.Getter;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemporaryFile implements Closeable {

    private static final String PREFIX = "SPRING_APP_";

    @Getter
    private final Path path;

    public TemporaryFile(String extension) throws IOException {
        path = Files.createTempFile(PREFIX, "." + extension);
    }

    public File getFile() {
        return path.toFile();
    }

    @Override
    public void close() throws IOException {
        Files.delete(path);
    }
}
