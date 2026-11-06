package com.byazt.im;

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
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.anythink.core.common.f.k;
import com.byazt.vx.w;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 147, 8})
public final class s implements Function<SparseArray<Object>, Object> {
    public static final int CANCELED = -4;
    public static final int DOWNLOAD_COMPLETE_HANDLE = 11;
    public static final int FAILED = -1;
    public static final int START = 2;
    public static final int SUCCESSED = -3;
    public static final int TYPE_ACTIVE = 1;
    public static final int TYPE_COMPLETE = 3;
    public static final int TYPE_PREPARE = 4;
    public static final int TYPE_WAITING = 2;
    public static volatile s n;
    public final Context qg;
    public Function<SparseArray<Object>, Object> s;

    private s(Context context) {
        this.qg = context;
    }

    public static s n() {
        return n;
    }

    public static s n(Context context) {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s(context);
                }
            }
        }
        return n;
    }

    public <T> T n(Class<T> cls, int i, Map<String, Object> map) {
        w.qg("xgc_dl", "api:".concat(String.valueOf(i)));
        if (i == 0) {
            if (this.s != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 0);
                sparseArray.put(0, map);
                return (T) this.s.apply(sparseArray);
            }
            return (T) Boolean.FALSE;
        }
        if (i == 159) {
            if (map != null) {
                Object obj = map.get(com.byazt.ug.n.n);
                if (obj instanceof Function) {
                    this.s = (Function) obj;
                }
            }
            return null;
        }
        if (i == 161) {
            return (T) qg(map);
        }
        if (i == 155) {
            return (T) n((String) map.get("custom_authority"), (String) map.get("custom_file_path"));
        }
        if (i != 156) {
            return null;
        }
        return (T) n(map);
    }

    public void n(Map<String, Object> map, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(0, map);
        Function<SparseArray<Object>, Object> function = this.s;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    private NotificationCompat.Builder n(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.qg);
        }
        try {
            return new NotificationCompat.Builder(this.qg, str);
        } catch (NoSuchMethodError unused) {
            return new NotificationCompat.Builder(this.qg);
        }
    }

    private Map<String, Object> n(Map<String, Object> map) {
        Map<String, Object> map2;
        if (map == null || (map2 = (Map) map.get("params")) == null) {
            return null;
        }
        Map<String, Object> mapS = s(map2);
        Object obj = mapS.get("remote_views");
        Object obj2 = mapS.get("builder_content_type");
        int iIntValue = ((Integer) map2.get("notification_type")).intValue();
        String str = (String) map2.get("channel_id");
        int iIntValue2 = ((Integer) map2.get("download_status")).intValue();
        NotificationCompat.Builder builderN = n(str);
        builderN.setWhen(((Long) map2.get("first_time")).longValue());
        Object obj3 = map2.get("notification_group");
        if (obj3 != null && (obj3 instanceof String)) {
            builderN.setGroup((String) obj3);
            builderN.setGroupSummary(false);
        }
        builderN.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        if (iIntValue == 1 || iIntValue == 4 || iIntValue == 2) {
            builderN.setContentIntent((PendingIntent) mapS.get("apa_click_content_intent"));
            builderN.setAutoCancel(false);
        } else if (iIntValue == 3) {
            builderN.setAutoCancel(true);
            if (iIntValue2 == -3) {
                Object obj4 = map2.get("auto_cancel");
                if ((obj4 instanceof Boolean) && ((Boolean) obj4).booleanValue()) {
                    builderN.setAutoCancel(false);
                }
            }
            builderN.setContentIntent((PendingIntent) mapS.get("complete_click_content_intent"));
            builderN.setDeleteIntent((PendingIntent) mapS.get("hide_click_content_intent"));
        }
        if (iIntValue == 3 && iIntValue2 == -3 && (obj2 instanceof String)) {
            builderN.setContentText((String) obj2);
        }
        Object obj5 = mapS.get("builder_small_icon");
        if (obj5 instanceof Integer) {
            builderN.setSmallIcon(((Integer) obj5).intValue());
        }
        Notification notificationBuild = builderN.build();
        notificationBuild.contentView = (RemoteViews) obj;
        mapS.put("notification", notificationBuild);
        return mapS;
    }

    private Map<String, Object> qg(Map<String, Object> map) {
        String strConcat;
        String str;
        String str2;
        String str3;
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        String str4 = (String) map.get("install_app_name");
        Bitmap bitmap = (Bitmap) map.get("install_icon_bitmap");
        String str5 = (String) map.get("install_action_type");
        Object obj = map.get("install_click_type");
        String str6 = (String) map.get("install_package_name");
        String str7 = (String) map.get("install_tag");
        String str8 = (String) map.get("install_value");
        String str9 = (String) map.get("install_log_extra");
        int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
        Object obj2 = map.get("install_download_id");
        int iIntValue2 = obj2 != null ? ((Integer) obj2).intValue() : -1;
        Object obj3 = map.get("install_enable_target_34");
        boolean zBooleanValue = obj3 != null ? ((Boolean) obj3).booleanValue() : false;
        RemoteViews remoteViews = new RemoteViews(this.qg.getPackageName(), this.qg.getResources().getIdentifier("tt_install_notification_layout", "layout", this.qg.getPackageName()));
        int iOa = n.oa();
        int iD = n.d();
        int iSz = n.sz();
        int iK = n.k();
        int iCy = n.cy();
        if (iIntValue == 1) {
            strConcat = "打开".concat(String.valueOf(str4));
            str = "应用已安装完成";
            str2 = "去打开";
        } else {
            strConcat = "安装".concat(String.valueOf(str4));
            str = "应用已下载完成";
            str2 = "去安装";
        }
        String str10 = str;
        String str11 = strConcat;
        remoteViews.setTextViewText(iD, str10);
        remoteViews.setTextViewText(iSz, str11);
        remoteViews.setTextViewText(iK, str2);
        int iHu = n.hu();
        if (iHu == 0 && (iHu = n.m()) == 0) {
            iHu = n.ou();
        }
        int i = iHu;
        remoteViews.setImageViewIcon(iOa, Icon.createWithBitmap(bitmap));
        PendingIntent pendingIntentN = n(str5, iIntValue, iIntValue2, zBooleanValue, str6, str7, str8, str9);
        remoteViews.setOnClickPendingIntent(iCy, pendingIntentN);
        remoteViews.setOnClickPendingIntent(iK, pendingIntentN);
        String str12 = "csj_" + this.qg.getPackageName();
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(str12, "csj_install", 4);
                notificationChannel.setShowBadge(true);
                notificationChannel.setBypassDnd(true);
                str3 = "notification";
                try {
                    ((NotificationManager) this.qg.getSystemService(str3)).createNotificationChannel(notificationChannel);
                } catch (Throwable th) {
                    th = th;
                    w.n(th);
                }
            } else {
                str3 = "notification";
            }
        } catch (Throwable th2) {
            th = th2;
            str3 = "notification";
        }
        NotificationCompat.Builder builderN = n(str12);
        builderN.setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setContentIntent(pendingIntentN).setSmallIcon(i).setContentTitle(str10).setContentText(str11).setPriority(1).setDefaults(-1).setVisibility(1).setAutoCancel(true);
        Notification notificationBuild = builderN.build();
        notificationBuild.contentView = remoteViews;
        map2.put(str3, notificationBuild);
        return map2;
    }

    /* JADX WARN: Code duplicated, block: B:252:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:253:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:256:0x04ed  */
    private Map<String, Object> s(Map<String, Object> map) {
        int i;
        int iL;
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        String str5;
        Object obj;
        String str6;
        int i3;
        int i4;
        int i5;
        RemoteViews remoteViews = new RemoteViews(this.qg.getPackageName(), this.qg.getResources().getIdentifier("tt_adl_notification_layout", "layout", this.qg.getPackageName()));
        HashMap map2 = new HashMap();
        Object obj2 = map.get("csj_enable_target_34");
        boolean zBooleanValue = obj2 != null ? ((Boolean) obj2).booleanValue() : false;
        int iTj = n.tj();
        Object obj3 = map.get("notification_type");
        Object obj4 = map.get("notification_opt_2");
        int iHu = n.hu();
        int i6 = iHu != 0 ? iHu : 0;
        if ((obj3 instanceof Integer) && (obj4 instanceof Integer)) {
            int iN = n(((Integer) obj3).intValue(), ((Integer) obj4).intValue() == 1);
            remoteViews.setImageViewResource(iTj, iN);
            if (iN != 0 && iHu == 0) {
                i6 = iN;
            }
        }
        map2.put("builder_small_icon", Integer.valueOf(i6));
        Object obj5 = map.get("click_type");
        int iIntValue = obj5 instanceof Integer ? ((Integer) obj5).intValue() : 0;
        Object obj6 = map.get("click_download_id");
        int iIntValue2 = obj6 instanceof Integer ? ((Integer) obj6).intValue() : 0;
        int iRv = n.rv();
        boolean z = obj4 instanceof Integer;
        String str7 = null;
        if (!z || ((Integer) obj4).intValue() == 1) {
            i = iRv;
        } else {
            Object obj7 = map.get("action_click_btn");
            i = iRv;
            remoteViews.setOnClickPendingIntent(i, n(obj7 instanceof String ? (String) obj7 : null, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj8 = map.get("action_apa");
        if (obj8 instanceof String) {
            map2.put("apa_click_content_intent", n((String) obj8, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj9 = map.get("action_complete");
        if (obj9 instanceof String) {
            map2.put("complete_click_content_intent", n((String) obj9, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj10 = map.get("action_hide");
        if (obj10 instanceof String) {
            map2.put("hide_click_content_intent", n((String) obj10, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj11 = map.get("enable_notification_ui");
        if (n(obj11)) {
            remoteViews.setInt(i, "setBackgroundResource", n.py());
            remoteViews.setTextColor(i, -1);
        }
        Object obj12 = map.get("show_title");
        if (obj12 == null) {
            obj12 = "未命名";
        }
        if (obj12 instanceof String) {
            remoteViews.setTextViewText(n.cp(), (String) obj12);
        }
        if (n(obj11)) {
            iL = n.w();
        } else {
            iL = n.l();
        }
        remoteViews.setViewVisibility(i, 0);
        Object obj13 = map.get("percent");
        Object obj14 = map.get("indeterminate");
        if (obj13 != null && obj14 != null) {
            remoteViews.setProgressBar(iL, 100, ((Integer) obj13).intValue(), ((Boolean) obj14).booleanValue());
        }
        if (n(obj11)) {
            Object obj15 = map.get("bitmap");
            if (obj15 != null) {
                remoteViews.setInt(iTj, "setBackgroundColor", 0);
                remoteViews.setImageViewBitmap(iTj, (Bitmap) obj15);
            } else {
                remoteViews.setInt(iTj, "setBackgroundResource", n.py());
            }
        }
        int iFs = n.fs();
        int iX = n.x();
        int iCd = n.cd();
        Object obj16 = map.get("is_bind_app");
        boolean z2 = (obj16 instanceof Boolean) && ((Boolean) obj16).booleanValue();
        int iIntValue3 = ((Integer) obj3).intValue();
        String str8 = "";
        if (iIntValue3 == 1 || iIntValue3 == 4) {
            Object obj17 = map.get(k.a.e);
            str = obj17 instanceof String ? (String) obj17 : "";
            if (iIntValue3 == 1) {
                Object obj18 = map.get("download_status");
                if (obj18 instanceof Integer) {
                    if (((Integer) obj18).intValue() == 11) {
                        str2 = "处理中";
                    } else {
                        str8 = "正在下载";
                    }
                }
                remoteViews.setViewVisibility(iL, 0);
                remoteViews.setViewVisibility(iX, 8);
                remoteViews.setViewVisibility(iFs, 0);
                if (z2) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                remoteViews.setViewVisibility(i, i2);
                if (qg(obj11)) {
                    remoteViews.setViewVisibility(i, 8);
                }
                str3 = "暂停";
                str4 = null;
                str5 = str8;
            } else {
                str2 = "准备中";
            }
            str8 = str2;
            remoteViews.setViewVisibility(iL, 0);
            remoteViews.setViewVisibility(iX, 8);
            remoteViews.setViewVisibility(iFs, 0);
            if (z2) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            remoteViews.setViewVisibility(i, i2);
            if (qg(obj11)) {
                remoteViews.setViewVisibility(i, 8);
            }
            str3 = "暂停";
            str4 = null;
            str5 = str8;
        } else if (iIntValue3 == 2) {
            Object obj19 = map.get(k.a.e);
            str8 = obj19 instanceof String ? (String) obj19 : "";
            if (z) {
                if (((Integer) obj4).intValue() == 1) {
                    if (((Integer) obj13).intValue() >= ((Integer) map.get("progress_70")).intValue()) {
                        i5 = 0;
                        remoteViews.setViewVisibility(iL, 0);
                        iL = iFs;
                        i4 = 8;
                    } else {
                        remoteViews.setViewVisibility(iL, 8);
                        remoteViews.setViewVisibility(iFs, 8);
                        remoteViews.setViewVisibility(iX, 0);
                        remoteViews.setViewVisibility(iCd, 8);
                        str5 = "下载暂停中，点击继续。";
                    }
                } else {
                    i4 = 8;
                    remoteViews.setViewVisibility(iFs, 0);
                    i5 = qg(obj11) ? 0 : 8;
                }
                remoteViews.setViewVisibility(iL, i5);
                remoteViews.setViewVisibility(iX, i4);
                str5 = "暂停中";
            } else {
                str5 = "暂停中";
            }
            if (!z2) {
                remoteViews.setViewVisibility(i, 0);
                if (qg(obj11)) {
                    Object obj20 = map.get(k.a.e);
                    if (obj20 instanceof String) {
                        str8 = (String) obj20;
                    }
                }
                str4 = null;
                str = str8;
                str3 = "继续";
            } else {
                str = str8;
                str8 = "继续";
                remoteViews.setViewVisibility(i, 8);
                str4 = str7;
                str3 = str8;
            }
        } else if (iIntValue3 == 3) {
            Object obj21 = map.get("download_status");
            boolean z3 = obj21 instanceof Integer;
            if (z3) {
                int iIntValue4 = ((Integer) obj21).intValue();
                Object obj22 = map.get("is_network_error");
                Object obj23 = map.get("is_insufficient_space_error");
                if (iIntValue4 == -1 || iIntValue4 == -4) {
                    if (qg(obj11) && iIntValue4 == -1 && (((obj22 instanceof Boolean) && ((Boolean) obj22).booleanValue()) || ((obj23 instanceof Boolean) && ((Boolean) obj23).booleanValue()))) {
                        Object obj24 = map.get(k.a.e);
                        if (obj24 instanceof String) {
                            str8 = (String) obj24;
                        }
                    }
                    remoteViews.setViewVisibility(iCd, 8);
                    Object obj25 = map.get("is_error_code_insufficient_space_error");
                    Object obj26 = map.get("is_need_show_wait_net_text");
                    if ((obj25 instanceof Boolean) && ((Boolean) obj25).booleanValue()) {
                        str6 = "SdCard空间不足, 下载失败。";
                    } else if ((obj26 instanceof Boolean) && ((Boolean) obj26).booleanValue()) {
                        Object obj27 = map.get("is_wait_wifi");
                        str6 = (obj27 instanceof Boolean) && ((Boolean) obj27).booleanValue() ? "等待wifi开始下载" : "等待网络继续下载";
                    } else {
                        str6 = "下载失败。";
                    }
                    remoteViews.setViewVisibility(i, 8);
                    if (qg(obj11) && iIntValue4 == -1) {
                        Object obj28 = map.get("is_net_work_error");
                        if ((obj28 instanceof Boolean) && ((Boolean) obj28).booleanValue()) {
                            Object obj29 = map.get("is_wait_wifi_and_in_net");
                            if ((obj29 instanceof Boolean) && ((Boolean) obj29).booleanValue()) {
                                str6 = "无Wi-Fi 已暂停";
                                str = str8;
                                str8 = "继续";
                            } else {
                                str6 = "下载异常，请检查网络";
                            }
                        } else if ((obj23 instanceof Boolean) && ((Boolean) obj23).booleanValue()) {
                            Object obj30 = map.get("download_size_diff");
                            if (obj30 instanceof String) {
                                str6 = String.format("空间不足 还需%s", (String) obj30);
                            }
                        }
                    }
                    str = str8;
                    i3 = 8;
                    str8 = "重新下载";
                    remoteViews.setViewVisibility(iL, i3);
                    remoteViews.setViewVisibility(iX, 0);
                    remoteViews.setViewVisibility(iFs, i3);
                    obj = "is_network_error";
                } else if (iIntValue4 == -3) {
                    Object obj31 = map.get(k.a.e);
                    str = obj31 instanceof String ? (String) obj31 : "";
                    Object obj32 = map.get("is_mime_apk");
                    if ((obj32 instanceof Boolean) && ((Boolean) obj32).booleanValue()) {
                        Object obj33 = map.get("is_apk_installed");
                        if ((obj33 instanceof Boolean) && ((Boolean) obj33).booleanValue()) {
                            str6 = "安装完成，点击打开。";
                            str8 = "打开";
                        } else {
                            str6 = "下载完成，点击安装。";
                            str8 = "安装";
                        }
                    } else {
                        Object obj34 = map.get("is_have_notification_click_callback");
                        str6 = ((obj34 instanceof Boolean) && ((Boolean) obj34).booleanValue()) ? "下载完成，点击打开。" : "下载完成";
                    }
                    String str9 = str8;
                    if (((Integer) obj4).intValue() == 1) {
                        remoteViews.setTextViewText(i, str9);
                        remoteViews.setViewVisibility(iCd, 8);
                    } else {
                        remoteViews.setViewVisibility(i, 8);
                    }
                    str7 = str6;
                    str8 = str9;
                } else {
                    str = "";
                    str6 = str;
                }
                i3 = 8;
                remoteViews.setViewVisibility(iL, i3);
                remoteViews.setViewVisibility(iX, 0);
                remoteViews.setViewVisibility(iFs, i3);
                obj = "is_network_error";
            } else {
                obj = "is_network_error";
                str = "";
                str6 = str;
            }
            Object obj35 = map.get(obj);
            Object obj36 = map.get("is_insufficient_space_error");
            if (qg(obj11) && z3 && ((Integer) obj21).intValue() == -1 && (((obj35 instanceof Boolean) && ((Boolean) obj35).booleanValue()) || ((obj36 instanceof Boolean) && ((Boolean) obj36).booleanValue()))) {
                remoteViews.setViewVisibility(iL, 0);
                remoteViews.setViewVisibility(iX, 8);
                remoteViews.setViewVisibility(iFs, 0);
                Object obj37 = map.get("is_wait_wifi_and_in_net");
                if ((obj37 instanceof Boolean) && ((Boolean) obj37).booleanValue()) {
                    remoteViews.setViewVisibility(i, 0);
                    Object obj38 = map.get(k.a.e);
                    str = obj38 instanceof String ? (String) obj38 : str;
                } else {
                    str5 = str6;
                    remoteViews.setViewVisibility(i, 8);
                    str4 = str7;
                    str3 = str8;
                }
            }
            str5 = str6;
            str4 = str7;
            str3 = str8;
        } else {
            str4 = null;
            str5 = "";
            str3 = str5;
            str = str3;
        }
        remoteViews.setTextViewText(n.hd(), str);
        remoteViews.setTextViewText(n.um(), str5);
        remoteViews.setTextViewText(iCd, str);
        remoteViews.setTextViewText(n.a(), str5);
        if (TextUtils.isEmpty(str3)) {
            remoteViews.setViewVisibility(i, 8);
        } else {
            remoteViews.setTextViewText(i, str3);
        }
        try {
            if (qg(this.qg)) {
                remoteViews.setInt(n.q(), "setBackgroundColor", Color.parseColor("#fffafafa"));
            }
        } catch (Throwable unused) {
        }
        map2.put("remote_views", remoteViews);
        map2.put("builder_content_type", str4);
        return map2;
    }

    private Pair<Intent, Boolean> n(Context context, long j, boolean z) {
        if (z) {
            return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandlerService.class), Boolean.FALSE);
    }

    private PendingIntent n(String str, int i, int i2, boolean z, String str2) {
        Pair<Intent, Boolean> pairN = n(this.qg, i2, z);
        Intent intent = (Intent) pairN.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        return n(this.qg, pairN, i2);
    }

    private PendingIntent n(String str, int i, int i2, boolean z, String str2, String str3, String str4, String str5) {
        Pair<Intent, Boolean> pairN = n(this.qg, i2, z);
        Intent intent = (Intent) pairN.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        intent.putExtra("extra_tag", str3);
        intent.putExtra("extra_value", str4);
        intent.putExtra("extra_log_extra", str5);
        return n(this.qg, pairN, i2);
    }

    private PendingIntent n(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0030 A[EXC_TOP_SPLITTER, PHI: r5
      0x0030: PHI (r5v3 android.content.res.TypedArray) = (r5v2 android.content.res.TypedArray), (r5v4 android.content.res.TypedArray) binds: [B:15:0x0035, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static boolean qg(Context context) {
        TypedArray typedArrayObtainStyledAttributes;
        if (context == null) {
            return false;
        }
        try {
            int color = Color.parseColor("#7f0b0198");
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(n.s(), new int[]{n.n(), n.qg()});
            try {
                if (color == typedArrayObtainStyledAttributes.getColor(0, 0)) {
                    if (typedArrayObtainStyledAttributes != null) {
                        try {
                            typedArrayObtainStyledAttributes.recycle();
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
                if (typedArrayObtainStyledAttributes != null) {
                    try {
                        typedArrayObtainStyledAttributes.recycle();
                    } catch (Throwable unused2) {
                    }
                }
                return false;
            } catch (Throwable unused3) {
                if (typedArrayObtainStyledAttributes != null) {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        } catch (Throwable unused4) {
            typedArrayObtainStyledAttributes = null;
        }
    }

    private boolean n(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() > 0;
    }

    private boolean qg(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() >= 2;
    }

    private int n(int i, boolean z) {
        if (z) {
            return n.m();
        }
        if (i == 1 || i == 4) {
            return n.ou();
        }
        if (i == 2) {
            return n.wm();
        }
        if (i == 3) {
            return n.m();
        }
        return 0;
    }

    public Uri n(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return FileProvider.getUriForFile(this.qg, str, new File(str2));
        }
        return Uri.fromFile(new File(str2));
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Map<String, Object> map;
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        int iIntValue = valueSetQg.intValue(-99999987);
        Class cls = (Class) valueSetQg.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return com.byazt.qvu.s.n().n(10000, 3).qg().sparseArray();
        }
        if (valueSetQg.objectValue(0, Map.class) != null) {
            map = (Map) valueSetQg.objectValue(0, Map.class);
        } else {
            map = new HashMap<>();
        }
        return n(cls, iIntValue, map);
    }
}
