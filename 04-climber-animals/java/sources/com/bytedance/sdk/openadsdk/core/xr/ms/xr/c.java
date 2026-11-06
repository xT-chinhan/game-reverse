package com.bytedance.sdk.openadsdk.core.xr.ms.xr;

import android.content.Context;
import androidx.core.view.MotionEventCompat;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends xr {
    private int ab;
    private com.bytedance.sdk.openadsdk.core.xr.d c;
    private String ka;

    public static boolean xr(int i) {
        switch (i) {
            case 101:
            case 102:
            case 103:
            case 104:
                return true;
            default:
                return false;
        }
    }

    public c() {
    }

    public c(lm lmVar, Context context, com.bytedance.sdk.openadsdk.core.xr.d dVar) {
        this.f3767ms = lmVar;
        this.xr = context;
        this.c = dVar;
        ms();
    }

    public void ms(String str) {
        this.ka = str;
    }

    public void ms(i iVar) {
        try {
            this.ab = iVar.ms().optInt("live_saas_param_interaction_type", -1);
            Object[] objArr = new Object[1];
            iVar.ms();
        } catch (Exception unused) {
        }
    }

    public void ms(int i) {
        this.ab = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        boolean zXr;
        try {
            zXr = xr(map, ahVar);
        } catch (Throwable unused) {
            zXr = false;
        }
        ms();
        return zXr ? 1 : 0;
    }

    public void ms() {
        if (this.f3767ms != null) {
            this.ab = this.f3767ms.ku();
        } else {
            this.ab = -1;
        }
    }

    private boolean xr(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        String strT;
        if (this.ab < 2) {
            return false;
        }
        HashMap map2 = new HashMap(2);
        if (xr(this.ab)) {
            map2.put("live_saas_param_interaction_type", Integer.valueOf(this.ab));
        }
        map2.put("event_tag", this.ka);
        if (this.ah != null && (strT = this.ah.t()) != null) {
            map2.put("dpa_tag", strT);
        }
        com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.d, this.f3767ms.ml(), map2, map);
        int iMs = com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.xr, this.f3767ms, map2);
        int i = iMs & 255;
        int i2 = (iMs & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (i2 > 0) {
            map.put("click_saas_action", Integer.valueOf(i2));
        }
        if (i != 0) {
            return false;
        }
        ah(map, ahVar);
        return true;
    }

    private void ah(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        com.bytedance.sdk.openadsdk.core.xr.d dVar = this.c;
        if (dVar != null) {
            try {
                com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr xrVar = (com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) dVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class);
                if (xrVar != null && xrVar.xr() != null) {
                    final com.bytedance.sdk.openadsdk.core.xr.ms.ms.c cVarXr = xrVar.xr();
                    final com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms msVarMs = cVarXr.ms();
                    com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms msVar = msVarMs;
                            if (msVar != null) {
                                msVar.ms(c.this.d, cVarXr.d());
                            }
                        }
                    });
                }
            } catch (Exception e) {
                sl.ms(e);
            }
            if (((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.c.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map, ahVar) == 0) {
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) this.c.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class)).ms(map, ahVar);
            }
        }
    }

    public static void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        c cVar;
        if (xrVar == null) {
            cVar = null;
        } else {
            try {
                cVar = (c) xrVar.ms(c.class);
            } catch (NullPointerException unused) {
                return;
            }
        }
        if (cVar != null) {
            cVar.ms();
        }
    }
}
