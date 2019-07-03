package com.services.db

databaseChangeLog {

    changeSet(id: '2019-07-03-00', author: 'skorillia@gmail.com') {
        comment("creates schema for services tables")
        sql('create schema srv')
    }

    changeSet(id: '2019-07-03-01', author: 'skorillia@gmail.com') {
        comment("creates news data table")
        createTable(tableName: 'news', schemaName : 'srv') {
            column(name: 'id', type: 'int')
            column(name: 'title', type: 'text')
            column(name: 'post', type: 'text')
        }
        addPrimaryKey(columnNames: 'id', constraintName: 'news_pk', tableName: 'news', schemaName: 'srv')
        rollback {
            dropTable(schemaName: 'srv', tableName: 'news')
        }
    }
}