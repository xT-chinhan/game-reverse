package com.byazt.am;

import android.content.Context;
import com.byazt.ry.fw;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1646, 20})
public class hn {
    public static void pr(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            switch (i) {
                case 1:
                    linkedHashMap.put(pr(i2), str);
                    break;
            }
            if (fw.pr().pr(i2).x() != null) {
                fw.pr().pr(i2).x().pr(context, linkedHashMap);
            }
        } catch (Exception e) {
        }
    }

    public static String pr(Context context, int i, int i2) {
        String strPr;
        switch (i) {
            case 1:
                try {
                    if (fw.pr().pr(i2).x() != null) {
                        strPr = fw.pr().pr(i2).x().pr(context, pr(i2), "");
                    }
                    break;
                } catch (Exception e) {
                    strPr = "";
                    break;
                }
            default:
                strPr = "";
                break;
        }
        if (!(strPr instanceof String)) {
            return "";
        }
        return String.valueOf(strPr);
    }

    private static String pr(int i) {
        return "tnc_config".concat(String.valueOf(i));
    }
}
