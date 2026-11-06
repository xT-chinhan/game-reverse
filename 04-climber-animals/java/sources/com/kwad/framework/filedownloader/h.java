package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private final ArrayList<com.kwad.framework.filedownloader.a.InterfaceC0463a> alT;

    /* synthetic */ h(byte b) {
        this();
    }

    static final class a {
        private static final h alU = new h(0);
    }

    public static h xp() {
        return a.alU;
    }

    private h() {
        this.alT = new ArrayList<>();
    }

    final int size() {
        return this.alT.size();
    }

    final int bs(int i) {
        int i2;
        synchronized (this.alT) {
            Iterator<com.kwad.framework.filedownloader.a.InterfaceC0463a> it = this.alT.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().br(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    final List<com.kwad.framework.filedownloader.a.InterfaceC0463a> bt(int i) {
        byte bWJ;
        ArrayList arrayList = new ArrayList();
        synchronized (this.alT) {
            for (com.kwad.framework.filedownloader.a.InterfaceC0463a interfaceC0463a : this.alT) {
                if (interfaceC0463a.br(i) && !interfaceC0463a.isOver() && (bWJ = interfaceC0463a.wR().wJ()) != 0 && bWJ != 10) {
                    arrayList.add(interfaceC0463a);
                }
            }
        }
        return arrayList;
    }

    final List<com.kwad.framework.filedownloader.a.InterfaceC0463a> bu(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.alT) {
            for (com.kwad.framework.filedownloader.a.InterfaceC0463a interfaceC0463a : this.alT) {
                if (interfaceC0463a.br(i) && !interfaceC0463a.isOver()) {
                    arrayList.add(interfaceC0463a);
                }
            }
        }
        return arrayList;
    }

    final boolean a(com.kwad.framework.filedownloader.a.InterfaceC0463a interfaceC0463a) {
        return this.alT.isEmpty() || !this.alT.contains(interfaceC0463a);
    }

    final void p(List<com.kwad.framework.filedownloader.a.InterfaceC0463a> list) {
        synchronized (this.alT) {
            for (com.kwad.framework.filedownloader.a.InterfaceC0463a interfaceC0463a : this.alT) {
                if (!list.contains(interfaceC0463a)) {
                    list.add(interfaceC0463a);
                }
            }
            this.alT.clear();
        }
    }

    public final boolean a(com.kwad.framework.filedownloader.a.InterfaceC0463a interfaceC0463a, MessageSnapshot messageSnapshot) {
        boolean zRemove;
        byte bWJ = messageSnapshot.wJ();
        synchronized (this.alT) {
            zRemove = this.alT.remove(interfaceC0463a);
        }
        if (com.kwad.framework.filedownloader.f.d.apD && this.alT.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0463a, Byte.valueOf(bWJ), Integer.valueOf(this.alT.size()));
        }
        if (zRemove) {
            t tVarXh = interfaceC0463a.wS().xh();
            if (bWJ == -4) {
                tVarXh.l(messageSnapshot);
            } else if (bWJ == -3) {
                tVarXh.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            } else if (bWJ == -2) {
                tVarXh.n(messageSnapshot);
            } else if (bWJ == -1) {
                tVarXh.m(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0463a, Byte.valueOf(bWJ));
        }
        return zRemove;
    }

    final void b(com.kwad.framework.filedownloader.a.InterfaceC0463a interfaceC0463a) {
        if (!interfaceC0463a.wR().wC()) {
            interfaceC0463a.wU();
        }
        if (interfaceC0463a.wS().xh().xu()) {
            c(interfaceC0463a);
        }
    }

    final void c(com.kwad.framework.filedownloader.a.InterfaceC0463a interfaceC0463a) {
        if (interfaceC0463a.wV()) {
            return;
        }
        synchronized (this.alT) {
            if (this.alT.contains(interfaceC0463a)) {
                com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0463a);
            } else {
                interfaceC0463a.wW();
                this.alT.add(interfaceC0463a);
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0463a, Byte.valueOf(interfaceC0463a.wR().wJ()), Integer.valueOf(this.alT.size()));
                }
            }
        }
    }
}
