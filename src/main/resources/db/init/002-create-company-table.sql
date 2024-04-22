CREATE TABLE company
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         varchar(255) not null,
    address_id   int not null,
    type         varchar(15)
);
alter table company add foreign key (address_id) references address(ID);