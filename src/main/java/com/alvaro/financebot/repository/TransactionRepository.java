package com.alvaro.financebot.repository;

import com.alvaro.financebot.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.category = :category AND MONTH(t.createdAt) = MONTH(CURRENT_DATE) AND YEAR(t.createdAt) = YEAR(CURRENT_DATE)")
	Double sumByCategoryThisMonth(@Param("category") String category);
}