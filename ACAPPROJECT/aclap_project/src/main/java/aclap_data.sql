

--------------------------DB (table)--------------------------
--DB는 각자 컴퓨터에 각자 만드세여--
--------------------------member--------------------------
DROP TABLE ACLAPMEMBER
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_MEMBER;

CREATE TABLE ACLAPMEMBER(
    MEMNUM NUMBER PRIMARY KEY,
    EMAIL VARCHAR2(50) NOT NULL UNIQUE,
    PWD VARCHAR2(50) NOT NULL,
    USERNAME VARCHAR2(50) NOT NULL UNIQUE,
    NICKNAME VARCHAR2(50) NOT NULL,
    PHONENUM VARCHAR2(50) NULL,
    INTEREST1 VARCHAR2(50) NULL,
    INTEREST2 VARCHAR2(50) NULL,
    INTEREST3 VARCHAR2(50) NULL,
    PROFILEPIC VARCHAR2(50) NULL,
    AUTH NUMBER(1) NOT NULL,
    CLASSMASTER NUMBER(1) NOT NULL,
    MYPOINT NUMBER NOT NULL
);

CREATE SEQUENCE SEQ_MEMBER
START WITH 1
INCREMENT BY 1;



--------------------------onedayClass--------------------------
DROP TABLE ONEDAYCLASS
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_CLASS;

CREATE TABLE ONEDAYCLASS(
    CLASSNUM NUMBER PRIMARY KEY,
    INSTRUCTOR VARCHAR2(50) NOT NULL,
    PRIMARYCATEGORY VARCHAR2(50) NOT NULL,
    SECONDARYCATEGORY VARCHAR2(200) NOT NULL,
    TITLE VARCHAR2(200) NOT NULL,
    CONTENT VARCHAR2(4000) NOT NULL,
    STARTDATE DATE NOT NULL,
    ENDDATE DATE NOT NULL,
    PRICE NUMBER NOT NULL,
    INFOMATION VARCHAR2(500) NOT NULL,
    DURATION VARCHAR2(50) NOT NULL,
    LIMITNUM VARCHAR2(50) NOT NULL,
    PREPARATION VARCHAR2(200) NOT NULL,
    ABOUTME VARCHAR2(1000) NOT NULL,
    IMAGE1 VARCHAR2(50) NOT NULL,
    IMAGE2 VARCHAR2(50) NULL,
    IMAGE3 VARCHAR2(50) NULL,
    IMAGE4 VARCHAR2(50) NULL,
    IMAGE5 VARCHAR2(50) NULL,
    LOCATION VARCHAR2(100) NOT NULL,
    YOUTUBELINKE VARCHAR2(200) NULL,
    LIKECOUNT NUMBER(38) NOT NULL,
    DEL NUMBER(1) NOT NULL,
    OLDREGNUM NUMBER NOT NULL,
    NEWREGNUM NUMBER NOT NULL
);

CREATE SEQUENCE SEQ_CLASS
START WITH 1
INCREMENT BY 1;


--------------------------likes--------------------------
DROP TABLE LIKES
CASCADE CONSTRAINTS;

CREATE TABLE LIKES(
    MEMNUM NUMBER,
    CLASSNUM NUMBER,
    FOREIGN KEY (MEMNUM) REFERENCES ACLAPMEMBER(MEMNUM),
    FOREIGN KEY (CLASSNUM) REFERENCES ONEDAYCLASS(CLASSNUM)
);

--------------------------review--------------------------
DROP TABLE REVIEW
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_REVIEW;

CREATE TABLE REVIEW(
    REVIEWSEQ NUMBER PRIMARY KEY,
    CLASSNUM NUMBER,
    STARPOINT NUMBER NOT NULL,
    RCONTENT VARCHAR2(4000) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    CLEANNESS NUMBER(3) NOT NULL,
    SATISFY NUMBER(3) NOT NULL,
    RCOMM NUMBER(3) NOT NULL,
    RLOCATION NUMBER(3) NOT NULL,
    ACCURACY NUMBER(3) NOT NULL,
    DEL NUMBER(1) NOT NULL,
    FOREIGN KEY (CLASSNUM) REFERENCES ONEDAYCLASS(CLASSNUM)
);

CREATE SEQUENCE SEQ_REVIEW
START WITH 1
INCREMENT BY 1;

--------------------------schedule--------------------------
DROP TABLE SCHEDULE
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_SCHEDULE;

CREATE TABLE SCHEDULE(
    RDATE DATE NOT NULL,
    SCHEDULENUM NUMBER PRIMARY KEY,
    NAME VARCHAR2(50) NOT NULL,
    CLASSNUM NUMBER,
    DEL NUMBER(1) NOT NULL,
    FOREIGN KEY (CLASSNUM) REFERENCES ONEDAYCLASS(CLASSNUM)
);
CREATE SEQUENCE SEQ_SCHEDULE
START WITH 1
INCREMENT BY 1;

--------------------------receipt--------------------------
DROP TABLE RECEIPT
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_RECEIPT;

CREATE TABLE RECEIPT(
    RECEIPTNUM NUMBER PRIMARY KEY,
    NAME VARCHAR2(50) NOT NULL,
    PRICE NUMBER NOT NULL,
    WDATE DATE NOT NULL,
    CLASSNUM NUMBER,
    MEMNUM NUMBER,
    DEL NUMBER(1) NOT NULL,
    FOREIGN KEY (MEMNUM) REFERENCES ACLAPMEMBER(MEMNUM),
    FOREIGN KEY (CLASSNUM) REFERENCES ONEDAYCLASS(CLASSNUM)
);
CREATE SEQUENCE SEQ_RECEIPT
START WITH 1
INCREMENT BY 1;

--------------------------noticeBbs--------------------------
DROP TABLE NOTICEBBS
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_NOTICEBBS;

CREATE TABLE NOTICEBBS(
    NOTICENUM NUMBER PRIMARY KEY,
    MEMNUM NUMBER,
    NTITLE VARCHAR2(50) NOT NULL,
    NCONTENT VARCHAR2(4000) NULL,
    WDATE DATE NOT NULL,
    NIMG VARCHAR2(50) NULL,
    DEL NUMBER(1) NOT NULL,
    ANSWER NUMBER(1) NOT NULL,
    FOREIGN KEY (MEMNUM) REFERENCES ACLAPMEMBER(MEMNUM)
);

CREATE SEQUENCE SEQ_NOTICEBBS
START WITH 1
INCREMENT BY 1;

---------------------------MYSTAMP TABLE--------------------------

DROP TABLE MYSTAMP
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_MYSTAMP;

CREATE TABLE MYSTAMP(
    MYSTAMPNUM NUMBER PRIMARY KEY,
    MEMNUM NUMBER,
    CLASSNUM NUMBER,
    PRIMARYCATEGORY VARCHAR2(50) NOT NULL,
    SECONDARYCATEGORY VARCHAR2(200) NOT NULL,
    TITLE VARCHAR2(200) NOT NULL,
    FOREIGN KEY (MEMNUM) REFERENCES ACLAPMEMBER(MEMNUM),
    FOREIGN KEY (CLASSNUM) REFERENCES ONEDAYCLASS(CLASSNUM)
);


CREATE SEQUENCE SEQ_MYSTAMP
START WITH 1
INCREMENT BY 1;

----------------------------------------------------




