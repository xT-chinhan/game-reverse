package com.smartdigimkt.y0;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements h {
    public final Context a;
    public final h b;

    public n(Context context) {
        p pVar = new p();
        this.a = context.getApplicationContext();
        this.b = pVar;
    }

    @Override // com.smartdigimkt.y0.h
    public final i a() {
        return new m(this.a, this.b.a());
    }
}
