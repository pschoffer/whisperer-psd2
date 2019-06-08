package com.techsylvania.klarnauts.whisperer.data.repo;

import com.techsylvania.klarnauts.whisperer.data.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

  @Query(
      nativeQuery = true,
      value =
          "SELECT u.id AS user_id, COUNT(t.id) AS user_count, SUM(t.amount) AS total_amount"
              + " FROM public.transaction t"
              + " INNER JOIN public.account a on t.account_id = a.id"
              + " INNER JOIN public.user u on a.user_id = u.id"
              + " WHERE t.merchant_id = ?1"
              + " AND t.bookkeeping_date > date_trunc('day', NOW() - interval '1 year')"
              + " AND u.birth_date BETWEEN ?2 AND ?3"
              + " AND u.gender like ?4"
              + " GROUP BY u.id")
  public List<Object[]> fetchCustomerPurchaseCountAndAmountSumForMerchant(
      String merchantId, Date ageLower, Date ageUpper, String gender);
}
