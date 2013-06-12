USE [DvdStoreVer2]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Song]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Report]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[PromotionRegister]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Promotion]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Producer]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Permission]    Script Date: 06/12/2013 16:33:14 ******/
SET IDENTITY_INSERT [dbo].[Permission] ON
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (1, N'System Admin', N'Admin with full permission', N'/admin/*', 1, 1, CAST(0x0000A1DB008B6A2A AS DateTime), CAST(0x0000A1DB008B6A2A AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (2, N'Product Manage', N'manage product', N'/admin/product/*', 1, 3, CAST(0x0000A1DB008BABAE AS DateTime), CAST(0x0000A1DB008BABAE AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (3, N'Advertising manage', N'Manage advertising', N'/admin/advertising/*', 1, 3, CAST(0x0000A1DB008BE9B2 AS DateTime), CAST(0x0000A1DB008BE9B2 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (4, N'Album Manage', N'album manage', N'/admin/album/*', 1, 3, CAST(0x0000A1DB008C0E2B AS DateTime), CAST(0x0000A1DB008C0E2B AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (5, N'Artist Manage', N'Artist Manage', N'/admin/artist/*', 1, 3, CAST(0x0000A1DB008C35E8 AS DateTime), CAST(0x0000A1DB008C35E8 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (6, N'Category Manage', N'category manage', N'/admin/category/*', 1, 3, CAST(0x0000A1DB008C529E AS DateTime), CAST(0x0000A1DB008C529E AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (7, N'Customer Manage', N'customer manage', N'/admin/customer/*', 1, 3, CAST(0x0000A1DB008C6A84 AS DateTime), CAST(0x0000A1DB008C6A84 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (8, N'Feedback Manage', N'feedback manage', N'/admin/feedback/*', 1, 3, CAST(0x0000A1DB008C87B4 AS DateTime), CAST(0x0000A1DB008C87B4 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (9, N'File Manage', N'file manage', N'/admin/file/*', 1, 3, CAST(0x0000A1DB008C9D4A AS DateTime), CAST(0x0000A1DB008C9D4A AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (10, N'Manage manage', N'manage Manager', N'/admin/manage/*', 1, 2, CAST(0x0000A1DB008CC668 AS DateTime), CAST(0x0000A1DB008CC668 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (11, N'News Manager', N'manage news', N'/admin/news/*', 1, 3, CAST(0x0000A1DB008CF951 AS DateTime), CAST(0x0000A1DB008CF951 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (12, N'Order Manager', N'Order Manager', N'/admin/order/*', 1, 3, CAST(0x0000A1DB008D1DA5 AS DateTime), CAST(0x0000A1DB008D1DA5 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (13, N'Permission Manager', N'Permission Manager', N'/admin/permission/*', 1, 3, CAST(0x0000A1DB008D44B2 AS DateTime), CAST(0x0000A1DB008D44B2 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (14, N'Producer Manager', N'Producer Manager', N'/admin/producer/*', 1, 3, CAST(0x0000A1DB008D6483 AS DateTime), CAST(0x0000A1DB008D6483 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (15, N'Promotion Manager', N'Promotion Manager', N'/admin/promotion/*', 1, 3, CAST(0x0000A1DB008D8476 AS DateTime), CAST(0x0000A1DB008D8476 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (16, N'Report Manager', N'report manage', N'/admin/report/*', 1, 3, CAST(0x0000A1DB008DA7CE AS DateTime), CAST(0x0000A1DB008DA7CE AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (17, N'Song Manager', N'song manager', N'/admin/song/*', 1, 3, CAST(0x0000A1DB008DBD41 AS DateTime), CAST(0x0000A1DB008DBD41 AS DateTime), 0)
INSERT [dbo].[Permission] ([Id], [Title], [Description], [UrlPattern], [IsBase], [Position], [CreatedDate], [ModifiedDate], [IsDeleted]) VALUES (18, N'Supplier Manager', N'Supplier Manager', N'/admin/supplier/*', 1, 3, CAST(0x0000A1DB008DDD4E AS DateTime), CAST(0x0000A1DB008DDD4E AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Permission] OFF
/****** Object:  Table [dbo].[ObjectOfBrowsingRule]    Script Date: 06/12/2013 16:33:14 ******/
SET IDENTITY_INSERT [dbo].[ObjectOfBrowsingRule] ON
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (1, N'Singer', 0, N'Select Artist.Id as Id, Artist.Title as Value From Artist where Artist.Id in (Select distinct Song.SingerId from Song)', N'SingerId', N'Song')
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (2, N'Price', 1, NULL, N'Price', N'DVD')
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (3, N'Composer', 0, N'Select Artist.Id as Id, Artist.Title As Value From Artist where Artist.Id in (Select distinct Song.ComposerId from Song)', N'ComposerId', N'Song')
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (4, N'Producer', 0, N'Select Producer.Id as Id, Producer.Title As Vaule From Producer', N'ProducerId', N'DVD')
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (5, N'Genre', 0, N'Select Genre.Id as Id, Genre.Title As Value From Genre', N'Genres', N'DVD')
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (6, N'Rate Point', 1, NULL, N'RatePoint', N'DVD')
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (7, N'Rate Count', 1, NULL, N'RateCount', N'DVD')
INSERT [dbo].[ObjectOfBrowsingRule] ([Id], [Name], [IsBase], [QueryToGetValue], [CollToMapping], [TableToMapping]) VALUES (8, N'Supplier', 0, N'Select Supplier.Id as Id, Supplier.Title As Value From Supplier', N'SupperlierId', N'DVD')
SET IDENTITY_INSERT [dbo].[ObjectOfBrowsingRule] OFF
/****** Object:  Table [dbo].[News]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Member]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[MappingTable]    Script Date: 06/12/2013 16:33:14 ******/
SET IDENTITY_INSERT [dbo].[MappingTable] ON
INSERT [dbo].[MappingTable] ([TableA], [TableB], [QueryToJoin], [Id]) VALUES (N'DVD', N'DVD', N'FROM DVD', 1)
INSERT [dbo].[MappingTable] ([TableA], [TableB], [QueryToJoin], [Id]) VALUES (N'DVD', N'Song', N'FROM DVD INNER JOIN AlbumMusicMapping ON DVD.AlbumId = AlbumMusicMapping.AlbumId INNER JOIN Song ON AlbumMusicMapping.SongId = Song.Id', 2)
INSERT [dbo].[MappingTable] ([TableA], [TableB], [QueryToJoin], [Id]) VALUES (N'DVD', N'BillDetail', N'FROM BillDetail INNER JOIN DVD ON BillDetail.DvdId = DVD.Id WHERE (DVD.IsDeleted = 0)', 3)
INSERT [dbo].[MappingTable] ([TableA], [TableB], [QueryToJoin], [Id]) VALUES (N'DVD', N'Comemt', N'FROM DVD INNER JOIN Comment ON DVD.Id = Comment.DvdID WHERE (DVD.IsDeleted = 0) AND (Comment.IsDeleted = 0)', 4)
INSERT [dbo].[MappingTable] ([TableA], [TableB], [QueryToJoin], [Id]) VALUES (N'DVD', N'Producer', N'FROM DVD INNER JOIN Producer ON DVD.ProducerId = Producer.Id WHERE(Producer.IsDeleted = 0) AND (DVD.IsDeleted = 0)', 5)
SET IDENTITY_INSERT [dbo].[MappingTable] OFF
/****** Object:  Table [dbo].[ManagePermissionMapping]    Script Date: 06/12/2013 16:33:14 ******/
INSERT [dbo].[ManagePermissionMapping] ([ManageId], [PermissionId]) VALUES (1, 1)
/****** Object:  Table [dbo].[Manage]    Script Date: 06/12/2013 16:33:14 ******/
SET IDENTITY_INSERT [dbo].[Manage] ON
INSERT [dbo].[Manage] ([Id], [Name], [Password], [Info], [Position], [NewLogin], [LastLogin], [CreatedDate], [ModifiedDate], [IsLock]) VALUES (1, N'systemadmin', N'123456', N'System Admin', 0, NULL, CAST(0x0000A1DB00EB89B5 AS DateTime), CAST(0x0000A1D9009A4BDA AS DateTime), CAST(0x0000A1D9009B85EF AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Manage] OFF
/****** Object:  Table [dbo].[Genre]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[FileData]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Feedback]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[DVD]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Comment]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Category]    Script Date: 06/12/2013 16:33:14 ******/
SET IDENTITY_INSERT [dbo].[Category] ON
INSERT [dbo].[Category] ([Id], [Name], [Query], [Description], [CategoryParentId], [CreatedDate], [ModifiedDate], [IsDeleted], [WoodenLeg], [CateLevel]) VALUES (1, N'All Product', N'Select * from DVD', N'all product in store', 0, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0, N'1', 0)
INSERT [dbo].[Category] ([Id], [Name], [Query], [Description], [CategoryParentId], [CreatedDate], [ModifiedDate], [IsDeleted], [WoodenLeg], [CateLevel]) VALUES (2, N'Game', N'Select * from DVD where Type = ''game''', N'all game', 1, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0, N'10002', 1)
INSERT [dbo].[Category] ([Id], [Name], [Query], [Description], [CategoryParentId], [CreatedDate], [ModifiedDate], [IsDeleted], [WoodenLeg], [CateLevel]) VALUES (3, N'Movie', N'Select * from DVD Where Type = ''movie''', N'all movie', 1, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0, N'10003', 1)
INSERT [dbo].[Category] ([Id], [Name], [Query], [Description], [CategoryParentId], [CreatedDate], [ModifiedDate], [IsDeleted], [WoodenLeg], [CateLevel]) VALUES (4, N'Album', N'Select * from DVD Where Type = ''music''', N'all music', 1, CAST(0x0000A1D000000000 AS DateTime), CAST(0x0000A1D000000000 AS DateTime), 0, N'10004', 1)
INSERT [dbo].[Category] ([Id], [Name], [Query], [Description], [CategoryParentId], [CreatedDate], [ModifiedDate], [IsDeleted], [WoodenLeg], [CateLevel]) VALUES (6, N'Nhac trinh', N'SELECT DVD.* FROM DVD inner join (SELECT DISTINCT c2.ComposerId As ComposerId , c2.Id As Id  FROM (Select DVD.Id, Song.ComposerId FROM  DVD INNER JOIN  Album ON DVD.DetailId = Album.Id INNER JOIN   AlbumMusicMapping ON Album.Id = AlbumMusicMapping.AlbumId INNER JOIN Song ON AlbumMusicMapping.SongId = Song.Id WHERE(DVD.IsDeleted = 0) AND (Song.IsDeleted = 0)) As c2 WHERE c2.ComposerId = ''5'') as a2 on DVD.id = a2.id inner join (Select * from DVD Where Type = ''music'') as b2 on DVD.id = b2.id', N'nhac trinh cong son', 4, CAST(0x0000A1D5012A3C5B AS DateTime), CAST(0x0000A1D5012A3C5B AS DateTime), 0, N'40005', 2)
SET IDENTITY_INSERT [dbo].[Category] OFF
/****** Object:  Table [dbo].[Browser]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[BillDetail]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Bill]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Artist]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[AlbumMusicMapping]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Album]    Script Date: 06/12/2013 16:33:14 ******/
/****** Object:  Table [dbo].[Advertising]    Script Date: 06/12/2013 16:33:14 ******/
