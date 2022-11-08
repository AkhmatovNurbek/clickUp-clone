package uz.clickup.clickupclone.entity.enums;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public enum WorkspacePermissionName {
    ADD_REMOVE_MEMBER("Add/Remove members", "Gives user permission to add or remove members", Arrays.asList(WorkspaceRoleName.ROLE_OWNER , WorkspaceRoleName.ROLE_ADMIN)),
    EDIT_WORKSPACE("Edit workspace", "Gives user permission to add or remove members", Arrays.asList(WorkspaceRoleName.ROLE_OWNER , WorkspaceRoleName.ROLE_ADMIN)),
    ADD_GUEST("Invite guest", "Gives user permission to add or remove members", Arrays.asList(WorkspaceRoleName.ROLE_OWNER , WorkspaceRoleName.ROLE_ADMIN));


    public String name;
    public String description;
    public List<WorkspaceRoleName> workspaceRoleNames;

    WorkspacePermissionName(String name, String description, List<WorkspaceRoleName> workspaceRoleNames) {
        this.name = name;
        this.description = description;
        this.workspaceRoleNames=workspaceRoleNames;
    }
}
