package com.byazt.ys;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.gct.pk;
import com.byazt.gct.tj;
import com.byazt.gct.wm;
import com.byazt.jmk.k;
import com.byazt.udb.cp;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 122, 8})
public class s extends l implements com.byazt.xnr.n, q {
    public k cp;
    public int d;
    public volatile boolean l;
    public cp n;
    public WeakReference<ViewGroup> q;
    public boolean qg;
    public pk s;
    public View tj;

    @Override // com.byazt.xnr.n
    public void n(cp cpVar) {
        this.n = cpVar;
    }

    @Override // com.byazt.xnr.n
    public void n(boolean z, k kVar) {
        this.l = true;
        this.qg = z;
        this.cp = kVar;
        WeakReference<ViewGroup> weakReference = this.q;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.byazt.cd.qg.n(this.q, this);
    }

    @Override // com.byazt.xnr.n
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.d = jSONObject.optInt("convertActionType", Integer.MIN_VALUE);
    }

    public s(pk pkVar, WeakReference<ViewGroup> weakReference) {
        super(null);
        this.l = false;
        this.d = Integer.MIN_VALUE;
        this.s = pkVar;
        this.q = weakReference;
    }

    @Override // com.byazt.xnr.n
    public void n(View view) {
        this.x.qg(view);
    }

    @Override // com.byazt.xnr.n
    public void qg(View view) {
        this.x.n(view);
    }

    @Override // com.byazt.ys.l
    public void n(View view, tj tjVar) {
        this.tj = view;
        if (this.l) {
            this.l = false;
        } else {
            s(view);
        }
    }

    private void s(View view) {
        try {
            n(view, ((Integer) view.getTag()).intValue());
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        } catch (Exception e2) {
            com.byazt.tk.k.qg("DynamicClickListener", e2.getMessage());
        }
    }

    private void n(View view, int i) {
        CharSequence text;
        if (this.n != null) {
            if (this.qg && this.s != null) {
                com.byazt.wif.w.q = true;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            View viewTj = this.x.tj();
            if (viewTj != null) {
                int[] iArrN = com.byazt.okk.s.n(viewTj);
                if (iArrN != null) {
                    iArr = iArrN;
                }
                int[] iArrS = com.byazt.okk.s.s(viewTj);
                if (iArrS != null) {
                    iArr2 = iArrS;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null && text.toString().contains("下载")) {
                    jSONObject.put("is_compliant_download", true);
                }
                jSONObject.putOpt("convertActionType", Integer.valueOf(this.d));
            } catch (Throwable unused) {
            }
            this.n.n(view, i, new wm.n().q(this.x.cd()).s(this.x.um()).qg(this.x.a()).n(this.x.py()).qg(this.x.cy()).n(this.x.hd()).n(iArr[0]).qg(iArr[1]).s(iArr2[0]).q(iArr2[1]).n(q(view)).s(String.valueOf(i)).qg(String.valueOf(view.getTag(2097610714))).n(String.valueOf(view.getTag(2097610715))).q(String.valueOf(view.getTag(2097610713))).n(this.x.rv()).n(jSONObject).n(this.x.sz()).n(), -1);
        }
    }

    private JSONObject q(View view) {
        return new JSONObject();
    }

    private void qg() {
        WeakReference<ViewGroup> weakReference = this.q;
        if (weakReference == null || weakReference.get() == null || !com.byazt.cd.qg.n(this.q.get())) {
            return;
        }
        this.d = 1;
        s(this.tj);
    }

    @Override // com.byazt.ys.q
    public void n() {
        qg();
        this.l = false;
        k kVar = this.cp;
        if (kVar != null) {
            kVar.l();
        }
    }
}
