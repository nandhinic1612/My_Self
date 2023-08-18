package com.Demo.Enum.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "Error_Table")
@Data
@Entity
public class ErrorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

   // @Enumerated(EnumType.ORDINAL)
    @Enumerated(EnumType.STRING)
    private ErrorType errorType;

}
