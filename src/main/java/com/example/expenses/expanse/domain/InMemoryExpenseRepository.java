package com.example.expenses.expanse.domain;

import com.example.expenses.expanse.domain.model.Expense;
import com.example.expenses.expanse.domain.model.ExpenseId;
import com.example.expenses.expanse.domain.ports.outgoing.ExpenseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryExpenseRepository implements ExpenseRepository {
    private final ConcurrentHashMap<ExpenseId, Expense> map = new ConcurrentHashMap<>();

    public Expense save(Expense expense) {
        requireNonNull(expense);
        expense.setId(new ExpenseId(expense.getTitle()));
        //map.put(expense.getId(), expense);
        return expense;
    }

    public Expense findOneOrThrow(ExpenseId expenseId) {
        Expense expense = map.get(expenseId);
        if(expense == null) {
            throw new ExpenseNotFoundExpetion(expenseId);
        }
        return expense;
    }

    public void delete(ExpenseId expenseId) {
        map.remove(expenseId);
    }

    public Page<Expense> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }

    class ExpenseNotFoundExpetion extends RuntimeException {
        public ExpenseNotFoundExpetion(ExpenseId expenseId) {
            super("Expense " + expenseId.getId() + " not found");
        }
    }

}
