package com.byazt.cf;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.anythink.core.common.d.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a {
    public final String q;
    public final LruCache<String, s> qg;
    public final cp.n s;
    public final Map<String, List<qg>> n = new ConcurrentHashMap();
    public volatile boolean l = false;

    @com.byazt.cp.n(n = {0, 1, 93, 1986})
    static final class s {
        public ou n = ou.PUBLIC;
        public Set<String> qg = new HashSet();
        public Set<String> s = new HashSet();
    }

    public a(String str, int i, cp.n nVar, final Executor executor, JSONObject jSONObject) {
        this.q = str;
        if (i <= 0) {
            this.qg = new LruCache<>(16);
        } else {
            this.qg = new LruCache<>(i);
        }
        this.s = nVar;
        if (jSONObject == null) {
            q(str);
            new Object() { // from class: com.byazt.cf.a.1
            };
        } else {
            update(jSONObject);
        }
    }

    public void update(JSONObject jSONObject) {
        n(jSONObject);
        q(this.q);
    }

    public s n(String str, Set<String> set) {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String string = new Uri.Builder().scheme(scheme).authority(authority).path(uri.getPath()).toString();
        s sVar = new s();
        if (authority == null || authority.isEmpty()) {
            sVar.n = ou.PUBLIC;
            return sVar;
        }
        for (String str2 : set) {
            if (authority.equals(str2) || authority.endsWith(i.E.concat(String.valueOf(str2)))) {
                sVar.n = ou.PRIVATE;
                return sVar;
            }
        }
        s sVar2 = this.qg.get(string);
        return sVar2 != null ? sVar2 : n(string);
    }

    private void n(JSONObject jSONObject) {
        this.n.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(com.anythink.core.common.k.D);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.n.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(qg(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            rv.qg("Parse configurations failed, response: " + jSONObject.toString(), e);
        }
        this.l = true;
    }

    private s n(String str) throws n {
        s sVar = new s();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String strQg = qg(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || strQg == null) {
            sVar.n = ou.PUBLIC;
            return sVar;
        }
        List<qg> listS = s(strQg);
        if (listS == null) {
            return sVar;
        }
        for (qg qgVar : listS) {
            if (qgVar.n.matcher(str).find()) {
                if (qgVar.qg.compareTo(sVar.n) >= 0) {
                    sVar.n = qgVar.qg;
                }
                sVar.qg.addAll(qgVar.s);
                sVar.s.addAll(qgVar.q);
            }
        }
        this.qg.put(str, sVar);
        return sVar;
    }

    @com.byazt.cp.n(n = {0, 1, 93, 998})
    static class n extends IllegalStateException {
        public n(String str) {
            super(str);
        }
    }

    private static String qg(String str) {
        String[] strArrSplit;
        int length;
        if (str != null && (length = (strArrSplit = str.split("[.]")).length) >= 2) {
            return length == 2 ? str : strArrSplit[length - 2] + i.E + strArrSplit[length - 1];
        }
        return null;
    }

    private List<qg> s(String str) throws n {
        if (!this.l) {
            throw new n("Permission config is outdated!");
        }
        return this.n.get(str);
    }

    private static qg qg(JSONObject jSONObject) throws JSONException {
        qg qgVar = new qg();
        qgVar.n = Pattern.compile(jSONObject.getString("pattern"));
        qgVar.qg = ou.n(jSONObject.getString("group"));
        qgVar.s = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("included_methods");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                qgVar.s.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        qgVar.q = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                qgVar.q.add(jSONArrayOptJSONArray2.getString(i2));
            }
        }
        return qgVar;
    }

    private static String q(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig.".concat(String.valueOf(str));
    }

    @com.byazt.cp.n(n = {0, 1, 93, 1627})
    private static final class qg {
        public Pattern n;
        public List<String> q;
        public ou qg;
        public List<String> s;

        private qg() {
        }
    }
}
