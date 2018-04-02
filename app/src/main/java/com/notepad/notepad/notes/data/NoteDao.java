package com.notepad.notepad.notes.data;

import android.content.Context;

import com.notepad.notepad.notes.Note;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class NoteDao {

    private Realm realm;
    private RealmConfiguration realmConfig;

    public NoteDao(Context context){
        Realm.init(context);
        realmConfig = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(realmConfig);
    }

    public void close(){
        realm.close();
    }

//    public void insertNote(Note note){
//        realm.beginTransaction();
//
//        NoteRealm noteRealm = realm.createObject(NoteRealm.class, note);
//        noteRealm.setId(generateId());
//        noteRealm.setTitle(note.getTitle());
//
//        realm.commitTransaction();
//    }

    public Note getNoteById(int id){
        NoteRealm noteRealm = realm.where(NoteRealm.class).equalTo("id", id).findFirst();
        return new NoteMapper().fromRealm(noteRealm);
    }

    public void insertNote(Note note) {
        // operacje zapisu muszą odbywać się w transakcji
        realm.beginTransaction();

        // tworzymy nowy obiekt przy pomocy metody createObject()
        NoteRealm noteRealm = realm.createObject(NoteRealm.class);
        noteRealm.setId(generateId());
        noteRealm.setTitle(note.getTitle());

        // commitTransaction() zapisuje stan obiektów realmowych do bazy danych
        // jeśli więc stworzyliśmy nowy lub usunęliśmy stary, to w tym momencie
        // te operacje zostaną odwzorowane w bazie
        realm.commitTransaction();
    }

    public void deleteNoteById(final long id) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(NoteRealm.class).equalTo("id", id).findFirst().deleteFromRealm();
            }
        });
    }

    // pobranie wszystkich notatek
    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        NoteMapper mapper = new NoteMapper();

        RealmResults<NoteRealm> all = realm.where(NoteRealm.class).findAll();

        for (NoteRealm noteRealm : all) {
            notes.add(mapper.fromRealm(noteRealm));
        }

        return notes;
    }

    // pobranie wszystkich notatek, które zawierają w treści dany tekst
    public List<Note> getNotesLike(String text) {
        List<Note> notes = new ArrayList<>();
        NoteMapper mapper = new NoteMapper();

        RealmResults<NoteRealm> all = realm.where(NoteRealm.class)
                .contains("noteText", text)
                .findAll();

        for (NoteRealm noteRealm : all) {
            notes.add(mapper.fromRealm(noteRealm));
        }

        return notes;
    }

    public List<NoteRealm> getRawNotes(){
        return realm.where(NoteRealm.class).findAll();
    }

    // usunięcie wszystkich notatek
    public void deleteAllNotes() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(NoteRealm.class)
                        .findAll()
                        .deleteAllFromRealm();
            }
        });
    }

    private int generateId() {
        return realm.where(NoteRealm.class).max("id").intValue() + 1;
    }
}
