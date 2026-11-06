package com.anythink.core.c.b;

import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.ah;
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

    /* JADX WARN: Code duplicated, block: B:103:0x0243  */
    /* JADX WARN: Code duplicated, block: B:11:0x0037 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0037, B:12:0x003b, B:15:0x0046, B:17:0x004b, B:19:0x0050, B:24:0x0078, B:51:0x00fe, B:69:0x014b, B:71:0x0151, B:73:0x0157, B:75:0x0164, B:77:0x016f, B:78:0x018f, B:80:0x0195, B:82:0x019b, B:83:0x019e, B:84:0x01a1, B:86:0x01a7, B:88:0x01ad, B:89:0x01b0, B:90:0x01b3, B:92:0x01d2, B:93:0x01e7, B:68:0x0148), top: B:109:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0046 A[Catch: Exception -> 0x002f, TRY_ENTER, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0037, B:12:0x003b, B:15:0x0046, B:17:0x004b, B:19:0x0050, B:24:0x0078, B:51:0x00fe, B:69:0x014b, B:71:0x0151, B:73:0x0157, B:75:0x0164, B:77:0x016f, B:78:0x018f, B:80:0x0195, B:82:0x019b, B:83:0x019e, B:84:0x01a1, B:86:0x01a7, B:88:0x01ad, B:89:0x01b0, B:90:0x01b3, B:92:0x01d2, B:93:0x01e7, B:68:0x0148), top: B:109:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x004b A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0037, B:12:0x003b, B:15:0x0046, B:17:0x004b, B:19:0x0050, B:24:0x0078, B:51:0x00fe, B:69:0x014b, B:71:0x0151, B:73:0x0157, B:75:0x0164, B:77:0x016f, B:78:0x018f, B:80:0x0195, B:82:0x019b, B:83:0x019e, B:84:0x01a1, B:86:0x01a7, B:88:0x01ad, B:89:0x01b0, B:90:0x01b3, B:92:0x01d2, B:93:0x01e7, B:68:0x0148), top: B:109:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x004f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0102  */
    /* JADX WARN: Code duplicated, block: B:57:0x0112 A[Catch: Exception -> 0x0145, TRY_LEAVE, TryCatch #4 {Exception -> 0x0145, blocks: (B:55:0x0106, B:57:0x0112), top: B:117:0x0106 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x011e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0129 A[Catch: Exception -> 0x0143, TRY_LEAVE, TryCatch #5 {Exception -> 0x0143, blocks: (B:60:0x0120, B:62:0x0129), top: B:119:0x0120 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0151 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0037, B:12:0x003b, B:15:0x0046, B:17:0x004b, B:19:0x0050, B:24:0x0078, B:51:0x00fe, B:69:0x014b, B:71:0x0151, B:73:0x0157, B:75:0x0164, B:77:0x016f, B:78:0x018f, B:80:0x0195, B:82:0x019b, B:83:0x019e, B:84:0x01a1, B:86:0x01a7, B:88:0x01ad, B:89:0x01b0, B:90:0x01b3, B:92:0x01d2, B:93:0x01e7, B:68:0x0148), top: B:109:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0162  */
    /* JADX WARN: Code duplicated, block: B:77:0x016f A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0037, B:12:0x003b, B:15:0x0046, B:17:0x004b, B:19:0x0050, B:24:0x0078, B:51:0x00fe, B:69:0x014b, B:71:0x0151, B:73:0x0157, B:75:0x0164, B:77:0x016f, B:78:0x018f, B:80:0x0195, B:82:0x019b, B:83:0x019e, B:84:0x01a1, B:86:0x01a7, B:88:0x01ad, B:89:0x01b0, B:90:0x01b3, B:92:0x01d2, B:93:0x01e7, B:68:0x0148), top: B:109:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0195 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0037, B:12:0x003b, B:15:0x0046, B:17:0x004b, B:19:0x0050, B:24:0x0078, B:51:0x00fe, B:69:0x014b, B:71:0x0151, B:73:0x0157, B:75:0x0164, B:77:0x016f, B:78:0x018f, B:80:0x0195, B:82:0x019b, B:83:0x019e, B:84:0x01a1, B:86:0x01a7, B:88:0x01ad, B:89:0x01b0, B:90:0x01b3, B:92:0x01d2, B:93:0x01e7, B:68:0x0148), top: B:109:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x019b A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0037, B:12:0x003b, B:15:0x0046, B:17:0x004b, B:19:0x0050, B:24:0x0078, B:51:0x00fe, B:69:0x014b, B:71:0x0151, B:73:0x0157, B:75:0x0164, B:77:0x016f, B:78:0x018f, B:80:0x0195, B:82:0x019b, B:83:0x019e, B:84:0x01a1, B:86:0x01a7, B:88:0x01ad, B:89:0x01b0, B:90:0x01b3, B:92:0x01d2, B:93:0x01e7, B:68:0x0148), top: B:109:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01a7 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0037, B:12:0x003b, B:15:0x0046, B:17:0x004b, B:19:0x0050, B:24:0x0078, B:51:0x00fe, B:69:0x014b, B:71:0x0151, B:73:0x0157, B:75:0x0164, B:77:0x016f, B:78:0x018f, B:80:0x0195, B:82:0x019b, B:83:0x019e, B:84:0x01a1, B:86:0x01a7, B:88:0x01ad, B:89:0x01b0, B:90:0x01b3, B:92:0x01d2, B:93:0x01e7, B:68:0x0148), top: B:109:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01ad A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0037, B:12:0x003b, B:15:0x0046, B:17:0x004b, B:19:0x0050, B:24:0x0078, B:51:0x00fe, B:69:0x014b, B:71:0x0151, B:73:0x0157, B:75:0x0164, B:77:0x016f, B:78:0x018f, B:80:0x0195, B:82:0x019b, B:83:0x019e, B:84:0x01a1, B:86:0x01a7, B:88:0x01ad, B:89:0x01b0, B:90:0x01b3, B:92:0x01d2, B:93:0x01e7, B:68:0x0148), top: B:109:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01d2 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:4:0x0020, B:6:0x0026, B:11:0x0037, B:12:0x003b, B:15:0x0046, B:17:0x004b, B:19:0x0050, B:24:0x0078, B:51:0x00fe, B:69:0x014b, B:71:0x0151, B:73:0x0157, B:75:0x0164, B:77:0x016f, B:78:0x018f, B:80:0x0195, B:82:0x019b, B:83:0x019e, B:84:0x01a1, B:86:0x01a7, B:88:0x01ad, B:89:0x01b0, B:90:0x01b3, B:92:0x01d2, B:93:0x01e7, B:68:0x0148), top: B:109:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x022c A[Catch: Exception -> 0x024c, TryCatch #1 {Exception -> 0x024c, blocks: (B:95:0x0215, B:97:0x022c, B:99:0x0232, B:101:0x023b, B:104:0x0245, B:102:0x023f), top: B:111:0x0215 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0034  */
    public final double a(int i, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        int i2;
        String str2;
        JSONArray jSONArrayOptJSONArray;
        String str3;
        String strConcat;
        String strConcat2;
        String strConcat3;
        StringBuilder sb;
        String string;
        String str4;
        double d2;
        double d3;
        int iOptInt;
        String strOptString;
        int iOptInt2;
        String[] strArr;
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        if (bVarB != null) {
            try {
                JSONObject jSONObjectY = bVarB.Y();
                if (jSONObjectY != null) {
                    jSONObject = jSONObjectY.getJSONObject(String.valueOf(i));
                } else {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    jSONObject = a();
                }
                jSONObject2 = jSONObject;
                i2 = jSONObject2.getInt(com.anythink.basead.b.f.a);
                String str5 = "";
                if (i2 >= 0) {
                    strArr = c;
                    if (i2 < strArr.length) {
                        str2 = strArr[i2];
                    } else {
                        str2 = "";
                    }
                } else {
                    str2 = "";
                }
                String string2 = jSONObject2.getString("q_f");
                jSONArrayOptJSONArray = jSONObject2.optJSONArray("w_c_f");
                JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("w_c_o");
                JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("w_c_v");
                JSONArray jSONArrayOptJSONArray4 = jSONObject2.optJSONArray("w_o");
                try {
                    try {
                        try {
                            if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray.length() > 0) {
                                try {
                                    StringBuilder sb2 = new StringBuilder();
                                    int i3 = 0;
                                    while (i3 < jSONArrayOptJSONArray.length()) {
                                        String string3 = jSONArrayOptJSONArray.getString(i3);
                                        int i4 = jSONArrayOptJSONArray2.getInt(i3);
                                        str3 = str5;
                                        try {
                                            String string4 = jSONArrayOptJSONArray3.getString(i3);
                                            sb2.append(string3);
                                            sb2.append(d[i4]);
                                            if (ah.a((CharSequence) string4) || string4.startsWith("strftime")) {
                                                sb2.append(string4);
                                            } else {
                                                sb2.append("'").append(string4).append("'");
                                            }
                                            if (i3 != jSONArrayOptJSONArray.length() - 1 && jSONArrayOptJSONArray4 != null && i3 < jSONArrayOptJSONArray4.length()) {
                                                sb2.append(" ").append(e[jSONArrayOptJSONArray4.getInt(i3)]).append(" ");
                                            }
                                            i3++;
                                            str5 = str3;
                                        } catch (Exception e2) {
                                            e = e2;
                                            e.getMessage();
                                            strConcat = str3;
                                            strOptString = jSONObject2.optString("o_f");
                                            if (TextUtils.isEmpty(strOptString)) {
                                                strConcat2 = str3;
                                            } else {
                                                strConcat2 = "ORDER BY ".concat(String.valueOf(strOptString));
                                            }
                                            iOptInt2 = jSONObject2.optInt("o", -1);
                                            if (iOptInt2 != -1) {
                                                strConcat2 = strConcat2 + " " + f[iOptInt2];
                                            }
                                            if (jSONObject2.isNull(com.kuaishou.weapon.p0.t.d)) {
                                                strConcat3 = str3;
                                            } else {
                                                strConcat3 = str3;
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
                                            str4 = "SELECT " + string2 + " FROM user_value_placement";
                                            if (!TextUtils.isEmpty(string)) {
                                                str4 = str4 + " " + string;
                                            }
                                            double[] dArrA = this.g.a(new String[]{str2 + "(" + string2 + ")", "count(*)"}, "(" + str4 + ")");
                                            d2 = dArrA[1];
                                            if (d2 > 0.0d) {
                                                d3 = -1.0d;
                                            } else {
                                                d3 = -1.0d;
                                            }
                                            Object[] objArr = new Object[4];
                                            Double.valueOf(d3);
                                            return d3;
                                        }
                                    }
                                    str3 = str5;
                                    strConcat = "WHERE ".concat(String.valueOf(sb2));
                                } catch (Exception e3) {
                                    e = e3;
                                    str3 = str5;
                                }
                                strOptString = jSONObject2.optString("o_f");
                                if (TextUtils.isEmpty(strOptString)) {
                                    strConcat2 = "ORDER BY ".concat(String.valueOf(strOptString));
                                } else {
                                    strConcat2 = str3;
                                }
                                iOptInt2 = jSONObject2.optInt("o", -1);
                                if (iOptInt2 != -1) {
                                    strConcat2 = strConcat2 + " " + f[iOptInt2];
                                }
                                if (jSONObject2.isNull(com.kuaishou.weapon.p0.t.d) || (iOptInt = jSONObject2.optInt(com.kuaishou.weapon.p0.t.d)) <= 0) {
                                    strConcat3 = str3;
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
                                str4 = "SELECT " + string2 + " FROM user_value_placement";
                                if (!TextUtils.isEmpty(string)) {
                                    str4 = str4 + " " + string;
                                }
                                double[] dArrA2 = this.g.a(new String[]{str2 + "(" + string2 + ")", "count(*)"}, "(" + str4 + ")");
                                d2 = dArrA2[1];
                                if (d2 > 0.0d || (!jSONObject2.isNull(com.kuaishou.weapon.p0.t.d) && d2 < jSONObject2.optInt(com.kuaishou.weapon.p0.t.d))) {
                                    d3 = -1.0d;
                                } else {
                                    d3 = dArrA2[0];
                                }
                                Object[] objArr2 = new Object[4];
                                Double.valueOf(d3);
                                return d3;
                            }
                            str3 = "";
                            iOptInt2 = jSONObject2.optInt("o", -1);
                            if (iOptInt2 != -1) {
                                strConcat2 = strConcat2 + " " + f[iOptInt2];
                            }
                        } catch (Exception e4) {
                            e = e4;
                            e.getMessage();
                        }
                        strOptString = jSONObject2.optString("o_f");
                        if (TextUtils.isEmpty(strOptString)) {
                            strConcat2 = "ORDER BY ".concat(String.valueOf(strOptString));
                        } else {
                            strConcat2 = str3;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        strConcat2 = str3;
                    }
                    double[] dArrA3 = this.g.a(new String[]{str2 + "(" + string2 + ")", "count(*)"}, "(" + str4 + ")");
                    d2 = dArrA3[1];
                    if (d2 > 0.0d) {
                        d3 = -1.0d;
                    } else {
                        d3 = -1.0d;
                    }
                    Object[] objArr3 = new Object[4];
                    Double.valueOf(d3);
                    return d3;
                } catch (Exception e6) {
                    e = e6;
                }
                strConcat = str3;
                if (jSONObject2.isNull(com.kuaishou.weapon.p0.t.d)) {
                    strConcat3 = str3;
                } else {
                    strConcat3 = str3;
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
                str4 = "SELECT " + string2 + " FROM user_value_placement";
                if (!TextUtils.isEmpty(string)) {
                    str4 = str4 + " " + string;
                }
            } catch (Exception e7) {
                e = e7;
            }
        } else {
            jSONObject = null;
            if (jSONObject == null) {
                jSONObject = a();
            }
            jSONObject2 = jSONObject;
            i2 = jSONObject2.getInt(com.anythink.basead.b.f.a);
            String str6 = "";
            if (i2 >= 0) {
                strArr = c;
                if (i2 < strArr.length) {
                    str2 = strArr[i2];
                } else {
                    str2 = "";
                }
            } else {
                str2 = "";
            }
            String string5 = jSONObject2.getString("q_f");
            jSONArrayOptJSONArray = jSONObject2.optJSONArray("w_c_f");
            JSONArray jSONArrayOptJSONArray5 = jSONObject2.optJSONArray("w_c_o");
            JSONArray jSONArrayOptJSONArray6 = jSONObject2.optJSONArray("w_c_v");
            JSONArray jSONArrayOptJSONArray7 = jSONObject2.optJSONArray("w_o");
            if (jSONArrayOptJSONArray == null) {
                str3 = "";
                strConcat = str3;
            } else {
                str3 = "";
                strConcat = str3;
            }
            strOptString = jSONObject2.optString("o_f");
            if (TextUtils.isEmpty(strOptString)) {
                strConcat2 = "ORDER BY ".concat(String.valueOf(strOptString));
            } else {
                strConcat2 = str3;
            }
            iOptInt2 = jSONObject2.optInt("o", -1);
            if (iOptInt2 != -1) {
                strConcat2 = strConcat2 + " " + f[iOptInt2];
            }
            if (jSONObject2.isNull(com.kuaishou.weapon.p0.t.d)) {
                strConcat3 = str3;
            } else {
                strConcat3 = str3;
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
            str4 = "SELECT " + string5 + " FROM user_value_placement";
            if (!TextUtils.isEmpty(string)) {
                str4 = str4 + " " + string;
            }
            double[] dArrA4 = this.g.a(new String[]{str2 + "(" + string5 + ")", "count(*)"}, "(" + str4 + ")");
            d2 = dArrA4[1];
            if (d2 > 0.0d) {
                d3 = -1.0d;
            } else {
                d3 = -1.0d;
            }
            Object[] objArr4 = new Object[4];
            Double.valueOf(d3);
            return d3;
        }
        e.getMessage();
        return -1.0d;
    }

    private static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.anythink.basead.b.f.a, 2);
            jSONObject.put("q_f", "price");
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
            jSONObject.put(com.kuaishou.weapon.p0.t.d, 3);
        } catch (JSONException e2) {
            Object[] objArr = new Object[1];
            e2.getMessage();
        }
        return jSONObject;
    }
}
