package step3;


import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    // 계산 결과들을 모아서 저장하는 리스트 (외부에서 직접 접근 불가)
    private final List<Double> results = new ArrayList<>();


    // 두 숫자와 연산자를 받아서 계산하고 결과를 반환하는 메서드
    public <T extends Number> double calculate(T n1, T n2, OperatorType op) {
        double result = op.apply(n1,n2); // 계산 결과를 임시로 저장할 변수
        results.add(result);  // 계산 결과를 리스트에 저장
        return result;
    }

    // results 리스트에서 가장 먼저 저장된 값(인덱스 0)을 삭제하는 메서드
    public void removeFirstResult() {
        if(!results.isEmpty()) results.remove(0);

    }

    public void searchResults(Double threshold) {
        results.stream()
                .filter(n -> n > threshold)
                .forEach(System.out::println);

    }
}
