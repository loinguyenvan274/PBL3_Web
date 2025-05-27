// role.js
import { BASE_URL } from "./init.js";

const API_BASE = BASE_URL + '/role';

// Lấy danh sách tất cả role
export async function getAllRoles() {
    try {
        const res = await fetch(API_BASE, {
            credentials: 'include'
        });
        return await res.json();
    } catch (error) {
        console.error('Error fetching roles:', error);
        return [];
    }
}

// Lấy thông tin 1 role theo ID
export async function getRoleById(id) {
    const res = await fetch(`${API_BASE}/${id}`, {
        credentials: 'include'
    });
    return await res.json();
}

// Thêm role mới
export async function addRole(role) {
    await fetch(API_BASE, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(role),
        credentials: 'include'
    });
}

// Cập nhật role
export async function updateRole(id, role) {
    await fetch(`${API_BASE}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(role),
        credentials: 'include'
    });
}

// Xóa role theo ID
export async function deleteRole(id) {
    await fetch(`${API_BASE}/${id}`, {
        method: "DELETE",
        credentials: 'include'
    });
}

// Lấy tất cả permission (dạng DTO)
export async function getAllPermissions() {
    const res = await fetch(`${API_BASE}/permissions`, {
        credentials: 'include'
    });
    return await res.json();
}
