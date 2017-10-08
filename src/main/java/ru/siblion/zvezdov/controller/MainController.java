package ru.siblion.zvezdov.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Zvezdov on 23.12.16.
 */

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    @CrossOrigin
    public String index(Map<String, Object> model) {
        logger.info("Request for index page");
        Collection<File> intFiles = FileUtils.listFiles(new File("/Users/Zvezdov/Documents/Tmp/temp"), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        Collection<File> extFiles = FileUtils.listFiles(new File("/Users/Zvezdov/Documents/Tmp/temp"), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        model.put("intFiles", intFiles);
        model.put("extFiles", extFiles);
        return "index";
    }

    @RequestMapping(value = "file", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String getFile(@RequestParam("filepath") String path) {
        logger.info("Request for getting the file: " + path);
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            logger.warn("Exception: ", e);
        }
        return new String(encoded, StandardCharsets.UTF_8);
    }

    @RequestMapping(value = "file", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String setFile(@RequestBody String body, @RequestParam("filepath") String path) {
        logger.info("Request for setting the file: " + path + "\n Text: " + body);
        try {
            FileUtils.writeStringToFile(new File(path), body);
        } catch (IOException e) {
            logger.warn("Exception: ", e);
            return "Error";
        }
        return "Ok";
    }

}
