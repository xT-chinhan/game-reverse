package com.bytedance.sdk.openadsdk.core.xr.ms.ms;

import com.bytedance.sdk.openadsdk.ao.xr.xr.zb;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class x extends xr {
    protected boolean ab = false;

    public void ka(boolean z) {
        this.ab = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr
    public int xr(Map<String, Object> map) {
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        String strHi = this.ka.hi();
        if (this.ka.ka()) {
            if ((this.ka.zb() instanceof zb) || this.ab) {
                map.put("is_need_report_click_button", Boolean.TRUE);
            }
            boolean zC = this.ka.c();
            map.put("key_open_video_detail_page_direct", Boolean.TRUE);
            str = strHi;
            z2 = zC;
            z = false;
            z3 = false;
        } else {
            boolean zXr = nw.xr(this.f3767ms);
            c cVar = this.ka;
            String strHi2 = zXr ? cVar.hi() : f.ms(cVar.ny());
            this.ka.ms(strHi2);
            this.ka.xr(zXr);
            z = zXr;
            str = strHi2;
            z2 = true;
            z3 = true;
        }
        ah(map);
        this.c.ms(this.f3767ms, map);
        return !this.c.ms(map, z, str, z2, z3, false) ? 1 : 0;
    }
}
