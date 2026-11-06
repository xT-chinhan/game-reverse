package com.byazt.dx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import com.byazt.tx.fo;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, 62})
public class fw {
    public static final Map<String, g<uc>> pr = new HashMap();
    public static final Set<Object> hw = new HashSet();
    public static final byte[] hn = {80, 75, 3, 4};

    public static void pr(int i) {
        com.byazt.uxi.uc.pr().pr(i);
    }

    public static g<uc> pr(Context context, String str) {
        return pr(context, str, str);
    }

    public static g<uc> pr(final Context context, final String str, final String str2) {
        return pr(str2, new Callable<m<uc>>() { // from class: com.byazt.dx.fw.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public m<uc> call() throws Exception {
                m<uc> mVarPr = c.pr(context).pr(context, str, str2);
                if (str2 != null && mVarPr.pr() != null) {
                    com.byazt.uxi.uc.pr().pr(str2, mVarPr.pr());
                }
                return mVarPr;
            }
        });
    }

    public static g<uc> hw(Context context, String str) {
        return hw(context, str, "asset_" + str);
    }

    public static g<uc> hw(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return pr(str2, new Callable<m<uc>>() { // from class: com.byazt.dx.fw.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public m<uc> call() throws Exception {
                return fw.hn(applicationContext, str, str2);
            }
        });
    }

    public static m<uc> hn(Context context, String str) {
        return hn(context, str, "asset_" + str);
    }

    public static m<uc> hn(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return hw(context.getAssets().open(str), str2);
            }
            return pr(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new m<>((Throwable) e);
        }
    }

    public static g<uc> pr(Context context, int i) {
        return pr(context, i, hn(context, i));
    }

    public static g<uc> pr(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return pr(str, new Callable<m<uc>>() { // from class: com.byazt.dx.fw.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public m<uc> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return fw.hw(context2, i, str);
            }
        });
    }

    public static m<uc> hw(Context context, int i) {
        return hw(context, i, hn(context, i));
    }

    public static m<uc> hw(Context context, int i, String str) {
        try {
            return hw(context.getResources().openRawResource(i), hn(context, i));
        } catch (Resources.NotFoundException e) {
            return new m<>((Throwable) e);
        }
    }

    private static String hn(Context context, int i) {
        return "rawRes" + (pr(context) ? "_night_" : "_day_") + i;
    }

    private static boolean pr(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static g<uc> pr(final InputStream inputStream, final String str) {
        return pr(str, new Callable<m<uc>>() { // from class: com.byazt.dx.fw.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public m<uc> call() throws Exception {
                return fw.hw(inputStream, str);
            }
        });
    }

    public static m<uc> hw(InputStream inputStream, String str) {
        return pr(inputStream, str, true);
    }

    private static m<uc> pr(InputStream inputStream, String str, boolean z) {
        try {
            return pr(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.byazt.ptr.vk.pr(inputStream);
            }
        }
    }

    public static m<uc> pr(JsonReader jsonReader, String str) {
        return pr(jsonReader, str, true);
    }

    private static m<uc> pr(JsonReader jsonReader, String str, boolean z) {
        try {
            uc ucVarPr = fo.pr(jsonReader);
            com.byazt.uxi.uc.pr().pr(str, ucVarPr);
            return new m<>(ucVarPr);
        } catch (Exception e) {
            return new m<>((Throwable) e);
        } finally {
            if (z) {
                pr(jsonReader);
            }
        }
    }

    public static void pr(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static m<uc> pr(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return hw(context, zipInputStream, str);
        } finally {
            com.byazt.ptr.vk.pr(zipInputStream);
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0112 A[Catch: IOException -> 0x02c5, TryCatch #2 {IOException -> 0x02c5, blocks: (B:3:0x000b, B:6:0x0015, B:8:0x0021, B:62:0x0151, B:9:0x0026, B:11:0x0032, B:12:0x0037, B:14:0x0043, B:15:0x005a, B:18:0x0066, B:20:0x006e, B:22:0x0076, B:25:0x0080, B:27:0x0088, B:30:0x0091, B:31:0x0096, B:33:0x009c, B:34:0x00a5, B:54:0x0108, B:56:0x0112, B:57:0x012e, B:53:0x00e6, B:58:0x0132, B:60:0x0138, B:61:0x0141, B:35:0x00be, B:42:0x00d5, B:51:0x00e4, B:50:0x00e1), top: B:126:0x000b, inners: #3 }] */
    private static m<uc> hw(Context context, ZipInputStream zipInputStream, String str) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            uc ucVarPr = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    ucVarPr = pr(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).pr();
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
                        File file = new File(com.byazt.mg.hw.hw(context), str2);
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
                            com.byazt.ptr.uc.pr("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th4);
                            Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                com.byazt.ptr.uc.hw("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                            }
                            map2.put(str3, typefaceCreateFromFile);
                            nextEntry = zipInputStream.getNextEntry();
                        }
                        Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            com.byazt.ptr.uc.hw("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                        }
                        map2.put(str3, typefaceCreateFromFile2);
                    }
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (ucVarPr == null) {
                return new m<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                aj ajVarPr = pr(ucVarPr, (String) entry.getKey());
                if (ajVarPr != null) {
                    ajVarPr.pr(com.byazt.ptr.vk.pr((Bitmap) entry.getValue(), ajVarPr.pr(), ajVarPr.hw()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z = false;
                for (com.byazt.uxi.hn hnVar : ucVarPr.nt().values()) {
                    if (hnVar.pr().equals(entry2.getKey())) {
                        hnVar.pr((Typeface) entry2.getValue());
                        z = true;
                    }
                }
                if (!z) {
                    com.byazt.ptr.uc.hw("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (map.isEmpty()) {
                Iterator<Map.Entry<String, aj>> it = ucVarPr.yb().entrySet().iterator();
                while (it.hasNext()) {
                    aj value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String strM = value.m();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strM.startsWith("data:") && strM.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strM.substring(strM.indexOf(44) + 1), 0);
                            value.pr(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException e) {
                            com.byazt.ptr.uc.pr("data URL did not have correct base64 format.", e);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, aj> entry3 : ucVarPr.yb().entrySet()) {
                if (entry3.getValue().ho() == null) {
                    return new m<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().m()));
                }
            }
            if (str != null) {
                com.byazt.uxi.uc.pr().pr(str, ucVarPr);
            }
            return new m<>(ucVarPr);
        } catch (IOException e2) {
            return new m<>((Throwable) e2);
        }
    }

    private static aj pr(uc ucVar, String str) {
        for (aj ajVar : ucVar.yb().values()) {
            if (ajVar.m().equals(str)) {
                return ajVar;
            }
        }
        return null;
    }

    private static g<uc> pr(final String str, Callable<m<uc>> callable) {
        final uc ucVarPr = str == null ? null : com.byazt.uxi.uc.pr().pr(str);
        if (ucVarPr != null) {
            return new g<>(new Callable<m<uc>>() { // from class: com.byazt.dx.fw.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public m<uc> call() throws Exception {
                    return new m<>(ucVarPr);
                }
            });
        }
        if (str != null) {
            Map<String, g<uc>> map = pr;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        g<uc> gVar = new g<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            gVar.pr(new vk<uc>() { // from class: com.byazt.dx.fw.2
                @Override // com.byazt.dx.vk
                public void pr(uc ucVar) {
                    fw.pr.remove(str);
                    atomicBoolean.set(true);
                    if (fw.pr.size() == 0) {
                        fw.hw(true);
                    }
                }
            });
            gVar.hn(new vk<Throwable>() { // from class: com.byazt.dx.fw.3
                @Override // com.byazt.dx.vk
                public void pr(Throwable th) {
                    fw.pr.remove(str);
                    atomicBoolean.set(true);
                    if (fw.pr.size() == 0) {
                        fw.hw(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, g<uc>> map2 = pr;
                map2.put(str, gVar);
                if (map2.size() == 1) {
                    hw(false);
                }
            }
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(boolean z) {
        ArrayList arrayList = new ArrayList(hw);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
