import { BASE_URL } from "./init.js";
import axios from 'axios';


// Đăng nhập
export const login = async (email, password) => {
    try {
        const response = await axios.post(`${BASE_URL}/login`, {
            username: email,
            password: password
        }, {
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

// Đăng xuất
export const logout = async () => {
    try {
        const response = await axios.post(`${BASE_URL}/logoutApp`, {}, {
            withCredentials: true
        });
        return response;
    } catch (error) {
        if (error.response) {
            return error.response;
        } else {
            throw error;
        }
    }
};

