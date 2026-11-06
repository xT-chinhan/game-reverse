package com.byazt.tn;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.ih.s;
import com.byazt.rg.l;
import com.byazt.vs.m;
import com.byazt.xz.x;
import com.byazt.za.d;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1895, 19})
public class n {
    public static final HashSet<String> n = new HashSet<>(Arrays.asList("interactiveFinish", "nextVideoCancel", "haptic", "closeWidget", "dismiss", "openNewAdPage"));

    /* JADX WARN: Code duplicated, block: B:82:0x0105  */
    public static void n(d dVar, qg qgVar, pk pkVar, Context context, String str, x.n nVar, l lVar, s sVar) {
        int i;
        int i2;
        if (nVar == null) {
        }
        Map<String, Object> mapS = nVar.s();
        str.hashCode();
        int iN = 0;
        switch (str) {
            case "businessStatusNotify":
                if (mapS != null) {
                    Object obj = mapS.get("type");
                    Object obj2 = mapS.get("status");
                    if ((obj instanceof Integer) && (obj2 instanceof Integer)) {
                        try {
                            i2 = Integer.parseInt(String.valueOf(obj));
                            try {
                                iN = Integer.parseInt(String.valueOf(obj2));
                                break;
                            } catch (NumberFormatException unused) {
                            }
                        } catch (NumberFormatException unused2) {
                            i2 = 0;
                        }
                        int i3 = iN;
                        iN = i2;
                        i = i3;
                    } else {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                dVar.n(iN, i);
                break;
            case "nextVideoCancel":
                if (qgVar != null) {
                    qgVar.n();
                    break;
                }
                break;
            case "openNewAdPage":
                if (mapS != null) {
                    Object obj3 = mapS.get("second_page_type");
                    String strValueOf = obj3 != null ? String.valueOf(obj3) : "";
                    if (!TextUtils.isEmpty(strValueOf)) {
                        try {
                            iN = Integer.parseInt(strValueOf);
                            break;
                        } catch (NumberFormatException unused3) {
                        }
                    }
                }
                if (lVar != null) {
                    lVar.n(iN);
                    break;
                }
                break;
            case "haptic":
                if (mapS != null) {
                    Object obj4 = mapS.get("params");
                    if ((obj4 instanceof String) && !TextUtils.isEmpty((String) obj4)) {
                        try {
                            com.byazt.bz.s.n(new JSONObject(String.valueOf(obj4)), context, pkVar);
                        } catch (JSONException unused4) {
                            return;
                        }
                        break;
                    }
                }
                break;
            case "closeWidget":
                if (lVar != null) {
                    lVar.l();
                    break;
                }
                break;
            case "interactiveFinish":
                if (mapS != null) {
                    try {
                        Object obj5 = mapS.get("reduce_duration");
                        if (obj5 instanceof Integer) {
                            iN = m.n(pkVar, ((Integer) obj5).intValue());
                        }
                    } catch (NumberFormatException unused5) {
                    }
                }
                if (dVar != null) {
                    dVar.qg(iN);
                    break;
                }
                break;
            case "dismiss":
                if (sVar != null) {
                    sVar.qg(8);
                    break;
                }
                break;
        }
    }
}
