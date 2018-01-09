package com.samsungfaults.zilu.samsungfaults;

/**
 * Created by user on 1/3/2018.
 */

public class StationFaultModel {

    private Integer id;
    private String staFaultCode;
    private String staFaultName;
    private String staFaultStationId;

    public StationFaultModel(){

    }
    public StationFaultModel(String staFaultName){
        this.staFaultName = staFaultName;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaFaultCode() {
        return staFaultCode;
    }
    public void setStaFaultCode(String name) {
        this.staFaultCode = name;
    }

    public String getStaFaultName() {
        return staFaultName;
    }
    public void setStaFaultName(String name) {
        this.staFaultName = name;
    }

    public String getStaFaultStationId() {
        return staFaultStationId;
    }
    public void setStaFaultStationId(String name) {
        this.staFaultStationId = name;
    }

}
