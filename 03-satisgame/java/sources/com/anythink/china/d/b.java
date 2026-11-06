package com.anythink.china.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.m.a.m;
import com.anythink.core.common.u.ad;
import com.anythink.core.common.u.n;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b a = null;
    private static final String b = "b";
    private Context c;
    private String d;
    private long e = 0;
    private boolean f = false;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private b() {
    }

    public final String b() {
        return this.d;
    }

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            this.c = context;
            if (this.e == 0) {
                this.e = ad.b(context, t.b.a, t.a.S, 0L);
            }
            long j = this.e;
            if (j > 0) {
                Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                long timeInMillis = calendar.getTimeInMillis();
                calendar.set(11, 23);
                calendar.set(12, 59);
                calendar.set(13, 59);
                calendar.set(14, m.h);
                if (j >= timeInMillis && j <= calendar.getTimeInMillis()) {
                    return;
                }
            }
            if (TextUtils.isEmpty(this.d)) {
                String strC = ad.c(this.c, t.b.a, t.a.R, "");
                this.d = strC;
                if (TextUtils.isEmpty(strC)) {
                    String strA = n.a(UUID.randomUUID().toString() + new Random().nextInt(100000001));
                    this.d = strA;
                    ad.b(this.c, t.b.a, t.a.R, strA);
                }
            }
            if (this.f) {
                return;
            }
            this.f = true;
            new a(this.c, s.b().p(), s.b().q(), this.d).a(0, new com.anythink.core.common.l.s() { // from class: com.anythink.china.d.b.1
                @Override // com.anythink.core.common.l.s
                public final void onLoadStart(int i) {
                    b.this.f = true;
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadFinish(int i, Object obj) {
                    try {
                        b.this.f = false;
                        b.this.e = System.currentTimeMillis();
                        ad.a(b.this.c, t.b.a, t.a.S, b.this.e);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadError(int i, String str, AdError adError) {
                    b.this.f = false;
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadCanceled(int i) {
                    b.this.f = false;
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static boolean a(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, m.h);
        return j >= timeInMillis && j <= calendar.getTimeInMillis();
    }
}
