package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 849})
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        if (com.byazt.dj.x.pr()) {
            this.ho = new ImageView(context);
            ((ImageView) this.ho).setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fw = this.zo;
        } else {
            this.ho = new TextView(context);
        }
        this.ho.setTag(3);
        addView(this.ho, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.ho);
        if (dynamicRootView.getRenderRequest() != null) {
            if (!dynamicRootView.getRenderRequest().vk() || !dynamicRootView.getRenderRequest().iu()) {
                this.ho.setVisibility(8);
                setVisibility(8);
            }
        }
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        ((TextView) this.ho).setText("反馈");
        if (Build.VERSION.SDK_INT >= 17) {
            this.ho.setTextAlignment(this.k.zo());
        }
        ((TextView) this.ho).setTextColor(this.k.fw());
        ((TextView) this.ho).setTextSize(this.k.c());
        if (Build.VERSION.SDK_INT >= 16) {
            this.ho.setBackground(getBackgroundDrawable());
        }
        if (!this.k.ny()) {
            ((TextView) this.ho).setMaxLines(1);
            ((TextView) this.ho).setGravity(17);
            ((TextView) this.ho).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iFo = this.k.fo();
            if (iFo > 0) {
                ((TextView) this.ho).setLines(iFo);
                ((TextView) this.ho).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.ho.setPadding((int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hn()), (int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hw()), (int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.x()), (int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.pr()));
        ((TextView) this.ho).setGravity(17);
        return true;
    }
}
