package com.byazt.igw;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.ca.c;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.vkw.g;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.qa;
import com.byazt.zs.uc;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 77, 13})
public class hw {
    public static String pr;

    public static void pr(JSONObject jSONObject) {
        if (!iu.zo.equals("privacy")) {
            try {
                com.byazt.apo.pr prVarX = ((g) uc.pr("device_info_new")).x(!com.byazt.mp.pr.hw());
                float fHw = 0.0f;
                float fPr = prVarX == null ? 0.0f : prVarX.pr();
                if (prVarX != null) {
                    fHw = prVarX.hw();
                }
                jSONObject.put("latitude", fPr);
                jSONObject.put("longitude", fHw);
            } catch (JSONException e) {
            }
        }
    }

    public static void pr(com.byazt.qe.x xVar, List<String> list) {
        if (!iu.zo.equals("privacy") && xVar.pr()) {
            list.add("android.permission.ACCESS_COARSE_LOCATION");
            list.add("android.permission.ACCESS_FINE_LOCATION");
        }
    }

    public static void hw(JSONObject jSONObject) {
        com.byazt.apo.pr prVarX;
        if (!iu.zo.equals("privacy") && (prVarX = ((g) uc.pr("device_info_new")).x(!com.byazt.mp.pr.hw())) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", prVarX.pr());
                jSONObject2.put("longitude", prVarX.hw());
                jSONObject.put("geo", jSONObject2);
            } catch (Exception e) {
            }
        }
    }

    public static void hn(JSONObject jSONObject) {
        try {
            if (iu.zo.equals("privacy")) {
                jSONObject.put("imei_md5", pr());
            } else {
                jSONObject.put("imei", DeviceUtils.pr((Boolean) null));
            }
        } catch (JSONException e) {
        }
    }

    public static String pr() {
        if (TextUtils.isEmpty(pr)) {
            String strPr = DeviceUtils.pr((Boolean) null);
            if (!TextUtils.isEmpty(strPr)) {
                pr = c.hw(strPr);
            }
        }
        return pr;
    }

    public static void pr(Context context, JSONObject jSONObject) {
        if (!iu.zo.equals("privacy")) {
            try {
                JSONArray jSONArrayPr = qa.pr(context);
                if (jSONArrayPr != null) {
                    jSONObject.put("app_list", jSONArrayPr);
                }
            } catch (JSONException e) {
            }
        }
    }

    public static void hw() {
        if (!iu.zo.equals("privacy")) {
            ((g) uc.pr("device_info_new")).x(!com.byazt.mp.pr.hw());
        }
    }

    public static void pr(String str) {
        if (!iu.zo.equals("privacy")) {
            com.byazt.is.hn.hw().pr(str);
        }
    }

    public static boolean hw(String str) {
        if (iu.zo.equals("privacy")) {
            return false;
        }
        return qa.pr(str);
    }

    public static void pr(Context context) {
        if (iu.zo.equals("privacy") || (a.hw().ic() & 8) != 0) {
            return;
        }
        pr.pr(context);
    }

    public static File hw(Context context) {
        if (iu.zo.equals("privacy")) {
            return com.byazt.ca.uc.pr(context, "Download/Pangolin", false, null);
        }
        return com.byazt.ca.uc.pr(context, Environment.DIRECTORY_DOWNLOADS, false, null);
    }
}
