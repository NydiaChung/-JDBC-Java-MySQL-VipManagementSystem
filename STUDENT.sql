create table student(
	vipid integer(12),
	stuname char(10) not null,
	sex enum('±£ÃÜ','Å®','ÄĞ') not null default '±£ÃÜ',
	college char(50) not null,
	grade integer(4) not null,
	stuid integer(12) primary key,
	tele integer(11),
	qq integer(12),
	note char(100)

);