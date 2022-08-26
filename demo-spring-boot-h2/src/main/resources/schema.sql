create table login_user
(
    id          identity not null ,
    nickname    varchar(32) default not null,
    create_time timestamp   default current_timestamp(),
    constraint unique_nick_name unique (nickname)
);