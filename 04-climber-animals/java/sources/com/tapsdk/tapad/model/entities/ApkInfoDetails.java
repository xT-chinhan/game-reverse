package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ApkInfoDetails implements Parcelable {
    public static final Parcelable.Creator<ApkInfoDetails> CREATOR = new a();
    public final List<ApkUrlInfo> apkUrlInfoList;
    public final String identifier;
    public final String md5;
    public final String name;
    public final long size;
    public final int versionCode;
    public final String versionName;

    static class a implements Parcelable.Creator<ApkInfoDetails> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkInfoDetails createFromParcel(Parcel parcel) {
            return new ApkInfoDetails(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkInfoDetails[] newArray(int i) {
            return new ApkInfoDetails[i];
        }
    }

    protected ApkInfoDetails(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.apkUrlInfoList = arrayList;
        this.name = parcel.readString();
        this.size = parcel.readLong();
        this.md5 = parcel.readString();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.identifier = parcel.readString();
        parcel.readTypedList(arrayList, ApkUrlInfo.CREATOR);
    }

    public ApkInfoDetails(JSONObject jSONObject) throws JSONException {
        this.apkUrlInfoList = new ArrayList();
        this.name = jSONObject.optString(Common.System.NAME);
        this.size = jSONObject.optLong("size");
        this.md5 = jSONObject.optString("md5");
        this.versionCode = jSONObject.optInt("version_code");
        this.versionName = jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
        this.identifier = jSONObject.optString("identifier");
        JSONArray jSONArray = jSONObject.getJSONArray("apk_urls");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.apkUrlInfoList.add(new ApkUrlInfo(jSONArray.getJSONObject(i)));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ApkInfoDetails{name='" + this.name + "', size=" + this.size + ", md5='" + this.md5 + "', versionCode=" + this.versionCode + ", versionName='" + this.versionName + "', identifier='" + this.identifier + "', apkUrlInfoList=" + this.apkUrlInfoList + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.size);
        parcel.writeString(this.md5);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeString(this.identifier);
        parcel.writeTypedList(this.apkUrlInfoList);
    }
}
