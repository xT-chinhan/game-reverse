package com.anythink.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.bugly.Bugly;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final String b = "Y29tLnhpYW9taS5tYXJrZXQuRE1fUEFHRV9PUEVORUQ=";
    public static final String c = "Y29tLnhpYW9taS5tYXJrZXQuRE1fUEFHRV9DTE9TRUQ=";
    public static final String d = "Y29tLnhpYW9taS5tYXJrZXQuRElSRUNUX01BSUxfU1RBVFVT";
    public static final String e = "Y29udGVudDovL2NvbS54aWFvbWkubWFya2V0LnByb3ZpZGVyLkRpcmVjdE1haWxQcm92aWRlcg==";
    private static final String f = "code";
    private static final String g = "packageName";
    private static volatile String j;
    private static volatile o n;
    BroadcastReceiver a;
    private CopyOnWriteArrayList<com.anythink.core.common.h.w> h = new CopyOnWriteArrayList<>();
    private final AtomicBoolean i = new AtomicBoolean(false);
    private volatile Boolean k;
    private com.anythink.core.common.h.w l;
    private Context m;

    private o() {
    }

    public static o a() {
        if (n == null) {
            synchronized (o.class) {
                if (n == null) {
                    n = new o();
                }
            }
        }
        return n;
    }

    public final void a(com.anythink.core.common.h.w wVar) {
        if (this.k == null || wVar == null || !this.k.booleanValue()) {
            return;
        }
        this.l = wVar;
        this.h.add(wVar);
    }

    public final void b(com.anythink.core.common.h.w wVar) {
        if (this.k == null || wVar == null || !this.k.booleanValue()) {
            return;
        }
        this.l = null;
        try {
            this.h.remove(wVar);
        } catch (Exception unused) {
        }
    }

    private com.anythink.core.common.h.w d() {
        return this.l;
    }

    public final void a(Context context) {
        this.m = context;
        if (this.i.compareAndSet(false, true)) {
            try {
                this.k = f();
                if (this.k == null || !this.k.booleanValue() || this.m == null) {
                    return;
                }
                this.a = new AnonymousClass1();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(com.anythink.core.common.v.k.b(b));
                intentFilter.addAction(com.anythink.core.common.v.k.b(c));
                intentFilter.addAction(com.anythink.core.common.v.k.b(d));
                this.m.registerReceiver(this.a, intentFilter);
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (this.k == null || !this.k.booleanValue() || this.m == null) {
            return;
        }
        try {
            this.a = new AnonymousClass1();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.anythink.core.common.v.k.b(b));
            intentFilter.addAction(com.anythink.core.common.v.k.b(c));
            intentFilter.addAction(com.anythink.core.common.v.k.b(d));
            this.m.registerReceiver(this.a, intentFilter);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.o$1, reason: invalid class name */
    final class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Bundle extras;
            com.anythink.core.common.h.w wVar;
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || action.equals(com.anythink.core.common.v.k.b(o.b)) || action.equals(com.anythink.core.common.v.k.b(o.c)) || !action.equals(com.anythink.core.common.v.k.b(o.d)) || (extras = intent.getExtras()) == null) {
                return;
            }
            int i = extras.getInt("code", -1);
            String string = extras.getString("packageName", "");
            if (i == -1 || TextUtils.isEmpty(string)) {
                return;
            }
            if (o.this.l == null || !TextUtils.equals(o.this.l.I(), string)) {
                if (o.this.h != null && o.this.h.size() > 0) {
                    Iterator it = o.this.h.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            wVar = null;
                            break;
                        }
                        com.anythink.core.common.h.w wVar2 = (com.anythink.core.common.h.w) it.next();
                        if (wVar2 != null && TextUtils.equals(wVar2.I(), string)) {
                            wVar = wVar2;
                            break;
                        }
                    }
                } else {
                    wVar = null;
                    break;
                }
            } else {
                wVar = o.this.l;
            }
            if (wVar == null) {
                return;
            }
            if (i == 4) {
                o.this.b(wVar);
            }
            com.anythink.core.common.u.e.a(wVar.q(), wVar.v(), "", i, "", 0L, 0L, wVar.ap(), wVar.aq());
        }

        private com.anythink.core.common.h.w a(String str) {
            if (o.this.l == null || !TextUtils.equals(o.this.l.I(), str)) {
                if (o.this.h == null || o.this.h.size() <= 0) {
                    return null;
                }
                for (com.anythink.core.common.h.w wVar : o.this.h) {
                    if (wVar != null && TextUtils.equals(wVar.I(), str)) {
                        return wVar;
                    }
                }
                return null;
            }
            return o.this.l;
        }
    }

    private void b(Context context) {
        BroadcastReceiver broadcastReceiver = this.a;
        if (broadcastReceiver == null || context == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused) {
        }
        this.l = null;
        this.h.clear();
        this.h = null;
        this.a = null;
        this.m = null;
    }

    private static Boolean f() {
        Cursor cursorQuery;
        Context contextG = com.anythink.core.common.d.t.b().g();
        Boolean boolValueOf = null;
        if (contextG != null && contextG.getContentResolver() != null) {
            try {
                cursorQuery = contextG.getContentResolver().query(Uri.parse(com.anythink.core.common.v.k.b(e)), null, null, null, null);
            } catch (Throwable unused) {
                cursorQuery = null;
            }
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("support"));
                        if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase(AbstractJsonLexerKt.NULL) && (string.equalsIgnoreCase(Bugly.SDK_IS_DEV) || string.equalsIgnoreCase("true"))) {
                            boolValueOf = Boolean.valueOf(Boolean.parseBoolean(string));
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        j = cursorQuery.getString(cursorQuery.getColumnIndex("detailStyle"));
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
            return j == null ? "" : String.format("[%s]", j);
        } catch (Throwable unused) {
            return "";
        }
    }

    public final int c() {
        if (this.k != null) {
            return this.k.booleanValue() ? 1 : 0;
        }
        return -1;
    }
}
