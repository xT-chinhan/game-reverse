package com.byazt.bo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 508, 13})
public class hw implements com.byazt.ld.x {
    public pr hw;
    public long pr;

    public hw(File file, long j, ExecutorService executorService) {
        this.pr = j;
        try {
            this.hw = pr.pr(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.ld.x
    public InputStream pr(String str) {
        pr prVar = this.hw;
        if (prVar == null) {
            return null;
        }
        try {
            pr.hn hnVarPr = prVar.pr(str);
            if (hnVarPr != null) {
                return hnVarPr.pr(0);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }

    @Override // com.byazt.ld.pr
    public boolean pr(String str, byte[] bArr) throws Throwable {
        OutputStream outputStream;
        pr prVar = this.hw;
        if (prVar == null || bArr == null || str == null) {
            return false;
        }
        OutputStream outputStreamPr = null;
        outputStreamPr = null;
        pr.C0025pr c0025pr = null;
        try {
            try {
                pr.C0025pr c0025prHw = prVar.hw(str);
                if (c0025prHw == null) {
                    com.byazt.cb.hw.pr(null);
                    return false;
                }
                try {
                    outputStreamPr = c0025prHw.pr(0);
                    if (outputStreamPr == pr.hn) {
                        com.byazt.cb.hw.pr(outputStreamPr);
                        return false;
                    }
                    outputStreamPr.write(bArr);
                    c0025prHw.pr();
                    this.hw.pr();
                    com.byazt.cb.hw.pr(outputStreamPr);
                    return true;
                } catch (IOException e) {
                    OutputStream outputStream2 = outputStreamPr;
                    c0025pr = c0025prHw;
                    outputStream = outputStream2;
                    if (c0025pr != null) {
                        try {
                            c0025pr.hw();
                        } catch (IOException e2) {
                        } catch (Throwable th) {
                            outputStreamPr = outputStream;
                            th = th;
                            com.byazt.cb.hw.pr(outputStreamPr);
                            throw th;
                        }
                    }
                    com.byazt.cb.hw.pr(outputStream);
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                com.byazt.cb.hw.pr(outputStreamPr);
                throw th;
            }
        } catch (IOException e3) {
            outputStream = null;
        }
    }

    @Override // com.byazt.ld.pr
    /* JADX INFO: renamed from: hw, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] pr(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamPr;
        pr prVar = this.hw;
        InputStream inputStream = null;
        if (prVar == null || str == null) {
            return null;
        }
        try {
            pr.hn hnVarPr = prVar.pr(str);
            if (hnVarPr == null) {
                com.byazt.cb.hw.pr(null);
                com.byazt.cb.hw.pr(null);
                return null;
            }
            inputStreamPr = hnVarPr.pr(0);
            if (inputStreamPr != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamPr.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } catch (IOException e) {
                    } catch (OutOfMemoryError e2) {
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamPr;
                        com.byazt.cb.hw.pr(inputStream);
                        com.byazt.cb.hw.pr(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    byteArrayOutputStream = null;
                } catch (OutOfMemoryError e4) {
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    inputStream = inputStreamPr;
                    com.byazt.cb.hw.pr(inputStream);
                    com.byazt.cb.hw.pr(byteArrayOutputStream);
                    throw th;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.byazt.cb.hw.pr(inputStreamPr);
            com.byazt.cb.hw.pr(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e5) {
            inputStreamPr = null;
            byteArrayOutputStream = null;
        } catch (OutOfMemoryError e6) {
            inputStreamPr = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        com.byazt.cb.hw.pr(inputStreamPr);
        com.byazt.cb.hw.pr(byteArrayOutputStream);
        return null;
    }

    @Override // com.byazt.ld.pr
    public void pr() {
        try {
            this.hw.delete();
        } catch (IOException e) {
        }
    }

    @Override // com.byazt.ld.pr
    /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
    public boolean hw(String str) {
        try {
            try {
                pr.hn hnVarPr = this.hw.pr(str);
                boolean z = hnVarPr != null;
                com.byazt.cb.hw.pr(hnVarPr);
                return z;
            } catch (IOException e) {
                e.getMessage();
                com.byazt.cb.hw.pr(null);
                return false;
            }
        } catch (Throwable th) {
            com.byazt.cb.hw.pr(null);
            throw th;
        }
    }

    @Override // com.byazt.ld.pr
    public void pr(double d) {
        this.hw.pr((long) (this.pr * d));
    }
}
