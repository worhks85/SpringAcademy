package examspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JavaConfig;

public class Main2 {
	public static void main(String[] args) {
		System.out.println("1. 컨테이너 준비");
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);
		System.out.println("5. 컨테이너 준비 완료");
		
		//컨테이너 사용
		Client client = ctx.getBean("client", Client.class);
		client.send();
		Client2 client2 = ctx.getBean("client2", Client2.class);
		client2.send();
		
		System.out.println("7. 컨테이너 종료 준비");
		ctx.close();
		System.out.println("9. 컨테이너 종료");
	}
}
