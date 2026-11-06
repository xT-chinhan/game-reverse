package com.byazt.sqs;

import com.byazt.pq.cy;
import com.byazt.pq.lh;
import com.byazt.pq.um;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 707, 13})
public final class w {
    public final com.byazt.pq.n n;
    public final cy q;
    public final q qg;
    public final com.byazt.pq.l s;
    public int w;
    public List<Proxy> l = Collections.emptyList();
    public List<InetSocketAddress> x = Collections.emptyList();
    public final List<lh> fs = new ArrayList();

    public w(com.byazt.pq.n nVar, q qVar, com.byazt.pq.l lVar, cy cyVar) throws IOException {
        this.n = nVar;
        this.qg = qVar;
        this.s = lVar;
        this.q = cyVar;
        n(nVar.n(), nVar.fs());
    }

    public boolean n() {
        return s() || !this.fs.isEmpty();
    }

    public n qg() throws IOException {
        if (!n()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (s()) {
            Proxy proxyQ = q();
            int size = this.x.size();
            for (int i = 0; i < size; i++) {
                lh lhVar = new lh(this.n, proxyQ, this.x.get(i));
                if (this.qg.s(lhVar)) {
                    this.fs.add(lhVar);
                } else {
                    arrayList.add(lhVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.fs);
            this.fs.clear();
        }
        return new n(arrayList);
    }

    public void n(lh lhVar, IOException iOException) {
        if (lhVar.qg().type() != Proxy.Type.DIRECT && this.n.x() != null) {
            this.n.x().connectFailed(this.n.n().n(), lhVar.qg().address(), iOException);
        }
        this.qg.n(lhVar);
    }

    private void n(um umVar, Proxy proxy) throws IOException {
        List<Proxy> listN;
        if (proxy != null) {
            this.l = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> listSelect = this.n.x().select(umVar.n());
                if (listSelect != null && !listSelect.isEmpty()) {
                    listN = com.byazt.zho.s.n(listSelect);
                } else {
                    listN = com.byazt.zho.s.n(Proxy.NO_PROXY);
                }
                this.l = listN;
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.w = 0;
    }

    private boolean s() {
        return this.w < this.l.size();
    }

    private Proxy q() throws IOException {
        if (!s()) {
            throw new SocketException("No route to " + this.n.n().w() + "; exhausted proxy configurations: " + this.l);
        }
        List<Proxy> list = this.l;
        int i = this.w;
        this.w = i + 1;
        Proxy proxy = list.get(i);
        n(proxy);
        return proxy;
    }

    private void n(Proxy proxy) throws IOException {
        String strW;
        int iX;
        this.x = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strW = this.n.n().w();
            iX = this.n.n().x();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strW = n(inetSocketAddress);
            iX = inetSocketAddress.getPort();
        }
        if (iX <= 0 || iX > 65535) {
            throw new SocketException("No route to " + strW + ":" + iX + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.x.add(InetSocketAddress.createUnresolved(strW, iX));
            return;
        }
        List<InetAddress> listN = this.n.qg().n(strW);
        if (listN.isEmpty()) {
            return;
        }
        int size = listN.size();
        for (int i = 0; i < size; i++) {
            this.x.add(new InetSocketAddress(listN.get(i), iX));
        }
    }

    public static String n(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    @com.byazt.cp.n(n = {0, 1, 707, 108})
    public static final class n {
        public final List<lh> n;
        public int qg = 0;

        public n(List<lh> list) {
            this.n = list;
        }

        public boolean n() {
            return this.qg < this.n.size();
        }

        public lh qg() {
            if (!n()) {
                throw new NoSuchElementException();
            }
            List<lh> list = this.n;
            int i = this.qg;
            this.qg = i + 1;
            return list.get(i);
        }

        public List<lh> s() {
            return new ArrayList(this.n);
        }
    }
}
