package com.byazt.tl;

import com.bumptech.glide.load.Key;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 905, 20})
public class hn {
    public static JSONObject pr(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strDecode = URLDecoder.decode(str, Key.STRING_CHARSET_NAME);
            int iIndexOf = strDecode.indexOf(63);
            if (iIndexOf == -1) {
                return jSONObject;
            }
            Matcher matcher = Pattern.compile("([^&=]+)=((?:\\$\\{[^}]+\\})|[^&]+)").matcher(strDecode.substring(iIndexOf + 1));
            while (matcher.find()) {
                jSONObject.put(matcher.group(1), matcher.group(2));
            }
        } catch (Throwable th) {
        }
        return jSONObject;
    }
}
