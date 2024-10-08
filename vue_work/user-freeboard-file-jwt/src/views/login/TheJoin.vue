<template>
  <div class="py-5 bg-gray-100 flex items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-md w-96">
      <h2 class="text-2xl font-bold mb-6 text-center">회원가입</h2>

      <form @submit.prevent="doSubmit">
        <div class="mb-4">
          <label for="username" class="block text-sm font-medium text-gray-700">사용자 이름</label>
          <input
            type="text"
            id="username"
            name="username"
            required
            class="mt-1 p-2 border border-gray-300 rounded w-full"
            placeholder="사용자 이름을 입력하세요"
          />
        </div>
        <div class="mb-4">
          <label for="email" class="block text-sm font-medium text-gray-700">이메일</label>
          <input
            type="email"
            id="email"
            name="email"
            required
            class="mt-1 p-2 border border-gray-300 rounded w-full"
            placeholder="이메일을 입력하세요"
          />
        </div>
        <div class="mb-4">
          <label for="password" class="block text-sm font-medium text-gray-700">비밀번호</label>
          <input
            type="password"
            id="password"
            name="password"
            required
            class="mt-1 p-2 border border-gray-300 rounded w-full"
            placeholder="비밀번호를 입력하세요"
          />
        </div>
        <div class="mb-4">
          <label for="confirm-password" class="block text-sm font-medium text-gray-700"
            >비밀번호 확인</label
          >
          <input
            type="password"
            id="confirm-password"
            name="confirm-password"
            required
            class="mt-1 p-2 border border-gray-300 rounded w-full"
            placeholder="비밀번호를 다시 입력하세요"
          />
        </div>
        <button type="submit" class="w-full bg-blue-600 text-white p-2 rounded hover:bg-blue-700">
          회원가입
        </button>
      </form>

      <p class="mt-4 text-center text-sm text-gray-600">
        이미 계정이 있으신가요? <a href="/login" class="text-blue-600 hover:underline">로그인</a>
      </p>
    </div>
  </div>
</template>

<script setup>
import { doJoin } from '@/api/loginApi';

const doSubmit = async (event) => {
  console.log('Connect ?' + event);
  const res = await doJoin({
    "name": '홍길동',
    "age": '25',
    "email": 'aaa@naver.com',
    "password": '1234'
  });
  console.log(res);
};
</script>

<style lang="scss" scoped></style>
