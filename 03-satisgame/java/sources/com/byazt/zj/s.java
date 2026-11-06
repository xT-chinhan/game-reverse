package com.byazt.zj;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.fvm.x;
import com.byazt.fz.d;
import com.byazt.he.q;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, TTAdConstant.IMAGE_LIST_SIZE_CODE, 8})
public class s extends com.byazt.suf.n {
    public com.byazt.gl.s n;

    public s(com.byazt.gl.s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.suf.n
    public String n() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.n();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public String qg() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.n();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public String s() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.qg();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public String q() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.s();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public String l() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.q();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public double w() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.l();
        }
        return 0.0d;
    }

    @Override // com.byazt.suf.n
    public List<String> x() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.w();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public String fs() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.x();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public int rv() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.fs();
        }
        return 0;
    }

    @Override // com.byazt.suf.n
    public int tj() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.rv();
        }
        return 0;
    }

    @Override // com.byazt.suf.n
    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, q qVar) {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            sVar.n(activity, viewGroup, list, list2, list3, d.n(qVar));
        }
    }

    @Override // com.byazt.suf.n
    public com.byazt.suf.q cp() {
        com.byazt.gl.s sVar = this.n;
        if (sVar == null || sVar.tj() == null) {
            return null;
        }
        return new qg(this.n.tj());
    }

    @Override // com.byazt.suf.n
    public boolean d() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.cp();
        }
        return false;
    }

    @Override // com.byazt.suf.n
    public com.byazt.suf.s n(Activity activity) {
        if (activity == null || this.n == null) {
            return null;
        }
        return new n(activity, null, this.n);
    }

    @Override // com.byazt.suf.n
    public com.byazt.suf.s n(Activity activity, Map<String, Object> map) {
        if (activity == null || map == null || this.n == null) {
            return null;
        }
        return new n(activity, map, this.n);
    }

    @Override // com.byazt.suf.n
    public void n(Activity activity, com.byazt.lr.n nVar) {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            sVar.n(activity, nVar);
        }
    }

    @Override // com.byazt.suf.n
    public void n(Dialog dialog, Integer[] numArr) {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            sVar.n(dialog, numArr);
        }
    }

    @Override // com.byazt.suf.n
    public x qg(Activity activity) {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.qg(activity);
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public x qg(Dialog dialog, Integer[] numArr) {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.qg(dialog, numArr);
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public com.byazt.fvm.q oa() {
        com.byazt.gl.s sVar = this.n;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }
}
