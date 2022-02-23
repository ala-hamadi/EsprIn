-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 23 fév. 2022 à 22:22
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `esprin`
--

-- --------------------------------------------------------

--
-- Structure de la table `alert`
--

CREATE TABLE `alert` (
  `idAlert` int(11) NOT NULL,
  `content` text NOT NULL,
  `destClass` varchar(20) NOT NULL,
  `idSender` int(11) NOT NULL,
  `state` varchar(15) NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `annoncement`
--

CREATE TABLE `annoncement` (
  `idAnn` int(11) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `destination` varchar(20) NOT NULL,
  `idSender` int(11) NOT NULL,
  `state` varchar(15) NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `annoncement`
--

INSERT INTO `annoncement` (`idAnn`, `subject`, `content`, `destination`, `idSender`, `state`) VALUES
(5, 'Rappel 5lass', 'no 5lass no result', 'Etudiant', 10020855, 'Active'),
(6, 'Rappel 5lass', 'no 5lass no result', 'Etudiant', 10020855, 'Active'),
(7, 'Rappel 5lass', 'no 5lass no result', 'Etudiant', 10020855, 'Active'),
(8, 'Rappel 5lass', 'no 5lass no result', 'Etudiant', 10020855, 'Active'),
(9, 'Rappel 5lass', 'no 5lass no result', 'Etudiant', 10020855, 'Deleted');

-- --------------------------------------------------------

--
-- Structure de la table `commented`
--

CREATE TABLE `commented` (
  `userWhoCommented` int(11) NOT NULL,
  `postCommented` int(11) NOT NULL,
  `content` text NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

CREATE TABLE `event` (
  `idEvent` int(11) NOT NULL,
  `titleEvent` varchar(20) NOT NULL,
  `contentEvent` text NOT NULL,
  `imgURL` text DEFAULT NULL,
  `eventDate` datetime NOT NULL,
  `idOrganizer` int(11) NOT NULL,
  `state` varchar(15) NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `event`
--

INSERT INTO `event` (`idEvent`, `titleEvent`, `contentEvent`, `imgURL`, `eventDate`, `idOrganizer`, `state`) VALUES
(1, 'Hackathon', 'Hackathon dev mobile', NULL, '3922-11-30 05:06:00', 10000000, 'Active'),
(2, 'Hackathon', 'Hackathon dev mobile', NULL, '3922-11-30 05:06:00', 10000000, 'Active'),
(3, 'Hackathon', 'Hackathon dev mobile', NULL, '3922-11-30 05:06:00', 10000000, 'Deleted'),
(4, 'Hackathon', 'Hackathon dev mobile', NULL, '3922-11-30 05:06:00', 10000000, 'Active'),
(5, 'Hackathon', 'Hackathon dev mobile', NULL, '3922-11-30 05:06:00', 10000000, 'Active');

-- --------------------------------------------------------

--
-- Structure de la table `follow`
--

CREATE TABLE `follow` (
  `cinFollower` int(11) NOT NULL,
  `cinFollowed` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `forum`
--

CREATE TABLE `forum` (
  `idForum` int(11) NOT NULL,
  `title` varchar(40) NOT NULL,
  `content` text NOT NULL,
  `idOwner` int(11) NOT NULL,
  `state` varchar(15) NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `forum`
--

INSERT INTO `forum` (`idForum`, `title`, `content`, `idOwner`, `state`) VALUES
(1, 'First forum', 'el PIdev damerli 7iety.\r\nps: youssef tika\r\n', 10020855, 'Active');

-- --------------------------------------------------------

--
-- Structure de la table `intrest`
--

CREATE TABLE `intrest` (
  `IdOffer` int(11) NOT NULL,
  `cinIntrested` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `intrest`
--

INSERT INTO `intrest` (`IdOffer`, `cinIntrested`) VALUES
(1, 10020855);

-- --------------------------------------------------------

--
-- Structure de la table `like`
--

CREATE TABLE `like` (
  `likeUser` int(8) NOT NULL,
  `likePost` int(11) NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déclencheurs `like`
--
DELIMITER $$
CREATE TRIGGER `addLike` BEFORE INSERT ON `like` FOR EACH ROW UPDATE post 
set likeNum=likeNum+1
where post.idPost=new.likePost
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `dislike` BEFORE DELETE ON `like` FOR EACH ROW UPDATE post 
set likeNum=likeNum-1
where post.idPost=old.likePost
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `IdOffer` int(11) NOT NULL,
  `catOffre` varchar(20) NOT NULL,
  `titleOffer` varchar(20) NOT NULL,
  `descOffer` text NOT NULL,
  `offerProvider` int(8) NOT NULL,
  `state` varchar(15) NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`IdOffer`, `catOffre`, `titleOffer`, `descOffer`, `offerProvider`, `state`) VALUES
(1, 'Offre_De_Travail', 'mohsen', 'lll', 10020855, 'Deleted'),
(2, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(3, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(4, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(5, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(6, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(7, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(8, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(9, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(10, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(11, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(12, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(13, 'Alternance', 'mohsen', 'lll', 10020855, 'Active'),
(14, 'Alternance', 'mohsen', 'lll', 10020855, 'Active');

-- --------------------------------------------------------

--
-- Structure de la table `participate`
--

CREATE TABLE `participate` (
  `cinUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `participate`
--

INSERT INTO `participate` (`cinUser`, `idEvent`) VALUES
(10020855, 1);

-- --------------------------------------------------------

--
-- Structure de la table `post`
--

CREATE TABLE `post` (
  `idPost` int(11) NOT NULL,
  `content` text NOT NULL,
  `mediaURL` text NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT current_timestamp(),
  `categorie` varchar(20) NOT NULL,
  `likeNum` int(11) NOT NULL DEFAULT 0,
  `idOwer` int(11) NOT NULL,
  `state` varchar(15) NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `post`
--

INSERT INTO `post` (`idPost`, `content`, `mediaURL`, `createdAt`, `categorie`, `likeNum`, `idOwer`, `state`) VALUES
(2, 'adb el slem', 'wwwxxxx.', '2022-02-19 19:33:07', 'Covoiturage', 0, 10000000, 'Deleted'),
(3, 'test post', 'wwwxxxx.', '2022-02-19 19:33:35', 'Covoiturage', 0, 10000000, 'Active'),
(4, 'test post', 'wwwxxxx.', '2022-02-19 19:34:07', 'Covoiturage', 0, 10000000, 'Active'),
(5, 'test post', 'wwwxxxx.', '2022-02-19 19:34:54', 'Covoiturage', 0, 10000000, 'Deleted'),
(6, 'test post', 'wwwxxxx.', '2022-02-19 19:35:09', 'Covoiturage', 0, 10000000, 'Active');

-- --------------------------------------------------------

--
-- Structure de la table `reacted forum`
--

CREATE TABLE `reacted forum` (
  `cinUser` int(8) NOT NULL,
  `idForum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `responded`
--

CREATE TABLE `responded` (
  `cinUser` int(8) NOT NULL,
  `idForum` int(11) NOT NULL,
  `content` text NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `cinUser` int(8) NOT NULL,
  `email` varchar(30) NOT NULL CHECK (`email` like '%@%.%'),
  `passwd` varchar(20) NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT current_timestamp(),
  `imgURL` text NOT NULL,
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `domaine` varchar(30) DEFAULT NULL,
  `departement` varchar(40) DEFAULT NULL,
  `typeClub` varchar(20) DEFAULT NULL,
  `class` varchar(20) DEFAULT NULL,
  `localisation` varchar(20) DEFAULT NULL,
  `entrepriseName` varchar(20) DEFAULT NULL,
  `role` varchar(20) NOT NULL,
  `state` varchar(15) NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`cinUser`, `email`, `passwd`, `createdAt`, `imgURL`, `firstName`, `lastName`, `domaine`, `departement`, `typeClub`, `class`, `localisation`, `entrepriseName`, `role`, `state`) VALUES
(10000000, 'test.test@test.com', 'hello', '2022-02-14 10:25:42', 'clubImg', 'Orenda', 'Junior Entreprise', NULL, NULL, 'Junior_entreprise', NULL, NULL, NULL, 'Club', 'Disconnected'),
(10020855, 'bairem.khedhri@esprit.tn', 'bairem1111', '2022-02-11 20:11:24', 'https://scontent.ftun1-2.fna.fbcdn.net/v/t39.30808-6/272684591_4777980965613182_3886000276045516308_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=d8M8Fib7ksoAX_2iqEa&tn=uvaTFBdxAtYlt109&_nc_ht=scontent.ftun1-2.fna&oh=00_AT83jpvkfurx2M9D9oBKDTLnMdpPIPX6nJyaK1bpHF_4bQ&oe=620AAA93', 'bairem', 'khedhri', NULL, 'Financier', NULL, NULL, NULL, NULL, 'Admin', 'Disconnected'),
(11111111, 'etudiant.student@esprit.tn', 'etudiant1', '2022-02-14 08:59:09', 'dd', 'etudiant 1', 'student', 'Informatique', NULL, NULL, '3 A 25', NULL, NULL, 'Etudiant', 'Disconnected'),
(15542230, 'vermeg@gmail.com', 'bairem1111', '2022-02-14 10:15:30', 'c', NULL, NULL, NULL, NULL, NULL, NULL, 'Lac,Tunis', 'Vermeg', 'Externe', 'Disconnected'),
(55555555, 'student.student@test.tn', 'helloworld', '2022-02-17 08:54:39', 'null', 'testname', 'testlastame', 'Business', NULL, NULL, '3 A 25', NULL, NULL, 'Etudiant', 'Disconnected');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `alert`
--
ALTER TABLE `alert`
  ADD PRIMARY KEY (`idAlert`),
  ADD KEY `FK sender` (`idSender`);

--
-- Index pour la table `annoncement`
--
ALTER TABLE `annoncement`
  ADD PRIMARY KEY (`idAnn`),
  ADD KEY `FK annonce sender` (`idSender`);

--
-- Index pour la table `commented`
--
ALTER TABLE `commented`
  ADD PRIMARY KEY (`userWhoCommented`,`createdAt`,`postCommented`) USING BTREE,
  ADD KEY `Fk post commented` (`postCommented`);

--
-- Index pour la table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`idEvent`),
  ADD KEY `FK organizer` (`idOrganizer`);

--
-- Index pour la table `follow`
--
ALTER TABLE `follow`
  ADD PRIMARY KEY (`cinFollower`,`cinFollowed`),
  ADD KEY `FK followed` (`cinFollowed`);

--
-- Index pour la table `forum`
--
ALTER TABLE `forum`
  ADD PRIMARY KEY (`idForum`),
  ADD KEY `FK owner` (`idOwner`);

--
-- Index pour la table `intrest`
--
ALTER TABLE `intrest`
  ADD PRIMARY KEY (`IdOffer`,`cinIntrested`),
  ADD KEY `FK intrested` (`cinIntrested`);

--
-- Index pour la table `like`
--
ALTER TABLE `like`
  ADD PRIMARY KEY (`likeUser`,`likePost`),
  ADD KEY `FK post liked` (`likePost`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`IdOffer`),
  ADD KEY `FK Provider` (`offerProvider`);

--
-- Index pour la table `participate`
--
ALTER TABLE `participate`
  ADD PRIMARY KEY (`cinUser`,`idEvent`),
  ADD KEY `FK event` (`idEvent`);

--
-- Index pour la table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`idPost`),
  ADD KEY `FK Post owner` (`idOwer`);

--
-- Index pour la table `reacted forum`
--
ALTER TABLE `reacted forum`
  ADD PRIMARY KEY (`cinUser`,`idForum`),
  ADD KEY `FK reacted` (`idForum`);

--
-- Index pour la table `responded`
--
ALTER TABLE `responded`
  ADD PRIMARY KEY (`cinUser`,`idForum`,`createdAt`) USING BTREE,
  ADD KEY `FK responded` (`idForum`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`cinUser`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `alert`
--
ALTER TABLE `alert`
  MODIFY `idAlert` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `annoncement`
--
ALTER TABLE `annoncement`
  MODIFY `idAnn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `event`
--
ALTER TABLE `event`
  MODIFY `idEvent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `forum`
--
ALTER TABLE `forum`
  MODIFY `idForum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `offre`
--
ALTER TABLE `offre`
  MODIFY `IdOffer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `post`
--
ALTER TABLE `post`
  MODIFY `idPost` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `alert`
--
ALTER TABLE `alert`
  ADD CONSTRAINT `FK sender` FOREIGN KEY (`idSender`) REFERENCES `user` (`cinUser`);

--
-- Contraintes pour la table `annoncement`
--
ALTER TABLE `annoncement`
  ADD CONSTRAINT `FK annonce sender` FOREIGN KEY (`idSender`) REFERENCES `user` (`cinUser`);

--
-- Contraintes pour la table `commented`
--
ALTER TABLE `commented`
  ADD CONSTRAINT `FK user who commented` FOREIGN KEY (`userWhoCommented`) REFERENCES `user` (`cinUser`),
  ADD CONSTRAINT `Fk post commented` FOREIGN KEY (`postCommented`) REFERENCES `post` (`idPost`);

--
-- Contraintes pour la table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `FK organizer` FOREIGN KEY (`idOrganizer`) REFERENCES `user` (`cinUser`);

--
-- Contraintes pour la table `follow`
--
ALTER TABLE `follow`
  ADD CONSTRAINT `FK followed` FOREIGN KEY (`cinFollowed`) REFERENCES `user` (`cinUser`),
  ADD CONSTRAINT `FK follower` FOREIGN KEY (`cinFollower`) REFERENCES `user` (`cinUser`);

--
-- Contraintes pour la table `forum`
--
ALTER TABLE `forum`
  ADD CONSTRAINT `FK owner` FOREIGN KEY (`idOwner`) REFERENCES `user` (`cinUser`);

--
-- Contraintes pour la table `intrest`
--
ALTER TABLE `intrest`
  ADD CONSTRAINT `FK intrested` FOREIGN KEY (`cinIntrested`) REFERENCES `user` (`cinUser`),
  ADD CONSTRAINT `FK offer` FOREIGN KEY (`IdOffer`) REFERENCES `offre` (`IdOffer`);

--
-- Contraintes pour la table `like`
--
ALTER TABLE `like`
  ADD CONSTRAINT `FK user like` FOREIGN KEY (`likeUser`) REFERENCES `user` (`cinUser`),
  ADD CONSTRAINT `Fk post liked` FOREIGN KEY (`likePost`) REFERENCES `post` (`idPost`);

--
-- Contraintes pour la table `offre`
--
ALTER TABLE `offre`
  ADD CONSTRAINT `FK Provider` FOREIGN KEY (`offerProvider`) REFERENCES `user` (`cinUser`);

--
-- Contraintes pour la table `participate`
--
ALTER TABLE `participate`
  ADD CONSTRAINT `FK event` FOREIGN KEY (`idEvent`) REFERENCES `event` (`idEvent`),
  ADD CONSTRAINT `FK participent` FOREIGN KEY (`cinUser`) REFERENCES `user` (`cinUser`);

--
-- Contraintes pour la table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK Post owner` FOREIGN KEY (`idOwer`) REFERENCES `user` (`cinUser`);

--
-- Contraintes pour la table `reacted forum`
--
ALTER TABLE `reacted forum`
  ADD CONSTRAINT `FK reacted` FOREIGN KEY (`idForum`) REFERENCES `forum` (`idForum`),
  ADD CONSTRAINT `FK reacter` FOREIGN KEY (`cinUser`) REFERENCES `user` (`cinUser`);

--
-- Contraintes pour la table `responded`
--
ALTER TABLE `responded`
  ADD CONSTRAINT `FK responded` FOREIGN KEY (`idForum`) REFERENCES `forum` (`idForum`),
  ADD CONSTRAINT `FK response` FOREIGN KEY (`cinUser`) REFERENCES `user` (`cinUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
