package com.bytedance.sdk.openadsdk.core.op.ms;

import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.op.ab;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    /* JADX INFO: Access modifiers changed from: private */
    public b ms() {
        b bVar = new b(re.getContext(), 1, ch.ub().ka());
        boolean zMs = bVar.ms(0);
        ms(zMs ? 1 : 0, System.currentTimeMillis(), 0L);
        try {
            bVar.xr(0);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void ms(JSONObject jSONObject, int i) {
        if (System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.op.ms.ms().xr() > ms(i)) {
            ab.ms(new ny("reg_sensor") { // from class: com.bytedance.sdk.openadsdk.core.op.ms.ah.1
                @Override // java.lang.Runnable
                public void run() {
                    ah.this.ms();
                }
            });
        }
    }
}
