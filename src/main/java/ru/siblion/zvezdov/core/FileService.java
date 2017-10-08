package ru.siblion.zvezdov.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Dmitry Zvezdov
 *         08.10.2017.
 */
public class FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    public static String getFileAsString(String path) {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            logger.warn("Exception: ", e);
        }
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static void writeFileFromString(String path, String data) {
        try {
            org.apache.commons.io.FileUtils.writeStringToFile(new File(path), data);
        } catch (IOException e) {
            logger.warn("Exception: ", e);
        }
    }
}
