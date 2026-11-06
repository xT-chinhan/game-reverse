package com.byazt.llk;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aa.zo;
import com.byazt.ch.ho;
import com.byazt.dd.fw;
import com.byazt.rij.Swiper;
import com.tapsdk.tapad.group.constants.Constants;
import com.umeng.analytics.pro.cc;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 669, 20})
public class hn extends com.byazt.ik.pr<Swiper> implements com.byazt.rij.pr {
    public boolean fe;
    public float fs;
    public boolean gg;
    public int h;
    public int hg;
    public boolean kl;
    public boolean ks;
    public String ku;
    public int lj;
    public boolean oj;
    public float om;
    public String p;
    public int pp;
    public int qx;
    public float sr;
    public boolean su;
    public float sx;
    public String t;
    public float tv;
    public float uk;
    public JSONArray vv;
    public float wm;
    public int wo;
    public float wz;
    public float xb;
    public float xg;
    public boolean xi;
    public float yj;

    public hn(Context context) {
        super(context);
        this.qx = 0;
        this.fe = true;
        this.ks = true;
        this.sr = 500.0f;
        this.wz = -1.0f;
        this.xb = 2000.0f;
        this.p = "slide";
        this.ku = "dot";
        this.xg = 8.0f;
        this.fs = 8.0f;
        this.sx = 50.0f;
        this.uk = 90.0f;
        this.oj = false;
        this.lj = Color.parseColor("#666666");
        this.h = Color.parseColor("#ffffff");
        this.t = "row";
        this.yj = 1.0f;
        this.tv = 0.0f;
        this.om = 0.0f;
        this.wm = 0.0f;
        this.wo = 0;
        this.hg = 0;
        this.su = true;
        this.gg = false;
        this.kl = true;
        float fPr = zo.pr(this.hw, 8.0f);
        this.xg = fPr;
        this.fs = fPr;
    }

    @Override // com.byazt.ik.hn
    public View pr() {
        this.c = new Swiper(this.hw);
        ((Swiper) this.c).pr((c) this);
        return this.c;
    }

    @Override // com.byazt.ik.pr, com.byazt.ik.hn
    public void hw() {
        super.hw();
        ((Swiper) this.c).hn((int) this.sr).c(this.gg).pr(this.ku).pr(this.xg).hw(this.fs).hn(this.sx).x(this.uk).hw(this.t).pr(this.qx).hw().x(this.fe).pr(this.ks).hw((int) this.sr).x((int) this.xb).c((int) this.wz).hw(this.su).hn(this.oj).fw(this.lj).uc(this.h).aj((int) this.om).vk((int) this.wm).zo((int) this.tv).c(this.yj).hn(this.p).g(this.hg);
        ((Swiper) this.c).setOnPageChangeListener(this);
        if (this.wo == 1) {
            od();
        } else {
            lv();
        }
        ((Swiper) this.c).hn();
    }

    @Override // com.byazt.ik.pr
    public void pr(com.byazt.ik.hn hnVar) {
        if (hnVar == null) {
            return;
        }
        this.pr.add(hnVar);
    }

    @Override // com.byazt.ik.pr
    public void pr(com.byazt.ik.hn hnVar, ViewGroup.LayoutParams layoutParams) {
        if (hnVar == null) {
            return;
        }
        this.pr.add(hnVar);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        byte b = -1;
        switch (str.hashCode()) {
            case -1598524863:
                if (str.equals("startDelay")) {
                    b = 4;
                }
                break;
            case -1593646704:
                if (str.equals("startIndex")) {
                    b = 22;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    b = 10;
                }
                break;
            case -1560813342:
                if (str.equals("indicatorStyle")) {
                    b = 8;
                }
                break;
            case -1557466889:
                if (str.equals("indicatorWidth")) {
                    b = 12;
                }
                break;
            case -1469828074:
                if (str.equals("indicatorHeight")) {
                    b = cc.k;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    b = 19;
                }
                break;
            case -1367379379:
                if (str.equals("driveMode")) {
                    b = 21;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    b = 6;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    b = 0;
                }
                break;
            case -855614293:
                if (str.equals("disableOnInteraction")) {
                    b = 24;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    b = 7;
                }
                break;
            case -597162967:
                if (str.equals("indicatorX")) {
                    b = cc.l;
                }
                break;
            case -597162966:
                if (str.equals("indicatorY")) {
                    b = cc.m;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    b = 18;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    b = 1;
                }
                break;
            case 95467907:
                if (str.equals(Constants.DELAY_FIELD)) {
                    b = 5;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    b = 3;
                }
                break;
            case 195414576:
                if (str.equals("indicatorDirection")) {
                    b = cc.n;
                }
                break;
            case 497874535:
                if (str.equals("allowTouchMove")) {
                    b = 23;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    b = 9;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    b = 20;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    b = 11;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    b = 2;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    b = 17;
                }
                break;
        }
        switch (b) {
            case 0:
                if (TextUtils.equals(str2, "vertical")) {
                    this.qx = 1;
                } else {
                    this.qx = 0;
                }
                break;
            case 1:
                this.fe = com.byazt.aa.hn.pr(str2, true);
                break;
            case 2:
                this.ks = com.byazt.aa.hn.pr(str2, true);
                break;
            case 3:
                this.sr = com.byazt.aa.hn.pr(str2, 500.0f);
                break;
            case 4:
                this.wz = com.byazt.aa.hn.pr(str2, -1.0f);
                break;
            case 5:
                this.xb = com.byazt.aa.hn.pr(str2, 2000.0f);
                break;
            case 6:
                this.p = str2;
                break;
            case 7:
                this.oj = com.byazt.aa.hn.pr(str2, false);
                break;
            case 8:
                this.ku = str2;
                break;
            case 9:
                this.yj = com.byazt.aa.hn.pr(str2, 1.0f);
                break;
            case 10:
                this.lj = com.byazt.aa.pr.pr(str2, this.lj);
                break;
            case 11:
                this.h = com.byazt.aa.pr.pr(str2, this.h);
                break;
            case 12:
                this.xg = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 8.0f));
                break;
            case 13:
                this.fs = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 8.0f));
                break;
            case 14:
                this.sx = com.byazt.aa.hn.pr(str2, 50.0f);
                break;
            case 15:
                this.uk = com.byazt.aa.hn.pr(str2, 90.0f);
                break;
            case 16:
                this.t = str2;
                break;
            case 17:
                this.vv = com.byazt.aa.hw.pr(this.x, str2, null);
                break;
            case 18:
                this.om = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
            case 19:
                this.wm = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
            case 20:
                this.tv = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
            case 21:
                this.wo = com.byazt.aa.hn.pr(str2, 0);
                break;
            case 22:
                this.hg = com.byazt.aa.hn.pr(str2, 0);
                break;
            case 23:
                this.su = com.byazt.aa.hn.pr(str2, true);
                break;
            case 24:
                this.gg = com.byazt.aa.hn.pr(str2, false);
                break;
        }
    }

    private void lv() {
        if (this.pr != null && !this.pr.isEmpty()) {
            com.byazt.ik.hn<View> hnVar = this.pr.get(0);
            if (this.vv == null) {
                return;
            }
            for (int i = 0; i < this.vv.length(); i++) {
                ho hoVar = new ho(this.hw);
                pr(hoVar);
                hoVar.pr(this.u);
                try {
                    JSONObject jSONObjectOptJSONObject = this.vv.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        if (jSONObjectOptJSONObject.has("$chunk")) {
                            this.x.put("$item", jSONObjectOptJSONObject.optJSONArray("$chunk"));
                        } else {
                            this.x.put("$item", jSONObjectOptJSONObject);
                        }
                        ((Swiper) this.c).pr(hoVar.pr(hnVar.ve(), this.x, (JSONObject) null));
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    private void od() {
        for (int i = 0; i < this.pr.size(); i++) {
            com.byazt.ik.hn<View> hnVar = this.pr.get(i);
            if (hnVar != null) {
                ho hoVar = new ho(this.hw);
                pr(hoVar);
                hoVar.pr(this.u);
                ((Swiper) this.c).pr(hoVar.pr(hnVar.ve(), this.x, (JSONObject) null));
            }
        }
    }

    private int vj() {
        if (this.wo == 1) {
            if (this.pr != null) {
                return this.pr.size();
            }
            return 0;
        }
        JSONArray jSONArray = this.vv;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    @Override // com.byazt.rij.pr
    public void pr(boolean z, int i, float f, int i2) {
        pr(z, i, f);
    }

    @Override // com.byazt.rij.pr
    public void pr(boolean z, int i, int i2, boolean z2, boolean z3) {
        if (this.pp != i) {
            uc(i);
            fw(i);
            this.pp = i;
        }
    }

    @Override // com.byazt.rij.pr
    public void pr(boolean z, int i) {
        switch (i) {
            case 0:
                if (!z) {
                    this.kl = true;
                }
                this.xi = false;
                break;
            case 1:
                this.xi = true;
                break;
        }
    }

    private void uc(int i) {
        if (this.ag == null) {
            return;
        }
        if (this.pp == 0 && i == vj() - 1) {
            this.ag.pr("SwiperView://reloop", 1);
        }
        if (this.pp == vj() - 1 && i == 0) {
            this.ag.pr("SwiperView://reloop", 0);
        }
    }

    private void fw(int i) {
        if (this.ag == null) {
            return;
        }
        this.ag.pr("SwiperView://slide", Integer.valueOf(this.pp), Integer.valueOf(i), Integer.valueOf(!this.xi ? 1 : 0));
    }

    private void pr(boolean z, int i, float f) {
        if (this.ag != null && !z && i == vj() - 1 && f == 0.0f && this.kl) {
            this.ag.pr("SwiperView://finish", new Object[0]);
            this.kl = false;
        }
    }

    private void pr(ho hoVar) {
        if (this.gg) {
            hoVar.pr(new com.byazt.ch.uc() { // from class: com.byazt.llk.hn.1
                @Override // com.byazt.ch.uc
                public void pr(com.byazt.ik.hn hnVar, String str, List<fw.pr> list) {
                    if ((TextUtils.equals(str, "tap") || TextUtils.equals(str, "slide") || TextUtils.equals(str, "touchStart") || TextUtils.equals(str, "touchEnd")) && hn.this.c != null) {
                        ((Swiper) hn.this.c).c();
                    }
                }
            });
        }
    }
}
