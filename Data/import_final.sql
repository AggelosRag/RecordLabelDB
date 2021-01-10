DELETE FROM Creates;
DELETE FROM Creates2;
DELETE FROM Has;
DELETE FROM Participates;
DELETE FROM Recorded;
DELETE FROM Composer;
DELETE FROM Singer;
DELETE FROM Lyricist;
DELETE FROM Musician;
DELETE FROM Purchases;
DELETE FROM Single;
DELETE FROM Song;
DELETE FROM Album;
DELETE FROM Client;
DELETE FROM Versions;
DELETE FROM Collections;
DELETE FROM Studio;
DELETE FROM Artist;
DELETE FROM Band;
DELETE FROM Contracts;

-- insert clients
INSERT INTO Client(ClientID,Firstname,Lastname,City,Address,Company) VALUES (20 , "William" ,"Smith","Arlington","1851  Lightning Point Drive","Spotify");
INSERT INTO Client(ClientID,Firstname,Lastname,City,Address,Company) VALUES (21 , "Albert" ,"Johnson","Los Angeles","1387  Platinum Drive","Google Deezer");
INSERT INTO Client(ClientID,Firstname,Lastname,City,Address,Company) VALUES (22 , "Alonso" ,"Williams","Chicago","4934  Diamond Cove","Itunes");
INSERT INTO Client(ClientID,Firstname,Lastname,City,Address,Company) VALUES (23 , "Anthony" ,"Brown","San Jose","3075  Aaron Smith Drive","ARTMUSIC");
INSERT INTO Client(ClientID,Firstname,Lastname,City,Address,Company) VALUES (24 , "Chester" ,"Jones","Jacksonville","370  Sun Valley Road","ADAGIO MUSIC STORE");
INSERT INTO Client(ClientID,Firstname,Lastname,City,Address,Company) VALUES (25 , "Clare" ,"Garcia","Charlotte","1305  Wilmar Farm Road","PMT London");
INSERT INTO Client(ClientID,Firstname,Lastname,City,Address,Company) VALUES (26 , "David" ,"Jackson","Seattle","1570  Holt Street","Yamaha Music");
INSERT INTO Client(ClientID,Firstname,Lastname,City,Address,Company) VALUES (27 , "Evan" ,"Harris","Boston","485  Randall Drive","Bon Studio");
INSERT INTO Client(ClientID,Firstname,Lastname,City,Address,Company) VALUES (28 , "Harvey" ,"Young","Detroit","2633  Cherry Camp Road","Vinyl City");
INSERT INTO Client(ClientID,Firstname,Lastname,City,Address,Company) VALUES (29 , "Jacob" ,"Wright","Memphis","2237  Sundown Lane","CASIO");

-- insert studios
INSERT INTO Studio(StudioID,Name,City,Address,Cost) VALUES (1 , "Abbey Road Studios", "London", "3 Abbey Rd, St John's Wood", 100);
INSERT INTO Studio(StudioID,Name,City,Address,Cost) VALUES (2 , "Capitol Studios", "Los Angeles", "1750 Vine St", 80);
INSERT INTO Studio(StudioID,Name,City,Address,Cost) VALUES (3 , "Air Studios", "London", "Lyndhurst Rd, Hampstead", 70);
INSERT INTO Studio(StudioID,Name,City,Address,Cost) VALUES (4 , "Platinum Studios", "New York", "59 Franklin St", 90);
INSERT INTO Studio(StudioID,Name,City,Address,Cost) VALUES (5 , "Question De Son", "Paris", "49 Rue du Faubourg Saint-Denis", 120);
INSERT INTO Studio(StudioID,Name,City,Address,Cost) VALUES (6 , "HANSA", "Berlin", "Köthener Str. 38", 60);
INSERT INTO Studio(StudioID,Name,City,Address,Cost) VALUES (7 , "Metropolis Studios", "London", "70 Chiswick High Rd, Chiswick", 80);


-- insert individual artists
INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (1, "M", "Jacques", "Webster", "Travis Scott", "Trap");
    INSERT INTO Singer VALUES (1);
    INSERT INTO Lyricist VALUES (1);
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,1,"Terms",'2020-01-01','2024-01-01');
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (2,1,"Terms",'2015-07-01','2020-01-01');

INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (2, "F", "Stefani", "Germanotta", "Lady Gaga", "Pop");
    INSERT INTO Singer VALUES (2);
    INSERT INTO Lyricist VALUES (2);
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,2,"Terms",'2015-03-20','2016-01-01');
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (2,2,"Terms",'2010-03-11','2015-03-11');

INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (10, "M", "Elvis", "Presley", "Elvis Presley", "Pop");
    INSERT INTO Singer VALUES (10);
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,10,"Terms",'2020-01-01','2024-01-01');
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (2,10,"Terms",'2015-07-01','2020-01-01');

INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (11, "F", "Belcalis", "Almánzar", "Cardi B", "Hip hop");
    INSERT INTO Singer VALUES (11);
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,11,"Terms",'2013-03-21','2017-07-01');

INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (12, "M", "Abel", "Tesfaye", "The Weeknd", "R&B");
    INSERT INTO Singer VALUES (12);
    INSERT INTO Lyricist VALUES (12);
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,12,"Terms",'2015-02-17','2022-01-01');

INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (13, "M", "Drake", "Graham", "Drake", "Hip hop");
    INSERT INTO Singer VALUES (13);
    INSERT INTO Lyricist VALUES (13);
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,13,"Terms",'2015-01-01','2019-01-01');
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (2,13,"Terms",'2013-07-01','2015-01-01');
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (3,13,"Terms",'2019-01-10','2025-01-01');

INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (14, "F", "Ariana", "Butera", "Ariana Grande", "Pop");
    INSERT INTO Singer VALUES (14);
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,14,"Terms",'2018-02-03','2022-02-01');

INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (15, "M", "Jason", "Quenneville", "DaHeala", "R&B");
    INSERT INTO Lyricist VALUES (15);
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,15,"Terms",'2018-02-14','2019-08-01');
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (2,15,"Terms",'2011-07-01','2013-01-01');  

INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (16, "M", "Carlo", "Montagnese", "Illangelo", "R&B");
    INSERT INTO Composer VALUES (16);
    INSERT INTO Musician VALUES (16, "Synthesizer");
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,16,"Terms",'2016-12-01','2021-12-01');
    
INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (17, "M", "Ali", "Payami", "Ali Payami", "R&B");
    INSERT INTO Composer VALUES (17);
    INSERT INTO Musician VALUES (17, "Piano");
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,17,"Terms",'2015-11-01','2021-05-01');
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (2,17,"Terms",'2011-12-01','2015-10-01');
    
INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (18, "M", "Che", "Pope", "Che Pope", "Hip hop");
    INSERT INTO Composer VALUES (18);
    INSERT INTO Musician VALUES (18, "Piano");
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,18,"Terms",'2010-09-15','2012-10-01');

INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre) VALUES (19, "M", "Xavier", "Dotson", "Xavier Dotson", "Trap");
    INSERT INTO Composer VALUES (19);
    INSERT INTO Musician VALUES (19, "Piano");
    INSERT INTO Lyricist VALUES (19);
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,19,"Terms",'1998-01-01','2000-01-01');
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (2,19,"Terms",'2000-02-01','2003-05-29');


-- insert their songs

-- Travis Scott
INSERT INTO Collections VALUES (8, '2004-02-22');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (8,1,12.99,"CD");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (8,2,4.99,"Digital");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (8,3,24.99,"Vinyl");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (8,2,20,'2004-11-14',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (8,2,22,'2004-01-05',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (8,1,26,'2005-09-19',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (8,3,26,'2006-09-19',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (8,3,29,'2005-07-03',"Terms");
    INSERT INTO Creates VALUES (1,8);
    INSERT INTO Album VALUES (8, 'Rodeo', 'Trap');
            INSERT INTO Song VALUES (16, '3500', 5.25, 'R&B', "Original");
                INSERT INTO Participates VALUES (15,16);
                INSERT INTO Participates VALUES (18,16);
                    INSERT INTO Recorded VALUES (16, 1, '2003-11-14', '2003-11-24', 45);
            INSERT INTO Song VALUES (17, 'Wasted', 6.35, 'Trap', "Remix");
                INSERT INTO Participates VALUES (2,17);
                    INSERT INTO Recorded VALUES (17, 2, '2002-10-14', '2002-10-25', 60);    
                    INSERT INTO Recorded VALUES (17, 5, '2002-11-01', '2002-11-03', 10);                                             
            INSERT INTO Song VALUES (18, 'Nightcrawler', 4.39, 'Trap', "Original");
                INSERT INTO Participates VALUES (15,18);
                INSERT INTO Participates VALUES (18,18);
                    INSERT INTO Recorded VALUES (18, 5, '2003-07-20', '2003-07-25', 30);     
            INSERT INTO Has VALUES (16, 8, 1);
            INSERT INTO Has VALUES (17, 8, 2);
            INSERT INTO Has VALUES (18, 8, 3);           
INSERT INTO Collections VALUES (9, '2003-01-20');
    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (9,4,3.99,"CD");
    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (9,5,0.99,"Digital");
	    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (9,5,21,'2003-11-04',"Terms");
	    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (9,4,23,'2003-01-15',"Terms");
	    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (9,4,27,'2004-09-13',"Terms");
	    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (9,4,28,'2005-09-29',"Terms");
	    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (9,5,22,'2004-04-23',"Terms"); 
    INSERT INTO Creates VALUES (1,9);
    INSERT INTO Single VALUES (9, 17);

-- Lady Gaga
INSERT INTO Collections VALUES (10, '2010-05-12');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (10,6,16.99,"CD");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (10,7,6.99,"Digital");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (10,8,34.99,"Vinyl");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (10,7,22,'2011-01-24',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (10,6,24,'2011-01-25',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (10,8,26,'2010-05-09',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (10,7,21,'2012-03-03',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (10,8,29,'2012-06-19',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (10,8,28,'2013-03-13',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (10,6,27,'2017-04-03',"Terms");
    INSERT INTO Creates VALUES (2,10);
    INSERT INTO Album VALUES (10, 'The Fame', 'Pop');
            INSERT INTO Song VALUES (19, 'Just Dance', 6.48, 'Pop' , "Original");
                INSERT INTO Participates VALUES (17,19);
                    INSERT INTO Recorded VALUES (19, 3, '2009-06-22', '2009-06-27', 40);
                    INSERT INTO Recorded VALUES (19, 4, '2009-08-10', '2009-08-14', 15);    
            INSERT INTO Song VALUES (20, 'Poker Face', 4.15, 'Pop', "Remix");
                INSERT INTO Participates VALUES (16,20);
                INSERT INTO Participates VALUES (17,20);  
                    INSERT INTO Recorded VALUES (20, 4, '2010-01-18', '2010-02-28', 35); 
            INSERT INTO Has VALUES (19, 10, 1);
            INSERT INTO Has VALUES (20, 10, 2);
INSERT INTO Collections VALUES (11, '2010-02-18');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (11,9,3.99,"CD");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (11,10,0.99,"Digital");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (11,10,22,'2011-11-24',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (11,9,24,'2010-11-05',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (11,9,28,'2012-05-24',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (11,9,29,'2013-08-22',"Terms");
    INSERT INTO Creates VALUES (2,11);
    INSERT INTO Single VALUES (11, 20);    

-- Cardi B
INSERT INTO Collections VALUES (14, '2018-08-22');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (14,11,15.99,"CD");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (14,12,7.99,"Digital");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (14,13,29.99,"Vinyl");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (14,13,24,'2020-12-27',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (14,13,25,'2019-11-05',"Terms");
    INSERT INTO Creates VALUES (11,14);
    INSERT INTO Album VALUES (14, 'Invasion of Privacy', 'Hip hop');
            INSERT INTO Song VALUES (23, 'Bodak Yellow', 6.28, 'Hip hop', "Original");
                INSERT INTO Participates VALUES (16,23);
                INSERT INTO Participates VALUES (19,23);
                    INSERT INTO Recorded VALUES (23, 6, '2018-07-03', '2018-07-13', 50);
                    INSERT INTO Recorded VALUES (23, 2, '2018-08-03', '2018-08-07', 15);  
            INSERT INTO Song VALUES (24, 'Be Careful', 7.35, 'R&B', "Remix");
                INSERT INTO Participates VALUES (18,24);
                    INSERT INTO Recorded VALUES (24, 6, '2017-09-06', '2017-09-26', 60);
            INSERT INTO Song VALUES (25, 'I Like It', 6.39, 'Hip hop', "Original");
                    INSERT INTO Recorded VALUES (25, 7, '2017-10-06', '2017-10-27', 55);  
            INSERT INTO Has VALUES (23, 14, 1);
            INSERT INTO Has VALUES (24, 14, 2);
            INSERT INTO Has VALUES (25, 14, 3);            

-- The Weekend
INSERT INTO Collections VALUES (15, '2020-03-11');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (15,14,11.99,"CD");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (15,15,11.99,"Digital");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (15,16,49.99,"Vinyl");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (15,15,22,'2020-05-24',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (15,15,20,'2020-04-25',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (15,15,21,'2020-07-09',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (15,14,26,'2020-07-23',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (15,14,25,'2020-03-13',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (15,14,29,'2020-06-19',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (15,16,28,'2020-07-13',"Terms");
    INSERT INTO Creates VALUES (12,15);
    INSERT INTO Album VALUES (15, 'After Hours', 'R&B');
            INSERT INTO Song VALUES (26, 'Heartless', 5.28, 'R&B', "Original");
                INSERT INTO Participates VALUES (15,26);
                INSERT INTO Participates VALUES (16,26);
                    INSERT INTO Recorded VALUES (26, 6, '2020-02-11', '2020-02-18', 50); 
            INSERT INTO Song VALUES (27, 'Blinding Lights', 5.22, 'Hip hop', "Original");
                INSERT INTO Participates VALUES (17,27);
                    INSERT INTO Recorded VALUES (27, 3, '2020-01-10', '2020-01-20', 70);
            INSERT INTO Song VALUES (28, 'In Your Eyes', 4.49, 'R&B', "Remix");
                    INSERT INTO Recorded VALUES (28, 5, '2019-12-06', '2019-12-20', 45);  
            INSERT INTO Has VALUES (26, 15, 1);
            INSERT INTO Has VALUES (27, 15, 2);
            INSERT INTO Has VALUES (28, 15, 3);    
INSERT INTO Collections VALUES (16, '2020-03-29');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (16,17,9.99,"CD");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (16,18,9.99,"Digital");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (16,19,39.99,"Vinyl");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (16,18,22,'2020-04-24',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (16,17,24,'2020-05-25',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (16,19,26,'2020-08-09',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (16,17,26,'2020-09-19',"Terms");		
    INSERT INTO Creates VALUES (12,16);
    INSERT INTO Album VALUES (16, 'Kiss Land', 'Hip hop');
            INSERT INTO Song VALUES (29, 'Kiss Land', 6.28, 'R&B', "Original");
                INSERT INTO Participates VALUES (18,29);
                INSERT INTO Participates VALUES (19,29);
                    INSERT INTO Recorded VALUES (29, 1, '2019-11-04', '2019-11-14', 57); 
            INSERT INTO Song VALUES (30, 'Live For', 6.22, 'Hip hop', "Original");
                INSERT INTO Participates VALUES (15,30);
                INSERT INTO Participates VALUES (17,30);    
                    INSERT INTO Recorded VALUES (30, 2, '2019-11-02', '2019-11-10', 43);           
            INSERT INTO Song VALUES (31, 'Wanderlust', 5.49, 'R&B', "Remix");  
                    INSERT INTO Recorded VALUES (31, 4, '2019-10-23', '2019-10-29', 63); 
            INSERT INTO Song VALUES (32, 'Pretty', 7.49, 'R&B', "Original");
                    INSERT INTO Recorded VALUES (32, 5, '2019-10-18', '2019-10-25', 42);
                    INSERT INTO Recorded VALUES (32, 7, '2019-10-06', '2019-10-11', 23);                
            INSERT INTO Has VALUES (29, 16, 1);
            INSERT INTO Has VALUES (30, 16, 2);
            INSERT INTO Has VALUES (31, 16, 3);   
            INSERT INTO Has VALUES (32, 16, 4);   
INSERT INTO Collections VALUES (17, '2020-03-05');
    INSERT INTO Creates VALUES (12,17);
    INSERT INTO Single VALUES (17, 27);
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (17,20,8.99,"Digital");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (17,20,22,'2020-04-24',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (17,20,21,'2020-04-25',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (17,20,20,'2020-08-09',"Terms");

-- Drake
INSERT INTO Collections VALUES (18, '2018-07-09');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (18,21,13.99,"CD");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (18,22,13.99,"Digital");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (18,23,59.99,"Vinyl");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (18,22,22,'2019-11-14',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (18,22,20,'2016-01-15',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (18,21,23,'2019-05-19',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (18,21,24,'2020-03-13',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (18,21,25,'2019-03-13',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (18,23,26,'2018-09-19',"Terms");
	    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (18,23,28,'2012-03-13',"Terms");
    INSERT INTO Creates VALUES (13,18);
    INSERT INTO Album VALUES (18, 'Scorpion', 'Hip hop');
            INSERT INTO Song VALUES (33, 'Nice for What', 6.13, 'R&B', "Original");
                INSERT INTO Participates VALUES (15,33);
                INSERT INTO Participates VALUES (18,33);
                INSERT INTO Participates VALUES (19,33);
                    INSERT INTO Recorded VALUES (33, 5, '2018-03-20', '2018-03-29', 61);                
            INSERT INTO Song VALUES (34, 'In My Feelings', 7.22, 'Hip hop', "Original");
                INSERT INTO Participates VALUES (17,34);
                    INSERT INTO Recorded VALUES (34, 7, '2018-03-14', '2018-03-22', 57);
            INSERT INTO Song VALUES (35, 'In Your Eyes', 4.49, 'Pop', "Remix");
                    INSERT INTO Recorded VALUES (35, 3, '2018-03-01', '2018-03-17', 82);  
            INSERT INTO Has VALUES (33, 18, 1);
            INSERT INTO Has VALUES (34, 18, 2);
            INSERT INTO Has VALUES (35, 18, 3);      
INSERT INTO Collections VALUES (19, '2018-05-09');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (19,24,0.99,"Digital");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (19,24,29,'2018-06-24',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (19,24,28,'2018-07-25',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (19,24,27,'2019-05-09',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (19,24,26,'2019-11-23',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (19,24,25,'2020-12-03',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (19,24,24,'2020-06-19',"Terms");		
    INSERT INTO Creates VALUES (13,19);
    INSERT INTO Single VALUES (19, 33);
INSERT INTO Collections VALUES (20, '2018-04-09');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (20,25,0.99,"Digital");
    INSERT INTO Creates VALUES (13,20);
    INSERT INTO Single VALUES (20, 35);  

-- Ariana Grande
INSERT INTO Collections VALUES (21, '2019-03-14');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (21,26,9.99,"CD");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (21,27,7.99,"Digital");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (21,28,29.99,"Vinyl");
    INSERT INTO Creates VALUES (14,21);
    INSERT INTO Album VALUES (21, 'The Best', 'Pop');
            INSERT INTO Song VALUES (36, 'Break Free', 5.53, 'Pop', "Original");
                INSERT INTO Participates VALUES (17,36);
                INSERT INTO Participates VALUES (18,36);
                    INSERT INTO Recorded VALUES (36, 3, '2018-12-01', '2018-12-23', 47); 
            INSERT INTO Song VALUES (37, 'Problem', 5.14, 'Pop', "Original");
                INSERT INTO Participates VALUES (18,37);
                    INSERT INTO Recorded VALUES (37, 4, '2018-12-14', '2018-12-26', 42);
            INSERT INTO Song VALUES (38, 'In Your Eyes', 4.49, 'Pop', "Remix"); 
                    INSERT INTO Recorded VALUES (38, 2, '2018-11-27', '2018-12-06', 34); 
            INSERT INTO Has VALUES (36, 21, 1);
            INSERT INTO Has VALUES (37, 21, 2);
            INSERT INTO Has VALUES (38, 21, 3);   


-- insert music bands and their songs

-- Metallica
INSERT INTO Band (BandID, Name) VALUES (1,"Metallica");
    -- insert band artists
    INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre,BandID) VALUES (3, "M", "James", "Hetfield", "James Hetfield", "Rock", 1);
        INSERT INTO Musician VALUES (3,"Guitar");
        INSERT INTO Lyricist VALUES (3);
        INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,3,"Terms",'2018-01-01','2019-01-01');
    	INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (2,3,"Terms",'2014-07-01','2015-07-11');
    	
    INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre,BandID) VALUES (4, "M", "Lars", "Ulrich", "Lars Ulrich", "Rock", 1);
        INSERT INTO Musician VALUES (4,"Drums");
        INSERT INTO Lyricist VALUES (4);
        INSERT INTO Composer VALUES (4);
        INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,4,"Terms",'2018-01-01','2019-01-01');

    INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre,BandID) VALUES (5, "M", "Kirk", "Hammett", "Kirk Hammett", "Rock", 1);
        INSERT INTO Singer VALUES (5);
        INSERT INTO Musician VALUES (5,"Guitar");
        INSERT INTO Lyricist VALUES (5);
        INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,5,"Terms",'2018-01-01','2019-01-01');

    -- insert band collections
    INSERT INTO Collections VALUES (1, '1988-04-20');
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (1,29,19.99,"CD");
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (1,30,19.99,"Digital");
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (1,31,59.99,"Vinyl");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (1,30,21,'1988-11-27',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (1,30,20,'1988-08-28',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (1,31,27,'1989-08-29',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (1,31,26,'1989-03-03',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (1,31,23,'1990-12-09',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (1,31,22,'1988-06-12',"Terms");
        INSERT INTO Creates2 VALUES (1,1);
        INSERT INTO Album VALUES (1, '...And Justice For All', 'Rock');
            INSERT INTO Song VALUES (1,'One',7.25,'Rock', "Original");
                INSERT INTO Participates VALUES (2,1);
                    INSERT INTO Recorded VALUES (1, 7, '1987-04-20', '1987-04-30', 56);
            INSERT INTO Song VALUES (2,'Blackened',6.42,'Rock', "Original");
                    INSERT INTO Recorded VALUES (2, 2, '1987-05-20', '1987-05-30', 48);
            INSERT INTO Song VALUES (3,'The Shortest Straw',6.35,'Rock', "Original");
                    INSERT INTO Recorded VALUES (3, 6, '1987-06-20', '1987-06-30', 49);
            INSERT INTO Song VALUES (4,"Harvester of Sorrow",5.42,'Rock', "Original");
                    INSERT INTO Recorded VALUES (4, 5, '1987-07-20', '1987-07-30', 42);
            INSERT INTO Song VALUES (5,	"To Live is to Die",9.48,'Rock', "Original");
                    INSERT INTO Recorded VALUES (5, 7, '1987-08-20', '1987-08-30', 45);
            INSERT INTO Song VALUES (6,	"Dyers Eve",5.12,'Rock', "Original");
                    INSERT INTO Recorded VALUES (6, 7, '1987-09-20', '1987-09-30', 41);
            INSERT INTO Has VALUES (1, 1, 1);
            INSERT INTO Has VALUES (2, 1, 2);
            INSERT INTO Has VALUES (3, 1, 3);
            INSERT INTO Has VALUES (4, 1, 4);
            INSERT INTO Has VALUES (5, 1, 5);
            INSERT INTO Has VALUES (6, 1, 6);
    INSERT INTO Collections VALUES (2, '1988-01-20');
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (2,32,7.99,"CD");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (2,32,26,'1988-07-17',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (2,32,23,'1989-10-19',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (2,32,27,'1989-10-12',"Terms");
        INSERT INTO Creates2 VALUES (1,2);
        INSERT INTO Single VALUES (2, 1);
    INSERT INTO Collections VALUES (3, '1988-02-20');
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (3,33,7.99,"CD");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (3,33,26,'1988-04-16',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (3,33,23,'1989-10-07',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (3,33,25,'1989-06-17',"Terms");
        INSERT INTO Creates2 VALUES (1,3);
        INSERT INTO Single VALUES (3, 2);

-- The Beatles
INSERT INTO Band (BandID, Name) VALUES (2,"The Beatles");
    -- insert band artists
    INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre,BandID) VALUES (6, "M", "John", "Lennon", "John Lennon", "Pop", 2);
        INSERT INTO Musician VALUES (6,"Guitar");
        INSERT INTO Lyricist VALUES (6);
        INSERT INTO Singer VALUES (6);
	INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,6,"Terms",'2020-06-15','2025-07-01');
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (2,6,"Terms",'2014-06-21','2015-07-15');

    INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre,BandID) VALUES (7, "M", "Paul", "McCartney", "Paul McCartney", "Pop", 2);
        INSERT INTO Musician VALUES (7,"Guitar");
        INSERT INTO Singer VALUES (7);
        INSERT INTO Composer VALUES (7);
        INSERT INTO Lyricist VALUES (7);
	INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,7,"Terms",'2020-06-15','2025-07-01');
    INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (2,7,"Terms",'2014-06-21','2015-07-15');

    INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre,BandID) VALUES (8, "M", "George", "Harrison", "George Harrison", "Pop", 2);
        INSERT INTO Musician VALUES (8,"Sitar");
        INSERT INTO Composer VALUES (8);
	INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,8,"Terms",'2020-06-15','2025-07-01');
    	
    INSERT INTO Artist (ArtistID,Gender,Firstname,Lastname,ArtisticName,Genre,BandID) VALUES (9, "M", "Richard", "Starkey", "Richard Starkey", "Pop", 2);
        INSERT INTO Musician VALUES (9,"Drums");
        INSERT INTO Composer VALUES (9);
	INSERT INTO Contracts (ContractID,ArtistID,Terms,StartDate,ExpDate) VALUES (1,9,"Terms",'2020-06-15','2025-07-01');
    	

    -- insert band collections
    INSERT INTO Collections VALUES (4, '1967-09-26');
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (4,34,13.99,"CD");
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (4,35,8.99,"Digital");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (4,34,28,'1988-09-25',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (4,34,24,'1988-11-29',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (4,35,22,'1988-09-23',"Terms");
        INSERT INTO Creates2 VALUES (2,4);
        INSERT INTO Album VALUES (4, 'Sgt. Pepper''s Lonely Hearts Club Band', 'Pop');
            INSERT INTO Song VALUES(7,'Sgt. Pepper''s Lonely Hearts Club Band', 2.0333, 'Pop', "Original");
                    INSERT INTO Recorded VALUES (7, 3, '1966-01-23', '1966-01-31', 56);
            INSERT INTO Song VALUES(8,'With a Little Help from My Friends', 2.7333, 'Pop', "Original");
                    INSERT INTO Recorded VALUES (8, 4, '1966-02-23', '1966-03-05', 47);
            INSERT INTO Song VALUES(9,'Lucy in the Sky with Diamonds', 3.4666, 'Pop', "Original");
                    INSERT INTO Recorded VALUES (9, 2, '1966-03-23', '1966-03-30', 36);
            INSERT INTO Song VALUES(10,'Getting Better', 2.80, 'Pop', "Original");
                    INSERT INTO Recorded VALUES (10, 4, '1966-05-23', '1966-05-30', 72);
            INSERT INTO Song VALUES(11,'Fixing a Hole', 2.60, 'Pop', "Original");
                    INSERT INTO Recorded VALUES (11, 1, '1966-06-23', '1966-06-30', 81);
            INSERT INTO Has VALUES (7, 4, 1);
            INSERT INTO Has VALUES (8, 4, 2);
            INSERT INTO Has VALUES (9, 4, 3);
            INSERT INTO Has VALUES (10, 4, 4);
            INSERT INTO Has VALUES (11, 4, 5);
    INSERT INTO Collections VALUES (5, '1972-11-12');
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (5,36,26.99,"CD");
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (5,37,89.99,"Vinyl");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (5,37,27,'1989-10-05',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (5,37,23,'1989-11-29',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (5,37,26,'1989-01-03',"Terms");
        INSERT INTO Creates2 VALUES (2,5);
        INSERT INTO Album VALUES (5, 'Abbey Road', 'Rock');
            INSERT INTO Song VALUES(12,'Come Together', 4.20, 'Rock', "Original");
                    INSERT INTO Recorded VALUES (12, 1, '1971-06-12', '1971-06-25', 81);
            INSERT INTO Song VALUES(13,'Something', 3.03, 'Rock', "Original");
                    INSERT INTO Recorded VALUES (13, 1, '1971-07-12', '1971-07-25', 36);
            INSERT INTO Song VALUES(14,'Oh! Darling', 3.27, 'Rock', "Original");
                    INSERT INTO Recorded VALUES (14, 1, '1971-08-12', '1971-08-25', 56);
                    INSERT INTO Recorded VALUES (14, 2, '1971-09-12', '1971-09-25', 12);
            INSERT INTO Song VALUES(15,'I Want You', 3.26, 'Rock', "Original");
                    INSERT INTO Recorded VALUES (15, 1, '1971-10-12', '1971-10-25', 45);
                    INSERT INTO Recorded VALUES (15, 4, '1971-11-12', '1971-11-25', 62);
            INSERT INTO Has VALUES (12, 5, 1);
            INSERT INTO Has VALUES (13, 5, 2);
            INSERT INTO Has VALUES (14, 5, 3);
            INSERT INTO Has VALUES (15, 5, 4);
    INSERT INTO Collections VALUES (6, '1972-03-02');
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (6,38,3.99,"CD");
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (6,39,1.99,"Digital");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (6,38,23,'1989-11-15',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (6,38,29,'1989-10-08',"Terms");
            INSERT INTO Creates2 VALUES (2,6);
            INSERT INTO Single VALUES (6, 13);
    INSERT INTO Collections VALUES (7, '1972-05-07');
	    INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (7,40,1.99,"Digital");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (7,40,20,'1989-10-06',"Terms");
		    INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (7,40,22,'1989-07-22',"Terms");
        INSERT INTO Creates2 VALUES (2,7);
        INSERT INTO Single VALUES (7, 14);


-- Bands and individual artists
 
-- Elvis Presley
INSERT INTO Collections VALUES (12, '1998-11-02');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (12,41,1.99,"Digital");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (12,42,1.99,"Vinyl");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (12,42,26,'1999-04-16',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (12,42,27,'1998-12-07',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (12,42,28,'2000-06-17',"Terms");
    INSERT INTO Creates VALUES (10,12);
            INSERT INTO Song VALUES (21, 'Suspicious Minds', 7.02, 'Pop', "Original");
                    INSERT INTO Recorded VALUES (21, 5, '1998-09-12', '1998-09-25', 56);
    INSERT INTO Single VALUES (12, 21); 
INSERT INTO Collections VALUES (13, '2010-02-18');
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (13,43,1.99,"Digital");
	INSERT INTO Versions (CollectionID,VersionID, ProductionCost,Type) VALUES (13,44,1.99,"Vinyl");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (13,44,26,'2013-04-16',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (13,44,25,'2017-10-07',"Terms");
		INSERT INTO Purchases (CollectionID,VersionID,ClientID,PurchaseDate,Terms) VALUES (13,43,20,'2018-06-17',"Terms");
    INSERT INTO Creates VALUES (10,13);
            INSERT INTO Song VALUES (22, 'Burning Love', 6.15, 'Pop', "Remix");
                INSERT INTO Participates VALUES (6,22);
                INSERT INTO Participates VALUES (7,22);  
                    INSERT INTO Recorded VALUES (22, 3, '2009-11-12', '2009-12-03', 61);
    INSERT INTO Single VALUES (13, 22); 



