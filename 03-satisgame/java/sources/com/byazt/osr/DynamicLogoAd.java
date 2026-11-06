package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.byazt.hkc.cp;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1417})
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.k = new TextView(context);
        this.k.setTag(Integer.valueOf(getClickArea()));
        addView(this.k, getWidgetLayoutParams());
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        this.k.setTextAlignment(this.d.fs());
        ((TextView) this.k).setTextColor(this.d.x());
        ((TextView) this.k).setTextSize(this.d.l());
        if (com.byazt.twc.q.n()) {
            ((TextView) this.k).setIncludeFontPadding(false);
            ((TextView) this.k).setTextSize(Math.min(((com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), this.fs) - this.d.qg()) - this.d.n()) - 0.5f, this.d.l()));
            ((TextView) this.k).setText("AD");
            return true;
        }
        if (rv()) {
            if (cp.qg()) {
                ((TextView) this.k).setText(cp.n());
                return true;
            }
            ((TextView) this.k).setText(cp.n(this.d.qg));
            return true;
        }
        ((TextView) this.k).setText("广告");
        return true;
    }

    private boolean rv() {
        if (com.byazt.twc.q.n()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.d.qg) && this.d.qg.contains("adx:")) || cp.qg();
    }
}
