package com.smartdigimkt.k;

import android.util.SparseIntArray;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public static final /* synthetic */ int m = 0;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public long f;
    public long g;
    public int h;
    public c0 j;
    public ExecutorService k;
    public y l;
    public int e = 2;
    public int i = 1;

    public static void a(z zVar) throws ProtocolException {
        if (zVar.f > 0) {
            if (zVar.d) {
                zVar.a();
                return;
            }
            String str = zVar.a;
            zVar.e = 1;
            zVar.k.execute(new v(0, str, com.smartdigimkt.n.c.a(0, zVar.c), zVar.b, zVar.g, 0, 0, 0, zVar.l, zVar));
            return;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(zVar.a).openConnection();
        httpURLConnection.setRequestMethod("HEAD");
        long contentLength = httpURLConnection.getContentLength();
        zVar.f = contentLength;
        if (contentLength <= 0) {
            zVar.a(3, "downloadSize <= 0");
            return;
        }
        String headerField = httpURLConnection.getHeaderField("Accept-Ranges");
        if (headerField != null && headerField.equals("bytes")) {
            zVar.d = true;
            zVar.a();
        } else {
            zVar.d = false;
            String str2 = zVar.a;
            zVar.e = 1;
            zVar.k.execute(new v(0, str2, com.smartdigimkt.n.c.a(0, zVar.c), zVar.b, zVar.g, 0, 0, 0, zVar.l, zVar));
        }
    }

    public final void a() {
        z zVar = this;
        int i = zVar.h;
        if (i > 0 && zVar.f < i) {
            zVar.e = 1;
        }
        int i2 = zVar.e;
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            File file = new File(zVar.c + "_" + i3);
            if (file.exists()) {
                arrayList.add(file);
            }
        }
        a(sparseIntArray, sparseIntArray2, sparseIntArray3, i2, zVar.f, zVar.c);
        if (arrayList.size() > 0 && i2 != arrayList.size()) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                File file2 = (File) arrayList.get(i4);
                if (file2.exists()) {
                    file2.delete();
                }
            }
            a(sparseIntArray, sparseIntArray2, sparseIntArray3, i2, zVar.f, zVar.c);
        }
        int i5 = 0;
        while (i5 < i2) {
            zVar.k.execute(new v(i5, zVar.a, com.smartdigimkt.n.c.a(i5, zVar.c), zVar.b, zVar.g, sparseIntArray.get(i5), sparseIntArray2.get(i5), sparseIntArray3.get(i5), zVar.l, this));
            i5++;
            zVar = this;
            i2 = i2;
            sparseIntArray3 = sparseIntArray3;
        }
    }

    public final void a(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2, SparseIntArray sparseIntArray3, int i, long j, String str) {
        long length;
        long length2;
        long jCeil = (long) Math.ceil(j / ((double) i));
        for (int i2 = 0; i2 < i; i2++) {
            File file = new File(com.smartdigimkt.n.c.a(i2, str));
            file.length();
            if (file.exists()) {
                length = file.length() + (((long) i2) * jCeil);
                length2 = file.length();
            } else if (!file.createNewFile()) {
                a(3, "create part File failed.");
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
        }
    }

    public final void a(int i, String str) {
        c0 c0Var = this.j;
        if (c0Var != null) {
            c0Var.a(7);
            this.j.a(i, str);
        }
    }
}
