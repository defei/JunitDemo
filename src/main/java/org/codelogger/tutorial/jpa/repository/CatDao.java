package org.codelogger.tutorial.jpa.repository;

import java.util.List;
import org.codelogger.tutorial.jpa.po.CatPO;

/**
 * @author defei
 * @since 10/5/18.
 */
public interface CatDao {

    List<CatPO> findCatWithoutValue(String value);
}
