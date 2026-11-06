package com.smartdigimkt.n;

import android.content.Context;
import com.smartdigimkt.b3.f;
import com.smartdigimkt.z2.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.smartdigimkt.b3.c c;

    public a(Context context, String str, com.smartdigimkt.b3.c cVar) {
        this.a = context;
        this.b = str;
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVarA = g.a(this.a).a(this.b);
        if (fVarA != null) {
            this.c.D = fVarA.B;
        } else {
            this.c.D = 0;
        }
    }
}
