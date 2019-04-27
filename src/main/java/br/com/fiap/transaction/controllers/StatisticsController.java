package br.com.fiap.transaction.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fiap.transaction.dto.Statistics;
import br.com.fiap.transaction.service.StatisticsService;

import static org.springframework.http.HttpStatus.OK;

@Controller
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/statistic")
    @ResponseBody
    public ResponseEntity<Statistics> getTransactions() {
        return new ResponseEntity<>(statisticsService.getStatistics(), OK);
    }
}
