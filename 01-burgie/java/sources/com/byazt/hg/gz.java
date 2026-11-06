package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
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
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 672})
public class gz {
    public static final Set<hn> hw = new CopyOnWriteArraySet();
    public static boolean pr = false;
    public static final Object hn = new Object();

    public interface pr {
        void hw(hn hnVar);

        void pr(hn hnVar);
    }

    public static void pr(JSONObject jSONObject, pr prVar) {
        if (jSONObject == null) {
            return;
        }
        com.byazt.wt.qn.pr().pr(prVar);
        pr = jSONObject.optBoolean("h5_cache_resources_enable", false);
        hw(jSONObject, prVar);
    }

    public static Set<hn> pr() {
        return hw;
    }

    private static void hw(JSONObject jSONObject, final pr prVar) {
        if (!pr) {
            return;
        }
        final HashSet hashSet = new HashSet();
        String str = "h5_cache_resources";
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("h5_cache_resources");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    hashSet.add(new hn(jSONObjectOptJSONObject));
                }
            }
        }
        com.byazt.zp.zo.pr(new com.byazt.xlm.fw(str) { // from class: com.byazt.hg.gz.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.wt.qn.pr().pr(hashSet, prVar);
            }
        });
    }

    public static void pr(com.byazt.zq.c cVar) {
        synchronized (hn) {
            try {
                pr = cVar.hw("h5_cache_resources_enable", false);
                JSONArray jSONArray = new JSONArray(cVar.hw("h5_cache_resources", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        hw.add(new hn(jSONObjectOptJSONObject));
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static void hw(com.byazt.zq.c cVar) {
        cVar.pr("h5_cache_resources_enable", pr);
    }

    public static void pr(com.byazt.zq.c cVar, hn hnVar) {
        synchronized (hn) {
            hw.add(hnVar);
            hn(cVar);
        }
    }

    public static void hw(com.byazt.zq.c cVar, hn hnVar) {
        synchronized (hn) {
            hw.remove(hnVar);
            hn(cVar);
        }
    }

    private static void hn(com.byazt.zq.c cVar) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            Set<hn> set = hw;
            jSONObject.put("res_length", set.size());
            JSONArray jSONArray2 = new JSONArray();
            for (hn hnVar : set) {
                jSONArray.put(hnVar.c());
                jSONArray2.put(hnVar.pr + "$" + hnVar.hw + "$" + (hnVar.hn() == null ? "" : hnVar.hn().pr()));
            }
            jSONObject.put("res_infos", jSONArray2);
            com.byazt.xk.hw.pr().pr("h5_resource_report", jSONObject);
            cVar.pr("h5_cache_resources", jSONArray.toString());
        } catch (OutOfMemoryError e) {
            com.byazt.xk.hw.pr().pr("h5_resource_oom", jSONObject, e);
        } catch (JSONException e2) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME})
    public static class hn {
        public final List<x> hn = new ArrayList();
        public final String hw;
        public final String pr;

        public hn(JSONObject jSONObject) {
            this.pr = jSONObject.optString("channel");
            this.hw = jSONObject.optString("prefix");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resource");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.hn.add(new x(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public String pr() {
            return this.pr;
        }

        public String hw() {
            return this.hw;
        }

        public x hn() {
            if (this.hn.isEmpty()) {
                return null;
            }
            return this.hn.get(0);
        }

        public String x() {
            String str = this.pr;
            if (hn() != null) {
                return str + "$" + com.byazt.ca.c.hw(hn().hw());
            }
            return str;
        }

        public List<x> getResources() {
            return this.hn;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel", this.pr);
                jSONObject.put("prefix", this.hw);
                JSONArray jSONArray = new JSONArray();
                Iterator<x> it = this.hn.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().x());
                }
                jSONObject.put("resource", jSONArray);
            } catch (JSONException e) {
            }
            return jSONObject;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            hn hnVar = (hn) obj;
            if (!Objects.equals(this.pr, hnVar.pr) || !Objects.equals(this.hw, hnVar.hw)) {
                return false;
            }
            x xVarHn = hn();
            x xVarHn2 = hnVar.hn();
            if (xVarHn == null || xVarHn2 == null) {
                if (xVarHn == xVarHn2) {
                    return true;
                }
                return false;
            }
            String strPr = xVarHn.pr();
            String strPr2 = xVarHn2.pr();
            String strHw = xVarHn.hw();
            String strHw2 = xVarHn2.hw();
            if (Objects.equals(strPr, strPr2) && Objects.equals(strHw, strHw2)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.pr;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.hw;
            int iHashCode2 = iHashCode + (str2 != null ? str2.hashCode() : 0);
            x xVarHn = hn();
            if (xVarHn != null) {
                String strPr = xVarHn.pr();
                String strHw = xVarHn.hw();
                return (((iHashCode2 * 31) + (strPr != null ? strPr.hashCode() : 0)) * 31) + (strHw != null ? strHw.hashCode() : 0);
            }
            return iHashCode2;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1722})
    public static class x {
        public final List<hw> hn = new ArrayList();
        public final String hw;
        public final String pr;

        public x(JSONObject jSONObject) {
            this.pr = jSONObject.optString("resource_url");
            this.hw = jSONObject.optString("content_hash");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("channel_resource_list");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.hn.add(new hw(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public String pr() {
            return this.pr;
        }

        public String hw() {
            return this.hw;
        }

        public List<hw> hn() {
            return this.hn;
        }

        public JSONObject x() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resource_url", this.pr);
                jSONObject.put("content_hash", this.hw);
                JSONArray jSONArray = new JSONArray();
                Iterator<hw> it = this.hn.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().hn());
                }
                jSONObject.put("channel_resource_list", jSONArray);
            } catch (JSONException e) {
            }
            return jSONObject;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM})
    public static class hw {
        public final String c;
        public final String hn;
        public final String hw;
        public final long pr;
        public final String uc;
        public final String x;

        public hw(JSONObject jSONObject) {
            this.pr = jSONObject.optLong("size", 0L);
            this.hw = jSONObject.optString("md5");
            this.hn = jSONObject.optString("content_hash");
            this.x = jSONObject.optString(BreakpointSQLiteKey.URL);
            this.c = jSONObject.optString("mime_type");
            this.uc = jSONObject.optString("file_name");
        }

        public String pr() {
            return this.c;
        }

        public String hw() {
            return this.uc;
        }

        public JSONObject hn() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("size", this.pr);
                jSONObject.put("md5", this.hw);
                jSONObject.put("content_hash", this.hn);
                jSONObject.put("mime_type", this.c);
                jSONObject.put("file_name", this.uc);
                jSONObject.put(BreakpointSQLiteKey.URL, this.x);
            } catch (JSONException e) {
            }
            return jSONObject;
        }
    }
}
