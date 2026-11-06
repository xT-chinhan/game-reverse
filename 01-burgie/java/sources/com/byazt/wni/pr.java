package com.byazt.wni;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.aa.zo;
import com.byazt.ik.hn;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1241, 37})
public class pr extends hn<DislikeView> {
    public int fe;
    public int pr;
    public int qx;

    public pr(Context context) {
        super(context);
        this.pr = 0;
        this.fe = 0;
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public DislikeView pr() {
        DislikeView dislikeView = new DislikeView(this.hw);
        dislikeView.pr(this);
        return dislikeView;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        ((DislikeView) this.c).setRadius(this.ii);
        ((DislikeView) this.c).setStrokeWidth((int) this.jn);
        ((DislikeView) this.c).setDislikeColor(this.pr);
        ((DislikeView) this.c).setStrokeColor(this.l);
        ((DislikeView) this.c).setDislikeWidth(this.qx);
        ((DislikeView) this.c).setBgColor(this.fe);
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.pr(str, str2);
        switch (str) {
            case "dislikeColor":
                this.pr = com.byazt.aa.pr.pr(str2);
                break;
            case "dislikeFillColor":
                this.fe = com.byazt.aa.pr.pr(str2);
                break;
            case "dislikeWidth":
                this.qx = (int) zo.pr(this.hw, Integer.parseInt(str2));
                break;
        }
    }
}
