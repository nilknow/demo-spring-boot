package tech.poorguy.demospringdatajpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "demo")
public class Demo {
    @Id
    @Column(name = "id",length = 50)
    private String id;
    @Column(name = "value", length = 4000)
    private String value;
    @Column(name = "create_time")
    private Instant createTime;

    public Demo(String id, Instant createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    public Demo(String id) {
        this.id = id;
    }
}
