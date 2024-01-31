package br.com.iaexplorer.controller;

import br.com.iaexplorer.model.AITool;
import br.com.iaexplorer.service.AIToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Rever cross origin
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AIToolController {
    private final AIToolService aiToolService;

    @PostMapping("/aitool")
    public ResponseEntity<AITool> save(@RequestBody AITool aiTool) {
        return new ResponseEntity<>(aiToolService.save(aiTool), HttpStatus.OK);
    }

    @PutMapping("/aitool")
    public ResponseEntity<AITool> update(@RequestBody AITool aiTool) {
        return new ResponseEntity<>(aiToolService.update(aiTool), HttpStatus.OK);
    }

    /*@PutMapping("/aitool-picture")
    public ResponseEntity<AITool> updatePhoto(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "picture", required = false) MultipartFile picture) throws Exception {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(picture.getOriginalFilename()));
        AITool aiTool = aiToolService.findById(id);
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence " + fileName);
            }
            if (picture.getBytes().length > (1024 * 1024)) {
                throw new Exception("File size exceeds maximum limit");
            }
            aiTool.setProfilePicture(picture.getBytes());
        } catch (MaxUploadSizeExceededException e) {
            throw new MaxUploadSizeExceededException(picture.getSize());
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
        return new ResponseEntity<>(aiToolService.update(aiTool), HttpStatus.OK);
    }*/

    @PostMapping("/aitool/save-all")
    public ResponseEntity<AITool> saveAll(@RequestBody List<AITool> aiTools) {
        aiToolService.saveAll(aiTools);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/aitool")
    public ResponseEntity<?> delete(@RequestBody AITool aiTool) {
        aiToolService.delete(aiTool);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/aitool")
    public ResponseEntity<Page<AITool>> findByPageNumber(
        @RequestParam(
            value = "page",
            required = false,
            defaultValue = "0") int pageNumber,
        @RequestParam(
            value = "size",
            required = false,
            defaultValue = "6") int pageSize) {
        return new ResponseEntity<>(
                aiToolService.findByPageNumber(pageNumber, pageSize),
                HttpStatus.OK);
    }

    @GetMapping("/aitool/all")
    public ResponseEntity<List<AITool>> findAll() {
        return new ResponseEntity<>(aiToolService.findAll(), HttpStatus.OK);
    }
}
