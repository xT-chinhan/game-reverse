package com.byazt.dr;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.hr.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1091, 37})
public class pr extends RecyclerView.pr<c> {
    public final float hn;
    public final Context pr;
    public final float x;
    public final List<hw> hw = new ArrayList();
    public final List<c> c = new ArrayList();

    public pr(Context context, float f, float f2) {
        this.pr = context;
        this.hn = f;
        this.x = f2;
    }

    public void pr(List<hw> list) {
        this.hw.clear();
        this.hw.addAll(list);
        hn();
    }

    @Override // com.byazt.hr.RecyclerView.pr
    public void pr(c cVar) {
        super.pr(cVar);
        cVar.e();
    }

    @Override // com.byazt.hr.RecyclerView.pr
    /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
    public c pr(ViewGroup viewGroup, int i) {
        c cVar = new c(com.byazt.sdv.c.k(this.pr));
        this.c.add(cVar);
        return cVar;
    }

    @Override // com.byazt.hr.RecyclerView.pr
    public void pr(c cVar, int i) {
        List<hw> list = this.hw;
        cVar.pr(list.get(i % list.size()), (int) this.hn, (int) this.x);
    }

    @Override // com.byazt.hr.RecyclerView.pr
    public int pr() {
        return this.hw.size();
    }

    @Override // com.byazt.hr.RecyclerView.pr
    public long hw(int i) {
        return i;
    }

    public void x() {
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        this.c.clear();
    }
}
