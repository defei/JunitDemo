package org.codelogger.tutorial.jpa.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.codelogger.tutorial.jpa.po.CatPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * @author defei
 * @since 10/5/18.
 */
public class CatRepositoryImpl extends SimpleJpaRepository<CatPO, Long> implements CatDao {

    private EntityManager entityManager;

    @Autowired
    public CatRepositoryImpl(EntityManager em) {

        super(CatPO.class, em);
        this.entityManager = em;
    }

    /**
     * 查询value值和传入的不同的结果，使用原生sql查询，使用 {@link EntityManager} 执行
     *
     * @param value 需要查询的value值
     * @return 查询结果
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<CatPO> findCatWithoutValue(String value) {

        StringBuilder querySql = new StringBuilder("SELECT p.* FROM cat p");
        if (value == null) {
            querySql.append(" WHERE p.value IS NOT NULL");
        } else {
            querySql.append(" WHERE p.value != :value");
        }

        Query query = entityManager.createNativeQuery(querySql.toString(), CatPO.class);

        if (value != null) {
            query.setParameter("value", value);
        }

        return query.getResultList();
    }
}
