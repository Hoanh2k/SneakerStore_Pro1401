CREATE DATABASE SneakerStore
GO
USE SneakerStore
GO
--drop database SneakerStore

create table  DANH_MUC
(
	MaDM int IDENTITY(1,1) primary key ,
	TenDanhMuc nvarchar(50) not null,
	TrangThai bit not null
)
GO
select * from DANH_MUC

CREATE TABLE SAN_PHAM
(
	MaSP int IDENTITY(30,3),
	TenSP NVARCHAR(100),
	NgayNhap VARCHAR(20),
	NgayCapNhat VARCHAR(20),
	TrangThai NVARCHAR(30),
	MaDM int,
	PRIMARY KEY (MaSP),
	FOREIGN KEY (MaDM) REFERENCES DANH_MUC(MaDM)
)
GO
insert into SAN_PHAM values( N'Giày Voremo ', '2024-03-03', '2024-03-03', 1,1)
insert into SAN_PHAM values( N'Giày AriForce ', '2024-03-03', '2024-03-03', 1,2)
insert into SAN_PHAM values( N'Giày Flex Experience ', '2024-03-03', '2024-03-03', 1,1)
insert into SAN_PHAM values( N'Giày Dowshipfer ', '2024-03-03', '2024-03-03', 1,2)
insert into SAN_PHAM values( N'Giày Pureboost ', '2024-03-03', '2024-03-03', 1,2)


CREATE TABLE CHAT_LIEU_DE_GIAY(
	MaCLDe INT IDENTITY(20,1) NOT NULL PRIMARY KEY,
	TenChatLieuDe NVARCHAR(40),
	TrangThai BIT,
)
GO
insert into CHAT_LIEU_DE_GIAY values( N'Đế Giày Hơi ', 1)
insert into CHAT_LIEU_DE_GIAY values( N'Đế Mềm ', 1)
insert into CHAT_LIEU_DE_GIAY values( N'Đế Cứng ', 1)
insert into CHAT_LIEU_DE_GIAY values( N'Đế Fit ', 1)
go
CREATE TABLE SIZE(
	MaSize INT IDENTITY(30,1) NOT NULL PRIMARY KEY,
	KichThuoc INT,
	TrangThai BIT,
)
GO

insert into SIZE values( 38, 1)
insert into SIZE values( 39, 1)
insert into SIZE values( 40, 1)
insert into SIZE values( 41, 1)
insert into SIZE values( 42, 1)

CREATE TABLE MAU_SAC(
	MaMS INT IDENTITY(40,1) NOT NULL PRIMARY KEY,
	TenMau NVARCHAR(20),
	TrangThai BIT
)
GO
insert into MAU_SAC values( N'Trắng', 1)
insert into MAU_SAC values( N'Vàng', 1)
insert into MAU_SAC values( N'Xám', 1)
insert into MAU_SAC values( N'Đen', 1)
insert into MAU_SAC values( N'Hồng', 1)

CREATE TABLE CHAT_LIEU(
	MaCL INT IDENTITY(50,1) NOT NULL PRIMARY KEY,
	TenChatLieu NVARCHAR(40),
	TrangThai BIT,
)
GO
insert into CHAT_LIEU values( N'Vải', 1)
insert into CHAT_LIEU values( N'Da', 1)
insert into CHAT_LIEU values( N'Lưới', 1)


create TABLE CHI_TIET_SAN_PHAM
(
	MaCTSP int IDENTITY(60,1),
	SoLuong INT,
	DonGia float,
	MaSP int,
	MaCLDe int,
	MaSize INT,
	MaMS INT,
	MaCL INT,
	MoTa NVARCHAR(100),
	PRIMARY KEY (MaCTSP),
	FOREIGN KEY (MaSP) REFERENCES SAN_PHAM(MaSP),
	FOREIGN KEY (MaCLDe) REFERENCES CHAT_LIEU_DE_GIAY(MaCLDe),
	FOREIGN KEY (MaSize) REFERENCES SIZE(MaSize),
	FOREIGN KEY (MaMS) REFERENCES MAU_SAC(MaMS),
	FOREIGN KEY (MaCL) REFERENCES CHAT_LIEU(MaCL)
)
GO

insert into CHI_TIET_SAN_PHAM values(20, 10000, 30, 20, 30,40, 50, 'Giay 1')
insert into CHI_TIET_SAN_PHAM values(20, 11000, 42, 23, 34,44, 52, 'Giay 1')
insert into CHI_TIET_SAN_PHAM values(20, 10000, 33, 21, 31,41, 51, 'Giay 1')
insert into CHI_TIET_SAN_PHAM values(20, 10000, 36, 22, 32,42, 51, 'Giay 1')
insert into CHI_TIET_SAN_PHAM values(20, 30000, 39, 23, 33,43, 50, 'Giay 1')

--create table GIA_TIEN
--(
--MaGT int IDENTITY(10,5) primary key,
--MaCTSP int,
--NgayCapNhat date,
--GiaTien float
--)
--go

--CREATE TABLE VOUCHER
--(
--MaVC int IDENTITY(60,1),
--NgayBatDau date,
--NgayKetThuc date,
--MucGiam float
--)
--go
--drop table nhan_vien
create table NHAN_VIEN(
	MaNV int IDENTITY(70,1) primary key,
	TenDangNhap varchar(50) UNIQUE not null,
	MatKhau varchar(8) not null,
	HoTen	nvarchar(50) not null,
	GioiTinh bit not null,
	DienThoai varchar(10) not null,
	Email nvarchar(50) not null,
	NgayTao date not null,
	ChucVu bit not null,
	TrangThai bit
)

select * from NHAN_VIEN



ALTER TABLE Nhan_vien
ALTER COLUMN chucvu bit
GO


--ALTER TABLE NHAN_VIEN
--ADD CONSTRAINT unique_TenDangNhap UNIQUE(TenDangNhap);
--alter table tai_khoan alter column ngaytao date
CREATE TABLE THONG_TIN_KH
(
	MaTTKH int IDENTITY(100,5),
	TenKH NVARCHAR(50),
	SDT VARCHAR(10),
	NgayCN DATE,
	TrangThai bit
	PRIMARY KEY (MaTTKH)
)
GO



create table HOA_DON(
	MaHD int IDENTITY(80,1) primary key,
	NgayTao VARCHAR(20),	
	TongTien float,
	TrangThai BIT DEFAULT(0),
	MaTTKH int,
	MaNV INT not null,
	foreign key (MaTTKH) references  THONG_TIN_KH(MaTTKH),
	foreign key (MaNV) references  NHAN_VIEN(MaNV),
)
GO
--ALTER TABLE Hoa_Don ALTER COLUMN TrangThai BIT;


--ALTER TABLE Hoa_Don ADD CONSTRAINT df_TrangThai DEFAULT 1 FOR TrangThai
--ALTER TABLE Hoa_Don DROP CONSTRAINT df_TrangThai




create table HOA_DON_CHI_TIET
(
	MaHDCT int IDENTITY(90,1) primary key,
	MaCTSP INT,
	MaHD int,
	MaTT int,
	SoLuong INT,
	DonGia FLOAT,
	MaKM int,
	GhiChu NVARCHAR (70),
	foreign key (MaCTSP) references  CHI_TIET_SAN_PHAM(MaCTSP),
	foreign key (MaHD) references  HOA_DON(MaHD),
	foreign key (MaTT) references  THANH_TOAN(MaTT),
	foreign key (MaKM ) references  KHUYEN_MAI(MaKM )
)
go

--drop table HOA_DON_CHI_TIET
CREATE table THANH_TOAN(
	MaTT int IDENTITY(90,1) primary key,
	HinhThucThanhToan nvarchar(20) not null
)
go



CREATE TABLE KHUYEN_MAI
(
	MaKM int IDENTITY(110,1),
	TenKhuyenMai NVARCHAR(100),
	NgayBD DATE,
	NgayKT DATE,
	MucGiam FLOAT,
	MaGiam NVARCHAR(8),
	DonVi bit,
	TrangThai BIT,
	PRIMARY KEY (MaKM)
)
GO

create table DOI_TRA
(
	MaDT int IDENTITY(120,1) primary key,
	MaHDCT int,
	LyDoDoi nvarchar(100) not null,
	NgayDoiTra date ,
	TrangThai bit not null,
	MoTa nvarchar(100) not null,
	foreign key (MaHDCT) references HOA_DON_CHI_TIET(MaHDCT)
)
go

create table SAN_PHAM_LOI
(
	MaSPL int IDENTITY(130,1) primary key,
	TenLoi nvarchar(50) not null,
	MoTa nvarchar(100) not null,
	MaHDCT int,
	SoLuongSPLoi int,
	foreign key (MaHDCT) references HOA_DON_CHI_TIET(MaHDCT)
)
GO


insert into DANH_MUC values(N'Giày ĐI Bộ', 1)
insert into DANH_MUC values( N'Giày Chạy ', 1)


insert into THONG_TIN_KH values(N'Anh A' ,'0123456789' ,'2024-03-09' ,1 )
insert into THONG_TIN_KH values(N'Anh C' ,'0123456798' ,'2024-03-09' ,1 )
insert into THONG_TIN_KH values(N'Chị B' ,'0123456799' ,'2024-03-09' ,1 )
go

create table Giam_Gia
(
MaGG int identity(1,1) primary key,
TenMaGiam nvarchar(50), 
MucGiam float,
NgayBatDau date,
NgayKetThuc date,
GhiChu nvarchar(100)
)


select * from Giam_Gia

insert into Giam_Gia values (N'Giảm Giá 1', 2000, '2024-03-03', '2024-04-01', N'Giảm giá sản phẩm bán ít')
insert into Giam_Gia values (N'Giảm Giá 2', 100000, '2024-03-03', '2024-04-01', N'Giảm giá sản phẩm bán ít')
insert into Giam_Gia values (N'Giảm Giá 3', 200000, '2024-03-03', '2024-04-01', N'Giảm giá sản phẩm bán ít')


alter table Chi_Tiet_San_Pham add MaGG int
--select * from Chi_Tiet_San_Pham

ALTER TABLE Chi_Tiet_San_Pham
ADD CONSTRAINT FK_MaGG
FOREIGN KEY (MaGG) REFERENCES Giam_Gia(MaGG);

select * from NHAN_VIEN
select * from Giam_Gia

