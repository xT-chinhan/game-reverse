package ms.bz.bd.c.Pgl;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes4.dex */
final class f1 implements FilenameFilter {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final /* synthetic */ String f4832ms;

    f1(String str) {
        this.f4832ms = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.f4832ms);
    }
}
