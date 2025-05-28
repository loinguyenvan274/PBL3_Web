import { BASE_URL } from "./init.js";
import axios from 'axios';

const API_URL = BASE_URL + '/bookings';

// Tạo booking mới
export const createBooking = async (bookingRequest) => {
    try {
        const response = await axios.post(API_URL, bookingRequest, {
            withCredentials: true
        });
        return response.data;
    } catch (error) {
        console.log(error.response);
        return null;
    }
};

// Lấy booking theo id
export const getBookingById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`, {
            withCredentials: true
        });
        return response.data;
    } catch (error) {
        console.log(error.response);
        return null;
    }
};

// Xóa booking theo id
export const deleteBooking = async (id) => {
    try {
        const response = await axios.delete(`${API_URL}/${id}`, {
            withCredentials: true
        });
        return response.data;
    } catch (error) {
        console.log(error.response);
        return null;
    }
};

// Lấy danh sách booking theo customerId
export const findByCustomerId = async (customerId) => {
    try {
        const response = await axios.get(`${API_URL}/findByCustomerId/${customerId}`, {
            withCredentials: true
        });
        return response.data;
    } catch (error) {
        console.log(error.response);
        return [];
    }
};

// Lấy danh sách booking theo khoảng thời gian
export const findByFromDate = async (fromDate, toDate) => {
    try {
        const response = await axios.get(`${API_URL}/fromDate/${fromDate}/toDate/${toDate}`, {
            withCredentials: true
        });
        return response.data;
    } catch (error) {
        console.log(error.response);
        return [];
    }
};
