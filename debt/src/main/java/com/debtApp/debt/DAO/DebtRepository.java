package com.debtApp.debt.DAO;

import com.debtApp.debt.model.DebtItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DebtRepository extends CrudRepository<DebtItem, Integer> {

    public List<DebtItem> getDebtItemsByGroupId(int groupId);
}
