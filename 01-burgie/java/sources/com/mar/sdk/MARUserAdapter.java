package com.mar.sdk;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MARUserAdapter implements IUser {
    @Override // com.mar.sdk.IPlugin
    public abstract boolean isSupportMethod(String str);

    @Override // com.mar.sdk.IUser
    public void login() {
    }

    @Override // com.mar.sdk.IUser
    public void loginCustom(String customData) {
    }

    @Override // com.mar.sdk.IUser
    public void switchLogin() {
    }

    @Override // com.mar.sdk.IUser
    public boolean showAccountCenter() {
        return false;
    }

    @Override // com.mar.sdk.IUser
    public void logout() {
    }

    @Override // com.mar.sdk.IUser
    public void submitExtraData(UserExtraData extraData) {
    }

    @Override // com.mar.sdk.IUser
    public void exit() {
    }

    @Override // com.mar.sdk.IUser
    public void postGiftCode(String code) {
    }

    @Override // com.mar.sdk.IUser
    public void realNameRegister() {
    }

    @Override // com.mar.sdk.IUser
    public void queryAntiAddiction() {
    }

    @Override // com.mar.sdk.IUser
    public void updateApk() {
    }
}
