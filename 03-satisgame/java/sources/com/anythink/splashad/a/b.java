package com.anythink.splashad.a;

import com.anythink.core.api.AdError;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements com.anythink.core.common.d.a {
    private String mRequestId;
    private volatile boolean mHasReturn = false;
    private volatile boolean isAdTimeout = false;
    private final com.anythink.core.common.s.a timeOutHandler = com.anythink.core.common.s.c.a();
    private final com.anythink.core.common.u.b.d timeoutRunnable = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dx, new Runnable() { // from class: com.anythink.splashad.a.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.mHasReturn) {
                return;
            }
            b.this.isAdTimeout = true;
            b bVar = b.this;
            bVar.onTimeout(bVar.mRequestId);
        }
    });

    public abstract void onAdLoaded(String str, boolean z);

    public abstract void onNoAdError(String str, AdError adError);

    public abstract void onTimeout(String str);

    public void startCountDown(int i) {
        this.timeOutHandler.a(this.timeoutRunnable, i);
    }

    public void setRequestId(String str) {
        this.mRequestId = str;
    }

    @Override // com.anythink.core.common.d.a
    public void onAdLoaded() {
        this.timeOutHandler.a(this.timeoutRunnable);
        if (this.mHasReturn) {
            return;
        }
        this.mHasReturn = true;
        onAdLoaded(this.mRequestId, this.isAdTimeout);
    }

    @Override // com.anythink.core.common.d.a
    public void onAdLoadFail(AdError adError) {
        this.timeOutHandler.a(this.timeoutRunnable);
        if (this.mHasReturn) {
            return;
        }
        this.mHasReturn = true;
        onNoAdError(this.mRequestId, adError);
    }
}
