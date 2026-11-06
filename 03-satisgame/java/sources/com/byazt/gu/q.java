package com.byazt.gu;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.byazt.hb.fs;
import com.byazt.lb.Swiper;
import com.byazt.vh.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, 5})
@Deprecated
public class q extends com.byazt.ih.n<Swiper> {
    public int bz;
    public boolean dm;
    public boolean ei;
    public float eq;
    public float il;
    public JSONArray la;
    public String nk;
    public float o;
    public float ox;
    public com.byazt.ih.s qh;
    public int qn;
    public String sq;
    public float vo;
    public float xd;
    public boolean ze;

    @Override // com.byazt.ih.s
    public void n(JSONObject jSONObject) {
    }

    public q(Context context) {
        super(context);
        this.ei = true;
        this.dm = true;
        this.vo = 0.0f;
        this.o = 2000.0f;
        this.nk = "normal";
        this.ze = true;
        this.qn = Color.parseColor("#666666");
        this.bz = Color.parseColor("#ffffff");
    }

    @Override // com.byazt.ih.s
    public View n() {
        this.l = new Swiper(this.qg);
        ((Swiper) this.l).n((l) this);
        return this.l;
    }

    @Override // com.byazt.ih.n, com.byazt.ih.s
    public void qg() {
        super.qg();
        JSONArray jSONArray = this.la;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((Swiper) this.l).fs((int) this.eq).rv((int) this.ox).tj((int) this.xd).s(this.ze).w(this.bz).x(this.qn).s(this.nk).q(this.ei).l(this.il).n(this.dm).q((int) this.o).s(this.ze);
        for (int i = 0; i < this.la.length(); i++) {
            k kVar = new k(this.qg);
            kVar.n((String) null, this.rv);
            kVar.n(this.ju);
            com.byazt.ih.s<View> sVarQg = kVar.qg(this.qh.ur(), null);
            kVar.qg(this.la.optJSONObject(i));
            ((Swiper) this.l).n(sVarQg);
        }
        if (this.dm) {
            ((Swiper) this.l).s();
        }
    }

    @Override // com.byazt.ih.n
    public void n(com.byazt.ih.s sVar) {
        this.qh = sVar;
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        switch (str) {
            case "delayStart":
                this.vo = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case "indicatorColor":
                this.qn = com.byazt.hb.n.n(str2);
                break;
            case "nextMargin":
                this.xd = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
            case "effect":
                this.nk = str2;
                break;
            case "direction":
                this.sq = str2;
                break;
            case "indicator":
                this.ze = com.byazt.hb.s.n(str2, true);
                break;
            case "previousMargin":
                this.ox = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
            case "loop":
                this.ei = com.byazt.hb.s.n(str2, true);
                break;
            case "speed":
                this.o = com.byazt.hb.s.n(str2, 500.0f);
                break;
            case "pageCount":
                this.il = com.byazt.hb.s.n(str2, 1.0f);
                break;
            case "pageMargin":
                this.eq = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
            case "indicatorSelectedColor":
                this.bz = com.byazt.hb.n.n(str2);
                break;
            case "autoplay":
                this.dm = com.byazt.hb.s.n(str2, true);
                break;
            case "dataList":
                this.la = com.byazt.hb.qg.n(this.q, str2, null);
                break;
        }
    }
}
