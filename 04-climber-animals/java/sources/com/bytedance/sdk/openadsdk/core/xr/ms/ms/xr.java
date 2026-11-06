package com.bytedance.sdk.openadsdk.core.xr.ms.ms;

import android.content.Context;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.sdk.openadsdk.core.xr.ms.ms {
    c ka = new c();
    ka c = new ka(this.ka, this.ah);

    public interface ms {
        void ms(View view, int i);
    }

    int xr(Map<String, Object> map) {
        return 0;
    }

    public void ms(int i) {
        this.ka.xr(i);
    }

    public void ms(Map<String, Object> map) {
        this.ka.ms(map);
    }

    public void ms(String str) {
        this.ka.ms(str);
    }

    public void ms(boolean z) {
        this.ka.ms(z);
    }

    public void ms(lm lmVar) {
        this.f3767ms = lmVar;
        this.ka.ms(lmVar);
    }

    public void ms(Context context) {
        this.xr = context;
        this.ka.ms(context);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar) {
        this.ka.ms(ahVar);
    }

    public com.bytedance.sdk.openadsdk.core.hi.xr.ah ms() {
        return this.ka.x();
    }

    public void xr(boolean z) {
        this.ka.d(z);
    }

    public void ms(Object obj) {
        this.ka.ms(obj);
    }

    public void ah(boolean z) {
        this.ka.ah(z);
    }

    public void ms(com.bytedance.sdk.openadsdk.nw.ms.xr.ms.ms msVar) {
        this.ka.ms(msVar);
    }

    public void d(boolean z) {
        this.ka.xr(z);
    }

    public void ms(ms msVar) {
        this.ka.ms(msVar);
    }

    protected void xr(int i) {
        if (this.ka.ka()) {
            this.ka.ms(i);
        }
    }

    public void ms(long j) {
        this.ka.ms(j);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.video.xr.xr xrVar) {
        this.ka.ms(xrVar);
    }

    public c xr() {
        return this.ka;
    }

    public ka ah() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        if (this.xr == null) {
            this.xr = re.getContext();
        }
        if (this.xr == null || this.f3767ms == null) {
            return 1;
        }
        xr(this.f3767ms.jr());
        d();
        final ms msVarMs = this.ka.ms();
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.1
            @Override // java.lang.Runnable
            public void run() {
                ms msVar = msVarMs;
                if (msVar != null) {
                    msVar.ms(xr.this.d, xr.this.ka.d());
                }
            }
        });
        int iMs = com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.f3767ms, new com.bytedance.sdk.openadsdk.core.live.ms.ah() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.2
            @Override // com.bytedance.sdk.openadsdk.core.live.ms.ah
            public void ms() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.live.ms.ah
            public void ms(int i) {
                ahVar.ms(xr.this.d((Map<String, Object>) map));
            }
        }, this.ka.hi());
        if (iMs == 1 || iMs == 2) {
            com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms msVar = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) ahVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class);
            if (msVar == null) {
                return 0;
            }
            msVar.ms(map, ahVar);
            return 0;
        }
        return d(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(Map<String, Object> map) {
        String strT;
        if (map == null) {
            map = new HashMap<>(1);
        }
        com.bytedance.sdk.openadsdk.core.live.xr xrVarMs = com.bytedance.sdk.openadsdk.core.live.xr.ms();
        if ((xrVarMs.ms(this.ka) & 255) == 0) {
            this.ka.h();
            return 0;
        }
        HashMap map2 = new HashMap(3);
        c cVar = this.ka;
        map2.put("event_tag", cVar != null ? cVar.hi() : "");
        if (this.ah != null && (strT = this.ah.t()) != null) {
            map2.put("dpa_tag", strT);
        }
        com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.d, this.f3767ms.ml(), map2, map);
        int iMs = xrVarMs.ms(this.xr, this.f3767ms, map2);
        int i = iMs & 255;
        int i2 = (iMs & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (i2 > 0) {
            map.put("click_saas_action", Integer.valueOf(i2));
        }
        if (i == 0) {
            return 0;
        }
        int iXr = xr(map);
        ka();
        return iXr;
    }

    protected void d() {
        if (this.ka.ah() && this.ka.ka()) {
            com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarX = this.ka.x();
            if (ahVarX instanceof com.bytedance.sdk.openadsdk.core.hi.ah.x) {
                ((com.bytedance.sdk.openadsdk.core.hi.ah.x) ahVarX).ah(true);
            }
        }
    }

    protected void ka() {
        if (this.ka.ka()) {
            com.bytedance.sdk.openadsdk.nw.ms.xr.ms.ms msVarAb = this.ka.ab();
            if (!f.ah(this.f3767ms) || msVarAb == null) {
                return;
            }
            msVarAb.xr();
        }
    }

    protected void ah(Map<String, Object> map) {
        if (this.d == null) {
            return;
        }
        Object tag = this.d.getTag(2114387600);
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            map.put("reward_browse_banner_from", Boolean.TRUE);
        }
    }
}
