drop table if exists cities;
drop table if exists countries;

create table countries
(
    id   int          not null,
    name varchar(255) not null
);

alter table countries
    add constraint pk_countries primary key (id);

create table cities
(
    id         int          not null,
    name       varchar(255) not null,
    country_id int          not null
);

alter table cities
    add constraint pk_cities primary key (id);

alter table cities
    add constraint fk_cities_country_id foreign key (country_id) references countries (id);

insert into countries (id, name)
values (1, 'Russia');
insert into countries (id, name)
values (2, 'France');
insert into countries (id, name)
values (3, 'Uzbekistan');

insert into cities (id, name, country_id)
values (1, 'Moscow', 1);
insert into cities (id, name, country_id)
values (2, 'Saint-Petersburg', 1);
insert into cities (id, name, country_id)
values (3, 'Kazan', 1);

insert into cities (id, name, country_id)
values (4, 'Paris', 2);
insert into cities (id, name, country_id)
values (5, 'Marcel', 2);
insert into cities (id, name, country_id)
values (6, 'Nice', 2);

insert into cities (id, name, country_id)
values (7, 'Tashkent', 3);
insert into cities (id, name, country_id)
values (8, 'Samarkand', 3);
insert into cities (id, name, country_id)
values (9, 'Bukhara', 3);

drop table if exists books_authors;
drop table if exists books;
drop table if exists authors;

create table books
(
    id   int          not null,
    name varchar(255) not null
);

alter table books
    add constraint pk_books primary key (id);

create table authors
(
    id   int          not null,
    name varchar(255) not null
);

alter table authors
    add constraint pk_authors primary key (id);

create table books_authors
(
    book_id   int not null,
    author_id int not null
);

alter table books_authors
    add constraint pk_books_authors primary key (book_id, author_id);

alter table books_authors
    add constraint fk_books_authors_book_id foreign key (book_id) references books (id);

alter table books_authors
    add constraint fk_books_authors_author_id foreign key (author_id) references authors (id);

insert into books (id, name)
values (1, 'Code Complete'),
       (2, 'Clean Code'),
       (3, 'GoF Patterns'),
       (4, '12 стульев'),
       (5, 'Clean Architecture');

insert into authors (id, name)
values (1, 'Steve McConnell'),
       (2, 'Robert Martin'),
       (3, 'Erich Gamma'),
       (4, 'Richard Helm'),
       (5, 'Ralph Johnson'),
       (6, 'Grady Booch'),
       (7, 'Илья Ильф'),
       (8, 'Евгений Петров');

insert into books_authors (book_id, author_id)
values (1, 1),
       (2, 2),
       (5, 2),
       (3, 3),
       (3, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (4, 8);