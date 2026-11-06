package com.byazt.sd;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.hg.of;
import com.byazt.wt.ls;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 61})
public class aj {
    public com.byazt.qx.c c;
    public String fw;
    public com.byazt.nv.hn hn;
    public final of hw;
    public final Context pr;
    public View uc;
    public com.byazt.qx.uc x;

    public aj(Context context, of ofVar, View view, String str) {
        this.fw = "rewarded_video";
        this.hw = ofVar;
        this.pr = context;
        this.uc = view;
        if (TextUtils.isEmpty(str)) {
            this.fw = ls.hw(ls.k(ofVar));
        } else {
            this.fw = str;
        }
        if (ofVar.aj() == 4) {
            this.hn = com.byazt.jx.zo.pr(context, ofVar, this.fw);
        }
        String str2 = this.fw;
        com.byazt.qx.uc ucVar = new com.byazt.qx.uc(context, ofVar, str2, ls.x(str2));
        this.x = ucVar;
        ucVar.pr(this.uc);
        ((com.byazt.dl.pr) this.x.pr(com.byazt.dl.pr.class)).pr(this.hn);
        String str3 = this.fw;
        com.byazt.qx.c cVar = new com.byazt.qx.c(context, ofVar, str3, ls.x(str3));
        this.c = cVar;
        cVar.pr(this.uc);
        ((com.byazt.dl.pr) this.c.pr(com.byazt.dl.pr.class)).pr(this.hn);
    }

    public void pr(int i, com.byazt.hg.fo foVar) {
        if (i == -1 || foVar == null) {
            return;
        }
        com.byazt.hg.vk vkVar = new com.byazt.hg.vk();
        vkVar.pr(foVar.pr);
        vkVar.hw(foVar.hw);
        vkVar.hn(foVar.hn);
        vkVar.x(foVar.x);
        vkVar.hw(foVar.ho);
        vkVar.pr(foVar.yb);
        switch (i) {
            case 1:
                com.byazt.qx.uc ucVar = this.x;
                if (ucVar != null) {
                    ucVar.pr(foVar);
                    this.x.pr(vkVar);
                    this.x.pr(this.uc, vkVar);
                }
                break;
            case 2:
                com.byazt.qx.c cVar = this.c;
                if (cVar != null) {
                    cVar.pr(foVar);
                    this.c.pr(vkVar);
                    this.c.pr(this.uc, vkVar);
                }
                break;
        }
    }
}
