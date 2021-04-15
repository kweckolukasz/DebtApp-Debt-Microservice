package com.debtApp.debt.service;

import com.debtApp.debt.model.DebtItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class DebtService {


    @RequestMapping("${env}/debt/{id}")
    DebtItem getDebtItemById(@PathVariable("id") int id) {

        return new DebtItem(id);
    }

    @RequestMapping("${env}/debtsIds")
    List<Integer> getDebtsIds(@RequestParam("id") int id) {
        return Arrays.asList(id + 1, id + 2, id + 3);
    }
}
