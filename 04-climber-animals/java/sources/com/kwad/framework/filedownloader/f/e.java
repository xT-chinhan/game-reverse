package com.kwad.framework.filedownloader.f;

import com.tencent.bugly.Bugly;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    public final int apE;
    public final long apF;
    public final boolean apG;
    public final boolean apH;
    public final int apI;
    public final boolean apJ;
    public final boolean apK;

    /* synthetic */ e(byte b) {
        this();
    }

    public static class a {
        private static final e apL = new e(0);
    }

    public static e zB() {
        return a.apL;
    }

    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x007d A[Catch: all -> 0x01cd, TryCatch #8 {all -> 0x01cd, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:37:0x0079, B:39:0x007d, B:41:0x0081, B:42:0x0089), top: B:95:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0081 A[Catch: all -> 0x01cd, TryCatch #8 {all -> 0x01cd, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:37:0x0079, B:39:0x007d, B:41:0x0081, B:42:0x0089), top: B:95:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0089 A[Catch: all -> 0x01cd, TRY_LEAVE, TryCatch #8 {all -> 0x01cd, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:37:0x0079, B:39:0x007d, B:41:0x0081, B:42:0x0089), top: B:95:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x009f  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:63:0x0107  */
    /* JADX WARN: Code duplicated, block: B:64:0x0117  */
    /* JADX WARN: Code duplicated, block: B:66:0x011c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0122  */
    /* JADX WARN: Code duplicated, block: B:74:0x0145  */
    /* JADX WARN: Code duplicated, block: B:76:0x014a  */
    /* JADX WARN: Code duplicated, block: B:78:0x0150  */
    /* JADX WARN: Code duplicated, block: B:84:0x0172  */
    /* JADX WARN: Code duplicated, block: B:87:0x0178  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean] */
    private e() throws Throwable {
        InputStream inputStream;
        InputStream inputStreamOpen;
        String property;
        String property2;
        String property3;
        String property4;
        String property5;
        String str;
        String str2;
        String property6;
        int i;
        int i2;
        ?? r4;
        if (c.zz() == null) {
            throw new IllegalStateException("Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Properties properties = new Properties();
        try {
            inputStreamOpen = c.zz().getAssets().open("filedownloader.properties");
            if (inputStreamOpen != null) {
                try {
                    try {
                        properties.load(inputStreamOpen);
                        property = properties.getProperty("http.lenient");
                        try {
                            property2 = properties.getProperty("download.min-progress-step");
                            try {
                                property3 = properties.getProperty("download.min-progress-time");
                                try {
                                    property4 = properties.getProperty("download.max-network-thread-count");
                                    try {
                                        property5 = properties.getProperty("file.non-pre-allocation");
                                        try {
                                            property6 = properties.getProperty("broadcast.completed");
                                            str = property;
                                        } catch (IOException e) {
                                            e = e;
                                            if (e instanceof FileNotFoundException) {
                                                if (d.apD) {
                                                    d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                                }
                                            } else {
                                                e.printStackTrace();
                                            }
                                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                                            str = property;
                                            str2 = property5;
                                            property6 = null;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        property5 = null;
                                        if (e instanceof FileNotFoundException) {
                                            if (d.apD) {
                                                d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                            }
                                        } else {
                                            e.printStackTrace();
                                        }
                                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                                        str = property;
                                        str2 = property5;
                                        property6 = null;
                                        if (str != null) {
                                            if (str.equals("true")) {
                                            }
                                            i = 0;
                                            this.apG = str.equals("true");
                                        } else {
                                            i = 0;
                                            this.apG = false;
                                        }
                                        this.apH = true;
                                        if (property2 != null) {
                                            this.apE = Math.max(i, Integer.valueOf(property2).intValue());
                                        } else {
                                            this.apE = 65536;
                                        }
                                        if (property3 != null) {
                                            this.apF = Math.max(0L, Long.valueOf(property3).longValue());
                                        } else {
                                            this.apF = com.anythink.basead.exoplayer.i.a.f;
                                        }
                                        if (property4 != null) {
                                            this.apI = ce(Integer.valueOf(property4).intValue());
                                            i2 = 3;
                                        } else {
                                            i2 = 3;
                                            this.apI = 3;
                                        }
                                        if (str2 != null) {
                                            if (str2.equals("true")) {
                                            }
                                            r4 = 0;
                                            this.apJ = str2.equals("true");
                                        } else {
                                            r4 = 0;
                                            this.apJ = false;
                                        }
                                        if (property6 != null) {
                                            if (property6.equals("true")) {
                                            }
                                            this.apK = property6.equals("true");
                                        } else {
                                            this.apK = r4;
                                        }
                                        if (d.apD) {
                                            Object[] objArr = new Object[11];
                                            objArr[r4] = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                                            objArr[1] = "http.lenient";
                                            objArr[2] = Boolean.valueOf(this.apG);
                                            objArr[3] = "process.non-separate";
                                            objArr[4] = true;
                                            objArr[5] = "download.min-progress-step";
                                            objArr[6] = Integer.valueOf(this.apE);
                                            objArr[7] = "download.min-progress-time";
                                            objArr[8] = Long.valueOf(this.apF);
                                            objArr[9] = "download.max-network-thread-count";
                                            objArr[10] = Integer.valueOf(this.apI);
                                            d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr);
                                        }
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    property4 = null;
                                    property5 = null;
                                    if (e instanceof FileNotFoundException) {
                                        if (d.apD) {
                                            d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                        }
                                    } else {
                                        e.printStackTrace();
                                    }
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                                    str = property;
                                    str2 = property5;
                                    property6 = null;
                                    if (str != null) {
                                        if (str.equals("true")) {
                                        }
                                        i = 0;
                                        this.apG = str.equals("true");
                                    } else {
                                        i = 0;
                                        this.apG = false;
                                    }
                                    this.apH = true;
                                    if (property2 != null) {
                                        this.apE = Math.max(i, Integer.valueOf(property2).intValue());
                                    } else {
                                        this.apE = 65536;
                                    }
                                    if (property3 != null) {
                                        this.apF = Math.max(0L, Long.valueOf(property3).longValue());
                                    } else {
                                        this.apF = com.anythink.basead.exoplayer.i.a.f;
                                    }
                                    if (property4 != null) {
                                        this.apI = ce(Integer.valueOf(property4).intValue());
                                        i2 = 3;
                                    } else {
                                        i2 = 3;
                                        this.apI = 3;
                                    }
                                    if (str2 != null) {
                                        if (str2.equals("true")) {
                                        }
                                        r4 = 0;
                                        this.apJ = str2.equals("true");
                                    } else {
                                        r4 = 0;
                                        this.apJ = false;
                                    }
                                    if (property6 != null) {
                                        if (property6.equals("true")) {
                                        }
                                        this.apK = property6.equals("true");
                                    } else {
                                        this.apK = r4;
                                    }
                                    if (d.apD) {
                                        Object[] objArr2 = new Object[11];
                                        objArr2[r4] = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                                        objArr2[1] = "http.lenient";
                                        objArr2[2] = Boolean.valueOf(this.apG);
                                        objArr2[3] = "process.non-separate";
                                        objArr2[4] = true;
                                        objArr2[5] = "download.min-progress-step";
                                        objArr2[6] = Integer.valueOf(this.apE);
                                        objArr2[7] = "download.min-progress-time";
                                        objArr2[8] = Long.valueOf(this.apF);
                                        objArr2[9] = "download.max-network-thread-count";
                                        objArr2[10] = Integer.valueOf(this.apI);
                                        d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr2);
                                    }
                                }
                            } catch (IOException e4) {
                                e = e4;
                                property3 = null;
                                property4 = null;
                                property5 = null;
                                if (e instanceof FileNotFoundException) {
                                    if (d.apD) {
                                        d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                    }
                                } else {
                                    e.printStackTrace();
                                }
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                                str = property;
                                str2 = property5;
                                property6 = null;
                                if (str != null) {
                                    if (str.equals("true")) {
                                    }
                                    i = 0;
                                    this.apG = str.equals("true");
                                } else {
                                    i = 0;
                                    this.apG = false;
                                }
                                this.apH = true;
                                if (property2 != null) {
                                    this.apE = Math.max(i, Integer.valueOf(property2).intValue());
                                } else {
                                    this.apE = 65536;
                                }
                                if (property3 != null) {
                                    this.apF = Math.max(0L, Long.valueOf(property3).longValue());
                                } else {
                                    this.apF = com.anythink.basead.exoplayer.i.a.f;
                                }
                                if (property4 != null) {
                                    this.apI = ce(Integer.valueOf(property4).intValue());
                                    i2 = 3;
                                } else {
                                    i2 = 3;
                                    this.apI = 3;
                                }
                                if (str2 != null) {
                                    if (str2.equals("true")) {
                                    }
                                    r4 = 0;
                                    this.apJ = str2.equals("true");
                                } else {
                                    r4 = 0;
                                    this.apJ = false;
                                }
                                if (property6 != null) {
                                    if (property6.equals("true")) {
                                    }
                                    this.apK = property6.equals("true");
                                } else {
                                    this.apK = r4;
                                }
                                if (d.apD) {
                                    Object[] objArr3 = new Object[11];
                                    objArr3[r4] = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                                    objArr3[1] = "http.lenient";
                                    objArr3[2] = Boolean.valueOf(this.apG);
                                    objArr3[3] = "process.non-separate";
                                    objArr3[4] = true;
                                    objArr3[5] = "download.min-progress-step";
                                    objArr3[6] = Integer.valueOf(this.apE);
                                    objArr3[7] = "download.min-progress-time";
                                    objArr3[8] = Long.valueOf(this.apF);
                                    objArr3[9] = "download.max-network-thread-count";
                                    objArr3[10] = Integer.valueOf(this.apI);
                                    d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr3);
                                }
                            }
                        } catch (IOException e5) {
                            e = e5;
                            property2 = null;
                            property3 = null;
                            property4 = null;
                            property5 = null;
                            if (e instanceof FileNotFoundException) {
                                if (d.apD) {
                                    d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                }
                            } else {
                                e.printStackTrace();
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                            str = property;
                            str2 = property5;
                            property6 = null;
                            if (str != null) {
                                if (str.equals("true")) {
                                }
                                i = 0;
                                this.apG = str.equals("true");
                            } else {
                                i = 0;
                                this.apG = false;
                            }
                            this.apH = true;
                            if (property2 != null) {
                                this.apE = Math.max(i, Integer.valueOf(property2).intValue());
                            } else {
                                this.apE = 65536;
                            }
                            if (property3 != null) {
                                this.apF = Math.max(0L, Long.valueOf(property3).longValue());
                            } else {
                                this.apF = com.anythink.basead.exoplayer.i.a.f;
                            }
                            if (property4 != null) {
                                this.apI = ce(Integer.valueOf(property4).intValue());
                                i2 = 3;
                            } else {
                                i2 = 3;
                                this.apI = 3;
                            }
                            if (str2 != null) {
                                if (str2.equals("true")) {
                                }
                                r4 = 0;
                                this.apJ = str2.equals("true");
                            } else {
                                r4 = 0;
                                this.apJ = false;
                            }
                            if (property6 != null) {
                                if (property6.equals("true")) {
                                }
                                this.apK = property6.equals("true");
                            } else {
                                this.apK = r4;
                            }
                            if (d.apD) {
                                Object[] objArr4 = new Object[11];
                                objArr4[r4] = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                                objArr4[1] = "http.lenient";
                                objArr4[2] = Boolean.valueOf(this.apG);
                                objArr4[3] = "process.non-separate";
                                objArr4[4] = true;
                                objArr4[5] = "download.min-progress-step";
                                objArr4[6] = Integer.valueOf(this.apE);
                                objArr4[7] = "download.min-progress-time";
                                objArr4[8] = Long.valueOf(this.apF);
                                objArr4[9] = "download.max-network-thread-count";
                                objArr4[10] = Integer.valueOf(this.apI);
                                d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr4);
                            }
                        }
                    } catch (IOException e6) {
                        e = e6;
                        property = null;
                        property2 = null;
                        property3 = null;
                        property4 = null;
                        property5 = null;
                        if (e instanceof FileNotFoundException) {
                            if (d.apD) {
                                d.c(e.class, "not found filedownloader.properties", new Object[0]);
                            }
                        } else {
                            e.printStackTrace();
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                        str = property;
                        str2 = property5;
                        property6 = null;
                        if (str != null) {
                            if (str.equals("true")) {
                            }
                            i = 0;
                            this.apG = str.equals("true");
                        } else {
                            i = 0;
                            this.apG = false;
                        }
                        this.apH = true;
                        if (property2 != null) {
                            this.apE = Math.max(i, Integer.valueOf(property2).intValue());
                        } else {
                            this.apE = 65536;
                        }
                        if (property3 != null) {
                            this.apF = Math.max(0L, Long.valueOf(property3).longValue());
                        } else {
                            this.apF = com.anythink.basead.exoplayer.i.a.f;
                        }
                        if (property4 != null) {
                            this.apI = ce(Integer.valueOf(property4).intValue());
                            i2 = 3;
                        } else {
                            i2 = 3;
                            this.apI = 3;
                        }
                        if (str2 != null) {
                            if (str2.equals("true")) {
                            }
                            r4 = 0;
                            this.apJ = str2.equals("true");
                        } else {
                            r4 = 0;
                            this.apJ = false;
                        }
                        if (property6 != null) {
                            if (property6.equals("true")) {
                            }
                            this.apK = property6.equals("true");
                        } else {
                            this.apK = r4;
                        }
                        if (d.apD) {
                            Object[] objArr5 = new Object[11];
                            objArr5[r4] = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
                            objArr5[1] = "http.lenient";
                            objArr5[2] = Boolean.valueOf(this.apG);
                            objArr5[3] = "process.non-separate";
                            objArr5[4] = true;
                            objArr5[5] = "download.min-progress-step";
                            objArr5[6] = Integer.valueOf(this.apE);
                            objArr5[7] = "download.min-progress-time";
                            objArr5[8] = Long.valueOf(this.apF);
                            objArr5[9] = "download.max-network-thread-count";
                            objArr5[10] = Integer.valueOf(this.apI);
                            d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr5);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpen;
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    throw th;
                }
            } else {
                property6 = null;
                str = null;
                property2 = null;
                property3 = null;
                property4 = null;
                property5 = null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
            str2 = property5;
        } catch (IOException e7) {
            e = e7;
            inputStreamOpen = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        if (str != null) {
            if (str.equals("true") && !str.equals(Bugly.SDK_IS_DEV)) {
                throw new IllegalStateException(f.c("the value of '%s' must be '%s' or '%s'", "http.lenient", "true", Bugly.SDK_IS_DEV));
            }
            i = 0;
            this.apG = str.equals("true");
        } else {
            i = 0;
            this.apG = false;
        }
        this.apH = true;
        if (property2 != null) {
            this.apE = Math.max(i, Integer.valueOf(property2).intValue());
        } else {
            this.apE = 65536;
        }
        if (property3 != null) {
            this.apF = Math.max(0L, Long.valueOf(property3).longValue());
        } else {
            this.apF = com.anythink.basead.exoplayer.i.a.f;
        }
        if (property4 != null) {
            this.apI = ce(Integer.valueOf(property4).intValue());
            i2 = 3;
        } else {
            i2 = 3;
            this.apI = 3;
        }
        if (str2 != null) {
            if (str2.equals("true") && !str2.equals(Bugly.SDK_IS_DEV)) {
                Object[] objArr6 = new Object[i2];
                objArr6[0] = "file.non-pre-allocation";
                objArr6[1] = "true";
                objArr6[2] = Bugly.SDK_IS_DEV;
                throw new IllegalStateException(f.c("the value of '%s' must be '%s' or '%s'", objArr6));
            }
            r4 = 0;
            this.apJ = str2.equals("true");
        } else {
            r4 = 0;
            this.apJ = false;
        }
        if (property6 != null) {
            if (property6.equals("true") && !property6.equals(Bugly.SDK_IS_DEV)) {
                Object[] objArr7 = new Object[3];
                objArr7[r4] = "broadcast.completed";
                objArr7[1] = "true";
                objArr7[2] = Bugly.SDK_IS_DEV;
                throw new IllegalStateException(f.c("the value of '%s' must be '%s' or '%s'", objArr7));
            }
            this.apK = property6.equals("true");
        } else {
            this.apK = r4;
        }
        if (d.apD) {
            Object[] objArr8 = new Object[11];
            objArr8[r4] = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
            objArr8[1] = "http.lenient";
            objArr8[2] = Boolean.valueOf(this.apG);
            objArr8[3] = "process.non-separate";
            objArr8[4] = true;
            objArr8[5] = "download.min-progress-step";
            objArr8[6] = Integer.valueOf(this.apE);
            objArr8[7] = "download.min-progress-time";
            objArr8[8] = Long.valueOf(this.apF);
            objArr8[9] = "download.max-network-thread-count";
            objArr8[10] = Integer.valueOf(this.apI);
            d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr8);
        }
    }

    public static int ce(int i) {
        if (i > 12) {
            d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
            return 12;
        }
        if (i > 0) {
            return i;
        }
        d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
        return 1;
    }
}
