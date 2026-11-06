package com.bytedance.sdk.component.adexpress.ms.ah;

import android.text.TextUtils;
import android.util.Pair;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private String ah;
    private Map<String, ms> c = new ConcurrentHashMap();
    private List<C0231ms> d;
    private xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f889ms;
    private String xr;

    public Map<String, ms> ms() {
        return this.c;
    }

    public String xr() {
        return this.f889ms;
    }

    public void ms(String str) {
        this.f889ms = str;
    }

    public String ah() {
        return this.xr;
    }

    public void xr(String str) {
        this.xr = str;
    }

    public String d() {
        return this.ah;
    }

    public void ah(String str) {
        this.ah = str;
    }

    public void ms(xr xrVar) {
        this.ka = xrVar;
    }

    public xr ka() {
        return this.ka;
    }

    public List<C0231ms> getResources() {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        return this.d;
    }

    public void ms(List<C0231ms> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.d = list;
    }

    public boolean c() {
        return (TextUtils.isEmpty(d()) || TextUtils.isEmpty(ah()) || TextUtils.isEmpty(xr())) ? false : true;
    }

    public JSONObject ab() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(Common.System.NAME, xr());
            jSONObject.putOpt("version", ah());
            jSONObject.putOpt("main", d());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0231ms c0231ms : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0231ms.ms());
                    jSONObject2.putOpt("md5", c0231ms.xr());
                    jSONObject2.putOpt("level", Integer.valueOf(c0231ms.ah()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.c.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.c.keySet()) {
                    ms msVar = this.c.get(str);
                    if (msVar != null) {
                        jSONObject3.put(str, msVar.ab());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            xr xrVarKa = ka();
            if (xrVarKa != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", xrVarKa.f891ms);
                jSONObject4.put("md5", xrVarKa.xr);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listXr = xrVarKa.xr();
                if (listXr != null) {
                    for (Pair<String, String> pair : listXr) {
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

    public String x() {
        JSONObject jSONObjectAb;
        if (!c() || (jSONObjectAb = ab()) == null) {
            return null;
        }
        return jSONObjectAb.toString();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.ms.ah.ms$ms, reason: collision with other inner class name */
    public static class C0231ms {
        private int ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f890ms;
        private String xr;

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0231ms) {
                String str2 = this.f890ms;
                if (str2 != null) {
                    C0231ms c0231ms = (C0231ms) obj;
                    if (str2.equals(c0231ms.ms()) && (str = this.xr) != null && str.equals(c0231ms.xr())) {
                        return true;
                    }
                }
                return false;
            }
            return super.equals(obj);
        }

        public String ms() {
            return this.f890ms;
        }

        public void ms(String str) {
            this.f890ms = str;
        }

        public String xr() {
            return this.xr;
        }

        public void xr(String str) {
            this.xr = str;
        }

        public int ah() {
            return this.ah;
        }

        public void ms(int i) {
            this.ah = i;
        }
    }

    public static class xr {
        private List<Pair<String, String>> ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f891ms;
        private String xr;

        public String ms() {
            return this.f891ms;
        }

        public void ms(String str) {
            this.f891ms = str;
        }

        public void xr(String str) {
            this.xr = str;
        }

        public void ms(List<Pair<String, String>> list) {
            this.ah = list;
        }

        public List<Pair<String, String>> xr() {
            return this.ah;
        }
    }

    public static ms d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return ms(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static ms ms(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        ms msVar = new ms();
        msVar.ms(jSONObject.optString(Common.System.NAME));
        msVar.xr(jSONObject.optString("version"));
        msVar.ah(jSONObject.optString("main"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0231ms c0231ms = new C0231ms();
                c0231ms.ms(jSONObjectOptJSONObject2.optString("url"));
                c0231ms.xr(jSONObjectOptJSONObject2.optString("md5"));
                c0231ms.ms(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0231ms);
            }
        }
        msVar.ms(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    ms msVarMs = ms(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (msVarMs != null) {
                        msVar.ms().put(next, msVarMs);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            xr xrVar = new xr();
            xrVar.ms(jSONObjectOptJSONObject.optString("url"));
            xrVar.xr(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                xrVar.ms(arrayList2);
            }
            msVar.ms(xrVar);
        }
        if (msVar.c()) {
            return msVar;
        }
        return null;
    }
}
