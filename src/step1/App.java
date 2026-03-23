package step1;

import java.util.Scanner;

public class App {

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
        while (true) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            char opChar = ' ';  // 첫 번째 문자만 가져오기
            do {
                opChar = scanner.next().charAt(0);
                if (opChar != '+' && opChar != '-' && opChar != '*' && opChar != '/') {
                    System.out.println("잘못된 연산자입니다. 다시 입력해주세요!");
                    System.out.print("사칙연산 기호를 입력하세요: ");
                }
            } while (opChar != '+' && opChar != '-' && opChar != '*' && opChar != '/');
            int result = 0;

            switch (opChar) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("양의 정수를 입력해주세요!");
                    } else {
                        result = num1 / num2;

                    }
                    break;
            }
            System.out.println("결과: " + result);
            System.out.print("더 계산하시겠습니까? (종료:exit) : ");
            String answer = scanner.next();
            if (answer.equals("exit")) {
                break;
            }
        }

    }

}
