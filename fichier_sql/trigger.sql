delimiter |
create or replace trigger 10PersMaxParCours before insert on RESERVER for each row
begin
    declare nbins int;
    declare mes varchar(100);

    select count(*) into nbins from RESERVER where idc = new.idc;

    if nbins + 1 > 10 then
        set mes = concat('il y a deja 10 personne inscrite dans ce cours');
        signal SQLSTATE '45000' set message_text = mes;
    end if;
end |

create or replace trigger 10PersMaxParCours before update on RESERVER for each row
begin
    declare nbins int;
    declare mes varchar(100);

    select count(*) into nbins from RESERVER where idc=new.idc;

    if nbins + 1 > 10 then
        set mes = concat('il y a deja 10 personne inscrite dans ce cours');
        signal SQLSTATE '45000' set message_text=mes;
    end if;
end |

create or replace trigger UnNomParPoney before insert on PONEY for each row
begin
    declare nbins int;
    declare mes varchar(100);

    select count(*) into nbins from PONEY where nomP=new.nomP;

    if nbins > 0 then
        set mes = concat('Il y a deja un poney possedant le nom : ', new.nomP,'');
        signal SQLSTATE '45000' set message_text=mes;
    end if;
end |

create or replace trigger UnNomParPoney before update on PONEY for each row
begin
    declare nbins int;
    declare mes varchar(100);

    select count(*) into nbins from PONEY where nomP = new.nomP;

    if nbins > 0 then
        set mes = concat('Il y a deja un poney possedant le nom : ', new.nomP,'');
        signal SQLSTATE '45000' set message_text=mes;
    end if;
end |


delimiter ;