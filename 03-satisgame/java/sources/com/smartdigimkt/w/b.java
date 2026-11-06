package com.smartdigimkt.w;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    final /* synthetic */ e this$1;

    public b(e eVar) {
        this.this$1 = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.this$0.scheduleRefreshAfterShow();
        if (this.this$1.this$0.mDevListener != null) {
            this.this$1.this$0.mDevListener.onAdShow();
        }
    }
}
