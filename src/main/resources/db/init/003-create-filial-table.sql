CREATE TABLE filial
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         varchar(255) not null,
    address_id   int not null,
    company_id   int
);
alter table filial add foreign key (address_id) references address(ID);
alter table filial add foreign key (company_id) references company(ID);
