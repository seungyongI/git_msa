import axios from 'axios';

const url = 'http://localhost:8080';

export const login = async (code) => {
	try {
		const res = await axios.get(`${url}/kakao/login?code=${code}`);
		return res.data;
	} catch (e) {
		console.error(e);
		return e;
	}
};
