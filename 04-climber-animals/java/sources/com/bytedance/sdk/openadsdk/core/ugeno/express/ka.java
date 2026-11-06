package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.view.View;
import com.bytedance.adsdk.ugeno.ah.h;
import com.bytedance.sdk.component.adexpress.xr.ch;
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.component.adexpress.xr.ub;
import com.bytedance.sdk.component.adexpress.xr.x;
import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.utils.sl;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements ch {
    private zb ah;
    private ScheduledFuture<?> d;
    private AtomicBoolean ka = new AtomicBoolean(false);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f3508ms;
    private d xr;

    public ka(Context context, d dVar, x xVar, zb zbVar) {
        this.f3508ms = context;
        this.xr = dVar;
        this.ah = zbVar;
        this.xr.ms(xVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch
    public boolean ms(final ch.ms msVar) {
        int iX = this.ah.x();
        if (iX < 0) {
            ms(msVar, 137);
        } else {
            this.d = ab.d().schedule(new ms(1, msVar), iX, TimeUnit.MILLISECONDS);
            this.xr.ms(new com.bytedance.sdk.component.adexpress.xr.ab() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.ka.1
                @Override // com.bytedance.sdk.component.adexpress.xr.ab
                public void ms(View view, u uVar) {
                    if (msVar.ah()) {
                        return;
                    }
                    h hVar = new h();
                    hVar.ms(0);
                    ((xr) ka.this.ah).pc().ms(hVar);
                    ka.this.ah.ab().zb();
                    ub ubVarXr = msVar.xr();
                    if (ubVarXr == null) {
                        return;
                    }
                    ubVarXr.ms(ka.this.xr, uVar);
                    msVar.ms(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.xr.ab
                public void ms(int i, String str) {
                    ub ubVarXr;
                    h hVar = new h();
                    hVar.ms(i);
                    hVar.ms(str);
                    ((xr) ka.this.ah).pc().ms(hVar);
                    if (msVar.xr(ka.this)) {
                        msVar.ms(ka.this);
                    } else {
                        if (msVar.ah() || (ubVarXr = msVar.xr()) == null) {
                            return;
                        }
                        ubVarXr.a_(i);
                    }
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch
    public void ms() {
        d dVar = this.xr;
        if (dVar != null) {
            dVar.hi();
        }
    }

    private void xr() {
        try {
            ScheduledFuture<?> scheduledFuture = this.d;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.d.cancel(false);
            this.d = null;
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    private class ms implements Runnable {
        private int ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        ch.ms f3510ms;

        ms(int i, ch.ms msVar) {
            this.ah = i;
            this.f3510ms = msVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ah == 1) {
                ka.this.xr.ms(true);
                ka.this.ms(this.f3510ms, 137);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(ch.ms msVar, int i) {
        ub ubVarXr;
        if (msVar.ah() || this.ka.get()) {
            return;
        }
        xr();
        h hVar = new h();
        hVar.ms(i);
        ((xr) this.ah).pc().ms(hVar);
        if (msVar.xr(this)) {
            msVar.ms(this);
        } else {
            if (msVar.ah() || (ubVarXr = msVar.xr()) == null) {
                return;
            }
            msVar.ms(true);
            ubVarXr.a_(i);
        }
        this.ka.getAndSet(true);
    }
}
