package com.anythink.core.c.d;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.anythink.core.api.ATAdMixBidInfo;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.api.bridge.AnyThinkBaseAdapter;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.ab;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.cg;
import com.anythink.core.common.h.n;
import com.anythink.core.common.k;
import com.anythink.core.common.l.j;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.aj;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import com.anythink.core.common.u.l;
import com.anythink.core.common.u.o;
import com.anythink.core.mg.api.MgAdInfo;
import com.anythink.core.mg.api.MgComparedResult;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final int A = 6;
    public static final int B = 7;
    public static final int C = 8;
    public static final int D = 9;
    public static final int E = 10;
    public static final int F = 11;
    public static final int G = 12;
    public static final String H = "100";
    public static final String I = "102";
    public static final String J = "103";
    public static final String K = "103";
    public static final String L = "2";
    public static final String M = "1";
    static final String a = "c";
    public static final String b = "${AUCTION_PRICE}";
    public static final String c = "${AUCTION_PRICE_INT}";
    public static final String d = "${AUCTION_LOSS}";
    public static final String e = "${AUCTION_SEAT_ID}";
    public static final String f = "${AUCTION_BID_TO_WIN}";
    public static final String g = "${AUCTION_CURRENCY}";
    public static final String h = "${SECOND_PRICE}";
    public static final String i = "{__BIDDER__}";
    public static final String j = "__MEDIATION_CACHE__";
    public static final String k = "${AUCTION_LOSS_BD}";
    public static final String l = "{__TS__}";
    public static final String m = "__ADN_TYPE__";
    public static final String n = "__ADN_NAME__";
    public static final String o = "__AD_N__";
    public static final String p = "__AD_TI__";
    public static final String q = "__AD_REQID__";
    public static final String r = "__IS_S__";
    public static final String s = "__IS_C__";
    public static final String t = "__AD_ECPM__";
    public static final String u = "${WIN_PRICE}";
    public static final int v = 1;
    public static final int w = 2;
    public static final int x = 3;
    public static final int y = 4;
    public static final int z = 5;

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
        public static final int u = 37;
        public static final int v = 38;

        public static boolean a(int i2) {
            return i2 == 34 || i2 == 35;
        }
    }

    public static void a(com.anythink.core.common.h.c cVar, boolean z2, int i2) {
        try {
            by unitGroupInfo = cVar.e().getUnitGroupInfo();
            n nVarI = cVar.i();
            ad adVarY = unitGroupInfo.Y();
            if (adVarY != null) {
                a(adVarY, new ay(z2 ? 2 : 1, unitGroupInfo, nVarI), true, i2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(com.anythink.core.common.h.c cVar) {
        a(cVar, false, 25);
    }

    private static void a(com.anythink.core.common.h.c cVar, int i2, int i3) {
        int i4;
        try {
            by unitGroupInfo = cVar.e().getUnitGroupInfo();
            n nVarI = cVar.i();
            ad adVarY = unitGroupInfo.Y();
            if (adVarY != null) {
                ay ayVar = new ay(i2, unitGroupInfo, nVarI);
                ayVar.a(i3);
                if (i2 == 2) {
                    i4 = 34;
                } else {
                    i4 = i2 == 11 ? 36 : 30;
                }
                a(adVarY, ayVar, true, i4);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(final n nVar, final List<by> list, final long j2, final long j3, final int i2, final int i3) {
        com.anythink.core.common.u.b.c.a().g(new d(e.av, new Runnable() { // from class: com.anythink.core.c.d.c.1
            @Override // java.lang.Runnable
            public final void run() {
                Object obj;
                if (nVar == null) {
                    f.b("BiddingUtil#sendFinishHBTracking", "placementTrackingInfo is null.", s.b().r());
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                nVar.u(j2);
                nVar.w(j3);
                nVar.v(System.currentTimeMillis());
                nVar.x(SystemClock.elapsedRealtime());
                nVar.t = i2;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    by byVar = (by) list.get(i4);
                    if (i4 == 0) {
                        nVar.t(byVar.bD());
                    }
                    if (byVar.y() != 7 && byVar.w()) {
                        try {
                            int iB = byVar.B();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("sorttype", iB);
                            jSONObject.put("unit_id", byVar.G());
                            jSONObject.put("bidresult", byVar.ab());
                            jSONObject.put("bid_token_succ_t", byVar.a());
                            jSONObject.put("bid_token_succ_ts", byVar.b());
                            jSONObject.put("bid_start_t", byVar.c());
                            jSONObject.put("bidprice", byVar.X() ? String.valueOf(byVar.K()) : "0");
                            jSONObject.put("bidprice_cny", byVar.X() ? String.valueOf(byVar.j()) : "0");
                            jSONObject.put(k.aq, byVar.X() ? String.valueOf(byVar.aB()) : "0");
                            jSONObject.put("nw_firm_id", String.valueOf(byVar.n()));
                            jSONObject.put("tp_bid_id", byVar.Y() != null ? byVar.Y().g : null);
                            jSONObject.put("rl_bid_status", byVar.aa());
                            jSONObject.put("errormsg", byVar.M());
                            int iAk = byVar.ak();
                            String strValueOf = String.valueOf(i3);
                            if (!strValueOf.equals("0")) {
                                if (iAk == -1) {
                                    try {
                                        iAk = Integer.parseInt(strValueOf);
                                    } catch (Exception unused) {
                                    }
                                }
                                jSONObject.put("ad_type", iAk);
                            }
                            jSONObject.put("ads_list_type", byVar.k());
                            jSONObject.put("unit_type", byVar.aU());
                            ad adVarY = byVar.Y();
                            jSONObject.put("dd_ori_price", adVarY != null ? String.valueOf(adVarY.originPrice) : "0");
                            jSONObject.put(k.aP, byVar.aY());
                            jSONObject.put(k.aS, byVar.ba());
                            jSONObject.put("bid_floor", byVar.az());
                            jSONObject.put("en_p", adVarY != null ? adVarY.getExtra() : "");
                            if (adVarY != null && adVarY.s() != 0) {
                                jSONObject.put("deal_id", adVarY.u());
                                jSONObject.put("deal_type", adVarY.t());
                                nVar.A(adVarY.t());
                                nVar.B(adVarY.u());
                            }
                            jSONObject.put(k.bk, byVar.by());
                            jSONObject.put(k.bl, byVar.bx());
                            jSONObject.put("network_pl_id", aj.a(byVar, null));
                            jSONObject.put("nw_ver", byVar.B);
                            jSONObject.put(k.bC, byVar.bI());
                            jSONObject.put("adapter_bridge_ver", byVar.C);
                            Map mapD = c.d(adVarY);
                            if (mapD != null && (obj = mapD.get("nw_extra_info")) != null) {
                                jSONObject.put("nw_extra_info", obj);
                            }
                            jSONArray.put(jSONObject);
                        } catch (Exception unused2) {
                        }
                        try {
                            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
                            if (bVarB != null && bVarB.c() != null) {
                                String strValueOf2 = String.valueOf(byVar.n());
                                if (bVarB.c().contains(Integer.valueOf(byVar.n()))) {
                                    f.a(nVar, strValueOf2, l.a(strValueOf2), byVar.G());
                                }
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                }
                nVar.K(String.valueOf(i3));
                nVar.w(jSONArray.toString());
                com.anythink.core.common.t.e.a(s.b().g());
                com.anythink.core.common.t.e.a(11, nVar);
            }
        }));
    }

    public static void a(ad adVar, boolean z2, double d2, boolean z3, boolean z4, by byVar) {
        double sortPrice;
        if (adVar == null) {
            return;
        }
        double d3 = adVar.l;
        String str = adVar.j;
        int i2 = adVar.d;
        double d4 = d3 > 0.0d ? d2 * d3 : d2;
        if (z2) {
            Pair<Double, Double> pairA = a(adVar, byVar);
            double dDoubleValue = pairA != null ? ((Double) pairA.first).doubleValue() : 0.0d;
            if (TextUtils.isEmpty(str)) {
                str = adVar.displayNoticeUrl;
            }
            if (!TextUtils.isEmpty(str)) {
                if (d3 > 0.0d) {
                    dDoubleValue *= d3;
                }
                a(str.replace(f, String.valueOf(dDoubleValue)).replace(b, com.anythink.core.c.d.a.a(adVar, d4)), (com.anythink.core.common.l.s) null);
            }
        } else {
            if (adVar.d == 28) {
                sortPrice = adVar.originPrice;
            } else {
                sortPrice = adVar.getSortPrice();
            }
            if (d3 > 0.0d) {
                sortPrice *= d3;
            }
            by byVarA = a(adVar);
            if (byVarA != null) {
                double dA = o.a(byVarA);
                if (d3 > 0.0d) {
                    dA *= d3;
                }
                sortPrice = Math.max(sortPrice, dA);
            } else if (byVar != null && byVar.az() > 0.0d) {
                double dAz = byVar.az();
                if (d3 > 0.0d) {
                    dAz *= d3;
                }
                sortPrice = Math.max(sortPrice, dAz);
            }
            if (sortPrice != 0.0d) {
                double d5 = 0.01d + sortPrice;
                if (d5 < d4) {
                    sortPrice = d5;
                }
            }
            String str2 = adVar.displayNoticeUrl;
            if (!TextUtils.isEmpty(str2)) {
                a(str2.replace(f, String.valueOf(sortPrice)).replace(b, com.anythink.core.c.d.a.a(adVar, d4)).replace(d, com.anythink.core.c.d.a.a(z3, 2, i2, z4)), (com.anythink.core.common.l.s) null);
            }
        }
        synchronized (adVar) {
            ATBiddingNotice aTBiddingNotice = adVar.biddingNotice;
            if (aTBiddingNotice != null) {
                aTBiddingNotice.notifyBidDisplay(z2, d4);
                if (z2) {
                    adVar.e();
                }
            }
        }
    }

    private static by c(ad adVar) {
        if (adVar != null) {
            return adVar.f();
        }
        return null;
    }

    public static by a(ad adVar) {
        if (adVar != null) {
            return adVar.g();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:191:0x0401  */
    /* JADX WARN: Code duplicated, block: B:193:0x0405  */
    /* JADX WARN: Code duplicated, block: B:194:0x040a  */
    /* JADX WARN: Code duplicated, block: B:197:0x040f  */
    /* JADX WARN: Code duplicated, block: B:199:0x041f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0182  */
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
    public static void a(final ad adVar, final ay ayVar, boolean z2, int i2) {
        boolean zW;
        boolean z3;
        int i3;
        boolean z4;
        double sortPrice;
        int i4;
        boolean z5;
        final String str;
        boolean z6;
        int i5;
        int i6;
        boolean z7;
        double d2;
        final double d3;
        double d4;
        AnyThinkBaseAdapter anyThinkBaseAdapterD;
        double dA;
        Map<String, Object> mapBf;
        if (adVar == null) {
            return;
        }
        if (z2) {
            if (adVar.getCommonAdManager() != null) {
                com.anythink.core.common.f commonAdManager = adVar.getCommonAdManager();
                if (commonAdManager.f() != null) {
                    commonAdManager.f().a(ayVar.l(), adVar);
                }
            }
            if (ayVar.h() && ayVar.a() != 6) {
                com.anythink.core.common.a.a.a().a(s.b().g(), adVar.token);
            }
        }
        if ((ayVar.j() == 8 || !adVar.d()) && adVar.useType != 2) {
            ayVar.c(i2);
            double sortPrice2 = adVar.getSortPrice();
            double rmbPrice = adVar.getRmbPrice();
            int i7 = adVar.d;
            by byVarF = adVar != null ? adVar.f() : null;
            if (byVarF != null) {
                boolean z8 = aj.b(byVarF) && byVarF.Y() != null && byVarF.Y().r();
                double dA2 = o.a(byVarF);
                double dB = o.b(byVarF);
                int iN = byVarF.n();
                zW = byVarF.w();
                try {
                    if (ayVar.j() != 8 && (mapBf = byVarF.bf()) != null) {
                        ATAdMixBidInfo.BidEntity bidEntity = new ATAdMixBidInfo.BidEntity();
                        Object obj = mapBf.get("native_material_tittle");
                        Object obj2 = mapBf.get("native_material_publisher_name");
                        Object obj3 = mapBf.get("native_material_package_name");
                        if (obj != null) {
                            bidEntity.setAdTittle((String) obj);
                        }
                        if (obj2 != null) {
                            bidEntity.setAdUserName((String) obj2);
                        }
                        if (obj3 != null) {
                            bidEntity.setAdPackageName((String) obj3);
                        }
                        ayVar.a(bidEntity);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                z3 = z8;
                sortPrice2 = dA2;
                i7 = iN;
                rmbPrice = dB;
            } else {
                zW = true;
                z3 = false;
            }
            if (ayVar.i() > 0.0d && ayVar.i() > sortPrice2) {
                sortPrice2 = ayVar.i();
                i7 = adVar.d;
                zW = true;
            }
            by byVarC = ayVar.C();
            double dK = ayVar.K();
            if (sortPrice2 < dK) {
                if (byVarC == null || byVarC.i() != 1) {
                    sortPrice2 = adVar.getSortPrice() + 0.01d;
                } else if (dK > 0.0d) {
                    sortPrice2 = dK;
                }
            }
            double d5 = ayVar.d();
            String strF = ayVar.f();
            if (d5 > 0.0d) {
                i3 = -1;
                sortPrice2 = d5;
                z4 = TextUtils.equals("102", strF) || TextUtils.equals("100", strF);
            } else {
                i3 = i7;
                z4 = zW;
            }
            int iJ = ayVar.j();
            if (adVar.d == 28) {
                sortPrice = adVar.originPrice;
            } else {
                sortPrice = adVar.getSortPrice();
            }
            int i8 = adVar.d;
            double d6 = rmbPrice;
            double rmbPrice2 = adVar.getRmbPrice();
            by byVarA = a(adVar);
            if (sortPrice2 <= sortPrice) {
                ayVar.a(Double.valueOf(sortPrice2));
                if (z3) {
                    if (byVarA != null) {
                        dA = o.a(byVarA);
                        if (sortPrice >= dA) {
                            dA = sortPrice;
                        }
                    } else {
                        dA = sortPrice;
                    }
                    int iF = ayVar.F();
                    double d7 = sortPrice2;
                    if (iF == 2) {
                        sortPrice2 = dA + 0.01d;
                    } else if (iF == 3) {
                        sortPrice2 = d7;
                    } else if (iF == 4) {
                        sortPrice2 = 0.0d;
                    } else if (iF != 5) {
                        double d8 = dA + 0.01d;
                        sortPrice2 = d8 + (((dA * 1.3d) - d8) * new Random(System.currentTimeMillis()).nextDouble());
                    } else {
                        sortPrice2 = -1.0d;
                    }
                } else {
                    sortPrice2 = sortPrice + 0.01d;
                }
            }
            String strA = com.anythink.core.c.d.a.a(z4, iJ, i8, z3);
            if (strF != null) {
                strA = strF;
            }
            if (b.a(i2)) {
                double dA3 = a(ayVar.H());
                if (dA3 > 0.0d && dA3 > sortPrice2) {
                    sortPrice2 = dA3;
                }
            }
            ayVar.a(sortPrice2);
            ayVar.a(strA);
            ayVar.d(i3);
            boolean z9 = z4;
            ayVar.b(d6);
            ayVar.c(rmbPrice2);
            n nVarB = ayVar.B();
            nVarB.a(ab.a(ayVar));
            Map<String, Object> mapD = d(adVar);
            if (mapD != null) {
                nVarB.a(mapD);
            }
            com.anythink.core.common.t.e.a(s.b().g());
            com.anythink.core.common.t.e.a(24, nVarB);
            ayVar.a(adVar.biddingNotice == null);
            if (!ayVar.w() && strA.equals("-1")) {
                f.a(ayVar, sortPrice2, strA, 0.0d, sortPrice2, adVar.getSortPrice(), adVar.j(), "200", "", z3);
            }
            double dA4 = a(adVar, sortPrice2);
            double dA5 = a(adVar, sortPrice);
            double d9 = sortPrice2;
            com.anythink.core.common.u.d.a().a(ayVar.B(), ayVar.C(), com.anythink.core.common.u.d.d, "2");
            if (ayVar.g()) {
                com.anythink.core.common.a.a.a().a(adVar);
            }
            if (ayVar.w()) {
                if (strA.equals("-1")) {
                    i4 = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0427: MOVE (r3v10 'i4' int) = (r16v4 int) in method: com.anythink.core.c.d.c.a(com.anythink.core.common.h.ad, com.anythink.core.common.h.ay, boolean, int):void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r16v4 int
                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                        */
                    /*
                        Method dump skipped, instruction units count: 1098
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.c.d.c.a(com.anythink.core.common.h.ad, com.anythink.core.common.h.ay, boolean, int):void");
                }

                private static void a(String str, com.anythink.core.common.l.s sVar) {
                    j.b(str).a(0, sVar);
                }

                private static void a(String str, cg cgVar) {
                    if (cgVar == null) {
                        return;
                    }
                    j.a(str, cgVar).a(0, (com.anythink.core.common.l.s) null);
                }

                public static void a(cg cgVar) {
                    n nVarY = cgVar.y();
                    nVarY.a(ab.a(cgVar));
                    com.anythink.core.common.t.e.a(s.b().g());
                    com.anythink.core.common.t.e.a(24, nVarY);
                    f.a(cgVar);
                }

                /* JADX WARN: Code duplicated, block: B:12:0x0019 A[Catch: Exception -> 0x001e, TRY_LEAVE, TryCatch #0 {Exception -> 0x001e, blocks: (B:7:0x000c, B:9:0x000f, B:11:0x0014, B:12:0x0019), top: B:25:0x000c }] */
                public static void a(ATBaseAdAdapter aTBaseAdAdapter, by byVar, n nVar, BaseAd... baseAdArr) {
                    ad adVarY;
                    BaseAd baseAd;
                    Map<String, Object> networkInfoMap;
                    if (aTBaseAdAdapter == null || byVar == null || (adVarY = byVar.Y()) == null) {
                        return;
                    }
                    if (baseAdArr != null) {
                        try {
                            if (baseAdArr.length > 0 && (baseAd = baseAdArr[0]) != null) {
                                networkInfoMap = baseAd.getNetworkInfoMap();
                            } else {
                                networkInfoMap = aTBaseAdAdapter.getInternalNetworkInfoMap();
                            }
                        } catch (Exception unused) {
                            networkInfoMap = null;
                        }
                    } else {
                        networkInfoMap = aTBaseAdAdapter.getInternalNetworkInfoMap();
                    }
                    cg cgVar = new cg();
                    n nVarAh = nVar.ah();
                    nVarAh.a(networkInfoMap);
                    cgVar.a(nVarAh);
                    cgVar.a(networkInfoMap);
                    cgVar.a(byVar);
                    if (cgVar.d() != 0) {
                        byVar.J(cgVar.d());
                    }
                    adVarY.v = cgVar;
                    if (nVar.Z() == 66 && nVarAh.al()) {
                        adVarY.a(new com.anythink.core.basead.a.b(adVarY, byVar, nVarAh));
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

                /* JADX INFO: Access modifiers changed from: private */
                public static Map<String, Object> d(ad adVar) {
                    Map<String, Object> internalNetworkInfoMap = null;
                    if (adVar != null) {
                        try {
                            if (adVar.s != null) {
                                if (adVar.s.b() != null) {
                                    internalNetworkInfoMap = adVar.s.b().getNetworkInfoMap();
                                } else {
                                    internalNetworkInfoMap = adVar.s.a().getInternalNetworkInfoMap();
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    return internalNetworkInfoMap;
                }

                /* JADX WARN: Code duplicated, block: B:12:0x0015  */
                public static void a(com.anythink.core.common.h.c cVar, int i2) {
                    int i3;
                    int i4;
                    if (i2 == 1) {
                        i3 = 7;
                    } else if (i2 == 2) {
                        i3 = 10;
                    } else if (i2 == 3) {
                        i3 = 11;
                    } else if (i2 != 6) {
                        i3 = 2;
                    } else {
                        i3 = 7;
                    }
                    try {
                        by unitGroupInfo = cVar.e().getUnitGroupInfo();
                        n nVarI = cVar.i();
                        ad adVarY = unitGroupInfo.Y();
                        if (adVarY != null) {
                            ay ayVar = new ay(i3, unitGroupInfo, nVarI);
                            ayVar.a(i2);
                            if (i3 == 2) {
                                i4 = 34;
                            } else {
                                i4 = i3 == 11 ? 36 : 30;
                            }
                            a(adVarY, ayVar, true, i4);
                        }
                    } catch (Throwable unused) {
                    }
                }

                private static Pair<Double, Double> a(ad adVar, by byVar) {
                    double d2;
                    Double dValueOf = null;
                    if (adVar == null || byVar == null) {
                        return null;
                    }
                    double d3 = 0.0d;
                    try {
                        cg cgVar = adVar.v;
                        if (cgVar == null) {
                            return null;
                        }
                        double dA = o.a(byVar);
                        o.b(byVar);
                        d2 = adVar.r;
                        Double dA2 = cgVar.a();
                        double dDoubleValue = dA2 != null ? dA2.doubleValue() : d2;
                        if (adVar.r() || (dDoubleValue <= dA && dDoubleValue > 0.0d)) {
                            d2 = dDoubleValue;
                        } else if (d2 != 0.0d) {
                            dValueOf = Double.valueOf(dDoubleValue);
                            cgVar.a(dValueOf);
                            d2 = dA - 0.01d;
                            if (d2 < 0.0d) {
                                d2 = 0.0d;
                            }
                        }
                        try {
                            if (byVar.n() == 8) {
                                double dAz = byVar.az();
                                if (dAz > 0.0d && dAz > d2) {
                                    d2 = dAz;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            d3 = d2;
                            e.printStackTrace();
                            d2 = d3;
                        }
                        return new Pair<>(Double.valueOf(d2), dValueOf);
                    } catch (Exception e3) {
                        e = e3;
                    }
                    e.printStackTrace();
                    d2 = d3;
                    return new Pair<>(Double.valueOf(d2), dValueOf);
                }

                /* JADX WARN: Code duplicated, block: B:34:0x0079  */
                public static void a(ad adVar, by byVar, int i2) {
                    cg cgVar;
                    double dDoubleValue;
                    if (adVar == null || byVar == null || (cgVar = adVar.v) == null || adVar.d()) {
                        return;
                    }
                    cgVar.a(i2);
                    double dA = o.a(byVar);
                    double dB = o.b(byVar);
                    Double dA2 = cgVar.a();
                    if (dA2 != null) {
                        dA2.doubleValue();
                    }
                    Pair<Double, Double> pairA = a(adVar, byVar);
                    if (pairA != null) {
                        dDoubleValue = ((Double) pairA.first).doubleValue();
                        cgVar.a((Double) pairA.second);
                    } else {
                        dDoubleValue = 0.0d;
                    }
                    if (b.a(i2)) {
                        double dA3 = a(cgVar.C());
                        if (dA3 > 0.0d) {
                            if (dA3 > dDoubleValue) {
                                dDoubleValue = dA3;
                            } else {
                                String strG = byVar.G();
                                by byVarK = adVar.k();
                                String strG2 = byVarK != null ? byVarK.G() : "";
                                if (!TextUtils.isEmpty(strG) && strG.equals(strG2)) {
                                    dDoubleValue = dA3;
                                }
                            }
                        }
                    }
                    cgVar.a(dA);
                    cgVar.b(dDoubleValue);
                    cgVar.c(dB);
                    cgVar.s();
                    cgVar.d(dDoubleValue);
                    cgVar.b(Double.valueOf(adVar.j()));
                    double dA4 = a(adVar, dA);
                    double dA5 = a(adVar, dDoubleValue);
                    boolean zV = cgVar.v();
                    Map<String, Object> mapD = d(adVar);
                    if (mapD != null && cgVar.y() != null) {
                        cgVar.y().a(mapD);
                    }
                    com.anythink.core.common.u.d.a().a(cgVar.y(), byVar, com.anythink.core.common.u.d.d, "1");
                    if (byVar.as()) {
                        com.anythink.core.common.a.a.a().a(adVar);
                    }
                    cgVar.a(adVar.biddingNotice == null);
                    if (zV) {
                        String strA = com.anythink.core.c.d.a.a(adVar, cgVar, dA4, dA5);
                        if (TextUtils.isEmpty(strA)) {
                            a(cgVar);
                        } else if (cgVar != null) {
                            j.a(strA, cgVar).a(0, (com.anythink.core.common.l.s) null);
                        }
                        ATBiddingNotice aTBiddingNotice = adVar.biddingNotice;
                        if (aTBiddingNotice != null) {
                            try {
                                aTBiddingNotice.notifyBidWin(dA4, dA5, com.anythink.core.c.d.a.a(byVar.n(), adVar.k()));
                            } catch (Throwable th) {
                                th.printStackTrace();
                                Log.e("anythink", "notifyBidWin: error: " + th.getMessage());
                            }
                        }
                        if (byVar.n() == 66) {
                            AnyThinkBaseAdapter anyThinkBaseAdapterD = byVar.d();
                            if (anyThinkBaseAdapterD instanceof ATBaseAdAdapter) {
                                ((ATBaseAdAdapter) anyThinkBaseAdapterD).notifyWLInfo(1, com.anythink.core.c.d.a.a(adVar, cgVar, dA5));
                                byVar.a((AnyThinkBaseAdapter) null);
                            }
                        }
                    } else {
                        a(cgVar);
                    }
                    adVar.h();
                }
            }
