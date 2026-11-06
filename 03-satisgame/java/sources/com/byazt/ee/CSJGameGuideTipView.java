package com.byazt.ee;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 84, 2178})
public class CSJGameGuideTipView extends LottieAnimationView {
    public final float n;

    public CSJGameGuideTipView(Context context) {
        super(context);
        this.n = context.getResources().getDisplayMetrics().density;
        setClickable(false);
        setFocusable(false);
    }

    public void n(w wVar, JSONObject jSONObject, double d, double d2, double d3, double d4) {
        if (wVar == null) {
            return;
        }
        setMaintainOriginalImageBounds(true);
        setImageAssetDelegate(new n(this, jSONObject));
        float f = this.n;
        int i = (int) (d3 * ((double) f));
        int i2 = (int) (d4 * ((double) f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = (int) ((d * ((double) this.n)) - ((double) (i / 2.0f)));
        layoutParams.topMargin = (int) ((d2 * ((double) this.n)) - ((double) (i2 / 2.0f)));
        setLayoutParams(layoutParams);
        setComposition(wVar);
        n(true);
        setVisibility(0);
        n();
    }

    public void fs() {
        w();
        setVisibility(8);
    }
}
