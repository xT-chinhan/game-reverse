package com.byazt.lbp;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, 8})
public class s implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "cancel_event", qg = "ALL")
    public String fs;

    @com.byazt.phr.n(n = "app_manage_model", qg = "ALL")
    public String l;

    @com.byazt.phr.n(n = "context", qg = "ALL")
    public Context n;

    @com.byazt.phr.n(n = "permission_popup_listener", qg = "ALL")
    public com.byazt.okk.n.InterfaceC0282n q;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk qg;

    @com.byazt.phr.n(n = MediationConstant.EXTRA_ADID, qg = "ALL")
    public String s;

    @com.byazt.phr.n(n = "confirm_event", qg = "ALL")
    public String w;

    @com.byazt.phr.n(n = "deny_event", qg = "ALL")
    public String x;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        com.byazt.okk.n.n(this.s, n());
        TTDelegateActivity.n(this.n, this.s, this.l);
        nVar.n(map2);
        return true;
    }

    private com.byazt.okk.n.InterfaceC0282n n() {
        return new com.byazt.okk.n.InterfaceC0282n() { // from class: com.byazt.lbp.s.1
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                if (s.this.q == null) {
                    return;
                }
                s.this.q.n();
                s sVar = s.this;
                sVar.n(sVar.w);
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
                if (s.this.q == null) {
                    return;
                }
                s.this.q.qg();
                s sVar = s.this;
                sVar.n(sVar.x);
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
                if (s.this.q == null) {
                    return;
                }
                s.this.q.s();
                s sVar = s.this;
                sVar.n(sVar.fs);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (this.qg == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("material_meta", this.qg);
        map.put("context", this.n);
        com.byazt.ukb.qg.n(str, this.qg.pv(), map);
    }
}
