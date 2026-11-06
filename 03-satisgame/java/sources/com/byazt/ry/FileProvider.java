package com.byazt.ry;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.anythink.core.common.k;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, 1398})
public class FileProvider extends ContentProvider {
    public static final String[] n = {"_display_name", "_size"};
    public static final File qg = new File("/");
    public static n s;

    interface n {
        Uri n(File file);

        File n(Uri uri);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        if (s != null) {
            throw new SecurityException("仅允许定义一个FileProvider");
        }
        s = new qg(providerInfo.authority);
    }

    public static Uri getUriForFile(File file) {
        return s.n(file);
    }

    public static void n(Plugin plugin, XmlResourceParser xmlResourceParser) {
        try {
            n(plugin.mPkgName, ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), plugin.mPkgName), (qg) s, xmlResourceParser);
        } catch (IOException | XmlPullParserException e) {
            com.byazt.vx.w.n(e);
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File fileN = s.n(uri);
        if (strArr == null) {
            strArr = n;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileN.getName();
            } else {
                if ("_size".equals(str3)) {
                    strArr3[i2] = "_size";
                    i = i2 + 1;
                    objArr[i2] = Long.valueOf(fileN.length());
                }
            }
            i2 = i;
        }
        String[] strArrN = n(strArr3, i2);
        Object[] objArrN = n(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArrN, 1);
        matrixCursor.addRow(objArrN);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileN = s.n(uri);
        int iLastIndexOf = fileN.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileN.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return s.n(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(s.n(uri), n(str));
    }

    private static void n(String str, Context context, qg qgVar, XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlResourceParser.getName();
                File cacheDir = null;
                String attributeValue = xmlResourceParser.getAttributeValue(null, TapEventParamConstants.PARAM_NAME);
                String attributeValue2 = xmlResourceParser.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    cacheDir = qg;
                } else if ("files-path".equals(name)) {
                    cacheDir = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    cacheDir = context.getCacheDir();
                } else if ("external-files-path".equals(name)) {
                    File[] fileArrN = n(context, (String) null);
                    if (fileArrN.length > 0) {
                        cacheDir = fileArrN[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] fileArrN2 = n(context);
                    if (fileArrN2.length > 0) {
                        cacheDir = fileArrN2[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        cacheDir = externalMediaDirs[0];
                    }
                }
                if (cacheDir != null) {
                    qgVar.n(str + "_" + attributeValue, n(cacheDir, attributeValue2));
                }
            }
        }
    }

    public static File[] n(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File[] n(Context context) {
        return context.getExternalCacheDirs();
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, 2356})
    static class qg implements n {
        public final String n;
        public final HashMap<String, File> qg = new HashMap<>();

        public qg(String str) {
            this.n = str;
        }

        public void n(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.qg.put(str, file.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)), e);
            }
        }

        @Override // com.byazt.ry.FileProvider.n
        public Uri n(File file) {
            String strSubstring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.qg.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(canonicalPath)));
                }
                String path2 = entry.getValue().getPath();
                if (path2.endsWith("/")) {
                    strSubstring = canonicalPath.substring(path2.length());
                } else {
                    strSubstring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme(k.D).authority(this.n).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(strSubstring, "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)));
            }
        }

        @Override // com.byazt.ry.FileProvider.n
        public File n(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.qg.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(uri)));
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file2)));
            }
        }
    }

    private static int n(String str) {
        if ("r".equals(str)) {
            return C.ENCODING_PCM_MU_LAW;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(str)));
    }

    private static File n(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] n(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static Object[] n(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
