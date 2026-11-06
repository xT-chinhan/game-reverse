package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import com.anythink.core.common.d.j;
import com.bytedance.adsdk.lottie.d.re;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Map<String, zb<c>> f130ms = new HashMap();
    private static final Set<Object> xr = new HashSet();
    private static final byte[] ah = {80, 75, 3, 4};

    public static zb<c> ms(Context context, String str) {
        return ms(context, str, "url_" + str);
    }

    public static zb<c> ms(final Context context, final String str, final String str2) {
        return ms(str2, new Callable<sl<c>>() { // from class: com.bytedance.adsdk.lottie.ab.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public sl<c> call() throws Exception {
                sl<c> slVarMs = ka.ms(context).ms(context, str, str2);
                if (str2 != null && slVarMs.ms() != null) {
                    com.bytedance.adsdk.lottie.model.ka.ms().ms(str2, slVarMs.ms());
                }
                return slVarMs;
            }
        });
    }

    public static zb<c> xr(Context context, String str) {
        return xr(context, str, "asset_" + str);
    }

    public static zb<c> xr(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return ms(str2, new Callable<sl<c>>() { // from class: com.bytedance.adsdk.lottie.ab.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public sl<c> call() throws Exception {
                return ab.ah(applicationContext, str, str2);
            }
        });
    }

    public static sl<c> ah(Context context, String str) {
        return ah(context, str, "asset_" + str);
    }

    public static sl<c> ah(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return xr(context.getAssets().open(str), str2);
            }
            return ms(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new sl<>((Throwable) e);
        }
    }

    public static zb<c> ms(Context context, int i) {
        return ms(context, i, ah(context, i));
    }

    public static zb<c> ms(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return ms(str, new Callable<sl<c>>() { // from class: com.bytedance.adsdk.lottie.ab.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public sl<c> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return ab.xr(context2, i, str);
            }
        });
    }

    public static sl<c> xr(Context context, int i) {
        return xr(context, i, ah(context, i));
    }

    public static sl<c> xr(Context context, int i, String str) {
        try {
            return xr(context.getResources().openRawResource(i), ah(context, i));
        } catch (Resources.NotFoundException e) {
            return new sl<>((Throwable) e);
        }
    }

    private static String ah(Context context, int i) {
        return "rawRes" + (ms(context) ? "_night_" : "_day_") + i;
    }

    private static boolean ms(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static zb<c> ms(final InputStream inputStream, final String str) {
        return ms(str, new Callable<sl<c>>() { // from class: com.bytedance.adsdk.lottie.ab.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public sl<c> call() throws Exception {
                return ab.xr(inputStream, str);
            }
        });
    }

    public static sl<c> xr(InputStream inputStream, String str) {
        return ms(inputStream, str, true);
    }

    private static sl<c> ms(InputStream inputStream, String str, boolean z) {
        try {
            return ms(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.bytedance.adsdk.lottie.ka.ny.ms(inputStream);
            }
        }
    }

    public static sl<c> ms(JsonReader jsonReader, String str) {
        return ms(jsonReader, str, true);
    }

    private static sl<c> ms(JsonReader jsonReader, String str, boolean z) {
        try {
            c cVarMs = re.ms(jsonReader);
            com.bytedance.adsdk.lottie.model.ka.ms().ms(str, cVarMs);
            return new sl<>(cVarMs);
        } catch (Exception e) {
            return new sl<>((Throwable) e);
        } finally {
            if (z) {
                ms(jsonReader);
            }
        }
    }

    public static void ms(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static sl<c> ms(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return xr(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.lottie.ka.ny.ms(zipInputStream);
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0116 A[Catch: IOException -> 0x02c2, TryCatch #3 {IOException -> 0x02c2, blocks: (B:3:0x000a, B:6:0x0014, B:8:0x0020, B:62:0x0154, B:9:0x0025, B:11:0x0031, B:12:0x0036, B:14:0x0042, B:15:0x0059, B:18:0x0065, B:20:0x006d, B:22:0x0075, B:25:0x007f, B:27:0x0087, B:30:0x0090, B:31:0x0095, B:33:0x009b, B:34:0x00a4, B:54:0x010c, B:56:0x0116, B:57:0x0132, B:53:0x00ea, B:58:0x0136, B:60:0x013c, B:61:0x0145, B:35:0x00c2, B:42:0x00d9, B:51:0x00e8, B:50:0x00e5, B:47:0x00e0, B:37:0x00c9, B:38:0x00cb, B:40:0x00d2, B:41:0x00d6, B:45:0x00de), top: B:121:0x000a, inners: #2 }] */
    private static sl<c> xr(Context context, ZipInputStream zipInputStream, String str) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            c cVarMs = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    cVarMs = ms(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).ms();
                } else if (name.endsWith(".png") || name.endsWith(".webp") || name.endsWith(".jpg") || name.endsWith(".jpeg")) {
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit = name.split("/");
                        map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                } else if (name.endsWith(".ttf") || name.endsWith(".otf")) {
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit2 = name.split("/");
                        String str2 = strArrSplit2[strArrSplit2.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context), str2);
                        new FileOutputStream(file);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i = zipInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                                if (!file.delete()) {
                                    com.bytedance.adsdk.lottie.ka.ka.xr("Failed to delete temp font file " + file.getAbsolutePath() + j.z);
                                }
                                map2.put(str3, typefaceCreateFromFile);
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable th4) {
                            com.bytedance.adsdk.lottie.ka.ka.ms("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th4);
                            Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                com.bytedance.adsdk.lottie.ka.ka.xr("Failed to delete temp font file " + file.getAbsolutePath() + j.z);
                            }
                            map2.put(str3, typefaceCreateFromFile2);
                            nextEntry = zipInputStream.getNextEntry();
                        }
                    }
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (cVarMs == null) {
                return new sl<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                ny nyVarMs = ms(cVarMs, (String) entry.getKey());
                if (nyVarMs != null) {
                    nyVarMs.ms(com.bytedance.adsdk.lottie.ka.ny.ms((Bitmap) entry.getValue(), nyVarMs.ms(), nyVarMs.xr()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z = false;
                for (com.bytedance.adsdk.lottie.model.ah ahVar : cVarMs.ao().values()) {
                    if (ahVar.ms().equals(entry2.getKey())) {
                        ahVar.ms((Typeface) entry2.getValue());
                        z = true;
                    }
                }
                if (!z) {
                    com.bytedance.adsdk.lottie.ka.ka.xr("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (map.isEmpty()) {
                Iterator<Map.Entry<String, ny>> it = cVarMs.h().entrySet().iterator();
                while (it.hasNext()) {
                    ny value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String strSl = value.sl();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strSl.startsWith("data:") && strSl.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strSl.substring(strSl.indexOf(44) + 1), 0);
                            value.ms(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException e) {
                            com.bytedance.adsdk.lottie.ka.ka.ms("data URL did not have correct base64 format.", e);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, ny> entry3 : cVarMs.h().entrySet()) {
                if (entry3.getValue().u() == null) {
                    return new sl<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().sl()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.lottie.model.ka.ms().ms(str, cVarMs);
            }
            return new sl<>(cVarMs);
        } catch (IOException e2) {
            return new sl<>((Throwable) e2);
        }
    }

    private static ny ms(c cVar, String str) {
        for (ny nyVar : cVar.h().values()) {
            if (nyVar.sl().equals(str)) {
                return nyVar;
            }
        }
        return null;
    }

    private static zb<c> ms(final String str, Callable<sl<c>> callable) {
        final c cVarMs = str == null ? null : com.bytedance.adsdk.lottie.model.ka.ms().ms(str);
        if (cVarMs != null) {
            return new zb<>(new Callable<sl<c>>() { // from class: com.bytedance.adsdk.lottie.ab.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public sl<c> call() throws Exception {
                    return new sl<>(cVarMs);
                }
            });
        }
        if (str != null) {
            Map<String, zb<c>> map = f130ms;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        zb<c> zbVar = new zb<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            zbVar.ms(new ch<c>() { // from class: com.bytedance.adsdk.lottie.ab.2
                @Override // com.bytedance.adsdk.lottie.ch
                public void ms(c cVar) {
                    ab.f130ms.remove(str);
                    atomicBoolean.set(true);
                    if (ab.f130ms.size() == 0) {
                        ab.xr(true);
                    }
                }
            });
            zbVar.ah(new ch<Throwable>() { // from class: com.bytedance.adsdk.lottie.ab.3
                @Override // com.bytedance.adsdk.lottie.ch
                public void ms(Throwable th) {
                    ab.f130ms.remove(str);
                    atomicBoolean.set(true);
                    if (ab.f130ms.size() == 0) {
                        ab.xr(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, zb<c>> map2 = f130ms;
                map2.put(str, zbVar);
                if (map2.size() == 1) {
                    xr(false);
                }
            }
        }
        return zbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(boolean z) {
        ArrayList arrayList = new ArrayList(xr);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
