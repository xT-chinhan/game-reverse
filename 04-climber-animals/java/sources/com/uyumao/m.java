package com.uyumao;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: DataStore.java */
/* JADX INFO: loaded from: classes4.dex */
public class m {
    public static volatile m a;
    public final SharedPreferences b = e.a().getSharedPreferences("um_social_azx", 0);

    public static m a() {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m();
                }
            }
        }
        return a;
    }
}
