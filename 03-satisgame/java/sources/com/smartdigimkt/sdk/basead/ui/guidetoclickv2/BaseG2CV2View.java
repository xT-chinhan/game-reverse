package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.smartdigimkt.b2.e;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.y1.a;
import com.smartdigimkt.y1.b;
import com.smartdigimkt.y1.n;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseG2CV2View extends RelativeLayout {
    public long a;
    public b b;
    public long c;
    public a d;
    public e e;
    public boolean f;
    public boolean g;

    public BaseG2CV2View(Context context) {
        this(context, null);
    }

    public final void a() {
        if (this.b == null || this.f || !canStartNextAnim()) {
            return;
        }
        this.f = true;
        ((n) this.b).a.c();
        pauseAnim();
    }

    public boolean canStartNextAnim() {
        return true;
    }

    public void init(long j, int i, int i2, e eVar, b bVar) {
        this.a = j;
        this.e = eVar;
        this.b = bVar;
        this.f = false;
        this.d = new a(this);
        initView(i, i2);
    }

    public abstract void initView(int i, int i2);

    public void pauseAnim() {
    }

    public void pauseAnimPlay() {
        if (this.g) {
            this.g = false;
            long j = this.a;
            if (j > 0) {
                this.a = Math.max(j - (SystemClock.elapsedRealtime() - this.c), 0L);
            }
            f fVarA = f.a();
            fVarA.b.removeCallbacks(this.d);
            pauseAnim();
        }
    }

    public void release() {
    }

    public void resumeAnim() {
    }

    public void resumeAnimPlay() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.c = SystemClock.elapsedRealtime();
        if (this.a > 0) {
            resumeAnim();
            f.a().a(this.a, this.d);
            return;
        }
        b bVar = this.b;
        if (bVar != null) {
            ((n) bVar).a.c();
        }
    }

    public BaseG2CV2View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseG2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 5000L;
        this.g = false;
    }
}
