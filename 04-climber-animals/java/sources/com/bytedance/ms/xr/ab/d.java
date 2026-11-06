package com.bytedance.ms.xr.ab;

import android.content.Context;
import com.bytedance.ms.xr.ka.ab;
import com.bytedance.ms.xr.x;
import com.bytedance.ms.xr.x.ch;
import com.bytedance.ms.xr.x.ny;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f550ms;

    private d(Context context) {
        this.f550ms = context;
    }

    public static void ms(Context context, int i) {
        try {
            if (!x.ms().d().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        ab.xr().postDelayed(new d(context), i);
    }

    public static void ms(Context context) {
        ms(context, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new com.bytedance.ms.xr.ka.ah(this.f550ms).ms(ny.xr(this.f550ms));
        } catch (Throwable th) {
            try {
                ch.xr(th);
            } finally {
                com.bytedance.ms.xr.c.ah.ms(ab.xr(), this.f550ms).ms();
            }
        }
    }
}
