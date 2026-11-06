package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.ah.d;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import com.bytedance.sdk.openadsdk.api.ab;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.g;
import com.umeng.ccg.a;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ah implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ah f3928ms = new ah();
    private Map<String, String> ah;
    private volatile xr d;
    private volatile Function<SparseArray<Object>, Object> xr;

    private ah() {
    }

    public static ah ms() {
        return f3928ms;
    }

    public static Function<SparseArray<Object>, Object> ms(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new ms(iLiveAdCustomConfig);
    }

    public void ms(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.ah = map;
    }

    private Map<String, String> xr(Map map) {
        Object obj = map.get("live_tob_init_extra");
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new HashMap();
    }

    private void ah(Map map) {
        ILiveHostContextParam.Builder builderAddHostInitExtra = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.ah.1
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (ah.this.xr == null) {
                    return null;
                }
                return ah.this.xr.apply(com.bykv.ms.ms.ms.ms.xr.ms().ms(0, str).ms(1, map2).ms(-99999987, 0).xr().sparseArray());
            }
        }).setPartnerSecret("p_secret").setHostPermission(new com.bytedance.sdk.openadsdk.live.ms.ms(d(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.ms.xr(this.xr)).addHostInitExtra(xr(map));
        Map<String, String> map2 = this.ah;
        if (map2 != null) {
            builderAddHostInitExtra.addHostInitExtra(map2);
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.ah.2
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFinish() {
                ab.xr("TTLiveSDkBridge", "onLiveInitFinish!");
                com.bytedance.sdk.openadsdk.live.xr.ms();
                if (ah.this.d != null) {
                    ah.this.d.ms(2, null, false);
                }
                ah.this.ah = null;
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFailed(String str) {
                ab.ms("TTLiveSDkBridge", "onLiveInitFailed! ", str);
                if (ah.this.d != null) {
                    ah.this.d.ms(-3, str, false);
                }
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            builderAddHostInitExtra.setContext((Application) TTAppContextHolder.getContext());
        }
        boolean zBooleanValue = Boolean.valueOf(String.valueOf(map.get("sub_process"))).booleanValue();
        ab.ms("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.bytedance.sdk.openadsdk.live.xr.ms(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), builderAddHostInitExtra, iLiveInitCallback, zBooleanValue)), " subProcess=", Boolean.valueOf(zBooleanValue));
    }

    public <T> T ms(int i, Map<String, Object> map) {
        if (i == 0) {
            if (!com.bytedance.sdk.openadsdk.live.xr.ms(getContext(map.get(g.X)), ms(map.get("bundle")))) {
                return (T) 2;
            }
            return (T) 0;
        }
        if (i == 7) {
            return (T) ka(map);
        }
        if (i != 8) {
            return null;
        }
        return (T) c(map);
    }

    private Function<SparseArray<Object>, Object> d(Map map) {
        return ao.ms(map.get("c_control"));
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Bundle ms(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    private Object ka(Map<String, Object> map) {
        String str;
        try {
            str = (String) map.get("expand_method_name");
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                Object[] objArr = (Object[]) map.get("expand_method_param");
                if (objArr != null) {
                    for (int i = 0; i < objArr.length; i++) {
                        if (objArr[i] instanceof Function) {
                            objArr[i] = new com.bytedance.sdk.openadsdk.live.ms((Function) objArr[i]);
                        }
                    }
                    return liveRoomService.callExpandMethod(str, objArr);
                }
                return liveRoomService.callExpandMethod(str, new Object[0]);
            } catch (Throwable th) {
                th = th;
                ms("invokeLiveExpandMethod-".concat(String.valueOf(str)), th);
                ab.xr("TTLiveSDkBridge", th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    private Boolean c(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get(g.X));
            Uri uri = Uri.parse(str);
            if (uri != null && context != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.xr.ms(context, uri));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            ms("handleLiveScheme", th);
            ab.xr("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    public static void ms(String str, Throwable th) {
        try {
            TTAdManager adManager = TTAdSdk.getAdManager();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(a.j, str);
            if (th != null) {
                jSONObject.put("msg", Log.getStackTraceString(th));
            }
            Bundle bundle = new Bundle();
            bundle.putInt(a.z, 1);
            bundle.putString("event_name", "exception");
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        } catch (Exception e) {
            ab.xr("TTLiveSDkBridge", e);
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        int iIntValue = valueSetXr.intValue(-99999987);
        if (iIntValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 2);
            return sparseArray2;
        }
        if (iIntValue == 5) {
            ah((Map) valueSetXr.objectValue(0, Map.class));
            return null;
        }
        if (iIntValue == 9) {
            this.xr = ao.ms(valueSetXr.objectValue(0, Object.class));
            if (this.d != null) {
                if (this.d.f3932ms != 2 && this.d.f3932ms != -3) {
                    if (this.d.f3932ms != 0) {
                        this.d.ms(this.d.f3932ms, null, null, null, true);
                    }
                } else {
                    this.d.ms(this.d.f3932ms, this.d.xr, true);
                }
            } else {
                this.d = new xr();
                Function<SparseArray<Object>, Object> functionMs = ao.ms(d.ms().apply(com.bykv.ms.ms.ms.ms.xr.ms(2).ms(0, 4).ms(-99999987, 10).xr().sparseArray()));
                ValueSet valueSetXr2 = com.bykv.ms.ms.ms.ms.xr.ms(2).ms(-99999987, 106).ms(0, this.d).xr();
                if (functionMs != null) {
                    functionMs.apply(valueSetXr2.sparseArray());
                }
            }
            return null;
        }
        return ms(iIntValue, (Map<String, Object>) valueSetXr.objectValue(0, Map.class));
    }

    private static final class ms implements Function<SparseArray<Object>, Object> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private ILiveAdCustomConfig f3931ms;

        ms(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.f3931ms = iLiveAdCustomConfig;
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
            if (iIntValue == -99999986) {
                return com.bykv.ms.ms.ms.ms.xr.ms().ms(10000, 1).xr().sparseArray();
            }
            if (iIntValue == 0) {
                return Integer.valueOf(this.f3931ms.openLR((String) sparseArray.get(0)));
            }
            if (iIntValue == 1) {
                return this.f3931ms.convertToEnterFromMerge(((Integer) sparseArray.get(0)).intValue());
            }
            if (iIntValue == 2) {
                return this.f3931ms.convertToEnterMethod(((Integer) sparseArray.get(0)).intValue(), ((Boolean) sparseArray.get(1)).booleanValue());
            }
            if (iIntValue == 3) {
                return this.f3931ms.invoke(((Integer) sparseArray.get(0)).intValue(), (Bundle) sparseArray.get(1));
            }
            if (iIntValue == 4) {
                this.f3931ms.onEventV3((String) sparseArray.get(0), (JSONObject) sparseArray.get(1));
                return null;
            }
            if (iIntValue != 5) {
                return null;
            }
            return this.f3931ms;
        }
    }

    private final class xr implements TTPluginListener {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f3932ms;
        String xr;

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }

        private xr() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle) {
            ms(i, classLoader, resources, bundle, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ms(int i, ClassLoader classLoader, Resources resources, Bundle bundle, boolean z) {
            this.f3932ms = i;
            if (ah.this.xr != null) {
                ah.this.xr.apply(com.bykv.ms.ms.ms.ms.xr.ms().ms(0, i).ms(1, classLoader).ms(2, resources).ms(3, bundle).ms(4, ah.this.ms(z)).ms(-99999987, 3).xr().sparseArray());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ms(int i, String str, boolean z) {
            this.f3932ms = i;
            this.xr = str;
            if (ah.this.xr != null) {
                com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms().ms(0, i);
                if (str != null) {
                    xrVarMs.ms(1, str);
                }
                xrVarMs.ms(2, ah.this.ms(z)).ms(-99999987, 2);
                ah.this.xr.apply(xrVarMs.xr().sparseArray());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map ms(boolean z) {
        HashMap map = new HashMap();
        map.put("onlyUpdateState", Boolean.valueOf(z));
        return map;
    }
}
