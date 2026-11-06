package com.mar.sdk.gg.push;

/* JADX INFO: loaded from: classes2.dex */
public class PushConfig {
    private String gameIcon;
    private String gameName;
    private String gameUrl;
    private String packageName;
    private int pushId;
    private int sort;

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getPushId() {
        return this.pushId;
    }

    public void setPushId(int pushId) {
        this.pushId = pushId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameIcon() {
        return this.gameIcon;
    }

    public void setGameIcon(String gameIcon) {
        this.gameIcon = gameIcon;
    }

    public String getGameUrl() {
        return this.gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public int getSort() {
        return this.sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
