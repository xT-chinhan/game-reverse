package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import com.mcto.sspsdk.QyCustomMade;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class rd {
    public static boolean a = true;
    public static boolean b = true;
    public static boolean c = false;
    public static QyCustomMade d = null;
    public static boolean e = true;
    public static String f;
    public static String g;
    public static final HashMap h = new HashMap();

    public static boolean a() {
        return !TextUtils.isEmpty(f) && f.startsWith("qc_");
    }
}
