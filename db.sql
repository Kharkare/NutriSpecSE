-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 03, 2020 at 01:02 AM
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_client`
--

INSERT INTO `tbl_client` (`id`, `name`, `email`, `weight`, `height`, `gender`, `bmi`, `password`, `age`, `bloodgroup`, `profilepic`) VALUES
(1, 'Aniket', 'aniket@gmail.com', '72', '157', 'Male', '34', 'aniket', '27', 'A+', NULL),
(2, 'Karan', 'karan@gmail.com', '60', '87', 'M', '67', 'password', '26', 'O+', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_client_food_activity`
--

CREATE TABLE `tbl_client_food_activity` (
  `id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `activity_date` date NOT NULL,
  `activity_time` timestamp NOT NULL,
  `food_quantity` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_client_nutritionist_association`
--

CREATE TABLE `tbl_client_nutritionist_association` (
  `id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `nutritionist_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_client_workout_activity`
--

CREATE TABLE `tbl_client_workout_activity` (
  `id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `workout_id` int(11) NOT NULL,
  `activity_date` date NOT NULL,
  `activity_time` time NOT NULL,
  `quantity` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_food_dictionary`
--

CREATE TABLE `tbl_food_dictionary` (
  `id` int(11) NOT NULL,
  `food_name` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `food_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `calorie_per_unit` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_food_dictionary`
--

INSERT INTO `tbl_food_dictionary` (`id`, `food_name`, `food_desc`, `calorie_per_unit`, `unit_id`) VALUES
(1, 'Dal Rice', 'A plate of rice and dal', '20', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_food_unit`
--

CREATE TABLE `tbl_food_unit` (
  `id` int(11) NOT NULL,
  `unit_name` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unit_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_food_unit`
--

INSERT INTO `tbl_food_unit` (`id`, `unit_name`, `unit_desc`) VALUES
(1, 'plate_rice_dal', 'A plate of rice and dal');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_nutritionist`
--

CREATE TABLE `tbl_nutritionist` (
  `id` int(11) NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `specializations` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pincode` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `qualification` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `about` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `operatingHours` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operatingDays` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_nutritionist`
--

INSERT INTO `tbl_nutritionist` (`id`, `name`, `email`, `password`, `specializations`, `address`, `city`, `pincode`, `qualification`, `about`, `operatingHours`, `operatingDays`) VALUES
(1, 'Dr. Kunal', 'kunal@gmail.com', 'password', 'Public, toxicology', 'Alsenberger Stasse 9', 'Hof', '95028', 'MSc', 'My about text', '7:00 AM', 'Monday, Tuesday, Wednesday');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_ratings`
--

INSERT INTO `tbl_ratings` (`id`, `client`, `nutritionist`, `ratings_number`, `ratings_text`) VALUES
(1, 1, 1, '4', 'Good doctor'),
(2, 2, 1, '2', 'Not so good');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_workout_dictionary`
--

CREATE TABLE `tbl_workout_dictionary` (
  `id` int(11) NOT NULL,
  `workout_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `workout_desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `calorie_per_unit` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_workout_dictionary`
--

INSERT INTO `tbl_workout_dictionary` (`id`, `workout_name`, `workout_desc`, `calorie_per_unit`) VALUES
(1, 'Crunches', 'An exercise of abdomens', '30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_client`
--
ALTER TABLE `tbl_client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_client_food_activity`
--
ALTER TABLE `tbl_client_food_activity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `food_dictionary_id` (`food_id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `tbl_client_nutritionist_association`
--
ALTER TABLE `tbl_client_nutritionist_association`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `nutritionist_id` (`nutritionist_id`);

--
-- Indexes for table `tbl_client_workout_activity`
--
ALTER TABLE `tbl_client_workout_activity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `workout_id` (`workout_id`);

--
-- Indexes for table `tbl_food_dictionary`
--
ALTER TABLE `tbl_food_dictionary`
  ADD PRIMARY KEY (`id`),
  ADD KEY `unit_id` (`unit_id`);

--
-- Indexes for table `tbl_food_unit`
--
ALTER TABLE `tbl_food_unit`
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
-- Indexes for table `tbl_workout_dictionary`
--
ALTER TABLE `tbl_workout_dictionary`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_client`
--
ALTER TABLE `tbl_client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_client_food_activity`
--
ALTER TABLE `tbl_client_food_activity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_client_nutritionist_association`
--
ALTER TABLE `tbl_client_nutritionist_association`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_client_workout_activity`
--
ALTER TABLE `tbl_client_workout_activity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_food_dictionary`
--
ALTER TABLE `tbl_food_dictionary`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_food_unit`
--
ALTER TABLE `tbl_food_unit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_nutritionist`
--
ALTER TABLE `tbl_nutritionist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_ratings`
--
ALTER TABLE `tbl_ratings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_workout_dictionary`
--
ALTER TABLE `tbl_workout_dictionary`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_client_food_activity`
--
ALTER TABLE `tbl_client_food_activity`
  ADD CONSTRAINT `food_activity_client_id` FOREIGN KEY (`client_id`) REFERENCES `tbl_client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_client_nutritionist_association`
--
ALTER TABLE `tbl_client_nutritionist_association`
  ADD CONSTRAINT `client_id_foreign` FOREIGN KEY (`client_id`) REFERENCES `tbl_client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nutritionist_id_foreign` FOREIGN KEY (`nutritionist_id`) REFERENCES `tbl_nutritionist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_client_workout_activity`
--
ALTER TABLE `tbl_client_workout_activity`
  ADD CONSTRAINT `workout_client_id` FOREIGN KEY (`client_id`) REFERENCES `tbl_client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `workout_workout_id` FOREIGN KEY (`workout_id`) REFERENCES `tbl_workout_dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_food_dictionary`
--
ALTER TABLE `tbl_food_dictionary`
  ADD CONSTRAINT `food_unit_relation` FOREIGN KEY (`unit_id`) REFERENCES `tbl_food_unit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
