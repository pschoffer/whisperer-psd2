package com.techsylvania.klarnauts.whisperer.service;

import static java.time.temporal.ChronoUnit.YEARS;

import com.techsylvania.klarnauts.whisperer.data.domain.ReportItem;
import com.techsylvania.klarnauts.whisperer.data.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

  private static final BigDecimal PLATINUM_AMOUNT = new BigDecimal("50000");
  private static final BigDecimal GOLD_AMOUNT = new BigDecimal("25000");
  private static final BigDecimal BRONZE_AMOUNT = new BigDecimal("10000");
  private TransactionRepository transactionRepository;

  @Autowired
  public TransactionServiceImpl(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  @Override
  public List<ReportItem> getAmountsPerCategory() {
    final List<ReportItem> temp =
        Arrays.asList(
            new ReportItem("one", 12, 2600, null), new ReportItem("two", 78, 12600, null));

    return temp;
  }

  @Override
  public Map<String, Integer> getCustomerPurchaseCountAndAmountSumPerMerchant(
      String merchantId, int ageLower, int ageUpper, String gender) {

    String filterGender;
    if ("M".equalsIgnoreCase(gender) || "F".equalsIgnoreCase(gender)) {
      filterGender = gender.toUpperCase();
    } else {
      filterGender = "%";
    }

    List<Object[]> objects =
        transactionRepository.fetchCustomerPurchaseCountAndAmountSumForMerchant(
            "test-merchant", toDate(ageUpper), toDate(ageLower), filterGender);

    List<CustomerPurchaseCountAndAmountSum> results =
        objects.stream().map(CustomerPurchaseCountAndAmountSum::new).collect(Collectors.toList());

    // do the segmentation logic
    Map<String, Integer> segmentationMap = new HashMap<>();
    segmentationMap.put("Platinum", 0);
    segmentationMap.put("Gold", 0);
    segmentationMap.put("Bronze", 0);
    segmentationMap.put("None", 0);

    results.forEach(
        result -> {
          if (PLATINUM_AMOUNT.compareTo(result.totalAmount) >= 0) {
            segmentationMap.put("Platinum", segmentationMap.get("Platinum") + 1);
          } else if (GOLD_AMOUNT.compareTo(result.totalAmount) >= 0) {
            segmentationMap.put("Gold", segmentationMap.get("Gold") + 1);
          } else if (BRONZE_AMOUNT.compareTo(result.totalAmount) >= 0) {
            segmentationMap.put("Bronze", segmentationMap.get("Bronze") + 1);
          } else {
            segmentationMap.put("None", segmentationMap.get("None") + 1);
          }
        });

    System.out.println(segmentationMap);

    return segmentationMap;
  }

  private Date toDate(int minusYears) {
    try {
      LocalDate result = LocalDate.now().minus(minusYears, YEARS);
      String dateAsText = result.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      return Date.valueOf(
          format.parse(dateAsText).toInstant().atZone(ZoneId.of("UTC")).toLocalDate());
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}
