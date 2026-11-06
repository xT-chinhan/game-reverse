package com.smartdigimkt.n3;

import android.content.Context;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public static volatile r m;
    public Context f;
    public File g;
    public AtomicInteger h;
    public int a = 5;
    public int b = 10;
    public long c = com.anythink.core.common.g.c.a;
    public String d = "";
    public String e = "";
    public boolean i = false;
    public final o j = new o(this);
    public final p k = new p(this);
    public final Object l = new Object();

    public static r a() {
        if (m == null) {
            synchronized (r.class) {
                if (m == null) {
                    m = new r();
                }
            }
        }
        return m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e5, code lost:
    
        if (r2 != 0) goto L64;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void b() {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.n3.r.b():void");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00f1 A[Catch: all -> 0x0149, Error -> 0x014b, OutOfMemoryError | StackOverflowError -> 0x0155, OutOfMemoryError | StackOverflowError -> 0x0155, Exception -> 0x016e, TryCatch #10 {OutOfMemoryError | StackOverflowError -> 0x0155, blocks: (B:10:0x001d, B:12:0x0081, B:14:0x0094, B:15:0x009d, B:17:0x00a5, B:25:0x00d6, B:25:0x00d6, B:36:0x00ed, B:36:0x00ed, B:38:0x00f1, B:38:0x00f1, B:39:0x00f8, B:39:0x00f8, B:43:0x0107, B:43:0x0107, B:47:0x0118, B:47:0x0118, B:50:0x011f, B:50:0x011f, B:53:0x0128, B:53:0x0128, B:56:0x0131, B:56:0x0131, B:46:0x0116, B:46:0x0116, B:42:0x0105, B:42:0x0105, B:32:0x00e4, B:32:0x00e4, B:33:0x00e7, B:33:0x00e7, B:35:0x00ea, B:35:0x00ea), top: B:90:0x001d, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0104  */
    /* JADX WARN: Code duplicated, block: B:42:0x0105 A[Catch: all -> 0x0149, Error -> 0x014b, OutOfMemoryError | StackOverflowError -> 0x0155, OutOfMemoryError | StackOverflowError -> 0x0155, Exception -> 0x016e, TryCatch #10 {OutOfMemoryError | StackOverflowError -> 0x0155, blocks: (B:10:0x001d, B:12:0x0081, B:14:0x0094, B:15:0x009d, B:17:0x00a5, B:25:0x00d6, B:25:0x00d6, B:36:0x00ed, B:36:0x00ed, B:38:0x00f1, B:38:0x00f1, B:39:0x00f8, B:39:0x00f8, B:43:0x0107, B:43:0x0107, B:47:0x0118, B:47:0x0118, B:50:0x011f, B:50:0x011f, B:53:0x0128, B:53:0x0128, B:56:0x0131, B:56:0x0131, B:46:0x0116, B:46:0x0116, B:42:0x0105, B:42:0x0105, B:32:0x00e4, B:32:0x00e4, B:33:0x00e7, B:33:0x00e7, B:35:0x00ea, B:35:0x00ea), top: B:90:0x001d, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0115  */
    /* JADX WARN: Code duplicated, block: B:46:0x0116 A[Catch: all -> 0x0149, Error -> 0x014b, OutOfMemoryError | StackOverflowError -> 0x0155, OutOfMemoryError | StackOverflowError -> 0x0155, Exception -> 0x016e, TryCatch #10 {OutOfMemoryError | StackOverflowError -> 0x0155, blocks: (B:10:0x001d, B:12:0x0081, B:14:0x0094, B:15:0x009d, B:17:0x00a5, B:25:0x00d6, B:25:0x00d6, B:36:0x00ed, B:36:0x00ed, B:38:0x00f1, B:38:0x00f1, B:39:0x00f8, B:39:0x00f8, B:43:0x0107, B:43:0x0107, B:47:0x0118, B:47:0x0118, B:50:0x011f, B:50:0x011f, B:53:0x0128, B:53:0x0128, B:56:0x0131, B:56:0x0131, B:46:0x0116, B:46:0x0116, B:42:0x0105, B:42:0x0105, B:32:0x00e4, B:32:0x00e4, B:33:0x00e7, B:33:0x00e7, B:35:0x00ea, B:35:0x00ea), top: B:90:0x001d, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0143 A[Catch: all -> 0x017d, TryCatch #9 {, blocks: (B:4:0x0007, B:8:0x000f, B:57:0x013f, B:59:0x0143, B:77:0x0177, B:78:0x0179, B:70:0x0162, B:72:0x0166, B:73:0x016d, B:62:0x014b, B:64:0x014f, B:67:0x0158, B:69:0x015c, B:74:0x016e, B:76:0x0172, B:80:0x017b, B:10:0x001d, B:12:0x0081, B:14:0x0094, B:15:0x009d, B:17:0x00a5, B:25:0x00d6, B:36:0x00ed, B:38:0x00f1, B:39:0x00f8, B:43:0x0107, B:47:0x0118, B:50:0x011f, B:53:0x0128, B:56:0x0131, B:46:0x0116, B:42:0x0105, B:32:0x00e4, B:33:0x00e7, B:35:0x00ea, B:66:0x0155), top: B:94:0x0007, inners: #6, #9 }] */
    public final void a(Context context) {
        AtomicInteger atomicInteger;
        int i;
        long j;
        synchronized (this.l) {
            if (this.f == null && context != null) {
                SDKContext.getInstance().a();
                this.f = context.getApplicationContext();
                try {
                    try {
                        try {
                            StringBuilder sbAppend = new StringBuilder().append(this.f.getApplicationContext().getFilesDir().getAbsolutePath());
                            String str = File.separator;
                            this.d = sbAppend.append(str).append("log").append(str).append("sdm_agent_log").toString();
                            this.e = this.f.getApplicationContext().getFilesDir().getAbsolutePath() + str + "log" + str + "sdm_temp_log";
                            if (this.g == null) {
                                File file = new File(this.d);
                                this.g = file;
                                if (!file.getParentFile().exists()) {
                                    this.g.getParentFile().mkdirs();
                                }
                                if (!this.g.exists()) {
                                    this.g.createNewFile();
                                }
                            }
                            LineNumberReader lineNumberReader = null;
                            try {
                                try {
                                    LineNumberReader lineNumberReader2 = new LineNumberReader(new FileReader(this.g));
                                    try {
                                        lineNumberReader2.skip(LongCompanionObject.MAX_VALUE);
                                        int lineNumber = lineNumberReader2.getLineNumber();
                                        if (this.h == null) {
                                            this.h = new AtomicInteger(lineNumber);
                                        }
                                        lineNumberReader2.close();
                                        this.h.get();
                                        lineNumberReader2.close();
                                    } catch (Exception unused) {
                                        lineNumberReader = lineNumberReader2;
                                        if (lineNumberReader != null) {
                                            lineNumberReader.close();
                                        } else {
                                            if (this.h == null) {
                                                this.h = new AtomicInteger(0);
                                            }
                                            com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
                                            i = aVarA.n;
                                            if (i != 0) {
                                                i = this.a;
                                            }
                                            this.a = i;
                                            this.b = i * 2;
                                            j = aVarA.o;
                                            if (j != 0) {
                                                j = this.c;
                                            }
                                            this.c = j;
                                            if (this.f != null) {
                                                com.smartdigimkt.q3.f.a().a(new q(this), 0L, 13);
                                            }
                                            if (this.h == null) {
                                                atomicInteger = new AtomicInteger(0);
                                                this.h = atomicInteger;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        lineNumberReader = lineNumberReader2;
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
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            if (this.h == null) {
                                this.h = new AtomicInteger(0);
                            }
                            com.smartdigimkt.p4.a aVarA2 = com.smartdigimkt.o4.e.c().a();
                            i = aVarA2.n;
                            if (i != 0) {
                                i = this.a;
                            }
                            this.a = i;
                            this.b = i * 2;
                            j = aVarA2.o;
                            if (j != 0) {
                                j = this.c;
                            }
                            this.c = j;
                            if (this.f != null && SDKContext.getInstance().e && com.smartdigimkt.r4.k.c(this.f)) {
                                com.smartdigimkt.q3.f.a().a(new q(this), 0L, 13);
                            }
                            if (this.h == null) {
                                atomicInteger = new AtomicInteger(0);
                                this.h = atomicInteger;
                            }
                        } catch (Throwable th3) {
                            if (this.h == null) {
                                this.h = new AtomicInteger(0);
                            }
                            throw th3;
                        }
                    } catch (OutOfMemoryError | StackOverflowError unused5) {
                        System.gc();
                        if (this.h == null) {
                            atomicInteger = new AtomicInteger(0);
                        }
                    }
                } catch (Error unused6) {
                    if (this.h == null) {
                        atomicInteger = new AtomicInteger(0);
                    }
                } catch (Exception unused7) {
                    if (this.h == null) {
                        atomicInteger = new AtomicInteger(0);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
    
        if (r0 != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
    
        if (r0 != null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(com.smartdigimkt.f3.c r5, boolean r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.io.File r0 = r4.g     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L9
            java.util.concurrent.atomic.AtomicInteger r0 = r4.h     // Catch: java.lang.Throwable -> L87
            if (r0 != 0) goto L14
        L9:
            com.smartdigimkt.sdk.core.SDKContext r0 = com.smartdigimkt.sdk.core.SDKContext.getInstance()     // Catch: java.lang.Throwable -> L87
            android.content.Context r0 = r0.d()     // Catch: java.lang.Throwable -> L87
            r4.a(r0)     // Catch: java.lang.Throwable -> L87
        L14:
            java.io.File r0 = r4.g     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L85
            java.util.concurrent.atomic.AtomicInteger r0 = r4.h     // Catch: java.lang.Throwable -> L87
            if (r0 != 0) goto L1e
            goto L85
        L1e:
            com.smartdigimkt.o4.e r0 = com.smartdigimkt.o4.e.c()     // Catch: java.lang.Throwable -> L87
            com.smartdigimkt.p4.a r0 = r0.a()     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L39
            int r1 = r0.n     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L2d
            goto L2f
        L2d:
            int r1 = r4.a     // Catch: java.lang.Throwable -> L87
        L2f:
            r4.a = r1     // Catch: java.lang.Throwable -> L87
            int r1 = r1 * 2
            r4.b = r1     // Catch: java.lang.Throwable -> L87
            long r0 = r0.o     // Catch: java.lang.Throwable -> L87
            r4.c = r0     // Catch: java.lang.Throwable -> L87
        L39:
            r0 = 0
            org.json.JSONObject r5 = r5.a()     // Catch: java.lang.Throwable -> L69 java.lang.Error -> L6b java.lang.Throwable -> L6e java.lang.Exception -> L7b
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L69 java.lang.Error -> L6b java.lang.Throwable -> L6e java.lang.Exception -> L7b
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L69 java.lang.Error -> L6b java.lang.Throwable -> L6e java.lang.Exception -> L7b
            java.io.File r2 = r4.g     // Catch: java.lang.Throwable -> L69 java.lang.Error -> L6b java.lang.Throwable -> L6e java.lang.Exception -> L7b
            r3 = 1
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L69 java.lang.Error -> L6b java.lang.Throwable -> L6e java.lang.Exception -> L7b
            r1.append(r5)     // Catch: java.lang.Throwable -> L61 java.lang.Error -> L63 java.lang.Throwable -> L65 java.lang.Exception -> L67
            java.lang.String r5 = "\n"
            r1.append(r5)     // Catch: java.lang.Throwable -> L61 java.lang.Error -> L63 java.lang.Throwable -> L65 java.lang.Exception -> L67
            r1.flush()     // Catch: java.lang.Throwable -> L61 java.lang.Error -> L63 java.lang.Throwable -> L65 java.lang.Exception -> L67
            r1.close()     // Catch: java.lang.Throwable -> L61 java.lang.Error -> L63 java.lang.Throwable -> L65 java.lang.Exception -> L67
            java.util.concurrent.atomic.AtomicInteger r5 = r4.h     // Catch: java.lang.Throwable -> L61 java.lang.Error -> L63 java.lang.Throwable -> L65 java.lang.Exception -> L67
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L61 java.lang.Error -> L63 java.lang.Throwable -> L65 java.lang.Exception -> L67
            r1.close()     // Catch: java.io.IOException -> L80 java.lang.Throwable -> L87
            goto L80
        L61:
            r5 = move-exception
            goto L75
        L63:
            r0 = r1
            goto L6b
        L65:
            r0 = r1
            goto L6e
        L67:
            r0 = r1
            goto L7b
        L69:
            r5 = move-exception
            goto L74
        L6b:
            if (r0 == 0) goto L80
            goto L7d
        L6e:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L80
            goto L7d
        L74:
            r1 = r0
        L75:
            if (r1 == 0) goto L7a
            r1.close()     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L87
        L7a:
            throw r5     // Catch: java.lang.Throwable -> L87
        L7b:
            if (r0 == 0) goto L80
        L7d:
            r0.close()     // Catch: java.io.IOException -> L80 java.lang.Throwable -> L87
        L80:
            r4.a(r6)     // Catch: java.lang.Throwable -> L87
            monitor-exit(r4)
            return
        L85:
            monitor-exit(r4)
            return
        L87:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.n3.r.a(com.smartdigimkt.f3.c, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
    
        if (r1 != 0) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(boolean r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            android.content.Context r0 = r5.f     // Catch: java.lang.Throwable -> La6
            if (r0 != 0) goto L7
            monitor-exit(r5)
            return
        L7:
            com.smartdigimkt.sdk.core.SDKContext r0 = com.smartdigimkt.sdk.core.SDKContext.getInstance()     // Catch: java.lang.Throwable -> La6
            boolean r0 = r0.e     // Catch: java.lang.Throwable -> La6
            if (r0 != 0) goto L11
            monitor-exit(r5)
            return
        L11:
            boolean r0 = r5.i     // Catch: java.lang.Throwable -> La6
            if (r0 != 0) goto La4
            if (r6 != 0) goto L23
            java.util.concurrent.atomic.AtomicInteger r6 = r5.h     // Catch: java.lang.Throwable -> La6
            if (r6 == 0) goto La4
            int r6 = r6.get()     // Catch: java.lang.Throwable -> La6
            int r0 = r5.a     // Catch: java.lang.Throwable -> La6
            if (r6 < r0) goto La4
        L23:
            r6 = 1
            r5.i = r6     // Catch: java.lang.Throwable -> La6
            r0 = 0
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L88 java.lang.Throwable -> L8d java.lang.Exception -> L95
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L88 java.lang.Throwable -> L8d java.lang.Exception -> L95
            java.io.File r4 = r5.g     // Catch: java.lang.Throwable -> L88 java.lang.Throwable -> L8d java.lang.Exception -> L95
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L88 java.lang.Throwable -> L8d java.lang.Exception -> L95
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L88 java.lang.Throwable -> L8d java.lang.Exception -> L95
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            r1.<init>()     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            r3 = r0
        L3a:
            int r4 = r5.b     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            if (r3 >= r4) goto L4a
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            if (r4 == 0) goto L4a
            r1.add(r4)     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            int r3 = r3 + 1
            goto L3a
        L4a:
            com.smartdigimkt.o4.e r3 = com.smartdigimkt.o4.e.c()     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            com.smartdigimkt.p4.a r3 = r3.a()     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            if (r3 == 0) goto L74
            int r4 = r3.z     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            if (r4 == r6) goto L63
            com.smartdigimkt.f4.d r6 = new com.smartdigimkt.f4.d     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            r6.<init>(r4, r1)     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            com.smartdigimkt.n3.o r1 = r5.j     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            r6.a(r0, r1)     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            goto L7e
        L63:
            com.smartdigimkt.h4.a r4 = new com.smartdigimkt.h4.a     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            java.lang.String r1 = r3.C     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            r4.a = r6     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            r4.b = r1     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            com.smartdigimkt.n3.p r6 = r5.k     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            r4.a(r6)     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            goto L7e
        L74:
            com.smartdigimkt.f4.d r6 = new com.smartdigimkt.f4.d     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            r6.<init>(r0, r1)     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            com.smartdigimkt.n3.o r1 = r5.j     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
            r6.a(r0, r1)     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> L84 java.lang.Exception -> L86
        L7e:
            r2.close()     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> La6
            goto La4
        L82:
            r1 = r2
            goto L88
        L84:
            r1 = r2
            goto L8d
        L86:
            r1 = r2
            goto L95
        L88:
            r5.i = r0     // Catch: java.lang.Throwable -> L9d
            if (r1 == 0) goto La4
            goto L99
        L8d:
            r5.i = r0     // Catch: java.lang.Throwable -> L9d
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L9d
            if (r1 == 0) goto La4
            goto L99
        L95:
            r5.i = r0     // Catch: java.lang.Throwable -> L9d
            if (r1 == 0) goto La4
        L99:
            r1.close()     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> La6
            goto La4
        L9d:
            r6 = move-exception
            if (r1 == 0) goto La3
            r1.close()     // Catch: java.lang.Exception -> La3 java.lang.Throwable -> La6
        La3:
            throw r6     // Catch: java.lang.Throwable -> La6
        La4:
            monitor-exit(r5)
            return
        La6:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.n3.r.a(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        if (r0 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        if (r0 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        if (r0 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
    
        if (r0 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
    
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L71 java.lang.Exception -> L7e
            java.lang.String r2 = r6.e     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L71 java.lang.Exception -> L7e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L71 java.lang.Exception -> L7e
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L71 java.lang.Exception -> L7e
            if (r2 != 0) goto L12
            r1.createNewFile()     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L71 java.lang.Exception -> L7e
        L12:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L71 java.lang.Exception -> L7e
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L71 java.lang.Exception -> L7e
            java.io.File r4 = r6.g     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L71 java.lang.Exception -> L7e
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L71 java.lang.Exception -> L7e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L71 java.lang.Exception -> L7e
            java.io.FileWriter r0 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r3 = 0
            r4 = r3
        L25:
            java.lang.String r5 = r2.readLine()     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r5 == 0) goto L38
            int r4 = r4 + 1
            if (r4 <= r7) goto L25
            r0.append(r5)     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.lang.String r5 = "\n"
            r0.append(r5)     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            goto L25
        L38:
            r0.flush()     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r0.close()     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r2.close()     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.util.concurrent.atomic.AtomicInteger r0 = r6.h     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            int r4 = r0.get()     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            int r4 = r4 - r7
            if (r4 >= 0) goto L4b
            goto L52
        L4b:
            java.util.concurrent.atomic.AtomicInteger r3 = r6.h     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            int r3 = r3.get()     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            int r3 = r3 - r7
        L52:
            r0.set(r3)     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.io.File r7 = r6.g     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r7.delete()     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.io.File r7 = r6.g     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r1.renameTo(r7)     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r2.close()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            goto L87
        L63:
            r0 = r2
            goto L6b
        L65:
            r0 = r2
            goto L6e
        L67:
            r0 = r2
            goto L71
        L69:
            r0 = r2
            goto L7e
        L6b:
            if (r0 == 0) goto L87
            goto L80
        L6e:
            if (r0 == 0) goto L87
            goto L80
        L71:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L87
            goto L80
        L77:
            r7 = move-exception
            if (r0 == 0) goto L7d
            r0.close()     // Catch: java.io.IOException -> L7d java.lang.Throwable -> L84
        L7d:
            throw r7     // Catch: java.lang.Throwable -> L84
        L7e:
            if (r0 == 0) goto L87
        L80:
            r0.close()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            goto L87
        L84:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L87:
            monitor-exit(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.n3.r.a(int):void");
    }

    public final synchronized void a(ArrayList arrayList) {
        BufferedWriter bufferedWriter;
        if (this.g != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            arrayList.size();
            BufferedReader bufferedReader = null;
            try {
                try {
                    File file = new File(this.e);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.g));
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
                                    bufferedReader.close();
                                }
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            bufferedWriter.write((String) it.next());
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
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                        bufferedReader2.close();
                        bufferedWriter.close();
                        this.g.delete();
                        file.renameTo(this.g);
                        bufferedReader2.close();
                        bufferedWriter.close();
                    } catch (Throwable unused3) {
                        bufferedWriter = null;
                    }
                } catch (Throwable unused4) {
                }
            } catch (Throwable unused5) {
                bufferedWriter = null;
            }
        }
    }
}
