package uz.pdp.datarestpcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private  Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private  String phoneNumber;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private Integer password;

    @Column(nullable = false)
    private boolean active;
}
