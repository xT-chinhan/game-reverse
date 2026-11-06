package com.bytedance.sdk.openadsdk.core.xr.ms.ms;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends xr {
    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr
    public int xr(Map<String, Object> map) {
        if (this.ah != null && this.ka != null && this.ka.qv() != null) {
            x xVar = new x();
            xVar.ka = this.ka;
            xVar.ms(this.ka.xr());
            xVar.ms(this.ka.zb());
            xVar.ms(this.xr);
            xVar.ah(this.ka.c());
            xVar.c = this.c;
            return xVar.xr(map);
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarX = this.ka.x();
        if (ahVarX == null) {
            return 1;
        }
        xr(ahVarX);
        ah(map);
        ahVarX.d(this.d instanceof Button);
        ahVarX.ms(this.f3767ms, this.ah != null && this.ah.ms());
        map.put("convert_res", Boolean.TRUE);
        return 0;
    }

    private void xr(com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar) {
        if (ahVar == null || this.d == null || this.xr == null || this.ah == null) {
            return;
        }
        if (this.ah.nw()) {
            ahVar.xr(true);
            return;
        }
        try {
            if (this.d instanceof TextView) {
                if (this.d instanceof TextView) {
                    CharSequence text = ((TextView) this.d).getText();
                    if (TextUtils.isEmpty(text) || !text.toString().contains("下载")) {
                        return;
                    }
                }
                Resources resources = this.xr.getResources();
                if (resources == null) {
                    return;
                }
                String resourceEntryName = resources.getResourceEntryName(this.d.getId());
                if (!TextUtils.isEmpty(resourceEntryName) && resourceEntryName.startsWith("tt")) {
                    ahVar.xr(true);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
