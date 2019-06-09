package com.techsylvania.klarnauts.whisperer.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techsylvania.klarnauts.whisperer.data.domain.ReportItem;
import com.techsylvania.klarnauts.whisperer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

  private final ObjectMapper objectMapper;
  private final TransactionService transactionService;

  @Autowired
  public ReportController(ObjectMapper objectMapper, final TransactionService transactionService) {
    this.objectMapper = objectMapper;
    this.transactionService = transactionService;
  }

  @GetMapping("/categories")
  public String getCategoriesReport() throws JsonProcessingException {

    final List<ReportItem> result = transactionService.getAmountsPerCategory();
    return objectMapper.writeValueAsString(result.toArray());
  }

  @GetMapping("/segmentation/{gender}/{ageGroup}")
  public String getSegmentationReport(@PathVariable String gender, @PathVariable String ageGroup)
      throws JsonProcessingException {
    String genderFilter = "";
    int lowerAge;
    int upperAge;
    try {
      String[] ageGroups = ageGroup.split("-");
      lowerAge = Integer.parseInt(ageGroups[0]);
      upperAge = Integer.parseInt(ageGroups[1]);
    } catch (Exception e) {
      lowerAge = 0;
      upperAge = 120;
    }
    Map<String, Integer> segmentationResults =
        transactionService.getCustomerPurchaseCountAndAmountSumPerMerchant(
            "test-merchant", lowerAge, upperAge, gender);
    return objectMapper.writeValueAsString(segmentationResults);
  }
}
