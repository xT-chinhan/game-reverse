package com.byazt.mp;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.xlm.fw;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 168, 13})
public class hw {
    public static volatile hw pr;
    public volatile com.byazt.zq.hn hw = com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "sp_dynamic_tmpl_config");
    public volatile com.byazt.zq.hn hn = com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "sp_dynamic_tmpl_config_v3");

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new hw();
                }
            }
        }
        return pr;
    }

    public void pr(String str, String str2) {
        delete(str, str2, false);
    }

    public void delete(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strHw = hw(str, null, z);
            if (TextUtils.isEmpty(strHw)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(strHw);
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
                    pr(str, jSONArray.toString(), z);
                }
            }
        } catch (Exception e) {
        }
    }

    public void pr(String str, com.byazt.hfm.hn hnVar) {
        update(str, hnVar, false);
    }

    public void update(String str, com.byazt.hfm.hn hnVar, boolean z) {
        if (hnVar == null || hnVar.hw() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strHw = hw(str, null, z);
            JSONArray jSONArray = strHw == null ? new JSONArray() : new JSONArray(strHw);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", hnVar.hw());
            jSONObject.put("md5", hnVar.hn());
            jSONArray.put(jSONObject);
            pr(str, jSONArray.toString(), z);
        } catch (Exception e) {
        }
    }

    public JSONArray pr(final String str, int i) {
        try {
            final String strHw = hw(str, null, false);
            com.byazt.xlm.c.hw(new fw("tmpl_updatetime") { // from class: com.byazt.mp.hw.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        Set<com.byazt.hfm.hw> setPr = com.byazt.ce.hw.pr(str, false);
                        JSONArray jSONArray = new JSONArray();
                        if (setPr != null && setPr.size() > 0) {
                            z = true;
                            for (com.byazt.hfm.hw hwVar : setPr) {
                                if (hwVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("id", hwVar.hw());
                                    jSONObject.put("md5", hwVar.hn());
                                    jSONArray.put(jSONObject);
                                }
                            }
                        } else {
                            z = false;
                        }
                        String string = jSONArray.toString();
                        String str2 = strHw;
                        if ((str2 == null && z) || !string.equals(str2)) {
                            hw.this.pr(str, string, false);
                        }
                    } catch (Exception e) {
                    } catch (OutOfMemoryError e2) {
                        ho.pr("BidOptTmplManager", "getParentTplIds OOM in tmpl_updatetime task", e2);
                    }
                }
            });
            if (TextUtils.isEmpty(strHw)) {
                return null;
            }
            return new JSONArray(strHw);
        } catch (Exception e) {
            return null;
        }
    }

    public JSONArray hw(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!hn.pr().pr(i)) {
            return pr(str);
        }
        try {
            final String strHw = hw(str, null, true);
            com.byazt.xlm.c.hw(new fw("tmpl_updatetime") { // from class: com.byazt.mp.hw.2
                @Override // java.lang.Runnable
                public void run() {
                    String strPr;
                    try {
                        Set<com.byazt.ir.pr> setPr = com.byazt.ir.hw.pr().pr(str);
                        JSONArray jSONArray = new JSONArray();
                        boolean z = false;
                        if (setPr != null && setPr.size() > 0) {
                            for (com.byazt.ir.pr prVar : setPr) {
                                if (prVar != null && (strPr = prVar.pr()) != null) {
                                    int iIndexOf = strPr.indexOf(95);
                                    int iLastIndexOf = strPr.lastIndexOf(95);
                                    if (iIndexOf >= 0 && iIndexOf == iLastIndexOf && iIndexOf < strPr.length() - 1) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("id", strPr.substring(iIndexOf + 1));
                                        jSONObject.put("md5", prVar.hw());
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            }
                            z = true;
                        }
                        String string = null;
                        if (z || strHw != null) {
                            string = jSONArray.toString();
                        }
                        String str2 = strHw;
                        if ((str2 == null && z) || (string != null && !string.equals(str2))) {
                            hw.this.pr(str, string, true);
                        }
                    } catch (Exception e) {
                    } catch (OutOfMemoryError e2) {
                        ho.pr("BidOptTmplManager", "getParentTplIdsV3 OOM in tmpl_updatetime task", e2);
                    }
                }
            });
            if (TextUtils.isEmpty(strHw)) {
                return null;
            }
            return new JSONArray(strHw);
        } catch (Exception e) {
            return null;
        }
    }

    public JSONArray pr(String str) {
        String strPr;
        try {
            Set<com.byazt.ir.pr> setPr = com.byazt.ir.hw.pr().pr(str);
            if (setPr != null && setPr.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.byazt.ir.pr prVar : setPr) {
                    if (prVar != null && (strPr = prVar.pr()) != null) {
                        int iIndexOf = strPr.indexOf(95);
                        int iLastIndexOf = strPr.lastIndexOf(95);
                        if (iIndexOf >= 0 && iIndexOf == iLastIndexOf && iIndexOf < strPr.length() - 1) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", strPr.substring(iIndexOf + 1));
                            jSONObject.put("md5", prVar.hw());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            ho.pr("BidOptTmplManager", "getUgenParentTplIds: ", e);
            return null;
        }
    }

    public void pr(String str, String str2, boolean z) {
        com.byazt.zq.hn hnVar;
        try {
            if (z) {
                hnVar = this.hn;
            } else {
                hnVar = this.hw;
            }
            hnVar.pr(str, str2);
        } catch (Throwable th) {
        }
    }

    public String hw(String str, String str2, boolean z) {
        com.byazt.zq.hn hnVar;
        try {
            if (z) {
                hnVar = this.hn;
            } else {
                hnVar = this.hw;
            }
            return hnVar.getString(str, str2);
        } catch (Throwable th) {
            return str2;
        }
    }
}
