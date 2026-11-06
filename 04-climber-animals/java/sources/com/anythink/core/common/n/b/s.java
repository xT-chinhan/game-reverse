package com.anythink.core.common.n.b;

import androidx.browser.trusted.sharing.ShareTarget;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class s extends ae {
    private static final x a = x.a(ShareTarget.ENCODING_TYPE_URL_ENCODED);
    private final List<String> b;
    private final List<String> c;

    s(List<String> list, List<String> list2) {
        this.b = com.anythink.core.common.n.b.a.c.a(list);
        this.c = com.anythink.core.common.n.b.a.c.a(list2);
    }

    private int c() {
        return this.b.size();
    }

    private String a(int i) {
        return this.b.get(i);
    }

    private String c(int i) {
        return this.c.get(i);
    }

    @Override // com.anythink.core.common.n.b.ae
    public final x a() {
        return a;
    }

    @Override // com.anythink.core.common.n.b.ae
    public final long b() {
        return a((com.anythink.core.common.n.c.d) null, true);
    }

    @Override // com.anythink.core.common.n.b.ae
    public final void a(com.anythink.core.common.n.c.d dVar) {
        a(dVar, false);
    }

    private long a(com.anythink.core.common.n.c.d dVar, boolean z) {
        com.anythink.core.common.n.c.c cVarC;
        if (z) {
            cVarC = new com.anythink.core.common.n.c.c();
        } else {
            cVarC = dVar.c();
        }
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                cVarC.l(38);
            }
            cVarC.b(this.b.get(i));
            cVarC.l(61);
            cVarC.b(this.c.get(i));
        }
        if (!z) {
            return 0L;
        }
        long jB = cVarC.b();
        cVarC.z();
        return jB;
    }

    public static final class a {
        private final List<String> a;
        private final List<String> b;
        private final Charset c;

        public a() {
            this(null);
        }

        private a(Charset charset) {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = charset;
        }

        private a a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.a.add(v.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, this.c));
            this.b.add(v.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, this.c));
            return this;
        }

        private a b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.a.add(v.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, this.c));
            this.b.add(v.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, this.c));
            return this;
        }

        private s a() {
            return new s(this.a, this.b);
        }
    }

    private String b(int i) {
        return v.a(this.b.get(i), true);
    }

    private String d(int i) {
        return v.a(this.c.get(i), true);
    }
}
