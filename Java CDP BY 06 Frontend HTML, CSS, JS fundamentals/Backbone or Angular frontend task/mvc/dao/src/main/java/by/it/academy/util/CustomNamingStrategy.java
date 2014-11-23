package by.it.academy.util;

import org.hibernate.cfg.DefaultNamingStrategy;

public class CustomNamingStrategy extends DefaultNamingStrategy {
    public String classToTableName(String className) {
        return  super.classToTableName(className);
    }

    public String propertyToColumnName(String propName) {
        return super.propertyToColumnName(propName);
    }

    public String columnName(String columnName) {
        return columnName;
    }

    public String tableName(String tableName) {
        return tableName;
    }
}


