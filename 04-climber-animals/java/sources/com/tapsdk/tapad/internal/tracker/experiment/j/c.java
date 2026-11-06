package com.tapsdk.tapad.internal.tracker.experiment.j;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static String a(String str, String str2, String str3) {
        try {
            return new Uri.Builder().scheme(str).authority(str2).path(str3).build().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, Map<String, String> map) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builderBuildUpon.build().toString();
    }
}
