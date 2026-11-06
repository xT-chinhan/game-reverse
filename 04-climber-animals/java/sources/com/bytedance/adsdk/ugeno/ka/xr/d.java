package com.bytedance.adsdk.ugeno.ka.xr;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.ka.c;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {
    public d(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, c.ms msVar) {
        super(ahVar, str, msVar);
    }

    @Override // com.bytedance.adsdk.ugeno.ka.xr.ms
    public void ms() {
        if (this.c == null || this.c.size() <= 0) {
            return;
        }
        String str = this.c.get("id");
        if (TextUtils.isEmpty(str)) {
            ms(this.ah);
            return;
        }
        com.bytedance.adsdk.ugeno.xr.ah ahVarXr = this.ah.xr(this.ah);
        if (ahVarXr == null) {
            return;
        }
        ms(ahVarXr.ah(str));
    }

    private void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        if (ahVar == null) {
            return;
        }
        for (String str : this.c.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id")) {
                ahVar.ms(str, this.c.get(str));
            }
        }
        ahVar.op();
        ahVar.xr();
    }
}
