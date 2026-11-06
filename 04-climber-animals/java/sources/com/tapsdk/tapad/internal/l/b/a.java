package com.tapsdk.tapad.internal.l.b;

import android.content.Context;
import com.tapsdk.tapad.internal.i.b;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final String c = "settings_volume_state";
    public static final int d = 0;
    public static final int e = 1;
    b a;
    private int b;

    public a(Context context) {
        b bVar = new b(context);
        this.a = bVar;
        try {
            this.b = Integer.parseInt(bVar.b(c), 0);
        } catch (Throwable unused) {
            this.b = 0;
        }
    }

    public int a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z ? 1 : 0;
        this.a.a(c, this.b + "");
    }
}
