create table tbl_Todos(
task_id number primary key,
title varchar2(50),
description varchar2(500),
completed varchar2(20),
assigned_Date date,
updated_Date date
);

insert into tbl_Todos(TASK_ID, TITLE, DESCRIPTION, COMPLETED, ASSIGNED_DATE) values(101, 'Create rest api', 'Todos rest api', 'completed', sysdate);

update tbl_Todos set TITLE='create rest api', DESCRIPTION='create rest api with db', COMPLETED='pending', ASSIGNED_DATE=sysdate where TASK_ID=101;

select * from tbl_Todos where TASK_ID=101;
