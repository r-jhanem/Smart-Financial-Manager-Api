-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 06, 2023 at 06:58 PM
-- Server version: 10.5.20-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id21207358_dbraad`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `id_autss` int(11) NOT NULL,
  `aut_name` varchar(50) NOT NULL,
  `branchess_name` varchar(50) DEFAULT NULL,
  `box_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`id_autss`, `aut_name`, `branchess_name`, `box_name`) VALUES
(1, 'الكل', 'الكل', 'الكل'),
(2, 'عمران', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `authoritiess`
--

CREATE TABLE `authoritiess` (
  `id_au` int(11) NOT NULL,
  `au_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `boxes`
--

CREATE TABLE `boxes` (
  `id_bo` int(11) NOT NULL,
  `box_name` varchar(50) NOT NULL,
  `id_brans` int(11) NOT NULL,
  `keybos` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

--
-- Dumping data for table `boxes`
--

INSERT INTO `boxes` (`id_bo`, `box_name`, `id_brans`, `keybos`) VALUES
(1, 'الكل', 1, NULL),
(2, 'شهارة', 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `branchess`
--

CREATE TABLE `branchess` (
  `id` int(11) NOT NULL,
  `br_name` varchar(50) NOT NULL,
  `id_auth` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `branchesss`
--

CREATE TABLE `branchesss` (
  `br_id` int(11) NOT NULL,
  `br_name` varchar(20) NOT NULL,
  `id_auth` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `decoment`
--

CREATE TABLE `decoment` (
  `id_dee` int(11) NOT NULL,
  `aut_id` varchar(40) NOT NULL,
  `name` varchar(50) NOT NULL,
  `date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sol` varchar(200) NOT NULL DEFAULT '0',
  `type` varchar(20) NOT NULL DEFAULT '0',
  `id_emply` int(11) NOT NULL,
  `key_decoment` varchar(50) DEFAULT NULL,
  `detils` varchar(200) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `employesa3`
--

CREATE TABLE `employesa3` (
  `id_em` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `date` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `details` varchar(200) DEFAULT NULL,
  `id_aut` int(11) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `keyemple` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `Max_sal` int(20) NOT NULL DEFAULT 0,
  `id_rol` int(11) NOT NULL DEFAULT 11
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

--
-- Dumping data for table `employesa3`
--

INSERT INTO `employesa3` (`id_em`, `name`, `date`, `phone`, `details`, `id_aut`, `password`, `type`, `keyemple`, `Max_sal`, `id_rol`) VALUES
(1, 'الكل', NULL, NULL, NULL, 1, 'الكل', '0', NULL, 0, 11),
(2, 'admin', NULL, NULL, NULL, 1, 'admin1234', '0', NULL, 0, 11);

-- --------------------------------------------------------

--
-- Table structure for table `messagechat`
--

CREATE TABLE `messagechat` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `dates` varchar(20) NOT NULL,
  `iduser` varchar(40) NOT NULL,
  `keyMessag` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `messagechat`
--

INSERT INTO `messagechat` (`id`, `name`, `dates`, `iduser`, `keyMessag`) VALUES
(1, 'gggg', 't654t4', 'grrf', 'yyg'),
(2, 'gggg', 't654t4', 'grrf', 'yyg'),
(3, ' strip_tag', '2023/06/01 - 07:33 p', ' strip_t', 'Ucuenz2023060107331685633599'),
(4, 'empty', '2023/06/01 - 07:36 p', 'rrr', 'Uxckpl2023060107361685633805'),
(5, 'empty', '2023/06/01 - 07:40 p', 'rrr', 'Ukenfs2023060107401685634055'),
(6, 'Usftmg2023051607091684249778', '2023/06/02 - 03:54 a', '01062023', 'Ucwfdo2023060203541685663688');

-- --------------------------------------------------------

--
-- Table structure for table `rolse`
--

CREATE TABLE `rolse` (
  `id` int(11) NOT NULL,
  `title` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `rolse`
--

INSERT INTO `rolse` (`id`, `title`) VALUES
(1, 'admin'),
(2, 'empl');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD PRIMARY KEY (`id_autss`),
  ADD UNIQUE KEY `aut_name_2` (`aut_name`),
  ADD UNIQUE KEY `aut_name` (`aut_name`,`branchess_name`,`box_name`),
  ADD UNIQUE KEY `branchess_name` (`branchess_name`);

--
-- Indexes for table `authoritiess`
--
ALTER TABLE `authoritiess`
  ADD PRIMARY KEY (`id_au`);

--
-- Indexes for table `boxes`
--
ALTER TABLE `boxes`
  ADD PRIMARY KEY (`id_bo`),
  ADD KEY `id_bran` (`id_brans`),
  ADD KEY `id_bran_2` (`id_brans`),
  ADD KEY `id_brans` (`id_brans`);

--
-- Indexes for table `branchess`
--
ALTER TABLE `branchess`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_auth` (`id_auth`);

--
-- Indexes for table `branchesss`
--
ALTER TABLE `branchesss`
  ADD PRIMARY KEY (`br_id`);

--
-- Indexes for table `decoment`
--
ALTER TABLE `decoment`
  ADD PRIMARY KEY (`id_dee`),
  ADD KEY `id_em` (`id_emply`),
  ADD KEY `id_dee` (`id_dee`),
  ADD KEY `id_dee_2` (`id_dee`),
  ADD KEY `id_dee_3` (`id_dee`),
  ADD KEY `id_dee_4` (`id_dee`);

--
-- Indexes for table `employesa3`
--
ALTER TABLE `employesa3`
  ADD PRIMARY KEY (`id_em`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `id_aut` (`id_aut`);

--
-- Indexes for table `messagechat`
--
ALTER TABLE `messagechat`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_2` (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `rolse`
--
ALTER TABLE `rolse`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `authorities`
--
ALTER TABLE `authorities`
  MODIFY `id_autss` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `authoritiess`
--
ALTER TABLE `authoritiess`
  MODIFY `id_au` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `boxes`
--
ALTER TABLE `boxes`
  MODIFY `id_bo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `branchess`
--
ALTER TABLE `branchess`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `branchesss`
--
ALTER TABLE `branchesss`
  MODIFY `br_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `decoment`
--
ALTER TABLE `decoment`
  MODIFY `id_dee` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employesa3`
--
ALTER TABLE `employesa3`
  MODIFY `id_em` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `messagechat`
--
ALTER TABLE `messagechat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `rolse`
--
ALTER TABLE `rolse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `boxes`
--
ALTER TABLE `boxes`
  ADD CONSTRAINT `boxes_ibfk_1` FOREIGN KEY (`id_brans`) REFERENCES `authorities` (`id_autss`);

--
-- Constraints for table `decoment`
--
ALTER TABLE `decoment`
  ADD CONSTRAINT `decoment_ibfk_1` FOREIGN KEY (`id_emply`) REFERENCES `employesa3` (`id_em`);

--
-- Constraints for table `employesa3`
--
ALTER TABLE `employesa3`
  ADD CONSTRAINT `employesa3_ibfk_1` FOREIGN KEY (`id_aut`) REFERENCES `boxes` (`id_bo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
