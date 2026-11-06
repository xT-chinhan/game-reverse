package com.byazt.okk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.ho.BaseConstants;
import com.byazt.iz.fs;
import com.byazt.nf.l;
import com.byazt.nf.rv;
import com.byazt.ozc.x;
import com.byazt.vgx.w;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 52, 19})
public class n {
    public static final Map<String, InterfaceC0282n> n = Collections.synchronizedMap(new HashMap());
    public static l qg;

    /* JADX INFO: renamed from: com.byazt.okk.n$n, reason: collision with other inner class name */
    public interface InterfaceC0282n {
        void n();

        void qg();

        void s();
    }

    public static void n(Context context, String str, String str2, String str3, InterfaceC0282n interfaceC0282n) {
        if (TextUtils.isEmpty(str) || interfaceC0282n == null) {
            return;
        }
        n(str, interfaceC0282n);
        TTDelegateActivity.n(context, str, str2, str3);
    }

    public static void n(final Context context, final String str, final String str2, final String str3, final InterfaceC0282n interfaceC0282n, final x xVar, final pk pkVar) {
        if (TextUtils.isEmpty(str) || interfaceC0282n == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.okk.n.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zN = com.byazt.vyf.s.cy().n(true);
                if (!com.byazt.byp.qg.n()) {
                    if (n.n.containsKey(str)) {
                        return;
                    }
                    if (!w.q() && !zN) {
                        return;
                    }
                }
                n.n(str, interfaceC0282n);
                TTDelegateActivity.n(context, str, str2, str3, xVar, pkVar);
            }
        });
    }

    public static void n(final Context context, final String str, final String str2, final String str3, final InterfaceC0282n interfaceC0282n, final pk pkVar) {
        if (TextUtils.isEmpty(str) || interfaceC0282n == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.okk.n.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zN = com.byazt.vyf.s.cy().n(true);
                if (!com.byazt.byp.qg.n()) {
                    if (n.n.containsKey(str)) {
                        return;
                    }
                    if (!w.q() && !zN) {
                        return;
                    }
                }
                n.n(str, interfaceC0282n);
                TTDelegateActivity.n(context, str, str2, str3, pkVar);
            }
        });
    }

    public static void n(String str) {
        Map<String, InterfaceC0282n> map = n;
        if (map != null) {
            map.remove(str);
        }
    }

    private static void n(Context context, String str, InterfaceC0282n interfaceC0282n, String str2, pk pkVar) {
        if (TextUtils.isEmpty(str) || interfaceC0282n == null) {
            return;
        }
        n(str, interfaceC0282n);
        TTDelegateActivity.n(context, str, str2, pkVar);
    }

    public static void n(final pk pkVar, String str, final Context context, final String str2) {
        if (pkVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = pkVar.nn();
        }
        n(context, pkVar.q(), new InterfaceC0282n() { // from class: com.byazt.okk.n.3
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                n.q(pkVar, context, str2);
            }
        }, str, pkVar);
    }

    public static void n(pk pkVar, Context context, String str) {
        n(pkVar, qg(pkVar), context, str);
    }

    public static void n(Context context, String str, InterfaceC0282n interfaceC0282n, String str2) {
        if (TextUtils.isEmpty(str) || interfaceC0282n == null) {
            return;
        }
        n(str, interfaceC0282n);
        TTDelegateActivity.qg(context, str, str2);
    }

    public static void qg(final pk pkVar, String str, final Context context, final String str2) {
        if (pkVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = pkVar.nn();
        }
        n(context, pkVar.q(), new InterfaceC0282n() { // from class: com.byazt.okk.n.4
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                n.q(pkVar, context, str2);
            }
        }, str);
    }

    public static void qg(pk pkVar, Context context, String str) {
        qg(pkVar, qg(pkVar), context, str);
    }

    public static void n(Context context, String str, String str2, InterfaceC0282n interfaceC0282n) {
        if (TextUtils.isEmpty(str) || interfaceC0282n == null) {
            return;
        }
        n(str, interfaceC0282n);
        TTDelegateActivity.n(context, str, str2);
    }

    public static void s(final pk pkVar, String str, final Context context, final String str2) {
        if (pkVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = pkVar.nn();
        }
        n(context, pkVar.q(), str, new InterfaceC0282n() { // from class: com.byazt.okk.n.5
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                n.q(pkVar, context, str2);
            }
        });
    }

    public static void s(pk pkVar, Context context, String str) {
        s(pkVar, qg(pkVar), context, str);
    }

    public static void n(Context context, pk pkVar, String str) {
        n(context, s(pkVar), pkVar, str);
    }

    public static void n(final Context context, String str, final pk pkVar, final String str2) {
        if (pkVar == null) {
            return;
        }
        String strQ = pkVar.q();
        if (TextUtils.isEmpty(strQ)) {
            return;
        }
        n(strQ, new InterfaceC0282n() { // from class: com.byazt.okk.n.6
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                n.q(pkVar, context, str2);
            }
        });
        com.byazt.gct.w wVarCd = pkVar.cd();
        if (TextUtils.isEmpty(str)) {
            if (wVarCd == null) {
                return;
            } else {
                str = wVarCd.rv();
            }
        }
        TTDelegateActivity.s(context, strQ, str);
    }

    public static void qg(Context context, String str, String str2, InterfaceC0282n interfaceC0282n) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        n(str2, interfaceC0282n);
        TTDelegateActivity.s(context, str2, str);
    }

    public static void n(Context context, String str) {
        TTDelegateActivity.n(context, str);
        com.byazt.eji.s.n().n(str);
    }

    private static String qg(pk pkVar) {
        com.byazt.gct.q qVarN = com.byazt.iz.n.n(pkVar);
        if (qVarN != null) {
            return qVarN.fs();
        }
        return null;
    }

    private static String s(pk pkVar) {
        com.byazt.gct.q qVarN = com.byazt.iz.n.n(pkVar);
        if (qVarN == null || TextUtils.isEmpty(qVarN.l())) {
            return null;
        }
        return qVarN.l();
    }

    public static void q(pk pkVar, Context context, String str) {
        int iD = um.d(pkVar);
        if (pkVar == null || context == null) {
            return;
        }
        if (pkVar.rv() == 4 || iD != 0) {
            com.byazt.oh.n nVarN = fs.n(context, pkVar, str);
            if (nVarN instanceof com.byazt.oh.n) {
                nVarN.n().n(false);
            }
            nVarN.handleAdClick(pkVar, false);
        }
    }

    public static void n(Context context, String str, String str2, String str3, String str4, String str5, InterfaceC0282n interfaceC0282n) {
        if (TextUtils.isEmpty(str) || interfaceC0282n == null) {
            return;
        }
        n(str, interfaceC0282n);
        TTDelegateActivity.n(context, str, str2, str3, str4, str5);
    }

    public static void n(Context context, String str, boolean z, InterfaceC0282n interfaceC0282n) {
        if (z) {
            TTDelegateActivity.n(context, str, z);
        } else {
            if (TextUtils.isEmpty(str) || interfaceC0282n == null) {
                return;
            }
            n(str, interfaceC0282n);
            TTDelegateActivity.n(context, str, z);
        }
    }

    public static void qg(String str) {
        n(str, 1);
    }

    public static void s(String str) {
        n(str, 2);
    }

    public static void q(String str) {
        n(str, 3);
    }

    public static void n(final String str, final InterfaceC0282n interfaceC0282n) {
        if (TextUtils.isEmpty(str) || interfaceC0282n == null) {
            return;
        }
        if (com.byazt.byp.qg.n()) {
            com.byazt.qit.l.qg(new com.byazt.qit.x("addDialogListener") { // from class: com.byazt.okk.n.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        n.s().n(str, new com.byazt.ca.n(interfaceC0282n));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        } else {
            n.put(str, interfaceC0282n);
        }
    }

    public static InterfaceC0282n l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.remove(str);
    }

    private static void n(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.byazt.byp.qg.n()) {
            com.byazt.qit.l.qg(new com.byazt.qit.x("doHandler") { // from class: com.byazt.okk.n.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        n.s().n(str, i);
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
            return;
        }
        InterfaceC0282n interfaceC0282nL = l(str);
        if (interfaceC0282nL == null) {
            return;
        }
        if (i == 1) {
            interfaceC0282nL.n();
            return;
        }
        if (i == 2) {
            interfaceC0282nL.qg();
        } else if (i == 3) {
            interfaceC0282nL.s();
        } else {
            interfaceC0282nL.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static l s() {
        if (qg == null) {
            qg = com.byazt.ptd.s.n(com.byazt.prx.n.n(rv.getContext()).n(2));
        }
        return qg;
    }

    public static void n(Context context, String str, pk pkVar) {
        TTDelegateActivity.n(context, str, pkVar);
    }

    public static void n(Context context, final pk pkVar) {
        if (pkVar == null) {
            return;
        }
        com.byazt.hm.n.n(pkVar, "pangle_logo", "open_policy", new com.byazt.rs.n() { // from class: com.byazt.okk.n.9
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_info", pkVar.yk());
                jSONObject2.put("ad_slot_type", w.d(pkVar));
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
        TTDelegateActivity.qg(context, pkVar.yk());
    }

    public static boolean n(pk pkVar) {
        if (pkVar == null || pkVar.G_() || pkVar.D_() == null || um.tj(pkVar) == 1 || pkVar.rv() != 4 || um.rv(pkVar) == 0) {
            return false;
        }
        int iCx = pkVar.cx();
        return iCx == 4 || iCx == 5;
    }
}
