package com.bytedance.sdk.openadsdk.core.ugeno.ab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.h;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hi;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.nw.u;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;
import com.tapsdk.tapad.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements hi, ah, d, x {
    protected com.bytedance.adsdk.ugeno.xr.ah<View> ab;
    protected ViewGroup ah;
    protected int ao;
    protected com.bytedance.sdk.openadsdk.core.ugeno.d.ms c;
    protected com.bytedance.sdk.openadsdk.core.zb.ka d;
    protected int h;
    private c i;
    protected lm ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.ugeno.c.ms f3387ms;
    protected List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> ny;
    protected int qv;
    protected String sl;
    protected InterfaceC0313ms t;
    protected JSONObject u;
    protected int ub;
    private FrameLayout w;
    protected com.bytedance.adsdk.ugeno.xr.ah<View> x;
    protected Context xr;
    protected xr y;
    private boolean yu;
    protected Map<String, Object> zb;
    private boolean b = true;
    private boolean re = true;
    protected AtomicInteger nw = new AtomicInteger(2);
    protected AtomicInteger ch = new AtomicInteger();
    protected Map<Integer, Boolean> hi = new HashMap();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0313ms {
        void ms();
    }

    public abstract List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> sl();

    public ms(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.zb.ka kaVar, lm lmVar, String str, int i) {
        this.xr = context;
        this.ah = viewGroup;
        this.d = kaVar;
        this.ka = lmVar;
        this.sl = str;
        this.f3387ms = lmVar.op();
        c cVar = new c(this.xr, this.d, lmVar, str, i);
        this.i = cVar;
        cVar.ms((d) this);
        this.i.ms((ah) this);
        if (this.ka.uc() != null) {
            this.i.ms((x) this);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.ugeno.d.ms msVar) {
        this.c = msVar;
    }

    public void xr(boolean z) {
        this.yu = z;
    }

    public void zb() {
        try {
            this.ny = sl();
            ka.ms(this.f3387ms, new ka.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms
                public void ms(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        ms.this.d.ms(-1, "template info load fail");
                        if (ms.this.c != null) {
                            ms.this.c.ms(-1);
                            return;
                        }
                        return;
                    }
                    ms msVar = ms.this;
                    msVar.ms(jSONObject, msVar.ny);
                }
            });
        } catch (Exception e) {
            this.d.ms(-3, e.getMessage());
            com.bytedance.sdk.openadsdk.core.ugeno.d.ms msVar = this.c;
            if (msVar != null) {
                msVar.ms(-3);
            }
        }
    }

    public boolean u() {
        com.bytedance.adsdk.ugeno.xr.ah<T> ahVarAh;
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVar = this.ab;
        return (ahVar == null || (ahVarAh = ahVar.ah("interactionWebView")) == 0 || ahVarAh.ny() == null || ahVarAh.ny().getVisibility() != 0) ? false : true;
    }

    protected void ms(JSONObject jSONObject, List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> list) {
        this.d.xr();
        this.i.ms((hi) this);
        this.i.ms(jSONObject, list, new ab() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(int i, String str) {
                if (ms.this.c != null) {
                    ms.this.c.ms(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
                ms.this.ab = ahVar;
                ms msVar = ms.this;
                msVar.x = msVar.i.ms();
                ms.this.ah.addView(ahVar.ny(), new FrameLayout.LayoutParams(ahVar.pc(), ahVar.jw()));
                if (ms.this.yu) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ul.ah(ms.this.xr, 200.0f), ul.ah(ms.this.xr, 200.0f));
                    layoutParams.gravity = 17;
                    ms.this.ah.addView(ms.this.h(), layoutParams);
                }
                if (ms.this.c != null) {
                    ms.this.c.ms(ahVar.ny());
                }
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(ms.this.ka, ms.this.sl, "ugeno_coin_eCommerce_page_show_success", (com.bytedance.sdk.openadsdk.c.ms.ms) null);
            }
        });
    }

    public void ms(xr xrVar) {
        this.y = xrVar;
        c cVar = this.i;
        if (cVar != null) {
            cVar.ms(xrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View h() {
        this.w = new FrameLayout(this.xr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f);
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setShape(0);
        this.w.setBackground(gradientDrawable);
        final GifView gifView = new GifView(this.xr);
        com.bytedance.sdk.openadsdk.x.xr.ms(com.bytedance.sdk.openadsdk.core.x.ah.ms("shop_page_guide_gif.gif")).ah(3).ms(Bitmap.Config.RGB_565).ms(new ao() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.3
            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(2)
            public void ms(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(1)
            public void ms(com.bytedance.sdk.component.c.hi hiVar) {
                Object objAh = hiVar.ah();
                try {
                    if (objAh instanceof byte[]) {
                        if (hiVar.x()) {
                            gifView.ms((byte[]) objAh, false);
                        } else {
                            gifView.setImageDrawable(h.ms((byte[]) objAh, 0));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
        int iAh = ul.ah(this.xr, 120.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iAh, iAh);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = ul.ah(this.xr, 10.0f);
        gifView.setLayoutParams(layoutParams);
        this.w.addView(gifView);
        TextView textView = new TextView(this.xr);
        textView.setText("需要浏览页面才能领取奖励");
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.SERIF, 1);
        textView.setTextColor(Color.parseColor("#ffffff"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = ul.ah(this.xr, 70.0f);
        textView.setLayoutParams(layoutParams2);
        this.w.addView(textView);
        this.w.setOnTouchListener(new com.bytedance.sdk.openadsdk.core.ugeno.ny.ah(this.xr, new com.bytedance.sdk.openadsdk.core.ugeno.ny.ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ny.ah.ms
            public void ms() {
                if ((ms.this.x instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c) && ms.this.x.ny() != null) {
                    ((RecyclerView) ms.this.x.ny()).xr(1);
                }
                ms msVar = ms.this;
                msVar.ms(msVar.x);
                ms.this.w.setVisibility(8);
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(ms.this.ka, "landingpage", "in_web_click", (com.bytedance.sdk.openadsdk.c.ms.ms) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ny.ah.ms
            public void xr() {
                ms.this.w.setVisibility(8);
            }
        }, 200));
        this.w.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.5
            @Override // java.lang.Runnable
            public void run() {
                ms.this.w.setVisibility(8);
            }
        }, a.f);
        return this.w;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms$6, reason: invalid class name */
    class AnonymousClass6 extends ny {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final /* synthetic */ com.bytedance.adsdk.ugeno.xr.ah f3393ms;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(String str, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
            super(str);
            this.f3393ms = ahVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.re.xr.ms(ms.this.ka, ms.this.u, new com.bytedance.sdk.openadsdk.core.qv.ah() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.6.1
                @Override // com.bytedance.sdk.openadsdk.core.qv.ah
                public void ms(boolean z, List<lm> list, boolean z2) {
                    if (list == null || list.size() <= 0) {
                        if (ms.this.nw.get() <= 0) {
                            if (ms.this.t != null) {
                                ms.this.t.ms();
                                return;
                            }
                            return;
                        } else {
                            ms.this.ms(AnonymousClass6.this.f3393ms);
                            ms.this.nw.decrementAndGet();
                            return;
                        }
                    }
                    ms.this.ao = list.size();
                    ms.this.h += list.size();
                    ms.this.qv = ms.this.ub();
                    lm lmVar = list.get(0);
                    if (lmVar != null) {
                        ms.this.u = lmVar.vt();
                    }
                    final List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> listMs = ms.this.ms(list);
                    nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass6.this.f3393ms == null || !(AnonymousClass6.this.f3393ms instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c)) {
                                return;
                            }
                            ((com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c) AnonymousClass6.this.f3393ms).xr(listMs);
                        }
                    });
                }
            }, ms.this.ka.rt());
        }
    }

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        com.bytedance.sdk.component.ch.ab.xr(new AnonymousClass6("shop_page", ahVar));
    }

    protected int ub() {
        int i;
        int i2 = this.ao;
        int i3 = this.ub;
        if (i2 < i3) {
            i = this.h - i2;
        } else {
            i = this.h - i3;
        }
        return Math.max(i, 0);
    }

    protected List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> ms(List<lm> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (lm lmVar : list) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah ahVar = new com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah();
            JSONObject jSONObjectRm = lmVar.rm();
            try {
                jSONObjectRm.put("voice_btn_position", t.ub(this.ka));
            } catch (JSONException unused) {
            }
            ahVar.ms(-2134548432);
            ahVar.ms(jSONObjectRm);
            arrayList.add(ahVar);
        }
        return arrayList;
    }

    protected void ms(final lm lmVar, final com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        if (TextUtils.equals(ahVar.of(), "mute")) {
            com.bytedance.adsdk.ugeno.xr.ms msVarG = ahVar.g();
            if (msVarG != null) {
                com.bytedance.adsdk.ugeno.xr.ah ahVarAh = msVarG.ah("video_" + lmVar.kz());
                if (ahVarAh instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) {
                    com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) ahVarAh;
                    if (xrVar.x()) {
                        xrVar.d(false);
                        if (ahVar instanceof com.bytedance.adsdk.ugeno.widget.image.xr) {
                            ((com.bytedance.adsdk.ugeno.widget.image.xr) ahVar).xr(com.bytedance.sdk.component.utils.t.ah(this.xr, "tt_unmute"));
                            return;
                        }
                        return;
                    }
                    xrVar.d(true);
                    if (ahVar instanceof com.bytedance.adsdk.ugeno.widget.image.xr) {
                        ((com.bytedance.adsdk.ugeno.widget.image.xr) ahVar).xr(com.bytedance.sdk.component.utils.t.ah(this.xr, "tt_mute"));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this.b) {
            if (!ch.c(this.ka)) {
                ms(this.ka, this.zb);
            }
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, this.sl, "ugeno_coin_eCommerce_click_content", (com.bytedance.sdk.openadsdk.c.ms.ms) null);
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, this.sl, "page_click", (com.bytedance.sdk.openadsdk.c.ms.ms) null);
            this.b = false;
        }
        ms(lmVar);
        if (this instanceof com.bytedance.sdk.openadsdk.core.ugeno.ny.d) {
            lmVar.ny(1);
            lm lmVar2 = this.ka;
            if (lmVar2 != null) {
                lmVar.ms(lmVar2.op());
            }
        }
        if (com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms(lmVar, true)) {
            com.bytedance.sdk.openadsdk.core.xr.ms.xr.d dVar = new com.bytedance.sdk.openadsdk.core.xr.ms.xr.d(lmVar, this.xr);
            dVar.ms(new com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.xr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.7
                @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.xr
                public void ms() {
                    nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (lmVar == null || lmVar.rn() == null) {
                                return;
                            }
                            op.ms(ms.this.xr, lmVar.rn().d(), 0);
                        }
                    });
                    ms.this.xr(lmVar, ahVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.xr
                public void ms(final String str, final boolean z) {
                    nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z && "has_applied".equals(str)) {
                                op.ms(ms.this.xr, "你已领券，快去直播间下单吧", 0);
                            } else {
                                op.ms(ms.this.xr, "领券失败", 0);
                            }
                        }
                    });
                    ms.this.xr(lmVar, ahVar);
                }
            });
            dVar.ms(new com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.8
                @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms
                public void ms() {
                }
            });
            return;
        }
        xr(lmVar, ahVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(lm lmVar, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        String strXr = f.xr(this.ka);
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(this.xr, lmVar, strXr, f.xr(strXr));
        Map<String, Object> mapKa = ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ka();
        mapKa.put("click_element_type", ahVar.of());
        Map<String, Object> map = this.zb;
        if (map != null) {
            mapKa.putAll(map);
        }
        final String strDf = lmVar.df();
        com.bytedance.sdk.openadsdk.core.hi.xr.d dVarXr = com.bytedance.sdk.openadsdk.core.hi.ka.xr(this.xr, lmVar, strXr, false);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms((com.bytedance.sdk.openadsdk.core.hi.xr.ah) dVarXr);
        msVar.ms(null, new com.bytedance.sdk.openadsdk.core.nw.hi());
        if (dVarXr != null) {
            dVarXr.ms(new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.9
                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms() {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void xr(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ah(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms(long j, String str, String str2) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms(String str, String str2) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 6, 100);
                }
            });
        }
        Object obj = this.xr;
        if (obj instanceof com.bytedance.sdk.openadsdk.core.x.xr) {
            ((com.bytedance.sdk.openadsdk.core.x.xr) obj).ms(2);
        }
    }

    private void ms(lm lmVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.ny.ms msVarLe;
        JSONObject jSONObjectXr;
        u uVarMs;
        if (lmVar == null || (msVarLe = lmVar.le()) == null || (jSONObjectXr = msVarLe.xr()) == null || (uVarMs = u.ms(jSONObjectXr)) == null) {
            return;
        }
        if (uVarMs.ah() == 0 || uVarMs.ah() == 5) {
            lmVar.ms(uVarMs);
        }
    }

    public void ms(JSONObject jSONObject) {
        lm lmVarMs;
        if (jSONObject == null || (lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(jSONObject)) == null) {
            return;
        }
        String strXr = f.xr(this.ka);
        HashMap map = new HashMap();
        map.put("is_slide", this.ch);
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarMs, strXr, map, (Double) null);
        com.bytedance.sdk.openadsdk.core.op.ms.ms().d();
        lm lmVar = this.ka;
        pc.ms(lmVar != null ? lmVar.ka() : 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.re && this.ch.get() == 0) {
                return;
            }
            jSONObject2.put("is_slide", this.ch);
            jSONObject2.put("timestamp", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVarMs, strXr, "is_slide", jSONObject2, (com.bytedance.sdk.openadsdk.c.ms.ms) null);
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    public void ms(Map<String, Object> map) {
        this.zb = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.x
    public void xr(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        lm lmVar = this.ka;
        if (lmVar == null || lmVar.uc() == null) {
            return;
        }
        ahVar.xr(0);
    }

    public void ao() {
        lm lmVar = this.ka;
        pc.xr(lmVar != null ? lmVar.ka() : 0);
    }

    public void ms(InterfaceC0313ms interfaceC0313ms) {
        this.t = interfaceC0313ms;
    }

    private void ms(lm lmVar, Map<String, Object> map) {
        if (lmVar == null) {
            return;
        }
        String strXr = f.xr(lmVar);
        int iX = ul.x(re.getContext());
        com.bytedance.sdk.openadsdk.core.zb.ah.ms("click", lmVar, new com.bytedance.sdk.openadsdk.core.nw.ch.ms().c(-1.0f).ka(-1.0f).d(-1.0f).ah(-1.0f).xr(-1L).ms(-1L).ah(-1).d(-1).ka(-1024).xr(com.bytedance.sdk.openadsdk.core.ch.ub().ah() ? 1 : 2).ms(iX).ms(ul.c(re.getContext())).xr(ul.ab(re.getContext())).ms(), strXr, true, map, -1, false);
    }
}
