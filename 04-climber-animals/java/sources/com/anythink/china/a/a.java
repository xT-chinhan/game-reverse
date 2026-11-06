package com.anythink.china.a;

import com.anythink.core.common.v.k;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final String a = k.b(b.a);
    public static final String b = k.b(b.b);

    public static class b {
        public static final String a = "TW9icmFpbg==";
        public static final String b = "QWxleEdyb21vcmU=";
    }

    /* JADX INFO: renamed from: com.anythink.china.a.a$a, reason: collision with other inner class name */
    public static class C0072a {
        public static final String a;
        public static final String b;

        static {
            String str = "https://" + com.anythink.core.common.g.a.a() + "/v2/open/hf";
            a = str;
            b = str.replace("https", "http");
        }
    }
}
