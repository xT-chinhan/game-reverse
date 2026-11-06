package com.anythink.core.common.m.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.m.b.g;
import com.anythink.core.common.n.a.h;
import com.anythink.core.common.n.a.m;
import com.anythink.core.common.n.b.q;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "a";
    private final String b;
    private final String c;
    private com.anythink.core.common.m.b.a d;

    public a(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    private static boolean b(com.anythink.core.common.m.b.d dVar) {
        com.anythink.core.d.b bVarA = com.anythink.core.d.d.a();
        return bVarA != null && bVarA.g(dVar != null ? dVar.b() : "");
    }

    public final com.anythink.core.common.m.b.a a() {
        return this.d;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.m.a.a.a$a, reason: collision with other inner class name */
    private static class C0088a implements com.anythink.core.common.m.a.d {
        private final com.anythink.core.common.m.b.a a;
        private final String b;

        public C0088a(com.anythink.core.common.m.b.a aVar, String str) {
            this.a = aVar;
            this.b = str;
        }

        @Override // com.anythink.core.common.m.a.d
        public final List<InetAddress> a(String str) throws UnknownHostException {
            Throwable th;
            ArrayList arrayList;
            String unused = a.a;
            Object[] objArr = new Object[1];
            List<InetAddress> listA = a(str, this.a);
            if (listA != null && !listA.isEmpty()) {
                return listA;
            }
            try {
                com.anythink.core.common.m.b.a aVar = this.a;
                aVar.p();
                com.anythink.core.common.n.a.c cVarA = com.anythink.core.common.n.a.c.a();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (!cVarA.b()) {
                    throw new IllegalArgumentException("init custom dns server failed.");
                }
                m mVarA = cVarA.a(new h(str));
                aVar.c(SystemClock.elapsedRealtime() - jElapsedRealtime);
                th = null;
                com.anythink.core.common.n.a.f fVarB = mVarA != null ? mVarA.b() : null;
                if (fVarB != null) {
                    aVar.a(fVarB.a());
                    aVar.a(fVarB.b());
                    aVar.a(fVarB.c());
                }
                InetAddress[] inetAddressArrA = mVarA != null ? mVarA.a() : null;
                if (inetAddressArrA == null || inetAddressArrA.length <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    Collections.addAll(arrayList, inetAddressArrA);
                    String unused2 = a.a;
                    Object[] objArr2 = new Object[2];
                    Integer.valueOf(arrayList.size());
                    aVar.k();
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    return arrayList;
                }
                if (th != null) {
                    throw new UnknownHostException(th + ": " + th.getMessage());
                }
                String str2 = "cant not resolve \"" + str + "\".";
                if (TextUtils.isEmpty(this.a.l())) {
                    this.a.c(str2);
                }
                throw new UnknownHostException(str2);
            } catch (Throwable th2) {
                th = th2;
                String unused3 = a.a;
                this.a.c(th + ": " + th.getMessage());
            }
        }

        private static List<InetAddress> a(String str, com.anythink.core.common.m.b.a aVar) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                List<InetAddress> listLookup = q.a.lookup(str);
                aVar.b(SystemClock.elapsedRealtime() - jElapsedRealtime);
                if (listLookup == null || listLookup.isEmpty()) {
                    return null;
                }
                String unused = a.a;
                Object[] objArr = new Object[2];
                Integer.valueOf(listLookup.size());
                return listLookup;
            } catch (Throwable th) {
                String unused2 = a.a;
                aVar.h();
                aVar.b(th + ": " + th.getMessage());
                return null;
            }
        }

        private static List<InetAddress> b(String str, com.anythink.core.common.m.b.a aVar) {
            aVar.p();
            com.anythink.core.common.n.a.c cVarA = com.anythink.core.common.n.a.c.a();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (!cVarA.b()) {
                throw new IllegalArgumentException("init custom dns server failed.");
            }
            m mVarA = cVarA.a(new h(str));
            aVar.c(SystemClock.elapsedRealtime() - jElapsedRealtime);
            com.anythink.core.common.n.a.f fVarB = mVarA != null ? mVarA.b() : null;
            if (fVarB != null) {
                aVar.a(fVarB.a());
                aVar.a(fVarB.b());
                aVar.a(fVarB.c());
            }
            InetAddress[] inetAddressArrA = mVarA != null ? mVarA.a() : null;
            if (inetAddressArrA == null || inetAddressArrA.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, inetAddressArrA);
            String unused = a.a;
            Object[] objArr = new Object[2];
            Integer.valueOf(arrayList.size());
            aVar.k();
            return arrayList;
        }
    }

    public final com.anythink.core.common.m.a.d a(com.anythink.core.common.m.b.d dVar) {
        com.anythink.core.d.b bVarA = com.anythink.core.d.d.a();
        if (!(bVarA != null && bVarA.g(dVar != null ? dVar.b() : ""))) {
            return null;
        }
        com.anythink.core.common.m.b.a aVar = new com.anythink.core.common.m.b.a();
        aVar.d(this.b);
        aVar.e(this.c);
        aVar.b(g.a(dVar.b()));
        this.d = aVar;
        return new C0088a(aVar, dVar != null ? dVar.b() : "");
    }
}
