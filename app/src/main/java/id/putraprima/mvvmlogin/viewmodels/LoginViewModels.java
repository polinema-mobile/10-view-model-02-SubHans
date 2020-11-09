package id.putraprima.mvvmlogin.viewmodels;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.User;

public class LoginViewModels extends ViewModel {
    private String email = "indra@gmail.com";
    private String password = "123456";

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loggedMutableLive = new MutableLiveData<>();
    private MutableLiveData<String> errorData = new MutableLiveData<>();
   public User user;

    public LoginViewModels(User user) {
        this.user = user;
        this.userMutableLiveData.setValue(this.user);
    }

    public LiveData<User> getLogin(){
        return this.userMutableLiveData;
    }

    public LiveData<Boolean> loggedLiveData() {
        return this.loggedMutableLive;
    }

    public LiveData<String> getError(){
        return this.errorData;
    }



    public void BtnLoggin(){
        Log.d("Email",user.email);
        Log.d("Pass",user.password);
        loggedMutableLive.setValue(false);

        if (user.email.equals(email) && user.password.equals(password)){
            userMutableLiveData.setValue(user);
            loggedMutableLive.setValue(true);
            return;
        } else if(!user.isInputDataValid()){
            errorData.setValue("Masukkan Data Dengan Benar"); // set pesan error
            loggedMutableLive.setValue(false);
            return;
        } else if (user.email.isEmpty() || user.password.isEmpty()||user.email==null||user.password==null||!user.email.equals(email) || !user.password.equals(password)){
            errorData.setValue("Lengkapi Data Email dan Password "); // set pesan
            loggedMutableLive.setValue(false);
            return;
        }

    }
}
