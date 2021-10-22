package com.example.a2parcial_ft18i04001.daoFT;

import android.content.Context;

import androidx.room.Room;

import com.example.a2parcial_ft18i04001.dataFT.DataBaseRoomFT;
import com.example.a2parcial_ft18i04001.modelFT.ContactoFT;

import java.util.List;

public class ContactoFTDAOImpRoom implements  ContactoFTDAO {

    DataBaseRoomFT db;

    ContactoFTDAO dao;

    public ContactoFTDAOImpRoom(Context context){
        db= Room.databaseBuilder(context,DataBaseRoomFT.class,"db")
                .allowMainThreadQueries().build();
        dao=db.contactoFTDAO();
    }

    @Override
    public List<ContactoFT> getAll() {
        return dao.getAll();
    }

    @Override
    public ContactoFT get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(ContactoFT entity) {
        dao.save(entity);
    }

    @Override
    public void delete(ContactoFT entity) {
        dao.delete(entity);
    }

    @Override
    public void update(ContactoFT entity) {
        dao.update(entity);
    }

}
