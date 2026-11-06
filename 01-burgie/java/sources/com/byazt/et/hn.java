package com.byazt.et;

import android.content.Context;
import com.byazt.hg.of;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 51, 20})
public class hn extends hw {
    public hn(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        super(context, ofVar, hwVar);
    }

    @Override // com.byazt.et.hw
    public void pr(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        if (context == null) {
            return;
        }
        this.pr = new BannerExpressVideoView(context, ofVar, hwVar);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(com.byazt.qh.hn hnVar) {
        if (this.pr != null) {
            this.pr.setVideoAdListener(hnVar);
        }
    }

    @Override // com.byazt.qx.hw
    public com.byazt.mm.pr k() {
        if (this.fw != null && this.fw.get() != null) {
            return this.fw.get().getVideoModel();
        }
        if (this.pr != null) {
            return ((BannerExpressVideoView) this.pr).getVideoModel();
        }
        return null;
    }
}
