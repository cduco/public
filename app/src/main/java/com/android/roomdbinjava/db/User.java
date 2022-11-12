package com.android.roomdbinjava.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "item_name")
    public String itemName;

    @ColumnInfo(name = "amount")
    public int amount;

}
