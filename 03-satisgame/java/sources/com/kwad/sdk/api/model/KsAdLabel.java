package com.kwad.sdk.api.model;

/* JADX INFO: loaded from: classes3.dex */
public class KsAdLabel implements IKsAdLabel {
    public String channel;
    public long cpmBidFloor;
    public String historyTitle;
    public String postTitle;
    public String prevTitle;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public int getThirdAge() {
        return this.thirdAge;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public void setThirdAge(int i) {
        this.thirdAge = i;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public int getThirdGender() {
        return this.thirdGender;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public void setThirdGender(int i) {
        this.thirdGender = i;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public String getThirdInterest() {
        return this.thirdInterest;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public void setThirdInterest(String str) {
        this.thirdInterest = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public String getPrevTitle() {
        return this.prevTitle;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public void setPrevTitle(String str) {
        this.prevTitle = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public String getPostTitle() {
        return this.postTitle;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public void setPostTitle(String str) {
        this.postTitle = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public String getHistoryTitle() {
        return this.historyTitle;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public void setHistoryTitle(String str) {
        this.historyTitle = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public String getChannel() {
        return this.channel;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public void setChannel(String str) {
        this.channel = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public long getCpmBidFloor() {
        return this.cpmBidFloor;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public void setCpmBidFloor(long j) {
        this.cpmBidFloor = j;
    }
}
