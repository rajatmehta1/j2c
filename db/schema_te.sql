#telugu schema
use j2c;
-- hindi questions
  CREATE TABLE q_all_te (
     qid INT UNSIGNED NOT NULL AUTO_INCREMENT,
     q_text TEXT NOT NULL,
     topic_id INT,
     tag_ids VARCHAR(255), -- comma separated tag ids
     created_by INT,
     updated_by VARCHAR(25),
     update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     is_active CHAR(1) NOT NULL,
     q_link TEXT NULL,
     PRIMARY KEY  (qid)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- hindi answers
    CREATE TABLE a_all_te (
     aid INT UNSIGNED NOT NULL AUTO_INCREMENT,
     qid INT,
     a_text TEXT NOT NULL,
     created_by INT,
     updated_by VARCHAR(25),
     update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     is_active CHAR(1) NOT NULL,
     PRIMARY KEY  (aid)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


  CREATE TABLE topics_te (
     topic_id INT UNSIGNED NOT NULL,
     topic_name VARCHAR(255) NOT NULL,
     topic_desc VARCHAR(255),
     topic_lang VARCHAR(5),
     PRIMARY KEY  (topic_id)
  );

insert into topics_te(topic_id,topic_name,topic_lang) value(1,'Diabetes','te');
insert into topics_te(topic_id,topic_name,topic_lang) value(2,'Pregnancy','te');
insert into topics_te(topic_id,topic_name,topic_lang) value(3,'General Health','te');
insert into topics_te(topic_id,topic_name,topic_lang) value(4,'Mental Health','te');
insert into topics_te(topic_id,topic_name,topic_lang) value(5,'Heart Disease','te');
insert into topics_te(topic_id,topic_name,topic_lang) value(6,'Lungs Disease','te');


  -- Category
  CREATE TABLE sub_topics_te (
     stopic_id INT UNSIGNED NOT NULL,
     stopic_name VARCHAR(255) NOT NULL,
     stopic_desc VARCHAR(255),
     topic_id INT,
     topic_lang VARCHAR(5),
     PRIMARY KEY  (stopic_id)
  );


insert into sub_topics_te(stopic_id,stopic_name,topic_id,topic_lang) value(1,'Diabetes_general',1,'te');
insert into sub_topics_te(stopic_id,stopic_name,topic_id,topic_lang) value(2,'Diabetes_Type1',1,'te');
insert into sub_topics_te(stopic_id,stopic_name,topic_id,topic_lang) value(3,'Diabetes_Type2',1,'te');


