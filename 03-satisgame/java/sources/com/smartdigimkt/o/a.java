package com.smartdigimkt.o;

import com.smartdigimkt.dlopt.common.service.ApkDownloadService;
import com.smartdigimkt.j.u;
import com.smartdigimkt.k.r;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.smartdigimkt.k.a {
    public final /* synthetic */ u a;
    public final /* synthetic */ ApkDownloadService b;

    public a(ApkDownloadService apkDownloadService, u uVar) {
        this.b = apkDownloadService;
        this.a = uVar;
    }

    @Override // com.smartdigimkt.k.a
    public final void a(r rVar, long j) {
        this.b.a.remove(rVar.o);
        u uVar = this.a;
        com.smartdigimkt.k.a aVar = (com.smartdigimkt.k.a) uVar.e.get(rVar.o);
        if (aVar != null) {
            aVar.a(rVar, j);
        }
    }

    @Override // com.smartdigimkt.k.a
    public final void b(r rVar, long j, long j2) {
        u uVar = this.a;
        com.smartdigimkt.k.a aVar = (com.smartdigimkt.k.a) uVar.e.get(rVar.o);
        if (aVar != null) {
            aVar.b(rVar, j, j2);
        }
    }

    @Override // com.smartdigimkt.k.a
    public final void a(r rVar, long j, long j2) {
        u uVar = this.a;
        com.smartdigimkt.k.a aVar = (com.smartdigimkt.k.a) uVar.e.get(rVar.o);
        if (aVar != null) {
            aVar.a(rVar, j, j2);
        }
    }

    @Override // com.smartdigimkt.k.a
    public final void a(r rVar, String str) {
        this.b.a.remove(rVar.o);
        u uVar = this.a;
        com.smartdigimkt.k.a aVar = (com.smartdigimkt.k.a) uVar.e.get(rVar.o);
        if (aVar != null) {
            aVar.a(rVar, str);
        }
    }

    @Override // com.smartdigimkt.k.a
    public final void a(r rVar, long j, long j2, int i) {
        this.b.a.remove(rVar.o);
        u uVar = this.a;
        com.smartdigimkt.k.a aVar = (com.smartdigimkt.k.a) uVar.e.get(rVar.o);
        if (aVar != null) {
            aVar.a(rVar, j, j2, i);
        }
    }
}
