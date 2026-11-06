package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.cn;

/* JADX INFO: loaded from: classes.dex */
public class AdSettings {
    public static String getSDKVersion() {
        return cn.c() + "";
    }

    public static void setNotificationIcon(int i) {
        CustomNotification.setNotificationIcon(i);
    }

    public static void setNotificationChannel(String str) {
        CustomNotification.setNotificationChannel(str);
    }
}
