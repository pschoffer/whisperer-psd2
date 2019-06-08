package com.techsylvania.klarnauts.whisperer.service;

import com.techsylvania.klarnauts.whisperer.data.domain.ReportItem;
import com.techsylvania.klarnauts.whisperer.data.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class TransactionServiceImpl implements TransactionService {

  private TransactionRepository transactionRepository;

  @Autowired
  public TransactionServiceImpl(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }


  @Override
  public List<ReportItem> getAmountsPerCategory() {
    final List<ReportItem> temp = Arrays.asList(new ReportItem("one", 12, 2600, null),
        new ReportItem("two", 78, 12600, null));

    return temp;
  }
}
