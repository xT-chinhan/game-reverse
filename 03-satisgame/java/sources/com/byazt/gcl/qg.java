package com.byazt.gcl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.gct.tj;
import com.byazt.gct.wm;
import com.byazt.iz.fs;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.za.w;
import com.byazt.za.x;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 61, 26})
public class qg {
    public w l;
    public final Context n;
    public x q;
    public final pk qg;
    public ITTInnerDownloadAdapter s;
    public View w;
    public String x;

    public qg(Context context, pk pkVar, View view, String str) {
        this.x = "rewarded_video";
        this.qg = pkVar;
        this.n = context;
        this.w = view;
        if (TextUtils.isEmpty(str)) {
            this.x = com.byazt.vgx.w.qg(com.byazt.vgx.w.d(pkVar));
        } else {
            this.x = str;
        }
        if (pkVar.rv() == 4) {
            this.s = fs.n(context, pkVar, this.x);
        }
        String str2 = this.x;
        x xVar = new x(context, pkVar, str2, com.byazt.vgx.w.q(str2));
        this.q = xVar;
        xVar.n(this.w);
        ((com.byazt.zct.n) this.q.n(com.byazt.zct.n.class)).n(this.s);
        String str3 = this.x;
        w wVar = new w(context, pkVar, str3, com.byazt.vgx.w.q(str3));
        this.l = wVar;
        wVar.n(this.w);
        ((com.byazt.zct.n) this.l.n(com.byazt.zct.n.class)).n(this.s);
    }

    public void n(int i, wm wmVar) {
        w wVar;
        if (i == -1 || wmVar == null) {
            return;
        }
        tj tjVar = new tj();
        tjVar.n(wmVar.n);
        tjVar.qg(wmVar.qg);
        tjVar.s(wmVar.s);
        tjVar.q(wmVar.q);
        tjVar.qg(wmVar.k);
        tjVar.n(wmVar.hd);
        if (i != 1) {
            if (i == 2 && (wVar = this.l) != null) {
                wVar.n(wmVar);
                this.l.n(tjVar);
                this.l.n(this.w, tjVar);
                return;
            }
            return;
        }
        x xVar = this.q;
        if (xVar != null) {
            xVar.n(wmVar);
            this.q.n(tjVar);
            this.q.n(this.w, tjVar);
        }
    }
}
