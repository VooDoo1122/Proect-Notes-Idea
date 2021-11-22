package net.zametki.springzametkidemo.service;

import net.zametki.springzametkidemo.model.Note;
import net.zametki.springzametkidemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note findById(Long id){
        return noteRepository.findById(id).orElse(null);
    }
    public List<Note> findAll(){
        return noteRepository.findAll();
    }
    public  Note saveNote(Note note){
        return noteRepository.save(note);
    }
    public void deleteById(Long id){
        noteRepository.deleteById(id);
    }
}
