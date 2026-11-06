package com.byazt.zg;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.bf.rv;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 732, 5})
public class q implements s<rv> {
    public Context n;

    public q(Context context) {
        if (context != null) {
            this.n = context.getApplicationContext();
        }
    }

    @Override // com.byazt.zg.w
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public synchronized void qg(rv rvVar) {
        if (this.n != null && rvVar != null) {
            n(n(rvVar.qg()), rvVar);
        }
    }

    @Override // com.byazt.zg.w
    public synchronized rv query(String str) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!qg()) {
            return n(str, (String) null, false);
        }
        return qg(str, null, false);
    }

    @Override // com.byazt.zg.w
    public synchronized rv query(String str, String str2) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!qg()) {
            return n(str, str2, true);
        }
        return qg(str, str2, true);
    }

    private rv n(String str, boolean z) {
        String str2;
        String string;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] strArrSplit = jSONObject.getString("unity_id").split("_");
            String str3 = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str4 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (z) {
                str2 = "";
                string = str2;
            } else {
                String string2 = jSONObject.getString("waterfall_show_rules_version");
                string = jSONObject.getString("adn_rit_show_rules_version");
                str2 = string2;
            }
            return new rv(str3, str4, str2, string, jSONObject.getInt("timing_mode"), jSONObject.getString("show_pacing"), jSONObject.getString("show_pacing_rule_id"), jSONObject.getString("show_time"));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.byazt.zg.w
    public synchronized void delete(String str) {
        if (w(str)) {
            return;
        }
        if (this.n != null && !TextUtils.isEmpty(str)) {
            qg(n(str), str);
        }
    }

    @Override // com.byazt.zg.w
    public synchronized void delete(String str, String str2) {
        if (w(str)) {
            return;
        }
        if (this.n != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            qg(n(str), n(str, str2));
        }
    }

    @Override // com.byazt.zg.s
    public synchronized void n(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        rv rvVarQuery = query(str);
        if (rvVarQuery != null) {
            rvVarQuery.n(j);
            n(n(rvVarQuery.qg()), rvVarQuery);
        }
    }

    @Override // com.byazt.zg.s
    public synchronized void n(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            rv rvVarQuery = query(str, str2);
            if (rvVarQuery != null) {
                rvVarQuery.n(j);
                n(n(rvVarQuery.qg()), rvVarQuery);
            }
        }
    }

    private com.byazt.gwu.s n(String str) {
        if (qg()) {
            return n();
        }
        return qg(str);
    }

    private rv n(String str, String str2, boolean z) {
        return n(n(qg(str), n(str, str2)), z);
    }

    private rv qg(String str, String str2, boolean z) {
        String strN = n(str, str2);
        com.byazt.gwu.s sVarN = n();
        rv rvVarN = n(n(sVarN, strN), z);
        if (rvVarN != null) {
            if (s(str)) {
                n(str, sVarN);
            }
            return rvVarN;
        }
        if (!s(str)) {
            return null;
        }
        n(str, sVarN);
        return n(n(sVarN, strN), z);
    }

    private boolean n(com.byazt.gwu.s sVar, rv rvVar) {
        JSONObject jSONObjectQg;
        if (sVar == null || rvVar == null || (jSONObjectQg = qg(rvVar)) == null) {
            return false;
        }
        try {
            sVar.n(rvVar.q(), jSONObjectQg.toString());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private JSONObject qg(rv rvVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unity_id", rvVar.q());
            if (!rvVar.n()) {
                jSONObject.put("waterfall_show_rules_version", rvVar.l());
                jSONObject.put("adn_rit_show_rules_version", rvVar.w());
            }
            jSONObject.put("timing_mode", rvVar.x());
            jSONObject.put("show_pacing", new StringBuilder().append(rvVar.rv()).toString());
            jSONObject.put("show_pacing_rule_id", rvVar.tj());
            jSONObject.put("show_time", new StringBuilder().append(rvVar.cp()).toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private com.byazt.gwu.s n() {
        return com.byazt.ri.n.x();
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
        return l.n("gm_pacing_", str);
    }

    private boolean w(String str) {
        return TextUtils.isEmpty(str) || str.contains("_");
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
