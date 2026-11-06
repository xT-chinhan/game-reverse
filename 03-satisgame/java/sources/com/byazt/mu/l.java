package com.byazt.mu;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.prf.RecyclerView;
import com.byazt.vh.a;
import com.byazt.vh.cd;
import com.byazt.vh.k;
import com.byazt.vh.rv;
import com.byazt.vh.sz;
import com.byazt.vh.tj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1123, 18})
public class l extends RecyclerView.n<RecyclerView.m> {
    public cd cp;
    public a d;
    public q fs;
    public com.byazt.mu.q l;
    public List<com.byazt.mu.s> n;
    public sz q;
    public Map<Integer, rv.n> qg;
    public boolean rv = true;
    public Context s;
    public tj tj;
    public s w;
    public Object x;

    public interface n {
        void V_();

        void W_();

        View s();
    }

    public interface q {
        void n(RecyclerView.m mVar, int i);
    }

    public interface s {
    }

    public l(Context context, sz szVar) {
        this.s = context;
        this.q = szVar;
    }

    public void n(Map<Integer, rv.n> map) {
        this.qg = map;
    }

    public void n(List<com.byazt.mu.s> list) {
        if (this.n == null) {
            this.n = new ArrayList();
        }
        this.n.addAll(list);
    }

    public void n(com.byazt.mu.q qVar) {
        this.l = qVar;
    }

    public void n(tj tjVar) {
        this.tj = tjVar;
    }

    public void n(cd cdVar) {
        this.cp = cdVar;
    }

    public void n(a aVar) {
        this.d = aVar;
    }

    public void n(s sVar) {
        this.w = sVar;
    }

    @Override // com.byazt.prf.RecyclerView.n
    public RecyclerView.m n(ViewGroup viewGroup, int i) {
        rv.n nVar = this.qg.get(Integer.valueOf(i));
        k kVar = new k(this.s);
        kVar.n((String) null, this.q);
        com.byazt.ih.s<View> sVarN = kVar.n(nVar);
        kVar.n(sVarN);
        if (sVarN != null) {
            sVarN.n(new ViewGroup.LayoutParams(sVarN.an(), sVarN.ae()));
            C0250l c0250l = new C0250l(sVarN.rv());
            c0250l.n((com.byazt.ih.s) sVarN);
            c0250l.n(kVar);
            return c0250l;
        }
        return new qg(new View(this.s));
    }

    public void n(q qVar) {
        this.fs = qVar;
    }

    @Override // com.byazt.prf.RecyclerView.n
    public int n(int i) {
        return this.n.get(i).qg();
    }

    @Override // com.byazt.prf.RecyclerView.n
    public void n(RecyclerView.m mVar, int i, List<Object> list) {
        q qVar;
        if (list == null || list.isEmpty()) {
            n(mVar, i);
            return;
        }
        for (Object obj : list) {
            if (obj != null && this.x != null && TextUtils.equals(obj.toString(), this.x.toString()) && (qVar = this.fs) != null) {
                qVar.n(mVar, i);
            }
        }
    }

    @Override // com.byazt.prf.RecyclerView.n
    public void n(RecyclerView.m mVar, int i) {
        com.byazt.mu.s sVar;
        com.byazt.mu.q qVar;
        if (mVar == null || (sVar = this.n.get(i)) == null || !(mVar instanceof C0250l)) {
            return;
        }
        JSONObject jSONObjectN = sVar.n();
        sz szVar = this.q;
        if (szVar != null) {
            jSONObjectN = szVar.l(jSONObjectN);
        }
        C0250l c0250l = (C0250l) mVar;
        c0250l.hd.n(new ViewGroup.LayoutParams(c0250l.hd.an(), c0250l.hd.ae()));
        n(jSONObjectN, c0250l.t());
        n(this.s, jSONObjectN, c0250l.t());
        if (i == 0 && (qVar = this.l) != null && this.rv) {
            this.rv = false;
            qVar.n(c0250l.hd);
        }
    }

    @Override // com.byazt.prf.RecyclerView.n
    public int n() {
        return this.n.size();
    }

    public void n(Object obj) {
        this.x = obj;
    }

    @com.byazt.cp.n(n = {0, 1, 1123, 120})
    public class qg extends RecyclerView.m {
        public qg(View view) {
            super(view);
        }
    }

    /* JADX INFO: renamed from: com.byazt.mu.l$l, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1123, 1902})
    public class C0250l extends RecyclerView.m implements n {
        public k cd;
        public com.byazt.ih.s hd;

        public C0250l(View view) {
            super(view);
        }

        public void n(com.byazt.ih.s sVar) {
            this.hd = sVar;
        }

        public void n(k kVar) {
            this.cd = kVar;
        }

        public com.byazt.ih.s t() {
            return this.hd;
        }

        @Override // com.byazt.mu.l.n
        public void V_() {
            if (l.this.l != null) {
                l.this.l.qg(this.hd);
            }
        }

        @Override // com.byazt.mu.l.n
        public void W_() {
            if (l.this.l != null) {
                l.this.l.n(this.hd);
            }
        }

        @Override // com.byazt.mu.l.n
        public View s() {
            return this.hd.rv();
        }
    }

    public void n(JSONObject jSONObject, com.byazt.ih.s sVar) {
        if (sVar == null) {
            return;
        }
        if (sVar instanceof com.byazt.ih.n) {
            sVar.n(jSONObject);
            List<com.byazt.ih.s<View>> listX = ((com.byazt.ih.n) sVar).x();
            if (listX == null || listX.size() <= 0) {
                return;
            }
            Iterator<com.byazt.ih.s<View>> it = listX.iterator();
            while (it.hasNext()) {
                n(jSONObject, it.next());
            }
            return;
        }
        sVar.n(jSONObject);
    }

    public void n(Context context, JSONObject jSONObject, com.byazt.ih.s sVar) {
        if (sVar == null) {
            return;
        }
        if (sVar instanceof com.byazt.ih.n) {
            sVar.n(this.tj);
            sVar.n(this.cp);
            sVar.qg(true);
            sVar.qg();
            List<com.byazt.ih.s<View>> listX = ((com.byazt.ih.n) sVar).x();
            if (listX == null || listX.size() <= 0) {
                return;
            }
            Iterator<com.byazt.ih.s<View>> it = listX.iterator();
            while (it.hasNext()) {
                n(context, jSONObject, it.next());
            }
            return;
        }
        JSONObject jSONObjectM = sVar.m();
        Iterator<String> itKeys = jSONObjectM.keys();
        com.byazt.ih.n nVarLh = sVar.lh();
        com.byazt.ih.n.C0202n c0202nFs = nVarLh != null ? nVarLh.fs() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strN = com.byazt.mcb.qg.n(jSONObjectM.optString(next), jSONObject);
            sVar.n(next, strN);
            sVar.n(this.tj);
            sVar.n(this.cp);
            if (c0202nFs != null) {
                c0202nFs.n(context, next, strN);
            }
        }
        sVar.qg(true);
        sVar.qg();
    }
}
