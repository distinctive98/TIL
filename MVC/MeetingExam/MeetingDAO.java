package model.dao;

import java.util.List;
import model.vo.MeetingVO;

public interface MeetingDAO {
	public List<MeetingVO> listAll();
	public boolean insert(MeetingVO vo);
	public boolean delete(int eNo);
}
