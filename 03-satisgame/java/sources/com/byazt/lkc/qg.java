package com.byazt.lkc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 955, 26})
public class qg implements com.byazt.si.q {
    public long n;
    public n qg;

    public qg(File file, long j, ExecutorService executorService) {
        this.n = j;
        try {
            this.qg = n.n(file, 20210302, 1, j, executorService);
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.si.q
    public InputStream n(String str) {
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

    @Override // com.byazt.si.n
    public boolean n(String str, byte[] bArr) throws Throwable {
        OutputStream outputStream;
        n nVar = this.qg;
        if (nVar != null && bArr != null && str != null) {
            OutputStream outputStreamN = null;
            outputStreamN = null;
            n.C0237n c0237n = null;
            try {
                try {
                    n.C0237n c0237nQg = nVar.qg(str);
                    if (c0237nQg == null) {
                        com.byazt.wvr.qg.n(null);
                        return false;
                    }
                    try {
                        outputStreamN = c0237nQg.n(0);
                        if (outputStreamN == n.s) {
                            com.byazt.wvr.qg.n(outputStreamN);
                            return false;
                        }
                        outputStreamN.write(bArr);
                        c0237nQg.n();
                        this.qg.n();
                        com.byazt.wvr.qg.n(outputStreamN);
                        return true;
                    } catch (IOException unused) {
                        OutputStream outputStream2 = outputStreamN;
                        c0237n = c0237nQg;
                        outputStream = outputStream2;
                        if (c0237n != null) {
                            try {
                                c0237n.qg();
                            } catch (IOException unused2) {
                            } catch (Throwable th) {
                                outputStreamN = outputStream;
                                th = th;
                                com.byazt.wvr.qg.n(outputStreamN);
                                throw th;
                            }
                        }
                        com.byazt.wvr.qg.n(outputStream);
                        return false;
                    }
                } catch (IOException unused3) {
                    outputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                com.byazt.wvr.qg.n(outputStreamN);
                throw th;
            }
        }
        return false;
    }

    @Override // com.byazt.si.n
    /* JADX INFO: renamed from: qg, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
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
                        com.byazt.wvr.qg.n(null);
                        com.byazt.wvr.qg.n(null);
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
                                com.byazt.wvr.qg.n(inputStream);
                                com.byazt.wvr.qg.n(byteArrayOutputStream);
                                throw th;
                            }
                        } catch (IOException | OutOfMemoryError unused2) {
                            byteArrayOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = null;
                            inputStream = inputStreamN;
                            com.byazt.wvr.qg.n(inputStream);
                            com.byazt.wvr.qg.n(byteArrayOutputStream);
                            throw th;
                        }
                    } else {
                        byteArrayOutputStream = null;
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    com.byazt.wvr.qg.n(inputStreamN);
                    com.byazt.wvr.qg.n(byteArrayOutputStream);
                    return byteArray;
                } catch (IOException | OutOfMemoryError unused3) {
                    inputStreamN = null;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
            com.byazt.wvr.qg.n(inputStreamN);
            com.byazt.wvr.qg.n(byteArrayOutputStream);
        }
        return null;
    }

    @Override // com.byazt.si.n
    public void n() {
        try {
            this.qg.delete();
        } catch (IOException unused) {
        }
    }

    @Override // com.byazt.si.n
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean qg(String str) {
        try {
            try {
                n.s sVarN = this.qg.n(str);
                boolean z = sVarN != null;
                com.byazt.wvr.qg.n(sVarN);
                return z;
            } catch (IOException e) {
                e.getMessage();
                com.byazt.wvr.qg.n(null);
                return false;
            }
        } catch (Throwable th) {
            com.byazt.wvr.qg.n(null);
            throw th;
        }
    }

    @Override // com.byazt.si.n
    public void n(double d) {
        this.qg.n((long) (this.n * d));
    }
}
