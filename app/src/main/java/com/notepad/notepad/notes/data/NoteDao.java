package com.notepad.notepad.notes.data;

import android.content.Context;

import com.notepad.notepad.notes.Note;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class NoteDao {

    private Realm realm;

    public NoteDao(Context context){
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void close(){
        realm.close();
    }

    public Note getNoteById(int id){
        NoteRealm noteRealm = realm.where(NoteRealm.class).equalTo("id", id).findFirst();
        return new NoteMapper().fromRealm(noteRealm);
    }

    public void setNoteText(int id, String text){
        realm.where(NoteRealm.class).equalTo("id", id).findFirst().setNoteText(text);
    }

    public void insertNote(Note note) {
        realm.beginTransaction();

        NoteRealm noteRealm = realm.createObject(NoteRealm.class, generateId());
        noteRealm.setTitle(note.getTitle());
        noteRealm.setNoteText(note.getNoteText());

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

        RealmResults<NoteRealm> all = realm.where(NoteRealm.class).findAll().sort("id");

        for (NoteRealm noteRealm : all) {
            notes.add(mapper.fromRealm(noteRealm));
        }

        return notes;
    }

    public Note getNoteAtPosition(int position){
        return getAllNotes().get(position);
    }

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
        if(realm.where(NoteRealm.class).max("id")==null)
            return 0;

        return realm.where(NoteRealm.class).max("id").intValue() + 1;
    }
}
