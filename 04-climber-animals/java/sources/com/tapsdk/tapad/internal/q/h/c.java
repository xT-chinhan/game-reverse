package com.tapsdk.tapad.internal.q.h;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final String b = "PREFERENCES";
    private final SharedPreferences a;

    public c(Context context) {
        this.a = context.getSharedPreferences(b, 0);
    }

    public float a(String str) {
        return this.a.getFloat(str, 0.0f);
    }

    public void a(String str, float f) {
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.putFloat(str, f);
        editorEdit.apply();
    }
}
