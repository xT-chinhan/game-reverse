package com.byazt.llk;

import android.content.Context;
import com.byazt.dd.aj;
import com.byazt.dd.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 669, 5})
public class uc {
    public static volatile uc pr = null;
    public pr c;
    public com.byazt.qi.x fw;
    public com.byazt.ch.hn hn;
    public List<com.byazt.ch.hw> hw;
    public com.byazt.tn.pr uc;
    public hw x;
    public com.byazt.ef.pr zo;

    public static uc pr() {
        if (pr == null) {
            synchronized (uc.class) {
                if (pr == null) {
                    pr = new uc();
                }
            }
        }
        return pr;
    }

    private uc() {
    }

    public void pr(Context context, com.byazt.ch.hn hnVar, hw hwVar) {
        this.hn = hnVar;
        this.x = hwVar;
        fw();
    }

    public hw hw() {
        return this.x;
    }

    private void fw() {
        ArrayList arrayList = new ArrayList();
        this.hw = arrayList;
        com.byazt.ch.hn hnVar = this.hn;
        if (hnVar != null) {
            arrayList.addAll(hnVar.pr());
        }
        com.byazt.ch.x.pr(this.hw);
    }

    public void pr(com.byazt.tn.pr prVar) {
        this.uc = prVar;
    }

    public com.byazt.tn.pr hn() {
        return this.uc;
    }

    public void pr(aj ajVar) {
        ArrayList arrayList = new ArrayList(new com.byazt.dd.pr().pr());
        if (ajVar != null) {
            arrayList.addAll(ajVar.pr());
        }
        w.pr(arrayList);
    }

    public void pr(com.byazt.dd.hn hnVar) {
        ArrayList arrayList = new ArrayList(new com.byazt.dd.uc().pr());
        if (hnVar != null) {
            arrayList.addAll(hnVar.pr());
        }
        com.byazt.dd.x.pr(arrayList);
    }

    public pr x() {
        return this.c;
    }

    public void pr(com.byazt.qi.x xVar) {
        this.fw = xVar;
    }

    public com.byazt.qi.x c() {
        return this.fw;
    }

    public void pr(com.byazt.ef.pr prVar) {
        this.zo = prVar;
    }

    public com.byazt.ef.pr uc() {
        return this.zo;
    }
}
