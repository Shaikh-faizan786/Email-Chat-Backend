package com.emailchatapp.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;



    private boolean enabled = true; // Account active/inactive check

    @OneToMany(mappedBy = "receiver",cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private List<Message> receivedMessages;

}
