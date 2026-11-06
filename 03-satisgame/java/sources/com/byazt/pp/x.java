package com.byazt.pp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import com.anythink.core.common.d.i;
import com.byazt.ur.wm;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 21})
public class x {
    public static final Map<String, sz<w>> n = new HashMap();
    public static final Set<Object> qg = new HashSet();
    public static final byte[] s = {80, 75, 3, 4};

    public static void n(int i) {
        com.byazt.ld.w.n().n(i);
    }

    public static sz<w> n(Context context, String str) {
        return n(context, str, str);
    }

    public static sz<w> n(final Context context, final String str, final String str2) {
        return n(str2, new Callable<oa<w>>() { // from class: com.byazt.pp.x.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public oa<w> call() throws Exception {
                oa<w> oaVarN = l.n(context).n(context, str, str2);
                if (str2 != null && oaVarN.n() != null) {
                    com.byazt.ld.w.n().n(str2, oaVarN.n());
                }
                return oaVarN;
            }
        });
    }

    public static sz<w> qg(Context context, String str) {
        return qg(context, str, "asset_" + str);
    }

    public static sz<w> qg(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return n(str2, new Callable<oa<w>>() { // from class: com.byazt.pp.x.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public oa<w> call() throws Exception {
                return x.s(applicationContext, str, str2);
            }
        });
    }

    public static oa<w> s(Context context, String str) {
        return s(context, str, "asset_" + str);
    }

    public static oa<w> s(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return qg(context.getAssets().open(str), str2);
            }
            return n(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new oa<>((Throwable) e);
        }
    }

    public static sz<w> n(Context context, int i) {
        return n(context, i, s(context, i));
    }

    public static sz<w> n(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return n(str, new Callable<oa<w>>() { // from class: com.byazt.pp.x.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public oa<w> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return x.qg(context2, i, str);
            }
        });
    }

    public static oa<w> qg(Context context, int i) {
        return qg(context, i, s(context, i));
    }

    public static oa<w> qg(Context context, int i, String str) {
        try {
            return qg(context.getResources().openRawResource(i), s(context, i));
        } catch (Resources.NotFoundException e) {
            return new oa<>((Throwable) e);
        }
    }

    private static String s(Context context, int i) {
        return "rawRes" + (n(context) ? "_night_" : "_day_") + i;
    }

    private static boolean n(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static sz<w> n(final InputStream inputStream, final String str) {
        return n(str, new Callable<oa<w>>() { // from class: com.byazt.pp.x.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public oa<w> call() throws Exception {
                return x.qg(inputStream, str);
            }
        });
    }

    public static oa<w> qg(InputStream inputStream, String str) {
        return n(inputStream, str, true);
    }

    private static oa<w> n(InputStream inputStream, String str, boolean z) {
        try {
            return n(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.byazt.nu.tj.n(inputStream);
            }
        }
    }

    public static sz<w> n(final String str, final String str2) {
        return n(str2, new Callable<oa<w>>() { // from class: com.byazt.pp.x.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public oa<w> call() throws Exception {
                return x.qg(str, str2);
            }
        });
    }

    public static oa<w> qg(String str, String str2) {
        new ByteArrayInputStream(str.getBytes());
        return n(new JsonReader(new StringReader(str)), str2);
    }

    public static oa<w> n(JsonReader jsonReader, String str) {
        return n(jsonReader, str, true);
    }

    private static oa<w> n(JsonReader jsonReader, String str, boolean z) {
        try {
            w wVarN = wm.n(jsonReader);
            com.byazt.ld.w.n().n(str, wVarN);
            return new oa<>(wVarN);
        } catch (Exception e) {
            return new oa<>((Throwable) e);
        } finally {
            if (z) {
                n(jsonReader);
            }
        }
    }

    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static oa<w> n(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return qg(context, zipInputStream, str);
        } finally {
            com.byazt.nu.tj.n(zipInputStream);
        }
    }

    private static oa<w> qg(Context context, ZipInputStream zipInputStream, String str) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            w wVarN = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    wVarN = n(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).n();
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
                        File file = new File(com.byazt.qyu.qg.s(context), str2);
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
                                    com.byazt.nu.w.qg("Failed to delete temp font file " + file.getAbsolutePath() + i.E);
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
                            com.byazt.nu.w.n("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th4);
                        }
                    }
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (wVarN == null) {
                return new oa<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                rv rvVarN = n(wVarN, (String) entry.getKey());
                if (rvVarN != null) {
                    rvVarN.n(com.byazt.nu.tj.n((Bitmap) entry.getValue(), rvVarN.n(), rvVarN.qg()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z = false;
                for (com.byazt.ld.s sVar : wVarN.cy().values()) {
                    if (sVar.n().equals(entry2.getKey())) {
                        sVar.n((Typeface) entry2.getValue());
                        z = true;
                    }
                }
                if (!z) {
                    com.byazt.nu.w.qg("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (map.isEmpty()) {
                Iterator<Map.Entry<String, rv>> it = wVarN.hd().entrySet().iterator();
                while (it.hasNext()) {
                    rv value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String strOa = value.oa();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strOa.startsWith("data:") && strOa.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strOa.substring(strOa.indexOf(44) + 1), 0);
                            value.n(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException e) {
                            com.byazt.nu.w.n("data URL did not have correct base64 format.", e);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, rv> entry3 : wVarN.hd().entrySet()) {
                if (entry3.getValue().k() == null) {
                    return new oa<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().oa()));
                }
            }
            if (str != null) {
                com.byazt.ld.w.n().n(str, wVarN);
            }
            return new oa<>(wVarN);
        } catch (IOException e2) {
            return new oa<>((Throwable) e2);
        }
    }

    private static rv n(w wVar, String str) {
        for (rv rvVar : wVar.hd().values()) {
            if (rvVar.oa().equals(str)) {
                return rvVar;
            }
        }
        return null;
    }

    private static sz<w> n(final String str, Callable<oa<w>> callable) {
        final w wVarN = str == null ? null : com.byazt.ld.w.n().n(str);
        if (wVarN != null) {
            return new sz<>(new Callable<oa<w>>() { // from class: com.byazt.pp.x.8
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public oa<w> call() throws Exception {
                    return new oa<>(wVarN);
                }
            });
        }
        if (str != null) {
            Map<String, sz<w>> map = n;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        sz<w> szVar = new sz<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            szVar.n(new tj<w>() { // from class: com.byazt.pp.x.2
                @Override // com.byazt.pp.tj
                public void n(w wVar) {
                    x.n.remove(str);
                    atomicBoolean.set(true);
                    if (x.n.size() == 0) {
                        x.qg(true);
                    }
                }
            });
            szVar.s(new tj<Throwable>() { // from class: com.byazt.pp.x.3
                @Override // com.byazt.pp.tj
                public void n(Throwable th) {
                    x.n.remove(str);
                    atomicBoolean.set(true);
                    if (x.n.size() == 0) {
                        x.qg(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, sz<w>> map2 = n;
                map2.put(str, szVar);
                if (map2.size() == 1) {
                    qg(false);
                }
            }
        }
        return szVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(boolean z) {
        ArrayList arrayList = new ArrayList(qg);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
