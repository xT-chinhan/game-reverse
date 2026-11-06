package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 113})
public final class d {
    public static final Logger n = Logger.getLogger(d.class.getName());

    private d() {
    }

    public static l n(um umVar) {
        return new sz(umVar);
    }

    public static q n(cd cdVar) {
        return new oa(cdVar);
    }

    public static cd n(OutputStream outputStream) {
        return n(outputStream, new a());
    }

    private static cd n(final OutputStream outputStream, final a aVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new cd() { // from class: com.byazt.wa.d.1
            @Override // com.byazt.wa.cd
            public void a_(s sVar, long j) throws IOException {
                try {
                    py.n(sVar.qg, 0L, j);
                    while (j > 0) {
                        aVar.x();
                        k kVar = sVar.n;
                        int iMin = (int) Math.min(j, kVar.s - kVar.qg);
                        outputStream.write(kVar.n, kVar.qg, iMin);
                        kVar.qg += iMin;
                        long j2 = iMin;
                        j -= j2;
                        sVar.qg -= j2;
                        if (kVar.qg == kVar.s) {
                            sVar.n = kVar.qg();
                            cy.n(kVar);
                        }
                    }
                } catch (IOException | Exception unused) {
                }
            }

            @Override // com.byazt.wa.cd, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // com.byazt.wa.cd, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // com.byazt.wa.cd
            public a n() {
                return aVar;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static cd n(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        n nVarS = s(socket);
        return nVarS.n(n(socket.getOutputStream(), nVarS));
    }

    public static um n(InputStream inputStream) {
        return n(inputStream, new a());
    }

    private static um n(final InputStream inputStream, final a aVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new um() { // from class: com.byazt.wa.d.2
            @Override // com.byazt.wa.um
            public long n(s sVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    aVar.x();
                    k kVarL = sVar.l(1);
                    int i = inputStream.read(kVarL.n, kVarL.s, (int) Math.min(j, 8192 - kVarL.s));
                    if (i == -1) {
                        return -1L;
                    }
                    kVarL.s += i;
                    long j2 = i;
                    sVar.qg += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (d.n(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    throw new IOException(th.getMessage());
                }
            }

            @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // com.byazt.wa.um
            public a n() {
                return aVar;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static um n(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return n(new FileInputStream(file));
    }

    public static cd qg(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return n(new FileOutputStream(file));
    }

    public static cd s(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return n(new FileOutputStream(file, true));
    }

    public static cd n() {
        return new cd() { // from class: com.byazt.wa.d.3
            @Override // com.byazt.wa.cd, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.byazt.wa.cd, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // com.byazt.wa.cd
            public void a_(s sVar, long j) throws IOException {
                sVar.fs(j);
            }

            @Override // com.byazt.wa.cd
            public a n() {
                return a.s;
            }
        };
    }

    public static um qg(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        n nVarS = s(socket);
        return nVarS.n(n(socket.getInputStream(), nVarS));
    }

    private static n s(final Socket socket) {
        return new n() { // from class: com.byazt.wa.d.4
            @Override // com.byazt.wa.n
            public IOException qg(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.byazt.wa.n
            public void m_() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (d.n(e)) {
                        d.n.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    d.n.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    public static boolean n(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
