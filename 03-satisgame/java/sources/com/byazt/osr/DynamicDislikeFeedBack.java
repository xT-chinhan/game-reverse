package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.lh.fs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_SPACE})
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        if (com.byazt.twc.q.n()) {
            this.k = new ImageView(context);
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.x = this.fs;
        } else {
            this.k = new TextView(context);
        }
        this.k.setTag(3);
        addView(this.k, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.k);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().tj() && dynamicRootView.getRenderRequest().t()) {
                return;
            }
            this.k.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        ((TextView) this.k).setText("反馈");
        this.k.setTextAlignment(this.d.fs());
        ((TextView) this.k).setTextColor(this.d.x());
        ((TextView) this.k).setTextSize(this.d.l());
        this.k.setBackground(getBackgroundDrawable());
        if (!this.d.ou()) {
            ((TextView) this.k).setMaxLines(1);
            ((TextView) this.k).setGravity(17);
            ((TextView) this.k).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iWm = this.d.wm();
            if (iWm > 0) {
                ((TextView) this.k).setLines(iWm);
                ((TextView) this.k).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.k.setPadding((int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.s()), (int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.qg()), (int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.q()), (int) com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.n()));
        ((TextView) this.k).setGravity(17);
        return true;
    }
}
