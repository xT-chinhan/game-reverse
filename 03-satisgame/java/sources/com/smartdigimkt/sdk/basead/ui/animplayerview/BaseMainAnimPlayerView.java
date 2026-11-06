package com.smartdigimkt.sdk.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.q1.j;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.core.common.res.image.RecycleImageView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseMainAnimPlayerView extends BaseAnimPlayerView {
    public BaseMainAnimPlayerView(Context context) {
        this(context, null);
    }

    public void a(Context context) {
        RecycleImageView recycleImageView = new RecycleImageView(context);
        this.x = recycleImageView;
        recycleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.x, -1, -1);
        this.y = new WrapRoundImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.y.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(this.y, layoutParams);
        m.a(getContext()).a(new o(1, this.w), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new j(this, this.y));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void init(c cVar, a aVar, boolean z, List<Bitmap> list) {
        super.init(cVar, aVar, z, list);
        a(getContext().getApplicationContext());
    }

    public BaseMainAnimPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMainAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
