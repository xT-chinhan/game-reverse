package com.anythink.core.common.res;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.h;
import com.anythink.core.common.v.o;
import java.io.FileInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String b = "ImageLoader";
    private static volatile b c;
    Context a;
    private Map<String, Integer> d;
    private final Object f = new Object();
    private final ConcurrentHashMap<String, List<a>> g = new ConcurrentHashMap<>();
    private c<String, SoftReference<Bitmap>> e = new c<String, SoftReference<Bitmap>>(((int) Runtime.getRuntime().maxMemory()) / 5) { // from class: com.anythink.core.common.res.b.3
        @Override // com.anythink.core.common.res.c
        protected final /* synthetic */ int a(String str, SoftReference<Bitmap> softReference) {
            String str2 = str;
            SoftReference<Bitmap> softReference2 = softReference;
            Bitmap bitmap = softReference2 != null ? softReference2.get() : null;
            if (b.this.d == null) {
                b.this.d = new HashMap(8);
            }
            if (bitmap == null) {
                Integer num = (Integer) b.this.d.get(str2);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            }
            int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
            b.this.d.put(str2, Integer.valueOf(rowBytes));
            return rowBytes;
        }

        @Override // com.anythink.core.common.res.c
        protected final /* synthetic */ void a(boolean z, String str, SoftReference<Bitmap> softReference, SoftReference<Bitmap> softReference2) {
            Bitmap bitmap;
            String str2 = str;
            SoftReference<Bitmap> softReference3 = softReference;
            SoftReference<Bitmap> softReference4 = softReference2;
            super.a(z, str2, softReference3, softReference4);
            if (softReference3 != null) {
                try {
                    bitmap = softReference3.get();
                } catch (Exception unused) {
                    return;
                }
            } else {
                bitmap = null;
            }
            if (b.this.d != null) {
                b.this.d.remove(str2);
            }
            if (softReference3 == null || softReference3.equals(softReference4) || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private int a2(String str, SoftReference<Bitmap> softReference) {
            Bitmap bitmap = softReference != null ? softReference.get() : null;
            if (b.this.d == null) {
                b.this.d = new HashMap(8);
            }
            if (bitmap == null) {
                Integer num = (Integer) b.this.d.get(str);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            }
            int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
            b.this.d.put(str, Integer.valueOf(rowBytes));
            return rowBytes;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(boolean z, String str, SoftReference<Bitmap> softReference, SoftReference<Bitmap> softReference2) {
            Bitmap bitmap;
            super.a(z, str, softReference, softReference2);
            if (softReference != null) {
                try {
                    bitmap = softReference.get();
                } catch (Exception unused) {
                    return;
                }
            } else {
                bitmap = null;
            }
            if (b.this.d != null) {
                b.this.d.remove(str);
            }
            if (softReference == null || softReference.equals(softReference2) || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }
    };

    public interface a {
        void onFail(String str, String str2);

        void onSuccess(String str, Bitmap bitmap);
    }

    private void b(String str, Bitmap bitmap) {
        synchronized (this.g) {
            try {
                LinkedList<a> linkedList = (LinkedList) this.g.remove(str);
                if (linkedList != null) {
                    for (a aVar : linkedList) {
                        if (aVar != null) {
                            t.b().b(new AnonymousClass1(bitmap, aVar, str));
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.res.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Bitmap a;
        final /* synthetic */ a b;
        final /* synthetic */ String c;

        AnonymousClass1(Bitmap bitmap, a aVar, String str) {
            this.a = bitmap;
            this.b = aVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                this.b.onSuccess(this.c, bitmap);
            } else {
                this.b.onFail(this.c, "Bitmap load fail");
            }
        }
    }

    private void a(String str, String str2) {
        synchronized (this.g) {
            try {
                LinkedList<a> linkedList = (LinkedList) this.g.remove(str);
                if (linkedList != null) {
                    for (a aVar : linkedList) {
                        if (aVar != null) {
                            t.b().b(new AnonymousClass2(aVar, str, str2));
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.res.b$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ a a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        AnonymousClass2(a aVar, String str, String str2) {
            this.a = aVar;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onFail(this.b, this.c);
        }
    }

    public final void a(String str, Bitmap bitmap) {
        if (a(str) != null || bitmap == null) {
            return;
        }
        this.e.b(str, new SoftReference<>(bitmap));
    }

    private Bitmap a(String str) {
        SoftReference<Bitmap> softReferenceA = this.e.a(str);
        if (softReferenceA != null) {
            return softReferenceA.get();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[Catch: all -> 0x002e, TRY_LEAVE, TryCatch #2 {all -> 0x002e, blocks: (B:9:0x0014, B:11:0x0022), top: B:35:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x004b A[EXC_TOP_SPLITTER, PHI: r0
      0x004b: PHI (r0v2 android.graphics.Bitmap) = (r0v0 android.graphics.Bitmap), (r0v4 android.graphics.Bitmap) binds: [B:22:0x004f, B:19:0x0049] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final Bitmap a(e eVar, int i, int i2) {
        Bitmap bitmapA = null;
        if (eVar == null || TextUtils.isEmpty(eVar.h)) {
            return null;
        }
        String strA = o.a(eVar.h);
        if (i <= 0) {
            try {
                i = this.a.getResources().getDisplayMetrics().widthPixels;
                if (i2 <= 0) {
                    i2 = this.a.getResources().getDisplayMetrics().heightPixels;
                }
            } catch (Throwable unused) {
            }
        } else if (i2 <= 0) {
            i2 = this.a.getResources().getDisplayMetrics().heightPixels;
        }
        synchronized (this.f) {
            FileInputStream fileInputStreamA = d.a(this.a).a(eVar.g, strA);
            if (fileInputStreamA == null) {
                return null;
            }
            try {
                bitmapA = h.a(fileInputStreamA.getFD(), i, i2);
                if (fileInputStreamA != null) {
                    try {
                        fileInputStreamA.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable unused3) {
                if (fileInputStreamA != null) {
                    fileInputStreamA.close();
                }
            }
            return bitmapA;
        }
    }

    public final Bitmap b(e eVar, int i, int i2) {
        if (TextUtils.isEmpty(eVar.h)) {
            return null;
        }
        Bitmap bitmapA = a(eVar.h);
        if (bitmapA != null && !bitmapA.isRecycled()) {
            return bitmapA;
        }
        Bitmap bitmapA2 = a(eVar, i, i2);
        if (bitmapA2 == null || bitmapA2.isRecycled()) {
            return null;
        }
        a(eVar.h, bitmapA2);
        return bitmapA2;
    }

    private b(Context context) {
        this.a = context.getApplicationContext();
    }

    public static b a(Context context) {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b(context);
                }
            }
        }
        return c;
    }

    public final void a(e eVar, a aVar) {
        a(eVar, -1, -1, aVar);
    }

    public final void a(final e eVar, final int i, final int i2, final a aVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.h)) {
            if (aVar != null) {
                aVar.onFail("", "No url info.");
                return;
            }
            return;
        }
        Bitmap bitmapA = a(eVar.h);
        if (bitmapA == null || bitmapA.isRecycled() || (bitmapA.getWidth() < i && bitmapA.getHeight() < i2)) {
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.res.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmapA2 = b.this.a(eVar, i, i2);
                    if (bitmapA2 != null && !bitmapA2.isRecycled()) {
                        String str = eVar.h;
                        b.this.a(eVar.h, bitmapA2);
                        if (aVar != null) {
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(aVar);
                            b.this.g.put(eVar.h, linkedList);
                        }
                        b.a(b.this, eVar.h, bitmapA2);
                        return;
                    }
                    b.a(b.this, eVar, i, i2, aVar);
                }
            }, 2);
        } else if (aVar != null) {
            aVar.onSuccess(eVar.h, bitmapA);
        }
    }

    private void b(e eVar, int i, int i2, a aVar) {
        synchronized (this.g) {
            if (!this.g.containsKey(eVar.h)) {
                if (aVar != null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(aVar);
                    this.g.put(eVar.h, linkedList);
                }
                com.anythink.core.common.res.image.a aVar2 = new com.anythink.core.common.res.image.a(eVar);
                aVar2.a(new AnonymousClass5(i, i2, eVar));
                aVar2.d();
            } else {
                LinkedList linkedList2 = (LinkedList) this.g.get(eVar.h);
                if (linkedList2 != null && aVar != null && !linkedList2.contains(aVar)) {
                    linkedList2.add(aVar);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.res.b$5, reason: invalid class name */
    final class AnonymousClass5 implements com.anythink.core.common.res.image.a.InterfaceC0099a {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ e c;

        AnonymousClass5(int i, int i2, e eVar) {
            this.a = i;
            this.b = i2;
            this.c = eVar;
        }

        @Override // com.anythink.core.common.res.image.a.InterfaceC0099a
        public final void a(e eVar) {
            String str = eVar.h;
            Bitmap bitmapA = b.this.a(eVar, this.a, this.b);
            if (bitmapA != null) {
                b.this.a(eVar.h, bitmapA);
            }
            b.a(b.this, this.c.h, bitmapA);
        }

        @Override // com.anythink.core.common.res.image.a.InterfaceC0099a
        public final void a(e eVar, String str) {
            b.a(b.this, eVar.h, str);
        }
    }

    private void a() {
        try {
            c<String, SoftReference<Bitmap>> cVar = this.e;
            if (cVar != null) {
                cVar.a();
            }
            ConcurrentHashMap<String, List<a>> concurrentHashMap = this.g;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(b bVar, String str, Bitmap bitmap) {
        synchronized (bVar.g) {
            try {
                LinkedList<a> linkedList = (LinkedList) bVar.g.remove(str);
                if (linkedList != null) {
                    for (a aVar : linkedList) {
                        if (aVar != null) {
                            t.b().b(bVar.new AnonymousClass1(bitmap, aVar, str));
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(b bVar, e eVar, int i, int i2, a aVar) {
        synchronized (bVar.g) {
            if (!bVar.g.containsKey(eVar.h)) {
                if (aVar != null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(aVar);
                    bVar.g.put(eVar.h, linkedList);
                }
                com.anythink.core.common.res.image.a aVar2 = new com.anythink.core.common.res.image.a(eVar);
                aVar2.a(bVar.new AnonymousClass5(i, i2, eVar));
                aVar2.d();
            } else {
                LinkedList linkedList2 = (LinkedList) bVar.g.get(eVar.h);
                if (linkedList2 != null && aVar != null && !linkedList2.contains(aVar)) {
                    linkedList2.add(aVar);
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, String str, String str2) {
        synchronized (bVar.g) {
            try {
                LinkedList<a> linkedList = (LinkedList) bVar.g.remove(str);
                if (linkedList != null) {
                    for (a aVar : linkedList) {
                        if (aVar != null) {
                            t.b().b(bVar.new AnonymousClass2(aVar, str, str2));
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
