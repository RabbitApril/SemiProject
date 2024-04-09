------------ SEMI PROJECT DML ------------
---- 대체입력창이 아니라 문자그대로 동작하도록 함. 
SET DEFINE OFF;

------------ TABLE MEMBER INSERT ------------
DESC MEMBER;
--MEM_ID    NOT NULL VARCHAR2(20)  
--MEM_PWD   NOT NULL VARCHAR2(20)  
--MEM_EMAIL NOT NULL VARCHAR2(100) 
--MEM_NICK  NOT NULL VARCHAR2(24)  
--MEM_GRADE NOT NULL CHAR(1)
INSERT INTO MEMBER VALUES ('ampres15','namesies15','ampres1215@naver.com','묘시키','1');
INSERT INTO MEMBER VALUES ('guest1','12345','aaaa@aaaa.com','게스트계정','0');
------------ TABLE BOARD INSERT ------------
DESC NOTICEBOARD;
DESC REVIEWBOARD;
DESC FREEBOARD;
--REVIEW_ID      NOT NULL NUMBER         
--REVIEW_TITLE   NOT NULL VARCHAR2(120)  
--REVIEW_CONTENT NOT NULL VARCHAR2(4000) 
--REVIEW_TIME    NOT NULL TIMESTAMP(6)   
--REVIEW_COUNT   NOT NULL NUMBER         
--REVIEW_GOOD    NOT NULL NUMBER         
--MEM_ID         NOT NULL VARCHAR2(20)   
INSERT INTO FREEBOARD VALUES(SEQ_BOARD_ID, '테스트제목1', '테스트내용1', default, default, 'guest1');

------------ TABLE BOARD_REPLY INSERT ------------
DESC BOARD_REPLY;
DESC REVIEW_REPLY;
--BOARD_REPLY_ID      NOT NULL NUMBER         
--BOARD_ID            NOT NULL NUMBER         
--BOARD_REPLY_CONTENT NOT NULL VARCHAR2(4000) 
--BOARD_REPLY_LOG_IP           VARCHAR2(15)   
--BOARD_REPLY_LEVEL   NOT NULL NUMBER(2)      
--BOARD_REPLY_REF     NOT NULL NUMBER         
--BOARD_REPLY_STEP    NOT NULL NUMBER(3)      
--MEM_ID              NOT NULL VARCHAR2(20)   

------------ TABLE REPORT INSERT ------------
DESC BOARD_REPORT;
DESC REVICEW_REPORT;
DESC REPLY1_REPORT;
DESC REPLY2_REPORT;
--MEM_ID   NOT NULL VARCHAR2(20) 
--BOARD_ID NOT NULL NUMBER       