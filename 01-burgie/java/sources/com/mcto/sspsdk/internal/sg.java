package com.mcto.sspsdk.internal;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class sg {
    public String a;
    public int b;
    public int c;

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                sg sgVar = new sg();
                sgVar.a = jSONObject.optString(an.aI, "");
                try {
                    sgVar.b = Color.parseColor(jSONObject.optString(an.aF, ""));
                } catch (Exception e) {
                    sgVar.b = 0;
                }
                sgVar.c = jSONObject.optInt(an.aB, 0);
                arrayList.add(sgVar);
            } catch (Exception e2) {
            }
        }
        return arrayList;
    }

    public static CharSequence a(ArrayList arrayList, String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            if (str2 == null) {
                str2 = "";
            }
            map.put(str, str2);
        }
        return a(arrayList, map);
    }

    public static CharSequence a(ArrayList arrayList, HashMap map) {
        if (arrayList == null || arrayList.isEmpty()) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sg sgVar = (sg) it.next();
            if (sgVar != null && sgVar.a != null) {
                int length = spannableStringBuilder.length();
                String strReplace = sgVar.a;
                if (!map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        if (!TextUtils.isEmpty(str)) {
                            if (str2 == null) {
                                str2 = "";
                            }
                            strReplace = strReplace.replace(str, str2);
                        }
                    }
                }
                spannableStringBuilder.append((CharSequence) strReplace);
                int length2 = spannableStringBuilder.length();
                if (sgVar.b != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(sgVar.b), length, length2, 33);
                }
                if (sgVar.c > 0) {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(sgVar.c / 2, true), length, length2, 33);
                }
            }
        }
        return spannableStringBuilder;
    }
}
