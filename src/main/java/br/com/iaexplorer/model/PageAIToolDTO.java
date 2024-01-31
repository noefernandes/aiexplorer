package br.com.iaexplorer.model;

import java.util.HashSet;

public record PageAIToolDTO(HashSet<AITool> aitools, int totalElements, int totalPages) {
}
