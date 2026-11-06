package com.byazt.ae;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.taptap.sdk.db.constant.Common;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 592, 1258})
public class FileProvider extends ContentProvider {
    public static pr hn;
    public static final String[] pr = {"_display_name", "_size"};
    public static final File hw = new File("/");

    interface pr {
        Uri pr(File file);

        File pr(Uri uri);
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
        if (hn != null) {
            throw new SecurityException("仅允许定义一个FileProvider");
        }
        hn = new hw(providerInfo.authority);
    }

    public static Uri getUriForFile(File file) {
        return hn.pr(file);
    }

    public static void pr(Plugin plugin, XmlResourceParser xmlResourceParser) {
        try {
            pr(plugin.mPkgName, ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), plugin.mPkgName), (hw) hn, xmlResourceParser);
        } catch (IOException | XmlPullParserException e) {
            com.byazt.dea.uc.pr(e);
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        File filePr = hn.pr(uri);
        if (strArr == null) {
            strArr = pr;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i] = "_display_name";
                objArr[i] = filePr.getName();
                i++;
            } else if ("_size".equals(str3)) {
                strArr3[i] = "_size";
                objArr[i] = Long.valueOf(filePr.length());
                i++;
            }
        }
        String[] strArrPr = pr(strArr3, i);
        Object[] objArrPr = pr(objArr, i);
        MatrixCursor matrixCursor = new MatrixCursor(strArrPr, 1);
        matrixCursor.addRow(objArrPr);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File filePr = hn.pr(uri);
        int iLastIndexOf = filePr.getName().lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(filePr.getName().substring(iLastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
            return "application/octet-stream";
        }
        return "application/octet-stream";
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
        return hn.pr(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(hn.pr(uri), pr(str));
    }

    private static void pr(String str, Context context, hw hwVar, XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1) {
                if (next == 2) {
                    String name = xmlResourceParser.getName();
                    File cacheDir = null;
                    String attributeValue = xmlResourceParser.getAttributeValue(null, Common.System.NAME);
                    String attributeValue2 = xmlResourceParser.getAttributeValue(null, "path");
                    if ("root-path".equals(name)) {
                        cacheDir = hw;
                    } else if ("files-path".equals(name)) {
                        cacheDir = context.getFilesDir();
                    } else if ("cache-path".equals(name)) {
                        cacheDir = context.getCacheDir();
                    } else if ("external-files-path".equals(name)) {
                        File[] fileArrPr = pr(context, (String) null);
                        if (fileArrPr.length > 0) {
                            cacheDir = fileArrPr[0];
                        }
                    } else if ("external-cache-path".equals(name)) {
                        File[] fileArrPr2 = pr(context);
                        if (fileArrPr2.length > 0) {
                            cacheDir = fileArrPr2[0];
                        }
                    } else if (Build.VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                        File[] externalMediaDirs = context.getExternalMediaDirs();
                        if (externalMediaDirs.length > 0) {
                            cacheDir = externalMediaDirs[0];
                        }
                    }
                    if (cacheDir != null) {
                        hwVar.pr(str + "_" + attributeValue, pr(cacheDir, attributeValue2));
                    }
                }
            } else {
                return;
            }
        }
    }

    public static File[] pr(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(str) : new File[]{context.getExternalFilesDir(str)};
    }

    public static File[] pr(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()};
    }

    @com.byazt.vzx.pr(pr = {0, 1, 592, 2009})
    static class hw implements pr {
        public final HashMap<String, File> hw = new HashMap<>();
        public final String pr;

        public hw(String str) {
            this.pr = str;
        }

        public void pr(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.hw.put(str, file.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)), e);
            }
        }

        @Override // com.byazt.ae.FileProvider.pr
        public Uri pr(File file) {
            String strSubstring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.hw.entrySet()) {
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
                return new Uri.Builder().scheme("content").authority(this.pr).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(strSubstring, "/")).build();
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)));
            }
        }

        @Override // com.byazt.ae.FileProvider.pr
        public File pr(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.hw.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(uri)));
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (!canonicalFile.getPath().startsWith(file.getPath())) {
                    throw new SecurityException("Resolved path jumped beyond configured root");
                }
                return canonicalFile;
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file2)));
            }
        }
    }

    private static int pr(String str) {
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

    private static File pr(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] pr(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static Object[] pr(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
