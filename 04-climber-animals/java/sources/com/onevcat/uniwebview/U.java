package com.onevcat.uniwebview;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public abstract class U {
    public static C0734m a(String dataUrl) throws UnsupportedEncodingException {
        byte[] data;
        Intrinsics.checkNotNullParameter(dataUrl, "dataUrl");
        MatchResult matchResultMatchEntire = new Regex("^data:([-\\w]+/[-+\\w.]+)?(;?\\w+=[-\\w]+)*(;base64)?,(.*)").matchEntire(dataUrl);
        if (matchResultMatchEntire == null) {
            return null;
        }
        String str = matchResultMatchEntire.getGroupValues().get(1);
        boolean zAreEqual = Intrinsics.areEqual(";base64", matchResultMatchEntire.getGroupValues().get(3));
        String str2 = matchResultMatchEntire.getGroupValues().get(4);
        if (zAreEqual) {
            data = Base64.decode(str2, 0);
        } else {
            String strDecode = URLDecoder.decode(str2, StandardCharsets.UTF_8.name());
            Intrinsics.checkNotNullExpressionValue(strDecode, "decode(dataString, StandardCharsets.UTF_8.name())");
            data = strDecode.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(data, "this as java.lang.String).getBytes(charset)");
        }
        Intrinsics.checkNotNullExpressionValue(data, "data");
        return new C0734m(str, data);
    }
}
