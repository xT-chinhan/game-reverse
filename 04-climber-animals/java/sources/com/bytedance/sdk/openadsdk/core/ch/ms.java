package com.bytedance.sdk.openadsdk.core.ch;

import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.ch.x;
import com.bytedance.sdk.component.utils.c;
import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    protected abstract void ms(List<File> list);

    protected abstract boolean ms(long j, int i);

    protected abstract boolean ms(File file, long j, int i);

    public void ms(File file) throws IOException {
        final x xVar = new x(new CallableC0267ms(file), 1, 2);
        ab.xr(new ny("touch", xVar.ms()) { // from class: com.bytedance.sdk.openadsdk.core.ch.ms.1
            @Override // java.lang.Runnable
            public void run() {
                xVar.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(File file) throws IOException {
        try {
            c.xr(file);
        } catch (Throwable unused) {
        }
        List<File> listMs = c.ms(file.getParentFile());
        sl.d("splashLoadAd", "LruDiskFile touchInBackground files.size() " + listMs.size());
        ms(listMs);
    }

    long xr(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ch.ms$ms, reason: collision with other inner class name */
    private class CallableC0267ms implements Callable<Void> {
        private final File xr;

        private CallableC0267ms(File file) {
            this.xr = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            ms.this.xr(this.xr);
            return null;
        }
    }
}
