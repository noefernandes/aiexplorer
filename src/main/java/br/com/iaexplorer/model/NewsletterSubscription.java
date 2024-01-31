package br.com.iaexplorer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NewsletterSubscription {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private boolean active;
}
