package com.byazt.cq;

import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 883, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static n n(String str) {
        n nVar = n.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        nVar = n.CSS;
                    } else if (path.endsWith(".js")) {
                        nVar = n.JS;
                    } else if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico")) {
                        nVar = n.IMAGE;
                    } else if (path.endsWith(".html")) {
                        nVar = n.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return nVar;
    }

    public static boolean qg(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }

    public enum n {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        public String l;

        n(String str) {
            this.l = str;
        }

        public String getType() {
            return this.l;
        }
    }
}
