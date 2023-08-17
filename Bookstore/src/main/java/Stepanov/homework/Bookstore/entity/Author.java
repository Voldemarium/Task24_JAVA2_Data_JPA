package Stepanov.homework.Bookstore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String surname;

    @Column
    private String name;

    @Column
    private String middle_name;

}