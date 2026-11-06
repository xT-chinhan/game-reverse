package com.byazt.os;

import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.byazt.ho.BaseConstants;
import com.byazt.ug.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 634, 8})
public class s {
    public final int cp;
    public final JSONObject cy;
    public final Object d;
    public final JSONObject fs;
    public final String k;
    public final long l;
    public String n;
    public final String oa;
    public final boolean q;
    public final String qg;
    public final JSONObject rv;
    public final String s;
    public final boolean sz;
    public final List<String> tj;
    public final String w;
    public final long x;

    public s(n nVar) {
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        this.q = nVar.q;
        this.l = nVar.l;
        this.w = nVar.w;
        this.x = nVar.x;
        this.fs = nVar.fs;
        this.rv = nVar.rv;
        this.tj = nVar.cp;
        this.cp = nVar.d;
        this.d = nVar.oa;
        this.sz = nVar.k;
        this.k = nVar.cy;
        this.cy = nVar.hd;
        this.oa = nVar.sz;
    }

    @com.byazt.cp.n(n = {0, 1, 634, 546})
    public static class n {
        public List<String> cp;
        public String cy;
        public int d;
        public JSONObject fs;
        public JSONObject hd;
        public long l;
        public String n;
        public Object oa;
        public String qg;
        public JSONObject rv;
        public String s;
        public String sz;
        public Map<String, Object> tj;
        public String w;
        public long x;
        public boolean q = false;
        public boolean k = false;

        public n n(boolean z) {
            this.k = z;
            return this;
        }

        public n n(String str) {
            this.qg = str;
            return this;
        }

        public n qg(String str) {
            this.s = str;
            return this;
        }

        public n n(long j) {
            this.l = j;
            return this;
        }

        public n qg(long j) {
            this.x = j;
            return this;
        }

        public n s(String str) {
            this.w = str;
            return this;
        }

        public n qg(boolean z) {
            this.q = z;
            return this;
        }

        public n n(JSONObject jSONObject) {
            this.fs = jSONObject;
            return this;
        }

        public n qg(JSONObject jSONObject) {
            this.rv = jSONObject;
            return this;
        }

        public n n(List<String> list) {
            this.cp = list;
            return this;
        }

        public n n(int i) {
            this.d = i;
            return this;
        }

        public n n(Object obj) {
            this.oa = obj;
            return this;
        }

        public n q(String str) {
            this.sz = str;
            return this;
        }

        public s n() {
            if (TextUtils.isEmpty(this.n)) {
                this.n = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.fs == null) {
                this.fs = new JSONObject();
            }
            try {
                Map<String, Object> map = this.tj;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.tj.entrySet()) {
                        if (!this.fs.has(entry.getKey())) {
                            this.fs.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.k) {
                    this.cy = this.s;
                    JSONObject jSONObject2 = new JSONObject();
                    this.hd = jSONObject2;
                    if (this.q) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.fs.toString());
                    } else {
                        Iterator<String> itKeys = this.fs.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.hd.put(next, this.fs.get(next));
                        }
                    }
                    this.hd.put("category", this.n);
                    this.hd.put("tag", this.qg);
                    this.hd.put(e.a.d, this.l);
                    this.hd.put("ext_value", this.x);
                    if (!TextUtils.isEmpty(this.sz)) {
                        this.hd.put("refer", this.sz);
                    }
                    JSONObject jSONObject3 = this.rv;
                    if (jSONObject3 != null) {
                        this.hd = com.byazt.es.qg.n(jSONObject3, this.hd);
                    }
                    if (this.q) {
                        if (!this.hd.has("log_extra") && !TextUtils.isEmpty(this.w)) {
                            this.hd.put("log_extra", this.w);
                        }
                        this.hd.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.q) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.fs.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.w)) {
                        jSONObject.put("log_extra", this.w);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.fs);
                }
                if (!TextUtils.isEmpty(this.sz)) {
                    jSONObject.putOpt("refer", this.sz);
                }
                JSONObject jSONObject4 = this.rv;
                if (jSONObject4 != null) {
                    jSONObject = com.byazt.es.qg.n(jSONObject4, jSONObject);
                }
                this.fs = jSONObject;
            } catch (Exception e) {
                d.a().n(e, "DownloadEventModel build");
            }
            return new s(this);
        }
    }

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public String s() {
        return this.s;
    }

    public boolean q() {
        return this.q;
    }

    public long l() {
        return this.l;
    }

    public String w() {
        return this.w;
    }

    public long x() {
        return this.x;
    }

    public JSONObject fs() {
        return this.fs;
    }

    public JSONObject rv() {
        return this.rv;
    }

    public List<String> tj() {
        return this.tj;
    }

    public int cp() {
        return this.cp;
    }

    public Object d() {
        return this.d;
    }

    public boolean oa() {
        return this.sz;
    }

    public String sz() {
        return this.k;
    }

    public JSONObject k() {
        return this.cy;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("category: ").append(this.n).append("\ttag: ").append(this.qg).append("\tlabel: ").append(this.s).append("\nisAd: ").append(this.q).append("\tadId: ").append(this.l).append("\tlogExtra: ").append(this.w).append("\textValue: ").append(this.x).append("\nextJson: ").append(this.fs).append("\nparamsJson: ").append(this.rv).append("\nclickTrackUrl: ");
        List<String> list = this.tj;
        StringBuilder sbAppend2 = sbAppend.append(list != null ? list.toString() : "").append("\teventSource: ").append(this.cp).append("\textraObject: ");
        Object obj = this.d;
        StringBuilder sbAppend3 = sbAppend2.append(obj != null ? obj.toString() : "").append("\nisV3: ").append(this.sz).append("\tV3EventName: ").append(this.k).append("\tV3EventParams: ");
        JSONObject jSONObject = this.cy;
        return sbAppend3.append(jSONObject != null ? jSONObject.toString() : "").toString();
    }
}
