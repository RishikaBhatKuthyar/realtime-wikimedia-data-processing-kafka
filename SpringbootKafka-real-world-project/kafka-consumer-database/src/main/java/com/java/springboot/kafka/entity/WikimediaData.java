package com.java.springboot.kafka.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="wikimedia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Lob is used in JPA to store large objects like text (CLOB) or binary data (BLOB) in the database.
    @Lob
    private String wikiEventData;
}
