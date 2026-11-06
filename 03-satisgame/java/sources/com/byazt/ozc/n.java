package com.byazt.ozc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.ep.cp;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.gct.rv;
import com.byazt.gct.tj;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.prf.RecyclerView;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.stl.GifView;
import com.byazt.tk.h;
import com.byazt.tk.sz;
import com.byazt.vf.oa;
import com.byazt.za.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 19})
public abstract class n implements d, fs, q, s {
    public InterfaceC0290n a;
    public int cd;
    public int cy;
    public String d;
    public com.byazt.ih.s<View> fs;
    public boolean h;
    public int hd;
    public FrameLayout hu;
    public int k;
    public pk l;
    public w m;
    public com.byazt.ai.n n;
    public Map<String, Object> oa;
    public com.byazt.hm.q q;
    public Context qg;
    public List<com.byazt.mu.s> rv;
    public ViewGroup s;
    public JSONObject sz;
    public qg um;
    public com.byazt.au.n w;
    public com.byazt.ih.s<View> x;
    public boolean ou = true;
    public boolean wm = true;
    public AtomicInteger py = new AtomicInteger(2);
    public AtomicInteger tj = new AtomicInteger();
    public Map<Integer, Boolean> cp = new HashMap();

    /* JADX INFO: renamed from: com.byazt.ozc.n$n, reason: collision with other inner class name */
    public interface InterfaceC0290n {
        void n();
    }

    public abstract List<com.byazt.mu.s> cp();

    public n(Context context, ViewGroup viewGroup, com.byazt.hm.q qVar, pk pkVar, String str, int i) {
        this.qg = context;
        this.s = viewGroup;
        this.q = qVar;
        this.l = pkVar;
        this.d = str;
        this.n = pkVar.vb();
        w wVar = new w(this.qg, this.q, pkVar, str, i);
        this.m = wVar;
        wVar.n((q) this);
        this.m.n((s) this);
        if (this.l.it() != null) {
            this.m.n((fs) this);
        }
    }

    public void n(com.byazt.au.n nVar) {
        this.w = nVar;
    }

    public void qg(boolean z) {
        this.h = z;
    }

    public void d() {
        try {
            this.rv = cp();
            l.n(this.n, new l.n() { // from class: com.byazt.ozc.n.1
                @Override // com.byazt.ozc.l.n
                public void n(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        n.this.q.n(-1, "template info load fail");
                        if (n.this.w != null) {
                            n.this.w.n(-1);
                            return;
                        }
                        return;
                    }
                    n nVar = n.this;
                    nVar.n(jSONObject, nVar.rv);
                }
            });
        } catch (Exception e) {
            this.q.n(-3, e.getMessage());
            com.byazt.au.n nVar = this.w;
            if (nVar != null) {
                nVar.n(-3);
            }
        }
    }

    public boolean oa() {
        com.byazt.ih.s<T> sVarQ;
        com.byazt.ih.s<View> sVar = this.x;
        return (sVar == null || (sVarQ = sVar.q("interactionWebView")) == 0 || sVarQ.rv() == null || sVarQ.rv().getVisibility() != 0) ? false : true;
    }

    public void n(JSONObject jSONObject, List<com.byazt.mu.s> list) {
        this.q.qg();
        this.m.n((d) this);
        this.m.n(jSONObject, list, new x() { // from class: com.byazt.ozc.n.4
            @Override // com.byazt.ozc.x
            public void n(int i, String str) {
                if (n.this.w != null) {
                    n.this.w.n(i);
                }
            }

            @Override // com.byazt.ozc.x
            public void n(com.byazt.ih.s<View> sVar) {
                n.this.x = sVar;
                n nVar = n.this;
                nVar.fs = nVar.m.n();
                n.this.s.addView(sVar.rv(), new FrameLayout.LayoutParams(sVar.an(), sVar.ae()));
                if (n.this.h) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.byazt.okk.s.s(n.this.qg, 200.0f), com.byazt.okk.s.s(n.this.qg, 200.0f));
                    layoutParams.gravity = 17;
                    n.this.s.addView(n.this.cy(), layoutParams);
                }
                if (n.this.w != null) {
                    n.this.w.n(sVar.rv());
                }
                com.byazt.hm.n.n(n.this.l, n.this.d, "ugeno_coin_eCommerce_page_show_success", (com.byazt.rs.n) null);
            }
        });
    }

    public void n(qg qgVar) {
        this.um = qgVar;
        w wVar = this.m;
        if (wVar != null) {
            wVar.n(qgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View cy() {
        this.hu = new FrameLayout(this.qg);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f);
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setShape(0);
        this.hu.setBackground(gradientDrawable);
        final GifView gifView = new GifView(this.qg);
        com.byazt.imu.s.n(com.byazt.iu.n.n("shop_page_guide_gif.gif")).s(3).n(Bitmap.Config.RGB_565).n(new m() { // from class: com.byazt.ozc.n.5
            @Override // com.byazt.si.m
            public void n(int i, String str, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(cy cyVar) {
                Object objS = cyVar.s();
                try {
                    if (objS instanceof byte[]) {
                        if (cyVar.fs()) {
                            gifView.n((byte[]) objS, false);
                        } else {
                            gifView.setImageDrawable(com.byazt.imu.n.n((byte[]) objS, 0));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
        int iS = com.byazt.okk.s.s(this.qg, 120.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iS, iS);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = com.byazt.okk.s.s(this.qg, 10.0f);
        gifView.setLayoutParams(layoutParams);
        this.hu.addView(gifView);
        TextView textView = new TextView(this.qg);
        textView.setText("需要浏览页面才能领取奖励");
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.SERIF, 1);
        textView.setTextColor(Color.parseColor("#ffffff"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = com.byazt.okk.s.s(this.qg, 70.0f);
        textView.setLayoutParams(layoutParams2);
        this.hu.addView(textView);
        this.hu.setOnTouchListener(new com.byazt.ul.s(this.qg, new com.byazt.ul.s.n() { // from class: com.byazt.ozc.n.6
            @Override // com.byazt.ul.s.n
            public void n() {
                if ((n.this.fs instanceof com.byazt.mu.w) && n.this.fs.rv() != null) {
                    ((RecyclerView) n.this.fs.rv()).qg(1);
                }
                n nVar = n.this;
                nVar.n(nVar.fs);
                n.this.hu.setVisibility(8);
                com.byazt.hm.n.n(n.this.l, "landingpage", "in_web_click", (com.byazt.rs.n) null);
            }

            @Override // com.byazt.ul.s.n
            public void qg() {
                n.this.hu.setVisibility(8);
            }
        }, 200));
        this.hu.postDelayed(new Runnable() { // from class: com.byazt.ozc.n.7
            @Override // java.lang.Runnable
            public void run() {
                n.this.hu.setVisibility(8);
            }
        }, 3000L);
        return this.hu;
    }

    /* JADX INFO: renamed from: com.byazt.ozc.n$8, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 71})
    public class AnonymousClass8 extends com.byazt.qit.x {
        public final /* synthetic */ com.byazt.ih.s n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(String str, com.byazt.ih.s sVar) {
            super(str);
            this.n = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.byazt.jc.q.n(n.this.l, n.this.sz, new com.byazt.uv.q() { // from class: com.byazt.ozc.n.8.1
                @Override // com.byazt.uv.q
                public void n(boolean z, List<pk> list, boolean z2) {
                    if (list == null || list.size() <= 0) {
                        if (n.this.py.get() <= 0) {
                            if (n.this.a != null) {
                                n.this.a.n();
                                return;
                            }
                            return;
                        } else {
                            n.this.n(AnonymousClass8.this.n);
                            n.this.py.decrementAndGet();
                            return;
                        }
                    }
                    n.this.cy = list.size();
                    n.this.hd += list.size();
                    n.this.cd = n.this.sz();
                    pk pkVar = list.get(0);
                    if (pkVar != null) {
                        n.this.sz = pkVar.vh();
                    }
                    final List<com.byazt.mu.s> listN = n.this.n(list);
                    com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.ozc.n.8.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass8.this.n == null || !(AnonymousClass8.this.n instanceof com.byazt.mu.w)) {
                                return;
                            }
                            ((com.byazt.mu.w) AnonymousClass8.this.n).qg(listN);
                        }
                    });
                }
            }, n.this.l.xd());
        }
    }

    public void n(com.byazt.ih.s sVar) {
        com.byazt.qit.l.qg(new AnonymousClass8("shop_page", sVar));
    }

    public int sz() {
        int i;
        int i2 = this.cy;
        int i3 = this.k;
        if (i2 < i3) {
            i = this.hd - i2;
        } else {
            i = this.hd - i3;
        }
        return Math.max(i, 0);
    }

    public List<com.byazt.mu.s> n(List<pk> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (pk pkVar : list) {
            com.byazt.mu.s sVar = new com.byazt.mu.s();
            JSONObject jSONObjectPv = pkVar.pv();
            try {
                jSONObjectPv.put("voice_btn_position", cd.hd(this.l));
            } catch (JSONException unused) {
            }
            sVar.n(-2134548432);
            sVar.n(jSONObjectPv);
            arrayList.add(sVar);
        }
        return arrayList;
    }

    public void n(final pk pkVar, final com.byazt.ih.s sVar) {
        if (TextUtils.equals(sVar.v(), "mute")) {
            com.byazt.ih.n nVarLh = sVar.lh();
            if (nVarLh != null) {
                com.byazt.ih.s sVarQ = nVarLh.q("video_" + pkVar.ge());
                if (sVarQ instanceof com.byazt.kx.qg) {
                    com.byazt.kx.qg qgVar = (com.byazt.kx.qg) sVarQ;
                    if (qgVar.fs()) {
                        qgVar.q(false);
                        if (sVar instanceof com.byazt.jm.s) {
                            sz.n(this.qg, "tt_unmute", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.ozc.n.9
                                @Override // com.byazt.qyj.n
                                public void n(Bitmap bitmap) {
                                    ((com.byazt.jm.s) sVar).qg(new BitmapDrawable(n.this.qg.getResources(), bitmap));
                                }
                            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                            return;
                        }
                        return;
                    }
                    qgVar.q(true);
                    if (sVar instanceof com.byazt.jm.s) {
                        sz.n(this.qg, "tt_mute", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.ozc.n.10
                            @Override // com.byazt.qyj.n
                            public void n(Bitmap bitmap) {
                                ((com.byazt.jm.s) sVar).qg(new BitmapDrawable(n.this.qg.getResources(), bitmap));
                            }
                        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this.ou) {
            if (!cp.w(this.l)) {
                n(this.l, this.oa);
            }
            com.byazt.hm.n.n(pkVar, this.d, "ugeno_coin_eCommerce_click_content", (com.byazt.rs.n) null);
            com.byazt.hm.n.n(pkVar, this.d, "page_click", (com.byazt.rs.n) null);
            this.ou = false;
        }
        qg(pkVar);
        if (this instanceof com.byazt.ul.q) {
            pkVar.tj(1);
            pk pkVar2 = this.l;
            if (pkVar2 != null) {
                pkVar.n(pkVar2.vb());
            }
        }
        if (com.byazt.soz.s.n((com.byazt.llp.cp) pkVar, true)) {
            com.byazt.soz.s sVar2 = new com.byazt.soz.s(pkVar, pkVar.um(), this.qg, new HashMap());
            sVar2.n(new com.byazt.soz.s.qg() { // from class: com.byazt.ozc.n.11
                @Override // com.byazt.soz.s.qg
                public void n() {
                    com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.ozc.n.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (pkVar == null || pkVar.um() == null) {
                                return;
                            }
                            h.n(n.this.qg, pkVar.um().q(), 0);
                        }
                    });
                    n.this.qg(pkVar, sVar);
                }

                @Override // com.byazt.soz.s.qg
                public void n(final String str, final boolean z) {
                    com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.ozc.n.11.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z && "has_applied".equals(str)) {
                                h.n(n.this.qg, "你已领券，快去直播间下单吧", 0);
                            } else {
                                h.n(n.this.qg, "领券失败", 0);
                            }
                        }
                    });
                    n.this.qg(pkVar, sVar);
                }
            });
            sVar2.n(new com.byazt.soz.s.n() { // from class: com.byazt.ozc.n.2
                @Override // com.byazt.soz.s.n
                public void n() {
                }
            });
            return;
        }
        qg(pkVar, sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(pk pkVar, com.byazt.ih.s sVar) {
        String strQg = com.byazt.vgx.w.qg(this.l);
        com.byazt.ys.n nVar = new com.byazt.ys.n(this.qg, pkVar, strQg, com.byazt.vgx.w.q(strQg));
        Map<String, Object> mapL = ((com.byazt.fq.n) nVar.n(com.byazt.fq.n.class)).l();
        mapL.put("click_element_type", sVar.v());
        Map<String, Object> map = this.oa;
        if (map != null) {
            mapL.putAll(map);
        }
        final String strQ = pkVar.q();
        ITTInnerDownloadAdapter iTTInnerDownloadAdapterQg = com.byazt.iz.fs.qg(this.qg, pkVar, strQg);
        ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n(iTTInnerDownloadAdapterQg);
        nVar.n(null, new tj());
        if (iTTInnerDownloadAdapterQg != null) {
            iTTInnerDownloadAdapterQg.addAppDownloadListener(new AppDownloadListener() { // from class: com.byazt.ozc.n.3
                @Override // com.byazt.pmn.AppDownloadListener
                public void onIdle() {
                    com.byazt.ll.n.n(strQ);
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadActive(long j, long j2, String str, String str2) {
                    com.byazt.ll.n.n(strQ, j, j2);
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadPaused(long j, long j2, String str, String str2) {
                    com.byazt.ll.n.qg(strQ, j, j2);
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadFailed(long j, long j2, String str, String str2) {
                    com.byazt.ll.n.s(strQ, j, j2);
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadFinished(long j, String str, String str2) {
                    com.byazt.ll.n.qg(strQ);
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onInstalled(String str, String str2) {
                    com.byazt.ll.n.s(strQ);
                }
            });
        }
        Object obj = this.qg;
        if (obj instanceof com.byazt.rv.n) {
            ((com.byazt.rv.n) obj).n(2);
        }
    }

    private void qg(pk pkVar) {
        com.byazt.ul.n nVarFl;
        JSONObject jSONObjectQg;
        com.byazt.gct.sz szVarN;
        if (pkVar == null || (nVarFl = pkVar.fl()) == null || (jSONObjectQg = nVarFl.qg()) == null || (szVarN = com.byazt.gct.sz.n(jSONObjectQg)) == null) {
            return;
        }
        if (szVarN.s() == 0 || szVarN.s() == 5) {
            pkVar.n(szVarN);
        }
    }

    public void n(JSONObject jSONObject) {
        pk pkVarN;
        if (jSONObject == null || (pkVarN = com.byazt.vgx.qg.n(jSONObject)) == null) {
            return;
        }
        String strQg = com.byazt.vgx.w.qg(this.l);
        HashMap map = new HashMap();
        map.put("is_slide", this.tj);
        com.byazt.hm.n.n(pkVarN, strQg, map, (Double) null);
        com.byazt.hnb.qg.n().q();
        pk pkVar = this.l;
        com.byazt.cd.s.n(pkVar != null ? pkVar.v() : 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.wm && this.tj.get() == 0) {
                return;
            }
            jSONObject2.put("is_slide", this.tj);
            jSONObject2.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, System.currentTimeMillis());
            com.byazt.hm.n.n(pkVarN, strQg, "is_slide", jSONObject2, (com.byazt.rs.n) null);
        } catch (JSONException unused) {
        }
    }

    public void n(Map<String, Object> map) {
        this.oa = map;
    }

    @Override // com.byazt.ozc.fs
    public void qg(com.byazt.ih.s sVar) {
        pk pkVar = this.l;
        if (pkVar == null || pkVar.it() == null) {
            return;
        }
        sVar.qg(0);
    }

    public void k() {
        pk pkVar = this.l;
        com.byazt.cd.s.qg(pkVar != null ? pkVar.v() : 0);
    }

    public void n(InterfaceC0290n interfaceC0290n) {
        this.a = interfaceC0290n;
    }

    private void n(pk pkVar, Map<String, Object> map) {
        if (pkVar == null) {
            return;
        }
        String strQg = com.byazt.vgx.w.qg(pkVar);
        int iA = ((oa) com.byazt.qp.q.n("device_info_new")).a();
        com.byazt.hm.n.n("click", pkVar, new rv.n().w(-1.0f).l(-1.0f).q(-1.0f).s(-1.0f).qg(-1L).n(-1L).q(-1).l(-1).w(-1024).s(com.byazt.vyf.s.cy().qg() ? 1 : 2).qg(iA).n(com.byazt.okk.s.x(com.byazt.nf.rv.getContext())).qg(com.byazt.okk.s.fs(com.byazt.nf.rv.getContext())).n(com.byazt.oh.l.qg(pkVar)).n(), strQg, true, map, -1, false, false);
    }
}
