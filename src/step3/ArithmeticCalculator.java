package step3;


import java.util. ArrayList;

enum OperatorType {
    ADD, SUB, MUL, DIV
}

public class ArithmeticCalculator<T extends Number> {
    // 계산 결과들을 모아서 저장하는 리스트 (외부에서 직접 접근 불가)
    private final ArrayList<T> results = new ArrayList<>();


    // 두 숫자와 연산자를 받아서 계산하고 결과를 반환하는 메서드
    public T calculate(T num1, T num2, step3.OperatorType op) {
        double result = 0; // 계산 결과를 임시로 저장할 변수
        double n1 = num1.doubleValue();
        double n2 = num2.doubleValue();
        switch (op) {
            case ADD: // 덧셈 기호가 입력됐을 때
                result = n1 + n2;
                break;
            case SUB: // 뺄셈 기호가 입력됐을 때
                result = n1 - n2;
                break;
            case MUL: // 곱셈 기호가 입력됐을
                result = n1 * n2;
                break;
            case DIV: // 나눗셈 기호가 입력됐을 때
                if (n2 == 0) { // 0으로 나누면 오류가 나서 따로 처리하기
                    System.out.println("양의 정수를 입력해주세요!");
                } else {
                    result = n1 / n2;
                }
                break;
            default:   // +, -, *, / 이외의 기호가 입력됐을 때
                System.out.println("잘못된 연산자 입력입니다. 다시 입력해주세요!");
                break;

        }
        results.add((T)Double.valueOf(result));  // 계산 결과를 리스트에 저장
        return (T) Double.valueOf(result);       // 계산 결과를 반환
    }
    // results 리스트를 외부에서 가져올 수 있도록 하는 Getter 메서드
    public ArrayList<T> getResults() {
        return results;
    }

    // results 리스트에서 가장 먼저 저장된 값(인덱스 0)을 삭제하는 메서드
    public void removeResult() {
        results.removeFirst();
    }
}
