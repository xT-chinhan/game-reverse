package com.tapsdk.tapad.internal.q.c;

import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes3.dex */
public class a implements c {
    private final d a;

    public a(d dVar) {
        this.a = dVar;
    }

    @Override // com.tapsdk.tapad.internal.q.c.c
    public void a(NetworkInfo networkInfo, com.tapsdk.tapad.internal.q.e.a aVar) {
        if (aVar != null) {
            int i = aVar.i;
            if ((i >= 200 && i <= 299) || (i >= 300 && i <= 399)) {
                this.a.a(networkInfo, aVar);
            } else {
                if ((i < 400 || i > 499) && (i < 500 || i > 599)) {
                    return;
                }
                this.a.b(networkInfo, aVar);
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.q.c.c
    public void a(NetworkInfo networkInfo, com.tapsdk.tapad.internal.q.e.a aVar, Exception exc) {
        this.a.a(networkInfo, aVar, exc);
    }
}
