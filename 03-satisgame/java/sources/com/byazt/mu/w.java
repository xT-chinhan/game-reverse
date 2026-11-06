package com.byazt.mu;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hb.fs;
import com.byazt.prf.RecyclerView;
import com.byazt.vh.rv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1123, 13})
public class w extends com.byazt.ih.n<RecyclerView> {
    public List<s> dm;
    public Map<Integer, rv.n> ei;
    public q nk;
    public l o;
    public RecyclerView.rv sq;
    public qg vo;
    public l.s ze;

    public interface qg {
        void n();

        void n(int i, int i2);

        void n(int i, View view, s sVar);

        void n(RecyclerView recyclerView, int i);
    }

    @Override // com.byazt.ih.n
    public com.byazt.ih.n.C0202n fs() {
        return null;
    }

    @Override // com.byazt.ih.s
    public void n(ViewGroup.LayoutParams layoutParams) {
    }

    public w(Context context) {
        super(context);
        this.ei = new HashMap();
    }

    public void n(q qVar) {
        this.nk = qVar;
    }

    @Override // com.byazt.ih.s
    public View n() {
        return new RecyclerView(this.qg);
    }

    @Override // com.byazt.ih.n, com.byazt.ih.s
    public void qg() {
        super.qg();
        l lVar = new l(this.qg, this.rv);
        this.o = lVar;
        lVar.n(this.ry);
        this.o.n(this.ju);
        this.o.n(this.ta);
        this.o.n(this.nk);
        this.o.n(this.ze);
        this.o.n(this.ei);
        this.o.n(this.dm);
        ((RecyclerView) this.l).setLayoutManager(this.sq);
        ((RecyclerView) this.l).setAdapter(this.o);
        ((RecyclerView) this.l).n((RecyclerView.fs) new n((int) fs.n(this.qg, 10.0f)));
        ((RecyclerView) this.l).n((RecyclerView.sz) new com.byazt.mu.qg(new com.byazt.mu.n()) { // from class: com.byazt.mu.w.1
            @Override // com.byazt.mu.qg
            public void n(int i, int i2) {
                if (w.this.vo != null) {
                    w.this.vo.n(i, i2);
                }
            }

            @Override // com.byazt.mu.qg
            public void n(int i, View view) {
                if (w.this.vo == null || i < 0 || w.this.dm == null || i >= w.this.dm.size()) {
                    return;
                }
                w.this.vo.n(i, view, (s) w.this.dm.get(i));
            }

            @Override // com.byazt.mu.qg
            public void qg(RecyclerView recyclerView, int i) {
                if (w.this.vo != null) {
                    w.this.vo.n(recyclerView, i);
                }
            }

            @Override // com.byazt.mu.qg
            public void n() {
                if (w.this.vo != null) {
                    w.this.vo.n();
                }
            }
        });
    }

    public void n(qg qgVar) {
        this.vo = qgVar;
    }

    @Override // com.byazt.ih.s
    public void n(JSONObject jSONObject) {
        super.n(jSONObject);
    }

    public void n(List<s> list) {
        this.dm = list;
    }

    public void qg(List<s> list) {
        if (this.o == null || list == null || list.isEmpty()) {
            return;
        }
        if (this.dm == null) {
            this.dm = new ArrayList();
        }
        int size = this.dm.size();
        this.dm.addAll(list);
        this.o.n(list);
        this.o.n(size, this.dm.size());
    }

    public void n(int i, Object obj) {
        l lVar = this.o;
        if (lVar != null) {
            lVar.n(obj);
            this.o.n(i, obj);
        }
    }

    public void n(l.q qVar) {
        this.o.n(qVar);
    }

    @Override // com.byazt.ih.n
    public void n(com.byazt.ih.s sVar) {
        if (sVar == null) {
            return;
        }
        this.n.add(sVar);
        if (sVar.v() != null) {
            this.ei.put(Integer.valueOf(sVar.v().hashCode()), sVar.ur());
        }
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        if (str.equals("layoutType") && !TextUtils.equals("grid", str2)) {
            this.sq = new com.byazt.prf.w(this.qg);
        }
    }

    @Override // com.byazt.ih.n
    public void n(com.byazt.ih.s sVar, ViewGroup.LayoutParams layoutParams) {
        this.n.add(sVar);
        this.ei.put(Integer.valueOf(sVar.v().hashCode()), sVar.ur());
    }

    @com.byazt.cp.n(n = {0, 1, 1123, 108})
    private static class n extends RecyclerView.fs implements l.n {
        public int n;

        @Override // com.byazt.mu.l.n
        public void V_() {
        }

        @Override // com.byazt.mu.l.n
        public void W_() {
        }

        @Override // com.byazt.mu.l.n
        public View s() {
            return null;
        }

        public n(int i) {
            this.n = i;
        }

        @Override // com.byazt.prf.RecyclerView.fs
        public void n(Rect rect, View view, RecyclerView recyclerView, RecyclerView.py pyVar) {
            super.n(rect, view, recyclerView, pyVar);
            rect.left = this.n;
            rect.right = this.n;
            rect.bottom = this.n;
            if (recyclerView.w(view) == 0) {
                rect.top = this.n;
            }
        }
    }
}
