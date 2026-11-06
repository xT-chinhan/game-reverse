package com.tapsdk.tapad.internal.download.m.g;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.m.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0611a {
        a a(Context context, Uri uri, int i) throws FileNotFoundException;

        a a(Context context, File file, int i) throws FileNotFoundException;

        boolean a();
    }

    void a() throws IOException;

    void a(long j) throws IOException;

    void a(byte[] bArr, int i, int i2) throws IOException;

    void b(long j) throws IOException;

    void close() throws IOException;
}
