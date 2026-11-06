package com.byazt.cri;

import com.anythink.core.common.l.b;
import com.byazt.pq.a;
import com.byazt.pq.bb;
import com.byazt.pq.cy;
import com.byazt.pq.h;
import com.byazt.pq.lh;
import com.byazt.pq.ln;
import com.byazt.pq.m;
import com.byazt.pq.t;
import com.byazt.pq.um;
import com.byazt.pq.wm;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.kit.internal.http.TapHttp;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1393, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public final class tj implements a {
    public volatile boolean l;
    public final wm n;
    public Object q;
    public final boolean qg;
    public com.byazt.sqs.x s;

    public tj(wm wmVar, boolean z) {
        this.n = wmVar;
        this.qg = z;
    }

    public void n() {
        this.l = true;
        com.byazt.sqs.x xVar = this.s;
        if (xVar != null) {
            xVar.l();
        }
    }

    public boolean qg() {
        return this.l;
    }

    public void n(Object obj) {
        this.q = obj;
    }

    @Override // com.byazt.pq.a
    public bb n(a.n nVar) throws Throwable {
        String strN;
        String str;
        int i;
        IOException iOException;
        int i2;
        h hVarN = nVar.n();
        x xVar = (x) nVar;
        com.byazt.pq.l lVarCall = xVar.call();
        cy cyVarFs = xVar.fs();
        this.s = new com.byazt.sqs.x(this.n.k(), n(hVarN.n()), lVarCall, cyVarFs, this.q);
        try {
            int i3 = Integer.parseInt(hVarN.s().n("csj_client_source_from"));
            strN = hVarN.s().n("csj_extra_info");
            try {
                hVarN = hVarN.x().qg("csj_client_source_from").qg("csj_extra_info").n();
                i = i3;
                str = strN;
            } catch (Exception unused) {
                str = strN;
                i = 0;
            }
        } catch (Exception unused2) {
            strN = "";
        }
        String string = hVarN.n().toString();
        ArrayList arrayList = new ArrayList();
        bb bbVar = null;
        int i4 = 0;
        while (!this.l) {
            if (this.n.ln != null && hVarN.n() != null) {
                Iterator<String> it = this.n.ln.iterator();
                while (it.hasNext()) {
                    Iterator<String> it2 = it;
                    String[] strArrSplit = it.next().split("@");
                    cy cyVar = cyVarFs;
                    if (strArrSplit.length >= 2) {
                        String str2 = strArrSplit[0];
                        try {
                            i2 = Integer.parseInt(strArrSplit[1]);
                        } catch (Exception unused3) {
                            i2 = 0;
                        }
                        if ((i2 & i) != 0 && Pattern.compile(str2).matcher(hVarN.n().toString()).find()) {
                            bb.n nVar2 = new bb.n();
                            nVar2.n(8848);
                            nVar2.n(hVarN.n().toString());
                            nVar2.n(hVarN);
                            nVar2.n(m.HTTP_1_1);
                            nVar2.n(com.byazt.zho.s.s);
                            if (arrayList.size() > 0) {
                                arrayList.add(0, string);
                                return nVar2.n("csj-location-record", arrayList.toString()).n("csj-source-from", String.valueOf(i)).n("csj-extra-info", String.valueOf(str)).n();
                            }
                            return nVar2.n();
                        }
                    }
                    it = it2;
                    cyVarFs = cyVar;
                }
            }
            cy cyVar2 = cyVarFs;
            try {
                try {
                    bb bbVarN = xVar.n(hVarN, this.s, null, null);
                    if (bbVar != null) {
                        bbVarN = bbVarN.tj().s(bbVar.tj().n((ln) null).n()).n();
                    }
                    hVarN = n(bbVarN);
                    if (hVarN == null) {
                        if (!this.qg) {
                            this.s.s();
                        }
                        if (arrayList.size() <= 0) {
                            return bbVarN;
                        }
                        arrayList.add(0, string);
                        return bbVarN.tj().n("csj-location-record", arrayList.toString()).n("csj-source-from", String.valueOf(i)).n("csj-extra-info", String.valueOf(str)).n();
                    }
                    arrayList.add(hVarN.n().toString());
                    com.byazt.zho.s.n(bbVarN.rv());
                    int i5 = i4 + 1;
                    if (i5 > 20) {
                        this.s.s();
                        throw new ProtocolException("Too many follow-up requests: ".concat(String.valueOf(i5)));
                    }
                    if (hVarN.q() instanceof d) {
                        this.s.s();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", bbVarN.q());
                    }
                    if (!n(bbVarN, hVarN.n())) {
                        this.s.s();
                        this.s = new com.byazt.sqs.x(this.n.k(), n(hVarN.n()), lVarCall, cyVar2, this.q);
                    } else if (this.s.n() != null) {
                        throw new IllegalStateException("Closing the body of " + bbVarN + " didn't close its backing stream. Bad interceptor?");
                    }
                    bbVar = bbVarN;
                    i4 = i5;
                    arrayList = arrayList;
                    cyVarFs = cyVar2;
                } catch (com.byazt.sqs.l e) {
                    e = e;
                    if (!n(e.n(), false, hVarN)) {
                        throw e.n();
                    }
                } catch (IOException e2) {
                    e = e2;
                    iOException = null;
                    try {
                        if (!n(e, !(e instanceof com.byazt.hf.n), hVarN)) {
                            throw e;
                        }
                    } catch (Throwable th) {
                        th = th;
                        this.s.n(iOException);
                        this.s.s();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    iOException = null;
                    this.s.n(iOException);
                    this.s.s();
                    throw th;
                }
            } catch (com.byazt.sqs.l e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
                iOException = null;
            } catch (Throwable th3) {
                th = th3;
                iOException = null;
            }
        }
        this.s.s();
        throw new IOException("Canceled");
    }

    private com.byazt.pq.n n(um umVar) {
        SSLSocketFactory sSLSocketFactoryTj;
        HostnameVerifier hostnameVerifierCp;
        com.byazt.pq.x xVarD;
        if (umVar.s()) {
            sSLSocketFactoryTj = this.n.tj();
            hostnameVerifierCp = this.n.cp();
            xVarD = this.n.d();
        } else {
            sSLSocketFactoryTj = null;
            hostnameVerifierCp = null;
            xVarD = null;
        }
        return new com.byazt.pq.n(umVar.w(), umVar.x(), this.n.fs(), this.n.rv(), sSLSocketFactoryTj, hostnameVerifierCp, xVarD, this.n.sz(), this.n.q(), this.n.a(), this.n.py(), this.n.l());
    }

    private boolean n(IOException iOException, boolean z, h hVar) {
        this.s.n(iOException);
        if (this.n.cd()) {
            return !(z && (hVar.q() instanceof d)) && n(iOException, z) && this.s.w();
        }
        return false;
    }

    private boolean n(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private h n(bb bbVar) throws IOException {
        String strQg;
        um umVarS;
        Proxy proxyQ;
        if (bbVar == null) {
            throw new IllegalStateException();
        }
        com.byazt.sqs.s sVarQg = this.s.qg();
        lh lhVarN = sVarQg != null ? sVarQg.n() : null;
        int iQ = bbVar.q();
        String strQg2 = bbVar.qg().qg();
        if (iQ == 307 || iQ == 308) {
            if (!TapHttp.METHOD_GET.equals(strQg2) && !"HEAD".equals(strQg2)) {
                return null;
            }
        } else {
            if (iQ == 401) {
                return this.n.oa().n(lhVarN, bbVar);
            }
            if (iQ == 407) {
                if (lhVarN != null) {
                    proxyQ = lhVarN.qg();
                } else {
                    proxyQ = this.n.q();
                }
                if (proxyQ.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.n.sz().n(lhVarN, bbVar);
            }
            if (iQ == 408) {
                if (!this.n.cd() || (bbVar.qg().q() instanceof d)) {
                    return null;
                }
                if (bbVar.d() == null || bbVar.d().q() != 408) {
                    return bbVar.qg();
                }
                return null;
            }
            switch (iQ) {
                case TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX /* 300 */:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.n.hd() || (strQg = bbVar.qg("Location")) == null || (umVarS = bbVar.qg().n().s(strQg)) == null) {
            return null;
        }
        if (!umVarS.qg().equals(bbVar.qg().n().qg()) && !this.n.cy()) {
            return null;
        }
        h.n nVarX = bbVar.qg().x();
        if (w.s(strQg2)) {
            boolean zQ = w.q(strQg2);
            if (w.l(strQg2)) {
                nVarX.n(TapHttp.METHOD_GET, (t) null);
            } else {
                nVarX.n(strQg2, zQ ? bbVar.qg().q() : null);
            }
            if (!zQ) {
                nVarX.qg("Transfer-Encoding");
                nVarX.qg("Content-Length");
                nVarX.qg(b.g);
            }
        }
        if (!n(bbVar, umVarS)) {
            nVarX.qg("Authorization");
        }
        return nVarX.n(umVarS).n();
    }

    private boolean n(bb bbVar, um umVar) {
        um umVarN = bbVar.qg().n();
        return umVarN.w().equals(umVar.w()) && umVarN.x() == umVar.x() && umVarN.qg().equals(umVar.qg());
    }
}
