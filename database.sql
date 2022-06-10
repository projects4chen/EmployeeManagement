# 创建数据库
CREATE DATABASE companydb;

use companydb;

# 创建人员表
CREATE TABLE admin(
                      username VARCHAR(20) PRIMARY KEY NOT NULL,
                      password VARCHAR(20) NOT NULL,
                      phone VARCHAR(11) NOT NULL,
                      address VARCHAR(20) NOT NULL
) CHARSET=utf8;

INSERT INTO admin(username, password, phone, address)
VALUES('tom', '123456', '12312341234', 'earth');
INSERT INTO admin(username, password, phone, address)
VALUES('anny', '234567', '12323452345', 'earth');

SELECT * FROM admin;

# 创建管理员表
CREATE TABLE manager(
                        username VARCHAR(20) PRIMARY KEY,
                        password VARCHAR(20) NOT NULL
)CHARSET=utf8mb4;

INSERT INTO manager(username, password)
VALUES('jack', '123456');

SELECT * FROM 	manager;



