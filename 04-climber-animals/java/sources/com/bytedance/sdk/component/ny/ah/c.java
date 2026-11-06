package com.bytedance.sdk.component.ny.ah;

import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.ny;
import com.bytedance.sdk.component.xr.ms.u;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ny {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1276ms;

    public void ms(int i) {
        this.f1276ms = i;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ny
    public ao ms(ny.ms msVar) throws IOException {
        IOException iOException;
        u uVarMs = msVar.ms();
        if (ab.ms().ms(this.f1276ms).xr() != null) {
            ab.ms().ms(this.f1276ms).xr().ka();
        }
        String string = uVarMs.xr().toString();
        String strMs = ab.ms().ms(this.f1276ms).ms(string);
        if (!string.equals(strMs)) {
            uVarMs = uVarMs.ab().ms(strMs).xr();
        }
        ao aoVarMs = null;
        try {
            iOException = null;
            aoVarMs = msVar.ms(uVarMs);
        } catch (Exception e) {
            iOException = new IOException(e.getMessage());
            ab.ms().ms(this.f1276ms).ms(uVarMs, e);
        }
        ab.ms().ms(this.f1276ms).ms(uVarMs, aoVarMs);
        if (iOException == null) {
            return aoVarMs == null ? msVar.ms(uVarMs) : aoVarMs;
        }
        throw iOException;
    }
}
