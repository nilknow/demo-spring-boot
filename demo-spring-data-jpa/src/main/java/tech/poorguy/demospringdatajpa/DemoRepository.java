package tech.poorguy.demospringdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<Demo,Long> {
}
