package ru.siblion.zvezdov.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.siblion.zvezdov.core.FileService;

import java.io.File;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Zvezdov on 23.12.16.
 */

@Controller
@PropertySource("classpath:application.properties")
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Value("${folder.int}")
    private String intFolder;

    @Value("${folder.ext}")
    private String extFolder;

    @RequestMapping("/")
    @CrossOrigin
    public String index(Map<String, Object> model) {
        logger.info("Request for index page");
        Collection<File> intFiles = FileUtils.listFiles(new File(intFolder), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        Collection<File> extFiles = FileUtils.listFiles(new File(extFolder), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        model.put("intFiles", intFiles);
        model.put("extFiles", extFiles);
        return "index";
    }

    @RequestMapping(value = "file", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String getFile(@RequestParam("filepath") String path) {
        logger.info("Request for getting the file: " + path);
        return FileService.getFileAsString(path);
    }

    @RequestMapping(value = "file", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public void setFile(@RequestBody String body, @RequestParam("filepath") String path) {
        logger.info("Request for setting the file: " + path + "\n Text: " + body);
        FileService.writeFileFromString(path, body);
    }

}
