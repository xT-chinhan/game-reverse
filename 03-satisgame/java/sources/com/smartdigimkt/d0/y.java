package com.smartdigimkt.d0;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public final String a;
    public final com.smartdigimkt.b3.e b;
    public final com.smartdigimkt.l3.b c;
    public final long d;
    public com.smartdigimkt.l3.a e;
    public final String g;
    public long f = 0;
    public boolean h = false;

    public y(com.smartdigimkt.b3.c cVar, com.smartdigimkt.b3.e eVar, com.smartdigimkt.a3.a aVar, boolean z) {
        com.smartdigimkt.l3.b bVar;
        new AtomicBoolean(false);
        String str = cVar.i;
        this.a = str;
        this.b = eVar;
        com.smartdigimkt.t2.z.a().a(str);
        cVar.e();
        if (cVar instanceof com.smartdigimkt.b3.l) {
        }
        com.smartdigimkt.l3.d dVarA = com.smartdigimkt.l3.d.a();
        dVarA.getClass();
        if (TextUtils.isEmpty(str)) {
            bVar = null;
        } else {
            bVar = (com.smartdigimkt.l3.b) dVarA.a.get(str);
            if (bVar == null) {
                bVar = new com.smartdigimkt.l3.b(str);
                com.smartdigimkt.l3.b bVar2 = (com.smartdigimkt.l3.b) dVarA.a.putIfAbsent(str, bVar);
                if (bVar2 != null) {
                    bVar = bVar2;
                }
            }
        }
        this.c = bVar;
        try {
            com.smartdigimkt.n3.b.a().getClass();
            this.g = aVar.g + "_ " + aVar.f;
        } catch (Throwable unused) {
            this.g = null;
        }
        com.smartdigimkt.l3.b bVar3 = this.c;
        bVar3.i = this.g;
        bVar3.j = MediaFormat.KEY_VIDEO;
        this.d = 0L;
        if (TextUtils.equals(String.valueOf(eVar.a), "4") && eVar.E0 != 1 && eVar.S > 0) {
            this.d = eVar.l;
        }
        int i = eVar.V;
        com.smartdigimkt.l3.b bVar4 = this.c;
        com.smartdigimkt.b3.e eVar2 = this.b;
        bVar4.a(new com.smartdigimkt.l3.c(eVar2.S, eVar2.U, i, this.d));
        com.smartdigimkt.l3.b bVar5 = this.c;
        w wVar = new w(this, cVar, aVar);
        synchronized (bVar5) {
            if (!bVar5.l.contains(wVar)) {
                bVar5.l.add(wVar);
            }
        }
        this.c.m = new x(this, cVar);
    }

    public static void a(y yVar, long j) {
        yVar.getClass();
        try {
            if (yVar.h) {
                return;
            }
            yVar.h = true;
            String str = yVar.g;
            if (str != null && !str.isEmpty()) {
                com.smartdigimkt.n3.b bVarA = com.smartdigimkt.n3.b.a();
                String str2 = yVar.g;
                bVarA.getClass();
                com.smartdigimkt.b3.k kVar = TextUtils.isEmpty(str2) ? null : (com.smartdigimkt.b3.k) bVarA.b.get(str2);
                if (kVar == null) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - yVar.f;
                if (jCurrentTimeMillis < 0) {
                    jCurrentTimeMillis = 0;
                }
                com.smartdigimkt.b3.j jVar = new com.smartdigimkt.b3.j();
                jVar.a = MediaFormat.KEY_VIDEO;
                jVar.b = jCurrentTimeMillis;
                jVar.c = 0L;
                jVar.d = j > 0 ? j / com.anythink.china.a.c.k : 0L;
                kVar.l.add(jVar);
                com.smartdigimkt.l3.b bVar = yVar.c;
                bVar.i = null;
                bVar.j = null;
            }
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        this.f = System.currentTimeMillis();
        com.smartdigimkt.l3.b bVar = this.c;
        synchronized (bVar) {
            if (bVar.d()) {
                bVar.f();
            } else if (bVar.n == 1 && bVar.v) {
                bVar.w = true;
            }
        }
    }
}
