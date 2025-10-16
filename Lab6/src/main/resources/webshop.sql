﻿
CREATE DATABASE WebShop;
GO

USE WebShop;
GO


CREATE TABLE Accounts (
	username NVARCHAR(50) PRIMARY KEY,
	password NVARCHAR(50) NOT NULL,
	fullname NVARCHAR(100) NOT NULL,
	email NVARCHAR(100),
	photo NVARCHAR(100),
	activated BIT DEFAULT 1,
	admin BIT DEFAULT 0
);
GO

CREATE TABLE Categories (
	id NVARCHAR(10) PRIMARY KEY,
	name NVARCHAR(100) NOT NULL
);
GO


CREATE TABLE Products (
	id INT IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(100) NOT NULL,
	image NVARCHAR(200),
	price FLOAT NOT NULL,
	createdate DATE DEFAULT GETDATE(),
	available BIT DEFAULT 1,
	categoryid NVARCHAR(10) REFERENCES Categories(id)
);
GO

CREATE TABLE Orders (
	id BIGINT IDENTITY(1,1) PRIMARY KEY,
	username NVARCHAR(50) REFERENCES Accounts(username),
	address NVARCHAR(200),
	createdate DATE DEFAULT GETDATE()
);
GO


CREATE TABLE OrderDetails (
	id BIGINT IDENTITY(1,1) PRIMARY KEY,
	orderid BIGINT REFERENCES Orders(id),
	productid INT REFERENCES Products(id),
	price FLOAT NOT NULL,
	quantity INT NOT NULL
);
GO


INSERT INTO Accounts (username, password, fullname, email, photo, activated, admin)
VALUES
('poly', '123', N'Sinh viên FPT Poly', 'poly@example.com', 'poly.jpg', 1, 1),
('user1', '123', N'Nguyễn Văn A', 'a@gmail.com', 'a.jpg', 1, 0),
('user2', '123', N'Lê Thị B', 'b@gmail.com', 'b.jpg', 1, 0);

-- Categories
INSERT INTO Categories (id, name)
VALUES
('C01', N'Trà sữa'),
('C02', N'Đồ ăn vặt'),
('C03', N'Bánh ngọt');

-- Products
INSERT INTO Products (name, image, price, categoryid)
VALUES
(N'Trà sữa truyền thống', 'tra-sua.jpg', 30000, 'C01'),
(N'Trà sữa matcha', 'matcha.jpg', 35000, 'C01'),
(N'Khoai tây chiên', 'khoai-tay.jpg', 25000, 'C02'),
(N'Bánh su kem', 'banh-su.jpg', 20000, 'C03'),
(N'Bánh donut', 'donut.jpg', 25000, 'C03');
INSERT INTO Products (name, image, price, categoryid)
VALUES
-- 🍹 Nhóm Trà sữa (C01)
(N'Trà sữa socola', 'tra-sua-socola.jpg', 35000, 'C01'),
(N'Trà sữa dâu', 'tra-sua-dau.jpg', 35000, 'C01'),
(N'Trà sữa bạc hà', 'tra-sua-bac-ha.jpg', 40000, 'C01'),
(N'Trà sữa caramel', 'tra-sua-caramel.jpg', 40000, 'C01'),
(N'Trà sữa khoai môn', 'tra-sua-khoai-mon.jpg', 35000, 'C01'),

-- 🍟 Nhóm đồ ăn vặt (C02)
(N'Khoai tây phô mai', 'khoai-tay-pho-mai.jpg', 35000, 'C02'),
(N'Khoai lang kén', 'khoai-lang-ken.jpg', 40000, 'C02'),

-- 🍰 Nhóm bánh ngọt (C03)
(N'Bánh su kem socola', 'banh-su-socola.jpg', 35000, 'C03'),
(N'Bánh tiramisu', 'banh-tiramisu.jpg', 40000, 'C03'),
(N'Bánh mochi trà xanh', 'banh-mochi-matcha.jpg', 40000, 'C03');

-- Orders
INSERT INTO Orders (username, address)
VALUES
('poly', N'Hồ Chí Minh'),
('user1', N'Hà Nội');

-- OrderDetails
INSERT INTO OrderDetails (orderid, productid, price, quantity)
VALUES
(1, 1, 30000, 2),
(1, 3, 25000, 1),
(2, 5, 25000, 3);
GO

-- ============================================
-- ✅ KIỂM TRA
-- ============================================
SELECT * FROM Accounts;
SELECT * FROM Categories;
SELECT * FROM Products;
SELECT * FROM Orders;
SELECT * FROM OrderDetails;
GO
