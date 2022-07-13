-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 13, 2022 at 05:13 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shoes_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `pr_name` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` float NOT NULL,
  `type` varchar(30) NOT NULL,
  `image` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `pr_name`, `quantity`, `price`, `type`, `image`) VALUES
(16, 'Adidas', 22, 300000, 'Rep', 'https://cdn.shopify.com/s/files/1/0452/9497/7192/products/snkden5.jpg?v=1625514266'),
(17, 'Mc Queen', 30, 450000, 'Rep', 'https://saigonsneaker.com/wp-content/uploads/2021/10/NVTC-SS0428327-SS0428349SS0428355-5-scaled-1-350x350.jpg'),
(18, 'Balenciaga', 50, 500000, 'Rep', 'https://deestore.vn/wp-content/uploads/2019/07/Giay-sneaker-1199x800.jpg'),
(19, 'Nike', 20, 540000, 'Rep', 'https://i.pinimg.com/736x/b6/db/90/b6db9036bce78a10e4774347aa1fbcdb.jpg'),
(23, 'NikeMin', 50, 450000, 'SFri', 'https://chuyensigiaythethao.com/wp-content/uploads/2020/08/dddf7006aaf656a80fe7-2.jpg'),
(24, 'Jordan', 23, 700000, 'Rep', 'https://cf.shopee.vn/file/b9cea086f0184c4f404587d5688c04d9');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
