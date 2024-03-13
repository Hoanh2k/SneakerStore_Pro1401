USE [Sneacker_Store]
GO
/****** Object:  Table [dbo].[CHAT_LIEU]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHAT_LIEU](
	[MaCL] [int] IDENTITY(50,1) NOT NULL,
	[TenChatLieu] [nvarchar](40) NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CHAT_LIEU_DE_GIAY]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHAT_LIEU_DE_GIAY](
	[MaCLDe] [int] IDENTITY(20,1) NOT NULL,
	[TenChatLieuDe] [nvarchar](40) NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCLDe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CHI_TIET_SAN_PHAM]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHI_TIET_SAN_PHAM](
	[MaCTSP] [int] IDENTITY(60,1) NOT NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[MaSP] [int] NULL,
	[MaCLDe] [int] NULL,
	[MaSize] [int] NULL,
	[MaMS] [int] NULL,
	[MaCL] [int] NULL,
	[MoTa] [nvarchar](100) NULL,
	[MaGG] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DANH_MUC]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DANH_MUC](
	[MaDM] [int] IDENTITY(1,1) NOT NULL,
	[TenDanhMuc] [nvarchar](50) NOT NULL,
	[TrangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DOI_TRA]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DOI_TRA](
	[MaDT] [int] IDENTITY(120,1) NOT NULL,
	[MaHDCT] [int] NULL,
	[LyDoDoi] [nvarchar](100) NOT NULL,
	[NgayDoiTra] [date] NULL,
	[TrangThai] [bit] NOT NULL,
	[MoTa] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Giam_Gia]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Giam_Gia](
	[MaGG] [int] IDENTITY(1,1) NOT NULL,
	[TenMaGiam] [nvarchar](50) NULL,
	[MucGiam] [float] NULL,
	[NgayBatDau] [date] NULL,
	[NgayKetThuc] [date] NULL,
	[GhiChu] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaGG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOA_DON]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOA_DON](
	[MaHD] [int] IDENTITY(80,1) NOT NULL,
	[NgayTao] [varchar](20) NULL,
	[TongTien] [float] NULL,
	[TrangThai] [bit] NULL,
	[MaTTKH] [int] NULL,
	[MaNV] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOA_DON_CHI_TIET]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOA_DON_CHI_TIET](
	[MaHDCT] [int] IDENTITY(90,1) NOT NULL,
	[MaCTSP] [int] NULL,
	[MaHD] [int] NULL,
	[MaTT] [int] NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[MaKM] [int] NULL,
	[GhiChu] [nvarchar](70) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHDCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHUYEN_MAI]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHUYEN_MAI](
	[MaKM] [int] IDENTITY(110,1) NOT NULL,
	[TenKhuyenMai] [nvarchar](100) NULL,
	[NgayBD] [date] NULL,
	[NgayKT] [date] NULL,
	[MucGiam] [float] NULL,
	[MaGiam] [nvarchar](8) NULL,
	[DonVi] [bit] NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MAU_SAC]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAU_SAC](
	[MaMS] [int] IDENTITY(40,1) NOT NULL,
	[TenMau] [nvarchar](20) NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaMS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHAN_VIEN]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHAN_VIEN](
	[MaNV] [int] IDENTITY(70,1) NOT NULL,
	[TenDangNhap] [varchar](50) NOT NULL,
	[MatKhau] [varchar](8) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[DienThoai] [varchar](10) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[NgayTao] [date] NOT NULL,
	[ChucVu] [nvarchar](30) NOT NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [unique_TenDangNhap] UNIQUE NONCLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SAN_PHAM]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SAN_PHAM](
	[MaSP] [int] IDENTITY(30,3) NOT NULL,
	[TenSP] [nvarchar](100) NULL,
	[NgayNhap] [varchar](20) NULL,
	[NgayCapNhat] [varchar](20) NULL,
	[TrangThai] [nvarchar](30) NULL,
	[MaDM] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SAN_PHAM_LOI]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SAN_PHAM_LOI](
	[MaSPL] [int] IDENTITY(130,1) NOT NULL,
	[TenLoi] [nvarchar](50) NOT NULL,
	[MoTa] [nvarchar](100) NOT NULL,
	[MaHDCT] [int] NULL,
	[SoLuongSPLoi] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSPL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SIZE]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SIZE](
	[MaSize] [int] IDENTITY(30,1) NOT NULL,
	[KichThuoc] [int] NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSize] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[THANH_TOAN]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[THANH_TOAN](
	[MaTT] [int] IDENTITY(90,1) NOT NULL,
	[HinhThucThanhToan] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[THONG_TIN_KH]    Script Date: 3/10/2024 4:46:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[THONG_TIN_KH](
	[MaTTKH] [int] IDENTITY(100,5) NOT NULL,
	[TenKH] [nvarchar](50) NULL,
	[SDT] [varchar](10) NULL,
	[NgayCN] [date] NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTTKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[HOA_DON] ADD  CONSTRAINT [df_TrangThai]  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[CHI_TIET_SAN_PHAM]  WITH CHECK ADD FOREIGN KEY([MaCLDe])
REFERENCES [dbo].[CHAT_LIEU_DE_GIAY] ([MaCLDe])
GO
ALTER TABLE [dbo].[CHI_TIET_SAN_PHAM]  WITH CHECK ADD FOREIGN KEY([MaSize])
REFERENCES [dbo].[SIZE] ([MaSize])
GO
ALTER TABLE [dbo].[CHI_TIET_SAN_PHAM]  WITH CHECK ADD FOREIGN KEY([MaCL])
REFERENCES [dbo].[CHAT_LIEU] ([MaCL])
GO
ALTER TABLE [dbo].[CHI_TIET_SAN_PHAM]  WITH CHECK ADD FOREIGN KEY([MaMS])
REFERENCES [dbo].[MAU_SAC] ([MaMS])
GO
ALTER TABLE [dbo].[CHI_TIET_SAN_PHAM]  WITH CHECK ADD FOREIGN KEY([MaSP])
REFERENCES [dbo].[SAN_PHAM] ([MaSP])
GO
ALTER TABLE [dbo].[CHI_TIET_SAN_PHAM]  WITH CHECK ADD  CONSTRAINT [FK_MaGG] FOREIGN KEY([MaGG])
REFERENCES [dbo].[Giam_Gia] ([MaGG])
GO
ALTER TABLE [dbo].[CHI_TIET_SAN_PHAM] CHECK CONSTRAINT [FK_MaGG]
GO
ALTER TABLE [dbo].[DOI_TRA]  WITH CHECK ADD FOREIGN KEY([MaHDCT])
REFERENCES [dbo].[HOA_DON_CHI_TIET] ([MaHDCT])
GO
ALTER TABLE [dbo].[HOA_DON]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NHAN_VIEN] ([MaNV])
GO
ALTER TABLE [dbo].[HOA_DON]  WITH CHECK ADD FOREIGN KEY([MaTTKH])
REFERENCES [dbo].[THONG_TIN_KH] ([MaTTKH])
GO
ALTER TABLE [dbo].[HOA_DON_CHI_TIET]  WITH CHECK ADD FOREIGN KEY([MaCTSP])
REFERENCES [dbo].[CHI_TIET_SAN_PHAM] ([MaCTSP])
GO
ALTER TABLE [dbo].[HOA_DON_CHI_TIET]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HOA_DON] ([MaHD])
GO
ALTER TABLE [dbo].[HOA_DON_CHI_TIET]  WITH CHECK ADD FOREIGN KEY([MaKM])
REFERENCES [dbo].[KHUYEN_MAI] ([MaKM])
GO
ALTER TABLE [dbo].[HOA_DON_CHI_TIET]  WITH CHECK ADD FOREIGN KEY([MaTT])
REFERENCES [dbo].[THANH_TOAN] ([MaTT])
GO
ALTER TABLE [dbo].[SAN_PHAM]  WITH CHECK ADD FOREIGN KEY([MaDM])
REFERENCES [dbo].[DANH_MUC] ([MaDM])
GO
ALTER TABLE [dbo].[SAN_PHAM_LOI]  WITH CHECK ADD FOREIGN KEY([MaHDCT])
REFERENCES [dbo].[HOA_DON_CHI_TIET] ([MaHDCT])
GO
