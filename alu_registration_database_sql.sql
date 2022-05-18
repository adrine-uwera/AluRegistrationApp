-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2022 at 01:09 PM
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
-- Database: `alu_registration_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `applicants_table`
--

CREATE TABLE `applicants_table` (
  `studentRegistrationNumber` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneNumber` bigint(20) NOT NULL,
  `countryOfResidence` varchar(255) NOT NULL,
  `nationality` varchar(255) NOT NULL,
  `campus` enum('Rwanda','Mauritius') DEFAULT NULL,
  `intake` enum('January','September') DEFAULT NULL,
  `grades` double(20,2) NOT NULL,
  `major` enum('Computer science','Global challenges','Business studies') DEFAULT NULL,
  `admissionStatus` enum('Pending','Admitted','Rejected') DEFAULT 'Pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `applicants_table`
--

INSERT INTO `applicants_table` (`studentRegistrationNumber`, `fullName`, `email`, `phoneNumber`, `countryOfResidence`, `nationality`, `campus`, `intake`, `grades`, `major`, `admissionStatus`) VALUES
('2022/01', 'Adrine UWERA', 'adu@gmail.com', 837642732, 'Rwanda', 'Rwanda', 'Rwanda', 'September', 19.00, 'Computer science', 'Admitted'),
('2022/02', 'Adrien Ntwali', 'adrien@gmail.com', 8927362387, 'China', 'Rwandan', 'Mauritius', 'September', 13.00, 'Business studies', 'Rejected'),
('2022/03', 'Evelyne UMUBYEYI', 'eve@gmail.com', 923729872, 'Rwanda', 'Rwanda', 'Rwanda', 'January', 18.00, 'Computer science', 'Admitted'),
('2022/04', 'Jessie UMUHIRE', 'jessie@gmail.com', 3723273244, 'Belgium', 'Rwanda', 'Rwanda', 'January', 15.00, 'Global challenges', 'Pending'),
('2022/05', 'Julia Gihozo', 'ju@gmail.com', 8293723792, 'Mauritius', 'Kenyan', 'Mauritius', 'January', 16.00, 'Global challenges', 'Rejected'),
('2022/06', 'Kelsy Igiraneza', 'keke@gmail.com', 837237237, 'Burundi', 'Burundian', 'Mauritius', 'January', 14.00, 'Business studies', 'Pending'),
('2022/07', 'Melissa Giramata', 'meli@gmail.com', 8237723822, 'Uganda', 'Rwandan', 'Rwanda', 'January', 20.00, 'Computer science', 'Admitted'),
('2022/08', 'Parfine MIZERO', 'paru@gmail.com', 876327987362, 'Ethiopia', 'Rwandan', 'Rwanda', 'January', 13.00, 'Business studies', 'Admitted'),
('2022/09', 'Vicky Umuhorakeye', 'v@gmail.com', 8736283732, 'South Africa', 'Rwandan', 'Mauritius', 'September', 19.00, 'Computer science', 'Pending'),
('2022/10', 'Vanessa Bami', 'vava@gmail.com', 382372372382, 'America', 'Ghanaian', 'Mauritius', 'January', 16.00, 'Global challenges', 'Admitted'),
('2022/11', 'Irene Busah', 'irene@gmail.com', 82372327328, 'Ghana', 'Ghanaina', 'Rwanda', 'January', 15.00, 'Global challenges', 'Admitted'),
('2022/12', 'Peace ISHIMWE', 'peace@gmail.com', 8323723, 'rwanda', 'rwandan', 'Mauritius', 'September', 13.00, 'Business studies', 'Admitted'),
('2022/13', 'Christelle Gihozo', 'kiki@gmail.com', 8372387237, 'Jamaica', 'rwandan', 'Rwanda', 'September', 18.00, 'Computer science', 'Rejected');

-- --------------------------------------------------------

--
-- Table structure for table `login_credentials_table`
--

CREATE TABLE `login_credentials_table` (
  `studentName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login_credentials_table`
--

INSERT INTO `login_credentials_table` (`studentName`, `email`, `password`) VALUES
('adrien', 'adrien@gmail.com', 'yeah'),
('adrine', 'adu@gmail.com', '1234'),
('evelyne', 'eve@gmail.com', 'petero'),
('Irene Busah', 'irene@gmail.com', 'busah'),
('jessie', 'jessie@gmail.com', 'jeshwi'),
('julia', 'ju@gmail.com', 'gihozo'),
('kelsy', 'keke@gmail.com', 'keke'),
('Christelle Gihozo', 'kiki@gmail.com', '0987'),
('melissa', 'meli@gmail.com', 'giramata'),
('parfine', 'paru@gmail.com', 'missAlu'),
('Peace ISHIMWE', 'peace@gmail.com', 'mutoni'),
('vicky', 'v@gmail.com', '1704'),
('Vanessa Bami', 'vava@gmail.com', 'vanessa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applicants_table`
--
ALTER TABLE `applicants_table`
  ADD PRIMARY KEY (`studentRegistrationNumber`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `login_credentials_table`
--
ALTER TABLE `login_credentials_table`
  ADD PRIMARY KEY (`email`),
  ADD UNIQUE KEY `email` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
