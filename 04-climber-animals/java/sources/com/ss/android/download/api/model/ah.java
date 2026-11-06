package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.anythink.core.common.e.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.downloadlib.addownload.hi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ah {
    private final long ab;
    private final String ah;
    private final JSONObject ao;
    private final String c;
    private final List<String> ch;
    private final boolean d;
    private final int hi;
    private final long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f4323ms;
    private final JSONObject ny;
    private final Object sl;
    private final boolean u;
    private final String ub;
    private final JSONObject x;
    private final String xr;
    private final String zb;

    ah(ms msVar) {
        this.f4323ms = msVar.f4324ms;
        this.xr = msVar.xr;
        this.ah = msVar.ah;
        this.d = msVar.d;
        this.ka = msVar.ka;
        this.c = msVar.c;
        this.ab = msVar.ab;
        this.x = msVar.x;
        this.ny = msVar.ny;
        this.ch = msVar.hi;
        this.hi = msVar.sl;
        this.sl = msVar.zb;
        this.u = msVar.ub;
        this.ub = msVar.ao;
        this.ao = msVar.h;
        this.zb = msVar.u;
    }

    public static class ms {
        private long ab;
        private String ah;
        private String ao;
        private String c;
        private Map<String, Object> ch;
        private JSONObject h;
        private List<String> hi;
        private long ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f4324ms;
        private JSONObject ny;
        private int sl;
        private String u;
        private JSONObject x;
        private String xr;
        private Object zb;
        private boolean d = false;
        private boolean ub = false;

        public ms ms(boolean z) {
            this.ub = z;
            return this;
        }

        public ms ms(String str) {
            this.xr = str;
            return this;
        }

        public ms xr(String str) {
            this.ah = str;
            return this;
        }

        public ms ms(long j) {
            this.ka = j;
            return this;
        }

        public ms xr(long j) {
            this.ab = j;
            return this;
        }

        public ms ah(String str) {
            this.c = str;
            return this;
        }

        public ms xr(boolean z) {
            this.d = z;
            return this;
        }

        public ms ms(JSONObject jSONObject) {
            this.x = jSONObject;
            return this;
        }

        public ms xr(JSONObject jSONObject) {
            this.ny = jSONObject;
            return this;
        }

        public ms ms(List<String> list) {
            this.hi = list;
            return this;
        }

        public ms ms(int i) {
            this.sl = i;
            return this;
        }

        public ms ms(Object obj) {
            this.zb = obj;
            return this;
        }

        public ms d(String str) {
            this.u = str;
            return this;
        }

        public ah ms() {
            if (TextUtils.isEmpty(this.f4324ms)) {
                this.f4324ms = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.x == null) {
                this.x = new JSONObject();
            }
            try {
                Map<String, Object> map = this.ch;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.ch.entrySet()) {
                        if (!this.x.has(entry.getKey())) {
                            this.x.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.ub) {
                    this.ao = this.ah;
                    JSONObject jSONObject2 = new JSONObject();
                    this.h = jSONObject2;
                    if (this.d) {
                        jSONObject2.put("ad_extra_data", this.x.toString());
                    } else {
                        Iterator<String> itKeys = this.x.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.h.put(next, this.x.get(next));
                        }
                    }
                    this.h.put("category", this.f4324ms);
                    this.h.put(TTDownloadField.TT_TAG, this.xr);
                    this.h.put(f.a.d, this.ka);
                    this.h.put("ext_value", this.ab);
                    if (!TextUtils.isEmpty(this.u)) {
                        this.h.put(TTDownloadField.TT_REFER, this.u);
                    }
                    JSONObject jSONObject3 = this.ny;
                    if (jSONObject3 != null) {
                        this.h = com.ss.android.download.api.ah.xr.ms(jSONObject3, this.h);
                    }
                    if (this.d) {
                        if (!this.h.has("log_extra") && !TextUtils.isEmpty(this.c)) {
                            this.h.put("log_extra", this.c);
                        }
                        this.h.put("is_ad_event", "1");
                    }
                }
                if (this.d) {
                    jSONObject.put("ad_extra_data", this.x.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.c)) {
                        jSONObject.put("log_extra", this.c);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.x);
                }
                if (!TextUtils.isEmpty(this.u)) {
                    jSONObject.putOpt(TTDownloadField.TT_REFER, this.u);
                }
                JSONObject jSONObject4 = this.ny;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.ah.xr.ms(jSONObject4, jSONObject);
                }
                this.x = jSONObject;
            } catch (Exception e) {
                hi.t().ms(e, "DownloadEventModel build");
            }
            return new ah(this);
        }
    }

    public String ms() {
        return this.f4323ms;
    }

    public String xr() {
        return this.xr;
    }

    public String ah() {
        return this.ah;
    }

    public boolean d() {
        return this.d;
    }

    public long ka() {
        return this.ka;
    }

    public String c() {
        return this.c;
    }

    public long ab() {
        return this.ab;
    }

    public JSONObject x() {
        return this.x;
    }

    public JSONObject ny() {
        return this.ny;
    }

    public List<String> ch() {
        return this.ch;
    }

    public int hi() {
        return this.hi;
    }

    public Object sl() {
        return this.sl;
    }

    public boolean zb() {
        return this.u;
    }

    public String u() {
        return this.ub;
    }

    public JSONObject ub() {
        return this.ao;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("category: ").append(this.f4323ms).append("\ttag: ").append(this.xr).append("\tlabel: ").append(this.ah).append("\nisAd: ").append(this.d).append("\tadId: ").append(this.ka).append("\tlogExtra: ").append(this.c).append("\textValue: ").append(this.ab).append("\nextJson: ").append(this.x).append("\nparamsJson: ").append(this.ny).append("\nclickTrackUrl: ");
        List<String> list = this.ch;
        StringBuilder sbAppend2 = sbAppend.append(list != null ? list.toString() : "").append("\teventSource: ").append(this.hi).append("\textraObject: ");
        Object obj = this.sl;
        StringBuilder sbAppend3 = sbAppend2.append(obj != null ? obj.toString() : "").append("\nisV3: ").append(this.u).append("\tV3EventName: ").append(this.ub).append("\tV3EventParams: ");
        JSONObject jSONObject = this.ao;
        return sbAppend3.append(jSONObject != null ? jSONObject.toString() : "").toString();
    }
}
