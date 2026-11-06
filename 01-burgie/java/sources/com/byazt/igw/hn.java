package com.byazt.igw;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.qam.fw;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 77, 20})
public class hn {
    public String hn;
    public String hw;
    public String pr;
    public volatile String x;

    private hn() {
    }

    @com.byazt.vzx.pr(pr = {0, 1, 77, 116})
    private static class pr {
        public static hn pr = new hn();
    }

    public static hn pr() {
        return pr.pr;
    }

    public String hw() {
        try {
            Map<String, Object> mapVk = vk();
            if (mapVk == null) {
                hn(null);
                return null;
            }
            Object obj = mapVk.get("motion_info");
            if (obj instanceof String) {
                if (TextUtils.equals("0", (String) obj)) {
                    hn("0");
                    return "0";
                }
                hn("1");
                return "1";
            }
            hn(null);
            return null;
        } catch (Exception e) {
        }
    }

    private String w() {
        Map<String, Object> mapVk = vk();
        if (mapVk != null) {
            Object obj = mapVk.get("od");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return null;
    }

    public boolean hn() {
        if (!TextUtils.isEmpty(this.x)) {
            return !TextUtils.equals("0", this.x);
        }
        Map<String, Object> mapVk = vk();
        if (mapVk != null) {
            Object obj = mapVk.get("uip");
            if (obj instanceof String) {
                String str = (String) obj;
                this.x = str;
                return !TextUtils.equals("0", str);
            }
        }
        this.x = "1";
        return true;
    }

    public String x() {
        Map<String, Object> mapVk = vk();
        if (mapVk != null) {
            Object obj = mapVk.get("blt");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return null;
    }

    public void c() {
        if (!k()) {
            return;
        }
        String strW = w();
        if (!TextUtils.equals(strW, this.hw)) {
            com.byazt.eg.hw.pr().pr("setOaidEnabled", pr(strW));
            this.hw = strW;
        }
    }

    public boolean uc() {
        return !TextUtils.equals(hw(), "0");
    }

    public boolean fw() {
        if (!k()) {
            return true;
        }
        return pr(w());
    }

    public boolean zo() {
        if (a.hw().qi()) {
            return false;
        }
        Map<String, Object> mapVk = vk();
        if (mapVk != null) {
            Object obj = mapVk.get("mcod");
            if (obj instanceof String) {
                String str = (String) obj;
                this.hn = str;
                if (TextUtils.equals(str, "0")) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    public boolean aj() {
        return hw(x());
    }

    public static Map<String, Object> vk() {
        JSONObject jSONObjectHn;
        fw fwVarYb = zo.nt().yb();
        if (fwVarYb == null) {
            return null;
        }
        Map<String, Object> mapNt = fwVarYb.nt();
        if ((mapNt == null || mapNt.isEmpty()) && zo.nt().of() && ho.hn() && (jSONObjectHn = com.byazt.ej.pr.hn("compliance.json")) != null) {
            return pr(jSONObjectHn);
        }
        return mapNt;
    }

    public static HashMap<String, Object> pr(JSONObject jSONObject) {
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
        } catch (Exception e) {
        }
        return map;
    }

    private boolean pr(String str) {
        return !TextUtils.equals(str, "0");
    }

    private boolean hw(String str) {
        return !TextUtils.equals(str, "0");
    }

    private void hn(String str) {
        if (!TextUtils.equals(this.pr, str)) {
            com.byazt.eg.hw.pr().pr("setSensorEnable", !TextUtils.equals(str, "0"));
        }
        this.pr = str;
    }

    private boolean k() {
        String strNy = zo.nt().ny();
        if (TextUtils.isEmpty(strNy)) {
            return false;
        }
        switch (strNy) {
            case "5002213":
            case "5001121":
            case "5437586":
            case "5634951":
                return true;
            default:
                return false;
        }
    }
}
