package com.byazt.mw;

import android.content.Context;
import com.byazt.ik.hn;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1133, 37})
public class pr extends hn<PageWebView> {
    public String pr;

    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public PageWebView pr() {
        return new PageWebView(this.hw);
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        ((PageWebView) this.c).setMeta(com.byazt.sd.pr.pr(vk()));
        ((PageWebView) this.c).hw(vk());
        ((PageWebView) this.c).setUGenContext(this.aj);
        ((PageWebView) this.c).pr();
        ((PageWebView) this.c).pr(this.pr);
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "src":
                this.pr = str2;
                break;
        }
    }
}
