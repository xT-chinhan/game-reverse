package com.kwad.sdk.core.webview.b.c;

import com.anythink.basead.exoplayer.k.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final List<String> aNE;

    static {
        ArrayList arrayList = new ArrayList();
        aNE = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add("image/jpeg");
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add("text/html");
        arrayList.add("image/gif");
        arrayList.add("image/png");
        arrayList.add("application/javascript");
        arrayList.add(o.e);
        arrayList.add(o.t);
        arrayList.add("application/json");
        arrayList.add("image/webp");
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add("application/octet-stream");
    }

    public static boolean fg(String str) {
        return aNE.contains(str);
    }
}
