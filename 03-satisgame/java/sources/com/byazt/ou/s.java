package com.byazt.ou;

import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.h;
import com.byazt.gct.oa;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.rg.PlayableFeedWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 849, 8})
public class s extends com.byazt.rg.qg {
    public final com.byazt.rg.l l;
    public PlayableFeedWebView q;

    public s(pk pkVar, com.byazt.rg.n nVar) {
        super(pkVar, nVar);
        this.l = new com.byazt.rg.l() { // from class: com.byazt.ou.s.1
            @Override // com.byazt.rg.l
            public void fs() {
            }

            @Override // com.byazt.rg.l
            public void l() {
            }

            @Override // com.byazt.rg.l
            public void n(int i) {
            }

            @Override // com.byazt.rg.l
            public void n(int i, long j) {
            }

            @Override // com.byazt.rg.l
            public void n(long j, long j2) {
            }

            @Override // com.byazt.rg.l
            public void qg(boolean z) {
            }

            @Override // com.byazt.rg.l
            public void w() {
            }

            @Override // com.byazt.rg.l
            public void x() {
            }

            @Override // com.byazt.rg.l
            public void n() {
                if (s.this.q != null) {
                    s.this.q.w();
                }
            }

            @Override // com.byazt.rg.l
            public void n(boolean z) {
                if (s.this.q != null) {
                    s.this.q.qg(z);
                }
            }

            @Override // com.byazt.rg.l
            public void qg() {
                if (s.this.q != null) {
                    s.this.q.x();
                }
            }

            @Override // com.byazt.rg.l
            public void s() {
                if (s.this.q != null) {
                    s.this.q.fs();
                }
            }

            @Override // com.byazt.rg.l
            public void q() {
                if (h.n() && s.this.s != null) {
                    s.this.s.n(s.this.n);
                }
            }
        };
        this.s = new com.byazt.whi.n(pkVar, qg());
    }

    public boolean n(ViewGroup viewGroup, View view) {
        if (qg() == null || view == null || viewGroup == null) {
            com.byazt.rg.s.n(this.n, qg(), false, 5);
            return false;
        }
        if (!h.q(this.n)) {
            com.byazt.rg.s.n(this.n, qg(), false, 6);
            return false;
        }
        if (com.byazt.rg.q.n(viewGroup)) {
            String name = viewGroup.getClass().getName();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("container_name", name);
                jSONObject.put("enable_layout_restrict", rv.qg().ed());
            } catch (JSONException unused) {
            }
            com.byazt.rg.s.n(this.n, qg(), false, 1, jSONObject);
            return false;
        }
        if (com.byazt.rg.q.n(this.n, false)) {
            return true;
        }
        com.byazt.rg.s.n(this.n, qg(), false, 2);
        return false;
    }

    public void qg(final ViewGroup viewGroup, final View view) {
        if (!n(viewGroup, view)) {
            com.byazt.de.w.n(com.byazt.de.x.n(this.n), 2);
            if (this.s != null) {
                this.s.qg(null);
                return;
            }
            return;
        }
        com.byazt.de.w.n(com.byazt.de.x.n(this.n), 1);
        com.byazt.rg.s.n(this.n, qg(), true);
        this.q = new PlayableFeedWebView(this.s, viewGroup);
        this.s.n(this.q);
        this.q.setMaterialMeta(com.byazt.cd.s.n(this.n));
        this.q.setEasyPlayableListener(this.qg);
        viewGroup.post(new Runnable() { // from class: com.byazt.ou.s.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rg.s.qg(s.this.n, s.this.qg(), true);
                s sVar = s.this;
                sVar.n(viewGroup, view, sVar.q, (float[]) null);
            }
        });
    }

    public void q() {
        PlayableFeedWebView playableFeedWebView = this.q;
        if (playableFeedWebView != null) {
            playableFeedWebView.destroy();
        }
        if (this.s != null) {
            this.s.l();
        }
    }

    @Override // com.byazt.rg.qg
    public oa qg() {
        return h.rv(this.n);
    }

    @Override // com.byazt.rg.qg
    public com.byazt.rg.l n() {
        return this.l;
    }
}
