use master
go
create database STATIONERYv2
GO
use STATIONERYv2
go
CREATE TABLE [dbo].[_User](
	[_id] int IDENTITY(1,1) NOT NULL primary key,
	[firstname] nvarchar(32) NOT NULL,
	[lastname] nvarchar(32) NOT NULL,
	[slug] nvarchar(100) NULL,
	[id_card] varchar(50) NULL,
	[email] varchar(100) NULL,
	[phone] varchar(20) NULL,
	[isEmalActive] bit NULL,
	[isPhoneActive] bit NULL,
	[salt] varchar(max) NULL,
	[hashed_password] varchar(max) NOT NULL,
	[_role] varchar(10) NULL,
	[addresses] nvarchar(200) NULL,
	[avatar] nvarchar(500) NULL,
	[cover] nvarchar(500) NULL,
	[point] int NULL,
	[e_wallet] decimal(10, 4) NULL,
	[createdAt] datetime NULL,
	[updatedAt] datetime NULL,
)
GO
CREATE TABLE [dbo].[UserLevel](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[_name] nvarchar(32) NOT NULL,
	[minPoint] int NOT NULL,
	[discount] decimal(4, 2) NOT NULL,
	[isDeleted] bit NULL,
	[createdAt] datetime NULL,
	[updatedAt] datetime NULL
)
GO
CREATE TABLE [dbo].[Store](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[_name] nvarchar(100) NOT NULL,
	[bio] nvarchar(1000) NOT NULL,
	[slug] nvarchar(100) NULL,
	[ownerId] int references _User(_id) NULL,
	[isActive] bit NULL,
	[isOpen] bit NULL,
	[avatar] nvarchar(500) NULL,
	[cover] nvarchar(500) NULL,
	[featured_images] nvarchar(500) NULL,
	[commissionId] int NULL,
	[point] int NULL,
	[rating] int NULL,
	[e_wallet] decimal(10, 4) NULL,
	[createdAt] datetime NULL,
	[updatedAt] datetime NULL
)
GO
CREATE TABLE [dbo].[StoreLevel](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[_name] nvarchar(32) NOT NULL,
	[minPoint] int NOT NULL,
	[discount] decimal(4, 2) NOT NULL,
	[isDeleted] bit NULL,
	[createdAt] datetime NULL,
	[updatedAt] datetime NULL
)
GO
CREATE TABLE [dbo].[Commission](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[_name] nvarchar(32) NOT NULL,
	[cost] decimal(10, 4) NOT NULL,
	[_description] nvarchar(3000) NOT NULL,
	[isDeleted] bit NULL,
	[createdAt] datetime NULL,
	[updatedAt] datetime NULL
)
GO
CREATE TABLE [dbo].[Category](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[_name] nvarchar(32) NOT NULL,
	[slug] nvarchar(100) NULL,
	[categoryId] int references Category(_id) NULL,
	[_image] nvarchar(500) NULL,
	[isDeleted] bit NULL,
	[createdAt] date NULL,
	[updatedAt] date NULL
)
GO
CREATE TABLE [dbo].[Style](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[name] nvarchar(32) NOT NULL,
	[categoryId] int references Category(_id) NULL,
	[image] nvarchar(100) NULL,
	[isDeleted] bit NULL,
	[createdAt] date NULL,
	[updatedAt] date NULL
)
GO
CREATE TABLE [dbo].[StyleValue](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[name] nvarchar(32) NOT NULL,
	[styleId] int references Style(_id) NULL,
	[isDeleted] bit NULL,
	[createdAt] date NULL,
	[updatedAt] date NULL
)
GO
CREATE TABLE [dbo].[Product](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[name] nvarchar(100) NOT NULL,
	[slug] nvarchar(110) NULL,
	[description] nvarchar(1000) NOT NULL,
	[price] decimal(18, 0) NOT NULL,
	[promotionalPrice] decimal(18, 0) NOT NULL,
	[quantity] int NOT NULL,
	[sold] int NOT NULL,
	[isActive] bit NULL,
	[isSelling] bit NULL,
	[categoryId] int references Category(_id) NULL,
	[storeId] int references Store(_id) NULL,
	[isDeleted] bit NULL,
	[rating] int NULL,
	[createdAt] date NULL,
	[updatedAt] date NULL
)
GO
CREATE TABLE [dbo].[Delivery](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[name] nvarchar(100) NOT NULL,
	[description] nvarchar(1000) NOT NULL,
	[price] decimal(18, 0) NOT NULL,
	[isDeleted] bit NULL,
	[createdAt] date NULL,
	[updatedAt] date NULL
)
GO
CREATE TABLE [dbo].[UserFollowStore](
	[_id] int IDENTITY(1,1) NOT NULL,
	[userId] int references _User(_id) NOT NULL,
	[storeId] int references Store(_id) NOT NULL,
	[createdAt] date NULL,
	[updatedAt] date NULL
)
GO
CREATE TABLE [dbo].[UserFollowProduct](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[userId] int references _User(_id) NOT NULL,
	[productId] int references Product(_id) NOT NULL,
	[createdAt] date NULL,
	[updatedAt] date NULL
)
GO
CREATE TABLE [dbo].[_Order](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[userId] int references _User(_id) NULL,
	[storeId] int references Store(_id) NULL,
	[deliveryId] int references Delivery(_id) NULL,
	[commissionId] int references Commission(_id) NULL,
	[address] nvarchar(255) NOT NULL,
	[phone] int NOT NULL,
	[status] nvarchar(255) NOT NULL,
	[isPaidBefore] bit NULL,
	[amountFromUser] int NULL,
	[amountFromStore] int NULL,
	[amountToStore] int NULL,
	[amountToGD] int NULL,
	[createdAt] date NULL,
	[updatedAT] date NULL
)
GO
CREATE TABLE [dbo].[Review](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[userId] int references _User(_id) NULL,
	[productId] int references Product(_id) NULL,
	[storeId] int references Store(_id) NULL,
	[orderId] int references _Order(_id) NULL,
	[content] nvarchar(255) NULL,
	[stars] int NULL,
	[createdAt] date NULL,
	[updatedAt] date NULL
)

GO
CREATE TABLE [dbo].[OrderItem](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[orderId] int references _Order(_id) NULL,
	[productId] int references Product(_id) NULL,
	[count_SP] int NULL,
	[createdAt] date NULL,
	[updatedAT] date NULL
)
GO
CREATE TABLE [dbo].[Cart](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[userId] int references _User(_id) NULL,
	[storetId] int references Store(_id) NULL,
	[createdAt] date NULL,
	[updatedAT] date NULL
)
GO
CREATE TABLE [dbo].[CartItem](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[cartId] int references Cart(_id) NULL,
	[productId] int references Product(_id) NULL,
	[count_SP] int NOT NULL,
	[createdAt] date NULL,
	[updatedAT] date NULL
)
GO
CREATE TABLE [dbo].[Transaction_SP](
	[_id] int IDENTITY(1,1) primary key NOT NULL,
	[userId] int references _User(_id) NULL,
	[storeId] int references Store(_id) NULL,
	[isUp] bit NOT NULL,
	[amount] int NOT NULL,
	[createdAt] date NULL,
	[updatedAT] date NULL
)
GO
CREATE TABLE [dbo].[CartItem_StyleValue](
	[cartItemId] int references CartItem(_id) NOT NULL,
	[styleValueId] int references StyleValue(_id) NOT NULL
	primary key(cartItemId,styleValueId)
)



GO
CREATE TABLE [dbo].[ListImagesProduct](
	[_id] int primary key NOT NULL,
	[image] nvarchar(100) NULL
)
GO
CREATE TABLE [dbo].[ListImagesStore](
	[_id] int  NULL,
	[featured_image] nvarchar(100) NULL
)

GO
CREATE TABLE [dbo].[OrderItem_StyleValue](
	[orderItemId] int references OrderItem(_id) NOT NULL,
	[styleValueId] int references StyleValue(_id) NOT NULL
	primary key(orderItemId,styleValueId)
)

GO
CREATE TABLE [dbo].[Product_Style](
	[StyleId] int references Style(_id) NOT NULL,
	[ProductId] int references Product(_id) NOT NULL
	primary key(StyleId,ProductId)
)


GO
CREATE TABLE [dbo].[Store_Staff](
	[storeId] int references Store(_id) NOT NULL,
	[staffId] int references _User(_id) NOT NULL
	primary key(storeId,staffId)
)


GO
CREATE TABLE [dbo].[Style_Category](
	[StyleId] int references Style(_id) NOT NULL,
	[CategoryId] int references Category(_id) NOT NULL,
	primary key(StyleId,CategoryId)
)

GO

--_User
SET IDENTITY_INSERT _User ON;  

INSERT INTO _User(_id,firstname,lastname,hashed_password) VALUES(1,N'My',N'Trần',123456);
INSERT INTO _User(_id,firstname,lastname,hashed_password) VALUES(2,N'Quyên',N'Phạm',123456);
INSERT INTO _User(_id,firstname,lastname,hashed_password) VALUES(3,N'Anh',N'Nguyễn',123456);
INSERT INTO _User(_id,firstname,lastname,hashed_password) VALUES(4,N'Duyên',N'Lâm',123456);
INSERT INTO _User(_id,firstname,lastname,hashed_password) VALUES(5,N'Như',N'Nguyễn',123456);
INSERT INTO _User(_id,firstname,lastname,hashed_password) VALUES(6,N'Trinh',N'Phan',123456);
INSERT INTO _User(_id,firstname,lastname,hashed_password) VALUES(7,N'Linh',N'Lê',123456);
INSERT INTO _User(_id,firstname,lastname,hashed_password) VALUES(8,N'Quảng',N'Trần',123456);
INSERT INTO _User(_id,firstname,lastname,hashed_password) VALUES(9,N'Duy',N'Lê',123456);
INSERT INTO _User(_id,firstname,lastname,hashed_password) VALUES(10,N'Mie',N'Mie',123456);

SET IDENTITY_INSERT _User OFF; 

GO

--Store 
SET IDENTITY_INSERT Store ON;  

INSERT INTO Store(_id,_name,bio) VALUES(1,N'Custi',N'Văn phòng phẩm');
SET IDENTITY_INSERT Store OFF;
GO
--Category
SET IDENTITY_INSERT Category ON;  

INSERT INTO Category(_id,_name,categoryId,createdAt,updatedAT) VALUES(1,N'Bút',1,'20220909','20221010')
INSERT INTO Category(_id,_name,categoryId,createdAt,updatedAT) VALUES(2,N'Vở học sinh',1,'20220909','20221010')
INSERT INTO Category(_id,_name,categoryId,createdAt,updatedAT) VALUES(3,N'Sổ ghi chép',1,'20220909','20221010')
INSERT INTO Category(_id,_name,categoryId,createdAt,updatedAT) VALUES(4,N'Bảng',1,'20220909','20221010')
INSERT INTO Category(_id,_name,categoryId,createdAt,updatedAT) VALUES(5,N'File tài liệu',1,'20220909','20221010')
INSERT INTO Category(_id,_name,categoryId,createdAt,updatedAT) VALUES(6,N'Máy tính tay (Casio)',1,'20220909','20221010')
INSERT INTO Category(_id,_name,categoryId,createdAt,updatedAT) VALUES(7,N'Dung cụ đóng dấu',1,'20220909','20221010')
INSERT INTO Category(_id,_name,categoryId,createdAt,updatedAT) VALUES(8,N'Kẹp giấy',1,'20220909','20221010')
INSERT INTO Category(_id,_name,categoryId,createdAt,updatedAT) VALUES(9,N'Đồ bấm lỗ, dây cột',1,'20220909','20221010')
INSERT INTO Category(_id,_name,categoryId,createdAt,updatedAT) VALUES(10,N'Keo dán, băng dính, kéo',1,'20220909','20221010')
SET IDENTITY_INSERT Category OFF; 

GO

--Product
SET IDENTITY_INSERT Product ON;  

INSERT INTO Product(_id,name,description,price,promotionalPrice,quantity,sold,categoryId,createdAt,updatedAT) VALUES(1,N'Bút Deli',N'Gò Vấp','15000','14000',100,20,1,'20220101','20220109')
INSERT INTO Product(_id,name,description,price,promotionalPrice,quantity,sold,categoryId,createdAt,updatedAT) VALUES(2,N'Vở ô li',N'Gò Vấp','15000','14000',100,20,2,'20220101','20220109')
INSERT INTO Product(_id,name,description,price,promotionalPrice,quantity,sold,categoryId,createdAt,updatedAT) VALUES(3,N'Vở Làng Hương',N'Quận 1','5000','4000',100,20,2,'20220101','20220109')
INSERT INTO Product(_id,name,description,price,promotionalPrice,quantity,sold,categoryId,createdAt,updatedAT) VALUES(4,N'Bìa đựng hồ sơ',N'Quận 2','25000','24000',100,20,5,'20220101','20220109')
INSERT INTO Product(_id,name,description,price,promotionalPrice,quantity,sold,categoryId,createdAt,updatedAT) VALUES(5,N'Bút Lông Dầu',N'Quận 3','17000','15000',100,20,1,'20220101','20220109')
INSERT INTO Product(_id,name,description,price,promotionalPrice,quantity,sold,categoryId,createdAt,updatedAT) VALUES(6,N'Sổ Còng',N'Quận 4','65000','50000',100,20,3,'20220101','20220109')
INSERT INTO Product(_id,name,description,price,promotionalPrice,quantity,sold,categoryId,createdAt,updatedAT) VALUES(7,N'Bút Thiên Long',N'Quận 5','6000','5000',100,20,1,'20220101','20220109')
INSERT INTO Product(_id,name,description,price,promotionalPrice,quantity,sold,categoryId,createdAt,updatedAT) VALUES(8,N'Băng keo trong',N'Quận 6','30000','24000',100,20,10,'20220101','20220109')
INSERT INTO Product(_id,name,description,price,promotionalPrice,quantity,sold,categoryId,createdAt,updatedAT) VALUES(9,N'Dao rọc giấy',N'Quận 7','25000','24000',100,20,10,'20220101','20220109')
INSERT INTO Product(_id,name,description,price,promotionalPrice,quantity,sold,categoryId,createdAt,updatedAT) VALUES(10,N'Kim bấm ',N'Quận 8','11000','8000',100,20,8,'20220101','20220109')
SET IDENTITY_INSERT Product OFF;

GO
--Cart
SET IDENTITY_INSERT Cart ON;  

INSERT INTO Cart(_id,userId,createdAt,updatedAT) VALUES(1,1,'20221009','20221001')
INSERT INTO Cart(_id,userId,createdAt,updatedAT) VALUES(2,1,'20220908','20221001')
INSERT INTO Cart(_id,userId,createdAt,updatedAT) VALUES(3,1,'20220907','20221001')
INSERT INTO Cart(_id,userId,createdAt,updatedAT) VALUES(4,2,'20220906','20221001')
INSERT INTO Cart(_id,userId,createdAt,updatedAT) VALUES(5,2,'20220905','20221001')
INSERT INTO Cart(_id,userId,createdAt,updatedAT) VALUES(6,3,'20220904','20221001')
INSERT INTO Cart(_id,userId,createdAt,updatedAT) VALUES(7,3,'20220903','20221001')
INSERT INTO Cart(_id,userId,createdAt,updatedAT) VALUES(8,4,'20220903','20221001')
INSERT INTO Cart(_id,userId,createdAt,updatedAT) VALUES(9,4,'20220902','20221001')
INSERT INTO Cart(_id,userId,createdAt,updatedAT) VALUES(10,5,'20220910','20221001')

SET IDENTITY_INSERT Cart OFF;
GO
--Cartitem
SET IDENTITY_INSERT CartItem ON;  

INSERT INTO CartItem(_id,cartId,productId,count_SP,createdAt,updatedAT) VALUES(1,1,1,100,'20220909','20221001')
INSERT INTO CartItem(_id,cartId,productId,count_SP,createdAt,updatedAT) VALUES(3,2,1,100,'20220909','20221001')
INSERT INTO CartItem(_id,cartId,productId,count_SP,createdAt,updatedAT) VALUES(4,3,2,100,'20220809','20221001')
INSERT INTO CartItem(_id,cartId,productId,count_SP,createdAt,updatedAT) VALUES(5,3,2,100,'20220809','20221001')
INSERT INTO CartItem(_id,cartId,productId,count_SP,createdAt,updatedAT) VALUES(6,3,2,100,'20220809','20221001')
INSERT INTO CartItem(_id,cartId,productId,count_SP,createdAt,updatedAT) VALUES(7,4,3,100,'20220709','20221001')
INSERT INTO CartItem(_id,cartId,productId,count_SP,createdAt,updatedAT) VALUES(8,4,3,100,'20220709','20221001')
INSERT INTO CartItem(_id,cartId,productId,count_SP,createdAt,updatedAT) VALUES(9,5,3,100,'20220709','20221001')
INSERT INTO CartItem(_id,cartId,productId,count_SP,createdAt,updatedAT) VALUES(10,5,4,100,'20220909','20221001')
SET IDENTITY_INSERT CartItem OFF; 

GO

--_Order
SET IDENTITY_INSERT _Order ON;  

INSERT INTO _Order(_id,userId,storeId,address,phone,status,createdAt,updatedAT) VALUES(1,1,1,N'Gò Vấp',0918804237,'0','20221010','20221015')
INSERT INTO _Order(_id,userId,storeId,address,phone,status,createdAt,updatedAT) VALUES(2,1,1,N'Long An',0918845325,'0','20221010','20221015')
INSERT INTO _Order(_id,userId,storeId,address,phone,status,createdAt,updatedAT) VALUES(3,1,1,N'Vĩnh Long',0648831254,'0','20221010','20221015')
INSERT INTO _Order(_id,userId,storeId,address,phone,status,createdAt,updatedAT) VALUES(4,2,1,N'Sóc Trăng',0684421357,'0','20221010','20221015')
INSERT INTO _Order(_id,userId,storeId,address,phone,status,createdAt,updatedAT) VALUES(5,2,1,N'Cần Thơ',0918805237,'0','20221010','20221015')
INSERT INTO _Order(_id,userId,storeId,address,phone,status,createdAt,updatedAT) VALUES(6,2,1,N'Tiền Giang',0947504237,'0','20221010','20221015')
INSERT INTO _Order(_id,userId,storeId,address,phone,status,createdAt,updatedAT) VALUES(7,3,1,N'Bến Tre',0918852237,'0','20221010','20221015')
INSERT INTO _Order(_id,userId,storeId,address,phone,status,createdAt,updatedAT) VALUES(8,3,1,N'Hậu Giang',0918404237,'0','20221010','20221015')
INSERT INTO _Order(_id,userId,storeId,address,phone,status,createdAt,updatedAT) VALUES(9,3,1,N'Kiên Giang',0918804267,'0','20221010','20221015')
INSERT INTO _Order(_id,userId,storeId,address,phone,status,createdAt,updatedAT) VALUES(10,4,1,N'Cà Mau',0918950237,'0','20221010','20221015')
SET IDENTITY_INSERT _Order OFF; 
GO

--OrderItem
SET IDENTITY_INSERT OrderItem ON;  

INSERT INTO OrderItem(_id,orderId,productId,count_SP,createdAt,updatedAT) VALUES(1,1,1,2,'20221011','20221012')
INSERT INTO OrderItem(_id,orderId,productId,count_SP,createdAt,updatedAT) VALUES(2,1,1,2,'20221010','20221013')
INSERT INTO OrderItem(_id,orderId,productId,count_SP,createdAt,updatedAT) VALUES(3,2,1,1,'20221009','20221013')
INSERT INTO OrderItem(_id,orderId,productId,count_SP,createdAt,updatedAT) VALUES(4,2,1,1,'20221008','20221013')
INSERT INTO OrderItem(_id,orderId,productId,count_SP,createdAt,updatedAT) VALUES(5,6,1,1,'20221010','20221014')
INSERT INTO OrderItem(_id,orderId,productId,count_SP,createdAt,updatedAT) VALUES(6,6,1,3,'20221010','20221015')
INSERT INTO OrderItem(_id,orderId,productId,count_SP,createdAt,updatedAT) VALUES(7,7,1,1,'20221011','20221016')
INSERT INTO OrderItem(_id,orderId,productId,count_SP,createdAt,updatedAT) VALUES(8,7,1,8,'20221011','20221012')
INSERT INTO OrderItem(_id,orderId,productId,count_SP,createdAt,updatedAT) VALUES(9,8,1,1,'20221011','20221013')
INSERT INTO OrderItem(_id,orderId,productId,count_SP,createdAt,updatedAT) VALUES(10,8,1,1,'20221011','20221012')
SET IDENTITY_INSERT OrderItem OFF; 
 
GO


--Review
SET IDENTITY_INSERT Review ON;  

INSERT INTO Review(_id,userId,productId,storeId,orderId,createdAt,updatedAT) VALUES(1,1,1,1,1,'20220101','20220109');
INSERT INTO Review(_id,userId,productId,storeId,orderId,createdAt,updatedAT) VALUES(2,1,1,1,1,'20220102','20220109');
INSERT INTO Review(_id,userId,productId,storeId,orderId,createdAt,updatedAT) VALUES(3,1,3,1,1,'20220103','20220109');
INSERT INTO Review(_id,userId,productId,storeId,orderId,createdAt,updatedAT) VALUES(4,2,3,1,1,'20220103','20220109');
INSERT INTO Review(_id,userId,productId,storeId,orderId,createdAt,updatedAT) VALUES(5,2,4,1,1,'20220103','20220109');
INSERT INTO Review(_id,userId,productId,storeId,orderId,createdAt,updatedAT) VALUES(6,2,4,1,1,'20220104','20220109');
INSERT INTO Review(_id,userId,productId,storeId,orderId,createdAt,updatedAT) VALUES(7,3,8,1,1,'20220105','20220109');
INSERT INTO Review(_id,userId,productId,storeId,orderId,createdAt,updatedAT) VALUES(8,8,8,1,1,'20220105','20220109');
INSERT INTO Review(_id,userId,productId,storeId,orderId,createdAt,updatedAT) VALUES(9,9,9,1,1,'20220105','20220109');
INSERT INTO Review(_id,userId,productId,storeId,orderId,createdAt,updatedAT) VALUES(10,10,1,1,1,'20220106','20220109');

SET IDENTITY_INSERT Review OFF; 
 

GO


