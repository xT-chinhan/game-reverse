package com.byazt.jv;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS})
public class fo implements Cloneable {
    public final hw a;
    public final nt.pr aj;
    public final int b;
    public final List<rc> c;
    public final vk cz;
    public final boolean fo;
    public final List<a> fw;
    public final SocketFactory g;
    public final int gz;
    public final g hn;
    public final SSLSocketFactory ho;
    public final int iu;
    public final hn k;
    public final fw lb;
    public final com.byazt.gr.uc m;
    public Set<String> nl;
    public final com.byazt.di.hn nt;
    public final ho ny;
    public final hw qa;
    public final boolean rc;
    public final List<w> uc;
    public final int ve;
    public final ProxySelector vk;
    public final m w;
    public final Proxy x;
    public final HostnameVerifier yb;
    public final boolean z;
    public final List<a> zo;
    public static final List<rc> pr = com.byazt.xx.hn.pr(rc.HTTP_2, rc.HTTP_1_1);
    public static final List<w> hw = com.byazt.xx.hn.pr(w.pr, w.hn);

    static {
        com.byazt.xx.pr.pr = new com.byazt.xx.pr() { // from class: com.byazt.jv.fo.1
            @Override // com.byazt.xx.pr
            public void pr(lb.pr prVar, String str) {
                prVar.pr(str);
            }

            @Override // com.byazt.xx.pr
            public void pr(lb.pr prVar, String str, String str2) {
                prVar.hw(str, str2);
            }

            @Override // com.byazt.xx.pr
            public boolean pr(vk vkVar, com.byazt.iaw.hn hnVar) {
                return vkVar.hw(hnVar);
            }

            @Override // com.byazt.xx.pr
            public com.byazt.iaw.hn pr(vk vkVar, com.byazt.jv.pr prVar, com.byazt.iaw.fw fwVar, y yVar) {
                return vkVar.pr(prVar, fwVar, yVar);
            }

            @Override // com.byazt.xx.pr
            public boolean pr(com.byazt.jv.pr prVar, com.byazt.jv.pr prVar2) {
                return prVar.pr(prVar2);
            }

            @Override // com.byazt.xx.pr
            public Socket pr(vk vkVar, com.byazt.jv.pr prVar, com.byazt.iaw.fw fwVar) {
                return vkVar.pr(prVar, fwVar);
            }

            @Override // com.byazt.xx.pr
            public void hw(vk vkVar, com.byazt.iaw.hn hnVar) {
                vkVar.pr(hnVar);
            }

            @Override // com.byazt.xx.pr
            public com.byazt.iaw.x pr(vk vkVar) {
                return vkVar.pr;
            }

            @Override // com.byazt.xx.pr
            public int pr(gz.pr prVar) {
                return prVar.hn;
            }

            @Override // com.byazt.xx.pr
            public void pr(w wVar, SSLSocket sSLSocket, boolean z) {
                wVar.pr(sSLSocket, z);
            }
        };
    }

    public fo() {
        this(new pr());
    }

    public fo(pr prVar) {
        this.hn = prVar.pr;
        this.x = prVar.hw;
        this.c = prVar.hn;
        List<w> list = prVar.x;
        this.uc = list;
        this.fw = com.byazt.xx.hn.pr(prVar.c);
        this.zo = com.byazt.xx.hn.pr(prVar.uc);
        this.aj = prVar.fw;
        this.vk = prVar.zo;
        this.w = prVar.aj;
        this.k = prVar.vk;
        this.m = prVar.w;
        this.g = prVar.k;
        this.nl = prVar.gz;
        Iterator<w> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = z || it.next().pr();
        }
        if (prVar.m != null || !z) {
            this.ho = prVar.m;
            this.nt = prVar.g;
        } else {
            X509TrustManager x509TrustManagerZ = z();
            this.ho = pr(x509TrustManagerZ);
            this.nt = com.byazt.di.hn.pr(x509TrustManagerZ);
        }
        this.yb = prVar.ho;
        this.lb = prVar.nt.pr(this.nt);
        this.qa = prVar.yb;
        this.a = prVar.lb;
        vk vkVar = prVar.qa;
        this.cz = vkVar;
        if (vkVar != null) {
            vkVar.pr(prVar.ve);
        }
        this.ny = prVar.a;
        this.fo = prVar.cz;
        this.rc = prVar.ny;
        this.z = prVar.fo;
        this.b = prVar.rc;
        this.iu = prVar.z;
        this.ve = prVar.b;
        this.gz = prVar.iu;
        if (this.fw.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.fw);
        }
        if (this.zo.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.zo);
        }
    }

    private X509TrustManager z() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw com.byazt.xx.hn.pr("No System TLS", (Exception) e);
        }
    }

    private SSLSocketFactory pr(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw com.byazt.xx.hn.pr("No System TLS", (Exception) e);
        }
    }

    public int pr() {
        return this.b;
    }

    public int hw() {
        return this.iu;
    }

    public int hn() {
        return this.ve;
    }

    public Proxy x() {
        return this.x;
    }

    public ProxySelector c() {
        return this.vk;
    }

    public m uc() {
        return this.w;
    }

    public com.byazt.gr.uc fw() {
        hn hnVar = this.k;
        return hnVar != null ? hnVar.pr : this.m;
    }

    public ho zo() {
        return this.ny;
    }

    public SocketFactory aj() {
        return this.g;
    }

    public SSLSocketFactory vk() {
        return this.ho;
    }

    public HostnameVerifier w() {
        return this.yb;
    }

    public fw k() {
        return this.lb;
    }

    public hw m() {
        return this.a;
    }

    public hw g() {
        return this.qa;
    }

    public vk ho() {
        return this.cz;
    }

    public boolean nt() {
        return this.fo;
    }

    public boolean yb() {
        return this.rc;
    }

    public boolean lb() {
        return this.z;
    }

    public g qa() {
        return this.hn;
    }

    public List<rc> a() {
        return this.c;
    }

    public List<w> cz() {
        return this.uc;
    }

    public List<a> ny() {
        return this.fw;
    }

    public List<a> fo() {
        return this.zo;
    }

    public nt.pr rc() {
        return this.aj;
    }

    public c pr(b bVar) {
        return z.pr(this, bVar, false);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
    public static final class pr {
        public ho a;
        public m aj;
        public int b;
        public final List<a> c;
        public boolean cz;
        public boolean fo;
        public nt.pr fw;
        public com.byazt.di.hn g;
        public Set<String> gz;
        public List<rc> hn;
        public HostnameVerifier ho;
        public Proxy hw;
        public int iu;
        public SocketFactory k;
        public hw lb;
        public SSLSocketFactory m;
        public TimeUnit nl;
        public fw nt;
        public boolean ny;
        public g pr;
        public vk qa;
        public int rc;
        public final List<a> uc;
        public Bundle ve;
        public hn vk;
        public com.byazt.gr.uc w;
        public TimeUnit ww;
        public List<w> x;
        public TimeUnit y;
        public hw yb;
        public int z;
        public ProxySelector zo;

        public pr() {
            this("");
        }

        public pr(String str) {
            this.c = new ArrayList();
            this.uc = new ArrayList();
            this.nl = TimeUnit.MILLISECONDS;
            this.y = TimeUnit.MILLISECONDS;
            this.ww = TimeUnit.MILLISECONDS;
            this.pr = new g(str);
            this.hn = fo.pr;
            this.x = fo.hw;
            this.fw = nt.pr(nt.pr);
            this.zo = ProxySelector.getDefault();
            this.aj = m.pr;
            this.k = SocketFactory.getDefault();
            this.ho = com.byazt.di.c.pr;
            this.nt = fw.pr;
            this.yb = hw.pr;
            this.lb = hw.pr;
            this.qa = new vk();
            this.a = ho.pr;
            this.cz = true;
            this.ny = true;
            this.fo = true;
            this.rc = 10000;
            this.z = 10000;
            this.b = 10000;
            this.iu = 0;
        }

        public pr pr(long j, TimeUnit timeUnit) {
            this.rc = com.byazt.xx.hn.pr("timeout", j, timeUnit);
            return this;
        }

        public pr hw(long j, TimeUnit timeUnit) {
            this.z = com.byazt.xx.hn.pr("timeout", j, timeUnit);
            return this;
        }

        public pr hn(long j, TimeUnit timeUnit) {
            this.b = com.byazt.xx.hn.pr("timeout", j, timeUnit);
            return this;
        }

        public pr pr(Proxy proxy) {
            this.hw = proxy;
            return this;
        }

        public pr pr(ho hoVar) {
            if (hoVar == null) {
                throw new NullPointerException("dns == null");
            }
            this.a = hoVar;
            return this;
        }

        public pr pr(a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.c.add(aVar);
            return this;
        }

        public pr pr(nt ntVar) {
            if (ntVar == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.fw = nt.pr(ntVar);
            return this;
        }

        public fo pr() {
            return new fo(this);
        }
    }
}
