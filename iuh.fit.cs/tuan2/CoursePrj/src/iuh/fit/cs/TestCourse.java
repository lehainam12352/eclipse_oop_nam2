package iuh.fit.cs; 
import java.util.*; 
public class TestCourse { 
	public void initData(CourseList c) { 
		try { 
			c.addCourse(new Course("C001", "Java", "CNTT", 3)); 
			c.addCourse(new Course("C002", "Python", "CNTT", 3)); 
			c.addCourse(new Course("C003", "Marketing", "Kinh tế", 2)); 
			c.addCourse(new Course("C004", "Kế toán", "Kinh tế", 2)); 
			c.addCourse(new Course("C005", "Mạng máy tính", "CNTT", 4)); 
			
		} catch(Exception e) { 
			System.out.println("loi khi them khoa hoc"+e.getMessage()); 
			}
	} 
	public static void main(String[] args) { 
		CourseList cl =new CourseList(100); 
		TestCourse tc=new TestCourse(); 
		tc.initData(cl);
		System.out.println("✅ Đã thêm " + cl.getCourse().length + " khóa học.");
		Scanner sc = new Scanner(System.in); 
		while (true) { 
			System.out.println("\n===== MENU ====="); 
			System.out.println("1. Thêm khóa học"); 
			System.out.println("2. Hiển thị danh sách"); 
			System.out.println("3. Xóa khóa học"); 
			System.out.println("4. Sắp xếp theo mã"); 
			System.out.println("5. Tìm khóa học theo tên");
			System.out.println("6. Tìm khóa học theo khoa");
			System.out.println("7. Tìm khóa học có tín chỉ cao nhất");
			System.out.println("8. Tìm khoa có nhiều khóa học nhất");
			System.out.println("9. Tìm khóa học theo mã");
			System.out.println("0. Thoát"); 
			System.out.print("Chọn chức năng: "); 
			int choice = sc.nextInt(); 
			sc.nextLine();
				switch (choice) {
					case 1:
					    try {
					        System.out.print("Mã: ");
					        String id = sc.nextLine().trim();
					        System.out.print("Tên: ");
					        String name = sc.nextLine().trim();
					        System.out.print("Khoa: ");
					        String dept = sc.nextLine().trim();
					        System.out.print("Tín chỉ: ");
					        int credit = Integer.parseInt(sc.nextLine().trim());
	
					        cl.addCourse(new Course(id, name, dept, credit));
					        System.out.println("✅ Thêm thành công!");
					    } catch (Exception e) {
					        System.out.println("❌ Lỗi: " + e.getMessage());
					    }
					    break;
					case 2:
					    Course[] allCourses = cl.getCourse();
					    if (allCourses.length == 0) {
					        System.out.println("📭 Danh sách trống.");
					    } else {
					        System.out.printf("%-10s %-20s %-15s %-6s\n", "Mã", "Tên khóa học", "Khoa", "Tín chỉ");
					        for (Course j : allCourses) {
					            if (j != null) {
					                System.out.printf("%-10s %-20s %-15s %-6d\n",
					                    j.getCourseId(), j.getTitle(), j.getDepartment(), j.getCredit());
					            }
					        }
					    }
					    break;
					case 3:
					    System.out.print("Nhập mã khóa học cần xóa: ");
					    String removeId = sc.nextLine().trim();
					    try {
					        if (cl.removeCourse(removeId)) {
					            System.out.println("✅ Đã xóa khóa học có mã: " + removeId);
					        } else {
					            System.out.println("⚠️ Không tìm thấy khóa học.");
					        }
					    } catch (Exception e) {
					        System.out.println("❌ Lỗi: " + e.getMessage());
					    }
					    break;
					case 4:
					    Course[] sorted = cl.sortCourse();
					    if (sorted.length == 0) {
					        System.out.println("📭 Không có khóa học để sắp xếp.");
					    } else {
					        System.out.println("📋 Danh sách sau khi sắp xếp:");
					        System.out.printf("%-10s %-20s %-15s %-6s\n", "Mã", "Tên khóa học", "Khoa", "Tín chỉ");
					        for (Course c : sorted) {
					            System.out.printf("%-10s %-20s %-15s %-6d\n",
					                c.getCourseId(), c.getTitle(), c.getDepartment(), c.getCredit());
					        }
					    }
					    break;
					case 5:
						System.out.print("Nhập tên khóa học cần tìm: ");
						String title = sc.nextLine();
						Course[] foundByTitle = cl.searchCourse(title);
						if (foundByTitle.length == 0) {
						    System.out.println("Không tìm thấy khóa học.");
						} else {
						    for (Course c : foundByTitle) {
						        System.out.printf("%-10s %-20s %-15s %-6d\n", c.getCourseId(), c.getTitle(), c.getDepartment(), c.getCredit());
						    }
						}
						break;
					case 6:
						System.out.print("Nhập tên khoa: ");
						String deptSearch = sc.nextLine();
						Course[] foundByDept = cl.searchCourseByDepartment(deptSearch);
						if (foundByDept.length == 0) {
						    System.out.println("Không có khóa học nào thuộc khoa này.");
						} else {
						    for (Course c : foundByDept) {
						        System.out.printf("%-10s %-20s %-15s %-6d\n", c.getCourseId(), c.getTitle(), c.getDepartment(), c.getCredit());
						    }
						}
						break;
					case 7:
						Course[] maxCreditCourses = cl.findMaxCreditCourse();
						System.out.println("Các khóa học có tín chỉ cao nhất:");
						for (Course c : maxCreditCourses) {
						    System.out.printf("%-10s %-20s %-15s %-6d\n", c.getCourseId(), c.getTitle(), c.getDepartment(), c.getCredit());
						}
						break;
					case 8:
						String topDept = cl.findDepartmentWithMostCourse();
						System.out.println("Khoa có nhiều khóa học nhất: " + topDept);
						break;
					case 9:
						System.out.print("Nhập mã khóa học: ");
						String idSearch = sc.nextLine();
						Course found = cl.SearchCourseById(idSearch);
						if (found == null) {
						    System.out.println("Không tìm thấy khóa học.");
						} else {
						    System.out.printf("%-10s %-20s %-15s %-6d\n", found.getCourseId(), found.getTitle(), found.getDepartment(), found.getCredit());
						}
						break;
						case 0: 
							System.out.println("Kết thúc chương trình."); 
							sc.close(); 
							return; 
						default: 
							System.out.println("Chọn sai, vui lòng thử lại."); 
						
				}
		}
	}
}

