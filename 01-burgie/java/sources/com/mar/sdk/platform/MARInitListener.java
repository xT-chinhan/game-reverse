package com.mar.sdk.platform;

import com.mar.sdk.verify.UToken;

/* JADX INFO: loaded from: classes2.dex */
public interface MARInitListener {
    void onInitResult(int i, String str);

    void onLoginResult(int i, UToken uToken);

    void onLogout();

    void onPayResult(int i, String str);

    void onRedeemResult(String str);

    void onResult(int i, String str);

    void onSwitchAccount(UToken uToken);
}
