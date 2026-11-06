package com.byazt.qx;

import android.content.Context;
import com.byazt.hg.of;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 91})
public class rc extends z {
    public rc(Context context, of ofVar, com.byazt.qe.hw hwVar, int i) {
        super(context, ofVar, hwVar, i);
    }

    @Override // com.byazt.qx.z, com.byazt.qx.fo
    public void pr(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        this.x = "draw_ad";
        this.pr = new NativeExpressDrawVideoView(context, ofVar, hwVar, "draw_ad");
        pr(this.pr, this.hn);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(boolean z) {
        if (this.pr != null) {
            ((NativeExpressVideoView) this.pr).setCanInterruptVideoPlay(z);
        }
    }
}
