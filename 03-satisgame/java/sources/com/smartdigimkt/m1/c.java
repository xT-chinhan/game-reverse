package com.smartdigimkt.m1;

import com.smartdigimkt.r4.q;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a = "adx_optional_res.txt";
    public final /* synthetic */ String b;
    public final /* synthetic */ d c;

    public c(d dVar, String str) {
        this.c = dVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.f) {
            try {
                if (!this.c.d.exists()) {
                    this.c.d.mkdirs();
                }
                File file = new File(this.c.d, this.a);
                if (file.exists()) {
                    file.delete();
                }
                q.a(this.b.getBytes(), file);
            } catch (Throwable unused) {
            }
        }
    }
}
