import axios from 'axios';

const url = 'http://localhost:8080';

export const saveTodo = async (title, content, selectDate) => {
	const data = {
		title: title,
		content: content,
		selectDate: selectDate,
		completed: false,
	};

	const headers = {
		'Content-Type': 'application/json',
		Authorization: `Bearer ${localStorage.getItem('token')}`,
	};

	try {
		const res = await axios.post(`${url}/todo/save`, data, { headers });
		return res;
	} catch (e) {
		console.error(e);
		return e;
	}
};
