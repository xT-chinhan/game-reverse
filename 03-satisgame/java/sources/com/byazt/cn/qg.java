package com.byazt.cn;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.fl.l;
import com.byazt.fl.q;
import com.byazt.fl.w;
import com.byazt.fl.x;
import com.byazt.fz.d;
import com.byazt.fz.tj;
import com.byazt.jp.k;
import com.byazt.sg.s;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 750, 26})
public class qg extends s {
    public l cd;
    public com.byazt.lr.n cp;
    public x cy;
    public q d;
    public com.byazt.fl.qg hd;
    public com.byazt.fl.s k;
    public k oa;
    public w sz;
    public com.byazt.xo.n tj;

    @Override // com.byazt.sg.s
    public void cp() {
    }

    @Override // com.byazt.sg.s
    public boolean l() {
        return false;
    }

    @Override // com.byazt.sg.s
    public void n() {
    }

    @Override // com.byazt.sg.s
    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, d dVar, List<View> list4) {
    }

    @Override // com.byazt.sg.s
    public void qg() {
    }

    @Override // com.byazt.sg.s
    public void s() {
    }

    @Override // com.byazt.sg.s
    public int q() {
        l lVar = this.cd;
        if (lVar != null) {
            return lVar.n();
        }
        return -1;
    }

    @Override // com.byazt.sg.s
    public final Integer w() {
        x xVar = this.cy;
        if (xVar != null) {
            return xVar.n();
        }
        com.byazt.xo.n nVar = this.tj;
        if (nVar != null) {
            return nVar.s();
        }
        return super.w();
    }

    @Override // com.byazt.sg.s
    public String x() {
        com.byazt.fl.qg qgVar = this.hd;
        if (qgVar != null) {
            return qgVar.n();
        }
        return null;
    }

    @Override // com.byazt.sg.s
    public com.byazt.fz.l fs() {
        com.byazt.fl.qg qgVar = this.hd;
        if (qgVar != null) {
            return qgVar.qg();
        }
        return null;
    }

    @Override // com.byazt.sg.s
    public View rv() {
        com.byazt.xo.n nVar = this.tj;
        if (nVar != null && (nVar instanceof com.byazt.ik.n)) {
            return ((com.byazt.ik.n) nVar).n();
        }
        w wVar = this.sz;
        if (wVar != null) {
            return wVar.n();
        }
        return null;
    }

    @Override // com.byazt.sg.s
    public View tj() {
        com.byazt.fl.qg qgVar = this.hd;
        if (qgVar != null) {
            return qgVar.s();
        }
        return super.tj();
    }

    @Override // com.byazt.sg.s
    public void n(Activity activity, Object obj, String str) {
        com.byazt.xo.n nVar = this.tj;
        if (nVar == null || !(nVar instanceof com.byazt.xo.qg)) {
            return;
        }
        ((com.byazt.xo.qg) nVar).n(activity);
    }

    @Override // com.byazt.sg.s
    public void n(ViewGroup viewGroup) {
        com.byazt.xo.n nVar = this.tj;
        if (nVar == null || !(nVar instanceof com.byazt.od.n)) {
            return;
        }
        ((com.byazt.od.n) nVar).n(viewGroup);
    }

    @Override // com.byazt.sg.s
    public com.byazt.fz.qg d() {
        return this.n;
    }

    @Override // com.byazt.sg.s
    public tj oa() {
        return this.qg;
    }

    @Override // com.byazt.sg.s
    public com.byazt.kv.qg sz() {
        return this.s;
    }

    @Override // com.byazt.sg.s
    public com.byazt.us.n k() {
        return this.fs;
    }

    @Override // com.byazt.sg.s
    public void cy() {
        super.cy();
    }

    @Override // com.byazt.sg.s
    public void hd() {
        super.hd();
    }

    @Override // com.byazt.sg.s
    public void cd() {
        super.cd();
    }

    @Override // com.byazt.sg.s
    public void n(Activity activity, com.byazt.lr.n nVar) {
        this.cp = nVar;
    }

    @Override // com.byazt.sg.s
    public com.byazt.lr.n um() {
        return this.cp;
    }

    @Override // com.byazt.sg.s
    public boolean a() {
        try {
            com.byazt.fl.s sVar = this.k;
            if (sVar != null) {
                return sVar.n();
            }
        } catch (Exception unused) {
        }
        return super.a();
    }

    @Override // com.byazt.sg.s
    public void n(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        try {
            Object obj = map.get("bidding_lose_reason_NUM");
            if (obj instanceof Integer) {
                ((Integer) obj).intValue();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.sg.s
    public void qg(Map<String, Object> map) {
        if (this.tj != null) {
            ta();
        }
        if (this.oa != null) {
            ta();
        }
    }

    @Override // com.byazt.sg.s
    public com.byazt.fvm.x n(Activity activity) {
        q qVar = this.d;
        if (qVar != null) {
            return qVar.n(activity);
        }
        return super.n(activity);
    }
}
