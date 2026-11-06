package com.anythink.core.common.u;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.m.q;
import com.anythink.core.common.v.af;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile d b;
    private Context h;
    private File i;
    private AtomicInteger j;
    private final String a = "Agent";
    private int c = 5;
    private int d = 10;
    private long e = 1800000;
    private String f = "";
    private String g = "";
    private boolean k = false;
    private String l = "";
    private q m = new q() { // from class: com.anythink.core.common.u.d.1
        @Override // com.anythink.core.common.m.q
        public final void onLoadStart(int i) {
        }

        @Override // com.anythink.core.common.m.q
        public final void onLoadFinish(int i, Object obj) {
            try {
                d.this.a(((Integer) obj).intValue());
                d.a(d.this);
                af.a(d.this.h, u.b.a, "LOG_SEND_TIME", System.currentTimeMillis());
            } catch (Throwable unused) {
                d.a(d.this);
            }
        }

        @Override // com.anythink.core.common.m.q
        public final void onLoadError(int i, String str, AdError adError) {
            d.a(d.this);
        }

        @Override // com.anythink.core.common.m.q
        public final void onLoadCanceled(int i) {
            d.a(d.this);
        }
    };
    private com.anythink.core.common.m.d.d.a n = new com.anythink.core.common.m.d.d.a() { // from class: com.anythink.core.common.u.d.2
        @Override // com.anythink.core.common.m.d.d.a
        public final void a(Object obj) {
            if (obj instanceof com.anythink.core.common.m.d.a) {
                d.this.a(((com.anythink.core.common.m.d.a) obj).b());
                d.a(d.this);
                af.a(d.this.h, u.b.a, "LOG_SEND_TIME", System.currentTimeMillis());
            }
        }

        @Override // com.anythink.core.common.m.d.d.a
        public final void a(Throwable th) {
            d.a(d.this);
        }
    };
    private Object o = new Object();

    static /* synthetic */ boolean a(d dVar) {
        dVar.k = false;
        return false;
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    private d() {
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00fa A[Catch: all -> 0x0142, Error -> 0x0144, OutOfMemoryError | StackOverflowError -> 0x014e, OutOfMemoryError | StackOverflowError -> 0x014e, Exception -> 0x0167, TryCatch #3 {OutOfMemoryError | StackOverflowError -> 0x014e, blocks: (B:10:0x001c, B:12:0x008a, B:14:0x009d, B:15:0x00a6, B:17:0x00ae, B:25:0x00df, B:25:0x00df, B:37:0x00f6, B:37:0x00f6, B:39:0x00fa, B:39:0x00fa, B:40:0x0101, B:40:0x0101, B:42:0x0113, B:42:0x0113, B:44:0x011a, B:44:0x011a, B:46:0x012a, B:46:0x012a, B:48:0x0131, B:48:0x0131, B:47:0x012f, B:47:0x012f, B:43:0x0118, B:43:0x0118, B:33:0x00ed, B:33:0x00ed, B:34:0x00f0, B:34:0x00f0, B:36:0x00f3, B:36:0x00f3), top: B:80:0x001c, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0113 A[Catch: all -> 0x0142, Error -> 0x0144, OutOfMemoryError | StackOverflowError -> 0x014e, OutOfMemoryError | StackOverflowError -> 0x014e, Exception -> 0x0167, TryCatch #3 {OutOfMemoryError | StackOverflowError -> 0x014e, blocks: (B:10:0x001c, B:12:0x008a, B:14:0x009d, B:15:0x00a6, B:17:0x00ae, B:25:0x00df, B:25:0x00df, B:37:0x00f6, B:37:0x00f6, B:39:0x00fa, B:39:0x00fa, B:40:0x0101, B:40:0x0101, B:42:0x0113, B:42:0x0113, B:44:0x011a, B:44:0x011a, B:46:0x012a, B:46:0x012a, B:48:0x0131, B:48:0x0131, B:47:0x012f, B:47:0x012f, B:43:0x0118, B:43:0x0118, B:33:0x00ed, B:33:0x00ed, B:34:0x00f0, B:34:0x00f0, B:36:0x00f3, B:36:0x00f3), top: B:80:0x001c, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0118 A[Catch: all -> 0x0142, Error -> 0x0144, OutOfMemoryError | StackOverflowError -> 0x014e, OutOfMemoryError | StackOverflowError -> 0x014e, Exception -> 0x0167, TryCatch #3 {OutOfMemoryError | StackOverflowError -> 0x014e, blocks: (B:10:0x001c, B:12:0x008a, B:14:0x009d, B:15:0x00a6, B:17:0x00ae, B:25:0x00df, B:25:0x00df, B:37:0x00f6, B:37:0x00f6, B:39:0x00fa, B:39:0x00fa, B:40:0x0101, B:40:0x0101, B:42:0x0113, B:42:0x0113, B:44:0x011a, B:44:0x011a, B:46:0x012a, B:46:0x012a, B:48:0x0131, B:48:0x0131, B:47:0x012f, B:47:0x012f, B:43:0x0118, B:43:0x0118, B:33:0x00ed, B:33:0x00ed, B:34:0x00f0, B:34:0x00f0, B:36:0x00f3, B:36:0x00f3), top: B:80:0x001c, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x012a A[Catch: all -> 0x0142, Error -> 0x0144, OutOfMemoryError | StackOverflowError -> 0x014e, OutOfMemoryError | StackOverflowError -> 0x014e, Exception -> 0x0167, TryCatch #3 {OutOfMemoryError | StackOverflowError -> 0x014e, blocks: (B:10:0x001c, B:12:0x008a, B:14:0x009d, B:15:0x00a6, B:17:0x00ae, B:25:0x00df, B:25:0x00df, B:37:0x00f6, B:37:0x00f6, B:39:0x00fa, B:39:0x00fa, B:40:0x0101, B:40:0x0101, B:42:0x0113, B:42:0x0113, B:44:0x011a, B:44:0x011a, B:46:0x012a, B:46:0x012a, B:48:0x0131, B:48:0x0131, B:47:0x012f, B:47:0x012f, B:43:0x0118, B:43:0x0118, B:33:0x00ed, B:33:0x00ed, B:34:0x00f0, B:34:0x00f0, B:36:0x00f3, B:36:0x00f3), top: B:80:0x001c, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x012f A[Catch: all -> 0x0142, Error -> 0x0144, OutOfMemoryError | StackOverflowError -> 0x014e, OutOfMemoryError | StackOverflowError -> 0x014e, Exception -> 0x0167, TryCatch #3 {OutOfMemoryError | StackOverflowError -> 0x014e, blocks: (B:10:0x001c, B:12:0x008a, B:14:0x009d, B:15:0x00a6, B:17:0x00ae, B:25:0x00df, B:25:0x00df, B:37:0x00f6, B:37:0x00f6, B:39:0x00fa, B:39:0x00fa, B:40:0x0101, B:40:0x0101, B:42:0x0113, B:42:0x0113, B:44:0x011a, B:44:0x011a, B:46:0x012a, B:46:0x012a, B:48:0x0131, B:48:0x0131, B:47:0x012f, B:47:0x012f, B:43:0x0118, B:43:0x0118, B:33:0x00ed, B:33:0x00ed, B:34:0x00f0, B:34:0x00f0, B:36:0x00f3, B:36:0x00f3), top: B:80:0x001c, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x013a A[Catch: all -> 0x0175, TryCatch #4 {, blocks: (B:4:0x0003, B:8:0x000b, B:49:0x0136, B:51:0x013a, B:52:0x013f, B:70:0x0171, B:63:0x015b, B:65:0x015f, B:66:0x0166, B:55:0x0144, B:57:0x0148, B:60:0x0151, B:62:0x0155, B:67:0x0167, B:69:0x016b, B:72:0x0173, B:10:0x001c, B:12:0x008a, B:14:0x009d, B:15:0x00a6, B:17:0x00ae, B:25:0x00df, B:37:0x00f6, B:39:0x00fa, B:40:0x0101, B:42:0x0113, B:44:0x011a, B:46:0x012a, B:48:0x0131, B:47:0x012f, B:43:0x0118, B:33:0x00ed, B:34:0x00f0, B:36:0x00f3, B:59:0x014e), top: B:84:0x0003, inners: #0, #6, #9 }] */
    public final void a(Context context) {
        AtomicInteger atomicInteger;
        LineNumberReader lineNumberReader;
        Throwable th;
        com.anythink.core.d.b bVarB;
        int iAr;
        long jAt;
        synchronized (this.o) {
            if (this.h == null && context != null) {
                this.l = t.b().p();
                this.h = context.getApplicationContext();
                try {
                    try {
                        try {
                            try {
                                this.f = this.h.getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + "log" + File.separator + "anythink_agent_log";
                                this.g = this.h.getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + "log" + File.separator + "anythink_temp_log";
                                if (this.i == null) {
                                    File file = new File(this.f);
                                    this.i = file;
                                    if (!file.getParentFile().exists()) {
                                        this.i.getParentFile().mkdirs();
                                    }
                                    if (!this.i.exists()) {
                                        this.i.createNewFile();
                                    }
                                }
                                LineNumberReader lineNumberReader2 = null;
                                try {
                                    try {
                                        lineNumberReader = new LineNumberReader(new FileReader(this.i));
                                        try {
                                            lineNumberReader.skip(Long.MAX_VALUE);
                                            int lineNumber = lineNumberReader.getLineNumber();
                                            if (this.j == null) {
                                                this.j = new AtomicInteger(lineNumber);
                                            }
                                            lineNumberReader.close();
                                            this.j.get();
                                            lineNumberReader.close();
                                        } catch (Exception unused) {
                                            lineNumberReader2 = lineNumberReader;
                                            if (lineNumberReader2 != null) {
                                                lineNumberReader2.close();
                                            } else {
                                                if (this.j == null) {
                                                    this.j = new AtomicInteger(0);
                                                }
                                                bVarB = com.anythink.core.d.d.a(this.h).b(this.l);
                                                if (bVarB.ar() != 0) {
                                                    iAr = bVarB.ar();
                                                } else {
                                                    iAr = this.c;
                                                }
                                                this.c = iAr;
                                                this.d = iAr * 2;
                                                if (bVarB.at() != 0) {
                                                    jAt = bVarB.at();
                                                } else {
                                                    jAt = this.e;
                                                }
                                                this.e = jAt;
                                                b();
                                                if (this.j == null) {
                                                    atomicInteger = new AtomicInteger(0);
                                                    this.j = atomicInteger;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (lineNumberReader != null) {
                                                try {
                                                    lineNumberReader.close();
                                                } catch (IOException unused2) {
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (IOException unused3) {
                                    }
                                } catch (Exception unused4) {
                                } catch (Throwable th3) {
                                    lineNumberReader = null;
                                    th = th3;
                                }
                                if (this.j == null) {
                                    this.j = new AtomicInteger(0);
                                }
                                bVarB = com.anythink.core.d.d.a(this.h).b(this.l);
                                if (bVarB.ar() != 0) {
                                    iAr = bVarB.ar();
                                } else {
                                    iAr = this.c;
                                }
                                this.c = iAr;
                                this.d = iAr * 2;
                                if (bVarB.at() != 0) {
                                    jAt = bVarB.at();
                                } else {
                                    jAt = this.e;
                                }
                                this.e = jAt;
                                b();
                                if (this.j == null) {
                                    atomicInteger = new AtomicInteger(0);
                                    this.j = atomicInteger;
                                }
                            } catch (Throwable th4) {
                                if (this.j == null) {
                                    this.j = new AtomicInteger(0);
                                }
                                throw th4;
                            }
                        } catch (OutOfMemoryError | StackOverflowError unused5) {
                            System.gc();
                            if (this.j == null) {
                                atomicInteger = new AtomicInteger(0);
                            }
                        }
                    } catch (Exception unused6) {
                        if (this.j == null) {
                            atomicInteger = new AtomicInteger(0);
                        }
                    }
                } catch (Error unused7) {
                    if (this.j == null) {
                        atomicInteger = new AtomicInteger(0);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        if (r0 != null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final synchronized void a(com.anythink.core.common.h.u r5, boolean r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.io.File r0 = r4.i     // Catch: java.lang.Throwable -> L94
            if (r0 == 0) goto L9
            java.util.concurrent.atomic.AtomicInteger r0 = r4.j     // Catch: java.lang.Throwable -> L94
            if (r0 != 0) goto L14
        L9:
            com.anythink.core.common.d.t r0 = com.anythink.core.common.d.t.b()     // Catch: java.lang.Throwable -> L94
            android.content.Context r0 = r0.g()     // Catch: java.lang.Throwable -> L94
            r4.a(r0)     // Catch: java.lang.Throwable -> L94
        L14:
            java.io.File r0 = r4.i     // Catch: java.lang.Throwable -> L94
            if (r0 == 0) goto L92
            java.util.concurrent.atomic.AtomicInteger r0 = r4.j     // Catch: java.lang.Throwable -> L94
            if (r0 != 0) goto L1e
            goto L92
        L1e:
            android.content.Context r0 = r4.h     // Catch: java.lang.Throwable -> L94
            com.anythink.core.d.d r0 = com.anythink.core.d.d.a(r0)     // Catch: java.lang.Throwable -> L94
            java.lang.String r1 = r4.l     // Catch: java.lang.Throwable -> L94
            com.anythink.core.d.b r0 = r0.b(r1)     // Catch: java.lang.Throwable -> L94
            if (r0 == 0) goto L45
            int r1 = r0.ar()     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L37
            int r1 = r0.ar()     // Catch: java.lang.Throwable -> L94
            goto L39
        L37:
            int r1 = r4.c     // Catch: java.lang.Throwable -> L94
        L39:
            r4.c = r1     // Catch: java.lang.Throwable -> L94
            int r1 = r1 * 2
            r4.d = r1     // Catch: java.lang.Throwable -> L94
            long r0 = r0.at()     // Catch: java.lang.Throwable -> L94
            r4.e = r0     // Catch: java.lang.Throwable -> L94
        L45:
            r0 = 0
            org.json.JSONObject r5 = r5.a()     // Catch: java.lang.Throwable -> L76 java.lang.Error -> L78 java.lang.Throwable -> L7e java.lang.Exception -> L8a
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L76 java.lang.Error -> L78 java.lang.Throwable -> L7e java.lang.Exception -> L8a
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L76 java.lang.Error -> L78 java.lang.Throwable -> L7e java.lang.Exception -> L8a
            java.io.File r2 = r4.i     // Catch: java.lang.Throwable -> L76 java.lang.Error -> L78 java.lang.Throwable -> L7e java.lang.Exception -> L8a
            r3 = 1
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L76 java.lang.Error -> L78 java.lang.Throwable -> L7e java.lang.Exception -> L8a
            r1.append(r5)     // Catch: java.lang.Throwable -> L6d java.lang.Error -> L70 java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r5 = "\n"
            r1.append(r5)     // Catch: java.lang.Throwable -> L6d java.lang.Error -> L70 java.lang.Throwable -> L72 java.lang.Exception -> L74
            r1.flush()     // Catch: java.lang.Throwable -> L6d java.lang.Error -> L70 java.lang.Throwable -> L72 java.lang.Exception -> L74
            r1.close()     // Catch: java.lang.Throwable -> L6d java.lang.Error -> L70 java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.util.concurrent.atomic.AtomicInteger r5 = r4.j     // Catch: java.lang.Throwable -> L6d java.lang.Error -> L70 java.lang.Throwable -> L72 java.lang.Exception -> L74
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L6d java.lang.Error -> L70 java.lang.Throwable -> L72 java.lang.Exception -> L74
            r1.close()     // Catch: java.io.IOException -> L8d java.lang.Throwable -> L94
            goto L8d
        L6d:
            r5 = move-exception
            r0 = r1
            goto L84
        L70:
            r0 = r1
            goto L78
        L72:
            r0 = r1
            goto L7e
        L74:
            r0 = r1
            goto L8a
        L76:
            r5 = move-exception
            goto L84
        L78:
            if (r0 == 0) goto L8d
        L7a:
            r0.close()     // Catch: java.io.IOException -> L8d java.lang.Throwable -> L94
            goto L8d
        L7e:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L76
            if (r0 == 0) goto L8d
            goto L7a
        L84:
            if (r0 == 0) goto L89
            r0.close()     // Catch: java.io.IOException -> L89 java.lang.Throwable -> L94
        L89:
            throw r5     // Catch: java.lang.Throwable -> L94
        L8a:
            if (r0 == 0) goto L8d
            goto L7a
        L8d:
            r4.a(r6)     // Catch: java.lang.Throwable -> L94
            monitor-exit(r4)
            return
        L92:
            monitor-exit(r4)
            return
        L94:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.u.d.a(com.anythink.core.common.h.u, boolean):void");
    }

    private synchronized void a(boolean z) {
        String line;
        AtomicInteger atomicInteger;
        if (this.h == null) {
            return;
        }
        if (!t.b().a()) {
            return;
        }
        if (this.k || (!z && ((atomicInteger = this.j) == null || atomicInteger.get() < this.c))) {
            return;
        }
        this.k = true;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.i));
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < this.d && (line = bufferedReader2.readLine()) != null; i++) {
                        arrayList.add(line);
                    }
                    com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
                    if (bVarB == null) {
                        new com.anythink.core.common.m.d(this.h, 0, arrayList).a(0, this.m);
                    } else if (bVarB.F() != 1) {
                        new com.anythink.core.common.m.d(this.h, bVarB.F(), arrayList).a(0, this.m);
                    } else {
                        com.anythink.core.common.m.d.a aVar = new com.anythink.core.common.m.d.a(arrayList);
                        aVar.a(1, bVarB.E());
                        aVar.a(this.n);
                    }
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    bufferedReader = bufferedReader2;
                    this.k = false;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (OutOfMemoryError | StackOverflowError unused4) {
                    bufferedReader = bufferedReader2;
                    this.k = false;
                    System.gc();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused5) {
                        }
                    }
                } catch (Throwable unused6) {
                    bufferedReader = bufferedReader2;
                    this.k = false;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused7) {
                        }
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused8) {
                    }
                }
                throw th;
            }
        } catch (Exception unused9) {
        } catch (OutOfMemoryError | StackOverflowError unused10) {
        } catch (Throwable unused11) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i) {
        BufferedReader bufferedReader = null;
        try {
            File file = new File(this.g);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.i));
            try {
                FileWriter fileWriter = new FileWriter(file);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    i3++;
                    if (i3 > i) {
                        fileWriter.append((CharSequence) line);
                        fileWriter.append((CharSequence) "\n");
                    }
                }
                fileWriter.flush();
                fileWriter.close();
                bufferedReader2.close();
                AtomicInteger atomicInteger = this.j;
                if (atomicInteger.get() - i >= 0) {
                    i2 = this.j.get() - i;
                }
                atomicInteger.set(i2);
                this.i.delete();
                file.renameTo(this.i);
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
            } catch (Error unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Exception unused4) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused5) {
                    }
                }
            } catch (OutOfMemoryError | StackOverflowError unused6) {
                bufferedReader = bufferedReader2;
                try {
                    System.gc();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused7) {
                        }
                    }
                } catch (Throwable th) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused8) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable unused9) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused10) {
                    }
                }
            }
        } catch (Exception unused11) {
        } catch (OutOfMemoryError | StackOverflowError unused12) {
        } catch (Error unused13) {
        } catch (Throwable unused14) {
        }
    }

    public final void b() {
        if (this.h != null && t.b().a() && com.anythink.core.common.v.q.a(this.h)) {
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.u.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (d.this.h == null) {
                            return;
                        }
                        if ((System.currentTimeMillis() - af.b(d.this.h, u.b.a, "LOG_SEND_TIME", 0L) > d.this.e || (d.this.j != null && d.this.j.get() >= d.this.c)) && !d.this.k && d.this.j != null && d.this.j.get() > 0) {
                            d.this.c();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }, 13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        String line;
        int iOptInt;
        boolean z;
        this.k = true;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.i));
                try {
                    try {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int i = 0;
                        while (i < this.d && (line = bufferedReader2.readLine()) != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(line);
                                try {
                                    iOptInt = jSONObject.optInt(com.anythink.core.common.h.u.a, 0);
                                    try {
                                        long j = Long.parseLong(jSONObject.optString("timestamp"));
                                        z = j > 0 && System.currentTimeMillis() - j > 604800000;
                                    } catch (Throwable unused) {
                                    }
                                } catch (Throwable unused2) {
                                    iOptInt = 0;
                                }
                                Object[] objArr = new Object[2];
                                Integer.valueOf(iOptInt);
                                if (iOptInt > 5 || z) {
                                    arrayList2.add(jSONObject.toString());
                                } else {
                                    jSONObject.put(com.anythink.core.common.h.u.a, iOptInt + 1);
                                    arrayList.add(jSONObject.toString());
                                }
                            } catch (Throwable unused3) {
                            }
                            i++;
                        }
                        bufferedReader2.close();
                        if (i == 0) {
                            this.k = false;
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (Exception unused4) {
                                return;
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            a(arrayList2.size());
                            c();
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (Exception unused5) {
                                return;
                            }
                        }
                        a(arrayList);
                        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
                        if (bVarB == null) {
                            new com.anythink.core.common.m.d(this.h, 0, arrayList).a(0, this.m);
                        } else if (bVarB.F() != 1) {
                            new com.anythink.core.common.m.d(this.h, bVarB.F(), arrayList).a(0, this.m);
                        } else {
                            com.anythink.core.common.m.d.a aVar = new com.anythink.core.common.m.d.a(arrayList);
                            aVar.a(1, bVarB.E());
                            aVar.a(this.n);
                        }
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused6) {
                        }
                    } catch (OutOfMemoryError | StackOverflowError unused7) {
                        bufferedReader = bufferedReader2;
                        this.k = false;
                        System.gc();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused8) {
                            }
                        }
                    }
                } catch (Error unused9) {
                    bufferedReader = bufferedReader2;
                    this.k = false;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused10) {
                        }
                    }
                } catch (Exception unused11) {
                    bufferedReader = bufferedReader2;
                    this.k = false;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused12) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused13) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused14) {
        } catch (OutOfMemoryError | StackOverflowError unused15) {
        } catch (Error unused16) {
        }
    }

    private synchronized void a(List<String> list) {
        BufferedWriter bufferedWriter;
        if (this.i != null && !list.isEmpty()) {
            int size = list.size();
            Object[] objArr = new Object[1];
            Integer.valueOf(list.size());
            BufferedReader bufferedReader = null;
            try {
                File file = new File(this.g);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.i));
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file));
                    for (int i = 0; i < size; i++) {
                        try {
                            if (bufferedReader2.readLine() == null) {
                                break;
                            }
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                            return;
                        }
                    }
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        bufferedWriter.write(it.next());
                        bufferedWriter.newLine();
                    }
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            bufferedWriter.write(line);
                            bufferedWriter.newLine();
                        } else {
                            try {
                                break;
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                    bufferedReader2.close();
                    bufferedWriter.close();
                    this.i.delete();
                    file.renameTo(this.i);
                    try {
                        bufferedReader2.close();
                        bufferedWriter.close();
                    } catch (Throwable unused4) {
                    }
                } catch (Throwable unused5) {
                    bufferedWriter = null;
                }
            } catch (Throwable unused6) {
                bufferedWriter = null;
            }
        }
    }
}
