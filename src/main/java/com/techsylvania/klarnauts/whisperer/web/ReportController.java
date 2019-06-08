package com.techsylvania.klarnauts.whisperer.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techsylvania.klarnauts.whisperer.data.domain.ReportItem;
import com.techsylvania.klarnauts.whisperer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;

@RestController
@RequestMapping("/report")
public class ReportController {

  private ObjectMapper objectMapper;

  @Autowired
  public ReportController(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }


  @GetMapping("/{reportType}")
  public String getReport(@PathVariable String reportType) throws JsonProcessingException {
    ReportItem[] items = {new ReportItem("one", 12, 2600),
        new ReportItem("two", 78, 12600)};
    return objectMapper.writeValueAsString(items);
  }
}
