drop database if exists awajaba;
create database awajaba;
use awajaba;

--
-- Structure de la table `Membre`
--

create table Membre(

    id int,
    login varchar(20),
    mdp varchar(20),
    email varchar(40),
    dateInscription date ,
    bloque boolean,

    primary key(id)
);

--
-- Structure de la table `Membre`
--

--
-- Structure de la table `Specialite`
--

create table Specialite(

    id int,
    libelle varchar(20),

    primary key(id)
);

--
-- Structure de la table `Specialite`
--

--
-- Structure de la table `Avoir`
--

create table Avoir(

    idMembre int,
    idSpecialite int,
    niveau int,

    primary key(idMembre, idSpecialite),
    foreign key(idMembre) references Membre(id) ,
    foreign key(idSpecialite) references Specialite(id) 

);

--
-- Structure de la table `Avoir`
--

--------------------------------

--
-- Contenu de la table `Membre`
--

INSERT INTO `Membre` (`id`, `login`,`mdp`,`email`,`dateInscription`,`bloque`) VALUES
(1, 'Brigide','azerty','brabus.rigide@gmail.com','2022-03-12',false),
(2, 'Ribiscus','azerty','rodrigue.ibiscus@gmail.com','2022-05-22',false),
(3, 'Abarette','azerty','Arthur.barette@gmail.com','2022-11-07',true),
(4, 'Sava','azerty','sahra.ava@gmail.com','2022-04-30',false),
(5, 'Lbrutus','azerty','loic.brutus@gmail.com','2022-04-30',false);

--
-- Contenu de la table `Membre`
--

--
-- Contenu de la table `Specialite`
--

INSERT INTO `Specialite` (`id`, `libelle`) VALUES
(1, 'française'),
(2, 'mexicaine'),
(3, 'marocaine'),
(4, 'indienne'),
(5, 'italienne'),
(6, 'irlandaise'),
(7, 'congolaise'),
(8, 'japonaise'),
(9, 'malgache'),
(10, 'bretonne'),
(11, 'béarnaise'),
(12, 'martiniquaise');

--
-- Contenu de la table `Specialite`
--

--
-- Contenu de la table `Avoir`
--
INSERT INTO `Avoir` (`idMembre`, `idSpecialite`,`niveau`) VALUES
(1,8,6),
(1,10,7),
(2,12,7),
(2,9,5),
(2,7,8),
(3,1,4),
(4,3,9),
(4,2,5),
(4,5,6),
(5,4,10),
(5,1,0),
(5,11,2);
--
-- Contenu de la table `Avoir`
--