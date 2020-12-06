create table m_user
(
    id         bigserial                                          not null
        constraint m_user_pk
            primary key,
    name       varchar(200)                                       not null,
    surname    varchar(200)                                       not null,
    e_mail     varchar(200),
    birth_date date,
    created    timestamp    default CURRENT_TIMESTAMP             not null,
    changed    timestamp    default CURRENT_TIMESTAMP             not null,
    login      varchar(50)  default 'login'::character varying    not null,
    password   varchar(200) default 'password'::character varying not null,
    gender     varchar(10)  default 'NOT_SELECTED'::character varying
);

alter table m_user
    owner to postgres;

create unique index m_user_id_uindex
    on m_user (id);

create index m_user_name_index
    on m_user (name);

create unique index m_user_login_uindex
    on m_user (login);

create table m_landlord
(
    id       bigserial                                          not null
        constraint m_landlord_pk
            primary key,
    name     varchar(100)                                       not null,
    surname  varchar(100)                                       not null,
    phone    varchar(45)                                        not null,
    e_mail   varchar(100)                                       not null,
    created  timestamp    default CURRENT_TIMESTAMP             not null,
    changed  timestamp    default CURRENT_TIMESTAMP             not null,
    login    varchar(50)  default 'login'::character varying    not null,
    password varchar(100) default 'password'::character varying not null
);

alter table m_landlord
    owner to postgres;

create unique index m_landlord_id_uindex
    on m_landlord (id);

create unique index m_landlord_login_uindex
    on m_landlord (login);

create index m_landlord_name_index
    on m_landlord (name);

create table m_country
(
    id      bigserial    not null
        constraint m_country_pk
            primary key,
    country varchar(200) not null
);

alter table m_country
    owner to postgres;

create unique index m_country_id_uindex
    on m_country (id);

create table m_city
(
    id         bigserial    not null
        constraint m_city_pk
            primary key,
    city       varchar(200) not null,
    country_id bigint       not null
        constraint m_city_m_country_id_fk
            references m_country
);

alter table m_city
    owner to postgres;

create table m_apart
(
    id           bigserial        not null
        constraint m_apart_pk
            primary key,
    type         varchar(50)      not null,
    apart_name   varchar(100)     not null,
    city_id      bigint           not null
        constraint m_apart_m_city_id_fk
            references m_city,
    address      varchar(100)     not null,
    guest_number bigint           not null,
    area         double precision not null,
    cost_per_day double precision not null,
    landlord_id  bigint           not null
        constraint m_apart_m_landlord_id_fk
            references m_landlord,
    status       varchar(50)      not null,
    created      timestamp        not null,
    changed      timestamp        not null
);

alter table m_apart
    owner to postgres;

create unique index m_apart_id_uindex
    on m_apart (id);

create index m_apart_type_index
    on m_apart (type);

create unique index m_apart_address_uindex
    on m_apart (address);

create index m_apart_city_index
    on m_apart (city_id);

create index m_apart_guest_number_index
    on m_apart (guest_number);

create index m_apart_cost_per_day_index
    on m_apart (cost_per_day);

create table m_additionally
(
    id           bigserial                                             not null
        constraint m_additionally_pk
            primary key,
    additionally varchar(50) default 'ADDITIONALLY'::character varying not null,
    apart_id     integer                                               not null
        constraint m_additionally_m_apart_id_fk
            references m_apart
);

alter table m_additionally
    owner to postgres;

create unique index m_additionally_id_uindex
    on m_additionally (id);

create table m_booking
(
    id                bigserial        not null
        constraint m_booking_pk
            primary key,
    apart_id          bigint           not null
        constraint m_booking_m_apart_id_fk
            references m_apart,
    user_id           bigint           not null
        constraint m_booking_m_user_id_fk
            references m_user,
    number_of_persons integer          not null,
    check_in          date             not null,
    check_out         date             not null,
    price             double precision not null,
    created           timestamp        not null,
    changed           timestamp        not null
);

alter table m_booking
    owner to postgres;

create unique index m_booking_id_uindex
    on m_booking (id);

create unique index m_city_id_uindex
    on m_city (id);

