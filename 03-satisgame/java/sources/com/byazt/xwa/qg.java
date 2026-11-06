package com.byazt.xwa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 26})
public class qg implements com.byazt.db.n {
    public long n;
    public n qg;

    public qg(File file, long j, ExecutorService executorService) {
        this.n = j;
        try {
            this.qg = n.n(file, 20210302, 1, j, executorService);
        } catch (IOException unused) {
        }
    }

    @Override // com.byazt.db.n
    public boolean s(String str) {
        n nVar = this.qg;
        if (nVar == null) {
            return false;
        }
        try {
            return nVar.s(str);
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
    }

    @Override // com.byazt.db.n
    public InputStream qg(String str) {
        n nVar = this.qg;
        if (nVar == null) {
            return null;
        }
        try {
            n.s sVarN = nVar.n(str);
            if (sVarN != null) {
                return sVarN.n(0);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }

    @Override // com.byazt.db.n
    public boolean n(String str, byte[] bArr) throws Throwable {
        OutputStream outputStream;
        n nVar = this.qg;
        if (nVar != null && bArr != null && str != null) {
            OutputStream outputStreamN = null;
            outputStreamN = null;
            n.C0398n c0398n = null;
            try {
                try {
                    n.C0398n c0398nQg = nVar.qg(str);
                    if (c0398nQg == null) {
                        com.byazt.pn.n.n(null);
                        return false;
                    }
                    try {
                        outputStreamN = c0398nQg.n(0);
                        if (outputStreamN == n.s) {
                            com.byazt.pn.n.n(outputStreamN);
                            return false;
                        }
                        outputStreamN.write(bArr);
                        c0398nQg.n();
                        this.qg.s();
                        com.byazt.pn.n.n(outputStreamN);
                        return true;
                    } catch (IOException unused) {
                        OutputStream outputStream2 = outputStreamN;
                        c0398n = c0398nQg;
                        outputStream = outputStream2;
                        if (c0398n != null) {
                            try {
                                c0398n.qg();
                            } catch (IOException unused2) {
                            } catch (Throwable th) {
                                outputStreamN = outputStream;
                                th = th;
                                com.byazt.pn.n.n(outputStreamN);
                                throw th;
                            }
                        }
                        com.byazt.pn.n.n(outputStream);
                        return false;
                    }
                } catch (IOException unused3) {
                    outputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                com.byazt.pn.n.n(outputStreamN);
                throw th;
            }
        }
        return false;
    }

    @Override // com.byazt.db.n
    public byte[] n(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamN;
        n nVar = this.qg;
        InputStream inputStream = null;
        if (nVar != null && str != null) {
            try {
                try {
                    n.s sVarN = nVar.n(str);
                    if (sVarN == null) {
                        com.byazt.pn.n.n(null);
                        com.byazt.pn.n.n(null);
                        return null;
                    }
                    inputStreamN = sVarN.n(0);
                    if (inputStreamN != null) {
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = inputStreamN.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, i);
                                }
                            } catch (IOException | OutOfMemoryError unused) {
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStreamN;
                                com.byazt.pn.n.n(inputStream);
                                com.byazt.pn.n.n(byteArrayOutputStream);
                                throw th;
                            }
                        } catch (IOException | OutOfMemoryError unused2) {
                            byteArrayOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = null;
                            inputStream = inputStreamN;
                            com.byazt.pn.n.n(inputStream);
                            com.byazt.pn.n.n(byteArrayOutputStream);
                            throw th;
                        }
                    } else {
                        byteArrayOutputStream = null;
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    com.byazt.pn.n.n(inputStreamN);
                    com.byazt.pn.n.n(byteArrayOutputStream);
                    return byteArray;
                } catch (IOException | OutOfMemoryError unused3) {
                    inputStreamN = null;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
            com.byazt.pn.n.n(inputStreamN);
            com.byazt.pn.n.n(byteArrayOutputStream);
        }
        return null;
    }

    @Override // com.byazt.db.n
    public void n() {
        n nVar = this.qg;
        if (nVar == null) {
            return;
        }
        try {
            nVar.delete();
        } catch (IOException unused) {
        }
    }

    @Override // com.byazt.db.n
    public boolean q(String str) {
        n nVar = this.qg;
        if (nVar == null) {
            return false;
        }
        try {
            try {
                n.s sVarN = nVar.n(str);
                boolean z = sVarN != null;
                com.byazt.pn.n.n(sVarN);
                return z;
            } catch (IOException e) {
                e.getMessage();
                com.byazt.pn.n.n(null);
                return false;
            }
        } catch (Throwable th) {
            com.byazt.pn.n.n(null);
            throw th;
        }
    }

    @Override // com.byazt.db.n
    public int qg() {
        n nVar = this.qg;
        if (nVar != null) {
            return nVar.qg();
        }
        return 0;
    }

    @Override // com.byazt.db.n
    public long s() {
        n nVar = this.qg;
        if (nVar == null) {
            return 0L;
        }
        return nVar.n();
    }

    @Override // com.byazt.db.n
    public void n(double d) {
        n nVar = this.qg;
        if (nVar == null) {
            return;
        }
        nVar.n((long) (this.n * d));
    }
}
