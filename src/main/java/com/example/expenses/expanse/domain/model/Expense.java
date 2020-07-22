package com.example.expenses.expanse.domain.model;

import com.example.expenses.expanse.domain.dto.ExpanseDTO;

public class Expense {

    private ExpenseId id;
    private String title;

    private Expense() { }

    public static Expense of(String title) {
        Expense expense = new Expense();
        expense.title = title;
        return expense;
    }

    public ExpanseDTO dto() {
        return new ExpanseDTO(id.getId());
    }

    public ExpenseId getId() {
        return id;
    }

    public void setId(ExpenseId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
