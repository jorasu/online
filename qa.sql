create table questions
(
	id int(32) auto_increment comment '问题 id'
		primary key,
	title varchar(32) not null comment '问题名',
	detailDesc varchar(32) null comment '问题描述',
	answerCount int(32) not null comment '回答次数',
	lastModified date not null comment '最后修改时间'
)
comment '问题表'
;

create table answers
(
	id int(32) auto_increment comment '问题 id'
		primary key,
	ansContent varchar(32) not null comment '答案内容',
	ansDate date not null comment '回答时间',
	qid int(32) not null comment '问题 id',
	constraint answers_ibfk_1
	foreign key (id) references test.questions (id)
)
	comment '应答表'
;

INSERT INTO test.answers (ansContent, ansDate, qid) VALUES ('夫子庙', '2019-06-05', 1);
INSERT INTO test.answers (ansContent, ansDate, qid) VALUES ('北大青鸟', '2019-06-05', 2);
INSERT INTO test.answers (ansContent, ansDate, qid) VALUES ('丫丫吃老虎', '2019-06-06', 3);

INSERT INTO test.questions (title, detailDesc, answerCount, lastModified) VALUES ('南京有什么好玩的地方', null, 1, '2019-06-03');
INSERT INTO test.questions (title, detailDesc, answerCount, lastModified) VALUES ('什么是面向对象？', null, 0, '2018-06-08');
INSERT INTO test.questions (title, detailDesc, answerCount, lastModified) VALUES ('帮忙找一首歌', null, 5, '2018-06-09');
INSERT INTO test.questions (title, detailDesc, answerCount, lastModified) VALUES ('Java好学么？', null, 0, '2018-06-07');
INSERT INTO test.questions (title, detailDesc, answerCount, lastModified) VALUES ('十一是什么？', null, 0, '2018-06-08');