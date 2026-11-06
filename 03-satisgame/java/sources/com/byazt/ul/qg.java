package com.byazt.ul;

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
import com.byazt.ep.cp;
import com.byazt.gct.pk;
import com.byazt.ho.BaseConstants;
import com.byazt.ozc.l;
import com.byazt.prf.RecyclerView;
import com.byazt.tk.h;
import com.byazt.tk.k;
import com.byazt.tk.sz;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.byazt.vh.cd;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 831, 26})
public class qg extends com.byazt.ozc.n implements wo.n {
    public long h;
    public com.byazt.uv.q hu;
    public final Handler m;
    public com.byazt.kx.qg ou;
    public boolean t;
    public AtomicBoolean ur;
    public boolean wm;

    @Override // com.byazt.za.d
    public void fs() {
    }

    @Override // com.byazt.za.d
    public void l() {
    }

    @Override // com.byazt.za.d
    public long n() {
        return 0L;
    }

    @Override // com.byazt.za.d
    public void n(float f) {
    }

    @Override // com.byazt.za.d
    public void n(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.za.d
    public void n(int i, int i2) {
    }

    @Override // com.byazt.za.d
    public void n(int i, String str) {
    }

    @Override // com.byazt.za.d
    public void n(pk pkVar) {
    }

    @Override // com.byazt.za.d
    public void n(boolean z) {
    }

    @Override // com.byazt.za.d
    public void q() {
    }

    @Override // com.byazt.za.d
    public void q(int i) {
    }

    @Override // com.byazt.ozc.q
    public void q(com.byazt.ih.s<View> sVar) {
    }

    @Override // com.byazt.za.d
    public int qg() {
        return 0;
    }

    @Override // com.byazt.za.d
    public void qg(int i) {
    }

    @Override // com.byazt.za.d
    public void rv() {
    }

    @Override // com.byazt.za.d
    public int s() {
        return 0;
    }

    @Override // com.byazt.za.d
    public void s(int i) {
    }

    @Override // com.byazt.za.d
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.za.d
    public void tj() {
    }

    @Override // com.byazt.za.d
    public void w() {
    }

    @Override // com.byazt.za.d
    public void x() {
    }

    public qg(Context context, ViewGroup viewGroup, com.byazt.hm.q qVar, pk pkVar, String str, int i) {
        super(context, viewGroup, qVar, pkVar, str, i);
        this.wm = false;
        this.m = new t(Looper.getMainLooper(), this);
        this.t = true;
        this.ur = new AtomicBoolean();
        this.h = System.currentTimeMillis();
    }

    @Override // com.byazt.ozc.n
    public void d() {
        try {
            this.k = cp.n(this.l);
            JSONObject jSONObjectVh = this.l.vh();
            this.hu = new com.byazt.uv.q() { // from class: com.byazt.ul.qg.1
                @Override // com.byazt.uv.q
                public void n(boolean z, List<pk> list, boolean z2) {
                    if (!z) {
                        if (qg.this.py.get() <= 0) {
                            qg.this.q.n(-3, "ad meta info load fail");
                            if (qg.this.w != null) {
                                qg.this.w.n(-3);
                                return;
                            }
                            return;
                        }
                        qg.this.py.get();
                        qg.this.py.decrementAndGet();
                        qg.this.d();
                        return;
                    }
                    if (list == null || list.size() <= 0) {
                        if (qg.this.py.get() <= 0) {
                            if (qg.this.w != null) {
                                qg.this.w.n(-2);
                                return;
                            }
                            return;
                        } else {
                            qg.this.py.get();
                            qg.this.py.decrementAndGet();
                            qg.this.d();
                            return;
                        }
                    }
                    qg.this.qg(list);
                }
            };
            boolean z = false;
            if ((this.l == null || this.l.fl() == null || this.l.fl().s() == null || this.l.fl().s().optInt("use_gnd_prefetch", 0) == 1) && com.byazt.ltk.n.n().n(this.l, this.hu)) {
                z = true;
            }
            if (z) {
                return;
            }
            com.byazt.jc.q.n(this.l, jSONObjectVh, this.hu, this.l.xd());
        } catch (Exception e) {
            if (this.py.get() <= 0) {
                this.q.n(-3, e.getMessage());
                if (this.w != null) {
                    this.w.n(-3);
                    return;
                }
                return;
            }
            this.py.get();
            this.py.decrementAndGet();
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(List<pk> list) {
        this.cy = list.size();
        this.hd = list.size();
        this.cd = sz();
        pk pkVar = list.get(0);
        if (pkVar != null) {
            this.sz = pkVar.vh();
        }
        this.rv = n(list);
        l.n(this.n, new l.n() { // from class: com.byazt.ul.qg.2
            @Override // com.byazt.ozc.l.n
            public void n(JSONObject jSONObject) {
                if (jSONObject == null) {
                    qg.this.q.n(-1, "template info load fail");
                    if (qg.this.w != null) {
                        qg.this.w.n(-1);
                        return;
                    }
                    return;
                }
                qg qgVar = qg.this;
                qgVar.n(jSONObject, (List<com.byazt.mu.s>) qgVar.rv);
            }
        });
    }

    public void s(boolean z) {
        this.wm = z;
        com.byazt.kx.qg qgVar = this.ou;
        if (qgVar != null) {
            qgVar.q(z);
        }
    }

    @Override // com.byazt.ozc.n
    public List<com.byazt.mu.s> cp() {
        this.rv = new ArrayList();
        JSONObject jSONObjectPv = this.l.pv();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "android");
            jSONObjectPv.put("env_info", jSONObject);
        } catch (JSONException unused) {
        }
        this.rv.add(new com.byazt.mu.s(jSONObjectPv, -2134548432));
        return this.rv;
    }

    @Override // com.byazt.ozc.q
    public void qg(int i, int i2) {
        if (i2 > 0) {
            this.tj.set(1);
        }
    }

    @Override // com.byazt.ozc.q
    public void n(RecyclerView recyclerView, int i) {
        if (cp.qg(this.l)) {
            l(i);
        }
    }

    public void l(int i) {
        if (i == 0) {
            if (this.ur.get()) {
                return;
            }
            this.m.sendEmptyMessageDelayed(10081, 5000L);
        } else {
            if (this.ur.get()) {
                if (this.um != null) {
                    this.um.qg();
                }
                this.ur.set(false);
            }
            this.m.removeMessages(10081);
            this.m.removeMessages(10082);
        }
    }

    @Override // com.byazt.ozc.q
    public void n(com.byazt.ih.s sVar, int i, View view, com.byazt.mu.s sVar2) {
        if (sVar2 == null || sVar2.n() == null) {
            return;
        }
        int iHashCode = sVar2.n().hashCode();
        if (this.cp.get(Integer.valueOf(iHashCode)) != null && this.cp.containsKey(Integer.valueOf(iHashCode)) && this.cp.get(Integer.valueOf(iHashCode)).booleanValue()) {
            return;
        }
        n(sVar2.n());
        if (i == this.cd) {
            n(sVar);
        }
        this.cp.put(Integer.valueOf(iHashCode), Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("is_slide", 1);
        } catch (JSONException unused) {
        }
        if (this.tj.get() == 1) {
            com.byazt.hm.n.n(this.l, this.d, "ugeno_coin_eCommerce_is_slide", jSONObject);
        }
    }

    @Override // com.byazt.ozc.q
    public void l(com.byazt.ih.s<View> sVar) {
        JSONObject jSONObjectTj;
        if (sVar == null || (jSONObjectTj = sVar.tj()) == null) {
            return;
        }
        cd.n nVarQ = sVar.q("video_".concat(String.valueOf(jSONObjectTj.optInt("image_mode"))));
        if (nVarQ instanceof com.byazt.kx.qg) {
            com.byazt.kx.qg qgVar = (com.byazt.kx.qg) nVarQ;
            this.ou = qgVar;
            qgVar.q(this.wm);
            this.ou.cx();
        }
    }

    @Override // com.byazt.ozc.q
    public void w(com.byazt.ih.s<View> sVar) {
        JSONObject jSONObjectTj;
        if (sVar == null || (jSONObjectTj = sVar.tj()) == null) {
            return;
        }
        cd.n nVarQ = sVar.q("video_".concat(String.valueOf(jSONObjectTj.optInt("image_mode"))));
        if (nVarQ instanceof com.byazt.kx.qg) {
            ((com.byazt.kx.qg) nVarQ).ci();
        }
    }

    @Override // com.byazt.ozc.s
    public void s(com.byazt.ih.s sVar) {
        pk pkVarN;
        if (sVar == null) {
            return;
        }
        if (sVar.tj().has("ugen_sub_meta")) {
            pkVarN = com.byazt.vgx.qg.n(sVar.tj().optJSONObject("ugen_sub_meta"));
        } else {
            pkVarN = com.byazt.vgx.qg.n(sVar.tj());
        }
        if (pkVarN != null) {
            n(pkVarN, sVar);
        }
    }

    @Override // com.byazt.za.d
    public void n(int i) {
        com.byazt.kx.qg qgVar = this.ou;
        if (qgVar == null) {
            k.qg("BasePageInflater", "onChangeVideoState,mVideoComponent is null !!!!!!!!!!!!");
        } else if (i == 2) {
            qgVar.ic();
        } else if (i == 3) {
            qgVar.lq();
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        int i = message.what;
        if (i == 10081) {
            if (this.um != null) {
                this.um.n();
                this.ur.set(true);
                n("\"需要下滑浏览更多才能领取奖励哦\"");
                this.m.sendEmptyMessageDelayed(10082, 6000L);
                return;
            }
            return;
        }
        if (i != 10082) {
            return;
        }
        if (this.ur.get()) {
            n("\"需要下滑浏览更多才能领取奖励哦\"");
            this.m.sendEmptyMessageDelayed(10082, 6000L);
        } else {
            this.m.removeMessages(10082);
        }
    }

    public void n(String str) {
        if (this.s == null || !this.s.isShown()) {
            return;
        }
        h.qg(this.qg, str, 0, 49, 0, 60);
    }

    public void cy() {
        ScrollView scrollView = new ScrollView(this.qg);
        LinearLayout linearLayout = new LinearLayout(this.qg);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this.qg);
        sz.n(this.qg, "tt_ecomm_page_backup_img", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.byazt.okk.s.s(this.qg, 10.0f);
        layoutParams.leftMargin = com.byazt.okk.s.s(this.qg, 10.0f);
        layoutParams.rightMargin = com.byazt.okk.s.s(this.qg, 10.0f);
        linearLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this.qg);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        sz.n(this.qg, "tt_ecomm_page_backup_img", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = com.byazt.okk.s.s(this.qg, 10.0f);
        layoutParams2.leftMargin = com.byazt.okk.s.s(this.qg, 10.0f);
        layoutParams2.rightMargin = com.byazt.okk.s.s(this.qg, 10.0f);
        linearLayout.addView(imageView2, layoutParams2);
        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        this.s.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void hd() {
        cd();
        if (this.t) {
            this.t = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.h);
                jSONObject.put("end", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            com.byazt.hm.n.n(this.l, "landingpage", "agg_stay_page", new com.byazt.rs.n() { // from class: com.byazt.ul.qg.3
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                    return jSONObject;
                }
            });
        }
    }

    public void cd() {
        Handler handler = this.m;
        if (handler != null) {
            handler.removeMessages(10081);
            this.m.removeMessages(10082);
        }
    }

    public void um() {
        this.m.removeMessages(10082);
    }

    public void a() {
        if (cp.qg(this.l)) {
            this.m.sendEmptyMessageDelayed(10081, 5000L);
        }
    }

    @Override // com.byazt.ozc.n
    public void k() {
        super.k();
        com.byazt.ltk.n.n().qg(this.l);
        cd();
    }
}
