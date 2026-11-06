package com.byazt.iaw;

import com.byazt.jv.nt;
import com.byazt.jv.qa;
import com.byazt.jv.y;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 507, 5})
public final class uc {
    public final com.byazt.jv.c hn;
    public final x hw;
    public final com.byazt.jv.pr pr;
    public int uc;
    public final nt x;
    public List<Proxy> c = Collections.emptyList();
    public List<InetSocketAddress> fw = Collections.emptyList();
    public final List<y> zo = new ArrayList();

    public uc(com.byazt.jv.pr prVar, x xVar, com.byazt.jv.c cVar, nt ntVar) throws IOException {
        this.pr = prVar;
        this.hw = xVar;
        this.hn = cVar;
        this.x = ntVar;
        pr(prVar.pr(), prVar.zo());
    }

    public boolean pr() {
        return hn() || !this.zo.isEmpty();
    }

    public pr hw() throws IOException {
        if (!pr()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (hn()) {
            Proxy proxyX = x();
            int size = this.fw.size();
            for (int i = 0; i < size; i++) {
                y yVar = new y(this.pr, proxyX, this.fw.get(i));
                if (this.hw.hn(yVar)) {
                    this.zo.add(yVar);
                } else {
                    arrayList.add(yVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.zo);
            this.zo.clear();
        }
        return new pr(arrayList);
    }

    public void pr(y yVar, IOException iOException) {
        if (yVar.hw().type() != Proxy.Type.DIRECT && this.pr.fw() != null) {
            this.pr.fw().connectFailed(this.pr.pr().pr(), yVar.hw().address(), iOException);
        }
        this.hw.pr(yVar);
    }

    private void pr(qa qaVar, Proxy proxy) throws IOException {
        List<Proxy> listPr;
        if (proxy != null) {
            this.c = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> listSelect = this.pr.fw().select(qaVar.pr());
                if (listSelect != null && !listSelect.isEmpty()) {
                    listPr = com.byazt.xx.hn.pr(listSelect);
                } else {
                    listPr = com.byazt.xx.hn.pr(Proxy.NO_PROXY);
                }
                this.c = listPr;
            } catch (IllegalArgumentException e) {
                throw new IOException();
            }
        }
        this.uc = 0;
    }

    private boolean hn() {
        return this.uc < this.c.size();
    }

    private Proxy x() throws IOException {
        if (!hn()) {
            throw new SocketException("No route to " + this.pr.pr().uc() + "; exhausted proxy configurations: " + this.c);
        }
        List<Proxy> list = this.c;
        int i = this.uc;
        this.uc = i + 1;
        Proxy proxy = list.get(i);
        pr(proxy);
        return proxy;
    }

    private void pr(Proxy proxy) throws IOException {
        String strUc;
        int iFw;
        this.fw = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strUc = this.pr.pr().uc();
            iFw = this.pr.pr().fw();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strUc = pr(inetSocketAddress);
            iFw = inetSocketAddress.getPort();
        }
        if (iFw <= 0 || iFw > 65535) {
            throw new SocketException("No route to " + strUc + ":" + iFw + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.fw.add(InetSocketAddress.createUnresolved(strUc, iFw));
            return;
        }
        List<InetAddress> listPr = this.pr.hw().pr(strUc);
        if (listPr.isEmpty()) {
            return;
        }
        int size = listPr.size();
        for (int i = 0; i < size; i++) {
            this.fw.add(new InetSocketAddress(listPr.get(i), iFw));
        }
    }

    public static String pr(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 507, 129})
    public static final class pr {
        public int hw = 0;
        public final List<y> pr;

        public pr(List<y> list) {
            this.pr = list;
        }

        public boolean pr() {
            return this.hw < this.pr.size();
        }

        public y hw() {
            if (!pr()) {
                throw new NoSuchElementException();
            }
            List<y> list = this.pr;
            int i = this.hw;
            this.hw = i + 1;
            return list.get(i);
        }

        public List<y> hn() {
            return new ArrayList(this.pr);
        }
    }
}
