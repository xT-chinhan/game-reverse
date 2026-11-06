package com.bytedance.sdk.openadsdk.x;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bytedance.sdk.component.c.ah.ka;
import com.bytedance.sdk.component.c.d;
import com.bytedance.sdk.component.c.ub;
import com.bytedance.sdk.component.c.zb;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.c;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.op.ny;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    @ATSMethod
    public static Context getContext() {
        return re.getContext();
    }

    @ATSMethod
    public static ub ms(Context context, zb zbVar) {
        return com.bytedance.sdk.component.c.ah.xr.ms(context, zbVar);
    }

    @ATSMethod
    public static zb ms() {
        return new ka.ms().ms(new com.bytedance.sdk.component.c.ah.ms.ms(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760), AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE), 0, 41943040L, true, true, new File(ny.c()))).ms(ab.ms()).ms(new d() { // from class: com.bytedance.sdk.openadsdk.x.ms.1
            @Override // com.bytedance.sdk.component.c.d
            public com.bytedance.sdk.component.c.xr.d call(com.bytedance.sdk.component.c.ka kaVar) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                sl slVarC = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c();
                u uVarXr = new u.ms().ms(kaVar.ms()).ms().ms("csj_client_source_from", "2").xr();
                ao aoVar = null;
                com.bytedance.sdk.component.c.xr.ka kaVar2 = kaVar.ah() ? new com.bytedance.sdk.component.c.xr.ka() : null;
                if (kaVar2 != null) {
                    kaVar2.ms(jCurrentTimeMillis);
                }
                try {
                    ao aoVarMs = slVarC.ms(uVarXr).ms();
                    if (kaVar2 != null) {
                        try {
                            kaVar2.xr(System.currentTimeMillis());
                        } catch (Throwable th) {
                            th = th;
                            aoVar = aoVarMs;
                            try {
                                return ms(kaVar2, th);
                            } finally {
                                com.bytedance.sdk.component.c.ah.ah.xr.ms(aoVar);
                            }
                        }
                    }
                    if (kaVar.d() != null) {
                        kaVar.d().ms(3, null);
                    }
                    Map<String, String> mapMs = ms(kaVar, aoVarMs);
                    byte[] bArrD = aoVarMs.c().d();
                    mapMs.put("image_size", String.valueOf(bArrD == null ? 0 : bArrD.length));
                    com.bytedance.sdk.component.c.xr.d dVar = new com.bytedance.sdk.component.c.xr.d(aoVarMs.ah(), bArrD, "", mapMs);
                    if (kaVar2 != null) {
                        kaVar2.ah(System.currentTimeMillis());
                    }
                    dVar.ms(kaVar2);
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(aoVarMs);
                    return dVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            private Map<String, String> ms(com.bytedance.sdk.component.c.ka kaVar, ao aoVar) {
                HashMap map = new HashMap();
                if (kaVar.xr()) {
                    c cVarAb = aoVar.ab();
                    int iMs = cVarAb.ms();
                    for (int i = 0; i < iMs; i++) {
                        String strMs = cVarAb.ms(i);
                        String strXr = cVarAb.xr(i);
                        if (strMs != null) {
                            map.put(strMs, strXr);
                        }
                    }
                }
                return map;
            }

            private com.bytedance.sdk.component.c.xr.d ms(com.bytedance.sdk.component.c.xr.ka kaVar, Throwable th) {
                com.bytedance.sdk.component.utils.sl.xr("ImageConfig", th.getMessage());
                if (kaVar != null) {
                    kaVar.ah(System.currentTimeMillis());
                }
                com.bytedance.sdk.component.c.xr.d dVar = new com.bytedance.sdk.component.c.xr.d(0, th, "net failed");
                dVar.ms(kaVar);
                return dVar;
            }
        }).ms();
    }
}
