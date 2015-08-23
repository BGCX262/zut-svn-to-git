--
-- Base de données: `apptest`
--
DROP DATABASE IF EXISTS `apptest`;

CREATE DATABASE `apptest`;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `surname` varchar(250) NOT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--
INSERT INTO `user` VALUES (1,'knromeo','romeo',0,'2012-12-31 08:16:00',0),(2,'knromeo','romeo',0,'2012-12-31 08:16:00',0);
