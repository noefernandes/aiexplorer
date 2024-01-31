package br.com.iaexplorer.service;

import br.com.iaexplorer.model.AITool;
import br.com.iaexplorer.repository.AIToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AIToolService {
    private final AIToolRepository aiToolRepository;

    public AITool save(AITool aiTool) {
        if(aiTool.getCreatedAt() == null) {
            aiTool.setCreatedAt(new Date());
        }

        aiTool.setUpdatedAt(new Date());

        return aiToolRepository.save(aiTool);
    }

    public void saveAll(Collection<AITool> aiTools) {
        aiToolRepository.saveAll(aiTools);
    }

    public void delete(AITool aiTool) {
        Optional<AITool> found = aiToolRepository.findById(aiTool.getId());
        found.ifPresent(aiToolRepository::delete);
    }

    public AITool findById(Long id) {
        return aiToolRepository.findById(id).orElse(null);
    }

    public AITool update(AITool aiTool) {
        //AITool ait = aiToolRepository.findById(aiTool.getId()).orElseThrow(() -> new RuntimeException("Resource not found"));
        aiTool.setUpdatedAt(new Date());
        return aiToolRepository.save(aiTool);
    }

    public Page<AITool> findByPageNumber(int pageNumber, int pageSize) {
        return aiToolRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name"));
    }

    public List<AITool> findAll() {
        return aiToolRepository.findAll();
    }
}
