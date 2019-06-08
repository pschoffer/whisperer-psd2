package com.techsylvania.klarnauts.whisperer.service;

import com.techsylvania.klarnauts.whisperer.data.domain.ReportItem;

import java.util.List;
import java.util.Map;

public interface TransactionService {

  List<ReportItem> getAmountsPerCategory();

  Map<String, Integer> getCustomerPurchaseCountAndAmountSumPerMerchant(
      String merchantId, int ageLower, int ageUpper, String gender);
}
