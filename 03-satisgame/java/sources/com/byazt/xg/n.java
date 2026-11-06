package com.byazt.xg;

import android.text.TextUtils;
import com.byazt.sx.qg;
import com.byazt.sx.s;
import com.byazt.xz.l;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1817, 19})
public class n implements com.byazt.sx.n, s {
    public final Map<String, String> n = new HashMap();

    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "animateState".equals(str);
    }

    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, l lVar) {
        String strN = n(map);
        this.n.put(qg.n(str, i), strN);
        String strQg = qg(map2);
        if (TextUtils.isEmpty(strQg)) {
            return false;
        }
        strQg.hashCode();
        if (strQg.equals("complete")) {
            return qg(str, i, str2, strN, lVar);
        }
        if (strQg.equals("start")) {
            return n(str, i, str2, strN, lVar);
        }
        if (!TextUtils.isEmpty(strN) && !TextUtils.equals(strN, strQg)) {
            return false;
        }
        n(str2, strQg, str, i, lVar);
        return true;
    }

    private static boolean n(String str, int i, String str2, String str3, l lVar) {
        if (!TextUtils.isEmpty(str3) && !TextUtils.equals(str3, "start")) {
            return false;
        }
        n(str2, "start", str, i, lVar);
        return true;
    }

    private static boolean qg(String str, int i, String str2, String str3, l lVar) {
        if (!TextUtils.isEmpty(str3) && !TextUtils.equals(str3, "complete")) {
            return false;
        }
        n(str2, "complete", str, i, lVar);
        return true;
    }

    private static void n(String str, String str2, String str3, int i, l lVar) {
        if (lVar != null) {
            lVar.n();
        }
    }

    private static String n(Map<String, Object> map) {
        Object obj;
        return (map == null || (obj = map.get(WebLoginFragment.QUERY_KEY_ID)) == null) ? "" : String.valueOf(obj);
    }

    private static String qg(Map<String, Object> map) {
        Object obj;
        if (map == null) {
            return "";
        }
        Object obj2 = map.get("args");
        if (obj2 instanceof Object[]) {
            Object[] objArr = (Object[]) obj2;
            if (objArr.length > 0 && (obj = objArr[0]) != null) {
                return String.valueOf(obj);
            }
        }
        Object obj3 = map.get(WebLoginFragment.QUERY_KEY_ID);
        return obj3 == null ? "" : String.valueOf(obj3);
    }

    @Override // com.byazt.sx.n
    public void n(String str, int i) {
        this.n.remove(qg.n(str, i));
    }

    @Override // com.byazt.sx.n
    public void n(String str) {
        String strN = qg.n(str);
        Iterator<Map.Entry<String, String>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strN)) {
                it.remove();
            }
        }
    }
}
