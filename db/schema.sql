drop database j2c
create database j2c
use j2c;

  CREATE TABLE q_all (
     qid INT UNSIGNED NOT NULL AUTO_INCREMENT,
     q_text TEXT NOT NULL,
     topic_id INT,
     tag_ids VARCHAR(255), -- comma separated tag ids
     created_by INT,
     updated_by VARCHAR(25),
     update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     is_active CHAR(1) NOT NULL,
     PRIMARY KEY  (qid)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    CREATE TABLE a_all (
     aid INT UNSIGNED NOT NULL AUTO_INCREMENT,
     qid INT,
     a_text TEXT NOT NULL,
     created_by INT,
     updated_by VARCHAR(25),
     update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     is_active CHAR(1) NOT NULL,
     PRIMARY KEY  (aid)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  CREATE TABLE users (
     user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
     pwd VARCHAR(10) NULL,
     email VARCHAR(255) NULL,
     update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     is_active CHAR(1) NOT NULL,
     primary key(user_id)
  );


  CREATE TABLE q_comments (
     comment_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
     qid INT NOT NULL,
     comment TEXT NOT NULL,
     updated_by VARCHAR(25),
     update_time DATE,
     PRIMARY KEY  (comment_id)
  );


  CREATE TABLE topics (
     topic_id INT UNSIGNED NOT NULL,
     topic_name VARCHAR(255) NOT NULL,
     topic_desc VARCHAR(255),
     PRIMARY KEY  (topic_id)
  );

insert into topics(topic_id,topic_name) value(1,'Diabetes');
insert into topics(topic_id,topic_name) value(2,'Pregnancy');
insert into topics(topic_id,topic_name) value(3,'General Health');
insert into topics(topic_id,topic_name) value(4,'Mental Health');
insert into topics(topic_id,topic_name) value(5,'Heart Disease');
insert into topics(topic_id,topic_name) value(6,'Lungs Disease');


  -- Category
  CREATE TABLE sub_topics (
     stopic_id INT UNSIGNED NOT NULL,
     stopic_name VARCHAR(255) NOT NULL,
     stopic_desc VARCHAR(255),
     topic_id INT,
     PRIMARY KEY  (stopic_id)
  );


insert into sub_topics(stopic_id,stopic_name,topic_id) value(1,'Diabetes_general',1);
insert into sub_topics(stopic_id,stopic_name,topic_id) value(2,'Diabetes_Type1',1);
insert into sub_topics(stopic_id,stopic_name,topic_id) value(3,'Diabetes_Type2',1);


