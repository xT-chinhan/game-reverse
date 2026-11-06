package com.byazt.t;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD, 13})
public final class hw {

    /* JADX INFO: renamed from: com.byazt.t.hw$hw, reason: collision with other inner class name */
    public interface InterfaceC0192hw {
        void pr(Bitmap bitmap);
    }

    public static void pr(long j, String str, InterfaceC0192hw interfaceC0192hw) {
        new pr(interfaceC0192hw, j).pr((Object[]) new String[]{str});
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr extends com.byazt.fr.hw<String, Integer, Bitmap> {
        public long hw;
        public InterfaceC0192hw pr;

        public pr(InterfaceC0192hw interfaceC0192hw, long j) {
            this.hw = 0L;
            this.pr = interfaceC0192hw;
            this.hw = j;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
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
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.hw * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                com.byazt.o.hw.pr("MediaUtils", "MediaUtils doInBackground : ", th);
                return frameAtTime;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0192hw interfaceC0192hw = this.pr;
            if (interfaceC0192hw != null) {
                interfaceC0192hw.pr(bitmap);
            }
        }
    }
}
