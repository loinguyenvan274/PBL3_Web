package com.pbl.flightapp.Enum;

public enum Permission {
    MANAGE_FLIGHT("Quản lý chuyến bay"),
    MANAGE_PLANE("Quản lý máy bay"),
    CREATE_FLIGHT("Tạo chuyến bay"),
    DELETE_FLIGHT("Xóa chuyến bay"),
    VIEW_FLIGHT("Xem danh sách chuyến bay"),
    BOOK_TICKET("Đặt vé"),
    VIEW_STATS("Xem thống kê"),
    MANAGE_USER("Quản lý người dùng");

    private final String description;

    Permission(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
