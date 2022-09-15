package com.example.autsoftjavainterview.services;

import com.example.autsoftjavainterview.dao.EntryRepo;
import com.example.autsoftjavainterview.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    private static EntryRepo entryRepo;

    @Autowired
    public EntryService(EntryRepo entryRepo) {
        EntryService.entryRepo = entryRepo;
    }

    public static void saveEntry(Entry entry) {
        entryRepo.save(entry);
    }

    /*public static void updateEntry(Entry entry) {
        entryRepo.save(entry);
    }*/

    public static void deleteEntry(Entry entry) {
        entryRepo.delete(entry);
    }

    public static List<Entry> getAll() {
        return entryRepo.findAll();
    }

    public static Entry getByTitle(String title) {
        List<Entry> entries = getAll();

        for (Entry entry : entries) {
            if (entry.getTitle().equals(title))
                return entry;
        }

        return null;
    }

    public static Entry getById(Long id) {
        List<Entry> entries = getAll();

        for (Entry entry : entries) {
            if (entry.getId() == id)
                return entry;
        }

        return null;
    }
}
