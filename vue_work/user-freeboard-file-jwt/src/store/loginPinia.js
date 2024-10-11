import { defineStore } from "pinia";

export const useLoginStore = defineStore('loginPinia', {
    state: () => ({
        isLoggedIn: false,
        data: null,
        name: ''
    }),
    actions: {
        login(data) {
            this.loginCheck = true;
            this.data = data;
            this.name = data.name;
        },
        logout() {
            this.loginCheck = false;
            this.data = null;
            this.name = '';
        }
    }
});