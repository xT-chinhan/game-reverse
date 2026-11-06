package com.byazt.llk;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.byazt.aa.zo;
import com.byazt.ch.ho;
import com.byazt.rij.Swiper;
import com.umeng.analytics.pro.cc;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 669, 121})
@Deprecated
public class x extends com.byazt.ik.pr<Swiper> {
    public boolean fe;
    public float fs;
    public float h;
    public boolean ks;
    public int ku;
    public float lj;
    public float oj;
    public boolean p;
    public String qx;
    public float sr;
    public JSONArray sx;
    public com.byazt.ik.hn uk;
    public float wz;
    public String xb;
    public int xg;

    public x(Context context) {
        super(context);
        this.fe = true;
        this.ks = true;
        this.sr = 0.0f;
        this.wz = 2000.0f;
        this.xb = "normal";
        this.p = true;
        this.ku = Color.parseColor("#666666");
        this.xg = Color.parseColor("#ffffff");
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
        JSONArray jSONArray = this.sx;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((Swiper) this.c).zo((int) this.oj).aj((int) this.lj).vk((int) this.h).hn(this.p).uc(this.xg).fw(this.ku).hn(this.xb).x(this.fe).c(this.fs).pr(this.ks).x((int) this.wz).hn(this.p);
        for (int i = 0; i < this.sx.length(); i++) {
            ho hoVar = new ho(this.hw);
            hoVar.pr(this.u);
            com.byazt.ik.hn<View> hnVarHw = hoVar.hw(this.uk.ve(), null);
            hoVar.hw(this.sx.optJSONObject(i));
            ((Swiper) this.c).pr(hnVarHw);
        }
        if (this.ks) {
            ((Swiper) this.c).hn();
        }
    }

    @Override // com.byazt.ik.hn
    public void pr(JSONObject jSONObject) {
    }

    @Override // com.byazt.ik.pr
    public void pr(com.byazt.ik.hn hnVar) {
        this.uk = hnVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        byte b = -1;
        switch (str.hashCode()) {
            case -1657957217:
                if (str.equals("delayStart")) {
                    b = 3;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    b = 8;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    b = 12;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    b = 5;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    b = 0;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    b = 6;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    b = 11;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    b = 1;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    b = 4;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    b = 7;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    b = cc.k;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    b = 9;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    b = 2;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    b = 10;
                }
                break;
        }
        switch (b) {
            case 0:
                this.qx = str2;
                break;
            case 1:
                this.fe = com.byazt.aa.hn.pr(str2, true);
                break;
            case 2:
                this.ks = com.byazt.aa.hn.pr(str2, true);
                break;
            case 3:
                this.sr = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 4:
                this.wz = com.byazt.aa.hn.pr(str2, 500.0f);
                break;
            case 5:
                this.xb = str2;
                break;
            case 6:
                this.p = com.byazt.aa.hn.pr(str2, true);
                break;
            case 7:
                this.fs = com.byazt.aa.hn.pr(str2, 1.0f);
                break;
            case 8:
                this.ku = com.byazt.aa.pr.pr(str2);
                break;
            case 9:
                this.xg = com.byazt.aa.pr.pr(str2);
                break;
            case 10:
                this.sx = com.byazt.aa.hw.pr(this.x, str2, null);
                break;
            case 11:
                this.lj = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
            case 12:
                this.h = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
            case 13:
                this.oj = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
        }
    }
}
