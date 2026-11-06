package com.byazt.aun;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.byazt.vf.fi;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 898, 13})
public class w implements fi, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return Integer.valueOf(n((String) sparseArray.get(1)));
        }
        if (iIntValue == 2) {
            return n((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
        }
        if (iIntValue != 3) {
            return null;
        }
        return n((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (JSONObject) sparseArray.get(3));
    }

    @Override // com.byazt.vf.fi
    public int n(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pkg_name", str);
            JSONObject jSONObjectN = n("c_s_s_plugin_up", jSONObject);
            if (jSONObjectN != null) {
                return jSONObjectN.optInt("update", 1);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @Override // com.byazt.vf.fi
    public JSONObject n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return qg(str, jSONObject, rv.qg().xm());
    }

    @Override // com.byazt.vf.fi
    public JSONObject n(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return qg(str, jSONObject, jSONObject2);
    }

    private JSONObject qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = x.qg.get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private JSONObject qg(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        int iIntValue = 0;
        if (jSONObject2 != null && jSONObject2.has(str)) {
            iIntValue = jSONObject2.optInt(str, 0);
        }
        if (iIntValue <= 0 && x.n.containsKey(str)) {
            Integer num = x.n.get(str);
            if (num != null) {
                iIntValue = num.intValue();
            }
            if (iIntValue <= 0) {
                return qg(str);
            }
        }
        int iN = x.n(iIntValue);
        int iQg = x.qg(iIntValue);
        com.byazt.gdj.fs fsVarN = fs.n().n(str, iN);
        if (fsVarN == null) {
            return null;
        }
        try {
            JSONObject jSONObjectN = n(fsVarN, jSONObject, jSONObject2);
            if (jSONObjectN == null) {
                jSONObjectN = new JSONObject();
            }
            jSONObjectN.putOpt("s_ab_conf_info", Integer.valueOf(iQg));
            return jSONObjectN;
        } catch (Throwable th) {
            k.qg("Tme_TTStrategyCalCenter", "processAbStrategy error:" + th.toString());
            return null;
        }
    }

    private JSONObject n(com.byazt.gdj.fs fsVar, JSONObject jSONObject, JSONObject jSONObject2) {
        if (fsVar == null || TextUtils.isEmpty(fsVar.n())) {
            return null;
        }
        JSONObject jSONObjectQg = qg(fsVar, jSONObject, jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        n(fsVar, jSONObject, jSONObjectQg, jSONObject3);
        return n(fsVar, jSONObject3);
    }

    private JSONObject qg(com.byazt.gdj.fs fsVar, JSONObject jSONObject, JSONObject jSONObject2) {
        List<String> listS = fsVar.s();
        if (listS == null || listS.isEmpty()) {
            return null;
        }
        JSONObject jSONObject3 = new JSONObject();
        for (String str : listS) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    n(jSONObject3, qg(str, jSONObject, jSONObject2));
                } catch (Throwable th) {
                    k.qg("Tme_TTStrategyCalCenter", "resolveDependResults error dependId:" + str + " " + th.toString());
                }
            }
        }
        return jSONObject3;
    }

    private void n(com.byazt.gdj.fs fsVar, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Object objQg;
        List<com.byazt.gdj.rv> listQ = fsVar.q();
        if (listQ == null || listQ.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.putOpt("params", jSONObject);
            jSONObject4.putOpt("env", com.byazt.rm.n.n());
            jSONObject4.putOpt("device", com.byazt.kld.n.n());
            n(jSONObject4, jSONObject2);
            n(jSONObject4, jSONObject3);
            n(jSONObject4, q.n().qg());
            for (com.byazt.gdj.rv rvVar : listQ) {
                if (rvVar != null && !TextUtils.isEmpty(rvVar.qg()) && (objQg = qg(rvVar.n(), jSONObject4)) != null) {
                    jSONObject3.putOpt(rvVar.qg(), objQg);
                    jSONObject4.putOpt(rvVar.qg(), objQg);
                }
            }
        } catch (Throwable th) {
            k.qg("Tme_TTStrategyCalCenter", "executeFunctions error:" + th.toString());
        }
    }

    private JSONObject n(com.byazt.gdj.fs fsVar, JSONObject jSONObject) {
        Object objQg;
        JSONObject jSONObject2 = new JSONObject();
        List<com.byazt.gdj.s> listL = fsVar.l();
        if (listL != null && !listL.isEmpty()) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("results", jSONObject);
                for (com.byazt.gdj.s sVar : listL) {
                    if (sVar != null && !TextUtils.isEmpty(sVar.qg()) && (objQg = qg(sVar.n(), jSONObject3)) != null) {
                        jSONObject2.putOpt(sVar.qg(), objQg);
                    }
                }
            } catch (Throwable th) {
                k.qg("Tme_TTStrategyCalCenter", "generateOutputs error:" + th.toString());
            }
        }
        return jSONObject2;
    }

    private Object qg(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.byazt.sz.n.n(com.byazt.rm.q.n(str)).n(jSONObject);
        } catch (Throwable th) {
            k.qg("Tme_TTStrategyCalCenter", "calcEL error:" + str + " " + th.toString());
            return null;
        }
    }

    private void n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject.putOpt(next, jSONObject2.opt(next));
            } catch (Throwable unused) {
            }
        }
    }
}
