package com.anythink.network.ks;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.SdkConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class KSATInitManager extends ATInitMediation {
    static final int a = 0;
    static final int b = 1;
    static final int c = 2;
    static final int d = 3;
    static final int e = 4;
    private static final String i = "KSATInitManager";
    private static volatile KSATInitManager j;
    Boolean f;
    Boolean g;
    private boolean l;
    private List<MediationInitCallback> n;
    private KSATCustomController o;
    private final Object k = new Object();
    private Map<String, WeakReference> p = new ConcurrentHashMap();
    int h = 0;
    private AtomicBoolean m = new AtomicBoolean(false);

    @Override // com.anythink.core.api.ATInitMediation
    public String getAdapterVersion() {
        return "UA_6.5.10";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Kuaishou";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.kwad.sdk.api.KsAdSDK";
    }

    static /* synthetic */ boolean a(KSATInitManager kSATInitManager) {
        kSATInitManager.l = true;
        return true;
    }

    private KSATInitManager() {
    }

    protected final void a(String str, WeakReference weakReference) {
        try {
            this.p.put(str, weakReference);
        } catch (Throwable unused) {
        }
    }

    private void a() {
        try {
            for (Map.Entry<String, WeakReference> entry : this.p.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.p.remove(entry.getKey());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static KSATInitManager getInstance() {
        if (j == null) {
            synchronized (KSATInitManager.class) {
                if (j == null) {
                    j = new KSATInitManager();
                }
            }
        }
        return j;
    }

    public void setKSATCustomController(KSATCustomController kSATCustomController) {
        if (kSATCustomController != null) {
            this.o = kSATCustomController;
        }
    }

    public void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    public void setPersonalRecommend(boolean z) {
        this.f = Boolean.valueOf(z);
    }

    public void setProgrammaticRecommend(boolean z) {
        this.g = Boolean.valueOf(z);
    }

    final void a(Context context, final Map<String, Object> map, final Map<String, Object> map2, final ATBidRequestInfoListener aTBidRequestInfoListener, final int i2) {
        initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATInitManager.2
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                KSATInitManager.this.runOnThreadPool(new Runnable() { // from class: com.anythink.network.ks.KSATInitManager.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        KSBidRequestInfo kSBidRequestInfo = new KSBidRequestInfo(map, map2, i2);
                        if (!kSBidRequestInfo.isValid()) {
                            if (aTBidRequestInfoListener != null) {
                                aTBidRequestInfoListener.onFailed(ATBidRequestInfo.BIDTOKEN_EMPTY_ERROR_TYPE);
                            }
                        } else if (aTBidRequestInfoListener != null) {
                            aTBidRequestInfoListener.onSuccess(kSBidRequestInfo);
                        }
                    }
                });
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                ATBidRequestInfoListener aTBidRequestInfoListener2 = aTBidRequestInfoListener;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onFailed(ATBidRequestInfo.INIT_ERROR_TYPE);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int i2 = this.h;
        boolean zBooleanValue = i2 != 2;
        boolean zBooleanValue2 = i2 != 2;
        Boolean bool = this.f;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        }
        Boolean bool2 = this.g;
        if (bool2 != null) {
            zBooleanValue2 = bool2.booleanValue();
        }
        KsAdSDK.setPersonalRecommend(zBooleanValue);
        KsAdSDK.setProgrammaticRecommend(zBooleanValue2);
        if (ATSDK.isNetworkLogDebug()) {
            String str = i;
            Log.i(str, "PersonalRecommend: ".concat(String.valueOf(zBooleanValue)));
            Log.i(str, "ProgrammaticRecommend: ".concat(String.valueOf(zBooleanValue2)));
        }
    }

    public String getPayloadInfo(String str, double d2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getJSONArray("adBids").getJSONObject(0).put("bidEcpm", d2);
            str = jSONObject.toString();
            Log.i(i, jSONObject.toString());
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    private void a(boolean z, String str, String str2) {
        synchronized (this.k) {
            int size = this.n.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediationInitCallback mediationInitCallback = this.n.get(i2);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            this.n.clear();
            this.m.set(false);
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return KSATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public Map<String, Boolean> getPluginClassStatus() {
        HashMap map = new HashMap();
        map.put("recyclerview-*.aar", Boolean.FALSE);
        try {
            map.put("recyclerview-*.aar", Boolean.TRUE);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return map;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getResourceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ksad_reward_order_end_dialog");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        try {
            for (Map.Entry<String, WeakReference> entry : this.p.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.p.remove(entry.getKey());
                }
            }
        } catch (Throwable unused) {
        }
        String stringFromMap = getStringFromMap(map, "app_id");
        Context applicationContext = context.getApplicationContext();
        try {
            this.h = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused2) {
        }
        if (TextUtils.isEmpty(stringFromMap)) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onFail("Kuaishou init failed with empty app_id");
                return;
            }
            return;
        }
        if (TextUtils.equals(stringFromMap, KsAdSDK.getAppId()) && this.l) {
            b();
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        synchronized (this.k) {
            if (this.m.get()) {
                if (mediationInitCallback != null) {
                    this.n.add(mediationInitCallback);
                }
                return;
            }
            if (this.n == null) {
                this.n = new ArrayList();
            }
            this.m.set(true);
            if (mediationInitCallback != null) {
                this.n.add(mediationInitCallback);
            }
            SdkConfig.Builder builder = new SdkConfig.Builder();
            builder.appId(stringFromMap);
            KSATCustomController kSATCustomController = this.o;
            if (kSATCustomController != null) {
                builder.canReadICCID(kSATCustomController.getCanReadICCID());
                builder.canReadMacAddress(this.o.getCanReadMacAddress());
                builder.canReadNearbyWifiList(this.o.getCanReadNearbyWifiList());
                if (this.o.getKsCustomeController() != null) {
                    builder.customController(this.o.getKsCustomeController());
                }
            }
            builder.setStartCallback(new KsInitCallback() { // from class: com.anythink.network.ks.KSATInitManager.1
                @Override // com.kwad.sdk.api.KsInitCallback
                public final void onSuccess() {
                    KSATInitManager.this.runOnThreadPool(new Runnable() { // from class: com.anythink.network.ks.KSATInitManager.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            KSATInitManager.a(KSATInitManager.this);
                            KSATInitManager.this.b();
                            KSATInitManager.a(KSATInitManager.this, true, null, null);
                        }
                    });
                }

                @Override // com.kwad.sdk.api.KsInitCallback
                public final void onFail(final int i2, final String str) {
                    KSATInitManager.this.runOnThreadPool(new Runnable() { // from class: com.anythink.network.ks.KSATInitManager.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            KSATInitManager.a(KSATInitManager.this, false, new StringBuilder().append(i2).toString(), str);
                        }
                    });
                }
            });
            this.l = false;
            KsAdSDK.init(applicationContext, builder.build());
            KsAdSDK.start();
        }
    }

    static /* synthetic */ void a(KSATInitManager kSATInitManager, boolean z, String str, String str2) {
        synchronized (kSATInitManager.k) {
            int size = kSATInitManager.n.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediationInitCallback mediationInitCallback = kSATInitManager.n.get(i2);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            kSATInitManager.n.clear();
            kSATInitManager.m.set(false);
        }
    }
}
