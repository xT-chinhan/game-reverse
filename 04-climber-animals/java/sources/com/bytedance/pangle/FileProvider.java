package com.bytedance.pangle;

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
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.kuaishou.weapon.p0.t;
import com.taptap.sdk.db.constant.Common;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class FileProvider extends ContentProvider {
    private static ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String[] f602ms = {"_display_name", "_size"};
    private static final File xr = new File("/");

    interface ms {
        Uri ms(File file);

        File ms(Uri uri);
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
        if (ah != null) {
            throw new SecurityException("仅允许定义一个FileProvider");
        }
        ah = new xr(providerInfo.authority);
    }

    public static Uri getUriForFile(File file) {
        return ah.ms(file);
    }

    public static void ms(Plugin plugin, XmlResourceParser xmlResourceParser) {
        try {
            ms(plugin.mPkgName, ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), plugin.mPkgName), (xr) ah, xmlResourceParser);
        } catch (IOException | XmlPullParserException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File fileMs = ah.ms(uri);
        if (strArr == null) {
            strArr = f602ms;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileMs.getName();
            } else {
                if ("_size".equals(str3)) {
                    strArr3[i2] = "_size";
                    i = i2 + 1;
                    objArr[i2] = Long.valueOf(fileMs.length());
                }
            }
            i2 = i;
        }
        String[] strArrMs = ms(strArr3, i2);
        Object[] objArrMs = ms(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArrMs, 1);
        matrixCursor.addRow(objArrMs);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileMs = ah.ms(uri);
        int iLastIndexOf = fileMs.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileMs.getName().substring(iLastIndexOf + 1));
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
        return ah.ms(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(ah.ms(uri), ms(str));
    }

    private static void ms(String str, Context context, xr xrVar, XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlResourceParser.getName();
                File cacheDir = null;
                String attributeValue = xmlResourceParser.getAttributeValue(null, Common.System.NAME);
                String attributeValue2 = xmlResourceParser.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    cacheDir = xr;
                } else if ("files-path".equals(name)) {
                    cacheDir = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    cacheDir = context.getCacheDir();
                } else if ("external-files-path".equals(name)) {
                    File[] fileArrMs = ms(context, (String) null);
                    if (fileArrMs.length > 0) {
                        cacheDir = fileArrMs[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] fileArrMs2 = ms(context);
                    if (fileArrMs2.length > 0) {
                        cacheDir = fileArrMs2[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        cacheDir = externalMediaDirs[0];
                    }
                }
                if (cacheDir != null) {
                    xrVar.ms(str + "_" + attributeValue, ms(cacheDir, attributeValue2));
                }
            }
        }
    }

    public static File[] ms(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File[] ms(Context context) {
        return context.getExternalCacheDirs();
    }

    static class xr implements ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final String f603ms;
        private final HashMap<String, File> xr = new HashMap<>();

        xr(String str) {
            this.f603ms = str;
        }

        void ms(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.xr.put(str, file.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)), e);
            }
        }

        @Override // com.bytedance.pangle.FileProvider.ms
        public Uri ms(File file) {
            String strSubstring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.xr.entrySet()) {
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
                return new Uri.Builder().scheme("content").authority(this.f603ms).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(strSubstring, "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.pangle.FileProvider.ms
        public File ms(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.xr.get(strDecode);
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

    private static int ms(String str) {
        if (t.k.equals(str)) {
            return C.ENCODING_PCM_MU_LAW;
        }
        if (IAdInterListener.AdReqParam.WIDTH.equals(str) || "wt".equals(str)) {
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

    private static File ms(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] ms(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static Object[] ms(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
