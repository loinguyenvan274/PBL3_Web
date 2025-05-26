import { BASE_URL } from "./init.js";
import axios from 'axios';


// Đăng nhập
export const login = async (email, password) => {
    try {
        const response = await axios.get(`${BASE_URL}/login`, {
            params: { email, password },
            withCredentials: true
        });
        return response;
    } catch (error) {
        if (error.response) {
            // ✅ Đây là nơi bạn lấy được phản hồi từ server
            return error.response;
        } else {
            throw error;
        }
    }
};

// Đăng xuất
export const logout = async () => {
    const response = await axios.get(`${BASE_URL}/logout`, {
        withCredentials: true
    });
    return response;
};

// Lấy thông tin người dùng đã đăng nhập
export const getCurrentUser = async () => {
    const response = await axios.get(`${BASE_URL}/current-user`, {
        withCredentials: true
    });
    return response;
};

// Kiểm tra xem người dùng đã đăng nhập chưa
export const isAuthenticated = async () => {
    const response = await axios.get(`${BASE_URL}/is-authenticated`, {
        withCredentials: true
    });
    return response;
};


