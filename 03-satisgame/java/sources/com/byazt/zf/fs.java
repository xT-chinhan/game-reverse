package com.byazt.zf;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.anythink.core.d.b.e;
import com.byazt.fvm.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 547, 101})
public class fs {
    public void n(final boolean z, com.byazt.yn.n nVar, final com.byazt.zq.qg qgVar, final com.byazt.ua.qg qgVar2) {
        if (nVar == null || qgVar2 == null || qgVar == null) {
            return;
        }
        nVar.n(qgVar, new com.byazt.ap.s(null) { // from class: com.byazt.zf.fs.1
            @Override // com.byazt.ap.s
            public void n(int i, String str) {
                qgVar2.n(new com.byazt.mj.n(i, str));
            }

            @Override // com.byazt.ap.s
            public void n(List<com.byazt.fvm.tj> list) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "PangleNativeAd_onFeedAdLoad_SupportRenderControl:" + qgVar.cp());
                if (list == null || list.isEmpty()) {
                    qgVar2.n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                if (qgVar.cp()) {
                    fs.this.n(list, qgVar2, z);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.byazt.fvm.tj> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new n(it.next(), z, false));
                }
                qgVar2.n(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(List<com.byazt.fvm.tj> list, final com.byazt.ua.qg qgVar, final boolean z) {
        int size = list.size();
        com.byazt.rb.qg.qg(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_adNum:".concat(String.valueOf(size)));
        final AtomicInteger atomicInteger = new AtomicInteger();
        final ArrayList arrayList = new ArrayList();
        for (final com.byazt.fvm.tj tjVar : list) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final int i = size;
            tjVar.n(new com.byazt.dc.s(null) { // from class: com.byazt.zf.fs.2
                @Override // com.byazt.dc.s
                public void n(View view, float f, float f2, boolean z2) {
                    com.byazt.rb.qg.qg(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_onRenderSuccess:" + z2 + " duration:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    arrayList.add(new n(tjVar, z, z2));
                    if (atomicInteger.incrementAndGet() != i || qgVar == null) {
                        return;
                    }
                    com.byazt.rb.qg.qg(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_notifyAdSuccess!!!!!");
                    qgVar.n(arrayList);
                }
            });
            tjVar.wm();
            size = size;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 547, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    private static class n extends com.byazt.sg.s {
        public int cy;
        public com.byazt.fvm.tj k;
        public com.byazt.dc.n tj = new com.byazt.dc.n(0 == true ? 1 : 0) { // from class: com.byazt.zf.fs.n.2
            @Override // com.byazt.dc.n
            public void n(View view, oa oaVar) {
                if (n.this.n != null) {
                    n.this.n.n(view);
                }
            }

            @Override // com.byazt.dc.n
            public void qg(View view, oa oaVar) {
                if (n.this.n != null) {
                    n.this.n.n(view);
                }
            }

            @Override // com.byazt.dc.n
            public void n(oa oaVar) {
                if (n.this.n != null) {
                    n.this.n.n();
                }
            }
        };
        public com.byazt.wn.n cp = new com.byazt.wn.n(0 == true ? 1 : 0) { // from class: com.byazt.zf.fs.n.3
            @Override // com.byazt.wn.n
            public void n(com.byazt.fvm.tj tjVar) {
                if (n.this.qg != null) {
                    n.this.qg.n();
                }
            }

            @Override // com.byazt.wn.n
            public void n(int i, int i2) {
                if (n.this.qg != null) {
                    n.this.qg.n(new com.byazt.mj.n(i, "Android MediaPlay Error Code :".concat(String.valueOf(i2))));
                }
            }

            @Override // com.byazt.wn.n
            public void qg(com.byazt.fvm.tj tjVar) {
                if (n.this.qg != null) {
                    n.this.qg.qg();
                }
            }

            @Override // com.byazt.wn.n
            public void s(com.byazt.fvm.tj tjVar) {
                if (n.this.qg != null) {
                    n.this.qg.s();
                }
            }

            @Override // com.byazt.wn.n
            public void q(com.byazt.fvm.tj tjVar) {
                if (n.this.qg != null) {
                    n.this.qg.q();
                }
            }

            @Override // com.byazt.wn.n
            public void n(long j, long j2) {
                if (n.this.qg != null) {
                    n.this.qg.n(j, j2);
                }
            }

            @Override // com.byazt.wn.n
            public void l(com.byazt.fvm.tj tjVar) {
                if (n.this.qg != null) {
                    n.this.qg.l();
                }
            }
        };
        public com.byazt.dc.qg d = new com.byazt.dc.qg(0 == true ? 1 : 0) { // from class: com.byazt.zf.fs.n.4
            @Override // com.byazt.dc.qg
            public void n(JSONObject jSONObject) {
                if (n.this.l != null) {
                    n.this.l.n(jSONObject);
                }
            }

            @Override // com.byazt.dc.qg
            public JSONObject n() {
                if (n.this.l != null) {
                    return n.this.l.n();
                }
                return null;
            }

            @Override // com.byazt.dc.qg
            public void qg(JSONObject jSONObject) {
                if (n.this.l != null) {
                    n.this.l.qg(jSONObject);
                }
            }

            @Override // com.byazt.dc.qg
            public void s(JSONObject jSONObject) {
                if (n.this.l != null) {
                    n.this.l.s(jSONObject);
                }
            }

            @Override // com.byazt.dc.qg
            public void qg() {
                if (n.this.l != null) {
                    n.this.l.qg();
                }
            }
        };
        public com.byazt.dc.q oa = new com.byazt.dc.q(0 == true ? 1 : 0) { // from class: com.byazt.zf.fs.n.5
            @Override // com.byazt.dc.q
            public void n(JSONObject jSONObject) {
                if (n.this.w != null) {
                    n.this.w.n(jSONObject);
                }
            }

            @Override // com.byazt.dc.q
            public void qg(JSONObject jSONObject) {
                if (n.this.w != null) {
                    n.this.w.qg(jSONObject);
                }
            }

            @Override // com.byazt.dc.q
            public void s(JSONObject jSONObject) {
                if (n.this.w != null) {
                    n.this.w.s(jSONObject);
                }
            }

            @Override // com.byazt.dc.q
            public void n() {
                if (n.this.w != null) {
                    n.this.w.n();
                }
            }
        };
        public com.byazt.mi.s sz = new com.byazt.mi.s(0 == true ? 1 : 0) { // from class: com.byazt.zf.fs.n.6
            @Override // com.byazt.mi.s
            public void n() {
                n.this.cy = 0;
                if (n.this.s != null) {
                    n.this.s.n();
                }
            }

            @Override // com.byazt.mi.s
            public void n(long j, long j2, String str, String str2) {
                n.this.cy = 2;
                if (n.this.s != null) {
                    n.this.s.n(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                }
            }

            @Override // com.byazt.mi.s
            public void qg(long j, long j2, String str, String str2) {
                n.this.cy = 3;
                if (n.this.s != null) {
                    n.this.s.n(j, j2, str, str2);
                }
            }

            @Override // com.byazt.mi.s
            public void s(long j, long j2, String str, String str2) {
                n.this.cy = 4;
                if (n.this.s != null) {
                    n.this.s.qg(j, j2, str, str2);
                }
            }

            @Override // com.byazt.mi.s
            public void n(long j, String str, String str2) {
                n.this.cy = 5;
                if (n.this.s != null) {
                    n.this.s.n(j, str, str2);
                }
            }

            @Override // com.byazt.mi.s
            public void n(String str, String str2) {
                n.this.cy = 6;
                if (n.this.s != null) {
                    n.this.s.n(str, str2);
                }
            }
        };

        @Override // com.byazt.sg.s
        public boolean a() {
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public n(com.byazt.fvm.tj tjVar, boolean z, boolean z2) {
            Map<String, Object> mapOu;
            List<com.byazt.fvm.d> listK;
            this.k = tjVar;
            com.byazt.fvm.s sVarUm = tjVar.um();
            if (sVarUm != null) {
                ou(sVarUm.n());
                wm(sVarUm.s());
                hu(sVarUm.q());
                h(sVarUm.qg());
                HashMap map = new HashMap();
                Map<String, String> mapL = sVarUm.l();
                if (mapL != null && mapL.size() > 0) {
                    map.putAll(mapL);
                }
                x(map);
                if (com.byazt.mt.qg.n("5.1.0.0")) {
                    m(sVarUm.w());
                }
                if (com.byazt.mt.qg.n("5.4.0.3")) {
                    d(sVarUm.x());
                }
                if (com.byazt.mt.qg.n("6.8.1.6")) {
                    tj(sVarUm.fs());
                }
                cp(sVarUm.rv());
            }
            qg(z2 ? 1 : 0);
            v(tjVar.x());
            j(tjVar.fs());
            ln(tjVar.rv());
            ur(tjVar.sz() != null ? tjVar.sz().s() : null);
            cp(tjVar.hd());
            d(tjVar.cy());
            an(tjVar.oa());
            q(tjVar.tj());
            fs(tjVar.cy() == 4);
            x(false);
            if (tjVar.hd() == 16 || tjVar.hd() == 3 || tjVar.hd() == 2 || tjVar.hd() == 131) {
                List<com.byazt.fvm.d> listK2 = tjVar.k();
                if (listK2 != null && !listK2.isEmpty() && listK2.get(0) != null) {
                    com.byazt.fvm.d dVar = listK2.get(0);
                    bb(dVar.s());
                    um(dVar.n());
                    cd(dVar.qg());
                }
            } else if (tjVar.hd() == 4) {
                List<com.byazt.fvm.d> listK3 = tjVar.k();
                if (listK3 != null && listK3.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.byazt.fvm.d> it = listK3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().s());
                    }
                    n((List<String>) arrayList);
                }
            } else {
                com.byazt.fvm.d dVarL = tjVar.l();
                if ((dVarL == null || TextUtils.isEmpty(dVarL.s())) && (listK = tjVar.k()) != null && !listK.isEmpty() && listK.get(0) != null) {
                    dVarL = listK.get(0);
                }
                if (dVarL != null) {
                    bb(dVarL.s());
                    um(dVarL.n());
                    cd(dVarL.qg());
                }
            }
            if (z && (mapOu = tjVar.ou()) != null) {
                double dN = com.byazt.mt.qg.n(mapOu.get(e.a.h));
                com.byazt.rb.qg.n("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(dN)));
                n(dN <= 0.0d ? 0.0d : dN);
            }
            this.k.n(this.cp);
            this.k.n(this.sz);
            this.k.n(this.d);
            new HashMap();
            n(MediationConstant.EXTRA_ADID, Long.valueOf(c()));
            n("c_id", Long.valueOf(dz()));
            n(MediationConstant.EXTRA_DURATION, Double.valueOf(this.k.n()));
            Map<String, Object> mapOu2 = this.k.ou();
            if (mapOu2 != null) {
                q(mapOu2);
                n("log_extra", mapOu2.toString());
            }
        }

        @Override // com.byazt.sg.s
        public Map<String, Object> bb() {
            Map<String, Object> mapOu;
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar == null || (mapOu = tjVar.ou()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapOu.get("coupon"));
            map.put("live_room", mapOu.get("live_room"));
            map.put("product", mapOu.get("product"));
            s(map);
            return super.bb();
        }

        private void qg(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                tjVar.n(this.sz);
                try {
                    this.k.n(new com.byazt.wn.qg(null) { // from class: com.byazt.zf.fs.n.1
                        @Override // com.byazt.wn.qg
                        public void n(int i) {
                            if (n.this.x != null) {
                                n.this.x.n(i);
                            }
                        }
                    });
                } catch (Throwable unused) {
                }
                this.k.n(viewGroup, list, list2, list3, list4, view, this.tj);
            }
        }

        @Override // com.byazt.sg.s
        public void n(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.n(viewGroup, list, list2, list3, list4, view);
            qg(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.mi.qg qgVar) {
            this.k.n(qgVar);
        }

        @Override // com.byazt.sg.s
        public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.fz.d dVar, List<View> list4) {
            FrameLayout frameLayout;
            com.byazt.fvm.tj tjVar;
            View viewPy;
            com.byazt.fvm.tj tjVar2;
            View viewFindViewById;
            super.n(activity, viewGroup, list, list2, list3, dVar, list4);
            qg(viewGroup, null, list, list2, list3, null);
            com.byazt.fvm.tj tjVar3 = this.k;
            if (tjVar3 != null && tjVar3.w() != null && dVar != null && (viewFindViewById = viewGroup.findViewById(dVar.d)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.k.w());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.byazt.rb.w.qg(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.byazt.rb.w.qg(viewGroup.getContext(), 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.k.w());
                }
            }
            if ((an() && (tjVar2 = this.k) != null && tjVar2.qg() != null && !TextUtils.isEmpty(this.k.qg().n())) || dVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(dVar.x)) == null || (tjVar = this.k) == null || (viewPy = tjVar.py()) == null) {
                return;
            }
            qg(viewPy);
            frameLayout.removeAllViews();
            frameLayout.addView(viewPy, -1, -1);
        }

        @Override // com.byazt.sg.s
        public int wf() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                return tjVar.s();
            }
            return 0;
        }

        @Override // com.byazt.sg.s
        public int lr() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                return tjVar.q();
            }
            return 0;
        }

        @Override // com.byazt.sg.s
        public View tj() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                return tjVar.py();
            }
            return null;
        }

        @Override // com.byazt.sg.s
        public String x() {
            com.byazt.fvm.tj tjVar;
            if (!an() || (tjVar = this.k) == null || tjVar.qg() == null) {
                return null;
            }
            return this.k.qg().n();
        }

        @Override // com.byazt.sg.s
        public Bitmap dx() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                return tjVar.w();
            }
            return super.dx();
        }

        @Override // com.byazt.sg.s
        public double on() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                return tjVar.n();
            }
            return super.on();
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.d es() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                return tjVar.l();
            }
            return super.es();
        }

        @Override // com.byazt.sg.s
        public int yp() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                return tjVar.cp();
            }
            return super.yp();
        }

        @Override // com.byazt.sg.s
        public void qg(Activity activity) {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                tjVar.qg(activity);
            }
        }

        @Override // com.byazt.sg.s
        public void cd() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                tjVar.n((com.byazt.wn.n) null);
                this.k.m();
                this.k = null;
            }
        }

        @Override // com.byazt.sg.s
        public boolean l() {
            return this.k == null;
        }

        @Override // com.byazt.sg.s
        public String di() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                return com.byazt.mt.qg.s(tjVar.ou());
            }
            return null;
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.fz.fs fsVar) {
            super.n(fsVar);
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                tjVar.n(fsVar == null ? null : this.oa);
            }
        }

        @Override // com.byazt.sg.s
        public void n() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar == null || tjVar.a() == null || this.cy != 2) {
                return;
            }
            this.k.a().n();
        }

        @Override // com.byazt.sg.s
        public void qg() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar == null || tjVar.a() == null || this.cy != 3) {
                return;
            }
            this.k.a().n();
        }

        @Override // com.byazt.sg.s
        public void s() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar == null || tjVar.a() == null) {
                return;
            }
            this.k.a().qg();
        }

        @Override // com.byazt.sg.s
        public int q() {
            return this.cy;
        }

        @Override // com.byazt.sg.s
        public long dz() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                return com.byazt.mt.qg.n(tjVar.ou());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public long c() {
            com.byazt.fvm.tj tjVar = this.k;
            if (tjVar != null) {
                return com.byazt.mt.qg.qg(tjVar.ou());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public void n(Activity activity, com.byazt.lr.n nVar) {
            if (this.k != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle native:  activity = " + activity + " pluginDislikeInteractionCallback:" + nVar);
                this.k.n(activity, nVar);
            }
        }

        @Override // com.byazt.sg.s
        public void n(Dialog dialog, Integer[] numArr) {
            if (this.k != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.k.qg(dialog, numArr);
            }
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.x n(Activity activity) {
            if (this.k == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle native : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.k.n(activity);
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.x qg(Dialog dialog, Integer[] numArr) {
            if (this.k == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.k.n(dialog, numArr);
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.q qd() {
            if (this.k == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle native : getDislikeInfo");
            return this.k.cd();
        }

        @Override // com.byazt.sg.s
        public void f(String str) {
            if (this.k != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle native : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.k.n(str);
            }
        }

        @Override // com.byazt.sg.s
        public com.byazt.fz.l fs() {
            if (an()) {
                return new com.byazt.fz.l() { // from class: com.byazt.zf.fs.n.7
                    @Override // com.byazt.fz.l
                    public void n(long j) {
                        if (n.this.k == null || n.this.k.qg() == null) {
                            return;
                        }
                        n.this.k.qg().n(j);
                    }

                    @Override // com.byazt.fz.l
                    public void qg(long j) {
                        if (n.this.k == null || n.this.k.qg() == null) {
                            return;
                        }
                        n.this.k.qg().qg(j);
                    }

                    @Override // com.byazt.fz.l
                    public void n() {
                        if (n.this.k == null || n.this.k.qg() == null) {
                            return;
                        }
                        n.this.k.qg().s();
                    }

                    @Override // com.byazt.fz.l
                    public void s(long j) {
                        if (n.this.k == null || n.this.k.qg() == null) {
                            return;
                        }
                        n.this.k.qg().s(j);
                    }

                    @Override // com.byazt.fz.l
                    public void qg() {
                        if (n.this.k == null || n.this.k.qg() == null) {
                            return;
                        }
                        n.this.k.qg().q();
                    }

                    @Override // com.byazt.fz.l
                    public void n(int i, int i2) {
                        if (n.this.k == null || n.this.k.qg() == null) {
                            return;
                        }
                        n.this.k.qg().n(i, i2);
                    }

                    @Override // com.byazt.fz.l
                    public void n(long j, int i, int i2) {
                        if (n.this.k == null || n.this.k.qg() == null) {
                            return;
                        }
                        n.this.k.qg().n(j, i, i2);
                    }
                };
            }
            return null;
        }
    }
}
