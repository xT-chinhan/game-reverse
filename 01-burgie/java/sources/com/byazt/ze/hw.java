package com.byazt.ze;

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
import com.byazt.ca.b;
import com.byazt.ca.g;
import com.byazt.ca.ho;
import com.byazt.ca.iu;
import com.byazt.ch.lb;
import com.byazt.ea.w;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.of;
import com.byazt.hr.RecyclerView;
import com.byazt.sa.c;
import com.byazt.vkw.qi;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 16, 13})
public class hw extends com.byazt.sa.pr implements qi.pr {
    public long b;
    public boolean fo;
    public boolean iu;
    public com.byazt.hd.hw ny;
    public final Handler rc;
    public AtomicBoolean ve;
    public com.byazt.ap.x z;

    public hw(Context context, ViewGroup viewGroup, com.byazt.pj.x xVar, of ofVar, String str, int i) {
        super(context, viewGroup, xVar, ofVar, str, i);
        this.fo = false;
        this.rc = new iu(Looper.getMainLooper(), this);
        this.iu = true;
        this.ve = new AtomicBoolean();
        this.b = System.currentTimeMillis();
    }

    @Override // com.byazt.sa.pr
    public void k() {
        try {
            this.ho = w.pr(this.c);
            JSONObject jSONObjectCg = this.c.cg();
            this.z = new com.byazt.ap.x() { // from class: com.byazt.ze.hw.1
                @Override // com.byazt.ap.x
                public void pr(boolean z, List<of> list, boolean z2) {
                    if (!z) {
                        if (hw.this.cz.get() <= 0) {
                            hw.this.x.pr(-3, "ad meta info load fail");
                            if (hw.this.uc != null) {
                                hw.this.uc.pr(-3);
                                return;
                            }
                            return;
                        }
                        hw.this.cz.get();
                        hw.this.cz.decrementAndGet();
                        hw.this.k();
                        return;
                    }
                    if (list == null || list.size() <= 0) {
                        if (hw.this.cz.get() <= 0) {
                            if (hw.this.uc != null) {
                                hw.this.uc.pr(-2);
                                return;
                            }
                            return;
                        } else {
                            hw.this.cz.get();
                            hw.this.cz.decrementAndGet();
                            hw.this.k();
                            return;
                        }
                    }
                    hw.this.hw(list);
                }
            };
            boolean z = false;
            boolean z2 = this.c == null || this.c.sv() == null || this.c.sv().hn() == null || this.c.sv().hn().optInt("use_gnd_prefetch", 0) == 1;
            if (z2 && com.byazt.sb.hw.pr().pr(this.c, this.z)) {
                z = true;
            }
            if (!z) {
                com.byazt.pk.hn.pr(this.c, jSONObjectCg, this.z, this.c.p());
            }
        } catch (Exception e) {
            if (this.cz.get() <= 0) {
                this.x.pr(-3, e.getMessage());
                if (this.uc != null) {
                    this.uc.pr(-3);
                    return;
                }
                return;
            }
            this.cz.get();
            this.cz.decrementAndGet();
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(List<of> list) {
        this.nt = list.size();
        this.yb = list.size();
        this.lb = g();
        of ofVar = list.get(0);
        if (ofVar != null) {
            this.g = ofVar.cg();
        }
        this.aj = pr(list);
        c.pr(this.pr, new c.pr() { // from class: com.byazt.ze.hw.2
            @Override // com.byazt.sa.c.pr
            public void pr(JSONObject jSONObject) {
                if (jSONObject == null) {
                    hw.this.x.pr(-1, "template info load fail");
                    if (hw.this.uc != null) {
                        hw.this.uc.pr(-1);
                        return;
                    }
                    return;
                }
                hw hwVar = hw.this;
                hwVar.pr(jSONObject, (List<com.byazt.um.hn>) hwVar.aj);
            }
        });
    }

    public void hn(boolean z) {
        this.fo = z;
        com.byazt.hd.hw hwVar = this.ny;
        if (hwVar != null) {
            hwVar.x(z);
        }
    }

    @Override // com.byazt.sa.pr
    public List<com.byazt.um.hn> w() {
        this.aj = new ArrayList();
        JSONObject jSONObject = this.c.to();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("platform", "android");
            jSONObject.put("env_info", jSONObject2);
        } catch (JSONException e) {
        }
        this.aj.add(new com.byazt.um.hn(jSONObject, "shop_content".hashCode()));
        return this.aj;
    }

    @Override // com.byazt.sa.x
    public void x(com.byazt.ik.hn<View> hnVar) {
    }

    @Override // com.byazt.sa.x
    public void hw(int i, int i2) {
        if (i2 > 0) {
            this.vk.set(1);
        }
    }

    @Override // com.byazt.sa.x
    public void pr(RecyclerView recyclerView, int i) {
        if (w.hw(this.c)) {
            c(i);
        }
    }

    public void c(int i) {
        if (i == 0) {
            if (!this.ve.get()) {
                this.rc.sendEmptyMessageDelayed(10081, 5000L);
            }
        } else {
            if (this.ve.get()) {
                if (this.qa != null) {
                    this.qa.hw();
                }
                this.ve.set(false);
            }
            this.rc.removeMessages(10081);
            this.rc.removeMessages(10082);
        }
    }

    @Override // com.byazt.sa.x
    public void pr(com.byazt.ik.hn hnVar, int i, View view, com.byazt.um.hn hnVar2) {
        if (hnVar2 == null || hnVar2.pr() == null) {
            return;
        }
        int iHashCode = hnVar2.pr().hashCode();
        if (this.w.get(Integer.valueOf(iHashCode)) == null || !this.w.containsKey(Integer.valueOf(iHashCode)) || !this.w.get(Integer.valueOf(iHashCode)).booleanValue()) {
            pr(hnVar2.pr());
            if (i == this.lb) {
                pr(hnVar);
            }
            this.w.put(Integer.valueOf(iHashCode), Boolean.TRUE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("is_slide", 1);
            } catch (JSONException e) {
            }
            if (this.vk.get() == 1) {
                com.byazt.pj.pr.pr(this.c, this.k, "ugeno_coin_eCommerce_is_slide", jSONObject);
            }
        }
    }

    @Override // com.byazt.sa.x
    public void c(com.byazt.ik.hn<View> hnVar) {
        JSONObject jSONObjectVk;
        if (hnVar == null || (jSONObjectVk = hnVar.vk()) == null) {
            return;
        }
        lb.hw hwVarX = hnVar.x("video_".concat(String.valueOf(jSONObjectVk.optInt("image_mode"))));
        if (hwVarX instanceof com.byazt.hd.hw) {
            com.byazt.hd.hw hwVar = (com.byazt.hd.hw) hwVarX;
            this.ny = hwVar;
            hwVar.x(this.fo);
            this.ny.lv();
        }
    }

    @Override // com.byazt.sa.x
    public void uc(com.byazt.ik.hn<View> hnVar) {
        JSONObject jSONObjectVk;
        if (hnVar == null || (jSONObjectVk = hnVar.vk()) == null) {
            return;
        }
        lb.hw hwVarX = hnVar.x("video_".concat(String.valueOf(jSONObjectVk.optInt("image_mode"))));
        if (hwVarX instanceof com.byazt.hd.hw) {
            ((com.byazt.hd.hw) hwVarX).mw();
        }
    }

    @Override // com.byazt.sa.hn
    public void hn(com.byazt.ik.hn hnVar) {
        of ofVarPr;
        if (hnVar == null) {
            return;
        }
        if (hnVar.vk().has("ugen_sub_meta")) {
            ofVarPr = com.byazt.sd.pr.pr(hnVar.vk().optJSONObject("ugen_sub_meta"));
        } else {
            ofVarPr = com.byazt.sd.pr.pr(hnVar.vk());
        }
        if (ofVarPr != null) {
            pr(ofVarPr, hnVar);
        }
    }

    @Override // com.byazt.qx.w
    public void pr(boolean z) {
    }

    @Override // com.byazt.qx.w
    public void uc() {
    }

    @Override // com.byazt.qx.w
    public void fw() {
    }

    @Override // com.byazt.qx.w
    public void pr(int i) {
        com.byazt.hd.hw hwVar = this.ny;
        if (hwVar == null) {
            ho.hw("BasePageInflater", "onChangeVideoState,mVideoComponent is null !!!!!!!!!!!!");
        } else if (i == 2) {
            hwVar.vj();
        } else if (i == 3) {
            hwVar.od();
        }
    }

    @Override // com.byazt.qx.w
    public long pr() {
        return 0L;
    }

    @Override // com.byazt.qx.w
    public int hw() {
        return 0;
    }

    @Override // com.byazt.qx.w
    public void zo() {
    }

    @Override // com.byazt.qx.w
    public int hn() {
        return 0;
    }

    @Override // com.byazt.qx.w
    public void aj() {
    }

    @Override // com.byazt.qx.w
    public void vk() {
    }

    @Override // com.byazt.qx.w
    public void x(int i) {
    }

    @Override // com.byazt.qx.w
    public void pr(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.qx.w
    public void x() {
    }

    @Override // com.byazt.qx.w
    public void hw(int i) {
    }

    @Override // com.byazt.qx.w
    public void c() {
    }

    @Override // com.byazt.qx.w
    public void pr(int i, String str) {
    }

    @Override // com.byazt.qx.w
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.qx.w
    public void pr(float f) {
    }

    @Override // com.byazt.qx.w
    public void pr(int i, int i2) {
    }

    @Override // com.byazt.qx.w
    public void hn(int i) {
    }

    @Override // com.byazt.qx.w
    public void pr(of ofVar) {
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 10081:
                if (this.qa != null) {
                    this.qa.pr();
                    this.ve.set(true);
                    pr("\"需要下滑浏览更多才能领取奖励哦\"");
                    this.rc.sendEmptyMessageDelayed(10082, 6000L);
                }
                break;
            case 10082:
                if (this.ve.get()) {
                    pr("\"需要下滑浏览更多才能领取奖励哦\"");
                    this.rc.sendEmptyMessageDelayed(10082, 6000L);
                } else {
                    this.rc.removeMessages(10082);
                }
                break;
        }
    }

    public void pr(String str) {
        if (this.hn == null || !this.hn.isShown()) {
            return;
        }
        b.hw(this.hw, str, 0, 49, 0, 60);
    }

    public void nt() {
        ScrollView scrollView = new ScrollView(this.hw);
        LinearLayout linearLayout = new LinearLayout(this.hw);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this.hw);
        g.pr(this.hw, "tt_ecomm_page_backup_img", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = er.hn(this.hw, 10.0f);
        layoutParams.leftMargin = er.hn(this.hw, 10.0f);
        layoutParams.rightMargin = er.hn(this.hw, 10.0f);
        linearLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this.hw);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        g.pr(this.hw, "tt_ecomm_page_backup_img", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = er.hn(this.hw, 10.0f);
        layoutParams2.leftMargin = er.hn(this.hw, 10.0f);
        layoutParams2.rightMargin = er.hn(this.hw, 10.0f);
        linearLayout.addView(imageView2, layoutParams2);
        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        this.hn.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void yb() {
        lb();
        if (this.iu) {
            this.iu = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TrackAction.START, this.b);
                jSONObject.put("end", System.currentTimeMillis());
            } catch (JSONException e) {
            }
            com.byazt.pj.pr.pr(this.c, "landingpage", "agg_stay_page", new com.byazt.ttf.pr() { // from class: com.byazt.ze.hw.3
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                    return jSONObject;
                }
            });
        }
    }

    public void lb() {
        Handler handler = this.rc;
        if (handler != null) {
            handler.removeMessages(10081);
            this.rc.removeMessages(10082);
        }
    }

    public void qa() {
        this.rc.removeMessages(10082);
    }

    public void a() {
        if (w.hw(this.c)) {
            this.rc.sendEmptyMessageDelayed(10081, 5000L);
        }
    }

    @Override // com.byazt.sa.pr
    public void ho() {
        super.ho();
        com.byazt.sb.hw.pr().hw(this.c);
        lb();
    }
}
