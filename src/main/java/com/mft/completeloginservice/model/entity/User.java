package com.mft.completeloginservice.model.entity;

import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter

@Entity(name = "userEntity")
@Table(name = "user_tbl")

@NamedQueries(
        {@NamedQuery(name = "User.FindByUserName" , query = "SELECT oo FROM userEntity oo where oo.userName =:userName and oo.deleted = false "),
                @NamedQuery(name = "User.FindByUserNameAndPassword" , query = "SELECT oo FROM userEntity oo where oo.userName =:userName AND oo.password =:password and oo.deleted = false"),
                @NamedQuery(name  ="User.FindEmailByUserName" , query = "SELECT oo.email FROM userEntity  oo WHERE oo.userName =:userName")
        })

@SessionScoped
public class User extends Base{
    @Id
    @SequenceGenerator(name = "userSeq" ,sequenceName ="user_seq" , initialValue = 1 , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "userSeq" )
    @Column(name = "id" )
    private Long Id;



    @Column(name = "u_userName" , length = 30 , unique = true)
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "Invalid UserName")
    private String userName;

    @Column(name = "u_password" , length = 30 )
//    @Size(min = 10, max = 30, message = "password must have 10 digits")
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "Invalid Password")
    // TODO: dose not take numbers in  password string
    private String password;

    @Column(name = "u_email" , length = 30 )
    @Email
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private Role role;
}
