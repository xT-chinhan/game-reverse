package com.anythink.dlopt.common.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private static final String a = "l";
    private String b;
    private String c;
    private String d;
    private boolean e;
    private int f;
    private long g;
    private long h;
    private int i;
    private g j;
    private k k;
    private ExecutorService l;
    private f m;

    private interface e {
        void a(int i);

        void a(int i, int i2);

        void a(int i, int i2, long j);

        void a(int i, c cVar, String str);

        void b(int i);

        void c(int i);
    }

    static /* synthetic */ String f() {
        return "anythink_download_apk";
    }

    private static String l() {
        return "anythink_download_apk";
    }

    /* synthetic */ l(byte b2) {
        this();
    }

    static /* synthetic */ long h(l lVar) {
        lVar.h = 60000L;
        return 60000L;
    }

    static /* synthetic */ int i(l lVar) {
        lVar.i = 20971520;
        return 20971520;
    }

    private l() {
        this.f = 2;
        this.j = g.IDLE;
    }

    private boolean h() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.d) || this.l == null) ? false : true;
    }

    public final void a() {
        Object[] objArr = new Object[6];
        Boolean.valueOf(this.e);
        Integer.valueOf(this.f);
        Long.valueOf(this.g);
        if (!((TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.d) || this.l == null) ? false : true)) {
            a("url, filePath or executorService can not be empty. url: " + this.b + " filePath: " + this.d + " executorService: " + this.l);
            return;
        }
        if (this.j == g.START || this.j == g.LOADING) {
            return;
        }
        g gVar = g.START;
        this.j = gVar;
        k kVar = this.k;
        if (kVar != null) {
            kVar.a(gVar);
        }
        this.m = new f();
        this.l.execute(new b() { // from class: com.anythink.dlopt.common.a.l.1
            @Override // com.anythink.dlopt.common.a.l.b, java.lang.Runnable
            public final void run() {
                String string;
                super.run();
                try {
                    if (l.this.j == g.LOADING) {
                        return;
                    }
                    l.b(l.this);
                } catch (Throwable th) {
                    try {
                        StringWriter stringWriter = new StringWriter();
                        th.printStackTrace(new PrintWriter(stringWriter));
                        string = stringWriter.toString();
                    } catch (Throwable unused) {
                        string = null;
                    }
                    l.this.a("DownloadLoader#start() >>> download failed: msg = " + th.getMessage() + ", stackTrace = " + string);
                }
            }
        });
    }

    public final void b() {
        this.j = g.PAUSE;
    }

    public final void c() {
        this.j = g.STOP;
    }

    public final g d() {
        return this.j;
    }

    public final boolean e() {
        return this.e;
    }

    private void i() throws ProtocolException {
        if (this.g > 0) {
            if (this.e) {
                k();
                return;
            } else {
                j();
                return;
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.b).openConnection();
        httpURLConnection.setRequestMethod("HEAD");
        long contentLength = httpURLConnection.getContentLength();
        this.g = contentLength;
        if (contentLength <= 0) {
            a("downloadSize <= 0");
            return;
        }
        String headerField = httpURLConnection.getHeaderField("Accept-Ranges");
        if (headerField == null || !headerField.equals("bytes")) {
            this.e = false;
            j();
        } else {
            this.e = true;
            k();
        }
    }

    private void j() {
        Object[] objArr = new Object[1];
        this.f = 1;
        this.l.execute(new d(0, this.b, com.anythink.dlopt.common.c.b.a(this.d, 0), this.c, this.h, 0, 0, 0, this.m, this, (byte) 0));
    }

    private void k() {
        int i = this.i;
        if (i > 0) {
            long j = this.g;
            if (j < i) {
                Object[] objArr = new Object[2];
                Long.valueOf(j);
                Integer.valueOf(this.i);
                this.f = 1;
            }
        }
        int i2 = this.f;
        Object[] objArr2 = new Object[2];
        Integer.valueOf(i2);
        Long.valueOf(this.g);
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            File file = new File(this.d + "_" + i3);
            if (file.exists()) {
                arrayList.add(file);
            }
        }
        a(sparseIntArray, sparseIntArray2, sparseIntArray3, i2, this.g, this.d);
        if (arrayList.size() > 0 && i2 != arrayList.size()) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                File file2 = (File) arrayList.get(i4);
                if (file2.exists()) {
                    file2.delete();
                }
            }
            a(sparseIntArray, sparseIntArray2, sparseIntArray3, i2, this.g, this.d);
        }
        int i5 = 0;
        while (i5 < i2) {
            this.l.execute(new d(i5, this.b, com.anythink.dlopt.common.c.b.a(this.d, i5), this.c, this.h, sparseIntArray.get(i5), sparseIntArray2.get(i5), sparseIntArray3.get(i5), this.m, this, (byte) 0));
            i5++;
            sparseIntArray3 = sparseIntArray3;
            sparseIntArray2 = sparseIntArray2;
        }
    }

    private void a(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2, SparseIntArray sparseIntArray3, int i, long j, String str) {
        long length;
        long length2;
        long jCeil = (long) Math.ceil(j / ((double) i));
        for (int i2 = 0; i2 < i; i2++) {
            File file = new File(com.anythink.dlopt.common.c.b.a(str, i2));
            Object[] objArr = new Object[3];
            Integer.valueOf(i2);
            Long.valueOf(file.length());
            Long.valueOf(jCeil);
            if (file.exists()) {
                length = (((long) i2) * jCeil) + file.length();
                length2 = file.length();
            } else if (!file.createNewFile()) {
                a("create part File failed.");
                return;
            } else {
                length = ((long) i2) * jCeil;
                length2 = 0;
            }
            long jMin = Math.min(((((long) i2) * jCeil) + jCeil) - 1, j - 1);
            long jMin2 = Math.min(length, jMin);
            long jMin3 = Math.min(length2, jCeil - 1);
            sparseIntArray.put(i2, (int) jMin2);
            sparseIntArray2.put(i2, (int) jMin);
            sparseIntArray3.put(i2, (int) jMin3);
            Object[] objArr2 = new Object[4];
            Integer.valueOf(i2);
            Long.valueOf(jMin2);
            Long.valueOf(jMin);
            Long.valueOf(jMin3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        a(c.EXCEPTION, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, String str) {
        k kVar = this.k;
        if (kVar != null) {
            kVar.a(g.ERROR);
            this.k.a(cVar, str);
        }
    }

    private static String b(String str, int i) {
        return com.anythink.dlopt.common.c.b.a(str, i);
    }

    private class f implements e {
        private static final int l = 100;
        private final AtomicInteger b = new AtomicInteger(0);
        private final AtomicInteger c = new AtomicInteger(0);
        private final AtomicInteger d = new AtomicInteger(0);
        private final AtomicInteger e = new AtomicInteger(0);
        private final AtomicInteger f = new AtomicInteger(0);
        private final AtomicInteger g = new AtomicInteger(0);
        private final AtomicInteger h = new AtomicInteger(0);
        private final SparseIntArray i = new SparseIntArray();
        private HandlerThread j;
        private Handler k;

        public f() {
            try {
                HandlerThread handlerThread = new HandlerThread(l.f());
                this.j = handlerThread;
                handlerThread.start();
                this.k = new Handler(this.j.getLooper()) { // from class: com.anythink.dlopt.common.a.l.f.1
                    @Override // android.os.Handler
                    public final void handleMessage(Message message) {
                        if (message.what == 100) {
                            long j = 0;
                            for (int i = 0; i < f.this.i.size(); i++) {
                                try {
                                    j += (long) f.this.i.get(i);
                                } catch (Throwable th) {
                                    String unused = l.a;
                                    Object[] objArr = new Object[1];
                                    th.getMessage();
                                    return;
                                }
                            }
                            if (l.this.k != null) {
                                k kVar = l.this.k;
                                SparseIntArray unused2 = f.this.i;
                                kVar.a(j, l.this.g);
                            }
                            if (f.this.k == null || j > l.this.g) {
                                return;
                            }
                            f.this.k.sendMessageDelayed(f.this.k.obtainMessage(100), 500L);
                        }
                    }
                };
            } catch (Throwable th) {
                String unused = l.a;
                Object[] objArr = new Object[1];
                th.getMessage();
            }
        }

        @Override // com.anythink.dlopt.common.a.l.e
        public final void a(int i) {
            String unused = l.a;
            Object[] objArr = new Object[1];
            Integer.valueOf(i);
            if (this.b.incrementAndGet() == 1) {
                if (l.this.k != null) {
                    l.this.k.a(g.PAUSE);
                }
                a();
            }
        }

        @Override // com.anythink.dlopt.common.a.l.e
        public final void b(int i) {
            String unused = l.a;
            Object[] objArr = new Object[1];
            Integer.valueOf(i);
            if (this.c.incrementAndGet() == 1) {
                if (l.this.k != null) {
                    l.this.k.a(g.STOP);
                }
                a();
            }
        }

        @Override // com.anythink.dlopt.common.a.l.e
        public final void a(int i, int i2) {
            String unused = l.a;
            Object[] objArr = new Object[2];
            Integer.valueOf(i);
            Integer.valueOf(i2);
            int iAddAndGet = this.h.addAndGet(i2);
            if (this.d.incrementAndGet() != l.this.f || l.this.k == null) {
                return;
            }
            l.this.j = g.LOADING;
            l.this.k.a(g.LOADING);
            l.this.k.a(iAddAndGet, l.this.g, l.this.f);
        }

        @Override // com.anythink.dlopt.common.a.l.e
        public final void a(int i, int i2, long j) {
            Handler handler;
            synchronized (this.i) {
                this.i.put(i, (int) (((long) i2) + j));
            }
            if (this.e.get() == 1 || this.e.incrementAndGet() != 1 || (handler = this.k) == null) {
                return;
            }
            this.k.sendMessageDelayed(handler.obtainMessage(100), 500L);
        }

        @Override // com.anythink.dlopt.common.a.l.e
        public final void c(int i) {
            String unused = l.a;
            Object[] objArr = new Object[1];
            Integer.valueOf(i);
            if (this.f.incrementAndGet() == l.this.f) {
                String strA = a(l.this.f, l.this.d);
                if (l.this.k != null) {
                    if (TextUtils.isEmpty(strA)) {
                        l.this.j = g.FINISH;
                        l.this.k.a(l.this.j);
                        int i2 = l.this.f;
                        String str = l.this.d;
                        for (int i3 = 0; i3 < i2; i3++) {
                            File file = new File(com.anythink.dlopt.common.c.b.a(str, i3));
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                        k kVar = l.this.k;
                        String unused2 = l.this.b;
                        String unused3 = l.this.d;
                        kVar.a();
                    } else {
                        l.this.j = g.ERROR;
                        l.this.k.a(l.this.j);
                        k kVar2 = l.this.k;
                        String unused4 = l.this.b;
                        kVar2.a(c.EXCEPTION, strA);
                    }
                }
                a();
            }
        }

        @Override // com.anythink.dlopt.common.a.l.e
        public final void a(int i, c cVar, String str) {
            String unused = l.a;
            Object[] objArr = new Object[3];
            Integer.valueOf(i);
            if (this.g.incrementAndGet() == 1) {
                l.this.j = g.ERROR;
                l.this.a(cVar, str);
                a();
            }
        }

        private void a() {
            try {
                Handler handler = this.k;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (this.j != null) {
                    this.j.quitSafely();
                }
            } catch (Throwable th) {
                String unused = l.a;
                Object[] objArr = new Object[1];
                th.getMessage();
            }
        }

        private static String a(int i, String str) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.createNewFile();
                } else {
                    file.delete();
                    file.createNewFile();
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                for (int i2 = 0; i2 < i; i2++) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(com.anythink.dlopt.common.c.b.a(str, i2)));
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int i3 = bufferedInputStream.read(bArr);
                        if (i3 != -1) {
                            bufferedOutputStream.write(bArr, 0, i3);
                        }
                    }
                    bufferedInputStream.close();
                }
                bufferedOutputStream.close();
                return "";
            } catch (Throwable th) {
                String unused = l.a;
                th.getMessage();
                return "mergeFiles() >>> failed: " + th.getMessage();
            }
        }

        private static void b(int i, String str) {
            for (int i2 = 0; i2 < i; i2++) {
                File file = new File(com.anythink.dlopt.common.c.b.a(str, i2));
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public enum g {
        IDLE,
        START,
        LOADING,
        PAUSE,
        STOP,
        FINISH,
        ERROR;

        private static /* synthetic */ g[] a() {
            return new g[]{IDLE, START, LOADING, PAUSE, STOP, FINISH, ERROR};
        }
    }

    public enum c {
        HTTP_STATUS,
        HTTP_TIMEOUT,
        EXCEPTION,
        CONNECT_EXCEPTION;

        private static /* synthetic */ c[] a() {
            return new c[]{HTTP_STATUS, HTTP_TIMEOUT, EXCEPTION, CONNECT_EXCEPTION};
        }
    }

    public static class a {
        private final l a = new l(0);

        public final a a(String str) {
            this.a.b = str;
            return this;
        }

        public final a b(String str) {
            this.a.c = str;
            return this;
        }

        public final a c(String str) {
            this.a.d = str;
            return this;
        }

        public final a a(boolean z) {
            this.a.e = z;
            return this;
        }

        public final a a(int i) {
            this.a.f = i;
            return this;
        }

        public final a a(long j) {
            this.a.g = j;
            return this;
        }

        public final a a(k kVar) {
            this.a.k = kVar;
            return this;
        }

        public final a a(ExecutorService executorService) {
            this.a.l = executorService;
            return this;
        }

        public final a a() {
            l.h(this.a);
            return this;
        }

        public final a b() {
            l.i(this.a);
            return this;
        }

        public final l c() {
            return this.a;
        }
    }

    public static abstract class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName(l.f());
        }
    }

    private static class d extends b {
        private static final int a = 1048576;
        private final int b;
        private final String c;
        private final String d;
        private final String e;
        private long f;
        private final int g;
        private final int h;
        private final int i;
        private final e j;
        private final l k;

        /* synthetic */ d(int i, String str, String str2, String str3, long j, int i2, int i3, int i4, e eVar, l lVar, byte b) {
            this(i, str, str2, str3, j, i2, i3, i4, eVar, lVar);
        }

        private d(int i, String str, String str2, String str3, long j, int i2, int i3, int i4, e eVar, l lVar) {
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = j;
            this.g = i2;
            this.h = i3;
            this.i = i4;
            this.j = eVar;
            this.k = lVar;
        }

        @Override // com.anythink.dlopt.common.a.l.b, java.lang.Runnable
        public final void run() {
            e eVar;
            int i;
            super.run();
            if (this.k == null || (eVar = this.j) == null) {
                return;
            }
            int i2 = this.h;
            if ((i2 > 0 && this.g == i2) || ((i = this.i) > 0 && i2 == i)) {
                String unused = l.a;
                Object[] objArr = new Object[2];
                Integer.valueOf(this.b);
                Integer.valueOf(this.h);
                this.j.a(this.b, this.i);
                this.j.c(this.b);
                return;
            }
            eVar.a(this.b, i);
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.c).openConnection();
                    try {
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        if (TextUtils.isEmpty(this.e)) {
                            httpURLConnection2.addRequestProperty("User-Agent", this.e);
                        }
                        String str = "bytes=" + this.g + "-";
                        if (this.h > 0) {
                            str = "bytes=" + this.g + "-" + this.h;
                        }
                        httpURLConnection2.setRequestProperty("Range", str);
                        if (a()) {
                            if (httpURLConnection2 != null) {
                                try {
                                    httpURLConnection2.disconnect();
                                    return;
                                } catch (Throwable th) {
                                    String unused2 = l.a;
                                    th.getMessage();
                                    return;
                                }
                            }
                            return;
                        }
                        long j = 0;
                        if (this.f <= 0) {
                            this.f = 60000L;
                        }
                        httpURLConnection2.setConnectTimeout((int) this.f);
                        httpURLConnection2.connect();
                        int responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode != 200 && responseCode != 206) {
                            this.j.a(this.b, c.HTTP_STATUS, "statusCode=" + responseCode + " " + httpURLConnection2.getResponseMessage());
                            if (httpURLConnection2 != null) {
                                try {
                                    httpURLConnection2.disconnect();
                                    return;
                                } catch (Throwable th2) {
                                    String unused3 = l.a;
                                    th2.getMessage();
                                    return;
                                }
                            }
                            return;
                        }
                        if (a()) {
                            if (httpURLConnection2 != null) {
                                try {
                                    httpURLConnection2.disconnect();
                                    return;
                                } catch (Throwable th3) {
                                    String unused4 = l.a;
                                    th3.getMessage();
                                    return;
                                }
                            }
                            return;
                        }
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.d, "rws");
                        randomAccessFile.seek(this.i);
                        byte[] bArr = new byte[1048576];
                        while (true) {
                            int i3 = bufferedInputStream.read(bArr, 0, 1048576);
                            if (i3 == -1) {
                                randomAccessFile.close();
                                bufferedInputStream.close();
                                this.j.c(this.b);
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                        return;
                                    } catch (Throwable th4) {
                                        String unused5 = l.a;
                                        th4.getMessage();
                                        return;
                                    }
                                }
                                return;
                            }
                            if (a()) {
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                        return;
                                    } catch (Throwable th5) {
                                        String unused6 = l.a;
                                        th5.getMessage();
                                        return;
                                    }
                                }
                                return;
                            }
                            randomAccessFile.write(bArr, 0, i3);
                            j += (long) i3;
                            this.j.a(this.b, this.i, j);
                        }
                    } catch (OutOfMemoryError e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        this.j.a(this.b, c.EXCEPTION, "OutOfMemoryError: " + e.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th6) {
                                String unused7 = l.a;
                                th6.getMessage();
                            }
                        }
                    } catch (StackOverflowError e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        this.j.a(this.b, c.EXCEPTION, "StackOverflowError: " + e.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th7) {
                                String unused8 = l.a;
                                th7.getMessage();
                            }
                        }
                    } catch (Error e3) {
                        e = e3;
                        httpURLConnection = httpURLConnection2;
                        this.j.a(this.b, c.EXCEPTION, "Error: " + e.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th8) {
                                String unused9 = l.a;
                                th8.getMessage();
                            }
                        }
                    } catch (ConnectException e4) {
                        e = e4;
                        httpURLConnection = httpURLConnection2;
                        this.j.a(this.b, c.CONNECT_EXCEPTION, "ConnectException: " + e.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th9) {
                                String unused10 = l.a;
                                th9.getMessage();
                            }
                        }
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        httpURLConnection = httpURLConnection2;
                        this.j.a(this.b, c.HTTP_TIMEOUT, "SocketTimeoutException: " + e.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th10) {
                                String unused11 = l.a;
                                th10.getMessage();
                            }
                        }
                    } catch (ConnectTimeoutException e6) {
                        e = e6;
                        httpURLConnection = httpURLConnection2;
                        this.j.a(this.b, c.HTTP_TIMEOUT, "ConnectTimeoutException: " + e.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th11) {
                                String unused12 = l.a;
                                th11.getMessage();
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                        httpURLConnection = httpURLConnection2;
                        this.j.a(this.b, c.EXCEPTION, "Exception: " + e.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th12) {
                                String unused13 = l.a;
                                th12.getMessage();
                            }
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        httpURLConnection = httpURLConnection2;
                        this.j.a(this.b, c.EXCEPTION, "Throwable: " + th.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th14) {
                                String unused14 = l.a;
                                th14.getMessage();
                            }
                        }
                    }
                } catch (Throwable th15) {
                    if (0 != 0) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th16) {
                            String unused15 = l.a;
                            th16.getMessage();
                        }
                    }
                    throw th15;
                }
            } catch (OutOfMemoryError e8) {
                e = e8;
            } catch (StackOverflowError e9) {
                e = e9;
            } catch (Error e10) {
                e = e10;
            } catch (ConnectException e11) {
                e = e11;
            } catch (SocketTimeoutException e12) {
                e = e12;
            } catch (ConnectTimeoutException e13) {
                e = e13;
            } catch (Exception e14) {
                e = e14;
            } catch (Throwable th17) {
                th = th17;
            }
        }

        private boolean a() {
            if (this.k.d() == g.STOP) {
                this.j.b(this.b);
                return true;
            }
            if (this.k.d() != g.PAUSE) {
                return false;
            }
            this.j.a(this.b);
            return true;
        }
    }

    static /* synthetic */ void b(l lVar) throws ProtocolException {
        if (lVar.g > 0) {
            if (lVar.e) {
                lVar.k();
                return;
            } else {
                lVar.j();
                return;
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(lVar.b).openConnection();
        httpURLConnection.setRequestMethod("HEAD");
        long contentLength = httpURLConnection.getContentLength();
        lVar.g = contentLength;
        if (contentLength <= 0) {
            lVar.a("downloadSize <= 0");
            return;
        }
        String headerField = httpURLConnection.getHeaderField("Accept-Ranges");
        if (headerField == null || !headerField.equals("bytes")) {
            lVar.e = false;
            lVar.j();
        } else {
            lVar.e = true;
            lVar.k();
        }
    }
}
