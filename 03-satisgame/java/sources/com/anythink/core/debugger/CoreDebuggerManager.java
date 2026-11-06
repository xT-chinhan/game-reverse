package com.anythink.core.debugger;

import android.content.Context;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.bo;
import com.anythink.core.common.h.v;
import com.anythink.core.common.l.f;
import com.anythink.core.common.l.t;
import com.anythink.core.debugger.api.DebuggerAdSourceInfo;
import com.anythink.core.debugger.api.DebuggerDeviceInfo;
import com.anythink.core.debugger.api.DebuggerPlacementInfo;
import com.anythink.core.debugger.api.DebuggerSdkInfo;
import com.anythink.core.debugger.api.IDeviceInfoGetter;
import com.anythink.core.debugger.api.IOnlinePlcCfgGetter;
import com.anythink.core.debugger.api.ISdkInfoGetter;
import com.anythink.core.e.c;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import com.anythink.core.e.o;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CoreDebuggerManager {
    public static final String a = "anythink_debug_place_strategy_obj";
    private static volatile CoreDebuggerManager b;
    private final DebuggerDeviceInfo c = new DebuggerDeviceInfo();
    private final DebuggerSdkInfo d = new DebuggerSdkInfo();

    private CoreDebuggerManager() {
    }

    public static CoreDebuggerManager getInstance() {
        if (b == null) {
            synchronized (CoreDebuggerManager.class) {
                if (b == null) {
                    b = new CoreDebuggerManager();
                }
            }
        }
        return b;
    }

    public void setDeviceInfoGetter(Context context, IDeviceInfoGetter iDeviceInfoGetter) {
        if (iDeviceInfoGetter != null) {
            if (this.c.getDeviceInfoJsonObj() != null) {
                iDeviceInfoGetter.onDeviceInfoCallback(this.c);
                return;
            }
            try {
                JSONObject jSONObjectA = f.a(-1);
                JSONObject jSONObjectB = f.b(-1);
                Iterator<String> itKeys = jSONObjectB.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectA.put(next, jSONObjectB.opt(next));
                }
                this.c.setDeviceInfoJsonObj(jSONObjectA);
            } catch (Throwable unused) {
            }
            iDeviceInfoGetter.onDeviceInfoCallback(this.c);
        }
    }

    public void setSdkInfoGetter(ISdkInfoGetter iSdkInfoGetter) {
        s sVarB = s.b();
        if (iSdkInfoGetter != null) {
            this.d.setInitSdk(sVarB.V());
            this.d.setAppId(sVarB.p());
            this.d.setAppKey(sVarB.q());
            this.d.setDeniedUploadDeviceInfo(sVarB.f());
            this.d.setHaveLoadAd(sVarB.c);
            this.d.setHavePreInitNetwork(sVarB.P());
            this.d.setVersionName(ATSDK.getSDKVersionName());
            iSdkInfoGetter.onSdkInfoCallback(this.d);
        }
    }

    public DebuggerSdkInfo getSdkInfo() {
        return this.d;
    }

    public void reqPlacementConfig(Context context, String str, final IOnlinePlcCfgGetter iOnlinePlcCfgGetter) {
        this.d.setDebugKey(str);
        v vVar = new v(this.d.getAppId(), this.d.getAppKey());
        vVar.a(str);
        vVar.c(i.ad.h);
        new c().a(context, vVar, new com.anythink.core.common.l.c() { // from class: com.anythink.core.debugger.CoreDebuggerManager.1
            @Override // com.anythink.core.common.l.s
            public final void onLoadFinish(int i, Object obj) {
                IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                if (iOnlinePlcCfgGetter2 != null) {
                    iOnlinePlcCfgGetter2.onOnlinePlcCfgCallback(DebuggerPlacementInfo.create(obj, null));
                }
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadError(int i, String str2, AdError adError) {
                IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                if (iOnlinePlcCfgGetter2 != null) {
                    iOnlinePlcCfgGetter2.onOnlinePlcCfgError(str2);
                }
            }
        });
    }

    public void reqPlacementGroupInfo(Context context, String str, String str2, final IOnlinePlcCfgGetter iOnlinePlcCfgGetter) {
        new t(context, new bo(this.d.getAppId(), this.d.getAppKey(), str, str2)).a(0, (com.anythink.core.common.l.s) new com.anythink.core.common.l.c() { // from class: com.anythink.core.debugger.CoreDebuggerManager.2
            @Override // com.anythink.core.common.l.s
            public final void onLoadFinish(int i, Object obj) {
                IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                if (iOnlinePlcCfgGetter2 != null) {
                    iOnlinePlcCfgGetter2.onOnlinePlcCfgCallback(DebuggerPlacementInfo.create(obj));
                }
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadError(int i, String str3, AdError adError) {
                IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                if (iOnlinePlcCfgGetter2 != null) {
                    iOnlinePlcCfgGetter2.onOnlinePlcCfgError(str3);
                }
            }
        });
    }

    public void reqPlacementStrategy(final Context context, final String str, String str2, JSONObject jSONObject, final IOnlinePlcCfgGetter iOnlinePlcCfgGetter) {
        bo boVar = new bo(this.d.getAppId(), this.d.getAppKey(), str, str2);
        boVar.a(jSONObject);
        boVar.a(i.ad.h);
        new o().a(context, boVar, new com.anythink.core.common.l.c() { // from class: com.anythink.core.debugger.CoreDebuggerManager.3
            @Override // com.anythink.core.common.l.s
            public final void onLoadFinish(int i, Object obj) {
                try {
                    l lVarA = l.a(str, (JSONObject) obj);
                    if (lVarA != null) {
                        lVarA.bs();
                        n.a(context).a(str, lVarA, null, 0);
                        if (iOnlinePlcCfgGetter != null) {
                            DebuggerPlacementInfo debuggerPlacementInfoCreate = DebuggerPlacementInfo.create(null, lVarA);
                            debuggerPlacementInfoCreate.setDebuggerAdSourceInfo(new DebuggerAdSourceInfo.Builder().setNormalUnitGroupListStr(lVarA.ay() != null ? lVarA.ay().toString() : "[]").setAdxUnitGroupListStr(lVarA.Z() != null ? lVarA.Z().toString() : "[]").setC2sHeadBiddingUnitGroupListStr(lVarA.aB() != null ? lVarA.aB().toString() : "[]").setS2sHeadBiddingUnitGroupListStr(lVarA.aA() != null ? lVarA.aA().toString() : "[]").setAdxOpenUnitGroupListStr(lVarA.aI() != null ? lVarA.aI().toString() : "[]").setCustomInHouseHeadBiddingUnitGroupListStr(lVarA.P() != null ? lVarA.P().toString() : "[]").setDefaultUnitGroupListStr(lVarA.K() != null ? lVarA.K().toString() : "[]").setDirectlyUnitGroupListStr(lVarA.aH() != null ? lVarA.aH().toString() : "[]").setC2sDynamicPriceAdSourceListStr(lVarA.bt() != null ? lVarA.bt().toString() : "[]").setS2sDynamicPriceAdSourceListStr(lVarA.bu() != null ? lVarA.bu().toString() : "[]").setOnlineUnitGroupListStr(lVarA.az() != null ? lVarA.az().toString() : "[]").setFbInHouseHeadBiddingUnitGroupListStr(lVarA.X() != null ? lVarA.X().toString() : "[]").build());
                            iOnlinePlcCfgGetter.onOnlinePlcCfgCallback(debuggerPlacementInfoCreate);
                        }
                    }
                } catch (Throwable th) {
                    IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                    if (iOnlinePlcCfgGetter2 != null) {
                        iOnlinePlcCfgGetter2.onOnlinePlcCfgError("request debug place strategy error: " + th.getMessage());
                    }
                }
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadError(int i, String str3, AdError adError) {
                IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                if (iOnlinePlcCfgGetter2 != null) {
                    iOnlinePlcCfgGetter2.onOnlinePlcCfgError(str3);
                }
            }
        });
    }
}
