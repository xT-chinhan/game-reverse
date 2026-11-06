package com.byazt.jfs;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, 26})
public class qg implements com.byazt.osr.l {
    public List<q> n = new ArrayList();

    public qg(View view, List<com.byazt.lh.n> list) {
        Iterator<com.byazt.lh.n> it = list.iterator();
        while (it.hasNext()) {
            q qVarN = s.n().n(view, it.next());
            if (qVarN != null) {
                this.n.add(qVarN);
            }
        }
    }

    public void n() {
        Iterator<q> it = this.n.iterator();
        while (it.hasNext()) {
            try {
                it.next().s();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.byazt.osr.l
    public void qg() {
        Iterator<q> it = this.n.iterator();
        while (it.hasNext()) {
            try {
                it.next().qg();
            } catch (Exception unused) {
            }
        }
    }
}
