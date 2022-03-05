package com.esgi.trademe.use_cases.profile.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Certificats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {
    @Id
    private String id;
    private String name;
}
