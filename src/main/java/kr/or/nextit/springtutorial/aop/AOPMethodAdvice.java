package kr.or.nextit.springtutorial.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AOPMethodAdvice {
    //Adivce라는건 조언 , 충고임 @Aspect가 조언을 했다라는걸 선언하는것임
//    4가지 관점이 있음
//    @Before() : 메소드가 실행되기 전에 호출
//    @After() : 메소드가 호출되고 종료되는 시점에 호출
//    @AfterThrowing() : 메소드가 실행 중에 에러를 발생했을때 호출
//    @AfterReturning : 메소드가 실행되고 정상적으로 종료될때 호출
//    @Aound : 위의 4가지 설정을 모두 종합해서 사용가능

    @Before("execution(public void kr..aop.AOPMethod.*())")
//    패키지명을 kr.or.nextit.springtutorial.aop.AOPMethod.method1()) 위에처럼 줄여도 됨.
//    kr..은 kr로 시작하는 모든
//    즉 kr로 시작하는 aop안에있는 AOPMethod클래스 안에 있는모든 메소드가 실행되기전에 ~ 라는 뜻
//    그리고 Spring에 bean으로 등록해야됨
    public void preRevoke() {
        //AOPMethod가 호출되기 전마다 그 클래스가 호출되었다는걸 말해줄거임
//        실행되기 전이니까 Before을 호출할거임
//        ()안에 문자열이 호출되기 전에 실행해라. 타겟을 넣으면됨 어떤걸 호출하기 전에 하는거임? 이런느낌
//        지금은 AOPMethod안에있는 모든 메소드를 호출하기전에 넣을거니까 패턴형식으로 넣어줄거임
//        메소드는 접근제한자 + 리턴타입 +  메소드명 + 파라미터 이렇게 되어있는데 이걸 다쓰면됨
//        접근제한자는 생략가능 , 메소드명은 풀네임을 써야함.(어느패키지의 어느클래스의 메소드인지 적어야함 ㅈㄴ귀찮네 수발)
//        기존에 메소드 안에있는걸 바꾸지않아도 관점에 의해 호출내용을 더 추가할수있는 장점이 있음
        System.out.println("AOPMethod 클래스의 메소드가 호출됨");
    }

    //메소드 호출후 "AOPMethod 클래스의 메소드 실행 완료 " 뜨게하기

    @After("execution(public void kr..aop.AOPMethod.*())")
//    @After(myPointCut()) 이렇게 쓸수있음 중복코드 방지
    public void complete() {
        System.out.println("AOPMethod 클래스의 메소드 실행 완료");
    }

    //    pointCut 표현식
    @Pointcut("execution(public void kr..aop.AOPMethod.*())")
//    execution(void kr..*.*(..)) 이게 전부
    public void myPointCut() {
//        이걸 만들면 이제 @옆에 주소를 정의한 메소드로 호출하면됨.
    }

    @Around("myPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around를 통한 메소드 호출 전");

        Object proceed = null;
        try {
            proceed = joinPoint.proceed();// => 원래 호출하려고했던 메소드
        } catch (Throwable e) {
            System.out.println("Around를 통한 메소드 에러 발생시 호출");
        }
        System.out.println("Around를 통한 메소드 호출 함");
        return proceed;
    }
}
