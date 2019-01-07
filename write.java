package seProject;

import java.io.FileWriter;
import java.io.IOException;

public class write {
	public void write(String job,String salary , String phone)throws IOException {
		FileWriter fw = new FileWriter("test.txt",true);
		fw.write(job+"@split");
		fw.write(salary+"@split");
		fw.write(phone+"@split");
		fw.flush();
		fw.close();
	}
}
