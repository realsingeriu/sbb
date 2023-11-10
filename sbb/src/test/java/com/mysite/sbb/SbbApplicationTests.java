package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {

//	@Autowired
//	private QuestionRepository qRepo;
//	
//	@Autowired
//	private AnswerRepository aRepo;
	
	@Autowired
	private QuestionService qService;
	
	@Test
	void contextLoads() {
		/* 입력 테스트
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.qRepo.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.qRepo.save(q2);
			
		List<Question> all =this.qRepo.findAll();
		for(Question q : all) {
			System.out.println(q.getId());
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			System.out.println(q.getCreateDate());
		}		
					
		Optional<Question> oq = this.qRepo.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get(); //Question이 리턴
			System.out.println(q.getContent());
		}
		
		
		Question q = this.qRepo.findBySubject("sbb가 무엇인가요?");
		System.out.println(q.getContent());
		
		
		Question q = this.qRepo.findBySubjectAndContent("sbb가 무엇인가요?","sbb에 대해서 알고 싶습니다.");
		assertEquals(1, q.getId());
		
		
		Optional<Question> oq = this.qRepo.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get(); //Question이 리턴
			q.setSubject("수정된 제목");
			this.qRepo.save(q); //수정(업데이트됨)
			//save메소드 입력객체가 id가 없으면 입력 있으면 수정
		}
		*/
		
//		Optional<Question> oq = this.qRepo.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get(); //Question이 리턴
//			this.qRepo.delete(q); //삭제
//		}
//		this.qRepo.deleteById(1);
		
//		Optional<Question> oq = this.qRepo.findById(2);
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		
//		aRepo.save(a);
		
//		Optional<Answer> oa = aRepo.findById(1);
//		Answer a = oa.get();
//		List<Answer> list = a.getQuestion().getAnswerList();
		
		for(int i=1; i<=300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			qService.create(subject, content, null);
		}
	
	}

}
