package br.com.iaexplorer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AITool {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String shortDescription;

    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "aiTool", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Tag> tags;

    @Lob
    private byte[] profilePicture;

    private String siteUrl;

    private String instagramUrl;

    private String discordUrl;

    private String linkedinUrl;

    private String githubUrl;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone = "GMT-3")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone = "GMT-3")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
}
