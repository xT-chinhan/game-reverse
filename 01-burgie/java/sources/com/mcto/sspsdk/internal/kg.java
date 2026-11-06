package com.mcto.sspsdk.internal;

import android.content.Context;
import com.mcto.sspsdk.QyAdSlot;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class kg implements f7 {
    public final /* synthetic */ ng a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ QyAdSlot d;

    public kg(ng ngVar, boolean z, Context context, QyAdSlot qyAdSlot) {
        this.a = ngVar;
        this.b = z;
        this.c = context;
        this.d = qyAdSlot;
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar, int i, String str) {
        this.a.a(i, str);
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar) {
        ArrayList arrayList = vhVar.b;
        if (arrayList == null || arrayList.isEmpty()) {
            this.a.a(5, "has empty ad.");
            return;
        }
        p pVar = (p) arrayList.get(0);
        if (pVar == null) {
            this.a.a(5, "has empty ad.");
            return;
        }
        if (!this.b) {
            this.a.a(new dg(this.c, this.d, pVar, false));
            return;
        }
        Context context = this.c;
        QyAdSlot qyAdSlot = this.d;
        ng ngVar = this.a;
        if (pVar.n()) {
            new ig(context, qyAdSlot, pVar, ngVar);
        } else {
            ngVar.a(new dg(context, qyAdSlot, pVar, true));
        }
    }
}
