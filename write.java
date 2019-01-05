package seProject;

import java.io.FileWriter;
import java.io.IOException;

public class write {
	public void write(String job,String salary , String phone)throws IOException {
		FileWriter fw = new FileWriter("test.txt",true);
		fw.write(job+" ");
		fw.write(salary+" ");
		fw.write(phone+" ");
		fw.flush();
		fw.close();
	}
}
