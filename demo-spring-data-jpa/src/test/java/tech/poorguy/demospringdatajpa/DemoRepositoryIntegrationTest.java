package com.nilknow.demospringdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoRepositoryIntegrationTest {
    @Autowired
    private DemoRepository demoRepository;
    @Autowired
    private EntityManager entityManager;
    @Test
    @Transactional
    void test(){
        List<Demo> preList = Arrays.asList(
                new Demo("-1")
        );
        demoRepository.saveAll(preList);

        saveAll();
        entityManager.flush();
        entityManager.clear();

        List<Demo> postList = Arrays.asList(new Demo("-2"));
        demoRepository.saveAll(postList);

        long count = demoRepository.count();
        assertEquals(count,4);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void saveAll(){
        List<Demo> demoList = Arrays.asList(
                new Demo("1"),
                new Demo("2")
        );
        demoRepository.saveAll(demoList);
    }
}