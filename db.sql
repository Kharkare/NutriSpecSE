-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 01, 2020 at 01:50 AM
-- Server version: 8.0.18
-- PHP Version: 7.3.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nutrispecdb`
--
CREATE DATABASE IF NOT EXISTS `nutrispecdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `nutrispecdb`;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_client`
--

CREATE TABLE `tbl_client` (
  `id` int(11) NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `weight` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `height` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bmi` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bloodgroup` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `profilepic` text CHARACTER SET utf8 COLLATE utf8_general_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_nutritionist`
--

CREATE TABLE `tbl_nutritionist` (
  `id` int(11) NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `specializations` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pincode` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `qualification` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `about` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `operatingHours` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operatingDays` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_ratings`
--

CREATE TABLE `tbl_ratings` (
  `id` int(11) NOT NULL,
  `client` int(11) NOT NULL,
  `nutritionist` int(11) NOT NULL,
  `ratings_number` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratings_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_client`
--
ALTER TABLE `tbl_client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_nutritionist`
--
ALTER TABLE `tbl_nutritionist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_ratings`
--
ALTER TABLE `tbl_ratings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `foreign_key_client_nutritionist` (`client`,`nutritionist`) USING BTREE,
  ADD KEY `nutritionist_id_foreignkey` (`nutritionist`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_client`
--
ALTER TABLE `tbl_client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_nutritionist`
--
ALTER TABLE `tbl_nutritionist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_ratings`
--
ALTER TABLE `tbl_ratings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_ratings`
--
ALTER TABLE `tbl_ratings`
  ADD CONSTRAINT `client_id_foreignkey` FOREIGN KEY (`client`) REFERENCES `tbl_client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nutritionist_id_foreignkey` FOREIGN KEY (`nutritionist`) REFERENCES `tbl_nutritionist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
