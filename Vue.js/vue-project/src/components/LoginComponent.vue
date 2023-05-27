<template>
  <div class="login">
    <el-card>
      <h2 class="login-title">Library Login</h2>
      <el-form
        class="login-form"
        href="form"
        ref="uploadForm"
        :model="uploadFormData"
      >
        <el-row>
          <el-col :span="24">
            <el-form-item prop="phoneNumber">
              <el-input
                v-model="uploadFormData.phoneNumber"
                placeholder="手機號碼"
              ></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="24">
            <el-form-item prop="password">
              <el-input
                v-model="uploadFormData.password"
                placeholder="密碼"
                type="password"
              >
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div>
        <el-button id="login_button" @click="signIn">登入</el-button>
        <el-button id="register_button" @click="register">註冊</el-button>
      </div>
    </el-card>
  </div>
</template>


<script lang="ts">
import axios from 'axios';
import { defineComponent, ref, onMounted, watch } from 'vue';
import { useRouter } from 'vue-router';
import { signInService,registerService } from '@/services/baseService';
import Swal from 'sweetalert2';

export default defineComponent({
  name: 'signIn',
  components: {},
  emits: { },
  setup() {
    const phoneNumber = ref();
    const router = useRouter();
    const uploadForm = ref();
    const uploadFormData = ref({
      phoneNumber: '',
      password: '',
    });
    const DialogVisible = ref(false);

    const signIn = async(): Promise<Boolean> => {
      const response = await signInService(uploadFormData.value.phoneNumber,uploadFormData.value.password);
      if (response)  { Swal.fire('Hi', '登入成功', 'success'); console.log('sareett') ;router.push({ name : 'MainPage' }); } 
      else Swal.fire('錯誤訊息', '登入失敗', 'error');
      return response;
    }

    const register = async(): Promise<Boolean> => {
      const response = await registerService(uploadFormData.value.phoneNumber,uploadFormData.value.password);
      if (response) { Swal.fire('Hi', '註冊成功', 'success') ; router.push({name : 'Login'})}
      else Swal.fire('錯誤訊息', '註冊失敗', 'error'); 
      return response;
    }
    

    return {
      signIn,
      register,
      phoneNumber,
      uploadForm,
      DialogVisible,
      uploadFormData,
    };
  },
});
</script>

<style lang="scss">


.login{
  background-color: #CCE8FF;
  width: 100%;
  display: flex;
  align-items: center;
  height: 100%;
  justify-content: center;
}

.login-title{
  text-align: center;
  padding:10px;
  font-family: "Helvetica Neue", Arial, sans-serif;
  font-weight: 700;
  line-height: 1.2;
  margin-bottom: 0.5em;
}

.el-card__body{
  width: 100%;
  position: relative;
  height: 220px;
}

#login_button{
  position:absolute;
  right:21px;
}

#register_button{
  position:absolute;
  right:92px;
}

</style>
