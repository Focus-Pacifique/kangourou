# --- Sample dataset

# --- !Ups

insert into equipe (id,nomEquipe) values (1,'Ajaccio');
insert into equipe (id,nomEquipe) values (2,'Bastia');
insert into equipe (id,nomEquipe) values (3,'Bordeaux');
insert into equipe (id,nomEquipe) values (4,'Brest');
insert into equipe (id,nomEquipe) values (5,'Evian TG');
insert into equipe (id,nomEquipe) values (6,'Lille');
insert into equipe (id,nomEquipe) values (7,'Lorient');
insert into equipe (id,nomEquipe) values (8,'Lyon');
insert into equipe (id,nomEquipe) values (9,'Marseille');
insert into equipe (id,nomEquipe) values (10,'Montpellier');
insert into equipe (id,nomEquipe) values (11,'Nancy');
insert into equipe (id,nomEquipe) values (12,'Nice');
insert into equipe (id,nomEquipe) values (13,'Paris');
insert into equipe (id,nomEquipe) values (14,'Reims');
insert into equipe (id,nomEquipe) values (15,'Rennes');
insert into equipe (id,nomEquipe) values (16,'Saint-Etienne');
insert into equipe (id,nomEquipe) values (17,'Sochaux');
insert into equipe (id,nomEquipe) values (18,'Toulouse');
insert into equipe (id,nomEquipe) values (19,'Troyes');
insert into equipe (id,nomEquipe) values (20,'Valenciennes');

insert into matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (1,10,18,null,null,null,'2012-08-10 20:45:00');
insert into matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (2,5,3,null,null,null,'2012-08-11 21:00:00');
insert into matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (3,11,4,null,null,null,'2012-08-11 21:00:00');
insert into matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (4,12,1,null,null,null,'2012-08-11 21:00:00');
insert into matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (5,13,7,null,null,null,'2012-08-11 21:00:00');
insert into matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (6,15,8,null,null,null,'2012-08-11 21:00:00');
insert into matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (7,16,6,null,null,null,'2012-08-11 21:00:00');
insert into matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (8,17,2,null,null,null,'2012-08-11 21:00:00');
insert into matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (9,19,20,null,null,null,'2012-08-11 21:00:00');
insert into matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (10,14,9,null,null,null,'2012-08-12 21:00:00');

insert into journee (id,NomJournee,Matche1,Matche2,Matche3,Matche4,Matche5,Matche6,Matche7,Matche8,Matche9,Matche10,dateJournee) values (1,'1ère journée',1,2,3,4,5,6,7,8,9,10,'2012-08-10 20:45:00');