package com.byazt.ou;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.ep.cp;
import com.byazt.gct.g;
import com.byazt.gct.h;
import com.byazt.gct.nf;
import com.byazt.gct.oa;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.rg.EasyPlayableContainer;
import com.byazt.udb.sz;
import com.byazt.vh.ou;
import com.byazt.za.py;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 849, 19})
public class n extends com.byazt.rg.qg implements com.byazt.li.qg {
    public int cp;
    public final com.byazt.rg.l d;
    public com.byazt.zq.qg fs;
    public View l;
    public g q;
    public Context rv;
    public boolean tj;
    public boolean w;
    public com.byazt.gn.w x;

    public com.byazt.li.qg l() {
        return this;
    }

    public void n(ViewGroup viewGroup) {
    }

    public int q() {
        return 2;
    }

    public n(pk pkVar, com.byazt.rg.n nVar, g gVar) {
        super(pkVar, nVar);
        this.w = false;
        this.tj = false;
        this.cp = 0;
        this.d = new com.byazt.rg.l() { // from class: com.byazt.ou.n.1
            @Override // com.byazt.rg.l
            public void n(boolean z) {
            }

            @Override // com.byazt.rg.l
            public void n() {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ou.n.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.tj = true;
                        n.this.cp = 1;
                        if (n.this.x != null) {
                            n.this.x.cd();
                        }
                    }
                });
            }

            @Override // com.byazt.rg.l
            public void w() {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ou.n.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.cp = 2;
                        if (n.this.x != null) {
                            n.this.x.cy();
                        }
                    }
                });
            }

            @Override // com.byazt.rg.l
            public void x() {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ou.n.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.cp = 1;
                        if (n.this.x != null) {
                            n.this.x.hd();
                        }
                    }
                });
            }

            @Override // com.byazt.rg.l
            public void fs() {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ou.n.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.cp = 3;
                        if (n.this.x != null) {
                            n.this.x.k();
                        }
                    }
                });
            }

            @Override // com.byazt.rg.l
            public void n(final long j, final long j2) {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ou.n.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.x != null) {
                            n.this.x.n(j, j2);
                        }
                    }
                });
            }

            @Override // com.byazt.rg.l
            public void qg(boolean z) {
                if (n.this.x != null) {
                    n.this.x.s(z);
                }
            }

            @Override // com.byazt.rg.l
            public void n(int i, long j) {
                if (n.this.x != null) {
                    n.this.x.n(i, j);
                }
            }

            @Override // com.byazt.rg.l
            public void qg() {
                n.this.w = true;
                n.this.tj();
            }

            @Override // com.byazt.rg.l
            public void s() {
                n.this.w = false;
                if (n.this.l != null) {
                    n.this.l.setVisibility(8);
                }
            }

            @Override // com.byazt.rg.l
            public void q() {
                if (h.n()) {
                    if (n.this.s != null) {
                        n.this.s.n(n.this.n);
                    }
                    if (n.this.x != null) {
                        n.this.x.s(true);
                    }
                }
            }

            @Override // com.byazt.rg.l
            public void l() {
                n.this.rv();
            }

            @Override // com.byazt.rg.l
            public void n(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("second_page_type", i);
                } catch (JSONException unused) {
                }
                com.byazt.rg.s.n(n.this.n, (oa) n.this.q, false, jSONObject);
                n.this.n(i);
            }
        };
        this.q = gVar;
    }

    public n(pk pkVar, g gVar) {
        this(pkVar, null, gVar);
    }

    public void n(g gVar) {
        this.q = gVar;
    }

    public boolean n(ViewGroup viewGroup, View view) {
        g gVar = this.q;
        if (gVar == null || view == null || viewGroup == null) {
            com.byazt.rg.s.n(this.n, (oa) this.q, false, 5);
            return false;
        }
        if (!gVar.k()) {
            com.byazt.rg.s.n(this.n, (oa) this.q, false, 6);
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
            com.byazt.rg.s.n(this.n, (oa) this.q, false, 1, jSONObject);
            return false;
        }
        if (!com.byazt.rg.q.n(this.n, true)) {
            com.byazt.rg.s.n(this.n, (oa) this.q, false, 2);
            return false;
        }
        if (rv.qg().cp() && Build.VERSION.SDK_INT <= 25) {
            com.byazt.rg.s.n(this.n, (oa) this.q, false, 9);
            return false;
        }
        if (this.q.cp() == 1) {
            com.byazt.rg.s.n(this.n, (oa) this.q, false, 11);
            return false;
        }
        if (this.q.n(view.getWidth(), view.getHeight())) {
            return true;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("view_width", view.getWidth());
            jSONObject2.put("view_height", view.getHeight());
        } catch (JSONException unused2) {
        }
        com.byazt.rg.s.n(this.n, (oa) this.q, false, 10, jSONObject2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(pk pkVar) {
        oa oaVarQg;
        if (pkVar != null && (oaVarQg = qg()) != null) {
            int iN = oaVarQg.n();
            int i = iN == 1 ? 2 : -1;
            if (iN == 3) {
                i = 4;
            }
            if (i != -1) {
                return com.byazt.aci.n.n(i, pkVar);
            }
        }
        return false;
    }

    public void qg(ViewGroup viewGroup, View view) {
        if (!n(viewGroup, view)) {
            com.byazt.de.w.n(com.byazt.de.x.n(this.n), 2);
            n(viewGroup);
        } else {
            s(viewGroup, view);
        }
    }

    private void s(final ViewGroup viewGroup, final View view) {
        g gVar = this.q;
        if (gVar == null) {
            n(viewGroup);
        } else {
            cp.n(this.q.oa(), gVar.d(), new com.byazt.ep.s() { // from class: com.byazt.ou.n.2
                @Override // com.byazt.ep.s
                public void n(String str) {
                    if (str != null) {
                        try {
                            if (str.contains("Lottie")) {
                                n nVar = n.this;
                                if (nVar.n(nVar.n)) {
                                    com.byazt.de.w.n(com.byazt.de.x.n(n.this.n), 2);
                                    com.byazt.rg.s.n(n.this.n, (oa) n.this.q, false, 12);
                                    n.this.n(viewGroup);
                                    return;
                                }
                            }
                        } catch (JSONException unused) {
                            com.byazt.de.w.n(com.byazt.de.x.n(n.this.n), 2);
                            com.byazt.rg.s.n(n.this.n, (oa) n.this.q, false, 3);
                            n.this.n(viewGroup);
                            return;
                        }
                    }
                    com.byazt.de.w.n(com.byazt.de.x.n(n.this.n), 1);
                    com.byazt.rg.s.n(n.this.n, (oa) n.this.q, true);
                    n.this.n(new JSONObject(str), viewGroup, view);
                }

                @Override // com.byazt.ep.s
                public void n() {
                    com.byazt.de.w.n(com.byazt.de.x.n(n.this.n), 2);
                    com.byazt.rg.s.n(n.this.n, (oa) n.this.q, false, 4);
                    n.this.n(viewGroup);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final JSONObject jSONObject, final ViewGroup viewGroup, final View view) {
        viewGroup.post(new Runnable() { // from class: com.byazt.ou.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.n == null || n.this.q == null) {
                    com.byazt.rg.s.n(n.this.n, (oa) n.this.q, false, 100, "materialMeta or ugenComponent is null");
                    n.this.n(viewGroup);
                    return;
                }
                int iS = n.this.q.s();
                com.byazt.gn.s sVarN = n.this.n(view, n.this.n(iS, jSONObject, view));
                n.this.fs();
                n nVar = n.this;
                nVar.x = nVar.n(iS, sVarN, viewGroup);
                n.this.cp();
                final int i = iS != 3 ? 2 : 3;
                com.byazt.de.w.n().n(com.byazt.de.x.n(n.this.n), new com.byazt.bok.qg.n() { // from class: com.byazt.ou.n.3.1
                    @Override // com.byazt.bok.qg.n
                    public void n(com.byazt.wea.fs fsVar) {
                        if (fsVar instanceof com.byazt.wea.rv) {
                            ((com.byazt.wea.rv) fsVar).tj = i;
                        }
                    }
                });
                com.byazt.de.w.s(com.byazt.de.x.n(n.this.n));
                com.byazt.rg.s.qg(n.this.n, n.this.q);
                n.this.x.n(new com.byazt.udb.x() { // from class: com.byazt.ou.n.3.2
                    @Override // com.byazt.udb.x
                    public void n(View view2, sz szVar) {
                        n.this.n(view2, viewGroup, view, szVar);
                    }

                    @Override // com.byazt.udb.x
                    public void n(int i2, String str) {
                        if (n.this.qg != null) {
                            n.this.qg.n(viewGroup);
                        }
                        com.byazt.de.w.qg(com.byazt.de.x.n(n.this.n), 2);
                        com.byazt.rg.s.n(n.this.n, (oa) n.this.q, false, i2, str);
                        n.this.n(viewGroup);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject n(int i, JSONObject jSONObject, View view) {
        if (i != 3) {
            return jSONObject;
        }
        return com.byazt.ns.qg.n(this.n, com.byazt.ns.qg.n(view), jSONObject, oa(), null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gn.s n(View view, JSONObject jSONObject) {
        com.byazt.gn.s.n nVar = new com.byazt.gn.s.n();
        nVar.l(cp.n(this.n, view, oa()));
        nVar.n(jSONObject);
        nVar.n((ou) new py());
        nVar.qg(view.getHeight());
        nVar.n(view.getWidth());
        nVar.n(com.byazt.vyf.s.cy().q());
        nVar.tj(this.n.v());
        nVar.cp(q());
        int iD = com.byazt.vgx.w.d(this.n);
        if (iD == 3 || iD == 4) {
            nVar.w(com.byazt.ql.qg.l());
        }
        return nVar.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gn.w n(int i, com.byazt.gn.s sVar, ViewGroup viewGroup) {
        if (i == 3) {
            return new com.byazt.gn.fs(rv.getContext(), this.n, sVar, viewGroup);
        }
        return new com.byazt.gn.w(rv.getContext(), this.n, sVar, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp() {
        this.x.n(this.d);
        this.x.n(this.qg);
        this.x.n(l());
        this.x.n(new com.byazt.udb.fs() { // from class: com.byazt.ou.n.4
            @Override // com.byazt.udb.fs
            public void n(View view, int i, com.byazt.twc.s sVar, int i2) {
                com.byazt.de.w.q(com.byazt.de.x.n(n.this.n));
                if (n.this.qg != null) {
                    n.this.qg.n(view, i, sVar, n.this.q);
                }
            }

            @Override // com.byazt.udb.fs
            public void qg(View view, int i, com.byazt.twc.s sVar, int i2) {
                com.byazt.de.w.q(com.byazt.de.x.n(n.this.n));
                if (n.this.qg != null) {
                    n.this.qg.n(view, i, sVar, n.this.q);
                }
            }
        });
        this.x.n(new com.byazt.rg.w() { // from class: com.byazt.ou.n.5
            @Override // com.byazt.rg.w
            public void n() {
                com.byazt.de.w.q(com.byazt.de.x.n(n.this.n), 1);
                n.this.rv();
            }
        });
        d();
    }

    private void d() {
        com.byazt.gn.w wVar = this.x;
        if (wVar == null || !this.tj) {
            return;
        }
        wVar.cd();
        int i = this.cp;
        if (i == 2) {
            this.x.cy();
        } else if (i == 3) {
            this.x.k();
        }
    }

    @Override // com.byazt.li.qg
    public boolean n(String str, com.byazt.ih.s sVar, com.byazt.li.s sVar2) {
        str.hashCode();
        if (!str.equals("closeWidget")) {
            return false;
        }
        rv();
        return true;
    }

    @Override // com.byazt.li.qg
    public void n(String str) {
        str.hashCode();
        if (str.equals("clickEvent") || str.equals("convert")) {
            com.byazt.rg.s.n(this.n, (oa) this.q, false, (JSONObject) null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, ViewGroup viewGroup, View view2, sz szVar) {
        if (view == null) {
            n(viewGroup);
            com.byazt.de.w.qg(com.byazt.de.x.n(this.n), 2);
            com.byazt.rg.s.n(this.n, (oa) this.q, false, 101, "renderView is null");
            return;
        }
        com.byazt.de.w.qg(com.byazt.de.x.n(this.n), 1);
        com.byazt.rg.s.qg(this.n, this.q, true);
        this.l = view;
        view.setVisibility(8);
        if (!n(view)) {
            n(viewGroup);
            com.byazt.de.w.s(com.byazt.de.x.n(this.n), 2);
            com.byazt.rg.s.qg(this.n, this.q, false, 103, new JSONObject());
        } else {
            View view3 = this.l;
            com.byazt.gn.w wVar = this.x;
            n(viewGroup, view2, view3, wVar != null ? wVar.l() : null, szVar);
            tj();
        }
    }

    public void n(ViewGroup viewGroup, View view, View view2, float[] fArr, sz szVar) {
        n(viewGroup, view, view2, fArr);
    }

    private boolean n(View view) {
        View childAt;
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() <= 0) {
            return false;
        }
        View childAt2 = viewGroup.getChildAt(0);
        if ((this.x instanceof com.byazt.gn.fs) && childAt2 != null) {
            ViewGroup viewGroup2 = (ViewGroup) childAt2;
            if (viewGroup2.getChildCount() <= 0 || (childAt = viewGroup2.getChildAt(0)) == null || childAt.getVisibility() != 0) {
                return false;
            }
        } else if (childAt2 == null || childAt2.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void w() {
        final View view = this.l;
        if (view == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            qg(view);
        } else {
            view.post(new Runnable() { // from class: com.byazt.ou.n.6
                @Override // java.lang.Runnable
                public void run() {
                    n.this.qg(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void qg(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(4);
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).removeAllViews();
        }
        ViewParent parent = view.getParent();
        if (parent instanceof EasyPlayableContainer) {
            ViewParent parent2 = parent.getParent();
            ((ViewGroup) parent).removeView(view);
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView((View) parent);
                return;
            }
            return;
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public void x() {
        rv();
        this.l = null;
        fs();
    }

    public void fs() {
        com.byazt.gn.w wVar = this.x;
        if (wVar != null) {
            wVar.n((com.byazt.rg.l) null);
            this.x.n((com.byazt.udb.fs) null);
            this.x.n((com.byazt.rg.w) null);
            this.x.n(true);
            this.x = null;
        }
    }

    @Override // com.byazt.rg.qg
    public oa qg() {
        return this.q;
    }

    @Override // com.byazt.rg.qg
    public com.byazt.rg.l n() {
        return this.d;
    }

    public void rv() {
        w();
        com.byazt.de.w.q(com.byazt.de.x.n(this.n), 1);
        if (this.s != null) {
            this.s.l();
        }
    }

    public void tj() {
        View view = this.l;
        if (view != null && this.w) {
            view.setVisibility(0);
        }
        this.d.qg(true);
    }

    private boolean oa() {
        return nf.n(this.n) == 1;
    }

    public void n(com.byazt.zq.qg qgVar) {
        this.fs = qgVar;
    }

    public void n(Context context) {
        this.rv = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i) {
        new com.byazt.pnj.n(this.n, this.rv).n(i, this.fs);
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.de.w.q(com.byazt.de.x.n(this.n), 2);
    }
}
