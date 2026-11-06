package com.mar.sdk.verify;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UToken {
    private String avatar;
    private String channelUserId;
    private String extension;
    private String nickName;
    private boolean suc = false;
    private String timestamp;
    private String token;
    private String userID;
    private String username;

    public UToken() {
    }

    public UToken(String userID, String username, String nickName, String avatar, String channelUserId, String token, String extension, String timestamp) {
        this.userID = userID;
        this.channelUserId = channelUserId;
        this.username = username;
        this.nickName = nickName;
        this.avatar = avatar;
        this.token = token;
        this.extension = extension;
        this.timestamp = timestamp;
    }

    public String toString() {
        JSONObject json = new JSONObject();
        try {
            json.put("suc", this.suc);
            json.put("userID", this.userID);
            json.put("sdkUserID", this.channelUserId);
            json.put("username", this.username);
            json.put("nickName", this.nickName);
            json.put("sdkUsername", this.nickName);
            json.put("avatar", this.avatar);
            json.put("token", this.token);
            json.put("extension", this.extension);
            json.put("timestamp", this.timestamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuc() {
        return this.suc;
    }

    public void setSuc(boolean suc) {
        this.suc = suc;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSdkUserID() {
        return this.channelUserId;
    }

    public void setSdkUserID(String channelUserId) {
        this.channelUserId = channelUserId;
    }

    public String getSdkUsername() {
        return this.nickName;
    }

    public void setSdkUsername(String sdkUsername) {
        this.nickName = sdkUsername;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
