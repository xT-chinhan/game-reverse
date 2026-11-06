package com.anythink.core.common.f;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class b<T> {
    protected c e;

    public b(c cVar) {
        this.e = cVar;
    }

    protected final synchronized SQLiteDatabase a() {
        return this.e.a();
    }

    protected final synchronized SQLiteDatabase b() {
        return this.e.b();
    }
}
