package com.byazt.gx;

import android.content.Context;
import android.widget.ImageView;
import com.byazt.jt.DislikeView;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1866})
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        if (com.byazt.dj.x.pr()) {
            this.ho = new ImageView(context);
        } else {
            this.ho = new DislikeView(context);
        }
        this.ho.setTag(3);
        addView(this.ho, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.ho);
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        int iPr = (int) com.byazt.js.zo.pr(this.w, this.k.yb());
        if (this.ho instanceof DislikeView) {
            ((DislikeView) this.ho).setRadius((int) com.byazt.js.zo.pr(this.w, this.k.ho()));
            ((DislikeView) this.ho).setStrokeWidth(iPr);
            ((DislikeView) this.ho).setStrokeColor(this.k.nt());
            ((DislikeView) this.ho).setBgColor(this.k.ve());
            ((DislikeView) this.ho).setDislikeColor(this.k.fw());
            ((DislikeView) this.ho).setDislikeWidth((int) com.byazt.js.zo.pr(this.w, 1.0f));
            return true;
        }
        return true;
    }
}
