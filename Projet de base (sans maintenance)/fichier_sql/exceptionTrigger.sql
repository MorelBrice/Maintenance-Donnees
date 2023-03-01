--Pour verifier la contrainte :  un seul nom par Poney
insert insert into PONEY(idp, nomP, robe, DDNP, disciplineP, anneeService) values
(131, "Sleipnir", "noir", "1965-07-20", "Dressage", 2);

-- Pour verifier la contrainte : Pas plus de 10 élèves par cours
insert into RESERVER (idc,ide) values
(1000,1),
(1001,1),
(1002,1),
(1003,1),
(1004,1),
(1005,1),
(1006,1),
(1007,1),
(1008,1),
(1009,1),
(1010,1),;