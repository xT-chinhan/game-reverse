package com.mar.sdk.verify;

/* JADX INFO: loaded from: classes2.dex */
public class UGameArchive {
    private String extraData;
    private String gameArchive;
    private int serialNumber;
    private int status;

    public UGameArchive() {
        this.status = 0;
        this.serialNumber = 0;
        this.gameArchive = "";
        this.extraData = "";
    }

    public UGameArchive(int status, int serialNumber, String gameArchive) {
        this.status = 0;
        this.serialNumber = 0;
        this.gameArchive = "";
        this.extraData = "";
        this.status = status;
        this.serialNumber = serialNumber;
        this.gameArchive = gameArchive;
        this.extraData = "";
    }

    public UGameArchive(int status, int serialNumber, String gameArchive, String extraData) {
        this.status = 0;
        this.serialNumber = 0;
        this.gameArchive = "";
        this.extraData = "";
        this.status = status;
        this.serialNumber = serialNumber;
        this.gameArchive = gameArchive;
        this.extraData = extraData;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getGameArchive() {
        return this.gameArchive;
    }

    public void setGameArchive(String gameArchive) {
        this.gameArchive = gameArchive;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }
}
