package com.byazt.so;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.dd.fw;
import com.byazt.gm.fo;
import com.byazt.hg.of;
import com.byazt.ik.hn;
import com.byazt.qx.w;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1263, 37})
public class pr {
    public static final HashSet<String> pr = new HashSet<>(Arrays.asList("interactiveFinish", "nextVideoCancel", "haptic", "closeWidget", "dismiss", "openNewAdPage"));

    public static void pr(w wVar, hw hwVar, of ofVar, Context context, String str, fw.pr prVar, com.byazt.uq.fw fwVar, hn hnVar) {
        if (prVar == null) {
        }
        Map<String, Object> mapHn = prVar.hn();
        int iPr = 0;
        switch (str) {
            case "interactiveFinish":
                if (mapHn != null) {
                    try {
                        Object obj = mapHn.get("reduce_duration");
                        if (obj instanceof Integer) {
                            iPr = fo.pr(ofVar, ((Integer) obj).intValue());
                        }
                    } catch (NumberFormatException e) {
                    }
                }
                if (wVar != null) {
                    wVar.hw(iPr);
                    break;
                }
                break;
            case "nextVideoCancel":
                if (hwVar != null) {
                    hwVar.pr();
                    break;
                }
                break;
            case "haptic":
                if (mapHn != null) {
                    Object obj2 = mapHn.get("params");
                    if ((obj2 instanceof String) && !TextUtils.isEmpty((String) obj2)) {
                        try {
                            com.byazt.tm.hn.pr(new JSONObject(String.valueOf(obj2)), context, ofVar);
                        } catch (JSONException e2) {
                            return;
                        }
                        break;
                    }
                }
                break;
            case "closeWidget":
                if (fwVar != null) {
                    fwVar.c();
                    break;
                }
                break;
            case "dismiss":
                if (hnVar != null) {
                    hnVar.hw(8);
                    break;
                }
                break;
            case "openNewAdPage":
                if (mapHn != null) {
                    Object obj3 = mapHn.get("second_page_type");
                    String strValueOf = obj3 != null ? String.valueOf(obj3) : "";
                    if (!TextUtils.isEmpty(strValueOf)) {
                        try {
                            iPr = Integer.parseInt(strValueOf);
                            break;
                        } catch (NumberFormatException e3) {
                        }
                    }
                }
                if (fwVar != null) {
                    fwVar.pr(iPr);
                    break;
                }
                break;
        }
    }
}
