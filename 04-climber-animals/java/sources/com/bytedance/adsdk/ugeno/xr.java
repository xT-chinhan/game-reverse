package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.ah.sl;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.adsdk.ugeno.swiper.Swiper;
import com.umeng.analytics.pro.ek;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class xr extends com.bytedance.adsdk.ugeno.xr.ms<Swiper> {
    private float a;
    private boolean cc;
    private int cj;
    private com.bytedance.adsdk.ugeno.xr.ah di;
    private boolean gs;
    private boolean kl;
    private float mh;
    private float nl;
    private JSONArray pl;
    private String qo;
    private float r;
    private float si;
    private String vf;
    private float wp;
    private int wq;

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(JSONObject jSONObject) {
    }

    public xr(Context context) {
        super(context);
        this.kl = true;
        this.gs = true;
        this.r = 0.0f;
        this.nl = 2000.0f;
        this.qo = PrerollVideoResponse.NORMAL;
        this.cc = true;
        this.cj = Color.parseColor("#666666");
        this.wq = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public View ms() {
        this.ka = new Swiper(this.xr);
        ((Swiper) this.ka).ms((ah) this);
        return this.ka;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        JSONArray jSONArray = this.pl;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((Swiper) this.ka).d((int) this.a).ka((int) this.mh).c((int) this.wp).ah(this.cc).xr(this.wq).ah(this.cj).xr(this.qo).d(this.kl).ms(this.si).ms(this.gs).ms((int) this.nl).ah(this.cc);
        for (int i = 0; i < this.pl.length(); i++) {
            sl slVar = new sl(this.xr);
            slVar.ms(this.z);
            com.bytedance.adsdk.ugeno.xr.ah<View> ahVarXr = slVar.xr(this.di.le(), null);
            slVar.xr(this.pl.optJSONObject(i));
            ((Swiper) this.ka).ms(ahVarXr);
        }
        if (this.gs) {
            ((Swiper) this.ka).xr();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        this.di = ahVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1657957217:
                if (str.equals("delayStart")) {
                    b = 0;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    b = 1;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    b = 2;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    b = 3;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    b = 4;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    b = 5;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    b = 6;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    b = 7;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    b = 8;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    b = 9;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    b = 10;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    b = 11;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    b = 12;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    b = ek.k;
                }
                break;
        }
        switch (b) {
            case 0:
                this.r = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 1:
                this.cj = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
            case 2:
                this.wp = x.ms(this.xr, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f));
                break;
            case 3:
                this.qo = str2;
                break;
            case 4:
                this.vf = str2;
                break;
            case 5:
                this.cc = com.bytedance.adsdk.ugeno.c.ah.ms(str2, true);
                break;
            case 6:
                this.mh = x.ms(this.xr, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f));
                break;
            case 7:
                this.kl = com.bytedance.adsdk.ugeno.c.ah.ms(str2, true);
                break;
            case 8:
                this.nl = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 500.0f);
                break;
            case 9:
                this.si = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 1.0f);
                break;
            case 10:
                this.a = x.ms(this.xr, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f));
                break;
            case 11:
                this.wq = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
            case 12:
                this.gs = com.bytedance.adsdk.ugeno.c.ah.ms(str2, true);
                break;
            case 13:
                this.pl = com.bytedance.adsdk.ugeno.c.xr.ms(str2, (JSONArray) null);
                break;
        }
    }
}
