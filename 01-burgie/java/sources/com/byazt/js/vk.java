package com.byazt.js;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 756, 50})
public class vk {
    public static pr pr(String str) {
        pr prVar = pr.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        prVar = pr.CSS;
                    } else if (path.endsWith(".js")) {
                        prVar = pr.JS;
                    } else if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico")) {
                        prVar = pr.IMAGE;
                    } else if (path.endsWith(".html")) {
                        prVar = pr.HTML;
                    }
                }
            } catch (Throwable th) {
            }
        }
        return prVar;
    }

    public static boolean hw(String str) {
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

    public enum pr {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        public String c;

        pr(String str) {
            this.c = str;
        }

        public String getType() {
            return this.c;
        }
    }
}
