package com.onevcat.uniwebview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.webkit.CookieManager;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class W {
    public final Activity a;
    public final String b;
    public final c2 c;
    public final Function0 d;
    public boolean e;
    public final HashMap f;
    public final V g;

    public W(Activity activity, String name, c2 messageSender, C0755t customizeHeaders) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(messageSender, "messageSender");
        Intrinsics.checkNotNullParameter(customizeHeaders, "customizeHeaders");
        this.a = activity;
        this.b = name;
        this.c = messageSender;
        this.d = customizeHeaders;
        this.e = true;
        this.f = new HashMap();
        this.g = new V(this);
    }

    public final void a(String url, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(url, "url");
        C0716g c0716g = null;
        if (StringsKt.startsWith$default(url, "data:", false, 2, (Object) null)) {
            try {
                C0734m c0734mA = U.a(url);
                if (c0734mA != null) {
                    C0719h c0719h = new C0719h(url, c0734mA.b);
                    if (str2 == null && (str2 = c0734mA.a) == null) {
                        str2 = "";
                    }
                    String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str2);
                    c0716g = new C0716g(c0719h, extensionFromMimeType == null ? AbstractC0743p.a(StringCompanionObject.INSTANCE) : AbstractC0743p.a(StringCompanionObject.INSTANCE) + '.' + extensionFromMimeType, z);
                }
            } catch (Exception e) {
                C0731l c0731l = C0731l.b;
                String message = "Failed to parse data url: " + url + ". Error: " + e;
                c0731l.getClass();
                Intrinsics.checkNotNullParameter(message, "message");
                c0731l.a(EnumC0728k.CRITICAL, message);
            }
        } else if (URLUtil.isValidUrl(url)) {
            String fileName = URLUtil.guessFileName(url, str, str2);
            C0722i c0722i = new C0722i(url);
            Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
            c0716g = new C0716g(c0722i, fileName, z);
        }
        if (c0716g != null) {
            a(c0716g);
        } else {
            Activity activity = this.a;
            Toast.makeText(activity, activity.getResources().getString(R.string.INVALID_URL), 1).show();
        }
    }

    public final void b(C0716g c0716g) {
        AbstractC0725j abstractC0725j = c0716g.a;
        if (abstractC0725j instanceof C0722i) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(c0716g.a()));
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDescription(c0716g.b);
            request.setTitle(c0716g.b);
            request.setDestinationInExternalFilesDir(this.a, Environment.DIRECTORY_DOWNLOADS, c0716g.b);
            request.addRequestHeader("Cookie", CookieManager.getInstance().getCookie(c0716g.a()));
            for (Map.Entry entry : ((Map) this.d.invoke()).entrySet()) {
                request.addRequestHeader((String) entry.getKey(), (String) entry.getValue());
            }
            Object systemService = this.a.getSystemService("download");
            if (systemService instanceof DownloadManager) {
                this.f.put(Long.valueOf(((DownloadManager) systemService).enqueue(request)), c0716g);
                Activity activity = this.a;
                Toast.makeText(activity, activity.getResources().getString(R.string.DOWNLOAD_STARTED), 1).show();
                if (c0716g.c) {
                    this.c.a(this.b, d2.FileDownloadStarted, new Y1(c0716g.a(), "0", c0716g.b, null));
                    return;
                }
                return;
            }
            return;
        }
        if (abstractC0725j instanceof C0719h) {
            C0719h c0719h = (C0719h) abstractC0725j;
            String strA = c0716g.a();
            if (c0716g.c) {
                this.c.a(this.b, d2.FileDownloadStarted, new Y1(strA, "0", c0716g.b, null));
            }
            try {
                File file = new File(this.a.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), c0716g.b);
                FilesKt.writeBytes(file, c0719h.b);
                if (c0716g.c) {
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                    this.c.a(this.b, d2.FileDownloadFinished, new Y1(strA, "0", absolutePath, null));
                }
            } catch (Exception e) {
                C0731l c0731l = C0731l.b;
                String message = "Failed to download base64 data: " + strA + ". Error: " + e;
                c0731l.getClass();
                Intrinsics.checkNotNullParameter(message, "message");
                c0731l.a(EnumC0728k.CRITICAL, message);
            }
        }
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.a.registerReceiver(this.g, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 2);
        } else {
            this.a.registerReceiver(this.g, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
    }

    public final void a(final C0716g c0716g) {
        if (!this.e) {
            b(c0716g);
            return;
        }
        final EditText editText = new EditText(this.a);
        editText.setSingleLine();
        editText.setText(c0716g.b);
        AlertDialog.Builder cancelable = new AlertDialog.Builder(this.a).setTitle(c0716g.a()).setMessage(this.a.getResources().getString(R.string.DOWNLOAD_DESCRIPTION)).setIcon(android.R.drawable.ic_dialog_info).setCancelable(true);
        Intrinsics.checkNotNullExpressionValue(cancelable, "Builder(activity)\n      …     .setCancelable(true)");
        AbstractC0698a.a(cancelable, editText).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.onevcat.uniwebview.W$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                W.a(editText, c0716g, this, dialogInterface, i);
            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.onevcat.uniwebview.W$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                W.a(dialogInterface, i);
            }
        }).create().show();
    }

    public static final void a(EditText input, C0716g task, W this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(input, "$input");
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = input.getText().toString();
        dialogInterface.dismiss();
        task.getClass();
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        task.b = string;
        this$0.b(task);
    }

    public static final void a(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
