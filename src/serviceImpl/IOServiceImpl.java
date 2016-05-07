package serviceImpl;

import java.io.*;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			saveFileCopy(fileName,userId,file);
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
	public boolean saveFileCopy(String filename, String userid,String filetext) throws RemoteException {

		if(!DBTest.findCopyAddress(filename,userid)){
			DBTest.makeCopeDir(filename,userid);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String  time=df.format(new Date());
		File f = new File("Code/"+userid +"/_"+filename+"/_"+filename+"_"+time);
		try {
			FileWriter fw = new FileWriter(f, false);
			fw.write(filetext);
			fw.flush();
			fw.close();

			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}


	}

	@Override
	public String readFileCopy(String username, String filename) throws RemoteException {
		return null;
	}

	@Override
	public String[] readFileCopyList(String username,String fileName) throws RemoteException {
		return DBTest.getFileCopyList(username,fileName);
	}

}
