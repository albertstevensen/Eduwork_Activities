package com.example.a2301961632;

public class imagesManage {
    int imageManages;
    String titleManages, descriptionManages;

    public imagesManage(int imageManage, String titleManage, String descriptionManage) {
        this.imageManages = imageManage;
        this.titleManages = titleManage;
        this.descriptionManages = descriptionManage;
    }

    public int getImageManage() {
        return imageManages;
    }

    public String getTitleManage() {
        return titleManages;
    }

    public String getDescriptionManage() {
        return descriptionManages;
    }
}
