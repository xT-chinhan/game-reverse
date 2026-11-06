package com.tapsdk.tapad.internal.download.m.e;

import android.net.ConnectivityManager;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import com.tapsdk.tapad.internal.download.i;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    private static final String c = "DownloadStrategy";
    private static final long d = 1048576;
    private static final long e = 5242880;
    private static final long f = 52428800;
    private static final long g = 104857600;
    private static final Pattern h = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");
    Boolean a = null;
    private ConnectivityManager b = null;

    public static class a {
        private volatile String a;
        private final boolean b = false;

        public a() {
        }

        public a(String str) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        void a(String str) {
            this.a = str;
        }

        public boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            if (this.a == null) {
                return ((a) obj).a == null;
            }
            return this.a.equals(((a) obj).a);
        }

        public int hashCode() {
            if (this.a == null) {
                return 0;
            }
            return this.a.hashCode();
        }
    }

    public static class b {
        private com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a a;
        private com.tapsdk.tapad.internal.download.core.breakpoint.c b;
        private int c;

        protected b(com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605a, int i, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
            this.a = interfaceC0605a;
            this.b = cVar;
            this.c = i;
        }

        public void a() throws IOException {
            com.tapsdk.tapad.internal.download.core.breakpoint.a aVarB = this.b.b(this.c);
            int iF = this.a.f();
            ResumeFailedCause resumeFailedCauseA = i.j().f().a(iF, aVarB.c() != 0, this.b, this.a.c("Etag"));
            if (resumeFailedCauseA != null) {
                throw new com.tapsdk.tapad.internal.download.m.f.f(resumeFailedCauseA);
            }
            if (i.j().f().a(iF, aVarB.c() != 0)) {
                throw new com.tapsdk.tapad.internal.download.m.f.i(iF, aVarB.c());
            }
        }
    }

    public int a(com.tapsdk.tapad.internal.download.f fVar, long j) {
        if (fVar.s() != null) {
            return fVar.s().intValue();
        }
        if (j < 1048576) {
            return 1;
        }
        if (j < e) {
            return 2;
        }
        if (j < f) {
            return 3;
        }
        return j < g ? 4 : 5;
    }

    public ResumeFailedCause a(int i, boolean z, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, String str) {
        String strC = cVar.c();
        if (i == 412) {
            return ResumeFailedCause.RESPONSE_PRECONDITION_FAILED;
        }
        if (!com.tapsdk.tapad.internal.download.m.c.a((CharSequence) strC) && !com.tapsdk.tapad.internal.download.m.c.a((CharSequence) str) && !str.equals(strC)) {
            return ResumeFailedCause.RESPONSE_ETAG_CHANGED;
        }
        if (i == 201 && z) {
            return ResumeFailedCause.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (i == 205 && z) {
            return ResumeFailedCause.RESPONSE_RESET_RANGE_NOT_FROM_0;
        }
        return null;
    }

    public b a(com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605a, int i, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        return new b(interfaceC0605a, i, cVar);
    }

    protected String a(String str, com.tapsdk.tapad.internal.download.f fVar) throws IOException {
        if (!com.tapsdk.tapad.internal.download.m.c.a((CharSequence) str)) {
            return str;
        }
        String strE = fVar.e();
        Matcher matcher = h.matcher(strE);
        String strB = null;
        while (matcher.find()) {
            strB = matcher.group(1);
        }
        if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) strB)) {
            strB = com.tapsdk.tapad.internal.download.m.c.b(strE);
        }
        if (strB != null) {
            return strB;
        }
        throw new IOException("Can't find valid filename.");
    }

    public void a() throws UnknownHostException {
        if (this.a == null) {
            this.a = Boolean.valueOf(com.tapsdk.tapad.internal.download.m.c.a(com.kuaishou.weapon.p0.g.b));
        }
        if (this.a.booleanValue()) {
            if (this.b == null) {
                this.b = (ConnectivityManager) i.j().d().getSystemService("connectivity");
            }
            if (!com.tapsdk.tapad.internal.download.m.c.a(this.b)) {
                throw new UnknownHostException("network is not available!");
            }
        }
    }

    public void a(com.tapsdk.tapad.internal.download.f fVar) throws IOException {
        if (this.a == null) {
            this.a = Boolean.valueOf(com.tapsdk.tapad.internal.download.m.c.a(com.kuaishou.weapon.p0.g.b));
        }
        if (fVar.C()) {
            if (!this.a.booleanValue()) {
                throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
            }
            if (this.b == null) {
                this.b = (ConnectivityManager) i.j().d().getSystemService("connectivity");
            }
            if (com.tapsdk.tapad.internal.download.m.c.b(this.b)) {
                throw new com.tapsdk.tapad.internal.download.m.f.d();
            }
        }
    }

    public void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.i iVar) {
        long length;
        com.tapsdk.tapad.internal.download.core.breakpoint.c cVarG = iVar.g(fVar.b());
        if (cVarG == null) {
            cVarG = new com.tapsdk.tapad.internal.download.core.breakpoint.c(fVar.b(), fVar.e(), fVar.c(), fVar.a());
            if (com.tapsdk.tapad.internal.download.m.c.c(fVar.x())) {
                length = com.tapsdk.tapad.internal.download.m.c.b(fVar.x());
            } else {
                File fileH = fVar.h();
                if (fileH == null) {
                    com.tapsdk.tapad.internal.download.m.c.c(c, "file is not ready on valid info for task on complete state " + fVar);
                    length = 0;
                } else {
                    length = fileH.length();
                }
            }
            long j = length;
            cVarG.a(new com.tapsdk.tapad.internal.download.core.breakpoint.a(0L, j, j));
        }
        com.tapsdk.tapad.internal.download.f.c.a(fVar, cVarG);
    }

    public void a(String str, com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) throws IOException {
        if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) fVar.a())) {
            String strA = a(str, fVar);
            if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) fVar.a())) {
                synchronized (fVar) {
                    if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) fVar.a())) {
                        fVar.i().a(strA);
                        cVar.f().a(strA);
                    }
                }
            }
        }
    }

    public boolean a(int i, boolean z) {
        if (i == 206 || i == 200) {
            return i == 200 && z;
        }
        return true;
    }

    public boolean a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, long j) {
        com.tapsdk.tapad.internal.download.core.breakpoint.g gVarA;
        com.tapsdk.tapad.internal.download.core.breakpoint.c cVarA;
        if (!fVar.z() || (cVarA = (gVarA = i.j().a()).a(fVar, cVar)) == null) {
            return false;
        }
        gVarA.remove(cVarA.g());
        if (cVarA.i() <= i.j().f().b()) {
            return false;
        }
        if ((cVarA.c() != null && !cVarA.c().equals(cVar.c())) || cVarA.h() != j || cVarA.d() == null || !cVarA.d().exists()) {
            return false;
        }
        cVar.a(cVarA);
        com.tapsdk.tapad.internal.download.m.c.a(c, "Reuse another same info: " + cVar);
        return true;
    }

    public boolean a(boolean z) {
        if (i.j().h().a()) {
            return z;
        }
        return false;
    }

    public long b() {
        return 10240L;
    }

    public void b(String str, com.tapsdk.tapad.internal.download.f fVar) {
        if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) fVar.a())) {
            fVar.i().a(str);
        }
    }

    public boolean b(com.tapsdk.tapad.internal.download.f fVar) {
        String strA = i.j().a().a(fVar.e());
        if (strA == null) {
            return false;
        }
        fVar.i().a(strA);
        return true;
    }
}
