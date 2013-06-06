USE [master]
GO
/****** Object:  Database [DVDStoreVer2]    Script Date: 06/05/2013 08:34:55 ******/
CREATE DATABASE [DVDStoreVer2] ON  PRIMARY 
( NAME = N'DVDStore2', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.SQLEXPRESS\MSSQL\DATA\DVDStore2.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'DVDStore2_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.SQLEXPRESS\MSSQL\DATA\DVDStore2_log.LDF' , SIZE = 768KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [DVDStoreVer2] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DVDStoreVer2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DVDStoreVer2] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [DVDStoreVer2] SET ANSI_NULLS OFF
GO
ALTER DATABASE [DVDStoreVer2] SET ANSI_PADDING OFF
GO
ALTER DATABASE [DVDStoreVer2] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [DVDStoreVer2] SET ARITHABORT OFF
GO
ALTER DATABASE [DVDStoreVer2] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [DVDStoreVer2] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [DVDStoreVer2] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [DVDStoreVer2] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [DVDStoreVer2] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [DVDStoreVer2] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [DVDStoreVer2] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [DVDStoreVer2] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [DVDStoreVer2] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [DVDStoreVer2] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [DVDStoreVer2] SET  DISABLE_BROKER
GO
ALTER DATABASE [DVDStoreVer2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [DVDStoreVer2] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [DVDStoreVer2] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [DVDStoreVer2] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [DVDStoreVer2] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [DVDStoreVer2] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [DVDStoreVer2] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [DVDStoreVer2] SET  READ_WRITE
GO
ALTER DATABASE [DVDStoreVer2] SET RECOVERY SIMPLE
GO
ALTER DATABASE [DVDStoreVer2] SET  MULTI_USER
GO
ALTER DATABASE [DVDStoreVer2] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [DVDStoreVer2] SET DB_CHAINING OFF
GO
USE [DvdStoreVer2]
GO
IF  EXISTS (SELECT * FROM sys.default_constraints WHERE object_id = OBJECT_ID(N'[dbo].[DF_Order_Status]') AND parent_object_id = OBJECT_ID(N'[dbo].[Bill]'))
Begin
IF  EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_Order_Status]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[Bill] DROP CONSTRAINT [DF_Order_Status]
END


End
GO
IF  EXISTS (SELECT * FROM sys.default_constraints WHERE object_id = OBJECT_ID(N'[dbo].[DF_DVD_DiscNumber]') AND parent_object_id = OBJECT_ID(N'[dbo].[DVD]'))
Begin
IF  EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_DVD_DiscNumber]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[DVD] DROP CONSTRAINT [DF_DVD_DiscNumber]
END


End
GO
IF  EXISTS (SELECT * FROM sys.default_constraints WHERE object_id = OBJECT_ID(N'[dbo].[DF_Feedback_Status]') AND parent_object_id = OBJECT_ID(N'[dbo].[Feedback]'))
Begin
IF  EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_Feedback_Status]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[Feedback] DROP CONSTRAINT [DF_Feedback_Status]
END


End
GO
/****** Object:  Table [dbo].[Advertising]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Advertising]') AND type in (N'U'))
DROP TABLE [dbo].[Advertising]
GO
/****** Object:  Table [dbo].[Album]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Album]') AND type in (N'U'))
DROP TABLE [dbo].[Album]
GO
/****** Object:  Table [dbo].[AlbumMusicMapping]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[AlbumMusicMapping]') AND type in (N'U'))
DROP TABLE [dbo].[AlbumMusicMapping]
GO
/****** Object:  Table [dbo].[Artist]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Artist]') AND type in (N'U'))
DROP TABLE [dbo].[Artist]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Bill]') AND type in (N'U'))
DROP TABLE [dbo].[Bill]
GO
/****** Object:  Table [dbo].[BillDetail]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BillDetail]') AND type in (N'U'))
DROP TABLE [dbo].[BillDetail]
GO
/****** Object:  Table [dbo].[Browser]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Browser]') AND type in (N'U'))
DROP TABLE [dbo].[Browser]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Category]') AND type in (N'U'))
DROP TABLE [dbo].[Category]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Comment]') AND type in (N'U'))
DROP TABLE [dbo].[Comment]
GO
/****** Object:  Table [dbo].[DVD]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[DVD]') AND type in (N'U'))
DROP TABLE [dbo].[DVD]
GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Feedback]') AND type in (N'U'))
DROP TABLE [dbo].[Feedback]
GO
/****** Object:  Table [dbo].[FileData]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[FileData]') AND type in (N'U'))
DROP TABLE [dbo].[FileData]
GO
/****** Object:  Table [dbo].[Game]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Game]') AND type in (N'U'))
DROP TABLE [dbo].[Game]
GO
/****** Object:  Table [dbo].[Genre]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Genre]') AND type in (N'U'))
DROP TABLE [dbo].[Genre]
GO
/****** Object:  Table [dbo].[Manage]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Manage]') AND type in (N'U'))
DROP TABLE [dbo].[Manage]
GO
/****** Object:  Table [dbo].[ManagePermissionMapping]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ManagePermissionMapping]') AND type in (N'U'))
DROP TABLE [dbo].[ManagePermissionMapping]
GO
/****** Object:  Table [dbo].[MappingTable]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[MappingTable]') AND type in (N'U'))
DROP TABLE [dbo].[MappingTable]
GO
/****** Object:  Table [dbo].[Member]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Member]') AND type in (N'U'))
DROP TABLE [dbo].[Member]
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Movie]') AND type in (N'U'))
DROP TABLE [dbo].[Movie]
GO
/****** Object:  Table [dbo].[News]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[News]') AND type in (N'U'))
DROP TABLE [dbo].[News]
GO
/****** Object:  Table [dbo].[ObjectOfBrowsingRule]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ObjectOfBrowsingRule]') AND type in (N'U'))
DROP TABLE [dbo].[ObjectOfBrowsingRule]
GO
/****** Object:  Table [dbo].[Permission]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Permission]') AND type in (N'U'))
DROP TABLE [dbo].[Permission]
GO
/****** Object:  Table [dbo].[Producer]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Producer]') AND type in (N'U'))
DROP TABLE [dbo].[Producer]
GO
/****** Object:  Table [dbo].[Promotion]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Promotion]') AND type in (N'U'))
DROP TABLE [dbo].[Promotion]
GO
/****** Object:  Table [dbo].[PromotionRegister]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[PromotionRegister]') AND type in (N'U'))
DROP TABLE [dbo].[PromotionRegister]
GO
/****** Object:  Table [dbo].[Report]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Report]') AND type in (N'U'))
DROP TABLE [dbo].[Report]
GO
/****** Object:  Table [dbo].[Song]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Song]') AND type in (N'U'))
DROP TABLE [dbo].[Song]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 06/06/2013 07:06:02 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Supplier]') AND type in (N'U'))
DROP TABLE [dbo].[Supplier]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Supplier]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Supplier](
	[Id] [int] NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Info] [nvarchar](1000) NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Supplier] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Song]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Song]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Song](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[SingerId] [int] NULL,
	[ComposerId] [int] NULL,
	[Lyrics] [ntext] NULL,
	[IsFree] [bit] NOT NULL,
	[FileID] [int] NOT NULL,
	[Info] [nchar](10) NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Song] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
SET IDENTITY_INSERT [dbo].[Song] ON
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (7, N'chim en', 1, 5, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (8, N'khi co don em nho ai', 2, 5, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (9, N'chim sao', 3, 5, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (10, N'mua xuan ve', 4, 5, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (11, N'nguoi den tu chieu chau', 1, 6, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (12, N'mat nai', 2, 6, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (13, N'mai mai mot tinh yeu', 3, 6, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (14, N'phut boi roi', 4, 6, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (15, N'hay ve day ben anh', 1, 7, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (16, N'kiep do den', 2, 7, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (17, N'ngay moi nang hong', 3, 7, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (18, N'dong thoi gian', 4, 7, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (19, N'mot ngay moi', 1, 8, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (20, N'neu nhu anh den', 2, 8, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (21, N'ben bo yeu thuong', 3, 8, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (22, N'hay min cuoi', 4, 8, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (23, N'ben thuong hai', 1, 5, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (24, N'dung yeu trong goc toi', 2, 6, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (25, N'duong den vinh quang', 3, 7, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
INSERT [dbo].[Song] ([Id], [Title], [SingerId], [ComposerId], [Lyrics], [IsFree], [FileID], [Info], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (26, N'xuan hoi ngo', 4, 8, N'asd', 0, 1, N'chim en   ', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D100000000 AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Song] OFF
/****** Object:  Table [dbo].[Report]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Report]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Report](
	[Id] [int] NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Description] [nvarchar](255) NULL,
	[QueryReport] [ntext] NOT NULL,
	[CreatedDate] [datetime] NULL,
	[ModifiedDate] [datetime] NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Report] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[PromotionRegister]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[PromotionRegister]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[PromotionRegister](
	[Id] [int] NOT NULL,
	[MemberId] [int] NOT NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_PromotionRegister] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Promotion]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Promotion]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Promotion](
	[Id] [int] NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Description] [nvarchar](255) NULL,
	[PromotionInfo] [ntext] NOT NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Promotion] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Producer]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Producer]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Producer](
	[Id] [int] NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Info] [nvarchar](1000) NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Producer] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Permission]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Permission]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Permission](
	[Id] [int] NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Description] [nvarchar](255) NULL,
	[UrlPattern] [nvarchar](1000) NULL,
	[CreatedDate] [datetime] NULL,
	[ModifiedDate] [datetime] NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Permission] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[ObjectOfBrowsingRule]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ObjectOfBrowsingRule]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ObjectOfBrowsingRule](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[IsBase] [bit] NOT NULL,
	[QueryToGetValue] [varchar](300) NULL,
	[CollToMapping] [varchar](50) NULL,
	[TableToMapping] [varchar](50) NULL,
 CONSTRAINT [PK_ObjectOfBrowsingRule] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[ObjectOfBrowsingRule] ON
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (1, N'Singer', 0, N'Select Id as Id, Title As Value From Artist where Id in (Select distinct SingerId from Song)', N'SingerId', N'Song')
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (2, N'Price', 1, NULL, N'Price', N'DVD')
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (3, N'Composer', 0, N'Select Id as Id, Title As Value From Artist where Id in (Select distinct ComposerId from Song)', N'ComposerId', N'Song')
SET IDENTITY_INSERT [dbo].[ObjectOfBrowsingRule] OFF
/****** Object:  Table [dbo].[News]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[News]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[News](
	[Id] [int] NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[ManageId] [int] NOT NULL,
	[NewsContent] [ntext] NOT NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_News] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Movie]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Movie](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Studio] [nvarchar](100) NULL,
	[Director] [nvarchar](100) NULL,
	[Actor] [nvarchar](255) NULL,
	[Info] [nvarchar](1000) NULL,
	[TrailerId] [int] NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Movie] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Member]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Member]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Member](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NULL,
	[Email] [nvarchar](255) NULL,
	[Password] [nvarchar](255) NULL,
	[JoinedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsLock] [bit] NOT NULL,
 CONSTRAINT [PK_Member] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[MappingTable]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[MappingTable]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[MappingTable](
	[TableA] [varchar](50) NULL,
	[TableB] [varchar](50) NULL,
	[QueryToJoin] [varchar](2000) NULL,
	[Id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_MappingTable] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[MappingTable] ON
INSERT [dbo].[MappingTable] ([TableA], [TableB], [QueryToJoin], [Id]) VALUES (N'DVD', N'DVD', N'FROM DVD', 1)
INSERT [dbo].[MappingTable] ([TableA], [TableB], [QueryToJoin], [Id]) VALUES (N'DVD', N'Song', N'FROM  DVD INNER JOIN  Album ON DVD.DetailId = Album.Id INNER JOIN   AlbumMusicMapping ON Album.Id = AlbumMusicMapping.AlbumId INNER JOIN Song ON AlbumMusicMapping.SongId = Song.Id WHERE(DVD.IsDeleted = 0) AND (Song.IsDeleted = 0)', 2)
INSERT [dbo].[MappingTable] ([TableA], [TableB], [QueryToJoin], [Id]) VALUES (N'DVD', N'BillDetail', N'FROM BillDetail INNER JOIN DVD ON BillDetail.DvdId = DVD.Id WHERE (DVD.IsDeleted = 0)', 3)
SET IDENTITY_INSERT [dbo].[MappingTable] OFF
/****** Object:  Table [dbo].[ManagePermissionMapping]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ManagePermissionMapping]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ManagePermissionMapping](
	[ManageId] [int] NOT NULL,
	[PermissionId] [int] NOT NULL,
 CONSTRAINT [PK_ManagePermissionMapping] PRIMARY KEY CLUSTERED 
(
	[ManageId] ASC,
	[PermissionId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Manage]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Manage]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Manage](
	[Id] [int] NOT NULL,
	[Name] [nvarchar](255) NOT NULL,
	[Password] [nvarchar](255) NOT NULL,
	[Info] [nvarchar](1000) NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsLock] [bit] NOT NULL,
 CONSTRAINT [PK_Manage] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Genre]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Genre]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Genre](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](50) NOT NULL,
	[Type] [varchar](50) NOT NULL,
	[Description] [nvarchar](100) NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Genre] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Game]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Game]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Game](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Manufacture] [nvarchar](255) NULL,
	[Info] [nvarchar](1000) NULL,
	[TrailerId] [int] NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Game] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[FileData]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[FileData]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[FileData](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NULL,
	[Url] [nvarchar](255) NULL,
	[Type] [varchar](10) NULL,
	[ViewCount] [int] NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Files] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Feedback]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Feedback](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[MemberId] [int] NULL,
	[FeedbackText] [nvarchar](1000) NULL,
	[IsRead] [bit] NULL,
	[ReplyText] [nvarchar](1000) NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Feedback] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[DVD]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[DVD]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[DVD](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[ReleaseDate] [datetime] NULL,
	[Genres] [nvarchar](255) NULL,
	[Description] [ntext] NULL,
	[Price] [float] NULL,
	[ImgCover] [nvarchar](255) NOT NULL,
	[Author] [nvarchar](255) NOT NULL,
	[ProducerId] [int] NULL,
	[SupplierId] [int] NULL,
	[DiscNumber] [int] NULL,
	[Type] [varchar](50) NOT NULL,
	[DetailId] [int] NULL,
	[RatePoint] [int] NULL,
	[RateCount] [int] NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_DVD] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[DVD] ON
INSERT [dbo].[DVD] ([Id], [Title], [ReleaseDate], [Genres], [Description], [Price], [ImgCover], [Author], [ProducerId], [SupplierId], [DiscNumber], [Type], [DetailId], [RatePoint], [RateCount], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (2, N'Wow fish', CAST(0x0000A1D000000000 AS DateTime), N'6/1/2013', N'game fishing', 10, N'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg', N'Duc', 1, 1, 1, N'game', 1, 0, 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[DVD] ([Id], [Title], [ReleaseDate], [Genres], [Description], [Price], [ImgCover], [Author], [ProducerId], [SupplierId], [DiscNumber], [Type], [DetailId], [RatePoint], [RateCount], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (3, N'Wow tank', CAST(0x0000A1D000000000 AS DateTime), N'6/1/2013', N'game fishing', 50, N'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg', N'Duc', 1, 1, 1, N'game', 1, 0, 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[DVD] ([Id], [Title], [ReleaseDate], [Genres], [Description], [Price], [ImgCover], [Author], [ProducerId], [SupplierId], [DiscNumber], [Type], [DetailId], [RatePoint], [RateCount], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (4, N'Warcraft', CAST(0x0000A1D000000000 AS DateTime), N'6/1/2013', N'game fishing', 100, N'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg', N'Duc', 1, 1, 1, N'game', 1, 0, 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[DVD] ([Id], [Title], [ReleaseDate], [Genres], [Description], [Price], [ImgCover], [Author], [ProducerId], [SupplierId], [DiscNumber], [Type], [DetailId], [RatePoint], [RateCount], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (5, N'Mot thoi tho au', CAST(0x0000A1D000000000 AS DateTime), N'6/1/2013', N'album nhac viet', 103, N'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg', N'Duc', 1, 1, 1, N'music', 2, 0, 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[DVD] ([Id], [Title], [ReleaseDate], [Genres], [Description], [Price], [ImgCover], [Author], [ProducerId], [SupplierId], [DiscNumber], [Type], [DetailId], [RatePoint], [RateCount], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (6, N'ca tim', CAST(0x0000A1D000000000 AS DateTime), N'6/1/2013', N'album nhac viet', 50, N'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg', N'Duc', 1, 1, 1, N'music', 3, 0, 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[DVD] ([Id], [Title], [ReleaseDate], [Genres], [Description], [Price], [ImgCover], [Author], [ProducerId], [SupplierId], [DiscNumber], [Type], [DetailId], [RatePoint], [RateCount], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (7, N'nam moi', CAST(0x0000A1D000000000 AS DateTime), N'6/1/2013', N'album nhac viet', 20, N'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg', N'Duc', 1, 1, 1, N'music', 4, 0, 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[DVD] ([Id], [Title], [ReleaseDate], [Genres], [Description], [Price], [ImgCover], [Author], [ProducerId], [SupplierId], [DiscNumber], [Type], [DetailId], [RatePoint], [RateCount], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (8, N'xuan 2013', CAST(0x0000A1D000000000 AS DateTime), N'6/1/2013', N'album nhac viet', 34, N'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg', N'Duc', 1, 1, 1, N'music', 5, 0, 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[DVD] ([Id], [Title], [ReleaseDate], [Genres], [Description], [Price], [ImgCover], [Author], [ProducerId], [SupplierId], [DiscNumber], [Type], [DetailId], [RatePoint], [RateCount], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (9, N'xuan 2012', CAST(0x0000A1D000000000 AS DateTime), N'6/1/2013', N'album nhac viet', 76, N'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg', N'Duc', 1, 1, 1, N'music', 6, 0, 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[DVD] ([Id], [Title], [ReleaseDate], [Genres], [Description], [Price], [ImgCover], [Author], [ProducerId], [SupplierId], [DiscNumber], [Type], [DetailId], [RatePoint], [RateCount], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (10, N'ha noi', CAST(0x0000A1D000000000 AS DateTime), N'6/1/2013', N'album nhac viet', 200, N'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg', N'Duc', 1, 1, 1, N'music', 7, 0, 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[DVD] ([Id], [Title], [ReleaseDate], [Genres], [Description], [Price], [ImgCover], [Author], [ProducerId], [SupplierId], [DiscNumber], [Type], [DetailId], [RatePoint], [RateCount], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (11, N'da xa mot thoi', CAST(0x0000A1D000000000 AS DateTime), N'6/1/2013', N'album nhac viet', 150, N'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg', N'Duc', 1, 1, 1, N'music', 8, 0, 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[DVD] OFF
/****** Object:  Table [dbo].[Comment]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Comment]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Comment](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[MemberId] [int] NOT NULL,
	[DvdID] [int] NOT NULL,
	[CommentText] [ntext] NOT NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Category]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Category]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Category](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Query] [nvarchar](2000) NULL,
	[Description] [nvarchar](255) NULL,
	[CategoryParentId] [int] NULL,
	[CreatedDate] [datetime] NULL,
	[ModifiedDate] [datetime] NULL,
	[IsDeleted] [bit] NOT NULL,
	[WoodenLeg] [varchar](50) NULL,
	[CateLevel] [int] NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Category] ON
INSERT [dbo].[Category] ([Id], [Name], [Query], [Description], [CategoryParentId], [CreatedDate], [ModifiedDate], [IsDeleted], [WoodenLeg], [CateLevel]) VALUES (1, N'All Product', N'Select * from DVD', N'all product in store', 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0, N'1', 0)
INSERT [dbo].[Category] ([Id], [Name], [Query], [Description], [CategoryParentId], [CreatedDate], [ModifiedDate], [IsDeleted], [WoodenLeg], [CateLevel]) VALUES (2, N'Game', N'Select * from DVD where Type = ''game''', N'all game', 1, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0, N'10002', 1)
INSERT [dbo].[Category] ([Id], [Name], [Query], [Description], [CategoryParentId], [CreatedDate], [ModifiedDate], [IsDeleted], [WoodenLeg], [CateLevel]) VALUES (3, N'Movie', N'Select * from DVD Where Type = ''movie''', N'all movie', 1, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0, N'10003', 1)
INSERT [dbo].[Category] ([Id], [Name], [Query], [Description], [CategoryParentId], [CreatedDate], [ModifiedDate], [IsDeleted], [WoodenLeg], [CateLevel]) VALUES (4, N'Album', N'Select * from DVD Where Type = ''music''', N'all music', 1, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0, N'10004', 1)
SET IDENTITY_INSERT [dbo].[Category] OFF
/****** Object:  Table [dbo].[Browser]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Browser]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Browser](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](100) NOT NULL,
	[ParentId] [int] NOT NULL,
	[QuerySearch] [nvarchar](1000) NOT NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Browser] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[BillDetail]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BillDetail]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[BillDetail](
	[BillId] [int] NOT NULL,
	[DvdId] [int] NOT NULL,
	[Price] [float] NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK_BillDetail] PRIMARY KEY CLUSTERED 
(
	[BillId] ASC,
	[DvdId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Bill]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Bill](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Total] [money] NULL,
	[Status] [smallint] NULL,
	[CustomerName] [nvarchar](255) NULL,
	[DeliveryAddress] [ntext] NULL,
	[Phone] [varchar](50) NULL,
	[Message] [nvarchar](1000) NULL,
	[MemberId] [int] NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Artist]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Artist]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Artist](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Info] [ntext] NULL,
	[WorkAs] [nvarchar](50) NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Artist] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
SET IDENTITY_INSERT [dbo].[Artist] ON
INSERT [dbo].[Artist] ([Id], [Title], [Info], [WorkAs], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (1, N'Bang Kieu', N'ca si bang kieu viet nam', N'Singer', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Artist] ([Id], [Title], [Info], [WorkAs], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (2, N'Dan truong', N'ca si dan truong viet nam', N'Singer', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Artist] ([Id], [Title], [Info], [WorkAs], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (3, N'Lam truong', N'CA SI LAM TRUONG VIET NAM', N'SINGER', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Artist] ([Id], [Title], [Info], [WorkAs], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (4, N'Thanh thao', N'ca si thanh thao viet nam', N'singer', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Artist] ([Id], [Title], [Info], [WorkAs], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (5, N'Trinh cong son', N'nghe si trinh cong son viet nam', N'Composer', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Artist] ([Id], [Title], [Info], [WorkAs], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (6, N'Văn Cao', N'nghe si trinh cong son viet nam', N'Composer', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Artist] ([Id], [Title], [Info], [WorkAs], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (7, N'Đoàn Chuẩn', N'nghe si trinh cong son viet nam', N'Composer', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Artist] ([Id], [Title], [Info], [WorkAs], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (8, N'Trần Tiến', N'nghe si trinh cong son viet nam', N'Composer', CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Artist] OFF
/****** Object:  Table [dbo].[AlbumMusicMapping]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[AlbumMusicMapping]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[AlbumMusicMapping](
	[AlbumId] [int] NOT NULL,
	[SongId] [int] NOT NULL,
	[TrackNumber] [int] NOT NULL,
 CONSTRAINT [PK_AlbumMusicMapping] PRIMARY KEY CLUSTERED 
(
	[AlbumId] ASC,
	[SongId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (2, 7, 1)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (2, 8, 2)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (2, 9, 3)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (2, 10, 4)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (3, 11, 1)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (3, 12, 2)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (3, 13, 3)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (3, 14, 4)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (4, 15, 1)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (4, 16, 2)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (4, 17, 3)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (4, 18, 4)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (5, 19, 1)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (5, 20, 2)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (5, 21, 3)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (5, 22, 4)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (6, 23, 1)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (6, 24, 2)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (6, 25, 3)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (6, 26, 4)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (7, 1, 3)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (7, 4, 2)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (7, 15, 1)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (7, 20, 4)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (8, 1, 1)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (8, 5, 2)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (8, 20, 4)
INSERT [dbo].[AlbumMusicMapping] ([AlbumId], [SongId], [TrackNumber]) VALUES (8, 22, 3)
/****** Object:  Table [dbo].[Album]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Album]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Album](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Owner] [nvarchar](100) NULL,
	[ViewCount] [int] NULL,
	[NumberItem] [int] NULL,
	[CreatedDate] [datetime] NULL,
	[ModifiedDate] [datetime] NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Album] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET IDENTITY_INSERT [dbo].[Album] ON
INSERT [dbo].[Album] ([Id], [Title], [Owner], [ViewCount], [NumberItem], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (2, N'Mot thoi tho au', N'Nhac Viet', 0, 5, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Album] ([Id], [Title], [Owner], [ViewCount], [NumberItem], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (3, N'ca tim', N'Nhac Viet', 0, 5, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Album] ([Id], [Title], [Owner], [ViewCount], [NumberItem], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (4, N'nam moi', N'Nhac Viet', 0, 5, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Album] ([Id], [Title], [Owner], [ViewCount], [NumberItem], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (5, N'xuan 2013', N'Nhac Viet', 0, 5, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Album] ([Id], [Title], [Owner], [ViewCount], [NumberItem], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (6, N'xuan 2012', N'Nhac Viet', 0, 5, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Album] ([Id], [Title], [Owner], [ViewCount], [NumberItem], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (7, N'ha noi', N'Nhac Viet', 0, 5, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
INSERT [dbo].[Album] ([Id], [Title], [Owner], [ViewCount], [NumberItem], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (8, N'da xa mot thoi', N'Nhac Viet', 0, 5, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Album] OFF
/****** Object:  Table [dbo].[Advertising]    Script Date: 06/06/2013 07:06:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Advertising]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Advertising](
	[Id] [int] NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Description] [nvarchar](255) NULL,
	[ImgUrl] [nvarchar](1000) NULL,
	[UrlTo] [nvarchar](1000) NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Advertising] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Default [DF_Order_Status]    Script Date: 06/06/2013 07:06:02 ******/
IF Not EXISTS (SELECT * FROM sys.default_constraints WHERE object_id = OBJECT_ID(N'[dbo].[DF_Order_Status]') AND parent_object_id = OBJECT_ID(N'[dbo].[Bill]'))
Begin
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_Order_Status]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[Bill] ADD  CONSTRAINT [DF_Order_Status]  DEFAULT ((0)) FOR [Status]
END


End
GO
/****** Object:  Default [DF_DVD_DiscNumber]    Script Date: 06/06/2013 07:06:02 ******/
IF Not EXISTS (SELECT * FROM sys.default_constraints WHERE object_id = OBJECT_ID(N'[dbo].[DF_DVD_DiscNumber]') AND parent_object_id = OBJECT_ID(N'[dbo].[DVD]'))
Begin
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_DVD_DiscNumber]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[DVD] ADD  CONSTRAINT [DF_DVD_DiscNumber]  DEFAULT ((1)) FOR [DiscNumber]
END


End
GO
/****** Object:  Default [DF_Feedback_Status]    Script Date: 06/06/2013 07:06:02 ******/
IF Not EXISTS (SELECT * FROM sys.default_constraints WHERE object_id = OBJECT_ID(N'[dbo].[DF_Feedback_Status]') AND parent_object_id = OBJECT_ID(N'[dbo].[Feedback]'))
Begin
IF NOT EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_Feedback_Status]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[Feedback] ADD  CONSTRAINT [DF_Feedback_Status]  DEFAULT ((0)) FOR [IsRead]
END


End
GO
