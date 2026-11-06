package com.tapsdk.tapad.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bykv.vk.component.ttvideo.player.C;
import com.tapsdk.tapad.a;
import com.tapsdk.tapad.c;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class TapADFileProvider extends ContentProvider {
    private static final String[] DEFAULT_PROJECTION = {"_display_name", "_size"};
    private String authority;
    private volatile RootStrategy strategy;

    public static final class RootStrategy {
        private final LinkedHashMap<String, File> roots = new LinkedHashMap<>();

        private RootStrategy() {
        }

        private void addRoot(String str, File file) {
            if (file == null) {
                return;
            }
            try {
                this.roots.put(str, file.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException(c.a("Unable to canonicalize root ", str), e);
            }
        }

        private static boolean contains(File file, File file2) {
            String path = file.getPath();
            String path2 = file2.getPath();
            if (path2.equals(path)) {
                return true;
            }
            String str = File.separator;
            if (!path.endsWith(str)) {
                path = a.a(path, str);
            }
            return path2.startsWith(path);
        }

        public static RootStrategy create(Context context) {
            RootStrategy rootStrategy = new RootStrategy();
            rootStrategy.addRoot("external_files", context.getExternalFilesDir(null));
            rootStrategy.addRoot("external_cache", context.getExternalCacheDir());
            rootStrategy.addRoot("external_root", Environment.getExternalStorageDirectory());
            rootStrategy.addRoot("internal_files", context.getFilesDir());
            rootStrategy.addRoot("internal_cache", context.getCacheDir());
            return rootStrategy;
        }

        public File fileForUri(Uri uri) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() < 2) {
                throw new SecurityException("Malformed file URI");
            }
            File file = this.roots.get(pathSegments.get(0));
            if (file == null) {
                throw new SecurityException("Unknown file root");
            }
            int i = 1;
            File file2 = file;
            while (i < pathSegments.size()) {
                File file3 = new File(file2, pathSegments.get(i));
                i++;
                file2 = file3;
            }
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (contains(file, canonicalFile)) {
                    return canonicalFile;
                }
                throw new SecurityException("Path escapes configured root");
            } catch (IOException e) {
                throw new SecurityException("Unable to canonicalize URI path", e);
            }
        }

        public Uri uriForFile(String str, File file) {
            try {
                File canonicalFile = file.getCanonicalFile();
                if (!canonicalFile.isFile()) {
                    throw new IllegalArgumentException("Only existing regular files can be shared");
                }
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.roots.entrySet()) {
                    if (contains(entry2.getValue(), canonicalFile) && (entry == null || entry2.getValue().getPath().length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("File is outside configured roots");
                }
                String strSubstring = canonicalFile.getPath().substring(entry.getValue().getPath().length());
                if (strSubstring.startsWith(File.separator)) {
                    strSubstring = strSubstring.substring(1);
                }
                Uri.Builder builderAppendPath = new Uri.Builder().scheme("content").authority(str).appendPath(entry.getKey());
                if (!strSubstring.isEmpty()) {
                    for (String str2 : strSubstring.split("/")) {
                        builderAppendPath.appendPath(str2);
                    }
                }
                return builderAppendPath.build();
            } catch (IOException e) {
                throw new IllegalArgumentException("Unable to canonicalize file", e);
            }
        }
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        if (context == null) {
            throw new NullPointerException(d.R);
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("authority is empty");
        }
        if (file != null) {
            return RootStrategy.create(context).uriForFile(str, file);
        }
        throw new NullPointerException("file");
    }

    private Uri requireAuthority(Uri uri) {
        if (uri != null && "content".equals(uri.getScheme()) && this.authority.equals(uri.getAuthority())) {
            return uri;
        }
        throw new SecurityException("URI does not belong to TapADFileProvider");
    }

    private RootStrategy requireStrategy() {
        RootStrategy rootStrategy = this.strategy;
        if (rootStrategy != null) {
            return rootStrategy;
        }
        throw new IllegalStateException("Provider is not attached");
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo == null || TextUtils.isEmpty(providerInfo.authority)) {
            throw new IllegalArgumentException("TapADFileProvider requires one authority");
        }
        if (providerInfo.exported) {
            throw new SecurityException("TapADFileProvider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("TapADFileProvider must grant URI permissions");
        }
        this.authority = providerInfo.authority;
        this.strategy = RootStrategy.create(context);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("TapADFileProvider is read-only");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int i;
        String mimeTypeFromExtension;
        String name = requireStrategy().fileForUri(requireAuthority(uri)).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return (iLastIndexOf < 0 || (i = iLastIndexOf + 1) >= name.length() || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(i).toLowerCase(Locale.ROOT))) == null) ? "application/octet-stream" : mimeTypeFromExtension;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("TapADFileProvider is read-only");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        if (!"r".equals(str)) {
            throw new SecurityException("TapADFileProvider is read-only");
        }
        File fileFileForUri = requireStrategy().fileForUri(requireAuthority(uri));
        if (fileFileForUri.isFile() && fileFileForUri.canRead()) {
            return ParcelFileDescriptor.open(fileFileForUri, C.ENCODING_PCM_MU_LAW);
        }
        throw new FileNotFoundException("File is not readable: " + fileFileForUri);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        File fileFileForUri = requireStrategy().fileForUri(requireAuthority(uri));
        if (strArr == null) {
            strArr = DEFAULT_PROJECTION;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i] = "_display_name";
                objArr[i] = fileFileForUri.getName();
                i++;
            } else if ("_size".equals(str3)) {
                strArr3[i] = "_size";
                objArr[i] = Long.valueOf(fileFileForUri.length());
                i++;
            }
        }
        String[] strArr4 = new String[i];
        Object[] objArr2 = new Object[i];
        System.arraycopy(strArr3, 0, strArr4, 0, i);
        System.arraycopy(objArr, 0, objArr2, 0, i);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("TapADFileProvider is read-only");
    }
}
