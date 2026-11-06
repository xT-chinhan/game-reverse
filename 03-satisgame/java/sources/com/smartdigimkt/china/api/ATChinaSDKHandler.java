package com.smartdigimkt.china.api;

import android.content.Context;
import com.anythink.china.b.c;
import com.smartdigimkt.d.b;
import com.smartdigimkt.odopt.api.ATOaidHandler;
import com.smartdigimkt.odopt.api.OaidSDKCallbackListener;

/* JADX INFO: loaded from: classes3.dex */
public class ATChinaSDKHandler {
    public static void handleInitOaidSDK(Context context, OaidSDKCallbackListener oaidSDKCallbackListener) {
        try {
            ATOaidHandler.handleInitOaidSDK(context, oaidSDKCallbackListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void requestPermissionIfNecessary(Context context) {
        b.a(context, c.a, c.b);
    }

    public static void setAllowUseMdidSDK(boolean z) {
        try {
            ATOaidHandler.setAllowUseMdidSDK(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
