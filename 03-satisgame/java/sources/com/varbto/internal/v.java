package com.varbto.internal;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements Runnable {
    public final /* synthetic */ r a;

    public v(r rVar) {
        this.a = rVar;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005e A[Catch: all -> 0x00af, TryCatch #0 {all -> 0x00af, blocks: (B:3:0x0003, B:5:0x000d, B:7:0x0013, B:10:0x0022, B:11:0x0026, B:13:0x0040, B:15:0x004b, B:17:0x0051, B:19:0x0054, B:21:0x0063, B:22:0x0067, B:24:0x006d, B:28:0x008f, B:30:0x00ab, B:20:0x005e), top: B:35:0x0003 }] */
    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<File> arrayList;
        File[] fileArrListFiles;
        try {
            String absolutePath = this.a.b;
            if (TextUtils.isEmpty(absolutePath)) {
                Context context = this.a.a;
                File file = context != null ? new File(context.getCacheDir(), "tktp_anr") : null;
                if (file != null) {
                    absolutePath = file.getAbsolutePath();
                }
            }
            m.a("w", "handleStackFiles() >>> stackCacheDir: %s, stackValidTime: %s", absolutePath, Long.valueOf(com.anythink.core.e.i.f));
            if (TextUtils.isEmpty(absolutePath)) {
                arrayList = new ArrayList();
            } else {
                File file2 = new File(absolutePath);
                if (!file2.isDirectory() || (fileArrListFiles = file2.listFiles()) == null || fileArrListFiles.length <= 0) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = new ArrayList(Arrays.asList(fileArrListFiles));
                }
            }
            for (File file3 : arrayList) {
                String str = file3.getName().split("\\.")[0];
                boolean z = System.currentTimeMillis() - Long.parseLong(str) >= com.anythink.core.e.i.f;
                m.a("w", "handleStackFiles() >>> file name: %s, isExpired: %s, currentTimeStamp: %s", str, Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis()));
                if (z) {
                    file3.delete();
                }
            }
        } catch (Throwable th) {
            m.a("w", "handleStackFiles() >>> ", th, new Object[0]);
        }
    }
}
