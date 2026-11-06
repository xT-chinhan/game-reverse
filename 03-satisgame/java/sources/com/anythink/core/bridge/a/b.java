package com.anythink.core.bridge.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.d.m;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.b.c;
import com.anythink.core.common.u.b.e;
import com.anythink.core.common.u.j;
import com.anythink.core.common.u.n;
import com.anythink.core.e.d;
import com.byazt.ho.BaseConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b b;
    private final String a = "b";
    private String c = "";
    private final int d = 1;
    private final int e = BaseConstants.Time.MINUTE;
    private final AtomicLong f = new AtomicLong(0);
    private final AtomicLong g = new AtomicLong(0);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final AtomicBoolean j = new AtomicBoolean(false);

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    private b() {
    }

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.h;
        s.b();
        atomicBoolean.set(true);
        com.anythink.core.e.b bVarB = d.a(context).b(s.b().p());
        if (bVarB == null || bVarB.J()) {
            return;
        }
        this.j.set(bVarB.aJ() != 2);
        this.i.set(true);
        c.a().a(new com.anythink.core.common.u.b.d(e.cb, new AnonymousClass1(context)));
    }

    /* JADX INFO: renamed from: com.anythink.core.bridge.a.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (b.this.h.get() && b.this.j.get() && b.this.i.get()) {
                    Intent intentA = b.a(b.this, this.a);
                    intentA.putExtra("a", 1);
                    m.a(this.a).a(intentA);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void b(Context context) {
        c.a().a(new com.anythink.core.common.u.b.d(e.cb, new AnonymousClass1(context)));
    }

    public final void a(final Context context, JSONObject jSONObject) {
        if (context != null && this.h.get()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.f.get();
            if (jCurrentTimeMillis - j <= 60000 || !this.f.compareAndSet(j, jCurrentTimeMillis)) {
                return;
            }
            final String string = jSONObject.toString();
            c.a().a(new com.anythink.core.common.u.b.d(e.cc, new Runnable() { // from class: com.anythink.core.bridge.a.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Intent intentA = b.a(b.this, context);
                        intentA.putExtra("a", 2);
                        intentA.putExtra(d.a, string);
                        m.a(context).a(intentA);
                    } catch (Throwable unused) {
                    }
                }
            }));
        }
    }

    public final void b(final Context context, JSONObject jSONObject) {
        if (context != null && this.h.get()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.g.get();
            if (jCurrentTimeMillis - j <= 60000 || !this.g.compareAndSet(j, jCurrentTimeMillis)) {
                return;
            }
            final String string = jSONObject.toString();
            c.a().a(new com.anythink.core.common.u.b.d(e.cd, new Runnable() { // from class: com.anythink.core.bridge.a.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Intent intentA = b.a(b.this, context);
                        intentA.putExtra("a", 3);
                        intentA.putExtra(d.a, string);
                        m.a(context).a(intentA);
                    } catch (Throwable unused) {
                    }
                }
            }));
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.bridge.a.b$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ Context b;
        final /* synthetic */ Bundle c;

        AnonymousClass4(int i, Context context, Bundle bundle) {
            this.a = i;
            this.b = context;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (b.this.h.get() && b.this.j.get()) {
                    int i = this.a;
                    if (i == 5 || i == 6 || i == 7) {
                        Intent intentA = b.a(b.this, this.b);
                        intentA.putExtra("a", this.a);
                        intentA.putExtra("b", this.c);
                        m.a(this.b).a(intentA);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(Context context, int i, Bundle bundle) {
        c.a().a(new com.anythink.core.common.u.b.d(e.ce, new AnonymousClass4(i, context, bundle)));
    }

    private Intent c(Context context) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(this.c)) {
            String str = "";
            for (int i = 0; i < 2; i++) {
                str = str + packageName;
            }
            this.c = n.c(j.c(str));
        }
        Intent intent = new Intent(this.c);
        intent.setPackage(packageName);
        intent.putExtra(com.anythink.core.common.s.a, 1);
        return intent;
    }

    static /* synthetic */ Intent a(b bVar, Context context) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(bVar.c)) {
            String str = "";
            for (int i = 0; i < 2; i++) {
                str = str + packageName;
            }
            bVar.c = n.c(j.c(str));
        }
        Intent intent = new Intent(bVar.c);
        intent.setPackage(packageName);
        intent.putExtra(com.anythink.core.common.s.a, 1);
        return intent;
    }
}
