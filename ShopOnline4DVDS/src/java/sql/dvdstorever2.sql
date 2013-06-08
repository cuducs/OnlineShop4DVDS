USE [master]
GO
/****** Object:  Database [DVDStoreVer2]    Script Date: 06/06/2013 19:24:22 ******/
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀匀甀瀀瀀氀椀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀搀攀昀愀甀氀琀开挀漀渀猀琀爀愀椀渀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䐀䘀开伀爀搀攀爀开匀琀愀琀甀猀崀✀⤀ 䄀一䐀 瀀愀爀攀渀琀开漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䈀椀氀氀崀✀⤀⤀ഀ਀䈀攀最椀渀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 搀戀漀⸀猀礀猀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀䐀䘀开伀爀搀攀爀开匀琀愀琀甀猀崀✀⤀ 䄀一䐀 琀礀瀀攀 㴀 ✀䐀✀⤀ഀ਀䈀䔀䜀䤀一ഀ਀䄀䰀吀䔀刀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䈀椀氀氀崀 䐀刀伀倀 䌀伀一匀吀刀䄀䤀一吀 嬀䐀䘀开伀爀搀攀爀开匀琀愀琀甀猀崀ഀ਀䔀一䐀ഀ਀ഀ਀ഀ਀䔀渀搀ഀ਀䜀伀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀搀攀昀愀甀氀琀开挀漀渀猀琀爀愀椀渀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䐀䘀开䐀嘀䐀开䐀椀猀挀一甀洀戀攀爀崀✀⤀ 䄀一䐀 瀀愀爀攀渀琀开漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䐀嘀䐀崀✀⤀⤀ഀ਀䈀攀最椀渀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 搀戀漀⸀猀礀猀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀䐀䘀开䐀嘀䐀开䐀椀猀挀一甀洀戀攀爀崀✀⤀ 䄀一䐀 琀礀瀀攀 㴀 ✀䐀✀⤀ഀ਀䈀䔀䜀䤀一ഀ਀䄀䰀吀䔀刀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 䐀刀伀倀 䌀伀一匀吀刀䄀䤀一吀 嬀䐀䘀开䐀嘀䐀开䐀椀猀挀一甀洀戀攀爀崀ഀ਀䔀一䐀ഀ਀ഀ਀ഀ਀䔀渀搀ഀ਀䜀伀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀搀攀昀愀甀氀琀开挀漀渀猀琀爀愀椀渀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䐀䘀开䘀攀攀搀戀愀挀欀开匀琀愀琀甀猀崀✀⤀ 䄀一䐀 瀀愀爀攀渀琀开漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䘀攀攀搀戀愀挀欀崀✀⤀⤀ഀ਀䈀攀最椀渀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 搀戀漀⸀猀礀猀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀䐀䘀开䘀攀攀搀戀愀挀欀开匀琀愀琀甀猀崀✀⤀ 䄀一䐀 琀礀瀀攀 㴀 ✀䐀✀⤀ഀ਀䈀䔀䜀䤀一ഀ਀䄀䰀吀䔀刀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䘀攀攀搀戀愀挀欀崀 䐀刀伀倀 䌀伀一匀吀刀䄀䤀一吀 嬀䐀䘀开䘀攀攀搀戀愀挀欀开匀琀愀琀甀猀崀ഀ਀䔀一䐀ഀ਀ഀ਀ഀ਀䔀渀搀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀搀瘀攀爀琀椀猀椀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䄀搀瘀攀爀琀椀猀椀渀最崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䄀搀瘀攀爀琀椀猀椀渀最崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䈀椀氀氀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䈀椀氀氀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䈀椀氀氀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䈀椀氀氀䐀攀琀愀椀氀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䈀椀氀氀䐀攀琀愀椀氀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䈀椀氀氀䐀攀琀愀椀氀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䈀爀漀眀猀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䈀爀漀眀猀攀爀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䈀爀漀眀猀攀爀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䌀漀洀洀攀渀琀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䌀漀洀洀攀渀琀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䌀漀洀洀攀渀琀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䐀嘀䐀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䘀攀攀搀戀愀挀欀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䘀攀攀搀戀愀挀欀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䘀攀攀搀戀愀挀欀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䘀椀氀攀䐀愀琀愀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䘀椀氀攀䐀愀琀愀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䘀椀氀攀䐀愀琀愀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䜀愀洀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䜀愀洀攀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䜀愀洀攀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䜀攀渀爀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䜀攀渀爀攀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䜀攀渀爀攀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀愀渀愀最攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䴀愀渀愀最攀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䴀愀渀愀最攀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀愀渀愀最攀倀攀爀洀椀猀猀椀漀渀䴀愀瀀瀀椀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䴀愀渀愀最攀倀攀爀洀椀猀猀椀漀渀䴀愀瀀瀀椀渀最崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䴀愀渀愀最攀倀攀爀洀椀猀猀椀漀渀䴀愀瀀瀀椀渀最崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀愀瀀瀀椀渀最吀愀戀氀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䴀愀瀀瀀椀渀最吀愀戀氀攀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䴀愀瀀瀀椀渀最吀愀戀氀攀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀攀洀戀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䴀攀洀戀攀爀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䴀攀洀戀攀爀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀漀瘀椀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䴀漀瘀椀攀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䴀漀瘀椀攀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀一攀眀猀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀一攀眀猀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀一攀眀猀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀伀戀樀攀挀琀伀昀䈀爀漀眀猀椀渀最刀甀氀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀伀戀樀攀挀琀伀昀䈀爀漀眀猀椀渀最刀甀氀攀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀伀戀樀攀挀琀伀昀䈀爀漀眀猀椀渀最刀甀氀攀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀攀爀洀椀猀猀椀漀渀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀倀攀爀洀椀猀猀椀漀渀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀倀攀爀洀椀猀猀椀漀渀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀爀漀搀甀挀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀倀爀漀搀甀挀攀爀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀倀爀漀搀甀挀攀爀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀爀漀洀漀琀椀漀渀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀倀爀漀洀漀琀椀漀渀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀倀爀漀洀漀琀椀漀渀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀爀漀洀漀琀椀漀渀刀攀最椀猀琀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀倀爀漀洀漀琀椀漀渀刀攀最椀猀琀攀爀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀倀爀漀洀漀琀椀漀渀刀攀最椀猀琀攀爀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀刀攀瀀漀爀琀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀刀攀瀀漀爀琀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀刀攀瀀漀爀琀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀匀漀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀匀漀渀最崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀匀漀渀最崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀匀甀瀀瀀氀椀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀  䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀匀甀瀀瀀氀椀攀爀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䐀刀伀倀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀匀甀瀀瀀氀椀攀爀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀匀甀瀀瀀氀椀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀匀漀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀匀漀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀刀攀瀀漀爀琀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀匀䔀吀 䤀䐀䔀一吀䤀吀夀开䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 伀一ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㜀Ⰰ 一✀挀栀椀洀 攀渀✀Ⰰ ㄀Ⰰ 㔀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㠀Ⰰ 一✀欀栀椀 挀漀 搀漀渀 攀洀 渀栀漀 愀椀✀Ⰰ ㈀Ⰰ 㔀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㤀Ⰰ 一✀挀栀椀洀 猀愀漀✀Ⰰ ㌀Ⰰ 㔀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀　Ⰰ 一✀洀甀愀 砀甀愀渀 瘀攀✀Ⰰ 㐀Ⰰ 㔀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀㄀Ⰰ 一✀渀最甀漀椀 搀攀渀 琀甀 挀栀椀攀甀 挀栀愀甀✀Ⰰ ㄀Ⰰ 㘀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀㈀Ⰰ 一✀洀愀琀 渀愀椀✀Ⰰ ㈀Ⰰ 㘀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀㌀Ⰰ 一✀洀愀椀 洀愀椀 洀漀琀 琀椀渀栀 礀攀甀✀Ⰰ ㌀Ⰰ 㘀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀㐀Ⰰ 一✀瀀栀甀琀 戀漀椀 爀漀椀✀Ⰰ 㐀Ⰰ 㘀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀㔀Ⰰ 一✀栀愀礀 瘀攀 搀愀礀 戀攀渀 愀渀栀✀Ⰰ ㄀Ⰰ 㜀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀㘀Ⰰ 一✀欀椀攀瀀 搀漀 搀攀渀✀Ⰰ ㈀Ⰰ 㜀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀㜀Ⰰ 一✀渀最愀礀 洀漀椀 渀愀渀最 栀漀渀最✀Ⰰ ㌀Ⰰ 㜀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀㠀Ⰰ 一✀搀漀渀最 琀栀漀椀 最椀愀渀✀Ⰰ 㐀Ⰰ 㜀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀㤀Ⰰ 一✀洀漀琀 渀最愀礀 洀漀椀✀Ⰰ ㄀Ⰰ 㠀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀　Ⰰ 一✀渀攀甀 渀栀甀 愀渀栀 搀攀渀✀Ⰰ ㈀Ⰰ 㠀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀㄀Ⰰ 一✀戀攀渀 戀漀 礀攀甀 琀栀甀漀渀最✀Ⰰ ㌀Ⰰ 㠀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀㈀Ⰰ 一✀栀愀礀 洀椀渀 挀甀漀椀✀Ⰰ 㐀Ⰰ 㠀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀㌀Ⰰ 一✀戀攀渀 琀栀甀漀渀最 栀愀椀✀Ⰰ ㄀Ⰰ 㔀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀㐀Ⰰ 一✀搀甀渀最 礀攀甀 琀爀漀渀最 最漀挀 琀漀椀✀Ⰰ ㈀Ⰰ 㘀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀㔀Ⰰ 一✀搀甀漀渀最 搀攀渀 瘀椀渀栀 焀甀愀渀最✀Ⰰ ㌀Ⰰ 㜀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀匀椀渀最攀爀䤀搀崀Ⰰ 嬀䌀漀洀瀀漀猀攀爀䤀搀崀Ⰰ 嬀䰀礀爀椀挀猀崀Ⰰ 嬀䤀猀䘀爀攀攀崀Ⰰ 嬀䘀椀氀攀䤀䐀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀㘀Ⰰ 一✀砀甀愀渀 栀漀椀 渀最漀✀Ⰰ 㐀Ⰰ 㠀Ⰰ 一✀愀猀搀✀Ⰰ 　Ⰰ ㄀Ⰰ 一✀挀栀椀洀 攀渀   ✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀㄀　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀匀䔀吀 䤀䐀䔀一吀䤀吀夀开䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀匀漀渀最崀 伀䘀䘀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀刀攀瀀漀爀琀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀爀漀洀漀琀椀漀渀刀攀最椀猀琀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀爀漀洀漀琀椀漀渀刀攀最椀猀琀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀爀漀洀漀琀椀漀渀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀爀漀洀漀琀椀漀渀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀爀漀搀甀挀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀爀漀搀甀挀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀攀爀洀椀猀猀椀漀渀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀倀攀爀洀椀猀猀椀漀渀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀一攀眀猀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀伀戀樀攀挀琀伀昀䈀爀漀眀猀椀渀最刀甀氀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀攀洀戀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀漀瘀椀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀匀䔀吀 䄀一匀䤀开一唀䰀䰀匀 伀一ഀ਀䜀伀ഀ਀匀䔀吀 儀唀伀吀䔀䐀开䤀䐀䔀一吀䤀䘀䤀䔀刀 伀一ഀ਀䜀伀ഀ਀䤀䘀 一伀吀 䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䴀漀瘀椀攀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䈀䔀䜀䤀一ഀ਀䌀刀䔀䄀吀䔀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䴀漀瘀椀攀崀⠀ഀ਀ऀ嬀䤀搀崀 嬀椀渀琀崀 䤀䐀䔀一吀䤀吀夀⠀㄀Ⰰ㄀⤀ 一伀吀 一唀䰀䰀Ⰰഀ਀ऀ嬀吀椀琀氀攀崀 嬀渀瘀愀爀挀栀愀爀崀⠀㈀㔀㔀⤀ 一伀吀 一唀䰀䰀Ⰰഀ਀ऀ嬀匀琀甀搀椀漀崀 嬀渀瘀愀爀挀栀愀爀崀⠀㄀　　⤀ 一唀䰀䰀Ⰰഀ਀ऀ嬀䐀椀爀攀挀琀漀爀崀 嬀渀瘀愀爀挀栀愀爀崀⠀㄀　　⤀ 一唀䰀䰀Ⰰഀ਀ऀ嬀䄀挀琀漀爀崀 嬀渀瘀愀爀挀栀愀爀崀⠀㈀㔀㔀⤀ 一唀䰀䰀Ⰰഀ਀ऀ嬀䤀渀昀漀崀 嬀渀瘀愀爀挀栀愀爀崀⠀㄀　　　⤀ 一唀䰀䰀Ⰰഀ਀ऀ嬀吀爀愀椀氀攀爀䤀搀崀 嬀椀渀琀崀 一唀䰀䰀Ⰰഀ਀ऀ嬀䌀爀攀愀琀攀搀䐀愀琀攀崀 嬀搀愀琀攀琀椀洀攀崀 一伀吀 一唀䰀䰀Ⰰഀ਀ऀ嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀 嬀搀愀琀攀琀椀洀攀崀 一伀吀 一唀䰀䰀Ⰰഀ਀ऀ嬀䤀猀䐀攀氀攀琀攀搀崀 嬀戀椀琀崀 一伀吀 一唀䰀䰀Ⰰഀ਀ 䌀伀一匀吀刀䄀䤀一吀 嬀倀䬀开䴀漀瘀椀攀崀 倀刀䤀䴀䄀刀夀 䬀䔀夀 䌀䰀唀匀吀䔀刀䔀䐀 ഀ਀⠀ഀ਀ऀ嬀䤀搀崀 䄀匀䌀ഀ਀⤀圀䤀吀䠀 ⠀倀䄀䐀开䤀一䐀䔀堀  㴀 伀䘀䘀Ⰰ 匀吀䄀吀䤀匀吀䤀䌀匀开一伀刀䔀䌀伀䴀倀唀吀䔀  㴀 伀䘀䘀Ⰰ 䤀䜀一伀刀䔀开䐀唀倀开䬀䔀夀 㴀 伀䘀䘀Ⰰ 䄀䰀䰀伀圀开刀伀圀开䰀伀䌀䬀匀  㴀 伀一Ⰰ 䄀䰀䰀伀圀开倀䄀䜀䔀开䰀伀䌀䬀匀  㴀 伀一⤀ 伀一 嬀倀刀䤀䴀䄀刀夀崀ഀ਀⤀ 伀一 嬀倀刀䤀䴀䄀刀夀崀ഀ਀䔀一䐀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀攀洀戀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Member]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Member](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NOT NULL,
	[Email] [nvarchar](255) NOT NULL,
	[Password] [nvarchar](255) NOT NULL,
	[LastLogin] [datetime] NULL,
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀愀渀愀最攀倀攀爀洀椀猀猀椀漀渀䴀愀瀀瀀椀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀愀瀀瀀椀渀最吀愀戀氀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀愀渀愀最攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䴀愀渀愀最攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
	[LastLogin] [datetime] NULL,
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䜀攀渀爀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䜀攀渀爀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䘀椀氀攀䐀愀琀愀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䜀愀洀攀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀匀䔀吀 䄀一匀䤀开一唀䰀䰀匀 伀一ഀ਀䜀伀ഀ਀匀䔀吀 儀唀伀吀䔀䐀开䤀䐀䔀一吀䤀䘀䤀䔀刀 伀一ഀ਀䜀伀ഀ਀䤀䘀 一伀吀 䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䜀愀洀攀崀✀⤀ 䄀一䐀 琀礀瀀攀 椀渀 ⠀一✀唀✀⤀⤀ഀ਀䈀䔀䜀䤀一ഀ਀䌀刀䔀䄀吀䔀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䜀愀洀攀崀⠀ഀ਀ऀ嬀䤀搀崀 嬀椀渀琀崀 䤀䐀䔀一吀䤀吀夀⠀㄀Ⰰ㄀⤀ 一伀吀 一唀䰀䰀Ⰰഀ਀ऀ嬀吀椀琀氀攀崀 嬀渀瘀愀爀挀栀愀爀崀⠀㈀㔀㔀⤀ 一伀吀 一唀䰀䰀Ⰰഀ਀ऀ嬀䴀愀渀甀昀愀挀琀甀爀攀崀 嬀渀瘀愀爀挀栀愀爀崀⠀㈀㔀㔀⤀ 一唀䰀䰀Ⰰഀ਀ऀ嬀䤀渀昀漀崀 嬀渀瘀愀爀挀栀愀爀崀⠀㄀　　　⤀ 一唀䰀䰀Ⰰഀ਀ऀ嬀吀爀愀椀氀攀爀䤀搀崀 嬀椀渀琀崀 一唀䰀䰀Ⰰഀ਀ऀ嬀䌀爀攀愀琀攀搀䐀愀琀攀崀 嬀搀愀琀攀琀椀洀攀崀 一伀吀 一唀䰀䰀Ⰰഀ਀ऀ嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀 嬀搀愀琀攀琀椀洀攀崀 一伀吀 一唀䰀䰀Ⰰഀ਀ऀ嬀䤀猀䐀攀氀攀琀攀搀崀 嬀戀椀琀崀 一伀吀 一唀䰀䰀Ⰰഀ਀ 䌀伀一匀吀刀䄀䤀一吀 嬀倀䬀开䜀愀洀攀崀 倀刀䤀䴀䄀刀夀 䬀䔀夀 䌀䰀唀匀吀䔀刀䔀䐀 ഀ਀⠀ഀ਀ऀ嬀䤀搀崀 䄀匀䌀ഀ਀⤀圀䤀吀䠀 ⠀倀䄀䐀开䤀一䐀䔀堀  㴀 伀䘀䘀Ⰰ 匀吀䄀吀䤀匀吀䤀䌀匀开一伀刀䔀䌀伀䴀倀唀吀䔀  㴀 伀䘀䘀Ⰰ 䤀䜀一伀刀䔀开䐀唀倀开䬀䔀夀 㴀 伀䘀䘀Ⰰ 䄀䰀䰀伀圀开刀伀圀开䰀伀䌀䬀匀  㴀 伀一Ⰰ 䄀䰀䰀伀圀开倀䄀䜀䔀开䰀伀䌀䬀匀  㴀 伀一⤀ 伀一 嬀倀刀䤀䴀䄀刀夀崀ഀ਀⤀ 伀一 嬀倀刀䤀䴀䄀刀夀崀ഀ਀䔀一䐀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䘀椀氀攀䐀愀琀愀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
	[Url] [ntext] NULL,
	[Type] [varchar](10) NULL,
	[ViewCount] [int] NULL,
	[CreatedDate] [datetime] NOT NULL,
	[ModifiedDate] [datetime] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Files] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
㰼㰼㰼㰠䡅䅄਀⤀ 伀一 嬀倀刀䤀䴀䄀刀夀崀 吀䔀堀吀䤀䴀䄀䜀䔀开伀一 嬀倀刀䤀䴀䄀刀夀崀ഀ਽㴽㴽㴽਀⤀ 伀一 嬀倀刀䤀䴀䄀刀夀崀ഀ਀䔀一䐀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊GO
SET ANSI_PADDING OFF
GO
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䘀攀攀搀戀愀挀欀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䘀攀攀搀戀愀挀欀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
	[ImgCover] [ntext] NOT NULL,
	[Author] [nvarchar](255) NOT NULL,
	[ProducerId] [int] NULL,
	[SupplierId] [int] NULL,
	[DiscNumber] [int] NULL,
	[TrailerId] [int] NULL,
	[AlbumId] [int] NULL,
	[Type] [varchar](50) NOT NULL,
	[Details] [ntext] NULL,
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䌀漀洀洀攀渀琀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀匀䔀吀 䤀䐀䔀一吀䤀吀夀开䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 伀一ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀刀攀氀攀愀猀攀䐀愀琀攀崀Ⰰ 嬀䜀攀渀爀攀猀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀倀爀椀挀攀崀Ⰰ 嬀䤀洀最䌀漀瘀攀爀崀Ⰰ 嬀䄀甀琀栀漀爀崀Ⰰ 嬀倀爀漀搀甀挀攀爀䤀搀崀Ⰰ 嬀匀甀瀀瀀氀椀攀爀䤀搀崀Ⰰ 嬀䐀椀猀挀一甀洀戀攀爀崀Ⰰ 嬀吀礀瀀攀崀Ⰰ 嬀䐀攀琀愀椀氀䤀搀崀Ⰰ 嬀刀愀琀攀倀漀椀渀琀崀Ⰰ 嬀刀愀琀攀䌀漀甀渀琀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀Ⰰ 一✀圀漀眀 昀椀猀栀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 一✀㘀⼀㄀⼀㈀　㄀㌀✀Ⰰ 一✀最愀洀攀 昀椀猀栀椀渀最✀Ⰰ ㄀　Ⰰ 一✀䌀㨀尀唀猀攀爀猀尀倀甀戀氀椀挀尀倀椀挀琀甀爀攀猀尀匀愀洀瀀氀攀 倀椀挀琀甀爀攀猀尀䐀攀猀攀爀琀⸀樀瀀最✀Ⰰ 一✀䐀甀挀✀Ⰰ ㄀Ⰰ ㄀Ⰰ ㄀Ⰰ 一✀最愀洀攀✀Ⰰ ㄀Ⰰ 　Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀刀攀氀攀愀猀攀䐀愀琀攀崀Ⰰ 嬀䜀攀渀爀攀猀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀倀爀椀挀攀崀Ⰰ 嬀䤀洀最䌀漀瘀攀爀崀Ⰰ 嬀䄀甀琀栀漀爀崀Ⰰ 嬀倀爀漀搀甀挀攀爀䤀搀崀Ⰰ 嬀匀甀瀀瀀氀椀攀爀䤀搀崀Ⰰ 嬀䐀椀猀挀一甀洀戀攀爀崀Ⰰ 嬀吀礀瀀攀崀Ⰰ 嬀䐀攀琀愀椀氀䤀搀崀Ⰰ 嬀刀愀琀攀倀漀椀渀琀崀Ⰰ 嬀刀愀琀攀䌀漀甀渀琀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㌀Ⰰ 一✀圀漀眀 琀愀渀欀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 一✀㘀⼀㄀⼀㈀　㄀㌀✀Ⰰ 一✀最愀洀攀 昀椀猀栀椀渀最✀Ⰰ 㔀　Ⰰ 一✀䌀㨀尀唀猀攀爀猀尀倀甀戀氀椀挀尀倀椀挀琀甀爀攀猀尀匀愀洀瀀氀攀 倀椀挀琀甀爀攀猀尀䐀攀猀攀爀琀⸀樀瀀最✀Ⰰ 一✀䐀甀挀✀Ⰰ ㄀Ⰰ ㄀Ⰰ ㄀Ⰰ 一✀最愀洀攀✀Ⰰ ㄀Ⰰ 　Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀刀攀氀攀愀猀攀䐀愀琀攀崀Ⰰ 嬀䜀攀渀爀攀猀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀倀爀椀挀攀崀Ⰰ 嬀䤀洀最䌀漀瘀攀爀崀Ⰰ 嬀䄀甀琀栀漀爀崀Ⰰ 嬀倀爀漀搀甀挀攀爀䤀搀崀Ⰰ 嬀匀甀瀀瀀氀椀攀爀䤀搀崀Ⰰ 嬀䐀椀猀挀一甀洀戀攀爀崀Ⰰ 嬀吀礀瀀攀崀Ⰰ 嬀䐀攀琀愀椀氀䤀搀崀Ⰰ 嬀刀愀琀攀倀漀椀渀琀崀Ⰰ 嬀刀愀琀攀䌀漀甀渀琀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㐀Ⰰ 一✀圀愀爀挀爀愀昀琀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 一✀㘀⼀㄀⼀㈀　㄀㌀✀Ⰰ 一✀最愀洀攀 昀椀猀栀椀渀最✀Ⰰ ㄀　　Ⰰ 一✀䌀㨀尀唀猀攀爀猀尀倀甀戀氀椀挀尀倀椀挀琀甀爀攀猀尀匀愀洀瀀氀攀 倀椀挀琀甀爀攀猀尀䐀攀猀攀爀琀⸀樀瀀最✀Ⰰ 一✀䐀甀挀✀Ⰰ ㄀Ⰰ ㄀Ⰰ ㄀Ⰰ 一✀最愀洀攀✀Ⰰ ㄀Ⰰ 　Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀刀攀氀攀愀猀攀䐀愀琀攀崀Ⰰ 嬀䜀攀渀爀攀猀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀倀爀椀挀攀崀Ⰰ 嬀䤀洀最䌀漀瘀攀爀崀Ⰰ 嬀䄀甀琀栀漀爀崀Ⰰ 嬀倀爀漀搀甀挀攀爀䤀搀崀Ⰰ 嬀匀甀瀀瀀氀椀攀爀䤀搀崀Ⰰ 嬀䐀椀猀挀一甀洀戀攀爀崀Ⰰ 嬀吀礀瀀攀崀Ⰰ 嬀䐀攀琀愀椀氀䤀搀崀Ⰰ 嬀刀愀琀攀倀漀椀渀琀崀Ⰰ 嬀刀愀琀攀䌀漀甀渀琀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㔀Ⰰ 一✀䴀漀琀 琀栀漀椀 琀栀漀 愀甀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 一✀㘀⼀㄀⼀㈀　㄀㌀✀Ⰰ 一✀愀氀戀甀洀 渀栀愀挀 瘀椀攀琀✀Ⰰ ㄀　㌀Ⰰ 一✀䌀㨀尀唀猀攀爀猀尀倀甀戀氀椀挀尀倀椀挀琀甀爀攀猀尀匀愀洀瀀氀攀 倀椀挀琀甀爀攀猀尀䐀攀猀攀爀琀⸀樀瀀最✀Ⰰ 一✀䐀甀挀✀Ⰰ ㄀Ⰰ ㄀Ⰰ ㄀Ⰰ 一✀洀甀猀椀挀✀Ⰰ ㈀Ⰰ 　Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀刀攀氀攀愀猀攀䐀愀琀攀崀Ⰰ 嬀䜀攀渀爀攀猀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀倀爀椀挀攀崀Ⰰ 嬀䤀洀最䌀漀瘀攀爀崀Ⰰ 嬀䄀甀琀栀漀爀崀Ⰰ 嬀倀爀漀搀甀挀攀爀䤀搀崀Ⰰ 嬀匀甀瀀瀀氀椀攀爀䤀搀崀Ⰰ 嬀䐀椀猀挀一甀洀戀攀爀崀Ⰰ 嬀吀礀瀀攀崀Ⰰ 嬀䐀攀琀愀椀氀䤀搀崀Ⰰ 嬀刀愀琀攀倀漀椀渀琀崀Ⰰ 嬀刀愀琀攀䌀漀甀渀琀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㘀Ⰰ 一✀挀愀 琀椀洀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 一✀㘀⼀㄀⼀㈀　㄀㌀✀Ⰰ 一✀愀氀戀甀洀 渀栀愀挀 瘀椀攀琀✀Ⰰ 㔀　Ⰰ 一✀䌀㨀尀唀猀攀爀猀尀倀甀戀氀椀挀尀倀椀挀琀甀爀攀猀尀匀愀洀瀀氀攀 倀椀挀琀甀爀攀猀尀䐀攀猀攀爀琀⸀樀瀀最✀Ⰰ 一✀䐀甀挀✀Ⰰ ㄀Ⰰ ㄀Ⰰ ㄀Ⰰ 一✀洀甀猀椀挀✀Ⰰ ㌀Ⰰ 　Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀刀攀氀攀愀猀攀䐀愀琀攀崀Ⰰ 嬀䜀攀渀爀攀猀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀倀爀椀挀攀崀Ⰰ 嬀䤀洀最䌀漀瘀攀爀崀Ⰰ 嬀䄀甀琀栀漀爀崀Ⰰ 嬀倀爀漀搀甀挀攀爀䤀搀崀Ⰰ 嬀匀甀瀀瀀氀椀攀爀䤀搀崀Ⰰ 嬀䐀椀猀挀一甀洀戀攀爀崀Ⰰ 嬀吀礀瀀攀崀Ⰰ 嬀䐀攀琀愀椀氀䤀搀崀Ⰰ 嬀刀愀琀攀倀漀椀渀琀崀Ⰰ 嬀刀愀琀攀䌀漀甀渀琀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㜀Ⰰ 一✀渀愀洀 洀漀椀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 一✀㘀⼀㄀⼀㈀　㄀㌀✀Ⰰ 一✀愀氀戀甀洀 渀栀愀挀 瘀椀攀琀✀Ⰰ ㈀　Ⰰ 一✀䌀㨀尀唀猀攀爀猀尀倀甀戀氀椀挀尀倀椀挀琀甀爀攀猀尀匀愀洀瀀氀攀 倀椀挀琀甀爀攀猀尀䐀攀猀攀爀琀⸀樀瀀最✀Ⰰ 一✀䐀甀挀✀Ⰰ ㄀Ⰰ ㄀Ⰰ ㄀Ⰰ 一✀洀甀猀椀挀✀Ⰰ 㐀Ⰰ 　Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀刀攀氀攀愀猀攀䐀愀琀攀崀Ⰰ 嬀䜀攀渀爀攀猀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀倀爀椀挀攀崀Ⰰ 嬀䤀洀最䌀漀瘀攀爀崀Ⰰ 嬀䄀甀琀栀漀爀崀Ⰰ 嬀倀爀漀搀甀挀攀爀䤀搀崀Ⰰ 嬀匀甀瀀瀀氀椀攀爀䤀搀崀Ⰰ 嬀䐀椀猀挀一甀洀戀攀爀崀Ⰰ 嬀吀礀瀀攀崀Ⰰ 嬀䐀攀琀愀椀氀䤀搀崀Ⰰ 嬀刀愀琀攀倀漀椀渀琀崀Ⰰ 嬀刀愀琀攀䌀漀甀渀琀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㠀Ⰰ 一✀砀甀愀渀 ㈀　㄀㌀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 一✀㘀⼀㄀⼀㈀　㄀㌀✀Ⰰ 一✀愀氀戀甀洀 渀栀愀挀 瘀椀攀琀✀Ⰰ ㌀㐀Ⰰ 一✀䌀㨀尀唀猀攀爀猀尀倀甀戀氀椀挀尀倀椀挀琀甀爀攀猀尀匀愀洀瀀氀攀 倀椀挀琀甀爀攀猀尀䐀攀猀攀爀琀⸀樀瀀最✀Ⰰ 一✀䐀甀挀✀Ⰰ ㄀Ⰰ ㄀Ⰰ ㄀Ⰰ 一✀洀甀猀椀挀✀Ⰰ 㔀Ⰰ 　Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀刀攀氀攀愀猀攀䐀愀琀攀崀Ⰰ 嬀䜀攀渀爀攀猀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀倀爀椀挀攀崀Ⰰ 嬀䤀洀最䌀漀瘀攀爀崀Ⰰ 嬀䄀甀琀栀漀爀崀Ⰰ 嬀倀爀漀搀甀挀攀爀䤀搀崀Ⰰ 嬀匀甀瀀瀀氀椀攀爀䤀搀崀Ⰰ 嬀䐀椀猀挀一甀洀戀攀爀崀Ⰰ 嬀吀礀瀀攀崀Ⰰ 嬀䐀攀琀愀椀氀䤀搀崀Ⰰ 嬀刀愀琀攀倀漀椀渀琀崀Ⰰ 嬀刀愀琀攀䌀漀甀渀琀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㤀Ⰰ 一✀砀甀愀渀 ㈀　㄀㈀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 一✀㘀⼀㄀⼀㈀　㄀㌀✀Ⰰ 一✀愀氀戀甀洀 渀栀愀挀 瘀椀攀琀✀Ⰰ 㜀㘀Ⰰ 一✀䌀㨀尀唀猀攀爀猀尀倀甀戀氀椀挀尀倀椀挀琀甀爀攀猀尀匀愀洀瀀氀攀 倀椀挀琀甀爀攀猀尀䐀攀猀攀爀琀⸀樀瀀最✀Ⰰ 一✀䐀甀挀✀Ⰰ ㄀Ⰰ ㄀Ⰰ ㄀Ⰰ 一✀洀甀猀椀挀✀Ⰰ 㘀Ⰰ 　Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀刀攀氀攀愀猀攀䐀愀琀攀崀Ⰰ 嬀䜀攀渀爀攀猀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀倀爀椀挀攀崀Ⰰ 嬀䤀洀最䌀漀瘀攀爀崀Ⰰ 嬀䄀甀琀栀漀爀崀Ⰰ 嬀倀爀漀搀甀挀攀爀䤀搀崀Ⰰ 嬀匀甀瀀瀀氀椀攀爀䤀搀崀Ⰰ 嬀䐀椀猀挀一甀洀戀攀爀崀Ⰰ 嬀吀礀瀀攀崀Ⰰ 嬀䐀攀琀愀椀氀䤀搀崀Ⰰ 嬀刀愀琀攀倀漀椀渀琀崀Ⰰ 嬀刀愀琀攀䌀漀甀渀琀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀　Ⰰ 一✀栀愀 渀漀椀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 一✀㘀⼀㄀⼀㈀　㄀㌀✀Ⰰ 一✀愀氀戀甀洀 渀栀愀挀 瘀椀攀琀✀Ⰰ ㈀　　Ⰰ 一✀䌀㨀尀唀猀攀爀猀尀倀甀戀氀椀挀尀倀椀挀琀甀爀攀猀尀匀愀洀瀀氀攀 倀椀挀琀甀爀攀猀尀䐀攀猀攀爀琀⸀樀瀀最✀Ⰰ 一✀䐀甀挀✀Ⰰ ㄀Ⰰ ㄀Ⰰ ㄀Ⰰ 一✀洀甀猀椀挀✀Ⰰ 㜀Ⰰ 　Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀刀攀氀攀愀猀攀䐀愀琀攀崀Ⰰ 嬀䜀攀渀爀攀猀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀倀爀椀挀攀崀Ⰰ 嬀䤀洀最䌀漀瘀攀爀崀Ⰰ 嬀䄀甀琀栀漀爀崀Ⰰ 嬀倀爀漀搀甀挀攀爀䤀搀崀Ⰰ 嬀匀甀瀀瀀氀椀攀爀䤀搀崀Ⰰ 嬀䐀椀猀挀一甀洀戀攀爀崀Ⰰ 嬀吀礀瀀攀崀Ⰰ 嬀䐀攀琀愀椀氀䤀搀崀Ⰰ 嬀刀愀琀攀倀漀椀渀琀崀Ⰰ 嬀刀愀琀攀䌀漀甀渀琀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀㄀Ⰰ 一✀搀愀 砀愀 洀漀琀 琀栀漀椀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 一✀㘀⼀㄀⼀㈀　㄀㌀✀Ⰰ 一✀愀氀戀甀洀 渀栀愀挀 瘀椀攀琀✀Ⰰ ㄀㔀　Ⰰ 一✀䌀㨀尀唀猀攀爀猀尀倀甀戀氀椀挀尀倀椀挀琀甀爀攀猀尀匀愀洀瀀氀攀 倀椀挀琀甀爀攀猀尀䐀攀猀攀爀琀⸀樀瀀最✀Ⰰ 一✀䐀甀挀✀Ⰰ ㄀Ⰰ ㄀Ⰰ ㄀Ⰰ 一✀洀甀猀椀挀✀Ⰰ 㠀Ⰰ 　Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀匀䔀吀 䤀䐀䔀一吀䤀吀夀开䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 伀䘀䘀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䌀漀洀洀攀渀琀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䈀爀漀眀猀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀匀䔀吀 䄀一匀䤀开倀䄀䐀䐀䤀一䜀 伀䘀䘀ഀ਀䜀伀ഀ਀匀䔀吀 䤀䐀䔀一吀䤀吀夀开䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀 伀一ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀 ⠀嬀䤀搀崀Ⰰ 嬀一愀洀攀崀Ⰰ 嬀儀甀攀爀礀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀䌀愀琀攀最漀爀礀倀愀爀攀渀琀䤀搀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀Ⰰ 嬀圀漀漀搀攀渀䰀攀最崀Ⰰ 嬀䌀愀琀攀䰀攀瘀攀氀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀Ⰰ 一✀䄀氀氀 倀爀漀搀甀挀琀✀Ⰰ 一✀匀攀氀攀挀琀 ⨀ 昀爀漀洀 䐀嘀䐀✀Ⰰ 一✀愀氀氀 瀀爀漀搀甀挀琀 椀渀 猀琀漀爀攀✀Ⰰ 　Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　Ⰰ 一✀㄀✀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀 ⠀嬀䤀搀崀Ⰰ 嬀一愀洀攀崀Ⰰ 嬀儀甀攀爀礀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀䌀愀琀攀最漀爀礀倀愀爀攀渀琀䤀搀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀Ⰰ 嬀圀漀漀搀攀渀䰀攀最崀Ⰰ 嬀䌀愀琀攀䰀攀瘀攀氀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀Ⰰ 一✀䜀愀洀攀✀Ⰰ 一✀匀攀氀攀挀琀 ⨀ 昀爀漀洀 䐀嘀䐀 眀栀攀爀攀 吀礀瀀攀 㴀 ✀✀最愀洀攀✀✀✀Ⰰ 一✀愀氀氀 最愀洀攀✀Ⰰ ㄀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　Ⰰ 一✀㄀　　　㈀✀Ⰰ ㄀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀 ⠀嬀䤀搀崀Ⰰ 嬀一愀洀攀崀Ⰰ 嬀儀甀攀爀礀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀䌀愀琀攀最漀爀礀倀愀爀攀渀琀䤀搀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀Ⰰ 嬀圀漀漀搀攀渀䰀攀最崀Ⰰ 嬀䌀愀琀攀䰀攀瘀攀氀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㌀Ⰰ 一✀䴀漀瘀椀攀✀Ⰰ 一✀匀攀氀攀挀琀 ⨀ 昀爀漀洀 䐀嘀䐀 圀栀攀爀攀 吀礀瀀攀 㴀 ✀✀洀漀瘀椀攀✀✀✀Ⰰ 一✀愀氀氀 洀漀瘀椀攀✀Ⰰ ㄀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　Ⰰ 一✀㄀　　　㌀✀Ⰰ ㄀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀 ⠀嬀䤀搀崀Ⰰ 嬀一愀洀攀崀Ⰰ 嬀儀甀攀爀礀崀Ⰰ 嬀䐀攀猀挀爀椀瀀琀椀漀渀崀Ⰰ 嬀䌀愀琀攀最漀爀礀倀愀爀攀渀琀䤀搀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀Ⰰ 嬀圀漀漀搀攀渀䰀攀最崀Ⰰ 嬀䌀愀琀攀䰀攀瘀攀氀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㐀Ⰰ 一✀䄀氀戀甀洀✀Ⰰ 一✀匀攀氀攀挀琀 ⨀ 昀爀漀洀 䐀嘀䐀 圀栀攀爀攀 吀礀瀀攀 㴀 ✀✀洀甀猀椀挀✀✀✀Ⰰ 一✀愀氀氀 洀甀猀椀挀✀Ⰰ ㄀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　Ⰰ 一✀㄀　　　㐀✀Ⰰ ㄀⤀ഀ਀匀䔀吀 䤀䐀䔀一吀䤀吀夀开䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䌀愀琀攀最漀爀礀崀 伀䘀䘀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䈀爀漀眀猀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䈀椀氀氀䐀攀琀愀椀氀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䈀椀氀氀䐀攀琀愀椀氀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䈀椀氀氀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䈀椀氀氀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀匀䔀吀 䤀䐀䔀一吀䤀吀夀开䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀 伀一ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀圀漀爀欀䄀猀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㄀Ⰰ 一✀䈀愀渀最 䬀椀攀甀✀Ⰰ 一✀挀愀 猀椀 戀愀渀最 欀椀攀甀 瘀椀攀琀 渀愀洀✀Ⰰ 一✀匀椀渀最攀爀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀圀漀爀欀䄀猀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀Ⰰ 一✀䐀愀渀 琀爀甀漀渀最✀Ⰰ 一✀挀愀 猀椀 搀愀渀 琀爀甀漀渀最 瘀椀攀琀 渀愀洀✀Ⰰ 一✀匀椀渀最攀爀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀圀漀爀欀䄀猀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㌀Ⰰ 一✀䰀愀洀 琀爀甀漀渀最✀Ⰰ 一✀䌀䄀 匀䤀 䰀䄀䴀 吀刀唀伀一䜀 嘀䤀䔀吀 一䄀䴀✀Ⰰ 一✀匀䤀一䜀䔀刀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀圀漀爀欀䄀猀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㐀Ⰰ 一✀吀栀愀渀栀 琀栀愀漀✀Ⰰ 一✀挀愀 猀椀 琀栀愀渀栀 琀栀愀漀 瘀椀攀琀 渀愀洀✀Ⰰ 一✀猀椀渀最攀爀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀圀漀爀欀䄀猀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㔀Ⰰ 一✀吀爀椀渀栀 挀漀渀最 猀漀渀✀Ⰰ 一✀渀最栀攀 猀椀 琀爀椀渀栀 挀漀渀最 猀漀渀 瘀椀攀琀 渀愀洀✀Ⰰ 一✀䌀漀洀瀀漀猀攀爀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀圀漀爀欀䄀猀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㘀Ⰰ 一✀嘁̀渀 䌀愀漀✀Ⰰ 一✀渀最栀攀 猀椀 琀爀椀渀栀 挀漀渀最 猀漀渀 瘀椀攀琀 渀愀洀✀Ⰰ 一✀䌀漀洀瀀漀猀攀爀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀圀漀爀欀䄀猀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㜀Ⰰ 一✁က漀渀 䌀栀甞꤀渀✀Ⰰ 一✀渀最栀攀 猀椀 琀爀椀渀栀 挀漀渀最 猀漀渀 瘀椀攀琀 渀愀洀✀Ⰰ 一✀䌀漀洀瀀漀猀攀爀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀䤀渀昀漀崀Ⰰ 嬀圀漀爀欀䄀猀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㠀Ⰰ 一✀吀爞꜀渀 吀椞뼀渀✀Ⰰ 一✀渀最栀攀 猀椀 琀爀椀渀栀 挀漀渀最 猀漀渀 瘀椀攀琀 渀愀洀✀Ⰰ 一✀䌀漀洀瀀漀猀攀爀✀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀匀䔀吀 䤀䐀䔀一吀䤀吀夀开䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀爀琀椀猀琀崀 伀䘀䘀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀Ⰰ 㜀Ⰰ ㄀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀Ⰰ 㠀Ⰰ ㈀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀Ⰰ 㤀Ⰰ ㌀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀Ⰰ ㄀　Ⰰ 㐀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㌀Ⰰ ㄀㄀Ⰰ ㄀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㌀Ⰰ ㄀㈀Ⰰ ㈀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㌀Ⰰ ㄀㌀Ⰰ ㌀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㌀Ⰰ ㄀㐀Ⰰ 㐀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㐀Ⰰ ㄀㔀Ⰰ ㄀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㐀Ⰰ ㄀㘀Ⰰ ㈀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㐀Ⰰ ㄀㜀Ⰰ ㌀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㐀Ⰰ ㄀㠀Ⰰ 㐀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㔀Ⰰ ㄀㤀Ⰰ ㄀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㔀Ⰰ ㈀　Ⰰ ㈀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㔀Ⰰ ㈀㄀Ⰰ ㌀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㔀Ⰰ ㈀㈀Ⰰ 㐀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㘀Ⰰ ㈀㌀Ⰰ ㄀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㘀Ⰰ ㈀㐀Ⰰ ㈀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㘀Ⰰ ㈀㔀Ⰰ ㌀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㘀Ⰰ ㈀㘀Ⰰ 㐀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㜀Ⰰ ㄀Ⰰ ㌀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㜀Ⰰ 㐀Ⰰ ㈀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㜀Ⰰ ㄀㔀Ⰰ ㄀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㜀Ⰰ ㈀　Ⰰ 㐀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㠀Ⰰ ㄀Ⰰ ㄀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㠀Ⰰ 㔀Ⰰ ㈀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㠀Ⰰ ㈀　Ⰰ 㐀⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀䴀甀猀椀挀䴀愀瀀瀀椀渀最崀 ⠀嬀䄀氀戀甀洀䤀搀崀Ⰰ 嬀匀漀渀最䤀搀崀Ⰰ 嬀吀爀愀挀欀一甀洀戀攀爀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㠀Ⰰ ㈀㈀Ⰰ ㌀⤀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
	[Description] [ntext] NULL,
	[IsAdminCreated] [bit] NOT NULL,
	[CreatedDate] [datetime] NULL,
	[ModifiedDate] [datetime] NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Album] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
㰼㰼㰼㰠䡅䅄਀⤀ 伀一 嬀倀刀䤀䴀䄀刀夀崀 吀䔀堀吀䤀䴀䄀䜀䔀开伀一 嬀倀刀䤀䴀䄀刀夀崀ഀ਽㴽㴽㴽਀⤀ 伀一 嬀倀刀䤀䴀䄀刀夀崀ഀ਀䔀一䐀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊GO
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀搀瘀攀爀琀椀猀椀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀匀䔀吀 䤀䐀䔀一吀䤀吀夀开䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀 伀一ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀伀眀渀攀爀崀Ⰰ 嬀嘀椀攀眀䌀漀甀渀琀崀Ⰰ 嬀一甀洀戀攀爀䤀琀攀洀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㈀Ⰰ 一✀䴀漀琀 琀栀漀椀 琀栀漀 愀甀✀Ⰰ 一✀一栀愀挀 嘀椀攀琀✀Ⰰ 　Ⰰ 㔀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀伀眀渀攀爀崀Ⰰ 嬀嘀椀攀眀䌀漀甀渀琀崀Ⰰ 嬀一甀洀戀攀爀䤀琀攀洀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㌀Ⰰ 一✀挀愀 琀椀洀✀Ⰰ 一✀一栀愀挀 嘀椀攀琀✀Ⰰ 　Ⰰ 㔀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀伀眀渀攀爀崀Ⰰ 嬀嘀椀攀眀䌀漀甀渀琀崀Ⰰ 嬀一甀洀戀攀爀䤀琀攀洀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㐀Ⰰ 一✀渀愀洀 洀漀椀✀Ⰰ 一✀一栀愀挀 嘀椀攀琀✀Ⰰ 　Ⰰ 㔀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀伀眀渀攀爀崀Ⰰ 嬀嘀椀攀眀䌀漀甀渀琀崀Ⰰ 嬀一甀洀戀攀爀䤀琀攀洀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㔀Ⰰ 一✀砀甀愀渀 ㈀　㄀㌀✀Ⰰ 一✀一栀愀挀 嘀椀攀琀✀Ⰰ 　Ⰰ 㔀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀伀眀渀攀爀崀Ⰰ 嬀嘀椀攀眀䌀漀甀渀琀崀Ⰰ 嬀一甀洀戀攀爀䤀琀攀洀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㘀Ⰰ 一✀砀甀愀渀 ㈀　㄀㈀✀Ⰰ 一✀一栀愀挀 嘀椀攀琀✀Ⰰ 　Ⰰ 㔀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀伀眀渀攀爀崀Ⰰ 嬀嘀椀攀眀䌀漀甀渀琀崀Ⰰ 嬀一甀洀戀攀爀䤀琀攀洀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㜀Ⰰ 一✀栀愀 渀漀椀✀Ⰰ 一✀一栀愀挀 嘀椀攀琀✀Ⰰ 　Ⰰ 㔀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀 ⠀嬀䤀搀崀Ⰰ 嬀吀椀琀氀攀崀Ⰰ 嬀伀眀渀攀爀崀Ⰰ 嬀嘀椀攀眀䌀漀甀渀琀崀Ⰰ 嬀一甀洀戀攀爀䤀琀攀洀崀Ⰰ 嬀䌀爀攀愀琀攀搀䐀愀琀攀崀Ⰰ 嬀䴀漀搀椀昀椀攀搀䐀愀琀攀崀Ⰰ 嬀䤀猀䐀攀氀攀琀攀搀崀⤀ 嘀䄀䰀唀䔀匀 ⠀㠀Ⰰ 一✀搀愀 砀愀 洀漀琀 琀栀漀椀✀Ⰰ 一✀一栀愀挀 嘀椀攀琀✀Ⰰ 　Ⰰ 㔀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 䌀䄀匀吀⠀　砀　　　　䄀㄀䐀　　　　　　　　　 䄀匀 䐀愀琀攀吀椀洀攀⤀Ⰰ 　⤀ഀ਀匀䔀吀 䤀䐀䔀一吀䤀吀夀开䤀一匀䔀刀吀 嬀搀戀漀崀⸀嬀䄀氀戀甀洀崀 伀䘀䘀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  吀愀戀氀攀 嬀搀戀漀崀⸀嬀䄀搀瘀攀爀琀椀猀椀渀最崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊SET ANSI_NULLS ON
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
㰼㰼㰼㰠䡅䅄਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  䐀攀昀愀甀氀琀 嬀䐀䘀开䘀攀攀搀戀愀挀欀开匀琀愀琀甀猀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਀䄀䰀吀䔀刀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䘀攀攀搀戀愀挀欀崀 䄀䐀䐀  䌀伀一匀吀刀䄀䤀一吀 嬀䐀䘀开䘀攀攀搀戀愀挀欀开匀琀愀琀甀猀崀  䐀䔀䘀䄀唀䰀吀 ⠀⠀　⤀⤀ 䘀伀刀 嬀䤀猀刀攀愀搀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  䐀攀昀愀甀氀琀 嬀䐀䘀开䐀嘀䐀开䐀椀猀挀一甀洀戀攀爀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਀䄀䰀吀䔀刀 吀䄀䈀䰀䔀 嬀搀戀漀崀⸀嬀䐀嘀䐀崀 䄀䐀䐀  䌀伀一匀吀刀䄀䤀一吀 嬀䐀䘀开䐀嘀䐀开䐀椀猀挀一甀洀戀攀爀崀  䐀䔀䘀䄀唀䰀吀 ⠀⠀㄀⤀⤀ 䘀伀刀 嬀䐀椀猀挀一甀洀戀攀爀崀ഀ਀䜀伀ഀ਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  䐀攀昀愀甀氀琀 嬀䐀䘀开伀爀搀攀爀开匀琀愀琀甀猀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ ㄀㤀㨀㈀㐀㨀㌀　 ⨀⨀⨀⨀⨀⨀⼀ഀ਽㴽㴽㴽਀⼀⨀⨀⨀⨀⨀⨀ 伀戀樀攀挀琀㨀  䐀攀昀愀甀氀琀 嬀䐀䘀开伀爀搀攀爀开匀琀愀琀甀猀崀    匀挀爀椀瀀琀 䐀愀琀攀㨀 　㘀⼀　㘀⼀㈀　㄀㌀ 　㜀㨀　㘀㨀　㈀ ⨀⨀⨀⨀⨀⨀⼀ഀ਀䤀䘀 一漀琀 䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 猀礀猀⸀搀攀昀愀甀氀琀开挀漀渀猀琀爀愀椀渀琀猀 圀䠀䔀刀䔀 漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䐀䘀开伀爀搀攀爀开匀琀愀琀甀猀崀✀⤀ 䄀一䐀 瀀愀爀攀渀琀开漀戀樀攀挀琀开椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀搀戀漀崀⸀嬀䈀椀氀氀崀✀⤀⤀ഀ਀䈀攀最椀渀ഀ਀䤀䘀 一伀吀 䔀堀䤀匀吀匀 ⠀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 搀戀漀⸀猀礀猀漀戀樀攀挀琀猀 圀䠀䔀刀䔀 椀搀 㴀 伀䈀䨀䔀䌀吀开䤀䐀⠀一✀嬀䐀䘀开伀爀搀攀爀开匀琀愀琀甀猀崀✀⤀ 䄀一䐀 琀礀瀀攀 㴀 ✀䐀✀⤀ഀ਀䈀䔀䜀䤀一ഀਾ㸾㸾㸾⁢牡湣栠❭慳瑥爧⁯映桴瑰猺⼯杩瑨畢⹣潭⽣畤畣猯佮汩湥卨潰㑄噄匮杩琊ALTER TABLE [dbo].[Bill] ADD  CONSTRAINT [DF_Order_Status]  DEFAULT ((0)) FOR [Status]
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
