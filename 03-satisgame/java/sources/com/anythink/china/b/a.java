package com.anythink.china.b;

import com.anythink.core.common.u.j;
import com.byazt.ho.BaseConstants;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final String a = j.b(b.a);
    public static final String b = j.b(b.b);

    public static class b {
        public static final String a = "TW9icmFpbg==";
        public static final String b = "QWxleEdyb21vcmU=";
    }

    /* JADX INFO: renamed from: com.anythink.china.b.a$a, reason: collision with other inner class name */
    public static class C0008a {
        public static final String a;
        public static final String b;
        public static final String c;
        public static final String d;

        static {
            String str = "https://" + com.anythink.core.common.g.a.a() + "/v2/open/hf";
            a = str;
            b = str.replace(BaseConstants.SCHEME_HTTPS, "http");
            String str2 = "https://" + com.anythink.core.common.g.a.b() + "/v2/open/dev";
            c = str2;
            d = str2.replace(BaseConstants.SCHEME_HTTPS, "http");
        }
    }
}
