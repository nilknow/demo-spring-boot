package com.nilknow.demospringdatajpa;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
class DemoSpringDataJpaApplicationTests {
    @Autowired
    private DemoRepository demoRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Disabled
    @DisplayName("h2 column type bug")
    void h2ColumnTypeBug(){
        List<Demo> list = new ArrayList<>(2);
        list.add(new Demo("'char'","'char'", Instant.now()));
        list.add(new Demo("char","char", Instant.now()));
        demoRepository.saveAll(list);
    }

    @Test
    @Disabled
    @DisplayName("debug saveAll")
    void debugSaveAll() {
        demoRepository.saveAll(
                Lists.newArrayList(
                        new Demo("demo1", Instant.now()),
                        new Demo("demo2", Instant.now()),
                        new Demo("demo3", Instant.now()),
                        new Demo("demo3", Instant.now()),
                        new Demo("demo3", Instant.now()),
                        new Demo("demo3", Instant.now().plus(1, ChronoUnit.DAYS))
                )
        );
    }

    @Test
    @Disabled
    @DisplayName("debug deleteInBatch")
    void debugDeleteInBatch(){
        demoRepository.saveAll(
                Lists.newArrayList(
                        new Demo("demo1", Instant.now()),
                        new Demo("demo2", Instant.now()),
                        new Demo("demo3", Instant.now()),
                        new Demo("demo3", Instant.now()),
                        new Demo("demo3", Instant.now()),
                        new Demo("demo3", Instant.now().plus(1, ChronoUnit.DAYS))
                )
        );
        ArrayList<Demo> demos = Lists.newArrayList(
                new Demo("demo1", Instant.now()),
                new Demo("demo2", Instant.now()),
                new Demo("demo3", Instant.now()),
                new Demo("demo3", Instant.now()),
                new Demo("demo3", Instant.now()),
                new Demo("demo3", Instant.now().plus(1, ChronoUnit.DAYS))
        );
        demoRepository.deleteInBatch(demos);

        then(demoRepository.count()).isEqualTo(0);
    }

    @Test
    @Disabled
    @DisplayName("debug deleteAll")
    void debugDeleteAll(){
        demoRepository.saveAll(
                Lists.newArrayList(
                        new Demo("demo1", Instant.now()),
                        new Demo("demo2", Instant.now()),
                        new Demo("demo3", Instant.now()),
                        new Demo("demo3", Instant.now()),
                        new Demo("demo3", Instant.now()),
                        new Demo("demo3", Instant.now().plus(1, ChronoUnit.DAYS))
                )
        );
        ArrayList<Demo> demos = Lists.newArrayList(
                new Demo("demo1", Instant.now()),
                new Demo("demo2", Instant.now()),
                new Demo("demo3", Instant.now()),
                new Demo("demo3", Instant.now()),
                new Demo("demo3", Instant.now()),
                new Demo("demo3", Instant.now().plus(1, ChronoUnit.DAYS))
        );
        demoRepository.deleteAll(demos);
        then(demoRepository.count()).isEqualTo(0);
    }

}
