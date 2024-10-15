import { createRouter, createWebHistory } from 'vue-router';
import TheHome from '../views/TheHome.vue';
import TheFreeBoardInput from '@/views/freeboard/TheFreeBoardInput.vue';
import TheFreeBoardList from '@/views/freeboard/TheFreeBoardList.vue';
import TheFreeBoardView from '@/views/freeboard/TheFreeBoardView.vue';
import TheFileUpload from '@/views/TheFileUpload.vue';
import TheFreeBoardUpdate from '@/views/freeboard/TheFreeBoardUpdate.vue';
import TheUserList from '@/views/users/TheUserList.vue';
import TheJoin from '../views/login/TheJoin.vue';
import TheLogin from '../views/login/TheLogin.vue';
import TheFileUploads from '@/views/TheFileUploads.vue';
import TheFileDownload from '@/views/TheFileDownload.vue';

const router = createRouter({
  history: createWebHistory('/'),
  routes: [
    {
      path: '/',
      name: 'home',
      component: TheHome
    },
    {
      path: '/user',
      name: 'user',
      component: TheUserList
    },
    {
      path: '/join',
      name: 'join',
      component: TheJoin
    },
    {
      path: '/login',
      name: 'login',
      component: TheLogin
    },
    {
      path: '/freeboardinput',
      name: 'freeboardinput',
      component: TheFreeBoardInput
    },
    {
      path: '/freeboardupdate',
      name: 'freeboardupdate',
      component: TheFreeBoardUpdate
    },
    {
      path: '/freeboardlist',
      name: 'freeboardlist',
      component: TheFreeBoardList
    },
    {
      path: '/freeboardview/:idx',
      name: 'freeboardview',
      component: TheFreeBoardView
    },
    {
      path: '/fileupload',
      name: 'fileupload',
      component: TheFileUpload
    },
    {
      path: '/fileuploads',
      name: 'fileuploads',
      component: TheFileUploads
    },
    {
      path: '/filedownload',
      name: 'filedownload',
      component: TheFileDownload
    }
  ]
});

export default router;
