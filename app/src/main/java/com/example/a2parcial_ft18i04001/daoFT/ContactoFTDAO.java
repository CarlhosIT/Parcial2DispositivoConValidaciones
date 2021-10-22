package com.example.a2parcial_ft18i04001.daoFT;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.a2parcial_ft18i04001.modelFT.ContactoFT;

import java.util.List;
@Dao
public interface ContactoFTDAO {
    @Query("select * from contactos")
    public List<ContactoFT> getAll();

    @Query("select * from contactos where id = :id")
    public ContactoFT get(int id);

    @Insert
    public void save(ContactoFT entity);

    @Delete
    public void delete(ContactoFT entity);

    @Update
    public void update(ContactoFT entity);

}
