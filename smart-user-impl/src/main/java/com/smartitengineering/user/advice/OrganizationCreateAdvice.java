/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartitengineering.user.advice;

import com.smartitengineering.user.domain.Organization;
import com.smartitengineering.user.domain.Privilege;
import com.smartitengineering.user.domain.SecuredObject;
import com.smartitengineering.user.domain.User;
import com.smartitengineering.user.service.OrganizationService;
import com.smartitengineering.user.service.PrivilegeService;
import com.smartitengineering.user.service.SecuredObjectService;
import com.smartitengineering.user.service.UserService;
import java.lang.reflect.Method;
import java.security.Provider.Service;
import java.util.HashSet;
import java.util.Set;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author modhu7
 */
public class OrganizationCreateAdvice implements AfterReturningAdvice {

  final static String ORGS_OID = "/orgs";
  final static String USERS_OID = "/users";
  final static String USERS_OID_NAME = "Users";
  final static String SECURED_OBJECTS_OID = "/securedObjects";
  final static String SECURED_OBJECTS_NAME = "Secured Objects";
  final static String PRIVILEGES_OID = "/privileges";
  final static String PRIVILEGES_OID_NAME = "Privileges";
  final static String ORG_UNIQUE_FRAG = "/shortName";
  final static String ADAM_ORG_SHORT_NAME = "smart-user";
  final static String ADMIN_USERNAME = "admin";
  final static String ADMIN_PASSWORD = "adminadmin";
  final static String URI_FRAG_CONTENT = "/content";
  final static String URI_FRAG_UPDATE = "/update";
  final static String URIFRAG_DELETE = "/delete";
  final static Integer PRIVILEGE_PERMISSION_MASK = 31;

  private UserService userService;
  private SecuredObjectService securedObjectService;
  private PrivilegeService privilegeService;
  private OrganizationService OrganizationService;


  @Override
  public void afterReturning(Object returnValue, Method method, Object[] parameters, Object instance) throws Throwable {
    if (parameters != null && parameters.length > 0 &&
        parameters[0] instanceof Organization && method.getName().contains(
        "delete")) {
      Organization organization = (Organization) parameters[0];
      String uniqueShortName = organization.getUniqueShortName();
      organization = OrganizationService.getOrganizationByUniqueShortName(uniqueShortName);

      User user = new User();
      user.setUsername(ADMIN_USERNAME);
      user.setPassword(ADMIN_PASSWORD);
      user.setOrganization(organization);
      userService.save(user);

      String orgUri = ORGS_OID + ORG_UNIQUE_FRAG + "/" + organization.getUniqueShortName();
      SecuredObject securedObjectOrganization = new SecuredObject();
      securedObjectOrganization.setName(organization.getName());
      securedObjectOrganization.setObjectID(orgUri);
      securedObjectOrganization.setOrganization(organization);
      securedObjectOrganization.setParentObjectID(ORGS_OID);
      securedObjectOrganization = securedObjectService.getByOrganizationAndObjectID(organization.getUniqueShortName(), securedObjectOrganization.
          getObjectID());

      SecuredObject securedObjectUsers = new SecuredObject();
      securedObjectUsers.setName(organization.getName() + USERS_OID_NAME);
      securedObjectUsers.setObjectID(orgUri + USERS_OID);
      securedObjectUsers.setOrganization(organization);
      securedObjectUsers.setParentObjectID(securedObjectOrganization.getObjectID());

      SecuredObject securedObjectSOs = new SecuredObject();
      securedObjectSOs.setName(organization.getName() + SECURED_OBJECTS_NAME);
      securedObjectSOs.setObjectID(orgUri + SECURED_OBJECTS_OID); //This objectId is actually the http url of secured objcets list of smart-user organizations
      securedObjectSOs.setOrganization(organization);
      securedObjectSOs.setParentObjectID(securedObjectOrganization.getObjectID());
      securedObjectService.save(securedObjectSOs);

      SecuredObject securedObjectPrivileges = new SecuredObject();
      securedObjectPrivileges.setName(organization.getName() + PRIVILEGES_OID_NAME);
      securedObjectPrivileges.setObjectID(orgUri + PRIVILEGES_OID); //This objectId is actually the http url of secured objcets list of smart-user organizations
      securedObjectPrivileges.setOrganization(organization);
      securedObjectPrivileges.setParentObjectID(securedObjectOrganization.getObjectID());
      securedObjectService.save(securedObjectPrivileges);

      Privilege privilege = new Privilege();
      privilege.setDisplayName("Smart User Adminstration");
      privilege.setName("smart-user-admin");
      privilege.setParentOrganization(organization);
      privilege.setPermissionMask(PRIVILEGE_PERMISSION_MASK); //permission mask 31 means all privileges are there 11111
      privilege.setSecuredObject(securedObjectOrganization);
      privilege.setShortDescription("This admin privilege contains the authority to do any of the CRUD options");
      privilegeService.create(privilege);
      privilege = privilegeService.getPrivilegeByOrganizationAndPrivilegeName(organization.getUniqueShortName(), privilege.
          getName());

      Set<Privilege> privileges = new HashSet();
      privileges.add(privilege);

      user = userService.getUserByOrganizationAndUserName(ADMIN_USERNAME, organization.getUniqueShortName());
      user.setPrivileges(privileges);
      userService.update(user);
    }
  }
}
