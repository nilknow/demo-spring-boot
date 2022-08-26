create table login_user
(
    id          number not null ,
    nickname    varchar(32) default not null,
    create_time timestamp   default sysdate
constraint login_user_create_time_check
check (create_time=trunc(create_time)),
    primary key (id)
);

create trigger login_user_insert_trigger
    before insert
    on login_user
    for each row
call "com.nilknow.demospringbooth2trigger.MyTrigger";