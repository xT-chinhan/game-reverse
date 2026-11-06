package com.byazt.zg;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.bf.x;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 732, 26})
public class qg implements n<x> {
    public Context n;

    public qg(Context context) {
        if (context != null) {
            this.n = context.getApplicationContext();
        }
    }

    @Override // com.byazt.zg.w
    /* JADX INFO: renamed from: n, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public synchronized void qg(x xVar) {
        if (this.n != null && xVar != null) {
            n(n(xVar.qg()), xVar, true);
        }
    }

    private JSONObject n(x xVar, boolean z) {
        if (xVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unity_id", xVar.q());
            if (xVar.n()) {
                jSONObject.put("adn_rit_show_rules_version", xVar.w());
            } else {
                jSONObject.put("waterfall_show_rules_version", xVar.l());
            }
            jSONObject.put("timing_mode", xVar.x());
            jSONObject.put("show_freqctl_rules", z ? xVar.rv() : xVar.tj());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.byazt.zg.w
    public synchronized x query(String str) {
        if (this.n != null && !TextUtils.isEmpty(str)) {
            if (!qg()) {
                return n(str, (String) null, false);
            }
            return qg(str, null, false);
        }
        return null;
    }

    @Override // com.byazt.zg.w
    public synchronized x query(String str, String str2) {
        if (this.n != null && !TextUtils.isEmpty(str)) {
            if (!qg()) {
                return n(str, str2, true);
            }
            return qg(str, str2, true);
        }
        return null;
    }

    private x n(String str, boolean z) {
        String string;
        String string2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] strArrSplit = jSONObject.getString("unity_id").split("_");
            String str2 = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str3 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (z) {
                string2 = jSONObject.getString("adn_rit_show_rules_version");
                string = "";
            } else {
                string = jSONObject.getString("waterfall_show_rules_version");
                string2 = "";
            }
            return new x(str2, str3, string, string2, jSONObject.getInt("timing_mode"), jSONObject.getString("show_freqctl_rules"));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.byazt.zg.w
    public synchronized void delete(String str) {
        if (this.n != null && !TextUtils.isEmpty(str)) {
            qg(n(str), str);
        }
    }

    @Override // com.byazt.zg.w
    public synchronized void delete(String str, String str2) {
        if (this.n != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            qg(n(str), n(str, str2));
        }
    }

    @Override // com.byazt.zg.n
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public synchronized void n(x xVar) {
        if (xVar != null) {
            s(xVar);
        }
    }

    private void s(x xVar) {
        if (this.n == null || xVar == null) {
            return;
        }
        n(n(xVar.qg()), xVar, false);
    }

    private com.byazt.gwu.s n(String str) {
        if (qg()) {
            return n();
        }
        return qg(str);
    }

    private x n(String str, String str2, boolean z) {
        return n(n(qg(str), n(str, str2)), z);
    }

    private x qg(String str, String str2, boolean z) {
        String strN = n(str, str2);
        com.byazt.gwu.s sVarN = n();
        x xVarN = n(n(sVarN, strN), z);
        if (xVarN != null) {
            if (s(str)) {
                n(str, sVarN);
            }
            return xVarN;
        }
        if (!s(str)) {
            return null;
        }
        n(str, sVarN);
        return n(n(sVarN, strN), z);
    }

    private boolean n(com.byazt.gwu.s sVar, x xVar, boolean z) {
        JSONObject jSONObjectN;
        if (sVar == null || xVar == null || (jSONObjectN = n(xVar, z)) == null) {
            return false;
        }
        try {
            sVar.n(xVar.q(), jSONObjectN.toString());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private com.byazt.gwu.s n() {
        return com.byazt.ri.n.w();
    }

    private com.byazt.gwu.s qg(String str) {
        return com.byazt.lk.l.n(null, l(str));
    }

    private boolean s(String str) {
        return l.qg(null, l(str));
    }

    private boolean qg() {
        return com.byazt.qt.qg.n().cp();
    }

    private void n(String str, com.byazt.gwu.s sVar) {
        try {
            qg(str, sVar);
        } catch (Throwable unused) {
        }
    }

    private void qg(String str, com.byazt.gwu.s sVar) {
        com.byazt.gwu.s sVarQg;
        if (TextUtils.isEmpty(str) || sVar == null || (sVarQg = qg(str)) == null) {
            return;
        }
        Map all = sVarQg.getAll();
        if (all == null || all.isEmpty()) {
            q(str);
            return;
        }
        SharedPreferences.Editor editorEdit = sVar.edit();
        if (editorEdit == null) {
            return;
        }
        boolean z = false;
        for (Map.Entry entry : all.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key instanceof String) {
                String str2 = (String) key;
                if (sVar.contains(str2)) {
                    continue;
                } else if (!n(editorEdit, str2, value)) {
                    return;
                } else {
                    z = true;
                }
            }
        }
        if (!z || editorEdit.commit()) {
            q(str);
        }
    }

    private boolean n(SharedPreferences.Editor editor, String str, Object obj) {
        if (obj instanceof String) {
            editor.putString(str, (String) obj);
            return true;
        }
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return true;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return true;
        }
        if (obj instanceof Float) {
            editor.putFloat(str, ((Float) obj).floatValue());
            return true;
        }
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        editor.putStringSet(str, (Set) obj);
        return true;
    }

    private String n(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str + "_" + str2;
    }

    private void q(String str) {
        l.s(null, l(str));
    }

    private String l(String str) {
        return l.n("gm_freqctl_", str);
    }

    private String n(com.byazt.gwu.s sVar, String str) {
        if (sVar != null && !TextUtils.isEmpty(str)) {
            try {
                return sVar.getString(str, "");
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    private void qg(com.byazt.gwu.s sVar, String str) {
        if (sVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            sVar.n(str);
        } catch (Throwable unused) {
        }
    }
}
