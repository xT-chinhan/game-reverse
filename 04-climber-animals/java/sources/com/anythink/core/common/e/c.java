package com.anythink.core.common.e;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class c<T> {
    protected d e;

    public c(d dVar) {
        this.e = dVar;
    }

    protected final synchronized SQLiteDatabase c() {
        return this.e.a();
    }

    protected final synchronized SQLiteDatabase d() {
        return this.e.b();
    }
}
