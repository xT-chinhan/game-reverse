package com.mar.sdk.permission;

/* JADX INFO: loaded from: classes2.dex */
public class MARPermissionInfo {
    public static final int STATE_DENIED = 2;
    public static final int STATE_PERMITTED = 1;
    private String cname;
    private String group;
    private String name;
    private boolean state;

    public MARPermissionInfo() {
    }

    public MARPermissionInfo(String name, String cname, String group) {
        this.name = name;
        this.cname = cname;
        this.group = group;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return this.state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
