import axios from 'axios';
import { GLOBAL_URL } from './util';
export const URL = `${GLOBAL_URL}/freeboard`;

export const saveFreeboard = async (FormData) => {
  try {
    const res = await axios.post(`${URL}`, FormData, {
      headers: { 'Content-Type': 'multipart/form-data' }
    });
    return res;
  } catch (e) {
    console.log(e);
  }
};

export const getFreeBoard = async (pageNum) => {
  if (pageNum == undefined) pageNum = 0;
  try {
    const res = await axios.get(`${URL}/select?pageNum=${pageNum}`);
    return res;
  } catch (e) {
    console.log(e);
    return e;
  }
};
