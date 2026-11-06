package com.byazt.pd;

import android.content.Context;
import android.os.Process;
import com.byazt.qf.fs;
import com.byazt.yw.k;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 24, 8})
public abstract class s {
    public q l;
    public com.byazt.qf.s n;
    public qg q;
    public Context qg;
    public com.byazt.qf.l s = fs.n().s();

    public boolean n() {
        return true;
    }

    public boolean qg() {
        return true;
    }

    public s(com.byazt.qf.s sVar, Context context, qg qgVar, q qVar) {
        this.n = sVar;
        this.qg = context;
        this.q = qgVar;
        this.l = qVar;
    }

    public com.byazt.ub.n n(com.byazt.ub.n nVar) {
        if (nVar == null) {
            nVar = new com.byazt.ub.n();
        }
        qg(nVar);
        l(nVar);
        return nVar;
    }

    public void qg(com.byazt.ub.n nVar) {
        qg qgVar;
        if (qg() && (qgVar = this.q) != null) {
            nVar.n(qgVar);
        }
        nVar.n(fs.w());
        qg qgVar2 = this.q;
        nVar.n("is_background", Boolean.valueOf((qgVar2 == null || !qgVar2.s()) && !com.byazt.yw.n.n(this.qg)));
        nVar.n("pid", Integer.valueOf(Process.myPid()));
        nVar.n("battery", Integer.valueOf(this.l.n()));
        nVar.n(this.s.l());
        nVar.qg(fs.rv());
        nVar.n(fs.tj(), fs.cp());
        nVar.n(this.s.w());
        nVar.n(k.n(this.qg));
        if (n()) {
            q(nVar);
        }
        nVar.n(this.s.q());
        String strX = fs.x();
        if (strX != null) {
            nVar.n("business", strX);
        }
        if (fs.fs()) {
            nVar.n("is_mp", (Object) 1);
        }
        nVar.s(fs.qg().n());
        nVar.n("crash_uuid", UUID.randomUUID().toString());
    }

    public void s(com.byazt.ub.n nVar) {
        Map<String, Object> mapN = fs.n().n();
        if (mapN == null) {
            return;
        }
        if (mapN.containsKey("app_version")) {
            nVar.n("crash_version", mapN.get("app_version"));
        }
        if (mapN.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
            nVar.n("app_version", mapN.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
        }
        if (mapN.containsKey("version_code")) {
            try {
                nVar.n("crash_version_code", Integer.valueOf(Integer.parseInt(mapN.get("version_code").toString())));
            } catch (Exception unused) {
                nVar.n("crash_version_code", mapN.get("version_code"));
            }
        }
        if (mapN.containsKey("update_version_code")) {
            try {
                nVar.n("crash_update_version_code", Integer.valueOf(Integer.parseInt(mapN.get("update_version_code").toString())));
            } catch (Exception unused2) {
                nVar.n("crash_update_version_code", mapN.get("update_version_code"));
            }
        }
    }

    private void l(com.byazt.ub.n nVar) {
        List<com.byazt.qf.n> listN = fs.qg().n(this.n);
        if (listN != null) {
            JSONObject jSONObject = new JSONObject();
            Iterator<com.byazt.qf.n> it = listN.iterator();
            while (it.hasNext()) {
                Map<? extends String, ? extends String> mapN = it.next().n(this.n);
                if (mapN != null) {
                    try {
                        for (String str : mapN.keySet()) {
                            jSONObject.put(str, mapN.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            nVar.n("custom", jSONObject);
        }
    }

    public void q(com.byazt.ub.n nVar) {
        nVar.qg(com.byazt.qi.q.n(fs.l().q(), fs.l().l()));
    }
}
