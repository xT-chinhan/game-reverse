package com.mcto.sspsdk.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class nh {
    public static volatile nh b;
    public final Context a;

    public nh(Context context) {
        this.a = context instanceof Application ? context : context.getApplicationContext();
    }

    public static nh a(Context context) {
        if (b != null) {
            return b;
        }
        synchronized (nh.class) {
            if (b == null) {
                b = new nh(context);
            }
        }
        return b;
    }

    public final void b(HashMap map) {
        SharedPreferences.Editor editorEdit = this.a.getSharedPreferences("iad_spa", 0).edit();
        for (String str : map.keySet()) {
            editorEdit.putString(str, (String) map.get(str));
        }
        editorEdit.apply();
    }

    public final String a(String str) {
        return this.a.getSharedPreferences("iad_dev", 0).getString(str, "");
    }

    public final void a(HashMap map) {
        SharedPreferences.Editor editorEdit = this.a.getSharedPreferences("iad_dev", 0).edit();
        for (String str : map.keySet()) {
            editorEdit.putString(str, (String) map.get(str));
        }
        editorEdit.apply();
    }

    public final boolean a() {
        AtomicInteger atomicInteger = gj.a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences sharedPreferences = this.a.getSharedPreferences("iad_spa", 0);
            long j = sharedPreferences.getLong("frst", 0L);
            if (Math.abs(jCurrentTimeMillis - j) <= 86400000 && (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000 == (((long) TimeZone.getDefault().getOffset(jCurrentTimeMillis)) + jCurrentTimeMillis) / 86400000) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("frst", jCurrentTimeMillis);
            editorEdit.apply();
            return true;
        } catch (Exception e) {
            r9.a("ssp_sdk", "firstColdStart(): ", e);
            return false;
        }
    }

    public final void a(String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = this.a.getSharedPreferences(str, 0).edit();
        editorEdit.putString(str2, str3);
        editorEdit.apply();
    }
}
