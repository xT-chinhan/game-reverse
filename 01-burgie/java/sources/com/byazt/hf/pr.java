package com.byazt.hf;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hg.fw;
import com.byazt.sd.zo;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 219, 37})
public class pr {
    public static String pr(String str) {
        if (!ho.hn() || TextUtils.isEmpty(str)) {
            return str;
        }
        fw fwVar = new fw(zo.nt().ve());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = fwVar.hw().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append("&").append(fwVar.pr());
                } else {
                    sb.append("?").append(fwVar.pr());
                }
            }
        }
        return sb.toString();
    }
}
