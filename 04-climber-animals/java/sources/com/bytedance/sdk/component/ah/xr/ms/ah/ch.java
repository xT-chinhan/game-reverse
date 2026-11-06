package com.bytedance.sdk.component.ah.xr.ms.ah;

import com.bytedance.sdk.component.ah.xr.ao;
import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.g;
import com.bytedance.sdk.component.ah.xr.i;
import com.bytedance.sdk.component.ah.xr.of;
import com.bytedance.sdk.component.ah.xr.op;
import com.bytedance.sdk.component.ah.xr.re;
import com.bytedance.sdk.component.ah.xr.t;
import com.bytedance.sdk.component.ah.xr.y;
import com.bytedance.sdk.component.ah.xr.yu;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class ch implements t {
    private com.bytedance.sdk.component.ah.xr.ms.xr.ab ah;
    private Object d;
    private volatile boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final re f1060ms;
    private final boolean xr;

    public ch(re reVar, boolean z) {
        this.f1060ms = reVar;
        this.xr = z;
    }

    public void ms() {
        this.ka = true;
        com.bytedance.sdk.component.ah.xr.ms.xr.ab abVar = this.ah;
        if (abVar != null) {
            abVar.ka();
        }
    }

    public boolean xr() {
        return this.ka;
    }

    public void ms(Object obj) {
        this.d = obj;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t
    public cv ms(t.ms msVar) throws Throwable {
        String strMs;
        String str;
        int i;
        IOException iOException;
        int i2;
        yu yuVarMs = msVar.ms();
        ab abVar = (ab) msVar;
        com.bytedance.sdk.component.ah.xr.ka kaVarCall = abVar.call();
        ao aoVarX = abVar.x();
        this.ah = new com.bytedance.sdk.component.ah.xr.ms.xr.ab(this.f1060ms.ub(), ms(yuVarMs.ms()), kaVarCall, aoVarX, this.d);
        try {
            int i3 = Integer.parseInt(yuVarMs.ah().ms("csj_client_source_from"));
            strMs = yuVarMs.ah().ms("csj_extra_info");
            try {
                yuVarMs = yuVarMs.c().ms("csj_client_source_from").ms("csj_extra_info").ms();
                i = i3;
                str = strMs;
            } catch (Exception unused) {
                str = strMs;
                i = 0;
            }
        } catch (Exception unused2) {
            strMs = "";
        }
        String string = yuVarMs.ms().toString();
        ArrayList arrayList = new ArrayList();
        cv cvVar = null;
        int i4 = 0;
        while (!this.ka) {
            if (this.f1060ms.g != null && yuVarMs.ms() != null) {
                Iterator<String> it = this.f1060ms.g.iterator();
                while (it.hasNext()) {
                    Iterator<String> it2 = it;
                    String[] strArrSplit = it.next().split("@");
                    ao aoVar = aoVarX;
                    if (strArrSplit.length >= 2) {
                        String str2 = strArrSplit[0];
                        try {
                            i2 = Integer.parseInt(strArrSplit[1]);
                        } catch (Exception unused3) {
                            i2 = 0;
                        }
                        if ((i2 & i) != 0 && Pattern.compile(str2).matcher(yuVarMs.ms().toString()).find()) {
                            cv.ms msVar2 = new cv.ms();
                            msVar2.ms(8848);
                            msVar2.ms(yuVarMs.ms().toString());
                            msVar2.ms(yuVarMs);
                            msVar2.ms(i.HTTP_1_1);
                            msVar2.ms(com.bytedance.sdk.component.ah.xr.ms.ah.ah);
                            if (arrayList.size() > 0) {
                                arrayList.add(0, string);
                                return msVar2.ms("csj-location-record", arrayList.toString()).ms("csj-source-from", String.valueOf(i)).ms("csj-extra-info", String.valueOf(str)).ms();
                            }
                            return msVar2.ms();
                        }
                    }
                    it = it2;
                    aoVarX = aoVar;
                }
            }
            ao aoVar2 = aoVarX;
            try {
                try {
                    cv cvVarMs = abVar.ms(yuVarMs, this.ah, null, null);
                    if (cvVar != null) {
                        cvVarMs = cvVarMs.ny().ah(cvVar.ny().ms((g) null).ms()).ms();
                    }
                    yuVarMs = ms(cvVarMs);
                    if (yuVarMs == null) {
                        if (!this.xr) {
                            this.ah.ah();
                        }
                        if (arrayList.size() <= 0) {
                            return cvVarMs;
                        }
                        arrayList.add(0, string);
                        return cvVarMs.ny().ms("csj-location-record", arrayList.toString()).ms("csj-source-from", String.valueOf(i)).ms("csj-extra-info", String.valueOf(str)).ms();
                    }
                    arrayList.add(yuVarMs.ms().toString());
                    com.bytedance.sdk.component.ah.xr.ms.ah.ms(cvVarMs.x());
                    int i5 = i4 + 1;
                    if (i5 > 20) {
                        this.ah.ah();
                        throw new ProtocolException("Too many follow-up requests: ".concat(String.valueOf(i5)));
                    }
                    if (yuVarMs.d() instanceof sl) {
                        this.ah.ah();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", cvVarMs.ah());
                    }
                    if (!ms(cvVarMs, yuVarMs.ms())) {
                        this.ah.ah();
                        this.ah = new com.bytedance.sdk.component.ah.xr.ms.xr.ab(this.f1060ms.ub(), ms(yuVarMs.ms()), kaVarCall, aoVar2, this.d);
                    } else if (this.ah.ms() != null) {
                        throw new IllegalStateException("Closing the body of " + cvVarMs + " didn't close its backing stream. Bad interceptor?");
                    }
                    cvVar = cvVarMs;
                    i4 = i5;
                    arrayList = arrayList;
                    aoVarX = aoVar2;
                } catch (com.bytedance.sdk.component.ah.xr.ms.xr.ka e) {
                    e = e;
                    if (!ms(e.ms(), false, yuVarMs)) {
                        throw e.ms();
                    }
                } catch (IOException e2) {
                    e = e2;
                    iOException = null;
                    try {
                        if (!ms(e, !(e instanceof com.bytedance.sdk.component.ah.xr.ms.ka.ms), yuVarMs)) {
                            throw e;
                        }
                    } catch (Throwable th) {
                        th = th;
                        this.ah.ms(iOException);
                        this.ah.ah();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    iOException = null;
                    this.ah.ms(iOException);
                    this.ah.ah();
                    throw th;
                }
            } catch (com.bytedance.sdk.component.ah.xr.ms.xr.ka e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
                iOException = null;
            } catch (Throwable th3) {
                th = th3;
                iOException = null;
            }
        }
        this.ah.ah();
        throw new IOException("Canceled");
    }

    private com.bytedance.sdk.component.ah.xr.ms ms(y yVar) {
        SSLSocketFactory sSLSocketFactoryCh;
        HostnameVerifier hostnameVerifierHi;
        com.bytedance.sdk.component.ah.xr.ab abVarSl;
        if (yVar.d()) {
            sSLSocketFactoryCh = this.f1060ms.ch();
            hostnameVerifierHi = this.f1060ms.hi();
            abVarSl = this.f1060ms.sl();
        } else {
            sSLSocketFactoryCh = null;
            hostnameVerifierHi = null;
            abVarSl = null;
        }
        return new com.bytedance.sdk.component.ah.xr.ms(yVar.ab(), yVar.x(), this.f1060ms.x(), this.f1060ms.ny(), sSLSocketFactoryCh, hostnameVerifierHi, abVarSl, this.f1060ms.u(), this.f1060ms.d(), this.f1060ms.t(), this.f1060ms.nw(), this.f1060ms.ka());
    }

    private boolean ms(IOException iOException, boolean z, yu yuVar) {
        this.ah.ms(iOException);
        if (this.f1060ms.qv()) {
            return !(z && (yuVar.d() instanceof sl)) && ms(iOException, z) && this.ah.c();
        }
        return false;
    }

    private boolean ms(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private yu ms(cv cvVar) throws IOException {
        String strMs;
        y yVarAh;
        Proxy proxyD;
        if (cvVar == null) {
            throw new IllegalStateException();
        }
        com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVarXr = this.ah.xr();
        of ofVarMs = ahVarXr != null ? ahVarXr.ms() : null;
        int iAh = cvVar.ah();
        String strXr = cvVar.ms().xr();
        if (iAh == 307 || iAh == 308) {
            if (!strXr.equals("GET") && !strXr.equals("HEAD")) {
                return null;
            }
        } else {
            if (iAh == 401) {
                return this.f1060ms.zb().ms(ofVarMs, cvVar);
            }
            if (iAh == 407) {
                if (ofVarMs != null) {
                    proxyD = ofVarMs.xr();
                } else {
                    proxyD = this.f1060ms.d();
                }
                if (proxyD.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f1060ms.u().ms(ofVarMs, cvVar);
            }
            if (iAh == 408) {
                if (!this.f1060ms.qv() || (cvVar.ms().d() instanceof sl)) {
                    return null;
                }
                if (cvVar.hi() == null || cvVar.hi().ah() != 408) {
                    return cvVar.ms();
                }
                return null;
            }
            switch (iAh) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f1060ms.h() || (strMs = cvVar.ms("Location")) == null || (yVarAh = cvVar.ms().ms().ah(strMs)) == null) {
            return null;
        }
        if (!yVarAh.ah().equals(cvVar.ms().ms().ah()) && !this.f1060ms.ao()) {
            return null;
        }
        yu.ms msVarC = cvVar.ms().c();
        if (c.ah(strXr)) {
            boolean zD = c.d(strXr);
            if (c.ka(strXr)) {
                msVarC.ms("GET", (op) null);
            } else {
                msVarC.ms(strXr, zD ? cvVar.ms().d() : null);
            }
            if (!zD) {
                msVarC.ms("Transfer-Encoding");
                msVarC.ms("Content-Length");
                msVarC.ms("Content-Type");
            }
        }
        if (!ms(cvVar, yVarAh)) {
            msVarC.ms("Authorization");
        }
        return msVarC.ms(yVarAh).ms();
    }

    private boolean ms(cv cvVar, y yVar) {
        y yVarMs = cvVar.ms().ms();
        return yVarMs.ab().equals(yVar.ab()) && yVarMs.x() == yVar.x() && yVarMs.ah().equals(yVar.ah());
    }
}
