package com.anythink.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.anythink.basead.d.f;
import com.anythink.basead.j.e;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePlayerView extends RelativeLayout {
    private int a;
    protected long i;
    protected long j;
    protected int k;
    protected int l;
    protected int m;
    protected boolean n;
    protected boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected Thread u;
    protected Handler v;
    protected a w;
    protected w x;
    protected x y;
    protected boolean z;

    public interface a {
        void a();

        void a(int i);

        void a(long j);

        void a(f fVar);

        void b();

        void b(int i);

        void b(long j);

        void c();

        void d();

        void e();

        void f();
    }

    public abstract long getCurrentPosition();

    public abstract long getVideoLength();

    public abstract boolean hasVideo();

    public abstract boolean isMute();

    public abstract boolean isPlaying();

    public abstract void pause();

    public void rePlayVideo() {
    }

    public void release(int i) {
    }

    public abstract void setListener(a aVar);

    public abstract void setMute(boolean z);

    public abstract void start();

    public abstract void stop();

    public BasePlayerView(Context context) {
        super(context);
        this.i = 5000L;
        this.j = -1L;
        this.r = false;
        this.s = false;
        this.t = false;
        this.z = false;
    }

    public BasePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 5000L;
        this.j = -1L;
        this.r = false;
        this.s = false;
        this.t = false;
        this.z = false;
    }

    public BasePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 5000L;
        this.j = -1L;
        this.r = false;
        this.s = false;
        this.t = false;
        this.z = false;
    }

    public void init(w wVar, x xVar, boolean z, List<Bitmap> list, e eVar) {
        this.x = wVar;
        this.y = xVar;
    }

    public boolean isPlayCompletion() {
        return this.t;
    }

    protected void a(f fVar) {
        a aVar = this.w;
        if (aVar != null) {
            aVar.a(fVar);
        }
        this.w = null;
    }

    protected final void b(f fVar) {
        a aVar = this.w;
        if (aVar != null) {
            aVar.a(fVar);
        }
        if (this.z) {
            return;
        }
        this.w = null;
    }

    protected final void h() {
        this.w = null;
    }

    public void setNeedInterruptRelease(boolean z) {
        this.z = z;
    }

    public int getViewType() {
        return this.a;
    }

    public void setViewType(int i) {
        this.a = i;
    }
}
