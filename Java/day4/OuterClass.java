public class OuterClass {
    String outerField = "외부 멤버 변수";
    static String staticOuterField = "외부 클래스 변수";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // System.out.println(outerField); // 컴파일 오류
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();  //outer클래스 객체 생성해야만!! inner클래스 객체를 생성할 수 있다.
        OuterClass.InnerClass innerObject = outerObject.new InnerClass(); //따라서 inner클래스는 outer 클래스 인스턴스 변수에 접근 가능
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        OuterClass.StaticNestedClass staticNestedObject = new OuterClass.StaticNestedClass(); //정적(static)중첩클래스는 outer클래스 객체 생성 안되고 생성할 수 있고 outer클래스 인스턴스 변수에는 접근 할 수 없다.
        staticNestedObject.accessMembers(outerObject);
    }
}
