package com.smartdigimkt.sdk.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.inner.b.b;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.q1.c;
import com.smartdigimkt.q1.d;
import com.smartdigimkt.q1.f;
import com.smartdigimkt.q1.k;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.core.common.res.image.RecycleImageView;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAnimPlayerView extends BasePlayerView {
    public boolean A;
    public volatile boolean B;
    public long t;
    public long u;
    public List v;
    public String w;
    public RecycleImageView x;
    public WrapRoundImageView y;
    public boolean z;

    public BaseAnimPlayerView(Context context) {
        super(context);
        this.t = 0L;
        this.u = 0L;
        this.w = "";
        this.z = false;
        this.A = false;
        this.B = false;
        this.n = new c(this, Looper.getMainLooper());
    }

    public abstract void a();

    public final void a(int i, int i2) {
        RecycleImageView recycleImageView = new RecycleImageView(getContext());
        this.x = recycleImageView;
        recycleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.x, -1, -1);
        this.y = new WrapRoundImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.y.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(this.y, layoutParams);
        m.a(getContext()).a(new o(1, this.w), i, i2, new f(this, i, i2));
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public void e() {
        if (TextUtils.isEmpty(this.w)) {
            g gVar = new g(b.l, b.T);
            this.A = true;
            super.a(gVar);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public long getCurrentPosition() {
        return this.b;
    }

    public int getMinAnimDuration() {
        return 0;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public long getVideoLength() {
        return this.a;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public boolean hasVideo() {
        return this.p != null;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void init(com.smartdigimkt.b3.c cVar, a aVar, boolean z, List<Bitmap> list) {
        super.init(cVar, aVar, z, list);
        this.v = list;
        this.w = cVar.f;
        long jMax = Math.max(this.q.s.h0, getMinAnimDuration());
        this.a = jMax;
        this.c = Math.round(jMax * 0.25f);
        this.d = Math.round(this.a * 0.5f);
        this.e = Math.round(this.a * 0.75f);
        k kVar = this.o;
        if (kVar != null) {
            kVar.a(this.a);
        }
        setOnClickListener(new com.smartdigimkt.q1.b(this));
        e();
        List list2 = this.v;
        (list2 == null ? AbstractJsonLexerKt.NULL : Integer.valueOf(list2.size())).toString();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public boolean isMute() {
        return this.i;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public boolean isPlaying() {
        return this.z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release(5);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void pause() {
        if (this.z) {
            this.t = (SystemClock.elapsedRealtime() - this.u) + this.t;
        }
        this.z = false;
        this.j = false;
        this.m = null;
        a();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void release(int i) {
        this.B = true;
        this.z = false;
        this.j = false;
        this.m = null;
        this.o = null;
        c cVar = this.n;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
        b();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void setListener(k kVar) {
        this.o = kVar;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void setMute(boolean z) {
        this.i = z;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void start() {
        if (this.B || this.A) {
            return;
        }
        this.z = !this.l;
        this.u = SystemClock.elapsedRealtime();
        if (this.m == null) {
            this.j = true;
            this.m = new Thread(new d(this));
            this.m.setName("sdm_type_anim_player_progress");
            this.m.start();
        }
        if (this.z) {
            c();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void stop() {
        this.z = false;
        this.j = false;
        this.m = null;
        k kVar = this.o;
        if (kVar != null) {
            kVar.c();
        }
        d();
        this.o = null;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public final void a(g gVar) {
        this.A = true;
        super.a(gVar);
    }

    public BaseAnimPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = 0L;
        this.u = 0L;
        this.w = "";
        this.z = false;
        this.A = false;
        this.B = false;
        this.n = new c(this, Looper.getMainLooper());
    }

    public BaseAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = 0L;
        this.u = 0L;
        this.w = "";
        this.z = false;
        this.A = false;
        this.B = false;
        this.n = new c(this, Looper.getMainLooper());
    }
}
