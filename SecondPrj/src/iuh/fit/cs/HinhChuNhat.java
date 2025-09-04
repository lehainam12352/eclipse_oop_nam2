
package iuh.fit.cs;
/**
 * 
 * This class represents a rectangle  
 *
 * @author : LENOVO
 * @version : 1.0
 * @since : Aug 27, 2025
 */


public class HinhChuNhat {

	private double chieudai;
	private double chieurong;
	
	public void setChieudai(double d) throws Exception {
			if (d>=0)
			{
				this.chieudai=d;
			}
		else throw new Exception("Chieu rong khong duoc am");

	}
	public double getChieudai() {
		return this.chieudai;
	}

	public void setChieurong(double r) throws Exception {
		if (r>=0)
		{
			this.chieurong=r;
		}else throw new Exception("Chieu rong khong duoc am");
	}
	public double getChieurong() {
		return this.chieurong;
	}
	public double getArea()
	{
		return this.chieudai*this.chieurong;
	}
	public double getPerimeter()
	{
		return (this.chieudai+this.chieurong)*2;
	}
	
	public HinhChuNhat() {}
	public HinhChuNhat(double d, double r) throws Exception
	{
		if (d>=0&&r>=0)
		{
			this.chieudai=d;
			this.chieurong=r;
		}
		else if(r<0&&d<0) {throw new Exception("Chieu dai va rong khong duoc am");}
		else if(r<0) {throw new Exception ("Chieu rong khong duoc am");}
		else {throw new Exception ("Chieu dai khong duoc am");}
	}
	
	
	

}
