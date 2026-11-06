package com.smartdigimkt.w;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    final /* synthetic */ e this$1;

    public c(e eVar) {
        this.this$1 = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.this$1.this$0.mDevListener != null) {
            this.this$1.this$0.mDevListener.onAdClose();
        }
    }
}
