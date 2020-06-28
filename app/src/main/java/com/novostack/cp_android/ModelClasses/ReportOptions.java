package com.novostack.cp_android.ModelClasses;

public class ReportOptions {

    private String title;
    private boolean isSelected;

    public ReportOptions() {
    }

    public ReportOptions(String title, boolean isSelected) {
        this.title = title;
        this.isSelected = isSelected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
