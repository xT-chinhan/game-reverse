package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.byazt.rk.zo;
import com.byazt.uko.w;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1288})
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.ho = new TextView(context);
        this.ho.setTag(Integer.valueOf(getClickArea()));
        addView(this.ho, getWidgetLayoutParams());
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        if (Build.VERSION.SDK_INT >= 17) {
            this.ho.setTextAlignment(this.k.zo());
        }
        ((TextView) this.ho).setTextColor(this.k.fw());
        ((TextView) this.ho).setTextSize(this.k.c());
        if (com.byazt.dj.x.pr()) {
            ((TextView) this.ho).setIncludeFontPadding(false);
            ((TextView) this.ho).setTextSize(Math.min(((com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), this.zo) - this.k.hw()) - this.k.pr()) - 0.5f, this.k.c()));
            ((TextView) this.ho).setText("AD");
            return true;
        }
        if (aj()) {
            if (w.hw()) {
                ((TextView) this.ho).setText(w.pr());
                return true;
            }
            ((TextView) this.ho).setText(w.pr(this.k.hw));
            return true;
        }
        ((TextView) this.ho).setText("广告");
        return true;
    }

    private boolean aj() {
        if (com.byazt.dj.x.pr()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.k.hw) && this.k.hw.contains("adx:")) || w.hw();
    }
}
