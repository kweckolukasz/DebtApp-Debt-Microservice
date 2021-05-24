package com.debtApp.debtSearch.DAO;

import com.debtApp.debtSearch.model.DebtItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DebtRepository extends MongoRepository<DebtItem, String>
{
    List<DebtItem> findByGroupId(String groupId);
}
