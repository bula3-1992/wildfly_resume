create table address
(
    id                      INT AUTO_INCREMENT PRIMARY KEY,
    _index                  varchar(15),
    city                    varchar(255) not null,
    street                  varchar(255) not null,
    home_number             varchar(15) not null,
    apartment               varchar(15)
);