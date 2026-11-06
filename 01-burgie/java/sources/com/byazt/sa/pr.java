package com.byazt.sa;

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
import com.byazt.ca.b;
import com.byazt.ca.g;
import com.byazt.hg.aj;
import com.byazt.hg.of;
import com.byazt.hg.vk;
import com.byazt.hr.RecyclerView;
import com.byazt.jt.GifView;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.qx.w;
import com.byazt.sd.a;
import com.byazt.sd.lb;
import com.byazt.wt.e;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.yb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 158, 37})
public abstract class pr implements w, hn, x, zo {
    public InterfaceC0182pr a;
    public List<com.byazt.um.hn> aj;
    public boolean b;
    public of c;
    public com.byazt.ik.hn<View> fw;
    public JSONObject g;
    public ViewGroup hn;
    public int ho;
    public Context hw;
    public String k;
    public int lb;
    public Map<String, Object> m;
    public int nt;
    public com.byazt.qk.pr pr;
    public hw qa;
    public uc rc;
    public com.byazt.ql.pr uc;
    public com.byazt.pj.x x;
    public int yb;
    public FrameLayout z;
    public com.byazt.ik.hn<View> zo;
    public boolean ny = true;
    public boolean fo = true;
    public AtomicInteger cz = new AtomicInteger(2);
    public AtomicInteger vk = new AtomicInteger();
    public Map<Integer, Boolean> w = new HashMap();

    /* JADX INFO: renamed from: com.byazt.sa.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0182pr {
        void pr();
    }

    public abstract List<com.byazt.um.hn> w();

    public pr(Context context, ViewGroup viewGroup, com.byazt.pj.x xVar, of ofVar, String str, int i) {
        this.hw = context;
        this.hn = viewGroup;
        this.x = xVar;
        this.c = ofVar;
        this.k = str;
        this.pr = ofVar.mw();
        uc ucVar = new uc(this.hw, this.x, ofVar, str, i);
        this.rc = ucVar;
        ucVar.pr((x) this);
        this.rc.pr((hn) this);
        if (this.c.iq() != null) {
            this.rc.pr((zo) this);
        }
    }

    public void pr(com.byazt.ql.pr prVar) {
        this.uc = prVar;
    }

    public void hw(boolean z) {
        this.b = z;
    }

    public void k() {
        try {
            this.aj = w();
            c.pr(this.pr, new c.pr() { // from class: com.byazt.sa.pr.1
                @Override // com.byazt.sa.c.pr
                public void pr(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        pr.this.x.pr(-1, "template info load fail");
                        if (pr.this.uc != null) {
                            pr.this.uc.pr(-1);
                            return;
                        }
                        return;
                    }
                    pr prVar = pr.this;
                    prVar.pr(jSONObject, prVar.aj);
                }
            });
        } catch (Exception e) {
            this.x.pr(-3, e.getMessage());
            com.byazt.ql.pr prVar = this.uc;
            if (prVar != null) {
                prVar.pr(-3);
            }
        }
    }

    public boolean m() {
        com.byazt.ik.hn<T> hnVarX;
        com.byazt.ik.hn<View> hnVar = this.fw;
        return (hnVar == null || (hnVarX = hnVar.x("interactionWebView")) == 0 || hnVarX.aj() == null || hnVarX.aj().getVisibility() != 0) ? false : true;
    }

    public void pr(JSONObject jSONObject, List<com.byazt.um.hn> list) {
        this.x.hw();
        this.rc.pr((w) this);
        this.rc.pr(jSONObject, list, new fw() { // from class: com.byazt.sa.pr.4
            @Override // com.byazt.sa.fw
            public void pr(int i, String str) {
                if (pr.this.uc != null) {
                    pr.this.uc.pr(i);
                }
            }

            @Override // com.byazt.sa.fw
            public void pr(com.byazt.ik.hn<View> hnVar) {
                pr.this.fw = hnVar;
                pr prVar = pr.this;
                prVar.zo = prVar.rc.pr();
                pr.this.hn.addView(hnVar.aj(), new FrameLayout.LayoutParams(hnVar.e(), hnVar.s()));
                if (pr.this.b) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(er.hn(pr.this.hw, 200.0f), er.hn(pr.this.hw, 200.0f));
                    layoutParams.gravity = 17;
                    pr.this.hn.addView(pr.this.nt(), layoutParams);
                }
                if (pr.this.uc != null) {
                    pr.this.uc.pr(hnVar.aj());
                }
                com.byazt.pj.pr.pr(pr.this.c, pr.this.k, "ugeno_coin_eCommerce_page_show_success", (com.byazt.ttf.pr) null);
            }
        });
    }

    public void pr(hw hwVar) {
        this.qa = hwVar;
        uc ucVar = this.rc;
        if (ucVar != null) {
            ucVar.pr(hwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View nt() {
        this.z = new FrameLayout(this.hw);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f);
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setShape(0);
        this.z.setBackground(gradientDrawable);
        final GifView gifView = new GifView(this.hw);
        com.byazt.ub.hw.pr(com.byazt.hb.hn.pr("shop_page_guide_gif.gif")).hn(3).pr(Bitmap.Config.RGB_565).pr(new rc() { // from class: com.byazt.sa.pr.5
            @Override // com.byazt.ld.rc
            public void pr(nt ntVar) {
                Object objHn = ntVar.hn();
                try {
                    if (objHn instanceof byte[]) {
                        if (ntVar.zo()) {
                            gifView.pr((byte[]) objHn, false);
                        } else {
                            gifView.setImageDrawable(yb.pr((byte[]) objHn, 0));
                        }
                    }
                } catch (Throwable th) {
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i, String str, Throwable th) {
            }
        });
        int iHn = er.hn(this.hw, 120.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iHn, iHn);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = er.hn(this.hw, 10.0f);
        gifView.setLayoutParams(layoutParams);
        this.z.addView(gifView);
        TextView textView = new TextView(this.hw);
        textView.setText("需要浏览页面才能领取奖励");
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.SERIF, 1);
        textView.setTextColor(Color.parseColor("#ffffff"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = er.hn(this.hw, 70.0f);
        textView.setLayoutParams(layoutParams2);
        this.z.addView(textView);
        this.z.setOnTouchListener(new com.byazt.ze.hn(this.hw, new com.byazt.ze.hn.pr() { // from class: com.byazt.sa.pr.6
            @Override // com.byazt.ze.hn.pr
            public void pr() {
                if ((pr.this.zo instanceof com.byazt.um.uc) && pr.this.zo.aj() != null) {
                    ((RecyclerView) pr.this.zo.aj()).hw(1);
                }
                pr prVar = pr.this;
                prVar.pr(prVar.zo);
                pr.this.z.setVisibility(8);
                com.byazt.pj.pr.pr(pr.this.c, "landingpage", "in_web_click", (com.byazt.ttf.pr) null);
            }

            @Override // com.byazt.ze.hn.pr
            public void hw() {
                pr.this.z.setVisibility(8);
            }
        }, 200));
        this.z.postDelayed(new Runnable() { // from class: com.byazt.sa.pr.7
            @Override // java.lang.Runnable
            public void run() {
                pr.this.z.setVisibility(8);
            }
        }, 3000L);
        return this.z;
    }

    /* JADX INFO: renamed from: com.byazt.sa.pr$8, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 158, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200})
    public class AnonymousClass8 extends com.byazt.xlm.fw {
        public final /* synthetic */ com.byazt.ik.hn pr;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(String str, com.byazt.ik.hn hnVar) {
            super(str);
            this.pr = hnVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.byazt.pk.hn.pr(pr.this.c, pr.this.g, new com.byazt.ap.x() { // from class: com.byazt.sa.pr.8.1
                @Override // com.byazt.ap.x
                public void pr(boolean z, List<of> list, boolean z2) {
                    if (list == null || list.size() <= 0) {
                        if (pr.this.cz.get() <= 0) {
                            if (pr.this.a != null) {
                                pr.this.a.pr();
                                return;
                            }
                            return;
                        } else {
                            pr.this.pr(AnonymousClass8.this.pr);
                            pr.this.cz.decrementAndGet();
                            return;
                        }
                    }
                    pr.this.nt = list.size();
                    pr.this.yb += list.size();
                    pr.this.lb = pr.this.g();
                    of ofVar = list.get(0);
                    if (ofVar != null) {
                        pr.this.g = ofVar.cg();
                    }
                    final List<com.byazt.um.hn> listPr = pr.this.pr(list);
                    lb.uc().post(new Runnable() { // from class: com.byazt.sa.pr.8.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass8.this.pr != null && (AnonymousClass8.this.pr instanceof com.byazt.um.uc)) {
                                ((com.byazt.um.uc) AnonymousClass8.this.pr).hw(listPr);
                            }
                        }
                    });
                }
            }, pr.this.c.p());
        }
    }

    public void pr(com.byazt.ik.hn hnVar) {
        com.byazt.xlm.c.hw(new AnonymousClass8("shop_page", hnVar));
    }

    public int g() {
        int i;
        int i2 = this.nt;
        int i3 = this.ho;
        if (i2 < i3) {
            i = this.yb - i2;
        } else {
            i = this.yb - i3;
        }
        return Math.max(i, 0);
    }

    public List<com.byazt.um.hn> pr(List<of> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (of ofVar : list) {
            com.byazt.um.hn hnVar = new com.byazt.um.hn();
            JSONObject jSONObject = ofVar.to();
            try {
                jSONObject.put("voice_btn_position", com.byazt.hg.lb.yb(this.c));
            } catch (JSONException e) {
            }
            hnVar.pr("shop_content".hashCode());
            hnVar.pr(jSONObject);
            arrayList.add(hnVar);
        }
        return arrayList;
    }

    public void pr(final of ofVar, final com.byazt.ik.hn hnVar) {
        if (TextUtils.equals(hnVar.ww(), "mute")) {
            com.byazt.ik.pr prVarY = hnVar.y();
            if (prVarY != null) {
                com.byazt.ik.hn hnVarX = prVarY.x("video_" + ofVar.jg());
                if (hnVarX instanceof com.byazt.hd.hw) {
                    com.byazt.hd.hw hwVar = (com.byazt.hd.hw) hnVarX;
                    if (hwVar.zo()) {
                        hwVar.x(false);
                        if (hnVar instanceof com.byazt.hl.hw) {
                            g.pr(this.hw, "tt_unmute", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.sa.pr.9
                                @Override // com.byazt.ezf.pr
                                public void pr(Bitmap bitmap) {
                                    ((com.byazt.hl.hw) hnVar).hw(new BitmapDrawable(pr.this.hw.getResources(), bitmap));
                                }
                            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                            return;
                        }
                        return;
                    }
                    hwVar.x(true);
                    if (hnVar instanceof com.byazt.hl.hw) {
                        g.pr(this.hw, "tt_mute", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.sa.pr.10
                            @Override // com.byazt.ezf.pr
                            public void pr(Bitmap bitmap) {
                                ((com.byazt.hl.hw) hnVar).hw(new BitmapDrawable(pr.this.hw.getResources(), bitmap));
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
        if (this.ny) {
            if (!com.byazt.ea.w.uc(this.c)) {
                pr(this.c, this.m);
            }
            com.byazt.pj.pr.pr(ofVar, this.k, "ugeno_coin_eCommerce_click_content", (com.byazt.ttf.pr) null);
            com.byazt.pj.pr.pr(ofVar, this.k, "page_click", (com.byazt.ttf.pr) null);
            this.ny = false;
        }
        hw(ofVar);
        if (this instanceof com.byazt.ze.x) {
            ofVar.vk(1);
            of ofVar2 = this.c;
            if (ofVar2 != null) {
                ofVar.pr(ofVar2.mw());
            }
        }
        if (com.byazt.md.hn.pr((com.byazt.af.w) ofVar, true)) {
            com.byazt.md.hn hnVar2 = new com.byazt.md.hn(ofVar, ofVar.qa(), this.hw, new HashMap());
            hnVar2.pr(new com.byazt.md.hn.hw() { // from class: com.byazt.sa.pr.11
                @Override // com.byazt.md.hn.hw
                public void pr() {
                    lb.uc().post(new Runnable() { // from class: com.byazt.sa.pr.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ofVar != null && ofVar.qa() != null) {
                                b.pr(pr.this.hw, ofVar.qa().x(), 0);
                            }
                        }
                    });
                    pr.this.hw(ofVar, hnVar);
                }

                @Override // com.byazt.md.hn.hw
                public void pr(final String str, final boolean z) {
                    lb.uc().post(new Runnable() { // from class: com.byazt.sa.pr.11.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z && "has_applied".equals(str)) {
                                b.pr(pr.this.hw, "你已领券，快去直播间下单吧", 0);
                            } else {
                                b.pr(pr.this.hw, "领券失败", 0);
                            }
                        }
                    });
                    pr.this.hw(ofVar, hnVar);
                }
            });
            hnVar2.pr(new com.byazt.md.hn.pr() { // from class: com.byazt.sa.pr.2
                @Override // com.byazt.md.hn.pr
                public void pr() {
                }
            });
            return;
        }
        hw(ofVar, hnVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(of ofVar, com.byazt.ik.hn hnVar) {
        String strHw = ls.hw(this.c);
        com.byazt.az.pr prVar = new com.byazt.az.pr(this.hw, ofVar, strHw, ls.x(strHw));
        Map<String, Object> mapC = ((com.byazt.yx.pr) prVar.pr(com.byazt.yx.pr.class)).c();
        mapC.put("click_element_type", hnVar.ww());
        Map<String, Object> map = this.m;
        if (map != null) {
            mapC.putAll(map);
        }
        final String strX = ofVar.x();
        com.byazt.nv.hn hnVarHw = com.byazt.jx.zo.hw(this.hw, ofVar, strHw);
        ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr(hnVarHw);
        prVar.pr(null, new vk());
        if (hnVarHw != null) {
            hnVarHw.pr(new com.byazt.nv.pr() { // from class: com.byazt.sa.pr.3
                @Override // com.byazt.nv.pr
                public void pr() {
                    com.byazt.dp.pr.pr(strX);
                }

                @Override // com.byazt.nv.pr
                public void pr(long j, long j2, String str, String str2) {
                    com.byazt.dp.pr.pr(strX, j, j2);
                }

                @Override // com.byazt.nv.pr
                public void hw(long j, long j2, String str, String str2) {
                    com.byazt.dp.pr.hw(strX, j, j2);
                }

                @Override // com.byazt.nv.pr
                public void hn(long j, long j2, String str, String str2) {
                    com.byazt.dp.pr.hn(strX, j, j2);
                }

                @Override // com.byazt.nv.pr
                public void pr(long j, String str, String str2) {
                    com.byazt.dp.pr.hw(strX);
                }

                @Override // com.byazt.nv.pr
                public void pr(String str, String str2) {
                    com.byazt.dp.pr.hn(strX);
                }
            });
        }
        Object obj = this.hw;
        if (obj instanceof com.byazt.hb.hw) {
            ((com.byazt.hb.hw) obj).pr(2);
        }
    }

    private void hw(of ofVar) {
        com.byazt.ze.pr prVarSv;
        JSONObject jSONObjectHw;
        com.byazt.hg.g gVarPr;
        if (ofVar == null || (prVarSv = ofVar.sv()) == null || (jSONObjectHw = prVarSv.hw()) == null || (gVarPr = com.byazt.hg.g.pr(jSONObjectHw)) == null) {
            return;
        }
        if (gVarPr.hn() == 0 || gVarPr.hn() == 5) {
            ofVar.pr(gVarPr);
        }
    }

    public void pr(JSONObject jSONObject) {
        of ofVarPr;
        if (jSONObject == null || (ofVarPr = com.byazt.sd.pr.pr(jSONObject)) == null) {
            return;
        }
        String strHw = ls.hw(this.c);
        HashMap map = new HashMap();
        map.put("is_slide", this.vk);
        com.byazt.pj.pr.pr(ofVarPr, strHw, map, (Double) null);
        com.byazt.na.pr.pr().x();
        of ofVar = this.c;
        e.pr(ofVar != null ? ofVar.nl() : 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.fo && this.vk.get() == 0) {
                return;
            }
            jSONObject2.put("is_slide", this.vk);
            jSONObject2.put("timestamp", System.currentTimeMillis());
            com.byazt.pj.pr.pr(ofVarPr, strHw, "is_slide", jSONObject2, (com.byazt.ttf.pr) null);
        } catch (JSONException e) {
        }
    }

    public void pr(Map<String, Object> map) {
        this.m = map;
    }

    @Override // com.byazt.sa.zo
    public void hw(com.byazt.ik.hn hnVar) {
        of ofVar = this.c;
        if (ofVar == null || ofVar.iq() == null) {
            return;
        }
        hnVar.hw(0);
    }

    public void ho() {
        of ofVar = this.c;
        e.hw(ofVar != null ? ofVar.nl() : 0);
    }

    public void pr(InterfaceC0182pr interfaceC0182pr) {
        this.a = interfaceC0182pr;
    }

    private void pr(of ofVar, Map<String, Object> map) {
        if (ofVar == null) {
            return;
        }
        String strHw = ls.hw(ofVar);
        int iA = ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).a();
        com.byazt.pj.pr.pr("click", ofVar, new aj.pr().uc(-1.0f).c(-1.0f).x(-1.0f).hn(-1.0f).hw(-1L).pr(-1L).x(-1).c(-1).uc(-1024).hn(com.byazt.sd.zo.nt().hw() ? 1 : 2).hw(iA).pr(er.fw(a.getContext())).hw(er.zo(a.getContext())).pr(com.byazt.ri.c.hw(ofVar)).pr(), strHw, true, map, -1, false, false);
    }
}
