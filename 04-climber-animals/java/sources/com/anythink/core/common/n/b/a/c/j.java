package com.anythink.core.common.n.b.a.c;

import com.anythink.core.common.n.b.ad;
import com.anythink.core.common.n.b.ae;
import com.anythink.core.common.n.b.af;
import com.anythink.core.common.n.b.ag;
import com.anythink.core.common.n.b.ah;
import com.anythink.core.common.n.b.v;
import com.anythink.core.common.n.b.w;
import com.anythink.core.common.n.b.z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public final class j implements w {
    private static final int a = 20;
    private final z b;

    public j(z zVar) {
        this.b = zVar;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0103  */
    @Override // com.anythink.core.common.n.b.w
    public final af a(w.a aVar) throws IOException {
        ad adVarB;
        String strA;
        v vVarC;
        Proxy proxyC;
        ad adVarA = aVar.a();
        g gVar = (g) aVar;
        com.anythink.core.common.n.b.a.b.j jVarG = gVar.g();
        int i = 0;
        af afVar = null;
        while (true) {
            jVarG.a(adVarA);
            if (jVarG.j()) {
                throw new IOException("Canceled");
            }
            boolean z = true;
            try {
                try {
                    af afVarA = gVar.a(adVarA, jVarG, null);
                    if (afVar != null) {
                        afVarA = afVarA.h().c(afVar.h().a((ag) null).a()).a();
                    }
                    afVar = afVarA;
                    com.anythink.core.common.n.b.a.b.c cVarA = com.anythink.core.common.n.b.a.a.a.a(afVar);
                    ah ahVarA = cVarA != null ? cVarA.a().a() : null;
                    if (afVar == null) {
                        throw new IllegalStateException();
                    }
                    int iC = afVar.c();
                    String strB = afVar.a().b();
                    if (iC == 307 || iC == 308) {
                        if (!strB.equals("GET") && !strB.equals("HEAD")) {
                            adVarB = null;
                        } else if (!this.b.o() || (strA = afVar.a("Location")) == null || (vVarC = afVar.a().a().c(strA)) == null) {
                            adVarB = null;
                        } else if (vVarC.b().equals(afVar.a().a().b()) || this.b.n()) {
                            ad.a aVarE = afVar.a().e();
                            if (f.c(strB)) {
                                boolean zEquals = strB.equals("PROPFIND");
                                if (true ^ strB.equals("PROPFIND")) {
                                    aVarE.a("GET", (ae) null);
                                } else {
                                    aVarE.a(strB, zEquals ? afVar.a().d() : null);
                                }
                                if (!zEquals) {
                                    aVarE.b("Transfer-Encoding");
                                    aVarE.b("Content-Length");
                                    aVarE.b("Content-Type");
                                }
                            }
                            if (!com.anythink.core.common.n.b.a.c.a(afVar.a().a(), vVarC)) {
                                aVarE.b("Authorization");
                            }
                            adVarB = aVarE.a(vVarC).b();
                        } else {
                            adVarB = null;
                        }
                    } else if (iC == 401) {
                        adVarB = this.b.k().authenticate(ahVarA, afVar);
                    } else if (iC == 503) {
                        adVarB = ((afVar.j() == null || afVar.j().c() != 503) && a(afVar, Integer.MAX_VALUE) == 0) ? afVar.a() : null;
                    } else if (iC == 407) {
                        if (ahVarA != null) {
                            proxyC = ahVarA.b();
                        } else {
                            proxyC = this.b.c();
                        }
                        if (proxyC.type() != Proxy.Type.HTTP) {
                            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        }
                        adVarB = this.b.l().authenticate(ahVarA, afVar);
                    } else if (iC != 408) {
                        switch (iC) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                if (!this.b.o()) {
                                }
                                break;
                            default:
                                adVarB = null;
                                break;
                        }
                    } else if (this.b.p()) {
                        afVar.a().d();
                        adVarB = ((afVar.j() == null || afVar.j().c() != 408) && a(afVar, 0) <= 0) ? afVar.a() : null;
                    } else {
                        adVarB = null;
                    }
                    if (adVarB == null) {
                        if (cVarA != null && cVarA.b()) {
                            jVarG.c();
                        }
                        return afVar;
                    }
                    adVarB.d();
                    com.anythink.core.common.n.b.a.c.a(afVar.g());
                    if (jVarG.h()) {
                        cVarA.i();
                    }
                    i++;
                    if (i > 20) {
                        throw new ProtocolException("Too many follow-up requests: ".concat(String.valueOf(i)));
                    }
                    adVarA = adVarB;
                } catch (com.anythink.core.common.n.b.a.b.h e) {
                    if (!a(e.b(), jVarG, false, adVarA)) {
                        throw e.a();
                    }
                    jVarG.f();
                } catch (IOException e2) {
                    if (e2 instanceof com.anythink.core.common.n.b.a.e.a) {
                        z = false;
                    }
                    if (!a(e2, jVarG, z, adVarA)) {
                        throw e2;
                    }
                    jVarG.f();
                }
            } catch (Throwable th) {
                jVarG.f();
                throw th;
            }
        }
    }

    private boolean a(IOException iOException, com.anythink.core.common.n.b.a.b.j jVar, boolean z, ad adVar) {
        if (this.b.p()) {
            return !(z && a(iOException, adVar)) && a(iOException, z) && jVar.g();
        }
        return false;
    }

    private static boolean a(IOException iOException, ad adVar) {
        adVar.d();
        return iOException instanceof FileNotFoundException;
    }

    private static boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private ad a(af afVar, ah ahVar) throws ProtocolException {
        String strA;
        v vVarC;
        Proxy proxyC;
        if (afVar == null) {
            throw new IllegalStateException();
        }
        int iC = afVar.c();
        String strB = afVar.a().b();
        if (iC == 307 || iC == 308) {
            if (!strB.equals("GET") && !strB.equals("HEAD")) {
                return null;
            }
        } else {
            if (iC == 401) {
                return this.b.k().authenticate(ahVar, afVar);
            }
            if (iC == 503) {
                if ((afVar.j() == null || afVar.j().c() != 503) && a(afVar, Integer.MAX_VALUE) == 0) {
                    return afVar.a();
                }
                return null;
            }
            if (iC == 407) {
                if (ahVar != null) {
                    proxyC = ahVar.b();
                } else {
                    proxyC = this.b.c();
                }
                if (proxyC.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.b.l().authenticate(ahVar, afVar);
            }
            if (iC == 408) {
                if (!this.b.p()) {
                    return null;
                }
                afVar.a().d();
                if ((afVar.j() == null || afVar.j().c() != 408) && a(afVar, 0) <= 0) {
                    return afVar.a();
                }
                return null;
            }
            switch (iC) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.b.o() || (strA = afVar.a("Location")) == null || (vVarC = afVar.a().a().c(strA)) == null) {
            return null;
        }
        if (!vVarC.b().equals(afVar.a().a().b()) && !this.b.n()) {
            return null;
        }
        ad.a aVarE = afVar.a().e();
        if (f.c(strB)) {
            boolean zEquals = strB.equals("PROPFIND");
            if (!strB.equals("PROPFIND")) {
                aVarE.a("GET", (ae) null);
            } else {
                aVarE.a(strB, zEquals ? afVar.a().d() : null);
            }
            if (!zEquals) {
                aVarE.b("Transfer-Encoding");
                aVarE.b("Content-Length");
                aVarE.b("Content-Type");
            }
        }
        if (!com.anythink.core.common.n.b.a.c.a(afVar.a().a(), vVarC)) {
            aVarE.b("Authorization");
        }
        return aVarE.a(vVarC).b();
    }

    private static int a(af afVar, int i) {
        String strA = afVar.a("Retry-After");
        if (strA == null) {
            return i;
        }
        if (strA.matches("\\d+")) {
            return Integer.valueOf(strA).intValue();
        }
        return Integer.MAX_VALUE;
    }
}
