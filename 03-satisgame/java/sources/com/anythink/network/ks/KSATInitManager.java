package com.anythink.network.ks;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.api.ATRewardRetryTaskContract;
import com.anythink.rewardvideo.api.ATRewardRetryTaskInfo;
import com.anythink.rewardvideo.api.ATRewardRetryTaskManager;
import com.anythink.rewardvideo.api.ATRewardRetryTaskResult;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.manager.RewardRetryTaskManager;
import com.kwad.sdk.api.model.KSAdRewardRetryTaskResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class KSATInitManager extends ATInitMediation {
    private static final String q = "KSATInitManager";
    private static volatile KSATInitManager r = null;
    private static final int s = 513;
    private static final int t = 7;
    private static final long u = 1000;
    static final int v = 0;
    static final int w = 1;
    static final int x = 2;
    static final int y = 3;
    static final int z = 4;
    private boolean b;
    private List<MediationInitCallback> d;
    private KSATCustomController e;
    private volatile String h;
    private HandlerThread k;
    private Handler l;
    Boolean n;
    Boolean o;
    private final Object a = new Object();
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private int i = 0;
    private final Object j = new Object();
    private Map<String, WeakReference> m = new ConcurrentHashMap();
    int p = 0;
    private AtomicBoolean c = new AtomicBoolean(false);

    class a implements KsInitCallback {

        /* JADX INFO: renamed from: com.anythink.network.ks.KSATInitManager$a$a, reason: collision with other inner class name */
        class RunnableC0070a implements Runnable {
            RunnableC0070a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                KSATInitManager.this.a(true, null, null, "ks_callback");
            }
        }

        class b implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ String b;

            b(int i, String str) {
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                KSATInitManager.this.a(false, "" + this.a, this.b, "ks_callback");
            }
        }

        a() {
        }

        @Override // com.kwad.sdk.api.KsInitCallback
        public void onFail(int i, String str) {
            String unused = KSATInitManager.q;
            KSATInitManager.this.runOnThreadPool(new b(i, str));
        }

        @Override // com.kwad.sdk.api.KsInitCallback
        public void onSuccess() {
            String unused = KSATInitManager.q;
            String unused2 = KSATInitManager.this.h;
            KSATInitManager.this.runOnThreadPool(new RunnableC0070a());
        }
    }

    class b implements MediationInitCallback {
        final /* synthetic */ Map a;
        final /* synthetic */ Map b;
        final /* synthetic */ int c;
        final /* synthetic */ ATBidRequestInfoListener d;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                KSBidRequestInfo kSBidRequestInfo = new KSBidRequestInfo(bVar.a, bVar.b, bVar.c);
                if (kSBidRequestInfo.isValid()) {
                    ATBidRequestInfoListener aTBidRequestInfoListener = b.this.d;
                    if (aTBidRequestInfoListener != null) {
                        aTBidRequestInfoListener.onSuccess(kSBidRequestInfo);
                        return;
                    }
                    return;
                }
                ATBidRequestInfoListener aTBidRequestInfoListener2 = b.this.d;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onFailed(ATBidRequestInfo.BIDTOKEN_EMPTY_ERROR_TYPE);
                }
            }
        }

        b(Map map, Map map2, int i, ATBidRequestInfoListener aTBidRequestInfoListener) {
            this.a = map;
            this.b = map2;
            this.c = i;
            this.d = aTBidRequestInfoListener;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onFail(String str) {
            ATBidRequestInfoListener aTBidRequestInfoListener = this.d;
            if (aTBidRequestInfoListener != null) {
                aTBidRequestInfoListener.onFailed(ATBidRequestInfo.INIT_ERROR_TYPE);
            }
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public void onSuccess() {
            KSATInitManager.this.runOnThreadPool(new a());
        }
    }

    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 513) {
                KSATInitManager.this.d();
            }
        }
    }

    class d implements ATRewardRetryTaskContract {

        class a implements RewardRetryTaskManager.RetryRewardConvertResultListener {
            final /* synthetic */ ATRewardRetryTaskContract.RetryRewardConvertResultListener a;

            a(ATRewardRetryTaskContract.RetryRewardConvertResultListener retryRewardConvertResultListener) {
                this.a = retryRewardConvertResultListener;
            }

            @Override // com.kwad.sdk.api.manager.RewardRetryTaskManager.RetryRewardConvertResultListener
            public void onError(int i, String str) {
                ATRewardRetryTaskContract.RetryRewardConvertResultListener retryRewardConvertResultListener = this.a;
                if (retryRewardConvertResultListener != null) {
                    retryRewardConvertResultListener.onError(i, str);
                }
            }

            @Override // com.kwad.sdk.api.manager.RewardRetryTaskManager.RetryRewardConvertResultListener
            public void onSuccess() {
                ATRewardRetryTaskContract.RetryRewardConvertResultListener retryRewardConvertResultListener = this.a;
                if (retryRewardConvertResultListener != null) {
                    retryRewardConvertResultListener.onSuccess();
                }
            }
        }

        class b implements RewardRetryTaskManager.RetryRewardResultListener {
            final /* synthetic */ ATRewardRetryTaskContract.RetryRewardResultListener a;

            b(ATRewardRetryTaskContract.RetryRewardResultListener retryRewardResultListener) {
                this.a = retryRewardResultListener;
            }

            @Override // com.kwad.sdk.api.manager.RewardRetryTaskManager.RetryRewardResultListener
            public void onError(int i, String str) {
                ATRewardRetryTaskContract.RetryRewardResultListener retryRewardResultListener = this.a;
                if (retryRewardResultListener != null) {
                    retryRewardResultListener.onError(i, str);
                }
            }

            @Override // com.kwad.sdk.api.manager.RewardRetryTaskManager.RetryRewardResultListener
            public void onSuccess(List<KSAdRewardRetryTaskResult> list) {
                if (this.a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<KSAdRewardRetryTaskResult> it = list.iterator();
                while (it.hasNext()) {
                    ATRewardRetryTaskResult aTRewardRetryTaskResultConvertFromKSResult = KSATInfoReversion.convertFromKSResult(it.next());
                    if (aTRewardRetryTaskResultConvertFromKSResult != null) {
                        arrayList.add(aTRewardRetryTaskResultConvertFromKSResult);
                    }
                }
                this.a.onSuccess(arrayList);
            }
        }

        d() {
        }

        @Override // com.anythink.rewardvideo.api.ATRewardRetryTaskContract
        public void rewardAdRetryTaskUpdate(ATRewardRetryTaskInfo aTRewardRetryTaskInfo, ATRewardRetryTaskContract.RetryRewardConvertResultListener retryRewardConvertResultListener) {
            if (aTRewardRetryTaskInfo == null || TextUtils.isEmpty(aTRewardRetryTaskInfo.getRequestId())) {
                if (retryRewardConvertResultListener != null) {
                    retryRewardConvertResultListener.onError(-1, "taskInfo is null or requestId is empty");
                    return;
                }
                return;
            }
            try {
                RewardRetryTaskManager.Builder.build().rewardAdRetryTaskUpdate(KSATInfoReversion.convertToKSAdInfoData(aTRewardRetryTaskInfo), new a(retryRewardConvertResultListener));
            } catch (Throwable th) {
                if (retryRewardConvertResultListener != null) {
                    retryRewardConvertResultListener.onError(-1, "Exception: " + th.getMessage());
                }
            }
        }

        @Override // com.anythink.rewardvideo.api.ATRewardRetryTaskContract
        public void setRetryRewardResultListener(List<ATRewardRetryTaskInfo> list, ATRewardRetryTaskContract.RetryRewardResultListener retryRewardResultListener) {
            if (list == null || list.isEmpty()) {
                if (retryRewardResultListener != null) {
                    retryRewardResultListener.onError(-1, "taskInfoList is null or empty");
                    return;
                }
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<ATRewardRetryTaskInfo> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(KSATInfoReversion.convertToKSAdInfoData(it.next()));
                }
                if (!arrayList.isEmpty()) {
                    RewardRetryTaskManager.Builder.build().setRetryRewardResultListener(arrayList, new b(retryRewardResultListener));
                } else if (retryRewardResultListener != null) {
                    retryRewardResultListener.onError(-1, "Failed to convert taskInfoList to KSAdInfoData list");
                }
            } catch (Throwable th) {
                if (retryRewardResultListener != null) {
                    retryRewardResultListener.onError(-1, "Exception: " + th.getMessage());
                }
            }
        }
    }

    private KSATInitManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f.get()) {
            return;
        }
        try {
            String appId = KsAdSDK.getAppId();
            boolean zHaseInit = KsAdSDK.haseInit();
            if (zHaseInit && TextUtils.equals(this.h, appId)) {
                a(true, null, null, "poll");
                return;
            }
            int i = this.i + 1;
            this.i = i;
            if (i >= 7) {
                a(false, "-1", "init timeout (no callback), haseInit=" + zHaseInit + ", sdkAppId=" + appId + ", requesting=" + this.h, "poll_timeout");
                return;
            }
            synchronized (this.j) {
                Handler handler = this.l;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(513, u);
                }
            }
        } catch (Throwable th) {
            int i2 = this.i + 1;
            this.i = i2;
            if (i2 >= 7) {
                a(false, "-1", "init poll error: " + th.getMessage(), "poll_timeout");
                return;
            }
            synchronized (this.j) {
                Handler handler2 = this.l;
                if (handler2 != null) {
                    handler2.sendEmptyMessageDelayed(513, u);
                }
            }
        }
    }

    private void e() {
        try {
            ATRewardRetryTaskManager.getInstance().registerContract(String.valueOf(28), new d());
        } catch (Throwable unused) {
        }
    }

    private void f() {
        if (this.g.compareAndSet(false, true)) {
            e();
        }
    }

    private void g() {
        int i = this.p;
        boolean zBooleanValue = i != 2;
        boolean zBooleanValue2 = i != 2;
        Boolean bool = this.n;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        }
        Boolean bool2 = this.o;
        if (bool2 != null) {
            zBooleanValue2 = bool2.booleanValue();
        }
        KsAdSDK.setPersonalRecommend(zBooleanValue);
        KsAdSDK.setProgrammaticRecommend(zBooleanValue2);
        if (ATSDK.isNetworkLogDebug()) {
            String str = q;
            Log.i(str, "PersonalRecommend: " + zBooleanValue);
            Log.i(str, "ProgrammaticRecommend: " + zBooleanValue2);
        }
    }

    public static KSATInitManager getInstance() {
        if (r == null) {
            synchronized (KSATInitManager.class) {
                if (r == null) {
                    r = new KSATInitManager();
                }
            }
        }
        return r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h() {
        /*
            r5 = this;
            r5.i()     // Catch: java.lang.Throwable -> L1c
            r5.c()     // Catch: java.lang.Throwable -> L1c
            r0 = 0
            r5.i = r0     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r0 = r5.j     // Catch: java.lang.Throwable -> L1c
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L1c
            android.os.Handler r1 = r5.l     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L17
            r2 = 513(0x201, float:7.19E-43)
            r3 = 3000(0xbb8, double:1.482E-320)
            r1.sendEmptyMessageDelayed(r2, r3)     // Catch: java.lang.Throwable -> L19
        L17:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
            goto L1c
        L19:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
            throw r1     // Catch: java.lang.Throwable -> L1c
        L1c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.ks.KSATInitManager.h():void");
    }

    private void i() {
        synchronized (this.j) {
            Handler handler = this.l;
            if (handler != null) {
                handler.removeMessages(513);
            }
            HandlerThread handlerThread = this.k;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.k = null;
                this.l = null;
            }
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public int getAdapterBridgeVersion() {
        return 1;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getAdapterVersion() {
        return "5.9.10.1.1.0";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Kuaishou";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.kwad.sdk.api.KsAdSDK";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return KSATConst.getNetworkVersion();
    }

    public String getPayloadInfo(String str, double d2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getJSONArray("adBids").getJSONObject(0).put("bidEcpm", d2);
            str = jSONObject.toString();
            Log.i(q, jSONObject.toString());
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public Map<String, Boolean> getPluginClassStatus() {
        HashMap map = new HashMap();
        map.put("recyclerview-*.aar", Boolean.FALSE);
        try {
            Class.forName("androidx.recyclerview.widget.RecyclerView");
            map.put("recyclerview-*.aar", Boolean.TRUE);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class.forName("androidx.recyclerview.widget.RecyclerView");
            map.put("recyclerview-*.aar", Boolean.TRUE);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return map;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getResourceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ksad_reward_order_end_dialog");
        return arrayList;
    }

    public void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    public void setKSATCustomController(KSATCustomController kSATCustomController) {
        if (kSATCustomController != null) {
            this.e = kSATCustomController;
        }
    }

    public void setPersonalRecommend(boolean z2) {
        this.n = Boolean.valueOf(z2);
    }

    public void setProgrammaticRecommend(boolean z2) {
        this.o = Boolean.valueOf(z2);
    }

    private void c() {
        if (this.l != null) {
            return;
        }
        synchronized (this.j) {
            if (this.l != null) {
                return;
            }
            HandlerThread handlerThread = new HandlerThread("at_ks_init_check");
            this.k = handlerThread;
            handlerThread.start();
            this.l = new c(this.k.getLooper());
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        b();
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        Context applicationContext = context.getApplicationContext();
        try {
            this.p = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(stringFromMap)) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onFail("Kuaishou init failed with empty app_id");
                return;
            }
            return;
        }
        if (TextUtils.equals(stringFromMap, KsAdSDK.getAppId()) && this.b) {
            g();
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        synchronized (this.a) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (mediationInitCallback != null) {
                this.d.add(mediationInitCallback);
            }
        }
        if (this.c.compareAndSet(false, true)) {
            this.f.set(false);
            KsAdSDK.getAppId();
            SdkConfig.Builder builder = new SdkConfig.Builder();
            builder.appId(stringFromMap);
            KSATCustomController kSATCustomController = this.e;
            if (kSATCustomController != null) {
                builder.canReadICCID(kSATCustomController.getCanReadICCID());
                builder.canReadMacAddress(this.e.getCanReadMacAddress());
                builder.canReadNearbyWifiList(this.e.getCanReadNearbyWifiList());
                if (this.e.getKsCustomeController() != null) {
                    builder.customController(this.e.getKsCustomeController());
                }
            }
            builder.setStartCallback(new a());
            this.b = false;
            this.h = stringFromMap;
            KsAdSDK.init(applicationContext, builder.build());
            KsAdSDK.start();
            KsAdSDK.getAppId();
            h();
            KsAdSDK.haseInit();
        }
    }

    protected void b() {
        try {
            for (Map.Entry<String, WeakReference> entry : this.m.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.m.remove(entry.getKey());
                }
            }
        } catch (Throwable unused) {
        }
    }

    protected void a(String str, WeakReference weakReference) {
        try {
            this.m.put(str, weakReference);
        } catch (Throwable unused) {
        }
    }

    void a(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener, int i) {
        initSDK(context, map, new b(map, map2, i, aTBidRequestInfoListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, String str, String str2, String str3) {
        ArrayList<MediationInitCallback> arrayList;
        if (this.f.compareAndSet(false, true)) {
            i();
            if (z2) {
                this.b = true;
                g();
                f();
            }
            synchronized (this.a) {
                arrayList = this.d == null ? null : new ArrayList(this.d);
                List<MediationInitCallback> list = this.d;
                if (list != null) {
                    list.clear();
                }
                this.c.set(false);
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            for (MediationInitCallback mediationInitCallback : arrayList) {
                if (mediationInitCallback != null) {
                    if (z2) {
                        try {
                            mediationInitCallback.onSuccess();
                        } catch (Throwable unused) {
                        }
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
        }
    }

    protected Map<String, Object> a(Map<String, Object> map, Map<String, Object> map2) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    if (map2 == null) {
                        map2 = new HashMap();
                    }
                    Object obj = map.get(KSATConst.KS_LLS_ID);
                    if (obj != null) {
                        Object obj2 = map2.get("nw_extra_info");
                        JSONObject jSONObject = obj2 instanceof JSONObject ? (JSONObject) obj2 : new JSONObject();
                        jSONObject.put("request_id", obj.toString());
                        map2.put("nw_extra_info", jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return map2;
    }
}
