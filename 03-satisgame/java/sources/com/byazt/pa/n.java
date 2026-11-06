package com.byazt.pa;

import com.byazt.qit.l;
import com.byazt.qit.w;
import com.byazt.qit.x;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2192, 19})
public abstract class n {
    public abstract void n(List<File> list);

    public abstract boolean n(long j, int i);

    public abstract boolean n(File file, long j, int i);

    public void n(File file) throws IOException {
        final w wVar = new w(new CallableC0291n(file), 1, 2);
        l.qg(new x("touch", wVar.n()) { // from class: com.byazt.pa.n.1
            @Override // java.lang.Runnable
            public void run() {
                wVar.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(File file) throws IOException {
        try {
            com.byazt.tk.x.qg(file);
        } catch (Throwable unused) {
        }
        List<File> listN = com.byazt.tk.x.n(file.getParentFile());
        k.qg("splashLoadAd", "LruDiskFile touchInBackground files.size() " + listN.size());
        n(listN);
    }

    public long qg(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: renamed from: com.byazt.pa.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 2192, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private class CallableC0291n implements Callable<Void> {
        public final File qg;

        private CallableC0291n(File file) {
            this.qg = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            n.this.qg(this.qg);
            return null;
        }
    }
}
