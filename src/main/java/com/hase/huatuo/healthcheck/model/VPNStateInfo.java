package com.hase.huatuo.healthcheck.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "vpn_info")
public class VPNStateInfo {
    @Column(name = "open_id")
    private String openId;
    @Id
    @Column(name = "staff_id", nullable = false)
    private String staffId;
    @Column(name = "location")
    private String location;
    @Column(name = "isp")
    private String isp;
    @Column(name = "link_Type")
    private String linkType;
    @Column(name = "band_width")
    private String bandWidth;
    @Column(name = "vpn_type")
    private String vpnType;
    @Column(name = "had_reboot_adsl")
    private String hadRebootADSL;
    @Column(name = "symptom")
    private String symptom;
    @Column(name = "outlook_slow")
    private String outlookSlow;
    @Column(name = "jabber_slow")
    private String jabberSlow;
    @Column(name = "sametime_slow")
    private String sametimeSlow;
    @Column(name = "video_conference_slow")
    private String videoConferenceSlow;
    @Column(name = "sharepoint_shared_folder_slow")
    private String sharepointSharedFolderSlow;
    @Column(name = "has_other_applications_slow")
    private String hasOtherApplicationsSlow;
    @Column(name = "other_slow_applications")
    private String otherSlowApplications;
    @Column(name = "has_some_applications_cannot_access")
    private String hasSomeApplicationsCannotAccess;
    @Column(name = "cannot_access_applications")
    private String cannotAccessApplications;
    @Column(name = "reporter_staff_id")
    private String reporterStaffId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
