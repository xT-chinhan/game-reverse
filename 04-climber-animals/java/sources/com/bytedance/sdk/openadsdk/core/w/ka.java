package com.bytedance.sdk.openadsdk.core.w;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.anythink.core.common.e.f;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.umeng.analytics.pro.bv;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@ATS(single = true, value = {"pitaya"})
public class ka implements com.bytedance.sdk.openadsdk.core.jw.ms.xr, ah {
    private EventListener ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private AtomicBoolean f3682ms = new AtomicBoolean(false);
    private AtomicBoolean xr = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.w.ah
    @ATSMethod(5)
    public void ms(String str, com.bytedance.sdk.component.x.ms.xr xrVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(long j, d dVar) {
        u.ms().ms(j, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.core.jw.ms msVarD = com.bytedance.sdk.openadsdk.core.ch.ub().d();
        if (msVarD != null) {
            msVarD.ms(this);
        }
    }

    private Bridge ab() {
        Bridge bridgeMs = re.ms(AVMDLDataLoader.KeyIsStoRingBufferSizeKB);
        if (bridgeMs != null && d()) {
            return bridgeMs;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
    public void xr() {
        Bridge bridgeAb;
        try {
            if (com.bytedance.sdk.openadsdk.core.ch.ub().cv() || (bridgeAb = ab()) == null) {
                return;
            }
            bridgeAb.call(PointerIconCompat.TYPE_TEXT, com.bykv.ms.ms.ms.ms.xr.ms().ms(36, 0).xr(), null);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
    public void ms() {
        Bridge bridgeAb;
        try {
            if (com.bytedance.sdk.openadsdk.core.ch.ub().cv() || (bridgeAb = ab()) == null) {
                return;
            }
            bridgeAb.call(PointerIconCompat.TYPE_TEXT, com.bykv.ms.ms.ms.ms.xr.ms().ms(36, 1).xr(), null);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ah
    @ATSMethod(3)
    public boolean d() {
        return this.xr.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ah
    @ATSMethod(4)
    public void ms(final String str, JSONObject jSONObject, EventListener eventListener) {
        Bridge bridgeMs = re.ms(AVMDLDataLoader.KeyIsStoRingBufferSizeKB);
        if (bridgeMs == null) {
            if (eventListener != null) {
                eventListener.onEvent(8, new Result() { // from class: com.bytedance.sdk.openadsdk.core.w.ka.1
                    @Override // com.bykv.vk.openvk.api.proto.Result
                    public int code() {
                        return -6;
                    }

                    @Override // com.bykv.vk.openvk.api.proto.Result
                    public boolean isSuccess() {
                        return false;
                    }

                    @Override // com.bykv.vk.openvk.api.proto.Result
                    public String message() {
                        return "predict bridge is null";
                    }

                    @Override // com.bykv.vk.openvk.api.proto.Result
                    public ValueSet values() {
                        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
                        xrVarMs.ms(5, str);
                        return xrVarMs.xr();
                    }
                });
            }
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("run_package_start", System.currentTimeMillis());
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
            bridgeMs.call(1003, com.bykv.ms.ms.ms.ms.xr.ms().ms(25, str).ms(26, jSONObject).ms(1, eventListener).ms(37, jSONObject2).xr(), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ah
    @ATSMethod(1)
    public void ms(Context context, final EventListener eventListener) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Bridge bridgeMs = re.ms(AVMDLDataLoader.KeyIsStoRingBufferSizeKB);
        if (bridgeMs == null) {
            if (eventListener != null) {
                eventListener.onEvent(-1, null);
                return;
            }
            return;
        }
        if (d()) {
            if (eventListener != null) {
                eventListener.onEvent(0, null);
                return;
            }
            return;
        }
        try {
            if (this.f3682ms.compareAndSet(false, true)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("aid", "1371");
                jSONObject.put("channel", g.c);
                jSONObject.put("core_api_version", g.ah);
                jSONObject.put("core_plugin_version", "6.9.2.3");
                jSONObject.put("debug", false);
                jSONObject.put("update", true);
                jSONObject.put("download_concurrency", 2);
                jSONObject.put("py_concurrency", 2);
                jSONObject.put("provide_applog", true);
                jSONObject.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.t.xr.f3363ms);
                x();
                bridgeMs.call(1001, com.bykv.ms.ms.ms.ms.xr.ms().ms(21, jSONObject).ms(22, context).ms(38, this.ah).ms(1, new ab() { // from class: com.bytedance.sdk.openadsdk.core.w.ka.2
                    @Override // com.bytedance.sdk.openadsdk.core.w.ab
                    protected ValueSet ms(int i, d dVar) {
                        ka.this.xr.set(dVar.ms());
                        if (!dVar.ms()) {
                            if (dVar.xr() != null) {
                                com.bytedance.sdk.component.utils.sl.d("pitaya_ext_plugin", "pit error:" + dVar.xr().toString());
                            }
                            EventListener eventListener2 = eventListener;
                            if (eventListener2 != null) {
                                eventListener2.onEvent(-1, null);
                            }
                        } else {
                            EventListener eventListener3 = eventListener;
                            if (eventListener3 != null) {
                                eventListener3.onEvent(0, null);
                            }
                            ka.this.c();
                        }
                        ka.this.ms(System.currentTimeMillis() - jCurrentTimeMillis, dVar);
                        return super.ms(i, dVar);
                    }
                }).ms(13, com.bytedance.sdk.component.ch.ab.ms()).xr(), null);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.d("pitaya_ext_plugin", "pit#initPit:" + th.getMessage());
            if (eventListener != null) {
                eventListener.onEvent(-1, null);
            }
        }
    }

    private void x() {
        if (this.ah == null) {
            this.ah = new ab() { // from class: com.bytedance.sdk.openadsdk.core.w.ka.3
                @Override // com.bytedance.sdk.openadsdk.core.w.ab, com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i, Result result) {
                    try {
                        if (i == 1) {
                            JSONObject jSONObject = (JSONObject) result.values().objectValue(10, JSONObject.class);
                            ms.ms().ms(jSONObject.optString(bv.e), jSONObject.optString(f.a.b), jSONObject.optString(f.a.d));
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("success", true);
                            return com.bykv.ms.ms.ms.ms.xr.ms().ms(37, jSONObject2).xr();
                        }
                        if (i == 2) {
                            JSONObject jSONObject3 = (JSONObject) result.values().objectValue(10, JSONObject.class);
                            String strOptString = jSONObject3.optString(bv.e);
                            String strOptString2 = jSONObject3.optString(f.a.b);
                            String strMs = ms.ms().ms(strOptString, strOptString2);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put(strOptString2, strMs);
                            return com.bykv.ms.ms.ms.ms.xr.ms().ms(37, jSONObject4).xr();
                        }
                        return super.onEvent(i, result);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.sl.ms(e);
                        return com.bykv.ms.ms.ms.ms.xr.ms().ms(37, new JSONObject()).xr();
                    }
                }
            };
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ah
    @ATSMethod(2)
    public boolean ah() {
        if (!g.ms() || g.xr < 5003 || Build.VERSION.SDK_INT < 28) {
            return false;
        }
        if (ka() && Build.VERSION.SDK_INT == 29) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.y.xr.xr(re.xr().of());
    }

    public boolean ka() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ah
    @ATSMethod(6)
    public void ms(String str, EventListener eventListener) {
        Bridge bridgeMs = re.ms(AVMDLDataLoader.KeyIsStoRingBufferSizeKB);
        if (bridgeMs != null) {
            com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
            xrVarMs.ms(1, eventListener);
            xrVarMs.ms(25, str);
            bridgeMs.call(1004, xrVarMs.xr(), null);
        }
    }
}
