package com.mft.completeloginservice.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.json.bind.annotation.JsonbProperty;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name = "roleEntity")
@Table(name = "role_tbl")
public class Role extends Base{

    @Id
    @SequenceGenerator(name = "roleSeq", sequenceName = "role_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSeq")
    private Long id;


    @Column(name = "role_name", length = 20)
    @NotBlank(message = "Empty Role")
    @Pattern(regexp = "^[a-z]{2,20}$]", message = "Invalid Role")
    @JsonbProperty("نام نقش")
    private String role;

}
