package com.example.autsoftjavainterview.controllers;

import com.example.autsoftjavainterview.model.Entry;
import com.example.autsoftjavainterview.services.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntryController {

    @GetMapping("/entries")
    public ResponseEntity<List<Entry>> getAll() {
        List<Entry> entries = EntryService.getAll();

        if (entries.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok(entries);
    }

    @GetMapping("/entry/{title}")
    public ResponseEntity<Entry> getByTitle(@PathVariable String title) {
        Entry entry = EntryService.getByTitle(title);

        if (entry == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok(entry);
    }

    @GetMapping("/entry/{id}")
    public ResponseEntity<Entry> getById(@PathVariable Long id) {
        Entry entry = EntryService.getById(id);

        if (entry == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok(entry);
    }

    @PostMapping("/entry")
    public ResponseEntity<Entry> newEntry(@RequestBody Entry entry) {
        try {
            EntryService.saveEntry(entry);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/entry/{title}")
    public ResponseEntity<Entry> deleteByTitle(@PathVariable String title) {
        Entry entry = EntryService.getByTitle(title);

        if (entry == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        EntryService.deleteEntry(entry);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
