package com.smartdigimkt.sdk.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.q1.c;
import com.smartdigimkt.q1.k;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePlayerView extends RelativeLayout {
    public long a;
    public long b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public volatile boolean j;
    public boolean k;
    public boolean l;
    public volatile Thread m;
    public c n;
    public k o;
    public com.smartdigimkt.b3.c p;
    public a q;
    public boolean r;
    public int s;

    public BasePlayerView(Context context) {
        super(context);
        this.a = 5000L;
        this.b = -1L;
        this.j = false;
        this.k = false;
        this.l = false;
        this.r = false;
    }

    public void a(g gVar) {
        k kVar = this.o;
        if (kVar != null) {
            kVar.a(gVar);
        }
        this.o = null;
    }

    public abstract long getCurrentPosition();

    public abstract long getVideoLength();

    public int getViewType() {
        return this.s;
    }

    public abstract boolean hasVideo();

    public void init(com.smartdigimkt.b3.c cVar, a aVar, boolean z, List<Bitmap> list) {
        this.p = cVar;
        this.q = aVar;
    }

    public abstract boolean isMute();

    public boolean isPlayCompletion() {
        return this.l;
    }

    public abstract boolean isPlaying();

    public abstract void pause();

    public void rePlayVideo() {
    }

    public void release(int i) {
    }

    public abstract void setListener(k kVar);

    public abstract void setMute(boolean z);

    public void setNeedInterruptRelease(boolean z) {
        this.r = z;
    }

    public void setViewType(int i) {
        this.s = i;
    }

    public abstract void start();

    public abstract void stop();

    public BasePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 5000L;
        this.b = -1L;
        this.j = false;
        this.k = false;
        this.l = false;
        this.r = false;
    }

    public BasePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 5000L;
        this.b = -1L;
        this.j = false;
        this.k = false;
        this.l = false;
        this.r = false;
    }
}
