package com.nilknow.demospringbooth2trigger;

import org.h2.api.Trigger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class MyTrigger implements Trigger {

    @Override
    public void init(Connection connection, String s, String s1, String s2, boolean b, int i) throws SQLException {
        System.out.println("Trigger init");
    }

    @Override
    public void fire(Connection connection, Object[] objects, Object[] objects1) throws SQLException {
        System.out.println("Trigger fire");
    }

    @Override
    public void close() throws SQLException {

    }

    @Override
    public void remove() throws SQLException {

    }
}
