package com.anythink.basead.b.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.anythink.basead.mraid.MraidWebView;
import com.anythink.basead.mraid.i;
import com.anythink.basead.webtemplet.WTWebView;
import com.anythink.basead.webtemplet.l;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.o;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class c implements e.a {
    public static final String a = "c";
    w b;
    y c;
    x d;
    private String f;
    private boolean g;
    private int h;
    private String i;
    private List<String> j;
    private b k;
    private com.anythink.basead.b.a.e<Void, com.anythink.basead.d.f> l;
    private volatile boolean m;
    com.anythink.core.common.t.b e = new com.anythink.core.common.t.b() { // from class: com.anythink.basead.b.c.c.1
        @Override // java.lang.Runnable
        public final void run() {
            c.this.a(com.anythink.basead.d.g.a("20001", com.anythink.basead.d.g.v));
        }
    };
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public interface b {
        void a();

        void a(com.anythink.basead.d.f fVar);
    }

    /* JADX INFO: renamed from: com.anythink.basead.b.c.c$c, reason: collision with other inner class name */
    private static final class C0011c {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;

        private C0011c() {
        }
    }

    public c(String str, boolean z, w wVar, x xVar) {
        this.f = str;
        this.g = z;
        this.b = wVar;
        this.d = xVar;
        y yVar = xVar.o;
        this.c = yVar;
        this.h = yVar.w();
        com.anythink.basead.b.c.b bVar = new com.anythink.basead.b.c.b();
        this.l = bVar;
        bVar.a((com.anythink.basead.b.a.d) new a(this, (byte) 0));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0091  */
    /* JADX WARN: Code duplicated, block: B:31:0x0099  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:68:0x0117  */
    /* JADX WARN: Code duplicated, block: B:77:0x0131  */
    /* JADX WARN: Code duplicated, block: B:78:0x0136  */
    /* JADX WARN: Code duplicated, block: B:80:0x0142  */
    /* JADX WARN: Code duplicated, block: B:81:0x0144  */
    public final void a(b bVar) {
        w wVar;
        boolean z;
        int i;
        w wVar2;
        boolean z2;
        String strAn;
        boolean z3;
        w wVar3 = this.b;
        if (wVar3 == null || this.l == null) {
            a(com.anythink.basead.d.g.a("-9999", com.anythink.basead.d.g.C));
            return;
        }
        this.i = wVar3.v();
        this.k = bVar;
        com.anythink.core.common.t.d.a().a(this.e, this.h, false);
        int iAo = this.b.ao();
        int i2 = this.d.j;
        if (iAo == 1) {
            if (!this.d.q && String.valueOf(this.d.j).equals("0")) {
                wVar = this.b;
                if ((!(wVar instanceof r) && !TextUtils.isEmpty(((r) wVar).d())) || this.d.p || TextUtils.isEmpty(this.b.B())) {
                    z = false;
                }
            } else {
                z = false;
            }
            this.o = z;
            i = z ? 2 : 1;
            if (!this.b.L() && String.valueOf(this.d.j).equals("0")) {
                wVar2 = this.b;
                if (((wVar2 instanceof r) || TextUtils.isEmpty(((r) wVar2).d())) && !this.d.p) {
                    d.a(this.b, this.c);
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            this.p = z2;
            if (z2) {
                i++;
            }
            if ((i2 != 1 || i2 == 3 || i2 == 4) && iAo == 3) {
                i++;
                strAn = this.b.an();
                if (TextUtils.isEmpty(strAn)) {
                    a(5);
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (this.c.bC() == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    com.anythink.core.common.res.a.a.a(t.b().g()).a(strAn, new AnonymousClass6(this.c.bI(), jCurrentTimeMillis, z3));
                }
            }
            this.l.b(i);
            a();
        } else if (iAo == 2) {
            this.m = false;
            if (this.c != null) {
                boolean z4 = i2 == 1 || i2 == 3;
                this.l.b(1);
                if (z4) {
                    this.l.b(2);
                    a();
                }
                if (this.m) {
                    return;
                }
                boolean zAd = this.c.ad();
                String strA = i.a(this.d, this.b);
                if (TextUtils.isEmpty(strA)) {
                    a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.L, com.anythink.basead.d.g.R));
                } else if (!zAd) {
                    a(2);
                } else {
                    t.b().b(new AnonymousClass4(d.b(this.d, this.b), strA));
                }
            }
        } else if (iAo == 3) {
            if (this.d.q) {
                z = false;
            } else {
                wVar = this.b;
                z = !(wVar instanceof r) ? true : true;
            }
            this.o = z;
            if (z) {
            }
            if (this.b.L()) {
                z2 = false;
            } else {
                wVar2 = this.b;
                if (wVar2 instanceof r) {
                    d.a(this.b, this.c);
                    z2 = true;
                } else {
                    d.a(this.b, this.c);
                    z2 = true;
                }
            }
            this.p = z2;
            if (z2) {
                i++;
            }
            if (i2 != 1) {
                i++;
                strAn = this.b.an();
                if (TextUtils.isEmpty(strAn)) {
                    a(5);
                } else {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (this.c.bC() == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    com.anythink.core.common.res.a.a.a(t.b().g()).a(strAn, new AnonymousClass6(this.c.bI(), jCurrentTimeMillis2, z3));
                }
            } else {
                i++;
                strAn = this.b.an();
                if (TextUtils.isEmpty(strAn)) {
                    a(5);
                } else {
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    if (this.c.bC() == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    com.anythink.core.common.res.a.a.a(t.b().g()).a(strAn, new AnonymousClass6(this.c.bI(), jCurrentTimeMillis3, z3));
                }
            }
            this.l.b(i);
            a();
        }
        i();
    }

    private void a() {
        List<String> listA = this.b.a(this.c);
        if (listA == null) {
            a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.m, "Incomplete resource allocation! MissResource: ".concat(String.valueOf(this.b.a()))));
            return;
        }
        int size = listA.size();
        if (size == 0) {
            b();
            a(1);
            return;
        }
        this.j = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = listA.get(i);
            if (!TextUtils.isEmpty(str)) {
                if (this.b.I(str)) {
                    if (!d.a(this.b, this.c) && !this.j.contains(str)) {
                        this.c.aa();
                        this.j.add(str);
                    }
                } else if (!d.f(str) && !this.j.contains(str)) {
                    this.j.add(str);
                }
            }
        }
        if (com.anythink.basead.b.e.c(this.b, this.d) && this.b.L() && d.a(this.b, this.c) && !TextUtils.isEmpty(this.b.B())) {
            this.j.remove(this.b.B());
        }
        int size2 = this.j.size();
        if (size2 == 0) {
            b();
            a(1);
            return;
        }
        synchronized (this) {
            e.a().a(this);
            ArrayList arrayList = new ArrayList(this.j);
            for (int i2 = 0; i2 < size2; i2++) {
                String str2 = (String) arrayList.get(i2);
                boolean zI = this.b.I(str2);
                int iAa = this.c.aa();
                if (zI) {
                    if (d.a(this.b, this.c)) {
                        new StringBuilder("Video file ready -> ").append(str2).append(",videoNeedReadyRate:");
                        e.a().a(str2, iAa);
                    } else {
                        new StringBuilder("Video file not exis -> ").append(str2).append(",videoNeedReadyRate:");
                        new g(this.f, this.b, this.c, this.d).a();
                    }
                } else if (!d.a(str2)) {
                    if (d.f(str2)) {
                        d.a(str2, 100);
                        e.a().a(str2, 100);
                    } else {
                        d.a(str2, 0);
                        new f(this.f, this.g, this.b, str2).d();
                    }
                }
            }
        }
        b();
    }

    private void b() {
        List<String> listB = this.b.b(this.c);
        listB.size();
        if (listB.size() > 0) {
            for (int i = 0; i < listB.size(); i++) {
                String str = listB.get(i);
                if (!d.f(str)) {
                    new f(this.f, this.g, this.b, str).d();
                }
            }
        }
    }

    private boolean c() {
        if (!this.d.q || !String.valueOf(this.d.j).equals("0")) {
            return false;
        }
        w wVar = this.b;
        return (((wVar instanceof r) && !TextUtils.isEmpty(((r) wVar).d())) || this.d.p || TextUtils.isEmpty(this.b.B())) ? false : true;
    }

    private void d() {
        if (this.b.ab() > 0 || this.b.ac() > 0) {
            this.b.ab();
            this.b.ac();
            a(3);
            return;
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.b.c.c.2
            @Override // java.lang.Runnable
            public final void run() {
                String strB = c.this.b.B();
                com.anythink.core.common.u.b.a();
                String strA = com.anythink.core.common.u.b.a(c.this.d);
                com.anythink.core.common.u.b.a().a(strA).d = System.currentTimeMillis();
                c.a(c.this, strB);
                com.anythink.core.common.u.b.a().a(strA).e = System.currentTimeMillis();
                String str = c.a;
                c.this.b.ab();
                c.this.b.ac();
                com.anythink.core.common.u.b.a().a(strA).a();
                c.this.a(3);
            }
        }, 4);
    }

    private boolean e() {
        if (!this.b.L() || !String.valueOf(this.d.j).equals("0")) {
            return false;
        }
        w wVar = this.b;
        if (((wVar instanceof r) && !TextUtils.isEmpty(((r) wVar).d())) || this.d.p) {
            return false;
        }
        d.a(this.b, this.c);
        return true;
    }

    private void f() {
        if (!d.a(this.b, this.c)) {
            a(4);
            return;
        }
        if (this.b.V() > 0 && this.b.W() > 0) {
            this.b.V();
            this.b.W();
            a(4);
        } else {
            com.anythink.core.common.u.b.a();
            String strA = com.anythink.core.common.u.b.a(this.d);
            com.anythink.core.common.u.b.a().a(strA).f = System.currentTimeMillis();
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.b.c.c.3
                @Override // java.lang.Runnable
                public final void run() {
                    final ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
                    executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.anythink.basead.b.c.c.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                String strC = com.anythink.core.common.res.d.a(t.b().g()).c(4, o.a(c.this.b.E()));
                                if (new File(strC).exists()) {
                                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                                    String str = c.a;
                                    mediaMetadataRetriever.setDataSource(strC);
                                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                                    String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                                    String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                                    mediaMetadataRetriever.release();
                                    c.this.b.k(Integer.parseInt(strExtractMetadata));
                                    c.this.b.l(Integer.parseInt(strExtractMetadata2));
                                    c.this.b.a(Long.parseLong(strExtractMetadata3));
                                    com.anythink.core.common.u.b.a();
                                    String strA2 = com.anythink.core.common.u.b.a(c.this.d);
                                    com.anythink.core.common.u.b.a().a(strA2).g = System.currentTimeMillis();
                                    String str2 = c.a;
                                    com.anythink.core.common.u.b.a().a(strA2).b();
                                } else {
                                    String str3 = c.a;
                                }
                                synchronized (executorServiceNewFixedThreadPool) {
                                    executorServiceNewFixedThreadPool.notifyAll();
                                }
                            } catch (Throwable unused) {
                                c.this.a(4);
                            }
                        }
                    });
                    try {
                        synchronized (executorServiceNewFixedThreadPool) {
                            executorServiceNewFixedThreadPool.wait(com.anythink.basead.exoplayer.i.a.f);
                        }
                        executorServiceNewFixedThreadPool.shutdownNow();
                        String str = c.a;
                        c.this.a(4);
                    } catch (Throwable unused) {
                        c.this.a(4);
                    }
                }
            }, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:38:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void a(String str) {
        int i;
        int i2;
        int i3;
        InputStream inputStream = null;
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(2000);
            uRLConnectionOpenConnection.setReadTimeout(5000);
            InputStream inputStream2 = uRLConnectionOpenConnection.getInputStream();
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream2, null, options);
                i2 = options.outWidth;
                try {
                    i3 = options.outHeight;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStream2;
                    i = i2;
                    try {
                        th.getMessage();
                        th.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        i2 = i;
                        i3 = 0;
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStream2;
                i = 0;
                th.getMessage();
                th.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
                i2 = i;
                i3 = 0;
                if (i2 < 0) {
                    i2 = 0;
                }
                int i4 = i3 >= 0 ? i3 : 0;
                this.b.n(i2);
                this.b.o(i4);
            }
        } catch (Throwable th4) {
            th = th4;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= 0) {
        }
        this.b.n(i2);
        this.b.o(i4);
    }

    private void a(boolean z) {
        String strA = i.a(this.d, this.b);
        if (TextUtils.isEmpty(strA)) {
            a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.L, com.anythink.basead.d.g.R));
        } else if (!z) {
            a(2);
        } else {
            t.b().b(new AnonymousClass4(d.b(this.d, this.b), strA));
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.b.c.c$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        AnonymousClass4(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                i.a(this.a, this.b, new MraidWebView(t.b().g()), new i.a() { // from class: com.anythink.basead.b.c.c.4.1
                    @Override // com.anythink.basead.mraid.i.a
                    public final void a() {
                        c.this.a(2);
                    }

                    @Override // com.anythink.basead.mraid.i.a
                    public final void a(com.anythink.basead.d.f fVar) {
                        c.this.a(fVar);
                    }
                }, c.this.b, c.this.d, 5, false);
            } catch (Throwable th) {
                c.this.a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.L, com.anythink.basead.d.g.U + th.getMessage()));
            }
        }
    }

    @Override // com.anythink.basead.b.c.e.a
    public final void a(String str, int i) {
        this.j.size();
        synchronized (this) {
            d.a(str, i);
            List<String> list = this.j;
            if (list != null && list.contains(str) && (!this.b.I(str) || this.c.aa() <= i)) {
                this.j.remove(str);
                if (this.b.I(str)) {
                    h.a(this.b, this.c);
                }
                if (this.j.isEmpty()) {
                    a(1);
                    return;
                }
                if (com.anythink.basead.b.e.c(this.b, this.d)) {
                    String strB = this.b.B();
                    if (TextUtils.equals(String.valueOf(this.d.o.D()), "2")) {
                        strB = this.b.d(this.c);
                    }
                    if (this.b.I(str) && !TextUtils.isEmpty(strB)) {
                        this.j.remove(strB);
                        if (this.j.isEmpty()) {
                            a(1);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.anythink.basead.b.c.e.a
    public final void a(String str, com.anythink.basead.d.f fVar) {
        this.j.size();
        fVar.c();
        synchronized (this) {
            byte b2 = -1;
            d.a(str, -1);
            List<String> list = this.j;
            if (list != null) {
                list.remove(str);
            }
            if (this.b.I(str) && com.anythink.basead.b.e.c(this.b, this.d)) {
                com.anythink.core.common.u.e.a(this.d, this.b, 1, fVar.c());
            }
            String strValueOf = String.valueOf(this.d.o.D());
            switch (strValueOf.hashCode()) {
                case 48:
                    if (strValueOf.equals("0")) {
                        b2 = 2;
                    }
                    break;
                case 49:
                    if (strValueOf.equals("1")) {
                        b2 = 0;
                    }
                    break;
                case 50:
                    if (strValueOf.equals("2")) {
                        b2 = 4;
                    }
                    break;
                case 51:
                    if (strValueOf.equals("3")) {
                        b2 = 1;
                    }
                    break;
                case 52:
                    if (strValueOf.equals("4")) {
                        b2 = 3;
                    }
                    break;
            }
            if (b2 == 0 || b2 == 1) {
                a(fVar);
            } else if (b2 == 2) {
                a(1);
            } else if (b2 == 3 || b2 == 4) {
                String strB = this.b.B();
                if (TextUtils.equals(String.valueOf(this.d.o.D()), "2")) {
                    strB = this.b.d(this.c);
                }
                if (!this.b.I(str) && (TextUtils.isEmpty(strB) || !TextUtils.equals(strB, str))) {
                    a(fVar);
                    return;
                }
                if (TextUtils.isEmpty(strB)) {
                    a(fVar);
                    return;
                }
                if (this.b.I(str) && this.j.size() == 0) {
                    a(1);
                    return;
                }
                List<String> list2 = this.j;
                if (list2 == null || (!list2.contains(this.b.E()) && !this.j.contains(this.b.B()))) {
                    a(fVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        boolean z = this.o;
        if (i == 1 && !this.n) {
            this.n = true;
            if (z) {
                d();
            }
            if (this.p) {
                f();
            }
        }
        com.anythink.basead.b.a.e<Void, com.anythink.basead.d.f> eVar = this.l;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.basead.d.f fVar) {
        fVar.c();
        this.m = true;
        com.anythink.basead.b.a.e<Void, com.anythink.basead.d.f> eVar = this.l;
        if (eVar != null) {
            eVar.a(fVar);
        }
    }

    private class a implements com.anythink.basead.b.a.d<Void, com.anythink.basead.d.f> {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        @Override // com.anythink.basead.b.a.d
        public final /* synthetic */ void a(com.anythink.basead.d.f fVar) {
            com.anythink.basead.d.f fVar2 = fVar;
            if (c.this.k != null) {
                String str = c.a;
                String unused = c.this.i;
                c.this.k.a(fVar2);
            }
            c.c(c.this);
        }

        private void b() {
            if (c.this.k != null) {
                String str = c.a;
                String unused = c.this.i;
                c.this.k.a();
            }
            c.c(c.this);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(com.anythink.basead.d.f fVar) {
            if (c.this.k != null) {
                String str = c.a;
                String unused = c.this.i;
                c.this.k.a(fVar);
            }
            c.c(c.this);
        }

        @Override // com.anythink.basead.b.a.d
        public final /* synthetic */ void a() {
            if (c.this.k != null) {
                String str = c.a;
                String unused = c.this.i;
                c.this.k.a();
            }
            c.c(c.this);
        }
    }

    private void g() {
        e.a().b(this);
        com.anythink.core.common.t.d.a().b(this.e);
    }

    private void h() {
        com.anythink.core.common.t.d.a().a(this.e, this.h, false);
    }

    private void i() {
        int iMin;
        List<String> listO;
        x xVar = this.d;
        if (xVar != null && xVar.o != null) {
            Context contextG = t.b().g();
            try {
                iMin = Math.min(contextG.getResources().getDisplayMetrics().widthPixels, contextG.getResources().getDisplayMetrics().heightPixels) / 2;
            } catch (Throwable unused) {
                iMin = 0;
            }
            if (String.valueOf(this.d.j).equals("1") && !this.b.L() && this.d.o.an() != 1) {
                com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(contextG).b(t.b().p());
                int iAo = this.d.o.ao();
                if (iAo == 2) {
                    listO = bVarB.o();
                } else if (iAo == 3) {
                    listO = bVarB.q();
                } else {
                    listO = iAo != 5 ? null : bVarB.p();
                }
                if (listO != null && listO.size() > 0) {
                    for (String str : listO) {
                        if (!TextUtils.isEmpty(str) && !d.b(str, 3)) {
                            com.anythink.core.common.res.b.a(contextG).a(new com.anythink.core.common.res.e(3, str), iMin, iMin, null);
                        }
                    }
                }
            }
            if (this.d.o.U() == 1 && !TextUtils.isEmpty(this.d.o.f())) {
                com.anythink.core.common.res.b.a(contextG).a(new com.anythink.core.common.res.e(3, this.d.o.f()), iMin, iMin, null);
            }
            if (this.d.o.aO() == 4 && !TextUtils.isEmpty(this.d.o.aZ()) && !com.anythink.core.common.res.d.a(contextG).b(3, o.a(this.d.o.aZ()))) {
                this.d.o.aZ();
                new com.anythink.basead.b.c.a(this.d.o.aZ()).d();
            }
        }
        List<String> listE = this.b.e(this.c);
        if (listE.isEmpty()) {
            return;
        }
        for (String str2 : listE) {
            if (!TextUtils.isEmpty(str2)) {
                d.b(str2, 3);
                if (!d.b(str2, 3)) {
                    com.anythink.core.common.res.b.a(t.b().g()).a(new com.anythink.core.common.res.e(3, str2), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.b.c.c.5
                        @Override // com.anythink.core.common.res.b.a
                        public final void onSuccess(String str3, Bitmap bitmap) {
                        }

                        @Override // com.anythink.core.common.res.b.a
                        public final void onFail(String str3, String str4) {
                            String str5 = c.a;
                        }
                    });
                }
            }
        }
    }

    private void j() {
        String strAn = this.b.an();
        if (TextUtils.isEmpty(strAn)) {
            a(5);
            return;
        }
        com.anythink.core.common.res.a.a.a(t.b().g()).a(strAn, new AnonymousClass6(this.c.bI(), System.currentTimeMillis(), this.c.bC() == 1));
    }

    /* JADX INFO: renamed from: com.anythink.basead.b.c.c$6, reason: invalid class name */
    final class AnonymousClass6 implements com.anythink.core.common.res.a.a.InterfaceC0097a {
        final /* synthetic */ long a;
        final /* synthetic */ long b;
        final /* synthetic */ boolean c;
        private volatile boolean e = false;
        private com.anythink.core.common.t.b f = new com.anythink.core.common.t.b() { // from class: com.anythink.basead.b.c.c.6.1
            @Override // java.lang.Runnable
            public final void run() {
                AnonymousClass6.this.a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.ac, "h5 template load timeout"), 7, "h5 template load timeout", 0L);
            }
        };

        AnonymousClass6(long j, long j2, boolean z) {
            this.a = j;
            this.b = j2;
            this.c = z;
            com.anythink.core.common.t.d.a().a(this.f, j, false);
        }

        private void a() {
            com.anythink.core.common.t.d.a().a(this.f, this.a, false);
        }

        private void b() {
            com.anythink.core.common.t.d.a().b(this.f);
        }

        @Override // com.anythink.core.common.res.a.a.InterfaceC0097a
        public final void a(String str, final String str2, final long j) {
            if (TextUtils.isEmpty(str) || !TextUtils.equals(c.this.b.an(), str)) {
                return;
            }
            if (!(c.this.c.bB() == 1)) {
                a(false, (String) null, j);
            } else {
                final String strA = d.a((x) null, c.this.b, 3);
                t.b().b(new Runnable() { // from class: com.anythink.basead.b.c.c.6.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Object aVar;
                        try {
                            WTWebView wTWebView = new WTWebView(t.b().g());
                            try {
                                int i = c.this.d.j;
                                if (i == 1 || i == 3) {
                                    aVar = new com.anythink.basead.webtemplet.adformat.intestitial.a();
                                } else {
                                    aVar = i != 4 ? null : new com.anythink.basead.webtemplet.adformat.splash.a();
                                }
                                l.a(strA, new File(str2).toURI().toString(), wTWebView, new l.a() { // from class: com.anythink.basead.b.c.c.6.2.1
                                    @Override // com.anythink.basead.webtemplet.l.a
                                    public final void a() {
                                        AnonymousClass6.this.a(true, strA, j);
                                    }

                                    @Override // com.anythink.basead.webtemplet.l.a
                                    public final void a(com.anythink.basead.d.f fVar) {
                                        AnonymousClass6.this.a(fVar, TextUtils.equals(fVar.a(), com.anythink.basead.d.g.u) ? 5 : 4, fVar.c(), j);
                                    }
                                }, c.this.b, c.this.d, 1, aVar);
                            } catch (Throwable th) {
                                AnonymousClass6.this.a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.L, com.anythink.basead.d.g.ab + th.getMessage()), 6, com.anythink.basead.d.g.U + th.getMessage(), 0L);
                            }
                        } catch (Throwable th2) {
                            AnonymousClass6.this.a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.L, com.anythink.basead.d.g.ab + th2.getMessage()), 6, com.anythink.basead.d.g.U + th2.getMessage(), 0L);
                        }
                    }
                });
            }
        }

        @Override // com.anythink.core.common.res.a.a.InterfaceC0097a
        public final void a(String str, int i, String str2) {
            if (TextUtils.equals(c.this.b.an(), str)) {
                a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.ac, com.anythink.basead.d.g.ac.concat(String.valueOf(str2))), i, str2, 0L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z, String str, long j) {
            if (this.e && z && !TextUtils.isEmpty(str)) {
                d.e(str);
            }
            a(true, (com.anythink.basead.d.f) null, 0, "", j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.anythink.basead.d.f fVar, int i, String str, long j) {
            a(false, fVar, i, str, j);
        }

        private void a(boolean z, com.anythink.basead.d.f fVar, int i, String str, long j) {
            if (this.e) {
                return;
            }
            this.e = true;
            b();
            if (!z) {
                com.anythink.core.common.u.e.a(c.this.b, c.this.d, false, System.currentTimeMillis() - this.b, i, str, 0L);
                if (this.c) {
                    c.this.a(5);
                    return;
                } else {
                    c.this.a(fVar);
                    return;
                }
            }
            com.anythink.core.common.u.e.a(c.this.b, c.this.d, System.currentTimeMillis() - this.b, j);
            c.this.a(5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:38:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static /* synthetic */ void a(c cVar, String str) {
        int i;
        int i2;
        int i3;
        InputStream inputStream = null;
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(2000);
            uRLConnectionOpenConnection.setReadTimeout(5000);
            InputStream inputStream2 = uRLConnectionOpenConnection.getInputStream();
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream2, null, options);
                i2 = options.outWidth;
                try {
                    i3 = options.outHeight;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStream2;
                    i = i2;
                    try {
                        th.getMessage();
                        th.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        i2 = i;
                        i3 = 0;
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStream2;
                i = 0;
                th.getMessage();
                th.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
                i2 = i;
                i3 = 0;
                if (i2 < 0) {
                    i2 = 0;
                }
                int i4 = i3 >= 0 ? i3 : 0;
                cVar.b.n(i2);
                cVar.b.o(i4);
            }
        } catch (Throwable th4) {
            th = th4;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= 0) {
        }
        cVar.b.n(i2);
        cVar.b.o(i4);
    }

    static /* synthetic */ void c(c cVar) {
        e.a().b(cVar);
        com.anythink.core.common.t.d.a().b(cVar.e);
    }
}
