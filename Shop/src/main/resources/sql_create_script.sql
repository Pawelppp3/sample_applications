CREATE DATABASE IF NOT EXISTS `sdadb`;
USE `sdadb`;

CREATE TABLE IF NOT EXISTS `hello` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(450) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `hello` (`id`, `text`) VALUES
 (1, 'ala ma kota'),
 (2, 'a kot ma ale');
