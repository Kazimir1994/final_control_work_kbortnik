package ru.kazimir.bornik.final_control_work_kbortnik.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kazimir.bornik.final_control_work_kbortnik.repository.BusinessCardRepository;
import ru.kazimir.bornik.final_control_work_kbortnik.repository.model.BusinessCard;

import javax.persistence.Query;
import java.util.List;

@Repository
public class BusinessCardRepositoryImpl extends GenericRepositoryImpl<Long, BusinessCard> implements BusinessCardRepository {
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<BusinessCard> getBusinessCardsByIdUser(Long id) {
        String query = "from " + BusinessCard.class.getName() + " where user.id:= id ";
        Query q = entityManager.createQuery(query).setParameter("id", id);
        return q.getResultList();
    }
}
