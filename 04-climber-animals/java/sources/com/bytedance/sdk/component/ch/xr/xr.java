package com.bytedance.sdk.component.ch.xr;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.le;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends le implements ah {
    private final HandlerThread xr;

    xr(HandlerThread handlerThread, le.ms msVar) {
        super(handlerThread.getLooper(), msVar);
        this.xr = handlerThread;
    }

    @Override // com.bytedance.sdk.component.ch.xr.ah
    public void ms() {
        removeCallbacksAndMessages(null);
        if (this.f1360ms != null) {
            this.f1360ms.clear();
            this.f1360ms = null;
        }
    }

    public void ms(le.ms msVar) {
        this.f1360ms = new WeakReference<>(msVar);
    }

    public void xr() {
        HandlerThread handlerThread = this.xr;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }
}
