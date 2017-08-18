--删除表，选择执行，没有以下表就不要运行这些删除表的语句
drop table HOUSE_PICTURE;
drop table HOUSE;
drop table STREET;
drop table DISTRICT;
drop table HOUSE_TYPE;
drop table HOUSE_USER;

--删除序列，选择执行，没有以下序列就不要运行这些删除序列的语句
drop sequence HOUSE_USER_ID ;
drop sequence DISTRICT_ID ;
drop sequence HOUSE_ID ;
drop sequence STREET_ID ;
drop sequence HOUSE_TYPE_ID ;
drop sequence HOUSE_PICTURE_ID ;


--创建表
-- Create table
create table HOUSE_USER
(
  ID        NUMBER(9) not null,
  USERNAME  VARCHAR2(50),
  PASSWORD  VARCHAR2(50),
  TELEPHONE VARCHAR2(15),
  REALNAME  VARCHAR2(50),
  ISADMIN   VARCHAR2(5)
);
alter table HOUSE_USER
  add constraint PRI_HOUSE_USER primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );


create table HOUSE_TYPE
(
  ID   NUMBER(9) not null,
  NAME VARCHAR2(50) not null
);
alter table HOUSE_TYPE
  add constraint PRI_HOUSE_TYPE primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

create table DISTRICT
(
  ID   NUMBER(9) not null,
  NAME VARCHAR2(50) not null
);
alter table DISTRICT
  add constraint PRI_DISTRICT primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

create table STREET
(
  ID          NUMBER(9) not null,
  NAME        VARCHAR2(50),
  DISTRICT_ID NUMBER(9)
);
alter table STREET
  add constraint PRI_STREET primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table STREET
  add constraint STREET_REF_DISTRICT foreign key (DISTRICT_ID)
  references DISTRICT (ID);

create table HOUSE
(
  ID          NUMBER(9) not null,
  USER_ID     NUMBER(9),
  TYPE_ID     NUMBER(9),
  TITLE       VARCHAR2(50),
  DESCRIPTION VARCHAR2(2000),
  PRICE       FLOAT,
  PUBDATE     DATE,
  ADDDATE     DATE,
  FLOORAGE    FLOAT,
  CONTACT     VARCHAR2(100),
  STREET_ID   NUMBER(9)
);
alter table HOUSE
  add constraint PRI_HOUSE primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table HOUSE
  add constraint HOUSE_REF_HOUSE_TYPE foreign key (TYPE_ID)
  references HOUSE_TYPE (ID);
alter table HOUSE
  add constraint HOUSE_REF_HOUSE_USER foreign key (USER_ID)
  references HOUSE_USER (ID);
alter table HOUSE
  add constraint HOUSE_REF_STREET foreign key (STREET_ID)
  references STREET (ID);


create table HOUSE_PICTURE
(
  ID       NUMBER(9) not null,
  HOUSE_ID NUMBER(9),
  TITLE    VARCHAR2(50),
  URL      VARCHAR2(500)
);
alter table HOUSE_PICTURE
  add constraint PRI_HOUSE_PICTURE primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table HOUSE_PICTURE
  add constraint HOUSE_PICTURE_REF_HOUSE foreign key (HOUSE_ID)
  references HOUSE (ID);


--创建序列
create sequence HOUSE_USER_ID increment by 1 start with 10;
create sequence DISTRICT_ID increment by 1 start with 10;
create sequence HOUSE_ID increment by 1 start with 10;
create sequence STREET_ID increment by 1 start with 10;
create sequence HOUSE_TYPE_ID increment by 1 start with 10;
create sequence HOUSE_PICTURE_ID increment by 1 start with 10;

--添加测试数据
insert into HOUSE_USER values (1, 'accp','111111','13888888888','accp','n');
insert into HOUSE_USER values (2, 'jbit','111111','13888888888','jbit','n');
insert into HOUSE_USER values (3, 'admin','111111','13888888888','admin','y');
commit;

insert into HOUSE_TYPE (ID, NAME) values (1, '一室一厅');
insert into HOUSE_TYPE (ID, NAME) values (2, '一室两厅');
insert into HOUSE_TYPE (ID, NAME) values (3, '两室一厅');
insert into HOUSE_TYPE (ID, NAME) values (4, '两室两厅');
insert into HOUSE_TYPE (ID, NAME) values (5, '三室一厅');
insert into HOUSE_TYPE (ID, NAME) values (6, '三室两厅');
insert into HOUSE_TYPE (ID, NAME) values (7, '四室一厅');
insert into HOUSE_TYPE (ID, NAME) values (8, '四室两厅');
insert into HOUSE_TYPE (ID, NAME) values (9, '四十三厅');
commit;

insert into DISTRICT (ID, NAME) values (1, '东城');
insert into DISTRICT (ID, NAME) values (2, '西城');
insert into DISTRICT (ID, NAME) values (3, '石景山');
insert into DISTRICT (ID, NAME) values (4, '朝阳');
insert into DISTRICT (ID, NAME) values (5, '丰台');
insert into DISTRICT (ID, NAME) values (6, '海淀');
commit;

insert into STREET (ID, NAME, DISTRICT_ID) values (1, '知春路', 4);
insert into STREET (ID, NAME, DISTRICT_ID) values (2, '中关村大街', 4);
insert into STREET (ID, NAME, DISTRICT_ID) values (3, '学院路', 4);
insert into STREET (ID, NAME, DISTRICT_ID) values (4, '朝阳路', 6);
commit;

insert into HOUSE values (1,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE_PICTURE values (1,1,'','');
commit;











------------------------------考试项目





drop table EDOC_CATEGORY;
drop table EDOC_ENTRY;

create table EDOC_CATEGORY (

    id number(10),
    name varchar2(10) not null

);
create table EDOC_ENTRY(
    id number(10),
    categoryid number(10) not null,
    title varchar2(100) not null,
    summary varchar(255),
    uploaduser varchar(50),
    createdate date not null
);
--alter table HOUSE_PICTURE
 -- add constraint HOUSE_PICTURE_REF_HOUSE foreign key (HOUSE_ID)
  --references HOUSE (ID);
alter table EDOC_CATEGORY add constraint  EDOC_CATEGORY_PRI primary key(ID);
alter table EDOC_ENTRY add constraint EDOC_ENTRY_FOR foreign key(CATEGORYID) references EDOC_CATEGORY(ID);
commit;
create sequence EDOC_ENTRY_SEQ;
create sequence EDOC_CATE_SEQ;
commit;
insert into EDOC_CATEGORY values( 1,'IT技术');
insert into EDOC_CATEGORY values( 1,'其他技术');
insert into HOUSE values (9,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (10,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (11,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (12,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (13,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (14,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (15,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (16,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (17,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (18,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (19,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (20,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (21,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (22,3,1,'好房出租','精装好房，不看后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);

commit;

insert into HOUSE values (23,3,1,'1好房出租','精装好房，不看14后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (24,3,1,'2好房出租','精装好房，不看13后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (25,3,1,'3好房出租','精装好房，不看12后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (26,3,1,'4好房出租','精装好房，不看11后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (27,3,1,'5好房出租','精装好房，不看10后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (28,3,1,'6好房出租','精装好房，不看9后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (29,3,1,'7好房出租','精装好房，不看8后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (30,3,1,'8好房出租','精装好房，不看7后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (31,3,1,'9好房出租','精装好房，不看6后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (32,3,1,'10好房出租','精装好房，不看5后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (33,3,1,'11好房出租','精装好房，不看4后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (34,3,1,'12好房出租','精装好房，不看3后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (35,3,1,'13好房出租','精装好房，不看2后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
insert into HOUSE values (36,3,1,'14好房出租','精装好房，不看1后悔',500,to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),
to_date('2012-02-02 13:02:40','yyyy-mm-dd hh24:mi:ss'),60.5,'13496659878',1);
commit;









