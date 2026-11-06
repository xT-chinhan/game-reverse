package com.mar.sdk.base;

import com.mar.sdk.verify.UToken;

/* JADX INFO: loaded from: classes2.dex */
public interface IMARSDKListener {
    void onAuthResult(UToken uToken);

    void onLoginResult(String str);

    void onLogout();

    void onPayResult(int i, String str);

    void onRedeemResult(String str);

    void onResult(int i, String str);

    void onSwitchAccount(String str);
}
