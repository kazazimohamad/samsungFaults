package com.samsungfaults.zilu.samsungfaults;

/**
 * Created by mohamad on 12/15/2017.
 */
public class groupsModel {

    private Integer id;
    private String groupName;

    public groupsModel(){

    }
    public groupsModel(String groupName){
        this.groupName = groupName;
    }
    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String name) {
        this.groupName = name;
    }
}
