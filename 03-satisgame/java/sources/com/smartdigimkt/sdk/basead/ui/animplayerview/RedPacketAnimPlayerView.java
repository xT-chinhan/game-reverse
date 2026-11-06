package com.smartdigimkt.sdk.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.animplayerview.redpacket.RedPacketAnimatorView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RedPacketAnimPlayerView extends BaseMainAnimPlayerView {
    public List C;
    public RedPacketAnimatorView D;

    public RedPacketAnimPlayerView(Context context) {
        this(context, null);
    }

    private ViewGroup.LayoutParams getLayoutParamsByOrientation() {
        if (!k.b(getContext())) {
            return new ViewGroup.LayoutParams(-1, -1);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getContext().getResources().getDisplayMetrics().heightPixels, -1);
        layoutParams.addRule(13);
        return layoutParams;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseMainAnimPlayerView
    public final void a(Context context) {
        super.a(context);
        RedPacketAnimatorView redPacketAnimatorView = new RedPacketAnimatorView(context);
        this.D = redPacketAnimatorView;
        redPacketAnimatorView.setLayoutParams(getLayoutParamsByOrientation());
        this.D.setBitmapResources(this.C);
        addView(this.D);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void b() {
        RedPacketAnimatorView redPacketAnimatorView = this.D;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.release();
            this.D = null;
        }
        List<Bitmap> list = this.C;
        if (list != null) {
            for (Bitmap bitmap : list) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void c() {
        RedPacketAnimatorView redPacketAnimatorView = this.D;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.start();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void d() {
        RedPacketAnimatorView redPacketAnimatorView = this.D;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.stop();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseMainAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void init(c cVar, a aVar, boolean z, List<Bitmap> list) {
        this.C = list;
        super.init(cVar, aVar, z, list);
    }

    public RedPacketAnimPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedPacketAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void a() {
        RedPacketAnimatorView redPacketAnimatorView = this.D;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.pause();
        }
    }
}
