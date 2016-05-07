package serviceImpl;

import java.io.*;
import java.rmi.RemoteException;

import DB.DBTest;
import service.IOService;

public class IOServiceImpl implements IOService{
	
	@Override
	public boolean writeFile(String file, String userId, String fileName) {

		File f = new File("Code/"+userId +"/"+fileName);
		try {
			FileWriter fw = new FileWriter(f, false);
			fw.write(file);
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String readFile(String userId, String fileName) {
		File f = new File("Code/"+userId +"/"+fileName);
		StringBuilder sb=new StringBuilder();
		String temp="";
		String result="";
		try {
			FileReader fileReader=new FileReader(f);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			while ((temp=bufferedReader.readLine())!=null){
				sb.append(temp);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		result=sb.toString();

		return result;
	}

	@Override
	public String[] readFileList(String userId) {
		// TODO Auto-generated method stub
		return DBTest.getFileList(userId);
	}

	@Override
	public boolean saveFileCopy(String filename, String userid) throws RemoteException {
		return false;
	}

}
