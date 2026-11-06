package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.anythink.core.common.d.t;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseG2CV2View extends RelativeLayout {
    protected b a;
    protected Runnable b;
    protected com.anythink.basead.ui.improveclick.c.a c;
    private long d;
    private long e;
    private boolean f;
    private boolean g;

    public interface b {
        void a();

        void b();
    }

    protected void a() {
    }

    abstract void a(int i, int i2);

    protected void b() {
    }

    public boolean canStartNextAnim() {
        return true;
    }

    public void release() {
    }

    public BaseG2CV2View(Context context) {
        this(context, null);
    }

    public BaseG2CV2View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseG2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 5000L;
        this.g = false;
    }

    public void init(long j, int i, int i2, com.anythink.basead.ui.improveclick.c.a aVar, b bVar) {
        this.d = j;
        this.c = aVar;
        this.a = bVar;
        this.f = false;
        this.b = new Runnable() { // from class: com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.1
            @Override // java.lang.Runnable
            public final void run() {
                BaseG2CV2View.this.c();
            }
        };
        a(i, i2);
    }

    public void resumeAnimPlay() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.e = SystemClock.elapsedRealtime();
        if (this.d > 0) {
            a();
            t.b().a(this.b, this.d);
        } else {
            this.a.a();
        }
    }

    public void pauseAnimPlay() {
        if (this.g) {
            this.g = false;
            long j = this.d;
            if (j > 0) {
                this.d = Math.max(j - (SystemClock.elapsedRealtime() - this.e), 0L);
            }
            t.b().d(this.b);
            b();
        }
    }

    public class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final int h = 8;
        public static final int i = 9;
        public static final int j = 10;
        public static final int k = 11;
        public static final int l = 12;
        public static final int m = 13;

        private a() {
        }
    }

    protected final void c() {
        if (this.a == null || this.f || !canStartNextAnim()) {
            return;
        }
        this.f = true;
        this.a.a();
        b();
    }
}
