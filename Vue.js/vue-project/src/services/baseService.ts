import { userInfoService } from './../state/userListState';
import axios from 'axios';


export interface UserData{
  phoneNumber:string,
  password:string
} 

export async function signInService(phoneNumber:string, password:string) {
  try {

    let verifyStatus:Boolean = false;
    const UserList = userInfoService.getUserList();
    UserList.forEach((user: UserData) => {
      if(user.password == password && user.phoneNumber == phoneNumber){
        verifyStatus = true;
      }
    });
    return verifyStatus;
  } catch (err) {
    console.error(err);
    throw new Error('its error');
  }
}


export async function registerService(phoneNumber:string, password:string) {
  try {
    
    const registerUserInfo:UserData = {phoneNumber:phoneNumber,password:password};
    userInfoService.addUserIntoUserList(registerUserInfo);
    return true;

  } catch (err) {
    console.error(err);
    return false;
  }
}
