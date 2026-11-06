package com.bytedance.sdk.openadsdk.core.xr.ms.xr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MotionEventCompat;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends xr {
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.ab ab;
    private boolean c;
    private int ka;
    private com.bytedance.sdk.openadsdk.core.xr.xr ny;
    private boolean x;

    public ab(lm lmVar, Context context) {
        this.f3767ms = lmVar;
        this.xr = context;
    }

    public void ms(boolean z) {
        this.x = z;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        this.ny = xrVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.video.nativevideo.ab abVar) {
        this.ab = abVar;
    }

    public void xr(boolean z) {
        this.c = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        com.bytedance.sdk.openadsdk.core.xr.xr xrVar;
        if (!d() || (xrVar = this.ny) == null) {
            return 0;
        }
        com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr xrVar2 = (com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) xrVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class);
        final com.bytedance.sdk.openadsdk.core.xr.ms.ms.c cVarXr = xrVar2.xr();
        final com.bytedance.sdk.openadsdk.core.xr.ms.ms.ka kaVarAh = xrVar2.ah();
        final boolean zXr = nw.xr(this.f3767ms);
        final String strHi = zXr ? cVarXr.hi() : f.ms(cVarXr.ny());
        cVarXr.ms(strHi);
        cVarXr.xr(zXr);
        kaVarAh.ms(this.f3767ms, map);
        if (d.ms(this.f3767ms, false)) {
            new d(this.f3767ms, this.xr).ms(strHi).ms(new d.ms() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.ab.1
                @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms
                public void ms() {
                    ab.this.ms(cVarXr, map, zXr, kaVarAh, strHi, ahVar);
                }
            });
            return 1;
        }
        ms(cVarXr, map, zXr, kaVarAh, strHi, ahVar);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final com.bytedance.sdk.openadsdk.core.xr.ms.ms.c cVar, final Map<String, Object> map, final boolean z, final com.bytedance.sdk.openadsdk.core.xr.ms.ms.ka kaVar, final String str, final com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        final com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms msVarMs = cVar.ms();
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.ab.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms msVar = msVarMs;
                if (msVar != null) {
                    msVar.ms(ab.this.d, cVar.d());
                }
            }
        });
        int iMs = com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.f3767ms, new com.bytedance.sdk.openadsdk.core.live.ms.ah() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.ab.3
            @Override // com.bytedance.sdk.openadsdk.core.live.ms.ah
            public void ms() {
                ab.this.xr(map, ahVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.live.ms.ah
            public void ms(int i) {
                ab.this.xr(cVar, map, z, kaVar, str, ahVar);
            }
        }, cVar.hi());
        if (iMs == 1 || iMs == 2) {
            xr(map, ahVar);
        } else {
            xr(cVar, map, z, kaVar, str, ahVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(com.bytedance.sdk.openadsdk.core.xr.ms.ms.c cVar, Map<String, Object> map, boolean z, com.bytedance.sdk.openadsdk.core.xr.ms.ms.ka kaVar, String str, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        if (!ms(cVar, map) ? kaVar.ms(map, z, str, true, true, false) : true) {
            xr(map, ahVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.ny.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map, ahVar);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) this.ny.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class)).ms(map, ahVar);
    }

    private boolean d() {
        return ka() && xr(this.d) && !this.c;
    }

    private boolean xr(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof NativeVideoTsView) || view.getId() == 2114387961 || view.getId() == 2114387670 || view.getId() == 2114387957 || view.getId() == 2114387770 || view.getId() == 2114387692 || view.getId() == 2114387632) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (xr(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean ka() {
        if (this.f3767ms == null || c() || !lm.xr(this.f3767ms)) {
            return false;
        }
        if (this.ka == 0) {
            this.ka = f.x(this.f3767ms);
        }
        ms();
        ah();
        xr();
        if (this.ka == 5 && ab() && ah() && !ms() && !xr()) {
            return false;
        }
        int i = this.ka;
        return i == 1 || i == 2 || i == 5;
    }

    private boolean c() {
        return this.x;
    }

    public boolean ms() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.ab abVar = this.ab;
        if (abVar == null) {
            return false;
        }
        return abVar.ms();
    }

    public boolean xr() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.ab abVar = this.ab;
        if (abVar == null) {
            return false;
        }
        return abVar.xr();
    }

    protected boolean ah() {
        if (this.f3767ms == null) {
            return true;
        }
        int iAb = re.xr().ab(f.ny(this.f3767ms));
        if (iAb == 1) {
            return u.d(this.xr);
        }
        if (iAb == 2) {
            return u.ka(this.xr) || u.d(this.xr) || u.c(this.xr);
        }
        if (iAb != 3) {
            return iAb != 5 || u.d(this.xr) || u.c(this.xr);
        }
        return false;
    }

    private boolean ab() {
        return this.f3767ms != null && this.f3767ms.ti() == 1 && lm.xr(this.f3767ms);
    }

    private boolean ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.c cVar, Map<String, Object> map) {
        int i;
        String strT;
        com.bytedance.sdk.openadsdk.core.live.xr xrVarMs = com.bytedance.sdk.openadsdk.core.live.xr.ms();
        HashMap map2 = new HashMap(2);
        map2.put("event_tag", cVar != null ? cVar.hi() : "");
        if (this.ah != null && (strT = this.ah.t()) != null) {
            map2.put("dpa_tag", strT);
        }
        com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.d, this.f3767ms.ml(), map2, map);
        int iMs = xrVarMs.ms(this.xr, this.f3767ms, map2);
        int i2 = iMs & 255;
        if (map != null && (i = (iMs & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) > 0) {
            map.put("click_saas_action", Integer.valueOf(i));
        }
        return i2 == 0;
    }
}
