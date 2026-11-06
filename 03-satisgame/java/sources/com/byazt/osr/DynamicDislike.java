package com.byazt.osr;

import android.content.Context;
import android.widget.ImageView;
import com.byazt.lh.fs;
import com.byazt.stl.DislikeView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2019})
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        if (com.byazt.twc.q.n()) {
            this.k = new ImageView(context);
        } else {
            this.k = new DislikeView(context);
        }
        this.k.setTag(3);
        addView(this.k, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.k);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        int iN = (int) com.byazt.cq.fs.n(this.cp, this.d.hd());
        if (!(this.k instanceof DislikeView)) {
            return true;
        }
        ((DislikeView) this.k).setRadius((int) com.byazt.cq.fs.n(this.cp, this.d.k()));
        ((DislikeView) this.k).setStrokeWidth(iN);
        ((DislikeView) this.k).setStrokeColor(this.d.cy());
        ((DislikeView) this.k).setBgColor(this.d.ur());
        ((DislikeView) this.k).setDislikeColor(this.d.x());
        ((DislikeView) this.k).setDislikeWidth((int) com.byazt.cq.fs.n(this.cp, 1.0f));
        return true;
    }
}
