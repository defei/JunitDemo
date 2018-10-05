package org.codelogger.tutorial.jpa.repository;

import java.util.List;
import org.codelogger.tutorial.jpa.po.CatPO;
import org.codelogger.tutorial.jpa.specification.CatQuerySpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author defei
 * @since 10/5/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatRepositoryTestConfiguration.class)
public class CatRepositoryTest {

    @Autowired
    private CatRepository catRepository;

    @Test
    public void save_withCorrectData_saveSuccess() {

        Long expectedId = 5L;//catRepository.count() + 1;

        CatPO cat = new CatPO();
        cat.setValue("test");
        CatPO savedCatPO = catRepository.save(cat);

        assertNotNull(savedCatPO.getId());
        assertEquals(expectedId, savedCatPO.getId());
    }

    @Test
    public void namedMethod_correctValue_expectedCorrectValue() {

        Long expectedId = 1L;

        CatPO catPO = catRepository.findTopByValue("a");
        assertNotNull(catPO);
        assertEquals(expectedId, catPO.getId());
    }

    @Test
    public void queryMethod_correctValue_expectedCorrectValue() {

        Long expectedId = 1L;

        List<CatPO> catPOList = catRepository.findCatsValue("a");
        assertFalse(catPOList.isEmpty());
        assertEquals(expectedId, catPOList.get(0).getId());
    }

    @Test
    public void findAllByValueOOrderByIdDesc_correctValue_expectedCorrectValue() {

        Long expectedId = 4L;

        List<CatPO> catPOList = catRepository.findAllByValueOrderByIdDesc("a");
        assertFalse(catPOList.isEmpty());
        assertEquals(expectedId, catPOList.get(0).getId());
    }

    @Test
    public void findBySpecification_withoutValue_expectedAllCats() {

        int expectedSize = 5;
        CatQuerySpecification catQuerySpecification = new CatQuerySpecification(null);
        List<CatPO> cats = catRepository.findAll(catQuerySpecification);

        assertEquals(expectedSize, cats.size());
    }

    @Test
    public void findBySpecification_withValue_expectedSpecifyCats() {

        int expectedSize = 2;
        CatQuerySpecification catQuerySpecification = new CatQuerySpecification("a");
        List<CatPO> cats = catRepository.findAll(catQuerySpecification);

        assertEquals(expectedSize, cats.size());
    }


    @Test
    public void nativeSql_calledFindCatWithoutValueMethodWithNull_expectedAllCats() {

        int expectedSize = (int) catRepository.count();
        List<CatPO> cats = catRepository.findCatWithoutValue(null);

        assertEquals(expectedSize, cats.size());
    }

    @Test
    public void nativeSql_calledFindCatWithoutValueMethodWithValue_expectedAllCats() {

        int expectedSize = (int) (catRepository.count() - 2);
        List<CatPO> cats = catRepository.findCatWithoutValue("a");

        assertEquals(expectedSize, cats.size());
    }
}