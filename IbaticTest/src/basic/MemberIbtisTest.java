package basic;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MemberIbtisTest {
   public static void main(String[] args) {
      //ibatis를 이용하여 DB자료를 처리하는 작업순서
      //1. ibatis의 환경설정 파일을 읽어와 실행시킨다.
      try {
         //1-1. xml문서 읽어오기
         Reader rd =Resources.getResourceAsReader("sqlMapConfig.xml");   //중요한 파일
         
         //1-2. 위에서 읽어온 Reader객체를 이용하여 실제작업을 진행할 객체 생성 
         SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
         rd.close(); //Reader객체 닫기
         
         //2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
         
         //2-1. insert작업연습
         System.out.println("insert 작업시작 ...");
         
         //1) 저장할 데이터를 VO에 담는다.
         MemberVO mv = new MemberVO();
         
         mv.setMem_id("d001");
         mv.setMem_name("김도현");
         mv.setMem_tel("1111-1111");
         mv.setMem_addr("대전시 대흥동");
         
         //2)SqlMapClient 객체 변수를 이용하여 해당 쿼리문을 실행한다.
         // 형식)smc.insert("namespace값.id값" , 파라미터 객체);
         //     반환값 : 성공하면 null이 반환된다.
         
         Object obj =smc.insert("memberTest.insertMember",mv);
         if(obj == null) {
            System.out.println("insert작업성공");
         }else {
            System.out.println("insert작업 실패!");
         }
         System.out.println("-------------------------------------------------");
         
         //2-2. update작업연습
         System.out.println("== update 작업시작 ==");
         
         MemberVO mv2 = new MemberVO();
         
         mv2.setMem_id("d001");
         mv2.setMem_name("이대용");
         mv2.setMem_tel("2222-2222");
         mv2.setMem_addr("대전시 은행동");
         
         //update()메서드의 반환값은 성공한 레코드 수이다.
         
         int cnt = smc.update("memberTest.updateMember", mv2);
         if(cnt > 0) {
            System.out.println("update작업성공");
         }else {
            System.out.println("update작업실패!");
         }
         System.out.println("-------------------------------------------------");
         
         // 2-3. delete연습
         System.out.println("== delete 작업 시작 ==");
         
         //delete메서드의 반환값 : 성공한 레코드의 수
         int cnt2 = smc.delete("memberTest.deleteMember", "d001");
         if(cnt2 > 0) {
            System.out.println("update작업성공");
         }else {
            System.out.println("update작업실패!");
         }
         System.out.println("-------------------------------------------------");
         
         //2-4. select연습
         // 1)응답결과가 여러개일 경우
         System.out.println("==select 연습시작(결과가 여러개일경우)==");
         List<MemberVO> memList;
          
         //응답결과가 여러개일 경우에는 queryForList메서드를 사용한다.
         // 이 메서드는 여러개의 레코드를 VO 에 담은후 이 VO데이터를 List에 추가해 주는 작업을 자동으로 수행한다
         memList = smc.queryForList("memberTest.getMemberAll");
         for(MemberVO memVO : memList) {
            System.out.println("ID : "+memVO.getMem_id());
            System.out.println("NAME : "+memVO.getMem_name());
            System.out.println("TEL : "+memVO.getMem_tel());
            System.out.println("ADDR"+memVO.getMem_addr());
         }
         
         System.out.println("출력끝");
        
         //2) 응답이 1개일 경우
         System.out.println( "select연습 시작 (결과가 1개일 경우)==");
         
         //응답결과가 1개가 확실한 경우에는 quertForObject메서드를 사용한다.
         MemberVO mv3 = (MemberVO) smc.queryForObject("memberTest.getMember","d001");
         System.out.println("ID : "+mv3.getMem_id());
         System.out.println("NAME : "+mv3.getMem_name());
         System.out.println("TEL : "+mv3.getMem_tel());
         System.out.println("ADDR"+mv3.getMem_addr());
         
      } catch (IOException e) {
         e.printStackTrace();
      }catch (SQLException e) {
         e.printStackTrace();
      }
      }
   }
