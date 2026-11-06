package com.byazt.ua;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.rb.l;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 958, 26})
public abstract class qg extends com.byazt.gf.q implements com.byazt.nw.n, com.byazt.nw.qg {
    public com.byazt.nw.qg n;
    public boolean qg = false;
    public boolean s = false;

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    @Override // com.byazt.nw.n
    public String n(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2) {
        return null;
    }

    public abstract void qg(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map);

    public qg(com.byazt.nw.qg qgVar) {
        this.n = qgVar;
    }

    @Override // com.byazt.nw.n
    public final void n(final Context context, final com.byazt.dd.qg qgVar, final com.byazt.qn.qg qgVar2, final Map<String, Object> map) {
        if (qgVar != null && (TextUtils.equals(MediationConstant.ADN_MINTEGRAL, qgVar.oa()) || TextUtils.equals("baidu", qgVar.oa()))) {
            l.s(new Runnable() { // from class: com.byazt.ua.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.s(context, qgVar, qgVar2, map);
                }
            });
        } else {
            s(context, qgVar, qgVar2, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map) {
        this.qg = false;
        this.s = false;
        if (com.byazt.vyf.s.cy().sh()) {
            qg(context, qgVar, qgVar2, map);
            n(qgVar);
            return;
        }
        try {
            qg(context, qgVar, qgVar2, map);
            n(qgVar);
        } catch (Throwable th) {
            n(new com.byazt.mj.n(com.byazt.ng.q.n(th)));
        }
    }

    private void n(com.byazt.dd.qg qgVar) {
        if (qgVar != null) {
            com.byazt.bw.s.qg(qgVar.oa(), qgVar.qg(), qgVar.d());
        }
    }

    public void n(com.byazt.sg.s sVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(sVar);
        n(arrayList);
    }

    public void n(List<com.byazt.sg.s> list) {
        if (this.qg) {
            return;
        }
        this.qg = true;
        com.byazt.nw.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(list);
        }
    }

    @Override // com.byazt.nw.qg
    public void n(com.byazt.mj.n nVar) {
        this.s = true;
        if (this.qg) {
            return;
        }
        this.qg = true;
        com.byazt.nw.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(nVar);
        }
    }

    public void n(com.byazt.sg.s sVar, com.byazt.mj.n nVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(sVar);
        n(arrayList, nVar);
    }

    @Override // com.byazt.nw.qg
    public void n(List<com.byazt.sg.s> list, com.byazt.mj.n nVar) {
        com.byazt.nw.qg qgVar;
        if (this.s || (qgVar = this.n) == null) {
            return;
        }
        qgVar.n(list, nVar);
    }

    @Override // com.byazt.nw.qg
    public void n(com.byazt.sg.s sVar, String str) {
        com.byazt.nw.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(sVar, str);
        }
    }

    public boolean n() {
        return this.s;
    }

    public boolean qg() {
        return this.qg;
    }
}
