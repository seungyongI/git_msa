import axios from 'axios';
import { GLOBAL_URL } from './util';

export const join = `${GLOBAL_URL}/join`;
export const login = `${GLOBAL_URL}/login`;
export const check = `${GLOBAL_URL}/check`;

export const doJoin = async (data) => {
  try {
    const res = await axios.post(join, data);
    return res;
  } catch (e) {
    console.log(e);
    return e;
  }
};

export const doLogin = async (data) => {
  try {
    const res = await axios.get(`${login}?email=${data.email}&password=${data.password}`);

    return res;
  } catch (e) {
    console.log(e);
    return e;
  }
};

export const doLoginCheck = async () => {
  const token = localStorage.getItem('token');
  if (!token) return false;
  try {
    const res = await axios.get(`${check}?jwt=${token}`);
    return res;
  } catch (e) {
    console.log(e);
    return e;
  }
};
