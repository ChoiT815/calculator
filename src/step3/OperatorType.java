package step3;

public enum OperatorType {
    ADD {
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    },
    SUB {
        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    },
    MUL {
        @Override
        public double apply(double a, double b) {
            return a * b;
        }

    },
    DIV {
        @Override
        public double apply(double a, double b) {
            if (b == 0) throw new ArithmeticException("0으로는 나눌 수 없습니다.");
            return a / b;
        }
    };

    public abstract double apply(double a, double b);

    //Number 타입을 직접 받아서 처리
    public double apply(Number a, Number b) {
        return apply(a.doubleValue(), b.doubleValue());
    }
}