package com.anythink.core.common.m.d.a;

import com.anythink.core.common.m.b.h;
import com.anythink.core.common.m.d.d;
import com.anythink.core.common.v.q;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    private static final int c = 0;
    private static final int d = 7;
    protected Socket a;
    private String e;
    private int f;
    private final String b = getClass().getSimpleName();
    private byte[] g = null;
    private final byte[] h = new byte[1];

    protected abstract void a(d dVar, d.a aVar);

    private void a(d dVar) {
        synchronized (this) {
            if (this.a == null) {
                Socket socket = new Socket();
                this.a = socket;
                socket.setSoTimeout(60000);
            }
            h hVarE_ = dVar.e_();
            if (hVarE_ != null) {
                this.e = hVarE_.a();
                int iB = hVarE_.b();
                this.f = iB;
                Object[] objArr = new Object[2];
                Integer.valueOf(iB);
                this.a.connect(new InetSocketAddress(this.e, this.f), 30000);
            } else {
                throw new IllegalArgumentException("The domain must not can be null or empty.");
            }
        }
    }

    private void a() {
        synchronized (this) {
            try {
                Socket socket = this.a;
                if (socket != null) {
                    socket.close();
                    this.a = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    private boolean b() {
        Socket socket = this.a;
        return (socket == null || !socket.isConnected() || this.a.isClosed()) ? false : true;
    }

    public final void b(final d dVar, final d.a aVar) {
        com.anythink.core.common.v.b.d dVar2 = new com.anythink.core.common.v.b.d() { // from class: com.anythink.core.common.m.d.a.c.1
            /* JADX WARN: Code duplicated, block: B:15:0x0092  */
            /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
            @Override // com.anythink.core.common.v.b.d
            public final void a() {
                d.a aVar2;
                try {
                    c.this.b(dVar);
                    c.this.a(dVar, aVar);
                } catch (SocketException e) {
                    String unused = c.this.b;
                    e.getMessage();
                    dVar.toString();
                    c.b(c.this);
                    try {
                        c.this.b(dVar);
                        c.this.a(dVar, aVar);
                    } catch (Throwable th) {
                        String unused2 = c.this.b;
                        e.getMessage();
                        dVar.toString();
                        th = th;
                        String str = th.getMessage() + "," + q.a(th.getStackTrace());
                        String unused3 = c.this.b;
                        Object[] objArr = new Object[1];
                        dVar.a("", str, c.this.e, c.this.f);
                        aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(th);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    String unused4 = c.this.b;
                    Object[] objArr2 = new Object[1];
                    th.getMessage();
                    String str2 = th.getMessage() + "," + q.a(th.getStackTrace());
                    String unused5 = c.this.b;
                    Object[] objArr3 = new Object[1];
                    dVar.a("", str2, c.this.e, c.this.f);
                    aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(th);
                    }
                }
            }
        };
        if (dVar.c() == 6) {
            com.anythink.core.common.v.b.b.a().a(dVar2, 2);
        } else {
            com.anythink.core.common.v.b.b.a().a(dVar2, 3);
        }
    }

    protected final int a(InputStream inputStream) throws SocketException {
        if (inputStream.read(this.h, 0, 1) == -1) {
            throw new SocketException("Socket.InputStream read length = -1!");
        }
        byte[] bArr = this.h;
        byte b = bArr[0];
        bArr[0] = 0;
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(d dVar) {
        Socket socket = this.a;
        if (!((socket == null || !socket.isConnected() || this.a.isClosed()) ? false : true)) {
            synchronized (this) {
                if (this.a == null) {
                    Socket socket2 = new Socket();
                    this.a = socket2;
                    socket2.setSoTimeout(60000);
                }
                h hVarE_ = dVar.e_();
                if (hVarE_ != null) {
                    this.e = hVarE_.a();
                    int iB = hVarE_.b();
                    this.f = iB;
                    Object[] objArr = new Object[2];
                    Integer.valueOf(iB);
                    this.a.connect(new InetSocketAddress(this.e, this.f), 30000);
                } else {
                    throw new IllegalArgumentException("The domain must not can be null or empty.");
                }
            }
        }
        byte[] bArrE = dVar.e();
        if (bArrE != null) {
            int length = bArrE.length;
            if (bArrE.length == 0) {
                return;
            }
            int i = length + 7;
            byte[] bArr = this.g;
            if (bArr == null || bArr.length < i) {
                this.g = new byte[i];
            }
            byte[] bArr2 = this.g;
            bArr2[0] = 0;
            bArr2[1] = 3;
            bArr2[2] = (byte) dVar.c();
            byte[] bArr3 = this.g;
            bArr3[3] = (byte) ((length >>> 24) & 255);
            bArr3[4] = (byte) ((length >>> 16) & 255);
            bArr3[5] = (byte) ((length >>> 8) & 255);
            bArr3[6] = (byte) ((length >>> 0) & 255);
            System.arraycopy(bArrE, 0, bArr3, 7, bArrE.length);
            OutputStream outputStream = this.a.getOutputStream();
            outputStream.write(this.g, 0, i);
            outputStream.flush();
        }
    }

    static /* synthetic */ void b(c cVar) {
        synchronized (cVar) {
            try {
                Socket socket = cVar.a;
                if (socket != null) {
                    socket.close();
                    cVar.a = null;
                }
            } catch (Exception unused) {
            }
        }
    }
}
