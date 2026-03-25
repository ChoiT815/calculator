package step3;

import java.util.Scanner;



public class App {
    static void main(String[] args) {


        // Calculator 객체 생성 (계산 기능을 사용하기 위해)
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // exit 입력 전까지 계속 반복
        while(true) {
            // 첫 번째 숫자 입력받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            Double num1 = scanner.nextDouble();

            // 두 번째 숫자 입력받기
            System.out.print("두 번째 숫자를 입력하세요: ");
            Double num2 = scanner.nextDouble();

            char opChar = ' ';  // 첫 번째 문자만 가져오기
            do {
                System.out.print("사칙연산 기호를 입력하세요: ");
                opChar = scanner.next().charAt(0);

                if (opChar != '+' && opChar != '-' && opChar != '*' && opChar != '/') {
                    System.out.println("잘못된 연산자입니다. 다시 입력해주세요!");
                }
            } while (opChar != '+' && opChar != '-' && opChar != '*' && opChar != '/');

            OperatorType operatorType = switch (opChar) {
                case '+' -> OperatorType.ADD;
                case '-' -> OperatorType.SUB;
                case '*' -> OperatorType.MUL;
                case '/' -> OperatorType.DIV;
                default -> throw new IllegalArgumentException("잘못된 연산자");
            };

            try {
                // Calculator 클래스의 calculate 메서드로 계산 후 결과 저장
                Double result = calculator.calculate(num1, num2, operatorType);
                // 계산 결과 출력
                System.out.println("결과: " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
            }

            // 계속할지 종료할지 물어보기
            System.out.print("더 계산하시겠습니까? (종료:exit, 삭제:delete, 조회:search) : ");
            String answer = scanner.next().toLowerCase();

            if (answer.equals("exit")) {
                break; // exit 입력 시 프로그램 종료
            } else if (answer.equals("delete")) {
                calculator.removeFirstResult();  // delete 입력 시 첫 번째 결과 삭제
            } else if (answer.equals("search")) {
                System.out.print("기준값을 입력하세요: ");
                Double threshold = scanner.nextDouble();
                System.out.println("조회 결과:");
                calculator.searchResults(threshold);
            }
        }
        scanner.close();
    }


}


