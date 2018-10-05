package org.codelogger.tutorial.jpa.repository;

import java.util.List;
import org.codelogger.tutorial.jpa.po.CatPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author defei
 * @since 10/5/18.
 */
public interface CatRepository extends JpaRepository<CatPO, Long>, JpaSpecificationExecutor<CatPO>, CatDao {

    CatPO findTopByValue(String value);

    @Query("SELECT p FROM CatPO p WHERE p.value = ?1")
    List<CatPO> findCatsValue(String value);

    List<CatPO> findAllByValueOrderByIdDesc(String value);
}
