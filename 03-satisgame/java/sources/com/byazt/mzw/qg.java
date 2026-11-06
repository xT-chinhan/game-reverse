package com.byazt.mzw;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.byazt.cq.tj;
import com.byazt.tk.k;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1346, 26})
public class qg {
    public static Object n = new Object();

    public static void n() {
        l.qg();
    }

    public static void qg() {
        try {
            fs.q();
            File fileX = l.x();
            if (fileX == null || !fileX.exists()) {
                return;
            }
            if (fileX.getParentFile() != null) {
                com.byazt.tk.x.s(fileX.getParentFile());
            } else {
                com.byazt.tk.x.s(fileX);
            }
        } catch (Throwable unused) {
        }
    }

    public static String s() {
        return w.s();
    }

    public static void n(com.byazt.px.q qVar) {
        x.n().n(qVar, qVar.w);
    }

    public static Set<com.byazt.px.qg> n(String str, boolean z) {
        final Set<com.byazt.px.qg> setQg = x.n().qg(str);
        if (setQg != null && setQg.size() > 0) {
            if (z) {
                com.byazt.cq.l.n(new com.byazt.qit.x("updateTmplTime") { // from class: com.byazt.mzw.qg.1
                    @Override // java.lang.Runnable
                    public void run() {
                        qg.qg((Set<com.byazt.px.qg>) setQg);
                    }
                }, 5);
            } else {
                qg(setQg);
            }
        }
        return setQg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Set<com.byazt.px.qg> set) {
        try {
            for (com.byazt.px.qg qgVar : set) {
                qgVar.n(Long.valueOf(System.currentTimeMillis()));
                w.n().n(qgVar, true);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.byazt.px.qg n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.byazt.px.qg qgVarN = x.n().n(str);
        if (qgVarN != null) {
            qgVarN.n(Long.valueOf(System.currentTimeMillis()));
            n(qgVarN);
        }
        return qgVarN;
    }

    private static void n(final com.byazt.px.qg qgVar) {
        com.byazt.cq.l.n(new com.byazt.qit.x("updateTmplTime") { // from class: com.byazt.mzw.qg.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (qg.n) {
                    w.n().n(qgVar, true);
                }
            }
        }, 10);
    }

    public static com.byazt.px.n q() {
        return l.qg().l();
    }

    @Deprecated
    private static String w() {
        com.byazt.px.n nVarQ = q();
        if (nVarQ == null) {
            return null;
        }
        return nVarQ.q();
    }

    public static String qg(String str) {
        com.byazt.px.n nVar;
        com.byazt.px.n nVarQ = q();
        if (nVarQ == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.byazt.px.n> mapN = nVarQ.n();
            if (mapN == null || mapN.size() <= 0 || (nVar = mapN.get(str)) == null) {
                return null;
            }
            return nVar.q();
        }
        return w();
    }

    public static boolean l() {
        return l.qg().q();
    }

    public static n n(String str, tj.n nVar, String str2, String str3) {
        File fileQ;
        n nVar2 = new n();
        if (TextUtils.isEmpty(str3)) {
            fileQ = null;
        } else {
            fileQ = qg(str3, str);
            if (fileQ != null) {
                nVar2.n(1);
            }
        }
        if (fileQ == null && (fileQ = l(str)) != null) {
            nVar2.n(3);
        }
        if (fileQ == null && (fileQ = q(str)) != null) {
            nVar2.n(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!n(str, str3)) {
                nVar2.n(4);
            }
        } else if (!s(str)) {
            nVar2.n(6);
        }
        nVar2.getType();
        if (fileQ != null) {
            try {
                nVar2.n(new WebResourceResponse(nVar.getType(), "utf-8", new FileInputStream(fileQ)));
            } catch (Throwable th) {
                k.n("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return nVar2;
    }

    private static boolean n(String str, String str2) {
        com.byazt.px.n nVarQ;
        com.byazt.px.n nVar;
        if (!l() || (nVarQ = q()) == null) {
            return false;
        }
        Map<String, com.byazt.px.n> mapN = nVarQ.n();
        if (mapN.size() == 0 || (nVar = mapN.get(str2)) == null) {
            return false;
        }
        for (com.byazt.px.n.C0308n c0308n : nVar.getResources()) {
            if (c0308n != null && TextUtils.equals(str, c0308n.n())) {
                return true;
            }
        }
        return false;
    }

    private static boolean s(String str) {
        com.byazt.px.n nVarQ;
        List<com.byazt.px.n.C0308n> resources;
        if (!l() || (nVarQ = q()) == null || (resources = nVarQ.getResources()) == null) {
            return false;
        }
        for (com.byazt.px.n.C0308n c0308n : resources) {
            if (c0308n != null && TextUtils.equals(str, c0308n.n())) {
                return true;
            }
        }
        return false;
    }

    private static File q(String str) {
        if (!l()) {
            return null;
        }
        for (com.byazt.px.n.C0308n c0308n : q().getResources()) {
            if (c0308n.n() != null && c0308n.n().equals(str)) {
                File file = new File(l.x(), com.byazt.tk.l.qg(c0308n.n()));
                String strN = com.byazt.tk.l.n(file);
                if (c0308n.qg() == null || !c0308n.qg().equals(strN)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    private static File l(String str) {
        List<Pair<String, String>> listQg;
        com.byazt.px.n.qg qgVarL = q().l();
        if (qgVarL == null || (listQg = qgVarL.qg()) == null || listQg.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : listQg) {
            if (pair.second != null && ((String) pair.second).equals(str)) {
                return new File(l.x(), (String) pair.first);
            }
        }
        return null;
    }

    private static File qg(String str, String str2) {
        com.byazt.px.n nVar;
        com.byazt.px.n nVarQ = q();
        if (nVarQ == null || !l()) {
            return null;
        }
        Map<String, com.byazt.px.n> mapN = nVarQ.n();
        if (mapN.size() == 0 || (nVar = mapN.get(str)) == null) {
            return null;
        }
        for (com.byazt.px.n.C0308n c0308n : nVar.getResources()) {
            if (c0308n.n() != null && c0308n.n().equals(str2)) {
                File file = new File(l.x(), com.byazt.tk.l.qg(c0308n.n()));
                String strN = com.byazt.tk.l.n(file);
                if (c0308n.qg() == null || !c0308n.qg().equals(strN)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static boolean n(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean qg(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean s(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null || (objOpt = jSONObjectOptJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
