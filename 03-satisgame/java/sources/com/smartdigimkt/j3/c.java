package com.smartdigimkt.j3;

import android.text.TextUtils;
import com.smartdigimkt.d0.n;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ n b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;

    public c(String str, n nVar, String str2, long j) {
        this.a = str;
        this.b = nVar;
        this.c = str2;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (TextUtils.isEmpty(this.a)) {
            this.b.a(3, this.c, "H5Template load fail:h5TemplateFilePath is empty");
            return;
        }
        this.b.a(this.d, this.c, this.a);
    }
}
