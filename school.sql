-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 11 juin 2019 à 11:03
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `school`
--

-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `Annee` int(11) NOT NULL,
  PRIMARY KEY (`Annee`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id` int(11) NOT NULL,
  `appreciation` char(1) DEFAULT NULL,
  `trimestre` int(11) DEFAULT NULL,
  `inscription` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `trimestre` (`trimestre`),
  KEY `inscription` (`inscription`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `Id` int(11) NOT NULL,
  `nom` char(1) DEFAULT NULL,
  `niveau` int(11) DEFAULT NULL,
  `anneescolaire` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `niveau` (`niveau`),
  KEY `anneescolaire` (`anneescolaire`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id` int(11) NOT NULL,
  `appreciation` char(1) DEFAULT NULL,
  `prof` int(11) DEFAULT NULL,
  `bulletin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `prof` (`prof`),
  KEY `bulletin` (`bulletin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `id` int(11) NOT NULL,
  `nom` char(1) DEFAULT NULL,
  `prenom` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL,
  `note` int(11) DEFAULT NULL,
  `appréciaton` char(1) DEFAULT NULL,
  `bulletin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bulletin` (`bulletin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id` int(11) NOT NULL,
  `classe` int(11) DEFAULT NULL,
  `eleve` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `classe` (`classe`),
  KEY `eleve` (`eleve`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `id` int(11) NOT NULL,
  `nom` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id` int(11) NOT NULL,
  `nom` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
CREATE TABLE IF NOT EXISTS `professeur` (
  `id` int(11) NOT NULL,
  `classe` int(11) DEFAULT NULL,
  `matiere` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `classe` (`classe`),
  KEY `matiere` (`matiere`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `semester`
--

DROP TABLE IF EXISTS `semester`;
CREATE TABLE IF NOT EXISTS `semester` (
  `Id` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `Fin` date DEFAULT NULL,
  `Debut` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
