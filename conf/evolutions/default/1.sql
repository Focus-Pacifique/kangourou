# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table equipe (
  id                        bigint auto_increment not null,
  nomEquipe                 varchar(255),
  constraint pk_equipe primary key (id))
;

create table journee (
  id                        bigint auto_increment not null,
  NomJournee                varchar(255),
  Matche1                   bigint,
  Matche2                   bigint,
  Matche3                   bigint,
  Matche4                   bigint,
  Matche5                   bigint,
  Matche6                   bigint,
  Matche7                   bigint,
  Matche8                   bigint,
  Matche9                   bigint,
  Matche10                  bigint,
  dateJournee               datetime,
  constraint pk_journee primary key (id))
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
  pseudo                    varchar(255) not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  points                    integer,
  password                  varchar(255),
  constraint pk_utilisateur primary key (pseudo))
;

alter table journee add constraint fk_journee_matche1_1 foreign key (Matche1) references matche (id) on delete restrict on update restrict;
create index ix_journee_matche1_1 on journee (Matche1);
alter table journee add constraint fk_journee_matche2_2 foreign key (Matche2) references matche (id) on delete restrict on update restrict;
create index ix_journee_matche2_2 on journee (Matche2);
alter table journee add constraint fk_journee_matche3_3 foreign key (Matche3) references matche (id) on delete restrict on update restrict;
create index ix_journee_matche3_3 on journee (Matche3);
alter table journee add constraint fk_journee_matche4_4 foreign key (Matche4) references matche (id) on delete restrict on update restrict;
create index ix_journee_matche4_4 on journee (Matche4);
alter table journee add constraint fk_journee_matche5_5 foreign key (Matche5) references matche (id) on delete restrict on update restrict;
create index ix_journee_matche5_5 on journee (Matche5);
alter table journee add constraint fk_journee_matche6_6 foreign key (Matche6) references matche (id) on delete restrict on update restrict;
create index ix_journee_matche6_6 on journee (Matche6);
alter table journee add constraint fk_journee_matche7_7 foreign key (Matche7) references matche (id) on delete restrict on update restrict;
create index ix_journee_matche7_7 on journee (Matche7);
alter table journee add constraint fk_journee_matche8_8 foreign key (Matche8) references matche (id) on delete restrict on update restrict;
create index ix_journee_matche8_8 on journee (Matche8);
alter table journee add constraint fk_journee_matche9_9 foreign key (Matche9) references matche (id) on delete restrict on update restrict;
create index ix_journee_matche9_9 on journee (Matche9);
alter table journee add constraint fk_journee_matche10_10 foreign key (Matche10) references matche (id) on delete restrict on update restrict;
create index ix_journee_matche10_10 on journee (Matche10);
alter table matche add constraint fk_matche_equipe1_11 foreign key (Equipe1) references equipe (id) on delete restrict on update restrict;
create index ix_matche_equipe1_11 on matche (Equipe1);
alter table matche add constraint fk_matche_equipe2_12 foreign key (Equipe2) references equipe (id) on delete restrict on update restrict;
create index ix_matche_equipe2_12 on matche (Equipe2);
alter table matche add constraint fk_matche_vainqueur_13 foreign key (vainqueur) references equipe (id) on delete restrict on update restrict;
create index ix_matche_vainqueur_13 on matche (vainqueur);
alter table pronostique add constraint fk_pronostique_matche_14 foreign key (matche) references matche (id) on delete restrict on update restrict;
create index ix_pronostique_matche_14 on pronostique (matche);
alter table pronostique add constraint fk_pronostique_utilisateur_15 foreign key (utilisateur) references utilisateur (pseudo) on delete restrict on update restrict;
create index ix_pronostique_utilisateur_15 on pronostique (utilisateur);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table equipe;

drop table journee;

drop table matche;

drop table pronostique;

drop table utilisateur;

SET FOREIGN_KEY_CHECKS=1;

