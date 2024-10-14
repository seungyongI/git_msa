import { defineStore } from 'pinia';

export const useLoginStore = defineStore('login', {
  state: () => ({
    loginCheck: false, // 로그인 여부
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
