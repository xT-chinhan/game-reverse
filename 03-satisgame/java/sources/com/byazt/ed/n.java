package com.byazt.ed;

import android.text.TextUtils;
import com.byazt.ivn.w;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.tk.k;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 854, 19})
public class n {
    public static volatile n n;
    public volatile com.byazt.gwu.s qg = com.byazt.lk.l.n(com.byazt.vgx.s.q(), "sp_dynamic_tmpl_config");
    public volatile com.byazt.gwu.s s = com.byazt.lk.l.n(com.byazt.vgx.s.q(), "sp_dynamic_tmpl_config_v3");

    /* JADX INFO: Access modifiers changed from: private */
    public int qg() {
        w wVarQg = rv.qg();
        if (wVarQg != null) {
            return wVarQg.nn();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        return qg() > 0;
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public void n(String str, String str2) {
        delete(str, str2, false);
    }

    public void delete(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strQg = qg(str, null, z);
            if (TextUtils.isEmpty(strQg)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(strQg);
            if (jSONArray.length() > 0) {
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        i = -1;
                        break;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && str2.equals(jSONObjectOptJSONObject.getString("id"))) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    jSONArray.remove(i);
                    n(str, jSONArray.toString(), z);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void n(String str, com.byazt.px.s sVar) {
        update(str, sVar, false);
    }

    public void update(String str, com.byazt.px.s sVar, boolean z) {
        if (sVar == null || sVar.qg() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strQg = qg(str, null, z);
            JSONArray jSONArray = strQg == null ? new JSONArray() : new JSONArray(strQg);
            String strQg2 = sVar.qg();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && TextUtils.equals(strQg2, jSONObjectOptJSONObject.optString("id"))) {
                    jSONArray.remove(i);
                    break;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", strQg2);
            jSONObject.put("md5", sVar.s());
            jSONArray.put(jSONObject);
            if (s()) {
                for (int length = jSONArray.length() - qg(); length > 0; length--) {
                    jSONArray.remove(0);
                }
            }
            n(str, jSONArray.toString(), z);
        } catch (Exception unused) {
        } catch (OutOfMemoryError e) {
            k.n("BidOptTmplManager", "update OOM, isV3=".concat(String.valueOf(z)), e);
        }
    }

    public JSONArray n(final String str, int i) {
        try {
            final String strQg = qg(str, null, false);
            com.byazt.qit.l.qg(new x("tmpl_updatetime") { // from class: com.byazt.ed.n.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        Set<com.byazt.px.qg> setN = com.byazt.mzw.qg.n(str, false);
                        JSONArray jSONArray = new JSONArray();
                        if (setN == null || setN.size() <= 0) {
                            z = false;
                        } else {
                            int i2 = 0;
                            for (com.byazt.px.qg qgVar : setN) {
                                if (qgVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("id", qgVar.qg());
                                    jSONObject.put("md5", qgVar.s());
                                    jSONArray.put(jSONObject);
                                    i2++;
                                    if (n.this.s() && i2 >= n.this.qg()) {
                                        break;
                                    }
                                }
                            }
                            z = true;
                        }
                        String string = jSONArray.toString();
                        String str2 = strQg;
                        if (!(str2 == null && z) && string.equals(str2)) {
                            return;
                        }
                        n.this.n(str, string, false);
                    } catch (Exception unused) {
                    } catch (OutOfMemoryError e) {
                        k.n("BidOptTmplManager", "getParentTplIds OOM in tmpl_updatetime task", e);
                    }
                }
            });
            if (TextUtils.isEmpty(strQg)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(strQg);
                if (!s() || jSONArray.length() <= qg()) {
                    return jSONArray;
                }
                JSONArray jSONArray2 = new JSONArray();
                for (int iMax = Math.max(0, jSONArray.length() - qg()); iMax < jSONArray.length(); iMax++) {
                    jSONArray2.put(jSONArray.opt(iMax));
                }
                return jSONArray2;
            } catch (OutOfMemoryError e) {
                k.n("BidOptTmplManager", "getParentTplIds OOM when parse cache", e);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public JSONArray qg(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!qg.n().n(i)) {
            return n(str);
        }
        try {
            final String strQg = qg(str, null, true);
            com.byazt.qit.l.qg(new x("tmpl_updatetime") { // from class: com.byazt.ed.n.2
                @Override // java.lang.Runnable
                public void run() {
                    String strN;
                    try {
                        Set<com.byazt.ysr.n> setN = com.byazt.ysr.qg.n().n(str);
                        JSONArray jSONArray = new JSONArray();
                        int i2 = 0;
                        if (setN != null && setN.size() > 0) {
                            for (com.byazt.ysr.n nVar : setN) {
                                if (nVar != null && (strN = nVar.n()) != null) {
                                    int iIndexOf = strN.indexOf(95);
                                    int iLastIndexOf = strN.lastIndexOf(95);
                                    if (iIndexOf >= 0 && iIndexOf == iLastIndexOf && iIndexOf < strN.length() - 1) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("id", strN.substring(iIndexOf + 1));
                                        jSONObject.put("md5", nVar.qg());
                                        jSONArray.put(jSONObject);
                                        i2++;
                                        if (n.this.s() && i2 >= n.this.qg()) {
                                            break;
                                        }
                                    }
                                }
                            }
                            i2 = 1;
                        }
                        String string = (i2 == 0 && strQg == null) ? null : jSONArray.toString();
                        String str2 = strQg;
                        if ((str2 != null || i2 == 0) && (string == null || string.equals(str2))) {
                            return;
                        }
                        n.this.n(str, string, true);
                    } catch (Exception unused) {
                    } catch (OutOfMemoryError e) {
                        k.n("BidOptTmplManager", "getParentTplIdsV3 OOM in tmpl_updatetime task", e);
                    }
                }
            });
            if (TextUtils.isEmpty(strQg)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(strQg);
                if (!s() || jSONArray.length() <= qg()) {
                    return jSONArray;
                }
                JSONArray jSONArray2 = new JSONArray();
                for (int iMax = Math.max(0, jSONArray.length() - qg()); iMax < jSONArray.length(); iMax++) {
                    jSONArray2.put(jSONArray.opt(iMax));
                }
                return jSONArray2;
            } catch (OutOfMemoryError e) {
                k.n("BidOptTmplManager", "getParentTplIdsV3 OOM when parse cache", e);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public JSONArray n(String str) {
        String strN;
        try {
            Set<com.byazt.ysr.n> setN = com.byazt.ysr.qg.n().n(str);
            if (setN != null && setN.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                for (com.byazt.ysr.n nVar : setN) {
                    if (nVar != null && (strN = nVar.n()) != null) {
                        int iIndexOf = strN.indexOf(95);
                        int iLastIndexOf = strN.lastIndexOf(95);
                        if (iIndexOf >= 0 && iIndexOf == iLastIndexOf && iIndexOf < strN.length() - 1) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", strN.substring(iIndexOf + 1));
                            jSONObject.put("md5", nVar.qg());
                            jSONArray.put(jSONObject);
                            i++;
                            if (s() && i >= qg()) {
                                break;
                            }
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            k.n("BidOptTmplManager", "getUgenParentTplIds: ", e);
            return null;
        }
    }

    public void n(String str, String str2, boolean z) {
        com.byazt.gwu.s sVar;
        try {
            if (z) {
                sVar = this.s;
            } else {
                sVar = this.qg;
            }
            sVar.n(str, str2);
        } catch (Throwable unused) {
        }
    }

    public String qg(String str, String str2, boolean z) {
        com.byazt.gwu.s sVar;
        try {
            if (z) {
                sVar = this.s;
            } else {
                sVar = this.qg;
            }
            return sVar.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
