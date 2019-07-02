package com.services.db

databaseChangeLog {

    changeSet(id: '2019-07-02-00', author: 'Illia Skoryi <skorillia@gmail.com>') {
        comment("test table")
        sql{
            'create table asdf'
        }
    }
}