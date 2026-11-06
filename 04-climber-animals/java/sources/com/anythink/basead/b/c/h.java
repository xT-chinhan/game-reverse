package com.anythink.basead.b.c;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.o;
import java.io.File;
import java.io.FileDescriptor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    public static class a {
        public int a;
        public int b;
    }

    public static a a(String str) {
        a aVar = null;
        try {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return null;
            }
            a aVar2 = new a();
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                mediaMetadataRetriever.release();
                aVar2.a = Integer.parseInt(strExtractMetadata);
                aVar2.b = Integer.parseInt(strExtractMetadata2);
                return aVar2;
            } catch (Exception e) {
                e = e;
                aVar = aVar2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return aVar;
    }

    private static a a(FileDescriptor fileDescriptor) {
        a aVar = null;
        if (fileDescriptor == null) {
            return null;
        }
        try {
            a aVar2 = new a();
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(fileDescriptor);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                mediaMetadataRetriever.release();
                aVar2.a = Integer.parseInt(strExtractMetadata);
                aVar2.b = Integer.parseInt(strExtractMetadata2);
                return aVar2;
            } catch (Exception e) {
                e = e;
                aVar = aVar2;
                e.printStackTrace();
                return aVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private static a a(int i, int i2, int i3, int i4) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        a aVar = new a();
        float f = (i * 1.0f) / i2;
        if (f < (i3 * 1.0f) / i4) {
            aVar.b = i4;
            aVar.a = (int) (aVar.b * f);
        } else {
            aVar.a = i3;
            aVar.b = (int) (aVar.a / f);
        }
        return aVar;
    }

    private static a a(FileDescriptor fileDescriptor, int i, int i2) {
        a aVarA = a(fileDescriptor);
        if (aVarA == null) {
            return null;
        }
        float f = (aVarA.a * 1.0f) / aVarA.b;
        if (f < (i * 1.0f) / i2) {
            aVarA.b = i2;
            aVarA.a = (int) Math.ceil(aVarA.b * f);
        } else {
            aVarA.a = i;
            aVarA.b = (int) Math.ceil(aVarA.a / f);
        }
        return aVarA;
    }

    public static void a(final w wVar, y yVar) {
        if (wVar == null) {
            return;
        }
        synchronized (wVar) {
            if (wVar != null) {
                if (!wVar.Y() && !TextUtils.isEmpty(wVar.E())) {
                    wVar.Z();
                    if (wVar.V() <= 0 && wVar.W() <= 0) {
                        if (yVar != null && yVar.D() == 3 && wVar.J() == 1 && TextUtils.equals(yVar.O(), "2")) {
                            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.b.c.h.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    final ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
                                    executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.anythink.basead.b.c.h.1.1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            try {
                                                a aVarA = h.a(com.anythink.core.common.res.d.a(t.b().g()).c(4, o.a(wVar.E())));
                                                if (aVarA != null) {
                                                    wVar.k(aVarA.a);
                                                    wVar.l(aVarA.b);
                                                }
                                            } catch (Throwable unused) {
                                            }
                                            try {
                                                synchronized (executorServiceNewFixedThreadPool) {
                                                    executorServiceNewFixedThreadPool.notifyAll();
                                                }
                                            } catch (Throwable unused2) {
                                            }
                                        }
                                    });
                                    try {
                                        synchronized (executorServiceNewFixedThreadPool) {
                                            executorServiceNewFixedThreadPool.wait(5000L);
                                        }
                                        executorServiceNewFixedThreadPool.shutdownNow();
                                    } catch (Throwable unused) {
                                    }
                                }
                            }, 2);
                        }
                    }
                }
            }
        }
    }
}
