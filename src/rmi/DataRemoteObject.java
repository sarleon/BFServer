package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import service.ExecuteService;
import service.IOService;
import service.TestService;
import service.UserService;
import serviceImpl.ExecuteServiceImpl;
import serviceImpl.IOServiceImpl;
import serviceImpl.TestServiceImpl;
import serviceImpl.UserServiceImpl;

public class DataRemoteObject extends UnicastRemoteObject implements IOService, UserService,TestService,ExecuteService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private ExecuteService executeService;
	private TestService testService;
	private IOService iOService;
	private UserService userService;
	protected DataRemoteObject() throws RemoteException {
		iOService = new IOServiceImpl();
		userService = new UserServiceImpl();
		testService=new TestServiceImpl();
		executeService=new ExecuteServiceImpl();
	}

	@Override
	public boolean writeFile(String file, String userId, String fileName) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.writeFile(file, userId, fileName);
	}

	@Override
	public String readFile(String userId, String fileName) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readFile(userId, fileName);
	}

	@Override
	public String[] readFileList(String userId) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readFileList(userId);
	}

	@Override
	public boolean saveFileCopy(String filename, String userid,String filetext) throws RemoteException {
		return iOService.saveFileCopy(filename,userid,filetext);
	}

	@Override
	public String readFileCopy(String username, String filename) throws RemoteException {
		return iOService.readFileCopy(username,filename);
	}

	@Override
	public String[] readFileCopyList(String username,String fileName) throws RemoteException {
		return iOService.readFileCopyList(username,fileName);
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.login(username, password);
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.logout(username);
	}

	@Override
	public boolean isLogin(String username) throws RemoteException {
		return userService.isLogin(username);
	}

	@Override
	public String execute(String code, String param) throws RemoteException {

		return executeService.execute(code,param);
	}

	@Override
	public boolean echo() throws RemoteException{
		return testService.echo();
	}
}
