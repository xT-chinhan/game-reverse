package com.smartdigimkt.k2;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.smartdigimkt.z.e0;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.Map;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ WTWebView c;

    public q(WTWebView wTWebView, int i, Map map) {
        this.c = wTWebView;
        this.a = i;
        this.b = map;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.b3.c cVar;
        int i;
        int i2;
        String str = "";
        String string = "";
        int i3 = this.a;
        if (i3 != 101) {
            int i4 = 0;
            int i5 = 1;
            try {
                if (i3 == 301) {
                    str = "ad_event_render_layout";
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    String str2 = this.c.e.f;
                    if (!TextUtils.isEmpty(str2)) {
                        com.smartdigimkt.b3.c cVar2 = this.c.e;
                        synchronized (cVar2) {
                            i2 = cVar2.E;
                        }
                        if (i2 <= 0 && this.c.e.b() <= 0) {
                            e0.a().getClass();
                            int[] iArrA = com.smartdigimkt.s4.d.a(e0.a(1, str2));
                            if (iArrA != null) {
                                jSONObject2.put("image_width", iArrA[0]);
                                jSONObject2.put("image_height", iArrA[1]);
                            }
                        } else {
                            jSONObject2.put("image_width", this.c.e.c());
                            jSONObject2.put("image_height", this.c.e.b());
                        }
                    }
                    if (!TextUtils.isEmpty(this.c.e.i) && (i = (cVar = this.c.e).G) > 0 && cVar.H > 0) {
                        jSONObject2.put("video_width", i);
                        jSONObject2.put("video_height", this.c.e.H);
                    }
                    jSONObject.put("material_info", jSONObject2);
                    string = jSONObject.toString();
                } else if (i3 == 305) {
                    str = "ad_event_size_change";
                    if (this.b != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        Object obj = this.b.get("wt_view_width");
                        if (obj != null) {
                            jSONObject3.put("view_width", obj);
                        }
                        Object obj2 = this.b.get("wt_view_height");
                        if (obj2 != null) {
                            jSONObject3.put("view_height", obj2);
                        }
                        string = jSONObject3.toString();
                    }
                } else if (i3 == 107) {
                    str = "player_completion";
                } else if (i3 != 108) {
                    switch (i3) {
                        case 110:
                            str = "ad_event_on_resume";
                            break;
                        case 111:
                            str = "ad_event_on_pause";
                            break;
                        case 112:
                            str = "ad_event_on_destroy";
                            break;
                        case 113:
                            str = "ad_event_click";
                            if (this.b != null) {
                                JSONObject jSONObject4 = new JSONObject();
                                Object obj3 = this.b.get("click_type");
                                if (obj3 != null) {
                                    jSONObject4.put("cl_s_type", obj3);
                                }
                                Object obj4 = this.b.get("click_area");
                                if (obj3 != null) {
                                    jSONObject4.put("cl_area", obj4);
                                }
                                string = jSONObject4.toString();
                            }
                            break;
                        case 114:
                            str = "ad_event_impresion";
                            break;
                        case 115:
                            str = "ad_event_close";
                            break;
                        default:
                            switch (i3) {
                                case 121:
                                    str = "ad_event_cta_update";
                                    if (this.b != null) {
                                        JSONObject jSONObject5 = new JSONObject();
                                        Object obj5 = this.b.get("cta_text");
                                        if (obj5 != null) {
                                            jSONObject5.put("cta_text", obj5);
                                        }
                                        string = jSONObject5.toString();
                                    }
                                    break;
                                case 122:
                                    str = "ad_event_feedback_dismiss";
                                    break;
                                case 123:
                                    str = "player_prepare";
                                    if (this.b != null) {
                                        JSONObject jSONObject6 = new JSONObject();
                                        Object obj6 = this.b.get("video_length");
                                        if (obj6 != null) {
                                            jSONObject6.put(MediationConstant.EXTRA_DURATION, obj6);
                                        }
                                        string = jSONObject6.toString();
                                    }
                                    break;
                                case 124:
                                    str = "player_stop";
                                    break;
                                case 125:
                                    str = "player_progress";
                                    if (this.b != null) {
                                        JSONObject jSONObject7 = new JSONObject();
                                        Object obj7 = this.b.get("video_progress");
                                        if (obj7 != null) {
                                            jSONObject7.put(NotificationCompat.CATEGORY_PROGRESS, obj7);
                                        }
                                        string = jSONObject7.toString();
                                    }
                                    break;
                                case 126:
                                case WorkQueueKt.MASK /* 127 */:
                                case 128:
                                case 131:
                                    str = "ad_event_data_fetch";
                                    if (i3 != 131) {
                                        switch (i3) {
                                            case 126:
                                                i4 = 1;
                                                break;
                                            case WorkQueueKt.MASK /* 127 */:
                                                i4 = 2;
                                                break;
                                            case 128:
                                                i4 = 3;
                                                break;
                                        }
                                    } else {
                                        i4 = 3;
                                    }
                                    JSONObject jSONObject8 = new JSONObject();
                                    jSONObject8.put(WebLoginFragment.QUERY_KEY_ID, i4);
                                    string = jSONObject8.toString();
                                    break;
                                case 129:
                                case MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE /* 130 */:
                                    str = "ad_event_foreground_change";
                                    JSONObject jSONObject9 = new JSONObject();
                                    if (this.a != 129) {
                                        i5 = 2;
                                    }
                                    jSONObject9.put("is_foreground", i5);
                                    string = jSONObject9.toString();
                                    break;
                            }
                            break;
                    }
                } else {
                    str = "player_show_fail";
                    if (this.b != null) {
                        JSONObject jSONObject10 = new JSONObject();
                        Object obj8 = this.b.get("video_play_fail_message");
                        if (obj8 != null) {
                            jSONObject10.put("error_message", obj8);
                        }
                        string = jSONObject10.toString();
                    }
                }
            } catch (Throwable unused) {
            }
        } else {
            str = "player_start";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.smartdigimkt.o2.a.a().a(this.c, str, string);
    }
}
