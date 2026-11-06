package com.byazt.du;

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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 250})
public final class k {
    public static final Logger pr = Logger.getLogger(k.class.getName());

    private k() {
    }

    public static c pr(qa qaVar) {
        return new g(qaVar);
    }

    public static x pr(lb lbVar) {
        return new m(lbVar);
    }

    public static lb pr(OutputStream outputStream) {
        return pr(outputStream, new a());
    }

    private static lb pr(final OutputStream outputStream, final a aVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new lb() { // from class: com.byazt.du.k.1
            @Override // com.byazt.du.lb
            public void a_(hn hnVar, long j) throws IOException {
                try {
                    cz.pr(hnVar.hw, 0L, j);
                    while (j > 0) {
                        aVar.fw();
                        ho hoVar = hnVar.pr;
                        int iMin = (int) Math.min(j, hoVar.hn - hoVar.hw);
                        outputStream.write(hoVar.pr, hoVar.hw, iMin);
                        hoVar.hw += iMin;
                        long j2 = iMin;
                        j -= j2;
                        hnVar.hw -= j2;
                        if (hoVar.hw == hoVar.hn) {
                            hnVar.pr = hoVar.hw();
                            nt.pr(hoVar);
                        }
                    }
                } catch (IOException e) {
                } catch (Exception e2) {
                }
            }

            @Override // com.byazt.du.lb, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // com.byazt.du.lb, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // com.byazt.du.lb
            public a pr() {
                return aVar;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static lb pr(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        pr prVarHn = hn(socket);
        return prVarHn.pr(pr(socket.getOutputStream(), prVarHn));
    }

    public static qa pr(InputStream inputStream) {
        return pr(inputStream, new a());
    }

    private static qa pr(final InputStream inputStream, final a aVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new qa() { // from class: com.byazt.du.k.2
            @Override // com.byazt.du.qa
            public long pr(hn hnVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    aVar.fw();
                    ho hoVarC = hnVar.c(1);
                    int i = inputStream.read(hoVarC.pr, hoVarC.hn, (int) Math.min(j, 8192 - hoVarC.hn));
                    if (i == -1) {
                        return -1L;
                    }
                    hoVarC.hn += i;
                    long j2 = i;
                    hnVar.hw += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (k.pr(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    throw new IOException(th.getMessage());
                }
            }

            @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // com.byazt.du.qa
            public a pr() {
                return aVar;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static qa pr(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return pr(new FileInputStream(file));
    }

    public static lb hw(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return pr(new FileOutputStream(file));
    }

    public static lb hn(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return pr(new FileOutputStream(file, true));
    }

    public static lb pr() {
        return new lb() { // from class: com.byazt.du.k.3
            @Override // com.byazt.du.lb
            public void a_(hn hnVar, long j) throws IOException {
                hnVar.zo(j);
            }

            @Override // com.byazt.du.lb, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // com.byazt.du.lb
            public a pr() {
                return a.hn;
            }

            @Override // com.byazt.du.lb, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }
        };
    }

    public static qa hw(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        pr prVarHn = hn(socket);
        return prVarHn.pr(pr(socket.getInputStream(), prVarHn));
    }

    private static pr hn(final Socket socket) {
        return new pr() { // from class: com.byazt.du.k.4
            @Override // com.byazt.du.pr
            public IOException hw(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.byazt.du.pr
            public void e_() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (k.pr(e)) {
                        k.pr.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    k.pr.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    public static boolean pr(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
