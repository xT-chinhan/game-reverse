package com.tapsdk.tapad.internal.tracker.experiment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static final int a = 268435470;
    public static final int b = 268435471;
    public static final String c = "tracker_for_tapadn_network";
    public static final String d = "tracker_for_tapadn_sdk";
    private static final Map<Integer, String> e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    static {
        HashMap map = new HashMap();
        e = map;
        map.put(Integer.valueOf(a), c);
        map.put(Integer.valueOf(b), d);
    }

    public static String a(int i) {
        return e.get(Integer.valueOf(i));
    }
}
