package com.byazt.qx;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.hg.bh;
import com.byazt.hg.of;
import com.byazt.sd.EmptyView;
import com.byazt.sd.ww;
import com.byazt.wt.e;
import com.byazt.wt.gz;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS})
public class fo extends hw {
    public static final String TAG = "TTNativeExpressAd";
    public final com.byazt.pj.hw b;
    public WeakReference<m> c;
    public final FrameLayout cz;
    public com.byazt.nv.pr fw;
    public of hn;
    public final Context hw;
    public int iu;
    public uc lb;
    public final com.byazt.uq.c ny;
    public NativeExpressView pr;
    public c qa;
    public EmptyView rc;
    public pr uc;
    public com.byazt.pfl.hw vk;
    public com.byazt.nv.hn w;
    public boolean z;
    public String x = com.byazt.pfl.hw.AD_TAG_FEED;
    public Double k = null;
    public boolean m = false;
    public boolean g = false;
    public AtomicBoolean ho = new AtomicBoolean(false);
    public AtomicBoolean nt = new AtomicBoolean(false);
    public AtomicBoolean yb = new AtomicBoolean(false);
    public volatile boolean a = false;
    public final ViewGroup fo = new FrameLayout(com.byazt.sd.a.getContext());
    public final pr ve = new pr() { // from class: com.byazt.qx.fo.1
        @Override // com.byazt.qx.pr
        public void pr(View view, int i) {
            if (fo.this.uc != null) {
                fo.this.uc.pr(fo.this.fo, i);
            }
        }

        @Override // com.byazt.qx.pr
        public void hw(View view, int i) {
            boolean zMo = com.byazt.sd.a.hw().mo();
            if (fo.this.uc != null && (!fo.this.yb.getAndSet(true) || zMo)) {
                fo.this.uc.hw(fo.this.fo, i);
                com.byazt.hg.yb ybVarG = fo.this.hn.g();
                if (fo.this.hn.b() && ybVarG != null) {
                    com.byazt.yq.pr.pr().pr(fo.this.hw, ybVarG.hw());
                }
            }
            if (fo.this.ny != null && fo.this.ny.pr() != null) {
                fo.this.ny.pr().x();
            }
        }

        @Override // com.byazt.qx.pr
        public void pr(View view, String str, int i) {
            if (fo.this.uc != null) {
                fo.this.uc.pr(fo.this.fo, str, i);
            }
        }

        @Override // com.byazt.qx.pr
        public void pr(View view, float f, float f2) {
            if (fo.this.pr != null && fo.this.ny != null) {
                fo.this.pr.setEasyPlayableSender(fo.this.ny.pr());
                fo.this.ny.pr(fo.this.pr.getEasyPlayableLayout(), fo.this.pr.getVideoContainer());
            }
            fo.this.fo.removeAllViews();
            fo.this.fo.addView(view);
            fo.this.fo.addView(fo.this.cz, new FrameLayout.LayoutParams((int) f, (int) f2));
            if (fo.this.uc != null) {
                fo.this.uc.pr(fo.this.fo, f, f2);
            }
        }
    };

    public fo(Context context, final of ofVar, com.byazt.qe.hw hwVar, int i) {
        this.z = false;
        this.iu = 5;
        this.iu = i;
        this.hw = context;
        this.hn = ofVar;
        this.z = com.byazt.sd.a.hw().hv() || com.byazt.sd.a.hw().kx();
        com.byazt.qd.hw.pr(ofVar, hwVar, i, vk());
        pr(context, ofVar, hwVar);
        this.cz = new FrameLayout(context);
        this.b = new com.byazt.pj.hw(this.hn, this.x);
        this.ny = new com.byazt.uq.c(ofVar, new com.byazt.uq.pr() { // from class: com.byazt.qx.fo.2
            @Override // com.byazt.qx.w
            public void pr(int i2) {
                if (fo.this.pr != null) {
                    fo.this.pr.pr(i2);
                }
            }

            @Override // com.byazt.qx.w
            public long pr() {
                if (fo.this.pr != null) {
                    return fo.this.pr.pr();
                }
                return 0L;
            }

            @Override // com.byazt.qx.w
            public int hw() {
                if (fo.this.pr != null) {
                    return fo.this.pr.hw();
                }
                return 0;
            }

            @Override // com.byazt.qx.w
            public int hn() {
                if (fo.this.pr != null) {
                    return fo.this.pr.hn();
                }
                return 0;
            }

            @Override // com.byazt.qx.w
            public void x() {
                if (fo.this.pr != null) {
                    fo.this.pr.x();
                }
            }

            @Override // com.byazt.qx.w
            public void hw(int i2) {
                if (fo.this.pr != null) {
                    fo.this.pr.hw(i2);
                }
            }

            @Override // com.byazt.qx.w
            public void c() {
                if (fo.this.pr != null) {
                    fo.this.pr.c();
                }
            }

            @Override // com.byazt.qx.w
            public void pr(int i2, String str) {
                if (fo.this.pr != null) {
                    fo.this.pr.pr(i2, str);
                }
            }

            @Override // com.byazt.qx.w
            public void setPauseFromExpressView(boolean z) {
                if (fo.this.pr != null) {
                    fo.this.pr.setPauseFromExpressView(z);
                }
            }

            @Override // com.byazt.qx.w
            public void pr(float f) {
                if (fo.this.pr != null) {
                    fo.this.pr.pr(f);
                }
            }

            @Override // com.byazt.qx.w
            public void pr(int i2, int i3) {
                if (fo.this.pr != null) {
                    fo.this.pr.pr(i2, i3);
                }
            }

            @Override // com.byazt.uq.pr
            public void pr(View view) {
                fo.this.ve.pr(view, ofVar.aj());
                of ofVar2 = ofVar;
                com.byazt.uq.hn.hw(ofVar2, com.byazt.hg.b.zo(ofVar2), true, null);
            }

            @Override // com.byazt.uq.pr
            public void pr(View view, int i2, com.byazt.dj.hn hnVar, bh bhVar) {
                boolean zOptBoolean;
                if (fo.this.pr != null) {
                    fo.this.pr.pr(view, i2, hnVar, -1);
                }
                if (!(hnVar instanceof com.byazt.hg.fo)) {
                    zOptBoolean = false;
                } else {
                    zOptBoolean = ((com.byazt.hg.fo) hnVar).pr().optBoolean("isLottieInternalClick", false);
                }
                com.byazt.uq.hn.pr(ofVar, (com.byazt.hg.m) bhVar, false, (JSONObject) null, zOptBoolean);
            }

            @Override // com.byazt.uq.pr
            public void pr(View view, int i2, com.byazt.dj.hn hnVar, int i3) {
                if (fo.this.pr != null) {
                    fo.this.pr.pr(view, i2, hnVar, i3);
                }
            }

            @Override // com.byazt.uq.pr
            public void pr(ViewGroup viewGroup) {
            }

            @Override // com.byazt.qx.w
            public void hn(int i2) {
            }

            @Override // com.byazt.qx.w
            public void pr(of ofVar2) {
            }
        });
    }

    public void pr(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, ofVar, hwVar, this.x);
        this.pr = nativeExpressView;
        this.fo.addView(nativeExpressView);
        pr(this.pr, this.hn);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public View pr() {
        com.byazt.nz.x.pr().pr(this.hn);
        com.byazt.ua.hw.pr(this.hn.pr());
        return this.fo;
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public int hw() {
        of ofVar = this.hn;
        if (ofVar == null) {
            return -1;
        }
        return ofVar.jg();
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public com.byazt.mr.x hn() {
        of ofVar = this.hn;
        if (ofVar == null || ofVar.ae() == null) {
            return null;
        }
        this.hn.ae().hw(this.x);
        return new com.byazt.dw.pr(this.hn.ae());
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(com.byazt.qh.hw hwVar) {
        this.uc = pr.pr(this, hwVar);
        this.pr.setExpressInteractionListener(this.ve);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(com.byazt.qh.pr prVar) {
        this.uc = pr.pr((com.byazt.mr.g) this, prVar);
        this.pr.setExpressInteractionListener(this.ve);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(com.byazt.rkl.hn hnVar) {
        this.fw = com.byazt.nv.pr.C0146pr.pr(hnVar);
        if (this.zo != null) {
            this.zo.pr(this.fw);
        }
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public Map<String, Object> zo() {
        of ofVar = this.hn;
        if (ofVar != null) {
            return ofVar.zc();
        }
        return null;
    }

    @Override // com.byazt.mr.g
    public com.byazt.wd.x aj() {
        return new com.byazt.vd.hn();
    }

    @Override // com.byazt.mr.g
    public String vk() {
        of ofVar = this.hn;
        if (ofVar != null) {
            return ofVar.z();
        }
        return null;
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public int x() {
        of ofVar = this.hn;
        if (ofVar == null) {
            return -1;
        }
        return ofVar.aj();
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void c() {
        com.byazt.pfl.hw hwVar = this.vk;
        if (hwVar != null) {
            hwVar.pr(this.pr);
        }
        this.pr.nt();
        com.byazt.nz.x.pr().pr(this.hn);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void uc() {
        super.uc();
        com.byazt.qd.hw.hn(vk(), 2);
        NativeExpressView nativeExpressView = this.pr;
        if (nativeExpressView != null) {
            nativeExpressView.k();
        }
        this.b.pr(ww.hw(this.pr), 16);
        com.byazt.nv.hn hnVar = this.w;
        if (hnVar != null) {
            hnVar.hn();
        }
        com.byazt.uq.c cVar = this.ny;
        if (cVar != null) {
            cVar.hw();
        }
        of ofVar = this.hn;
        e.hw(ofVar != null ? ofVar.nl() : 0);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(Activity activity, final com.byazt.rz.pr prVar) {
        if (prVar == null || activity == null) {
            return;
        }
        hw(activity, new com.byazt.rz.pr(null) { // from class: com.byazt.qx.fo.3
            @Override // com.byazt.rz.pr
            public void pr() {
                prVar.pr();
            }

            @Override // com.byazt.rz.pr
            public void pr(int i, String str, boolean z) {
                com.byazt.qd.hw.hn(fo.this.vk(), 1);
                prVar.pr(i, str, z);
            }

            @Override // com.byazt.rz.pr
            public void hw() {
                prVar.hw();
            }
        });
    }

    @Override // com.byazt.mr.g
    public void pr(String str) {
        com.byazt.pj.pr.hw(this.hn, str);
    }

    @Override // com.byazt.qx.hw
    public void pr(Dialog dialog) {
        if (dialog == null) {
            com.byazt.ca.ho.pr("dialog is null, please check");
            return;
        }
        NativeExpressView nativeExpressView = this.pr;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(dialog);
        }
    }

    @Override // com.byazt.qx.hw
    public of fw() {
        return this.hn;
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public com.byazt.mr.fw pr(Activity activity) {
        if (this.vk == null) {
            hw(activity, null);
        }
        return this.vk;
    }

    @Override // com.byazt.mr.g
    public void pr(JSONObject jSONObject) {
        NativeExpressView nativeExpressView = this.pr;
        if (nativeExpressView != null) {
            nativeExpressView.pr(jSONObject);
        }
    }

    @Override // com.byazt.mr.g
    public void w() {
        NativeExpressView nativeExpressView = this.pr;
        if (nativeExpressView != null) {
            nativeExpressView.ny();
        }
    }

    private void hw(Activity activity, com.byazt.rz.pr prVar) {
        if (this.vk == null) {
            com.byazt.pfl.hw hwVar = new com.byazt.pfl.hw(activity, this.hn.ae(), this.x, false, com.byazt.ub.hw.pr());
            this.vk = hwVar;
            com.byazt.pw.hn.pr(activity, this.hn, hwVar);
        }
        com.byazt.pfl.hw hwVar2 = this.vk;
        if (hwVar2 != null) {
            hwVar2.pr(this.pr);
        }
        this.vk.pr(prVar);
        NativeExpressView nativeExpressView = this.pr;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.vk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.a) {
            if (this.w != null) {
                uc ucVar = this.lb;
                if (ucVar != null) {
                    ((com.byazt.dl.pr) ucVar.pr(com.byazt.dl.pr.class)).pr(this.w);
                }
                c cVar = this.qa;
                if (cVar != null) {
                    ((com.byazt.dl.pr) cVar.pr(com.byazt.dl.pr.class)).pr(this.w);
                }
                try {
                    pr(this.w, this.pr);
                    this.w.pr();
                    this.w.pr(this.zo);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        this.a = true;
        if (this.hn.aj() == 4) {
            com.byazt.zp.zo.pr(new com.byazt.xlm.fw("native_register_download") { // from class: com.byazt.qx.fo.4
                @Override // java.lang.Runnable
                public void run() {
                    fo foVar = fo.this;
                    foVar.w = com.byazt.jx.zo.pr(foVar.hw, fo.this.hn, fo.this.x);
                    if (fo.this.lb != null) {
                        ((com.byazt.dl.pr) fo.this.lb.pr(com.byazt.dl.pr.class)).pr(fo.this.w);
                    }
                    if (fo.this.qa != null) {
                        ((com.byazt.dl.pr) fo.this.qa.pr(com.byazt.dl.pr.class)).pr(fo.this.w);
                    }
                    if (fo.this.hw instanceof Activity) {
                        fo.this.w.pr((Activity) fo.this.hw, false);
                    }
                    fo foVar2 = fo.this;
                    foVar2.pr(foVar2.w, fo.this.pr);
                    fo.this.w.pr();
                    fo.this.w.pr(fo.this.zo);
                }
            });
        }
    }

    public void pr(final NativeExpressView nativeExpressView, final of ofVar) {
        this.hn = ofVar;
        nativeExpressView.setBackupListener(new com.byazt.mq.hn() { // from class: com.byazt.qx.fo.5
            @Override // com.byazt.mq.hn
            public boolean pr(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).qa();
                    m mVar = new m(viewGroup.getContext());
                    com.byazt.it.pr.pr(Integer.valueOf(ofVar.hashCode()), fo.this);
                    mVar.pr(fo.this.hn, (NativeExpressView) viewGroup, fo.this.w);
                    mVar.setDislikeInner(fo.this.vk);
                    mVar.setDislikeOuter(fo.this.aj);
                    if (fo.this.hn != null) {
                        fo foVar = fo.this;
                        foVar.pr(foVar.hn.ae());
                    }
                    fo.this.c = new WeakReference<>(mVar);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
        EmptyView emptyViewPr = pr(nativeExpressView);
        this.rc = emptyViewPr;
        if (emptyViewPr == null) {
            int iOv = 1000;
            if (ofVar != null) {
                iOv = ofVar.ov();
            }
            EmptyView emptyView = new EmptyView(this.hw, nativeExpressView, iOv);
            this.rc = emptyView;
            emptyView.setAdType(this.iu);
            this.rc.pr(this.hn, this.x);
            nativeExpressView.addView(this.rc);
        }
        this.rc.setCallback(new EmptyView.pr() { // from class: com.byazt.qx.fo.6
            @Override // com.byazt.sd.EmptyView.pr
            public void pr(boolean z) {
                Activity activity;
                WeakReference<Activity> weakReferencePr;
                Activity activity2;
                if (fo.this.w != null) {
                    if (z) {
                        fo.this.w.hw();
                    } else {
                        com.byazt.nv.hn unused = fo.this.w;
                    }
                }
                fo.this.b.pr(ww.hw(nativeExpressView), z ? 12 : 13);
                if (ls.x(fo.this.hn)) {
                    if (z) {
                        if (ls.x(fo.this.hn) && (weakReferencePr = com.byazt.sd.zo.nt().hn().pr()) != null && (activity2 = weakReferencePr.get()) != null) {
                            com.byazt.rd.hn.pr().pr(activity2.getWindow(), fo.this.hn, ls.b(fo.this.hn));
                            return;
                        }
                        return;
                    }
                    WeakReference<Activity> weakReferencePr2 = com.byazt.sd.zo.nt().hn().pr();
                    if (weakReferencePr2 != null && (activity = weakReferencePr2.get()) != null) {
                        com.byazt.rd.hn.pr().hw((Context) activity, fo.this.hn, true);
                    }
                }
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr() {
                WeakReference<Activity> weakReferencePr;
                Activity activity;
                fo.this.g();
                fo.this.b.pr(ww.hw(nativeExpressView), 14);
                if (ls.x(fo.this.hn) && (weakReferencePr = com.byazt.sd.zo.nt().hn().pr()) != null && (activity = weakReferencePr.get()) != null) {
                    com.byazt.rd.hn.pr().pr(activity.getWindow(), fo.this.hn, ls.b(fo.this.hn));
                }
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void hw() {
                WeakReference<Activity> weakReferencePr;
                Activity activity;
                if (fo.this.w != null) {
                    fo.this.w.hn();
                }
                fo.this.b.pr(ww.hw(nativeExpressView), 15);
                fo.this.ho.set(false);
                fo.this.nt.set(false);
                if (ls.x(fo.this.hn) && (weakReferencePr = com.byazt.sd.zo.nt().hn().pr()) != null && (activity = weakReferencePr.get()) != null) {
                    com.byazt.rd.hn.pr().hw(activity.getWindow(), fo.this.hn, true);
                }
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr(View view, Map<String, Object> map) {
                fo.this.g();
                fo.this.b.pr(ww.hw(view), 11);
                Map mapHo = fo.this.ho();
                mapHo.put("is_repeat", Boolean.valueOf(fo.this.yb.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapHo.put("show_send_type", map.get("show_send_type"));
                }
                mapHo.put("is_repeat", Boolean.valueOf(fo.this.yb.get()));
                fo.this.ho.set(true);
                if (!fo.this.nt.get()) {
                    fo.this.nt.set(true);
                    com.byazt.pj.pr.pr(ofVar, fo.this.x, (Map<String, Object>) mapHo, fo.this.k);
                    com.byazt.na.pr.pr().x();
                    of ofVar2 = ofVar;
                    e.pr(ofVar2 != null ? ofVar2.nl() : 0);
                }
                boolean z = (fo.this.uc == null || fo.this.yb.get()) ? false : true;
                fo.this.ve.hw(view, ofVar.aj());
                if (z) {
                    if (view == null) {
                        view = fo.this.fo;
                    }
                    of ofVar3 = ofVar;
                    String str = fo.this.x;
                    of ofVar4 = ofVar;
                    com.byazt.ua.hw.pr(ofVar3, str, view, ofVar4 != null && ofVar4.ji());
                }
                if (fo.this.pr != null) {
                    fo.this.pr.yb();
                    fo.this.pr.ho();
                }
            }
        });
        Context context = this.hw;
        String str = this.x;
        uc ucVar = new uc(context, ofVar, str, ls.x(str));
        this.lb = ucVar;
        pr((com.byazt.yx.hn) ucVar.pr(com.byazt.yx.hn.class));
        this.lb.pr(nativeExpressView);
        ((com.byazt.dl.pr) this.lb.pr(com.byazt.dl.pr.class)).pr(this);
        this.pr.setClickListener(this.lb);
        Context context2 = this.hw;
        String str2 = this.x;
        c cVar = new c(context2, ofVar, str2, ls.x(str2));
        this.qa = cVar;
        pr((com.byazt.yx.hn) cVar.pr(com.byazt.yx.hn.class));
        this.qa.pr(nativeExpressView);
        ((com.byazt.dl.pr) this.qa.pr(com.byazt.dl.pr.class)).pr(this);
        this.pr.setClickCreativeListener(this.qa);
        if (!this.z) {
            this.rc.setNeedCheckingShow(true);
        }
    }

    public void pr(final com.byazt.yx.hn hnVar) {
        hnVar.pr(new com.byazt.yx.hn.pr() { // from class: com.byazt.qx.fo.7
            @Override // com.byazt.yx.hn.pr
            public boolean pr() {
                hnVar.pr(fo.this.rc);
                hnVar.pr(fo.this.ho());
                hnVar.pr(fo.this.x);
                hnVar.pr(fo.this.k);
                return fo.this.ho.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> ho() {
        HashMap map = new HashMap();
        b.pr(map, this.hn, this.pr);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.nv.hn hnVar, NativeExpressView nativeExpressView) {
        String strX;
        if (hnVar == null || nativeExpressView == null) {
            return;
        }
        of ofVar = this.hn;
        if (ofVar == null) {
            strX = "";
        } else {
            strX = ofVar.x();
        }
        this.zo = new hw.pr(this.fw, strX);
        hnVar.pr(this.zo);
    }

    private EmptyView pr(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.zo
    public void pr(Double d) {
        if (this.m) {
            return;
        }
        gz.pr(this.hn, d);
        this.m = true;
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.zo
    public void pr(Double d, String str, String str2) {
        if (this.g) {
            return;
        }
        gz.pr(this.hn, d, str, str2);
        this.g = true;
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.zo
    public void hw(Double d) {
        this.k = d;
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.qd.hw.hn(vk(), 3);
    }
}
