package com.onevcat.uniwebview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0735m0 extends Lambda implements Function1 {
    public final /* synthetic */ String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0735m0(String str) {
        super(1);
        this.a = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Y1 y1;
        String absolutePath;
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        String str = this.a;
        if (it.e.getHeight() <= 0 || it.e.getWidth() <= 0) {
            y1 = new Y1("", String.valueOf(-1002), "", null);
        } else {
            Bitmap bitmapA = it.a((Rect) null);
            File cacheDir = it.a.getCacheDir();
            if (str == null || str.length() == 0) {
                str = UUID.randomUUID() + ".png";
            }
            try {
                File file = new File(cacheDir, str);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmapA.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                C0731l c0731l = C0731l.b;
                String message = "Capture Snapshot done. File written in: " + file;
                c0731l.getClass();
                Intrinsics.checkNotNullParameter(message, "message");
                c0731l.a(EnumC0728k.INFO, message);
                absolutePath = file.getAbsolutePath();
            } catch (Exception e) {
                C0731l c0731l2 = C0731l.b;
                String message2 = "Error during save snapshot image: " + e;
                c0731l2.getClass();
                Intrinsics.checkNotNullParameter(message2, "message");
                c0731l2.a(EnumC0728k.CRITICAL, message2);
                absolutePath = null;
            }
            y1 = absolutePath != null ? new Y1("", String.valueOf(0), absolutePath, null) : new Y1("", String.valueOf(-1000), "", null);
        }
        it.c.a(it.b, d2.CaptureSnapshotFinished, y1);
        return Unit.INSTANCE;
    }
}
