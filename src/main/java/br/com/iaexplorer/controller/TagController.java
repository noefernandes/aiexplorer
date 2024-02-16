package br.com.iaexplorer.controller;

import br.com.iaexplorer.model.Tag;
import br.com.iaexplorer.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TagController {
    private final TagService tagService;

    @PostMapping("/tag")
    public ResponseEntity<Tag> save(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.save(tag));
    }

    @GetMapping("/tags")
    public ResponseEntity<List<Tag>> findAll() {
        return ResponseEntity.ok(tagService.findAll());
    }
}
