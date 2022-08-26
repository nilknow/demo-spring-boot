package com.nilknow.demospringbooth2;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "login_user")
public class LoginUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nickname;
    public Date createTime;
}
