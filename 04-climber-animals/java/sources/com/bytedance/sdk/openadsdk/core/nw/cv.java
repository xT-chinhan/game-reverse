package com.bytedance.sdk.openadsdk.core.nw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cv {
    private static final List<ah> xr = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static boolean f3041ms = false;

    public interface ms {
        void ms(ah ahVar);

        void xr(ah ahVar);
    }

    public static void ms(JSONObject jSONObject, ms msVar) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.lm.ms().ms(msVar);
        f3041ms = jSONObject.optBoolean("h5_cache_resources_enable", false);
        xr(jSONObject, msVar);
    }

    public static List<ah> ms() {
        return xr;
    }

    private static void xr(JSONObject jSONObject, final ms msVar) {
        if (f3041ms) {
            final ArrayList arrayList = new ArrayList();
            String str = "h5_cache_resources";
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("h5_cache_resources");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new ah(jSONObjectOptJSONObject));
                    }
                }
            }
            com.bytedance.sdk.openadsdk.op.ab.ms(new com.bytedance.sdk.component.ch.ny(str) { // from class: com.bytedance.sdk.openadsdk.core.nw.cv.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.jw.lm.ms().ms(arrayList, msVar);
                }
            });
        }
    }

    public static void ms(com.bytedance.sdk.component.d.ms.xr xrVar) {
        try {
            f3041ms = xrVar.xr("h5_cache_resources_enable", false);
            JSONArray jSONArray = new JSONArray(xrVar.xr("h5_cache_resources", ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    xr.add(new ah(jSONObjectOptJSONObject));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void xr(com.bytedance.sdk.component.d.ms.xr xrVar) {
        xrVar.ms("h5_cache_resources_enable", f3041ms);
    }

    public static synchronized void ms(com.bytedance.sdk.component.d.ms.xr xrVar, ah ahVar) {
        List<ah> list = xr;
        list.add(ahVar);
        JSONArray jSONArray = new JSONArray();
        Iterator<ah> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().ka());
        }
        xrVar.ms("h5_cache_resources", jSONArray.toString());
    }

    public static synchronized void xr(com.bytedance.sdk.component.d.ms.xr xrVar, ah ahVar) {
        List<ah> list = xr;
        list.remove(ahVar);
        JSONArray jSONArray = new JSONArray();
        Iterator<ah> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().ka());
        }
        xrVar.ms("h5_cache_resources", jSONArray.toString());
    }

    public static class ah {
        private final List<d> ah = new ArrayList();

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final String f3043ms;
        private final String xr;

        public ah(JSONObject jSONObject) {
            this.f3043ms = jSONObject.optString("channel");
            this.xr = jSONObject.optString("prefix");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resource");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.ah.add(new d(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public String ms() {
            return this.f3043ms;
        }

        public String xr() {
            return this.xr;
        }

        public d ah() {
            if (this.ah.isEmpty()) {
                return null;
            }
            return this.ah.get(0);
        }

        public String d() {
            String str = this.f3043ms;
            return ah() != null ? str + "$" + com.bytedance.sdk.component.utils.ka.xr(ah().xr()) : str;
        }

        public List<d> getResources() {
            return this.ah;
        }

        public JSONObject ka() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel", this.f3043ms);
                jSONObject.put("prefix", this.xr);
                JSONArray jSONArray = new JSONArray();
                Iterator<d> it = this.ah.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().d());
                }
                jSONObject.put("resource", jSONArray);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
            return jSONObject;
        }
    }

    public static class d {
        private final List<xr> ah = new ArrayList();

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final String f3044ms;
        private final String xr;

        public d(JSONObject jSONObject) {
            this.f3044ms = jSONObject.optString("resource_url");
            this.xr = jSONObject.optString("content_hash");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("channel_resource_list");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.ah.add(new xr(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public String ms() {
            return this.f3044ms;
        }

        public String xr() {
            return this.xr;
        }

        public List<xr> ah() {
            return this.ah;
        }

        public JSONObject d() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resource_url", this.f3044ms);
                jSONObject.put("content_hash", this.xr);
                JSONArray jSONArray = new JSONArray();
                Iterator<xr> it = this.ah.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().ah());
                }
                jSONObject.put("channel_resource_list", jSONArray);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
            return jSONObject;
        }
    }

    public static class xr {
        private final String ah;
        private final String c;
        private final String d;
        private final String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final long f3045ms;
        private final String xr;

        public xr(JSONObject jSONObject) {
            this.f3045ms = jSONObject.optLong("size", 0L);
            this.xr = jSONObject.optString("md5");
            this.ah = jSONObject.optString("content_hash");
            this.d = jSONObject.optString("url");
            this.ka = jSONObject.optString("mime_type");
            this.c = jSONObject.optString("file_name");
        }

        public String ms() {
            return this.ka;
        }

        public String xr() {
            return this.c;
        }

        public JSONObject ah() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("size", this.f3045ms);
                jSONObject.put("md5", this.xr);
                jSONObject.put("content_hash", this.ah);
                jSONObject.put("mime_type", this.ka);
                jSONObject.put("file_name", this.c);
                jSONObject.put("url", this.d);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
            return jSONObject;
        }
    }
}
