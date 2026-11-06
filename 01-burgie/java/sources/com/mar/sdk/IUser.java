package com.mar.sdk;

/* JADX INFO: loaded from: classes2.dex */
public interface IUser extends IPlugin {
    public static final int PLUGIN_TYPE = 1;

    void exit();

    void login();

    void loginCustom(String str);

    void logout();

    void postGiftCode(String str);

    void queryAntiAddiction();

    void realNameRegister();

    boolean showAccountCenter();

    void submitExtraData(UserExtraData userExtraData);

    void switchLogin();

    void updateApk();
}
