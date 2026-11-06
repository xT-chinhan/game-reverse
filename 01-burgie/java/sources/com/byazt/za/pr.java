package com.byazt.za;

import com.byazt.ca.ho;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import com.byazt.xlm.uc;
import com.mar.sdk.MARCode;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 857, 37})
public abstract class pr {
    public abstract void pr(List<File> list);

    public abstract boolean pr(long j, int i);

    public abstract boolean pr(File file, long j, int i);

    public void pr(File file) throws IOException {
        final uc ucVar = new uc(new CallableC0241pr(file), 1, 2);
        c.hw(new fw("touch", ucVar.pr()) { // from class: com.byazt.za.pr.1
            @Override // java.lang.Runnable
            public void run() {
                ucVar.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(File file) throws IOException {
        try {
            com.byazt.ca.fw.hw(file);
        } catch (Throwable th) {
        }
        List<File> listPr = com.byazt.ca.fw.pr(file.getParentFile());
        ho.hw("splashLoadAd", "LruDiskFile touchInBackground files.size() " + listPr.size());
        pr(listPr);
    }

    public long hw(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: renamed from: com.byazt.za.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 857, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private class CallableC0241pr implements Callable<Void> {
        public final File hw;

        private CallableC0241pr(File file) {
            this.hw = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            pr.this.hw(this.hw);
            return null;
        }
    }
}
