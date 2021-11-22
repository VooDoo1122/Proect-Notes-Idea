package net.zametki.springzametkidemo.controller;

import net.zametki.springzametkidemo.model.Note;
import net.zametki.springzametkidemo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public String findAll(Model model){
        List<Note> notes = noteService.findAll();
        model.addAttribute("notes",notes);
        return "note-list";
    }

    @GetMapping("/note-create")
    public String createNoteForm(Note note){
    return "note-create";
    }

    @PostMapping("/note-create")
    public  String createNote(Note note){
        noteService.saveNote(note);
        return "redirect:/notes";
    }
    @GetMapping("note-delete/{id}")
    public String deleteNote(@PathVariable("id") Long id){
        noteService.deleteById(id);
        return "redirect:/notes";
    }
}
