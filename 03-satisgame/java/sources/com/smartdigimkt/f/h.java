package com.smartdigimkt.f;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.m.cp;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static volatile h n;
    public a b;
    public final JSONObject i;
    public final String a = "h";
    public final Object f = new Object();
    public String g = null;
    public String h = null;
    public String j = "";
    public int k = 0;
    public boolean l = false;
    public boolean m = false;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final AtomicBoolean e = new AtomicBoolean(false);

    public h() {
        this.i = null;
        this.i = new JSONObject();
    }

    public static h a() {
        if (n == null) {
            synchronized (h.class) {
                if (n == null) {
                    n = new h();
                }
            }
        }
        return n;
    }

    public final void a(Context context, int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = this.k;
        if (i == i2 || i2 == 0) {
            synchronized (this.f) {
                try {
                    this.j = new JSONObject(str).getString("ua");
                    String strB = com.smartdigimkt.r4.e.b(str);
                    this.g = strB;
                    this.i.put(cp.n, strB);
                } catch (Throwable unused) {
                }
                a(context);
            }
        }
    }

    public final void a(Context context) {
        synchronized (this.f) {
            if (this.e.get()) {
                if (TextUtils.isEmpty(this.g)) {
                    return;
                }
                if (TextUtils.isEmpty(this.h)) {
                    return;
                }
                if (this.d.get()) {
                    return;
                }
                this.d.set(true);
                com.smartdigimkt.q3.f.a().c(new g(this, context));
            }
        }
    }
}
