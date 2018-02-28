package com.qs.web.fruit.fanxing;

public class Student <K,V>{

	private K k;
	private V v;
	public K getK() {
		return k;
	}
	public void setK(K k) {
		this.k = k;
	}
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
	
	
	public static void main(String[] args) {
		/*Student<String, String> student=new Student<String, String>();
		student.setK("姓名");
		student.setV("帅哥");
		System.out.println(student.getK()+student.getV());*/

		Home<Integer> home = new Home<Integer>();
		home.setName("zhangsan");
		home.setAddress("panshi");
		home.setT(200);
		print(home);
	}

	static class Home<T>{

		private String address;
		private String name;
		private T t;

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public T getT() {
			return t;
		}

		public void setT(T t) {
			this.t = t;
		}

		@Override
		public String toString() {
			return "Home{" +
					"address='" + address + '\'' +
					", name='" + name + '\'' +
					", t=" + t +
					'}';
		}
	}

	public static void print(Home<?> home){
		System.out.println(home.toString());
	}
	
}
