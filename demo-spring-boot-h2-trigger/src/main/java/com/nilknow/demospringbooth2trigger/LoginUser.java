package com.nilknow.demospringbooth2trigger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {
    @Id
    private Long id;
    private String nickname;
    private Date createTime;
}
