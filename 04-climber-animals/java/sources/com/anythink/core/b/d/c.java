package com.anythink.core.b.d;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdMixBidInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATIBiddingResultListener;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.b.f;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ab;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.cd;
import com.anythink.core.common.h.n;
import com.anythink.core.common.k;
import com.anythink.core.common.m.i;
import com.anythink.core.common.m.q;
import com.anythink.core.common.u.e;
import com.anythink.core.common.v.ak;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.p;
import com.anythink.core.d.d;
import com.anythink.core.mg.api.MgAdInfo;
import com.anythink.core.mg.api.MgComparedResult;
import com.anythink.network.baidu.BaiduATConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final int A = 7;
    public static final int B = 8;
    public static final int C = 9;
    public static final int D = 10;
    public static final int E = 11;
    public static final String F = "100";
    public static final String G = "102";
    public static final String H = "103";
    public static final String I = "103";
    public static final String J = "2";
    public static final String K = "1";
    static final String a = "c";
    public static final String b = "${AUCTION_PRICE}";
    public static final String c = "${AUCTION_PRICE_INT}";
    public static final String d = "${AUCTION_LOSS}";
    public static final String e = "${AUCTION_SEAT_ID}";
    public static final String f = "${AUCTION_BID_TO_WIN}";
    public static final String g = "${AUCTION_CURRENCY}";
    public static final String h = "${SECOND_PRICE}";
    public static final String i = "{__BIDDER__}";
    public static final String j = "${AUCTION_LOSS_BD}";
    public static final String k = "{__TS__}";
    public static final String l = "__ADN_TYPE__";
    public static final String m = "__ADN_NAME__";
    public static final String n = "__AD_N__";
    public static final String o = "__AD_TI__";
    public static final String p = "__AD_REQID__";
    public static final String q = "__IS_S__";
    public static final String r = "__IS_C__";
    public static final String s = "__AD_ECPM__";
    public static final String t = "${WIN_PRICE}";
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 3;
    public static final int x = 4;
    public static final int y = 5;
    public static final int z = 6;

    public static class a {
        public static final int a = 1;
        public static final int b = 2;
    }

    public static class b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 21;
        public static final int f = 22;
        public static final int g = 23;
        public static final int h = 24;
        public static final int i = 25;
        public static final int j = 26;
        public static final int k = 27;
        public static final int l = 28;
        public static final int m = 29;
        public static final int n = 30;
        public static final int o = 31;
        public static final int p = 32;
        public static final int q = 33;
        public static final int r = 34;
        public static final int s = 35;
        public static final int t = 36;

        public static boolean a(int i2) {
            return i2 == 34 || i2 == 35;
        }
    }

    public static void a(com.anythink.core.common.h.c cVar, boolean z2, int i2) {
        try {
            bv unitGroupInfo = cVar.e().getUnitGroupInfo();
            n nVarI = cVar.i();
            ad adVarR = unitGroupInfo.R();
            if (adVarR != null) {
                a(adVarR, new aw(z2 ? 2 : 1, unitGroupInfo, nVarI), true, i2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(com.anythink.core.common.h.c cVar) {
        a(cVar, false, 25);
    }

    public static void a(com.anythink.core.common.h.c cVar, int i2) {
        int i3;
        try {
            bv unitGroupInfo = cVar.e().getUnitGroupInfo();
            n nVarI = cVar.i();
            ad adVarR = unitGroupInfo.R();
            if (adVarR != null) {
                aw awVar = new aw(i2, unitGroupInfo, nVarI);
                if (i2 == 2) {
                    i3 = 34;
                } else {
                    i3 = i2 == 11 ? 36 : 30;
                }
                Object[] objArr = new Object[2];
                Integer.valueOf(i3);
                Long.valueOf(unitGroupInfo.u());
                a(adVarR, awVar, true, i3);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(final n nVar, final List<bv> list, final long j2, final int i2, final int i3) {
        com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.b.d.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (nVar == null) {
                    e.b("BiddingUtil#sendFinishHBTracking", "placementTrackingInfo is null.", t.b().r());
                    return;
                }
                String str = c.a;
                JSONArray jSONArray = new JSONArray();
                nVar.s(j2);
                nVar.t(System.currentTimeMillis());
                nVar.t = i2;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    bv bvVar = (bv) list.get(i4);
                    if (bvVar.q() != 7 && bvVar.o()) {
                        try {
                            int iT = bvVar.t();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("sorttype", iT);
                            jSONObject.put("unit_id", bvVar.z());
                            jSONObject.put("bidresult", bvVar.U());
                            jSONObject.put("bid_token_succ_t", bvVar.a());
                            jSONObject.put("bid_start_t", bvVar.b());
                            jSONObject.put("bidprice", bvVar.Q() ? String.valueOf(bvVar.D()) : "0");
                            jSONObject.put("bidprice_cny", bvVar.Q() ? String.valueOf(bvVar.c()) : "0");
                            jSONObject.put(k.ap, bvVar.Q() ? String.valueOf(bvVar.at()) : "0");
                            jSONObject.put("nw_firm_id", String.valueOf(bvVar.g()));
                            jSONObject.put("tp_bid_id", bvVar.R() != null ? bvVar.R().g : null);
                            jSONObject.put("rl_bid_status", bvVar.T());
                            jSONObject.put("errormsg", bvVar.F());
                            int iAe = bvVar.ae();
                            String strValueOf = String.valueOf(i3);
                            if (!strValueOf.equals("0")) {
                                if (iAe == -1) {
                                    try {
                                        iAe = Integer.parseInt(strValueOf);
                                    } catch (Exception unused) {
                                    }
                                }
                                jSONObject.put("ad_type", iAe);
                            }
                            jSONObject.put("ads_list_type", bvVar.d());
                            jSONObject.put("unit_type", bvVar.aM());
                            ad adVarR = bvVar.R();
                            jSONObject.put("dd_ori_price", adVarR != null ? String.valueOf(adVarR.originPrice) : "0");
                            jSONObject.put(k.aN, bvVar.aQ());
                            jSONObject.put(k.aQ, bvVar.aS());
                            jSONObject.put("bid_floor", bvVar.ar());
                            jSONObject.put(BaiduATConst.EN_P_KEY, adVarR != null ? adVarR.getExtra() : "");
                            if (adVarR != null && adVarR.t() != 0) {
                                jSONObject.put("deal_id", adVarR.v());
                                jSONObject.put("deal_type", adVarR.u());
                                nVar.B(adVarR.u());
                                nVar.C(adVarR.v());
                            }
                            jSONObject.put(k.bi, bvVar.bq());
                            jSONObject.put(k.bj, bvVar.bp());
                            jSONObject.put("network_pl_id", ak.a(bvVar, (ATBaseAdAdapter) null));
                            jSONArray.put(jSONObject);
                        } catch (Exception unused2) {
                        }
                        try {
                            com.anythink.core.d.b bVarB = d.a(t.b().g()).b(t.b().p());
                            if (bVarB != null && bVarB.c() != null) {
                                String strValueOf2 = String.valueOf(bvVar.g());
                                if (bVarB.c().contains(Integer.valueOf(bvVar.g()))) {
                                    e.a(nVar, strValueOf2, m.b(strValueOf2), bvVar.z());
                                }
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                }
                nVar.K(String.valueOf(i3));
                nVar.x(jSONArray.toString());
                com.anythink.core.common.u.c.a(t.b().g()).a(11, nVar);
            }
        });
    }

    public static void a(ad adVar, boolean z2, double d2, boolean z3, boolean z4) {
        if (adVar == null) {
            return;
        }
        double d3 = adVar.l;
        String str = adVar.j;
        int i2 = adVar.d;
        if (d3 > 0.0d) {
            d2 *= d3;
        }
        if (z2) {
            if (TextUtils.isEmpty(str)) {
                str = adVar.displayNoticeUrl;
            }
            if (!TextUtils.isEmpty(str)) {
                a(str.replace(b, com.anythink.core.b.d.a.a(adVar, d2)), (q) null);
            }
        } else {
            String str2 = adVar.displayNoticeUrl;
            if (!TextUtils.isEmpty(str2)) {
                a(str2.replace(b, com.anythink.core.b.d.a.a(adVar, d2)).replace(d, com.anythink.core.b.d.a.a(z3, 2, i2, z4)), (q) null);
            }
        }
        synchronized (adVar) {
            ATBiddingNotice aTBiddingNotice = adVar.biddingNotice;
            if (aTBiddingNotice != null) {
                aTBiddingNotice.notifyBidDisplay(z2, d2);
                if (z2) {
                    adVar.e();
                }
            }
        }
    }

    private static bv b(ad adVar) {
        if (adVar != null) {
            return adVar.f();
        }
        return null;
    }

    public static bv a(ad adVar) {
        if (adVar != null) {
            return adVar.g();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:106:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:110:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:116:0x022a  */
    /* JADX WARN: Code duplicated, block: B:119:0x024b  */
    /* JADX WARN: Code duplicated, block: B:173:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:178:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:181:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x014a  */
    /* JADX WARN: Code duplicated, block: B:97:0x019f  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a1  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void a(final ad adVar, final aw awVar, boolean z2, int i2) {
        boolean z3;
        boolean zO;
        int i3;
        boolean z4;
        double sortPrice;
        bv bvVar;
        double dNextDouble;
        String strA;
        String str;
        double d2;
        boolean z5;
        int i4;
        boolean z6;
        int i5;
        boolean z7;
        boolean z8;
        String str2;
        int i6;
        double d3;
        final double d4;
        Map<String, Object> map;
        double d5;
        ad.a aVarK;
        double dA;
        double dA2;
        Map<String, Object> mapAX;
        if (adVar == null) {
            return;
        }
        if (z2) {
            f.a().a(awVar.j(), adVar);
            if (awVar.f()) {
                com.anythink.core.common.a.a.a().b(t.b().g(), adVar.token);
            }
        }
        if (awVar.h() != 8 && adVar.d()) {
            String str3 = adVar.token;
            return;
        }
        if (adVar.useType == 2) {
            String str4 = adVar.token;
            return;
        }
        awVar.b(i2);
        double sortPrice2 = adVar.getSortPrice();
        double rmbPrice = adVar.getRmbPrice();
        int i7 = adVar.d;
        bv bvVarF = adVar != null ? adVar.f() : null;
        if (bvVarF != null) {
            boolean z9 = ak.b(bvVarF) && bvVarF.R() != null && bvVarF.R().s();
            double dA3 = p.a(bvVarF);
            double dB = p.b(bvVarF);
            int iG = bvVarF.g();
            zO = bvVarF.o();
            try {
                if (awVar.h() != 8 && (mapAX = bvVarF.aX()) != null) {
                    ATAdMixBidInfo.BidEntity bidEntity = new ATAdMixBidInfo.BidEntity();
                    Object obj = mapAX.get(j.w.A);
                    Object obj2 = mapAX.get(j.w.B);
                    Object obj3 = mapAX.get(j.w.C);
                    if (obj != null) {
                        bidEntity.setAdTittle((String) obj);
                    }
                    if (obj2 != null) {
                        bidEntity.setAdUserName((String) obj2);
                    }
                    if (obj3 != null) {
                        bidEntity.setAdPackageName((String) obj3);
                    }
                    awVar.a(bidEntity);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            z3 = z9;
            sortPrice2 = dA3;
            i7 = iG;
            rmbPrice = dB;
        } else {
            z3 = false;
            zO = true;
        }
        if (awVar.g() > 0.0d && awVar.g() > sortPrice2) {
            sortPrice2 = awVar.g();
            i7 = adVar.d;
            zO = true;
        }
        double dC = awVar.c();
        String strE = awVar.e();
        if (dC > 0.0d) {
            z4 = TextUtils.equals("102", strE) || TextUtils.equals("100", strE);
            i3 = -1;
            sortPrice2 = dC;
        } else {
            i3 = i7;
            z4 = zO;
        }
        int iH = awVar.h();
        if (adVar.d == 28) {
            sortPrice = adVar.originPrice;
        } else {
            sortPrice = adVar.getSortPrice();
        }
        double d6 = sortPrice;
        int i8 = adVar.d;
        double rmbPrice2 = adVar.getRmbPrice();
        if (sortPrice2 <= d6) {
            awVar.a(Double.valueOf(sortPrice2));
            if (z3) {
                bv bvVarA = a(adVar);
                if (bvVarA != null) {
                    dA2 = p.a(bvVarA);
                    if (d6 >= dA2) {
                        dA2 = d6;
                    }
                } else {
                    dA2 = d6;
                }
                int iD = awVar.D();
                bvVar = bvVarF;
                if (iD == 2) {
                    dNextDouble = dA2 + 0.01d;
                } else if (iD != 3) {
                    if (iD == 4) {
                        dNextDouble = 0.0d;
                    } else if (iD != 5) {
                        double d7 = dA2 + 0.01d;
                        dNextDouble = d7 + (((dA2 * 1.3d) - d7) * new Random(System.currentTimeMillis()).nextDouble());
                    } else {
                        dNextDouble = -1.0d;
                    }
                }
            } else {
                bvVar = bvVarF;
                dNextDouble = d6 + 0.01d;
            }
            strA = com.anythink.core.b.d.a.a(z4, iH, i8, z3);
            if (strE != null) {
                str = strE;
            } else {
                str = strA;
            }
            if (b.a(i2)) {
                dA = a(awVar.F());
                Object[] objArr = new Object[3];
                Double.valueOf(dA);
                Double.valueOf(sortPrice2);
                Integer.valueOf(i2);
                if (dA > 0.0d || dA <= dNextDouble) {
                    d2 = dNextDouble;
                } else {
                    d2 = dA;
                }
            } else {
                d2 = dNextDouble;
            }
            awVar.a(d2);
            awVar.a(str);
            awVar.c(i3);
            awVar.b(rmbPrice);
            awVar.c(rmbPrice2);
            n nVarZ = awVar.z();
            nVarZ.a(ab.a(awVar));
            com.anythink.core.common.u.c.a(t.b().g()).a(24, nVarZ);
            if (adVar.biddingNotice == null) {
                z5 = true;
            } else {
                z5 = false;
            }
            awVar.a(z5);
            if (awVar.u() && str.equals("-1")) {
                e.a(awVar, d2, str, 0.0d, d2, adVar.getSortPrice(), adVar.j(), "200", "", z3);
            }
            double dA4 = a(adVar, d2);
            double d8 = d2;
            com.anythink.core.common.v.d.a().a(awVar.z(), awVar.A(), com.anythink.core.common.v.d.d, "2");
            if (awVar.f()) {
                com.anythink.core.common.a.a.a().a(adVar);
            }
            if (awVar.u() || str.equals("-1")) {
                i4 = i8;
            } else {
                bv bvVar2 = bvVar;
                Map<String, Object> mapA = com.anythink.core.b.d.a.a(z4, i3, i8, bvVar2, adVar);
                if (awVar.h() == 8) {
                    z6 = true;
                    mapA.put(ATBiddingNotice.ADN_REQUEST_IS_SHOW, 1);
                    if (awVar.b() == 1) {
                        mapA.put(ATBiddingNotice.ADN_REQUEST_IS_CLICK, 1);
                    } else {
                        mapA.put(ATBiddingNotice.ADN_REQUEST_IS_CLICK, 0);
                    }
                    if (awVar.a() != null) {
                        Map<String, Object> mapAX2 = bvVar2 != null ? bvVar2.aX() : null;
                        if (mapAX2 == null) {
                            mapAX2 = new HashMap<>();
                        }
                        ATAdMixBidInfo.BidEntity bidEntityA = awVar.a();
                        mapAX2.put(j.w.A, bidEntityA.getAdTittle());
                        mapAX2.put(j.w.B, bidEntityA.getAdUserName());
                        mapA.put(ATBiddingNotice.ADN_EXTRA_NATIVE_MATERIAL_INFO, mapAX2);
                    }
                } else {
                    z6 = true;
                }
                synchronized (adVar) {
                    ATBiddingNotice aTBiddingNotice = adVar.biddingNotice;
                    if (aTBiddingNotice != null) {
                        try {
                            String strA2 = com.anythink.core.b.d.a.a(z4, iH);
                            i5 = i8;
                            d4 = d8;
                            i6 = i3;
                            final String str5 = str;
                            z7 = z6;
                            map = mapA;
                            z8 = z4;
                            str2 = str;
                            final boolean z10 = z3;
                            try {
                                ATIBiddingResultListener aTIBiddingResultListener = new ATIBiddingResultListener() { // from class: com.anythink.core.b.d.c.2
                                    final /* synthetic */ double d = 0.0d;

                                    @Override // com.anythink.core.api.ATIBiddingResultListener
                                    public final void reportSuccess(Map<String, Object> map2) {
                                        if (isNeedWait()) {
                                            e.a(awVar, d4, str5, this.d, d4, adVar.getSortPrice(), adVar.j(), "200", "", z10);
                                        }
                                    }

                                    @Override // com.anythink.core.api.ATIBiddingResultListener
                                    public final void reportFailed(int i9, String str6, Map<String, Object> map2) {
                                        if (isNeedWait()) {
                                            e.a(awVar, d4, str5, this.d, d4, adVar.getSortPrice(), adVar.j(), String.valueOf(i9), str6, z10);
                                        }
                                    }
                                };
                                map.put(ATBiddingNotice.ADN_BID_LISTENER_OBJECT, aTIBiddingResultListener);
                                try {
                                    aTBiddingNotice.notifyBidLoss(strA2, dA4, map);
                                } catch (Throwable unused) {
                                }
                                if (aTIBiddingResultListener.isNeedWait()) {
                                    d3 = dA4;
                                } else {
                                    d3 = dA4;
                                    try {
                                        e.a(awVar, d4, str2, 0.0d, d4, adVar.getSortPrice(), adVar.j(), "200", "", z3);
                                    } catch (Throwable th) {
                                        th = th;
                                        th.printStackTrace();
                                        Log.e("anythink", "notifyBidLoss: error: " + th.getMessage());
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                d3 = dA4;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i5 = i8;
                            z7 = z6;
                            z8 = z4;
                            str2 = str;
                            i6 = i3;
                            d3 = dA4;
                            d4 = d8;
                            map = mapA;
                        }
                    } else {
                        i5 = i8;
                        z8 = z4;
                        str2 = str;
                        i6 = i3;
                        d3 = dA4;
                        d4 = d8;
                        map = mapA;
                        z7 = false;
                    }
                }
                final double d9 = d3;
                String strA3 = com.anythink.core.b.d.a.a(adVar, awVar, i6, z8, d3, d6, str2, map);
                if (!TextUtils.isEmpty(strA3)) {
                    final boolean z11 = z7;
                    final double d10 = d4;
                    final String str6 = str2;
                    final double d11 = d4;
                    final boolean z12 = z3;
                    a(strA3, new com.anythink.core.common.m.b() { // from class: com.anythink.core.b.d.c.3
                        final /* synthetic */ double f = 0.0d;

                        @Override // com.anythink.core.common.m.q
                        public final void onLoadFinish(int i9, Object obj4) {
                            if (adVar.biddingNotice != null || z11) {
                                return;
                            }
                            e.a(awVar, d10, str6, this.f, d11, adVar.getSortPrice(), adVar.j(), "200", "", z12, d9);
                        }

                        @Override // com.anythink.core.common.m.q
                        public final void onLoadError(int i9, String str7, AdError adError) {
                            String platformCode;
                            String string;
                            if (adVar.biddingNotice != null || z11) {
                                return;
                            }
                            if (adError != null) {
                                platformCode = adError.getPlatformCode();
                                if (!TextUtils.isEmpty(adError.getPlatformMSG())) {
                                    string = adError.getPlatformMSG();
                                } else {
                                    string = adError.toString();
                                }
                            } else {
                                platformCode = com.anythink.core.common.res.image.c.a;
                                string = "";
                            }
                            e.a(awVar, d10, str6, this.f, d11, adVar.getSortPrice(), adVar.j(), platformCode, string, z12, d9);
                        }
                    });
                } else {
                    if (adVar.biddingNotice == null && !z7) {
                        d5 = d9;
                        e.a(awVar, d4, str2, 0.0d, d4, adVar.getSortPrice(), adVar.j(), "200", "", z3, d5);
                    }
                    aVarK = adVar.k();
                    if (aVarK != null) {
                        aVarK.b(com.anythink.core.b.d.a.a(adVar, awVar, d5, str2));
                    }
                    i4 = i5;
                }
                d5 = d9;
                aVarK = adVar.k();
                if (aVarK != null) {
                    aVarK.b(com.anythink.core.b.d.a.a(adVar, awVar, d5, str2));
                }
                i4 = i5;
            }
            if (i4 != 28) {
                adVar.e();
                adVar.h();
            }
        }
        bvVar = bvVarF;
        dNextDouble = sortPrice2;
        strA = com.anythink.core.b.d.a.a(z4, iH, i8, z3);
        if (strE != null) {
            str = strE;
        } else {
            str = strA;
        }
        if (b.a(i2)) {
            dA = a(awVar.F());
            Object[] objArr2 = new Object[3];
            Double.valueOf(dA);
            Double.valueOf(sortPrice2);
            Integer.valueOf(i2);
            if (dA > 0.0d) {
                d2 = dNextDouble;
            } else {
                d2 = dNextDouble;
            }
        } else {
            d2 = dNextDouble;
        }
        awVar.a(d2);
        awVar.a(str);
        awVar.c(i3);
        awVar.b(rmbPrice);
        awVar.c(rmbPrice2);
        n nVarZ2 = awVar.z();
        nVarZ2.a(ab.a(awVar));
        com.anythink.core.common.u.c.a(t.b().g()).a(24, nVarZ2);
        if (adVar.biddingNotice == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        awVar.a(z5);
        if (awVar.u()) {
        }
        double dA5 = a(adVar, d2);
        double d12 = d2;
        com.anythink.core.common.v.d.a().a(awVar.z(), awVar.A(), com.anythink.core.common.v.d.d, "2");
        if (awVar.f()) {
            com.anythink.core.common.a.a.a().a(adVar);
        }
        if (awVar.u()) {
            i4 = i8;
        } else {
            i4 = i8;
        }
        if (i4 != 28) {
            adVar.e();
            adVar.h();
        }
    }

    private static void a(String str, q qVar) {
        Object[] objArr = new Object[1];
        i.a(str).a(0, qVar);
    }

    private static void a(String str, cd cdVar) {
        if (cdVar == null) {
            return;
        }
        Object[] objArr = new Object[3];
        Integer.valueOf(1);
        i.a(str, cdVar).a(0, (q) null);
    }

    public static void a(cd cdVar) {
        n nVarY = cdVar.y();
        nVarY.a(ab.a(cdVar));
        com.anythink.core.common.u.c.a(t.b().g()).a(24, nVarY);
        e.a(cdVar);
    }

    public static void a(ATBaseAdAdapter aTBaseAdAdapter, bv bvVar, n nVar, BaseAd... baseAdArr) {
        ad adVarR;
        Map<String, Object> internalNetworkInfoMap;
        BaseAd baseAd;
        if (aTBaseAdAdapter == null || bvVar == null || (adVarR = bvVar.R()) == null) {
            return;
        }
        if (baseAdArr != null && baseAdArr.length > 0 && (baseAd = baseAdArr[0]) != null) {
            internalNetworkInfoMap = baseAd.getNetworkInfoMap();
        } else {
            internalNetworkInfoMap = aTBaseAdAdapter.getInternalNetworkInfoMap();
        }
        cd cdVar = new cd();
        n nVarAf = nVar.af();
        cdVar.a(nVarAf);
        cdVar.a(internalNetworkInfoMap);
        cdVar.a(bvVar);
        if (cdVar.d() != 0) {
            bvVar.F(cdVar.d());
        }
        adVarR.v = cdVar;
        if (internalNetworkInfoMap != null) {
            Object obj = internalNetworkInfoMap.get(ATAdConst.NETWORK_CUSTOM_KEY.WS_ACTION);
            if (obj instanceof ad.a) {
                adVarR.a((ad.a) obj);
            }
        }
        if (nVar.Y() == 66 && nVarAf.ah()) {
            adVarR.a(new com.anythink.core.basead.a.b(adVarR, bvVar, nVarAf));
        }
    }

    private static double a(ad adVar, double d2) {
        return adVar.l > 0.0d ? d2 * adVar.l : d2;
    }

    private static double a(int i2, double d2, double d3) {
        if (i2 == 2) {
            return d3 + 0.01d;
        }
        if (i2 == 3) {
            return d2;
        }
        if (i2 == 4) {
            return 0.0d;
        }
        if (i2 == 5) {
            return -1.0d;
        }
        double d4 = 0.01d + d3;
        return d4 + (((d3 * 1.3d) - d4) * new Random(System.currentTimeMillis()).nextDouble());
    }

    private static double a(MgComparedResult mgComparedResult) {
        MgAdInfo mgAdInfo = mgComparedResult != null ? mgComparedResult.getMgAdInfo() : null;
        if (mgAdInfo != null) {
            return mgAdInfo.getUSDEcpm();
        }
        return 0.0d;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00b5  */
    public static void a(ad adVar, bv bvVar, int i2) {
        cd cdVar;
        if (adVar == null || bvVar == null || (cdVar = adVar.v) == null || adVar.d()) {
            return;
        }
        cdVar.a(i2);
        double dA = p.a(bvVar);
        double dB = p.b(bvVar);
        double d2 = adVar.r;
        Double dA2 = cdVar.a();
        double dDoubleValue = dA2 != null ? dA2.doubleValue() : d2;
        if (adVar.s() || (dDoubleValue <= dA && dDoubleValue > 0.0d)) {
            d2 = dDoubleValue;
        } else if (d2 != 0.0d) {
            cdVar.a(Double.valueOf(dDoubleValue));
            d2 = dA - 0.01d;
            if (d2 < 0.0d) {
                d2 = 0.0d;
            }
        }
        if (bvVar.g() == 8) {
            double dAr = bvVar.ar();
            Object[] objArr = new Object[2];
            Double.valueOf(dAr);
            Double.valueOf(d2);
            if (dAr > 0.0d && dAr > d2) {
                d2 = dAr;
            }
        }
        if (b.a(i2)) {
            double dA3 = a(cdVar.C());
            Object[] objArr2 = new Object[2];
            Double.valueOf(dA3);
            Double.valueOf(d2);
            if (dA3 > 0.0d) {
                if (dA3 > d2) {
                    d2 = dA3;
                } else {
                    String strZ = bvVar.z();
                    bv bvVarL = adVar.l();
                    String strZ2 = bvVarL != null ? bvVarL.z() : "";
                    if (!TextUtils.isEmpty(strZ) && strZ.equals(strZ2)) {
                        d2 = dA3;
                    }
                }
            }
        }
        cdVar.a(dA);
        cdVar.b(d2);
        cdVar.c(dB);
        cdVar.s();
        cdVar.d(d2);
        cdVar.b(Double.valueOf(adVar.j()));
        double dA4 = a(adVar, dA);
        double dA5 = a(adVar, d2);
        boolean zV = cdVar.v();
        com.anythink.core.common.v.d.a().a(cdVar.y(), bvVar, com.anythink.core.common.v.d.d, "1");
        if (bvVar.am()) {
            com.anythink.core.common.a.a.a().a(adVar);
        }
        cdVar.a(adVar.biddingNotice == null);
        if (zV) {
            String strA = com.anythink.core.b.d.a.a(adVar, cdVar, dA4, dA5);
            if (TextUtils.isEmpty(strA)) {
                a(cdVar);
            } else if (cdVar != null) {
                Object[] objArr3 = new Object[3];
                Integer.valueOf(1);
                i.a(strA, cdVar).a(0, (q) null);
            }
            ATBiddingNotice aTBiddingNotice = adVar.biddingNotice;
            if (aTBiddingNotice != null) {
                try {
                    aTBiddingNotice.notifyBidWin(dA4, dA5, com.anythink.core.b.d.a.a(bvVar.g(), adVar.l()));
                } catch (Throwable th) {
                    th.printStackTrace();
                    Log.e("anythink", "notifyBidWin: error: " + th.getMessage());
                }
            }
            ad.a aVarK = adVar.k();
            if (aVarK != null) {
                aVarK.a(com.anythink.core.b.d.a.a(adVar, cdVar, dA5));
            }
        } else {
            a(cdVar);
        }
        adVar.h();
    }
}
