package com.bykv.vk.openvk.component.video.ms.ka;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class xr {

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.ms.ka.xr$xr, reason: collision with other inner class name */
    public interface InterfaceC0181xr {
        void ms(Bitmap bitmap);
    }

    public static void ms(long j, String str, InterfaceC0181xr interfaceC0181xr) {
        new ms(interfaceC0181xr, j).ms((Object[]) new String[]{str});
    }

    public static class ms extends com.bytedance.sdk.component.ch.d.xr<String, Integer, Bitmap> {
        private long ah;
        private InterfaceC0181xr xr;

        public ms(InterfaceC0181xr interfaceC0181xr, long j) {
            this.xr = interfaceC0181xr;
            this.ah = j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
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
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.ah * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.c.ah.ah("MediaUtils", "MediaUtils doInBackground : ", th);
                return frameAtTime;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0181xr interfaceC0181xr = this.xr;
            if (interfaceC0181xr != null) {
                interfaceC0181xr.ms(bitmap);
            }
        }
    }
}
