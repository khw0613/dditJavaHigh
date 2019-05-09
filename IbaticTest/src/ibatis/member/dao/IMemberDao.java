package ibatis.member.dao;

import java.util.List;

import ibatis.member.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 service에 전달하는 DAO의 interface
 * @author macbook
 *
 */
public interface IMemberDao {
	/**
	 * MemverVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param mv DB에 insert할 자료가 저장된 MemberVO객
	 * @return DB작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환됨.
	 */
	public int insertMember(MemberVO mv);
	
	
	public int deleteMember(String memId);
	/**
	 * 하나의 MemberVO자료를 이용하여 DB에 update하는 메서드
	 * @param mv update할 회원 정보가 들어있 MemverVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateMember(MemberVO mv);
	/**
	 * DB의 mymember테이블의 전체 레코드를 가져와서 List에 담어서 반환하는 메서
	 * @return MemverVO객체를 담고 있는 List객
	 */
	public List<MemberVO> getAllMemberList();
	/**
	 *  주어진 ID가 존재하는지 여부를 알아내는 메서
	 * @param memId 검색할 회원 ID
	 * @return 해당 회원 ID가 있으면 true, 없으면 false
	 */
	public boolean getMember(String memId);


	List<MemberVO> getSearchMember(MemberVO mv);
}
