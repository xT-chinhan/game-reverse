package com.byazt.ama;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.PointerIconCompat;
import com.byazt.prf.RecyclerView;
import com.byazt.vh.cd;
import com.byazt.vh.k;
import com.byazt.vh.rv;
import com.byazt.vh.sz;
import com.byazt.vh.tj;
import com.byazt.vh.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_TEXT, 8})
public class s extends RecyclerView.n<RecyclerView.m> {
    public cd fs;
    public final Context n;
    public Map<String, rv.n> q;
    public final sz qg;
    public tj x;
    public final List<com.byazt.mu.s> s = new ArrayList();
    public final Map<String, Integer> l = new HashMap();
    public final List<String> w = new ArrayList();
    public int rv = 0;

    public s(Context context, sz szVar) {
        this.n = context;
        this.qg = szVar;
    }

    public void n(Map<String, rv.n> map) {
        this.q = map;
        this.l.clear();
        this.w.clear();
        if (map != null) {
            for (String str : map.keySet()) {
                this.l.put(str, Integer.valueOf(this.w.size()));
                this.w.add(str);
            }
        }
    }

    public void n(tj tjVar) {
        this.x = tjVar;
    }

    public void n(cd cdVar) {
        this.fs = cdVar;
    }

    @Override // com.byazt.prf.RecyclerView.n
    public int n(int i) {
        Integer num = this.l.get(this.s.get(i).s());
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.byazt.prf.RecyclerView.n
    public int n() {
        return this.s.size();
    }

    @Override // com.byazt.prf.RecyclerView.n
    public RecyclerView.m n(ViewGroup viewGroup, int i) {
        Map<String, rv.n> map;
        String str = (i < 0 || i >= this.w.size()) ? null : this.w.get(i);
        rv.n nVar = (str == null || (map = this.q) == null) ? null : map.get(str);
        if (nVar == null) {
            return new n(new View(this.n));
        }
        k kVar = new k(this.n);
        kVar.n((String) null, this.qg);
        com.byazt.ih.s<View> sVarN = kVar.n(nVar);
        kVar.n(this.x);
        kVar.n(this.fs);
        kVar.n(sVarN);
        if (sVarN == null) {
            return new n(new View(this.n));
        }
        sVarN.n(new ViewGroup.LayoutParams(sVarN.an(), sVarN.ae()));
        qg qgVar = new qg(sVarN.rv());
        qgVar.hd = sVarN;
        qgVar.cd = kVar;
        return qgVar;
    }

    @Override // com.byazt.prf.RecyclerView.n
    public void n(RecyclerView.m mVar, int i) {
        if (mVar instanceof qg) {
            qg qgVar = (qg) mVar;
            com.byazt.mu.s sVar = this.s.get(i);
            if (sVar == null || qgVar.hd == null) {
                return;
            }
            n(qgVar);
            qgVar.hd.n(new ViewGroup.LayoutParams(qgVar.hd.an(), qgVar.hd.ae()));
            qgVar.cd.qg(sVar.n());
            qg(qgVar);
        }
    }

    @Override // com.byazt.prf.RecyclerView.n
    public void n(RecyclerView.m mVar, int i, List<Object> list) {
        if (list == null || list.isEmpty()) {
            n(mVar, i);
        } else {
            if (!(mVar instanceof qg) || i >= this.s.size()) {
                return;
            }
            ((qg) mVar).cd.qg(this.s.get(i).n());
        }
    }

    private void n(qg qgVar) {
        n(qgVar.hd);
    }

    private void n(com.byazt.ih.s sVar) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        sVar.n((tj) null);
        sVar.n((cd) null);
        sVar.w();
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            n(it.next());
        }
    }

    private void qg(qg qgVar) {
        if (qgVar == null || qgVar.hd == null) {
            return;
        }
        n(qgVar.hd, qgVar.hd.rv());
    }

    private void n(com.byazt.ih.s sVar, final View view) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        sVar.n(new x() { // from class: com.byazt.ama.s.1
            @Override // com.byazt.vh.x
            public void n() {
            }

            @Override // com.byazt.vh.x
            public void qg(com.byazt.ih.s sVar2, String str) {
            }

            @Override // com.byazt.vh.x
            public void n(com.byazt.ih.s sVar2, String str) {
                View view2 = view;
                if (view2 != null) {
                    view2.post(new Runnable() { // from class: com.byazt.ama.s.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            view.requestLayout();
                        }
                    });
                }
            }
        });
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            n(it.next(), view);
        }
    }

    private static List<com.byazt.mu.s> qg(List<com.byazt.mu.s> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (com.byazt.mu.s sVar : list) {
                if (sVar != null) {
                    arrayList.add(sVar);
                }
            }
        }
        return arrayList;
    }

    public void n(List<com.byazt.mu.s> list) {
        List<com.byazt.mu.s> listQg = qg(list);
        if (listQg.isEmpty()) {
            return;
        }
        this.rv++;
        int size = this.s.size();
        this.s.addAll(listQg);
        qg(size, listQg.size());
    }

    @Override // com.byazt.prf.RecyclerView.n
    public void n(RecyclerView.m mVar) {
        super.n(mVar);
        if (mVar instanceof qg) {
            qg qgVar = (qg) mVar;
            if (qgVar.hd != null) {
                n(qgVar.hd);
                qg(qgVar.hd);
            }
        }
    }

    private void qg(com.byazt.ih.s sVar) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        sVar.n((x) null);
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            qg(it.next());
        }
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_TEXT, 782})
    static class qg extends RecyclerView.m {
        public k cd;
        public com.byazt.ih.s hd;

        public qg(View view) {
            super(view);
        }
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_TEXT, 546})
    static class n extends RecyclerView.m {
        public n(View view) {
            super(view);
        }
    }
}
