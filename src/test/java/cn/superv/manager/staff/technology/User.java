package cn.superv.manager.staff.technology;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.com.superv.jute.Index;
import cn.com.superv.jute.InputArchive;
import cn.com.superv.jute.OutputArchive;
import cn.com.superv.jute.Record;
import cn.com.superv.util.MultiUtil;

public class User implements Record {
	private int type;
	private String name;
	private byte[] key;
	private List<String> authList;// 权限列表

	public User() {

	}

	public User(int type, String name, byte[] key, List<String> auth) {
		this.setType(type);
		this.setName(name);
		this.setKey(key);
		this.setAuth(auth);
	}

	@Override
	public void serialize(OutputArchive archive, String tag) throws IOException {
		archive.startRecord(this, tag);
		archive.writeInt(type, "type");
		archive.writeString(name, "name");
		archive.writeBuffer(key, "key");

		archive.startVector(authList, "authList");
		if (authList != null && authList.size() > 0) {
			for (String item : authList) {
				archive.writeString(item, "auth");
			}

		}
		archive.endVector(authList, "authList");

		archive.endRecord(this, tag);
	}

	@Override
	public void deserialize(InputArchive archive, String tag)
			throws IOException {
		archive.startRecord(tag);
		type=archive.readInt("type");
		name=archive.readString("name");
		key=archive.readBuffer("key");

		Index index = archive.startVector("authList");
		if (index != null) {
			authList = new ArrayList<String>();
			for (; !index.done(); index.incr()) {
				String auth = archive.readString("auth");
				authList.add(auth);
			}
		}
		archive.endVector("authList");

		archive.endRecord(tag);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("type=").append(getType()).append("&");
		buffer.append("name=").append(getName()).append("&");
		buffer.append("key=").append(MultiUtil.getByteString(getKey()));
		return buffer.toString();
	}

	public String signature() {
		return "LUser(ss)";
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the key
	 */
	public byte[] getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(byte[] key) {
		this.key = key;
	}

	/**
	 * @return the auth
	 */
	public List<String> getAuth() {
		return authList;
	}

	/**
	 * @param auth
	 *            the auth to set
	 */
	public void setAuth(List<String> auth) {
		this.authList = auth;
	}

}
