package com.bytedance.sdk.component.ah.ms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class sl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final Logger f1014ms = Logger.getLogger(sl.class.getName());

    private sl() {
    }

    public static ka ms(y yVar) {
        return new u(yVar);
    }

    public static d ms(qv qvVar) {
        return new zb(qvVar);
    }

    public static qv ms(OutputStream outputStream) {
        return ms(outputStream, new t());
    }

    private static qv ms(final OutputStream outputStream, final t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new qv() { // from class: com.bytedance.sdk.component.ah.ms.sl.1
            @Override // com.bytedance.sdk.component.ah.ms.qv
            public void a_(ah ahVar, long j) throws IOException {
                try {
                    nw.ms(ahVar.xr, 0L, j);
                    while (j > 0) {
                        tVar.ab();
                        ub ubVar = ahVar.f1003ms;
                        int iMin = (int) Math.min(j, ubVar.ah - ubVar.xr);
                        outputStream.write(ubVar.f1020ms, ubVar.xr, iMin);
                        ubVar.xr += iMin;
                        long j2 = iMin;
                        j -= j2;
                        ahVar.xr -= j2;
                        if (ubVar.xr == ubVar.ah) {
                            ahVar.f1003ms = ubVar.xr();
                            ao.ms(ubVar);
                        }
                    }
                } catch (IOException | Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // com.bytedance.sdk.component.ah.ms.qv
            public t ms() {
                return tVar;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static qv ms(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        ms msVarAh = ah(socket);
        return msVarAh.ms(ms(socket.getOutputStream(), msVarAh));
    }

    public static y ms(InputStream inputStream) {
        return ms(inputStream, new t());
    }

    private static y ms(final InputStream inputStream, final t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new y() { // from class: com.bytedance.sdk.component.ah.ms.sl.2
            @Override // com.bytedance.sdk.component.ah.ms.y
            public long ms(ah ahVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    tVar.ab();
                    ub ubVarKa = ahVar.ka(1);
                    int i = inputStream.read(ubVarKa.f1020ms, ubVarKa.ah, (int) Math.min(j, 8192 - ubVarKa.ah));
                    if (i == -1) {
                        return -1L;
                    }
                    ubVarKa.ah += i;
                    long j2 = i;
                    ahVar.xr += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (sl.ms(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    throw new IOException(th.getMessage());
                }
            }

            @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // com.bytedance.sdk.component.ah.ms.y
            public t ms() {
                return tVar;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static y ms(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return ms(new FileInputStream(file));
    }

    public static qv xr(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return ms(new FileOutputStream(file));
    }

    public static qv ah(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return ms(new FileOutputStream(file, true));
    }

    public static qv ms() {
        return new qv() { // from class: com.bytedance.sdk.component.ah.ms.sl.3
            @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // com.bytedance.sdk.component.ah.ms.qv
            public void a_(ah ahVar, long j) throws IOException {
                ahVar.x(j);
            }

            @Override // com.bytedance.sdk.component.ah.ms.qv
            public t ms() {
                return t.ah;
            }
        };
    }

    public static y xr(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        ms msVarAh = ah(socket);
        return msVarAh.ms(ms(socket.getInputStream(), msVarAh));
    }

    private static ms ah(final Socket socket) {
        return new ms() { // from class: com.bytedance.sdk.component.ah.ms.sl.4
            @Override // com.bytedance.sdk.component.ah.ms.ms
            protected IOException xr(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.bytedance.sdk.component.ah.ms.ms
            protected void e_() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (sl.ms(e)) {
                        sl.f1014ms.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    sl.f1014ms.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    static boolean ms(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
