package com.anythink.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.basead.d.g;
import com.anythink.basead.ui.WrapRoundImageView;
import com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView;
import com.anythink.core.common.res.e;
import com.anythink.core.common.res.image.RecycleImageView;
import com.anythink.core.common.v.h;

/* JADX INFO: loaded from: classes.dex */
public class ViewPagerAnimPlayerView extends BaseMainAnimPlayerView {
    private c A;
    private boolean B;
    private RecycleImageView h;

    static /* synthetic */ boolean d(ViewPagerAnimPlayerView viewPagerAnimPlayerView) {
        viewPagerAnimPlayerView.B = false;
        return false;
    }

    public ViewPagerAnimPlayerView(Context context) {
        this(context, null);
    }

    public ViewPagerAnimPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView
    protected final void a(Context context) {
        RecycleImageView recycleImageView = new RecycleImageView(context);
        this.h = recycleImageView;
        recycleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.h, -1, -1);
        WrapRoundImageView wrapRoundImageView = new WrapRoundImageView(getContext().getApplicationContext());
        WrapRoundImageView wrapRoundImageView2 = new WrapRoundImageView(getContext().getApplicationContext());
        wrapRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        wrapRoundImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new AnonymousClass1(wrapRoundImageView, wrapRoundImageView2));
    }

    private void i() {
        WrapRoundImageView wrapRoundImageView = new WrapRoundImageView(getContext().getApplicationContext());
        WrapRoundImageView wrapRoundImageView2 = new WrapRoundImageView(getContext().getApplicationContext());
        wrapRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        wrapRoundImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new AnonymousClass1(wrapRoundImageView, wrapRoundImageView2));
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ WrapRoundImageView a;
        final /* synthetic */ WrapRoundImageView b;

        AnonymousClass1(WrapRoundImageView wrapRoundImageView, WrapRoundImageView wrapRoundImageView2) {
            this.a = wrapRoundImageView;
            this.b = wrapRoundImageView2;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, ViewPagerAnimPlayerView.this.e)) {
                if (ViewPagerAnimPlayerView.this.h != null && bitmap != null) {
                    h.a(ViewPagerAnimPlayerView.this.getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.1.1
                        @Override // com.anythink.core.common.v.h.a
                        public final void a() {
                        }

                        @Override // com.anythink.core.common.v.h.a
                        public final void a(Bitmap bitmap2) {
                            ViewPagerAnimPlayerView.this.h.setImageBitmap(bitmap2);
                        }
                    });
                }
                if (ViewPagerAnimPlayerView.this.A == null) {
                    ViewPagerAnimPlayerView.this.A = new VpMainImgAnimatorView(ViewPagerAnimPlayerView.this.getContext().getApplicationContext());
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    ((View) ViewPagerAnimPlayerView.this.A).setLayoutParams(layoutParams);
                    ViewPagerAnimPlayerView viewPagerAnimPlayerView = ViewPagerAnimPlayerView.this;
                    viewPagerAnimPlayerView.addView((View) viewPagerAnimPlayerView.A);
                    ViewPagerAnimPlayerView.this.A.addMainView(bitmap, this.a, this.b);
                }
                if (ViewPagerAnimPlayerView.this.B) {
                    ViewPagerAnimPlayerView.d(ViewPagerAnimPlayerView.this);
                    if (ViewPagerAnimPlayerView.this.A != null) {
                        ViewPagerAnimPlayerView.this.A.start();
                    }
                }
            }
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            ViewPagerAnimPlayerView.this.a(g.a(g.l, g.T));
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void a() {
        c cVar = this.A;
        if (cVar != null) {
            cVar.start();
        } else {
            this.B = true;
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void b() {
        c cVar = this.A;
        if (cVar != null) {
            cVar.pause();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void c() {
        c cVar = this.A;
        if (cVar != null) {
            cVar.stop();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void d() {
        c cVar = this.A;
        if (cVar != null) {
            cVar.release();
            this.A = null;
        }
    }
}
