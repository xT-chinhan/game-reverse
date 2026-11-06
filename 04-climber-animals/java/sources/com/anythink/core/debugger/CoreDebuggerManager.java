package com.anythink.core.debugger;

import android.content.Context;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bm;
import com.anythink.core.common.h.v;
import com.anythink.core.common.m.b;
import com.anythink.core.common.m.e;
import com.anythink.core.common.m.q;
import com.anythink.core.common.m.r;
import com.anythink.core.d.c;
import com.anythink.core.d.l;
import com.anythink.core.d.n;
import com.anythink.core.d.o;
import com.anythink.core.debugger.api.DebuggerAdSourceInfo;
import com.anythink.core.debugger.api.DebuggerDeviceInfo;
import com.anythink.core.debugger.api.DebuggerPlacementInfo;
import com.anythink.core.debugger.api.DebuggerSdkInfo;
import com.anythink.core.debugger.api.IDeviceInfoGetter;
import com.anythink.core.debugger.api.IOnlinePlcCfgGetter;
import com.anythink.core.debugger.api.ISdkInfoGetter;
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
                JSONObject jSONObjectA = e.a(-1);
                JSONObject jSONObjectB = e.b(-1);
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
        t tVarB = t.b();
        if (iSdkInfoGetter != null) {
            this.d.setInitSdk(tVarB.V());
            this.d.setAppId(tVarB.p());
            this.d.setAppKey(tVarB.q());
            this.d.setDeniedUploadDeviceInfo(tVarB.f());
            this.d.setHaveLoadAd(tVarB.c);
            this.d.setHavePreInitNetwork(tVarB.P());
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
        new c().a(context, vVar, new b() { // from class: com.anythink.core.debugger.CoreDebuggerManager.1
            @Override // com.anythink.core.common.m.q
            public final void onLoadFinish(int i, Object obj) {
                IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                if (iOnlinePlcCfgGetter2 != null) {
                    iOnlinePlcCfgGetter2.onOnlinePlcCfgCallback(DebuggerPlacementInfo.create(obj, null));
                }
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str2, AdError adError) {
                IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                if (iOnlinePlcCfgGetter2 != null) {
                    iOnlinePlcCfgGetter2.onOnlinePlcCfgError(str2);
                }
            }
        });
    }

    public void reqPlacementGroupInfo(Context context, String str, String str2, final IOnlinePlcCfgGetter iOnlinePlcCfgGetter) {
        new r(context, new bm(this.d.getAppId(), this.d.getAppKey(), str, str2)).a(0, (q) new b() { // from class: com.anythink.core.debugger.CoreDebuggerManager.2
            @Override // com.anythink.core.common.m.q
            public final void onLoadFinish(int i, Object obj) {
                IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                if (iOnlinePlcCfgGetter2 != null) {
                    iOnlinePlcCfgGetter2.onOnlinePlcCfgCallback(DebuggerPlacementInfo.create(obj));
                }
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str3, AdError adError) {
                IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                if (iOnlinePlcCfgGetter2 != null) {
                    iOnlinePlcCfgGetter2.onOnlinePlcCfgError(str3);
                }
            }
        });
    }

    public void reqPlacementStrategy(final Context context, final String str, String str2, JSONObject jSONObject, final IOnlinePlcCfgGetter iOnlinePlcCfgGetter) {
        bm bmVar = new bm(this.d.getAppId(), this.d.getAppKey(), str, str2);
        bmVar.a(jSONObject);
        new o().a(context, bmVar, new b() { // from class: com.anythink.core.debugger.CoreDebuggerManager.3
            @Override // com.anythink.core.common.m.q
            public final void onLoadFinish(int i, Object obj) {
                try {
                    l lVarA = l.a(str, (JSONObject) obj);
                    if (lVarA != null) {
                        lVarA.bs();
                        n.a(context).a(str, lVarA, null, 0);
                        if (iOnlinePlcCfgGetter != null) {
                            DebuggerPlacementInfo debuggerPlacementInfoCreate = DebuggerPlacementInfo.create(null, lVarA);
                            debuggerPlacementInfoCreate.setDebuggerAdSourceInfo(new DebuggerAdSourceInfo.Builder().setNormalUnitGroupListStr(lVarA.az() != null ? lVarA.az().toString() : "[]").setAdxUnitGroupListStr(lVarA.Y() != null ? lVarA.Y().toString() : "[]").setC2sHeadBiddingUnitGroupListStr(lVarA.aC() != null ? lVarA.aC().toString() : "[]").setS2sHeadBiddingUnitGroupListStr(lVarA.aB() != null ? lVarA.aB().toString() : "[]").setAdxOpenUnitGroupListStr(lVarA.aJ() != null ? lVarA.aJ().toString() : "[]").setCustomInHouseHeadBiddingUnitGroupListStr(lVarA.O() != null ? lVarA.O().toString() : "[]").setDefaultUnitGroupListStr(lVarA.J() != null ? lVarA.J().toString() : "[]").setDirectlyUnitGroupListStr(lVarA.aI() != null ? lVarA.aI().toString() : "[]").setC2sDynamicPriceAdSourceListStr(lVarA.bt() != null ? lVarA.bt().toString() : "[]").setS2sDynamicPriceAdSourceListStr(lVarA.bu() != null ? lVarA.bu().toString() : "[]").setOnlineUnitGroupListStr(lVarA.aA() != null ? lVarA.aA().toString() : "[]").setFbInHouseHeadBiddingUnitGroupListStr(lVarA.W() != null ? lVarA.W().toString() : "[]").build());
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

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str3, AdError adError) {
                IOnlinePlcCfgGetter iOnlinePlcCfgGetter2 = iOnlinePlcCfgGetter;
                if (iOnlinePlcCfgGetter2 != null) {
                    iOnlinePlcCfgGetter2.onOnlinePlcCfgError(str3);
                }
            }
        });
    }
}
