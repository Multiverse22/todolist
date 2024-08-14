create table if not exists todo
(
    id int primary key comment 'todolist 고유번호',
    todo varchar(100) not null comment '일정 내용',
    managerName varchar(100) not null comment '일정 담당자',
    creationDate datetime not null comment '생성일',
    modifiedDate datetime not null comment '수정일',
    password varchar(100) not null comment '비밀번호'
)