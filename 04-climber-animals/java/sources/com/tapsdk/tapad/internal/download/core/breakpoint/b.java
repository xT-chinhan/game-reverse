package com.tapsdk.tapad.internal.download.core.breakpoint;

import android.database.Cursor;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private final int a;
    private final long b;
    private final long c;
    private final long d;

    public b(Cursor cursor) {
        this.a = cursor.getInt(cursor.getColumnIndex("breakpoint_id"));
        this.b = cursor.getInt(cursor.getColumnIndex("start_offset"));
        this.c = cursor.getInt(cursor.getColumnIndex("content_length"));
        this.d = cursor.getInt(cursor.getColumnIndex("current_offset"));
    }

    public int a() {
        return this.a;
    }

    public long b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    public long d() {
        return this.b;
    }

    public a e() {
        return new a(this.b, this.c, this.d);
    }
}
