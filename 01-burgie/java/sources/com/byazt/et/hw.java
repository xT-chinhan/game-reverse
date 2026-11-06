package com.byazt.et;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.ca.ho;
import com.byazt.ca.iu;
import com.byazt.hg.i;
import com.byazt.hg.of;
import com.byazt.mr.fw;
import com.byazt.mr.g;
import com.byazt.nz.x;
import com.byazt.qx.NativeExpressView;
import com.byazt.qx.b;
import com.byazt.qx.c;
import com.byazt.qx.uc;
import com.byazt.sd.EmptyView;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.vkw.qi;
import com.byazt.wt.e;
import com.byazt.wt.gz;
import com.byazt.zp.zo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 51, 13})
public class hw extends com.byazt.qx.hw implements qi.pr {
    public static final String TAG = "TTBannerExpressAd";
    public NativeExpressView b;
    public com.byazt.qx.pr c;
    public volatile View fo;
    public WeakReference<BannerExpressBackupView> fw;
    public com.byazt.rz.pr g;
    public of hn;
    public final Context hw;
    public boolean iu;
    public iu k;
    public int m;
    public pr pr;
    public uc rc;
    public com.byazt.nv.pr uc;
    public com.byazt.nv.hn vk;
    public com.byazt.pfl.hw w;
    public com.byazt.qe.hw x;
    public c z;
    public String ho = com.byazt.pfl.hw.AD_TAG_BANNER;
    public final Queue<Long> nt = new LinkedList();
    public Double yb = null;
    public boolean lb = false;
    public boolean qa = false;
    public AtomicBoolean a = new AtomicBoolean(false);
    public AtomicBoolean cz = new AtomicBoolean(false);
    public AtomicBoolean ny = new AtomicBoolean(false);

    public hw(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        this.iu = false;
        this.hw = context;
        this.hn = ofVar;
        this.x = hwVar;
        boolean z = true;
        com.byazt.qd.hw.pr(ofVar, hwVar, 1, vk());
        boolean zKx = a.hw().kx();
        if (!a.hw().hv() && !zKx) {
            z = false;
        }
        this.iu = z;
        pr(context, ofVar, hwVar);
        pr(this.pr.getCurView(), this.hn, false);
    }

    public void pr(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        if (context == null) {
            return;
        }
        this.pr = new pr(context, ofVar, hwVar);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public View pr() {
        x.pr().pr(this.hn).pr(1);
        com.byazt.ua.hw.pr(this.hn.pr());
        return this.pr;
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
        this.hn.ae().hw(this.ho);
        return new com.byazt.dw.pr(this.hn.ae());
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(com.byazt.qh.hw hwVar) {
        com.byazt.qx.pr prVarPr = com.byazt.qx.pr.pr(this, hwVar);
        this.c = prVarPr;
        this.pr.setExpressInteractionListener(prVarPr);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(com.byazt.qh.pr prVar) {
        com.byazt.qx.pr prVarPr = com.byazt.qx.pr.pr((g) this, prVar);
        this.c = prVarPr;
        this.pr.setExpressInteractionListener(prVarPr);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(com.byazt.rkl.hn hnVar) {
        this.uc = com.byazt.nv.pr.C0146pr.pr(hnVar);
        if (this.zo != null) {
            this.zo.pr(this.uc);
        }
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
        com.byazt.pfl.hw hwVar = this.w;
        if (hwVar != null) {
            hwVar.pr(this.pr);
        }
        this.pr.c();
        x.pr().pr(this.hn).pr(1);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void uc() {
        super.uc();
        zo.pr(new Runnable() { // from class: com.byazt.et.hw.1
            @Override // java.lang.Runnable
            public void run() {
                if (hw.this.pr != null) {
                    hw.this.pr.x();
                }
            }
        });
        iu iuVar = this.k;
        if (iuVar != null) {
            iuVar.removeCallbacksAndMessages(null);
            this.k = null;
        }
        of ofVar = this.hn;
        e.hw(ofVar != null ? ofVar.nl() : 0);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(Activity activity, final com.byazt.rz.pr prVar) {
        if (prVar == null || activity == null) {
            return;
        }
        com.byazt.rz.pr prVar2 = new com.byazt.rz.pr(null) { // from class: com.byazt.et.hw.2
            @Override // com.byazt.rz.pr
            public void pr() {
                prVar.pr();
            }

            @Override // com.byazt.rz.pr
            public void pr(int i, String str, boolean z) {
                com.byazt.qd.hw.hn(hw.this.vk(), 1);
                prVar.pr(i, str, z);
            }

            @Override // com.byazt.rz.pr
            public void hw() {
                prVar.hw();
            }
        };
        this.g = prVar2;
        hw(activity, prVar2);
    }

    @Override // com.byazt.mr.g
    public void pr(String str) {
        com.byazt.pj.pr.hw(this.hn, str);
    }

    @Override // com.byazt.qx.hw
    public void pr(Dialog dialog) {
        if (dialog == null) {
            ho.pr("dialog is null, please check");
            return;
        }
        pr prVar = this.pr;
        if (prVar != null && prVar.getCurView() != null) {
            this.pr.getCurView().setOuterDislike(dialog);
        }
    }

    @Override // com.byazt.qx.hw
    public of fw() {
        return this.hn;
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public fw pr(Activity activity) {
        if (this.w == null) {
            hw(activity, (com.byazt.rz.pr) null);
        }
        return this.w;
    }

    private void hw(Activity activity, com.byazt.rz.pr prVar) {
        if (this.w == null) {
            com.byazt.pfl.hw hwVar = new com.byazt.pfl.hw(activity, this.hn.ae(), this.ho, false, com.byazt.ub.hw.pr());
            this.w = hwVar;
            com.byazt.pw.hn.pr(activity, this.hn, hwVar);
        }
        com.byazt.pfl.hw hwVar2 = this.w;
        if (hwVar2 != null) {
            hwVar2.pr(this.pr);
        }
        this.w.pr(prVar);
        pr prVar2 = this.pr;
        if (prVar2 != null && prVar2.getCurView() != null) {
            this.pr.getCurView().setDislike(this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.hn.aj() == 4) {
            zo.pr(new com.byazt.xlm.fw("banner_express_register_download") { // from class: com.byazt.et.hw.3
                @Override // java.lang.Runnable
                public void run() {
                    if (hw.this.hn.aj() == 4) {
                        hw hwVar = hw.this;
                        hwVar.vk = com.byazt.jx.zo.pr(hwVar.hw, hw.this.hn, hw.this.ho);
                        hw.this.vk.hw();
                        if (hw.this.hw instanceof Activity) {
                            hw.this.vk.pr((Activity) hw.this.hw, false);
                        }
                        if (hw.this.rc != null) {
                            ((com.byazt.dl.pr) hw.this.rc.pr(com.byazt.dl.pr.class)).pr(hw.this.vk);
                        }
                        if (hw.this.z != null) {
                            ((com.byazt.dl.pr) hw.this.z.pr(com.byazt.dl.pr.class)).pr(hw.this.vk);
                        }
                        hw hwVar2 = hw.this;
                        hwVar2.pr(hwVar2.vk, hw.this.b);
                        hw.this.vk.pr();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ho() {
        iu iuVar;
        if (this.fo == null || !this.fo.isShown() || (iuVar = this.k) == null) {
            return;
        }
        iuVar.removeCallbacksAndMessages(null);
        this.k.sendEmptyMessageDelayed(112201, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt() {
        iu iuVar = this.k;
        if (iuVar != null) {
            iuVar.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(of ofVar) {
        if (this.pr.getNextView() != null && this.pr.hw()) {
            pr(this.pr.getNextView(), ofVar.ae());
            this.ny.set(false);
            pr(this.pr.getNextView(), ofVar, true);
        }
    }

    private void pr(NativeExpressView nativeExpressView, com.byazt.dw.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        if (this.g != null) {
            this.w.pr(hwVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.w);
            }
        }
        if (this.aj != null) {
            pr(hwVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.aj);
            }
        }
    }

    public void pr(final NativeExpressView nativeExpressView, final of ofVar, boolean z) {
        if (nativeExpressView == null || ofVar == null) {
            return;
        }
        this.b = nativeExpressView;
        of ofVar2 = this.hn;
        if (ofVar2 != null) {
            e.hw(ofVar2.nl());
        }
        this.hn = ofVar;
        nativeExpressView.setBackupListener(new com.byazt.mq.hn() { // from class: com.byazt.et.hw.4
            @Override // com.byazt.mq.hn
            public boolean pr(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).qa();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(viewGroup.getContext());
                    bannerExpressBackupView.pr(hw.this.hn, (NativeExpressView) viewGroup, hw.this.vk);
                    bannerExpressBackupView.setDislikeInner(hw.this.w);
                    bannerExpressBackupView.setDislikeOuter(hw.this.aj);
                    if (hw.this.hn != null) {
                        hw.this.pr(ofVar.ae());
                    }
                    hw.this.fw = new WeakReference<>(bannerExpressBackupView);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
        EmptyView emptyViewPr = pr(nativeExpressView);
        if (emptyViewPr == null) {
            int iOv = 1000;
            if (ofVar != null) {
                iOv = ofVar.ov();
            }
            EmptyView emptyView = new EmptyView(this.hw, nativeExpressView, iOv);
            emptyView.setAdType(1);
            emptyView.pr(this.hn, this.ho);
            nativeExpressView.addView(emptyView);
            emptyViewPr = emptyView;
        }
        this.fo = emptyViewPr;
        emptyViewPr.setCallback(new EmptyView.pr() { // from class: com.byazt.et.hw.5
            @Override // com.byazt.sd.EmptyView.pr
            public void pr(boolean z2) {
                String unused = hw.this.ho;
                if (hw.this.vk != null) {
                    if (z2) {
                        hw.this.vk.hw();
                    } else {
                        com.byazt.nv.hn unused2 = hw.this.vk;
                    }
                }
                if (z2) {
                    hw.this.ho();
                } else {
                    hw.this.nt();
                }
                hw.this.pr(z2, ofVar);
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr() {
                hw.this.g();
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void hw() {
                if (hw.this.vk != null) {
                    hw.this.vk.hn();
                }
                hw.this.hw(ofVar);
                hw.this.a.set(false);
                hw.this.cz.set(false);
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr(View view, Map<String, Object> map) {
                if (hw.this.nt != null) {
                    hw.this.nt.offer(Long.valueOf(SystemClock.elapsedRealtime()));
                }
                Map mapPr = hw.this.pr(nativeExpressView, ofVar);
                if (map != null && map.containsKey("show_send_type")) {
                    mapPr.put("show_send_type", map.get("show_send_type"));
                }
                mapPr.put("is_repeat", Boolean.valueOf(hw.this.ny.get()));
                hw.this.a.set(true);
                if (!hw.this.cz.get()) {
                    hw.this.cz.set(true);
                    com.byazt.pj.pr.pr(ofVar, hw.this.ho, (Map<String, Object>) mapPr, hw.this.yb);
                    com.byazt.na.pr.pr().x();
                    of ofVar3 = ofVar;
                    e.pr(ofVar3 != null ? ofVar3.nl() : 0);
                }
                boolean zMo = a.hw().mo();
                boolean andSet = hw.this.ny.getAndSet(true);
                if (hw.this.c != null && (!andSet || zMo)) {
                    hw.this.c.hw(view, ofVar.aj());
                    if (ofVar.b() && ofVar.g() != null) {
                        com.byazt.yq.pr.pr().pr(hw.this.hw, ofVar.g().hw());
                    }
                }
                if (!andSet) {
                    if (view == null) {
                        view = nativeExpressView;
                    }
                    com.byazt.ua.hw.pr(ofVar, hw.this.ho, view, ofVar.ji());
                }
                hw.this.ho();
                if (hw.this.pr != null && hw.this.pr.getCurView() != null) {
                    hw.this.pr.getCurView().yb();
                    hw.this.pr.getCurView().ho();
                }
            }
        });
        uc ucVar = new uc(this.hw, ofVar, this.ho, 2);
        this.rc = ucVar;
        final com.byazt.yx.hn hnVar = (com.byazt.yx.hn) ucVar.pr(com.byazt.yx.hn.class);
        final EmptyView emptyView2 = emptyViewPr;
        hnVar.pr(new com.byazt.yx.hn.pr() { // from class: com.byazt.et.hw.6
            @Override // com.byazt.yx.hn.pr
            public boolean pr() {
                hnVar.pr(emptyView2);
                hnVar.pr(hw.this.pr(nativeExpressView, ofVar));
                hnVar.pr(hw.this.ho);
                hnVar.pr(hw.this.yb);
                return hw.this.a.get();
            }
        });
        this.rc.pr(nativeExpressView);
        ((com.byazt.dl.pr) this.rc.pr(com.byazt.dl.pr.class)).pr(this);
        nativeExpressView.setClickListener(this.rc);
        c cVar = new c(this.hw, ofVar, this.ho, 2);
        this.z = cVar;
        final com.byazt.yx.hn hnVar2 = (com.byazt.yx.hn) cVar.pr(com.byazt.yx.hn.class);
        hnVar2.pr(new com.byazt.yx.hn.pr() { // from class: com.byazt.et.hw.7
            @Override // com.byazt.yx.hn.pr
            public boolean pr() {
                hnVar2.pr(emptyView2);
                hnVar2.pr(hw.this.pr(nativeExpressView, ofVar));
                hnVar2.pr(hw.this.ho);
                hnVar2.pr(hw.this.yb);
                return hw.this.a.get();
            }
        });
        this.z.pr(nativeExpressView);
        ((com.byazt.dl.pr) this.z.pr(com.byazt.dl.pr.class)).pr(this);
        nativeExpressView.setClickCreativeListener(this.z);
        if (!this.iu) {
            emptyViewPr.setNeedCheckingShow(true);
        }
        if (z) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> pr(NativeExpressView nativeExpressView, of ofVar) {
        HashMap map = new HashMap();
        b.pr(map, this.hn, nativeExpressView);
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
        this.zo = new com.byazt.qx.hw.pr(this.uc, strX);
        hnVar.pr(this.zo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(of ofVar) {
        Queue<Long> queue = this.nt;
        if (queue == null || queue.size() <= 0 || ofVar == null) {
            return;
        }
        try {
            long jLongValue = this.nt.poll().longValue();
            if (jLongValue > 0) {
                String string = new StringBuilder().append(SystemClock.elapsedRealtime() - jLongValue).toString();
                com.byazt.pj.hw hwVar = new com.byazt.pj.hw(this.hn, this.ho);
                hwVar.pr(1.0f);
                com.byazt.pj.pr.pr(string, ofVar, this.ho, 15, hwVar.hw());
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z, of ofVar) {
        Queue<Long> queue = this.nt;
        if (queue == null) {
            return;
        }
        try {
            if (z) {
                queue.offer(Long.valueOf(SystemClock.elapsedRealtime()));
                return;
            }
            if (queue.size() > 0) {
                String string = new StringBuilder().append(SystemClock.elapsedRealtime() - this.nt.poll().longValue()).toString();
                com.byazt.pj.hw hwVar = new com.byazt.pj.hw(this.hn, this.ho);
                hwVar.pr(1.0f);
                com.byazt.pj.pr.pr(string, ofVar, this.ho, 13, hwVar.hw());
            }
        } catch (Exception e) {
        }
    }

    private EmptyView pr(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            try {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            } catch (Throwable th) {
            }
        }
        return null;
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
    public void pr(int i) {
        if (i <= 0) {
            return;
        }
        this.ho = com.byazt.pfl.hw.AD_TAG_EXPRESS_BANNER;
        pr(this.pr.getCurView(), this.hn, false);
        this.pr.setDuration(1000);
        if (i < 30000) {
            i = 30000;
        } else if (i > 120000) {
            i = 120000;
        }
        this.m = i;
        this.k = new iu(Looper.getMainLooper(), this);
    }

    @Override // com.byazt.mr.g
    public void pr(JSONObject jSONObject) {
    }

    @Override // com.byazt.mr.g
    public void w() {
    }

    private void yb() {
        i iVar = new i();
        iVar.fw = 2;
        a.pr().pr(this.x, iVar, 1, new com.byazt.cv.pr(new fo.hw() { // from class: com.byazt.et.hw.8
            @Override // com.byazt.sd.fo.hw
            public void pr(int i, String str, com.byazt.hg.hw hwVar) {
                hw.this.ho();
            }

            @Override // com.byazt.sd.fo.hw
            public void pr(com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(prVar.hw());
                if (copyOnWriteArrayList.isEmpty()) {
                    hw.this.ho();
                    return;
                }
                of ofVar = (of) copyOnWriteArrayList.get(0);
                hw.this.pr.pr(ofVar, hw.this.x);
                hw.this.pr(ofVar);
                hw.this.pr.hn();
            }
        }));
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        if (message.what != 112201 || this.fo == null || !this.fo.isShown()) {
            return;
        }
        yb();
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.zo
    public void pr(Double d) {
        if (this.lb) {
            return;
        }
        gz.pr(this.hn, d);
        this.lb = true;
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.zo
    public void pr(Double d, String str, String str2) {
        if (this.qa) {
            return;
        }
        gz.pr(this.hn, d, str, str2);
        this.qa = true;
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.zo
    public void hw(Double d) {
        this.yb = d;
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.qd.hw.hn(vk(), 3);
    }
}
