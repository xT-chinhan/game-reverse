package com.byazt.hv;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 13})
public class hw implements com.byazt.gx.c {
    public List<x> pr = new ArrayList();

    public hw(View view, List<com.byazt.rk.pr> list) {
        Iterator<com.byazt.rk.pr> it = list.iterator();
        while (it.hasNext()) {
            x xVarPr = hn.pr().pr(view, it.next());
            if (xVarPr != null) {
                this.pr.add(xVarPr);
            }
        }
    }

    public void pr() {
        Iterator<x> it = this.pr.iterator();
        while (it.hasNext()) {
            try {
                it.next().hn();
            } catch (Exception e) {
            }
        }
    }

    @Override // com.byazt.gx.c
    public void hw() {
        Iterator<x> it = this.pr.iterator();
        while (it.hasNext()) {
            try {
                it.next().hw();
            } catch (Exception e) {
            }
        }
    }
}
