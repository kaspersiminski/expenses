package com.example.expenses.expanse.domain.ports.outgoing;

import com.example.expenses.expanse.domain.model.Expense;
import com.example.expenses.expanse.domain.model.ExpenseId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExpenseRepository {

    Expense save(Expense expense);

    Expense findOneOrThrow(ExpenseId expenseId);

    void delete(ExpenseId expenseId);

    Page<Expense> findAll(Pageable pageable);
}