package com.anythink.core.common.d;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomContentResult;
import com.anythink.core.api.ATRewardInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.basead.adx.api.IATAdxHandler;
import com.anythink.core.common.h.aa;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.bv;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l extends ATAdInfo {
    private Map<String, Object> C;
    private Map<String, Object> H;
    private double K;
    private ATBaseAdAdapter a;
    private double f;
    private String g;
    private String h;
    private int i;
    private Double m;
    private int b = -1;
    private String c = "";
    private int d = -1;
    private double e = 0.0d;
    private int j = 0;
    private String k = "";
    private Double l = Double.valueOf(0.0d);
    private String n = "";
    private String o = "";
    private String p = "";
    private String q = "";
    private String r = "unknow";
    private String s = "Network";
    private String t = "";
    private int u = 1;
    private int v = 0;
    private String w = "";
    private String x = "";
    private int y = 0;
    private String z = "";
    private String A = "";
    private Map<String, Object> B = null;
    private String D = "";
    private int E = 0;
    private String F = "";
    private int G = 0;
    private int I = 1;
    private String J = "";
    private IATAdxHandler L = null;
    private int M = -1;
    private String N = "";
    private String P = "";
    private String Q = "";
    private Map<String, String> O = new HashMap();
    private String R = "";
    private ATCustomContentResult T = null;
    private int S = 0;

    @Override // com.anythink.core.api.ATAdInfo
    public final int getNetworkFirmId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getAdsourceId() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getAdsourceIndex() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final double getEcpm() {
        return this.e;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ATAdConst.CURRENCY.values().length];
            a = iArr;
            try {
                iArr[ATAdConst.CURRENCY.RMB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ATAdConst.CURRENCY.RMB_CENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ATAdConst.CURRENCY.USD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final double getEcpm(ATAdConst.CURRENCY currency) {
        int i = AnonymousClass1.a[currency.ordinal()];
        if (i == 1) {
            return this.f;
        }
        if (i == 2) {
            return this.f * 100.0d;
        }
        if (i == 3) {
            return this.e;
        }
        return getEcpmWithCurrency(currency);
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getEncEcpmInfo() {
        return this.g;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getRmbEncEcpmInfo() {
        return this.h;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Double getPublisherRevenue() {
        return this.l;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Double getPublisherRevenue(ATAdConst.CURRENCY currency) {
        int i = AnonymousClass1.a[currency.ordinal()];
        if (i == 1) {
            return this.m;
        }
        if (i == 2) {
            return Double.valueOf(this.m.doubleValue() * 100.0d);
        }
        if (i == 3) {
            return this.l;
        }
        return getPublisherRevenue();
    }

    @Override // com.anythink.core.api.ATAdInfo
    @Deprecated
    public final double getEcpmWithCurrency(ATAdConst.CURRENCY currency) {
        return com.anythink.core.common.v.t.a(this.e, com.anythink.core.common.v.t.a(this.n), currency);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0061  */
    /* JADX WARN: Code duplicated, block: B:30:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0067  */
    private static l a(l lVar, com.anythink.core.common.h.n nVar, int i) {
        String str;
        ATRewardInfo aTRewardInfoF;
        ATRewardInfo aTRewardInfo;
        boolean z;
        lVar.b = nVar.Y();
        lVar.c = nVar.M();
        lVar.d = nVar.P();
        lVar.j = nVar.J();
        lVar.e = nVar.p();
        lVar.f = nVar.q();
        if (nVar.J() == 1) {
            aa aaVarAp = nVar.ap();
            new StringBuilder("handleEcpm, bidPriceCallbackSetting: ").append(aaVarAp);
            if (aaVarAp == null) {
                z = false;
            } else if (i == 0) {
                if (aaVarAp.h == 3) {
                    z = true;
                } else {
                    z = false;
                }
            } else if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                if (aaVarAp.h == 3) {
                                    z = true;
                                }
                            }
                        } else if (aaVarAp.g == 3) {
                            z = true;
                        }
                        z = false;
                    } else if (aaVarAp.f == 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (aaVarAp.e == 3) {
                    z = true;
                } else {
                    z = false;
                }
            } else if (aaVarAp.d == 3) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                nVar.M();
                lVar.e = 0.0d;
                lVar.f = 0.0d;
            }
            nVar.M();
            double d = lVar.e;
        }
        lVar.g = nVar.r();
        lVar.h = nVar.s();
        lVar.i = nVar.t();
        lVar.K = nVar.e();
        lVar.n = nVar.v();
        lVar.k = nVar.z();
        lVar.l = Double.valueOf(lVar.e / 1000.0d);
        lVar.m = Double.valueOf(lVar.f / 1000.0d);
        lVar.o = nVar.C();
        lVar.q = com.anythink.core.common.v.p.f(nVar.aK());
        String strAI = nVar.aI();
        String strG = nVar.g();
        if (TextUtils.isEmpty(strG) || TextUtils.equals(strAI, strG)) {
            str = "";
        } else {
            str = strAI;
            strAI = strG;
        }
        lVar.p = strAI;
        lVar.J = str;
        lVar.r = nVar.B();
        if (nVar.Y() == 35) {
            lVar.s = "Cross_Promotion";
        } else if (nVar.Y() == 66) {
            String strAu = nVar.au();
            strAu.hashCode();
            switch (strAu) {
                case "PA":
                    lVar.s = "Adx_pa";
                    break;
                case "PD":
                    lVar.s = "Adx_pd";
                    break;
                case "PDB":
                    lVar.s = "Adx_pdb";
                    break;
                default:
                    lVar.s = "Adx";
                    break;
            }
        } else {
            lVar.s = "Network";
        }
        lVar.t = nVar.y();
        lVar.u = nVar.A();
        lVar.v = nVar.Z();
        lVar.w = nVar.F;
        if (TextUtils.equals(j.n.b, lVar.q)) {
            Map<String, ATRewardInfo> mapE = nVar.E();
            if (mapE != null && mapE.containsKey(lVar.w) && (aTRewardInfo = mapE.get(lVar.w)) != null) {
                lVar.x = aTRewardInfo.rewardName;
                lVar.y = aTRewardInfo.rewardNumber;
            }
            if ((TextUtils.isEmpty(lVar.x) || lVar.y == 0) && (aTRewardInfoF = nVar.F()) != null) {
                lVar.x = aTRewardInfoF.rewardName;
                lVar.y = aTRewardInfoF.rewardNumber;
            }
        }
        lVar.A = t.b().n();
        lVar.z = t.b().o();
        lVar.B = nVar.G();
        lVar.D = nVar.o();
        lVar.E = nVar.ae();
        lVar.F = nVar.aB();
        lVar.G = nVar.aG();
        Map<String, Object> mapJ = nVar.j();
        if (mapJ != null) {
            lVar.H = new HashMap(mapJ);
        }
        lVar.I = nVar.i();
        Map<String, String> mapAl = nVar.al();
        if (mapAl != null) {
            lVar.O = new HashMap(mapAl);
        }
        lVar.P = nVar.aF();
        lVar.Q = nVar.ak();
        lVar.R = nVar.aJ();
        lVar.T = nVar.aq();
        lVar.S = com.anythink.core.common.v.p.e(nVar.k());
        return lVar;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int isHeaderBiddingAdsource() {
        return this.j;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getShowId() {
        return this.k;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCurrency() {
        return this.n;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCountry() {
        return this.o;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTopOnPlacementId() {
        return this.p;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTopOnAdFormat() {
        return this.q;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getPlacementId() {
        return this.p;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getFormat() {
        return this.q;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getEcpmPrecision() {
        return this.r;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getAdNetworkType() {
        return this.s;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getNetworkPlacementId() {
        return this.t;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getEcpmLevel() {
        return this.u;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getSegmentId() {
        return this.v;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getScenarioId() {
        return this.w;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getScenarioRewardName() {
        return this.x;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getScenarioRewardNumber() {
        return this.y;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getSubChannel() {
        return this.z;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getChannel() {
        return this.A;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCustomRule() {
        return this.B != null ? new JSONObject(this.B).toString() : "";
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Map<String, Object> getExtInfoMap() {
        return this.C;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getRewardUserCustomData() {
        ATBaseAdAdapter aTBaseAdAdapter = this.a;
        return aTBaseAdAdapter != null ? aTBaseAdAdapter.getUserCustomData() : "";
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Map<String, Object> getLocalExtra() {
        return this.H;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTpBidId() {
        return this.D;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getABTestId() {
        return this.G;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getDismissType() {
        return this.E;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getPlacementType() {
        return this.I;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getSharedPlacementId() {
        return this.J;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final double getBidFloor() {
        return this.K;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getWaterfallId() {
        return this.F;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final IATAdxHandler getAdxHandler() {
        return this.L;
    }

    public static l a(BaseAd baseAd, ATBaseAdAdapter aTBaseAdAdapter) {
        return a(baseAd, aTBaseAdAdapter, 0);
    }

    public static l a(BaseAd baseAd, ATBaseAdAdapter aTBaseAdAdapter, int i) {
        if (baseAd != null) {
            l lVarA = a(a(baseAd.getDetail(), i), aTBaseAdAdapter);
            lVarA.C = baseAd.getNetworkInfoMap();
            return lVarA;
        }
        return new l();
    }

    private static l a(l lVar, f fVar) {
        if (fVar != null && (fVar instanceof ATBaseAdAdapter)) {
            ATBaseAdAdapter aTBaseAdAdapter = (ATBaseAdAdapter) fVar;
            lVar.a = aTBaseAdAdapter;
            lVar.C = aTBaseAdAdapter.getInternalNetworkInfoMap();
            lVar.M = lVar.a.getTrackingInfo().ad();
            lVar.N = aTBaseAdAdapter.getAdCustomExt();
            try {
                if (lVar.a.getTrackingInfo().ah()) {
                    lVar.L = lVar.a.getUnitGroupInfo().R().i();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return lVar;
    }

    public static l a(f fVar) {
        return a(fVar, 0);
    }

    public static l a(f fVar, int i) {
        if (fVar != null) {
            return a(a(fVar.getTrackingInfo(), i), fVar);
        }
        return new l();
    }

    public static l a(com.anythink.core.common.h.n nVar, f fVar, int i) {
        return a(a(nVar, i), fVar);
    }

    public static l a(com.anythink.core.common.h.n nVar, f fVar) {
        return a(nVar, fVar, 0);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x004a  */
    /* JADX WARN: Code duplicated, block: B:33:0x004f  */
    private static void b(l lVar, com.anythink.core.common.h.n nVar, int i) {
        lVar.e = nVar.p();
        lVar.f = nVar.q();
        boolean z = true;
        if (nVar.J() != 1) {
            return;
        }
        aa aaVarAp = nVar.ap();
        new StringBuilder("handleEcpm, bidPriceCallbackSetting: ").append(aaVarAp);
        if (aaVarAp == null) {
            z = false;
        } else if (i == 0) {
            if (aaVarAp.h != 3) {
                z = false;
            }
        } else if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            if (aaVarAp.h != 3) {
                            }
                        }
                    } else if (aaVarAp.g != 3) {
                    }
                    z = false;
                } else if (aaVarAp.f != 3) {
                    z = false;
                }
            } else if (aaVarAp.e != 3) {
                z = false;
            }
        } else if (aaVarAp.d != 3) {
            z = false;
        }
        if (z) {
            nVar.M();
            lVar.e = 0.0d;
            lVar.f = 0.0d;
        }
        nVar.M();
        double d = lVar.e;
    }

    private static l a(com.anythink.core.common.h.n nVar, int i) {
        l lVar = new l();
        return nVar != null ? a(lVar, nVar, i) : lVar;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getAdSourceAdType() {
        return this.M;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getAdSourceCustomExt() {
        return this.N;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getNetworkName() {
        return this.P;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getShowCustomExt() {
        return this.Q;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Map<String, String> getUrlTagParams() {
        return this.O;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getSecretId() {
        return this.i;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getRequestId() {
        return this.R;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getBidType() {
        return this.S;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final ATCustomContentResult getCustomContentResult() {
        return this.T;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.k);
            jSONObject.put("publisher_revenue", this.l);
            jSONObject.put("publisher_revenue_cny", this.m);
            jSONObject.put(DeepLinkPresetEvent.UMEventParamCurrency, this.n);
            jSONObject.put(bv.O, this.o);
            jSONObject.put("adunit_id", this.p);
            jSONObject.put("adunit_format", this.q);
            jSONObject.put(com.anythink.core.common.k.T, this.r);
            jSONObject.put("network_type", this.s);
            jSONObject.put("network_placement_id", this.t);
            jSONObject.put(com.anythink.core.common.k.S, this.u);
            jSONObject.put("segment_id", this.v);
            if (!TextUtils.isEmpty(this.w)) {
                jSONObject.put("scenario_id", this.w);
            }
            if (!TextUtils.isEmpty(this.x) && this.y != 0) {
                jSONObject.put("scenario_reward_name", this.x);
                jSONObject.put("scenario_reward_number", this.y);
            }
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject.put("channel", this.A);
            }
            if (!TextUtils.isEmpty(this.z)) {
                jSONObject.put("sub_channel", this.z);
            }
            Map<String, Object> map = this.B;
            if (map != null && map.size() > 0) {
                jSONObject.put("custom_rule", new JSONObject(this.B));
            }
            jSONObject.put("network_firm_id", this.b);
            jSONObject.put("adsource_id", this.c);
            jSONObject.put("adsource_index", this.d);
            jSONObject.put("adsource_price", this.e);
            jSONObject.put("adsource_price_cny", this.f);
            jSONObject.put("adsource_isheaderbidding", this.j);
            Map<String, Object> map2 = this.C;
            if (map2 != null && map2.size() > 0) {
                jSONObject.put("ext_info", new JSONObject(this.C));
            }
            ATBaseAdAdapter aTBaseAdAdapter = this.a;
            if (aTBaseAdAdapter != null) {
                jSONObject.put(MediationConstant.REWARD_CUSTOM_DATA, aTBaseAdAdapter.getUserCustomData());
            }
            if (!TextUtils.isEmpty(this.D)) {
                jSONObject.put("tp_bid_id", this.D);
            }
            int i = this.E;
            if (i != 0) {
                jSONObject.put("dismiss_type", i);
            }
            if (!TextUtils.isEmpty(this.F)) {
                jSONObject.put(com.anythink.core.d.l.a.T, this.F);
            }
            jSONObject.put(com.anythink.core.common.m.e.J, this.G);
            Map<String, Object> map3 = this.H;
            if (map3 != null && map3.size() > 0) {
                jSONObject.put("user_load_extra_data", new JSONObject(this.H));
            }
            jSONObject.put("placement_type", this.I);
            if (!TextUtils.isEmpty(this.J)) {
                jSONObject.put("shared_placement_id", this.J);
            }
            jSONObject.put("bid_floor", this.K);
            jSONObject.put("ad_source_type", this.M);
            jSONObject.put("ad_source_custom_ext", this.N);
            jSONObject.put("url_tag_params", this.O);
            jSONObject.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_NAME, this.P);
            jSONObject.put("show_custom_ext", this.Q);
            if (!TextUtils.isEmpty(this.g)) {
                jSONObject.put(com.anythink.core.common.k.aS, this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put(com.anythink.core.common.k.aT, this.h);
            }
            jSONObject.put(com.anythink.core.d.l.a.aD, this.i);
            jSONObject.put("req_id", this.R);
            jSONObject.put(com.anythink.core.common.k.J, this.S);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public final String toString() {
        return a().toString();
    }

    public final void a(double d) {
        this.e = d;
        this.l = Double.valueOf(d / 1000.0d);
    }

    public final void b(double d) {
        this.f = d;
        this.m = Double.valueOf(d / 1000.0d);
    }
}
