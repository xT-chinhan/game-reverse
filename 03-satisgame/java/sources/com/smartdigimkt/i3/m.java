package com.smartdigimkt.i3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static volatile m f;
    public Map a;
    public final Context d;
    public final Object c = new Object();
    public final ConcurrentHashMap e = new ConcurrentHashMap();
    public final i b = new i(this, ((int) Runtime.getRuntime().maxMemory()) / 5);

    public m(Context context) {
        this.d = context.getApplicationContext();
    }

    public static void a(m mVar, String str, Bitmap bitmap) {
        synchronized (mVar.e) {
            LinkedList<l> linkedList = (LinkedList) mVar.e.remove(str);
            if (linkedList != null) {
                for (l lVar : linkedList) {
                    if (lVar != null) {
                        com.smartdigimkt.q3.f.a().a(new g(bitmap, lVar, str));
                    }
                }
            }
        }
    }

    public final Bitmap b(o oVar, int i, int i2) {
        if (TextUtils.isEmpty(oVar.b)) {
            return null;
        }
        Bitmap bitmapA = a(oVar.b, i, i2);
        if (bitmapA != null && !bitmapA.isRecycled()) {
            return bitmapA;
        }
        Bitmap bitmapA2 = a(oVar, i, i2);
        if (bitmapA2 == null || bitmapA2.isRecycled()) {
            return null;
        }
        a(oVar.b, bitmapA2, i, i2);
        return bitmapA2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(String str, Bitmap bitmap, int i, int i2) {
        Object objPut;
        if (a(str, i, i2) == null) {
            i iVar = this.b;
            com.smartdigimkt.k3.a aVar = new com.smartdigimkt.k3.a(bitmap, i, i2);
            iVar.getClass();
            synchronized (iVar) {
                iVar.b += iVar.a(str, aVar);
                objPut = iVar.a.put(str, aVar);
                if (objPut != null) {
                    iVar.b -= iVar.a(str, objPut);
                }
            }
            if (objPut != null) {
                iVar.a(str, objPut, aVar);
            }
            iVar.a(iVar.c);
        }
    }

    public final Bitmap a(String str, int i, int i2) {
        Object obj;
        Bitmap bitmap;
        i iVar = this.b;
        if (str != null) {
            synchronized (iVar) {
                obj = iVar.a.get(str);
                if (obj != null) {
                    iVar.d++;
                } else {
                    iVar.e++;
                    obj = null;
                }
            }
            com.smartdigimkt.k3.a aVar = (com.smartdigimkt.k3.a) obj;
            if (aVar == null || (bitmap = (Bitmap) aVar.a.get()) == null) {
                return null;
            }
            if (!aVar.b) {
                if (i <= 0 || i2 <= 0) {
                    return null;
                }
                if (bitmap.getWidth() <= i / 2 && bitmap.getHeight() <= i2 / 2) {
                    return null;
                }
            }
            return bitmap;
        }
        iVar.getClass();
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #5 {all -> 0x002f, blocks: (B:9:0x0015, B:11:0x0023), top: B:50:0x0015 }] */
    public final Bitmap a(o oVar, int i, int i2) {
        Bitmap bitmapDecodeFileDescriptor = null;
        if (oVar == null || TextUtils.isEmpty(oVar.b)) {
            return null;
        }
        String strB = com.smartdigimkt.r4.i.b(oVar.b);
        if (i <= 0) {
            try {
                i = this.d.getResources().getDisplayMetrics().widthPixels;
                if (i2 <= 0) {
                    i2 = this.d.getResources().getDisplayMetrics().heightPixels;
                }
            } catch (Throwable unused) {
            }
        } else if (i2 <= 0) {
            i2 = this.d.getResources().getDisplayMetrics().heightPixels;
        }
        synchronized (this.c) {
            FileInputStream fileInputStreamA = n.a().a(oVar.a, strB);
            if (fileInputStreamA == null) {
                return null;
            }
            try {
                FileDescriptor fd = fileInputStreamA.getFD();
                try {
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        int i3 = 1;
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFileDescriptor(fd, null, options);
                        int i4 = options.outWidth;
                        int i5 = options.outHeight;
                        if (i > 0 || i2 > 0) {
                            while (i4 / i3 > i && i5 / i3 > i2) {
                                i3 *= 2;
                            }
                        }
                        options.inSampleSize = i3;
                        options.inJustDecodeBounds = false;
                        bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fd, null, options);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                }
            } catch (Throwable unused2) {
            }
            try {
                fileInputStreamA.close();
            } catch (Exception unused3) {
            }
            return bitmapDecodeFileDescriptor;
        }
    }

    public static m a(Context context) {
        if (f == null) {
            synchronized (m.class) {
                if (f == null) {
                    f = new m(context);
                }
            }
        }
        return f;
    }

    public final void a(o oVar, int i, int i2, l lVar) {
        if (TextUtils.isEmpty(oVar.b)) {
            if (lVar != null) {
                lVar.a();
                return;
            }
            return;
        }
        Bitmap bitmapA = a(oVar.b, i, i2);
        if (bitmapA == null || bitmapA.isRecycled()) {
            com.smartdigimkt.q3.f.a().c(new j(this, oVar, i, i2, lVar));
        } else if (lVar != null) {
            lVar.a(oVar.b, bitmapA);
        }
    }
}
