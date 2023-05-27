import { reactive,ref } from 'vue';


type UserData = {
    phoneNumber:string,
    password:string
}
const UserList:UserData[] = reactive([
    {
        "phoneNumber":"09658884521",
        "password":"qaqaqaqa"
    },
    {
        "phoneNumber":"096588843321",
        "password":"qaqaqaqa"
    },
    {
        "phoneNumber":"096534434431",
        "password":"qaqaqaqa"
    },{
        "phoneNumber":"093333434521",
        "password":"qaqaqaqa"
    }
]);


export const userInfoService = {
    UserList,
    getUserList:()=>{
        return UserList;
    },
    addUserIntoUserList(user:UserData){
        UserList.push(user);
    }
}


export default {
    userInfoService,
};
  