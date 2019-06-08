package com.techsylvania.klarnauts.whisperer.service;

import com.techsylvania.klarnauts.whisperer.data.domain.ReportItem;

import java.util.List;

public interface TransactionService {

  List<ReportItem> getAmountsPerCategory();
}
