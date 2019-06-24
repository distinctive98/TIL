package model.vo;

public class MeetingVO {
	int id;
	String name;
	String title;
	String meetingDate;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	
	@Override
	public String toString() {
		return "MeetingVO [id=" + id + ", name=" + name + ", title=" + title + ", meetingDate=" + meetingDate + "]";
	}
}
