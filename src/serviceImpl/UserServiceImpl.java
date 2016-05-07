package serviceImpl;

import java.rmi.RemoteException;

import ControlCenter.UserController;
import DB.DBTest;
import DB.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	private UserController userController=UserController.getInstance();
	@Override
	public boolean login(String username, String password) throws RemoteException {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		boolean result= DB.UserDAO.login(user);
		if(result){
			this.userController.userLogin(user);
			if(!DBTest.findAddress(username)){
				DBTest.mkdir(username);
			};
		}
		return result;
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		userController.userLogout(username);
		return true;
	}

	@Override
	public boolean isLogin(String username) throws RemoteException {
		return false;
	}

}
