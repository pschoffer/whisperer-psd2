package com.techsylvania.klarnauts.whisperer.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techsylvania.klarnauts.whisperer.data.domain.ReportItem;
import com.techsylvania.klarnauts.whisperer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("/segmentation")
  public String getSegmentationReport() throws JsonProcessingException {
    Map<String, Integer> segmentationResults =
        transactionService.getCustomerPurchaseCountAndAmountSumPerMerchant(
            "test-merchant", 10, 75, "");
    return objectMapper.writeValueAsString(segmentationResults);
  }
}
