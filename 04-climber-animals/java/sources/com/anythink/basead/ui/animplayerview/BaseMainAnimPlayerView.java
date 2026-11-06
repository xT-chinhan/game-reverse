package com.anythink.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.basead.d.g;
import com.anythink.basead.j.e;
import com.anythink.basead.ui.WrapRoundImageView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.res.image.RecycleImageView;
import com.anythink.core.common.v.h;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMainAnimPlayerView extends BaseAnimPlayerView {
    public BaseMainAnimPlayerView(Context context) {
        this(context, null);
    }

    public BaseMainAnimPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMainAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(w wVar, x xVar, boolean z, List<Bitmap> list, e eVar) {
        super.init(wVar, xVar, z, list, eVar);
        a(getContext().getApplicationContext());
    }

    protected void a(Context context) {
        this.f = new RecycleImageView(context);
        this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f, -1, -1);
        this.g = new WrapRoundImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(this.g, layoutParams);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new AnonymousClass1(this.g));
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ WrapRoundImageView a;

        AnonymousClass1(WrapRoundImageView wrapRoundImageView) {
            this.a = wrapRoundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, final Bitmap bitmap) {
            if (TextUtils.equals(str, BaseMainAnimPlayerView.this.e)) {
                WrapRoundImageView wrapRoundImageView = this.a;
                if (wrapRoundImageView != null) {
                    wrapRoundImageView.post(new Runnable() { // from class: com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1.this.a.setBitmapAndResize(bitmap, BaseMainAnimPlayerView.this.getWidth(), BaseMainAnimPlayerView.this.getHeight());
                        }
                    });
                }
                if (BaseMainAnimPlayerView.this.f == null || bitmap == null) {
                    return;
                }
                h.a(BaseMainAnimPlayerView.this.getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.1.2
                    @Override // com.anythink.core.common.v.h.a
                    public final void a() {
                    }

                    @Override // com.anythink.core.common.v.h.a
                    public final void a(Bitmap bitmap2) {
                        BaseMainAnimPlayerView.this.f.setImageBitmap(bitmap2);
                    }
                });
            }
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            BaseMainAnimPlayerView.this.a(g.a(g.l, g.T));
        }
    }

    private void a(WrapRoundImageView wrapRoundImageView) {
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new AnonymousClass1(wrapRoundImageView));
    }
}
