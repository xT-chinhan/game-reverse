package com.byazt.ea;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.byazt.ja.q;
import com.byazt.mo.k;
import com.byazt.vx.w;
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
import com.taptap.sdk.compilance.constants.ComplianceMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 8})
public final class s implements Function<SparseArray<Object>, Object> {
    public static final String TAG = "TTLiveSDkBridge";
    public static final s n = new s();
    public volatile ILiveInitCallback l;
    public volatile C0161s q;
    public volatile Function<SparseArray<Object>, Object> qg;
    public Map<String, String> s;

    private s() {
    }

    public static s n() {
        return n;
    }

    public static Function<SparseArray<Object>, Object> n(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new n(iLiveAdCustomConfig);
    }

    public void n(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.s = map;
    }

    private Map<String, String> qg(Map map) {
        Object obj = map.get("live_tob_init_extra");
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new HashMap();
    }

    private void s(Map map) {
        ILiveHostContextParam.Builder builderAddHostInitExtra = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.byazt.ea.s.1
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (s.this.qg == null) {
                    return null;
                }
                return s.this.qg.apply(com.byazt.qvu.s.n().n(0, str).n(1, map2).n(-99999987, 0).qg().sparseArray());
            }
        }).setPartnerSecret("p_secret").setHostPermission(new com.byazt.eaw.n(q(map))).setHostActionParam(new com.byazt.eaw.qg(this.qg)).addHostInitExtra(qg(map));
        Map<String, String> map2 = this.s;
        if (map2 != null) {
            builderAddHostInitExtra.addHostInitExtra(map2);
        }
        if (this.l == null) {
            this.l = new qg();
        }
        if (TTAppContextHolder.getContext() instanceof Application) {
            builderAddHostInitExtra.setContext((Application) TTAppContextHolder.getContext());
        }
        boolean zBooleanValue = Boolean.valueOf(String.valueOf(map.get("sub_process"))).booleanValue();
        w.n(TAG, "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.byazt.ea.qg.n(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), builderAddHostInitExtra, this.l, zBooleanValue)), " subProcess=", Boolean.valueOf(zBooleanValue));
    }

    public <T> T n(int i, Map<String, Object> map) {
        if (i == 0) {
            if (!com.byazt.ea.qg.n(getContext(map.get("context")), n(map.get("bundle")))) {
                return (T) 2;
            }
            return (T) 0;
        }
        if (i == 7) {
            return (T) l(map);
        }
        if (i != 8) {
            return null;
        }
        return (T) w(map);
    }

    private Function<SparseArray<Object>, Object> q(Map map) {
        return k.n(map.get("c_control"));
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Bundle n(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    private Object l(Map<String, Object> map) {
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
                            objArr[i] = new com.byazt.ea.n((Function) objArr[i]);
                        }
                    }
                    return liveRoomService.callExpandMethod(str, objArr);
                }
                return liveRoomService.callExpandMethod(str, new Object[0]);
            } catch (Throwable th) {
                th = th;
                n("invokeLiveExpandMethod-".concat(String.valueOf(str)), th);
                w.n(TAG, th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    private Boolean w(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get("context"));
            Uri uri = Uri.parse(str);
            if (uri != null && context != null) {
                return Boolean.valueOf(com.byazt.ea.qg.n(context, uri));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            n("handleLiveScheme", th);
            w.n(TAG, th);
            return Boolean.FALSE;
        }
    }

    public static void n(String str, Throwable th) {
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
            w.n(TAG, e);
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        int iIntValue = valueSetQg.intValue(-99999987);
        if (iIntValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 2);
            return sparseArray2;
        }
        if (iIntValue == 5) {
            s((Map) valueSetQg.objectValue(0, Map.class));
            return null;
        }
        if (iIntValue == 9) {
            this.qg = k.n(valueSetQg.objectValue(0, Object.class));
            if (this.q != null) {
                if (this.q.n != 2 && this.q.n != -3) {
                    if (this.q.n != 0) {
                        this.q.n(this.q.n, null, null, null, true);
                    }
                } else {
                    this.q.n(this.q.n, this.q.qg, true);
                }
            } else {
                this.q = new C0161s();
                Function<SparseArray<Object>, Object> functionN = k.n(q.n().apply(com.byazt.qvu.s.n(2).n(0, 4).n(-99999987, 10).qg().sparseArray()));
                ValueSet valueSetQg2 = com.byazt.qvu.s.n(2).n(-99999987, 106).n(0, this.q).qg();
                if (functionN != null) {
                    functionN.apply(valueSetQg2.sparseArray());
                }
            }
            return null;
        }
        return n(iIntValue, (Map<String, Object>) valueSetQg.objectValue(0, Map.class));
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 546})
    private static final class n implements Function<SparseArray<Object>, Object> {
        public ILiveAdCustomConfig n;

        public n(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.n = iLiveAdCustomConfig;
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
            if (iIntValue == -99999986) {
                return com.byazt.qvu.s.n().n(10000, 1).qg().sparseArray();
            }
            if (iIntValue == 0) {
                return Integer.valueOf(this.n.openLR((String) sparseArray.get(0)));
            }
            if (iIntValue == 1) {
                return this.n.convertToEnterFromMerge(((Integer) sparseArray.get(0)).intValue());
            }
            if (iIntValue == 2) {
                return this.n.convertToEnterMethod(((Integer) sparseArray.get(0)).intValue(), ((Boolean) sparseArray.get(1)).booleanValue());
            }
            if (iIntValue == 3) {
                return this.n.invoke(((Integer) sparseArray.get(0)).intValue(), (Bundle) sparseArray.get(1));
            }
            if (iIntValue == 4) {
                this.n.onEventV3((String) sparseArray.get(0), (JSONObject) sparseArray.get(1));
                return null;
            }
            if (iIntValue != 5) {
                return null;
            }
            return this.n;
        }
    }

    /* JADX INFO: renamed from: com.byazt.ea.s$s, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR})
    private final class C0161s implements TTPluginListener {
        public int n;
        public String qg;

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }

        private C0161s() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle) {
            n(i, classLoader, resources, bundle, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(int i, ClassLoader classLoader, Resources resources, Bundle bundle, boolean z) {
            this.n = i;
            if (s.this.qg != null) {
                s.this.qg.apply(com.byazt.qvu.s.n().n(0, i).n(1, classLoader).n(2, resources).n(3, bundle).n(4, s.this.n(z)).n(-99999987, 3).qg().sparseArray());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(int i, String str, boolean z) {
            this.n = i;
            this.qg = str;
            if (s.this.qg != null) {
                com.byazt.qvu.s sVarN = com.byazt.qvu.s.n().n(0, i);
                if (str != null) {
                    sVarN.n(1, str);
                }
                sVarN.n(2, s.this.n(z)).n(-99999987, 2);
                s.this.qg.apply(sVarN.qg().sparseArray());
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 782})
    private final class qg implements ILiveInitCallback {
        private qg() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            w.q(s.TAG, "onLiveInitFinish!");
            com.byazt.ea.qg.n();
            if (s.this.q != null) {
                s.this.q.n(2, null, false);
            }
            s.this.s = null;
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(String str) {
            w.n(s.TAG, "onLiveInitFailed! ", str);
            if (s.this.q != null) {
                s.this.q.n(-3, str, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map n(boolean z) {
        HashMap map = new HashMap();
        map.put("onlyUpdateState", Boolean.valueOf(z));
        return map;
    }
}
