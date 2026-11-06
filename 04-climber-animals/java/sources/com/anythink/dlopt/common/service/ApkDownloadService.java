package com.anythink.dlopt.common.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.anythink.dlopt.common.a.j;
import com.anythink.dlopt.common.a.o;
import com.anythink.dlopt.common.b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ApkDownloadService extends Service {
    public static final String a = "extra_unique_id";
    private static final String b = "ApkDownloadService";
    private final Map<String, com.anythink.dlopt.common.a.a> c = new HashMap();

    public class a extends Binder implements com.anythink.dlopt.common.service.a {
        public a() {
        }

        @Override // com.anythink.dlopt.common.service.a
        public final void a(String str) {
            ApkDownloadService.this.a(str);
        }

        @Override // com.anythink.dlopt.common.service.a
        public final void b(String str) {
            com.anythink.dlopt.common.a.a aVar = (com.anythink.dlopt.common.a.a) ApkDownloadService.this.c.get(str);
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.anythink.dlopt.common.service.a
        public final void c(String str) {
            com.anythink.dlopt.common.a.a aVar = (com.anythink.dlopt.common.a.a) ApkDownloadService.this.c.get(str);
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.anythink.dlopt.common.service.a
        public final boolean a() {
            return ApkDownloadService.this.c.size() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            final b bVarA = b.a(getApplicationContext());
            j jVar = bVarA.f().get(str);
            if (jVar == null) {
                return;
            }
            o oVar = new o(jVar, bVarA.i());
            oVar.a(new com.anythink.dlopt.common.a.a.InterfaceC0112a() { // from class: com.anythink.dlopt.common.service.ApkDownloadService.1
                @Override // com.anythink.dlopt.common.a.a.InterfaceC0112a
                public final void a(j jVar2, long j, long j2) {
                    com.anythink.dlopt.common.a.a.InterfaceC0112a interfaceC0112aC = bVarA.c(jVar2.o);
                    if (interfaceC0112aC != null) {
                        interfaceC0112aC.a(jVar2, j, j2);
                    }
                }

                @Override // com.anythink.dlopt.common.a.a.InterfaceC0112a
                public final void a(j jVar2, long j) {
                    ApkDownloadService.this.c.remove(jVar2.o);
                    com.anythink.dlopt.common.a.a.InterfaceC0112a interfaceC0112aC = bVarA.c(jVar2.o);
                    if (interfaceC0112aC != null) {
                        interfaceC0112aC.a(jVar2, j);
                    }
                }

                @Override // com.anythink.dlopt.common.a.a.InterfaceC0112a
                public final void b(j jVar2, long j, long j2) {
                    com.anythink.dlopt.common.a.a.InterfaceC0112a interfaceC0112aC = bVarA.c(jVar2.o);
                    if (interfaceC0112aC != null) {
                        interfaceC0112aC.b(jVar2, j, j2);
                    }
                }

                @Override // com.anythink.dlopt.common.a.a.InterfaceC0112a
                public final void a(j jVar2, String str2) {
                    ApkDownloadService.this.c.remove(jVar2.o);
                    com.anythink.dlopt.common.a.a.InterfaceC0112a interfaceC0112aC = bVarA.c(jVar2.o);
                    if (interfaceC0112aC != null) {
                        interfaceC0112aC.a(jVar2, str2);
                    }
                }

                @Override // com.anythink.dlopt.common.a.a.InterfaceC0112a
                public final void a(j jVar2, long j, long j2, int i) {
                    ApkDownloadService.this.c.remove(jVar2.o);
                    com.anythink.dlopt.common.a.a.InterfaceC0112a interfaceC0112aC = bVarA.c(jVar2.o);
                    if (interfaceC0112aC != null) {
                        interfaceC0112aC.a(jVar2, j, j2, i);
                    }
                }
            });
            this.c.put(str, oVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent != null) {
            a(intent.getStringExtra(a));
        }
        return new a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        com.anythink.dlopt.common.b.a.a(getApplicationContext()).a();
        super.onTaskRemoved(intent);
    }
}
