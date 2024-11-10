-- 检查数据库是否存在，如果存在则删除
DROP DATABASE IF EXISTS protect_animal;

-- 创建数据库
CREATE DATABASE protect_animal;

-- 使用数据库
USE protect_animal;

-- 创建animal_users表
CREATE TABLE animal_users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- 插入数据到animal_users表
INSERT INTO animal_users (name, number, email, password) VALUES
('丽娜', '13800138000', 'lina@qq.com', 'linapassword'),
('陈可', '13900139000', 'chenke@qq.com', 'chenkepass'),
('韩梅梅', '13700137000', 'hanmei@qq.com', 'hanmei123'),
('李雷', '13500135000', 'lilei@qq.com', 'lipassword'),
('赵四', '13400134000', 'zhaosi@qq.com', 'zhaosi456');

-- 创建message表
CREATE TABLE message (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL
);

--插入数据到message表
INSERT INTO message (content) VALUES
('感谢协会为动物们所做的一切。你们的坚持和热情是我学习的榜样'),
('每一只动物都值得被爱，协会真棒！'),
('协会的努力让我相信，每一个生命都重要。我会尽我所能支持你们的工作。'),
('每次看到协会的更新，我都感到温暖。你们的工作让这个世界变得更美好。'),
('让我们携手，为动物创造一个更安全、更温暖的世界。');

--创建administrator表
CREATE TABLE administrator (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL
);

--插入数据到administrator表
INSERT INTO administrator (name, number, email, password, position)
VALUES 
('张晨曦', '13400123456', 'wang@qq.com', 'pass123', '部长'),
('李思远', '13400234567', 'lisiyuan@example.com', 'password456', '副部长'),
('赵雅楠', '13400345678', 'zhaoyanan@example.com', 'password789', '技术组组长');

--创建attendance表
CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL,
    inorout ENUM('in', 'out') NOT NULL
);

--插入数据到attendance表
INSERT INTO Attendance (number, name, position, inorout)
VALUES 
('13400123456', '张晨曦', '部长', 'in'),
('13400234567', '李思远', '副部长', 'in'),
('13400345678', '赵雅楠', '技术组组长', 'in'),
('13400456789', '王小明', '技术组副组长', 'in'),
('13400567890', '李华', '运营主管', 'out');

--创建animal表
CREATE TABLE animal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    area VARCHAR(255) NOT NULL,
    situation VARCHAR(255) NOT NULL
);

--插入数据到animal表
INSERT INTO animal (name, type, area, situation) VALUES
('旺财', '犬', 'A区', '健康'),
('小花', '猫', 'B区', '健康'),
('小黑', '犬', 'B区', '生病'),
('球球', '猫', 'D区', '健康'),
('豆豆', '兔', 'E区', '健康');

--创建activity表
CREATE TABLE activity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    program VARCHAR(255) NOT NULL,
    manager VARCHAR(255) NOT NULL
);

--插入数据到activity表
INSERT INTO activity (name, program, manager) VALUES
('国庆出游', '国庆带着小家伙们出游', '张晨曦'),
('逍遥圣诞', '带着小动物们，深入社区送温暖', '李思远'),
('春节快乐', '部门聚会，带着动物去巴黎', '张晨曦');
