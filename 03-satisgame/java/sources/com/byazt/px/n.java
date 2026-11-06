package com.byazt.px;

import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1804, 19})
public class n {
    public qg l;
    public String n;
    public List<C0308n> q;
    public String qg;
    public String s;
    public Map<String, n> w = new ConcurrentHashMap();

    public Map<String, n> n() {
        return this.w;
    }

    public String qg() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public String s() {
        return this.qg;
    }

    public void qg(String str) {
        this.qg = str;
    }

    public String q() {
        return this.s;
    }

    public void s(String str) {
        this.s = str;
    }

    public void n(qg qgVar) {
        this.l = qgVar;
    }

    public qg l() {
        return this.l;
    }

    public List<C0308n> getResources() {
        if (this.q == null) {
            this.q = new ArrayList();
        }
        return this.q;
    }

    public void n(List<C0308n> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.q = list;
    }

    public boolean w() {
        return (TextUtils.isEmpty(q()) || TextUtils.isEmpty(s()) || TextUtils.isEmpty(qg())) ? false : true;
    }

    public JSONObject x() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(TapEventParamConstants.PARAM_NAME, qg());
            jSONObject.putOpt("version", s());
            jSONObject.putOpt("main", q());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0308n c0308n : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt(ImagesContract.URL, c0308n.n());
                    jSONObject2.putOpt("md5", c0308n.qg());
                    jSONObject2.putOpt("level", Integer.valueOf(c0308n.s()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.w.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.w.keySet()) {
                    n nVar = this.w.get(str);
                    if (nVar != null) {
                        jSONObject3.put(str, nVar.x());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            qg qgVarL = l();
            if (qgVarL != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(ImagesContract.URL, qgVarL.n);
                jSONObject4.put("md5", qgVarL.qg);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listQg = qgVarL.qg();
                if (listQg != null) {
                    for (Pair<String, String> pair : listQg) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String fs() {
        JSONObject jSONObjectX;
        if (!w() || (jSONObjectX = x()) == null) {
            return null;
        }
        return jSONObjectX.toString();
    }

    /* JADX INFO: renamed from: com.byazt.px.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1804, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0308n {
        public String n;
        public String qg;
        public int s;

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0308n) {
                String str2 = this.n;
                if (str2 != null) {
                    C0308n c0308n = (C0308n) obj;
                    if (str2.equals(c0308n.n()) && (str = this.qg) != null && str.equals(c0308n.qg())) {
                        return true;
                    }
                }
                return false;
            }
            return super.equals(obj);
        }

        public String n() {
            return this.n;
        }

        public void n(String str) {
            this.n = str;
        }

        public String qg() {
            return this.qg;
        }

        public void qg(String str) {
            this.qg = str;
        }

        public int s() {
            return this.s;
        }

        public void n(int i) {
            this.s = i;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1804, 226})
    public static class qg {
        public String n;
        public String qg;
        public List<Pair<String, String>> s;

        public String n() {
            return this.n;
        }

        public void n(String str) {
            this.n = str;
        }

        public void qg(String str) {
            this.qg = str;
        }

        public void n(List<Pair<String, String>> list) {
            this.s = list;
        }

        public List<Pair<String, String>> qg() {
            return this.s;
        }
    }

    public static n q(String str) {
        if (str == null) {
            return null;
        }
        try {
            return n(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static n n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        n nVar = new n();
        nVar.n(jSONObject.optString(TapEventParamConstants.PARAM_NAME));
        nVar.qg(jSONObject.optString("version"));
        nVar.s(jSONObject.optString("main"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0308n c0308n = new C0308n();
                c0308n.n(jSONObjectOptJSONObject2.optString(ImagesContract.URL));
                c0308n.qg(jSONObjectOptJSONObject2.optString("md5"));
                c0308n.n(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0308n);
            }
        }
        nVar.n(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    n nVarN = n(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (nVarN != null) {
                        nVar.n().put(next, nVarN);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            qg qgVar = new qg();
            qgVar.n(jSONObjectOptJSONObject.optString(ImagesContract.URL));
            qgVar.qg(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                qgVar.n(arrayList2);
            }
            nVar.n(qgVar);
        }
        if (nVar.w()) {
            return nVar;
        }
        return null;
    }
}
