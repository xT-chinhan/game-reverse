package com.bytedance.embedapplog;

import android.os.Bundle;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class i extends t {
    private static final long[] xr = {60000};
    private long ah;
    private boolean d;

    @Override // com.bytedance.embedapplog.t
    String d() {
        return "s";
    }

    public void ms(boolean z) {
        this.d = z;
    }

    i(b bVar) {
        super(bVar);
        this.d = true;
    }

    @Override // com.bytedance.embedapplog.t
    long ms() {
        long jI = this.f525ms.d().i();
        if (jI > 60000 || jI <= 0) {
            jI = 60000;
        }
        xr[0] = jI;
        return this.ah + jI;
    }

    @Override // com.bytedance.embedapplog.t
    long[] xr() {
        return xr;
    }

    @Override // com.bytedance.embedapplog.t
    public boolean ah() {
        Bundle bundleMs;
        long jCurrentTimeMillis = System.currentTimeMillis();
        w wVarAb = this.f525ms.ab();
        if (wVarAb != null && (bundleMs = wVarAb.ms(jCurrentTimeMillis, 50000L)) != null) {
            ms.ms("play_session", bundleMs, 1);
            ms.xr();
        }
        ti tiVarAh = this.f525ms.ah();
        jw jwVarKa = this.f525ms.ka();
        if (jwVarKa.hi() != 0) {
            JSONObject jSONObjectXr = zd.xr(jwVarKa.ms());
            if (jSONObjectXr != null) {
                ms(tiVarAh.ms(jSONObjectXr));
                this.ah = System.currentTimeMillis();
                return true;
            }
            oh.xr((Throwable) null);
        }
        return false;
    }

    private void ms(ArrayList<zf> arrayList) {
        ti tiVarAh = this.f525ms.ah();
        ArrayList<zf> arrayList2 = new ArrayList<>();
        ArrayList<zf> arrayList3 = new ArrayList<>();
        pc pcVarD = this.f525ms.d();
        ArrayList<zf> arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.addAll(arrayList);
        }
        ArrayList<zf> arrayListMs = tiVarAh.ms();
        if (!arrayListMs.isEmpty()) {
            arrayList4.addAll(arrayListMs);
        }
        if (arrayList4.size() > 0) {
            for (zf zfVar : arrayList4) {
                if (zfVar.sl == null || zfVar.sl.length <= 0) {
                    arrayList2.add(zfVar);
                } else {
                    int iMs = this.d ? am.ms(sa.ms(this.f525ms, this.f525ms.xr(), this.f525ms.ka().ms()), zfVar.sl, pcVarD) : 200;
                    if (am.ms(iMs)) {
                        if (!arrayList.contains(zfVar)) {
                            break;
                        }
                        zfVar.u = iMs;
                        arrayList3.add(zfVar);
                        break;
                    }
                    if (iMs == 200) {
                        arrayList2.add(zfVar);
                    } else {
                        zfVar.u = iMs;
                        arrayList3.add(zfVar);
                    }
                }
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                tiVarAh.ms(arrayList2, arrayList3, arrayList);
            }
            oh.d(d() + " " + arrayList2.size() + " " + arrayList4.size(), null);
        }
    }
}
