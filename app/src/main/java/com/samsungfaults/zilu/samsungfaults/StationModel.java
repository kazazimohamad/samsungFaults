package com.samsungfaults.zilu.samsungfaults;

/**
 * Created by haniyeh on 12/31/17.
 */

public class StationModel {

    private String id;
    private Long groupId;
    private String faName;
    private String enName;
    private String details;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getFaName() {
        return faName;
    }

    public void setFaName(String faName) {
        this.faName = faName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
