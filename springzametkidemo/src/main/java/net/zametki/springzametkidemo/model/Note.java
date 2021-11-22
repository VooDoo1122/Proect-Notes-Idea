package net.zametki.springzametkidemo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="UserNote")
    private String UserNote;
    @Column(name="TextNote")
    private String TextNote;


}
