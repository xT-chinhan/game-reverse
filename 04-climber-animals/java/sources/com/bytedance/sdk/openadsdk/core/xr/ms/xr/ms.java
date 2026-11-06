package com.bytedance.sdk.openadsdk.core.xr.ms.xr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends xr {
    private int c;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.ah ka;

    public ms() {
    }

    public ms(lm lmVar, Context context) {
        this.f3767ms = lmVar;
        this.xr = context;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.nativeexpress.ah ahVar) {
        this.ka = ahVar;
    }

    public void ms(int i) {
        this.c = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public void ms(View view) {
        this.d = view;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        if (this.ka == null) {
            return 0;
        }
        if (this.ah == null) {
            this.ah = new hi();
        }
        View viewC = this.ah.c();
        int[] iArrMs = new int[2];
        int[] iArrAh = new int[2];
        if (viewC != null) {
            iArrMs = ul.ms(viewC);
            iArrAh = ul.ah(viewC);
        }
        this.ka.ms(this.d, this.c, new i.ms().d(this.ah.u()).ah(this.ah.ub()).xr(this.ah.ao()).ms(this.ah.h()).xr(this.ah.sl()).ms(this.ah.zb()).ms(iArrMs[0]).xr(iArrMs[1]).ah(iArrAh[0]).d(iArrAh[1]).ms(this.ah.ka()).ms(this.ah.ch()).ms());
        return 1;
    }
}
