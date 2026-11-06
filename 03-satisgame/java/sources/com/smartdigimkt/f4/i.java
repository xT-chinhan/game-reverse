package com.smartdigimkt.f4;

import com.smartdigimkt.sdk.api.AdError;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements com.smartdigimkt.a4.b {
    public final /* synthetic */ n a;

    public i(n nVar) {
        this.a = nVar;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
        synchronized (this.a.s) {
            if (this.a.r != null) {
                try {
                    Iterator it = this.a.r.iterator();
                    while (it.hasNext()) {
                        ((com.smartdigimkt.a4.b) it.next()).a(i);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        synchronized (this.a.s) {
            if (this.a.r != null) {
                try {
                    Iterator it = this.a.r.iterator();
                    while (it.hasNext()) {
                        ((com.smartdigimkt.a4.b) it.next()).a(i, obj);
                    }
                    this.a.r.clear();
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        synchronized (this.a.s) {
            if (this.a.r != null) {
                try {
                    Iterator it = this.a.r.iterator();
                    while (it.hasNext()) {
                        ((com.smartdigimkt.a4.b) it.next()).a(i, str, adError);
                    }
                    this.a.r.clear();
                } catch (Throwable unused) {
                }
            }
        }
    }
}
