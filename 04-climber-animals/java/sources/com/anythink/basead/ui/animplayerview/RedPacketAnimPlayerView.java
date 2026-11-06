package com.anythink.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.j.e;
import com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RedPacketAnimPlayerView extends BaseMainAnimPlayerView {
    private RedPacketAnimatorView A;
    private List<Bitmap> h;

    public RedPacketAnimPlayerView(Context context) {
        this(context, null);
    }

    public RedPacketAnimPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedPacketAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView, com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(w wVar, x xVar, boolean z, List<Bitmap> list, e eVar) {
        this.h = list;
        super.init(wVar, xVar, z, list, eVar);
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView
    protected final void a(Context context) {
        ViewGroup.LayoutParams layoutParams;
        super.a(context);
        RedPacketAnimatorView redPacketAnimatorView = new RedPacketAnimatorView(context);
        this.A = redPacketAnimatorView;
        if (q.c(getContext())) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getContext().getResources().getDisplayMetrics().heightPixels, -1);
            layoutParams2.addRule(13);
            layoutParams = layoutParams2;
        } else {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        redPacketAnimatorView.setLayoutParams(layoutParams);
        this.A.setBitmapResources(this.h);
        addView(this.A);
    }

    private ViewGroup.LayoutParams i() {
        if (q.c(getContext())) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getContext().getResources().getDisplayMetrics().heightPixels, -1);
            layoutParams.addRule(13);
            return layoutParams;
        }
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void a() {
        RedPacketAnimatorView redPacketAnimatorView = this.A;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.start();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void b() {
        RedPacketAnimatorView redPacketAnimatorView = this.A;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.pause();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void c() {
        RedPacketAnimatorView redPacketAnimatorView = this.A;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.stop();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void d() {
        RedPacketAnimatorView redPacketAnimatorView = this.A;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.release();
            this.A = null;
        }
        List<Bitmap> list = this.h;
        if (list != null) {
            for (Bitmap bitmap : list) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }
    }
}
