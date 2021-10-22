package com.example.a2parcial_ft18i04001.dataFT;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.a2parcial_ft18i04001.daoFT.ContactoFTDAO;
import com.example.a2parcial_ft18i04001.modelFT.ContactoFT;



@Database(entities = {ContactoFT.class}, version = 1)
public  abstract  class DataBaseRoomFT extends RoomDatabase {
    public abstract ContactoFTDAO contactoFTDAO ();
}
