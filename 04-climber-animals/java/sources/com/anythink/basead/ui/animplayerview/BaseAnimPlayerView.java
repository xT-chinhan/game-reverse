package com.anythink.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.basead.d.f;
import com.anythink.basead.d.g;
import com.anythink.basead.j.e;
import com.anythink.basead.ui.WrapRoundImageView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.res.image.RecycleImageView;
import com.anythink.core.common.v.h;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAnimPlayerView extends BasePlayerView {
    private boolean A;
    protected final String a;
    long b;
    long c;
    protected List<Bitmap> d;
    protected String e;
    protected RecycleImageView f;
    protected WrapRoundImageView g;
    private boolean h;

    protected abstract void a();

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected int e() {
        return 0;
    }

    static /* synthetic */ boolean b(BaseAnimPlayerView baseAnimPlayerView) {
        baseAnimPlayerView.h = false;
        return false;
    }

    public BaseAnimPlayerView(Context context) {
        super(context);
        this.a = getClass().getSimpleName();
        this.b = 0L;
        this.c = 0L;
        this.e = "";
        this.h = false;
        this.A = false;
        i();
    }

    public BaseAnimPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getClass().getSimpleName();
        this.b = 0L;
        this.c = 0L;
        this.e = "";
        this.h = false;
        this.A = false;
        i();
    }

    public BaseAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = getClass().getSimpleName();
        this.b = 0L;
        this.c = 0L;
        this.e = "";
        this.h = false;
        this.A = false;
        i();
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(w wVar, x xVar, boolean z, List<Bitmap> list, e eVar) {
        super.init(wVar, xVar, z, list, eVar);
        this.d = list;
        this.e = wVar.B();
        this.i = Math.max(this.y.o.am(), e());
        this.k = Math.round(this.i * 0.25f);
        this.l = Math.round(this.i * 0.5f);
        this.m = Math.round(this.i * 0.75f);
        if (this.w != null) {
            this.w.b(this.i);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BaseAnimPlayerView.this.w != null) {
                    BaseAnimPlayerView.this.w.b(1);
                }
            }
        });
        f();
        StringBuilder sbAppend = new StringBuilder("init success mDuration:").append(this.i).append(",mEndCardImageUrl:").append(this.e).append(",mAnimBitmapList:");
        List<Bitmap> list2 = this.d;
        sbAppend.append(list2 == null ? AbstractJsonLexerKt.NULL : Integer.valueOf(list2.size()));
    }

    protected void f() {
        if (TextUtils.isEmpty(this.e)) {
            a(g.a(g.l, g.T));
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void start() {
        if (this.A) {
            return;
        }
        this.h = !this.t;
        this.c = SystemClock.elapsedRealtime();
        if (this.u == null) {
            this.r = true;
            this.u = new Thread(new AnonymousClass3());
            this.u.setName("anythink_type_anim_player_progress");
            this.u.start();
        }
        if (this.h) {
            a();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void pause() {
        if (this.h) {
            this.b += SystemClock.elapsedRealtime() - this.c;
        }
        this.h = false;
        k();
        b();
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void stop() {
        this.h = false;
        k();
        c();
        h();
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void setListener(BasePlayerView.a aVar) {
        this.w = aVar;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean isPlaying() {
        return this.h;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean hasVideo() {
        return this.x != null;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public long getVideoLength() {
        return this.i;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public long getCurrentPosition() {
        return this.j;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void setMute(boolean z) {
        this.q = z;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean isMute() {
        return this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release(5);
    }

    private void i() {
        this.v = new Handler(Looper.getMainLooper()) { // from class: com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.2
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (BaseAnimPlayerView.this.w != null && BaseAnimPlayerView.this.r) {
                    BaseAnimPlayerView baseAnimPlayerView = BaseAnimPlayerView.this;
                    baseAnimPlayerView.j = (baseAnimPlayerView.b + SystemClock.elapsedRealtime()) - BaseAnimPlayerView.this.c;
                    if (!BaseAnimPlayerView.this.s && !BaseAnimPlayerView.this.t) {
                        BaseAnimPlayerView.this.s = true;
                        if (BaseAnimPlayerView.this.w != null) {
                            BaseAnimPlayerView.this.w.a();
                        }
                    }
                    if (BaseAnimPlayerView.this.w != null) {
                        BaseAnimPlayerView.this.w.a(BaseAnimPlayerView.this.j);
                    }
                    if (!BaseAnimPlayerView.this.n && BaseAnimPlayerView.this.j >= BaseAnimPlayerView.this.k) {
                        BaseAnimPlayerView.this.n = true;
                        if (BaseAnimPlayerView.this.w != null) {
                            BaseAnimPlayerView.this.w.a(25);
                        }
                    } else if (!BaseAnimPlayerView.this.o && BaseAnimPlayerView.this.j >= BaseAnimPlayerView.this.l) {
                        BaseAnimPlayerView.this.o = true;
                        if (BaseAnimPlayerView.this.w != null) {
                            BaseAnimPlayerView.this.w.a(50);
                        }
                    } else if (!BaseAnimPlayerView.this.p && BaseAnimPlayerView.this.j >= BaseAnimPlayerView.this.m) {
                        BaseAnimPlayerView.this.p = true;
                        if (BaseAnimPlayerView.this.w != null) {
                            BaseAnimPlayerView.this.w.a(75);
                        }
                    }
                    if (BaseAnimPlayerView.this.t || BaseAnimPlayerView.this.j < BaseAnimPlayerView.this.i) {
                        return;
                    }
                    BaseAnimPlayerView.this.k();
                    BaseAnimPlayerView.b(BaseAnimPlayerView.this);
                    BaseAnimPlayerView.this.t = true;
                    if (BaseAnimPlayerView.this.w != null) {
                        BaseAnimPlayerView.this.w.c();
                    }
                    BaseAnimPlayerView.this.h();
                }
            }
        };
    }

    private void j() {
        if (this.u != null) {
            return;
        }
        this.r = true;
        this.u = new Thread(new AnonymousClass3());
        this.u.setName("anythink_type_anim_player_progress");
        this.u.start();
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.animplayerview.BaseAnimPlayerView$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (BaseAnimPlayerView.this.r) {
                if (!BaseAnimPlayerView.this.t && BaseAnimPlayerView.this.v != null) {
                    try {
                        BaseAnimPlayerView.this.v.sendEmptyMessage(1);
                    } catch (Throwable unused) {
                    }
                    try {
                        Thread.sleep(200L);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(10L);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.r = false;
        this.u = null;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void release(int i) {
        k();
        h();
        if (this.v != null) {
            this.v.removeCallbacksAndMessages(null);
        }
        d();
    }

    protected final void g() {
        a(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
    }

    protected final void a(final int i, final int i2) {
        RecycleImageView recycleImageView = new RecycleImageView(getContext());
        this.f = recycleImageView;
        recycleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f, -1, -1);
        this.g = new WrapRoundImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(this.g, layoutParams);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), i, i2, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.4
            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, Bitmap bitmap) {
                if (TextUtils.equals(str, BaseAnimPlayerView.this.e)) {
                    BaseAnimPlayerView.this.g.setBitmapAndResize(bitmap, i, i2);
                    h.a(BaseAnimPlayerView.this.getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.4.1
                        @Override // com.anythink.core.common.v.h.a
                        public final void a() {
                        }

                        @Override // com.anythink.core.common.v.h.a
                        public final void a(Bitmap bitmap2) {
                            BaseAnimPlayerView.this.f.setImageBitmap(bitmap2);
                        }
                    });
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setDuration(100L);
                    BaseAnimPlayerView.this.g.startAnimation(alphaAnimation);
                    BaseAnimPlayerView.this.f.startAnimation(alphaAnimation);
                }
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
                BaseAnimPlayerView.this.a(g.a(g.l, g.T));
            }
        });
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    protected final void a(f fVar) {
        this.A = true;
        super.a(fVar);
    }
}
