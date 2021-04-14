package com.debtApp.debt.controller;

import com.debtApp.debt.model.DebtItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DebtController {

    @GetMapping("/debt/{id}")
    DebtItem getDebtItemById(@PathVariable("id") int id) {
        return new DebtItem(id);
    }

    @GetMapping("/debtsIds")
    List<Integer> getDebtsIds(@RequestParam("id") int id) {
        return Arrays.asList(id + 1, id + 2, id + 3);
    }
}
