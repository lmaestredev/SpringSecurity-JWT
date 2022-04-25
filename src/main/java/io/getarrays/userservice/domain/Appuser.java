package io.getarrays.userservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appuser {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
//    @OneToMany(mappedBy="appuser", fetch = EAGER)
//    private Collection<Appuserrole> appuserroles = new ArrayList<>();

//    public Appuser() {
//    }
//
//    public Appuser(String name, String username, String password) {
//        this.name = name;
//        this.username = username;
//        this.password = password;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public Collection<Role> getRoles() {
//        return roles;
//    }
//    @JsonIgnore
//    public List<String> getRoles(){
//        return appuserroles.stream().map(sub -> sub.getRole().getName()).collect(Collectors.toList());
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles;
//    }
//    public void addAppuserrole(Appuserrole appuserrole) {
//        appuserrole.setAppuser(this);
//        appuserroles.add(appuserrole);
//    }

}
