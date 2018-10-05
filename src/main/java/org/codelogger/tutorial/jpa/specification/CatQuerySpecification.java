package org.codelogger.tutorial.jpa.specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.codelogger.tutorial.jpa.po.CatPO;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author defei
 * @since 10/5/18.
 */
public class CatQuerySpecification implements Specification<CatPO> {

    private String value;

    public CatQuerySpecification(String value) {
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<CatPO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (value != null) {
            predicates.add(criteriaBuilder.equal(root.get("value"), value));
        }
        if (!predicates.isEmpty()) {
            criteriaQuery.where(predicates.toArray(new Predicate[0]));
        }
        return criteriaQuery.getRestriction();
    }
}
