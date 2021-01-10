create table m_additionally
(
    id bigserial not null
        constraint m_additionally_pk
            primary key,
    additionally varchar(50) default 'ADDITIONALLY'::character varying not null
);

alter table m_additionally owner to postgres;

create unique index m_additionally_id_uindex
    on m_additionally (id);

create table m_address
(
    id bigserial not null
        constraint m_address_pk
            primary key,
    country varchar(200) not null,
    city varchar(200) not null,
    location varchar(200) not null
);

alter table m_address owner to postgres;

create index m_address_country_city_index
    on m_address (country, city);

create index m_address_country_index
    on m_address (country);

create table m_role
(
    id bigserial not null
        constraint m_role_pk
            primary key,
    role_name varchar(100) not null
);

alter table m_role owner to postgres;

create table m_user
(
    id bigserial not null
        constraint m_user_pk
            primary key,
    name varchar(200) not null,
    surname varchar(200) not null,
    e_mail varchar(200),
    birth_date date,
    created timestamp default CURRENT_TIMESTAMP not null,
    changed timestamp default CURRENT_TIMESTAMP not null,
    login varchar(50) default 'login'::character varying not null,
    password varchar(200) default 'password'::character varying not null,
    gender varchar(10) default 'NOT_SELECTED'::character varying,
    role_id bigint not null
        constraint m_user_m_role_id_fk
            references m_role
);

alter table m_user owner to postgres;

create unique index m_user_id_uindex
    on m_user (id);

create index m_user_name_index
    on m_user (name);

create unique index m_user_login_uindex
    on m_user (login);

create table m_landlord
(
    id bigserial not null
        constraint m_landlord_pk
            primary key,
    name varchar(200) not null,
    surname varchar(200) not null,
    phone varchar(45) not null,
    e_mail varchar(200),
    created timestamp default CURRENT_TIMESTAMP not null,
    changed timestamp default CURRENT_TIMESTAMP not null,
    login varchar(50) default 'login'::character varying not null,
    password varchar(100) default 'password'::character varying not null,
    role_id bigint not null
        constraint m_landlord_m_role_id_fk
            references m_role
);

alter table m_landlord owner to postgres;

create unique index m_landlord_id_uindex
    on m_landlord (id);

create unique index m_landlord_login_uindex
    on m_landlord (login);

create index m_landlord_name_index
    on m_landlord (name);

create table m_apart
(
    id bigserial not null
        constraint m_apart_pk
            primary key,
    type varchar(50) not null,
    apart_name varchar(100) not null,
    address_id bigint not null
        constraint m_apart_m_address_id_fk
            references m_address
            on update cascade on delete cascade,
    guest_number bigint not null,
    area double precision not null,
    cost_per_day double precision not null,
    landlord_id bigint not null
        constraint m_apart_m_landlord_id_fk
            references m_landlord
            on delete set null,
    status varchar(100) default 'BOOKED'::character varying not null,
    created timestamp not null,
    changed timestamp not null
);

alter table m_apart owner to postgres;

create unique index m_apart_id_uindex
    on m_apart (id);

create index m_apart_type_index
    on m_apart (type);

create index m_apart_city_index
    on m_apart (address_id);

create index m_apart_guest_number_index
    on m_apart (guest_number);

create index m_apart_cost_per_day_index
    on m_apart (cost_per_day);

create unique index m_apart_id_uindex_2
    on m_apart (id);

create table m_booking
(
    id bigserial not null
        constraint m_booking_pk
            primary key,
    apart_id bigint not null
        constraint m_booking_m_apart_id_fk
            references m_apart,
    user_id bigint not null
        constraint m_booking_m_user_id_fk
            references m_user
            on delete cascade,
    date_from date not null,
    date_to date not null,
    price double precision not null,
    created timestamp not null,
    changed timestamp not null
);

alter table m_booking owner to postgres;

create unique index m_booking_id_uindex
    on m_booking (id);

create unique index m_role_id_uindex
    on m_role (id);

create unique index m_role_role_name_uindex
    on m_role (role_name);

create table l_apart_additionally
(
    id bigserial not null
        constraint l_apart_additionally_pk
            primary key,
    apart_id bigint not null
        constraint l_apart_additionally_m_apart_id_fk
            references m_apart,
    additionally_id bigint not null
        constraint l_apart_additionally_m_additionally_id_fk
            references m_additionally
);

alter table l_apart_additionally owner to postgres;

create unique index l_apart_additionally_id_uindex
    on l_apart_additionally (id);

