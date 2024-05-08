package ru.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "worker")
public class Worker {


    @Id
    private Long id;// по факту это номер пропуска, который не может повторяться, в организации менее 300 человек, поэтому тип int будет более, чем достаточен(штат точно не будет выше 30к, даже за 30 лет + есть дочерние организации, у которых будет выдача своих пропусков, со своей нумерацией, и со своей базой данных

    @Column(name = "name")
    private String name;
    @Column(name = "namePC")
    private String namePC;
    @Column(name = "nameSubdivision")
    private String nameSubdivision;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

}
