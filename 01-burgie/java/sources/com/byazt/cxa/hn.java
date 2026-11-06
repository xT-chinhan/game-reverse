package com.byazt.cxa;

import android.text.TextUtils;
import com.byazt.eld.k;
import com.byazt.fi.BaseConstants;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 228, 20})
public class hn {
    public final JSONObject aj;
    public final long c;
    public final long fw;
    public final boolean g;
    public final String hn;
    public final String ho;
    public final String hw;
    public final Object k;
    public final String m;
    public final JSONObject nt;
    public String pr;
    public final String uc;
    public final List<String> vk;
    public final int w;
    public final boolean x;
    public final JSONObject zo;

    public hn(pr prVar) {
        this.pr = prVar.pr;
        this.hw = prVar.hw;
        this.hn = prVar.hn;
        this.x = prVar.x;
        this.c = prVar.c;
        this.uc = prVar.uc;
        this.fw = prVar.fw;
        this.zo = prVar.zo;
        this.aj = prVar.aj;
        this.vk = prVar.w;
        this.w = prVar.k;
        this.k = prVar.m;
        this.g = prVar.ho;
        this.ho = prVar.nt;
        this.nt = prVar.yb;
        this.m = prVar.g;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 228, 116})
    public static class pr {
        public JSONObject aj;
        public long c;
        public long fw;
        public String g;
        public String hn;
        public String hw;
        public int k;
        public Object m;
        public String nt;
        public String pr;
        public String uc;
        public Map<String, Object> vk;
        public List<String> w;
        public JSONObject yb;
        public JSONObject zo;
        public boolean x = false;
        public boolean ho = false;

        public pr pr(boolean z) {
            this.ho = z;
            return this;
        }

        public pr pr(String str) {
            this.hw = str;
            return this;
        }

        public pr hw(String str) {
            this.hn = str;
            return this;
        }

        public pr pr(long j) {
            this.c = j;
            return this;
        }

        public pr hw(long j) {
            this.fw = j;
            return this;
        }

        public pr hn(String str) {
            this.uc = str;
            return this;
        }

        public pr hw(boolean z) {
            this.x = z;
            return this;
        }

        public pr pr(JSONObject jSONObject) {
            this.zo = jSONObject;
            return this;
        }

        public pr hw(JSONObject jSONObject) {
            this.aj = jSONObject;
            return this;
        }

        public pr pr(List<String> list) {
            this.w = list;
            return this;
        }

        public pr pr(int i) {
            this.k = i;
            return this;
        }

        public pr pr(Object obj) {
            this.m = obj;
            return this;
        }

        public pr x(String str) {
            this.g = str;
            return this;
        }

        public hn pr() {
            if (TextUtils.isEmpty(this.pr)) {
                this.pr = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.zo == null) {
                this.zo = new JSONObject();
            }
            try {
                Map<String, Object> map = this.vk;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.vk.entrySet()) {
                        if (!this.zo.has(entry.getKey())) {
                            this.zo.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.ho) {
                    this.nt = this.hn;
                    JSONObject jSONObject2 = new JSONObject();
                    this.yb = jSONObject2;
                    if (this.x) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.zo.toString());
                    } else {
                        Iterator<String> itKeys = this.zo.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.yb.put(next, this.zo.get(next));
                        }
                    }
                    this.yb.put("category", this.pr);
                    this.yb.put("tag", this.hw);
                    this.yb.put(Constants.VALUE_FIELD, this.c);
                    this.yb.put("ext_value", this.fw);
                    if (!TextUtils.isEmpty(this.g)) {
                        this.yb.put("refer", this.g);
                    }
                    JSONObject jSONObject3 = this.aj;
                    if (jSONObject3 != null) {
                        this.yb = com.byazt.snv.hw.pr(jSONObject3, this.yb);
                    }
                    if (this.x) {
                        if (!this.yb.has("log_extra") && !TextUtils.isEmpty(this.uc)) {
                            this.yb.put("log_extra", this.uc);
                        }
                        this.yb.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.x) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.zo.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.uc)) {
                        jSONObject.put("log_extra", this.uc);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.zo);
                }
                if (!TextUtils.isEmpty(this.g)) {
                    jSONObject.putOpt("refer", this.g);
                }
                JSONObject jSONObject4 = this.aj;
                if (jSONObject4 != null) {
                    jSONObject = com.byazt.snv.hw.pr(jSONObject4, jSONObject);
                }
                this.zo = jSONObject;
            } catch (Exception e) {
                k.a().pr(e, "DownloadEventModel build");
            }
            return new hn(this);
        }
    }

    public String pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public String hn() {
        return this.hn;
    }

    public boolean x() {
        return this.x;
    }

    public long c() {
        return this.c;
    }

    public String uc() {
        return this.uc;
    }

    public long fw() {
        return this.fw;
    }

    public JSONObject zo() {
        return this.zo;
    }

    public JSONObject aj() {
        return this.aj;
    }

    public List<String> vk() {
        return this.vk;
    }

    public int w() {
        return this.w;
    }

    public Object k() {
        return this.k;
    }

    public boolean m() {
        return this.g;
    }

    public String g() {
        return this.ho;
    }

    public JSONObject ho() {
        return this.nt;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("category: ").append(this.pr).append("\ttag: ").append(this.hw).append("\tlabel: ").append(this.hn).append("\nisAd: ").append(this.x).append("\tadId: ").append(this.c).append("\tlogExtra: ").append(this.uc).append("\textValue: ").append(this.fw).append("\nextJson: ").append(this.zo).append("\nparamsJson: ").append(this.aj).append("\nclickTrackUrl: ");
        List<String> list = this.vk;
        StringBuilder sbAppend2 = sbAppend.append(list != null ? list.toString() : "").append("\teventSource: ").append(this.w).append("\textraObject: ");
        Object obj = this.k;
        StringBuilder sbAppend3 = sbAppend2.append(obj != null ? obj.toString() : "").append("\nisV3: ").append(this.g).append("\tV3EventName: ").append(this.ho).append("\tV3EventParams: ");
        JSONObject jSONObject = this.nt;
        return sbAppend3.append(jSONObject != null ? jSONObject.toString() : "").toString();
    }
}
