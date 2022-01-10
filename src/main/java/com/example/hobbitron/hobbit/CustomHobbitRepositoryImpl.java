package com.example.hobbitron.hobbit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomHobbitRepositoryImpl implements CustomHobbitRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Hobbit> findUsingCustomRepo(String firstName, String lastName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();//generowanie zapytan
        CriteriaQuery<Hobbit> cq = cb.createQuery(Hobbit.class);//
        Root<Hobbit> hobbit = cq.from(Hobbit.class);
        Predicate namePredicate = cb.equal(hobbit.get("firstName"), firstName);
        Predicate lastNamePredicate = cb.like(hobbit.get("lastName"), lastName);
        cq.where(namePredicate, lastNamePredicate);
        TypedQuery<Hobbit> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
