package com.smartdigimkt.j3;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.t2.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static volatile b b;
    public String a;

    public b() {
        new AtomicBoolean(false);
        com.smartdigimkt.q3.f.a().a(new a(this), 0L, 7);
    }

    public static b a() {
        if (b == null) {
            synchronized (z.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public final synchronized String a(Context context) {
        if (TextUtils.isEmpty(this.a)) {
            this.a = y.c(context, "sdm_adx_rp_sdk", "app_default_h5_zip_url");
        }
        return this.a;
    }
}
