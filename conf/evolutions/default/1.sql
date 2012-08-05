# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table equipe (
  id                        bigint auto_increment not null,
  nomEquipe                 varchar(255),
  constraint pk_equipe primary key (id))
;

create table matche (
  id                        bigint auto_increment not null,
  Equipe1                   bigint,
  Equipe2                   bigint,
  scoreEquipe1              integer,
  scoreEquipe2              integer,
  vainqueur                 bigint,
  dateMatche                datetime,
  constraint pk_matche primary key (id))
;

create table pronostique (
  id                        bigint auto_increment not null,
  matche                    bigint,
  utilisateur               varchar(255),
  pronoEquipe1              integer,
  pronoEquipe2              integer,
  constraint pk_pronostique primary key (id))
;

create table utilisateur (
  nom                       varchar(255) not null,
  prenom                    varchar(255),
  points                    integer,
  password                  varchar(255),
  constraint pk_utilisateur primary key (nom))
;

alter table matche add constraint fk_matche_equipe1_1 foreign key (Equipe1) references equipe (id) on delete restrict on update restrict;
create index ix_matche_equipe1_1 on matche (Equipe1);
alter table matche add constraint fk_matche_equipe2_2 foreign key (Equipe2) references equipe (id) on delete restrict on update restrict;
create index ix_matche_equipe2_2 on matche (Equipe2);
alter table matche add constraint fk_matche_vainqueur_3 foreign key (vainqueur) references equipe (id) on delete restrict on update restrict;
create index ix_matche_vainqueur_3 on matche (vainqueur);
alter table pronostique add constraint fk_pronostique_matche_4 foreign key (matche) references matche (id) on delete restrict on update restrict;
create index ix_pronostique_matche_4 on pronostique (matche);
alter table pronostique add constraint fk_pronostique_utilisateur_5 foreign key (utilisateur) references utilisateur (nom) on delete restrict on update restrict;
create index ix_pronostique_utilisateur_5 on pronostique (utilisateur);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table equipe;

drop table matche;

drop table pronostique;

drop table utilisateur;

SET FOREIGN_KEY_CHECKS=1;

