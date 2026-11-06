package com.bytedance.sdk.openadsdk.core.ugeno.ny;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;
import com.bytedance.sdk.openadsdk.core.zb.ka;
import com.umeng.analytics.pro.cl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.sdk.openadsdk.core.ugeno.ab.ms implements le.ms {
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr b;
    private final Handler i;
    private AtomicBoolean le;
    private boolean op;
    private boolean re;
    private com.bytedance.sdk.openadsdk.core.qv.ah w;
    private long yu;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ab() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int ah() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ch() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void d() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void d(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void hi() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ka() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long ms() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(int i, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ny() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void x() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int xr() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void xr(int i) {
    }

    public xr(Context context, ViewGroup viewGroup, ka kaVar, lm lmVar, String str, int i) {
        super(context, viewGroup, kaVar, lmVar, str, i);
        this.re = false;
        this.i = new le(Looper.getMainLooper(), this);
        this.op = true;
        this.le = new AtomicBoolean();
        this.yu = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ms
    public void zb() {
        try {
            this.ub = ch.ms(this.ka);
            JSONObject jSONObjectVt = this.ka.vt();
            this.w = new com.bytedance.sdk.openadsdk.core.qv.ah() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ny.xr.1
                @Override // com.bytedance.sdk.openadsdk.core.qv.ah
                public void ms(boolean z, List<lm> list, boolean z2) {
                    if (!z) {
                        if (xr.this.nw.get() <= 0) {
                            xr.this.d.ms(-3, "ad meta info load fail");
                            if (xr.this.c != null) {
                                xr.this.c.ms(-3);
                                return;
                            }
                            return;
                        }
                        xr.this.nw.get();
                        xr.this.nw.decrementAndGet();
                        xr.this.zb();
                        return;
                    }
                    if (list == null || list.size() <= 0) {
                        if (xr.this.nw.get() <= 0) {
                            if (xr.this.c != null) {
                                xr.this.c.ms(-2);
                                return;
                            }
                            return;
                        } else {
                            xr.this.nw.get();
                            xr.this.nw.decrementAndGet();
                            xr.this.zb();
                            return;
                        }
                    }
                    xr.this.xr(list);
                }
            };
            boolean z = false;
            if ((this.ka == null || this.ka.le() == null || this.ka.le().ah() == null || this.ka.le().ah().optInt("use_gnd_prefetch", 0) == 1) && com.bytedance.sdk.openadsdk.core.playable.xr.ms().ms(this.ka, this.w)) {
                z = true;
            }
            if (z) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.re.xr.ms(this.ka, jSONObjectVt, this.w, this.ka.rt());
        } catch (Exception e) {
            if (this.nw.get() <= 0) {
                this.d.ms(-3, e.getMessage());
                if (this.c != null) {
                    this.c.ms(-3);
                    return;
                }
                return;
            }
            this.nw.get();
            this.nw.decrementAndGet();
            zb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(List<lm> list) {
        this.ao = list.size();
        this.h = list.size();
        this.qv = ub();
        lm lmVar = list.get(0);
        if (lmVar != null) {
            this.u = lmVar.vt();
        }
        this.ny = ms(list);
        com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms(this.f3387ms, new com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ny.xr.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms
            public void ms(JSONObject jSONObject) {
                if (jSONObject == null) {
                    xr.this.d.ms(-1, "template info load fail");
                    if (xr.this.c != null) {
                        xr.this.c.ms(-1);
                        return;
                    }
                    return;
                }
                xr xrVar = xr.this;
                xrVar.ms(jSONObject, (List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah>) xrVar.ny);
            }
        });
    }

    public void ah(boolean z) {
        this.re = z;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar = this.b;
        if (xrVar != null) {
            xrVar.d(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ms
    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> sl() {
        this.ny = new ArrayList();
        JSONObject jSONObjectRm = this.ka.rm();
        try {
            jSONObjectRm.put("env_info", ch.ms());
        } catch (JSONException e) {
            sl.ms(e);
        }
        this.ny.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah(jSONObjectRm, -2134548432));
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void ms(int i, int i2) {
        if (i2 > 0) {
            this.ch.set(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void ms(RecyclerView recyclerView, int i) {
        if (ch.xr(this.ka)) {
            ah(i);
        }
    }

    public void ah(int i) {
        if (i == 0) {
            if (this.le.get()) {
                return;
            }
            this.i.sendEmptyMessageDelayed(10081, 5000L);
        } else {
            if (this.le.get()) {
                if (this.y != null) {
                    this.y.xr();
                }
                this.le.set(false);
            }
            this.i.removeMessages(10081);
            this.i.removeMessages(10082);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, int i, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah ahVar2) {
        if (ahVar2 == null || ahVar2.ms() == null) {
            return;
        }
        int iHashCode = ahVar2.ms().hashCode();
        if (this.hi.get(Integer.valueOf(iHashCode)) != null && this.hi.containsKey(Integer.valueOf(iHashCode)) && this.hi.get(Integer.valueOf(iHashCode)).booleanValue()) {
            return;
        }
        ms(ahVar2.ms());
        if (i == this.qv) {
            ms(ahVar);
        }
        this.hi.put(Integer.valueOf(iHashCode), Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("is_slide", 1);
        } catch (JSONException e) {
            sl.ms(e);
        }
        if (this.ch.get() == 1) {
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, this.sl, "ugeno_coin_eCommerce_is_slide", jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void ka(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
        JSONObject jSONObjectCh;
        if (ahVar == null || (jSONObjectCh = ahVar.ch()) == null) {
            return;
        }
        ub.xr xrVarAh = ahVar.ah("video_".concat(String.valueOf(jSONObjectCh.optInt("image_mode"))));
        if (xrVarAh instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) xrVarAh;
            this.b = xrVar;
            xrVar.d(this.re);
            this.b.am();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void c(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
        JSONObject jSONObjectCh;
        if (ahVar == null || (jSONObjectCh = ahVar.ch()) == null) {
            return;
        }
        ub.xr xrVarAh = ahVar.ah("video_".concat(String.valueOf(jSONObjectCh.optInt("image_mode"))));
        if (xrVarAh instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) xrVarAh).ti();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ah
    public void ah(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        lm lmVarMs;
        if (ahVar == null) {
            return;
        }
        if (ahVar.ch().has("ugen_sub_meta")) {
            lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(ahVar.ch().optJSONObject("ugen_sub_meta"));
        } else {
            lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(ahVar.ch());
        }
        if (lmVarMs != null) {
            ms(lmVarMs, ahVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(int i) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar = this.b;
        if (xrVar == null) {
            sl.d("BasePageInflater", "onChangeVideoState,mVideoComponent is null !!!!!!!!!!!!");
        } else if (i == 2) {
            xrVar.tz();
        } else if (i == 3) {
            xrVar.sa();
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        int i = message.what;
        if (i == 10081) {
            if (this.y != null) {
                this.y.ms();
                this.le.set(true);
                ms(t.ms(this.xr, "tt_ecomm_page_reward_slide_tip"));
                this.i.sendEmptyMessageDelayed(10082, 6000L);
                return;
            }
            return;
        }
        if (i != 10082) {
            return;
        }
        if (this.le.get()) {
            ms(t.ms(this.xr, "tt_ecomm_page_reward_slide_tip"));
            this.i.sendEmptyMessageDelayed(10082, 6000L);
        } else {
            this.i.removeMessages(10082);
        }
    }

    public void ms(String str) {
        if (this.ah == null || !this.ah.isShown()) {
            return;
        }
        op.xr(this.xr, str, 0, 49, 0, 60);
    }

    public void h() {
        ScrollView scrollView = new ScrollView(this.xr);
        LinearLayout linearLayout = new LinearLayout(this.xr);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this.xr);
        t.ms(this.xr, "tt_ecomm_page_backup_img", imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ul.ah(this.xr, 10.0f);
        layoutParams.leftMargin = ul.ah(this.xr, 10.0f);
        layoutParams.rightMargin = ul.ah(this.xr, 10.0f);
        linearLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this.xr);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        t.ms(this.xr, "tt_ecomm_page_backup_img", imageView2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = ul.ah(this.xr, 10.0f);
        layoutParams2.leftMargin = ul.ah(this.xr, 10.0f);
        layoutParams2.rightMargin = ul.ah(this.xr, 10.0f);
        linearLayout.addView(imageView2, layoutParams2);
        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        this.ah.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void qv() {
        y();
        if (this.op) {
            this.op = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.yu);
                jSONObject.put(cl.s, System.currentTimeMillis());
            } catch (JSONException e) {
                sl.ms(e);
            }
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ny.xr.3
                @Override // com.bytedance.sdk.openadsdk.c.ms.ms
                public void ms(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
    }

    public void y() {
        Handler handler = this.i;
        if (handler != null) {
            handler.removeMessages(10081);
            this.i.removeMessages(10082);
        }
    }

    public void t() {
        this.i.removeMessages(10082);
    }

    public void nw() {
        if (ch.xr(this.ka)) {
            this.i.sendEmptyMessageDelayed(10081, 5000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ms
    public void ao() {
        super.ao();
        com.bytedance.sdk.openadsdk.core.playable.xr.ms().xr(this.ka);
        y();
    }
}
