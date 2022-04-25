package io.getarrays.userservice.service;

import io.getarrays.userservice.domain.Appuser;
import io.getarrays.userservice.domain.Role;

import java.util.List;

public interface UserService {
    Appuser saveAppuser(Appuser appUser);
    Role saveRole(Role role);
//    Appuserrole saveAppuserrole(Appuserrole appuserrole);
    void addRoleToUser(String username, String roleName);
    Appuser getAppuser(String username);
    List<Appuser> getAppusers();
}
