package com.smartdigimkt.sdk.basead.ui.animplayerview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.q1.m;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.core.common.res.image.RecycleImageView;

/* JADX INFO: loaded from: classes3.dex */
public class ViewPagerAnimPlayerView extends BaseMainAnimPlayerView {
    public RecycleImageView C;
    public m D;
    public boolean E;

    public ViewPagerAnimPlayerView(Context context) {
        this(context, null);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseMainAnimPlayerView
    public final void a(Context context) {
        RecycleImageView recycleImageView = new RecycleImageView(context);
        this.C = recycleImageView;
        recycleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.C, -1, -1);
        WrapRoundImageView wrapRoundImageView = new WrapRoundImageView(getContext().getApplicationContext());
        WrapRoundImageView wrapRoundImageView2 = new WrapRoundImageView(getContext().getApplicationContext());
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        wrapRoundImageView.setScaleType(scaleType);
        wrapRoundImageView2.setScaleType(scaleType);
        com.smartdigimkt.i3.m.a(getContext()).a(new o(1, this.w), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.smartdigimkt.q1.o(this, wrapRoundImageView, wrapRoundImageView2));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void b() {
        m mVar = this.D;
        if (mVar != null) {
            mVar.release();
            this.D = null;
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void c() {
        m mVar = this.D;
        if (mVar != null) {
            mVar.start();
        } else {
            this.E = true;
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void d() {
        m mVar = this.D;
        if (mVar != null) {
            mVar.stop();
        }
    }

    public ViewPagerAnimPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void a() {
        m mVar = this.D;
        if (mVar != null) {
            mVar.pause();
        }
    }
}
