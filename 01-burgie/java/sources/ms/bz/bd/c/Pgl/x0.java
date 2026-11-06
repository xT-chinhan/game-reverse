package ms.bz.bd.c.Pgl;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes3.dex */
final class x0 implements FilenameFilter {
    final /* synthetic */ String pr;

    x0(String str) {
        this.pr = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.pr);
    }
}
