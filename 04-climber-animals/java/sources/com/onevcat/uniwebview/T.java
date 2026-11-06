package com.onevcat.uniwebview;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class T implements InterfaceC0772y {
    public final ValueCallback b;
    public final WebChromeClient.FileChooserParams c;
    public boolean d;
    public File e;
    public File f;
    public String g;
    public Context h;

    public T(ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        this.b = valueCallback;
        this.c = fileChooserParams;
    }

    public static boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2 != null && StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.onevcat.uniwebview.InterfaceC0772y
    public final void a() {
    }

    @Override // com.onevcat.uniwebview.InterfaceC0772y
    public final void a(Intent intent) {
    }

    @Override // com.onevcat.uniwebview.InterfaceC0772y
    public final void b() {
        ValueCallback valueCallback;
        C0769x c0769x = InterfaceC0772y.a;
        String id = this.g;
        if (id == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handlerId");
            id = null;
        }
        c0769x.getClass();
        Intrinsics.checkNotNullParameter(id, "id");
        C0769x.b.remove(id);
        if (this.d || (valueCallback = this.b) == null) {
            return;
        }
        valueCallback.onReceiveValue(new Uri[0]);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a9  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Uri uri, File file) throws Throwable {
        InputStream inputStreamOpenInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        C0731l c0731l = C0731l.b;
        String message = "copyInputStream uri: '" + uri + "' ToFile: " + file;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        EnumC0728k enumC0728k = EnumC0728k.VERBOSE;
        c0731l.a(enumC0728k, message);
        EnumC0728k enumC0728k2 = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                Context context = this.h;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(com.umeng.analytics.pro.g.X);
                    context = null;
                }
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    if (inputStreamOpenInputStream == 0) {
                        String message2 = "Empty input stream with uri: " + uri + ". Aborting...";
                        Intrinsics.checkNotNullParameter(message2, "message");
                        c0731l.a(EnumC0728k.CRITICAL, message2);
                        return;
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamOpenInputStream.read(bArr);
                            if (i <= 0) {
                                fileOutputStream.close();
                                fileOutputStream.close();
                                inputStreamOpenInputStream.close();
                                return;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                    } catch (Exception unused) {
                        fileOutputStream2 = fileOutputStream;
                        C0731l c0731l2 = C0731l.b;
                        c0731l2.getClass();
                        Intrinsics.checkNotNullParameter("copyInputStreamToFile ", "message");
                        c0731l2.a(EnumC0728k.CRITICAL, "copyInputStreamToFile ");
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        if (inputStreamOpenInputStream != 0) {
                            inputStreamOpenInputStream.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStreamOpenInputStream != 0) {
                            inputStreamOpenInputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                }
            } catch (Throwable th3) {
                th = th3;
                enumC0728k2 = enumC0728k;
                inputStreamOpenInputStream = enumC0728k2;
                th = th;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStreamOpenInputStream != 0) {
                    inputStreamOpenInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused3) {
            inputStreamOpenInputStream = 0;
        } catch (Throwable th4) {
            th = th4;
            inputStreamOpenInputStream = enumC0728k2;
            th = th;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStreamOpenInputStream != 0) {
                inputStreamOpenInputStream.close();
            }
            throw th;
        }
    }

    public final File a(int i) throws IOException {
        String str;
        String str2;
        int iA = AbstractC0704c.a(i);
        if (iA == 1) {
            String str3 = Environment.DIRECTORY_PICTURES;
            str = "image-";
            str2 = ".jpg";
        } else if (iA != 2) {
            str = "";
            str2 = "";
        } else {
            String str4 = Environment.DIRECTORY_MOVIES;
            str = "video-";
            str2 = ".mp4";
        }
        Context context = this.h;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException(com.umeng.analytics.pro.g.X);
            context = null;
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        C0731l c0731l = C0731l.b;
        String message = O.a("Trying to create file as: prefix: ", str, ", suffix: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.VERBOSE, message);
        File outputFile = File.createTempFile(str, str2, externalFilesDir);
        C0731l c0731l2 = C0731l.b;
        String message2 = "Temp file created: " + outputFile;
        c0731l2.getClass();
        Intrinsics.checkNotNullParameter(message2, "message");
        c0731l2.a(EnumC0728k.VERBOSE, message2);
        Intrinsics.checkNotNullExpressionValue(outputFile, "outputFile");
        return outputFile;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        if (r0.length() == 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] a(java.lang.String[] r11) {
        /*
            int r0 = r11.length
            if (r0 != 0) goto L4
            goto L16
        L4:
            int r0 = r11.length
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L1d
            r0 = r11[r1]
            if (r0 == 0) goto L1d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.length()
            if (r0 != 0) goto L1d
        L16:
        */
        //  java.lang.String r11 = "*/*"
        /*
            java.lang.String[] r11 = new java.lang.String[]{r11}
            return r11
        L1d:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r3 = r11.length
            r0.<init>(r3)
            int r3 = r11.length
            r4 = r1
        L25:
            if (r4 >= r3) goto L51
            r5 = r11[r4]
            if (r5 == 0) goto L4b
            kotlin.text.Regex r6 = new kotlin.text.Regex
            java.lang.String r7 = "\\.\\w+"
            r6.<init>(r7)
            boolean r6 = r6.matches(r5)
            if (r6 != r2) goto L4b
            java.lang.String r6 = "."
            java.lang.String r7 = ""
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r5 = kotlin.text.StringsKt.replace$default(r5, r6, r7, r8, r9, r10)
            android.webkit.MimeTypeMap r6 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r5 = r6.getMimeTypeFromExtension(r5)
        L4b:
            r0.add(r5)
            int r4 = r4 + 1
            goto L25
        L51:
            java.lang.String[] r11 = new java.lang.String[r1]
            java.lang.Object[] r11 = r0.toArray(r11)
            if (r11 == 0) goto L5c
            java.lang.String[] r11 = (java.lang.String[]) r11
            return r11
        L5c:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onevcat.uniwebview.T.a(java.lang.String[]):java.lang.String[]");
    }

    public final Uri a(File file) {
        Context context = this.h;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException(com.umeng.analytics.pro.g.X);
            context = null;
        }
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        Context context3 = this.h;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(com.umeng.analytics.pro.g.X);
        } else {
            context2 = context3;
        }
        Uri uriForFile = FileProvider.getUriForFile(context2, packageName + ".uniwebview_fileprovider", file);
        Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(context, \"…eprovider\", capturedFile)");
        return uriForFile;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x0297 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x02c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0077  */
    /* JADX WARN: Code duplicated, block: B:20:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x011b  */
    /* JADX WARN: Code duplicated, block: B:74:0x0213  */
    /* JADX WARN: Code duplicated, block: B:89:0x0291 A[PHI: r3 r14 r18 r19 r20
      0x0291: PHI (r3v11 java.io.File) = (r3v10 java.io.File), (r3v23 java.io.File) binds: [B:88:0x028f, B:79:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0291: PHI (r14v4 android.database.Cursor) = (r14v3 android.database.Cursor), (r14v8 android.database.Cursor) binds: [B:88:0x028f, B:79:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0291: PHI (r18v7 boolean) = (r18v6 boolean), (r18v14 boolean) binds: [B:88:0x028f, B:79:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0291: PHI (r19v7 boolean) = (r19v6 boolean), (r19v12 boolean) binds: [B:88:0x028f, B:79:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0291: PHI (r20v3 android.webkit.ValueCallback) = (r20v2 android.webkit.ValueCallback), (r20v11 android.webkit.ValueCallback) binds: [B:88:0x028f, B:79:0x025f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:98:0x02c3  */
    @Override // com.onevcat.uniwebview.InterfaceC0772y
    public final void a(UniWebViewProxyActivity activity, int i, int i2, Intent intent) throws Throwable {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Uri[] uriArr;
        ValueCallback valueCallback;
        Uri[] uriArr2;
        Cursor cursor;
        boolean z5;
        boolean z6;
        Cursor cursorQuery;
        File fileCreateTempFile;
        Uri uriFromFile;
        String strJoinToString$default;
        Uri[] result;
        Intrinsics.checkNotNullParameter(activity, "activity");
        C0731l c0731l = C0731l.b;
        C0731l c0731l2 = C0731l.b;
        String message = "handleResult. requestCode: " + i + ", resultCode: " + i2 + ", data: " + intent;
        c0731l2.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        EnumC0728k enumC0728k = EnumC0728k.VERBOSE;
        c0731l2.a(enumC0728k, message);
        if (i != 19238467) {
            return;
        }
        if (this.b == null) {
            c0731l2.getClass();
            Intrinsics.checkNotNullParameter("filePathCallback is null for some reason. Aborting...", "message");
            c0731l2.a(EnumC0728k.CRITICAL, "filePathCallback is null for some reason. Aborting...");
            this.d = true;
            activity.finish();
            return;
        }
        File file = this.e;
        int i3 = 0;
        if (file != null) {
            Intrinsics.checkNotNull(file);
            if (file.length() > 0) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        File file2 = this.f;
        if (file2 != null) {
            Intrinsics.checkNotNull(file2);
            if (file2.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (i2 == -1) {
            if (z) {
                c0731l2.getClass();
                Intrinsics.checkNotNullParameter("imageTaken detected. Callback with output image uri.", "message");
                c0731l2.a(enumC0728k, "imageTaken detected. Callback with output image uri.");
                ValueCallback valueCallback2 = this.b;
                File file3 = this.e;
                Intrinsics.checkNotNull(file3);
                valueCallback2.onReceiveValue(new Uri[]{a(file3)});
            } else if (z2) {
                c0731l2.getClass();
                Intrinsics.checkNotNullParameter("videoTaken detected. Callback with output video uri.", "message");
                c0731l2.a(enumC0728k, "videoTaken detected. Callback with output video uri.");
                ValueCallback valueCallback3 = this.b;
                File file4 = this.f;
                Intrinsics.checkNotNull(file4);
                valueCallback3.onReceiveValue(new Uri[]{a(file4)});
            } else {
                if (intent != null) {
                    ClipData clipData = intent.getClipData();
                    if (clipData != null) {
                        ArrayList arrayList = new ArrayList();
                        int itemCount = clipData.getItemCount();
                        for (int i4 = 0; i4 < itemCount; i4++) {
                            Uri item = clipData.getItemAt(i4).getUri();
                            Intrinsics.checkNotNullExpressionValue(item, "item");
                            arrayList.add(item);
                        }
                        Object[] array = arrayList.toArray(new Uri[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        }
                        result = (Uri[]) array;
                    } else if (intent.getData() == null || i2 != -1) {
                        uriArr = null;
                    } else {
                        result = WebChromeClient.FileChooserParams.parseResult(i2, intent);
                    }
                    uriArr = result;
                } else {
                    uriArr = null;
                }
                C0731l c0731l3 = C0731l.b;
                C0731l c0731l4 = C0731l.b;
                String message2 = "File picking detected. externalUris: " + uriArr + ". Start processing...";
                c0731l4.getClass();
                Intrinsics.checkNotNullParameter(message2, "message");
                c0731l4.a(EnumC0728k.VERBOSE, message2);
                ValueCallback valueCallback4 = this.b;
                if (uriArr != null) {
                    ArrayList arrayList2 = new ArrayList();
                    int length = uriArr.length;
                    int i5 = 0;
                    while (i5 < length) {
                        Uri uri = uriArr[i5];
                        C0731l c0731l5 = C0731l.b;
                        String message3 = "processStreamUri: " + uri;
                        c0731l5.getClass();
                        Intrinsics.checkNotNullParameter(message3, "message");
                        EnumC0728k enumC0728k2 = EnumC0728k.VERBOSE;
                        c0731l5.a(enumC0728k2, message3);
                        Uri[] uriArr3 = uriArr;
                        int i6 = length;
                        try {
                            Context context = this.h;
                            if (context == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(com.umeng.analytics.pro.g.X);
                                context = null;
                            }
                            cursorQuery = context.getContentResolver().query(uri, null, null, null, null, null);
                            String str = "tmp_file";
                            String str2 = "";
                            if (cursorQuery != null) {
                                try {
                                    try {
                                        if (cursorQuery.moveToFirst()) {
                                            z5 = z2;
                                            try {
                                                String fullFileName = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                                                z6 = z;
                                                try {
                                                    Intrinsics.checkNotNullExpressionValue(fullFileName, "fullFileName");
                                                    List listSplit$default = StringsKt.split$default((CharSequence) fullFileName, new String[]{com.anythink.core.common.d.j.z}, false, 0, 6, (Object) null);
                                                    valueCallback4 = valueCallback4;
                                                    if (listSplit$default.size() >= 2) {
                                                        try {
                                                            String str3 = com.anythink.core.common.d.j.z + ((String) CollectionsKt.last(listSplit$default));
                                                            strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.dropLast(listSplit$default, 1), com.anythink.core.common.d.j.z, null, null, 0, null, null, 62, null);
                                                            str2 = str3;
                                                        } catch (Exception unused) {
                                                            C0731l c0731l6 = C0731l.b;
                                                            String message4 = "Error while createChoosingTempFileBasedOn uri: " + uri;
                                                            c0731l6.getClass();
                                                            Intrinsics.checkNotNullParameter(message4, "message");
                                                            c0731l6.a(EnumC0728k.CRITICAL, message4);
                                                            fileCreateTempFile = null;
                                                            if (cursorQuery != null) {
                                                                cursorQuery.close();
                                                            }
                                                        }
                                                    } else {
                                                        if (listSplit$default.size() == 1) {
                                                            strJoinToString$default = (String) listSplit$default.get(0);
                                                        }
                                                        if (fileCreateTempFile == null) {
                                                            uriFromFile = null;
                                                        } else {
                                                            try {
                                                                a(uri, fileCreateTempFile);
                                                                uriFromFile = Uri.fromFile(fileCreateTempFile);
                                                            } catch (Exception e) {
                                                                C0731l c0731l7 = C0731l.b;
                                                                String message5 = "Error while processStreamUri. " + e.getMessage();
                                                                c0731l7.getClass();
                                                                Intrinsics.checkNotNullParameter(message5, "message");
                                                                c0731l7.a(EnumC0728k.CRITICAL, message5);
                                                                uriFromFile = null;
                                                            }
                                                        }
                                                        if (uriFromFile != null) {
                                                            arrayList2.add(uriFromFile);
                                                        }
                                                        i5++;
                                                        uriArr = uriArr3;
                                                        length = i6;
                                                        z2 = z5;
                                                        z = z6;
                                                        valueCallback4 = valueCallback4;
                                                        i3 = 0;
                                                    }
                                                    str = strJoinToString$default;
                                                } catch (Exception unused2) {
                                                    valueCallback4 = valueCallback4;
                                                }
                                            } catch (Exception unused3) {
                                                z6 = z;
                                                C0731l c0731l8 = C0731l.b;
                                                String message6 = "Error while createChoosingTempFileBasedOn uri: " + uri;
                                                c0731l8.getClass();
                                                Intrinsics.checkNotNullParameter(message6, "message");
                                                c0731l8.a(EnumC0728k.CRITICAL, message6);
                                                fileCreateTempFile = null;
                                                if (cursorQuery != null) {
                                                    cursorQuery.close();
                                                }
                                                if (fileCreateTempFile == null) {
                                                    uriFromFile = null;
                                                } else {
                                                    a(uri, fileCreateTempFile);
                                                    uriFromFile = Uri.fromFile(fileCreateTempFile);
                                                }
                                                if (uriFromFile != null) {
                                                    arrayList2.add(uriFromFile);
                                                }
                                                i5++;
                                                uriArr = uriArr3;
                                                length = i6;
                                                z2 = z5;
                                                z = z6;
                                                valueCallback4 = valueCallback4;
                                                i3 = 0;
                                            }
                                        } else {
                                            valueCallback4 = valueCallback4;
                                            z5 = z2;
                                            z6 = z;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursorQuery;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception unused4) {
                                    z5 = z2;
                                }
                            } else {
                                valueCallback4 = valueCallback4;
                                z5 = z2;
                                z6 = z;
                            }
                            String str4 = str;
                            String str5 = str2;
                            String message7 = "Creating temp file with name " + str4 + '.' + str5;
                            Intrinsics.checkNotNullParameter(message7, "message");
                            c0731l5.a(enumC0728k2, message7);
                            Context context2 = this.h;
                            if (context2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(com.umeng.analytics.pro.g.X);
                                context2 = null;
                            }
                            fileCreateTempFile = File.createTempFile(str4, str5, context2.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
                            String message8 = "File created: " + fileCreateTempFile;
                            Intrinsics.checkNotNullParameter(message8, "message");
                            c0731l5.a(enumC0728k2, message8);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } catch (Exception unused5) {
                            valueCallback4 = valueCallback4;
                            z5 = z2;
                            z6 = z;
                            cursorQuery = null;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = null;
                        }
                        if (fileCreateTempFile == null) {
                            uriFromFile = null;
                        } else {
                            a(uri, fileCreateTempFile);
                            uriFromFile = Uri.fromFile(fileCreateTempFile);
                        }
                        if (uriFromFile != null) {
                            arrayList2.add(uriFromFile);
                        }
                        i5++;
                        uriArr = uriArr3;
                        length = i6;
                        z2 = z5;
                        z = z6;
                        valueCallback4 = valueCallback4;
                        i3 = 0;
                    }
                    ValueCallback valueCallback5 = valueCallback4;
                    z3 = z2;
                    z4 = z;
                    Object[] array2 = arrayList2.toArray(new Uri[i3]);
                    if (array2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                    uriArr2 = (Uri[]) array2;
                    valueCallback = valueCallback5;
                } else {
                    z3 = z2;
                    z4 = z;
                    valueCallback = valueCallback4;
                    uriArr2 = null;
                }
                valueCallback.onReceiveValue(uriArr2);
            }
            z3 = z2;
            z4 = z;
        } else {
            z3 = z2;
            z4 = z;
            this.b.onReceiveValue(null);
        }
        File file5 = this.e;
        if (file5 != null && !z4) {
            Intrinsics.checkNotNull(file5);
            file5.delete();
        }
        File file6 = this.f;
        if (file6 != null && !z3) {
            Intrinsics.checkNotNull(file6);
            file6.delete();
        }
        this.e = null;
        this.f = null;
        this.d = true;
        activity.finish();
    }

    /* JADX WARN: Code duplicated, block: B:48:0x013e  */
    @Override // com.onevcat.uniwebview.InterfaceC0772y
    public final void a(UniWebViewProxyActivity activity) {
        Exception e;
        Intent intent;
        Exception e2;
        Intent intent2;
        boolean z;
        Intrinsics.checkNotNullParameter(activity, "activity");
        C0731l c0731l = C0731l.b;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("Starting File Chooser...", "message");
        EnumC0728k enumC0728k = EnumC0728k.VERBOSE;
        c0731l.a(enumC0728k, "Starting File Chooser...");
        WebChromeClient.FileChooserParams fileChooserParams = this.c;
        Intent intent3 = null;
        String[] acceptTypes = fileChooserParams != null ? fileChooserParams.getAcceptTypes() : null;
        if (acceptTypes == null) {
            acceptTypes = new String[0];
        }
        StringBuilder sb = new StringBuilder("Accept types from file chooser params: ");
        WebChromeClient.FileChooserParams fileChooserParams2 = this.c;
        String message = sb.append(fileChooserParams2 != null ? fileChooserParams2.getAcceptTypes() : null).toString();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(enumC0728k, message);
        ArrayList arrayList = new ArrayList();
        String[] strArrA = a(acceptTypes);
        if (a(strArrA, "*/*") || a(strArrA, "image")) {
            Intrinsics.checkNotNullParameter("params contains image. Adding photo intent.", "message");
            c0731l.a(enumC0728k, "params contains image. Adding photo intent.");
            try {
                File fileA = a(2);
                Uri uriA = a(fileA);
                String message2 = "Output image uri: " + uriA;
                Intrinsics.checkNotNullParameter(message2, "message");
                c0731l.a(enumC0728k, message2);
                this.e = fileA;
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                try {
                    intent.putExtra("output", uriA);
                } catch (Exception e3) {
                    e = e3;
                    C0731l c0731l2 = C0731l.b;
                    String message3 = "getPhotoIntent errored (IOException). Cannot create the temp file. " + e;
                    c0731l2.getClass();
                    Intrinsics.checkNotNullParameter(message3, "message");
                    c0731l2.a(EnumC0728k.CRITICAL, message3);
                    e.printStackTrace();
                }
            } catch (Exception e4) {
                e = e4;
                intent = null;
            }
            if (intent != null) {
                arrayList.add(intent);
            }
        }
        String[] strArrA2 = a(acceptTypes);
        if (a(strArrA2, "*/*") || a(strArrA2, "video")) {
            C0731l c0731l3 = C0731l.b;
            c0731l3.getClass();
            Intrinsics.checkNotNullParameter("params contains video. Adding video intent.", "message");
            EnumC0728k enumC0728k2 = EnumC0728k.VERBOSE;
            c0731l3.a(enumC0728k2, "params contains video. Adding video intent.");
            try {
                File fileA2 = a(3);
                Uri uriA2 = a(fileA2);
                String message4 = "Output video uri: " + uriA2;
                Intrinsics.checkNotNullParameter(message4, "message");
                c0731l3.a(enumC0728k2, message4);
                this.f = fileA2;
                intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
                try {
                    intent2.putExtra("output", uriA2);
                } catch (Exception e5) {
                    e2 = e5;
                    intent3 = intent2;
                    C0731l c0731l4 = C0731l.b;
                    String message5 = "getVideoIntent errored (IOException). Cannot create the temp file. " + e2;
                    c0731l4.getClass();
                    Intrinsics.checkNotNullParameter(message5, "message");
                    c0731l4.a(EnumC0728k.CRITICAL, message5);
                    e2.printStackTrace();
                    intent2 = intent3;
                }
            } catch (Exception e6) {
                e2 = e6;
            }
            if (intent2 != null) {
                arrayList.add(intent2);
            }
        }
        WebChromeClient.FileChooserParams fileChooserParams3 = this.c;
        if (fileChooserParams3 != null) {
            z = fileChooserParams3.getMode() == 1;
        }
        Intent intent4 = new Intent("android.intent.action.GET_CONTENT");
        intent4.addCategory("android.intent.category.OPENABLE");
        intent4.setType("*/*");
        intent4.putExtra("android.intent.extra.MIME_TYPES", a(acceptTypes));
        intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
        Intent intent5 = new Intent("android.intent.action.CHOOSER");
        intent5.putExtra("android.intent.extra.TITLE", activity.getResources().getString(R.string.CHOOSE_IMAGE));
        intent5.putExtra("android.intent.extra.INTENT", intent4);
        intent5.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        activity.startActivityForResult(intent5, 19238467);
    }
}
