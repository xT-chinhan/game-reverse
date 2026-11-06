package com.tapsdk.tapad.internal.tracker.experiment.entities;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public final String a;
    public final String b;
    public final Map<String, Object> c;

    private c() {
        this.a = "";
        this.b = "";
        this.c = new HashMap();
    }

    public c(String str, String str2, Map<String, Object> map) {
        this.a = str;
        this.b = str2;
        this.c = map;
    }
}
