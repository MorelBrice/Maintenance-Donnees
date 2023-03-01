create table PERSONNE(
    idPersonne int(9),
    nom varchar(30),
    prenom varchar(30),
    DDN date,
    PRIMARY KEY (idPersonne)
);

create table ELEVE(
    idPersonne int(9),
    ide int(9),
    poids int(9),
    galop int(1),
    taille int(3),
    PRIMARY KEY (ide)
);

create table MONITEUR(
    idPersonne int(9),
    idm int(9),
    license varchar(8),
    descriptionM varchar(100),
    PRIMARY KEY (idm)
) ;

create table PONEY(
    idp int(9),
    nomP varchar(50), 
    robe varchar(30),
    DDNP date,
    disciplineP varchar(30),
    anneeService int(2),
    PRIMARY KEY (idp)
);

create table COURS(
    idc int(9),
    nomC varchar(30),
    dateC date,
    heureDeb time,
    heureFin time,
    idPersonne int(9),
    idm int(9),
    PRIMARY KEY (idc, idPersonne, idm)
);

create table PARTICIPER(
    idc int(9),
    idp int(9),
    PRIMARY KEY (idc, idp)
);

create table RESERVER(
    idc int(9),
    ide int(9),
    PRIMARY KEY (idc, ide)
);


-- TABLE COURS
ALTER TABLE COURS ADD FOREIGN KEY (idPersonne) REFERENCES PERSONNE (idPersonne);
ALTER TABLE COURS ADD FOREIGN KEY (idm) REFERENCES MONITEUR (idm);

-- TABLE PARTICIPER
ALTER TABLE PARTICIPER ADD FOREIGN KEY (idc) REFERENCES COURS (idc);
ALTER TABLE PARTICIPER ADD FOREIGN KEY (idp) REFERENCES PONEY (idp);

-- TABLE RESERVER

ALTER TABLE RESERVER ADD FOREIGN KEY (idc) REFERENCES COURS (idc);
ALTER TABLE RESERVER ADD FOREIGN KEY (ide) REFERENCES ELEVE (ide);

-- HERITAGE PERSONNE

ALTER TABLE MONITEUR ADD FOREIGN KEY (idPersonne) REFERENCES PERSONNE (idPersonne);
ALTER TABLE ELEVE ADD FOREIGN KEY (idPersonne) REFERENCES PERSONNE (idPersonne);
