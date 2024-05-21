package com.mft.completeloginservice.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import jakarta.json.bind.annotation.JsonbProperty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "personEntity")
@Table(name = "person_tbl")
@NamedQueries({
        @NamedQuery(name = "Person.FindByNameAndFamily" ,query = "select oo from personEntity oo " +
                "where oo.name=:name and oo.family=:family and oo.deleted = false")
})

//@SoftDelete
public class Person extends Base{

    @Id
    @SequenceGenerator(name = "personSeq" , sequenceName = "person_seq" , initialValue = 1 , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "personSeq")
    private Long id;

    @Column(name = "p_name" , length = 30)
    @Pattern(regexp = "^[a-z]{2,20}$]" , message = "Invalid Name")
    @NotBlank(message = "Empty Name")
    @JsonbProperty("نام")
    private String name;

    @Column(name = "p_family" , length = 30)
    @Pattern(regexp = "^[a-z]{2,20}$]" , message = "Invalid ّّّFamily")
    @NotBlank(message = "Empty Family")
    @JsonbProperty("نام خانوادگی")
    private String family;

//    @Override
//    public String toString() {
//        return new Gson().toString();
//    }
}