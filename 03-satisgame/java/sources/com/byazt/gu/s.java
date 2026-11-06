package com.byazt.gu;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hb.fs;
import com.byazt.lb.Swiper;
import com.byazt.vh.k;
import com.byazt.xz.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, 8})
public class s extends com.byazt.ih.n<Swiper> implements com.byazt.lb.n {
    public float bz;
    public boolean c;
    public float ca;
    public float ct;
    public boolean di;
    public boolean dm;
    public boolean dz;
    public boolean ei;
    public boolean eq;
    public float il;
    public int iz;
    public JSONArray jh;
    public float la;
    public float lg;
    public float nk;
    public float o;
    public boolean of;
    public int oo;
    public int ox;
    public float qh;
    public String qn;
    public int sq;
    public String ti;
    public int tr;
    public float vo;
    public float xb;
    public int xd;
    public String ze;

    public s(Context context) {
        super(context);
        this.sq = 0;
        this.ei = true;
        this.dm = true;
        this.vo = 500.0f;
        this.o = -1.0f;
        this.nk = 2000.0f;
        this.ze = "slide";
        this.qn = "dot";
        this.bz = 8.0f;
        this.il = 8.0f;
        this.la = 50.0f;
        this.qh = 90.0f;
        this.eq = false;
        this.ox = Color.parseColor("#666666");
        this.xd = Color.parseColor("#ffffff");
        this.ti = "row";
        this.lg = 1.0f;
        this.xb = 0.0f;
        this.ct = 0.0f;
        this.ca = 0.0f;
        this.tr = 0;
        this.iz = 0;
        this.of = true;
        this.dz = false;
        this.c = true;
        float fN = fs.n(this.qg, 8.0f);
        this.bz = fN;
        this.il = fN;
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
        ((Swiper) this.l).s((int) this.vo).l(this.dz).n(this.qn).n(this.bz).qg(this.il).s(this.la).q(this.qh).qg(this.ti).n(this.sq).qg().q(this.ei).n(this.dm).qg((int) this.vo).q((int) this.nk).l((int) this.o).qg(this.of).s(this.eq).x(this.ox).w(this.xd).rv((int) this.ct).tj((int) this.ca).fs((int) this.xb).l(this.lg).s(this.ze).sz(this.iz);
        ((Swiper) this.l).setOnPageChangeListener(this);
        if (this.tr == 1) {
            lq();
        } else {
            cx();
        }
        ((Swiper) this.l).s();
    }

    @Override // com.byazt.ih.n
    public void n(com.byazt.ih.s sVar) {
        if (sVar == null) {
            return;
        }
        this.n.add(sVar);
    }

    @Override // com.byazt.ih.n
    public void n(com.byazt.ih.s sVar, ViewGroup.LayoutParams layoutParams) {
        if (sVar == null) {
            return;
        }
        this.n.add(sVar);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        switch (str) {
            case "startDelay":
                this.o = com.byazt.hb.s.n(str2, -1.0f);
                break;
            case "startIndex":
                this.iz = com.byazt.hb.s.n(str2, 0);
                break;
            case "indicatorColor":
                this.ox = com.byazt.hb.n.n(str2, this.ox);
                break;
            case "indicatorStyle":
                this.qn = str2;
                break;
            case "indicatorWidth":
                this.bz = fs.n(this.qg, com.byazt.hb.s.n(str2, 8.0f));
                break;
            case "indicatorHeight":
                this.il = fs.n(this.qg, com.byazt.hb.s.n(str2, 8.0f));
                break;
            case "nextMargin":
                this.ca = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
            case "driveMode":
                this.tr = com.byazt.hb.s.n(str2, 0);
                break;
            case "effect":
                this.ze = str2;
                break;
            case "direction":
                if (TextUtils.equals(str2, "vertical")) {
                    this.sq = 1;
                    break;
                } else {
                    this.sq = 0;
                    break;
                }
                break;
            case "disableOnInteraction":
                this.dz = com.byazt.hb.s.n(str2, false);
                break;
            case "indicator":
                this.eq = com.byazt.hb.s.n(str2, false);
                break;
            case "indicatorX":
                this.la = com.byazt.hb.s.n(str2, 50.0f);
                break;
            case "indicatorY":
                this.qh = com.byazt.hb.s.n(str2, 90.0f);
                break;
            case "previousMargin":
                this.ct = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
            case "loop":
                this.ei = com.byazt.hb.s.n(str2, true);
                break;
            case "delay":
                this.nk = com.byazt.hb.s.n(str2, 2000.0f);
                break;
            case "speed":
                this.vo = com.byazt.hb.s.n(str2, 500.0f);
                break;
            case "indicatorDirection":
                this.ti = str2;
                break;
            case "allowTouchMove":
                this.of = com.byazt.hb.s.n(str2, true);
                break;
            case "pageCount":
                this.lg = com.byazt.hb.s.n(str2, 1.0f);
                break;
            case "pageMargin":
                this.xb = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
            case "indicatorSelectedColor":
                this.xd = com.byazt.hb.n.n(str2, this.xd);
                break;
            case "autoplay":
                this.dm = com.byazt.hb.s.n(str2, true);
                break;
            case "dataList":
                this.jh = com.byazt.hb.qg.n(this.q, str2, null);
                break;
        }
    }

    private void cx() {
        if (this.n == null || this.n.isEmpty()) {
            return;
        }
        com.byazt.ih.s<View> sVar = this.n.get(0);
        if (this.jh == null) {
            return;
        }
        for (int i = 0; i < this.jh.length(); i++) {
            k kVar = new k(this.qg);
            kVar.n((String) null, this.rv);
            n(kVar);
            kVar.n(this.ju);
            try {
                JSONObject jSONObjectOptJSONObject = this.jh.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    if (jSONObjectOptJSONObject.has("$chunk")) {
                        this.q.put("$item", jSONObjectOptJSONObject.optJSONArray("$chunk"));
                    } else {
                        this.q.put("$item", jSONObjectOptJSONObject);
                    }
                    ((Swiper) this.l).n(kVar.n(sVar.ur(), this.q, (JSONObject) null));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void lq() {
        for (int i = 0; i < this.n.size(); i++) {
            com.byazt.ih.s<View> sVar = this.n.get(i);
            if (sVar != null) {
                k kVar = new k(this.qg);
                kVar.n((String) null, this.rv);
                n(kVar);
                kVar.n(this.ju);
                ((Swiper) this.l).n(kVar.n(sVar.ur(), this.q, (JSONObject) null));
            }
        }
    }

    private int ic() {
        if (this.tr == 1) {
            if (this.n != null) {
                return this.n.size();
            }
            return 0;
        }
        JSONArray jSONArray = this.jh;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    @Override // com.byazt.lb.n
    public void n(boolean z, int i, float f, int i2) {
        n(z, i, f);
    }

    @Override // com.byazt.lb.n
    public void n(boolean z, int i, int i2, boolean z2, boolean z3) {
        if (this.oo != i) {
            w(i);
            x(i);
            this.oo = i;
        }
    }

    @Override // com.byazt.lb.n
    public void n(boolean z, int i) {
        if (i != 0) {
            if (i != 1) {
                return;
            }
            this.di = true;
        } else {
            if (!z) {
                this.c = true;
            }
            this.di = false;
        }
    }

    private void w(int i) {
        if (this.mz == null) {
            return;
        }
        if (this.oo == 0 && i == ic() - 1) {
            this.mz.n("SwiperView://reloop", 1);
        }
        if (this.oo == ic() - 1 && i == 0) {
            this.mz.n("SwiperView://reloop", 0);
        }
    }

    private void x(int i) {
        if (this.mz == null) {
            return;
        }
        this.mz.n("SwiperView://slide", Integer.valueOf(this.oo), Integer.valueOf(i), Integer.valueOf(!this.di ? 1 : 0));
    }

    private void n(boolean z, int i, float f) {
        if (this.mz != null && !z && i == ic() - 1 && f == 0.0f && this.c) {
            this.mz.n("SwiperView://finish", new Object[0]);
            this.c = false;
        }
    }

    private void n(k kVar) {
        if (this.dz) {
            kVar.n(new com.byazt.vh.w() { // from class: com.byazt.gu.s.1
                @Override // com.byazt.vh.w
                public void n(com.byazt.ih.s sVar, String str, List<x.n> list) {
                    if ((TextUtils.equals(str, "tap") || TextUtils.equals(str, "slide") || TextUtils.equals(str, "touchStart") || TextUtils.equals(str, "touchEnd")) && s.this.l != null) {
                        ((Swiper) s.this.l).l();
                    }
                }
            });
        }
    }
}
