package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ka {
    public static long ab = 31457280;
    public static volatile String ah = "";
    public static long c = 5242880;
    public static long d = 512000;
    public static long ka = 50;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile String f4631ms = "";
    public static final JSONObject ny = new JSONObject();
    public static long x = 10485760;
    public static volatile String xr = "";

    public static void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f4631ms = str;
    }
}
