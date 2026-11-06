package com.byazt.me;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.byazt.dea.uc;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 126, 20})
public final class hn implements Function<SparseArray<Object>, Object> {
    public static final int CANCELED = -4;
    public static final int DOWNLOAD_COMPLETE_HANDLE = 11;
    public static final int FAILED = -1;
    public static final int START = 2;
    public static final int SUCCESSED = -3;
    public static final int TYPE_ACTIVE = 1;
    public static final int TYPE_COMPLETE = 3;
    public static final int TYPE_PREPARE = 4;
    public static final int TYPE_WAITING = 2;
    public static volatile hn pr;
    public Function<SparseArray<Object>, Object> hn;
    public final Context hw;

    private hn(Context context) {
        this.hw = context;
    }

    public static hn pr() {
        return pr;
    }

    public static hn pr(Context context) {
        if (pr == null) {
            synchronized (hn.class) {
                if (pr == null) {
                    pr = new hn(context);
                }
            }
        }
        return pr;
    }

    public <T> T pr(Class<T> cls, int i, Map<String, Object> map) {
        uc.hw("xgc_dl", "api:".concat(String.valueOf(i)));
        switch (i) {
            case 0:
                if (this.hn != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 0);
                    sparseArray.put(0, map);
                    return (T) this.hn.apply(sparseArray);
                }
                return (T) Boolean.FALSE;
            case 155:
                return (T) pr((String) map.get("custom_authority"), (String) map.get("custom_file_path"));
            case 156:
                return (T) pr(map);
            case 159:
                if (map != null) {
                    Object obj = map.get("n");
                    if (obj instanceof Function) {
                        this.hn = (Function) obj;
                    }
                }
                return null;
            case 161:
                return (T) hw(map);
            default:
                return null;
        }
    }

    public void pr(Map<String, Object> map, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(0, map);
        Function<SparseArray<Object>, Object> function = this.hn;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    private NotificationCompat.Builder pr(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.hw);
        }
        try {
            return new NotificationCompat.Builder(this.hw, str);
        } catch (NoSuchMethodError e) {
            return new NotificationCompat.Builder(this.hw);
        }
    }

    private Map<String, Object> pr(Map<String, Object> map) {
        Map<String, Object> map2;
        if (map != null && (map2 = (Map) map.get("params")) != null) {
            Map<String, Object> mapHn = hn(map2);
            Object obj = mapHn.get("remote_views");
            Object obj2 = mapHn.get("builder_content_type");
            int iIntValue = ((Integer) map2.get("notification_type")).intValue();
            String str = (String) map2.get("channel_id");
            int iIntValue2 = ((Integer) map2.get("download_status")).intValue();
            NotificationCompat.Builder builderPr = pr(str);
            builderPr.setWhen(((Long) map2.get("first_time")).longValue());
            Object obj3 = map2.get("notification_group");
            if (obj3 != null && (obj3 instanceof String)) {
                builderPr.setGroup((String) obj3);
                builderPr.setGroupSummary(false);
            }
            builderPr.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
            if (iIntValue == 1 || iIntValue == 4 || iIntValue == 2) {
                builderPr.setContentIntent((PendingIntent) mapHn.get("apa_click_content_intent"));
                builderPr.setAutoCancel(false);
            } else if (iIntValue == 3) {
                builderPr.setAutoCancel(true);
                if (iIntValue2 == -3) {
                    Object obj4 = map2.get("auto_cancel");
                    if ((obj4 instanceof Boolean) && ((Boolean) obj4).booleanValue()) {
                        builderPr.setAutoCancel(false);
                    }
                }
                builderPr.setContentIntent((PendingIntent) mapHn.get("complete_click_content_intent"));
                builderPr.setDeleteIntent((PendingIntent) mapHn.get("hide_click_content_intent"));
            }
            if (iIntValue == 3 && iIntValue2 == -3 && (obj2 instanceof String)) {
                builderPr.setContentText((String) obj2);
            }
            Object obj5 = mapHn.get("builder_small_icon");
            if (obj5 instanceof Integer) {
                builderPr.setSmallIcon(((Integer) obj5).intValue());
            }
            Notification notificationBuild = builderPr.build();
            notificationBuild.contentView = (RemoteViews) obj;
            mapHn.put("notification", notificationBuild);
            return mapHn;
        }
        return null;
    }

    private Map<String, Object> hw(Map<String, Object> map) {
        int iIntValue;
        int iIntValue2;
        String strConcat;
        CharSequence charSequence;
        CharSequence charSequence2;
        int iNy;
        String str;
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        String str2 = (String) map.get("install_app_name");
        Bitmap bitmap = (Bitmap) map.get("install_icon_bitmap");
        String str3 = (String) map.get("install_action_type");
        Object obj = map.get("install_click_type");
        String str4 = (String) map.get("install_package_name");
        String str5 = (String) map.get("install_tag");
        String str6 = (String) map.get("install_value");
        String str7 = (String) map.get("install_log_extra");
        if (obj == null) {
            iIntValue = -1;
        } else {
            iIntValue = ((Integer) obj).intValue();
        }
        Object obj2 = map.get("install_download_id");
        if (obj2 == null) {
            iIntValue2 = -1;
        } else {
            iIntValue2 = ((Integer) obj2).intValue();
        }
        Object obj3 = map.get("install_enable_target_34");
        boolean zBooleanValue = false;
        if (obj3 != null) {
            zBooleanValue = ((Boolean) obj3).booleanValue();
        }
        RemoteViews remoteViews = new RemoteViews(this.hw.getPackageName(), this.hw.getResources().getIdentifier("tt_install_notification_layout", "layout", this.hw.getPackageName()));
        int iM = pr.m();
        int iK = pr.k();
        int iG = pr.g();
        int iHo = pr.ho();
        int iNt = pr.nt();
        if (iIntValue == 1) {
            strConcat = "打开".concat(String.valueOf(str2));
            charSequence = "应用已安装完成";
            charSequence2 = "去打开";
        } else {
            strConcat = "安装".concat(String.valueOf(str2));
            charSequence = "应用已下载完成";
            charSequence2 = "去安装";
        }
        remoteViews.setTextViewText(iK, charSequence);
        remoteViews.setTextViewText(iG, strConcat);
        remoteViews.setTextViewText(iHo, charSequence2);
        int iZ = pr.z();
        if (iZ != 0) {
            iNy = iZ;
        } else {
            int iRc = pr.rc();
            if (iRc != 0) {
                iNy = iRc;
            } else {
                iNy = pr.ny();
            }
        }
        remoteViews.setImageViewIcon(iM, Icon.createWithBitmap(bitmap));
        CharSequence charSequence3 = charSequence;
        PendingIntent pendingIntentPr = pr(str3, iIntValue, iIntValue2, zBooleanValue, str4, str5, str6, str7);
        remoteViews.setOnClickPendingIntent(iNt, pendingIntentPr);
        remoteViews.setOnClickPendingIntent(iHo, pendingIntentPr);
        String str8 = "csj_" + this.hw.getPackageName();
        try {
            if (Build.VERSION.SDK_INT < 26) {
                str = "notification";
            } else {
                NotificationChannel notificationChannel = new NotificationChannel(str8, "csj_install", 4);
                notificationChannel.setShowBadge(true);
                notificationChannel.setBypassDnd(true);
                str = "notification";
                try {
                    ((NotificationManager) this.hw.getSystemService(str)).createNotificationChannel(notificationChannel);
                } catch (Throwable th) {
                    th = th;
                    uc.pr(th);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            str = "notification";
        }
        NotificationCompat.Builder builderPr = pr(str8);
        builderPr.setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setContentIntent(pendingIntentPr).setSmallIcon(iNy).setContentTitle(charSequence3).setContentText(strConcat).setPriority(1).setDefaults(-1).setVisibility(1).setAutoCancel(true);
        Notification notificationBuild = builderPr.build();
        notificationBuild.contentView = remoteViews;
        map2.put(str, notificationBuild);
        return map2;
    }

    private Map<String, Object> hn(Map<String, Object> map) {
        boolean zBooleanValue;
        int i;
        int iIntValue;
        int iIntValue2;
        int i2;
        int iC;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i3;
        String str9;
        RemoteViews remoteViews = new RemoteViews(this.hw.getPackageName(), this.hw.getResources().getIdentifier("tt_adl_notification_layout", "layout", this.hw.getPackageName()));
        HashMap map2 = new HashMap();
        Object obj = map.get("csj_enable_target_34");
        if (obj == null) {
            zBooleanValue = false;
        } else {
            zBooleanValue = ((Boolean) obj).booleanValue();
        }
        int iVk = pr.vk();
        Object obj2 = map.get("notification_type");
        Object obj3 = map.get("notification_opt_2");
        int iZ = pr.z();
        if (iZ == 0) {
            i = 0;
        } else {
            i = iZ;
        }
        if ((obj2 instanceof Integer) && (obj3 instanceof Integer)) {
            int iPr = pr(((Integer) obj2).intValue(), ((Integer) obj3).intValue() == 1);
            remoteViews.setImageViewResource(iVk, iPr);
            if (iPr != 0 && iZ == 0) {
                i = iPr;
            }
        }
        map2.put("builder_small_icon", Integer.valueOf(i));
        Object obj4 = map.get("click_type");
        if (!(obj4 instanceof Integer)) {
            iIntValue = 0;
        } else {
            iIntValue = ((Integer) obj4).intValue();
        }
        Object obj5 = map.get("click_download_id");
        if (!(obj5 instanceof Integer)) {
            iIntValue2 = 0;
        } else {
            iIntValue2 = ((Integer) obj5).intValue();
        }
        int iAj = pr.aj();
        boolean z = obj3 instanceof Integer;
        String str10 = null;
        if (!z || ((Integer) obj3).intValue() == 1) {
            i2 = iAj;
        } else {
            Object obj6 = map.get("action_click_btn");
            if (!(obj6 instanceof String)) {
                str9 = null;
            } else {
                str9 = (String) obj6;
            }
            i2 = iAj;
            remoteViews.setOnClickPendingIntent(i2, pr(str9, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj7 = map.get("action_apa");
        if (obj7 instanceof String) {
            map2.put("apa_click_content_intent", pr((String) obj7, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj8 = map.get("action_complete");
        if (obj8 instanceof String) {
            map2.put("complete_click_content_intent", pr((String) obj8, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj9 = map.get("action_hide");
        if (obj9 instanceof String) {
            map2.put("hide_click_content_intent", pr((String) obj9, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj10 = map.get("enable_notification_ui");
        if (pr(obj10)) {
            remoteViews.setInt(i2, "setBackgroundResource", pr.cz());
            remoteViews.setTextColor(i2, -1);
        }
        Object obj11 = map.get("show_title");
        if (obj11 == null) {
            obj11 = "未命名";
        }
        if (obj11 instanceof String) {
            remoteViews.setTextViewText(pr.w(), (String) obj11);
        }
        if (pr(obj10)) {
            iC = pr.uc();
        } else {
            iC = pr.c();
        }
        remoteViews.setViewVisibility(i2, 0);
        Object obj12 = map.get("percent");
        Object obj13 = map.get("indeterminate");
        if (obj12 != null && obj13 != null) {
            remoteViews.setProgressBar(iC, 100, ((Integer) obj12).intValue(), ((Boolean) obj13).booleanValue());
        }
        if (pr(obj10)) {
            Object obj14 = map.get("bitmap");
            if (obj14 != null) {
                remoteViews.setInt(iVk, "setBackgroundColor", 0);
                remoteViews.setImageViewBitmap(iVk, (Bitmap) obj14);
            } else {
                remoteViews.setInt(iVk, "setBackgroundResource", pr.cz());
            }
        }
        int iZo = pr.zo();
        int iFw = pr.fw();
        int iLb = pr.lb();
        Object obj15 = map.get("is_bind_app");
        boolean z2 = (obj15 instanceof Boolean) && ((Boolean) obj15).booleanValue();
        int iIntValue3 = ((Integer) obj2).intValue();
        String str11 = "";
        if (iIntValue3 == 1 || iIntValue3 == 4) {
            Object obj16 = map.get("download_size");
            if (!(obj16 instanceof String)) {
                str = "";
            } else {
                str = (String) obj16;
            }
            if (iIntValue3 == 1) {
                Object obj17 = map.get("download_status");
                if (obj17 instanceof Integer) {
                    if (((Integer) obj17).intValue() == 11) {
                        str11 = "处理中";
                    } else {
                        str11 = "正在下载";
                    }
                }
            } else {
                str11 = "准备中";
            }
            remoteViews.setViewVisibility(iC, 0);
            remoteViews.setViewVisibility(iFw, 8);
            remoteViews.setViewVisibility(iZo, 0);
            remoteViews.setViewVisibility(i2, z2 ? 8 : 0);
            if (hw(obj10)) {
                remoteViews.setViewVisibility(i2, 8);
            }
            str2 = "暂停";
            str3 = null;
            str4 = str11;
        } else if (iIntValue3 == 2) {
            Object obj18 = map.get("download_size");
            str11 = obj18 instanceof String ? (String) obj18 : "";
            if (z) {
                if (((Integer) obj3).intValue() == 1) {
                    if (((Integer) obj12).intValue() >= ((Integer) map.get("progress_70")).intValue()) {
                        i3 = 0;
                        remoteViews.setViewVisibility(iC, 0);
                        iC = iZo;
                    } else {
                        remoteViews.setViewVisibility(iC, 8);
                        remoteViews.setViewVisibility(iZo, 8);
                        remoteViews.setViewVisibility(iFw, 0);
                        remoteViews.setViewVisibility(iLb, 8);
                        str4 = "下载暂停中，点击继续。";
                    }
                } else {
                    remoteViews.setViewVisibility(iZo, 0);
                    i3 = hw(obj10) ? 0 : 8;
                }
                remoteViews.setViewVisibility(iC, i3);
                remoteViews.setViewVisibility(iFw, 8);
                str4 = "暂停中";
            } else {
                str4 = "暂停中";
            }
            if (z2) {
                str2 = "继续";
                remoteViews.setViewVisibility(i2, 8);
                str3 = str10;
                str = str11;
            } else {
                remoteViews.setViewVisibility(i2, 0);
                if (hw(obj10)) {
                    Object obj19 = map.get("download_size");
                    if (obj19 instanceof String) {
                        str11 = (String) obj19;
                    }
                }
                str3 = null;
                str2 = "继续";
                str = str11;
            }
        } else if (iIntValue3 != 3) {
            str3 = null;
            str4 = "";
            str = str4;
            str2 = str;
        } else {
            Object obj20 = map.get("download_status");
            boolean z3 = obj20 instanceof Integer;
            if (z3) {
                int iIntValue4 = ((Integer) obj20).intValue();
                Object obj21 = map.get("is_network_error");
                Object obj22 = map.get("is_insufficient_space_error");
                if (iIntValue4 == -1 || iIntValue4 == -4) {
                    if (hw(obj10) && iIntValue4 == -1 && (((obj21 instanceof Boolean) && ((Boolean) obj21).booleanValue()) || ((obj22 instanceof Boolean) && ((Boolean) obj22).booleanValue()))) {
                        Object obj23 = map.get("download_size");
                        if (obj23 instanceof String) {
                            str11 = (String) obj23;
                        }
                    }
                    remoteViews.setViewVisibility(iLb, 8);
                    Object obj24 = map.get("is_error_code_insufficient_space_error");
                    Object obj25 = map.get("is_need_show_wait_net_text");
                    if ((obj24 instanceof Boolean) && ((Boolean) obj24).booleanValue()) {
                        str6 = "SdCard空间不足, 下载失败。";
                    } else if ((obj25 instanceof Boolean) && ((Boolean) obj25).booleanValue()) {
                        Object obj26 = map.get("is_wait_wifi");
                        str6 = (obj26 instanceof Boolean) && ((Boolean) obj26).booleanValue() ? "等待wifi开始下载" : "等待网络继续下载";
                    } else {
                        str6 = "下载失败。";
                    }
                    remoteViews.setViewVisibility(i2, 8);
                    if (hw(obj10) && iIntValue4 == -1) {
                        Object obj27 = map.get("is_net_work_error");
                        if ((obj27 instanceof Boolean) && ((Boolean) obj27).booleanValue()) {
                            Object obj28 = map.get("is_wait_wifi_and_in_net");
                            if ((obj28 instanceof Boolean) && ((Boolean) obj28).booleanValue()) {
                                str5 = "无Wi-Fi 已暂停";
                                str2 = "继续";
                            } else {
                                str5 = "下载异常，请检查网络";
                                str2 = "重新下载";
                            }
                        } else {
                            if ((obj22 instanceof Boolean) && ((Boolean) obj22).booleanValue()) {
                                Object obj29 = map.get("download_size_diff");
                                if (obj29 instanceof String) {
                                    str6 = String.format("空间不足 还需%s", (String) obj29);
                                }
                            }
                            str5 = str6;
                            str2 = "重新下载";
                        }
                    } else {
                        str5 = str6;
                        str2 = "重新下载";
                    }
                } else if (iIntValue4 != -3) {
                    str5 = "";
                    str2 = str5;
                } else {
                    Object obj30 = map.get("download_size");
                    if (!(obj30 instanceof String)) {
                        str7 = "";
                    } else {
                        str7 = (String) obj30;
                    }
                    Object obj31 = map.get("is_mime_apk");
                    if ((obj31 instanceof Boolean) && ((Boolean) obj31).booleanValue()) {
                        Object obj32 = map.get("is_apk_installed");
                        if ((obj32 instanceof Boolean) && ((Boolean) obj32).booleanValue()) {
                            str8 = "安装完成，点击打开。";
                            str2 = "打开";
                        } else {
                            str8 = "下载完成，点击安装。";
                            str2 = "安装";
                        }
                    } else {
                        Object obj33 = map.get("is_have_notification_click_callback");
                        if ((obj33 instanceof Boolean) && ((Boolean) obj33).booleanValue()) {
                            str8 = "下载完成，点击打开。";
                            str2 = "";
                        } else {
                            str8 = "下载完成";
                            str2 = "";
                        }
                    }
                    if (((Integer) obj3).intValue() == 1) {
                        remoteViews.setTextViewText(i2, str2);
                        remoteViews.setViewVisibility(iLb, 8);
                    } else {
                        remoteViews.setViewVisibility(i2, 8);
                    }
                    str11 = str7;
                    str5 = str8;
                    str10 = str5;
                }
                remoteViews.setViewVisibility(iC, 8);
                remoteViews.setViewVisibility(iFw, 0);
                remoteViews.setViewVisibility(iZo, 8);
            } else {
                str5 = "";
                str2 = str5;
            }
            Object obj34 = map.get("is_network_error");
            Object obj35 = map.get("is_insufficient_space_error");
            if (hw(obj10) && z3 && ((Integer) obj20).intValue() == -1 && (((obj34 instanceof Boolean) && ((Boolean) obj34).booleanValue()) || ((obj35 instanceof Boolean) && ((Boolean) obj35).booleanValue()))) {
                remoteViews.setViewVisibility(iC, 0);
                remoteViews.setViewVisibility(iFw, 8);
                remoteViews.setViewVisibility(iZo, 0);
                Object obj36 = map.get("is_wait_wifi_and_in_net");
                if ((obj36 instanceof Boolean) && ((Boolean) obj36).booleanValue()) {
                    remoteViews.setViewVisibility(i2, 0);
                    Object obj37 = map.get("download_size");
                    if (obj37 instanceof String) {
                        str11 = (String) obj37;
                    }
                    str4 = str5;
                    str3 = str10;
                    str = str11;
                } else {
                    str4 = str5;
                    remoteViews.setViewVisibility(i2, 8);
                    str3 = str10;
                    str = str11;
                }
            } else {
                str4 = str5;
                str3 = str10;
                str = str11;
            }
        }
        remoteViews.setTextViewText(pr.yb(), str);
        remoteViews.setTextViewText(pr.qa(), str4);
        remoteViews.setTextViewText(iLb, str);
        remoteViews.setTextViewText(pr.a(), str4);
        if (TextUtils.isEmpty(str2)) {
            remoteViews.setViewVisibility(i2, 8);
        } else {
            remoteViews.setTextViewText(i2, str2);
        }
        try {
            if (hw(this.hw)) {
                remoteViews.setInt(pr.x(), "setBackgroundColor", Color.parseColor("#fffafafa"));
            }
        } catch (Throwable th) {
        }
        map2.put("remote_views", remoteViews);
        map2.put("builder_content_type", str3);
        return map2;
    }

    private Pair<Intent, Boolean> pr(Context context, long j, boolean z) {
        if (z) {
            return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandlerService.class), Boolean.FALSE);
    }

    private PendingIntent pr(String str, int i, int i2, boolean z, String str2) {
        Pair<Intent, Boolean> pairPr = pr(this.hw, i2, z);
        Intent intent = (Intent) pairPr.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        return pr(this.hw, pairPr, i2);
    }

    private PendingIntent pr(String str, int i, int i2, boolean z, String str2, String str3, String str4, String str5) {
        Pair<Intent, Boolean> pairPr = pr(this.hw, i2, z);
        Intent intent = (Intent) pairPr.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        intent.putExtra("extra_tag", str3);
        intent.putExtra("extra_value", str4);
        intent.putExtra("extra_log_extra", str5);
        return pr(this.hw, pairPr, i2);
    }

    private PendingIntent pr(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }

    public static boolean hw(Context context) {
        if (context == null) {
            return false;
        }
        TypedArray typedArrayObtainStyledAttributes = null;
        try {
            try {
                int color = Color.parseColor("#7f0b0198");
                typedArrayObtainStyledAttributes = context.obtainStyledAttributes(pr.hn(), new int[]{pr.pr(), pr.hw()});
                if (color == typedArrayObtainStyledAttributes.getColor(0, 0)) {
                    if (typedArrayObtainStyledAttributes != null) {
                        try {
                            typedArrayObtainStyledAttributes.recycle();
                        } catch (Throwable th) {
                        }
                    }
                    return true;
                }
                if (typedArrayObtainStyledAttributes != null) {
                    typedArrayObtainStyledAttributes.recycle();
                }
                return false;
            } catch (Throwable th2) {
                if (typedArrayObtainStyledAttributes != null) {
                    typedArrayObtainStyledAttributes.recycle();
                }
                return false;
            }
        } catch (Throwable th3) {
        }
    }

    private boolean pr(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() > 0;
    }

    private boolean hw(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() >= 2;
    }

    private int pr(int i, boolean z) {
        if (z) {
            return pr.rc();
        }
        if (i == 1 || i == 4) {
            return pr.ny();
        }
        if (i == 2) {
            return pr.fo();
        }
        if (i != 3) {
            return 0;
        }
        return pr.rc();
    }

    public Uri pr(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(str)) {
            return FileProvider.getUriForFile(this.hw, str, new File(str2));
        }
        return Uri.fromFile(new File(str2));
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Map<String, Object> map;
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        int iIntValue = valueSetHw.intValue(-99999987);
        Class cls = (Class) valueSetHw.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return com.byazt.ij.hn.pr().pr(10000, 3).hw().sparseArray();
        }
        if (valueSetHw.objectValue(0, Map.class) != null) {
            map = (Map) valueSetHw.objectValue(0, Map.class);
        } else {
            map = new HashMap<>();
        }
        return pr(cls, iIntValue, map);
    }
}
