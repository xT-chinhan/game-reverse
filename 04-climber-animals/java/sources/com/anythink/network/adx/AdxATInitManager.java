package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.c;
import com.anythink.basead.f.c.a;
import com.anythink.basead.j.f;
import com.anythink.basead.oversea_plugin.OmsdkHandler;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.x;
import com.anythink.expressad.a.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class AdxATInitManager extends ATInitMediation {
    private static String a = "AdxATInitManager";
    private static volatile AdxATInitManager b;
    private boolean c;
    private List<MediationInitCallback> f;
    private String h;
    private AtomicBoolean d = new AtomicBoolean(false);
    private AtomicBoolean e = new AtomicBoolean(false);
    private final Object g = new Object();

    @Override // com.anythink.core.api.ATInitMediation
    public String getAdapterVersion() {
        return "UA_6.5.10";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Adx";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.anythink.core.api.ATSDK";
    }

    public static AdxATInitManager getInstance() {
        if (b == null) {
            synchronized (AdxATInitManager.class) {
                if (b == null) {
                    b = new AdxATInitManager();
                }
            }
        }
        return b;
    }

    private AdxATInitManager() {
        try {
            a.a(b.a());
        } catch (Throwable unused) {
        }
        try {
            com.anythink.basead.f.d.b.a(com.anythink.basead.k.b.a());
        } catch (Throwable unused2) {
        }
        try {
            f.a().a(new OmsdkHandler());
        } catch (Throwable unused3) {
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        if (this.c) {
            if (TextUtils.isEmpty(this.h)) {
                if (mediationInitCallback != null) {
                    mediationInitCallback.onSuccess();
                    return;
                }
                return;
            } else {
                if (mediationInitCallback != null) {
                    mediationInitCallback.onFail(b());
                    return;
                }
                return;
            }
        }
        synchronized (this.g) {
            if (this.f == null) {
                this.f = new ArrayList();
            }
            if (mediationInitCallback != null) {
                this.f.add(mediationInitCallback);
            }
            if (this.d.get()) {
                return;
            }
            this.d.set(true);
            String strA = t.b().a(context, getResourceStatus(), getDevBundleName());
            this.h = strA;
            if (TextUtils.isEmpty(strA)) {
                c.a().a(context);
                this.c = true;
                a(true, "");
                return;
            }
            a(false, b());
        }
    }

    private String b() {
        return "The " + this.h + " resources are missing, If shrinkResources is enabled, the " + this.h + " resources must be added to the whitelist (keep.xml)";
    }

    private void a(boolean z, String str) {
        synchronized (this.g) {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                MediationInitCallback mediationInitCallback = this.f.get(i);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str);
                    }
                }
            }
            this.f.clear();
            this.d.set(false);
        }
    }

    protected static boolean a() {
        return a.a();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getResourceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("anythink_myoffer_full_screen");
        arrayList.add("anythink_myoffer_splash_ad_layout_asseblem_vertical_port");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return ATSDK.getSDKVersionName();
    }

    protected static JSONArray a(String str, int i) {
        if (com.anythink.basead.f.d.b.a() != null) {
            return com.anythink.basead.f.d.b.a().a(str, i);
        }
        return null;
    }

    protected static void a(n nVar, x xVar) {
        if (nVar == null || xVar == null) {
            return;
        }
        nVar.ab(xVar.k);
    }

    static JSONArray a(Map<String, Object> map) {
        String stringFromMap = getStringFromMap(map, "nv_tmpl_id", "[\"1\",\"2\",\"3\",\"4\",\"5\"]");
        if (!TextUtils.isEmpty(stringFromMap)) {
            try {
                JSONArray jSONArray = new JSONArray(stringFromMap);
                if (jSONArray.length() > 0) {
                    return jSONArray;
                }
            } catch (Throwable unused) {
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put("1");
        jSONArray2.put("2");
        jSONArray2.put("3");
        jSONArray2.put("4");
        jSONArray2.put("5");
        return jSONArray2;
    }

    final void a(final Context context, final Map<String, Object> map, final Map<String, Object> map2, final ATBidRequestInfoListener aTBidRequestInfoListener, final int i) {
        c.a().b();
        getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.adx.AdxATInitManager.1
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                x xVar = (x) map.get(j.w.a);
                AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, xVar != null ? xVar.b : "", map, map2, i);
                int i2 = i;
                if (i2 == 0) {
                    adxBidRequestInfo.fillNative(map);
                } else if (i2 == 1) {
                    adxBidRequestInfo.fillRewardedVideo(map);
                } else if (i2 == 2) {
                    adxBidRequestInfo.fillBannerData(map);
                } else if (i2 == 3) {
                    adxBidRequestInfo.fillInterstitial(map);
                } else if (i2 == 4) {
                    adxBidRequestInfo.fillSplashData();
                }
                ATBidRequestInfoListener aTBidRequestInfoListener2 = aTBidRequestInfoListener;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onSuccess(adxBidRequestInfo);
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                ATBidRequestInfoListener aTBidRequestInfoListener2 = aTBidRequestInfoListener;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onFailed(str);
                }
            }
        });
    }
}
