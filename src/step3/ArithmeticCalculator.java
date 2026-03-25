package step3;


import java.util.ArrayList;
import java.util.List;

enum OperatorType {
    ADD{
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    }, SUB{
        @Override
        public double apply(double a, double b) { return a - b; }
    }, MUL{
        @Override
        public double apply(double a, double b) {
            return a * b;
        }
    }, DIV{
        @Override
        public double apply(double a, double b) {
            if(b == 0) throw new ArithmeticException("0으로는 나눌 수 없습니다.");
            return a / b;
        }
    };

    public abstract double apply(double a, double b);

    //Number 타입을 직접 받아서 처리
    public double apply(Number a, Number b) {
        return  apply(a.doubleValue(), b.doubleValue());
    }
}

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
                .toList();

    }

    public List<Double> getResult() {
        return List.copyOf(results);
    }
}
