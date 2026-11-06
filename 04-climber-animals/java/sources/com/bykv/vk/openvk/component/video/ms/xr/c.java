package com.bykv.vk.openvk.component.video.ms.xr;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.ca;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c d;
    private volatile com.bykv.vk.openvk.component.video.ms.xr.ms.xr ab;
    private final AtomicInteger ah = new AtomicInteger(0);
    private volatile com.bykv.vk.openvk.component.video.ms.xr.ms.ah c;
    private volatile ah ch;
    private volatile ah hi;
    private volatile com.bykv.vk.openvk.component.video.ms.xr.xr.ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile ServerSocket f65ms;
    private final ab.ah ny;
    private final Runnable sl;
    private final SparseArray<Set<ab>> x;
    private volatile int xr;
    private final AtomicBoolean zb;

    static /* synthetic */ void ms(String str, String str2) {
    }

    boolean ms(int i, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.x) {
            Set<ab> set = this.x.get(i);
            if (set != null) {
                for (ab abVar : set) {
                    if (abVar != null && str.equals(abVar.x)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static c ms() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    private c() {
        SparseArray<Set<ab>> sparseArray = new SparseArray<>(2);
        this.x = sparseArray;
        this.ny = new ab.ah() { // from class: com.bykv.vk.openvk.component.video.ms.xr.c.1
            @Override // com.bykv.vk.openvk.component.video.ms.xr.ab.ah
            public void ms(ab abVar) {
                synchronized (c.this.x) {
                    Set set = (Set) c.this.x.get(abVar.c());
                    if (set != null) {
                        set.add(abVar);
                    }
                }
            }

            @Override // com.bykv.vk.openvk.component.video.ms.xr.ab.ah
            public void xr(ab abVar) {
                boolean z = ka.ah;
                int iC = abVar.c();
                synchronized (c.this.x) {
                    Set set = (Set) c.this.x.get(iC);
                    if (set != null) {
                        set.remove(abVar);
                    }
                }
            }
        };
        this.sl = new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.xr.c.2
            /* JADX WARN: Code duplicated, block: B:33:0x0108  */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i = 0;
                    c.this.f65ms = new ServerSocket(0, 50, InetAddress.getByName(c.this.ny()));
                    c cVar = c.this;
                    cVar.xr = cVar.f65ms.getLocalPort();
                    if (c.this.xr != -1) {
                        ch.ms(c.this.ny(), c.this.xr);
                        if (c.this.ab()) {
                            com.bykv.vk.openvk.component.video.api.c.ah.ms("ProxyServer", "run:  state = ", c.this.ah);
                            if (c.this.ah.compareAndSet(0, 1)) {
                                com.bykv.vk.openvk.component.video.api.c.ah.ms("ProxyServer", "run:  state = ", c.this.ah);
                                if (ka.ah) {
                                    com.bykv.vk.openvk.component.video.api.c.ah.ms("ProxyServer", "proxy server start!");
                                }
                                while (c.this.ah.get() == 1) {
                                    try {
                                        try {
                                            Socket socketAccept = c.this.f65ms.accept();
                                            com.bykv.vk.openvk.component.video.ms.xr.xr.ah ahVar = c.this.ka;
                                            if (ahVar != null) {
                                                final ab abVarMs = new ab.ms().ms(ahVar).ms(socketAccept).ms(c.this.ny).ms();
                                                com.bytedance.sdk.component.ch.ab.ms().execute(new com.bytedance.sdk.component.ch.ny("ProxyTask", 10) { // from class: com.bykv.vk.openvk.component.video.ms.xr.c.2.1
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        abVarMs.run();
                                                    }
                                                });
                                            } else {
                                                com.bykv.vk.openvk.component.video.ms.ah.ms.ms(socketAccept);
                                            }
                                        } catch (IOException e) {
                                            com.bytedance.sdk.component.utils.sl.ms(e);
                                            c.ms("accept error", Log.getStackTraceString(e));
                                            i++;
                                            if (i > 3) {
                                                if (ka.ah) {
                                                    com.bykv.vk.openvk.component.video.api.c.ah.ms("ProxyServer", "proxy server closed!");
                                                }
                                                c.this.ka();
                                                return;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        String stackTraceString = Log.getStackTraceString(th);
                                        com.bytedance.sdk.component.utils.sl.d("ProxyServer", "proxy server crashed!  ".concat(String.valueOf(stackTraceString)));
                                        c.ms("error", stackTraceString);
                                    }
                                }
                                if (ka.ah) {
                                    com.bykv.vk.openvk.component.video.api.c.ah.ms("ProxyServer", "proxy server closed!");
                                }
                                c.this.ka();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    c.ms("socket not bound", "");
                    c.this.ka();
                } catch (IOException e2) {
                    if (ka.ah) {
                        com.bytedance.sdk.component.utils.sl.d("ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e2));
                    }
                    c.ms("create ServerSocket error", Log.getStackTraceString(e2));
                    c.this.ka();
                }
            }
        };
        this.zb = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    ah xr() {
        return this.ch;
    }

    ah ah() {
        return this.hi;
    }

    void ms(com.bykv.vk.openvk.component.video.ms.xr.xr.ah ahVar) {
        this.ka = ahVar;
    }

    void ms(com.bykv.vk.openvk.component.video.ms.xr.ms.ah ahVar) {
        this.c = ahVar;
    }

    public String ms(boolean z, boolean z2, String str, String... strArr) {
        String str2;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return strArr[0];
        }
        if (this.ka == null) {
            return strArr[0];
        }
        if ((z ? this.ab : this.c) == null) {
            return strArr[0];
        }
        if (this.ah.get() != 1) {
            return strArr[0];
        }
        List<String> listMs = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(strArr);
        if (listMs == null) {
            return strArr[0];
        }
        String strMs = ny.ms(str, z2 ? str : com.bykv.vk.openvk.component.video.api.c.xr.ms(str), listMs);
        if (strMs == null) {
            return strArr[0];
        }
        if (z) {
            str2 = "https://" + ny() + ":" + this.xr + "?f=1&" + strMs;
        } else {
            str2 = "https://" + ny() + ":" + this.xr + "?" + strMs;
        }
        return str2.replaceFirst("s", "");
    }

    public void d() {
        if (this.zb.compareAndSet(false, true)) {
            com.bytedance.sdk.component.ch.d.ah ahVar = new com.bytedance.sdk.component.ch.d.ah(this.sl, "r/ProxyServer");
            ahVar.setName("csj_proxy_server");
            ahVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        if (this.ah.compareAndSet(1, 2) || this.ah.compareAndSet(0, 2)) {
            com.bykv.vk.openvk.component.video.ms.ah.ms.ms(this.f65ms);
            c();
        }
    }

    private void c() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.x) {
            int size = this.x.size();
            for (int i = 0; i < size; i++) {
                SparseArray<Set<ab>> sparseArray = this.x;
                Set<ab> set = sparseArray.get(sparseArray.keyAt(i));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ab) it.next()).ms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ab() {
        com.bytedance.sdk.component.ch.x xVar = new com.bytedance.sdk.component.ch.x(new ms(ny(), this.xr), 5, 1);
        com.bytedance.sdk.component.ch.ab.ms().submit(xVar);
        x();
        try {
            if (!((Boolean) xVar.get()).booleanValue()) {
                com.bytedance.sdk.component.utils.sl.d("ProxyServer", "Ping error");
                ka();
                return false;
            }
            com.bykv.vk.openvk.component.video.api.c.ah.ms("ProxyServer", "pingTest: ");
            if (ka.ah) {
                com.bykv.vk.openvk.component.video.api.c.ah.ms("ProxyServer", "Ping OK!");
            }
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            Log.getStackTraceString(th);
            ka();
            return false;
        }
    }

    private static final class ms implements Callable<Boolean> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final String f69ms;
        private final int xr;

        ms(String str, int i) {
            this.f69ms = str;
            this.xr = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                socket = new Socket(this.f69ms, this.xr);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(com.bykv.vk.openvk.component.video.ms.ah.ms.f28ms));
                    outputStream.flush();
                    if (ca.k.equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        Boolean bool = Boolean.TRUE;
                        com.bykv.vk.openvk.component.video.ms.ah.ms.ms(socket);
                        return bool;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        com.bykv.vk.openvk.component.video.api.c.ah.ms("ProxyServer", "call: ", th);
                        c.ms("ping error", Log.getStackTraceString(th));
                    } finally {
                        com.bykv.vk.openvk.component.video.ms.ah.ms.ms(socket);
                    }
                }
            } catch (Throwable th3) {
                socket = null;
                th = th3;
            }
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private void x() {
        ?? r0;
        ?? Accept = 0;
        Accept = 0;
        try {
            try {
                Accept = this.f65ms.accept();
                Accept.setSoTimeout(2000);
                boolean zEquals = "Ping".equals(new BufferedReader(new InputStreamReader(Accept.getInputStream())).readLine());
                r0 = Accept;
                if (zEquals) {
                    OutputStream outputStream = Accept.getOutputStream();
                    outputStream.write("OK\n".getBytes(com.bykv.vk.openvk.component.video.ms.ah.ms.f28ms));
                    outputStream.flush();
                    r0 = Accept;
                }
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
                Log.getStackTraceString(e);
                r0 = Accept;
            }
            com.bykv.vk.openvk.component.video.ms.ah.ms.ms((Socket) r0);
            Accept = "ProxyServer";
            com.bykv.vk.openvk.component.video.api.c.ah.ms("ProxyServer", "answerPing: ");
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.ms.ah.ms.ms((Socket) Accept);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ny() {
        return new String(Base64.decode("MTI3LjAuMC4x".getBytes(), 0));
    }
}
