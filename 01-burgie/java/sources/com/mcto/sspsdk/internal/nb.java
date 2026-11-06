package com.mcto.sspsdk.internal;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class nb implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ zb c;

    public nb(zb zbVar, int i, int i2) {
        this.c = zbVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        la laVar = this.c.d;
        int i = this.a;
        int i2 = this.b;
        r9.a("ssp_player", laVar.a.k.a + ", onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2, null);
        if (i == -38 || i2 == -38) {
            return;
        }
        int i3 = i == -100 ? 7 : 6;
        zb zbVar = laVar.a.f;
        if (zbVar != null) {
            if (zbVar.f.hasMessages(110)) {
                zbVar.f.removeMessages(110);
            }
            zbVar.c.post(new wb(zbVar));
        }
        pa paVar = laVar.a;
        if (paVar.f != null) {
            int i4 = paVar.q;
            int[] iArr = paVar.r;
            if ((iArr != null && iArr.length > i4) || (i4 == 1 && j.b(6, i3))) {
                laVar.a.e();
                return;
            }
        }
        laVar.a.a = -1;
        HashMap map = new HashMap();
        map.put("pec", String.valueOf(i));
        map.put("pem", String.valueOf(i2));
        l lVarA = l.a();
        p pVar = laVar.a.k;
        lVarA.getClass();
        l.b(i3, pVar, map);
        pa paVar2 = laVar.a;
        paVar2.a(paVar2.a);
    }
}
