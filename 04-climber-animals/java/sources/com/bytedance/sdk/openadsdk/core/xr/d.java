package com.bytedance.sdk.openadsdk.core.xr;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.g.ny;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements View.OnClickListener, View.OnTouchListener {
    private static float ah = 0.0f;
    private static float d = 0.0f;
    private static long ka = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static float f3762ms = 0.0f;
    protected static int ny = 8;
    private static float xr;
    protected final Context c;
    protected hi ab = new hi();
    protected final com.bytedance.sdk.openadsdk.core.xr.ms.d x = new com.bytedance.sdk.openadsdk.core.xr.ms.d();

    public void ah() {
    }

    public void d() {
    }

    public void ka(int i) {
    }

    protected abstract void ms(View view, hi hiVar);

    public void ms(i iVar) {
    }

    static {
        try {
            if (ViewConfiguration.get(re.getContext()) != null) {
                ny = ViewConfiguration.get(re.getContext()).getScaledTouchSlop();
            }
        } catch (Exception unused) {
        }
    }

    public d(Context context) {
        if (context == null) {
            this.c = re.getContext();
        } else {
            this.c = context;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ny.ms()) {
            ms(view, this.ab);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(final View view, MotionEvent motionEvent) {
        int i;
        this.ab.ah(motionEvent.getDeviceId());
        this.ab.xr(motionEvent.getToolType(0));
        this.ab.d(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 1;
        if (actionMasked == 0) {
            this.ab.ka((int) motionEvent.getRawX());
            this.ab.c((int) motionEvent.getRawY());
            this.ab.ms(motionEvent.getRawX());
            this.ab.xr(motionEvent.getRawY());
            this.ab.ms(System.currentTimeMillis());
            this.ab.xr(motionEvent.getToolType(0));
            this.ab.ah(motionEvent.getDeviceId());
            this.ab.d(motionEvent.getSource());
            ka = System.currentTimeMillis();
            this.ab.ms(true);
            com.bytedance.sdk.openadsdk.core.jw.re.ms(motionEvent);
            i = 0;
        } else if (actionMasked != 1) {
            i = 2;
            if (actionMasked == 2) {
                ah += Math.abs(motionEvent.getX() - f3762ms);
                d += Math.abs(motionEvent.getY() - xr);
                f3762ms = motionEvent.getX();
                xr = motionEvent.getY();
                long jCurrentTimeMillis = System.currentTimeMillis() - ka;
                this.ab.ah(motionEvent.getRawX());
                this.ab.d(motionEvent.getRawY());
                if (Math.abs(this.ab.ao() - this.ab.x()) >= ny || Math.abs(this.ab.h() - this.ab.ny()) >= ny) {
                    this.ab.ms(false);
                }
                if (jCurrentTimeMillis > 200) {
                    float f = ah;
                    int i3 = ny;
                    if (f > i3 || xr > i3) {
                    }
                }
            } else if (actionMasked != 3) {
                i2 = -1;
            } else {
                if (com.bytedance.sdk.component.adexpress.dynamic.xr.ms.ms(view) && com.bytedance.sdk.component.adexpress.dynamic.xr.ms.xr(view)) {
                    view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (view.isShown()) {
                                d dVar = d.this;
                                dVar.ms(view, dVar.ab);
                            }
                        }
                    });
                    return true;
                }
                i2 = 4;
            }
            i = i2;
        } else {
            this.ab.ah(motionEvent.getRawX());
            this.ab.d(motionEvent.getRawY());
            if (Math.abs(this.ab.ao() - this.ab.x()) >= ny || Math.abs(this.ab.h() - this.ab.ny()) >= ny) {
                this.ab.ms(false);
            }
            this.ab.xr(System.currentTimeMillis());
            Context context = this.c;
            if (context == null) {
                context = re.getContext();
            }
            com.bytedance.sdk.openadsdk.core.xr.ms.xr xrVar = (com.bytedance.sdk.openadsdk.core.xr.ms.xr) ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.class);
            if (xrVar != null) {
                xrVar.ms(this.ab);
            }
            if (com.bytedance.sdk.component.adexpress.dynamic.xr.ms.ms(view)) {
                if (com.bytedance.sdk.component.adexpress.dynamic.xr.ms.ms(view, this.ab.ao(), this.ab.h(), this.ab.x(), this.ab.ny())) {
                    return false;
                }
                if (com.bytedance.sdk.component.adexpress.dynamic.xr.ms.xr(view)) {
                    ms(view, this.ab);
                }
                return true;
            }
            if (xrVar != null) {
                Point point = new Point((int) this.ab.ao(), (int) this.ab.h());
                if (view != null && !xrVar.ms(view, context) && xrVar.ms((View) view.getParent(), point)) {
                    return true;
                }
            }
            i = 3;
        }
        this.ab.ch().put(motionEvent.getActionMasked(), new ms(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    public <T extends com.bytedance.sdk.openadsdk.core.xr.ms.ms> T ms(Class<T> cls) {
        return (T) this.x.ms(cls);
    }

    public static class ms {
        public double ah;
        public long d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public int f3764ms;
        public double xr;

        public ms(int i, double d, double d2, long j) {
            this.f3764ms = i;
            this.xr = d;
            this.ah = d2;
            this.d = j;
        }
    }
}
