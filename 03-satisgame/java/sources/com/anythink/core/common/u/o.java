package com.anythink.core.common.u;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.common.h.bl;
import com.anythink.core.common.h.bq;
import com.anythink.core.common.h.by;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    static Random a = new Random();
    private static final String b = "CommonSDKUtil";

    public static class a {
        public static final String a = "com.android.vending";
    }

    public static String a(int i) {
        switch (i) {
            case 2:
                return "c2s";
            case 3:
                return "s2s";
            case 4:
                return "adx";
            case 5:
                return "adx open";
            case 6:
            case 10:
            default:
                return "";
            case 7:
                return "fb in-house";
            case 8:
                return "directly";
            case 9:
                return "dynamic";
            case 11:
                return "custom in-house";
            case 12:
                return "dynamic c2s";
            case 13:
                return "dynamic s2s";
        }
    }

    public static boolean b(int i) {
        return i == 2 || i == 7 || i == 9 || i == 12;
    }

    public static boolean c(int i) {
        return i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13;
    }

    public static boolean d(int i) {
        return i == 1 || i == 6 || i == 10;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("anythink", "Channel Error: The channel cannot be null or empty.");
        }
        return !TextUtils.isEmpty(str);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("anythink", "SubChannel Error: The subChannel cannot be null or empty.");
        }
        return !TextUtils.isEmpty(str);
    }

    public static boolean c(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 50) {
                Log.e("anythink", "Invalid ScenarioId(" + str + "):The length of ScenarioId must be between 1-50.");
            } else {
                if (!Pattern.matches(".*[\\u4E00-\\u9FFF\\s]+.*", str)) {
                    return true;
                }
                Log.e("anythink", "Invalid ScenarioId(" + str + "):ScenarioId cannot contain spaces or chinese characters.");
            }
        }
        return false;
    }

    public static String d(String str) {
        return (!TextUtils.isEmpty(str) && c(str)) ? str : "";
    }

    public static ATShowConfig e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new ATShowConfig.Builder().scenarioId(str).build();
    }

    public static String a(String str, String str2, long j) {
        return str + "_" + str2 + "_" + j;
    }

    public static String b(String str, String str2, long j) {
        return a(str, str2, j) + "_refresh";
    }

    public static String f(String str) {
        str.hashCode();
        switch (str) {
            case "0":
                return com.anythink.core.common.d.i.o.a;
            case "1":
                return com.anythink.core.common.d.i.o.b;
            case "2":
                return com.anythink.core.common.d.i.o.c;
            case "3":
                return com.anythink.core.common.d.i.o.d;
            case "4":
                return com.anythink.core.common.d.i.o.e;
            default:
                return "";
        }
    }

    public static JSONObject a(Context context, String str, String str2, int i, int i2) {
        com.anythink.core.a.a.a(context);
        int[] iArrA = com.anythink.core.a.a.a(i);
        int i3 = iArrA[0];
        int i4 = iArrA[1];
        com.anythink.core.a.a.a(context);
        bq bqVarA = com.anythink.core.a.a.a(str2, i);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sr", "tp");
            jSONObject.put("rid", str);
            jSONObject.put("ads", i3);
            jSONObject.put("ahs", i4);
            jSONObject.put("pds", bqVarA.c);
            jSONObject.put("phs", bqVarA.d);
            jSONObject.put("ap", i2);
            jSONObject.put("tpl", str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String a(Context context) {
        String strC = com.anythink.core.common.d.s.b().C();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(l.d(context));
        stringBuffer.append("&");
        stringBuffer.append(l.f());
        stringBuffer.append("&");
        stringBuffer.append(strC);
        stringBuffer.append("&");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("&");
        stringBuffer.append(new Random().nextInt(10000));
        return n.a(stringBuffer.toString());
    }

    public static void a(List<by> list, by byVar) {
        if (list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(byVar);
            return;
        }
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            boolean z = true;
            if (k.a(byVar, list.get(i2)) <= 0) {
                list.add(i2, byVar);
            } else if (i2 == i) {
                list.add(byVar);
            } else {
                z = false;
            }
            if (z) {
                return;
            }
        }
    }

    private static boolean a(List<by> list, by byVar, by byVar2, int i, int i2, boolean z) {
        if (z && byVar.l() == -1) {
            list.add(i, byVar2);
            return true;
        }
        if (k.a(byVar2, byVar) <= 0) {
            list.add(i, byVar2);
            return true;
        }
        if (i != i2) {
            return false;
        }
        list.add(byVar2);
        return true;
    }

    private static String d(Context context) {
        String strC = com.anythink.core.common.d.s.b().C();
        if (TextUtils.isEmpty(strC)) {
            strC = l.d(context) + l.f();
        }
        return n.a(strC + UUID.randomUUID().toString());
    }

    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.removeJavascriptInterface("searchBoxjavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webView.getSettings().setSavePassword(false);
    }

    public static double a(by byVar) {
        if (byVar != null) {
            return byVar.aB();
        }
        return 0.0d;
    }

    public static double b(by byVar) {
        if (byVar != null) {
            return byVar.j();
        }
        return 0.0d;
    }

    public static double c(by byVar) {
        if (byVar == null) {
            return 0.0d;
        }
        double dAB = byVar.aB();
        if (dAB <= 0.0d) {
            return dAB;
        }
        try {
            if (!byVar.w()) {
                return dAB;
            }
            double dBx = byVar != null ? byVar.bx() : 0.0d;
            return dBx > 0.0d ? dAB * dBx : dAB;
        } catch (Throwable unused) {
            return dAB;
        }
    }

    private static double d(by byVar) {
        if (byVar != null) {
            return byVar.bx();
        }
        return 0.0d;
    }

    private static void a(String str, List<by> list) {
        if (list != null) {
            try {
                StringBuilder sb = new StringBuilder();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    by byVar = list.get(i);
                    sb.append("\n").append(i).append(" --> adSourceId: ").append(byVar.G()).append(", ").append(byVar.o()).append(", real: ").append(byVar.K()).append(", sort: ").append(a(byVar));
                    String strM = byVar.M();
                    if (!TextUtils.isEmpty(strM)) {
                        sb.append(", errorMsg: ").append(strM);
                    }
                }
                Log.e(str, sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String a() {
        return TextUtils.isEmpty("UA_6.6.40") ? "UA_0.0.0" : "UA_6.6.40";
    }

    private static String a(com.anythink.core.common.h.w wVar) {
        com.anythink.core.common.h.y yVarF;
        String str = wVar.s() + wVar.h();
        if ((wVar instanceof bl) && (yVarF = wVar.f()) != null) {
            str = yVarF.B() != 2 ? b(wVar) + wVar.s() + wVar.h() : b(wVar) + wVar.s();
        }
        return n.a(str + (com.anythink.core.common.d.s.b().g() != null ? com.anythink.core.common.d.s.b().g().getPackageName() : ""));
    }

    private static String b(com.anythink.core.common.h.w wVar) {
        return wVar instanceof bl ? ((bl) wVar).N() : "";
    }

    public static boolean b() {
        try {
            Map<String, Object> mapM = com.anythink.core.common.d.s.b().m();
            return mapM != null && mapM.containsKey(ATCustomRuleKeys.AGE) && Integer.parseInt(mapM.get(ATCustomRuleKeys.AGE).toString()) <= 13;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(Map<String, Object> map, com.anythink.core.common.h.n nVar) {
        if (nVar == null || nVar.Z() >= 100000) {
            return;
        }
        map.put("anythink_tracking_info", nVar);
        map.put("anythink_placement_id", nVar.aQ());
    }

    public static boolean b(Context context) {
        return ae.a().a(context);
    }

    public static boolean c(Context context) {
        return ae.a().b(context);
    }

    public static boolean c() {
        return ae.a().b();
    }

    private static int a(int i, int[] iArr, int i2) {
        if (iArr == null) {
            return i2;
        }
        for (int i3 : iArr) {
            if (i == i3) {
                return i;
            }
        }
        return i2;
    }

    public static List<by> a(List<by> list, com.anythink.core.common.j.f fVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap map = new HashMap(3);
        ArrayList arrayList = new ArrayList();
        for (by byVar : list) {
            double dA = a(byVar);
            List arrayList2 = (List) linkedHashMap.get(String.valueOf(dA));
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(String.valueOf(dA), arrayList2);
            }
            Integer num = (Integer) map.get(String.valueOf(dA));
            if (num == null) {
                num = 0;
            }
            map.put(String.valueOf(dA), Integer.valueOf(num.intValue() + byVar.ag()));
            arrayList2.add(byVar);
        }
        int i = 0;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            List<by> list2 = (List) entry.getValue();
            int iIntValue = ((Integer) map.get(entry.getKey())).intValue();
            int i2 = -1;
            while (list2.size() > 0) {
                if (list2.size() == 1) {
                    by byVar2 = (by) list2.get(0);
                    arrayList.add(byVar2);
                    list2.remove(0);
                    if (fVar != null) {
                        fVar.a(byVar2, i, i2);
                    }
                    i++;
                    break;
                }
                int iNextInt = a.nextInt(iIntValue) + 1;
                int iAg = 0;
                for (by byVar3 : list2) {
                    if (byVar3.ag() + iAg >= iNextInt) {
                        arrayList.add(byVar3);
                        list2.remove(byVar3);
                        iIntValue -= byVar3.ag();
                        if (i2 == -1) {
                            i2 = 0;
                        }
                        if (fVar != null) {
                            fVar.a(byVar3, i, i2);
                        }
                        i2++;
                        i++;
                        break;
                    }
                    iAg += byVar3.ag();
                }
            }
        }
        return arrayList;
    }

    public static JSONObject a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < stackTraceElementArr.length; i++) {
                    String className = stackTraceElementArr[i].getClassName();
                    if (!className.startsWith("com.anythink")) {
                        jSONArray.put(stackTraceElementArr[i].toString());
                        try {
                            jSONArray2.put(Class.forName(className).getSuperclass().getName());
                        } catch (Throwable unused) {
                            jSONArray2.put("fail");
                        }
                        if (jSONArray.length() >= 5) {
                            break;
                        }
                    }
                }
                jSONObject.put("stacks", jSONArray);
                jSONObject.put("classes", jSONArray2);
            } catch (Throwable unused2) {
            }
            return jSONObject;
        } catch (Throwable unused3) {
            return null;
        }
    }

    public static boolean a(List<String> list, String str) {
        return list == null || list.size() <= 0 || list.contains(str);
    }

    public static boolean b(List<String> list, String str) {
        return list != null && list.size() > 0 && list.contains(str);
    }

    public static int e(int i) {
        if (c(i)) {
            return 1;
        }
        return b(i) ? 2 : 0;
    }
}
