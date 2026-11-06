package com.anythink.core.common.l.a.a;

import com.anythink.core.api.ATSDK;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final String a;
    private final String b;
    private com.anythink.core.common.l.c.a c;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    private static boolean b(com.anythink.core.common.l.c.d dVar) {
        String strB = dVar != null ? dVar.b() : "";
        if (!ATSDK.isCnSDK()) {
            if ("app_strategy".equals(strB) || "placement_strategy".equals(strB) || "bid".equals(strB) || "tracking".equals(strB) || "agent".equals(strB)) {
                return true;
            }
        }
        com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
        return bVarA != null && bVarA.g(strB);
    }

    private static boolean a(String str) {
        return "app_strategy".equals(str) || "placement_strategy".equals(str) || "bid".equals(str) || "tracking".equals(str) || "agent".equals(str);
    }

    public final com.anythink.core.common.l.c.a a() {
        return this.c;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.l.a.a.a$a, reason: collision with other inner class name */
    private static class C0032a implements com.anythink.core.common.l.a.d {
        private final com.anythink.core.common.l.c.a a;
        private final int b;

        C0032a(com.anythink.core.common.l.c.a aVar, boolean z) {
            this.a = aVar;
            this.b = z ? 3 : 1;
        }

        @Override // com.anythink.core.common.l.a.d
        public final List<InetAddress> a(String str) {
            com.anythink.core.common.l.c.a aVar = this.a;
            if (aVar != null) {
                aVar.q();
                this.a.f(this.b);
            }
            return h.a(str, true, this.a);
        }
    }

    private static class b implements com.anythink.core.common.l.a.d {
        private final com.anythink.core.common.l.c.a a;
        private final int b;

        b(com.anythink.core.common.l.c.a aVar, boolean z) {
            this.a = aVar;
            this.b = z ? 3 : 1;
        }

        @Override // com.anythink.core.common.l.a.d
        public final List<InetAddress> a(String str) {
            com.anythink.core.common.l.c.a aVar = this.a;
            if (aVar != null) {
                aVar.q();
                this.a.f(this.b);
            }
            return h.a(str, false, this.a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    public final com.anythink.core.common.l.a.d a(com.anythink.core.common.l.c.d dVar) {
        com.anythink.core.e.b bVarA;
        boolean z;
        String strB = dVar != null ? dVar.b() : "";
        boolean z2 = false;
        if (ATSDK.isCnSDK()) {
            bVarA = com.anythink.core.e.d.a();
            if (bVarA == null && bVarA.g(strB)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            if ("app_strategy".equals(strB) || "placement_strategy".equals(strB) || "bid".equals(strB) || "tracking".equals(strB) || "agent".equals(strB)) {
                z = true;
            } else {
                bVarA = com.anythink.core.e.d.a();
                if (bVarA == null) {
                }
                z = false;
            }
        }
        com.anythink.core.common.l.c.a aVar = new com.anythink.core.common.l.c.a();
        aVar.d(this.a);
        aVar.e(this.b);
        aVar.c(com.anythink.core.common.l.c.g.a(dVar != null ? dVar.b() : ""));
        this.c = aVar;
        if (dVar != null && dVar.c()) {
            z2 = true;
        }
        if (z) {
            return new C0032a(aVar, z2);
        }
        return new b(aVar, z2);
    }
}
