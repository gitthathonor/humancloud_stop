# 미니프로젝트 humancloud - 이력서 관리 웹 사이트

### DB - user생성 및 권한 부여
```sql
CREATE USER 'human'@'%' IDENTIFIED BY 'human1234';
CREATE database humandb;
GRANT ALL PRIVILEGES ON *.* TO 'human'@'%';
```