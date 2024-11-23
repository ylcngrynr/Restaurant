package com.restaurant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rtable extends BaseEntity {
   private String tableName;
   private String tableQr;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableQr() {
        return tableQr;
    }

    public void setTableQr(String tableQr) {
        this.tableQr = tableQr;
    }
}
