package com.byazt.hnb;

import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1322, 8})
public class s {
    public String n;
    public volatile String q;
    public String qg;
    public String s;

    private s() {
    }

    @com.byazt.cp.n(n = {0, 1, 1322, 546})
    private static class n {
        public static s n = new s();
    }

    public static s n() {
        return n.n;
    }

    public String qg() {
        try {
            Map<String, Object> mapTj = tj();
            if (mapTj == null) {
                s(null);
                return null;
            }
            Object obj = mapTj.get("motion_info");
            if (obj instanceof String) {
                if (TextUtils.equals("0", (String) obj)) {
                    s("0");
                    return "0";
                }
                s("1");
                return "1";
            }
            s(null);
            return null;
        } catch (Exception unused) {
        }
    }

    private String cp() {
        Map<String, Object> mapTj = tj();
        if (mapTj == null) {
            return null;
        }
        Object obj = mapTj.get("od");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public boolean s() {
        if (!TextUtils.isEmpty(this.q)) {
            return !TextUtils.equals("0", this.q);
        }
        Map<String, Object> mapTj = tj();
        if (mapTj != null) {
            Object obj = mapTj.get("uip");
            if (obj instanceof String) {
                String str = (String) obj;
                this.q = str;
                return !TextUtils.equals("0", str);
            }
        }
        this.q = "1";
        return true;
    }

    public String q() {
        Map<String, Object> mapTj = tj();
        if (mapTj == null) {
            return null;
        }
        Object obj = mapTj.get("blt");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void l() {
        if (d()) {
            String strCp = cp();
            if (TextUtils.equals(strCp, this.qg)) {
                return;
            }
            com.byazt.wq.qg.n().n("setOaidEnabled", n(strCp));
            this.qg = strCp;
        }
    }

    public boolean w() {
        return !TextUtils.equals(qg(), "0");
    }

    public boolean x() {
        if (d()) {
            return n(cp());
        }
        return true;
    }

    public boolean fs() {
        if (rv.qg().u()) {
            return false;
        }
        Map<String, Object> mapTj = tj();
        if (mapTj != null) {
            Object obj = mapTj.get("mcod");
            if (obj instanceof String) {
                String str = (String) obj;
                this.s = str;
                return !TextUtils.equals(str, "0");
            }
        }
        return true;
    }

    public boolean rv() {
        return qg(q());
    }

    public static Map<String, Object> tj() {
        JSONObject jSONObjectS;
        com.byazt.af.rv rvVarHd = com.byazt.vyf.s.cy().hd();
        if (rvVarHd == null) {
            return null;
        }
        Map<String, Object> mapD = rvVarHd.d();
        return ((mapD == null || mapD.isEmpty()) && com.byazt.vyf.s.cy().pk() && k.s() && (jSONObjectS = com.byazt.euy.n.s("compliance.json")) != null) ? n(jSONObjectS) : mapD;
    }

    public static HashMap<String, Object> n(JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.get(next));
            }
        } catch (Exception unused) {
        }
        return map;
    }

    private boolean n(String str) {
        return !TextUtils.equals(str, "0");
    }

    private boolean qg(String str) {
        return !TextUtils.equals(str, "0");
    }

    private void s(String str) {
        if (!TextUtils.equals(this.n, str)) {
            com.byazt.wq.qg.n().n("setSensorEnable", !TextUtils.equals(str, "0"));
        }
        this.n = str;
    }

    private boolean d() {
        String strOu = com.byazt.vyf.s.cy().ou();
        if (TextUtils.isEmpty(strOu)) {
            return false;
        }
        strOu.hashCode();
        switch (strOu) {
            case "5001121":
            case "5002213":
            case "5437586":
            case "5634951":
                return true;
            default:
                return false;
        }
    }
}
