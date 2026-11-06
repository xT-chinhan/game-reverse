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
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 547, 8})
public class s {
    public void n(final boolean z, com.byazt.yn.n nVar, com.byazt.zq.qg qgVar, final com.byazt.ua.qg qgVar2) {
        if (nVar == null || qgVar2 == null) {
            return;
        }
        nVar.n(qgVar, new com.byazt.ap.qg(null) { // from class: com.byazt.zf.s.1
            @Override // com.byazt.ap.qg
            public void n(int i, String str) {
                qgVar2.n(new com.byazt.mj.n(i, str));
            }

            @Override // com.byazt.ap.qg
            public void n(List<com.byazt.fvm.rv> list) {
                if (list == null || list.isEmpty()) {
                    qgVar2.n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.byazt.fvm.rv> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new n(it.next(), z));
                }
                qgVar2.n(arrayList);
            }
        });
    }

    @com.byazt.cp.n(n = {0, 1, 547, 546})
    private static class n extends com.byazt.sg.s {
        public com.byazt.fvm.rv d;
        public int oa;
        public com.byazt.dc.n tj = new com.byazt.dc.n(0 == true ? 1 : 0) { // from class: com.byazt.zf.s.n.3
            @Override // com.byazt.dc.n
            public void n(View view, oa oaVar) {
                if (n.this.fs != null) {
                    n.this.fs.n(view);
                }
            }

            @Override // com.byazt.dc.n
            public void qg(View view, oa oaVar) {
                if (n.this.fs != null) {
                    n.this.fs.n(view);
                }
            }

            @Override // com.byazt.dc.n
            public void n(oa oaVar) {
                if (n.this.fs != null) {
                    n.this.fs.n();
                }
            }
        };
        public com.byazt.wn.n cp = new com.byazt.wn.n(0 == true ? 1 : 0) { // from class: com.byazt.zf.s.n.4
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

        @Override // com.byazt.sg.s
        public boolean a() {
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public n(com.byazt.fvm.rv rvVar, boolean z) {
            Map<String, Object> mapOu;
            this.d = rvVar;
            com.byazt.fvm.s sVarUm = rvVar.um();
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
            v(rvVar.x());
            j(rvVar.fs());
            ln(rvVar.rv());
            ur(rvVar.sz() != null ? rvVar.sz().s() : null);
            cp(rvVar.hd());
            d(rvVar.cy());
            an(rvVar.oa());
            q(rvVar.tj());
            fs(rvVar.cy() == 4);
            x(false);
            if (rvVar.hd() == 16 || rvVar.hd() == 3 || rvVar.hd() == 2 || rvVar.hd() == 131) {
                if (rvVar.k() != null && !rvVar.k().isEmpty() && rvVar.k().get(0) != null) {
                    com.byazt.fvm.d dVar = rvVar.k().get(0);
                    bb(dVar.s());
                    um(dVar.n());
                    cd(dVar.qg());
                }
            } else if (rvVar.hd() == 4) {
                if (rvVar.k() != null && rvVar.k().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.byazt.fvm.d> it = rvVar.k().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().s());
                    }
                    n((List<String>) arrayList);
                }
            } else {
                com.byazt.fvm.d dVarL = rvVar.l();
                if (dVarL == null && rvVar.k() != null && !rvVar.k().isEmpty() && rvVar.k().get(0) != null) {
                    dVarL = rvVar.k().get(0);
                }
                if (dVarL != null) {
                    bb(dVarL.s());
                    um(dVarL.n());
                    cd(dVarL.qg());
                }
            }
            if (z && (mapOu = rvVar.ou()) != null) {
                double dN = com.byazt.mt.qg.n(mapOu.get(e.a.h));
                com.byazt.rb.qg.n("TTMediationSDK_ECMP", "pangle draw 返回的 cpm价格：".concat(String.valueOf(dN)));
                n(dN <= 0.0d ? 0.0d : dN);
            }
            this.d.n(this.cp);
            n(MediationConstant.EXTRA_ADID, Long.valueOf(c()));
            n("c_id", Long.valueOf(dz()));
            n(MediationConstant.EXTRA_DURATION, Double.valueOf(this.d.n()));
            Map<String, Object> mapOu2 = this.d.ou();
            if (mapOu2 != null) {
                q(mapOu2);
                n("log_extra", mapOu2.toString());
            }
        }

        @Override // com.byazt.sg.s
        public Map<String, Object> bb() {
            Map<String, Object> mapOu;
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar == null || (mapOu = rvVar.ou()) == null) {
                return null;
            }
            s(mapOu);
            return super.bb();
        }

        @Override // com.byazt.sg.s
        public void n(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.n(viewGroup, list, list2, list3, list4, view);
            qg(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.byazt.sg.s
        public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.fz.d dVar, List<View> list4) {
            FrameLayout frameLayout;
            com.byazt.fvm.rv rvVar;
            View viewPy;
            com.byazt.fvm.rv rvVar2;
            View viewFindViewById;
            super.n(activity, viewGroup, list, list2, list3, dVar, list4);
            qg(viewGroup, null, list, list2, list3, null);
            com.byazt.fvm.rv rvVar3 = this.d;
            if (rvVar3 != null && rvVar3.w() != null && dVar != null && (viewFindViewById = viewGroup.findViewById(dVar.d)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.d.w());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.byazt.rb.w.qg(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.byazt.rb.w.qg(viewGroup.getContext(), 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.d.w());
                }
            }
            if ((an() && (rvVar2 = this.d) != null && rvVar2.qg() != null && !TextUtils.isEmpty(this.d.qg().n())) || dVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(dVar.x)) == null || (rvVar = this.d) == null || (viewPy = rvVar.py()) == null) {
                return;
            }
            qg(viewPy);
            frameLayout.removeAllViews();
            frameLayout.addView(viewPy, -1, -1);
        }

        private void qg(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                try {
                    rvVar.n(new com.byazt.wn.qg(null) { // from class: com.byazt.zf.s.n.1
                        @Override // com.byazt.wn.qg
                        public void n(int i) {
                            if (n.this.x != null) {
                                n.this.x.n(i);
                            }
                        }
                    });
                } catch (Throwable unused) {
                }
                this.d.n(viewGroup, list, list2, list3, list4, view, this.tj);
            }
        }

        @Override // com.byazt.sg.s
        public int wf() {
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                return rvVar.s();
            }
            return 0;
        }

        @Override // com.byazt.sg.s
        public int lr() {
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                return rvVar.q();
            }
            return 0;
        }

        @Override // com.byazt.sg.s
        public String x() {
            com.byazt.fvm.rv rvVar;
            if (!an() || (rvVar = this.d) == null || rvVar.qg() == null) {
                return null;
            }
            return this.d.qg().n();
        }

        @Override // com.byazt.sg.s
        public com.byazt.fz.l fs() {
            if (an()) {
                return new com.byazt.fz.l() { // from class: com.byazt.zf.s.n.2
                    @Override // com.byazt.fz.l
                    public void n(long j) {
                        if (n.this.d == null || n.this.d.qg() == null) {
                            return;
                        }
                        n.this.d.qg().n(j);
                    }

                    @Override // com.byazt.fz.l
                    public void qg(long j) {
                        if (n.this.d == null || n.this.d.qg() == null) {
                            return;
                        }
                        n.this.d.qg().qg(j);
                    }

                    @Override // com.byazt.fz.l
                    public void n() {
                        if (n.this.d == null || n.this.d.qg() == null) {
                            return;
                        }
                        n.this.d.qg().s();
                    }

                    @Override // com.byazt.fz.l
                    public void s(long j) {
                        if (n.this.d == null || n.this.d.qg() == null) {
                            return;
                        }
                        n.this.d.qg().s(j);
                    }

                    @Override // com.byazt.fz.l
                    public void qg() {
                        if (n.this.d == null || n.this.d.qg() == null) {
                            return;
                        }
                        n.this.d.qg().q();
                    }

                    @Override // com.byazt.fz.l
                    public void n(int i, int i2) {
                        if (n.this.d == null || n.this.d.qg() == null) {
                            return;
                        }
                        n.this.d.qg().n(i, i2);
                    }

                    @Override // com.byazt.fz.l
                    public void n(long j, int i, int i2) {
                        if (n.this.d == null || n.this.d.qg() == null) {
                            return;
                        }
                        n.this.d.qg().n(j, i, i2);
                    }
                };
            }
            return null;
        }

        @Override // com.byazt.sg.s
        public void cd() {
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                rvVar.n((com.byazt.wn.n) null);
                this.d = null;
            }
        }

        @Override // com.byazt.sg.s
        public boolean l() {
            return this.d == null;
        }

        @Override // com.byazt.sg.s
        public String di() {
            com.byazt.fvm.rv rvVar = this.d;
            return rvVar != null ? com.byazt.mt.qg.s(rvVar.ou()) : "";
        }

        @Override // com.byazt.sg.s
        public void n() {
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar == null || rvVar.a() == null || this.oa != 2) {
                return;
            }
            this.d.a().n();
        }

        @Override // com.byazt.sg.s
        public void qg() {
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar == null || rvVar.a() == null || this.oa != 3) {
                return;
            }
            this.d.a().n();
        }

        @Override // com.byazt.sg.s
        public void s() {
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar == null || rvVar.a() == null) {
                return;
            }
            this.d.a().qg();
        }

        @Override // com.byazt.sg.s
        public int q() {
            return this.oa;
        }

        @Override // com.byazt.sg.s
        public long dz() {
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                return com.byazt.mt.qg.n(rvVar.ou());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public long c() {
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                return com.byazt.mt.qg.qg(rvVar.ou());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public void n(Activity activity, com.byazt.lr.n nVar) {
            if (this.d != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw :  activity = " + activity + " pluginDislikeInteractionCallback:" + nVar);
                this.d.n(activity, nVar);
            }
        }

        @Override // com.byazt.sg.s
        public void n(Dialog dialog, Integer[] numArr) {
            if (this.d != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.d.qg(dialog, numArr);
            }
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.x n(Activity activity) {
            if (this.d != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : getDislikeDialog = ".concat(String.valueOf(activity)));
                return this.d.n(activity);
            }
            return super.n(activity);
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.x qg(Dialog dialog, Integer[] numArr) {
            if (this.d == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.d.n(dialog, numArr);
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.q qd() {
            if (this.d == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : getDislikeInfo");
            return this.d.cd();
        }

        @Override // com.byazt.sg.s
        public void f(String str) {
            if (this.d != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.d.n(str);
            }
        }

        @Override // com.byazt.sg.s
        public View tj() {
            if (this.d == null) {
                return null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : getVideoView = " + this.d.py());
            return this.d.py();
        }

        @Override // com.byazt.sg.s
        public void tj(boolean z) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : setCanInterruptVideoPlay b = ".concat(String.valueOf(z)));
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                rvVar.n(z);
            }
        }

        @Override // com.byazt.sg.s
        public void n(Bitmap bitmap, int i) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : setPauseIcon bitmap = " + bitmap + " i = " + i);
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                rvVar.n(bitmap, i);
            }
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.vd.n nVar) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : setDrawVideoListener pluginDrawVideoListener = ".concat(String.valueOf(nVar)));
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                rvVar.n(nVar);
            }
        }

        @Override // com.byazt.sg.s
        public double on() {
            if (this.d != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : getVideoDuration = " + this.d.n());
                return this.d.n();
            }
            return super.on();
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.d es() {
            if (this.d != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : getVideoCoverImage = " + this.d.l());
                return this.d.l();
            }
            return super.es();
        }

        @Override // com.byazt.sg.s
        public Bitmap dx() {
            if (this.d != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : getAdLogo = " + this.d.w());
                return this.d.w();
            }
            return super.dx();
        }

        @Override // com.byazt.sg.s
        public int yp() {
            if (this.d != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : getAppCommentNum = " + this.d.cp());
                return this.d.cp();
            }
            return super.yp();
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.l ki() {
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                com.byazt.fvm.l lVarA = rvVar.a();
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : getDownloadStatusController = ".concat(String.valueOf(lVarA)));
                return lVarA;
            }
            return super.ki();
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.mi.s sVar) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(sVar)));
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                rvVar.n(sVar);
            }
        }

        @Override // com.byazt.sg.s
        public void qg(Activity activity) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle draw : setActivityForDownloadApp  activity = ".concat(String.valueOf(activity)));
            com.byazt.fvm.rv rvVar = this.d;
            if (rvVar != null) {
                rvVar.qg(activity);
            }
        }
    }
}
