/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartitengineering.user.domain;

import com.smartitengineering.domain.AbstractPersistentDTO;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author modhu7
 */
public class User extends AbstractPersistentDTO<User> {

    //private Organization parentOrganization;

    private String username;
    private String password;
    private Organization organization;
    private Set<Role> roles;
    private Set<Privilege> privileges;
    
    private List<Integer> roleIDs;
    private List<Integer> privilegeIDs;
    private Integer parentOrganizationID;

    private Date lastModifiedDate;

    

    @JsonIgnore
    public Integer getParentOrganizationID() {
        return parentOrganizationID;
    }

    public void setParentOrganizationID(Integer parentOrganizationID) {
        this.parentOrganizationID = parentOrganizationID;
    }

    public String getPassword() {
        if (password == null) {
            password = "";
        }
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            return;
        }
        this.password = password;
    }

    public Organization getOrganization() {
        if(organization==null){
            organization = new Organization("", "");
        }
        return organization;
    }

    public void setOrganization(Organization organization) {
        if(organization==null)
            return;
        this.organization = organization;
    }

    @JsonIgnore
    public Set<Privilege> getPrivileges() {
        if(privileges==null){
            privileges = new HashSet<Privilege>();
        }
        return privileges;
    }

    @JsonIgnore
    public void setPrivileges(Set<Privilege> privileges) {
        if(privileges==null){
            return;
        }
        this.privileges = privileges;
    }

    @JsonIgnore
    public Set<Role> getRoles() {
        if (roles == null) {
            roles = new HashSet<Role>();
        }
        return roles;
    }

    @JsonIgnore
    public void setRoles(Set<Role> roles) {
        if (roles == null) {
            return;
        }
        this.roles = roles;
    }

    public String getUsername() {
        if (username == null) {
            username = "";
        }
        return username;
    }

    public void setUsername(String username) {
        if (username == null) {
            return;
        }
        this.username = username;
    }

    @JsonIgnore
    public List<Integer> getPrivilegeIDs() {
        return privilegeIDs;
    }

    public void setPrivilegeIDs(List<Integer> privilegeIDs) {
        this.privilegeIDs = privilegeIDs;
    }

    @JsonIgnore
    public List<Integer> getRoleIDs() {
        return roleIDs;
    }

    public void setRoleIDs(List<Integer> roleIDs) {
        this.roleIDs = roleIDs;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean isValid() {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }
}
