package com.byazt.re;

import com.mar.sdk.MARCode;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1999, 37})
public class pr {
    public int c;
    public String hn;
    public String hw;
    public String pr;
    public int uc;
    public boolean x;
    public final Map<String, String> fw = new HashMap();
    public List<C0175pr> zo = new ArrayList();
    public final List<C0175pr> aj = new ArrayList();
    public final List<C0175pr> vk = new ArrayList();

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

    public int c() {
        return this.c;
    }

    public Map<String, String> uc() {
        return this.fw;
    }

    public List<C0175pr> fw() {
        return this.zo;
    }

    public pr(JSONObject jSONObject) {
        pr(jSONObject);
    }

    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.pr = jSONObject.optString(Common.System.NAME);
        this.uc = jSONObject.optInt(Constants.INDEX_FIELD);
        this.hw = jSONObject.optString("scheme");
        this.hn = jSONObject.optString("condition");
        this.x = jSONObject.optBoolean("enableCondition");
        this.c = jSONObject.optInt("priority", Integer.MAX_VALUE);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.fw.put(next, jSONObjectOptJSONObject.optString(next));
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("next");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    this.zo.add(new C0175pr(jSONObjectOptJSONObject2.optString(Common.System.NAME), jSONObjectOptJSONObject2.optString("condition")));
                }
            }
        } else {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("next");
            if (jSONObjectOptJSONObject3 != null) {
                this.zo.add(new C0175pr(jSONObjectOptJSONObject3.optString(Common.System.NAME), jSONObjectOptJSONObject3.optString("condition")));
            }
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("callback");
        if (jSONObjectOptJSONObject4 == null) {
            jSONObjectOptJSONObject4 = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray(TrackAction.SUCCESS);
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = new JSONArray();
        }
        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
            if (jSONObjectOptJSONObject5 != null) {
                this.aj.add(new C0175pr(jSONObjectOptJSONObject5.optString(Common.System.NAME), jSONObjectOptJSONObject5.optString("condition")));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray(TrackAction.FAIL);
        if (jSONArrayOptJSONArray3 == null) {
            jSONArrayOptJSONArray3 = new JSONArray();
        }
        for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i3);
            if (jSONObjectOptJSONObject6 != null) {
                this.vk.add(new C0175pr(jSONObjectOptJSONObject6.optString(Common.System.NAME), jSONObjectOptJSONObject6.optString("condition")));
            }
        }
    }

    public List<C0175pr> zo() {
        return this.aj;
    }

    public List<C0175pr> aj() {
        return this.vk;
    }

    /* JADX INFO: renamed from: com.byazt.re.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1999, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0175pr {
        public String hw;
        public String pr;

        public String pr() {
            return this.pr;
        }

        public String hw() {
            return this.hw;
        }

        public C0175pr(String str, String str2) {
            this.pr = str;
            this.hw = str2;
        }
    }
}
