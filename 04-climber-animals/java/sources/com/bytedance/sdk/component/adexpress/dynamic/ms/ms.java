package com.bytedance.sdk.component.adexpress.dynamic.ms;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.ah;
import com.bytedance.sdk.component.adexpress.d.ka;
import com.bytedance.sdk.component.adexpress.dynamic.ah.c;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.xr.ab;
import com.bytedance.sdk.component.adexpress.xr.d;
import com.bytedance.sdk.component.adexpress.xr.hi;
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.component.adexpress.xr.x;
import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.component.utils.sl;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements d<DynamicRootView>, hi {
    private ScheduledFuture<?> ab;
    private Context ah;
    private zb c;
    private ab d;
    private x ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private DynamicRootView f873ms;
    private com.bytedance.sdk.component.adexpress.dynamic.d.x xr;
    private AtomicBoolean x = new AtomicBoolean(false);
    private volatile boolean ny = false;

    public ms(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.d.x xVar, zb zbVar, com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar) {
        this.ah = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, zbVar, msVar);
        this.f873ms = dynamicRootView;
        this.xr = xVar;
        this.c = zbVar;
        dynamicRootView.setRenderListener(this);
        this.c = zbVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    public void ms(ab abVar) {
        this.d = abVar;
        int iX = this.c.x();
        if (iX < 0) {
            this.f873ms.ms(this.xr instanceof com.bytedance.sdk.component.adexpress.dynamic.d.ab ? 127 : 117, "time is " + iX);
            return;
        }
        this.ab = ka.ms(new RunnableC0230ms(2), iX, TimeUnit.MILLISECONDS);
        if (this.ny) {
            com.bytedance.sdk.component.utils.x.ah().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.ms.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.x();
                }
            }, this.c.sl());
        } else if (Looper.getMainLooper() == Looper.myLooper() && this.c.sl() <= 0) {
            x();
        } else {
            com.bytedance.sdk.component.utils.x.xr().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.ms.ms.2
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.x();
                }
            }, this.c.sl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.c.ab().xr(ah());
        JSONObject jSONObjectKa = this.c.ka();
        if (!com.bytedance.sdk.component.adexpress.ms.xr.xr.ms(jSONObjectKa)) {
            this.f873ms.ms(this.xr instanceof com.bytedance.sdk.component.adexpress.dynamic.d.ab ? 123 : 113, "data null is " + (jSONObjectKa == null));
        } else {
            this.xr.ms(new com.bytedance.sdk.component.adexpress.dynamic.ka.xr() { // from class: com.bytedance.sdk.component.adexpress.dynamic.ms.ms.3
                @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.xr
                public void ms(final com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
                    ms.this.ch();
                    ms.this.c.ab().ah(ms.this.ah());
                    ms.this.ms(xVar);
                    ms.this.xr(xVar);
                    if (ms.this.ny) {
                        ms.this.ah(xVar);
                    } else {
                        com.bytedance.sdk.component.utils.x.xr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.ms.ms.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ms.this.ah(xVar);
                            }
                        });
                    }
                    if (ms.this.f873ms == null || xVar == null) {
                        return;
                    }
                    ms.this.f873ms.setBgColor(xVar.ms());
                    ms.this.f873ms.setBgMaterialCenterCalcColor(xVar.xr());
                }
            });
            this.xr.ms(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> listHi;
        if (xVar == null || (listHi = xVar.hi()) == null || listHi.size() <= 0) {
            return;
        }
        Collections.sort(listHi, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.ah.x>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.ms.ms.4
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar2, com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar3) {
                c cVarKa = xVar2.ch().ka();
                c cVarKa2 = xVar3.ch().ka();
                if (cVarKa == null || cVarKa2 == null) {
                    return 0;
                }
                return cVarKa.zd() >= cVarKa2.zd() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar2 : listHi) {
            if (xVar2 != null) {
                ms(xVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        float fAb;
        float fC;
        List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> listHi;
        if (xVar == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> listHi2 = xVar.hi();
        if (listHi2 == null || listHi2.size() <= 0) {
            fAb = 0.0f;
        } else {
            fAb = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar2 : listHi2) {
                if (xVar2.ab() > xVar.ab() - xVar2.ny() || (listHi = xVar2.hi()) == null || listHi.size() <= 0) {
                    fC = 0.0f;
                } else {
                    fC = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar3 : listHi) {
                        if (xVar3.ch().getType().equals("logo-union")) {
                            fC = xVar3.ch().c();
                            fAb = (((-fC) + xVar.ab()) - xVar2.ab()) + xVar2.ch().ka().cc();
                        }
                    }
                }
                xr(xVar2);
                if (fC <= -15.0f) {
                    xVar2.c(xVar2.ny() - fC);
                    xVar2.d(xVar2.ab() + fC);
                    for (com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar4 : xVar2.hi()) {
                        xVar4.d(xVar4.ab() - fC);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.ah.x xVarSl = xVar.sl();
        if (xVarSl == null) {
            return;
        }
        float fC2 = xVar.c() - xVarSl.c();
        float fAb2 = xVar.ab() - xVarSl.ab();
        xVar.ah(fC2);
        xVar.d(fAb2);
        if (fAb > 0.0f) {
            xVar.d(xVar.ab() - fAb);
            xVar.c(xVar.ny() + fAb);
            for (com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar5 : xVar.hi()) {
                xVar5.d(xVar5.ab() + fAb);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public DynamicRootView ab() {
        return c();
    }

    public void xr() {
        ms(ab());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void ms(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                ms(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ka) {
            ((com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ka) view).xr();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    public int ah() {
        return this.xr instanceof com.bytedance.sdk.component.adexpress.dynamic.d.ab ? 3 : 2;
    }

    public void d() {
        this.f873ms.ms();
    }

    public void ka() {
        this.f873ms.xr();
    }

    public void ms(boolean z) {
        this.f873ms.setSoundMute(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        if (xVar == null) {
            this.f873ms.ms(this.xr instanceof com.bytedance.sdk.component.adexpress.dynamic.d.ab ? 123 : 113, "layoutUnit is null");
            return;
        }
        this.c.ab().d(ah());
        try {
            this.f873ms.ms(xVar, ah());
        } catch (Exception e) {
            this.f873ms.ms(this.xr instanceof com.bytedance.sdk.component.adexpress.dynamic.d.ab ? 128 : 118, "exception is " + e.getMessage());
        }
    }

    public DynamicRootView c() {
        return this.f873ms;
    }

    public void ms(x xVar) {
        this.ka = xVar;
    }

    private boolean ny() {
        DynamicRootView dynamicRootView = this.f873ms;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.hi
    public void ms(u uVar) {
        if (this.x.get()) {
            return;
        }
        this.x.set(true);
        if (uVar.ah() && ny()) {
            this.f873ms.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.d.ms(ab(), uVar);
            return;
        }
        this.d.ms(uVar.hi(), uVar.ch());
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.hi
    public void ms(View view, int i, ah ahVar) {
        x xVar = this.ka;
        if (xVar != null) {
            xVar.ms(view, i, ahVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.hi
    public void ms(View view, int i, ah ahVar, int i2) {
        x xVar = this.ka;
        if (xVar != null) {
            xVar.ms(view, i, ahVar, i2);
        }
    }

    public void xr(boolean z) {
        this.ny = z;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.ms.ms$ms, reason: collision with other inner class name */
    private class RunnableC0230ms implements Runnable {
        private int xr;

        public RunnableC0230ms(int i) {
            this.xr = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.xr == 2) {
                ms.this.f873ms.ms(ms.this.xr instanceof com.bytedance.sdk.component.adexpress.dynamic.d.ab ? 127 : 117, (String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch() {
        try {
            ScheduledFuture<?> scheduledFuture = this.ab;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.ab.cancel(false);
            this.ab = null;
        } catch (Throwable th) {
            sl.ms(th);
        }
    }
}
