package com.example.fifaworldcupservice;

import io.teaql.core.translation.TranslationRecord;
import io.teaql.core.translation.TranslationResponse;
import io.teaql.core.translation.Translator;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);

    // To generate demo data for development/testing, uncomment the following code:
    // try {
    //     new com.example.fifaworldcupservice.demodata.DemoDataService().generateDemoData(
    //         io.teaql.core.UserContext.admin(), 
    //         com.example.fifaworldcupservice.demodata.DemoDataService.DemoDataPlan.small()
    //     );
    // } catch (Exception e) {
    //     e.printStackTrace();
    // }
  }

  @Bean
  public Translator translator() {
    return req -> {
      TranslationResponse translationResponse = new TranslationResponse(req);
      Set<TranslationRecord> records = req.getRecords();
      for (TranslationRecord record : records) {
        String key = record.getKey();
        if (key.equals("web.action.delete")) {
          record.setValue("Delete");
        } else if (key.equals("web.action.update")) {
          record.setValue("Update");
        }
      }
      return translationResponse;
    };
  }
}