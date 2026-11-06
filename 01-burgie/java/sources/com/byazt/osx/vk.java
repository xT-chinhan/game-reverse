package com.byazt.osx;

import com.byazt.jv.a;
import com.byazt.jv.b;
import com.byazt.jv.fo;
import com.byazt.jv.gz;
import com.byazt.jv.iu;
import com.byazt.jv.nl;
import com.byazt.jv.nt;
import com.byazt.jv.qa;
import com.byazt.jv.rc;
import com.byazt.jv.y;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.core.Util;
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
@com.byazt.vzx.pr(pr = {0, 1, 442, 50})
public final class vk implements a {
    public volatile boolean c;
    public com.byazt.iaw.fw hn;
    public final boolean hw;
    public final fo pr;
    public Object x;

    public vk(fo foVar, boolean z) {
        this.pr = foVar;
        this.hw = z;
    }

    public void pr() {
        this.c = true;
        com.byazt.iaw.fw fwVar = this.hn;
        if (fwVar != null) {
            fwVar.c();
        }
    }

    public boolean hw() {
        return this.c;
    }

    public void pr(Object obj) {
        this.x = obj;
    }

    @Override // com.byazt.jv.a
    public gz pr(a.pr prVar) throws Throwable {
        String strPr;
        String str;
        int i;
        IOException iOException;
        int i2;
        b bVarPr = prVar.pr();
        fw fwVar = (fw) prVar;
        com.byazt.jv.c cVarCall = fwVar.call();
        nt ntVarZo = fwVar.zo();
        this.hn = new com.byazt.iaw.fw(this.pr.ho(), pr(bVarPr.pr()), cVarCall, ntVarZo, this.x);
        try {
            int i3 = Integer.parseInt(bVarPr.hn().pr("csj_client_source_from"));
            strPr = bVarPr.hn().pr("csj_extra_info");
            try {
                bVarPr = bVarPr.uc().hw("csj_client_source_from").hw("csj_extra_info").pr();
                i = i3;
                str = strPr;
            } catch (Exception e) {
                str = strPr;
                i = 0;
            }
        } catch (Exception e2) {
            strPr = "";
        }
        String string = bVarPr.pr().toString();
        ArrayList arrayList = new ArrayList();
        gz gzVar = null;
        int i4 = 0;
        while (!this.c) {
            if (this.pr.nl == null || bVarPr.pr() == null) {
                ntVarZo = ntVarZo;
            } else {
                Iterator<String> it = this.pr.nl.iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = it.next().split("@");
                    ntVarZo = ntVarZo;
                    if (strArrSplit.length >= 2) {
                        String str2 = strArrSplit[0];
                        try {
                            i2 = Integer.parseInt(strArrSplit[1]);
                        } catch (Exception e3) {
                            i2 = 0;
                        }
                        if ((i2 & i) != 0 && Pattern.compile(str2).matcher(bVarPr.pr().toString()).find()) {
                            gz.pr prVar2 = new gz.pr();
                            prVar2.pr(8848);
                            prVar2.pr(bVarPr.pr().toString());
                            prVar2.pr(bVarPr);
                            prVar2.pr(rc.HTTP_1_1);
                            prVar2.pr(com.byazt.xx.hn.hn);
                            if (arrayList.size() <= 0) {
                                return prVar2.pr();
                            }
                            arrayList.add(0, string);
                            return prVar2.pr("csj-location-record", arrayList.toString()).pr("csj-source-from", String.valueOf(i)).pr("csj-extra-info", String.valueOf(str)).pr();
                        }
                    }
                }
                ntVarZo = ntVarZo;
            }
            try {
                try {
                    gz gzVarPr = fwVar.pr(bVarPr, this.hn, null, null);
                    if (gzVar != null) {
                        gzVarPr = gzVarPr.vk().hn(gzVar.vk().pr((nl) null).pr()).pr();
                    }
                    bVarPr = pr(gzVarPr);
                    if (bVarPr == null) {
                        if (!this.hw) {
                            this.hn.hn();
                        }
                        if (arrayList.size() <= 0) {
                            return gzVarPr;
                        }
                        arrayList.add(0, string);
                        return gzVarPr.vk().pr("csj-location-record", arrayList.toString()).pr("csj-source-from", String.valueOf(i)).pr("csj-extra-info", String.valueOf(str)).pr();
                    }
                    arrayList.add(bVarPr.pr().toString());
                    com.byazt.xx.hn.pr(gzVarPr.aj());
                    int i5 = i4 + 1;
                    if (i5 > 20) {
                        this.hn.hn();
                        throw new ProtocolException("Too many follow-up requests: ".concat(String.valueOf(i5)));
                    }
                    if (bVarPr.x() instanceof k) {
                        this.hn.hn();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", gzVarPr.x());
                    }
                    if (!pr(gzVarPr, bVarPr.pr())) {
                        this.hn.hn();
                        this.hn = new com.byazt.iaw.fw(this.pr.ho(), pr(bVarPr.pr()), cVarCall, ntVarZo, this.x);
                    } else if (this.hn.pr() != null) {
                        throw new IllegalStateException("Closing the body of " + gzVarPr + " didn't close its backing stream. Bad interceptor?");
                    }
                    gzVar = gzVarPr;
                    i4 = i5;
                } catch (com.byazt.iaw.c e4) {
                    e = e4;
                    if (!pr(e.pr(), false, bVarPr)) {
                        throw e.pr();
                    }
                } catch (IOException e5) {
                    e = e5;
                    iOException = null;
                    try {
                        if (!pr(e, !(e instanceof com.byazt.cpq.pr), bVarPr)) {
                            throw e;
                        }
                    } catch (Throwable th) {
                        th = th;
                        this.hn.pr(iOException);
                        this.hn.hn();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    iOException = null;
                    this.hn.pr(iOException);
                    this.hn.hn();
                    throw th;
                }
            } catch (com.byazt.iaw.c e6) {
                e = e6;
            } catch (IOException e7) {
                e = e7;
                iOException = null;
            } catch (Throwable th3) {
                th = th3;
                iOException = null;
            }
        }
        this.hn.hn();
        throw new IOException("Canceled");
    }

    private com.byazt.jv.pr pr(qa qaVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierW;
        com.byazt.jv.fw fwVarK;
        if (!qaVar.hn()) {
            sSLSocketFactory = null;
            hostnameVerifierW = null;
            fwVarK = null;
        } else {
            SSLSocketFactory sSLSocketFactoryVk = this.pr.vk();
            hostnameVerifierW = this.pr.w();
            sSLSocketFactory = sSLSocketFactoryVk;
            fwVarK = this.pr.k();
        }
        return new com.byazt.jv.pr(qaVar.uc(), qaVar.fw(), this.pr.zo(), this.pr.aj(), sSLSocketFactory, hostnameVerifierW, fwVarK, this.pr.g(), this.pr.x(), this.pr.a(), this.pr.cz(), this.pr.c());
    }

    private boolean pr(IOException iOException, boolean z, b bVar) {
        this.hn.pr(iOException);
        if (this.pr.lb()) {
            return !(z && (bVar.x() instanceof k)) && pr(iOException, z) && this.hn.uc();
        }
        return false;
    }

    private boolean pr(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private b pr(gz gzVar) throws IOException {
        y yVarPr;
        String strHw;
        qa qaVarHn;
        Proxy proxyX;
        if (gzVar == null) {
            throw new IllegalStateException();
        }
        com.byazt.iaw.hn hnVarHw = this.hn.hw();
        if (hnVarHw == null) {
            yVarPr = null;
        } else {
            yVarPr = hnVarHw.pr();
        }
        int iX = gzVar.x();
        String strHw2 = gzVar.hw().hw();
        switch (iX) {
            case TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX /* 300 */:
            case 301:
            case 302:
            case 303:
                break;
            case 307:
            case 308:
                if (!TapHttp.METHOD_GET.equals(strHw2) && !Util.METHOD_HEAD.equals(strHw2)) {
                    return null;
                }
                break;
            case 401:
                return this.pr.m().pr(yVarPr, gzVar);
            case 407:
                if (yVarPr != null) {
                    proxyX = yVarPr.hw();
                } else {
                    proxyX = this.pr.x();
                }
                if (proxyX.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.pr.g().pr(yVarPr, gzVar);
            case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                if (!this.pr.lb() || (gzVar.hw().x() instanceof k)) {
                    return null;
                }
                if (gzVar.k() != null && gzVar.k().x() == 408) {
                    return null;
                }
                return gzVar.hw();
            default:
                return null;
        }
        if (!this.pr.yb() || (strHw = gzVar.hw("Location")) == null || (qaVarHn = gzVar.hw().pr().hn(strHw)) == null) {
            return null;
        }
        if (!qaVarHn.hw().equals(gzVar.hw().pr().hw()) && !this.pr.nt()) {
            return null;
        }
        b.pr prVarUc = gzVar.hw().uc();
        if (uc.hn(strHw2)) {
            boolean zX = uc.x(strHw2);
            if (uc.c(strHw2)) {
                prVarUc.pr(TapHttp.METHOD_GET, (iu) null);
            } else {
                prVarUc.pr(strHw2, zX ? gzVar.hw().x() : null);
            }
            if (!zX) {
                prVarUc.hw(Util.TRANSFER_ENCODING);
                prVarUc.hw(Util.CONTENT_LENGTH);
                prVarUc.hw("Content-Type");
            }
        }
        if (!pr(gzVar, qaVarHn)) {
            prVarUc.hw("Authorization");
        }
        return prVarUc.pr(qaVarHn).pr();
    }

    private boolean pr(gz gzVar, qa qaVar) {
        qa qaVarPr = gzVar.hw().pr();
        return qaVarPr.uc().equals(qaVar.uc()) && qaVarPr.fw() == qaVar.fw() && qaVarPr.hw().equals(qaVar.hw());
    }
}
