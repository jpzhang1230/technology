package cn.superv.manager.staff.technology;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.com.superv.jute.InputArchive;
import cn.com.superv.jute.OutputArchive;
import cn.com.superv.jute.RecordReader;
import cn.com.superv.jute.RecordWriter;


public class RecordTest {
	
	@Test
	public void testSerialize() {
		OutputStream out=null;
		List<String> list=new ArrayList<String>();
		list.add("create");
		list.add("update");
		list.add("retriew");
		list.add("delete");
		User user=new User(1, "admin", "12345".getBytes(),list);
		try {
			out = new FileOutputStream("test.dat");
			OutputArchive archive=RecordWriter.createArchive(out, "binary");
			user.serialize(archive, user.signature());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("serialize succ");
	}
	
	@Test
	public void testDeserialize(){
		InputStream in=null;
		User user=new User();
		try {
			in = new FileInputStream("test.dat");
			InputArchive archive=RecordReader.createArchive(in, "binary");
			user.deserialize(archive, user.signature());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(user);
	}
}
