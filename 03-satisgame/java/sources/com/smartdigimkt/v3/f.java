package com.smartdigimkt.v3;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.anythink.core.common.s;
import com.smartdigimkt.r4.i;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static volatile f h;
    public final String a = "f";
    public String b = "";
    public final AtomicLong c = new AtomicLong(0);
    public final AtomicLong d = new AtomicLong(0);
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean(false);
    public final AtomicBoolean g = new AtomicBoolean(false);

    public static Intent a(f fVar, Context context) {
        fVar.getClass();
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(fVar.b)) {
            String strA = "";
            for (int i = 0; i < 2; i++) {
                strA = com.smartdigimkt.p.a.a(strA, packageName);
            }
            fVar.b = i.a(com.smartdigimkt.r4.e.e(strA));
        }
        Intent intent = new Intent(fVar.b);
        intent.setPackage(packageName);
        intent.putExtra(s.a, 2);
        return intent;
    }

    public final void b(Context context, JSONObject jSONObject) {
        String string;
        if (context != null && this.e.get()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.c.get();
            if (jCurrentTimeMillis - j <= 60000 || !this.c.compareAndSet(j, jCurrentTimeMillis)) {
                return;
            }
            try {
                string = jSONObject.toString();
            } catch (Throwable unused) {
                string = "";
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            com.smartdigimkt.q3.f.a().c(new c(this, context, string));
        }
    }

    public static f a() {
        if (h == null) {
            synchronized (f.class) {
                if (h == null) {
                    h = new f();
                }
            }
        }
        return h;
    }

    public final void a(Context context) {
        com.smartdigimkt.p4.a aVarA;
        if (context == null || (aVarA = com.smartdigimkt.o4.e.c().a()) == null || aVarA.g) {
            return;
        }
        this.g.set(aVarA.R != 2);
        this.f.set(true);
        com.smartdigimkt.q3.f.a().c(new b(this, context));
    }

    public final void a(Context context, JSONObject jSONObject) {
        String string;
        if (context != null && this.e.get()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.d.get();
            if (jCurrentTimeMillis - j <= 60000 || !this.d.compareAndSet(j, jCurrentTimeMillis)) {
                return;
            }
            try {
                string = jSONObject.toString();
            } catch (Throwable unused) {
                string = "";
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            com.smartdigimkt.q3.f.a().c(new d(this, context, string));
        }
    }
}
