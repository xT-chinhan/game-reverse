package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0463a> amz = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.e
    public final void xk() {
        w wVarXL = r.xI().xL();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.amz) {
            List<a.InterfaceC0463a> list = (List) this.amz.clone();
            this.amz.clear();
            ArrayList arrayList = new ArrayList(wVarXL.xP());
            for (a.InterfaceC0463a interfaceC0463a : list) {
                int iWT = interfaceC0463a.wT();
                if (wVarXL.bA(iWT)) {
                    interfaceC0463a.wR().wA().wZ();
                    if (!arrayList.contains(Integer.valueOf(iWT))) {
                        arrayList.add(Integer.valueOf(iWT));
                    }
                } else {
                    interfaceC0463a.wX();
                }
            }
            wVarXL.q(arrayList);
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void xl() {
        if (xm() == DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            w wVarXL = r.xI().xL();
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.xp().size()));
            }
            if (h.xp().size() > 0) {
                synchronized (this.amz) {
                    h.xp().p(this.amz);
                    Iterator<a.InterfaceC0463a> it = this.amz.iterator();
                    while (it.hasNext()) {
                        it.next().free();
                    }
                    wVarXL.xO();
                }
                r.xI().xJ();
                return;
            }
            return;
        }
        if (h.xp().size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.xp().size()));
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC0463a interfaceC0463a) {
        return !this.amz.isEmpty() && this.amz.contains(interfaceC0463a);
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC0463a interfaceC0463a) {
        if (this.amz.isEmpty()) {
            return;
        }
        synchronized (this.amz) {
            this.amz.remove(interfaceC0463a);
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC0463a interfaceC0463a) {
        r.xI();
        if (!r.xK()) {
            synchronized (this.amz) {
                r.xI();
                if (!r.xK()) {
                    if (com.kwad.framework.filedownloader.f.d.apD) {
                        com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0463a.wR().getId()));
                    }
                    n.xA().aG(com.kwad.framework.filedownloader.f.c.zz());
                    if (!this.amz.contains(interfaceC0463a)) {
                        interfaceC0463a.free();
                        this.amz.add(interfaceC0463a);
                    }
                    return true;
                }
            }
        }
        e(interfaceC0463a);
        return false;
    }
}
