package com.anythink.core.common.d;

import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATCustomContentResult;
import com.anythink.core.api.ATRewardInfo;
import com.anythink.core.api.ATSDKUtils;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.basead.adx.api.IATAdxHandler;
import com.anythink.core.common.h.aa;
import com.anythink.core.common.u.af;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k extends ATAdInfo {
    private Map<String, Object> D;
    private Map<String, Object> I;
    private double L;
    private ATBaseAdAdapter a;
    private Pair<Integer, String> b;
    private double g;
    private String h;
    private String i;
    private int j;
    private Double n;
    private int c = -1;
    private String d = "";
    private int e = -1;
    private double f = 0.0d;
    private int k = 0;
    private String l = "";
    private Double m = Double.valueOf(0.0d);
    private String o = "";
    private String p = "";
    private String q = "";
    private String r = "";
    private String s = "unknow";
    private String t = "Network";
    private String u = "";
    private int v = 1;
    private int w = 0;
    private String x = "";
    private String y = "";
    private int z = 0;
    private String A = "";
    private String B = "";
    private Map<String, Object> C = null;
    private String E = "";
    private int F = 0;
    private String G = "";
    private int H = 0;
    private int J = 1;
    private String K = "";
    private IATAdxHandler M = null;
    private int N = -1;
    private String O = "";
    private String Q = "";
    private String R = "";
    private Map<String, String> P = new HashMap();
    private String S = "";
    private ATCustomContentResult U = null;
    private int T = 0;

    @Override // com.anythink.core.api.ATAdInfo
    public final int getNetworkFirmId() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getAdsourceId() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getAdsourceIndex() {
        return this.e;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final double getEcpm() {
        return this.f;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.k$1, reason: invalid class name */
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
        double d;
        double rmbChangeToUsdRate;
        int i = AnonymousClass1.a[currency.ordinal()];
        if (i == 1) {
            return this.g;
        }
        if (i == 2) {
            d = this.g;
            rmbChangeToUsdRate = 100.0d;
        } else if (i == 3) {
            String str = this.o;
            if (str != null && str.equalsIgnoreCase(i.k.b)) {
                d = this.f;
                rmbChangeToUsdRate = ATSDKUtils.getRmbChangeToUsdRate();
            } else {
                return this.f;
            }
        } else {
            return getEcpmWithCurrency(currency);
        }
        return d * rmbChangeToUsdRate;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getEncEcpmInfo() {
        return this.h;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getRmbEncEcpmInfo() {
        return this.i;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Double getPublisherRevenue() {
        return this.m;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Double getPublisherRevenue(ATAdConst.CURRENCY currency) {
        int i = AnonymousClass1.a[currency.ordinal()];
        if (i == 1) {
            return this.n;
        }
        if (i == 2) {
            return Double.valueOf(this.n.doubleValue() * 100.0d);
        }
        if (i == 3) {
            String str = this.o;
            if (str != null && str.equalsIgnoreCase(i.k.b)) {
                return Double.valueOf(this.m.doubleValue() * ATSDKUtils.getRmbChangeToUsdRate());
            }
            return this.m;
        }
        return getPublisherRevenue();
    }

    @Override // com.anythink.core.api.ATAdInfo
    @Deprecated
    public final double getEcpmWithCurrency(ATAdConst.CURRENCY currency) {
        return com.anythink.core.common.u.s.a(this.f, com.anythink.core.common.u.s.a(this.o), currency);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0080  */
    /* JADX WARN: Code duplicated, block: B:36:0x0082  */
    private static k a(k kVar, com.anythink.core.common.h.n nVar, int i) {
        String str;
        ATRewardInfo aTRewardInfoG;
        ATRewardInfo aTRewardInfo;
        boolean z;
        kVar.c = nVar.Z();
        kVar.d = nVar.N();
        kVar.e = nVar.Q();
        kVar.k = nVar.K();
        kVar.f = nVar.q();
        kVar.g = nVar.r();
        if (nVar.Z() == 2 || nVar.Z() == 1) {
            kVar.b = new Pair<>(Integer.valueOf(nVar.Z()), af.a(String.valueOf(kVar.f)));
        }
        if (nVar.K() == 1) {
            aa aaVarAt = nVar.at();
            if (aaVarAt == null) {
                z = false;
            } else if (i == 0) {
                if (aaVarAt.h == 3) {
                    z = true;
                } else {
                    z = false;
                }
            } else if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                if (aaVarAt.h == 3) {
                                    z = true;
                                }
                            }
                        } else if (aaVarAt.g == 3) {
                            z = true;
                        }
                        z = false;
                    } else if (aaVarAt.f == 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (aaVarAt.e == 3) {
                    z = true;
                } else {
                    z = false;
                }
            } else if (aaVarAt.d == 3) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                kVar.f = 0.0d;
                kVar.g = 0.0d;
            }
        }
        kVar.h = nVar.s();
        kVar.i = nVar.t();
        kVar.j = nVar.u();
        kVar.L = nVar.f();
        kVar.o = nVar.w();
        kVar.l = nVar.A();
        kVar.m = Double.valueOf(kVar.f / 1000.0d);
        kVar.n = Double.valueOf(kVar.g / 1000.0d);
        kVar.p = nVar.D();
        kVar.r = com.anythink.core.common.u.o.f(nVar.aS());
        String strAQ = nVar.aQ();
        String strH = nVar.h();
        if (TextUtils.isEmpty(strH) || TextUtils.equals(strAQ, strH)) {
            str = "";
        } else {
            str = strAQ;
            strAQ = strH;
        }
        kVar.q = strAQ;
        kVar.K = str;
        kVar.s = nVar.C();
        if (nVar.Z() == 35) {
            kVar.t = "Cross_Promotion";
        } else if (nVar.Z() == 66) {
            String strAz = nVar.az();
            strAz.hashCode();
            switch (strAz) {
                case "PA":
                    kVar.t = "Adx_pa";
                    break;
                case "PD":
                    kVar.t = "Adx_pd";
                    break;
                case "PDB":
                    kVar.t = "Adx_pdb";
                    break;
                default:
                    kVar.t = "Adx";
                    break;
            }
        } else {
            kVar.t = "Network";
        }
        kVar.u = nVar.z();
        kVar.v = nVar.B();
        kVar.w = nVar.aa();
        kVar.x = nVar.H;
        if (TextUtils.equals(i.o.b, kVar.r)) {
            Map<String, ATRewardInfo> mapF = nVar.F();
            if (mapF != null && mapF.containsKey(kVar.x) && (aTRewardInfo = mapF.get(kVar.x)) != null) {
                kVar.y = aTRewardInfo.rewardName;
                kVar.z = aTRewardInfo.rewardNumber;
            }
            if ((TextUtils.isEmpty(kVar.y) || kVar.z == 0) && (aTRewardInfoG = nVar.G()) != null) {
                kVar.y = aTRewardInfoG.rewardName;
                kVar.z = aTRewardInfoG.rewardNumber;
            }
        }
        kVar.B = s.b().n();
        kVar.A = s.b().o();
        kVar.C = nVar.H();
        kVar.E = nVar.p();
        kVar.F = nVar.af();
        kVar.G = nVar.aJ();
        kVar.H = nVar.aO();
        Map<String, Object> mapK = nVar.k();
        if (mapK != null) {
            kVar.I = new HashMap(mapK);
        }
        kVar.J = nVar.j();
        Map<String, String> mapAp = nVar.ap();
        if (mapAp != null) {
            kVar.P = new HashMap(mapAp);
        }
        kVar.Q = nVar.aN();
        kVar.R = nVar.ao();
        kVar.S = nVar.aR();
        kVar.U = nVar.av();
        kVar.T = com.anythink.core.common.u.o.e(nVar.l());
        return kVar;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int isHeaderBiddingAdsource() {
        return this.k;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getShowId() {
        return this.l;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCurrency() {
        return this.o;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCountry() {
        return this.p;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTopOnPlacementId() {
        return this.q;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTopOnAdFormat() {
        return this.r;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getPlacementId() {
        return this.q;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getFormat() {
        return this.r;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getEcpmPrecision() {
        return this.s;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getAdNetworkType() {
        return this.t;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getNetworkPlacementId() {
        return this.u;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getEcpmLevel() {
        return this.v;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getSegmentId() {
        return this.w;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getScenarioId() {
        return this.x;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getScenarioRewardName() {
        return this.y;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getScenarioRewardNumber() {
        return this.z;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getSubChannel() {
        return this.A;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getChannel() {
        return this.B;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCustomRule() {
        return this.C != null ? new JSONObject(this.C).toString() : "";
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Map<String, Object> getExtInfoMap() {
        return this.D;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getRewardUserCustomData() {
        ATBaseAdAdapter aTBaseAdAdapter = this.a;
        return aTBaseAdAdapter != null ? aTBaseAdAdapter.getUserCustomData() : "";
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Map<String, Object> getLocalExtra() {
        return this.I;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTpBidId() {
        return this.E;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getABTestId() {
        return this.H;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getDismissType() {
        return this.F;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getPlacementType() {
        return this.J;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getSharedPlacementId() {
        return this.K;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final double getBidFloor() {
        return this.L;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getWaterfallId() {
        return this.G;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final IATAdxHandler getAdxHandler() {
        return this.M;
    }

    public static k a(BaseAd baseAd, ATBaseAdAdapter aTBaseAdAdapter) {
        return a(baseAd, aTBaseAdAdapter, 0);
    }

    public static k a(BaseAd baseAd, ATBaseAdAdapter aTBaseAdAdapter, int i) {
        if (baseAd != null) {
            k kVarA = a(a(baseAd.getDetail(), i), aTBaseAdAdapter);
            kVarA.D = baseAd.getNetworkInfoMap();
            return kVarA;
        }
        return new k();
    }

    private static k a(k kVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null && (aTBaseAdAdapter instanceof ATBaseAdAdapter)) {
            kVar.a = aTBaseAdAdapter;
            kVar.D = aTBaseAdAdapter.getInternalNetworkInfoMap();
            kVar.N = kVar.a.getTrackingInfo().ae();
            kVar.O = aTBaseAdAdapter.getAdCustomExt();
            try {
                if (kVar.a.getTrackingInfo().al()) {
                    kVar.M = kVar.a.getUnitGroupInfo().Y().i();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return kVar;
    }

    public static k a(ATBaseAdAdapter aTBaseAdAdapter) {
        return a(aTBaseAdAdapter, 0);
    }

    public static k a(ATBaseAdAdapter aTBaseAdAdapter, int i) {
        if (aTBaseAdAdapter != null) {
            return a(a(aTBaseAdAdapter.getTrackingInfo(), i), aTBaseAdAdapter);
        }
        return new k();
    }

    public static k a(com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter, int i) {
        return a(a(nVar, i), aTBaseAdAdapter);
    }

    public static k a(com.anythink.core.common.h.n nVar, ATBaseAdAdapter aTBaseAdAdapter) {
        return a(nVar, aTBaseAdAdapter, 0);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    private static void b(k kVar, com.anythink.core.common.h.n nVar, int i) {
        kVar.f = nVar.q();
        kVar.g = nVar.r();
        boolean z = true;
        if (nVar.Z() == 2 || nVar.Z() == 1) {
            kVar.b = new Pair<>(Integer.valueOf(nVar.Z()), af.a(String.valueOf(kVar.f)));
        }
        if (nVar.K() != 1) {
            return;
        }
        aa aaVarAt = nVar.at();
        if (aaVarAt == null) {
            z = false;
        } else if (i == 0) {
            if (aaVarAt.h != 3) {
                z = false;
            }
        } else if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            if (aaVarAt.h != 3) {
                            }
                        }
                    } else if (aaVarAt.g != 3) {
                    }
                    z = false;
                } else if (aaVarAt.f != 3) {
                    z = false;
                }
            } else if (aaVarAt.e != 3) {
                z = false;
            }
        } else if (aaVarAt.d != 3) {
            z = false;
        }
        if (z) {
            kVar.f = 0.0d;
            kVar.g = 0.0d;
        }
    }

    private static k a(com.anythink.core.common.h.n nVar, int i) {
        k kVar = new k();
        return nVar != null ? a(kVar, nVar, i) : kVar;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getAdSourceAdType() {
        return this.N;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getAdSourceCustomExt() {
        return this.O;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getNetworkName() {
        return this.Q;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getShowCustomExt() {
        return this.R;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Map<String, String> getUrlTagParams() {
        return this.P;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getSecretId() {
        return this.j;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getRequestId() {
        return this.S;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getBidType() {
        return this.T;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final ATCustomContentResult getCustomContentResult() {
        return this.U;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.l);
            jSONObject.put("publisher_revenue", this.m);
            jSONObject.put("publisher_revenue_cny", this.n);
            jSONObject.put("currency", this.o);
            jSONObject.put("country", this.p);
            jSONObject.put("adunit_id", this.q);
            jSONObject.put("adunit_format", this.r);
            jSONObject.put(com.anythink.core.common.k.U, this.s);
            jSONObject.put("network_type", this.t);
            jSONObject.put("network_placement_id", this.u);
            jSONObject.put(com.anythink.core.common.k.T, this.v);
            jSONObject.put("segment_id", this.w);
            if (!TextUtils.isEmpty(this.x)) {
                jSONObject.put("scenario_id", this.x);
            }
            if (!TextUtils.isEmpty(this.y) && this.z != 0) {
                jSONObject.put("scenario_reward_name", this.y);
                jSONObject.put("scenario_reward_number", this.z);
            }
            if (!TextUtils.isEmpty(this.B)) {
                jSONObject.put("channel", this.B);
            }
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject.put("sub_channel", this.A);
            }
            Map<String, Object> map = this.C;
            if (map != null && map.size() > 0) {
                jSONObject.put("custom_rule", new JSONObject(this.C));
            }
            jSONObject.put("network_firm_id", this.c);
            jSONObject.put(com.anythink.core.common.f.i.a.d, this.d);
            jSONObject.put("adsource_index", this.e);
            jSONObject.put("adsource_price", this.f);
            jSONObject.put("adsource_price_cny", this.g);
            jSONObject.put("adsource_isheaderbidding", this.k);
            Map<String, Object> map2 = this.D;
            if (map2 != null && map2.size() > 0) {
                jSONObject.put("ext_info", new JSONObject(this.D));
            }
            ATBaseAdAdapter aTBaseAdAdapter = this.a;
            if (aTBaseAdAdapter != null) {
                jSONObject.put(MediationConstant.REWARD_CUSTOM_DATA, aTBaseAdAdapter.getUserCustomData());
            }
            if (!TextUtils.isEmpty(this.E)) {
                jSONObject.put("tp_bid_id", this.E);
            }
            int i = this.F;
            if (i != 0) {
                jSONObject.put("dismiss_type", i);
            }
            if (!TextUtils.isEmpty(this.G)) {
                jSONObject.put(com.anythink.core.e.l.a.T, this.G);
            }
            jSONObject.put(com.anythink.core.common.l.f.J, this.H);
            Map<String, Object> map3 = this.I;
            if (map3 != null && map3.size() > 0) {
                jSONObject.put("user_load_extra_data", new JSONObject(this.I));
            }
            jSONObject.put("placement_type", this.J);
            if (!TextUtils.isEmpty(this.K)) {
                jSONObject.put("shared_placement_id", this.K);
            }
            jSONObject.put("bid_floor", this.L);
            jSONObject.put("ad_source_type", this.N);
            jSONObject.put("ad_source_custom_ext", this.O);
            jSONObject.put("url_tag_params", this.P);
            jSONObject.put("network_name", this.Q);
            jSONObject.put("show_custom_ext", this.R);
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put(com.anythink.core.common.k.aU, this.h);
            }
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put(com.anythink.core.common.k.aV, this.i);
            }
            jSONObject.put(com.anythink.core.e.l.a.aD, this.j);
            jSONObject.put("req_id", this.S);
            jSONObject.put(com.anythink.core.common.k.K, this.T);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public final String toString() {
        return a().toString();
    }

    public final void a(double d) {
        this.f = d;
        this.m = Double.valueOf(d / 1000.0d);
    }

    public final void b(double d) {
        this.g = d;
        this.n = Double.valueOf(d / 1000.0d);
    }
}
