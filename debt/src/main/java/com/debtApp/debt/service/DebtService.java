package com.debtApp.debt.service;

import com.debtApp.debt.DAO.DebtRepository;
import com.debtApp.debt.model.DebtItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class DebtService {

    @Autowired
    DebtRepository debtRepository;

    @RequestMapping("${env}/debt/{id}")
    DebtItem getDebtItemById(@PathVariable("id") int id) {

        return debtRepository.findById(id).get();
    }

    @RequestMapping("${env}/debts")
    List<DebtItem> getDebtsIds(@RequestParam("id") int id) {
        return debtRepository.getDebtItemsByGroupId(id);
    }
}
