
create table Clients(
	Cust_usrnme Varchar(25) primary key,
	Cust_psword Varchar(50) not null,
	Cust_name Varchar(50) 
);
create table Staff(
	Emp_name varchar(25) not null,
	Emp_usrnme varchar(25) primary key, 
	Emp_psword Varchar(50) not null,
	Emp_rank numeric (2,0)
);
create table inventory(
	Prd_Name Varchar(50) primary key,
	Prd_Bid numeric(9,2),
	Offer_made Bool,
	Offer_accept Bool,
	Own_usrnme varchar(25)
);
create table offers(
	Cust_ID Varchar(50),
	Amnt numeric(9,2),
	prd_NM varchar (50),
	Serial_num numeric(11,0),
	Accepted Bool
	

);

-- This is imported data from Mockaroo for Clients.

insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('ibrain0', '4cUXrGes6', 'Israel Brain');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('ekilpin1', 'nisY5O8', 'Ermanno Kilpin');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('eelia2', '6HWAKl6taTtf', 'Erl Elia');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('kworsnop3', 'Huw5LvrdA', 'Kessia Worsnop');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('tstudholme4', 'UFmedY', 'Troy Studholme');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('atoderini5', 'gsADQvSuHEv', 'Alayne Toderini');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('hcale6', '08eg2sO', 'Hunfredo Cale');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('rtenby7', 'IFEWsqat', 'Rinaldo Tenby');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('rglanz8', 'astWPOqu', 'Roderigo Glanz');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('alappin9', 'l7NWofqyatYT', 'Audre Lappin');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('fdreighera', 'L8wZBNYY', 'Fawne Dreigher');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('aissacofb', '14mNHoz6Ub', 'Avrom Issacof');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('sbeethamc', 'O3jvxeGGL', 'Stephannie Beetham');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('sknowlesd', 'xv936PbC', 'Sibella Knowles');
insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values ('mballefante', 'GG4OLJomYTC', 'Marilee Ballefant');

-- This is imported data from Mockaroo for Staff. 

insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Clara Basilio', 'cbasilio0', 'FYKFnzxoH3Y', 11);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Lane Roberds', 'lroberds1', 'E3yKst0nFisS', 4);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Karlik Tembey', 'ktembey2', '2QUdJkLMTx2N', 4);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Carol-jean Jewel', 'cjewel3', 'ueMpaD', 2);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Tam Doorly', 'tdoorly4', 'PxGxxl5hXCD', 9);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Karlan Gonzalo', 'kgonzalo5', 'XDHE6U', 2);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Travis Batchellor', 'tbatchellor6', 'A2XGYwtf2', 3);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Matthaeus Bending', 'mbending7', 'o8UXWM', 1);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Kerk Hawkslee', 'khawkslee8', 'OPQGlY9EHc', 5);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Emylee Lownie', 'elownie9', 'aUVB5T7', 9);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Irene Abotson', 'iabotsona', 'NMqpzx57toek', 3);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Laurella Allicock', 'lallicockb', 'mXTyl5E', 4);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Renaud Rosier', 'rrosierc', '88mKfGhQaIZb', 8);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Calvin Gertz', 'cgertzd', 'SQe13vs', 3);
insert into Staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values ('Gustavo Hun', 'ghune', 'itNGGGPphY4g', 10);

--This is imported data from Mockaroo for Inventory

insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('Grand Voyager', 71583.14, false, false, 'acrewther0');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('Maxima', 61669.84, false, true, 'lpettersen1');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('Sierra 1500', 40269.1, true, false, 'dvalenta2');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('SJ', 27949.35, true, true, 'vlane3');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('Seville', 40366.02, false, false, 'bhamm4');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('E350', 35615.31, false, false, 'mwollacott5');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('Amanti', 35067.37, false, false, 'khaitlie6');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('Continental', 91760.36, false, false, 'ahastwall7');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('Voyager', 12796.41, true, true, 'awalklate8');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('Yukon', 11349.41, false, false, 'npadberry9');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('M3', 67075.4, false, false, 'bsneatha');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('Elan', 97047.4, true, true, 'hcoppinb');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('Gran Sport', 98020.71, false, false, 'vcaponc');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('A6', 98637.88, false, true, 'lveldmand');
insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values ('LaCrosse', 94210.55, false, false, 'gduerdene');