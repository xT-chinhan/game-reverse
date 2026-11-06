package com.mcto.sspsdk.internal;

import android.content.Context;
import com.mcto.sspsdk.QyAdSlot;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class i6 implements f7 {
    public final /* synthetic */ QyAdSlot a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ t6 c;

    public i6(QyAdSlot qyAdSlot, Context context, t6 t6Var) {
        this.a = qyAdSlot;
        this.b = context;
        this.c = t6Var;
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar, int i, String str) {
        this.c.a(i, str);
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar) {
        ArrayList arrayList = vhVar.b;
        if (arrayList == null || arrayList.isEmpty()) {
            this.c.a(3, "no ads！");
            return;
        }
        p pVar = (p) arrayList.get(0);
        if (lj.b(pVar.G)) {
            this.c.a(4, "empty url or empty renderType.");
        } else {
            m6.a(this.a, pVar, this.b, this.c);
        }
    }
}
