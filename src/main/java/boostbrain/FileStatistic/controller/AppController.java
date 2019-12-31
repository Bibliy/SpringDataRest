package boostbrain.FileStatistic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import boostbrain.FileStatistic.model.Statistic;
import  boostbrain.FileStatistic.service.StatisticProcessor;
import  boostbrain.FileStatistic.service.StatisticSave;

import java.io.*;

@SuppressWarnings("ALL")
@Controller
public class AppController {

    private StatisticProcessor processor;

    private StatisticSave statisticSave;

    @Autowired
    public AppController(StatisticProcessor processor, StatisticSave statisticSave) {
        this.processor = processor;
        this.statisticSave = statisticSave;
    }

    private static final String pathPrefix = "D:/Downloads/FileStatistic";

    @PostMapping(produces = "application/json")
    @ResponseBody
    public Statistic processRequest(@RequestParam("path") String path, @RequestParam("file") MultipartFile uploadedFile) {
        if (uploadedFile.isEmpty()) {
            return new Statistic();
        }
        else {
            try {
                File file = new File(pathPrefix + path);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(uploadedFile.getBytes());
                Statistic statistic = processor.getStatistic(uploadedFile.getBytes());
                statisticSave.save(statistic);

                return statistic;

            } catch (IOException e) {
                return new Statistic(e);
            }
        }
    }
}
