package com.smartdigimkt.z2;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public final d a;

    public b(d dVar) {
        this.a = dVar;
    }

    public final synchronized SQLiteDatabase a() {
        return this.a.a();
    }

    public final synchronized SQLiteDatabase b() {
        return this.a.b();
    }
}
