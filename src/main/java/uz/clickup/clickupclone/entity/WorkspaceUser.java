package uz.clickup.clickupclone.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

public class WorkspaceUser {
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    private WorkSpace workSpace;
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    private AuthUser user;
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    private WorkSpaceRole workSpaceRole;
    @Column(nullable = false)
    private Timestamp dateInvited;
    private Timestamp dataJoined;


}
