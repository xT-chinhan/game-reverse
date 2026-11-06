package com.bytedance.sdk.openadsdk.zb.ms;

import com.bytedance.sdk.component.c.ab;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.openadsdk.core.nw.qk;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.sdk.openadsdk.core.re.ms.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private qk f4317ms;

    private void ms(hi hiVar) {
        ab abVarCh = hiVar.ch();
        if (abVarCh == null || !d()) {
            return;
        }
        ms(abVarCh.ms(), abVarCh.xr());
    }

    private boolean d() {
        qk qkVar = this.f4317ms;
        return qkVar != null && qkVar.b();
    }

    private void ms(long j, long j2) {
        this.f4317ms.u(j2);
        qk qkVar = this.f4317ms;
        qkVar.ny(j2 - qkVar.nw());
        this.f4317ms.y(j2 - j);
    }

    private void ka() {
        if (d()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            qk qkVar = this.f4317ms;
            qkVar.x(jCurrentTimeMillis - qkVar.y());
            this.f4317ms.zb(jCurrentTimeMillis);
        }
    }

    public qk ah() {
        return this.f4317ms;
    }

    public void ms(qk qkVar) {
        this.f4317ms = qkVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.re.ms.ms
    protected void ms(hi hiVar, com.bytedance.sdk.openadsdk.core.re.ms.ms.xr xrVar) {
        ms(hiVar);
        super.ms(hiVar, xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.re.ms.ms
    protected void ms() {
        ka();
    }
}
