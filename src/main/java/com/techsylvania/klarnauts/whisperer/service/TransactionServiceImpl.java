package com.techsylvania.klarnauts.whisperer.service;

import com.techsylvania.klarnauts.whisperer.data.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TransactionServiceImpl implements TransactionService {

  private TransactionRepository transactionRepository;

  @Autowired
  public TransactionServiceImpl(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  /**
   * @param ageLowerLimit inclusive
   * @param ageUpperLimit inclusive
   * @return Key = MccCode , Value =Amount
   */
  @Override
  public Map<String, String> getPurchaseAmountsByAge(int ageLowerLimit, int ageUpperLimit) {

    //transactionRepository.fetchMccCodeAndPurchaseAmountsByAge(ageLowerLimit, ageUpperLimit);
    return null;
  }
}
