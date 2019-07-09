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

    changeSet(id: '2019-07-09-00', author: 'skorillia@gmail.com') {
        comment("creates users data table")
        createTable(tableName: 'users', schemaName : 'srv') {
            column(name: 'id', type: 'int')
            column(name: 'email', type: 'varchar(20)')
            column(name: 'password', type: 'varchar(24)')
            column(name: 'name', type: 'varchar(20)')
            column(name: 'profile_image', type: 'varchar(40)')
        }
        addPrimaryKey(columnNames: 'id, email', constraintName: 'users_pk', tableName: 'users', schemaName: 'srv')
        addNotNullConstraint(tableName: 'users', columnName: 'email', columnDataType: 'varchar(20)', schemaName: 'srv')
        addNotNullConstraint(tableName: 'users', columnName: 'password', columnDataType: 'varchar(24)', schemaName: 'srv')
        addNotNullConstraint(tableName: 'users', columnName: 'name', columnDataType: 'varchar(20)', schemaName: 'srv')
        rollback {
            dropTable(schemaName: 'srv', tableName: 'users')
        }
    }
}