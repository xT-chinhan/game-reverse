package com.byazt.zf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.d.b.e;
import com.byazt.fvm.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 547, 29})
public class cp extends qg {
    public static final String TAG = "PgRewardVideoAdapter";
    public static final String VERSION_4400 = "4.4.0.0";
    public com.byazt.qn.qg qg;

    public cp(com.byazt.nw.qg qgVar) {
        super(qgVar);
    }

    @Override // com.byazt.ua.qg
    public void qg(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map) {
        this.qg = qgVar2;
        if (qgVar2 == null) {
            s();
        } else {
            new n(map, qgVar).n(context != null ? context.getApplicationContext() : com.byazt.qt.qg.getContext());
        }
    }

    public void s() {
        n(new com.byazt.mj.n("load ad fail adSlot is null"));
    }

    @com.byazt.cp.n(n = {0, 1, 547, 570})
    class n extends com.byazt.sg.s {
        public final String a;
        public final String cd;
        public final String cy;
        public k d;
        public final String hd;
        public final String k;
        public boolean oa;
        public final Double py;
        public Map<String, Object> sz;
        public com.byazt.ap.x tj = new AnonymousClass1(null);
        public final boolean um;

        @Override // com.byazt.sg.s
        public boolean rm() {
            return true;
        }

        public n(Map<String, Object> map, com.byazt.dd.qg qgVar) {
            Double dValueOf = null;
            this.sz = map;
            this.k = qgVar != null ? qgVar.d() : null;
            this.cy = qgVar != null ? qgVar.cy() : null;
            this.hd = qgVar != null ? qgVar.hd() : null;
            this.cd = qgVar != null ? qgVar.hu() : null;
            this.um = qgVar != null && qgVar.n();
            this.a = qgVar != null ? qgVar.qg() : null;
            if (qgVar != null && qgVar.fs() != null) {
                dValueOf = Double.valueOf(qgVar.fs().m());
            }
            this.py = dValueOf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.me.n tv() {
            return (com.byazt.me.n) this.rv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:12:0x0028  */
        public void n(Context context) {
            String str;
            com.byazt.yn.n nVarN = cp.this.n(context);
            if (nVarN == null) {
                return;
            }
            Map<String, Object> mapAn = cp.this.qg.an();
            if (mapAn != null) {
                Object obj = mapAn.get(MediationConstant.ADN_PANGLE);
                if (obj instanceof String) {
                    str = (String) obj;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                } else {
                    str = "";
                }
            } else {
                str = "";
            }
            com.byazt.zq.qg.n nVarN2 = com.byazt.mt.qg.n(cp.this.qg, this.k, this.cy, this.hd, this.cd, this.py, false);
            nVarN2.w(cp.this.qg.bb()).l(str).tj(cp.this.qg.h()).fs(cp.this.qg.t()).x(cp.this.qg.um()).n(1080).qg(1920).q(cp.this.qg.ln());
            nVarN.n(nVarN2.n(), this.tj);
        }

        @Override // com.byazt.sg.s
        public void cd() {
            k kVar = this.d;
            if (kVar != null) {
                kVar.n((com.byazt.mi.s) null);
                this.d.n((com.byazt.tmn.n) null);
                this.d.n((com.byazt.mi.qg) null);
                this.d = null;
            }
        }

        @Override // com.byazt.sg.s
        public boolean l() {
            return this.d == null;
        }

        @Override // com.byazt.sg.s
        public boolean oj() {
            return this.oa;
        }

        @Override // com.byazt.sg.s
        public String di() {
            k kVar = this.d;
            return kVar != null ? com.byazt.mt.qg.s(kVar.qg()) : "";
        }

        @Override // com.byazt.sg.s
        public String oo() {
            k kVar = this.d;
            if (kVar instanceof com.byazt.rv.l) {
                return ((com.byazt.rv.l) kVar).fs();
            }
            return null;
        }

        @Override // com.byazt.sg.s
        public Integer w() {
            k kVar = this.d;
            if (kVar != null && kVar.q() > System.currentTimeMillis()) {
                return 2;
            }
            return 3;
        }

        @Override // com.byazt.sg.s
        public void n(Activity activity, Object obj, String str) {
            k kVar = this.d;
            if (kVar != null) {
                if (obj != null) {
                    kVar.n(activity, obj, str);
                } else {
                    kVar.n(activity);
                }
            }
        }

        @Override // com.byazt.sg.s
        public Map<String, Object> bb() {
            k kVar = this.d;
            if (kVar != null) {
                s(kVar.qg());
            }
            return super.bb();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean to() {
            return !"0.0".equals(cp.this.n(MediationConstant.ADN_PANGLE)) && cp.VERSION_4400.compareTo(cp.this.n(MediationConstant.ADN_PANGLE)) > 0;
        }

        /* JADX INFO: renamed from: com.byazt.zf.cp$n$1, reason: invalid class name */
        @com.byazt.cp.n(n = {0, 1, 547, 2406})
        public class AnonymousClass1 extends com.byazt.ap.x {
            public AnonymousClass1(Function function) {
                super(function);
            }

            @Override // com.byazt.ap.x
            public void n(int i, String str) {
                com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward_onError code:" + i + "  message:" + str);
                cp.this.n(new com.byazt.mj.n(i, str));
            }

            @Override // com.byazt.ap.x
            public void n(k kVar) {
                com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward_onRewardVideoAdLoad");
                if (kVar != null) {
                    n.this.d = kVar;
                    n.this.x(true);
                    n nVar = n.this;
                    nVar.d(nVar.d.n());
                    Map<String, Object> mapQg = n.this.d.qg();
                    com.byazt.rb.qg.q(MediationConstant.TAG, "PangleRewardLoader WaterfallPangleRewardLoader extraInfo :".concat(String.valueOf(mapQg)));
                    if (n.this.um && mapQg != null) {
                        double dN = com.byazt.mt.qg.n(mapQg.get(e.a.h));
                        com.byazt.rb.qg.n("TTMediationSDK_ECMP", com.byazt.rb.q.qg(n.this.a, n.this.k) + "pangle reward 返回的 cpm价格：" + dN);
                        n nVar2 = n.this;
                        if (dN <= 0.0d) {
                            dN = 0.0d;
                        }
                        nVar2.n(dN);
                    }
                    if (mapQg != null) {
                        n.this.q(mapQg);
                        Object obj = mapQg.get("materialMetaIsFromPreload");
                        if (obj instanceof Boolean) {
                            n.this.oa = ((Boolean) obj).booleanValue();
                            com.byazt.rb.qg.n(MediationConstant.TAG, "pangle 激励 返回的adnPreload：" + n.this.oa);
                        }
                    }
                    Function function = null;
                    n.this.d.n(new com.byazt.mi.s(function) { // from class: com.byazt.zf.cp.n.1.1
                        @Override // com.byazt.mi.s
                        public void n() {
                            if (n.this.s != null) {
                                n.this.s.n();
                            }
                        }

                        @Override // com.byazt.mi.s
                        public void n(long j, long j2, String str, String str2) {
                            if (n.this.s != null) {
                                n.this.s.n(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                            }
                        }

                        @Override // com.byazt.mi.s
                        public void qg(long j, long j2, String str, String str2) {
                            if (n.this.s != null) {
                                n.this.s.n(j, j2, str, str2);
                            }
                        }

                        @Override // com.byazt.mi.s
                        public void s(long j, long j2, String str, String str2) {
                            if (n.this.s != null) {
                                n.this.s.qg(j, j2, str, str2);
                            }
                        }

                        @Override // com.byazt.mi.s
                        public void n(long j, String str, String str2) {
                            if (n.this.s != null) {
                                n.this.s.n(j, str, str2);
                            }
                        }

                        @Override // com.byazt.mi.s
                        public void n(String str, String str2) {
                            if (n.this.s != null) {
                                n.this.s.n(str, str2);
                            }
                        }
                    });
                    n.this.d.n(new com.byazt.tmn.n(function) { // from class: com.byazt.zf.cp.n.1.2
                        @Override // com.byazt.tmn.n
                        public void n(Bundle bundle) {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward:onAdShow");
                            if (n.this.rv instanceof com.byazt.me.n) {
                                n.this.tv().n();
                            }
                        }

                        @Override // com.byazt.tmn.n
                        public void qg(Bundle bundle) {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward:onAdVideoBarClick");
                            if (n.this.rv instanceof com.byazt.me.n) {
                                n.this.tv().i_();
                            }
                        }

                        @Override // com.byazt.tmn.n
                        public void s(Bundle bundle) {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward:onAdClose");
                            if (n.this.rv instanceof com.byazt.me.n) {
                                n.this.tv().j_();
                            }
                        }

                        @Override // com.byazt.tmn.n
                        public void n() {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward:onVideoComplete");
                            if (n.this.rv instanceof com.byazt.me.n) {
                                n.this.tv().q();
                            }
                        }

                        @Override // com.byazt.tmn.n
                        public void qg() {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward:onVideoError");
                            if (n.this.rv instanceof com.byazt.me.n) {
                                n.this.tv().l();
                            }
                        }

                        @Override // com.byazt.tmn.n
                        @Deprecated
                        public void n(final boolean z, final int i, final String str, final int i2, final String str2) {
                            if (n.this.to()) {
                                com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward:onRewardVerify-------------2");
                                if (n.this.rv instanceof com.byazt.me.n) {
                                    n.this.tv().n(new com.byazt.fd.n() { // from class: com.byazt.zf.cp.n.1.2.1
                                        @Override // com.byazt.fd.n
                                        public boolean n() {
                                            return z;
                                        }

                                        @Override // com.byazt.fd.n
                                        public float qg() {
                                            int i3 = i;
                                            if (i3 >= 0) {
                                                return i3;
                                            }
                                            if (cp.this.qg != null) {
                                                return cp.this.qg.t();
                                            }
                                            return 0.0f;
                                        }

                                        @Override // com.byazt.fd.n
                                        public String s() {
                                            if (TextUtils.isEmpty(str)) {
                                                return cp.this.qg != null ? cp.this.qg.h() : "";
                                            }
                                            return str;
                                        }

                                        @Override // com.byazt.fd.n
                                        public Map<String, Object> q() {
                                            HashMap map = new HashMap();
                                            map.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(i2));
                                            map.put(MediationConstant.KEY_ERROR_MSG, str2);
                                            return map;
                                        }
                                    });
                                }
                            }
                        }

                        @Override // com.byazt.tmn.n
                        public void n(final boolean z, final int i, final Bundle bundle) {
                            if (n.this.to()) {
                                return;
                            }
                            com.byazt.rb.qg.q("GROMORE_SS_REWARD_VERIFY", "csj-onRewardArrived =".concat(String.valueOf(z)));
                            com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward:onRewardArrived: ".concat(String.valueOf(z)));
                            if (n.this.rv instanceof com.byazt.me.n) {
                                n.this.tv().n(new com.byazt.fd.n() { // from class: com.byazt.zf.cp.n.1.2.2
                                    @Override // com.byazt.fd.n
                                    public boolean n() {
                                        return z;
                                    }

                                    @Override // com.byazt.fd.n
                                    public float qg() {
                                        Bundle bundle2 = bundle;
                                        float f = bundle2 != null ? bundle2.getInt("reward_extra_key_reward_amount") : 0.0f;
                                        if (f >= 0.0f) {
                                            return f;
                                        }
                                        if (cp.this.qg != null) {
                                            return cp.this.qg.t();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.byazt.fd.n
                                    public String s() {
                                        Bundle bundle2 = bundle;
                                        String string = bundle2 != null ? bundle2.getString("reward_extra_key_reward_name") : "";
                                        if (TextUtils.isEmpty(string)) {
                                            return cp.this.qg != null ? cp.this.qg.h() : "";
                                        }
                                        return string;
                                    }

                                    @Override // com.byazt.fd.n
                                    public Map<String, Object> q() {
                                        HashMap map = new HashMap();
                                        map.put(MediationConstant.KEY_EXTRA_INFO, bundle);
                                        map.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(i));
                                        return map;
                                    }
                                });
                            }
                        }

                        @Override // com.byazt.tmn.n
                        public void s() {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward:onSkippedVideo");
                            if (n.this.rv instanceof com.byazt.me.n) {
                                n.this.tv().w();
                            }
                        }
                    });
                    cp.this.n(n.this);
                    return;
                }
                cp.this.n(new com.byazt.mj.n("请求成功，但无广告可用"));
            }

            @Override // com.byazt.ap.x
            public void n() {
                com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward_onRewardVideoCached");
            }

            @Override // com.byazt.ap.x
            public void qg(k kVar) {
                com.byazt.rb.qg.q(MediationConstant.TAG, "pangle_reward_onRewardVideoCached 2");
                cp.this.n(n.this, (com.byazt.mj.n) null);
            }
        }

        @Override // com.byazt.sg.s
        public long dz() {
            k kVar = this.d;
            if (kVar != null) {
                return com.byazt.mt.qg.n(kVar.qg());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public long c() {
            k kVar = this.d;
            if (kVar != null) {
                return com.byazt.mt.qg.qg(kVar.qg());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.mi.qg qgVar) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "PangleRewardLoader WaterfallPangleRewardLoader setAdInteractionListener pluginTTAdInteractionListener:" + qgVar + "  mTTRewardVideoAd: " + this.d);
            k kVar = this.d;
            if (kVar != null) {
                kVar.n(qgVar);
            }
        }
    }
}
