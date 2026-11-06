package com.efs.sdk.pa;

import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PAANRListener {
    private PAFactory a;
    private PATraceListener b;

    public a(PAFactory pAFactory) {
        this.a = pAFactory;
        this.b = pAFactory.getTraceListener();
        boolean zEnableTracer = pAFactory.getConfigManager().enableTracer();
        if (zEnableTracer || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            c.a(this.a, "patracepv", null);
        }
        if (this.b != null) {
            this.b.onCheck(zEnableTracer);
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void anrStack(String str) {
        if (str != null && str.length() > 200) {
            c.a(this.a, "patrace", str);
            if (this.b != null) {
                this.b.onAnrTrace();
            }
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void unexcept(Object obj) {
        if (this.b != null) {
            this.b.onUnexcept(obj);
        }
    }
}
