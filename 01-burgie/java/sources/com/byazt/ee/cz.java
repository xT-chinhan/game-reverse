package com.byazt.ee;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 213})
public class cz {
    public final w.pr hn;
    public final LruCache<String, hn> hw;
    public final String x;
    public final Map<String, List<hw>> pr = new ConcurrentHashMap();
    public volatile boolean c = false;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 2212})
    static final class hn {
        public fo pr = fo.PUBLIC;
        public Set<String> hw = new HashSet();
        public Set<String> hn = new HashSet();
    }

    public cz(String str, int i, w.pr prVar, final Executor executor, JSONObject jSONObject) {
        this.x = str;
        if (i <= 0) {
            this.hw = new LruCache<>(16);
        } else {
            this.hw = new LruCache<>(i);
        }
        this.hn = prVar;
        if (jSONObject == null) {
            x(str);
            new Object() { // from class: com.byazt.ee.cz.1
            };
        } else {
            update(jSONObject);
        }
    }

    public void update(JSONObject jSONObject) {
        pr(jSONObject);
        x(this.x);
    }

    public hn pr(String str, Set<String> set) {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String string = new Uri.Builder().scheme(scheme).authority(authority).path(uri.getPath()).toString();
        hn hnVar = new hn();
        if (authority == null || authority.isEmpty()) {
            hnVar.pr = fo.PUBLIC;
            return hnVar;
        }
        for (String str2 : set) {
            if (authority.equals(str2) || authority.endsWith(".".concat(String.valueOf(str2)))) {
                hnVar.pr = fo.PRIVATE;
                return hnVar;
            }
        }
        hn hnVar2 = this.hw.get(string);
        if (hnVar2 != null) {
            return hnVar2;
        }
        return pr(string);
    }

    private void pr(JSONObject jSONObject) {
        this.pr.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.pr.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(hw(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            aj.hw("Parse configurations failed, response: " + jSONObject.toString(), e);
        }
        this.c = true;
    }

    private hn pr(String str) throws pr {
        hn hnVar = new hn();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String strHw = hw(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || strHw == null) {
            hnVar.pr = fo.PUBLIC;
            return hnVar;
        }
        List<hw> listHn = hn(strHw);
        if (listHn == null) {
            return hnVar;
        }
        for (hw hwVar : listHn) {
            if (hwVar.pr.matcher(str).find()) {
                if (hwVar.hw.compareTo(hnVar.pr) >= 0) {
                    hnVar.pr = hwVar.hw;
                }
                hnVar.hw.addAll(hwVar.hn);
                hnVar.hn.addAll(hwVar.x);
            }
        }
        this.hw.put(str, hnVar);
        return hnVar;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, MediaPlayer.MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_ENABLE})
    static class pr extends IllegalStateException {
        public pr(String str) {
            super(str);
        }
    }

    private static String hw(String str) {
        String[] strArrSplit;
        int length;
        if (str == null || (length = (strArrSplit = str.split("[.]")).length) < 2) {
            return null;
        }
        if (length == 2) {
            return str;
        }
        return strArrSplit[length - 2] + "." + strArrSplit[length - 1];
    }

    private List<hw> hn(String str) throws pr {
        if (!this.c) {
            throw new pr("Permission config is outdated!");
        }
        return this.pr.get(str);
    }

    private static hw hw(JSONObject jSONObject) throws JSONException {
        hw hwVar = new hw();
        hwVar.pr = Pattern.compile(jSONObject.getString("pattern"));
        hwVar.hw = fo.pr(jSONObject.getString("group"));
        hwVar.hn = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("included_methods");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                hwVar.hn.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        hwVar.x = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                hwVar.x.add(jSONArrayOptJSONArray2.getString(i2));
            }
        }
        return hwVar;
    }

    private static String x(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig.".concat(String.valueOf(str));
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 2239})
    private static final class hw {
        public List<String> hn;
        public fo hw;
        public Pattern pr;
        public List<String> x;

        private hw() {
        }
    }
}
