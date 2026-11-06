package com.anythink.core.common;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final String a = "Y29tLnhpYW9taS5tYXJrZXQuRE1fUEFHRV9PUEVORUQ=";
    public static final String b = "Y29tLnhpYW9taS5tYXJrZXQuRE1fUEFHRV9DTE9TRUQ=";
    public static final String c = "Y29tLnhpYW9taS5tYXJrZXQuRElSRUNUX01BSUxfU1RBVFVT";
    public static final String d = "Y29udGVudDovL2NvbS54aWFvbWkubWFya2V0LnByb3ZpZGVyLkRpcmVjdE1haWxQcm92aWRlcg==";
    private static final String e = "code";
    private static final String f = "packageName";
    private static volatile String i;
    private static volatile o m;
    private CopyOnWriteArrayList<com.anythink.core.common.h.w> g = new CopyOnWriteArrayList<>();
    private final AtomicBoolean h = new AtomicBoolean(false);
    private volatile Boolean j;
    private com.anythink.core.common.h.w k;
    private Context l;

    private static void e() {
    }

    private o() {
    }

    public static o a() {
        if (m == null) {
            synchronized (o.class) {
                if (m == null) {
                    m = new o();
                }
            }
        }
        return m;
    }

    private void a(com.anythink.core.common.h.w wVar) {
        if (this.j == null || wVar == null || !this.j.booleanValue()) {
            return;
        }
        this.k = wVar;
        this.g.add(wVar);
    }

    private void b(com.anythink.core.common.h.w wVar) {
        if (this.j == null || wVar == null || !this.j.booleanValue()) {
            return;
        }
        this.k = null;
        try {
            this.g.remove(wVar);
        } catch (Exception unused) {
        }
    }

    private com.anythink.core.common.h.w d() {
        return this.k;
    }

    public final void a(Context context) {
        this.l = context;
        if (this.h.compareAndSet(false, true)) {
            try {
                this.j = f();
            } catch (Throwable unused) {
            }
        }
    }

    private static Boolean f() {
        Cursor cursorQuery;
        Context contextG = com.anythink.core.common.d.s.b().g();
        Boolean boolValueOf = null;
        if (contextG != null && contextG.getContentResolver() != null) {
            try {
                cursorQuery = contextG.getContentResolver().query(Uri.parse(com.anythink.core.common.u.j.b(d)), null, null, null, null);
            } catch (Throwable unused) {
                cursorQuery = null;
            }
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("support"));
                        if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase(AbstractJsonLexerKt.NULL) && (string.equalsIgnoreCase("false") || string.equalsIgnoreCase("true"))) {
                            boolValueOf = Boolean.valueOf(Boolean.parseBoolean(string));
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        i = cursorQuery.getString(cursorQuery.getColumnIndex("detailStyle"));
                    } catch (Exception unused3) {
                    }
                }
                try {
                    cursorQuery.close();
                } catch (Throwable unused4) {
                }
            }
        }
        return boolValueOf;
    }

    public static String b() {
        try {
            return i == null ? "" : String.format("[%s]", i);
        } catch (Throwable unused) {
            return "";
        }
    }

    public final int c() {
        if (this.j != null) {
            return this.j.booleanValue() ? 1 : 0;
        }
        return -1;
    }
}
