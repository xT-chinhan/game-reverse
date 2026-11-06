package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.byazt.eyv.AdBaseConstants;
import com.tapsdk.tapad.internal.TapADFileProvider;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class IntentUtil {
    private static final String FILE_PROVIDER_AUTHORITY_SUFFIX = ".com.tds.ad.fileprovider";
    private static final String TAG = "IntentUtil";

    private static Uri buildContentUri(String str, File file) {
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.startsWith("/")) {
            absolutePath = absolutePath.substring(1);
        }
        return new Uri.Builder().scheme("content").authority(str).appendPath("external_files").appendEncodedPath(absolutePath).build();
    }

    public static boolean canOpenUri(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                boolean z = parcelFileDescriptorOpenFileDescriptor != null;
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return z;
                    } catch (IOException e) {
                    }
                }
                return z;
            } catch (Throwable th) {
                uri.toString();
                th.getMessage();
            }
        }
        return false;
    }

    public static String describeFile(File file) {
        String canonicalPath;
        if (file == null) {
            return AbstractJsonLexerKt.NULL;
        }
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (IOException e) {
            canonicalPath = "error:" + e.getMessage();
        }
        return "path=" + file.getAbsolutePath() + ", canonical=" + canonicalPath + ", exists=" + file.exists() + ", isFile=" + file.isFile() + ", length=" + file.length() + ", canRead=" + file.canRead();
    }

    private static Uri getContentUriForInstall(Context context, File file, boolean z) {
        String str = context.getPackageName() + FILE_PROVIDER_AUTHORITY_SUFFIX;
        try {
            Uri uriForFile = TapADFileProvider.getUriForFile(context, str, file);
            Objects.toString(uriForFile);
            canOpenUri(context, uriForFile);
            return uriForFile;
        } catch (IllegalArgumentException e) {
            e.getMessage();
            Uri uriBuildContentUri = buildContentUri(str, file);
            Objects.toString(uriBuildContentUri);
            canOpenUri(context, uriBuildContentUri);
            return uriBuildContentUri;
        } catch (Throwable th) {
            th.getMessage();
            Uri uriBuildContentUri2 = buildContentUri(str, file);
            Objects.toString(uriBuildContentUri2);
            canOpenUri(context, uriBuildContentUri2);
            return uriBuildContentUri2;
        }
    }

    public static Uri getInstallFileUri(Context context, File file) {
        if (file == null || context == null) {
            return null;
        }
        boolean z = false;
        try {
            z = !file.getAbsolutePath().equals(file.getCanonicalPath());
        } catch (IOException e) {
        }
        describeFile(file);
        if (z) {
            file.getAbsolutePath();
        }
        return Build.VERSION.SDK_INT >= 24 ? getContentUriForInstall(context, file, z) : Uri.fromFile(file);
    }

    public static Intent getInstallTaskIntent(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException("fileUri is illegal!");
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, AdBaseConstants.MIME_APK);
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        return intent;
    }

    public static Intent getOpenAppTaskIntent(Context context, String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("packageName is null!");
        }
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
