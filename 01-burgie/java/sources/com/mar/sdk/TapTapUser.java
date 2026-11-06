package com.mar.sdk;

import android.app.Activity;
import android.text.TextUtils;
import com.mar.sdk.log.Log;
import com.mar.sdk.plugin.MARSpecialInterface;
import com.mar.sdk.utils.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class TapTapUser extends MARUserAdapter implements ISpecialInterface {
    private String[] supportedMethods = {"login", "switchLogin", "updateApk"};

    public TapTapUser(Activity context) {
        TapTapSDK.getInstance().initTap();
        MARSpecialInterface.getInstance().setSpecialInterface(this);
    }

    @Override // com.mar.sdk.MARUserAdapter, com.mar.sdk.IUser
    public void switchLogin() {
        TapTapSDK.getInstance().logout();
        TapTapSDK.getInstance().login();
    }

    @Override // com.mar.sdk.MARUserAdapter, com.mar.sdk.IUser
    public void login() {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.TapTapUser.1
            @Override // java.lang.Runnable
            public void run() {
                TapTapSDK.getInstance().login();
            }
        });
    }

    @Override // com.mar.sdk.MARUserAdapter, com.mar.sdk.IUser
    public void logout() {
        TapTapSDK.getInstance().logout();
    }

    @Override // com.mar.sdk.MARUserAdapter, com.mar.sdk.IUser
    public void realNameRegister() {
        TapTapSDK.getInstance().realNameRegister();
    }

    @Override // com.mar.sdk.MARUserAdapter, com.mar.sdk.IUser
    public void queryAntiAddiction() {
        TapTapSDK.getInstance().queryAntiAddiction();
    }

    @Override // com.mar.sdk.MARUserAdapter, com.mar.sdk.IPlugin
    public boolean isSupportMethod(String methodName) {
        return Arrays.contain(this.supportedMethods, methodName);
    }

    @Override // com.mar.sdk.ISpecialInterface
    public boolean isFromGameCenter(Activity context) {
        return false;
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void showGameCenter(Activity context) {
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void showPostDetail(Activity context, String postId, String extra) {
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void performFeature(Activity context, String type) {
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void callSpecailFunc(Activity context, String funcName, SDKParams params) {
        if (TextUtils.isEmpty(funcName)) {
            Log.d("MARSDK-TapTapSDK", "call special func fail, function name is null");
        } else if (funcName.equals("openReview")) {
            TapTapSDK.getInstance().openReview();
        } else if (funcName.equals("opneRep")) {
            TapTapSDK.getInstance().opneRep(params);
        }
    }

    @Override // com.mar.sdk.ISpecialInterface
    public String getOtherChannel(Activity context) {
        return null;
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void gotoMoreGame() {
    }

    @Override // com.mar.sdk.ISpecialInterface
    public void openMoment() {
    }

    @Override // com.mar.sdk.MARUserAdapter, com.mar.sdk.IUser
    public void updateApk() {
        TapTapSDK.getInstance().updataApk();
    }
}
