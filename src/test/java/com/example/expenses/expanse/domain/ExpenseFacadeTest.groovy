package com.example.expenses.expanse.domain

import com.example.expenses.expanse.domain.model.Expense
import com.example.expenses.expanse.domain.model.ExpenseId
import spock.lang.Specification

class ExpenseFacadeTest extends Specification {

    ExpenseFacade expenseFacade = ExpenseConfiguration.inMemExpenseFacade()

    def 'Should return expense'() {
        given: 'add 2 expense'
        ExpenseId exp1Id = expenseFacade.create("Exp1").getId()
        ExpenseId exp2Id = expenseFacade.create("Exp2").getId()

        when: 'and try to get them'
        Expense exp1 = expenseFacade.findOne(exp1Id)
        Expense exp2 = expenseFacade.findOne(exp2Id)

        then: 'result should be not null and no expections'
        exp1 != null
        exp2 != null
    }
}
