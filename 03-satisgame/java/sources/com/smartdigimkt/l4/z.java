package com.smartdigimkt.l4;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public static final ConcurrentHashMap d = new ConcurrentHashMap();
    public final String a;
    public final String b;
    public boolean c = false;

    public z(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        File filesDir = (applicationContext != null ? applicationContext : context).getFilesDir();
        if (filesDir == null) {
            return;
        }
        this.a = filesDir.getAbsolutePath() + "/tktp/";
        this.b = str;
    }
}
