package com.byazt.ay;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.byazt.bw.x;
import com.byazt.dea.uc;
import com.byazt.xjg.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.ILiveAdCustomConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 786, 20})
public final class hn implements Function<SparseArray<Object>, Object> {
    public static final String TAG = "TTLiveSDkBridge";
    public static final hn pr = new hn();
    public volatile ILiveInitCallback c;
    public Map<String, String> hn;
    public volatile Function<SparseArray<Object>, Object> hw;
    public volatile C0022hn x;

    private hn() {
    }

    public static hn pr() {
        return pr;
    }

    public static Function<SparseArray<Object>, Object> pr(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new pr(iLiveAdCustomConfig);
    }

    public void pr(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.hn = map;
    }

    private Map<String, String> hw(Map map) {
        Object obj = map.get("live_tob_init_extra");
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new HashMap();
    }

    private void hn(Map map) {
        ILiveHostContextParam.Builder builderAddHostInitExtra = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get(NativeUnifiedADAppInfoImpl.Keys.APP_NAME))).setChannel(String.valueOf(map.get("channel"))).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.byazt.ay.hn.1
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (hn.this.hw != null) {
                    return hn.this.hw.apply(com.byazt.ij.hn.pr().pr(0, str).pr(1, map2).pr(-99999987, 0).hw().sparseArray());
                }
                return null;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }
        }).setPartnerSecret("p_secret").setHostPermission(new com.byazt.ls.pr(x(map))).setHostActionParam(new com.byazt.ls.hw(this.hw)).addHostInitExtra(hw(map));
        Map<String, String> map2 = this.hn;
        if (map2 != null) {
            builderAddHostInitExtra.addHostInitExtra(map2);
        }
        if (this.c == null) {
            this.c = new hw();
        }
        if (TTAppContextHolder.getContext() instanceof Application) {
            builderAddHostInitExtra.setContext((Application) TTAppContextHolder.getContext());
        }
        boolean zBooleanValue = Boolean.valueOf(String.valueOf(map.get("sub_process"))).booleanValue();
        uc.pr(TAG, "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.byazt.ay.hw.pr(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), builderAddHostInitExtra, this.c, zBooleanValue)), " subProcess=", Boolean.valueOf(zBooleanValue));
    }

    public <T> T pr(int i, Map<String, Object> map) {
        switch (i) {
            case 0:
                if (!com.byazt.ay.hw.pr(getContext(map.get(d.R)), pr(map.get("bundle")))) {
                    return (T) 2;
                }
                return (T) 0;
            case 7:
                return (T) c(map);
            case 8:
                return (T) uc(map);
            default:
                return null;
        }
    }

    private Function<SparseArray<Object>, Object> x(Map map) {
        return ho.pr(map.get("c_control"));
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Bundle pr(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    private Object c(Map<String, Object> map) {
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
                        Object obj = objArr[i];
                        if (obj instanceof Function) {
                            objArr[i] = new com.byazt.ay.pr((Function) obj);
                        }
                    }
                    return liveRoomService.callExpandMethod(str, objArr);
                }
                return liveRoomService.callExpandMethod(str, new Object[0]);
            } catch (Throwable th) {
                th = th;
                pr("invokeLiveExpandMethod-".concat(String.valueOf(str)), th);
                uc.hw(TAG, th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    private Boolean uc(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get(d.R));
            Uri uri = Uri.parse(str);
            if (uri != null && context != null) {
                return Boolean.valueOf(com.byazt.ay.hw.pr(context, uri));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            pr("handleLiveScheme", th);
            uc.hw(TAG, th);
            return Boolean.FALSE;
        }
    }

    public static void pr(String str, Throwable th) {
        try {
            TTAdManager adManager = TTAdSdk.getAdManager();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", str);
            if (th != null) {
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, Log.getStackTraceString(th));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", "exception");
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        } catch (Exception e) {
            uc.hw(TAG, e);
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        int iIntValue = valueSetHw.intValue(-99999987);
        switch (iIntValue) {
            case -99999986:
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(10000, 2);
                return sparseArray2;
            case 5:
                hn((Map) valueSetHw.objectValue(0, Map.class));
                return null;
            case 9:
                this.hw = ho.pr(valueSetHw.objectValue(0, Object.class));
                if (this.x != null) {
                    if (this.x.pr != 2 && this.x.pr != -3) {
                        if (this.x.pr != 0) {
                            this.x.pr(this.x.pr, null, null, null, true);
                        }
                    } else {
                        this.x.pr(this.x.pr, this.x.hw, true);
                    }
                } else {
                    this.x = new C0022hn();
                    Function<SparseArray<Object>, Object> functionPr = ho.pr(x.pr().apply(com.byazt.ij.hn.pr(2).pr(0, 4).pr(-99999987, 10).hw().sparseArray()));
                    ValueSet valueSetHw2 = com.byazt.ij.hn.pr(2).pr(-99999987, 106).pr(0, this.x).hw();
                    if (functionPr != null) {
                        functionPr.apply(valueSetHw2.sparseArray());
                    }
                }
                return null;
            default:
                return pr(iIntValue, (Map<String, Object>) valueSetHw.objectValue(0, Map.class));
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 786, 116})
    private static final class pr implements Function<SparseArray<Object>, Object> {
        public ILiveAdCustomConfig pr;

        public pr(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.pr = iLiveAdCustomConfig;
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            switch (((Integer) sparseArray.get(-99999987)).intValue()) {
                case -99999986:
                    return com.byazt.ij.hn.pr().pr(10000, 1).hw().sparseArray();
                case 0:
                    return Integer.valueOf(this.pr.openLR((String) sparseArray.get(0)));
                case 1:
                    return this.pr.convertToEnterFromMerge(((Integer) sparseArray.get(0)).intValue());
                case 2:
                    return this.pr.convertToEnterMethod(((Integer) sparseArray.get(0)).intValue(), ((Boolean) sparseArray.get(1)).booleanValue());
                case 3:
                    return this.pr.invoke(((Integer) sparseArray.get(0)).intValue(), (Bundle) sparseArray.get(1));
                case 4:
                    this.pr.onEventV3((String) sparseArray.get(0), (JSONObject) sparseArray.get(1));
                    return null;
                case 5:
                    return this.pr;
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.ay.hn$hn, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 786, MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET})
    private final class C0022hn implements TTPluginListener {
        public String hw;
        public int pr;

        private C0022hn() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle) {
            pr(i, classLoader, resources, bundle, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pr(int i, ClassLoader classLoader, Resources resources, Bundle bundle, boolean z) {
            this.pr = i;
            if (hn.this.hw != null) {
                hn.this.hw.apply(com.byazt.ij.hn.pr().pr(0, i).pr(1, classLoader).pr(2, resources).pr(3, bundle).pr(4, hn.this.pr(z)).pr(-99999987, 3).hw().sparseArray());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pr(int i, String str, boolean z) {
            this.pr = i;
            this.hw = str;
            if (hn.this.hw != null) {
                com.byazt.ij.hn hnVarPr = com.byazt.ij.hn.pr().pr(0, i);
                if (str != null) {
                    hnVarPr.pr(1, str);
                }
                hnVarPr.pr(2, hn.this.pr(z)).pr(-99999987, 2);
                hn.this.hw.apply(hnVarPr.hw().sparseArray());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 786, 506})
    private final class hw implements ILiveInitCallback {
        private hw() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            uc.hw(hn.TAG, "onLiveInitFinish!");
            com.byazt.ay.hw.pr();
            if (hn.this.x != null) {
                hn.this.x.pr(2, null, false);
            }
            hn.this.hn = null;
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(String str) {
            uc.pr(hn.TAG, "onLiveInitFailed! ", str);
            if (hn.this.x != null) {
                hn.this.x.pr(-3, str, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map pr(boolean z) {
        HashMap map = new HashMap();
        map.put("onlyUpdateState", Boolean.valueOf(z));
        return map;
    }
}
