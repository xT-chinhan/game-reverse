package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.taptap.sdk.compliance.constants.BundleKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class InteractionInfo implements Parcelable {
    public static final Parcelable.Creator<InteractionInfo> CREATOR = new a();
    private static final String TAG = "InteractionInfo";
    public final String deepLinkUrl;
    public String extra;
    public JSONObject extraObject;
    public final int floatingLayerStyle;
    private final int floatingLayerStyleStartDownload;
    public int interactionType;
    public final int landingType;
    public final String landingUrl;
    public final int triggerStyle;
    public final WxMiniProgramInfo wxMiniProgramInfo;

    static class a implements Parcelable.Creator<InteractionInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InteractionInfo createFromParcel(Parcel parcel) {
            return new InteractionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InteractionInfo[] newArray(int i) {
            return new InteractionInfo[i];
        }
    }

    protected InteractionInfo(Parcel parcel) {
        this.extra = "";
        this.interactionType = parcel.readInt();
        this.deepLinkUrl = parcel.readString();
        this.landingUrl = parcel.readString();
        this.floatingLayerStyle = parcel.readInt();
        this.triggerStyle = parcel.readInt();
        this.landingType = parcel.readInt();
        this.wxMiniProgramInfo = (WxMiniProgramInfo) parcel.readParcelable(WxMiniProgramInfo.class.getClassLoader());
        this.extra = parcel.readString();
        try {
            this.extraObject = new JSONObject(this.extra);
        } catch (JSONException unused) {
        }
        this.floatingLayerStyleStartDownload = parcel.readInt();
    }

    public InteractionInfo(TapAdResp.r rVar) {
        WxMiniProgramInfo wxMiniProgramInfo;
        this.extra = "";
        int iIntValue = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("interaction_type", Integer.class, -1)).intValue();
        int iIntValue2 = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("landing_type", Integer.class, -1)).intValue();
        this.deepLinkUrl = rVar.o2();
        int iIntValue3 = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("trigger_style", Integer.class, -1)).intValue();
        this.triggerStyle = iIntValue3 == -1 ? rVar.i2() : iIntValue3;
        int iIntValue4 = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("float_layer_style", Integer.class, -1)).intValue();
        this.floatingLayerStyle = iIntValue4 == -1 ? rVar.f3() : iIntValue4;
        this.extra = rVar.a();
        try {
            this.extraObject = new JSONObject(rVar.a());
        } catch (Throwable th) {
            Log.i(TAG, th.getMessage());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            int iIntValue5 = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("shake_angle", Integer.class, -1)).intValue();
            if (iIntValue5 > 0) {
                jSONObject.put("shake_angle", iIntValue5);
                JSONObject jSONObject2 = this.extraObject;
                if (jSONObject2 != null && jSONObject2.has("shake_angle")) {
                    this.extraObject.remove("shake_angle");
                    this.extraObject.put("shake_angle", iIntValue5);
                }
            }
            if (this.extraObject == null) {
                this.extraObject = jSONObject;
            }
        } catch (Throwable th2) {
            Log.i(TAG, th2.getMessage());
        }
        if (iIntValue == -1) {
            this.landingUrl = rVar.V2();
            this.landingType = rVar.M0();
            this.wxMiniProgramInfo = new WxMiniProgramInfo(rVar.Q2());
            this.interactionType = rVar.G3();
        } else {
            String strV2 = "https://adn.tapapis.cn/dev-engine-g3/bid/wx302";
            if (iIntValue == 4) {
                this.interactionType = 4;
                if (iIntValue2 == 1) {
                    this.landingType = 1;
                    strV2 = rVar.V2();
                } else {
                    this.landingType = 2;
                }
                this.landingUrl = strV2;
                wxMiniProgramInfo = new WxMiniProgramInfo("gh_222569bab786", "", "wx0f2b0cfc3d31045f", "com.xindong.rocket");
            } else {
                this.interactionType = iIntValue;
                if (iIntValue != 3 || iIntValue2 == -1) {
                    this.landingUrl = rVar.V2();
                    this.landingType = rVar.M0();
                    wxMiniProgramInfo = new WxMiniProgramInfo(rVar.Q2());
                } else {
                    if (iIntValue2 == 1) {
                        this.landingType = 1;
                    } else {
                        if (iIntValue2 == 3) {
                            this.landingType = 3;
                            strV2 = "https://adn.tapapis.cn/dev-engine-g3/bid/download";
                        } else if (iIntValue2 == 2) {
                            this.landingType = 2;
                        } else {
                            this.landingType = 0;
                        }
                        this.landingUrl = strV2;
                        wxMiniProgramInfo = new WxMiniProgramInfo(rVar.Q2());
                    }
                    strV2 = rVar.V2();
                    this.landingUrl = strV2;
                    wxMiniProgramInfo = new WxMiniProgramInfo(rVar.Q2());
                }
            }
            this.wxMiniProgramInfo = wxMiniProgramInfo;
        }
        this.floatingLayerStyleStartDownload = rVar.f2();
    }

    public boolean canStartDownloadInFloatingLayer() {
        return 1 == this.floatingLayerStyleStartDownload;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean extractCloseTransferEnable() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_btn_close_transfer_activate", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_btn_close_transfer_activate", Integer.class, -1)).intValue() == 1;
        }
        try {
            JSONObject jSONObject = this.extraObject;
            return jSONObject != null && jSONObject.getInt("btn_close_transfer_activate") == 1;
        } catch (Throwable unused) {
        }
    }

    public boolean extractHotZoneInVideo() {
        try {
            JSONObject jSONObject = this.extraObject;
            return jSONObject != null && jSONObject.has("interstitial_video_hot_zone") && this.extraObject.optInt("interstitial_video_hot_zone", 0) == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public float extractShakeAngle() {
        try {
            JSONObject jSONObject = this.extraObject;
            if (jSONObject == null || !jSONObject.has("shake_angle")) {
                return 120.0f;
            }
            return this.extraObject.getInt("shake_angle");
        } catch (Throwable unused) {
            return 120.0f;
        }
    }

    public boolean extractShakeV2Enable() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("shake_v2_enable", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("shake_v2_enable", Integer.class, -1)).intValue() == 1;
        }
        try {
            JSONObject jSONObject = this.extraObject;
            return jSONObject != null && jSONObject.has("shake_v2_enable") && this.extraObject.getInt("shake_v2_enable") == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public String extractWaitInteractionContent() {
        try {
            JSONObject jSONObject = this.extraObject;
            return (jSONObject != null && jSONObject.has("auto_interaction_info") && this.extraObject.getJSONObject("auto_interaction_info").has("content")) ? this.extraObject.getJSONObject("auto_interaction_info").getString("content") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public String extractWaitInteractionDescription() {
        try {
            JSONObject jSONObject = this.extraObject;
            return (jSONObject != null && jSONObject.has("auto_interaction_info") && this.extraObject.getJSONObject("auto_interaction_info").has(BundleKey.DESCRIPTION)) ? this.extraObject.getJSONObject("auto_interaction_info").getString(BundleKey.DESCRIPTION) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public boolean extractWaitInteractionEnable() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_wait_interaction_enable", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_wait_interaction_enable", Integer.class, -1)).intValue() == 1;
        }
        try {
            JSONObject jSONObject = this.extraObject;
            return jSONObject != null && jSONObject.getInt("wait_interaction_enable") == 1;
        } catch (Throwable unused) {
        }
    }

    public String extractWaitInteractionIconUrl() {
        try {
            JSONObject jSONObject = this.extraObject;
            return (jSONObject != null && jSONObject.has("auto_interaction_info") && this.extraObject.getJSONObject("auto_interaction_info").has("icon_image")) ? this.extraObject.getJSONObject("auto_interaction_info").getString("icon_image") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public int extractWaitInteractionTime() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_auto_interaction_wait_time", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_auto_interaction_wait_time", Integer.class, -1)).intValue();
        }
        try {
            JSONObject jSONObject = this.extraObject;
            if (jSONObject != null && jSONObject.has("auto_interaction_info") && this.extraObject.getJSONObject("auto_interaction_info").has("wait_time")) {
                return this.extraObject.getJSONObject("auto_interaction_info").getInt("wait_time");
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public int extractXShakeDegree() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_x_degree", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_x_degree", Integer.class, -1)).intValue();
        }
        try {
            JSONObject jSONObject = this.extraObject;
            if (jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("x_degree")) {
                return this.extraObject.getJSONObject("shake_params").getInt("x_degree");
            }
            return 120;
        } catch (Throwable unused) {
            return 120;
        }
    }

    public boolean extractXShakeDegreeEnable() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_x_degree_enable", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_x_degree_enable", Integer.class, -1)).intValue() == 1;
        }
        try {
            JSONObject jSONObject = this.extraObject;
            return jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("x_degree_enable") && this.extraObject.getJSONObject("shake_params").getInt("x_degree_enable") == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public float extractXShakeSpeed() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_x_speed", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_x_speed", Integer.class, -1)).intValue();
        }
        try {
            JSONObject jSONObject = this.extraObject;
            if (jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("x_speed")) {
                return this.extraObject.getJSONObject("shake_params").getInt("x_speed");
            }
            return 30.0f;
        } catch (Throwable unused) {
            return 30.0f;
        }
    }

    public boolean extractXShakeSpeedEnable() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_x_speed_enable", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_x_speed_enable", Integer.class, -1)).intValue() == 1;
        }
        try {
            JSONObject jSONObject = this.extraObject;
            return jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("x_speed_enable") && this.extraObject.getJSONObject("shake_params").getInt("x_speed_enable") == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public int extractYShakeDegree() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_y_degree", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_y_degree", Integer.class, -1)).intValue();
        }
        try {
            JSONObject jSONObject = this.extraObject;
            if (jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("y_degree")) {
                return this.extraObject.getJSONObject("shake_params").getInt("y_degree");
            }
            return 120;
        } catch (Throwable unused) {
            return 120;
        }
    }

    public boolean extractYShakeDegreeEnable() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_y_degree_enable", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_y_degree_enable", Integer.class, -1)).intValue() == 1;
        }
        try {
            JSONObject jSONObject = this.extraObject;
            return jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("y_degree_enable") && this.extraObject.getJSONObject("shake_params").getInt("y_degree_enable") == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public float extractYShakeSpeed() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_y_speed", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_y_speed", Integer.class, -1)).intValue();
        }
        try {
            JSONObject jSONObject = this.extraObject;
            if (jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("y_speed")) {
                return this.extraObject.getJSONObject("shake_params").getInt("y_speed");
            }
            return 30.0f;
        } catch (Throwable unused) {
            return 30.0f;
        }
    }

    public boolean extractYShakeSpeedEnable() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_y_speed_enable", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_y_speed_enable", Integer.class, -1)).intValue() == 1;
        }
        try {
            JSONObject jSONObject = this.extraObject;
            return jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("y_speed_enable") && this.extraObject.getJSONObject("shake_params").getInt("y_speed_enable") == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public int extractZShakeDegree() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_z_degree", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_z_degree", Integer.class, -1)).intValue();
        }
        try {
            JSONObject jSONObject = this.extraObject;
            if (jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("z_degree")) {
                return this.extraObject.getJSONObject("shake_params").getInt("z_degree");
            }
            return 120;
        } catch (Throwable unused) {
            return 120;
        }
    }

    public boolean extractZShakeDegreeEnable() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_z_degree_enable", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_z_degree_enable", Integer.class, -1)).intValue() == 1;
        }
        try {
            JSONObject jSONObject = this.extraObject;
            return jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("z_degree_enable") && this.extraObject.getJSONObject("shake_params").getInt("z_degree_enable") == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public float extractZShakeSpeed() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_z_speed", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_z_speed", Integer.class, -1)).intValue();
        }
        try {
            JSONObject jSONObject = this.extraObject;
            if (jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("z_speed")) {
                return this.extraObject.getJSONObject("shake_params").getInt("z_speed");
            }
            return 30.0f;
        } catch (Throwable unused) {
            return 30.0f;
        }
    }

    public boolean extractZShakeSpeedEnable() {
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_z_speed_enable", Integer.class, -1)).intValue() != -1) {
            return ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_shake_z_speed_enable", Integer.class, -1)).intValue() == 1;
        }
        try {
            JSONObject jSONObject = this.extraObject;
            return jSONObject != null && jSONObject.has("shake_params") && this.extraObject.getJSONObject("shake_params").has("z_speed_enable") && this.extraObject.getJSONObject("shake_params").getInt("z_speed_enable") == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isValidWxOpenSdk() {
        return (TextUtils.isEmpty(this.wxMiniProgramInfo.c) || TextUtils.isEmpty(this.wxMiniProgramInfo.a)) ? false : true;
    }

    public String toString() {
        return "InteractionInfo{interactionType=" + this.interactionType + ", deepLinkUrl='" + this.deepLinkUrl + "', h5Url='" + this.landingUrl + "', extra='" + this.extra + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.interactionType);
        parcel.writeString(this.deepLinkUrl);
        parcel.writeString(this.landingUrl);
        parcel.writeInt(this.floatingLayerStyle);
        parcel.writeInt(this.triggerStyle);
        parcel.writeInt(this.landingType);
        parcel.writeParcelable(this.wxMiniProgramInfo, i);
        parcel.writeString(this.extra);
        parcel.writeInt(this.floatingLayerStyleStartDownload);
    }
}
