package com.tapsdk.tapad.internal.download.core.breakpoint;

import android.database.Cursor;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final boolean f;
    private final boolean g;

    public d(Cursor cursor) {
        this.a = cursor.getInt(cursor.getColumnIndex("id"));
        this.b = cursor.getString(cursor.getColumnIndex("url"));
        this.c = cursor.getString(cursor.getColumnIndex("etag"));
        this.d = cursor.getString(cursor.getColumnIndex("parent_path"));
        this.e = cursor.getString(cursor.getColumnIndex("filename"));
        this.f = cursor.getInt(cursor.getColumnIndex("task_only_parent_path")) == 1;
        this.g = cursor.getInt(cursor.getColumnIndex("chunked")) == 1;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.e;
    }

    public int c() {
        return this.a;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.b;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.f;
    }

    public c h() {
        c cVar = new c(this.a, this.b, new File(this.d), this.e, this.f);
        cVar.a(this.c);
        cVar.a(this.g);
        return cVar;
    }
}
