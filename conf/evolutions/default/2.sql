# --- Sample dataset

# --- !Ups

insert into Equipe (id,nomEquipe) values (  1,'Ajaccio');
insert into Equipe (id,nomEquipe) values (  2,'Bastia');
insert into Equipe (id,nomEquipe) values (  3,'Bordeaux');
insert into Equipe (id,nomEquipe) values (  4,'Brest');
insert into Equipe (id,nomEquipe) values (  5,'Evian TG');
insert into Equipe (id,nomEquipe) values (  6,'Lille');
insert into Equipe (id,nomEquipe) values (  7,'Lorient');
insert into Equipe (id,nomEquipe) values (  8,'Lyon');
insert into Equipe (id,nomEquipe) values (  9,'Marseille');
insert into Equipe (id,nomEquipe) values (  10,'Montpellier');
insert into Equipe (id,nomEquipe) values (  11,'Nancy');
insert into Equipe (id,nomEquipe) values (  12,'Nice');
insert into Equipe (id,nomEquipe) values (  13,'Paris');
insert into Equipe (id,nomEquipe) values (  14,'Reims');
insert into Equipe (id,nomEquipe) values (  15,'Rennes');
insert into Equipe (id,nomEquipe) values (  16,'Saint-Etienne');
insert into Equipe (id,nomEquipe) values (  17,'Sochaux');
insert into Equipe (id,nomEquipe) values (  18,'Toulouse');
insert into Equipe (id,nomEquipe) values (  19,'Troyes');
insert into Equipe (id,nomEquipe) values (  20,'Valenciennes');

insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (1,10,18,2,0,10,now());
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (2,5,3,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (3,11,4,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (4,12,1,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (5,13,7,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (6,15,8,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (7,16,6,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (8,17,2,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (9,19,20,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (10,14,9,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur,dateMatche) values (11,1,2,0,0,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (12,4,3,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (13,5,6,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (14,8,7,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (15,9,10,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (16,12,11,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (17,13,14,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (18,16,15,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (19,17,18,null,null,null);
insert into Matche (id,equipe1,equipe2,scoreEquipe1,scoreEquipe2,vainqueur) values (20,20,19,null,null,null);

insert into Journee (id,NomJournee,Matche1,Matche2,Matche3,Matche4,Matche5,Matche6,Matche7,Matche8,Matche9,Matche10,dateJournee) values (1,'1ère journée',1,2,3,4,5,6,7,8,9,10,now());
insert into Journee (id,NomJournee,Matche1,Matche2,Matche3,Matche4,Matche5,Matche6,Matche7,Matche8,Matche9,Matche10,dateJournee) values (2,'2ème journée',11,12,13,14,15,16,17,18,19,20,null);

<<<<<<< HEAD
insert into Utilisateur (nom,prenom,points,password) values ('toto','toto',0,'toto');
insert into Utilisateur (nom,prenom,points,password) values ('Gui','Sabot',10,'test');
=======
insert into Utilisateur (pseudo,nom,prenom,points,password) values ('Manoosh','Molle','Alexis',0,'alex');
>>>>>>> Inscription utilisateur

insert into Pronostique (id,matche,utilisateur,pronoEquipe1,pronoEquipe2) values (1,1,'Manoosh',3,2);

# --- !Downs

delete from Pronostique;
<<<<<<< HEAD
delete from Journee;
=======
>>>>>>> Inscription utilisateur
delete from Matche;
delete from Equipe;
delete from Utilisateur;