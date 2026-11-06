package com.byazt.mcb;

import android.text.TextUtils;
import com.byazt.gu.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2461, 26})
public class qg {
    public static String n(String str, JSONObject jSONObject) {
        n nVarS;
        n.InterfaceC0244n interfaceC0244nN;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith("}") || (nVarS = w.n().s()) == null || (interfaceC0244nN = nVarS.n(str.substring(2, str.length() + (-1)))) == null) ? str : (String) interfaceC0244nN.n(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    public static Object n(Object obj, JSONObject jSONObject) {
        if (obj == null) {
            return null;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        return (strValueOf.startsWith("${") && strValueOf.endsWith("}")) ? n(strValueOf, jSONObject) : obj;
    }

    public static String qg(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || !str.contains("${")) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i = 0;
        while (i < length) {
            int iIndexOf = str.indexOf("${", i);
            if (iIndexOf < 0) {
                sb.append((CharSequence) str, i, length);
                break;
            }
            sb.append((CharSequence) str, i, iIndexOf);
            int i2 = iIndexOf + 2;
            int i3 = 1;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                char cCharAt = str.charAt(i2);
                if (cCharAt != '{') {
                    if (cCharAt == '}' && (i3 = i3 - 1) == 0) {
                        break;
                    }
                } else {
                    i3++;
                }
                i2++;
            }
            if (i2 < 0) {
                sb.append((CharSequence) str, iIndexOf, length);
                break;
            }
            i = i2 + 1;
            String strSubstring = str.substring(iIndexOf, i);
            if (n(strSubstring)) {
                sb.append(strSubstring);
            } else {
                String strN = n(strSubstring, jSONObject);
                sb.append(strN == null ? "" : String.valueOf(strN));
            }
        }
        return sb.toString();
    }

    private static boolean n(String str) {
        if (str != null && str.length() > 3) {
            String strTrim = str.substring(2, str.length() - 1).trim();
            if (strTrim.length() > 1 && strTrim.charAt(0) == '_' && strTrim.charAt(strTrim.length() - 1) == '_' && strTrim.indexOf(46) < 0) {
                return true;
            }
        }
        return false;
    }
}
