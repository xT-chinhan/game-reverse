package com.bytedance.sdk.openadsdk.core.op.ms;

import android.os.Message;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.re;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms implements le.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final le f3230ms = new le(x.ms().getLooper(), this);
    private b xr;

    public void ms(JSONObject jSONObject, int i) {
        int iMs = ms(i);
        if (xr(i)) {
            ms(jSONObject, com.bytedance.sdk.openadsdk.core.op.ms.ms().xr(), iMs);
        } else if (ah(i)) {
            ms(jSONObject, com.bytedance.sdk.openadsdk.core.op.ms.ms().ah(), iMs);
        }
    }

    private void ms(JSONObject jSONObject, long j, long j2) {
        if (System.currentTimeMillis() - j > j2) {
            this.xr = ms();
            this.f3230ms.removeCallbacksAndMessages(null);
            this.f3230ms.sendEmptyMessage(1);
        }
    }

    private b ms() {
        b bVar = new b(re.getContext(), 1, ch.ub().ka());
        boolean zMs = bVar.ms(0);
        sl.xr("csj_sen", "reg res:".concat(String.valueOf(zMs)));
        if (zMs) {
            return bVar;
        }
        ms(0, System.currentTimeMillis(), 0L);
        bVar.xr(0);
        return null;
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            b bVar = this.xr;
            if (bVar != null) {
                bVar.xr(0);
            }
            ms(3, 0L, System.currentTimeMillis());
            return;
        }
        b bVar2 = this.xr;
        if (bVar2 == null) {
            return;
        }
        bVar2.ms(new b.ah() { // from class: com.bytedance.sdk.openadsdk.core.op.ms.xr.1
            @Override // com.bytedance.sdk.component.utils.b.ah
            public void ms() {
                xr.this.ms(1, System.currentTimeMillis(), 0L);
                if (xr.this.f3230ms != null) {
                    xr.this.f3230ms.removeCallbacksAndMessages(null);
                }
                if (xr.this.xr != null) {
                    xr.this.xr.xr(0);
                }
            }
        });
        this.f3230ms.sendEmptyMessageDelayed(2, ms(re.xr().qr()));
    }
}
