package com.bytedance.sdk.openadsdk.core.video.d;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.c.ah.hi;
import com.bytedance.sdk.openadsdk.core.jw;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.w.ah;
import com.bytedance.sdk.openadsdk.core.w.ch;
import com.bytedance.sdk.openadsdk.core.w.x;
import com.bytedance.sdk.openadsdk.core.w.zb;
import com.bytedance.sdk.openadsdk.op.ab;
import com.qq.e.comm.constants.ErrorCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile com.bykv.vk.openvk.component.video.api.ka.ms f3583ms;
    private static volatile com.bykv.vk.openvk.component.video.api.ka.ms xr;

    private static boolean ah(d dVar) {
        return true;
    }

    private static boolean ms(int i) {
        return i == 3 || i == 4;
    }

    private static boolean xr(int i) {
        return i == 8 || i == 7;
    }

    private static com.bykv.vk.openvk.component.video.api.ka.ms xr(d dVar) {
        if (dVar.qv() == 1) {
            if (xr == null) {
                synchronized (xr.class) {
                    if (xr == null) {
                        xr = new com.bytedance.sdk.component.sl.xr.xr.ms();
                    }
                }
            }
            return xr;
        }
        if (f3583ms == null) {
            synchronized (xr.class) {
                if (f3583ms == null) {
                    f3583ms = new com.bykv.vk.openvk.component.video.ms.ms.xr.ms();
                }
            }
        }
        return f3583ms;
    }

    private static void xr(d dVar, com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms, lm lmVar) {
        if (interfaceC0178ms != null) {
            interfaceC0178ms.ms(dVar, -100);
        }
        if (lmVar != null) {
            if (xr(f.x(lmVar)) || ms(f.x(lmVar))) {
                ms(dVar, lmVar, 0L);
            }
        }
    }

    public static void ms(final d dVar, final com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms) {
        if (dVar == null) {
            xr(null, interfaceC0178ms, null);
            return;
        }
        dVar.c();
        dVar.zb();
        final lm lmVarMs = ms(dVar);
        if (dVar.c() <= 0 && !dVar.zb()) {
            xr(dVar, interfaceC0178ms, lmVarMs);
        } else if (ab.ms()) {
            ab.ms(new ny("csj_vPreload") { // from class: com.bytedance.sdk.openadsdk.core.video.d.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    xr.ah(dVar, interfaceC0178ms, lmVarMs);
                }
            });
        } else {
            ah(dVar, interfaceC0178ms, lmVarMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(final d dVar, final com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms, final lm lmVar) {
        try {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            int iX = lmVar != null ? f.x(lmVar) : 0;
            boolean zMs = ch.ms();
            if (xr(iX) && zMs) {
                if (re.ms(AVMDLDataLoader.KeyIsStoRingBufferSizeKB) == null) {
                    ms(dVar, interfaceC0178ms, lmVar, jCurrentTimeMillis, zMs);
                    return;
                }
                ah ahVar = (ah) AutoService.ms(ah.class);
                if (ahVar != null && ahVar.d()) {
                    final JSONObject jSONObjectMs = new zb().ms(dVar);
                    ahVar.ms("video_cache", jSONObjectMs, new com.bytedance.sdk.openadsdk.core.w.ab() { // from class: com.bytedance.sdk.openadsdk.core.video.d.xr.2
                        @Override // com.bytedance.sdk.openadsdk.core.w.ab
                        protected ValueSet ms(int i, x xVar) {
                            u.ms();
                            u.ms(xVar == null ? null : xVar.ah(), jSONObjectMs);
                            return xr.xr(i, xVar, dVar, interfaceC0178ms, jCurrentTimeMillis, lmVar);
                        }
                    });
                    return;
                } else {
                    ms(dVar, -1000, -8, "not init", (JSONObject) null, System.currentTimeMillis() - jCurrentTimeMillis);
                    d(dVar, interfaceC0178ms, lmVar);
                    return;
                }
            }
            ms(dVar, interfaceC0178ms, lmVar, jCurrentTimeMillis, zMs);
        } catch (Exception e) {
            sl.xr("pit predict error:" + e.getMessage());
        }
    }

    private static void ms(d dVar, com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms, lm lmVar, long j, boolean z) {
        ms(dVar, -1000, z ? -6 : -9, "bridge is null", (JSONObject) null, System.currentTimeMillis() - j);
        d(dVar, interfaceC0178ms, lmVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ValueSet xr(int i, x xVar, d dVar, com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms, long j, lm lmVar) {
        int i2;
        int i3;
        String string;
        try {
            if (xVar == null) {
                ms(dVar, -1000, -2, "resultModel is null", (JSONObject) null, System.currentTimeMillis() - j);
                d(dVar, interfaceC0178ms, lmVar);
                return null;
            }
            Result resultAh = xVar.ah();
            if (resultAh == null) {
                ms(dVar, -1000, -3, "result is null", (JSONObject) null, System.currentTimeMillis() - j);
                d(dVar, interfaceC0178ms, lmVar);
                return null;
            }
            ValueSet valueSetValues = resultAh.values();
            if (valueSetValues == null) {
                ms(dVar, -1000, -4, "value is null", (JSONObject) null, System.currentTimeMillis() - j);
                d(dVar, interfaceC0178ms, lmVar);
                return null;
            }
            JSONObject jSONObject = (JSONObject) valueSetValues.objectValue(2, JSONObject.class);
            valueSetValues.stringValue(5);
            JSONObject jSONObject2 = (JSONObject) valueSetValues.objectValue(3, JSONObject.class);
            JSONObject jSONObject3 = (JSONObject) valueSetValues.objectValue(4, JSONObject.class);
            if (!resultAh.isSuccess() || jSONObject == null) {
                i2 = -1000;
                i3 = -5;
                string = null;
            } else {
                int iOptInt = jSONObject.optInt("pitaya_cache_size", -1);
                int iOptInt2 = jSONObject.optInt("pitaya_code", 200);
                string = "success";
                zb.ms(dVar, jSONObject, iOptInt, iOptInt2);
                i2 = iOptInt;
                i3 = iOptInt2;
            }
            if (!resultAh.isSuccess() && jSONObject3 != null) {
                string = jSONObject3.toString();
            }
            ms(dVar, i2, i3, string, jSONObject2, System.currentTimeMillis() - j);
            d(dVar, interfaceC0178ms, lmVar);
            return null;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static void ms(d dVar, int i, int i2, String str, JSONObject jSONObject, long j) {
        JSONObject jSONObjectMs = dVar.ms();
        try {
            jSONObjectMs.put("pitaya_cache_size", i);
            jSONObjectMs.put("pitaya_code", i2);
            jSONObjectMs.put("pitaya_msg", str);
            jSONObjectMs.put("ext_plugin_code", jw.xr());
            jSONObjectMs.put("package", jSONObject);
            jSONObjectMs.put("run_task_mills", j);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static lm ms(d dVar) {
        if (dVar == null) {
            return null;
        }
        Object objKa = dVar.ka("material_meta");
        if (objKa instanceof lm) {
            return (lm) objKa;
        }
        return null;
    }

    private static void d(final d dVar, final com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms, final lm lmVar) {
        dVar.c(ErrorCode.UNKNOWN_ERROR);
        dVar.ab(ErrorCode.UNKNOWN_ERROR);
        dVar.x(ErrorCode.UNKNOWN_ERROR);
        if (lmVar != null) {
            if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
                return;
            }
            if (dVar.ah() == 400) {
                ah(dVar, lmVar);
                return;
            }
            xr(dVar, lmVar);
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms2 = new com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms() { // from class: com.bytedance.sdk.openadsdk.core.video.d.xr.3
            @Override // com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms
            public void ms(d dVar2, int i) {
                com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms3 = interfaceC0178ms;
                if (interfaceC0178ms3 != null) {
                    interfaceC0178ms3.ms(dVar2, i);
                }
                if (lmVar != null) {
                    xr.ms(dVar, lmVar, SystemClock.elapsedRealtime() - jElapsedRealtime);
                }
                sl.ms("VideoPreloadUtils", "pit onVideoPreloadSuccess: ", dVar.h());
            }

            @Override // com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms
            public void ms(d dVar2, int i, String str) {
                com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms3 = interfaceC0178ms;
                if (interfaceC0178ms3 != null) {
                    interfaceC0178ms3.ms(dVar2, i, str);
                }
                if (lmVar != null) {
                    xr.xr(dVar, lmVar, SystemClock.elapsedRealtime() - jElapsedRealtime, i, str);
                }
                sl.ms("VideoPreloadUtils", "pit onVideoPreloadFail: ", dVar.h());
            }

            @Override // com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms
            public void xr(d dVar2, int i) {
                com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms3 = interfaceC0178ms;
                if (interfaceC0178ms3 != null) {
                    interfaceC0178ms3.ms(dVar2, i);
                }
                lm lmVar2 = lmVar;
                if (lmVar2 != null) {
                    xr.ah(dVar, lmVar2);
                }
                sl.ms("VideoPreloadUtils", "pit cancel: ", dVar.h());
            }
        };
        try {
            dVar.qv();
            xr(dVar).ms(re.getContext(), dVar, interfaceC0178ms2);
        } catch (Exception e) {
            if (interfaceC0178ms != null) {
                sl.ms("VideoPreloadUtils", "pit exception onVideoPreloadFail: ", dVar.h());
                interfaceC0178ms.ms(dVar, -1, e.getMessage());
            }
            if (lmVar != null) {
                xr(dVar, lmVar, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, e.getMessage());
            }
            sl.ms(e);
        }
    }

    private static void xr(d dVar, lm lmVar) {
        if (ah(dVar)) {
            long jSl = dVar.zb() ? dVar.sl() : dVar.c();
            String strXr = f.xr(lmVar);
            JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.c.xr.d.ms(dVar, null, -1, dVar.qv(), lmVar, -1L);
            com.bytedance.sdk.openadsdk.c.ah.sl slVar = new com.bytedance.sdk.openadsdk.c.ah.sl(dVar.ao(), jSl);
            slVar.ms(dVar);
            com.bytedance.sdk.openadsdk.c.xr.d.ms((com.bytedance.sdk.openadsdk.c.ah.xr<com.bytedance.sdk.openadsdk.c.ah.sl>) new com.bytedance.sdk.openadsdk.c.ah.xr(lmVar, strXr, jSONObjectMs, slVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(d dVar, lm lmVar, long j, int i, String str) {
        if (ah(dVar)) {
            String strXr = f.xr(lmVar);
            JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.c.xr.d.ms(dVar, null, -1, dVar.qv(), lmVar, -1L);
            hi hiVar = new hi();
            hiVar.ms(dVar.ao());
            hiVar.ms(dVar.c());
            hiVar.xr(j);
            hiVar.ms(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            hiVar.xr(str);
            hiVar.ah("");
            hiVar.ms(dVar);
            com.bytedance.sdk.openadsdk.c.xr.d.ah((com.bytedance.sdk.openadsdk.c.ah.xr<hi>) new com.bytedance.sdk.openadsdk.c.ah.xr(lmVar, strXr, jSONObjectMs, hiVar));
        }
    }

    public static void ms(d dVar, lm lmVar, long j) {
        if (ah(dVar)) {
            String strXr = f.xr(lmVar);
            JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.c.xr.d.ms(dVar, null, -1, dVar.qv(), lmVar, -1L);
            com.bytedance.sdk.openadsdk.c.ah.zb zbVar = new com.bytedance.sdk.openadsdk.c.ah.zb();
            zbVar.ms(dVar.ao());
            zbVar.ms(dVar.c());
            zbVar.xr(j);
            zbVar.ms(dVar);
            if (dVar.b() == 1) {
                zbVar.ah(1L);
            } else {
                zbVar.ah(0L);
            }
            com.bytedance.sdk.openadsdk.c.xr.d.xr((com.bytedance.sdk.openadsdk.c.ah.xr<com.bytedance.sdk.openadsdk.c.ah.zb>) new com.bytedance.sdk.openadsdk.c.ah.xr(lmVar, strXr, jSONObjectMs, zbVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(d dVar, lm lmVar) {
        if (ah(dVar)) {
            String strXr = f.xr(lmVar);
            JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.c.xr.d.ms(dVar, null, -1, dVar.qv(), lmVar, -1L);
            com.bytedance.sdk.openadsdk.c.ah.ch chVar = new com.bytedance.sdk.openadsdk.c.ah.ch(dVar.ao(), dVar.c());
            chVar.ms(dVar);
            com.bytedance.sdk.openadsdk.c.xr.d.d((com.bytedance.sdk.openadsdk.c.ah.xr<com.bytedance.sdk.openadsdk.c.ah.ch>) new com.bytedance.sdk.openadsdk.c.ah.xr(lmVar, strXr, jSONObjectMs, chVar));
        }
    }
}
