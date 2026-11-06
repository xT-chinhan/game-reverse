package com.smartdigimkt.k2;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final String[] a = {"atwt:"};
    public static final Pattern b = Pattern.compile("atwt://(.+?)#(.+?)/(.+?)(\\?(.*?))?");
    public static final HashMap c = new HashMap();

    static {
        for (int i : com.smartdigimkt.k.u.b(9)) {
            c.put(com.smartdigimkt.b1.a.b(i), com.smartdigimkt.b1.a.a(i));
        }
    }

    public static String a(String str) {
        String path;
        int iLastIndexOf;
        String str2 = (String) c.get((TextUtils.isEmpty(str) || (path = Uri.parse(str).getPath()) == null || (iLastIndexOf = path.lastIndexOf(com.anythink.core.common.d.i.E)) == -1) ? "" : path.substring(iLastIndexOf + 1));
        return str2 == null ? "" : str2;
    }
}
