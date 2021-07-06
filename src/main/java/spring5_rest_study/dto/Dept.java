package spring5_rest_study.dto;

public class Dept {
	private int deptNo;
	private String deptName;
	private int floor;

	@Override
	public String toString() {
		return String.format("Dept [deptNo=%s, deptName=%s, floor=%s]", deptNo, deptName, floor);
	}

	public Dept() {
	}

	public Dept(int deptNo) {
		this.deptNo = deptNo;
	}

	public Dept(int deptNo, String deptName, int floor) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.floor = floor;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
}
