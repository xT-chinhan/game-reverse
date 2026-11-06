package com.byazt.gct;

import androidx.core.view.PointerIconCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, PointerIconCompat.TYPE_ZOOM_IN})
public class ln {
    public static final Set<s> qg = new CopyOnWriteArraySet();
    public static boolean n = false;
    public static final Object s = new Object();

    public interface n {
        void n(s sVar);

        void qg(s sVar);
    }

    public static void n(JSONObject jSONObject, n nVar) {
        if (jSONObject == null) {
            return;
        }
        com.byazt.qq.s.n().n(nVar);
        n = jSONObject.optBoolean("h5_cache_resources_enable", false);
        qg(jSONObject, nVar);
    }

    public static Set<s> n() {
        return qg;
    }

    private static void qg(JSONObject jSONObject, final n nVar) {
        if (n) {
            final HashSet hashSet = new HashSet();
            String str = "h5_cache_resources";
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("h5_cache_resources");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        hashSet.add(new s(jSONObjectOptJSONObject));
                    }
                }
            }
            com.byazt.ag.qg.n(new com.byazt.qit.x(str) { // from class: com.byazt.gct.ln.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.qq.s.n().n(hashSet, nVar);
                }
            });
        }
    }

    public static void n(com.byazt.gwu.l lVar) {
        synchronized (s) {
            try {
                n = lVar.qg("h5_cache_resources_enable", false);
                JSONArray jSONArray = new JSONArray(lVar.qg("h5_cache_resources", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        qg.add(new s(jSONObjectOptJSONObject));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void qg(com.byazt.gwu.l lVar) {
        lVar.n("h5_cache_resources_enable", n);
    }

    public static void n(com.byazt.gwu.l lVar, s sVar) {
        synchronized (s) {
            qg.add(sVar);
            s(lVar);
        }
    }

    public static void qg(com.byazt.gwu.l lVar, s sVar) {
        synchronized (s) {
            qg.remove(sVar);
            s(lVar);
        }
    }

    private static void s(com.byazt.gwu.l lVar) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            Set<s> set = qg;
            jSONObject.put("res_length", set.size());
            JSONArray jSONArray2 = new JSONArray();
            for (s sVar : set) {
                jSONArray.put(sVar.l());
                jSONArray2.put(sVar.n + "$" + sVar.qg + "$" + (sVar.s() == null ? "" : sVar.s().n()));
            }
            jSONObject.put("res_infos", jSONArray2);
            com.byazt.eji.s.n().n("h5_resource_report", jSONObject);
            lVar.n("h5_cache_resources", jSONArray.toString());
        } catch (OutOfMemoryError e) {
            com.byazt.eji.s.n().n("h5_resource_oom", jSONObject, e);
        } catch (JSONException unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 2280})
    public static class s {
        public final String n;
        public final String qg;
        public final List<q> s = new ArrayList();

        public s(JSONObject jSONObject) {
            this.n = jSONObject.optString("channel");
            this.qg = jSONObject.optString("prefix");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resource");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.s.add(new q(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public String n() {
            return this.n;
        }

        public String qg() {
            return this.qg;
        }

        public q s() {
            if (this.s.isEmpty()) {
                return null;
            }
            return this.s.get(0);
        }

        public String q() {
            String str = this.n;
            return s() != null ? str + "$" + com.byazt.tk.l.qg(s().qg()) : str;
        }

        public List<q> getResources() {
            return this.s;
        }

        public JSONObject l() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel", this.n);
                jSONObject.put("prefix", this.qg);
                JSONArray jSONArray = new JSONArray();
                Iterator<q> it = this.s.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().q());
                }
                jSONObject.put("resource", jSONArray);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                s sVar = (s) obj;
                if (!Objects.equals(this.n, sVar.n) || !Objects.equals(this.qg, sVar.qg)) {
                    return false;
                }
                q qVarS = s();
                q qVarS2 = sVar.s();
                if (qVarS != null && qVarS2 != null) {
                    return Objects.equals(qVarS.n(), qVarS2.n()) && Objects.equals(qVarS.qg(), qVarS2.qg());
                }
                if (qVarS == qVarS2) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            String str = this.n;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.qg;
            int iHashCode2 = iHashCode + (str2 != null ? str2.hashCode() : 0);
            q qVarS = s();
            if (qVarS == null) {
                return iHashCode2;
            }
            String strN = qVarS.n();
            String strQg = qVarS.qg();
            return (((iHashCode2 * 31) + (strN != null ? strN.hashCode() : 0)) * 31) + (strQg != null ? strQg.hashCode() : 0);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 2281})
    public static class q {
        public final String n;
        public final String qg;
        public final List<qg> s = new ArrayList();

        public q(JSONObject jSONObject) {
            this.n = jSONObject.optString("resource_url");
            this.qg = jSONObject.optString("content_hash");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("channel_resource_list");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.s.add(new qg(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public String n() {
            return this.n;
        }

        public String qg() {
            return this.qg;
        }

        public List<qg> s() {
            return this.s;
        }

        public JSONObject q() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resource_url", this.n);
                jSONObject.put("content_hash", this.qg);
                JSONArray jSONArray = new JSONArray();
                Iterator<qg> it = this.s.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().s());
                }
                jSONObject.put("channel_resource_list", jSONArray);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 545})
    public static class qg {
        public final String l;
        public final long n;
        public final String q;
        public final String qg;
        public final String s;
        public final String w;

        public qg(JSONObject jSONObject) {
            this.n = jSONObject.optLong("size", 0L);
            this.qg = jSONObject.optString("md5");
            this.s = jSONObject.optString("content_hash");
            this.q = jSONObject.optString(ImagesContract.URL);
            this.l = jSONObject.optString("mime_type");
            this.w = jSONObject.optString("file_name");
        }

        public String n() {
            return this.l;
        }

        public String qg() {
            return this.w;
        }

        public JSONObject s() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("size", this.n);
                jSONObject.put("md5", this.qg);
                jSONObject.put("content_hash", this.s);
                jSONObject.put("mime_type", this.l);
                jSONObject.put("file_name", this.w);
                jSONObject.put(ImagesContract.URL, this.q);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }
}
