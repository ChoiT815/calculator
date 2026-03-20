package step2;
import java.util. ArrayList;


public class Calculator {
    // 계산 결과들을 모아서 저장하는 리스트 (외부에서 직접 접근 불가)
    private ArrayList<Integer> results = new ArrayList<>();

    // 두 숫자와 연산자를 받아서 계산하고 결과를 반환하는 메서드
    public int calculate(int num1, int num2, char op) {
        int result = 0; // 계산 결과를 임시로 저장할 변수
        switch (op) {
            case '+': // 덧셈 기호가 입력됐을 때
                result = num1 + num2;
                break;
            case '-': // 뺄셈 기호가 입력됐을 때
                result = num1 - num2;
                break;
            case '*': // 곱셈 기호가 입력됐을
                result = num1 * num2;
                break;
            case '/': // 나눗셈 기호가 입력됐을 때
                if (num2 == 0) { // 0으로 나누면 오류가 나서 따로 처리하기
                    System.out.println("양의 정수를 입력해주세요!");
                } else {
                    result = num1 / num2;
                }
                break;
            default:   // +, -, *, / 이외의 기호가 입력됐을 때
                System.out.println("잘못된 연산자 입력입니다. 다시 입력해주세요!");
                break;

        }
        results.add(result);  // 계산 결과를 리스트에 저장
        return result;        // 계산 결과를 반환
    }
    // results 리스트를 외부에서 가져올 수 있도록 하는 Getter 메서드
    public ArrayList<Integer> getResults() {
        return results;
    }
    // results 리스트에서 가장 먼저 저장된 값(인덱스 0)을 삭제하는 메서
    public void removeResult() {
        results.remove(0);
    }
}
