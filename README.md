# 미니프로젝트 humancloud - 이력서 관리 웹 사이트

### DB - user생성 및 권한 부여
```sql
CREATE USER 'human'@'%' IDENTIFIED BY 'human1234';
CREATE database humandb;
GRANT ALL PRIVILEGES ON *.* TO 'human'@'%';
```

### 테이블 생성
```sql
-- 구직자(유저) 
CREATE TABLE user (
	user_id int auto_increment PRIMARY KEY,
	user_username VARCHAR(50) UNIQUE NOT null,
	user_password VARCHAR(50) NOT null,
	user_name VARCHAR(50),
	user_email VARCHAR(120) UNIQUE NOT null,
	user_phone_number VARCHAR(100) UNIQUE NOT null,
	user_category VARCHAR(80)
	user_created_at TIMESTAMP
);

-- 구직자-분야 관계 테이블
CREATE TABLE user_category(
	user_category_id INT AUTO_INCREMENT PRIMARY KEY,
	user_category_category_id INT NOT NULL,
	user_category_user_id NOT NULL 
);

-- 분야
CREATE TABLE category (
	category_id int auto_increment PRIMARY KEY,
	category_name VARCHAR(50) UNIQUE NOT NULL
);

-- 회사-분야 관계 테이블
CREATE TABLE company_category(
	company_category_id INT AUTO_INCREMENT PRIMARY KEY,
	company_category_category_id INT NOT NULL,
	company_category_company_id NOT NULL 
);

-- 회사 
CREATE TABLE company (
	company_id INT auto_increment PRIMARY KEY,
	company_username VARCHAR(50) UNIQUE NOT null,
	company_password VARCHAR(50) NOT null,
	company_name VARCHAR(50) UNIQUE NOT null,
	company_email VARCHAR(120) UNIQUE NOT null,
	company_phone_number VARCHAR(100) NOT null,
	company_address VARCHAR(150) NOT null,
	company_category VARCHAR(80)
	company_created_at TimeStamp
);

-- 이력서 
CREATE TABLE resume(
	resume_id INT AUTO_INCREMENT PRIMARY KEY,
	resume_education VARCHAR(50),
	resume_career VARCHAR(50),
	resume_photo VARCHAR(500),
	resume_job VARCHAR(50) NOT null,
	resume_link VARCHAR(500), 
	resume_user_id INT,
	resume_readcount INT,
	resume_created_at TIMESTAMP
);

-- 이력서-직무 관계 테이블
CREATE TABLE resume_job(
	resume_job_id INT AUTO_INCREMENT PRIMARY KEY,
	resume_job_job_id INT NOT NULL,
	resume_job_resume_id INT NOT NULL 
);

-- 직무
CREATE TABLE job(
	job_id INT AUTO_INCREMENT PRIMARY KEY,
	job_name VARCHAR(50) UNIQUE NOT NULL
);

-- 공고-직무 관계 테이블
CREATE TABLE recruit_job(
	recruit_job_id INT AUTO_INCREMENT PRIMARY KEY,
	recruit_job_job_id INT NOT NULL,
	recruit_job_recruit_id INT NOT NULL 
);

-- 채용 공고 
CREATE TABLE recruit(
	recruit_id int auto_increment PRIMARY KEY,
	recruit_title VARCHAR(50) NOT NULL,
	recruit_career LONGTEXT,
	recruit_pattern VARCHAR(20),
	recruit_salary INT,
	recruit_job VARCHAR(50),
	recruit_location VARCHAR(120),
	recruit_content LONGTEXT,
	recruit_company_id INT,
	recruit_readcount INT,
	recruit_created_at TIMESTAMP
);

-- 채용 지원 
CREATE TABLE apply(
	apply_id INT AUTO_INCREMENT PRIMARY KEY,
	apply_recruit_id INT, 
	apply_resume_id INT, 
	apply_created_at TIMESTAMP
);

-- 게시판 
CREATE TABLE board(
	board_id INT AUTO_INCREMENT PRIMARY KEY,
	board_user_id INT,
	board_title VARCHAR(50) NOT null,
	board_content LONGTEXT,
	board_file VARCHAR(500),
	board_readcount INT, 
	board_created_at TIMESTAMP
);

-- 댓글 
CREATE TABLE comment(
	comment_id int AUTO_INCREMENT PRIMARY KEY,
	comment_content LONGTEXT,
	comment_user_id INT,
	comment_board_id int,
	comment_created_at TIMESTAMP
);

-- 관심 기업 구독
CREATE TABLE subscribe(
	subscribe_id int auto_increment PRIMARY KEY,
	subscribe_user_id INT,
	subscribe_company_id INT,
	subscribe_created_at TIMESTAMP
);

-- 게시글에 대한 추천(좋아요)
CREATE TABLE likes(
	likes_id INT AUTO_INCREMENT PRIMARY KEY,
	likes_board_id INT,
	likes_user_id INT,
	likes_created_at TIMESTAMP
);

-- 1:1 채팅 테이블
CREATE TABLE chatting(
	chatting_id INT AUTO_INCREMENT PRIMARY KEY,
	chatting_user_id INT NOT NULL,
	chatting_content LONGTEXT NOT NULL,
	chatting_created_at TIMESTAMP
);
```

### fk 제약조건
```sql
-- 구직자-분야 관계 테이블 fk
ALTER TABLE resume ADD FOREIGN KEY(user_category_category_id) REFERENCES category(category_id);
ALTER TABLE resume ADD FOREIGN KEY(user_category_user_id) REFERENCES user(user_id);

-- 회사-분야 관계 테이블 fk
ALTER TABLE resume ADD FOREIGN KEY(company_category_category_id) REFERENCES category(category_id);
ALTER TABLE resume ADD FOREIGN KEY(company_category_company_id) REFERENCES user(user_id);

-- 이력서 테이블 fk
ALTER TABLE resume ADD FOREIGN KEY(resume_user_id) REFERENCES user(user_id);

-- 이력서-직무 관계 테이블 fk
ALTER TABLE resume_job ADD FOREIGN KEY(resume_job_id) REFERENCES job(job_id);
ALTER TABLE resume_job ADD FOREIGN KEY(resume_job_resume_id) REFERENCES resume(resume_id);

-- 공고-직무 관계 테이블 fk
ALTER TABLE recruit_job ADD FOREIGN KEY(recruit_job_job_id) REFERENCES job(job_id);
ALTER TABLE recruit_job ADD FOREIGN KEY(recruit_job_recruit_id) REFERENCES recruit(recruit_id);

-- 채용 공고 테이블 fk
ALTER TABLE recruit ADD FOREIGN KEY(recruit_company_id) REFERENCES company(company_id);

-- 채용 지원 테이블 fk
ALTER TABLE apply ADD FOREIGN KEY(apply_recruit_id) REFERENCES recruit(recruit_id);
ALTER TABLE apply ADD FOREIGN KEY(apply_resume_id) REFERENCES resume(resume_id);

-- 게시판 테이블 fk
ALTER TABLE board ADD FOREIGN KEY(board_user_id) REFERENCES user(user_id);

-- 댓글 테이블 fk
ALTER TABLE comment ADD FOREIGN KEY(comment_user_id) REFERENCES user(user_id);
ALTER TABLE comment ADD FOREIGN KEY(comment_board_id) REFERENCES board(board_id);

-- 관심 기업 구독 테이블 fk
ALTER TABLE comment ADD FOREIGN KEY(subscribe_user_id) REFERENCES user(user_id);
ALTER TABLE comment ADD FOREIGN KEY(subscribe_company_id) REFERENCES company(company_id);

-- 게시글 추천(좋아요) 테이블 fk
ALTER TABLE comment ADD FOREIGN KEY(likes_board_id) REFERENCES board(board_id);
ALTER TABLE comment ADD FOREIGN KEY(likes_user_id) REFERENCES user(user_id);

-- 1:1 채팅 테이블 fk
ALTER TABLE comment ADD FOREIGN KEY(chatting_user_id) REFERENCES user(user_id);
```