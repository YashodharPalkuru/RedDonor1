-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 27, 2015 at 08:29 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `reddonordb`
--
CREATE DATABASE `reddonordb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `reddonordb`;

-- --------------------------------------------------------

--
-- Table structure for table `bloodgroup`
--

CREATE TABLE IF NOT EXISTS `bloodgroup` (
  `bg_id` int(11) NOT NULL AUTO_INCREMENT,
  `bg_name` varchar(10) NOT NULL,
  PRIMARY KEY (`bg_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `bloodgroup`
--

INSERT INTO `bloodgroup` (`bg_id`, `bg_name`) VALUES
(1, 'O+ve'),
(2, 'B+ve');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `ci_id` int(11) NOT NULL AUTO_INCREMENT,
  `ci_st_id` int(11) NOT NULL,
  `ci_name` varchar(50) NOT NULL,
  PRIMARY KEY (`ci_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`ci_id`, `ci_st_id`, `ci_name`) VALUES
(1, 1, 'Tirupati'),
(2, 1, 'Kadapa');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE IF NOT EXISTS `country` (
  `co_id` int(11) NOT NULL AUTO_INCREMENT,
  `co_name` varchar(50) NOT NULL,
  PRIMARY KEY (`co_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`co_id`, `co_name`) VALUES
(1, 'INDIA'),
(2, 'US');

-- --------------------------------------------------------

--
-- Table structure for table `donor_login`
--

CREATE TABLE IF NOT EXISTS `donor_login` (
  `dl_id` int(11) NOT NULL AUTO_INCREMENT,
  `dl_mobile` int(11) NOT NULL,
  `dl_pswd` varchar(50) NOT NULL,
  `dl_csrf_token` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dl_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `donor_login`
--

INSERT INTO `donor_login` (`dl_id`, `dl_mobile`, `dl_pswd`, `dl_csrf_token`) VALUES
(1, 1234, '1234', '-1861476476');

-- --------------------------------------------------------

--
-- Table structure for table `donor_register`
--

CREATE TABLE IF NOT EXISTS `donor_register` (
  `dr_id` int(11) NOT NULL AUTO_INCREMENT,
  `dr_firstname` varchar(30) NOT NULL,
  `dr_lastname` varchar(30) NOT NULL,
  `dr_ci_id` int(11) NOT NULL,
  `dr_email` varchar(50) NOT NULL,
  `dr_ar_id` int(11) NOT NULL,
  `dr_co_id` int(11) NOT NULL,
  `dr_bg_id` int(11) NOT NULL,
  PRIMARY KEY (`dr_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `donor_register`
--

INSERT INTO `donor_register` (`dr_id`, `dr_firstname`, `dr_lastname`, `dr_ci_id`, `dr_email`, `dr_ar_id`, `dr_co_id`, `dr_bg_id`) VALUES
(1, '', '', 0, '', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `dr_table`
--

CREATE TABLE IF NOT EXISTS `dr_table` (
  `dr_id` int(11) NOT NULL AUTO_INCREMENT,
  `dr_d_id` int(11) NOT NULL,
  `dr_r_id` int(11) NOT NULL,
  `dr_sts_id` int(11) NOT NULL,
  PRIMARY KEY (`dr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `dr_table`
--


-- --------------------------------------------------------

--
-- Table structure for table `region`
--

CREATE TABLE IF NOT EXISTS `region` (
  `ar_id` int(11) NOT NULL AUTO_INCREMENT,
  `ar_ci_id` int(11) NOT NULL,
  `ar_name` varchar(50) NOT NULL,
  `ar_pincode` int(11) NOT NULL,
  PRIMARY KEY (`ar_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `region`
--

INSERT INTO `region` (`ar_id`, `ar_ci_id`, `ar_name`, `ar_pincode`) VALUES
(1, 1, 'Chandra giri', 517101),
(2, 2, 'Proddatur', 516360);

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE IF NOT EXISTS `state` (
  `st_id` int(11) NOT NULL AUTO_INCREMENT,
  `st_co_id` int(11) NOT NULL,
  `st_name` varchar(30) NOT NULL,
  PRIMARY KEY (`st_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`st_id`, `st_co_id`, `st_name`) VALUES
(1, 1, 'Andhra Pradesh');

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE IF NOT EXISTS `status` (
  `sts_id` int(11) NOT NULL AUTO_INCREMENT,
  `sts_name` varchar(30) NOT NULL,
  PRIMARY KEY (`sts_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`sts_id`, `sts_name`) VALUES
(1, 'Accept'),
(2, 'Reject');
