import { BASE_URL } from "./init.js";
import axios from 'axios';

const API_URL = BASE_URL + '/account';

// Lấy tất cả account theo email và createdAt
export const getAllAccountByEmail = async (username, createdAt) => {
    try {
        const response = await axios.get(`${API_URL}/all_account_by_email`, {
            params: {
                username: username,
                requestCreatedAt: createdAt
            },
            withCredentials: true
        });
        return response.data;
    } catch (error) {
        // throw error;
        console.log(error);
        return [];
    }
};

// Lấy account theo id
export const getAccountById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`, {
            withCredentials: true
        });
        return response.data;
    } catch (error) {
        // throw error;
        console.log(error);
        return null;
    }
};

// Tạo account mới
export const createAccount = async (account) => {
    try {
        const response = await axios.post(API_URL, account, {
            withCredentials: true
        });
        return response;
    } catch (error) {
        // throw error;
        console.log(error);
        return null;
    }
};

// Cập nhật account theo id
export const updateAccount = async (id, account) => {
    try {
        const response = await axios.put(`${API_URL}/${id}`, account, {
            withCredentials: true
        });
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};

// Xóa account theo id
export const deleteAccount = async (id) => {
    try {
        const response = await axios.delete(`${API_URL}/${id}`, {
            withCredentials: true
        });
        return response.data;
    } catch (error) {
        console.log(error);
        throw error;
    }
};
