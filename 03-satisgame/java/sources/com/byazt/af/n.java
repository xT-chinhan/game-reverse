package com.byazt.af;

import android.text.TextUtils;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, 19})
public class n {
    public static final Map<String, InterfaceC0121n> n = Collections.synchronizedMap(new HashMap());
    public static com.byazt.nf.l qg;

    /* JADX INFO: renamed from: com.byazt.af.n$n, reason: collision with other inner class name */
    public interface InterfaceC0121n {
        void n();

        void n(String str);
    }

    public static void n(String str, String[] strArr, InterfaceC0121n interfaceC0121n) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        n(str, interfaceC0121n);
        TTDelegateActivity.n(str, strArr);
    }

    public static void n(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.byazt.byp.qg.n()) {
            com.byazt.qit.l.s().execute(new com.byazt.qit.x("handleYes", 5) { // from class: com.byazt.af.n.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        n.qg().n(str, (String) null);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        InterfaceC0121n interfaceC0121nQg = qg(str);
        if (interfaceC0121nQg == null) {
            return;
        }
        interfaceC0121nQg.n();
    }

    public static void n(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.byazt.byp.qg.n()) {
            com.byazt.qit.l.s().execute(new com.byazt.qit.x("handleNo", 5) { // from class: com.byazt.af.n.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        n.qg().n(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        InterfaceC0121n interfaceC0121nQg = qg(str);
        if (interfaceC0121nQg == null) {
            return;
        }
        interfaceC0121nQg.n(str2);
    }

    private static void n(final String str, final InterfaceC0121n interfaceC0121n) {
        if (TextUtils.isEmpty(str) || interfaceC0121n == null) {
            return;
        }
        if (com.byazt.byp.qg.n()) {
            com.byazt.qit.l.qg(new com.byazt.qit.x("addListener") { // from class: com.byazt.af.n.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        k.qg("MultiProcess", "getListenerManager().registerPermissionListener...");
                        n.qg().n(str, new com.byazt.ca.qg(interfaceC0121n));
                    } catch (Throwable th) {
                        k.qg("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            n.put(str, interfaceC0121n);
        }
    }

    private static InterfaceC0121n qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.nf.l qg() {
        if (qg == null) {
            qg = com.byazt.ptd.q.n(com.byazt.prx.n.n(com.byazt.nf.rv.getContext()).n(4));
        }
        return qg;
    }
}
