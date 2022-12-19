package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Commande",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ref")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_id")
    private Long id;
    @Column(nullable = false,unique = true)
    private String ref;
    @Column(nullable = false)
    private LocalDate date;
    private Double prixTotal;
    // collum for the enum status
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusCmd status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    //@JsonManagedReference
    private Client client;

    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL)
    //@JsonBackReference
    private List<CommandeItem> commandeItems;

}