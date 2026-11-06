package com.tapsdk.tapad.internal.download.m.e;

import com.tapsdk.tapad.internal.download.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final String h = "ConnectTrial";
    private static final Pattern i = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static final Pattern j = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
    private final com.tapsdk.tapad.internal.download.f a;
    private final com.tapsdk.tapad.internal.download.core.breakpoint.c b;
    private boolean c;
    private long d;
    private String e;
    private String f;
    private int g;

    public c(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        this.a = fVar;
        this.b = cVar;
    }

    private static String a(com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605a) {
        return interfaceC0605a.c("Etag");
    }

    private static String a(String str) throws IOException {
        String strGroup;
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = i.matcher(str);
            if (matcher.find()) {
                strGroup = matcher.group(1);
            } else {
                Matcher matcher2 = j.matcher(str);
                strGroup = matcher2.find() ? matcher2.group(1) : null;
            }
            if (strGroup != null && strGroup.contains("../")) {
                throw new com.tapsdk.tapad.internal.download.m.f.a("The filename [" + strGroup + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
            }
            return strGroup;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    private static long b(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.tapsdk.tapad.internal.download.m.c.c(h, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    private static String b(com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605a) throws IOException {
        return a(interfaceC0605a.c("Content-Disposition"));
    }

    private static long c(com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605a) {
        long jB = b(interfaceC0605a.c("Content-Range"));
        if (jB != -1) {
            return jB;
        }
        if (!c(interfaceC0605a.c("Transfer-Encoding"))) {
            com.tapsdk.tapad.internal.download.m.c.c(h, "Transfer-Encoding isn't chunked but there is no valid instance length found either!");
        }
        return -1L;
    }

    private static boolean c(String str) {
        return str != null && str.equals("chunked");
    }

    private static boolean d(com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605a) throws IOException {
        if (interfaceC0605a.f() == 206) {
            return true;
        }
        return "bytes".equals(interfaceC0605a.c("Accept-Ranges"));
    }

    public void a() throws IOException {
        i.j().f().a(this.a);
        i.j().f().a();
        com.tapsdk.tapad.internal.download.core.connection.a aVarA = i.j().c().a(this.a.e());
        try {
            if (!com.tapsdk.tapad.internal.download.m.c.a((CharSequence) this.b.c())) {
                aVarA.a("If-Match", this.b.c());
            }
            aVarA.a("Range", "bytes=0-0");
            Map<String, List<String>> mapK = this.a.k();
            if (mapK != null) {
                com.tapsdk.tapad.internal.download.m.c.b(mapK, aVarA);
            }
            com.tapsdk.tapad.internal.download.c cVarA = i.j().b().a();
            cVarA.a(this.a, aVarA.c());
            com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605aG = aVarA.g();
            this.a.a(interfaceC0605aG.a());
            com.tapsdk.tapad.internal.download.m.c.a(h, "task[" + this.a.b() + "] redirect location: " + this.a.r());
            this.g = interfaceC0605aG.f();
            this.c = d(interfaceC0605aG);
            this.d = c(interfaceC0605aG);
            this.e = a(interfaceC0605aG);
            this.f = b(interfaceC0605aG);
            Map<String, List<String>> mapE = interfaceC0605aG.e();
            if (mapE == null) {
                mapE = new HashMap<>();
            }
            cVarA.b(this.a, this.g, mapE);
            boolean zA = a(this.d, interfaceC0605aG);
            aVarA.d();
            if (zA) {
                i();
            }
        } catch (Throwable th) {
            aVarA.d();
            throw th;
        }
    }

    boolean a(long j2, com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605a) {
        String strC;
        if (j2 != -1) {
            return false;
        }
        String strC2 = interfaceC0605a.c("Content-Range");
        return (strC2 == null || strC2.length() <= 0) && !c(interfaceC0605a.c("Transfer-Encoding")) && (strC = interfaceC0605a.c("Content-Length")) != null && strC.length() > 0;
    }

    public long b() {
        return this.d;
    }

    public int c() {
        return this.g;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public boolean f() {
        return this.c;
    }

    public boolean g() {
        return this.d == -1;
    }

    public boolean h() {
        return (this.b.c() == null || this.b.c().equals(this.e)) ? false : true;
    }

    void i() throws IOException {
        com.tapsdk.tapad.internal.download.core.connection.a aVarA = i.j().c().a(this.a.e());
        com.tapsdk.tapad.internal.download.c cVarA = i.j().b().a();
        try {
            aVarA.a("HEAD");
            Map<String, List<String>> mapK = this.a.k();
            if (mapK != null) {
                com.tapsdk.tapad.internal.download.m.c.b(mapK, aVarA);
            }
            cVarA.a(this.a, aVarA.c());
            com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605aG = aVarA.g();
            cVarA.b(this.a, interfaceC0605aG.f(), interfaceC0605aG.e());
            this.d = com.tapsdk.tapad.internal.download.m.c.c(interfaceC0605aG.c("Content-Length"));
        } finally {
            aVarA.d();
        }
    }
}
