package com.efs.sdk.pa;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PAANRListener {
    private PAFactory a;
    private PATraceListener b;

    public a(PAFactory pAFactory) {
        this.a = pAFactory;
        this.b = pAFactory.getTraceListener();
        boolean zEnableTracer = pAFactory.getConfigManager().enableTracer();
        PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onCheck(zEnableTracer);
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void anrStack(String str) {
        if (str == null || str.length() <= 200) {
            return;
        }
        c.a(this.a, "patrace", str);
        PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onAnrTrace();
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void unexcept(Object obj) {
        PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onUnexcept(obj);
        }
    }
}
