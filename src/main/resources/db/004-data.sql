insert into address(_index, city, street, home_number, apartment)
       values ('123456', 'Moskva', 'Lenina', '5', '1');
insert into address(_index, city, street, home_number, apartment)
       values ('123456', 'Spb', 'Zingera', '500', '-');
insert into company(name, address_id, type)
       values ('Roga kopyta', 1, 'IP');
insert into filial(name, address_id, company_id)
       values ('Roga kopyta (doch. Spb)', 2, 1);