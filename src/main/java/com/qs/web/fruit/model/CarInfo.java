package com.qs.web.fruit.model;

public class CarInfo {

	public CarInfo() {}
	public CarInfo(String name) {
		this.name = name;
	}

	private String name;
	private Integer carAge;
	private String path;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCarAge() {
		return carAge;
	}
	public void setCarAge(Integer carAge) {
		this.carAge = carAge;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "CarInfo{" +
				"name='" + name + '\'' +
				", carAge=" + carAge +
				", path='" + path + '\'' +
				'}';
	}

	protected void changeValue(CarInfo carInfo){
		carInfo.setName("AUTO");
		carInfo.setPath("深圳");
	}
	protected void test(){
		CarInfo carInfo = new CarInfo();
		carInfo.setCarAge(20);

		System.out.println(carInfo.toString());
	}


	public static void fun(int temp){
		System.out.println("1temp="+temp);
		temp = 999;
		System.out.println("2temp="+temp);
	}

	public static void fun1(CarInfo carInfo){
		carInfo.setName("world");
	}

	public static void main(String[] args) {

		CarInfo carInfo = new CarInfo("hello");
		fun1(carInfo);
		System.out.println(carInfo);


		/*int i = 100;
		fun(i);
		System.out.println(i);*/


		//new CarInfo().test();
	}
}
