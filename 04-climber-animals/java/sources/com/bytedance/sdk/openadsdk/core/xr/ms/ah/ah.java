package com.bytedance.sdk.openadsdk.core.xr.ms.ah;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends xr {
    private Map<String, Object> ab;
    private String c;
    ms ka;
    private EmptyView ny;
    private Double x;

    public interface ms {
        boolean ms();
    }

    public void ms(ms msVar) {
        this.ka = msVar;
    }

    public void ms(String str) {
        this.c = str;
    }

    public void ms(EmptyView emptyView) {
        this.ny = emptyView;
    }

    public void ms(Map<String, Object> map) {
        Map<String, Object> map2 = this.ab;
        if (map2 == null) {
            this.ab = map;
        } else {
            map2.putAll(map);
        }
    }

    public void ms(Double d) {
        this.x = d;
    }

    public ah() {
    }

    public ah(lm lmVar, Context context) {
        this.f3767ms = lmVar;
        this.xr = context;
        this.ab = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ah.xr, com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        ms msVar;
        if (!re.xr().gz() || (msVar = this.ka) == null || msVar.ms()) {
            return 0;
        }
        EmptyView emptyView = this.ny;
        if (emptyView == null) {
            this.ab.put("show_send_type", 1);
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.f3767ms, this.c, this.ab, this.x);
        } else {
            emptyView.ms("checkWhenClicked");
        }
        return 0;
    }
}
