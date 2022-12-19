package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Fournisseur",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Fournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fournisseur_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "tel")
    private String tel;
    @Column(name = "password")
    private String  password;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "fournisseur")
    //@JsonBackReference
    List<AppelOffre> appelOffre;
}
