-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 05, 2020 at 12:14 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sis2`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
CREATE TABLE IF NOT EXISTS `assignment` (
  `ID` varchar(10) NOT NULL,
  `ANO` varchar(10) NOT NULL,
  `A_NAME` varchar(30) NOT NULL,
  `A_DESC` varchar(50) NOT NULL,
  `Submit_Date` date DEFAULT NULL,
  `year` varchar(10) NOT NULL,
  `section` varchar(6) NOT NULL,
  `courseId` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`ANO`,`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assignment`
--

INSERT INTO `assignment` (`ID`, `ANO`, `A_NAME`, `A_DESC`, `Submit_Date`, `year`, `section`, `courseId`) VALUES
('112233', '2', 'WEB TECH', 'DYNAMIC APPLICATION', '2018-12-07', '2012-16', '-', '102'),
('112233', '1', 'JAVA PROJECT', 'GUI JAVA PROJECT (DBMS IS MANDATORY)', '2018-12-05', '2016-20', 'A', '101'),
('111007', '1', 'DAA(BELLMAN FORD)', 'IMPLEMENT USING LINK LIST .', '2018-12-06', '2016-20', '-', '102'),
('111007', '2', 'SPM (TOOLS)', 'LIST ALL THE TOOLS IN SOFTWARE DEVELOPMENT ', '2018-12-20', '2016-20', '-', '102');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `courseid` varchar(10) NOT NULL,
  `coursename` varchar(30) NOT NULL,
  `courseduration` int(11) NOT NULL,
  `coursetype` varchar(3) NOT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`courseid`, `coursename`, `courseduration`, `coursetype`) VALUES
('101', 'BTECH(CSE)', 4, 'UG'),
('102', 'BTECH(I.T)', 4, 'UG'),
('103', 'BTECH(M.E)', 4, 'UG'),
('104', 'BTECH(C.E)', 4, 'UG'),
('105', 'BTECH(E.C)', 4, 'UG'),
('106', 'AGRICULTURE', 4, 'UG');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `NAME` varchar(50) NOT NULL,
  `TYPE` varchar(10) NOT NULL,
  `ID` varchar(20) NOT NULL,
  `USER_NAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_NAME` (`USER_NAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`NAME`, `TYPE`, `ID`, `USER_NAME`, `PASSWORD`) VALUES
('ADMIN1', 'ADMIN', '102103', 'ADMIN', '1234'),
('RK Sharma', 'OFFICE', '1012456', 'RK01', '567'),
('Abhay Rana ', 'OFFICE', '111A23', 'ARX111', '890'),
('Mohan Das', 'FACULTY', '112233', 'MD5', '1234'),
('Pankaj Sharma', 'FACULTY', '111007', 'PS07', '890'),
('SAURAV', 'ADMIN', 'CS1234', 'SCS1234', '1234'),
('RAKESH SHARMA', 'ADMIN', '111232', 'RSA01', '1234'),
('ADMIN2', 'ADMIN', 'RN123', 'RN', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `uno` varchar(20) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `fname` varchar(40) NOT NULL,
  `course` varchar(30) NOT NULL,
  `detailEnteredby` varchar(20) NOT NULL,
  `sec` varchar(1) NOT NULL,
  `batch` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`uno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`uno`, `Name`, `fname`, `course`, `detailEnteredby`, `sec`, `batch`) VALUES
('10186', 'ARUN', 'RAVI SHANKAR TIWARI', '101', '102103', 'A', '2016-20'),
('1018007', 'ABHYUDAYA SINGH', 'ROHAN SINGH', '101', '102103', 'A', '2016-20');

-- --------------------------------------------------------

--
-- Table structure for table `submit`
--

DROP TABLE IF EXISTS `submit`;
CREATE TABLE IF NOT EXISTS `submit` (
  `ID` varchar(20) NOT NULL,
  `A_NO` varchar(20) NOT NULL,
  `S_ID` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`,`A_NO`,`S_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `submit`
--

INSERT INTO `submit` (`ID`, `A_NO`, `S_ID`) VALUES
('111007', '1', '1016701'),
('111007', '1', '1016703'),
('111007', '1', '1016704'),
('111007', '1', '1016705'),
('111007', '1', '1016708'),
('111007', '2', '1016701'),
('111007', '2', '1016702'),
('111007', '2', '1016703'),
('111007', '2', '1016704'),
('111007', '2', '1016705'),
('111007', '2', '1016706'),
('111007', '2', '1016707'),
('111007', '2', '1016708'),
('111007', '2', '1016709'),
('112233', '1', '1018007'),
('112233', '1', '1018016'),
('112233', '1', '1018018'),
('112233', '1', '1018053'),
('112233', '1', '1018066'),
('112233', '1', '1018076'),
('112233', '1', '1018088'),
('112233', '1', '1018094'),
('112233', '1', '1018095'),
('112233', '1', '1018102'),
('112233', '2', '1012106'),
('112233', '2', '1012109');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
