package com.example.expenses.expanse.domain;

import com.example.expenses.expanse.domain.exceptions.MissingExpenseId;
import com.example.expenses.expanse.domain.model.Expense;
import com.example.expenses.expanse.domain.model.ExpenseId;
import com.example.expenses.expanse.domain.ports.outgoing.ExpenseRepository;

import static java.util.Objects.isNull;

public class ExpenseFacade {

    ExpenseRepository expenseRepository;

    public ExpenseFacade(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense create(String title) {
        Expense expense = Expense.of(title);
        expense = expenseRepository.save(expense);
        return expense;
    }

    public Expense findOne(ExpenseId expenseId) {
        if(isNull(expenseId)) {
            throw new MissingExpenseId();
        }
        return expenseRepository.findOneOrThrow(expenseId);
    }
}
