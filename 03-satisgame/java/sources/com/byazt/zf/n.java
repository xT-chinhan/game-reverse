package com.byazt.zf;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.anythink.core.d.b.e;
import com.byazt.fvm.oa;
import com.byazt.fvm.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 547, 19})
public class n extends com.byazt.zf.qg {
    public String fs;
    public String l;
    public String q;
    public com.byazt.qn.qg qg;
    public Double rv;
    public String s;
    public String w;
    public boolean x;

    public n(com.byazt.nw.qg qgVar) {
        super(qgVar);
    }

    @Override // com.byazt.ua.qg
    public void qg(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map) {
        this.qg = qgVar2;
        if (qgVar != null) {
            this.s = qgVar.d();
            this.q = qgVar.cy();
            this.l = qgVar.hd();
            this.w = qgVar.hu();
            this.x = qgVar.n();
            this.fs = qgVar.qg();
            this.rv = qgVar.fs() != null ? Double.valueOf(qgVar.fs().m()) : null;
        }
        if (this.qg == null) {
            n(new com.byazt.mj.n("load ad fail adSlot is null"));
            return;
        }
        if (map != null) {
            Object obj = map.get("tt_ad_sub_type");
            if (obj != null && ((Integer) obj).intValue() == 4) {
                Object obj2 = map.get("tt_ad_origin_type");
                if (obj2 != null) {
                    int iIntValue = ((Integer) obj2).intValue();
                    if (iIntValue == 1) {
                        qg(context.getApplicationContext());
                        return;
                    } else if (iIntValue == 2) {
                        s(context.getApplicationContext());
                        return;
                    } else {
                        n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "originType is mismatch"));
                        return;
                    }
                }
                return;
            }
            new s().n(context.getApplicationContext());
        }
    }

    private void qg(final Context context) {
        com.byazt.yn.n nVarN = n(context);
        if (nVarN == null) {
            return;
        }
        com.byazt.zq.qg.n nVarQg = com.byazt.mt.qg.n(this.qg, this.s, this.q, this.l, this.w, this.rv, false).x(this.qg.um()).n(this.qg.ou()).qg(this.qg.wm());
        float fOa = this.qg.oa();
        float fSz = this.qg.sz();
        boolean zN = com.byazt.mt.qg.n(this.qg);
        com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner native express autoHeight:" + zN + " width:" + fOa + "  height:" + fSz);
        if (fSz > 0.0f && !zN) {
            nVarQg.n(fOa).qg(fSz);
        } else {
            nVarQg.n(fOa).qg(0.0f);
        }
        nVarN.n(nVarQg.n(), new com.byazt.ap.w(null) { // from class: com.byazt.zf.n.1
            @Override // com.byazt.ap.w
            public void n(int i, String str) {
                n.this.n(new com.byazt.mj.n(i, str));
            }

            @Override // com.byazt.ap.w
            public void n(List<sz> list) {
                if (list == null || list.size() == 0) {
                    n.this.n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                    return;
                }
                for (sz szVar : list) {
                    if (szVar != null) {
                        n.this.new qg(context, szVar).cp();
                        return;
                    }
                }
            }
        });
    }

    private void s(final Context context) {
        com.byazt.yn.n nVarN = n(context);
        if (nVarN == null) {
            return;
        }
        com.byazt.zq.qg.n nVarN2 = com.byazt.mt.qg.n(this.qg, this.s, this.q, this.l, this.w, this.rv, false);
        nVarN2.n(this.qg.ou()).x(this.qg.um()).qg(this.qg.wm());
        nVarN.n(nVarN2.n(), new com.byazt.ap.s(null) { // from class: com.byazt.zf.n.2
            @Override // com.byazt.ap.s
            public void n(int i, String str) {
                n.this.n(new com.byazt.mj.n(i, str));
            }

            @Override // com.byazt.ap.s
            public void n(List<com.byazt.fvm.tj> list) {
                if (list == null || list.isEmpty()) {
                    n.this.n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                    return;
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(n.this.new C0414n(context, list.get(0)));
                n.this.n(arrayList);
            }
        });
    }

    @com.byazt.cp.n(n = {0, 1, 547, 226})
    class qg extends com.byazt.sg.s {
        public boolean d;
        public volatile boolean oa = false;
        public final com.byazt.fx.qg sz;
        public sz tj;

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.kt.n tv() {
            return (com.byazt.kt.n) this.rv;
        }

        public qg(Context context, sz szVar) {
            Map<String, Object> mapFs;
            Function function = null;
            com.byazt.fx.qg qgVar = new com.byazt.fx.qg(function) { // from class: com.byazt.zf.n.qg.3
                @Override // com.byazt.fx.qg
                public void n(View view, int i) {
                    if (qg.this.rv instanceof com.byazt.kt.n) {
                        qg.this.tv().n(view);
                    }
                }

                @Override // com.byazt.fx.qg
                public void qg(View view, int i) {
                    if (qg.this.rv instanceof com.byazt.kt.n) {
                        qg.this.tv().qg(view);
                    }
                }

                @Override // com.byazt.fx.qg
                public void n(View view, String str, int i) {
                    n.this.n(new com.byazt.mj.n(i, str));
                }

                @Override // com.byazt.fx.qg
                public void n(View view, float f, float f2) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(qg.this);
                    n.this.n(arrayList);
                }
            };
            this.sz = qgVar;
            this.tj = szVar;
            cp(szVar.qg());
            d(this.tj.s());
            x(true);
            this.tj.n(qgVar);
            if (context instanceof Activity) {
                this.tj.n((Activity) context, new com.byazt.lr.n(function) { // from class: com.byazt.zf.n.qg.1
                    @Override // com.byazt.lr.n
                    public void n() {
                    }

                    @Override // com.byazt.lr.n
                    public void qg() {
                    }

                    @Override // com.byazt.lr.n
                    public void n(int i, String str, boolean z) {
                        if (qg.this.d) {
                            return;
                        }
                        qg.this.d = true;
                        if (qg.this.rv instanceof com.byazt.kt.n) {
                            com.byazt.mv.n.n(n.this.fs);
                            qg.this.tv().n();
                        }
                    }
                });
            }
            if (!n.this.x || (mapFs = this.tj.fs()) == null) {
                return;
            }
            double dN = com.byazt.mt.qg.n(mapFs.get(e.a.h));
            com.byazt.rb.qg.n("TTMediationSDK_ECMP", "banner混存 pangle 模板native 返回的 cpm价格：".concat(String.valueOf(dN)));
            n(dN <= 0.0d ? 0.0d : dN);
        }

        @Override // com.byazt.sg.s
        public Map<String, Object> bb() {
            Map<String, Object> mapFs;
            sz szVar = this.tj;
            if (szVar == null || (mapFs = szVar.fs()) == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "getMediaExtraInfo ".concat(String.valueOf(mapFs)));
            s(mapFs);
            return super.bb();
        }

        @Override // com.byazt.sg.s
        public void cp() {
            sz szVar = this.tj;
            if (szVar != null) {
                szVar.q();
            }
        }

        @Override // com.byazt.sg.s
        public View rv() {
            sz szVar = this.tj;
            if (szVar != null) {
                return szVar.n();
            }
            return null;
        }

        @Override // com.byazt.sg.s
        public String di() {
            sz szVar = this.tj;
            return szVar != null ? com.byazt.mt.qg.s(szVar.fs()) : "";
        }

        @Override // com.byazt.sg.s
        public void cd() {
            this.oa = true;
            com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.zf.n.qg.2
                @Override // java.lang.Runnable
                public void run() {
                    if (qg.this.tj != null) {
                        qg.this.tj.l();
                    }
                }
            });
        }

        @Override // com.byazt.sg.s
        public boolean l() {
            return this.oa;
        }

        @Override // com.byazt.sg.s
        public long dz() {
            sz szVar = this.tj;
            if (szVar != null) {
                return com.byazt.mt.qg.n(szVar.fs());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public long c() {
            sz szVar = this.tj;
            if (szVar != null) {
                return com.byazt.mt.qg.qg(szVar.fs());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public void n(Activity activity, final com.byazt.lr.n nVar) {
            if (this.tj != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner-native express:  activity = " + activity + " pluginDislikeInteractionCallback:" + nVar);
                this.tj.n(activity, new com.byazt.lr.n(null) { // from class: com.byazt.zf.n.qg.4
                    @Override // com.byazt.lr.n
                    public void n() {
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.n();
                        }
                    }

                    @Override // com.byazt.lr.n
                    public void n(int i, String str, boolean z) {
                        if (qg.this.d) {
                            return;
                        }
                        qg.this.d = true;
                        com.byazt.mv.n.n(n.this.fs);
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.n(i, str, z);
                        }
                    }

                    @Override // com.byazt.lr.n
                    public void qg() {
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.qg();
                        }
                    }
                });
            }
        }

        @Override // com.byazt.sg.s
        public void n(Dialog dialog, Integer[] numArr) {
            if (this.tj != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner-native express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.tj.n(dialog, numArr);
            }
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.x n(Activity activity) {
            sz szVar = this.tj;
            if (szVar != null) {
                return szVar.n(activity);
            }
            return super.n(activity);
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.q qd() {
            sz szVar = this.tj;
            if (szVar != null) {
                return szVar.w();
            }
            return super.qd();
        }

        @Override // com.byazt.sg.s
        public void f(String str) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            sz szVar = this.tj;
            if (szVar != null) {
                szVar.n(str);
            }
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.mi.s sVar) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(sVar)));
            sz szVar = this.tj;
            if (szVar != null) {
                szVar.n(sVar);
            }
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.fx.s sVar) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner express: setVideoAdListener pluginExpressVideoAdListener = ".concat(String.valueOf(sVar)));
            sz szVar = this.tj;
            if (szVar != null) {
                szVar.n(sVar);
            }
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.mi.qg qgVar) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(qgVar)));
            sz szVar = this.tj;
            if (szVar != null) {
                szVar.n(qgVar);
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.zf.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 547, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    class C0414n extends com.byazt.sg.s {
        public com.byazt.fvm.tj d;
        public Context oa;
        public boolean sz;
        public volatile boolean k = false;
        public com.byazt.dc.n tj = new com.byazt.dc.n(0 == true ? 1 : 0) { // from class: com.byazt.zf.n.n.3
            @Override // com.byazt.dc.n
            public void n(View view, oa oaVar) {
                if (C0414n.this.rv instanceof com.byazt.kt.n) {
                    C0414n.this.tv().n(view);
                }
            }

            @Override // com.byazt.dc.n
            public void qg(View view, oa oaVar) {
                if (C0414n.this.rv instanceof com.byazt.kt.n) {
                    C0414n.this.tv().n(view);
                }
            }

            @Override // com.byazt.dc.n
            public void n(oa oaVar) {
                if (C0414n.this.rv instanceof com.byazt.kt.n) {
                    C0414n.this.tv().qg(null);
                }
            }
        };

        @Override // com.byazt.sg.s
        public boolean a() {
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0414n(Context context, com.byazt.fvm.tj tjVar) {
            Map<String, Object> mapOu;
            this.d = tjVar;
            this.oa = context;
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
                if (com.byazt.mt.qg.n("5.4.0.3")) {
                    d(sVarUm.x());
                }
                if (com.byazt.mt.qg.n("6.8.1.6")) {
                    tj(sVarUm.fs());
                }
                cp(sVarUm.rv());
            }
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
                if (tjVar.k() != null && !tjVar.k().isEmpty() && tjVar.k().get(0) != null) {
                    com.byazt.fvm.d dVar = tjVar.k().get(0);
                    bb(dVar.s());
                    um(dVar.n());
                    cd(dVar.qg());
                }
            } else if (tjVar.hd() == 4 && tjVar.k() != null && tjVar.k().size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.byazt.fvm.d> it = tjVar.k().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().s());
                }
                n((List<String>) arrayList);
            }
            cp(tjVar.hd());
            if (!n.this.x || (mapOu = tjVar.ou()) == null) {
                return;
            }
            double dN = com.byazt.mt.qg.n(mapOu.get(e.a.h));
            com.byazt.rb.qg.n("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(dN)));
            n(dN <= 0.0d ? 0.0d : dN);
        }

        @Override // com.byazt.sg.s
        public Map<String, Object> bb() {
            Map<String, Object> mapOu;
            com.byazt.fvm.tj tjVar = this.d;
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

        @Override // com.byazt.sg.s
        public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.fz.d dVar, List<View> list4) {
            FrameLayout frameLayout;
            com.byazt.fvm.tj tjVar;
            View viewPy;
            View viewFindViewById;
            super.n(activity, viewGroup, list, list2, list3, dVar, list4);
            com.byazt.fvm.tj tjVar2 = this.d;
            if (tjVar2 != null) {
                tjVar2.n(viewGroup, (List<View>) null, list, list2, list3, (View) null, this.tj);
                this.d.n(activity, new com.byazt.lr.n(null) { // from class: com.byazt.zf.n.n.1
                    @Override // com.byazt.lr.n
                    public void n() {
                    }

                    @Override // com.byazt.lr.n
                    public void qg() {
                    }

                    @Override // com.byazt.lr.n
                    public void n(int i, String str, boolean z) {
                        if (C0414n.this.sz) {
                            return;
                        }
                        C0414n.this.sz = true;
                        if (C0414n.this.rv instanceof com.byazt.kt.n) {
                            com.byazt.mv.n.n(n.this.fs);
                            C0414n.this.tv().n();
                        }
                    }
                });
            }
            com.byazt.fvm.tj tjVar3 = this.d;
            if (tjVar3 != null && tjVar3.w() != null && dVar != null && (viewFindViewById = viewGroup.findViewById(dVar.d)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(this.oa);
                    imageView.setImageBitmap(this.d.w());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.byazt.mj.l.s(this.oa, 38.0f);
                    layoutParams.height = com.byazt.mj.l.s(this.oa, 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.d.w());
                }
            }
            if (dVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(dVar.x)) == null || (tjVar = this.d) == null || (viewPy = tjVar.py()) == null) {
                return;
            }
            qg(viewPy);
            frameLayout.removeAllViews();
            frameLayout.addView(viewPy, -1, -1);
        }

        @Override // com.byazt.sg.s
        public int wf() {
            com.byazt.fvm.tj tjVar = this.d;
            if (tjVar != null) {
                return tjVar.s();
            }
            return 0;
        }

        @Override // com.byazt.sg.s
        public int lr() {
            com.byazt.fvm.tj tjVar = this.d;
            if (tjVar != null) {
                return tjVar.q();
            }
            return 0;
        }

        @Override // com.byazt.sg.s
        public void cd() {
            this.k = true;
            com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.zf.n.n.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C0414n.this.d != null) {
                        C0414n.this.d.n((com.byazt.wn.n) null);
                        C0414n.this.d.n((com.byazt.mi.qg) null);
                        C0414n.this.d.m();
                    }
                }
            });
        }

        @Override // com.byazt.sg.s
        public boolean l() {
            return this.k;
        }

        @Override // com.byazt.sg.s
        public String di() {
            com.byazt.fvm.tj tjVar = this.d;
            return tjVar != null ? com.byazt.mt.qg.s(tjVar.ou()) : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.kt.n tv() {
            return (com.byazt.kt.n) this.rv;
        }

        @Override // com.byazt.sg.s
        public long dz() {
            com.byazt.fvm.tj tjVar = this.d;
            if (tjVar != null) {
                return com.byazt.mt.qg.n(tjVar.ou());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public long c() {
            com.byazt.fvm.tj tjVar = this.d;
            if (tjVar != null) {
                return com.byazt.mt.qg.qg(tjVar.ou());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public void n(Activity activity, final com.byazt.lr.n nVar) {
            if (this.d != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner native:  activity = " + activity + " pluginDislikeInteractionCallback:" + nVar);
                this.d.n(activity, new com.byazt.lr.n(null) { // from class: com.byazt.zf.n.n.4
                    @Override // com.byazt.lr.n
                    public void n() {
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.n();
                        }
                    }

                    @Override // com.byazt.lr.n
                    public void n(int i, String str, boolean z) {
                        if (C0414n.this.sz) {
                            return;
                        }
                        C0414n.this.sz = true;
                        com.byazt.mv.n.n(n.this.fs);
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.n(i, str, z);
                        }
                    }

                    @Override // com.byazt.lr.n
                    public void qg() {
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.qg();
                        }
                    }
                });
            }
        }

        @Override // com.byazt.sg.s
        public void n(Dialog dialog, Integer[] numArr) {
            if (this.d != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.d.qg(dialog, numArr);
            }
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.x n(Activity activity) {
            if (this.d == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner native: getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.d.n(activity);
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.x qg(Dialog dialog, Integer[] numArr) {
            if (this.d == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.d.n(dialog, numArr);
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.q qd() {
            if (this.d == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner native : getDislikeInfo");
            return this.d.cd();
        }

        @Override // com.byazt.sg.s
        public void f(String str) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner native: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            com.byazt.fvm.tj tjVar = this.d;
            if (tjVar != null) {
                tjVar.n(str);
            }
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.mi.qg qgVar) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner native: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(qgVar)));
            com.byazt.fvm.tj tjVar = this.d;
            if (tjVar != null) {
                tjVar.n(qgVar);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 547, 829})
    class s extends com.byazt.sg.s {
        public SoftReference<FrameLayout> cp;
        public boolean k;
        public boolean sz;
        public sz tj;
        public final Object d = new Object();
        public volatile boolean cy = false;
        public final com.byazt.fx.qg hd = new com.byazt.fx.qg(null) { // from class: com.byazt.zf.n.s.4
            @Override // com.byazt.fx.qg
            public void n(View view, int i) {
                if (s.this.rv instanceof com.byazt.kt.n) {
                    s.this.tv().n(view);
                }
            }

            @Override // com.byazt.fx.qg
            public void qg(View view, int i) {
                if (s.this.rv instanceof com.byazt.kt.n) {
                    s.this.tv().qg(view);
                }
            }

            @Override // com.byazt.fx.qg
            public void n(View view, String str, int i) {
                s.this.k = false;
                com.byazt.rb.qg.q("TTMediationSDK_banner", com.byazt.rb.q.qg(n.this.fs, n.this.s) + "TTBannerView onRenderFail -> code=" + i + ",msg=" + str);
            }

            @Override // com.byazt.fx.qg
            public void n(View view, float f, float f2) {
                com.byazt.rb.qg.q("TTMediationSDK_banner", com.byazt.rb.q.qg(n.this.fs, n.this.s) + "TTBannerView onRenderSuccess 渲染成功！！mBannerViewRef = " + s.this.cp);
                if (s.this.cp != null) {
                    FrameLayout frameLayout = s.this.cp.get();
                    if (frameLayout != null) {
                        com.byazt.mj.l.n(view);
                        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
                    }
                    s.this.k = true;
                }
            }
        };

        public s() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.kt.n tv() {
            return (com.byazt.kt.n) this.rv;
        }

        public void n(final Context context) {
            com.byazt.yn.n nVarN = n.this.n(context);
            if (nVarN == null) {
                return;
            }
            com.byazt.zq.qg.n nVarN2 = com.byazt.mt.qg.n(n.this.qg, n.this.s, n.this.q, n.this.l, n.this.w, n.this.rv, false);
            float fOa = n.this.qg.oa();
            nVarN2.n(fOa).qg(n.this.qg.sz());
            nVarN.s(nVarN2.n(), new com.byazt.ap.w(null) { // from class: com.byazt.zf.n.s.1
                @Override // com.byazt.ap.w
                public void n(int i, String str) {
                    n.this.n(new com.byazt.mj.n(i, str));
                }

                @Override // com.byazt.ap.w
                public void n(List<sz> list) {
                    Map<String, Object> mapFs;
                    if (list == null || list.size() == 0 || context == null) {
                        n.this.n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                        return;
                    }
                    s.this.tj = list.get(0);
                    if (context instanceof Activity) {
                        s.this.tj.n((Activity) context, new com.byazt.lr.n(null) { // from class: com.byazt.zf.n.s.1.1
                            @Override // com.byazt.lr.n
                            public void n() {
                            }

                            @Override // com.byazt.lr.n
                            public void qg() {
                            }

                            @Override // com.byazt.lr.n
                            public void n(int i, String str, boolean z) {
                                if (s.this.sz) {
                                    return;
                                }
                                s.this.sz = true;
                                if (s.this.rv instanceof com.byazt.kt.n) {
                                    com.byazt.mv.n.n(n.this.fs);
                                    s.this.tv().n();
                                }
                            }
                        });
                    }
                    s.this.x(true);
                    s sVar = s.this;
                    sVar.d(sVar.tj.s());
                    s sVar2 = s.this;
                    sVar2.cp(sVar2.tj.qg());
                    if (n.this.x && (mapFs = s.this.tj.fs()) != null) {
                        double dN = com.byazt.mt.qg.n(mapFs.get(e.a.h));
                        com.byazt.rb.qg.n("TTMediationSDK_ECMP", com.byazt.rb.q.qg(n.this.fs, n.this.s) + "pangle banner 返回的 cpm价格：" + dN);
                        s sVar3 = s.this;
                        if (dN <= 0.0d) {
                            dN = 0.0d;
                        }
                        sVar3.n(dN);
                    }
                    s.this.tj.n(s.this.hd);
                    s.this.cp = new SoftReference<>(new FrameLayout(context));
                    s.this.tj.q();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(s.this);
                    n.this.n(arrayList);
                }
            });
        }

        @Override // com.byazt.sg.s
        public Map<String, Object> bb() {
            Map<String, Object> mapFs;
            sz szVar = this.tj;
            if (szVar == null || (mapFs = szVar.fs()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapFs.get("coupon"));
            map.put("live_room", mapFs.get("live_room"));
            map.put("product", mapFs.get("product"));
            s(map);
            return super.bb();
        }

        @Override // com.byazt.sg.s
        public long dz() {
            sz szVar = this.tj;
            if (szVar != null) {
                return com.byazt.mt.qg.n(szVar.fs());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public long c() {
            sz szVar = this.tj;
            if (szVar != null) {
                return com.byazt.mt.qg.qg(szVar.fs());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public String di() {
            sz szVar = this.tj;
            return szVar != null ? com.byazt.mt.qg.s(szVar.fs()) : "";
        }

        @Override // com.byazt.sg.s
        public synchronized View rv() {
            SoftReference<FrameLayout> softReference = this.cp;
            if (softReference == null) {
                return null;
            }
            FrameLayout frameLayout = softReference.get();
            synchronized (this.d) {
                if (frameLayout == null) {
                    try {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        long j = 2000 + jUptimeMillis;
                        while (!this.k && jUptimeMillis < j) {
                            this.d.wait(j - jUptimeMillis);
                            jUptimeMillis = SystemClock.uptimeMillis();
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            }
            return frameLayout;
        }

        @Override // com.byazt.sg.s
        public void cd() {
            this.cy = true;
            com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.zf.n.s.2
                @Override // java.lang.Runnable
                public void run() {
                    if (s.this.tj != null) {
                        s.this.tj.n((com.byazt.fx.n) null);
                        s.this.tj.l();
                    }
                }
            });
        }

        @Override // com.byazt.sg.s
        public boolean l() {
            return this.cy;
        }

        @Override // com.byazt.sg.s
        public void n(Activity activity, final com.byazt.lr.n nVar) {
            if (this.tj != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner : activity = " + activity + " pluginDislikeInteractionCallback:" + nVar);
                this.tj.n(activity, new com.byazt.lr.n(null) { // from class: com.byazt.zf.n.s.3
                    @Override // com.byazt.lr.n
                    public void n() {
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.n();
                        }
                    }

                    @Override // com.byazt.lr.n
                    public void n(int i, String str, boolean z) {
                        if (s.this.sz) {
                            return;
                        }
                        s.this.sz = true;
                        com.byazt.mv.n.n(n.this.fs);
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.n(i, str, z);
                        }
                    }

                    @Override // com.byazt.lr.n
                    public void qg() {
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.qg();
                        }
                    }
                });
            }
        }

        @Override // com.byazt.sg.s
        public void n(Dialog dialog, Integer[] numArr) {
            if (this.tj != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.tj.n(dialog, numArr);
            }
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.x n(Activity activity) {
            if (this.tj == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.tj.n(activity);
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.q qd() {
            if (this.tj == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner : getDislikeInfo");
            return this.tj.w();
        }

        @Override // com.byazt.sg.s
        public void f(String str) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner : uploadDislikeEvent event = ".concat(String.valueOf(str)));
            sz szVar = this.tj;
            if (szVar != null) {
                szVar.n(str);
            }
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.mi.qg qgVar) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner : setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(qgVar)));
            sz szVar = this.tj;
            if (szVar != null) {
                szVar.n(qgVar);
            }
        }

        @Override // com.byazt.sg.s
        public void wm(int i) {
            if (this.tj != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle banner : setSlideIntervalTime  intervalTime = ".concat(String.valueOf(i)));
                this.tj.n(i);
            }
        }
    }
}
