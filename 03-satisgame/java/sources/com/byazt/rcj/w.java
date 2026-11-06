package com.byazt.rcj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.byazt.gct.pk;
import com.byazt.llp.cp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 104, 13})
public class w implements com.byazt.wj.n {
    public cp fs;
    public int l;
    public com.byazt.wj.n n;
    public String q;
    public Context qg;
    public Map<String, Object> rv;
    public String s;
    public View w;
    public Map<String, Object> x;

    public static boolean n(int i) {
        switch (i) {
            case 101:
            case 102:
            case 103:
            case 104:
                return true;
            default:
                return false;
        }
    }

    public w(cp cpVar, Context context, String str, String str2, Map<String, Object> map) {
        this.fs = cpVar;
        this.qg = context;
        this.s = str;
        this.q = str2;
        this.rv = map;
        qg();
    }

    @Override // com.byazt.wj.n
    public boolean n(Map<String, Object> map) {
        boolean zN = n();
        qg();
        if (zN) {
            pk pkVarS = s();
            if (pkVarS != null && pkVarS.hy()) {
                com.byazt.gwu.l lVarS = com.byazt.ikv.n.s();
                lVarS.n("save_jump_saas_success_time", System.currentTimeMillis());
                lVarS.n("save_saas_success_materialmeta", pkVarS.pv().toString());
            }
            return true;
        }
        HashMap map2 = new HashMap(2);
        map2.put("event_tag", this.s);
        if (!TextUtils.isEmpty(this.q)) {
            map2.put("dpa_tag", this.q);
        }
        map2.put("material_meta", s());
        int iN = com.byazt.wq.qg.n().n(this.qg, this.fs, map2) & 255;
        s(iN);
        if (iN == 0) {
            return true;
        }
        com.byazt.wj.n nVar = this.n;
        return nVar != null && nVar.n(map);
    }

    private boolean n() {
        if (this.l < 2) {
            return false;
        }
        HashMap map = new HashMap(2);
        if (n(this.l)) {
            map.put("live_saas_param_interaction_type", Integer.valueOf(this.l));
        }
        if (this.rv.containsKey("saas_status_while_click")) {
            map.put("saas_status_while_click", this.rv.get("saas_status_while_click"));
        }
        map.put("event_tag", this.s);
        String str = this.q;
        if (str != null) {
            map.put("dpa_tag", str);
        }
        map.put("material_meta", s());
        if (this.x == null) {
            this.x = new HashMap();
        }
        com.byazt.wq.qg.n().n(this.w, this.fs.cp(), map, this.x);
        int iN = com.byazt.wq.qg.n().n(this.qg, this.fs, map);
        int i = iN & 255;
        int i2 = (iN & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (i2 > 0) {
            this.x.put("click_saas_action", Integer.valueOf(i2));
        }
        return i == 0;
    }

    public void qg(Map<String, Object> map) {
        this.x = map;
    }

    private void qg() {
        cp cpVar = this.fs;
        if (cpVar != null) {
            this.l = cpVar.l();
        } else {
            this.l = -1;
        }
    }

    public void qg(int i) {
        this.l = i;
    }

    public void n(View view) {
        this.w = view;
    }

    private pk s() {
        return com.byazt.ukb.qg.n(this.fs, this.rv);
    }

    private void s(int i) {
        com.byazt.wr.q qVar;
        if (i == 0) {
            qVar = com.byazt.wr.q.s;
        } else if (i == 1) {
            qVar = com.byazt.wr.q.l;
        } else if (i == 3) {
            qVar = com.byazt.wr.q.x;
        } else if (i == 4) {
            qVar = com.byazt.wr.q.w;
        } else {
            qVar = com.byazt.wr.q.q;
        }
        com.byazt.ukb.qg.n(this.rv, qVar);
    }
}
