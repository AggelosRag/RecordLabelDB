
DROP TABLE IF EXISTS `Participates`;
DROP TABLE IF EXISTS `Creates`;
DROP TABLE IF EXISTS `Creates2`;
DROP TABLE IF EXISTS `Recorded`;
DROP TABLE IF EXISTS `Purchases`;
DROP TABLE IF EXISTS `Has`;
DROP TABLE IF EXISTS `Musician`;
DROP TABLE IF EXISTS `Composer`;
DROP TABLE IF EXISTS `Singer`;
DROP TABLE IF EXISTS `Lyricist`;
DROP TABLE IF EXISTS `Single`;
DROP TABLE IF EXISTS `Album`;
DROP TABLE IF EXISTS `Song`;
DROP TABLE IF EXISTS `Contracts`;
DROP TABLE IF EXISTS `Studio`;
DROP TABLE IF EXISTS `Client`;
DROP TABLE IF EXISTS `Versions`;
DROP TABLE IF EXISTS `Collections`;
DROP TABLE IF EXISTS `Artist`;
DROP TABLE IF EXISTS `Band`;


CREATE TABLE `Artist` (
	`ArtistID` INT NOT NULL,
	`Firstname` varchar(20) NOT NULL,
	`Lastname` varchar(20) NOT NULL,
	`ArtisticName` varchar(30),
	`Gender` varchar(8) NOT NULL,
	`Nationality` varchar(15),
	`BandID` INT,
	`Phone` INT,
	`City` varchar(10),
	`Address` varchar(30),
	`Genre` varchar(20) NOT NULL,
	PRIMARY KEY (`ArtistID`)
);

CREATE TABLE `Musician` (
	`MusicianID` INT NOT NULL,
	`Instrument` varchar(20),
	PRIMARY KEY (`MusicianID`)
);

CREATE TABLE `Composer` (
	`ComposerID` INT NOT NULL,
	PRIMARY KEY (`ComposerID`)
);

CREATE TABLE `Singer` (
	`SingerID` INT NOT NULL,
	PRIMARY KEY (`SingerID`)
);

CREATE TABLE `Band` (
	`BandID` INT NOT NULL,
	`Name` varchar(20) NOT NULL,
	`Genre` varchar(20),
	PRIMARY KEY (`BandID`)
);

CREATE TABLE `Song` (
	`SongID` INT NOT NULL,
	`Name` varchar(50) NOT NULL,
	`Duration` DECIMAL(3,2) NOT NULL,
	`Genre` varchar(20) NOT NULL,
	`Type` varchar(10) NOT NULL,
	PRIMARY KEY (`SongID`)
);

CREATE TABLE `Recorded` (
	`SongID` INT NOT NULL,
	`StudioID` INT NOT NULL,
	`RecStartDate` DATE NOT NULL,
	`RecEndDate` DATE NOT NULL,
	`RecHours` DECIMAL,
	PRIMARY KEY (`SongID`,`StudioID`)
);

CREATE TABLE `Studio` (
	`StudioID` INT NOT NULL,
	`Name` varchar(30) NOT NULL,
	`City` varchar(20) NOT NULL,
	`Address` varchar(50) NOT NULL,
	`Phone` INT,
	`Cost` INT NOT NULL,
	PRIMARY KEY (`StudioID`)
);

CREATE TABLE `Participates` (
	`ArtistID` INT NOT NULL,
	`SongID` INT NOT NULL,
	PRIMARY KEY (`ArtistID`,`SongID`)
);

CREATE TABLE `Creates` (
	`ArtistID` INT NOT NULL,
	`CollectionID` INT NOT NULL,
	PRIMARY KEY (`ArtistID`,`CollectionID`)
);

CREATE TABLE `Creates2` (
	`BandID` INT NOT NULL,
	`CollectionID` INT NOT NULL,
	PRIMARY KEY (`BandID`,`CollectionID`)
);

CREATE TABLE `Collections` (
	`CollectionsID` INT NOT NULL,
	`ReleaseDate` DATE,
	PRIMARY KEY (`CollectionsID`)
);

CREATE TABLE `Single` (
	`SingleID` INT NOT NULL,
	`SongID` INT NOT NULL,
	PRIMARY KEY (`SingleID`,`SongID`)
);

CREATE TABLE `Album` (
	`AlbumID` INT NOT NULL,
	`Name` varchar(50) NOT NULL,
	`Genre` varchar(20) NOT NULL,
	PRIMARY KEY (`AlbumID`)
);

CREATE TABLE `Versions` (
	`CollectionID` INT NOT NULL,
	`VersionID` INT NOT NULL,
	`ProductionCost` DECIMAL NOT NULL,
	`Type` varchar(10) NOT NULL,
	PRIMARY KEY (`CollectionID`,`VersionID`)
);

CREATE TABLE `Purchases` (
	`CollectionID` INT NOT NULL,
	`VersionID` INT NOT NULL,
	`ClientID` INT NOT NULL,
	`PurchaseDate` DATE NOT NULL,
	`Terms` varchar(255),
	PRIMARY KEY (`CollectionID`,`VersionID`,`ClientID`)
);

CREATE TABLE `Client` (
	`ClientID` INT NOT NULL,
	`Firstname` varchar(10) NOT NULL,
	`Lastname` varchar(10) NOT NULL,
	`Company` varchar(30) NOT NULL,
	`City` varchar(50),
	`Address` varchar(100),
	`Phone` INT,
	PRIMARY KEY (`ClientID`)
);

CREATE TABLE `Contracts` (
	`ContractID` INT NOT NULL,
	`ArtistID` INT NOT NULL,
	`Terms` varchar(255),
	`StartDate` DATE NOT NULL,
	`ExpDate` DATE NOT NULL,
	PRIMARY KEY (`ContractID`,`ArtistID`)
);

CREATE TABLE `Has` (
	`SongID` INT NOT NULL,
	`AlbumID` INT NOT NULL,
	`TrackNo` INT NOT NULL,
	PRIMARY KEY (`SongID`,`AlbumID`)
);

CREATE TABLE `Lyricist` (
	`LyricistID` INT NOT NULL,
	PRIMARY KEY (`LyricistID`)
);

ALTER TABLE `Artist` ADD CONSTRAINT `Artist_fk0` FOREIGN KEY (`BandID`) REFERENCES `Band`(`BandID`) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE `Musician` ADD CONSTRAINT `Musician_fk0` FOREIGN KEY (`MusicianID`) REFERENCES `Artist`(`ArtistID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Composer` ADD CONSTRAINT `Composer_fk0` FOREIGN KEY (`ComposerID`) REFERENCES `Artist`(`ArtistID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Singer` ADD CONSTRAINT `Singer_fk0` FOREIGN KEY (`SingerID`) REFERENCES `Artist`(`ArtistID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Recorded` ADD CONSTRAINT `Recorded_fk0` FOREIGN KEY (`SongID`) REFERENCES `Song`(`SongID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Recorded` ADD CONSTRAINT `Recorded_fk1` FOREIGN KEY (`StudioID`) REFERENCES `Studio`(`StudioID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Participates` ADD CONSTRAINT `Participates_fk0` FOREIGN KEY (`ArtistID`) REFERENCES `Artist`(`ArtistID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Participates` ADD CONSTRAINT `Participates_fk1` FOREIGN KEY (`SongID`) REFERENCES `Song`(`SongID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Creates` ADD CONSTRAINT `Creates_fk0` FOREIGN KEY (`ArtistID`) REFERENCES `Artist`(`ArtistID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Creates` ADD CONSTRAINT `Creates_fk1` FOREIGN KEY (`CollectionID`) REFERENCES `Collections`(`CollectionsID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Creates2` ADD CONSTRAINT `Creates2_fk0` FOREIGN KEY (`BandID`) REFERENCES `Band`(`BandID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Creates2` ADD CONSTRAINT `Creates2_fk1` FOREIGN KEY (`CollectionID`) REFERENCES `Collections`(`CollectionsID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Single` ADD CONSTRAINT `Single_fk0` FOREIGN KEY (`SingleID`) REFERENCES `Collections`(`CollectionsID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Single` ADD CONSTRAINT `Single_fk1` FOREIGN KEY (`SongID`) REFERENCES `Song`(`SongID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Album` ADD CONSTRAINT `Album_fk0` FOREIGN KEY (`AlbumID`) REFERENCES `Collections`(`CollectionsID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Versions` ADD CONSTRAINT `Release_fk0` FOREIGN KEY (`CollectionID`) REFERENCES `Collections`(`CollectionsID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Purchases` ADD CONSTRAINT `Purchases_fk0` FOREIGN KEY (`CollectionID`, `VersionID`) REFERENCES `Versions`(`CollectionID`, `VersionID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Purchases` ADD CONSTRAINT `Purchases_fk1` FOREIGN KEY (`ClientID`) REFERENCES `Client`(`ClientID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Contracts` ADD CONSTRAINT `Contract_fk0` FOREIGN KEY (`ArtistID`) REFERENCES `Artist`(`ArtistID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Has` ADD CONSTRAINT `Has_fk0` FOREIGN KEY (`SongID`) REFERENCES `Song`(`SongID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Has` ADD CONSTRAINT `Has_fk1` FOREIGN KEY (`AlbumID`) REFERENCES `Album`(`AlbumID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Lyricist` ADD CONSTRAINT `Lyricist_fk0` FOREIGN KEY (`LyricistID`) REFERENCES `Artist`(`ArtistID`) ON DELETE CASCADE ON UPDATE CASCADE;

