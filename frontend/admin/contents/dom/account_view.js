import {
    getAllAccountByEmail,
    getAccountById,
    createAccount,
    updateAccount,
    deleteAccount
} from '../../../APIs/account.js';
import { getAllRoles } from '../../../APIs/role.js';


let selectedAccount;

export default async function loadAccountView() {
    selectedAccount = null;

    const addBtn = document.getElementById("add-account-btn");
    const editBtn = document.getElementById("edit-account-btn");
    const removeBtn = document.getElementById("remove-account-btn");
    const formContainer = document.getElementById("account-form-container");
    const accountForm = document.getElementById("account-form");
    const roleSelect = document.getElementById("role");
    // Lấy danh sách tất cả các role
    const roleOptions = await getAllRoles();
    // Thêm tất cả các role vào select

    roleOptions.forEach(option => {
        const opt = document.createElement("option");
        opt.value = option.id;
        opt.textContent = option.name;
        roleSelect.appendChild(opt);
    });

    // hiển thị form thêm tài khoản
    addBtn.addEventListener("click", () => {
        selectedAccount = null;
        showForm("Thêm tài khoản", "Lưu tài khoản");
        clearForm();
    });

    // hiển thị form chỉnh sửa tài khoản
    editBtn.addEventListener("click", () => {
        if (!selectedAccount) return;
        showForm("Chỉnh sửa tài khoản", "Hoàn tất chỉnh sửa");
        fillForm(selectedAccount);
    });

    // Xóa tài khoản
    removeBtn.addEventListener("click", async () => {
        if (!selectedAccount) return;
        await deleteAccount(selectedAccount.idAccount);
        selectedAccount = null;
        loadAccountsTable(await getAllAccountByEmail("", ""));
    });

    // Lưu tài khoản
    accountForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const accountData = getAccountFromForm(e);

        if (selectedAccount) {
            await updateAccount(selectedAccount.idAccount, accountData);
        } else {
            await createAccount(accountData);
        }
        selectedAccount = null;
        formContainer.classList.add("hidden");
        loadAccountsTable(await getAllAccountByEmail("", ""));
    });

    // Xóa form khi click ngoài
    formContainer.addEventListener("click", (e) => {
        if (!accountForm.contains(e.target)) {
            formContainer.classList.add("hidden");
        }
    });

    loadAccountsTable(await getAllAccountByEmail("", ""));
}


function showForm(title, buttonLabel) {
    const container = document.getElementById("account-form-container");

    container.querySelector('#form-title').textContent = title;
    container.querySelector('#submit-form-btn').textContent = buttonLabel;
    container.classList.remove("hidden");
}

function clearForm() {
    const form = document.getElementById("account-form");
    form.reset();
}

function fillForm(account) {
    const form = document.getElementById("account-form");

    form["email"].value = account.email || "";
    form["password"].value = account.password || "";
    form["role"].value = account?.role?.id || "";
    form["fullName"].value = account?.user?.fullName || "";
    form["phone"].value = account?.user?.phone || "";
    form["cardNumber"].value = account?.user?.cardNumber || "";
    form["address"].value = account?.user?.address || "";
    form["sex"].checked = account?.user?.sex || false;
    form["dayOfBirth"].value = account?.user?.dayOfBirth || "";
    form["userType"].value = account?.user?.userType || "";
}

// Lấy dữ liệu từ form
function getAccountFromForm(e) {
    const f = e.target.elements;
    let role = null;
    if (f["role"].value !== "customerAccount") {
        role = f["role"].value;
    }
    return {
        username: f["email"].value,
        password: f["password"].value,
        role: role,
        user: {
            fullName: f["fullName"].value,
            phone: f["phone"].value,
            email: f["email"].value,
            cardNumber: f["cardNumber"].value,
            address: f["address"].value,
            sex: f["sex"].checked,
            dayOfBirth: f["dayOfBirth"].value,
            userType: f["userType"].value
        }
    };
}

// Load danh sách tài khoản
function loadAccountsTable(accounts) {
    const table = document.getElementById("account-table-body");
    table.innerHTML = '';
    accounts.forEach(account => {
        const row = document.createElement("tr");
        row.className = "bg-gray-100 hover:bg-amber-100";
        row.setAttribute("account", JSON.stringify(account));

        row.innerHTML = `
            <td class="border px-2 py-1">${account.idAccount || ""}</td>
            <td class="border px-2 py-1">${account.email || ""}</td>
            <td class="border px-2 py-1">${account.password || ""}</td>
            <td class="border px-2 py-1">${account.createdAt || ""}</td>
            <td class="border px-2 py-1">${account?.role?.name || ""}</td>
        `;

        row.addEventListener("click", () => {
            table.querySelectorAll("tr").forEach(r => {
                r.classList.remove("bg-amber-300");
                r.classList.add("bg-gray-100");
            });
            selectedAccount = JSON.parse(row.getAttribute("account"));
            row.classList.remove("bg-gray-100");
            row.classList.add("bg-amber-300");
        });

        table.appendChild(row);
    });
}
