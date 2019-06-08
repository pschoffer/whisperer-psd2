package com.techsylvania.klarnauts.whisperer.data.repo;

import com.techsylvania.klarnauts.whisperer.data.domain.Transaction;
import com.techsylvania.klarnauts.whisperer.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

  @Query(
      nativeQuery = true,
      value =
          "SELECT id, account_id, amount, currency, merchant_id, bookkeeping_date, mcc_code, credit_debit_indicator, installment_indicator, zip_code"
              + " FROM public.transaction"
              + " WHERE lower(email) = lower(?1)")
  User findByEmail(String email);
}
