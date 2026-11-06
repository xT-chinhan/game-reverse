package com.smartdigimkt.f0;

import com.smartdigimkt.r4.q;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ e b;

    public c(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.d) {
            File file = this.b.c;
            if (file == null) {
                return;
            }
            try {
                if (!file.exists()) {
                    this.b.c.mkdirs();
                }
                File file2 = new File(this.b.c, "tracker_mapping.txt");
                if (file2.exists()) {
                    file2.delete();
                }
                q.a(this.a.getBytes(), file2);
            } catch (Throwable unused) {
            }
        }
    }
}
