USE [master]
GO
/****** Object:  Database [Lab1]    Script Date: 12/02/2021 7:10:26 PM ******/
CREATE DATABASE [Lab1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Lab1', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Lab1.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Lab1_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Lab1_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Lab1] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Lab1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Lab1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Lab1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Lab1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Lab1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Lab1] SET ARITHABORT OFF 
GO
ALTER DATABASE [Lab1] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Lab1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Lab1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Lab1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Lab1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Lab1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Lab1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Lab1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Lab1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Lab1] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Lab1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Lab1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Lab1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Lab1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Lab1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Lab1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Lab1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Lab1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Lab1] SET  MULTI_USER 
GO
ALTER DATABASE [Lab1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Lab1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Lab1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Lab1] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Lab1] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Lab1]
GO
/****** Object:  Table [dbo].[tblCake]    Script Date: 9/23/2021 7:10:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCake](
	[cakeID] [nvarchar](50) NOT NULL,
	[cakeName] [nvarchar](250) NULL,
	[cakeImg] [nvarchar](50) NULL,
	[cakeDescription] [nvarchar](250) NULL,
	[cakePrice] [float] NULL,
	[cakeCreateDate] [date] NULL,
	[cakeExpirationDate] [date] NULL,
	[cakeCategoryID] [nvarchar](50) NOT NULL,
	[cakeQuantity] [int] NULL,
	[cakeStatus] [bit] NULL,
	[cakeLastUpdateDate] [date] NULL,
	[cakeLastUpdateUser] [nchar](50) NULL,
 CONSTRAINT [PK_tblCake] PRIMARY KEY CLUSTERED 
(
	[cakeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 9/23/2021 7:10:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[categoryID] [nvarchar](50) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblCategory] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblOrder]    Script Date: 9/23/2021 7:10:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrder](
	[orderID] [nvarchar](50) NOT NULL,
	[orderTotalPrice] [float] NULL,
	[orderUserName] [nvarchar](50) NULL,
	[orderNumberPhone] [int] NULL,
	[orderAddress] [nvarchar](max) NULL,
	[userID] [nvarchar](50) NULL,
	[orderCreateDate] [date] NULL,
	[orderStatus] [bit] NULL,
	[orderPayment] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblOrder] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblOrderDetail]    Script Date: 9/23/2021 7:10:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrderDetail](
	[orderID] [nvarchar](50) NULL,
	[cakeID] [nvarchar](50) NULL,
	[quantity] [int] NULL,
	[price] [float] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 9/23/2021 7:10:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRole](
	[roleID] [nvarchar](50) NOT NULL,
	[roleName] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblRole] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 9/23/2021 7:10:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[userID] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[username] [nvarchar](50) NULL,
	[address] [nvarchar](max) NULL,
	[phoneNumber] [nvarchar](50) NULL,
	[roleID] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[tblCake] ([cakeID], [cakeName], [cakeImg], [cakeDescription], [cakePrice], [cakeCreateDate], [cakeExpirationDate], [cakeCategoryID], [cakeQuantity], [cakeStatus], [cakeLastUpdateDate], [cakeLastUpdateUser]) VALUES (N'1', N'Sweet Lu Taro & Purple Sweet Potato Snowy Mooncake Twin Pack (2 Pieces) 120g', N'Mooncake001.jpg', N'Sydney Chinatown''s Sweet Lu is famous for their locally baked and beautifully packaged Mooncakes. These gift sets are the perfect gift to share this Mid-Autumn Festival', 10, CAST(N'2021-09-16' AS Date), CAST(N'2021-12-01' AS Date), N'SL', 13, 1, CAST(N'2021-09-23' AS Date), N'Admin                                             ')
INSERT [dbo].[tblCake] ([cakeID], [cakeName], [cakeImg], [cakeDescription], [cakePrice], [cakeCreateDate], [cakeExpirationDate], [cakeCategoryID], [cakeQuantity], [cakeStatus], [cakeLastUpdateDate], [cakeLastUpdateUser]) VALUES (N'10', N'YẾN SÀO VI CÁ ĐẶT BIỆT 8 TRỨNG 1,2KG - YEN 1K2', N'Mooncake010.jpg', N'Bánh Trung Thu Yến sào Vi cá ĐẶT BIỆT 8 trứng 1,2kg của Như Lan với hương vị truyền thống đặc trưng thơm ngon đậm đà an toàn đảm bảo sức khỏe chất lượng,', 31.72, CAST(N'2021-09-09' AS Date), CAST(N'2021-12-07' AS Date), N'NL', 999, 0, NULL, NULL)
INSERT [dbo].[tblCake] ([cakeID], [cakeName], [cakeImg], [cakeDescription], [cakePrice], [cakeCreateDate], [cakeExpirationDate], [cakeCategoryID], [cakeQuantity], [cakeStatus], [cakeLastUpdateDate], [cakeLastUpdateUser]) VALUES (N'2', N'BÃ¡nh trung thu Truyá»n Thá»ng - Há»p 4 bÃ¡nh', N'Mooncake002.jpg', N'Há»p 4 bÃ¡nh: gá»m 4 bÃ¡nh truyá»n thá»ng do khÃ¡ch hÃ ng tá»± chá»n loáº¡i bÃ¡nh, nhÃ¢n bÃ¡nh', 32, CAST(N'2021-09-09' AS Date), CAST(N'2021-12-31' AS Date), N'HN', 995, 1, CAST(N'2021-09-17' AS Date), N'Admin                                             ')
INSERT [dbo].[tblCake] ([cakeID], [cakeName], [cakeImg], [cakeDescription], [cakePrice], [cakeCreateDate], [cakeExpirationDate], [cakeCategoryID], [cakeQuantity], [cakeStatus], [cakeLastUpdateDate], [cakeLastUpdateUser]) VALUES (N'3', N'Xi Wu Oriental Patisserie Mooncake Delightful Series - Pandan Delight, Violet Harmony, Black Sesame Gold & Mixed Nuts (4 Pieces)', N'Mooncake003.jpg', N'Xi Wu Oriental Patisserie â âDelightful SeriesâContains the following flavours:â Pandan Delightâ Violet Harmonyâ Black Sesame Goldâ Mixed NutsProduct of Malaysia', 32, CAST(N'2021-09-15' AS Date), CAST(N'2021-12-31' AS Date), N'XW', 17, 1, CAST(N'2021-09-17' AS Date), N'Admin                                             ')
INSERT [dbo].[tblCake] ([cakeID], [cakeName], [cakeImg], [cakeDescription], [cakePrice], [cakeCreateDate], [cakeExpirationDate], [cakeCategoryID], [cakeQuantity], [cakeStatus], [cakeLastUpdateDate], [cakeLastUpdateUser]) VALUES (N'4', N'Casahana Elegance 2F Mooncake Bubble Tea Brown Sugar Au Lait & Violet Harmony (2 Pieces)', N'Mooncake004.jpg', N'Casahana Elegance 2F

Contains the following mooncake flavours:
– Brown Sugar Tea Au Lait 黑糖珍珠奶茶
– Violet Harmony 紫芋

Product of Malaysia', 25, CAST(N'2021-09-09' AS Date), CAST(N'2021-12-31' AS Date), N'CA', 998, 1, NULL, NULL)
INSERT [dbo].[tblCake] ([cakeID], [cakeName], [cakeImg], [cakeDescription], [cakePrice], [cakeCreateDate], [cakeExpirationDate], [cakeCategoryID], [cakeQuantity], [cakeStatus], [cakeLastUpdateDate], [cakeLastUpdateUser]) VALUES (N'5', N'Hong Kong Emperor 4 Assorted Flavours Mooncake (4 Pieces) 700G', N'Mooncake005.jpg', N'4 Assorted Flavours contains one of each:
White Lotus Paste 2 Yolks
Mixed Nuts
Red Bean 1 Yolk
Black Sesame Paste 1 Yolk', 32, CAST(N'2021-09-09' AS Date), CAST(N'2021-12-31' AS Date), N'EM', 999, 1, NULL, NULL)
INSERT [dbo].[tblCake] ([cakeID], [cakeName], [cakeImg], [cakeDescription], [cakePrice], [cakeCreateDate], [cakeExpirationDate], [cakeCategoryID], [cakeQuantity], [cakeStatus], [cakeLastUpdateDate], [cakeLastUpdateUser]) VALUES (N'6', N'TRĂNG VÀNG HOÀNG KIM VINH HOA (VÀNG)', N'Mooncake006.jpg', N'Một thu rực rỡ thịnh vượng đã mở ra theo ánh hoàng kim quyền quý, để bản hòa tấu hương vị trung thu ngân lên những cung bậc tinh tế của Tôm Bách Hoa, Thịt Sốt Tương BBQ, Gà Quay Tứ Quý, Hạt Sen Hạt Dưa.', 57.2, CAST(N'2021-09-09' AS Date), CAST(N'2021-12-31' AS Date), N'KD', 997, 1, NULL, NULL)
INSERT [dbo].[tblCake] ([cakeID], [cakeName], [cakeImg], [cakeDescription], [cakePrice], [cakeCreateDate], [cakeExpirationDate], [cakeCategoryID], [cakeQuantity], [cakeStatus], [cakeLastUpdateDate], [cakeLastUpdateUser]) VALUES (N'7', N'BÁNH TRUNG THU LAVA TRỨNG CHẢY – HỘP 6 BÁNH 2021', N'Mooncake007.jpg', N'Dòng bánh lava – bánh trung thu có lớp nhân chính giữa tan chảy – được các nghệ nhân Kinh Đô dày công nghiên cứu giới thiệu đến người Việt Nam với mong muốn mang lại những trải nghiệm thật khác trong mùa trung thu.', 19.83, CAST(N'2021-09-09' AS Date), CAST(N'2021-12-31' AS Date), N'KD', 999, 1, NULL, NULL)
INSERT [dbo].[tblCake] ([cakeID], [cakeName], [cakeImg], [cakeDescription], [cakePrice], [cakeCreateDate], [cakeExpirationDate], [cakeCategoryID], [cakeQuantity], [cakeStatus], [cakeLastUpdateDate], [cakeLastUpdateUser]) VALUES (N'8', N'TRĂNG VÀNG BLACK & GOLD HỘP SƠN MÀI 2021 ÐẶC BIỆT', N'Mooncake008.jpg', N'thuộc bộ sưu tập Trăng Vàng Black & Gold – lấy cảm hứng từ Hoàng gia, kết hợp với ý tưởng thiết kế bao bì là hình ảnh Đoàn múa Lân Sư Rồng, biểu trưng cho điều lành, sự phát đạt, thịnh vượng và hạnh phúc.', 198.26, CAST(N'2021-09-09' AS Date), CAST(N'2021-12-31' AS Date), N'KD', 0, 1, NULL, NULL)
INSERT [dbo].[tblCake] ([cakeID], [cakeName], [cakeImg], [cakeDescription], [cakePrice], [cakeCreateDate], [cakeExpirationDate], [cakeCategoryID], [cakeQuantity], [cakeStatus], [cakeLastUpdateDate], [cakeLastUpdateUser]) VALUES (N'9', N'Bánh Cao Cấp DẠ NGUYỆT ĐOÀN VIÊN 480 gam', N'Mooncake009.jpg', N'1-   Vi cá Hải sâm hảo hạng
2-   Gà quay - Vi cá
3-   Jambon Bat buu
4-   Hạt sen - Cranberry
5-   Đậu xanh - Gấc
6-   Hạt sen - Trà xanh', 10, CAST(N'2021-09-09' AS Date), CAST(N'2021-12-31' AS Date), N'BBC', 999, 1, NULL, NULL)
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'BBC', N'Bibica')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'BD', N'Ba Dan')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'CA', N'Casahana')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'EM', N'Emperor')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'HN', N'Huu Nghi')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'KD', N'Kinh Do')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'NL', N'Nhu Lan')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'SL', N'Sweet Lu')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'XW', N'Xi Wu')
INSERT [dbo].[tblOrder] ([orderID], [orderTotalPrice], [orderUserName], [orderNumberPhone], [orderAddress], [userID], [orderCreateDate], [orderStatus], [orderPayment]) VALUES (N'aUy1m', 42, N'banana', 123456789, N'Q2', N'0123456789', CAST(N'2021-09-23' AS Date), 0, N'Cash')
INSERT [dbo].[tblOrder] ([orderID], [orderTotalPrice], [orderUserName], [orderNumberPhone], [orderAddress], [userID], [orderCreateDate], [orderStatus], [orderPayment]) VALUES (N'OR123', 999, N'User', 123456789, N'Cu Chi', N'user', CAST(N'2021-09-09' AS Date), 1, N'Cash')
INSERT [dbo].[tblOrder] ([orderID], [orderTotalPrice], [orderUserName], [orderNumberPhone], [orderAddress], [userID], [orderCreateDate], [orderStatus], [orderPayment]) VALUES (N'OR456', 999, N'User', 123456789, N'Cu Chi', N'user', CAST(N'2021-09-09' AS Date), 1, N'Cash')
INSERT [dbo].[tblOrder] ([orderID], [orderTotalPrice], [orderUserName], [orderNumberPhone], [orderAddress], [userID], [orderCreateDate], [orderStatus], [orderPayment]) VALUES (N'pvZ5Z', 57.200000762939453, N'banana', 123456789, N'Q2', N'0123456789', CAST(N'2021-09-23' AS Date), 0, N'Cash')
INSERT [dbo].[tblOrder] ([orderID], [orderTotalPrice], [orderUserName], [orderNumberPhone], [orderAddress], [userID], [orderCreateDate], [orderStatus], [orderPayment]) VALUES (N'qLzl8', 97.199996948242188, N'No Name', 123456789, N'Quan 1', N'user', CAST(N'2021-09-23' AS Date), 0, N'Cash')
INSERT [dbo].[tblOrderDetail] ([orderID], [cakeID], [quantity], [price]) VALUES (N'OR123', N'1', 2, 40)
INSERT [dbo].[tblOrderDetail] ([orderID], [cakeID], [quantity], [price]) VALUES (N'OR123', N'2', 2, 40)
INSERT [dbo].[tblOrderDetail] ([orderID], [cakeID], [quantity], [price]) VALUES (N'aUy1m', N'1', 1, 10)
INSERT [dbo].[tblOrderDetail] ([orderID], [cakeID], [quantity], [price]) VALUES (N'aUy1m', N'2', 1, 32)
INSERT [dbo].[tblOrderDetail] ([orderID], [cakeID], [quantity], [price]) VALUES (N'qLzl8', N'1', 4, 10)
INSERT [dbo].[tblOrderDetail] ([orderID], [cakeID], [quantity], [price]) VALUES (N'qLzl8', N'6', 1, 57.200000762939453)
INSERT [dbo].[tblOrderDetail] ([orderID], [cakeID], [quantity], [price]) VALUES (N'pvZ5Z', N'6', 1, 57.200000762939453)
INSERT [dbo].[tblRole] ([roleID], [roleName]) VALUES (N'AD', N'Admin')
INSERT [dbo].[tblRole] ([roleID], [roleName]) VALUES (N'US', N'User')
INSERT [dbo].[tblUser] ([userID], [password], [username], [address], [phoneNumber], [roleID]) VALUES (N'0123456789', N'3597794', N'banana', N'Q2', N'0123456789', N'US')
INSERT [dbo].[tblUser] ([userID], [password], [username], [address], [phoneNumber], [roleID]) VALUES (N'admin', N'123', N'Admin', N'Thu Duc', N'0987654321', N'AD')
INSERT [dbo].[tblUser] ([userID], [password], [username], [address], [phoneNumber], [roleID]) VALUES (N'user', N'123', N'No Name', N'Quan 1', N'0123456789', N'US')
INSERT [dbo].[tblUser] ([userID], [password], [username], [address], [phoneNumber], [roleID]) VALUES (N'user01', N'456', N'User 01', N'Quan 2', N'0123456788', N'US')
INSERT [dbo].[tblUser] ([userID], [password], [username], [address], [phoneNumber], [roleID]) VALUES (N'user02', N'456', N'User 01', N'Quan 2', N'0123456788', N'US')
INSERT [dbo].[tblUser] ([userID], [password], [username], [address], [phoneNumber], [roleID]) VALUES (N'user03', N'456', N'User 01', N'Quan 2', N'0123456788', N'US')
INSERT [dbo].[tblUser] ([userID], [password], [username], [address], [phoneNumber], [roleID]) VALUES (N'user04', N'456', N'User 01', N'Quan 2', N'0123456788', N'US')
ALTER TABLE [dbo].[tblCake]  WITH CHECK ADD  CONSTRAINT [FK_tblCake_tblCategory] FOREIGN KEY([cakeCategoryID])
REFERENCES [dbo].[tblCategory] ([categoryID])
GO
ALTER TABLE [dbo].[tblCake] CHECK CONSTRAINT [FK_tblCake_tblCategory]
GO
ALTER TABLE [dbo].[tblOrder]  WITH CHECK ADD  CONSTRAINT [FK_tblOrder_tblUser] FOREIGN KEY([userID])
REFERENCES [dbo].[tblUser] ([userID])
GO
ALTER TABLE [dbo].[tblOrder] CHECK CONSTRAINT [FK_tblOrder_tblUser]
GO
ALTER TABLE [dbo].[tblOrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tblOrderDetail_tblCake] FOREIGN KEY([cakeID])
REFERENCES [dbo].[tblCake] ([cakeID])
GO
ALTER TABLE [dbo].[tblOrderDetail] CHECK CONSTRAINT [FK_tblOrderDetail_tblCake]
GO
ALTER TABLE [dbo].[tblOrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tblOrderDetail_tblOrder] FOREIGN KEY([orderID])
REFERENCES [dbo].[tblOrder] ([orderID])
GO
ALTER TABLE [dbo].[tblOrderDetail] CHECK CONSTRAINT [FK_tblOrderDetail_tblOrder]
GO
ALTER TABLE [dbo].[tblUser]  WITH CHECK ADD  CONSTRAINT [FK_tblUser_tblRole] FOREIGN KEY([roleID])
REFERENCES [dbo].[tblRole] ([roleID])
GO
ALTER TABLE [dbo].[tblUser] CHECK CONSTRAINT [FK_tblUser_tblRole]
GO
USE [master]
GO
ALTER DATABASE [Lab1] SET  READ_WRITE 
GO
