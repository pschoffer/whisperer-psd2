package com.techsylvania.klarnauts.whisperer.service;

import java.util.Map;

public interface TransactionService {

  Map<String, String> getPurchaseAmountsByAge(int ageLowerLimit, int ageUpperLimit);
}
