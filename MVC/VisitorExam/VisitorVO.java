package model.vo;

//DB 테이블의 컬럼명과 맞춰주는 것이 좋음
public class VisitorVO {
	private String name;
	private String writeDate; //날짜는 String형이 여러모로 편함
	private String memo;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public String toString() {
		return "VisitorVO [name=" + name + ", writeDate=" + writeDate + ", memo=" + memo + "]";
	}
}
