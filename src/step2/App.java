package step2;

import java.util.Scanner;



public class App {
    static void main() {

        // Calculator 객체 생성 (계산 기능을 사용하기 위해)
        Calculator calculator = new Calculator();

        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // exit 입력 전까지 계속 반복
        while(true) {
            // 첫 번째 숫자 입력받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();

            // 두 번째 숫자 입력받기
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();

            // 사칙연산 기호 입력받기 (String으로 받은 후 char로 변환)
            System.out.print("사칙연산 기호를 입력하세요: ");
            String op = scanner.next();
            char opChar = op.charAt(0);  // 첫 번째 문자만 가져오기

            // Calculator 클래스의 calculate 메서드로 계산 후 결과 저장
            int result = calculator.calculate(num1, num2, opChar);

            // 계산 결과 출력
            System.out.println("결과: " + result);

            // 계속할지 종료할지 물어보기
            System.out.print("더 계산하시겠습니까? (종료:exit, 삭제:delete) : ");
            String answer = scanner.next();
            if (answer.equals("exit")) {
                break; // exit 입력 시 반복문 종료
            } else if (answer.equals("delete")) {
                calculator.removeResult();  // delete 입력 시 첫 번째 결과 삭제
            }
        }

    }
}
