package id.putraprima.mvvmlogin.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.User;

public class LoginViewModels extends ViewModel {
    public MutableLiveData <User> userMutableLiveData = new MutableLiveData<>();
    private User user = new User(null,null);

    public String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
    }

    public void afterEmailChange(CharSequence e){
        user.setEmail(e.toString());
    }
    public void afterPasswordChange(CharSequence p){
        user.setPassword(p.toString());
    }
    public void onLoginClicked(){
        if (user.isInputDataValid()){
            user.setMessage("Berhasil Login");
        }
        else {
            user.setMessage("Gagal Login");
        }
        userMutableLiveData.setValue(user);
        setToastMessage(user.getMessage());

    }
}
