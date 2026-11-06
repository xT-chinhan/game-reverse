package com.byazt.ly;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.prf.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 119, 19})
public class n extends RecyclerView.n<l> {
    public final Context n;
    public final float q;
    public final float s;
    public final List<qg> qg = new ArrayList();
    public final List<l> l = new ArrayList();

    @Override // com.byazt.prf.RecyclerView.n
    public long qg(int i) {
        return i;
    }

    public n(Context context, float f, float f2) {
        this.n = context;
        this.s = f;
        this.q = f2;
    }

    public void n(List<qg> list) {
        this.qg.clear();
        this.qg.addAll(list);
        s();
    }

    @Override // com.byazt.prf.RecyclerView.n
    public void n(l lVar) {
        super.n(lVar);
        lVar.an();
    }

    @Override // com.byazt.prf.RecyclerView.n
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public l n(ViewGroup viewGroup, int i) {
        l lVar = new l(com.byazt.cb.qg.d(this.n));
        this.l.add(lVar);
        return lVar;
    }

    @Override // com.byazt.prf.RecyclerView.n
    public void n(l lVar, int i) {
        List<qg> list = this.qg;
        lVar.n(list.get(i % list.size()), (int) this.s, (int) this.q);
    }

    @Override // com.byazt.prf.RecyclerView.n
    public int n() {
        return this.qg.size();
    }

    public void q() {
        Iterator<l> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().an();
        }
        this.l.clear();
    }
}
