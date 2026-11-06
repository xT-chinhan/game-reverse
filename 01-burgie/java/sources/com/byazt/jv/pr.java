package com.byazt.jv;

import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 37})
public final class pr {
    public final SSLSocketFactory aj;
    public final List<rc> c;
    public final ProxySelector fw;
    public final SocketFactory hn;
    public final ho hw;
    public final qa pr;
    public final List<w> uc;
    public final HostnameVerifier vk;
    public final fw w;
    public final hw x;
    public final Proxy zo;

    public pr(String str, int i, ho hoVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, fw fwVar, hw hwVar, Proxy proxy, List<rc> list, List<w> list2, ProxySelector proxySelector) {
        this.pr = new qa.pr().pr(sSLSocketFactory != null ? BaseConstants.SCHEME_HTTPS : "http").x(str).pr(i).hn();
        if (hoVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.hw = hoVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.hn = socketFactory;
        if (hwVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.x = hwVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.c = com.byazt.xx.hn.pr(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.uc = com.byazt.xx.hn.pr(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.fw = proxySelector;
        this.zo = proxy;
        this.aj = sSLSocketFactory;
        this.vk = hostnameVerifier;
        this.w = fwVar;
    }

    public qa pr() {
        return this.pr;
    }

    public ho hw() {
        return this.hw;
    }

    public SocketFactory hn() {
        return this.hn;
    }

    public hw x() {
        return this.x;
    }

    public List<rc> c() {
        return this.c;
    }

    public List<w> uc() {
        return this.uc;
    }

    public ProxySelector fw() {
        return this.fw;
    }

    public Proxy zo() {
        return this.zo;
    }

    public SSLSocketFactory aj() {
        return this.aj;
    }

    public HostnameVerifier vk() {
        return this.vk;
    }

    public fw w() {
        return this.w;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pr)) {
            return false;
        }
        pr prVar = (pr) obj;
        return this.pr.equals(prVar.pr) && pr(prVar);
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.pr.hashCode() + 527) * 31) + this.hw.hashCode()) * 31) + this.x.hashCode()) * 31) + this.c.hashCode()) * 31) + this.uc.hashCode()) * 31) + this.fw.hashCode()) * 31;
        Proxy proxy = this.zo;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.aj;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.vk;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        fw fwVar = this.w;
        return iHashCode4 + (fwVar != null ? fwVar.hashCode() : 0);
    }

    public boolean pr(pr prVar) {
        return this.hw.equals(prVar.hw) && this.x.equals(prVar.x) && this.c.equals(prVar.c) && this.uc.equals(prVar.uc) && this.fw.equals(prVar.fw) && com.byazt.xx.hn.pr(this.zo, prVar.zo) && com.byazt.xx.hn.pr(this.aj, prVar.aj) && com.byazt.xx.hn.pr(this.vk, prVar.vk) && com.byazt.xx.hn.pr(this.w, prVar.w) && pr().fw() == prVar.pr().fw();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Address{").append(this.pr.uc()).append(":").append(this.pr.fw());
        if (this.zo != null) {
            sbAppend.append(", proxy=").append(this.zo);
        } else {
            sbAppend.append(", proxySelector=").append(this.fw);
        }
        sbAppend.append("}");
        return sbAppend.toString();
    }
}
