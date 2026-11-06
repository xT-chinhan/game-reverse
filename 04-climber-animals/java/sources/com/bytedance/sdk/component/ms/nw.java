package com.bytedance.sdk.component.ms;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.anythink.core.common.d.j;
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

/* JADX INFO: loaded from: classes2.dex */
class nw {
    private final hi.ms ah;
    private final String d;
    private final LruCache<String, ah> xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Map<String, List<xr>> f1261ms = new ConcurrentHashMap();
    private volatile boolean ka = false;

    static final class ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        re f1263ms = re.PUBLIC;
        Set<String> xr = new HashSet();
        Set<String> ah = new HashSet();

        ah() {
        }
    }

    nw(String str, int i, hi.ms msVar, final Executor executor, JSONObject jSONObject) {
        this.d = str;
        if (i <= 0) {
            this.xr = new LruCache<>(16);
        } else {
            this.xr = new LruCache<>(i);
        }
        this.ah = msVar;
        if (jSONObject == null) {
            d(str);
            new Object() { // from class: com.bytedance.sdk.component.ms.nw.1
            };
        } else {
            update(jSONObject);
        }
    }

    void update(JSONObject jSONObject) {
        ms(jSONObject);
        d(this.d);
    }

    ah ms(String str, Set<String> set) {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String string = new Uri.Builder().scheme(scheme).authority(authority).path(uri.getPath()).toString();
        ah ahVar = new ah();
        if (authority == null || authority.isEmpty()) {
            ahVar.f1263ms = re.PUBLIC;
            return ahVar;
        }
        for (String str2 : set) {
            if (authority.equals(str2) || authority.endsWith(j.z.concat(String.valueOf(str2)))) {
                ahVar.f1263ms = re.PRIVATE;
                return ahVar;
            }
        }
        ah ahVar2 = this.xr.get(string);
        return ahVar2 != null ? ahVar2 : ms(string);
    }

    private void ms(JSONObject jSONObject) {
        this.f1261ms.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.f1261ms.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(xr(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            ny.xr("Parse configurations failed, response: " + jSONObject.toString(), e);
        }
        this.ka = true;
    }

    private ah ms(String str) throws ms {
        ah ahVar = new ah();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String strXr = xr(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || strXr == null) {
            ahVar.f1263ms = re.PUBLIC;
            return ahVar;
        }
        List<xr> listAh = ah(strXr);
        if (listAh == null) {
            return ahVar;
        }
        for (xr xrVar : listAh) {
            if (xrVar.f1264ms.matcher(str).find()) {
                if (xrVar.xr.compareTo(ahVar.f1263ms) >= 0) {
                    ahVar.f1263ms = xrVar.xr;
                }
                ahVar.xr.addAll(xrVar.ah);
                ahVar.ah.addAll(xrVar.d);
            }
        }
        this.xr.put(str, ahVar);
        return ahVar;
    }

    static class ms extends IllegalStateException {
        ms(String str) {
            super(str);
        }
    }

    private static String xr(String str) {
        String[] strArrSplit;
        int length;
        if (str != null && (length = (strArrSplit = str.split("[.]")).length) >= 2) {
            return length == 2 ? str : strArrSplit[length - 2] + j.z + strArrSplit[length - 1];
        }
        return null;
    }

    private List<xr> ah(String str) throws ms {
        if (!this.ka) {
            throw new ms("Permission config is outdated!");
        }
        return this.f1261ms.get(str);
    }

    private static xr xr(JSONObject jSONObject) throws JSONException {
        xr xrVar = new xr();
        xrVar.f1264ms = Pattern.compile(jSONObject.getString("pattern"));
        xrVar.xr = re.ms(jSONObject.getString("group"));
        xrVar.ah = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("included_methods");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                xrVar.ah.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        xrVar.d = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                xrVar.d.add(jSONArrayOptJSONArray2.getString(i2));
            }
        }
        return xrVar;
    }

    private static String d(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig.".concat(String.valueOf(str));
    }

    private static final class xr {
        List<String> ah;
        List<String> d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        Pattern f1264ms;
        re xr;

        private xr() {
        }
    }
}
