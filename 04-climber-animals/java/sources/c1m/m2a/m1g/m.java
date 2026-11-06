package c1m.m2a.m1g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m implements i {
    private static String h;
    private static Map<String, Object> i;
    private int a;
    private int b;
    private String c;
    private final Map<String, String> d;
    private final Map<String, String> e;
    private final Map<String, Object> f;
    private String g;

    public static class b {
        private m a;
        private boolean b;

        public b() {
            m mVar = new m();
            this.a = mVar;
            mVar.a("GET");
        }

        private String a(String str, Map<String, String> map) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }

        private void c() {
            Map<String, String> mapG = this.a.g();
            if (mapG == null || mapG.size() <= 0) {
                if (!"GET".equals(this.a.c()) || this.b) {
                    return;
                }
                m mVar = this.a;
                mVar.b(a(mVar.b(), m.l()));
                return;
            }
            if ("GET".equals(this.a.c()) && !this.b) {
                mapG.putAll(m.l());
            }
            m mVar2 = this.a;
            mVar2.b(a(mVar2.b(), mapG));
        }

        public i a() {
            Map<String, String> mapE = this.a.e();
            if (TextUtils.isEmpty(mapE.get("User-Agent"))) {
                mapE.put("User-Agent", m.m());
            }
            if ("POST".equals(this.a.c()) && TextUtils.isEmpty(mapE.get("Content-Type"))) {
                mapE.put("Content-Type", "application/json; charset=utf-8");
            }
            if ("POST".equals(this.a.c())) {
                this.a.a(m.k());
            }
            c();
            return this.a;
        }

        public b a(String str) {
            this.a.b(str);
            return this;
        }

        public b a(Map<String, Object> map) {
            this.a.a(map);
            return this;
        }

        public b b() {
            this.a.a("POST");
            this.a.a("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            return this;
        }
    }

    private m() {
        this.a = 10000;
        this.b = 10000;
        this.c = "GET";
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> k() {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> l() {
        Map<String, Object> map = i;
        if (map == null || map.size() <= 0) {
            return new HashMap();
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Object> entry : i.entrySet()) {
            if (entry.getValue() != null) {
                map2.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String m() {
        String str = h;
        if (str != null && str.length() > 0) {
            return h;
        }
        h = System.getProperty("http.agent");
        StringBuilder sb = new StringBuilder();
        String str2 = h;
        if (str2 != null) {
            int length = str2.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = h.charAt(i2);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                } else {
                    sb.append(cCharAt);
                }
            }
        }
        h = sb.toString();
        return sb.toString();
    }

    @Override // c1m.m2a.m1g.i
    public int a() {
        return this.b;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.d.put(str, str2);
    }

    public void a(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f.putAll(map);
    }

    @Override // c1m.m2a.m1g.i
    public String b() {
        return this.g;
    }

    public void b(String str) {
        this.g = str;
    }

    @Override // c1m.m2a.m1g.i
    public String c() {
        return this.c;
    }

    @Override // c1m.m2a.m1g.i
    public int d() {
        return this.a;
    }

    @Override // c1m.m2a.m1g.i
    public Map<String, String> e() {
        return this.d;
    }

    @Override // c1m.m2a.m1g.i
    public String f() {
        Map<String, Object> map;
        if (!"application/json; charset=utf-8".equals(this.d.get("Content-Type"))) {
            if (!"application/x-www-form-urlencoded; charset=utf-8".equals(this.d.get("Content-Type")) || (map = this.f) == null || map.size() <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : this.f.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }
        Map<String, Object> map2 = this.f;
        if (map2 == null || map2.size() <= 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry2 : this.f.entrySet()) {
            try {
                jSONObject.put(entry2.getKey(), entry2.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public Map<String, String> g() {
        return this.e;
    }
}
