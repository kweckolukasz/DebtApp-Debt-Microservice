package com.debtApp.debt.DAO;

import com.debtApp.debt.model.DebtItem;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DebtRepository extends CrudRepository<DebtItem, Integer> {

    @Cacheable("findByGroupIdCache")
    public List<DebtItem> findByGroupId(int groupId);
}
