package com.byazt.dj;

import android.view.View;
import com.byazt.gct.tj;
import com.byazt.ys.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1976, 8})
public class s {
    public final l fs;
    public volatile int l;
    public View q;
    public tj s;
    public List<n> n = new ArrayList();
    public Map<String, Object> qg = new HashMap();
    public volatile int w = 0;
    public long x = -1;

    public s(l lVar) {
        this.fs = lVar;
    }

    public long n() {
        return this.x;
    }

    public void n(View view) {
        this.q = view;
    }

    public void n(n nVar) {
        this.n.add(nVar);
    }

    public void n(tj tjVar) {
        this.s = tjVar;
        Iterator<n> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().n(this.s);
        }
    }

    private void s() {
        this.l = 0;
        this.w = 0;
    }

    public void qg() {
        this.x = System.currentTimeMillis();
        ((com.byazt.fq.n) this.fs.n(com.byazt.fq.n.class)).n(false);
        s();
        n(0);
    }

    private void n(int i) {
        int size = this.n.size();
        while (i < size) {
            int i2 = i + 1;
            this.l = i2;
            n nVar = this.n.get(i);
            nVar.n(this.q);
            this.w = nVar.n(this.qg, this);
            if (this.w != 0) {
                if (this.w == 2) {
                    ((com.byazt.fq.n) this.fs.n(com.byazt.fq.n.class)).n(this.qg, this);
                    return;
                }
                return;
            }
            i = i2;
        }
    }

    public <T extends n> T n(Class<T> cls) {
        return (T) this.fs.n(cls);
    }
}
