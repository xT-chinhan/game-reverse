package com.tapsdk.tapad.internal.q.f;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class b implements a {
    private final com.tapsdk.tapad.internal.q.c.b a;

    public b(com.tapsdk.tapad.internal.q.c.b bVar) {
        this.a = bVar;
    }

    @Override // com.tapsdk.tapad.internal.q.f.a
    public void a(a.InterfaceC0630a interfaceC0630a, a.b bVar) {
        if (interfaceC0630a == null || bVar == null) {
            return;
        }
        com.tapsdk.tapad.internal.q.e.a aVar = new com.tapsdk.tapad.internal.q.e.a(bVar.a());
        aVar.d = interfaceC0630a.e();
        aVar.b = interfaceC0630a.b();
        aVar.c = interfaceC0630a.d();
        aVar.h = interfaceC0630a.c();
        aVar.f = interfaceC0630a.f();
        aVar.e = bVar.e();
        aVar.i = bVar.d();
        aVar.j = bVar.f();
        aVar.k = bVar.b();
        aVar.g = bVar.c();
        this.a.a(aVar);
    }

    @Override // com.tapsdk.tapad.internal.q.f.a
    public void a(a.InterfaceC0630a interfaceC0630a, a.b bVar, Exception exc) {
        if (interfaceC0630a == null || bVar == null) {
            return;
        }
        com.tapsdk.tapad.internal.q.e.a aVar = new com.tapsdk.tapad.internal.q.e.a(bVar.a());
        aVar.d = interfaceC0630a.e();
        aVar.b = interfaceC0630a.b();
        aVar.c = interfaceC0630a.d();
        aVar.h = interfaceC0630a.c();
        aVar.f = interfaceC0630a.f();
        aVar.i = bVar.d();
        aVar.j = bVar.f();
        aVar.k = bVar.b();
        aVar.g = bVar.c();
        this.a.a(aVar, exc);
    }

    @Override // com.tapsdk.tapad.internal.q.f.a
    public void a(a.InterfaceC0630a interfaceC0630a, IOException iOException) {
        if (interfaceC0630a != null) {
            com.tapsdk.tapad.internal.q.e.a aVar = new com.tapsdk.tapad.internal.q.e.a(interfaceC0630a.a());
            aVar.b = interfaceC0630a.b();
            aVar.c = interfaceC0630a.d();
            aVar.h = interfaceC0630a.c();
            aVar.d = interfaceC0630a.e();
            aVar.f = interfaceC0630a.f();
            this.a.a(aVar, iOException);
        }
    }
}
