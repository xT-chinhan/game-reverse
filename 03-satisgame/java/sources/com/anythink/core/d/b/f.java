package com.anythink.core.d.b;

import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.l;
import com.anythink.core.common.u.af;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final double a = -1.0d;
    private static final String b = "UserValueCalculator";
    private static final String[] c = {"MAX", "MIN", "AVG", "SUM", "COUNT"};
    private static final String[] d = {"=", ">", "<", "!=", ">=", "<="};
    private static final String[] e = {"OR", "AND"};
    private static final String[] f = {"DESC", "ASC"};
    private final e g;

    public f(e eVar) {
        this.g = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0038 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0038, B:12:0x003c, B:15:0x0046, B:17:0x004b, B:19:0x004f, B:24:0x0077, B:59:0x0139, B:61:0x013f, B:63:0x0145, B:65:0x0152, B:67:0x015d, B:68:0x017d, B:70:0x0183, B:72:0x0189, B:73:0x018c, B:74:0x018f, B:76:0x0195, B:78:0x019b, B:79:0x019e, B:80:0x01a1, B:82:0x01c0, B:83:0x01d5), top: B:101:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0046 A[Catch: Exception -> 0x002f, TRY_ENTER, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0038, B:12:0x003c, B:15:0x0046, B:17:0x004b, B:19:0x004f, B:24:0x0077, B:59:0x0139, B:61:0x013f, B:63:0x0145, B:65:0x0152, B:67:0x015d, B:68:0x017d, B:70:0x0183, B:72:0x0189, B:73:0x018c, B:74:0x018f, B:76:0x0195, B:78:0x019b, B:79:0x019e, B:80:0x01a1, B:82:0x01c0, B:83:0x01d5), top: B:101:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x004b A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0038, B:12:0x003c, B:15:0x0046, B:17:0x004b, B:19:0x004f, B:24:0x0077, B:59:0x0139, B:61:0x013f, B:63:0x0145, B:65:0x0152, B:67:0x015d, B:68:0x017d, B:70:0x0183, B:72:0x0189, B:73:0x018c, B:74:0x018f, B:76:0x0195, B:78:0x019b, B:79:0x019e, B:80:0x01a1, B:82:0x01c0, B:83:0x01d5), top: B:101:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x004e  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f7 A[PHI: r7
      0x00f7: PHI (r7v1 java.lang.String) = 
      (r7v0 java.lang.String)
      (r7v0 java.lang.String)
      (r7v0 java.lang.String)
      (r7v0 java.lang.String)
      (r7v21 java.lang.String)
     binds: [B:21:0x0071, B:22:0x0073, B:23:0x0075, B:25:0x007b, B:100:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:51:0x0107 A[Catch: Exception -> 0x0137, TRY_LEAVE, TryCatch #3 {Exception -> 0x0137, blocks: (B:49:0x00fb, B:51:0x0107), top: B:107:0x00fb }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0112  */
    /* JADX WARN: Code duplicated, block: B:56:0x011d A[Catch: Exception -> 0x0139, TRY_LEAVE, TryCatch #1 {Exception -> 0x0139, blocks: (B:54:0x0114, B:56:0x011d), top: B:103:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0150  */
    /* JADX WARN: Code duplicated, block: B:67:0x015d A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0038, B:12:0x003c, B:15:0x0046, B:17:0x004b, B:19:0x004f, B:24:0x0077, B:59:0x0139, B:61:0x013f, B:63:0x0145, B:65:0x0152, B:67:0x015d, B:68:0x017d, B:70:0x0183, B:72:0x0189, B:73:0x018c, B:74:0x018f, B:76:0x0195, B:78:0x019b, B:79:0x019e, B:80:0x01a1, B:82:0x01c0, B:83:0x01d5), top: B:101:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0183 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0038, B:12:0x003c, B:15:0x0046, B:17:0x004b, B:19:0x004f, B:24:0x0077, B:59:0x0139, B:61:0x013f, B:63:0x0145, B:65:0x0152, B:67:0x015d, B:68:0x017d, B:70:0x0183, B:72:0x0189, B:73:0x018c, B:74:0x018f, B:76:0x0195, B:78:0x019b, B:79:0x019e, B:80:0x01a1, B:82:0x01c0, B:83:0x01d5), top: B:101:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0189 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0038, B:12:0x003c, B:15:0x0046, B:17:0x004b, B:19:0x004f, B:24:0x0077, B:59:0x0139, B:61:0x013f, B:63:0x0145, B:65:0x0152, B:67:0x015d, B:68:0x017d, B:70:0x0183, B:72:0x0189, B:73:0x018c, B:74:0x018f, B:76:0x0195, B:78:0x019b, B:79:0x019e, B:80:0x01a1, B:82:0x01c0, B:83:0x01d5), top: B:101:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0195 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0038, B:12:0x003c, B:15:0x0046, B:17:0x004b, B:19:0x004f, B:24:0x0077, B:59:0x0139, B:61:0x013f, B:63:0x0145, B:65:0x0152, B:67:0x015d, B:68:0x017d, B:70:0x0183, B:72:0x0189, B:73:0x018c, B:74:0x018f, B:76:0x0195, B:78:0x019b, B:79:0x019e, B:80:0x01a1, B:82:0x01c0, B:83:0x01d5), top: B:101:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x019b A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0038, B:12:0x003c, B:15:0x0046, B:17:0x004b, B:19:0x004f, B:24:0x0077, B:59:0x0139, B:61:0x013f, B:63:0x0145, B:65:0x0152, B:67:0x015d, B:68:0x017d, B:70:0x0183, B:72:0x0189, B:73:0x018c, B:74:0x018f, B:76:0x0195, B:78:0x019b, B:79:0x019e, B:80:0x01a1, B:82:0x01c0, B:83:0x01d5), top: B:101:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01c0 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0038, B:12:0x003c, B:15:0x0046, B:17:0x004b, B:19:0x004f, B:24:0x0077, B:59:0x0139, B:61:0x013f, B:63:0x0145, B:65:0x0152, B:67:0x015d, B:68:0x017d, B:70:0x0183, B:72:0x0189, B:73:0x018c, B:74:0x018f, B:76:0x0195, B:78:0x019b, B:79:0x019e, B:80:0x01a1, B:82:0x01c0, B:83:0x01d5), top: B:101:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0035  */
    public final double a(int i, String str) {
        JSONObject jSONObject;
        int i2;
        String str2;
        String str3;
        JSONArray jSONArrayOptJSONArray;
        String str4;
        String strConcat;
        String strConcat2;
        String strConcat3;
        StringBuilder sb;
        String string;
        String str5;
        double d2;
        int iOptInt;
        String strOptString;
        int iOptInt2;
        String[] strArr;
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
        if (bVarB != null) {
            try {
                JSONObject jSONObjectP = bVarB.P();
                if (jSONObjectP != null) {
                    jSONObject = jSONObjectP.getJSONObject(String.valueOf(i));
                } else {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    jSONObject = a();
                }
                i2 = jSONObject.getInt("f");
                str2 = "";
                if (i2 >= 0) {
                    strArr = c;
                    if (i2 < strArr.length) {
                        str3 = strArr[i2];
                    } else {
                        str3 = "";
                    }
                } else {
                    str3 = "";
                }
                String string2 = jSONObject.getString("q_f");
                jSONArrayOptJSONArray = jSONObject.optJSONArray("w_c_f");
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("w_c_o");
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("w_c_v");
                JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("w_o");
                if (jSONArrayOptJSONArray != null || jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray.length() <= 0) {
                    str4 = str2;
                    strConcat = str4;
                } else {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        int i3 = 0;
                        while (i3 < jSONArrayOptJSONArray.length()) {
                            String string3 = jSONArrayOptJSONArray.getString(i3);
                            int i4 = jSONArrayOptJSONArray2.getInt(i3);
                            str4 = str2;
                            try {
                                String string4 = jSONArrayOptJSONArray3.getString(i3);
                                sb2.append(string3);
                                sb2.append(d[i4]);
                                if (af.a((CharSequence) string4) || string4.startsWith("strftime")) {
                                    sb2.append(string4);
                                } else {
                                    sb2.append("'").append(string4).append("'");
                                }
                                if (i3 != jSONArrayOptJSONArray.length() - 1 && jSONArrayOptJSONArray4 != null && i3 < jSONArrayOptJSONArray4.length()) {
                                    sb2.append(" ").append(e[jSONArrayOptJSONArray4.getInt(i3)]).append(" ");
                                }
                                i3++;
                                str2 = str4;
                            } catch (Exception unused) {
                            }
                        }
                        str4 = str2;
                        strConcat = "WHERE ".concat(String.valueOf(sb2));
                    } catch (Exception unused2) {
                        str4 = str2;
                    }
                }
                try {
                    strOptString = jSONObject.optString("o_f");
                    if (TextUtils.isEmpty(strOptString)) {
                        strConcat2 = str4;
                    } else {
                        strConcat2 = "ORDER BY ".concat(String.valueOf(strOptString));
                    }
                    try {
                        iOptInt2 = jSONObject.optInt("o", -1);
                        if (iOptInt2 != -1) {
                            strConcat2 = strConcat2 + " " + f[iOptInt2];
                        }
                    } catch (Exception unused3) {
                    }
                } catch (Exception unused4) {
                    strConcat2 = str4;
                }
                if (!jSONObject.isNull(l.a) || (iOptInt = jSONObject.optInt(l.a)) <= 0) {
                    strConcat3 = str4;
                } else {
                    strConcat3 = "LIMIT ".concat(String.valueOf(iOptInt));
                }
                sb = new StringBuilder();
                if (!TextUtils.isEmpty(strConcat)) {
                    sb.append(strConcat);
                    sb.append(" ");
                    sb.append("AND ");
                    sb.append("placement_id");
                    sb.append("=");
                    sb.append("'");
                    sb.append(str);
                    sb.append("'");
                }
                if (!TextUtils.isEmpty(strConcat2)) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(strConcat2);
                }
                if (!TextUtils.isEmpty(strConcat3)) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(strConcat3);
                }
                string = sb.toString();
                str5 = "SELECT " + string2 + " FROM user_value_placement";
                if (!TextUtils.isEmpty(string)) {
                    str5 = str5 + " " + string;
                }
                try {
                    double[] dArrA = this.g.a(new String[]{str3 + "(" + string2 + ")", "count(*)"}, "(" + str5 + ")");
                    d2 = dArrA[1];
                    if (d2 > 0.0d || (!jSONObject.isNull(l.a) && d2 < jSONObject.optInt(l.a))) {
                        return -1.0d;
                    }
                    double d3 = dArrA[0];
                    return d3;
                } catch (Exception unused5) {
                }
            } catch (Exception unused6) {
            }
        } else {
            jSONObject = null;
            if (jSONObject == null) {
                jSONObject = a();
            }
            i2 = jSONObject.getInt("f");
            str2 = "";
            if (i2 >= 0) {
                strArr = c;
                if (i2 < strArr.length) {
                    str3 = strArr[i2];
                } else {
                    str3 = "";
                }
            } else {
                str3 = "";
            }
            String string5 = jSONObject.getString("q_f");
            jSONArrayOptJSONArray = jSONObject.optJSONArray("w_c_f");
            JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("w_c_o");
            JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("w_c_v");
            JSONArray jSONArrayOptJSONArray7 = jSONObject.optJSONArray("w_o");
            if (jSONArrayOptJSONArray != null) {
                str4 = str2;
                strConcat = str4;
            } else {
                str4 = str2;
                strConcat = str4;
            }
            strOptString = jSONObject.optString("o_f");
            if (TextUtils.isEmpty(strOptString)) {
                strConcat2 = "ORDER BY ".concat(String.valueOf(strOptString));
            } else {
                strConcat2 = str4;
            }
            iOptInt2 = jSONObject.optInt("o", -1);
            if (iOptInt2 != -1) {
                strConcat2 = strConcat2 + " " + f[iOptInt2];
            }
            if (jSONObject.isNull(l.a)) {
                strConcat3 = str4;
            } else {
                strConcat3 = str4;
            }
            sb = new StringBuilder();
            if (!TextUtils.isEmpty(strConcat)) {
                sb.append(strConcat);
                sb.append(" ");
                sb.append("AND ");
                sb.append("placement_id");
                sb.append("=");
                sb.append("'");
                sb.append(str);
                sb.append("'");
            }
            if (!TextUtils.isEmpty(strConcat2)) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(strConcat2);
            }
            if (!TextUtils.isEmpty(strConcat3)) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(strConcat3);
            }
            string = sb.toString();
            str5 = "SELECT " + string5 + " FROM user_value_placement";
            if (!TextUtils.isEmpty(string)) {
                str5 = str5 + " " + string;
            }
            double[] dArrA2 = this.g.a(new String[]{str3 + "(" + string5 + ")", "count(*)"}, "(" + str5 + ")");
            d2 = dArrA2[1];
            if (d2 > 0.0d) {
            }
            return -1.0d;
        }
        return -1.0d;
    }

    private static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("f", 2);
            jSONObject.put("q_f", e.a.h);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("type");
            jSONObject.put("w_c_f", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0);
            jSONObject.put("w_c_o", jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put("4");
            jSONObject.put("w_c_v", jSONArray3);
            jSONObject.put("o_f", e.a.i);
            jSONObject.put("o", 0);
            jSONObject.put(l.a, 3);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
