package com.byazt.rk;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1536, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public c aj;
    public float c;
    public float fw;
    public boolean g;
    public float hn;
    public float hw;
    public List<List<zo>> k;
    public String m;
    public String pr;
    public float uc;
    public List<zo> vk;
    public zo w;
    public float x;
    public float zo;
    public Map<String, String> ho = new HashMap();
    public Map<Integer, String> nt = new HashMap();

    public String pr() {
        return this.m;
    }

    public void pr(String str) {
        this.m = str;
    }

    public Map<Integer, String> hw() {
        return this.nt;
    }

    public void pr(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                this.nt.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString(Constants.VALUE_FIELD));
            }
        } catch (Throwable th) {
        }
    }

    public String hn() {
        return this.pr;
    }

    public void hw(String str) {
        this.pr = str;
    }

    public float x() {
        return this.x;
    }

    public void pr(float f) {
        this.x = f;
    }

    public float c() {
        return this.c;
    }

    public void hw(float f) {
        this.c = f;
    }

    public float uc() {
        return this.hw;
    }

    public void hn(float f) {
        this.hw = f;
    }

    public float fw() {
        return this.hn;
    }

    public void x(float f) {
        this.hn = f;
    }

    public float zo() {
        return this.uc;
    }

    public void c(float f) {
        this.uc = f;
    }

    public float aj() {
        return this.fw;
    }

    public void uc(float f) {
        this.fw = f;
    }

    public void fw(float f) {
        this.zo = f;
    }

    public c vk() {
        return this.aj;
    }

    public void pr(c cVar) {
        this.aj = cVar;
    }

    public List<zo> w() {
        return this.vk;
    }

    public void pr(List<zo> list) {
        this.vk = list;
    }

    public void pr(zo zoVar) {
        this.w = zoVar;
    }

    public zo k() {
        return this.w;
    }

    public int m() {
        uc ucVarC = this.aj.c();
        return ucVarC.hs() + ucVarC.nw();
    }

    public int g() {
        uc ucVarC = this.aj.c();
        return ucVarC.i() + ucVarC.r();
    }

    public float ho() {
        uc ucVarC = this.aj.c();
        return m() + ucVarC.ho() + ucVarC.nt() + (ucVarC.k() * 2.0f);
    }

    public float nt() {
        uc ucVarC = this.aj.c();
        return g() + ucVarC.yb() + ucVarC.g() + (ucVarC.k() * 2.0f);
    }

    public void hw(List<List<zo>> list) {
        this.k = list;
    }

    public List<List<zo>> yb() {
        return this.k;
    }

    public boolean lb() {
        List<zo> list = this.vk;
        if (list == null || list.size() <= 0) {
            return true;
        }
        return false;
    }

    public boolean qa() {
        return this.g;
    }

    public void pr(boolean z) {
        this.g = z;
    }

    public Map<String, String> a() {
        return this.ho;
    }

    public void pr(String str, String str2) {
        this.ho.put(str, str2);
    }

    public void cz() {
        List<List<zo>> list = this.k;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<zo> list2 : this.k) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.k = arrayList;
    }

    public boolean ny() {
        return TextUtils.equals(this.aj.c().ve(), "flex");
    }

    public String fo() {
        return this.aj.c().fo();
    }

    public void hn(String str) {
        this.aj.c().uc(str);
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.pr + "', x=" + this.hw + ", y=" + this.hn + ", width=" + this.uc + ", height=" + this.fw + ", remainWidth=" + this.zo + ", rootBrick=" + this.aj + ", childrenBrickUnits=" + this.vk + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean rc() {
        return this.aj.c().j() < 0 || this.aj.c().qo() < 0 || this.aj.c().iy() < 0 || this.aj.c().cr() < 0;
    }

    public String pr(int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.aj.getType());
        sb.append(":");
        sb.append(this.pr);
        if (this.aj.c() != null) {
            sb.append(":");
            sb.append(this.aj.c().xb());
        }
        sb.append(":");
        sb.append(i);
        if (this.aj.c() != null) {
            sb.append(":");
            switch (this.aj.c().ls()) {
                case "9":
                case "16":
                case "29":
                    i2 = 1;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            switch (this.aj.c().ls()) {
                case "17":
                case "18":
                    i2 = (i2 * 10) + 2;
                    break;
            }
            switch (this.aj.c().ls()) {
                case "0":
                case "5":
                case "10":
                case "12":
                case "13":
                case "24":
                case "29":
                case "20":
                case "22":
                    i2 = (i2 * 10) + 3;
                    break;
            }
            sb.append(i2);
        }
        return sb.toString();
    }
}
