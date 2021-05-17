drop table if exists device;

create table device (
    serial bigint not null,
    typeOfProducer varchar(255) not null,
    typeOfDevice varchar(255) not null,
    lastResponse timestamp,
    volumeMeasures bigint not null,
)