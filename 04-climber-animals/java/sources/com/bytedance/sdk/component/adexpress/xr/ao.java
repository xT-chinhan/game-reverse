package com.bytedance.sdk.component.adexpress.xr;

import android.content.Context;
import android.view.View;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ao implements ch {
    private x ah;
    private AtomicBoolean c = new AtomicBoolean(false);
    private zb d;
    private ScheduledFuture<?> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f991ms;
    private com.bytedance.sdk.component.adexpress.ka.ms xr;

    public ao(Context context, zb zbVar, com.bytedance.sdk.component.adexpress.ka.ms msVar, x xVar) {
        this.f991ms = context;
        this.d = zbVar;
        this.ah = xVar;
        this.xr = msVar;
        msVar.ms(this.ah);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch
    public boolean ms(final ch.ms msVar) {
        int iX = this.d.x();
        if (iX < 0) {
            ms(msVar, 107, "time is ".concat(String.valueOf(iX)));
        } else {
            this.ka = com.bytedance.sdk.component.adexpress.d.ka.ms(new ms(1, msVar), iX, TimeUnit.MILLISECONDS);
            this.xr.ms(new ab() { // from class: com.bytedance.sdk.component.adexpress.xr.ao.1
                @Override // com.bytedance.sdk.component.adexpress.xr.ab
                public void ms(View view, u uVar) {
                    ub ubVarXr;
                    ao.this.ah();
                    if (msVar.ah() || (ubVarXr = msVar.xr()) == null) {
                        return;
                    }
                    ubVarXr.ms(ao.this.xr, uVar);
                    msVar.ms(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.xr.ab
                public void ms(int i, String str) {
                    ao.this.ms(msVar, i, str);
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch
    public void ms() {
        this.xr.d();
        ah();
    }

    public com.bytedance.sdk.component.adexpress.ka.ms xr() {
        return this.xr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah() {
        try {
            ScheduledFuture<?> scheduledFuture = this.ka;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.ka.cancel(false);
            this.ka = null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    private class ms implements Runnable {
        private int ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        ch.ms f993ms;

        public ms(int i, ch.ms msVar) {
            this.ah = i;
            this.f993ms = msVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ah == 1) {
                ao.this.xr.ms(true);
                ao.this.ms(this.f993ms, 107, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(ch.ms msVar, int i, String str) {
        ub ubVarXr;
        if (msVar.ah() || this.c.get()) {
            return;
        }
        ah();
        this.d.ab().ms(i, str);
        if (msVar.xr(this)) {
            msVar.ms(this);
        } else {
            if (msVar.ah() || (ubVarXr = msVar.xr()) == null) {
                return;
            }
            msVar.ms(true);
            ubVarXr.a_(i);
        }
        this.c.getAndSet(true);
    }
}
