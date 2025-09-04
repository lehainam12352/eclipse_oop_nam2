
package iuh.fit.cs;
/**
 * 
 * This class represents a rectangle  
 *
 * @author : LENOVO
 * @version : 1.0
 * @since : Aug 27, 2025
 */
public class Test {
	//Constructor mặc định
	public Test() {}
	public static void main(String[] args) throws Exception {
		//code here
		HinhChuNhat h=new HinhChuNhat();
		h.setChieurong(-1);
		System.out.println(h.getChieurong());
		h.setChieudai(-1);
		System.out.println(h.getChieudai());
		
		h=new HinhChuNhat(-1,-2);
		System.out.println(h.getArea());
		h=new HinhChuNhat(1,2);
		System.out.println(h.getPerimeter());
	}

	
}
