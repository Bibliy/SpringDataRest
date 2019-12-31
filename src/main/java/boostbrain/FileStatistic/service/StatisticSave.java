package boostbrain.FileStatistic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  boostbrain.FileStatistic.model.Statistic;
import  boostbrain.FileStatistic.repository.StatisticRepository;


//логика взаимодействия с нашей Model
@Service
public class StatisticSave {

    private StatisticRepository repository;

    @Autowired
    public StatisticSave(StatisticRepository repository) {
        this.repository = repository;
    }

    public void save(Statistic statistic) {
        repository.save(statistic);
    }
}
