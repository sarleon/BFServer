//请不要修改本文件名
package serviceImpl;

import java.io.IOException;
import java.rmi.RemoteException;

import Interpreter.Interpreter;
import service.ExecuteService;
import service.UserService;

public class ExecuteServiceImpl implements ExecuteService {
	/**
	 * 请实现该方法
	 */
	@Override
	public String execute(String code, String param) throws RemoteException {
		// TODO Auto-generated method stub
		Interpreter interpreter=new Interpreter(code,param);
		String res;
		try {
			res=interpreter.interpret();
			return res;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "error";

	}

}
