package com.example.expenses.expanse.domain;

import com.example.expenses.expanse.domain.ports.outgoing.ExpenseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ExpenseConfiguration {


    static ExpenseFacade inMemExpenseFacade() {
        return new ExpenseFacade(new InMemoryExpenseRepository());
    }

    @Bean
    ExpenseFacade expenseFacade(ExpenseRepository expenseRepository) {
        return new ExpenseFacade(expenseRepository);
    }
}
