package com.byazt.hfm;

import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 994, 37})
public class pr {
    public hw c;
    public String hn;
    public String hw;
    public String pr;
    public Map<String, pr> uc = new ConcurrentHashMap();
    public List<C0084pr> x;

    public Map<String, pr> pr() {
        return this.uc;
    }

    public String hw() {
        return this.pr;
    }

    public void pr(String str) {
        this.pr = str;
    }

    public String hn() {
        return this.hw;
    }

    public void hw(String str) {
        this.hw = str;
    }

    public String x() {
        return this.hn;
    }

    public void hn(String str) {
        this.hn = str;
    }

    public void pr(hw hwVar) {
        this.c = hwVar;
    }

    public hw c() {
        return this.c;
    }

    public List<C0084pr> getResources() {
        if (this.x == null) {
            this.x = new ArrayList();
        }
        return this.x;
    }

    public void pr(List<C0084pr> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.x = list;
    }

    public boolean uc() {
        return (TextUtils.isEmpty(x()) || TextUtils.isEmpty(hn()) || TextUtils.isEmpty(hw())) ? false : true;
    }

    public JSONObject fw() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(Common.System.NAME, hw());
            jSONObject.putOpt("version", hn());
            jSONObject.putOpt("main", x());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0084pr c0084pr : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt(BreakpointSQLiteKey.URL, c0084pr.pr());
                    jSONObject2.putOpt("md5", c0084pr.hw());
                    jSONObject2.putOpt("level", Integer.valueOf(c0084pr.hn()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.uc.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.uc.keySet()) {
                    pr prVar = this.uc.get(str);
                    if (prVar != null) {
                        jSONObject3.put(str, prVar.fw());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            hw hwVarC = c();
            if (hwVarC != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(BreakpointSQLiteKey.URL, hwVarC.pr);
                jSONObject4.put("md5", hwVarC.hw);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listHw = hwVarC.hw();
                if (listHw != null) {
                    for (Pair<String, String> pair : listHw) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    public String zo() {
        JSONObject jSONObjectFw;
        if (uc() && (jSONObjectFw = fw()) != null) {
            return jSONObjectFw.toString();
        }
        return null;
    }

    /* JADX INFO: renamed from: com.byazt.hfm.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 994, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0084pr {
        public int hn;
        public String hw;
        public String pr;

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0084pr) {
                String str2 = this.pr;
                if (str2 != null) {
                    C0084pr c0084pr = (C0084pr) obj;
                    return str2.equals(c0084pr.pr()) && (str = this.hw) != null && str.equals(c0084pr.hw());
                }
                return false;
            }
            return super.equals(obj);
        }

        public String pr() {
            return this.pr;
        }

        public void pr(String str) {
            this.pr = str;
        }

        public String hw() {
            return this.hw;
        }

        public void hw(String str) {
            this.hw = str;
        }

        public int hn() {
            return this.hn;
        }

        public void pr(int i) {
            this.hn = i;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 994, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    public static class hw {
        public List<Pair<String, String>> hn;
        public String hw;
        public String pr;

        public String pr() {
            return this.pr;
        }

        public void pr(String str) {
            this.pr = str;
        }

        public void hw(String str) {
            this.hw = str;
        }

        public void pr(List<Pair<String, String>> list) {
            this.hn = list;
        }

        public List<Pair<String, String>> hw() {
            return this.hn;
        }
    }

    public static pr x(String str) {
        if (str == null) {
            return null;
        }
        try {
            return pr(new JSONObject(str));
        } catch (Exception e) {
            return null;
        }
    }

    public static pr pr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        pr prVar = new pr();
        prVar.pr(jSONObject.optString(Common.System.NAME));
        prVar.hw(jSONObject.optString("version"));
        prVar.hn(jSONObject.optString("main"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0084pr c0084pr = new C0084pr();
                c0084pr.pr(jSONObjectOptJSONObject2.optString(BreakpointSQLiteKey.URL));
                c0084pr.hw(jSONObjectOptJSONObject2.optString("md5"));
                c0084pr.pr(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0084pr);
            }
        }
        prVar.pr(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    pr prVarPr = pr(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (prVarPr != null) {
                        prVar.pr().put(next, prVarPr);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            hw hwVar = new hw();
            hwVar.pr(jSONObjectOptJSONObject.optString(BreakpointSQLiteKey.URL));
            hwVar.hw(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                hwVar.pr(arrayList2);
            }
            prVar.pr(hwVar);
        }
        if (!prVar.uc()) {
            return null;
        }
        return prVar;
    }
}
