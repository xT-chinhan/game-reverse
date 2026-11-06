package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile String f1358ms;

    public static String ms() {
        if (!TextUtils.isEmpty(f1358ms)) {
            return f1358ms;
        }
        String str = Build.MODEL;
        f1358ms = str;
        return str;
    }
}
