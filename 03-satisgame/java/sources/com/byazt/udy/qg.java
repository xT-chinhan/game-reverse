package com.byazt.udy;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, 26})
public final class qg {

    /* JADX INFO: renamed from: com.byazt.udy.qg$qg, reason: collision with other inner class name */
    public interface InterfaceC0363qg {
        void n(Bitmap bitmap);
    }

    public static void n(long j, String str, InterfaceC0363qg interfaceC0363qg) {
        new n(interfaceC0363qg, j).n((Object[]) new String[]{str});
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, 48})
    public static class n extends com.byazt.xis.qg<String, Integer, Bitmap> {
        public InterfaceC0363qg n;
        public long qg;

        public n(InterfaceC0363qg interfaceC0363qg, long j) {
            this.n = interfaceC0363qg;
            this.qg = j;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(String... strArr) {
            Bitmap frameAtTime = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith("http")) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.qg * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                com.byazt.nl.qg.n("MediaUtils", "MediaUtils doInBackground : ", th);
                return frameAtTime;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0363qg interfaceC0363qg = this.n;
            if (interfaceC0363qg != null) {
                interfaceC0363qg.n(bitmap);
            }
        }
    }
}
