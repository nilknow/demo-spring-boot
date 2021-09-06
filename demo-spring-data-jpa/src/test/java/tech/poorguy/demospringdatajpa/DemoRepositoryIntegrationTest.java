package tech.poorguy.demospringdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoRepositoryIntegrationTest {
    @Autowired
    private DemoRepository demoRepository;
    @Test
    @Transactional
    void test(){
        List<Demo> preList = Arrays.asList(
                new Demo("-1")
        );
        demoRepository.saveAll(preList);

        saveAll();

        List<Demo> postList = Arrays.asList(new Demo("-2"));
        demoRepository.saveAll(postList);
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